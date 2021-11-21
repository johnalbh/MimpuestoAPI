package edu.central.servicio.bienes.controller;

import edu.central.servicio.bienes.model.ResponseMessage;
import edu.central.servicio.bienes.model.Vehiculo;
import edu.central.servicio.bienes.DTO.VehiculoContribuyenteDTO;
import edu.central.servicio.bienes.DTO.VehiculoDTO;
import edu.central.servicio.bienes.service.VehiculoService;
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
@RequestMapping("/vehiculo")
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS, RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VehiculoController {

    @Autowired
    private VehiculoService serviceVehiculo;

    @GetMapping("/listar")
    public ResponseEntity<List<VehiculoDTO>> getAllVehiculos() {
        List<VehiculoDTO> vehiculosDTO = serviceVehiculo.getAllVehiculos().stream().map(this::converVehiculotoVehiculoDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(vehiculosDTO);
    }

    @GetMapping("/contribuyente/{numeroIdentificacion}")
    public ResponseEntity<List<VehiculoContribuyenteDTO>> getAllVehiculosByContribuyente(@PathVariable String numeroIdentificacion) {

        ModelMapper modelMapper = new ModelMapper();
        List<VehiculoContribuyenteDTO> vehiculosContribuyenteDTO = serviceVehiculo.getAllVehiculosByContribuyente(numeroIdentificacion)
                .stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoContribuyenteDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(vehiculosContribuyenteDTO);
    }

    @GetMapping("/detalle/{placa}")
    public ResponseEntity<Vehiculo> getVehiculoByPlaca(@PathVariable String placa) {
        Vehiculo vehiculo = serviceVehiculo.getVehiculoById(placa);
        return ResponseEntity.ok().body(vehiculo);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo existeVehiculo = this.serviceVehiculo.getVehiculoById(vehiculo.getPlaca());
        if (existeVehiculo.getPlaca() == null) {
            Vehiculo creado = this.serviceVehiculo.crearVehiculo(vehiculo);
            return ResponseEntity.ok().body(creado);
        } else {
            return ResponseEntity.ok().body(new ResponseMessage(String.format("Ya existe un vehículo registrado con la placa %s", existeVehiculo.getPlaca())));
        }
    }

    @PutMapping("/editar/{placa}")
    public ResponseEntity<?> modificar(@RequestBody Vehiculo vehiculo, @PathVariable String placa, BindingResult result) {
        if (result.hasErrors()) {
            return validar(result);
        }
        Optional<Vehiculo> optional = Optional.ofNullable(this.serviceVehiculo.getVehiculoById(placa));
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Vehiculo updatedVehiculo = optional.get();
        updatedVehiculo.setLinea(vehiculo.getLinea());
        updatedVehiculo.setCapacidad(vehiculo.getCapacidad());
        updatedVehiculo.setLinea(vehiculo.getLinea());
        updatedVehiculo.setModelo(vehiculo.getModelo());
        updatedVehiculo.setUso(vehiculo.getUso());
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceVehiculo.actualizarVehiculo(updatedVehiculo));
    }

    @DeleteMapping("/eliminar/{placa}")
    public HttpStatus eliminarContribuyente(@PathVariable String placa) {
        this.serviceVehiculo.DeleteVehiculo(placa);
        return HttpStatus.OK;
    }

    private VehiculoDTO converVehiculotoVehiculoDTO(Vehiculo user) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Vehiculo, VehiculoDTO> typeMap = modelMapper.createTypeMap(Vehiculo.class, VehiculoDTO.class).implicitMappings()
                .addMappings(mapper -> {
                    mapper.map(src -> src.getBien().getContribuyente(),
                            VehiculoDTO::setContribuyente);
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
