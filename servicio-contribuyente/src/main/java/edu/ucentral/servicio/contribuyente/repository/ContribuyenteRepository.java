package edu.ucentral.servicio.contribuyente.repository;

import edu.central.common_impuesto_bien.model.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContribuyenteRepository extends JpaRepository<Contribuyente, String> {


}
