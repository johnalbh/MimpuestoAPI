package edu.ucentral.servicio.contribuyente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Impuesto")
public class Impuesto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date fechaLimitePagoOrdinario;
    private Date fechaLimitePagoExtraOrdinario;
    private double basePagoOrdinario;
    private double basePagoOrdinarioConPagoVoluntario;
    private double basePagoExtraordinario;
    private double basePagoExtraOrdinarioConPagoVoluntario;
    private double valorPagoMinimoOrdinario;
    private double valorPagoMinimoConPagoVoluntario;
    private double valorPagoMinimoExtraOrdinario;
    private double valorPagoMinimoExtraOrdinarioConPagoVoluntario;
    private boolean estado;
    private boolean Obligatorio;
    private String periodicidad;

    @ManyToOne()
    @JoinColumn(name = "tipoBien_id")
    public TipoBien tipoBien;


    public Impuesto() {
    }

    public Impuesto(Long id, Date fechaLimitePagoOrdinario, Date fechaLimitePagoExtraOrdinario, double basePagoOrdinario, double basePagoOrdinarioConPagoVoluntario, double basePagoExtraordinario, double basePagoExtraOrdinarioConPagoVoluntario, double valorPagoMinimoOrdinario, double valorPagoMinimoConPagoVoluntario, double valorPagoMinimoExtraOrdinario, double valorPagoMinimoExtraOrdinarioConPagoVoluntario, boolean estado, boolean obligatorio, String periodicidad, TipoBien tipoBien) {
        Id = id;
        this.fechaLimitePagoOrdinario = fechaLimitePagoOrdinario;
        this.fechaLimitePagoExtraOrdinario = fechaLimitePagoExtraOrdinario;
        this.basePagoOrdinario = basePagoOrdinario;
        this.basePagoOrdinarioConPagoVoluntario = basePagoOrdinarioConPagoVoluntario;
        this.basePagoExtraordinario = basePagoExtraordinario;
        this.basePagoExtraOrdinarioConPagoVoluntario = basePagoExtraOrdinarioConPagoVoluntario;
        this.valorPagoMinimoOrdinario = valorPagoMinimoOrdinario;
        this.valorPagoMinimoConPagoVoluntario = valorPagoMinimoConPagoVoluntario;
        this.valorPagoMinimoExtraOrdinario = valorPagoMinimoExtraOrdinario;
        this.valorPagoMinimoExtraOrdinarioConPagoVoluntario = valorPagoMinimoExtraOrdinarioConPagoVoluntario;
        this.estado = estado;
        Obligatorio = obligatorio;
        this.periodicidad = periodicidad;
        this.tipoBien = tipoBien;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getFechaLimitePagoOrdinario() {
        return fechaLimitePagoOrdinario;
    }

    public void setFechaLimitePagoOrdinario(Date fechaLimitePagoOrdinario) {
        this.fechaLimitePagoOrdinario = fechaLimitePagoOrdinario;
    }

    public Date getFechaLimitePagoExtraOrdinario() {
        return fechaLimitePagoExtraOrdinario;
    }

    public void setFechaLimitePagoExtraOrdinario(Date fechaLimitePagoExtraOrdinario) {
        this.fechaLimitePagoExtraOrdinario = fechaLimitePagoExtraOrdinario;
    }

    public double getBasePagoOrdinario() {
        return basePagoOrdinario;
    }

    public void setBasePagoOrdinario(double basePagoOrdinario) {
        this.basePagoOrdinario = basePagoOrdinario;
    }

    public double getBasePagoOrdinarioConPagoVoluntario() {
        return basePagoOrdinarioConPagoVoluntario;
    }

    public void setBasePagoOrdinarioConPagoVoluntario(double basePagoOrdinarioConPagoVoluntario) {
        this.basePagoOrdinarioConPagoVoluntario = basePagoOrdinarioConPagoVoluntario;
    }

    public double getBasePagoExtraordinario() {
        return basePagoExtraordinario;
    }

    public void setBasePagoExtraordinario(double basePagoExtraordinario) {
        this.basePagoExtraordinario = basePagoExtraordinario;
    }

    public double getBasePagoExtraOrdinarioConPagoVoluntario() {
        return basePagoExtraOrdinarioConPagoVoluntario;
    }

    public void setBasePagoExtraOrdinarioConPagoVoluntario(double basePagoExtraOrdinarioConPagoVoluntario) {
        this.basePagoExtraOrdinarioConPagoVoluntario = basePagoExtraOrdinarioConPagoVoluntario;
    }

    public double getValorPagoMinimoOrdinario() {
        return valorPagoMinimoOrdinario;
    }

    public void setValorPagoMinimoOrdinario(double valorPagoMinimoOrdinario) {
        this.valorPagoMinimoOrdinario = valorPagoMinimoOrdinario;
    }

    public double getValorPagoMinimoConPagoVoluntario() {
        return valorPagoMinimoConPagoVoluntario;
    }

    public void setValorPagoMinimoConPagoVoluntario(double valorPagoMinimoConPagoVoluntario) {
        this.valorPagoMinimoConPagoVoluntario = valorPagoMinimoConPagoVoluntario;
    }

    public double getValorPagoMinimoExtraOrdinario() {
        return valorPagoMinimoExtraOrdinario;
    }

    public void setValorPagoMinimoExtraOrdinario(double valorPagoMinimoExtraOrdinario) {
        this.valorPagoMinimoExtraOrdinario = valorPagoMinimoExtraOrdinario;
    }

    public double getValorPagoMinimoExtraOrdinarioConPagoVoluntario() {
        return valorPagoMinimoExtraOrdinarioConPagoVoluntario;
    }

    public void setValorPagoMinimoExtraOrdinarioConPagoVoluntario(double valorPagoMinimoExtraOrdinarioConPagoVoluntario) {
        this.valorPagoMinimoExtraOrdinarioConPagoVoluntario = valorPagoMinimoExtraOrdinarioConPagoVoluntario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isObligatorio() {
        return Obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        Obligatorio = obligatorio;
    }

    public TipoBien getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impuesto impuesto = (Impuesto) o;
        return Double.compare(impuesto.basePagoOrdinario, basePagoOrdinario) == 0 && Double.compare(impuesto.basePagoOrdinarioConPagoVoluntario, basePagoOrdinarioConPagoVoluntario) == 0 && Double.compare(impuesto.basePagoExtraordinario, basePagoExtraordinario) == 0 && Double.compare(impuesto.basePagoExtraOrdinarioConPagoVoluntario, basePagoExtraOrdinarioConPagoVoluntario) == 0 && Double.compare(impuesto.valorPagoMinimoOrdinario, valorPagoMinimoOrdinario) == 0 && Double.compare(impuesto.valorPagoMinimoConPagoVoluntario, valorPagoMinimoConPagoVoluntario) == 0 && Double.compare(impuesto.valorPagoMinimoExtraOrdinario, valorPagoMinimoExtraOrdinario) == 0 && Double.compare(impuesto.valorPagoMinimoExtraOrdinarioConPagoVoluntario, valorPagoMinimoExtraOrdinarioConPagoVoluntario) == 0 && estado == impuesto.estado && Obligatorio == impuesto.Obligatorio && Objects.equals(Id, impuesto.Id) && Objects.equals(fechaLimitePagoOrdinario, impuesto.fechaLimitePagoOrdinario) && Objects.equals(fechaLimitePagoExtraOrdinario, impuesto.fechaLimitePagoExtraOrdinario) && Objects.equals(periodicidad, impuesto.periodicidad) && Objects.equals(tipoBien, impuesto.tipoBien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fechaLimitePagoOrdinario, fechaLimitePagoExtraOrdinario, basePagoOrdinario, basePagoOrdinarioConPagoVoluntario, basePagoExtraordinario, basePagoExtraOrdinarioConPagoVoluntario, valorPagoMinimoOrdinario, valorPagoMinimoConPagoVoluntario, valorPagoMinimoExtraOrdinario, valorPagoMinimoExtraOrdinarioConPagoVoluntario, estado, Obligatorio, periodicidad, tipoBien);
    }
}
