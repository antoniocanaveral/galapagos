package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_registro_hospedaje
* TABLA: REGISTRO HOSPEDAJE
* DESCRIPCION:ALMACENA INFORMACION DE LOS LUGARES DONDE SE VA A ALOJAR UNA PERSONA
* ABREVIATURA:CTRHJ
*/
public class Cgg_tct_registro_hospedaje implements Serializable{
	private static final long serialVersionUID = 1976279883;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtrhj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	private String myCtthj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	private String myCtreg_codigo;
	/**
	* NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	private String myCtrhj_lugar_hospedaje;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtrhj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtrhj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtrhj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro_hospedaje
	*/
	public Cgg_tct_registro_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro_hospedaje
	* @param inCtrhj_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtthj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtrhj_lugar_hospedaje NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @param inCtrhj_estado ESTADO DEL REGISTRO
	* @param inCtrhj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtrhj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_registro_hospedaje(
		String inCtrhj_codigo,
		String inCtthj_codigo,
		String inCtreg_codigo,
		String inCtrhj_lugar_hospedaje,
		boolean inCtrhj_estado,
		String inCtrhj_usuario_insert,
		String inCtrhj_usuario_update
	){
		this.setCTRHJ_CODIGO(inCtrhj_codigo);
		this.setCTTHJ_CODIGO(inCtthj_codigo);
		this.setCTREG_CODIGO(inCtreg_codigo);
		this.setCTRHJ_LUGAR_HOSPEDAJE(inCtrhj_lugar_hospedaje);
		this.setCTRHJ_ESTADO(inCtrhj_estado);
		this.setCTRHJ_USUARIO_INSERT(inCtrhj_usuario_insert);
		this.setCTRHJ_USUARIO_UPDATE(inCtrhj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtrhj_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTRHJ_CODIGO(String inCtrhj_codigo){
		this.myCtrhj_codigo = inCtrhj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTRHJ_CODIGO(){
		return this.myCtrhj_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public void setCTREG_CODIGO(String inCtreg_codigo){
		this.myCtreg_codigo = inCtreg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public String getCTREG_CODIGO(){
		return this.myCtreg_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @param inCtrhj_lugar_hospedaje NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	public void setCTRHJ_LUGAR_HOSPEDAJE(String inCtrhj_lugar_hospedaje){
		this.myCtrhj_lugar_hospedaje = inCtrhj_lugar_hospedaje;
	}
	/**
	* OBTIENE NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @return String NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	public String getCTRHJ_LUGAR_HOSPEDAJE(){
		return this.myCtrhj_lugar_hospedaje;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtrhj_estado ESTADO DEL REGISTRO
	*/
	public void setCTRHJ_ESTADO(boolean inCtrhj_estado){
		this.myCtrhj_estado = inCtrhj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTRHJ_ESTADO(){
		return this.myCtrhj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtrhj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTRHJ_USUARIO_INSERT(String inCtrhj_usuario_insert){
		this.myCtrhj_usuario_insert = inCtrhj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTRHJ_USUARIO_INSERT(){
		return this.myCtrhj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtrhj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTRHJ_USUARIO_UPDATE(String inCtrhj_usuario_update){
		this.myCtrhj_usuario_update = inCtrhj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTRHJ_USUARIO_UPDATE(){
		return this.myCtrhj_usuario_update;
	}

}
