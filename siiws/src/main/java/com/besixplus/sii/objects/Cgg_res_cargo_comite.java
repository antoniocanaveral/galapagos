package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_cargo_comite
* TABLA: CARGO COMITE
* DESCRIPCION:ALMACENA INFORMACION DE LAS FUNCIONES QUE CUMPLEN QUIENES SERAN DELEGADOS COMO MIEMBROS DE COMITE
* ABREVIATURA:CRCRG
*/
public class Cgg_res_cargo_comite implements Serializable{
	private static final long serialVersionUID = 1197269316;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrcrg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrcom_codigo;
	/**
	* DESCRIPCION DEL CARGO 
	*/
	private String myCrcrg_nombre;
	/**
	* INDICADOR DE QUE EL CARGO ES PRINCIPAL
	*/
	private boolean myCrcrg_principal;
	/**
	* ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
	*/
	private boolean myCrcrg_voto_dirimente;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrcrg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrcrg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrcrg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cargo_comite
	*/
	public Cgg_res_cargo_comite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cargo_comite
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcrg_nombre DESCRIPCION DEL CARGO 
	* @param inCrcrg_principal INDICADOR DE QUE EL CARGO ES PRINCIPAL
	* @param inCrcrg_voto_dirimente ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
	* @param inCrcrg_estado ESTADO DEL REGISTRO
	* @param inCrcrg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcrg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_cargo_comite(
		String inCrcrg_codigo,
		String inCrcom_codigo,
		String inCrcrg_nombre,
		boolean inCrcrg_principal,
		boolean inCrcrg_voto_dirimente,
		boolean inCrcrg_estado,
		String inCrcrg_usuario_insert,
		String inCrcrg_usuario_update
	){
		this.setCRCRG_CODIGO(inCrcrg_codigo);
		this.setCRCOM_CODIGO(inCrcom_codigo);
		this.setCRCRG_NOMBRE(inCrcrg_nombre);
		this.setCRCRG_PRINCIPAL(inCrcrg_principal);
		this.setCRCRG_VOTO_DIRIMENTE(inCrcrg_voto_dirimente);
		this.setCRCRG_ESTADO(inCrcrg_estado);
		this.setCRCRG_USUARIO_INSERT(inCrcrg_usuario_insert);
		this.setCRCRG_USUARIO_UPDATE(inCrcrg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRCRG_CODIGO(String inCrcrg_codigo){
		this.myCrcrg_codigo = inCrcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRCRG_CODIGO(){
		return this.myCrcrg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE
	* @param incrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRCOM_CODIGO(String inCrcom_codigo){
		this.myCrcom_codigo = inCrcom_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRCOM_CODIGO(){
		return this.myCrcom_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CARGO 
	 * @param inCrcrg_nombre NOMBRE DEL CARGO
	* @param incrcrg_nombre DESCRIPCION DEL CARGO 
	*/
	public void setCRCRG_NOMBRE(String inCrcrg_nombre){
		this.myCrcrg_nombre = inCrcrg_nombre;
	}
	/**
	* OBTIENE DESCRIPCION DEL CARGO 
	* @return String DESCRIPCION DEL CARGO 
	*/
	public String getCRCRG_NOMBRE(){
		return this.myCrcrg_nombre;
	}

	/**
	* ESTABLECE INDICADOR DE QUE EL CARGO ES PRINCIPAL
	 * @param inCrcrg_principal CARGO PRINCIPAL
	* @param incrcrg_principal INDICADOR DE QUE EL CARGO ES PRINCIPAL
	*/
	public void setCRCRG_PRINCIPAL(boolean inCrcrg_principal){
		this.myCrcrg_principal = inCrcrg_principal;
	}
	/**
	* OBTIENE INDICADOR DE QUE EL CARGO ES PRINCIPAL
	* @return boolean INDICADOR DE QUE EL CARGO ES PRINCIPAL
	*/
	public boolean getCRCRG_PRINCIPAL(){
		return this.myCrcrg_principal;
	}

	/**
	* ESTABLECE ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
	 * @param inCrcrg_voto_dirimente SI ES VOTO DIRIMENTE
	* @param incrcrg_voto_dirimente ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
	*/
	public void setCRCRG_VOTO_DIRIMENTE(boolean inCrcrg_voto_dirimente){
		this.myCrcrg_voto_dirimente = inCrcrg_voto_dirimente;
	}
	/**
	* OBTIENE ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
	* @return boolean ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
	*/
	public boolean getCRCRG_VOTO_DIRIMENTE(){
		return this.myCrcrg_voto_dirimente;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	 * @param inCrcrg_estado ESTADO DEL REGISTRO
	* @param incrcrg_estado ESTADO DEL REGISTRO
	*/
	public void setCRCRG_ESTADO(boolean inCrcrg_estado){
		this.myCrcrg_estado = inCrcrg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRCRG_ESTADO(){
		return this.myCrcrg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcrg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param incrcrg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRCRG_USUARIO_INSERT(String inCrcrg_usuario_insert){
		this.myCrcrg_usuario_insert = inCrcrg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRCRG_USUARIO_INSERT(){
		return this.myCrcrg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrcrg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRCRG_USUARIO_UPDATE(String inCrcrg_usuario_update){
		this.myCrcrg_usuario_update = inCrcrg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRCRG_USUARIO_UPDATE(){
		return this.myCrcrg_usuario_update;
	}

}
