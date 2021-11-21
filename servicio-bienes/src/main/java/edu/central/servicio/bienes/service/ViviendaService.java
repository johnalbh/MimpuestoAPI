package edu.central.servicio.bienes.service;

import edu.central.servicio.bienes.model.Vivienda;

import java.util.List;

public interface ViviendaService {

    List<Vivienda> getAllViviendas();

    List<Vivienda>  getAllViviendasByContribuyente(String numeroIdentificacion);

    Vivienda getViviendaById(String cedulaCatrastal);

    Vivienda crearVivienda(Vivienda vivienda);

    Vivienda actualizarVivienda(Vivienda vivienda);

    void DeleteVivienda(String cedulaCatrastal);
}
