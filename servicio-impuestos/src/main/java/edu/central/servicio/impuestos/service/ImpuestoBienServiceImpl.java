package edu.central.servicio.impuestos.service;

import edu.central.common_impuesto_bien.model.Bien;
import edu.central.common_impuesto_bien.model.Impuesto;
import edu.central.common_impuesto_bien.model.ImpuestoBien;
import edu.central.servicio.impuestos.repository.ImpuestoBienRepository;
import edu.ucentral.commonsservice.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpuestoBienServiceImpl extends CommonServiceImpl<ImpuestoBien, ImpuestoBienRepository> implements ImpuestoBienService {

    @Override
    public ImpuestoBien FindImpuestoBien(Bien idBien, Impuesto idImpuesto) {
        return repository.FindImpuestoBien(idBien, idImpuesto);
    }

    @Override
    public List<ImpuestoBien> ListarImpuestoBien(Long idBien) {
        return repository.ListarImpuestoBien(idBien);
    }

    @Override
    public List<ImpuestoBien> ListarImpuestoContribuyente(String numeroIdentificacion) {
        return repository.ListarImpuestoContribuyente(numeroIdentificacion);
    }
}
