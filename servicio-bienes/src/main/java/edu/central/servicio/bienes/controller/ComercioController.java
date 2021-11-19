package edu.central.servicio.bienes.controller;

import edu.central.common_impuesto_bien.model.Comercio;
import edu.central.common_impuesto_bien.model.ResponseMessage;
import edu.central.servicio.bienes.DTO.ComercioContribuyenteDTO;
import edu.central.servicio.bienes.DTO.ComercioDTO;
import edu.central.servicio.bienes.service.ComercioService;
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
@RequestMapping("/comercio")
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS, RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ComercioController {

    @Autowired
    private ComercioService comercioService;

    @GetMapping("/listar")
    public ResponseEntity<List<ComercioDTO>> getAllComercios() {
        List<ComercioDTO> comercioDTO = comercioService.getAllComercios().stream().map(this::convertComercioToComercioDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(comercioDTO);
    }

    @GetMapping("/contribuyente/{numeroIdentificacion}")
    public ResponseEntity<List<ComercioContribuyenteDTO>> getAllComerciosByContribuyente(@PathVariable String numeroIdentificacion) {
        ModelMapper modelMapper = new ModelMapper();
        List<ComercioContribuyenteDTO> comercioContribuyenteDTO = comercioService.getAllComerciosByContribuyente(numeroIdentificacion)
                .stream().map(comercio -> modelMapper.map(comercio, ComercioContribuyenteDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(comercioContribuyenteDTO);
    }

    @GetMapping("/detalle/{nit}")
    public ResponseEntity<Comercio> getVehiculoByPlaca(@PathVariable long nit) {
        Comercio comercio = comercioService.getComercioById(nit);
        return ResponseEntity.ok().body(comercio);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVehiculo(@RequestBody Comercio comercio) {
        Comercio existeComercio = this.comercioService.getComercioById(comercio.getNit());
        if (existeComercio == null) {
            Comercio creado = this.comercioService.crearComercio(comercio);
            return ResponseEntity.ok().body(creado);
        } else {
            return ResponseEntity.ok().body(new ResponseMessage(String.format("Ya existe un vehículo registrado con la placa %s", existeComercio.getNit())));
        }
    }

    @PutMapping("/editar/{nit}")
    public ResponseEntity<?> modificar(@RequestBody Comercio comercio, @PathVariable Long nit, BindingResult result) {
        if (result.hasErrors()) {
            return validar(result);
        }
        Optional<Comercio> optional = Optional.ofNullable(this.comercioService.getComercioById(nit));
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Comercio updatedComercio = optional.get();
        updatedComercio.setBaseGravableActividad(comercio.getBaseGravableActividad());
        updatedComercio.setCodigoActividad(comercio.getCodigoActividad());
        updatedComercio.setNombreEstablecimientoComercial(comercio.getNombreEstablecimientoComercial());
        return ResponseEntity.status(HttpStatus.CREATED).body(comercioService.actualizarComercio(updatedComercio));
    }

    @DeleteMapping("/eliminar/{nit}")
    public HttpStatus eliminarContribuyente(@PathVariable Long nit) {
        this.comercioService.DeleteComercio(nit);
        return HttpStatus.OK;
    }

    private ComercioDTO convertComercioToComercioDTO(Comercio user) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Comercio, ComercioDTO> typeMap = modelMapper.createTypeMap(Comercio.class, ComercioDTO.class).implicitMappings()
                .addMappings(mapper -> {
                    mapper.map(src -> src.getBien().getContribuyente(),
                            ComercioDTO::setContribuyente);
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
