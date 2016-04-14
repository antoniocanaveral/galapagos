package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_movilidad_hospedaje
* TABLA:  MOVILIDAD HOSPEDAJE
* DESCRIPCION:ALMACENA INFORMACION DE LOS LUGARES DONDE SE VA A ALOJAR LA PERSONA
* ABREVIATURA:CTMVH
*/
public class Cgg_tct_movilidad_hospedaje implements Serializable{
	private static final long serialVersionUID = 1253155650;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtmvh_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	*/
	private String myCtthj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	private String myCrmov_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtmvh_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtmvh_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtmvh_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_hospedaje
	*/
	public Cgg_tct_movilidad_hospedaje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_hospedaje
	* @param inCtmvh_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtthj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @param inCtmvh_estado ESTADO DEL REGISTRO
	* @param inCtmvh_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmvh_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_movilidad_hospedaje(
		String inCtmvh_codigo,
		String inCtthj_codigo,
		String inCrmov_codigo,
		boolean inCtmvh_estado,
		String inCtmvh_usuario_insert,
		String inCtmvh_usuario_update
	){
		this.setCTMVH_CODIGO(inCtmvh_codigo);
		this.setCTTHJ_CODIGO(inCtthj_codigo);
		this.setCRMOV_CODIGO(inCrmov_codigo);
		this.setCTMVH_ESTADO(inCtmvh_estado);
		this.setCTMVH_USUARIO_INSERT(inCtmvh_usuario_insert);
		this.setCTMVH_USUARIO_UPDATE(inCtmvh_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtmvh_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTMVH_CODIGO(String inCtmvh_codigo){
		this.myCtmvh_codigo = inCtmvh_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTMVH_CODIGO(){
		return this.myCtmvh_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	public void setCRMOV_CODIGO(String inCrmov_codigo){
		this.myCrmov_codigo = inCrmov_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	public String getCRMOV_CODIGO(){
		return this.myCrmov_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtmvh_estado ESTADO DEL REGISTRO
	*/
	public void setCTMVH_ESTADO(boolean inCtmvh_estado){
		this.myCtmvh_estado = inCtmvh_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTMVH_ESTADO(){
		return this.myCtmvh_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmvh_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTMVH_USUARIO_INSERT(String inCtmvh_usuario_insert){
		this.myCtmvh_usuario_insert = inCtmvh_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTMVH_USUARIO_INSERT(){
		return this.myCtmvh_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtmvh_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTMVH_USUARIO_UPDATE(String inCtmvh_usuario_update){
		this.myCtmvh_usuario_update = inCtmvh_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTMVH_USUARIO_UPDATE(){
		return this.myCtmvh_usuario_update;
	}

}
