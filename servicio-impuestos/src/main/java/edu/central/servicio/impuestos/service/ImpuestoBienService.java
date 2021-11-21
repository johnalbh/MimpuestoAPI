package edu.central.servicio.impuestos.service;

import edu.central.servicio.impuestos.model.Bien;
import edu.central.servicio.impuestos.model.Impuesto;
import edu.central.servicio.impuestos.model.ImpuestoBien;
import edu.ucentral.commonsservice.service.CommonService;

import java.util.List;

public interface ImpuestoBienService extends CommonService<ImpuestoBien> {
    public ImpuestoBien FindImpuestoBien(Bien idBien, Impuesto idImpuesto);
    public List<ImpuestoBien> ListarImpuestoBien(Long idBien);
    public List<ImpuestoBien> ListarImpuestoContribuyente(String numeroIdentificacion);

}
