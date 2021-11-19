package edu.central.servicio.impuestos.repository;

import edu.central.common_impuesto_bien.model.Bien;
import edu.central.common_impuesto_bien.model.Impuesto;
import edu.central.common_impuesto_bien.model.ImpuestoBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImpuestoBienRepository extends JpaRepository<ImpuestoBien, Long> {
    @Query("SELECT g FROM ImpuestoBien g  WHERE g.Bien = ?1 and g.Impuesto = ?2")
    public ImpuestoBien FindImpuestoBien(Bien idBien, Impuesto idImpuesto);

    @Query("SELECT g  FROM ImpuestoBien g join fetch g.Bien b WHERE b.contribuyente.numeroIdentificacion = ?1 ")
    public List<ImpuestoBien> ListarImpuestoContribuyente(String numeroIdentificacion);

    @Query("SELECT g  FROM ImpuestoBien g join fetch g.Bien b WHERE b.Id = ?1 ")
    public List<ImpuestoBien> ListarImpuestoBien(Long idBien);

}

