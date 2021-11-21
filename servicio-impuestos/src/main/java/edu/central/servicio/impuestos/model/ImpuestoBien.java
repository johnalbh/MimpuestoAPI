package edu.central.servicio.impuestos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ImpuestoBien")
public class ImpuestoBien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne()
    @JoinColumn(name = "impuesto_id")
    private edu.central.servicio.impuestos.model.Impuesto Impuesto;

    @ManyToOne()
    @JoinColumn(name = "bien_id")
    private edu.central.servicio.impuestos.model.Bien Bien;

    private boolean Pagado;

    private double valorTotalOrdinario;
    private double valorTotalConPagoVoluntario;
    private double valorTotalExtraOrdinario;
    private double valorTotalExtraOrdinarioConPagoVoluntario;

    public ImpuestoBien() {
    }

    public ImpuestoBien(edu.central.servicio.impuestos.model.Impuesto impuesto, edu.central.servicio.impuestos.model.Bien bien, boolean pagado, double valorTotalOrdinario, double valorTotalConPagoVoluntario, double valorTotalExtraOrdinario, double valorTotalExtraOrdinarioConPagoVoluntario) {
        Impuesto = impuesto;
        Bien = bien;
        Pagado = pagado;
        this.valorTotalOrdinario = valorTotalOrdinario;
        this.valorTotalConPagoVoluntario = valorTotalConPagoVoluntario;
        this.valorTotalExtraOrdinario = valorTotalExtraOrdinario;
        this.valorTotalExtraOrdinarioConPagoVoluntario = valorTotalExtraOrdinarioConPagoVoluntario;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public edu.central.servicio.impuestos.model.Impuesto getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(edu.central.servicio.impuestos.model.Impuesto impuesto) {
        Impuesto = impuesto;
    }

    public edu.central.servicio.impuestos.model.Bien getBien() {
        return Bien;
    }

    public void setBien(edu.central.servicio.impuestos.model.Bien bien) {
        Bien = bien;
    }

    public boolean isPagado() {
        return Pagado;
    }

    public void setPagado(boolean pagado) {
        Pagado = pagado;
    }

    private static final long serialVersionUID = 366475087915600676L;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpuestoBien that = (ImpuestoBien) o;
        return Pagado == that.Pagado && Double.compare(that.valorTotalOrdinario, valorTotalOrdinario) == 0 && Double.compare(that.valorTotalConPagoVoluntario, valorTotalConPagoVoluntario) == 0 && Double.compare(that.valorTotalExtraOrdinario, valorTotalExtraOrdinario) == 0 && Double.compare(that.valorTotalExtraOrdinarioConPagoVoluntario, valorTotalExtraOrdinarioConPagoVoluntario) == 0 && Objects.equals(Id, that.Id) && Objects.equals(Impuesto, that.Impuesto) && Objects.equals(Bien, that.Bien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Impuesto, Bien, Pagado, valorTotalOrdinario, valorTotalConPagoVoluntario, valorTotalExtraOrdinario, valorTotalExtraOrdinarioConPagoVoluntario);
    }
}
