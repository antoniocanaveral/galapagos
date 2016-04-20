package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_movilidad_int_hospedaje
* TABLA:  MOVILIDAD INTERNA HOSPEDAJE
* DESCRIPCION:ALMACENA INFORMACION DE LOS LUGARES DONDE SE VA A ALOJAR UNA PERSONA
* ABREVIATURA:CTMHJ
*/
public class Cgg_tct_movilidad_int_hospedaje implements Serializable{
	private static final long serialVersionUID = 1849029383;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtmhj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	private String myCtthj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	private String myCrmvi_codigo;
	/**
	* NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	private String myCtmhj_lugar_hospedaje;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtmhj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtmhj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtmhj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_int_hospedaje
	*/
	public Cgg_tct_movilidad_int_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_int_hospedaje
	* @param inCtmhj_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtthj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @param inCtmhj_lugar_hospedaje NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @param inCtmhj_estado ESTADO DEL REGISTRO
	* @param inCtmhj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmhj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_movilidad_int_hospedaje(
		String inCtmhj_codigo,
		String inCtthj_codigo,
		String inCrmvi_codigo,
		String inCtmhj_lugar_hospedaje,
		boolean inCtmhj_estado,
		String inCtmhj_usuario_insert,
		String inCtmhj_usuario_update
	){
		this.setCTMHJ_CODIGO(inCtmhj_codigo);
		this.setCTTHJ_CODIGO(inCtthj_codigo);
		this.setCRMVI_CODIGO(inCrmvi_codigo);
		this.setCTMHJ_LUGAR_HOSPEDAJE(inCtmhj_lugar_hospedaje);
		this.setCTMHJ_ESTADO(inCtmhj_estado);
		this.setCTMHJ_USUARIO_INSERT(inCtmhj_usuario_insert);
		this.setCTMHJ_USUARIO_UPDATE(inCtmhj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtmhj_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTMHJ_CODIGO(String inCtmhj_codigo){
		this.myCtmhj_codigo = inCtmhj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTMHJ_CODIGO(){
		return this.myCtmhj_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	public void setCRMVI_CODIGO(String inCrmvi_codigo){
		this.myCrmvi_codigo = inCrmvi_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	public String getCRMVI_CODIGO(){
		return this.myCrmvi_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @param inCtmhj_lugar_hospedaje NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	public void setCTMHJ_LUGAR_HOSPEDAJE(String inCtmhj_lugar_hospedaje){
		this.myCtmhj_lugar_hospedaje = inCtmhj_lugar_hospedaje;
	}
	/**
	* OBTIENE NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	* @return String NOMBRE DEL LUGAR DONDE SE ALOJARA LA PERSONA
	*/
	public String getCTMHJ_LUGAR_HOSPEDAJE(){
		return this.myCtmhj_lugar_hospedaje;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtmhj_estado ESTADO DEL REGISTRO
	*/
	public void setCTMHJ_ESTADO(boolean inCtmhj_estado){
		this.myCtmhj_estado = inCtmhj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTMHJ_ESTADO(){
		return this.myCtmhj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmhj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTMHJ_USUARIO_INSERT(String inCtmhj_usuario_insert){
		this.myCtmhj_usuario_insert = inCtmhj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTMHJ_USUARIO_INSERT(){
		return this.myCtmhj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtmhj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTMHJ_USUARIO_UPDATE(String inCtmhj_usuario_update){
		this.myCtmhj_usuario_update = inCtmhj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTMHJ_USUARIO_UPDATE(){
		return this.myCtmhj_usuario_update;
	}

}
