package edu.central.servicio.bienes.DTO;

import edu.central.servicio.bienes.model.Contribuyente;

public class ComercioDTO {

    private long Nit;
    private String NombreEstablecimientoComercial;
    private float BaseGravableActividad;
    private Integer CodigoActividad;

    public Contribuyente contribuyente;

    private double valorAvaluo;

    public double getValorAvaluo() {
        return valorAvaluo;
    }

    public void setValorAvaluo(double valorAvaluo) {
        this.valorAvaluo = valorAvaluo;
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

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
}
