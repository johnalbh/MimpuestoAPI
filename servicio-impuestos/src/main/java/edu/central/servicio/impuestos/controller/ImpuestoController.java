package edu.central.servicio.impuestos.controller;

import edu.central.common_impuesto_bien.model.*;
import edu.central.servicio.impuestos.DTO.ImpuestoBienDTO;
import edu.central.servicio.impuestos.service.BienService;
import edu.central.servicio.impuestos.service.ImpuestoBienService;
import edu.central.servicio.impuestos.service.ImpuestoService;
import edu.ucentral.commonsservice.controller.CommonController;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/impuesto")
@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ImpuestoController extends CommonController<Impuesto, ImpuestoService> {

    @Autowired
    private ImpuestoService serviceImpuesto;

    @Autowired
    private BienService serviceBien;

    @Autowired
    private ImpuestoBienService serviceImpuestoBien;

    @PostMapping("/registrar")
    public ResponseEntity<?> crear(@RequestBody Impuesto entity) {
        Impuesto impuestoCreated = serviceImpuesto.save(entity);
        List<Bien> bienes = (List<Bien>) serviceBien.findAll();
        bienes.forEach(x -> {
            ImpuestoBien existeImpuesto = serviceImpuestoBien.FindImpuestoBien(x, impuestoCreated);
            double calculoValorTotalOrdinario = Math.round(((impuestoCreated.getBasePagoOrdinario() * x.getValorAvaluo())) * 100.0 / 100.0);
            double calculoValorTotalOrdinarioConPagoVoluntario = Math.round(((impuestoCreated.getBasePagoOrdinarioConPagoVoluntario() * x.getValorAvaluo())) * 100.0 / 100.0);
            double calculoValorTotalExtraOrdinario = Math.round(((impuestoCreated.getBasePagoExtraordinario() * x.getValorAvaluo())) * 100.0 / 100.0);
            double calculoValorTotalExtraOrdinarioConPagoVoluntario = Math.round(((impuestoCreated.getValorPagoMinimoExtraOrdinarioConPagoVoluntario() * x.getValorAvaluo())) * 100.0 / 100.0);

            double valorTotalOrdinario = calculoValorTotalOrdinario <= impuestoCreated.getValorPagoMinimoOrdinario() ? impuestoCreated.getValorPagoMinimoOrdinario() : calculoValorTotalOrdinario;
            double valorTotalOrdinarioConPagoVoluntario = calculoValorTotalOrdinarioConPagoVoluntario <= impuestoCreated.getValorPagoMinimoConPagoVoluntario() ? impuestoCreated.getValorPagoMinimoOrdinario() : calculoValorTotalOrdinarioConPagoVoluntario;
            double valorTotalExtraOrdinario = calculoValorTotalExtraOrdinario <= impuestoCreated.getValorPagoMinimoExtraOrdinario() ? impuestoCreated.getValorPagoMinimoExtraOrdinario() : calculoValorTotalExtraOrdinario;
            double valorTotalExtraOrdinarioConPagoVoluntario = calculoValorTotalExtraOrdinarioConPagoVoluntario <= impuestoCreated.getBasePagoExtraOrdinarioConPagoVoluntario() ? impuestoCreated.getValorPagoMinimoOrdinario() : calculoValorTotalExtraOrdinarioConPagoVoluntario;

            if (existeImpuesto == null) {

                if (x.getTipoBien().getId() == impuestoCreated.getTipoBien().getId()) {
                    serviceImpuestoBien.save(new ImpuestoBien(impuestoCreated, x, false, valorTotalOrdinario, valorTotalOrdinarioConPagoVoluntario, valorTotalExtraOrdinario, valorTotalExtraOrdinarioConPagoVoluntario));
                }
            } else {
                new ResponseMessage(String.format("Ya existe un vehículo registrado con la placa %s"));
            }
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(impuestoCreated);
    }

    @GetMapping("/listarImpuestosContribuyenbte/{numeroIdentificacion}")
    public ResponseEntity<?> listarImpuestosContribuyente(@PathVariable String numeroIdentificacion) {

        ModelMapper modelMapper = new ModelMapper();
        List<ImpuestoBienDTO> impuestoBienDTO = serviceImpuestoBien.ListarImpuestoContribuyente(numeroIdentificacion)
                .stream().map(impuesto -> modelMapper.map(impuesto, ImpuestoBienDTO.class)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(impuestoBienDTO);
    }

    @GetMapping("/listarImpuestosBien/{idBien}")
    public ResponseEntity<?> listarImpuestosBien(@PathVariable String idBien) {

        ModelMapper modelMapper = new ModelMapper();
        List<ImpuestoBienDTO> impuestoBienDTO = serviceImpuestoBien.ListarImpuestoBien(Long.parseLong(idBien))
                .stream().map(impuesto -> modelMapper.map(impuesto, ImpuestoBienDTO.class)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(impuestoBienDTO);
    }

    private ImpuestoBienDTO convertImpuestoToImpuestoDTO(ImpuestoBien user) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<ImpuestoBien, ImpuestoBienDTO> typeMap = modelMapper.createTypeMap(ImpuestoBien.class, ImpuestoBienDTO.class).implicitMappings()
                .addMappings(mapper -> {
                    mapper.map(src -> src.getBien().getTipoBien().getNombre(), ImpuestoBienDTO::setNombreTipoBien);
                    mapper.map(src -> src.getBien().getTipoBien().getIcono(), ImpuestoBienDTO::setIconoTipoBien);
                });
        return typeMap.map(user);
    }

    @PostMapping("/asignarImpuestoBienes")
    public ResponseEntity<?> asignarImpuestoBienes(@RequestBody Impuesto entity) {
        Integer idTipoBien = entity.getTipoBien().getId();
        Long idImpuesto = entity.getId();
        if (validarImpuestoAsignado(idImpuesto)) {
            List<Bien> bienes = (List<Bien>) serviceBien.findAll();
            bienes.forEach(bien -> {
                if (Objects.equals(bien.getTipoBien().getId(), idTipoBien)) {
                    ImpuestoBien impuestoBien = new ImpuestoBien();
                    impuestoBien.setPagado(false);
                    impuestoBien.setValorTotalOrdinario(calcularValorPagoMinimoOrdinario(bien, entity));
                    impuestoBien.setValorTotalConPagoVoluntario(calcularValorPagoMinimoConPagoVoluntario(bien, entity));
                    impuestoBien.setValorTotalExtraOrdinario(calcularValorPagoMinimoExtraOrdinario(bien, entity));
                    impuestoBien.setValorTotalExtraOrdinarioConPagoVoluntario(calcularValorPagoMinimoExtraOrdinarioConPagoVoluntario(bien, entity));
                    impuestoBien.setBien(bien);
                    impuestoBien.setImpuesto(entity);
                    serviceImpuestoBien.save(impuestoBien);
                }
            });
            return ResponseEntity.status(HttpStatus.CREATED).body("");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    private boolean validarImpuestoAsignado(Long idImpuesto) {
        List<ImpuestoBien> impuestoBienList = (List<ImpuestoBien>) serviceImpuestoBien.findAll();
        AtomicBoolean validacion = new AtomicBoolean(true);
        impuestoBienList.forEach(impuesto -> {
            if (impuesto.getImpuesto().getId() == idImpuesto) {
                validacion.set(false);
            }
        });
        return validacion.get();
    }

    private double calcularValorPagoMinimoOrdinario(Bien bien, Impuesto entity) {
        double avaluo = (bien.getValorAvaluo() * entity.getBasePagoOrdinario()) / 100;
        double pagoMinimo = entity.getValorPagoMinimoOrdinario();
        return Math.max(avaluo, pagoMinimo);
    }

    private double calcularValorPagoMinimoConPagoVoluntario(Bien bien, Impuesto entity) {
        double avaluo = (bien.getValorAvaluo() * entity.getBasePagoOrdinarioConPagoVoluntario()) / 100;
        double pagoMinimo = entity.getValorPagoMinimoConPagoVoluntario();
        return Math.max(avaluo, pagoMinimo);
    }

    private double calcularValorPagoMinimoExtraOrdinario(Bien bien, Impuesto entity) {
        double avaluo = (bien.getValorAvaluo() * entity.getBasePagoExtraordinario()) / 100;
        double pagoMinimo = entity.getValorPagoMinimoExtraOrdinario();
        return Math.max(avaluo, pagoMinimo);
    }

    private double calcularValorPagoMinimoExtraOrdinarioConPagoVoluntario(Bien bien, Impuesto entity) {
        double avaluo = (bien.getValorAvaluo() * entity.getBasePagoExtraOrdinarioConPagoVoluntario()) / 100;
        double pagoMinimo = entity.getValorPagoMinimoExtraOrdinarioConPagoVoluntario();
        return Math.max(avaluo, pagoMinimo);
    }
}
