package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_isla
* TABLA: ISLA
* DESCRIPCION:ALMACENA INFORMACION DE ISLAS O CIUDADES QUE ESTAN DENTRO DE UN CANTON.
* ABREVIATURA:CISLA
*/
public class Cgg_isla implements Serializable{
	private static final long serialVersionUID = 963871027;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	private String myCisla_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE DE LA ISLA O DE CIUDAD
	*/
	private String myCisla_nombre;
	/**
	* ABREVIATURA DEL NOMBRE DE LA ISLA
	*/
	private String myCisla_abreviatura;
	/**
	* INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
	*/
	private java.math.BigDecimal myCisla_indice;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCisla_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCisla_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCisla_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_isla
	*/
	public Cgg_isla(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_isla
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCisla_nombre NOMBRE DE LA ISLA O DE CIUDAD
	* @param inCisla_abreviatura ABREVIATURA DEL NOMBRE DE LA ISLA
	* @param inCisla_indice INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
	* @param inCisla_estado ESTADO DEL REGISTRO
	* @param inCisla_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCisla_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_isla(
		String inCisla_codigo,
		String inCctn_codigo,
		String inCisla_nombre,
		String inCisla_abreviatura,
		java.math.BigDecimal inCisla_indice,
		boolean inCisla_estado,
		String inCisla_usuario_insert,
		String inCisla_usuario_update
	){
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCISLA_NOMBRE(inCisla_nombre);
		this.setCISLA_ABREVIATURA(inCisla_abreviatura);
		this.setCISLA_INDICE(inCisla_indice);
		this.setCISLA_ESTADO(inCisla_estado);
		this.setCISLA_USUARIO_INSERT(inCisla_usuario_insert);
		this.setCISLA_USUARIO_UPDATE(inCisla_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	public void setCISLA_CODIGO(String inCisla_codigo){
		this.myCisla_codigo = inCisla_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	public String getCISLA_CODIGO(){
		return this.myCisla_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA ISLA O DE CIUDAD
	* @param inCisla_nombre NOMBRE DE LA ISLA O DE CIUDAD
	*/
	public void setCISLA_NOMBRE(String inCisla_nombre){
		this.myCisla_nombre = inCisla_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA ISLA O DE CIUDAD
	* @return String NOMBRE DE LA ISLA O DE CIUDAD
	*/
	public String getCISLA_NOMBRE(){
		return this.myCisla_nombre;
	}

	/**
	* ESTABLECE ABREVIATURA DEL NOMBRE DE LA ISLA
	* @param inCisla_abreviatura ABREVIATURA DEL NOMBRE DE LA ISLA
	*/
	public void setCISLA_ABREVIATURA(String inCisla_abreviatura){
		this.myCisla_abreviatura = inCisla_abreviatura;
	}
	/**
	* OBTIENE ABREVIATURA DEL NOMBRE DE LA ISLA
	* @return String ABREVIATURA DEL NOMBRE DE LA ISLA
	*/
	public String getCISLA_ABREVIATURA(){
		return this.myCisla_abreviatura;
	}

	/**
	* ESTABLECE INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
	* @param inCisla_indice INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
	*/
	public void setCISLA_INDICE(java.math.BigDecimal inCisla_indice){
		this.myCisla_indice = inCisla_indice;
	}
	/**
	* OBTIENE INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
	* @return java.math.BigDecimal INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
	*/
	public java.math.BigDecimal getCISLA_INDICE(){
		return this.myCisla_indice;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCisla_estado ESTADO DEL REGISTRO
	*/
	public void setCISLA_ESTADO(boolean inCisla_estado){
		this.myCisla_estado = inCisla_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCISLA_ESTADO(){
		return this.myCisla_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCisla_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCISLA_USUARIO_INSERT(String inCisla_usuario_insert){
		this.myCisla_usuario_insert = inCisla_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCISLA_USUARIO_INSERT(){
		return this.myCisla_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCisla_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCISLA_USUARIO_UPDATE(String inCisla_usuario_update){
		this.myCisla_usuario_update = inCisla_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCISLA_USUARIO_UPDATE(){
		return this.myCisla_usuario_update;
	}

}
