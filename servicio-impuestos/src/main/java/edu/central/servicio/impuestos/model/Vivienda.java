package edu.central.servicio.impuestos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Vivienda")
public class Vivienda implements Serializable {


    @Id
    private String CedulaCatrastal;
    private String DireccionPredio;
    private float Terreno;
    private float Construccion;
    private Integer Estrato;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="bien_id")
    private Bien bien;

    public Vivienda() {
    }

    public Vivienda(String cedulaCatrastal, String direccionPredio, float terreno, float construccion, Integer estrato, Bien bien) {
        CedulaCatrastal = cedulaCatrastal;
        DireccionPredio = direccionPredio;
        Terreno = terreno;
        Construccion = construccion;
        Estrato = estrato;
        this.bien = bien;
    }

    public String getCedulaCatrastal() {
        return CedulaCatrastal;
    }

    public void setCedulaCatrastal(String cedulaCatrastal) {
        CedulaCatrastal = cedulaCatrastal;
    }

    public Integer getEstrato() {
        return Estrato;
    }

    public void setEstrato(Integer estrato) {
        Estrato = estrato;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public String getDireccionPredio() {
        return DireccionPredio;
    }

    public void setDireccionPredio(String direccionPredio) {
        DireccionPredio = direccionPredio;
    }

    public float getTerreno() {
        return Terreno;
    }

    public void setTerreno(float terreno) {
        Terreno = terreno;
    }

    public float getConstruccion() {
        return Construccion;
    }

    public void setConstruccion(float construccion) {
        Construccion = construccion;
    }

    private static final long serialVersionUID = -71524265435397121L;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vivienda vivienda = (Vivienda) o;
        return Float.compare(vivienda.Terreno, Terreno) == 0 && Float.compare(vivienda.Construccion, Construccion) == 0 && CedulaCatrastal.equals(vivienda.CedulaCatrastal) && DireccionPredio.equals(vivienda.DireccionPredio) && Estrato.equals(vivienda.Estrato) && bien.equals(vivienda.bien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CedulaCatrastal, DireccionPredio, Terreno, Construccion, Estrato, bien);
    }
}
