package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_documento_identificacio
* TABLA: TIPO DE DOCUMENTO DE IDENTIFICACION
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE DOCUMENTOS PERSONALES DE IDENTIFICACION 
* ABREVIATURA:CRDID
*/
public class Cgg_res_documento_identificacio implements Serializable{
	private static final long serialVersionUID = 1920511717;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	private String myCrdid_codigo;
	/**
	* DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
	*/
	private String myCrdid_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrdid_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrdid_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrdid_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_documento_identificacio
	*/
	public Cgg_res_documento_identificacio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_documento_identificacio
	* @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrdid_descripcion DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
	* @param inCrdid_estado ESTADO DEL REGISTRO
	* @param inCrdid_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrdid_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_documento_identificacio(
		String inCrdid_codigo,
		String inCrdid_descripcion,
		boolean inCrdid_estado,
		String inCrdid_usuario_insert,
		String inCrdid_usuario_update
	){
		this.setCRDID_CODIGO(inCrdid_codigo);
		this.setCRDID_DESCRIPCION(inCrdid_descripcion);
		this.setCRDID_ESTADO(inCrdid_estado);
		this.setCRDID_USUARIO_INSERT(inCrdid_usuario_insert);
		this.setCRDID_USUARIO_UPDATE(inCrdid_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	public void setCRDID_CODIGO(String inCrdid_codigo){
		this.myCrdid_codigo = inCrdid_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	public String getCRDID_CODIGO(){
		return this.myCrdid_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
	* @param inCrdid_descripcion DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
	*/
	public void setCRDID_DESCRIPCION(String inCrdid_descripcion){
		this.myCrdid_descripcion = inCrdid_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
	* @return String DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
	*/
	public String getCRDID_DESCRIPCION(){
		return this.myCrdid_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrdid_estado ESTADO DEL REGISTRO
	*/
	public void setCRDID_ESTADO(boolean inCrdid_estado){
		this.myCrdid_estado = inCrdid_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRDID_ESTADO(){
		return this.myCrdid_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrdid_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRDID_USUARIO_INSERT(String inCrdid_usuario_insert){
		this.myCrdid_usuario_insert = inCrdid_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRDID_USUARIO_INSERT(){
		return this.myCrdid_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrdid_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRDID_USUARIO_UPDATE(String inCrdid_usuario_update){
		this.myCrdid_usuario_update = inCrdid_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRDID_USUARIO_UPDATE(){
		return this.myCrdid_usuario_update;
	}

}
