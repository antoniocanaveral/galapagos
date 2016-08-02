package com.bmlaurus.rule;

import java.io.Serializable;

/**
 * Created by acanaveral on 5/7/16.
 */
public class RuleData implements Serializable {

    //Los datos estan en caliente, porque el tramite aún no ha sido creado.
    private String CRTST_CODIGO; //Código Tipo de Solicitud

    private String CRPJR_CODIGO;//Código Auspiciante Juridico

    private String CRPER_CODIGO; //Código del Auspiciante

    private String CGGCRPER_CODIGO; //Código del Beneficiario

    private String CRPER_NUM_DOC_IDENTIFIC; //Cédula del Beneficiario

    private String CRPER_FECHA_NACIMIENTO; //Fecha de Nacimiento del Beneficiario

    private String CRDPT_CODIGO; //Código del depósito o garantía

    private String CVVEH_CODIGO; //Código de Vehículo

    private String CRDID_CODIGO; //Código del tipo de identificación del Beneficiario. Puede venir nulo

    private String CRPER_CONYUGE; // Cédula del Conyuge

    private String CRPER_FECHA_MATRIMONIO;//Fecha de Matrimonio

    private String REP_CRPER_CODIGO; //Código del Representante para Temporales

    private String CHANGE_CRTST_CODIGO; //Nuevo motivo(cambio de motivo)

    public String getCRTST_CODIGO() {
        return CRTST_CODIGO;
    }

    public void setCRTST_CODIGO(String CRTST_CODIGO) {
        this.CRTST_CODIGO = CRTST_CODIGO;
    }

    public String getCRPJR_CODIGO() {
        return CRPJR_CODIGO;
    }

    public void setCRPJR_CODIGO(String CRPJR_CODIGO) {
        this.CRPJR_CODIGO = CRPJR_CODIGO;
    }

    public String getCRPER_CODIGO() {
        return CRPER_CODIGO;
    }

    public void setCRPER_CODIGO(String CRPER_CODIGO) {
        this.CRPER_CODIGO = CRPER_CODIGO;
    }

    public String getCGGCRPER_CODIGO() {
        return CGGCRPER_CODIGO;
    }

    public void setCGGCRPER_CODIGO(String CGGCRPER_CODIGO) {
        this.CGGCRPER_CODIGO = CGGCRPER_CODIGO;
    }

    public String getCRPER_NUM_DOC_IDENTIFIC() {
        return CRPER_NUM_DOC_IDENTIFIC;
    }

    public void setCRPER_NUM_DOC_IDENTIFIC(String CRPER_NUM_DOC_IDENTIFIC) {
        this.CRPER_NUM_DOC_IDENTIFIC = CRPER_NUM_DOC_IDENTIFIC;
    }

    public String getCRPER_FECHA_NACIMIENTO() {
        return CRPER_FECHA_NACIMIENTO;
    }

    public void setCRPER_FECHA_NACIMIENTO(String CRPER_FECHA_NACIMIENTO) {
        this.CRPER_FECHA_NACIMIENTO = CRPER_FECHA_NACIMIENTO;
    }

    public String getCRDPT_CODIGO() {
        return CRDPT_CODIGO;
    }

    public void setCRDPT_CODIGO(String CRDPT_CODIGO) {
        this.CRDPT_CODIGO = CRDPT_CODIGO;
    }

    public String getCVVEH_CODIGO() {
        return CVVEH_CODIGO;
    }

    public void setCVVEH_CODIGO(String CVVEH_CODIGO) {
        this.CVVEH_CODIGO = CVVEH_CODIGO;
    }

    public String getCRDID_CODIGO() {
        return CRDID_CODIGO;
    }

    public void setCRDID_CODIGO(String CRDID_CODIGO) {
        this.CRDID_CODIGO = CRDID_CODIGO;
    }

    public String getCRPER_CONYUGE() {
        return CRPER_CONYUGE;
    }

    public void setCRPER_CONYUGE(String CRPER_CONYUGE) {
        this.CRPER_CONYUGE = CRPER_CONYUGE;
    }

    public String getCRPER_FECHA_MATRIMONIO() {
        return CRPER_FECHA_MATRIMONIO;
    }

    public void setCRPER_FECHA_MATRIMONIO(String CRPER_FECHA_MATRIMONIO) {
        this.CRPER_FECHA_MATRIMONIO = CRPER_FECHA_MATRIMONIO;
    }

    public String getREP_CRPER_CODIGO() {
        return REP_CRPER_CODIGO;
    }

    public void setREP_CRPER_CODIGO(String CEDULA_REPRESENTANTE) {
        this.REP_CRPER_CODIGO = CEDULA_REPRESENTANTE;
    }

    public String getCHANGE_CRTST_CODIGO() {
        return CHANGE_CRTST_CODIGO;
    }

    public void setCHANGE_CRTST_CODIGO(String CHANGE_CRTST_CODIGO) {
        this.CHANGE_CRTST_CODIGO = CHANGE_CRTST_CODIGO;
    }
}
