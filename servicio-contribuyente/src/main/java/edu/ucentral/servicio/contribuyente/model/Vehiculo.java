package edu.ucentral.servicio.contribuyente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable {

    @Id
    private String Placa;
    private String Marca;
    private String Linea;
    private Integer Capacidad;
    private String Uso;
    private Integer Modelo;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bien_id")
    private Bien bien;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String linea, Integer capacidad, String uso, Integer modelo, Bien bien) {
        Placa = placa;
        Marca = marca;
        Linea = linea;
        Capacidad = capacidad;
        Uso = uso;
        Modelo = modelo;
        this.bien = bien;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public Integer getModelo() {
        return Modelo;
    }

    public void setModelo(Integer modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String linea) {
        Linea = linea;
    }

    public Integer getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        Capacidad = capacidad;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        Uso = uso;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    private static final long serialVersionUID = 6519161049705149684L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(Placa, vehiculo.Placa) && Objects.equals(Marca, vehiculo.Marca) && Objects.equals(Linea, vehiculo.Linea) && Objects.equals(Capacidad, vehiculo.Capacidad) && Objects.equals(Uso, vehiculo.Uso) && Objects.equals(Modelo, vehiculo.Modelo) && Objects.equals(bien, vehiculo.bien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Placa, Marca, Linea, Capacidad, Uso, Modelo, bien);
    }
}
