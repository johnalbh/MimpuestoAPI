package edu.central.servicio.impuestos.DTO;

import edu.central.servicio.impuestos.model.Bien;
import edu.central.servicio.impuestos.model.Impuesto;

import java.util.Objects;

public class ImpuestoBienDTO {

    private Long Id;
    private Impuesto Impuesto;
    private boolean Pagado;
    private double valorTotalOrdinario;
    private double valorTotalConPagoVoluntario;
    private double valorTotalExtraOrdinario;
    private double valorTotalExtraOrdinarioConPagoVoluntario;
    private String nombreTipoBien;
    private String iconoTipoBien;
    private Boolean estadoTipoBien;
    private Bien Bien;

    public ImpuestoBienDTO() {
    }

    public ImpuestoBienDTO(Long id, Impuesto impuesto, boolean pagado, double valorTotalOrdinario, double valorTotalConPagoVoluntario, double valorTotalExtraOrdinario, double valorTotalExtraOrdinarioConPagoVoluntario, String nombreTipoBien, String iconoTipoBien, Boolean estadoTipoBien, Bien bien) {
        Id = id;
        Impuesto = impuesto;
        Pagado = pagado;
        this.valorTotalOrdinario = valorTotalOrdinario;
        this.valorTotalConPagoVoluntario = valorTotalConPagoVoluntario;
        this.valorTotalExtraOrdinario = valorTotalExtraOrdinario;
        this.valorTotalExtraOrdinarioConPagoVoluntario = valorTotalExtraOrdinarioConPagoVoluntario;
        this.nombreTipoBien = nombreTipoBien;
        this.iconoTipoBien = iconoTipoBien;
        this.estadoTipoBien = estadoTipoBien;
        Bien = bien;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Impuesto getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        Impuesto = impuesto;
    }

    public boolean isPagado() {
        return Pagado;
    }

    public void setPagado(boolean pagado) {
        Pagado = pagado;
    }

    public double getValorTotalOrdinario() {
        return valorTotalOrdinario;
    }

    public void setValorTotalOrdinario(double valorTotalOrdinario) {
        this.valorTotalOrdinario = valorTotalOrdinario;
    }

    public double getValorTotalConPagoVoluntario() {
        return valorTotalConPagoVoluntario;
    }

    public void setValorTotalConPagoVoluntario(double valorTotalConPagoVoluntario) {
        this.valorTotalConPagoVoluntario = valorTotalConPagoVoluntario;
    }

    public double getValorTotalExtraOrdinario() {
        return valorTotalExtraOrdinario;
    }

    public void setValorTotalExtraOrdinario(double valorTotalExtraOrdinario) {
        this.valorTotalExtraOrdinario = valorTotalExtraOrdinario;
    }

    public double getValorTotalExtraOrdinarioConPagoVoluntario() {
        return valorTotalExtraOrdinarioConPagoVoluntario;
    }

    public void setValorTotalExtraOrdinarioConPagoVoluntario(double valorTotalExtraOrdinarioConPagoVoluntario) {
        this.valorTotalExtraOrdinarioConPagoVoluntario = valorTotalExtraOrdinarioConPagoVoluntario;
    }

    public String getNombreTipoBien() {
        return nombreTipoBien;
    }

    public void setNombreTipoBien(String nombreTipoBien) {
        this.nombreTipoBien = nombreTipoBien;
    }

    public String getIconoTipoBien() {
        return iconoTipoBien;
    }

    public void setIconoTipoBien(String iconoTipoBien) {
        this.iconoTipoBien = iconoTipoBien;
    }

    public Boolean getEstadoTipoBien() {
        return estadoTipoBien;
    }

    public void setEstadoTipoBien(Boolean estadoTipoBien) {
        this.estadoTipoBien = estadoTipoBien;
    }

    public Bien getBien() {
        return Bien;
    }

    public void setBien(Bien bien) {
        Bien = bien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpuestoBienDTO that = (ImpuestoBienDTO) o;
        return Pagado == that.Pagado && Double.compare(that.valorTotalOrdinario, valorTotalOrdinario) == 0 && Double.compare(that.valorTotalConPagoVoluntario, valorTotalConPagoVoluntario) == 0 && Double.compare(that.valorTotalExtraOrdinario, valorTotalExtraOrdinario) == 0 && Double.compare(that.valorTotalExtraOrdinarioConPagoVoluntario, valorTotalExtraOrdinarioConPagoVoluntario) == 0 && Objects.equals(Id, that.Id) && Objects.equals(Impuesto, that.Impuesto) && Objects.equals(nombreTipoBien, that.nombreTipoBien) && Objects.equals(iconoTipoBien, that.iconoTipoBien) && Objects.equals(estadoTipoBien, that.estadoTipoBien) && Objects.equals(Bien, that.Bien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Impuesto, Pagado, valorTotalOrdinario, valorTotalConPagoVoluntario, valorTotalExtraOrdinario, valorTotalExtraOrdinarioConPagoVoluntario, nombreTipoBien, iconoTipoBien, estadoTipoBien, Bien);
    }
}