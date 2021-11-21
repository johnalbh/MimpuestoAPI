package edu.central.servicio.bienes.repository;

import edu.central.servicio.bienes.model.TipoBien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoBienRepository extends JpaRepository<TipoBien, Long> {
}
