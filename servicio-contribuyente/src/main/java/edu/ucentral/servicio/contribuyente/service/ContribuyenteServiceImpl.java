package edu.ucentral.servicio.contribuyente.service;

import edu.ucentral.servicio.contribuyente.model.Contribuyente;
import edu.ucentral.servicio.contribuyente.model.ResponseMessage;
import edu.ucentral.servicio.contribuyente.exception.NotFoundException;
import edu.ucentral.servicio.contribuyente.repository.ContribuyenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

    @Autowired
    private ContribuyenteRepository contribuyenteRepository;

    @Override
    public List<Contribuyente> getAllContribuyentes() {
        return this.contribuyenteRepository.findAll();
    }

    @Override
    public Contribuyente getContribuyenteById(String numeroIdentificacion) {
        Optional<Contribuyente> contribuyenteDb = this.contribuyenteRepository.findById(numeroIdentificacion);
        if (contribuyenteDb.isPresent()) {
            return contribuyenteDb.get();
        } else {
            return null;
        }
    }

    @Override
    public Contribuyente crearContribuyente(Contribuyente contribuyente) {
        return contribuyenteRepository.save(contribuyente);
    }

    @Override
    public Contribuyente actualizarContribuyente(Contribuyente contribuyente) {
        Optional<Contribuyente> contribuyenteDb = this.contribuyenteRepository.findById(contribuyente.getNumeroIdentificacion());
        if (contribuyenteDb.isPresent()) {
            return contribuyenteRepository.save(contribuyente);
        } else {
            throw new NotFoundException("No existe el contribuyente con el: " + contribuyente.getNumeroIdentificacion());
        }
    }

    @Override
    public void DeleteContribuyente(String numeroIdentificacion) {
        Optional<Contribuyente> contribuyenteDb = this.contribuyenteRepository.findById(numeroIdentificacion);
        if (contribuyenteDb.isPresent()) {
            this.contribuyenteRepository.delete(contribuyenteDb.get());
        } else {
            throw new NotFoundException("No existe el contribuyente con el: " + numeroIdentificacion);
        }
    }
}
