package edu.central.servicio.bienes.DTO;

import edu.central.common_impuesto_bien.model.Contribuyente;

public class BienDTO {

    public Contribuyente contribuyente;

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
}
