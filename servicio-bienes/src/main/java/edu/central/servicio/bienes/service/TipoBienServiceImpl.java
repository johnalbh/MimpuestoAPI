package edu.central.servicio.bienes.service;

import edu.central.servicio.bienes.model.TipoBien;
import edu.central.servicio.bienes.repository.TipoBienRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoBienServiceImpl extends CommonServiceImpl<TipoBien, TipoBienRepository> implements TipoBienService{
}
