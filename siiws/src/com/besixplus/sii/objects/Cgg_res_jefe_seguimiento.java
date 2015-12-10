package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_jefe_seguimiento
* TABLA: JEFE SEGUIMIENTO
* DESCRIPCION:ALMACENA INFORMACION DE LOS JEFES DE SEGUIMIENTO ASIGNADOS PARA CONTROLAR LOS ESTADOS DE RESIDENCIA
* ABREVIATURA:CRJSG
*/
public class Cgg_res_jefe_seguimiento implements Serializable{
	private static final long serialVersionUID = 1346773070;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrjsg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrjsg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrjsg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrjsg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_jefe_seguimiento
	*/
	public Cgg_res_jefe_seguimiento(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_jefe_seguimiento
	* @param inCrjsg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrjsg_estado ESTADO DEL REGISTRO
	* @param inCrjsg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrjsg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_jefe_seguimiento(
		String inCrjsg_codigo,
		String inCusu_codigo,
		boolean inCrjsg_estado,
		String inCrjsg_usuario_insert,
		String inCrjsg_usuario_update
	){
		this.setCRJSG_CODIGO(inCrjsg_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRJSG_ESTADO(inCrjsg_estado);
		this.setCRJSG_USUARIO_INSERT(inCrjsg_usuario_insert);
		this.setCRJSG_USUARIO_UPDATE(inCrjsg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrjsg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRJSG_CODIGO(String inCrjsg_codigo){
		this.myCrjsg_codigo = inCrjsg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRJSG_CODIGO(){
		return this.myCrjsg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrjsg_estado ESTADO DEL REGISTRO
	*/
	public void setCRJSG_ESTADO(boolean inCrjsg_estado){
		this.myCrjsg_estado = inCrjsg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRJSG_ESTADO(){
		return this.myCrjsg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrjsg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRJSG_USUARIO_INSERT(String inCrjsg_usuario_insert){
		this.myCrjsg_usuario_insert = inCrjsg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRJSG_USUARIO_INSERT(){
		return this.myCrjsg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrjsg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRJSG_USUARIO_UPDATE(String inCrjsg_usuario_update){
		this.myCrjsg_usuario_update = inCrjsg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRJSG_USUARIO_UPDATE(){
		return this.myCrjsg_usuario_update;
	}

}
