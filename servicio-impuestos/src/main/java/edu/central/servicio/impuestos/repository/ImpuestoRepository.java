package edu.central.servicio.impuestos.repository;

import edu.central.servicio.impuestos.model.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Long> {

}
