package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_cargo
* TABLA: CARGO
* DESCRIPCION:ALMACENA INFORMACION DE LAS FUNCIONES ENCARGADAS A UNA PERSONA
* ABREVIATURA:CRCRG
*/
public class Cgg_res_cargo implements Serializable{
	private static final long serialVersionUID = 697866564;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrcrg_codigo;
	/**
	* NOMBRE DEL CARGO
	*/
	private String myCrcrg_nombre;
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
	* NO ESPECIFICADO
	*/
	private String myCrsec_codigo;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cargo
	*/
	public Cgg_res_cargo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cargo
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcrg_nombre NOMBRE DEL CARGO
	* @param inCrcrg_estado ESTADO DEL REGISTRO
	* @param inCrcrg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcrg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrsec_codigo NO ESPECIFICADO
	*/
	public Cgg_res_cargo(
		String inCrcrg_codigo,
		String inCrcrg_nombre,
		boolean inCrcrg_estado,
		String inCrcrg_usuario_insert,
		String inCrcrg_usuario_update,
		String inCrsec_codigo
	){
		this.setCRCRG_CODIGO(inCrcrg_codigo);
		this.setCRCRG_NOMBRE(inCrcrg_nombre);
		this.setCRCRG_ESTADO(inCrcrg_estado);
		this.setCRCRG_USUARIO_INSERT(inCrcrg_usuario_insert);
		this.setCRCRG_USUARIO_UPDATE(inCrcrg_usuario_update);
		this.setCRSEC_CODIGO(inCrsec_codigo);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRCRG_CODIGO(String inCrcrg_codigo){
		this.myCrcrg_codigo = inCrcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRCRG_CODIGO(){
		return this.myCrcrg_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL CARGO
	* @param inCrcrg_nombre NOMBRE DEL CARGO
	*/
	public void setCRCRG_NOMBRE(String inCrcrg_nombre){
		this.myCrcrg_nombre = inCrcrg_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL CARGO
	* @return String NOMBRE DEL CARGO
	*/
	public String getCRCRG_NOMBRE(){
		return this.myCrcrg_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrcrg_estado ESTADO DEL REGISTRO
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

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCrsec_codigo NO ESPECIFICADO
	*/
	public void setCRSEC_CODIGO(String inCrsec_codigo){
		this.myCrsec_codigo = inCrsec_codigo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCRSEC_CODIGO(){
		return this.myCrsec_codigo;
	}

}
