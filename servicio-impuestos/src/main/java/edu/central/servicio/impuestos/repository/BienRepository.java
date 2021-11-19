package edu.central.servicio.impuestos.repository;

import edu.central.common_impuesto_bien.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienRepository extends JpaRepository<Bien, Long> {
}
