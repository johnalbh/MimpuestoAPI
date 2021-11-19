package edu.central.servicio.bienes.repository;

import edu.central.common_impuesto_bien.model.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  ComercioRepository extends JpaRepository<Comercio, Long> {
    @Query("SELECT c FROM Comercio c join fetch c.bien b where b.contribuyente.numeroIdentificacion = ?1 ")
    List<Comercio> getAllComercioContribuyente(String numeroIdentificacion);
}