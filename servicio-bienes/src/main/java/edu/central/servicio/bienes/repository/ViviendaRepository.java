package edu.central.servicio.bienes.repository;

import edu.central.servicio.bienes.model.Vivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViviendaRepository extends JpaRepository<Vivienda, String> {
    @Query("SELECT v FROM Vivienda v join fetch v.bien b where b.contribuyente.numeroIdentificacion = ?1 ")
    List<Vivienda> getAllViviendaContribuyente(String numeroIdentificacion);
}
