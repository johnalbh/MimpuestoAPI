package edu.central.servicio.bienes.DTO;

public class ComercioContribuyenteDTO {

    private long Nit;
    private String NombreEstablecimientoComercial;
    private float BaseGravableActividad;
    private Integer CodigoActividad;
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
}
