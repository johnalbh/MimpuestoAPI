package edu.central.servicio.bienes.service;

import edu.central.servicio.bienes.model.Comercio;
import edu.central.servicio.bienes.exception.NotFoundException;
import edu.central.servicio.bienes.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercioServiceImpl implements ComercioService {

    @Autowired
    private ComercioRepository comercioRepository;

    @Override
    public List<Comercio> getAllComercios() {
        return this.comercioRepository.findAll();
    }

    @Override
    public List<Comercio> getAllComerciosByContribuyente(String numeroIdentificacion) {
        return this.comercioRepository.getAllComercioContribuyente(numeroIdentificacion);
    }

    @Override
    public Comercio getComercioById(long nit) {
        Optional<Comercio> comercioDB = this.comercioRepository.findById(nit);
        if (comercioDB.isPresent()) {
            return comercioDB.get();
        } else {
            return null;
        }
    }

    @Override
    public Comercio crearComercio(Comercio comercio) {
        return this.comercioRepository.save(comercio);
    }

    @Override
    public Comercio actualizarComercio(Comercio comercio) {
        Optional<Comercio> comercioDB = this.comercioRepository.findById(comercio.getNit());
        if (comercioDB.isPresent()) {
            return this.comercioRepository.save(comercio);
        } else {
            throw new NotFoundException("No existe la vivienda con la cédula catrastal Número: " + comercio.getNit());
        }
    }

    @Override
    public void DeleteComercio(long nit) {
        Optional<Comercio> comercioDB = this.comercioRepository.findById(nit);
        if (comercioDB.isPresent()) {
            this.comercioRepository.delete(comercioDB.get());
        } else {
            throw new NotFoundException("No existe la vivienda con la cédula catrastal Número: " + nit);
        }
    }
}
