package edu.central.servicio.impuestos.controller;

import edu.central.servicio.impuestos.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonController<E,S extends CommonService<E>> {
    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<E> optional = service.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody E entity) {
        E entityBD = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
    }

    @PutMapping
    public ResponseEntity<?> acyualizar(@RequestBody E entity) {
        E entityBD = service.update(entity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(entityBD);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    protected ResponseEntity<?> validar(BindingResult result){
        Map<String,Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errores.put(err.getField(), "El atributo " + err.getField()+ " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
