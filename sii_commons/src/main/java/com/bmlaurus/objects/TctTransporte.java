package com.bmlaurus.objects;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by acanaveral on 24/8/16.
 */
public class TctTransporte implements Serializable {

    private static final long serialVersionUID = 5246422450939885466L;

    private String codigo;
    private String codigoAerolinea;
    private String codigoAeropuerto;
    private String vuelo;
    private boolean estado;
    private Date fechaInsert;
    private String usuarioInsert;
    private Date fechaUpdate;
    private String usuarioUpdate;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAerolinea() {
        return codigoAerolinea;
    }

    public void setCodigoAerolinea(String codigoAerolinea) {
        this.codigoAerolinea = codigoAerolinea;
    }

    public String getCodigoAeropuerto() {
        return codigoAeropuerto;
    }

    public void setCodigoAeropuerto(String codigoAeropuerto) {
        this.codigoAeropuerto = codigoAeropuerto;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
    }
}
