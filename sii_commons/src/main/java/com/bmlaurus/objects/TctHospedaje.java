package com.bmlaurus.objects;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by acanaveral on 26/8/16.
 */
public class TctHospedaje implements Serializable {

    private static final long serialVersionUID = -6595575485613124814L;

    private String codigo;
    private String codigoPreregistro;
    private String tipoHospedaje;
    private String codigoIsla;
    private String lugarHospedaje;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String reserva;
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

    public String getCodigoPreregistro() {
        return codigoPreregistro;
    }

    public void setCodigoPreregistro(String codigoPreregistro) {
        this.codigoPreregistro = codigoPreregistro;
    }

    public String getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(String tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }

    public String getCodigoIsla() {
        return codigoIsla;
    }

    public void setCodigoIsla(String codigoIsla) {
        this.codigoIsla = codigoIsla;
    }

    public String getLugarHospedaje() {
        return lugarHospedaje;
    }

    public void setLugarHospedaje(String lugarHospedaje) {
        this.lugarHospedaje = lugarHospedaje;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
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
