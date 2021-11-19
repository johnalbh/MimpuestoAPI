package edu.central.servicio.impuestos.repository;

import edu.central.common_impuesto_bien.model.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Long> {

}
