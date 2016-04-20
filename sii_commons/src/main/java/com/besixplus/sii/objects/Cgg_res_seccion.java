package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_seccion
* TABLA: SECCION
* DESCRIPCION:ALMACENA INFORMACION DE LAS SECCIONES QUE PUEDEN PARTICIPAR EN UN SEGUIMIENTO
* ABREVIATURA:CRSEC
*/
public class Cgg_res_seccion implements Serializable{
	private static final long serialVersionUID = 1331394449;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	private String myCrsec_codigo;
	/**
	* NOMBRE DEL DOCUMENTO DE RESPUESTA
	*/
	private String myCrsec_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrsec_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrsec_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrsec_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_seccion
	*/
	public Cgg_res_seccion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_seccion
	* @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @param inCrsec_nombre NOMBRE DEL DOCUMENTO DE RESPUESTA
	* @param inCrsec_estado ESTADO DEL REGISTRO
	* @param inCrsec_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrsec_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_seccion(
		String inCrsec_codigo,
		String inCrsec_nombre,
		boolean inCrsec_estado,
		String inCrsec_usuario_insert,
		String inCrsec_usuario_update
	){
		this.setCRSEC_CODIGO(inCrsec_codigo);
		this.setCRSEC_NOMBRE(inCrsec_nombre);
		this.setCRSEC_ESTADO(inCrsec_estado);
		this.setCRSEC_USUARIO_INSERT(inCrsec_usuario_insert);
		this.setCRSEC_USUARIO_UPDATE(inCrsec_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	public void setCRSEC_CODIGO(String inCrsec_codigo){
		this.myCrsec_codigo = inCrsec_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	public String getCRSEC_CODIGO(){
		return this.myCrsec_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO DE RESPUESTA
	* @param inCrsec_nombre NOMBRE DEL DOCUMENTO DE RESPUESTA
	*/
	public void setCRSEC_NOMBRE(String inCrsec_nombre){
		this.myCrsec_nombre = inCrsec_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO DE RESPUESTA
	* @return String NOMBRE DEL DOCUMENTO DE RESPUESTA
	*/
	public String getCRSEC_NOMBRE(){
		return this.myCrsec_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrsec_estado ESTADO DEL REGISTRO
	*/
	public void setCRSEC_ESTADO(boolean inCrsec_estado){
		this.myCrsec_estado = inCrsec_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRSEC_ESTADO(){
		return this.myCrsec_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrsec_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRSEC_USUARIO_INSERT(String inCrsec_usuario_insert){
		this.myCrsec_usuario_insert = inCrsec_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRSEC_USUARIO_INSERT(){
		return this.myCrsec_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrsec_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRSEC_USUARIO_UPDATE(String inCrsec_usuario_update){
		this.myCrsec_usuario_update = inCrsec_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRSEC_USUARIO_UPDATE(){
		return this.myCrsec_usuario_update;
	}

}
