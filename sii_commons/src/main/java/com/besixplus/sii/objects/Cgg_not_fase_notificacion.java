package com.besixplus.sii.objects;

import com.besixplus.sii.misc.CGGEnumerators;

import java.io.Serializable;

/**
 * Created by acanaveral on 4/7/16.
 */
public class Cgg_not_fase_notificacion implements Serializable {

    private static final long serialVersionUID = 6951762004707402783L;
    //['AUSP','Auspiciante'],['BENF','Beneficiario'], ['USUA','Funcionario Fase'], ['GOB','Gobierno de Gal\u00F1pagos']];

    public static final String DEST_AUSPICIANTE = "AUSP";
    public static final String DEST_BENEFICIARIO = "BENF";
    public static final String DEST_FUNCIONARIOFASE = "USUA";
    public static final String DEST_GOBIERNO = "GOB";

    private final String APROBADO = "AUT";
    private final String NEGADO = "NEGA";


    private String NTML_CODIGO;
    private String CRFAS_CODIGO;
    private String CRPRO_CODIGO;
    private String NTFN_DESTINATARIO;
    private String NTFN_TIPO_SOLICITUD;
    private String NTFN_RESPUESTA_FASE;
    private boolean NTFN_ESTADO;
    private String NTFN_USUARIO_INSERT;
    private String NTFN_USUARIO_UPDATE;

    public Cgg_not_fase_notificacion() {
    }

    public Cgg_not_fase_notificacion(String CRFAS_CODIGO, String CRPRO_CODIGO, String NTFN_DESTINATARIO, String NTFN_TIPO_SOLICITUD,
                                     String NTFN_RESPUESTA_FASE, boolean NTFN_ESTADO, String NTFN_USUARIO_INSERT, String NTFN_USUARIO_UPDATE) {
        this.CRFAS_CODIGO = CRFAS_CODIGO;
        this.CRPRO_CODIGO = CRPRO_CODIGO;
        this.NTFN_DESTINATARIO = NTFN_DESTINATARIO;
        this.NTFN_TIPO_SOLICITUD = NTFN_TIPO_SOLICITUD;
        this.NTFN_RESPUESTA_FASE = NTFN_RESPUESTA_FASE;
        this.NTFN_ESTADO = NTFN_ESTADO;
        this.NTFN_USUARIO_INSERT = NTFN_USUARIO_INSERT;
        this.NTFN_USUARIO_UPDATE = NTFN_USUARIO_UPDATE;
    }

    public String getNTML_CODIGO() {
        return NTML_CODIGO;
    }

    public void setNTML_CODIGO(String NTML_CODIGO) {
        this.NTML_CODIGO = NTML_CODIGO;
    }

    public String getCRFAS_CODIGO() {
        return CRFAS_CODIGO;
    }

    public void setCRFAS_CODIGO(String CRFAS_CODIGO) {
        this.CRFAS_CODIGO = CRFAS_CODIGO;
    }

    public String getCRPRO_CODIGO() {
        return CRPRO_CODIGO;
    }

    public void setCRPRO_CODIGO(String CRPRO_CODIGO) {
        this.CRPRO_CODIGO = CRPRO_CODIGO;
    }

    public String getNTFN_DESTINATARIO() {
        return NTFN_DESTINATARIO;
    }

    public void setNTFN_DESTINATARIO(String NTFN_DESTINATARIO) {
        this.NTFN_DESTINATARIO = NTFN_DESTINATARIO;
    }

    public String getNTFN_TIPO_SOLICITUD() {
        return NTFN_TIPO_SOLICITUD;
    }

    public void setNTFN_TIPO_SOLICITUD(String NTFN_TIPO_SOLICITUD) {
        this.NTFN_TIPO_SOLICITUD = NTFN_TIPO_SOLICITUD;
    }

    public String getNTFN_RESPUESTA_FASE() {
        return NTFN_RESPUESTA_FASE;
    }

    public int getNTFN_RESPUESTA_FASE_INT(){
        if(NTFN_RESPUESTA_FASE.equals(APROBADO))
            return CGGEnumerators.TIPORESPUESTA.APROBADO.getValue();
        else if(NTFN_RESPUESTA_FASE.equals(NEGADO))
            return CGGEnumerators.TIPORESPUESTA.NEGADO.getValue();
        else
            return CGGEnumerators.TIPORESPUESTA.INDETERMINADO.getValue();
    }

    public void setNTFN_RESPUESTA_FASE(String NTFN_RESPUESTA_FASE) {
        this.NTFN_RESPUESTA_FASE = NTFN_RESPUESTA_FASE;
    }

    public boolean isNTFN_ESTADO() {
        return NTFN_ESTADO;
    }

    public void setNTFN_ESTADO(boolean NTFN_ESTADO) {
        this.NTFN_ESTADO = NTFN_ESTADO;
    }

    public String getNTFN_USUARIO_INSERT() {
        return NTFN_USUARIO_INSERT;
    }

    public void setNTFN_USUARIO_INSERT(String NTFN_USUARIO_INSERT) {
        this.NTFN_USUARIO_INSERT = NTFN_USUARIO_INSERT;
    }

    public String getNTFN_USUARIO_UPDATE() {
        return NTFN_USUARIO_UPDATE;
    }

    public void setNTFN_USUARIO_UPDATE(String NTFN_USUARIO_UPDATE) {
        this.NTFN_USUARIO_UPDATE = NTFN_USUARIO_UPDATE;
    }
}
