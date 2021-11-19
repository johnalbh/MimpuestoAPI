package edu.central.servicio.bienes.repository;

import edu.central.common_impuesto_bien.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

    @Query("SELECT v FROM Vehiculo v join fetch v.bien b where b.contribuyente.numeroIdentificacion = ?1 ")
    List<Vehiculo> getAllVehiculoContribuyente(String numeroIdentificacion);
}
