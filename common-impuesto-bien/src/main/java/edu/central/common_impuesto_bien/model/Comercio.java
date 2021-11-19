package edu.central.common_impuesto_bien.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Comercio")
public class Comercio implements Serializable {

    @Id
    private long Nit;

    private String NombreEstablecimientoComercial;
    private float BaseGravableActividad;
    private Integer CodigoActividad;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bien_id")
    private Bien bien;

    public Comercio() {
    }

    public Comercio(long nit, String nombreEstablecimientoComercial, float baseGravableActividad, Integer codigoActividad, Bien bien) {
        Nit = nit;
        NombreEstablecimientoComercial = nombreEstablecimientoComercial;
        BaseGravableActividad = baseGravableActividad;
        CodigoActividad = codigoActividad;
        this.bien = bien;
    }

    public long getNit() {
        return Nit;
    }

    public void setNit(long nit) {
        Nit = nit;
    }

    public String getNombreEstablecimientoComercial() {
        return NombreEstablecimientoComercial;
    }

    public void setNombreEstablecimientoComercial(String nombreEstablecimientoComercial) {
        NombreEstablecimientoComercial = nombreEstablecimientoComercial;
    }

    public float getBaseGravableActividad() {
        return BaseGravableActividad;
    }

    public void setBaseGravableActividad(float baseGravableActividad) {
        BaseGravableActividad = baseGravableActividad;
    }

    public Integer getCodigoActividad() {
        return CodigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        CodigoActividad = codigoActividad;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    private static final long serialVersionUID = 4252959538831733946L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comercio comercio = (Comercio) o;
        return Nit == comercio.Nit && Float.compare(comercio.BaseGravableActividad, BaseGravableActividad) == 0 && NombreEstablecimientoComercial.equals(comercio.NombreEstablecimientoComercial) && CodigoActividad.equals(comercio.CodigoActividad) && bien.equals(comercio.bien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nit, NombreEstablecimientoComercial, BaseGravableActividad, CodigoActividad, bien);
    }
}
