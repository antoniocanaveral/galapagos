package com.bmlaurus.objects;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by acanaveral on 29/8/16.
 */
public class RespuestaEncuesta implements Serializable{
/*
encres_codigo character varying PRIMARY KEY,
   encpr_codigo character varying,
   encit_codigo character varying,
   ctreg_codigo
   encres_numval numeric,
   encres_txtval character varying,
   encres_estado boolean DEFAULT TRUE , -- ESTADO DEL REGISTRO
   encres_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
   encres_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
   encres_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
   encres_usuario_update character varying(20)
*/



    private String codigo;
    private String codigoPregunta;
    private String codigoItem;
    private String codigoPreregistro;
    private int valorNumerico;
    private String valorTexto;
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

    public String getCodigoPregunta() {
        return codigoPregunta;
    }

    public void setCodigoPregunta(String codigoPregunta) {
        this.codigoPregunta = codigoPregunta;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getCodigoPreregistro() {
        return codigoPreregistro;
    }

    public void setCodigoPreregistro(String codigoPreregistro) {
        this.codigoPreregistro = codigoPreregistro;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getValorTexto() {
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
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
