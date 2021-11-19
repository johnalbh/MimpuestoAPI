package edu.central.servicio.impuestos.service;

import edu.central.common_impuesto_bien.model.Impuesto;
import edu.central.servicio.impuestos.repository.ImpuestoRepository;
import edu.ucentral.commonsservice.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ImpuestoServiceImpl extends CommonServiceImpl<Impuesto, ImpuestoRepository> implements ImpuestoService {
    @Override
    public Impuesto save(Impuesto entity) {
        return super.save(entity);
    }
}
