package com.bmlaurus.objects;

import java.util.Date;

/**
 * Created by acanaveral on 28/7/16.
 */
public class ResidenciaBeneficiario {

    //Beneficiario
    private String CRPER_CODIGO;
    private String CRPER_NUM_DOC_IDENTIFIC;
    private String CRPER_NOMBRES;
    private String CRPER_APELLIDO_PATERNO;
    private String CRPER_APELLIDO_MATERNO;
    private Date CRPER_FECHA_NACIMIENTO;
    private String CPAIS_CODIGO;
    private String CGG_CPAIS_CODIGO;
    private int CRPER_GENERO;
    private String CRPER_NUMERO_RESIDENCIA;
    //Residencia
    private String CRTST_TIPO_DESCRIPCION;
    private String CRTST_MOTIVO_DESCRIPCION;
    private String CRTST_CODIGO;
    private String CRRSD_NUMERO;
    private Date CRRSD_FECHA_INICIO;
    private Date CRRSD_FECHA_CADUCIDAD;

    public String getCRPER_CODIGO() {
        return CRPER_CODIGO;
    }

    public void setCRPER_CODIGO(String CRPER_CODIGO) {
        this.CRPER_CODIGO = CRPER_CODIGO;
    }

    public String getCRPER_NUM_DOC_IDENTIFIC() {
        return CRPER_NUM_DOC_IDENTIFIC;
    }

    public void setCRPER_NUM_DOC_IDENTIFIC(String CRPER_NUM_DOC_IDENTIFIC) {
        this.CRPER_NUM_DOC_IDENTIFIC = CRPER_NUM_DOC_IDENTIFIC;
    }

    public String getCRPER_NOMBRES() {
        return CRPER_NOMBRES;
    }

    public void setCRPER_NOMBRES(String CRPER_NOMBRES) {
        this.CRPER_NOMBRES = CRPER_NOMBRES;
    }

    public String getCRPER_APELLIDO_PATERNO() {
        return CRPER_APELLIDO_PATERNO;
    }

    public void setCRPER_APELLIDO_PATERNO(String CRPER_APELLIDO_PATERNO) {
        this.CRPER_APELLIDO_PATERNO = CRPER_APELLIDO_PATERNO;
    }

    public String getCRPER_APELLIDO_MATERNO() {
        return CRPER_APELLIDO_MATERNO;
    }

    public void setCRPER_APELLIDO_MATERNO(String CRPER_APELLIDO_MATERNO) {
        this.CRPER_APELLIDO_MATERNO = CRPER_APELLIDO_MATERNO;
    }

    public Date getCRPER_FECHA_NACIMIENTO() {
        return CRPER_FECHA_NACIMIENTO;
    }

    public void setCRPER_FECHA_NACIMIENTO(Date CRPER_FECHA_NACIMIENTO) {
        this.CRPER_FECHA_NACIMIENTO = CRPER_FECHA_NACIMIENTO;
    }

    public String getCPAIS_CODIGO() {
        return CPAIS_CODIGO;
    }

    public void setCPAIS_CODIGO(String CPAIS_CODIGO) {
        this.CPAIS_CODIGO = CPAIS_CODIGO;
    }

    public String getCGG_CPAIS_CODIGO() {
        return CGG_CPAIS_CODIGO;
    }

    public void setCGG_CPAIS_CODIGO(String CGG_CPAIS_CODIGO) {
        this.CGG_CPAIS_CODIGO = CGG_CPAIS_CODIGO;
    }

    public int getCRPER_GENERO() {
        return CRPER_GENERO;
    }

    public void setCRPER_GENERO(int CRPER_GENERO) {
        this.CRPER_GENERO = CRPER_GENERO;
    }

    public String getCRPER_NUMERO_RESIDENCIA() {
        return CRPER_NUMERO_RESIDENCIA;
    }

    public void setCRPER_NUMERO_RESIDENCIA(String CRPER_NUMERO_RESIDENCIA) {
        this.CRPER_NUMERO_RESIDENCIA = CRPER_NUMERO_RESIDENCIA;
    }

    public String getCRTST_TIPO_DESCRIPCION() {
        return CRTST_TIPO_DESCRIPCION;
    }

    public void setCRTST_TIPO_DESCRIPCION(String CRTST_TIPO_DESCRIPCION) {
        this.CRTST_TIPO_DESCRIPCION = CRTST_TIPO_DESCRIPCION;
    }

    public String getCRTST_MOTIVO_DESCRIPCION() {
        return CRTST_MOTIVO_DESCRIPCION;
    }

    public void setCRTST_MOTIVO_DESCRIPCION(String CRTST_MOTIVO_DESCRIPCION) {
        this.CRTST_MOTIVO_DESCRIPCION = CRTST_MOTIVO_DESCRIPCION;
    }

    public String getCRTST_CODIGO() {
        return CRTST_CODIGO;
    }

    public void setCRTST_CODIGO(String CRTST_CODIGO) {
        this.CRTST_CODIGO = CRTST_CODIGO;
    }

    public String getCRRSD_NUMERO() {
        return CRRSD_NUMERO;
    }

    public void setCRRSD_NUMERO(String CRRSD_NUMERO) {
        this.CRRSD_NUMERO = CRRSD_NUMERO;
    }

    public Date getCRRSD_FECHA_INICIO() {
        return CRRSD_FECHA_INICIO;
    }

    public void setCRRSD_FECHA_INICIO(Date CRRSD_FECHA_INICIO) {
        this.CRRSD_FECHA_INICIO = CRRSD_FECHA_INICIO;
    }

    public Date getCRRSD_FECHA_CADUCIDAD() {
        return CRRSD_FECHA_CADUCIDAD;
    }

    public void setCRRSD_FECHA_CADUCIDAD(Date CRRSD_FECHA_CADUCIDAD) {
        this.CRRSD_FECHA_CADUCIDAD = CRRSD_FECHA_CADUCIDAD;
    }
}
