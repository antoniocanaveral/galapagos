package com.besixplus.sii.objects;

import java.io.Serializable;

/**
 * CLASE Cgg_tct_grupo_turista
 * TABLA: GRUPO TURISTA
 * DESCRIPCION:ALMACENA INFORMACION DE LOS TURISTAS REGISTRADOS POR UNA AGENCIA DE VIAJES
 * ABREVIATURA:CTGTR
 */
public class Cgg_tct_grupo_turista_registro implements Serializable{
	private static final long serialVersionUID = 1827629447;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO
	 */
	private String ctgtr_codigo;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 */
	private String cusu_codigo;

	/**
	 * NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	 */
	private int ctgtr_numero;	
	/**
	 * FECHA DE INGRESO  A LA PROVINCIA
	 */
	private java.util.Date ctgtr_fecha_ingreso;
	/**
	 * FECHA DE SALIDA DE LA PROVINCIA
	 */
	private java.util.Date ctgtr_fecha_salida;

	////////////////////////////////PRE REGISTRO ///////////////////////////

	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	 */
	private String ctreg_codigo;
	/**
	 * CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	 */
	private String crper_codigo;

	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	 */
	private String cgg_cusu_codigo;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	 */
	private String carpt_codigo;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	 */
	private String cgg_carpt_codigo;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	 */
	private String craln_codigo;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	 */
	private String crtra_codigo;
	/**
	 * NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	 */
	private int ctreg_numero;
	/**
	 * FECHA DE RESERVA DEL TCT O PREREGISTRO
	 */
	private java.util.Date ctreg_fecha_preregistro;
	/**
	 * FECHA DE INGRESO  A LA PROVINCIA POR TCT
	 */
	private java.util.Date ctreg_fecha_ingreso;
	/**
	 * CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	 */
	private String ctreg_codigo_barras;
	/**
	 * FECHA DE SALIDA DE LA PROVINCIA
	 */
	private java.util.Date ctreg_fecha_salida;
	/**
	 * FECHA DE IMPRESION DE LA ESPECIE DE TCT
	 */
	private java.util.Date ctreg_impresion_especie;
	/**
	 * ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	 */
	private int ctreg_estado_registro;
	/**
	 * INFORMACION ADICIONAL
	 */
	private String ctreg_observacion;


	/////////////////////////////////////////PERSONA////////////////////////////////////	

	/**
	 * NOMBRES DE LA PERSONA
	 */
	private String crper_nombres;

	/**
	 * APELLIDO PATERNO
	 */
	private String crper_apellido_paterno;

	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	 */
	private String crdid_codigo;

	/**
	 * NUMERO DE DOCUMENTO DE IDENTIFICACION
	 */
	private String crper_num_doc_identific;

	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	 */
	private String cpais_codigo;
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	 */
	private String cgncn_codigo;
	/**
	 * GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	 */
	private int crper_genero;

	/**
	 * FECHA DE NACIMIENTO
	 */
	private java.util.Date crper_fecha_nacimiento;

	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_turista
	 */
	public Cgg_tct_grupo_turista_registro(){}

	public String getCtgtr_codigo() {
		return ctgtr_codigo;
	}

	public void setCtgtr_codigo(String ctgtr_codigo) {
		this.ctgtr_codigo = ctgtr_codigo;
	}

	public String getCusu_codigo() {
		return cusu_codigo;
	}

	public void setCusu_codigo(String cusu_codigo) {
		this.cusu_codigo = cusu_codigo;
	}

	public int getCtgtr_numero() {
		return ctgtr_numero;
	}

	public void setCtgtr_numero(int ctgtr_numero) {
		this.ctgtr_numero = ctgtr_numero;
	}

	public java.util.Date getCtgtr_fecha_ingreso() {
		return ctgtr_fecha_ingreso;
	}

	public void setCtgtr_fecha_ingreso(java.util.Date ctgtr_fecha_ingreso) {
		this.ctgtr_fecha_ingreso = ctgtr_fecha_ingreso;
	}

	public java.util.Date getCtgtr_fecha_salida() {
		return ctgtr_fecha_salida;
	}

	public void setCtgtr_fecha_salida(java.util.Date ctgtr_fecha_salida) {
		this.ctgtr_fecha_salida = ctgtr_fecha_salida;
	}

	public String getCtreg_codigo() {
		return ctreg_codigo;
	}

	public void setCtreg_codigo(String ctreg_codigo) {
		this.ctreg_codigo = ctreg_codigo;
	}

	public String getCrper_codigo() {
		return crper_codigo;
	}

	public void setCrper_codigo(String crper_codigo) {
		this.crper_codigo = crper_codigo;
	}

	public String getCgg_cusu_codigo() {
		return cgg_cusu_codigo;
	}

	public void setCgg_cusu_codigo(String cgg_cusu_codigo) {
		this.cgg_cusu_codigo = cgg_cusu_codigo;
	}

	public String getCarpt_codigo() {
		return carpt_codigo;
	}

	public void setCarpt_codigo(String carpt_codigo) {
		this.carpt_codigo = carpt_codigo;
	}

	public String getCgg_carpt_codigo() {
		return cgg_carpt_codigo;
	}

	public void setCgg_carpt_codigo(String cgg_carpt_codigo) {
		this.cgg_carpt_codigo = cgg_carpt_codigo;
	}

	public String getCraln_codigo() {
		return craln_codigo;
	}

	public void setCraln_codigo(String craln_codigo) {
		this.craln_codigo = craln_codigo;
	}

	public String getCrtra_codigo() {
		return crtra_codigo;
	}

	public void setCrtra_codigo(String crtra_codigo) {
		this.crtra_codigo = crtra_codigo;
	}

	public int getCtreg_numero() {
		return ctreg_numero;
	}

	public void setCtreg_numero(int ctreg_numero) {
		this.ctreg_numero = ctreg_numero;
	}

	public java.util.Date getCtreg_fecha_preregistro() {
		return ctreg_fecha_preregistro;
	}

	public void setCtreg_fecha_preregistro(java.util.Date ctreg_fecha_preregistro) {
		this.ctreg_fecha_preregistro = ctreg_fecha_preregistro;
	}

	public java.util.Date getCtreg_fecha_ingreso() {
		return ctreg_fecha_ingreso;
	}

	public void setCtreg_fecha_ingreso(java.util.Date ctreg_fecha_ingreso) {
		this.ctreg_fecha_ingreso = ctreg_fecha_ingreso;
	}

	public String getCtreg_codigo_barras() {
		return ctreg_codigo_barras;
	}

	public void setCtreg_codigo_barras(String ctreg_codigo_barras) {
		this.ctreg_codigo_barras = ctreg_codigo_barras;
	}

	public java.util.Date getCtreg_fecha_salida() {
		return ctreg_fecha_salida;
	}

	public void setCtreg_fecha_salida(java.util.Date ctreg_fecha_salida) {
		this.ctreg_fecha_salida = ctreg_fecha_salida;
	}

	public java.util.Date getCtreg_impresion_especie() {
		return ctreg_impresion_especie;
	}

	public void setCtreg_impresion_especie(java.util.Date ctreg_impresion_especie) {
		this.ctreg_impresion_especie = ctreg_impresion_especie;
	}

	public int getCtreg_estado_registro() {
		return ctreg_estado_registro;
	}

	public void setCtreg_estado_registro(int ctreg_estado_registro) {
		this.ctreg_estado_registro = ctreg_estado_registro;
	}

	public String getCtreg_observacion() {
		return ctreg_observacion;
	}

	public void setCtreg_observacion(String ctreg_observacion) {
		this.ctreg_observacion = ctreg_observacion;
	}

	public String getCrper_nombres() {
		return crper_nombres;
	}

	public void setCrper_nombres(String crper_nombres) {
		this.crper_nombres = crper_nombres;
	}

	public String getCrper_apellido_paterno() {
		return crper_apellido_paterno;
	}

	public void setCrper_apellido_paterno(String crper_apellido_paterno) {
		this.crper_apellido_paterno = crper_apellido_paterno;
	}

	public String getCrdid_codigo() {
		return crdid_codigo;
	}

	public void setCrdid_codigo(String crdid_codigo) {
		this.crdid_codigo = crdid_codigo;
	}

	public String getCrper_num_doc_identific() {
		return crper_num_doc_identific;
	}

	public void setCrper_num_doc_identific(String crper_num_doc_identific) {
		this.crper_num_doc_identific = crper_num_doc_identific;
	}

	public String getCpais_codigo() {
		return cpais_codigo;
	}

	public void setCpais_codigo(String cpais_codigo) {
		this.cpais_codigo = cpais_codigo;
	}

	public String getCgncn_codigo() {
		return cgncn_codigo;
	}

	public void setCgncn_codigo(String cgncn_codigo) {
		this.cgncn_codigo = cgncn_codigo;
	}

	public int getCrper_genero() {
		return crper_genero;
	}

	public void setCrper_genero(int crper_genero) {
		this.crper_genero = crper_genero;
	}

	public java.util.Date getCrper_fecha_nacimiento() {
		return crper_fecha_nacimiento;
	}

	public void setCrper_fecha_nacimiento(java.util.Date crper_fecha_nacimiento) {
		this.crper_fecha_nacimiento = crper_fecha_nacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
