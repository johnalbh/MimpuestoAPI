package edu.central.servicio.bienes.service;

import edu.central.servicio.bienes.model.Vivienda;
import edu.central.servicio.bienes.exception.NotFoundException;
import edu.central.servicio.bienes.repository.ViviendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViviendaServiceImpl implements ViviendaService {

    @Autowired
    private ViviendaRepository viviendaRepository;

    @Override
    public List<Vivienda> getAllViviendas() {
        return viviendaRepository.findAll();
    }

    @Override
    public List<Vivienda> getAllViviendasByContribuyente(String numeroIdentificacion) {
        return this.viviendaRepository.getAllViviendaContribuyente(numeroIdentificacion);
    }

    @Override
    public Vivienda getViviendaById(String cedulaCatrastal) {
        Optional<Vivienda> viviendaDB = this.viviendaRepository.findById(cedulaCatrastal);
        if (viviendaDB.isPresent()) {
            return viviendaDB.get();
        } else {
            return null;
        }
    }

    @Override
    public Vivienda crearVivienda(Vivienda vivienda) {
        return this.viviendaRepository.save(vivienda);
    }

    @Override
    public Vivienda actualizarVivienda(Vivienda vivienda) {
        Optional<Vivienda> viviendaDB = this.viviendaRepository.findById(vivienda.getCedulaCatrastal());
        if (viviendaDB.isPresent()) {
            return this.viviendaRepository.save(vivienda);
        } else {
            throw new NotFoundException("No existe la vivienda con la cédula catrastal Número: " + vivienda.getCedulaCatrastal());
        }
    }

    @Override
    public void DeleteVivienda(String cedulaCatrastal) {
        Optional<Vivienda> viviendaDB = this.viviendaRepository.findById(cedulaCatrastal);
        if (viviendaDB.isPresent()) {
            this.viviendaRepository.delete(viviendaDB.get());
        } else {
            throw new NotFoundException("No existe la vivienda con la cédula catrastal Número: " + cedulaCatrastal);
        }
    }
}
