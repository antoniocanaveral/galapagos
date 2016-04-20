package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_movilidad_actividad
* TABLA: MOVILIDAD ACTIVIDAD
* DESCRIPCION: ALMACENA INFORMACION DE LAS ACTIVIDADES QUE VA A CUMPLIR UNA PERSONA MIENTRAS SE DESPLAZA POR LA PROVINCIA
* ABREVIATURA:CTMVC
*/
public class Cgg_tct_movilidad_actividad implements Serializable{
	private static final long serialVersionUID = 480266234;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtmvc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	private String myCtact_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	private String myCrmov_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtmvc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtmvc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtmvc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_actividad
	*/
	public Cgg_tct_movilidad_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_actividad
	* @param inCtmvc_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @param inCtmvc_estado ESTADO DEL REGISTRO
	* @param inCtmvc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmvc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_movilidad_actividad(
		String inCtmvc_codigo,
		String inCtact_codigo,
		String inCrmov_codigo,
		boolean inCtmvc_estado,
		String inCtmvc_usuario_insert,
		String inCtmvc_usuario_update
	){
		this.setCTMVC_CODIGO(inCtmvc_codigo);
		this.setCTACT_CODIGO(inCtact_codigo);
		this.setCRMOV_CODIGO(inCrmov_codigo);
		this.setCTMVC_ESTADO(inCtmvc_estado);
		this.setCTMVC_USUARIO_INSERT(inCtmvc_usuario_insert);
		this.setCTMVC_USUARIO_UPDATE(inCtmvc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtmvc_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTMVC_CODIGO(String inCtmvc_codigo){
		this.myCtmvc_codigo = inCtmvc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTMVC_CODIGO(){
		return this.myCtmvc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	public void setCTACT_CODIGO(String inCtact_codigo){
		this.myCtact_codigo = inCtact_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	public String getCTACT_CODIGO(){
		return this.myCtact_codigo;
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
	* @param inCtmvc_estado ESTADO DEL REGISTRO
	*/
	public void setCTMVC_ESTADO(boolean inCtmvc_estado){
		this.myCtmvc_estado = inCtmvc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTMVC_ESTADO(){
		return this.myCtmvc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmvc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTMVC_USUARIO_INSERT(String inCtmvc_usuario_insert){
		this.myCtmvc_usuario_insert = inCtmvc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTMVC_USUARIO_INSERT(){
		return this.myCtmvc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtmvc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTMVC_USUARIO_UPDATE(String inCtmvc_usuario_update){
		this.myCtmvc_usuario_update = inCtmvc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTMVC_USUARIO_UPDATE(){
		return this.myCtmvc_usuario_update;
	}

}
