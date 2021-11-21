package edu.central.servicio.bienes.repository;

import edu.central.servicio.bienes.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienRepository extends JpaRepository<Bien, Long> {
}
