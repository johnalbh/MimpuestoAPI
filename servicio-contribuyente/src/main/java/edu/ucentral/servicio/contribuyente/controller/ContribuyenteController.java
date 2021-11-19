package edu.ucentral.servicio.contribuyente.controller;

import edu.central.common_impuesto_bien.model.Contribuyente;
import edu.ucentral.servicio.contribuyente.service.ContribuyenteService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/contribuyente")
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS, RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContribuyenteController {

    @Autowired
    public ContribuyenteService contribuyenteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Contribuyente>> getAllContribuyentes() {
        return ResponseEntity.ok().body(contribuyenteService.getAllContribuyentes());
    }

    @GetMapping("/detalle/{numeroIdentificacion}")
    public ResponseEntity<Contribuyente> getContribuyentesById(@PathVariable String numeroIdentificacion) throws NotFoundException {
        return ResponseEntity.ok().body(contribuyenteService.getContribuyenteById(numeroIdentificacion));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Contribuyente> crearContribuyente(@RequestBody Contribuyente contribuyente) {
        return ResponseEntity.ok().body(this.contribuyenteService.crearContribuyente(contribuyente));
    }

    @PutMapping("/editar/{numeroIdentificacion}")
    public ResponseEntity<?> editarContribuyente(@RequestBody Contribuyente contribuyente, @PathVariable String numeroIdentificacion, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }
        Optional<Contribuyente> optional = Optional.ofNullable(this.contribuyenteService.getContribuyenteById(numeroIdentificacion));
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Contribuyente updateContribuyente = optional.get();
        updateContribuyente.setCorreoElectronico(contribuyente.getCorreoElectronico());
        updateContribuyente.setDireccionNotificacion(contribuyente.getDireccionNotificacion());
        updateContribuyente.setTelefonoPrincipal(contribuyente.getTelefonoPrincipal());
        updateContribuyente.setPrimerNombre(contribuyente.getPrimerNombre());
        updateContribuyente.setSegundoNombre(contribuyente.getSegundoNombre());
        updateContribuyente.setPrimerApellido(contribuyente.getPrimerApellido());
        updateContribuyente.setSegundoApellido(contribuyente.getSegundoApellido());

        return ResponseEntity.status(HttpStatus.CREATED).body(contribuyenteService.actualizarContribuyente(updateContribuyente));
    }

    @DeleteMapping("eliminar/{numeroIdentificacion}")
    public HttpStatus eliminarContribuyente(@PathVariable String numeroIdentificacion) {
        this.contribuyenteService.DeleteContribuyente(numeroIdentificacion);
        return HttpStatus.OK;
    }

    protected ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
