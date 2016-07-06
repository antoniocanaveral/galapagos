package com.besixplus.sii.objects;

import java.io.Serializable;

/**
 * Created by acanaveral on 4/7/16.
 */
public class Cgg_not_fase_notificacion implements Serializable {

    private static final long serialVersionUID = 6951762004707402783L;

    private String NTML_CODIGO;
    private String CRFAS_CODIGO;
    private String CRPRO_CODIGO;
    private String NTFN_DESTINATARIO;
    private boolean NTFN_ESTADO;
    private String NTFN_USUARIO_INSERT;
    private String NTFN_USUARIO_UPDATE;

    public Cgg_not_fase_notificacion() {
    }

    public Cgg_not_fase_notificacion(String CRFAS_CODIGO, String CRPRO_CODIGO, String NTFN_DESTINATARIO, boolean NTFN_ESTADO, String NTFN_USUARIO_INSERT, String NTFN_USUARIO_UPDATE) {
        this.CRFAS_CODIGO = CRFAS_CODIGO;
        this.CRPRO_CODIGO = CRPRO_CODIGO;
        this.NTFN_DESTINATARIO = NTFN_DESTINATARIO;
        this.NTFN_ESTADO = NTFN_ESTADO;
        this.NTFN_USUARIO_INSERT = NTFN_USUARIO_INSERT;
        this.NTFN_USUARIO_UPDATE = NTFN_USUARIO_UPDATE;
    }

    public String getNtml_codigo() {
        return NTML_CODIGO;
    }

    public void setNtml_codigo(String NTML_CODIGO) {
        this.NTML_CODIGO = NTML_CODIGO;
    }

    public String getCrfas_codigo() {
        return CRFAS_CODIGO;
    }

    public void setCrfas_codigo(String CRFAS_CODIGO) {
        this.CRFAS_CODIGO = CRFAS_CODIGO;
    }

    public String getCrpro_codigo() {
        return CRPRO_CODIGO;
    }

    public void setCrpro_codigo(String CRPRO_CODIGO) {
        this.CRPRO_CODIGO = CRPRO_CODIGO;
    }

    public String getNtfn_destinatario() {
        return NTFN_DESTINATARIO;
    }

    public void setNtfn_destinatario(String NTFN_DESTINATARIO) {
        this.NTFN_DESTINATARIO = NTFN_DESTINATARIO;
    }

    public boolean isNtfn_estado() {
        return NTFN_ESTADO;
    }

    public void setNtfn_estado(boolean NTFN_ESTADO) {
        this.NTFN_ESTADO = NTFN_ESTADO;
    }

    public String getNtfn_usuario_insert() {
        return NTFN_USUARIO_INSERT;
    }

    public void setNtfn_usuario_insert(String NTFN_USUARIO_INSERT) {
        this.NTFN_USUARIO_INSERT = NTFN_USUARIO_INSERT;
    }

    public String getNtfn_usuario_update() {
        return NTFN_USUARIO_UPDATE;
    }

    public void setNtfn_usuario_update(String NTFN_USUARIO_UPDATE) {
        this.NTFN_USUARIO_UPDATE = NTFN_USUARIO_UPDATE;
    }
}
