package edu.central.servicio.bienes.service;

import edu.central.common_impuesto_bien.model.Vehiculo;
import edu.central.servicio.bienes.exception.NotFoundException;
import edu.central.servicio.bienes.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> getAllVehiculos() {
        return this.vehiculoRepository.findAll();
    }

    @Override
    public List<Vehiculo> getAllVehiculosByContribuyente(String numeroIdentificacion) {
        return this.vehiculoRepository.getAllVehiculoContribuyente(numeroIdentificacion);
    }

    @Override
    public Vehiculo getVehiculoById(String placa) {
        Optional<Vehiculo> vahiculoDB = this.vehiculoRepository.findById(placa);
        if (vahiculoDB.isPresent()) {
            return vahiculoDB.get();
        } else {
            return new Vehiculo();
        }
    }

    @Override
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
        Optional<Vehiculo> vahiculoDB = this.vehiculoRepository.findById(vehiculo.getPlaca());
        if (vahiculoDB.isPresent()) {
            return vehiculoRepository.save(vehiculo);
        } else {
            return new Vehiculo();
        }
    }

    @Override
    public void DeleteVehiculo(String placa) {
        Optional<Vehiculo> vehiculoDB = this.vehiculoRepository.findById(placa);
        if (vehiculoDB.isPresent()) {
            this.vehiculoRepository.delete(vehiculoDB.get());
        } else {
            throw new NotFoundException("No existe el contribuyente con el: " + placa);
        }
    }
}


