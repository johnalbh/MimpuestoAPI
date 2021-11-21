package edu.central.servicio.bienes.controller;

import edu.central.servicio.bienes.model.ResponseMessage;
import edu.central.servicio.bienes.model.Vivienda;
import edu.central.servicio.bienes.DTO.ViviendaContribuyenteDTO;
import edu.central.servicio.bienes.DTO.ViviendaDTO;
import edu.central.servicio.bienes.service.ViviendaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vivienda")
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS, RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ViviendaController {

    @Autowired
    private ViviendaService serviceVivienda;

    @GetMapping("/listar")
    public ResponseEntity<List<ViviendaDTO>> getAllViviendas() {
        List<ViviendaDTO> viviendaDTO = serviceVivienda.getAllViviendas().stream().map(this::converViviendaToViviendaDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(viviendaDTO);
    }

    @GetMapping("/contribuyente/{numeroIdentificacion}")
    public ResponseEntity<List<ViviendaContribuyenteDTO>> getAllViviendasByContribuyente(@PathVariable String numeroIdentificacion) {

        ModelMapper modelMapper = new ModelMapper();
        List<ViviendaContribuyenteDTO> viviendaContribuyenteDTO = serviceVivienda.getAllViviendasByContribuyente(numeroIdentificacion)
                .stream().map(vivienda -> modelMapper.map(vivienda, ViviendaContribuyenteDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(viviendaContribuyenteDTO);
    }

    @GetMapping("/detalle/{cedulaCatastral}")
    public ResponseEntity<Vivienda> getVehiculoByPlaca(@PathVariable String cedulaCatastral) {
        Vivienda vivienda = serviceVivienda.getViviendaById(cedulaCatastral);
        return ResponseEntity.ok().body(vivienda);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVivienda(@RequestBody Vivienda vivienda) {
        Vivienda existeVivienda = this.serviceVivienda.getViviendaById(vivienda.getCedulaCatrastal());
        if (existeVivienda == null) {
            Vivienda creado = this.serviceVivienda.crearVivienda(vivienda);
            return ResponseEntity.ok().body(creado);
        } else {
            return ResponseEntity.ok().body(new ResponseMessage(String.format("Ya existe una vivienda registrado con la placa %s", existeVivienda.getCedulaCatrastal())));
        }
    }

    @PutMapping("/editar/{cedulaCatastral}")
    public ResponseEntity<?> modificar(@RequestBody Vivienda vivienda, @PathVariable String cedulaCatastral, BindingResult result) {
        if (result.hasErrors()) {
            return validar(result);
        }
        Optional<Vivienda> optional = Optional.ofNullable(this.serviceVivienda.getViviendaById(cedulaCatastral));
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Vivienda updateVivienda = optional.get();
        updateVivienda.setConstruccion(vivienda.getConstruccion());
        updateVivienda.setEstrato(vivienda.getEstrato());
        updateVivienda.setTerreno(vivienda.getTerreno());
        updateVivienda.setDireccionPredio(vivienda.getDireccionPredio());
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceVivienda.actualizarVivienda(updateVivienda));
    }

    @DeleteMapping("/eliminar/{cedulaCatastral}")
    public HttpStatus eliminarVivienda(@PathVariable String cedulaCatastral) {
        this.serviceVivienda.DeleteVivienda(cedulaCatastral);
        return HttpStatus.OK;
    }

    private ViviendaDTO converViviendaToViviendaDTO(Vivienda user) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Vivienda, ViviendaDTO> typeMap = modelMapper.createTypeMap(Vivienda.class, ViviendaDTO.class).implicitMappings()
                .addMappings(mapper -> {
                    mapper.map(src -> src.getBien().getContribuyente(),
                            ViviendaDTO::setContribuyente);
                });
        return typeMap.map(user);
    }

    protected ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
