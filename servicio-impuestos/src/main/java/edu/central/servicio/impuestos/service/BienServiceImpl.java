package edu.central.servicio.impuestos.service;

import edu.central.servicio.impuestos.model.Bien;
import edu.central.servicio.impuestos.repository.BienRepository;
import edu.ucentral.commonsservice.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BienServiceImpl extends CommonServiceImpl<Bien, BienRepository> implements BienService{

}
