package edu.central.servicio.bienes.DTO;

import edu.central.common_impuesto_bien.model.Contribuyente;

public class ViviendaDTO {

    private String CedulaCatrastal;
    private String DireccionPredio;
    private float Terreno;
    private float Construccion;
    private Integer Estrato;
    public Contribuyente contribuyente;

    private double valorAvaluo;

    public double getValorAvaluo() {
        return valorAvaluo;
    }

    public void setValorAvaluo(double valorAvaluo) {
        this.valorAvaluo = valorAvaluo;
    }
    public String getCedulaCatrastal() {
        return CedulaCatrastal;
    }

    public void setCedulaCatrastal(String cedulaCatrastal) {
        CedulaCatrastal = cedulaCatrastal;
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

    public Integer getEstrato() {
        return Estrato;
    }

    public void setEstrato(Integer estrato) {
        Estrato = estrato;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
}
