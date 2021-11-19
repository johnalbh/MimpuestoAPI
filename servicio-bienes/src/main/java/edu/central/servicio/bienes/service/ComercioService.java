package edu.central.servicio.bienes.service;

import edu.central.common_impuesto_bien.model.Comercio;

import java.util.List;

public interface ComercioService  {

    List<Comercio> getAllComercios();

    List<Comercio>  getAllComerciosByContribuyente(String numeroIdentificacion);

    Comercio getComercioById(long nit);

    Comercio crearComercio(Comercio comercio);

    Comercio actualizarComercio(Comercio comercio);

    void DeleteComercio(long nit);
}
