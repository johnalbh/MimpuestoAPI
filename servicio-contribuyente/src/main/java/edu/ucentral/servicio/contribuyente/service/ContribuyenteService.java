package edu.ucentral.servicio.contribuyente.service;

import edu.central.common_impuesto_bien.model.Contribuyente;

import java.util.List;

public interface ContribuyenteService {

    List<Contribuyente> getAllContribuyentes();

    Contribuyente getContribuyenteById(String numeroIdentificacion);

    Contribuyente crearContribuyente(Contribuyente contribuyente);

    Contribuyente actualizarContribuyente(Contribuyente contribuyente);

    void DeleteContribuyente(String numeroIdentificacion);
}
