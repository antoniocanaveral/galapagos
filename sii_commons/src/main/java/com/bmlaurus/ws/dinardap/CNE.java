package com.bmlaurus.ws.dinardap;

/**
 * Created by acanaveral on 29/6/16.
 */
public class CNE extends DinardapService {

    private String cedula;
    private String nombre;
    private String provincia;
    private String certificado;
    private String sufrago;
    private String multa;
    private String fecha;

    public CNE(String numeroIdentificacion) {
        super(SERVICE_CNE, numeroIdentificacion);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSufrago() {
        return sufrago;
    }

    public void setSufrago(String sufrago) {
        this.sufrago = sufrago;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
