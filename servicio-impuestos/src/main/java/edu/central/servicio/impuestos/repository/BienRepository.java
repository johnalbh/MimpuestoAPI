package edu.central.servicio.impuestos.repository;

import edu.central.servicio.impuestos.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienRepository extends JpaRepository<Bien, Long> {
}
