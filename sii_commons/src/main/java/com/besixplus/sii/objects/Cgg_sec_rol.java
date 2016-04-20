package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_rol
* TABLA: ROL
* DESCRIPCION:ALMACENA INFORMACION DE LOS ROLES QUE TIENE EL SISTEMA
* ABREVIATURA:CSROL
*/
public class Cgg_sec_rol implements Serializable{
	private static final long serialVersionUID = 1147775404;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	private String myCsrol_codigo;
	/**
	* NOMBRE DEL ROL
	*/
	private String myCsrol_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsrol_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsrol_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsrol_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_rol
	*/
	public Cgg_sec_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_rol
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCsrol_nombre NOMBRE DEL ROL
	* @param inCsrol_estado ESTADO DEL REGISTRO
	* @param inCsrol_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsrol_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_rol(
		String inCsrol_codigo,
		String inCsrol_nombre,
		boolean inCsrol_estado,
		String inCsrol_usuario_insert,
		String inCsrol_usuario_update
	){
		this.setCSROL_CODIGO(inCsrol_codigo);
		this.setCSROL_NOMBRE(inCsrol_nombre);
		this.setCSROL_ESTADO(inCsrol_estado);
		this.setCSROL_USUARIO_INSERT(inCsrol_usuario_insert);
		this.setCSROL_USUARIO_UPDATE(inCsrol_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	public void setCSROL_CODIGO(String inCsrol_codigo){
		this.myCsrol_codigo = inCsrol_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	public String getCSROL_CODIGO(){
		return this.myCsrol_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL ROL
	* @param inCsrol_nombre NOMBRE DEL ROL
	*/
	public void setCSROL_NOMBRE(String inCsrol_nombre){
		this.myCsrol_nombre = inCsrol_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL ROL
	* @return String NOMBRE DEL ROL
	*/
	public String getCSROL_NOMBRE(){
		return this.myCsrol_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsrol_estado ESTADO DEL REGISTRO
	*/
	public void setCSROL_ESTADO(boolean inCsrol_estado){
		this.myCsrol_estado = inCsrol_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSROL_ESTADO(){
		return this.myCsrol_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsrol_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSROL_USUARIO_INSERT(String inCsrol_usuario_insert){
		this.myCsrol_usuario_insert = inCsrol_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSROL_USUARIO_INSERT(){
		return this.myCsrol_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsrol_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSROL_USUARIO_UPDATE(String inCsrol_usuario_update){
		this.myCsrol_usuario_update = inCsrol_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSROL_USUARIO_UPDATE(){
		return this.myCsrol_usuario_update;
	}

}
