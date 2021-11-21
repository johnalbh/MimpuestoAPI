package edu.central.servicio.bienes.service;

import edu.central.servicio.bienes.model.Comercio;

import java.util.List;

public interface ComercioService  {

    List<Comercio> getAllComercios();

    List<Comercio>  getAllComerciosByContribuyente(String numeroIdentificacion);

    Comercio getComercioById(long nit);

    Comercio crearComercio(Comercio comercio);

    Comercio actualizarComercio(Comercio comercio);

    void DeleteComercio(long nit);
}
