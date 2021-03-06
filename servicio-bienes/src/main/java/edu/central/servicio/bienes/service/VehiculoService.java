package edu.central.servicio.bienes.service;

import edu.central.servicio.bienes.model.Vehiculo;

import java.util.List;

public interface VehiculoService {

    List<Vehiculo> getAllVehiculos();

    List<Vehiculo>  getAllVehiculosByContribuyente(String numeroIdentificacio);

    Vehiculo getVehiculoById(String placa);

    Vehiculo crearVehiculo(Vehiculo vehiculo);

    Vehiculo actualizarVehiculo(Vehiculo vehiculo);

    void DeleteVehiculo(String placa);
}
