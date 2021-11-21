package edu.ucentral.servicio.contribuyente.repository;

import edu.ucentral.servicio.contribuyente.model.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContribuyenteRepository extends JpaRepository<Contribuyente, String> {


}
