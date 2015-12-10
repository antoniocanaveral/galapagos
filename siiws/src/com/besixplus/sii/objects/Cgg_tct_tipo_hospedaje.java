package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_tipo_hospedaje
* TABLA: TIPO DE  HOSPEDAJE
* DESCRIPCION:ALMACENA INFORMACION GENERAL DE LOS LUGARES DONDE SE PUEDEN HOSPEDAR LAS PERSONAS
* ABREVIATURA:CTTHJ
*/
public class Cgg_tct_tipo_hospedaje implements Serializable{
	private static final long serialVersionUID = 673864859;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	private String myCtthj_codigo;
	/**
	* NOMBRE DEL TIPO DE HOSPEDAJE
	*/
	private String myCtthj_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtthj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtthj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtthj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_tipo_hospedaje
	*/
	public Cgg_tct_tipo_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_tipo_hospedaje
	* @param inCtthj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @param inCtthj_nombre NOMBRE DEL TIPO DE HOSPEDAJE
	* @param inCtthj_estado ESTADO DEL REGISTRO
	* @param inCtthj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtthj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_tipo_hospedaje(
		String inCtthj_codigo,
		String inCtthj_nombre,
		boolean inCtthj_estado,
		String inCtthj_usuario_insert,
		String inCtthj_usuario_update
	){
		this.setCTTHJ_CODIGO(inCtthj_codigo);
		this.setCTTHJ_NOMBRE(inCtthj_nombre);
		this.setCTTHJ_ESTADO(inCtthj_estado);
		this.setCTTHJ_USUARIO_INSERT(inCtthj_usuario_insert);
		this.setCTTHJ_USUARIO_UPDATE(inCtthj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @param inCtthj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	public void setCTTHJ_CODIGO(String inCtthj_codigo){
		this.myCtthj_codigo = inCtthj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	public String getCTTHJ_CODIGO(){
		return this.myCtthj_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL TIPO DE HOSPEDAJE
	* @param inCtthj_nombre NOMBRE DEL TIPO DE HOSPEDAJE
	*/
	public void setCTTHJ_NOMBRE(String inCtthj_nombre){
		this.myCtthj_nombre = inCtthj_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL TIPO DE HOSPEDAJE
	* @return String NOMBRE DEL TIPO DE HOSPEDAJE
	*/
	public String getCTTHJ_NOMBRE(){
		return this.myCtthj_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtthj_estado ESTADO DEL REGISTRO
	*/
	public void setCTTHJ_ESTADO(boolean inCtthj_estado){
		this.myCtthj_estado = inCtthj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTTHJ_ESTADO(){
		return this.myCtthj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtthj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTTHJ_USUARIO_INSERT(String inCtthj_usuario_insert){
		this.myCtthj_usuario_insert = inCtthj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTTHJ_USUARIO_INSERT(){
		return this.myCtthj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtthj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTTHJ_USUARIO_UPDATE(String inCtthj_usuario_update){
		this.myCtthj_usuario_update = inCtthj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTTHJ_USUARIO_UPDATE(){
		return this.myCtthj_usuario_update;
	}

}
