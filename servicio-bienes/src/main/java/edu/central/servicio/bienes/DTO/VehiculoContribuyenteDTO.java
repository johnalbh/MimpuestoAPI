package edu.central.servicio.bienes.DTO;

public class VehiculoContribuyenteDTO {

    private String Placa;
    private String Marca;
    private String Linea;
    private Integer Capacidad;
    private String Uso;
    private Integer Modelo;
    private double valorAvaluo;

    public double getValorAvaluo() {
        return valorAvaluo;
    }

    public void setValorAvaluo(double valorAvaluo) {
        this.valorAvaluo = valorAvaluo;
    }
    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
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

    public Integer getModelo() {
        return Modelo;
    }

    public void setModelo(Integer modelo) {
        Modelo = modelo;
    }
}
