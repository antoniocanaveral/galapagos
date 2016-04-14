package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_proceso
* TABLA: PROCESO
* DESCRIPCION:ALMACENA INFORMACION DE LOS PROCESOS A EJECUTARSE EN LA INSTITUCION
* ABREVIATURA:CRPRO
*/
public class Cgg_res_proceso implements Serializable{
	private static final long serialVersionUID = 2065297251;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	private String myCrpro_codigo;
	/**
	* INFORMACION DE IDENTIFICACION DEL PROCESO
	*/
	private String myCrpro_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrpro_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrpro_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrpro_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_proceso
	*/
	public Cgg_res_proceso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_proceso
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrpro_nombre INFORMACION DE IDENTIFICACION DEL PROCESO
	* @param inCrpro_estado ESTADO DEL REGISTRO
	* @param inCrpro_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpro_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_proceso(
		String inCrpro_codigo,
		String inCrpro_nombre,
		boolean inCrpro_estado,
		String inCrpro_usuario_insert,
		String inCrpro_usuario_update
	){
		this.setCRPRO_CODIGO(inCrpro_codigo);
		this.setCRPRO_NOMBRE(inCrpro_nombre);
		this.setCRPRO_ESTADO(inCrpro_estado);
		this.setCRPRO_USUARIO_INSERT(inCrpro_usuario_insert);
		this.setCRPRO_USUARIO_UPDATE(inCrpro_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	public void setCRPRO_CODIGO(String inCrpro_codigo){
		this.myCrpro_codigo = inCrpro_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	public String getCRPRO_CODIGO(){
		return this.myCrpro_codigo;
	}

	/**
	* ESTABLECE INFORMACION DE IDENTIFICACION DEL PROCESO
	* @param inCrpro_nombre INFORMACION DE IDENTIFICACION DEL PROCESO
	*/
	public void setCRPRO_NOMBRE(String inCrpro_nombre){
		this.myCrpro_nombre = inCrpro_nombre;
	}
	/**
	* OBTIENE INFORMACION DE IDENTIFICACION DEL PROCESO
	* @return String INFORMACION DE IDENTIFICACION DEL PROCESO
	*/
	public String getCRPRO_NOMBRE(){
		return this.myCrpro_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrpro_estado ESTADO DEL REGISTRO
	*/
	public void setCRPRO_ESTADO(boolean inCrpro_estado){
		this.myCrpro_estado = inCrpro_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPRO_ESTADO(){
		return this.myCrpro_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpro_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPRO_USUARIO_INSERT(String inCrpro_usuario_insert){
		this.myCrpro_usuario_insert = inCrpro_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPRO_USUARIO_INSERT(){
		return this.myCrpro_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrpro_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPRO_USUARIO_UPDATE(String inCrpro_usuario_update){
		this.myCrpro_usuario_update = inCrpro_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPRO_USUARIO_UPDATE(){
		return this.myCrpro_usuario_update;
	}

}
