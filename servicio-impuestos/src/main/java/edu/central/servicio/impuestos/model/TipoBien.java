package edu.central.servicio.impuestos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TipoBien")
public class TipoBien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nombre;
    private String Icono;
    private Boolean Estado;

    public TipoBien() {
    }

    public TipoBien(Integer id, String nombre, String icono) {
        Id = id;
        Nombre = nombre;
        Icono = icono;
    }

    public String getIcono() {
        return Icono;
    }

    public void setIcono(String icono) {
        Icono = icono;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    private static final long serialVersionUID = 1466301245697587108L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoBien tipoBien = (TipoBien) o;
        return Objects.equals(Id, tipoBien.Id) && Objects.equals(Nombre, tipoBien.Nombre) && Objects.equals(Icono, tipoBien.Icono) && Objects.equals(Estado, tipoBien.Estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Nombre, Icono, Estado);
    }
}
