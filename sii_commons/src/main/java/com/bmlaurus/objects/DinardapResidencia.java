package com.bmlaurus.objects;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by acanaveral on 2/9/16.
 */
public class DinardapResidencia implements Serializable{

    private static final long serialVersionUID = -5386750626216286155L;

    private String numeroIdentificacion;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String tipoResidencia;
    private String motivoResidencia;
    private Date fechaInicioResidencia;
    private Date   fechaFinResidencia;
    private boolean vigente;

    //NO DATA ERROR
    private String errorCode;
    private String errorMsg;

    public DinardapResidencia() {
    }

    public DinardapResidencia(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public String getMotivoResidencia() {
        return motivoResidencia;
    }

    public void setMotivoResidencia(String motivoResidencia) {
        this.motivoResidencia = motivoResidencia;
    }

    public Date getFechaInicioResidencia() {
        return fechaInicioResidencia;
    }

    public void setFechaInicioResidencia(Date fechaInicioResidencia) {
        this.fechaInicioResidencia = fechaInicioResidencia;
    }

    public Date getFechaFinResidencia() {
        return fechaFinResidencia;
    }

    public void setFechaFinResidencia(Date fechaFinResidencia) {
        this.fechaFinResidencia = fechaFinResidencia;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
