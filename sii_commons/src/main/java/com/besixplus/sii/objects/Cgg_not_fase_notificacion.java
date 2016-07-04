package com.besixplus.sii.objects;

import java.io.Serializable;

/**
 * Created by acanaveral on 4/7/16.
 */
public class Cgg_not_fase_notificacion implements Serializable {

    private static final long serialVersionUID = 6951762004707402783L;

    private String ntml_codigo;
    private String crfas_codigo;
    private String crpro_codigo;
    private String ntfn_destinatario;
    private boolean ntfn_estado;
    private String ntfn_usuario_insert;
    private String ntfn_usuario_update;

    public Cgg_not_fase_notificacion() {
    }

    public Cgg_not_fase_notificacion(String crfas_codigo, String crpro_codigo, String ntfn_destinatario, boolean ntfn_estado, String ntfn_usuario_insert, String ntfn_usuario_update) {
        this.crfas_codigo = crfas_codigo;
        this.crpro_codigo = crpro_codigo;
        this.ntfn_destinatario = ntfn_destinatario;
        this.ntfn_estado = ntfn_estado;
        this.ntfn_usuario_insert = ntfn_usuario_insert;
        this.ntfn_usuario_update = ntfn_usuario_update;
    }

    public String getNtml_codigo() {
        return ntml_codigo;
    }

    public void setNtml_codigo(String ntml_codigo) {
        this.ntml_codigo = ntml_codigo;
    }

    public String getCrfas_codigo() {
        return crfas_codigo;
    }

    public void setCrfas_codigo(String crfas_codigo) {
        this.crfas_codigo = crfas_codigo;
    }

    public String getCrpro_codigo() {
        return crpro_codigo;
    }

    public void setCrpro_codigo(String crpro_codigo) {
        this.crpro_codigo = crpro_codigo;
    }

    public String getNtfn_destinatario() {
        return ntfn_destinatario;
    }

    public void setNtfn_destinatario(String ntfn_destinatario) {
        this.ntfn_destinatario = ntfn_destinatario;
    }

    public boolean isNtfn_estado() {
        return ntfn_estado;
    }

    public void setNtfn_estado(boolean ntfn_estado) {
        this.ntfn_estado = ntfn_estado;
    }

    public String getNtfn_usuario_insert() {
        return ntfn_usuario_insert;
    }

    public void setNtfn_usuario_insert(String ntfn_usuario_insert) {
        this.ntfn_usuario_insert = ntfn_usuario_insert;
    }

    public String getNtfn_usuario_update() {
        return ntfn_usuario_update;
    }

    public void setNtfn_usuario_update(String ntfn_usuario_update) {
        this.ntfn_usuario_update = ntfn_usuario_update;
    }
}
