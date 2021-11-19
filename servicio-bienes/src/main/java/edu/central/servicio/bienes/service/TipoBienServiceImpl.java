package edu.central.servicio.bienes.service;

import edu.central.common_impuesto_bien.model.TipoBien;
import edu.central.servicio.bienes.repository.TipoBienRepository;
import edu.ucentral.commonsservice.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TipoBienServiceImpl extends CommonServiceImpl<TipoBien, TipoBienRepository> implements TipoBienService{
}
