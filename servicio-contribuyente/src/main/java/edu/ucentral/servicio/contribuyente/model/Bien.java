package edu.ucentral.servicio.contribuyente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Bien")
public class Bien implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne()
    @JoinColumn(name = "contribuyente_id")
    public Contribuyente contribuyente;

    @ManyToOne()
    @JoinColumn(name = "tipoBien_id")
    public TipoBien tipoBien;

    private double valorAvaluo;

    public Bien() {
    }

    public Bien(long id, Contribuyente contribuyente, TipoBien tipoBien, float valorAvaluo) {
        Id = id;
        this.contribuyente = contribuyente;
        this.tipoBien = tipoBien;
        this.valorAvaluo = valorAvaluo;
    }

    public double getValorAvaluo() {
        return valorAvaluo;
    }

    public void setValorAvaluo(double valorAvaluo) {
        this.valorAvaluo = valorAvaluo;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public TipoBien getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }

    private static final long serialVersionUID = -3646326328988245976L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bien bien = (Bien) o;
        return Objects.equals(Id, bien.Id) && Objects.equals(contribuyente, bien.contribuyente) && Objects.equals(tipoBien, bien.tipoBien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, contribuyente, tipoBien);
    }

}
