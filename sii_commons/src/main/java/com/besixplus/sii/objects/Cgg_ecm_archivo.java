package com.besixplus.sii.objects;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by acanaveral on 8/8/16.
 */
public class Cgg_ecm_archivo implements Serializable{

    private static final long serialVersionUID = 5381646542528602650L;

    public static String TIPO_SISTEMA       = "SIST";
    public static String TIPO_PERSONAL      = "PERS";
    public static String TIPO_NORMATIVA     = "NORM";
    public static String TIPO_GENRICA       = "GENE";

    private String ECMCH_CODIGO;
    private String ECMCH_TIPO;
    private String ECMCH_ASUNTO;
    private Date ECMCH_FECHA;
    private String ECMCH_DESCRIPCION;
    private String ECMCH_EXTRACTO;
    private boolean ECMCH_ESTADO;
    private String ECMCH_USUARIO_INSERT;
    private Date  ECMCH_FECHA_INSERT;
    private String ECMCH_USUARIO_UPDATE;
    private Date  ECMCH_FECHA_UPDATE;
    private boolean ECMCH_UPDATEABLE;

    public Cgg_ecm_archivo() {
    }

    public String getECMCH_CODIGO() {
        return ECMCH_CODIGO;
    }

    public void setECMCH_CODIGO(String ECMCH_CODIGO) {
        this.ECMCH_CODIGO = ECMCH_CODIGO;
    }

    public String getECMCH_TIPO() {
        return ECMCH_TIPO;
    }

    public void setECMCH_TIPO(String ECMCH_TIPO) {
        this.ECMCH_TIPO = ECMCH_TIPO;
    }

    public String getECMCH_ASUNTO() {
        return ECMCH_ASUNTO;
    }

    public void setECMCH_ASUNTO(String ECMCH_ASUNTO) {
        this.ECMCH_ASUNTO = ECMCH_ASUNTO;
    }

    public Date getECMCH_FECHA() {
        return ECMCH_FECHA;
    }

    public void setECMCH_FECHA(Date ECMCH_FECHA) {
        this.ECMCH_FECHA = ECMCH_FECHA;
    }

    public String getECMCH_DESCRIPCION() {
        return ECMCH_DESCRIPCION;
    }

    public void setECMCH_DESCRIPCION(String ECMCH_DESCRIPCION) {
        this.ECMCH_DESCRIPCION = ECMCH_DESCRIPCION;
    }

    public String getECMCH_EXTRACTO() {
        return ECMCH_EXTRACTO;
    }

    public void setECMCH_EXTRACTO(String ECMCH_EXTRACTO) {
        this.ECMCH_EXTRACTO = ECMCH_EXTRACTO;
    }

    public boolean isECMCH_ESTADO() {
        return ECMCH_ESTADO;
    }

    public void setECMCH_ESTADO(boolean ECMCH_ESTADO) {
        this.ECMCH_ESTADO = ECMCH_ESTADO;
    }

    public String getECMCH_USUARIO_INSERT() {
        return ECMCH_USUARIO_INSERT;
    }

    public void setECMCH_USUARIO_INSERT(String ECMCH_USUARIO_INSERT) {
        this.ECMCH_USUARIO_INSERT = ECMCH_USUARIO_INSERT;
    }

    public Date getECMCH_FECHA_INSERT() {
        return ECMCH_FECHA_INSERT;
    }

    public void setECMCH_FECHA_INSERT(Date ECMCH_FECHA_INSERT) {
        this.ECMCH_FECHA_INSERT = ECMCH_FECHA_INSERT;
    }

    public String getECMCH_USUARIO_UPDATE() {
        return ECMCH_USUARIO_UPDATE;
    }

    public void setECMCH_USUARIO_UPDATE(String ECMCH_USUARIO_UPDATE) {
        this.ECMCH_USUARIO_UPDATE = ECMCH_USUARIO_UPDATE;
    }

    public Date getECMCH_FECHA_UPDATE() {
        return ECMCH_FECHA_UPDATE;
    }

    public void setECMCH_FECHA_UPDATE(Date ECMCH_FECHA_UPDATE) {
        this.ECMCH_FECHA_UPDATE = ECMCH_FECHA_UPDATE;
    }

    public boolean isECMCH_UPDATEABLE() {
        return ECMCH_UPDATEABLE;
    }

    public void setECMCH_UPDATEABLE(boolean ECMCH_UPDATEABLE) {
        this.ECMCH_UPDATEABLE = ECMCH_UPDATEABLE;
    }
}
