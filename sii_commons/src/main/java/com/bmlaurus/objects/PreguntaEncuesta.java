package com.bmlaurus.objects;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by acanaveral on 23/8/16.
 * encpr_codigo character varying PRIMARY KEY,
 encpr_descripcion character varying NOT NULL,
 encpr_categoria character varying,
 encpr_estado boolean DEFAULT TRUE , -- ESTADO DEL REGISTRO
 encpr_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
 encpr_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
 encpr_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
 encpr_usuario_update character varying(20)
 */
public class PreguntaEncuesta implements Serializable{

    public static final String CATEGORY_TCT="ENCUESTA_TCT";

    private static final String TIPO_SCORE = "SCORE";
    private static final String TIPO_COMBO = "COMBO";
    private static final String TIPO_TEXTO = "TEXT";

    private static final long serialVersionUID = 7502420380983384146L;


    private String codigo;
    private String descripcion;
    private String tipo;
    private String categoria;
    private boolean estado;
    private Date fechaInsert;
    private String usuarioInsert;
    private Date fechaUpdate;
    private String usuarioUpdate;

    private List<ItemEncuesta> items;



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public List<ItemEncuesta> getItems() {
        return items;
    }

    public void setItems(List<ItemEncuesta> items) {
        this.items = items;
    }
}
