package edu.ucentral.servicio.contribuyente.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Contribuyente")
public class Contribuyente implements Serializable {

    @Id
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String correoElectronico;
    private String telefonoPrincipal;
    private String direccionNotificacion;

    public Contribuyente() {
    }

    public Contribuyente(String numeroIdentificacion, String tipoIdentificacion, String primerApellido, String segundoApellido, String primerNombre, String segundoNombre, String correoElectronico, String telefonoPrincipal, String direccionNotificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.correoElectronico = correoElectronico;
        this.telefonoPrincipal = telefonoPrincipal;
        this.direccionNotificacion = direccionNotificacion;
    }

    public void setTelefonoPrincipal(String telefonoPrincipal) {
        this.telefonoPrincipal = telefonoPrincipal;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoPrincipal() {
        return telefonoPrincipal;
    }

    public String getDireccionNotificacion() {
        return direccionNotificacion;
    }

    public void setDireccionNotificacion(String direccionResidencia) {
        this.direccionNotificacion = direccionResidencia;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribuyente that = (Contribuyente) o;
        return numeroIdentificacion.equals(that.numeroIdentificacion) && tipoIdentificacion.equals(that.tipoIdentificacion) && primerApellido.equals(that.primerApellido) && segundoApellido.equals(that.segundoApellido) && primerNombre.equals(that.primerNombre) && segundoNombre.equals(that.segundoNombre) && correoElectronico.equals(that.correoElectronico) && telefonoPrincipal.equals(that.telefonoPrincipal) && direccionNotificacion.equals(that.direccionNotificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroIdentificacion, tipoIdentificacion, primerApellido, segundoApellido, primerNombre, segundoNombre, correoElectronico, telefonoPrincipal, direccionNotificacion);
    }
}
