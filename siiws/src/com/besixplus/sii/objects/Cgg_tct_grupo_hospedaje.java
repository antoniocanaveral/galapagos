package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_grupo_hospedaje
* TABLA:  GRUPO HOSPEDAJE
* DESCRIPCION:ALMACENA INFORMACION DE LOS LUGARES DONDE SE VA A ALOJAR UN GRUPO DE TURISTAS
* ABREVIATURA:CTGHJ
*/
public class Cgg_tct_grupo_hospedaje implements Serializable{
	private static final long serialVersionUID = 659156937;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtghj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtgtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	private String myCtthj_codigo;
	/**
	* NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	private String myCtghj_lugar_hospedaje;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtghj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtghj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtghj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_hospedaje
	*/
	public Cgg_tct_grupo_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_hospedaje
	* @param inCtghj_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtthj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @param inCtghj_lugar_hospedaje NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @param inCtghj_estado ESTADO DEL REGISTRO
	* @param inCtghj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtghj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_grupo_hospedaje(
		String inCtghj_codigo,
		String inCtgtr_codigo,
		String inCtthj_codigo,
		String inCtghj_lugar_hospedaje,
		boolean inCtghj_estado,
		String inCtghj_usuario_insert,
		String inCtghj_usuario_update
	){
		this.setCTGHJ_CODIGO(inCtghj_codigo);
		this.setCTGTR_CODIGO(inCtgtr_codigo);
		this.setCTTHJ_CODIGO(inCtthj_codigo);
		this.setCTGHJ_LUGAR_HOSPEDAJE(inCtghj_lugar_hospedaje);
		this.setCTGHJ_ESTADO(inCtghj_estado);
		this.setCTGHJ_USUARIO_INSERT(inCtghj_usuario_insert);
		this.setCTGHJ_USUARIO_UPDATE(inCtghj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtghj_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTGHJ_CODIGO(String inCtghj_codigo){
		this.myCtghj_codigo = inCtghj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTGHJ_CODIGO(){
		return this.myCtghj_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTGTR_CODIGO(String inCtgtr_codigo){
		this.myCtgtr_codigo = inCtgtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTGTR_CODIGO(){
		return this.myCtgtr_codigo;
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
	* ESTABLECE NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @param inCtghj_lugar_hospedaje NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	public void setCTGHJ_LUGAR_HOSPEDAJE(String inCtghj_lugar_hospedaje){
		this.myCtghj_lugar_hospedaje = inCtghj_lugar_hospedaje;
	}
	/**
	* OBTIENE NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @return String NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	public String getCTGHJ_LUGAR_HOSPEDAJE(){
		return this.myCtghj_lugar_hospedaje;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtghj_estado ESTADO DEL REGISTRO
	*/
	public void setCTGHJ_ESTADO(boolean inCtghj_estado){
		this.myCtghj_estado = inCtghj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTGHJ_ESTADO(){
		return this.myCtghj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtghj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTGHJ_USUARIO_INSERT(String inCtghj_usuario_insert){
		this.myCtghj_usuario_insert = inCtghj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTGHJ_USUARIO_INSERT(){
		return this.myCtghj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtghj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTGHJ_USUARIO_UPDATE(String inCtghj_usuario_update){
		this.myCtghj_usuario_update = inCtghj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTGHJ_USUARIO_UPDATE(){
		return this.myCtghj_usuario_update;
	}

}
