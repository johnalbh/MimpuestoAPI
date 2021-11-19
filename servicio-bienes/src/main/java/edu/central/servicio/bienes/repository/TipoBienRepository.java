package edu.central.servicio.bienes.repository;

import edu.central.common_impuesto_bien.model.TipoBien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoBienRepository extends JpaRepository<TipoBien, Long> {
}
