package edu.central.servicio.bienes.controller;

import edu.central.servicio.bienes.model.TipoBien;
import edu.central.servicio.bienes.service.TipoBienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bien")
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS, RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BienController {

    @Autowired
    private TipoBienService servicetipoBien;

    @GetMapping("/tiposBien")
    public ResponseEntity<List<TipoBien>> getAllTipoBien() {
        List<TipoBien> tiposBien = (List<TipoBien>) servicetipoBien.findAll();
        return ResponseEntity.ok().body(tiposBien);
    }


}
