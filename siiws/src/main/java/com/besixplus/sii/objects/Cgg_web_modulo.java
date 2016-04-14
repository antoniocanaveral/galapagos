package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_web_modulo
* TABLA: MODULO
* DESCRIPCION: ALMACENA INFORMACION SOBRE LOS MODULOS QUE COMPONEN EL SITIO WEB
* ABREVIATURA:CWMOD
*/
public class Cgg_web_modulo implements Serializable{
	private static final long serialVersionUID = 85229658;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwmod_codigo;
	/**
	* NOMBRE DEL MODULO
	*/
	private String myCwmod_nombre;
	/**
	* DESCRIPCION ACERCA DEL MODULO
	*/
	private String myCwmod_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCwmod_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCwmod_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCwmod_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_modulo
	*/
	public Cgg_web_modulo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_modulo
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwmod_nombre NOMBRE DEL MODULO
	* @param inCwmod_descripcion DESCRIPCION ACERCA DEL MODULO
	* @param inCwmod_estado ESTADO DEL REGISTRO
	* @param inCwmod_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwmod_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_web_modulo(
		String inCwmod_codigo,
		String inCwmod_nombre,
		String inCwmod_descripcion,
		boolean inCwmod_estado,
		String inCwmod_usuario_insert,
		String inCwmod_usuario_update
	){
		this.setCWMOD_CODIGO(inCwmod_codigo);
		this.setCWMOD_NOMBRE(inCwmod_nombre);
		this.setCWMOD_DESCRIPCION(inCwmod_descripcion);
		this.setCWMOD_ESTADO(inCwmod_estado);
		this.setCWMOD_USUARIO_INSERT(inCwmod_usuario_insert);
		this.setCWMOD_USUARIO_UPDATE(inCwmod_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCWMOD_CODIGO(String inCwmod_codigo){
		this.myCwmod_codigo = inCwmod_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCWMOD_CODIGO(){
		return this.myCwmod_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL MODULO
	* @param inCwmod_nombre NOMBRE DEL MODULO
	*/
	public void setCWMOD_NOMBRE(String inCwmod_nombre){
		this.myCwmod_nombre = inCwmod_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL MODULO
	* @return String NOMBRE DEL MODULO
	*/
	public String getCWMOD_NOMBRE(){
		return this.myCwmod_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION ACERCA DEL MODULO
	* @param inCwmod_descripcion DESCRIPCION ACERCA DEL MODULO
	*/
	public void setCWMOD_DESCRIPCION(String inCwmod_descripcion){
		this.myCwmod_descripcion = inCwmod_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION ACERCA DEL MODULO
	* @return String DESCRIPCION ACERCA DEL MODULO
	*/
	public String getCWMOD_DESCRIPCION(){
		return this.myCwmod_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCwmod_estado ESTADO DEL REGISTRO
	*/
	public void setCWMOD_ESTADO(boolean inCwmod_estado){
		this.myCwmod_estado = inCwmod_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCWMOD_ESTADO(){
		return this.myCwmod_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwmod_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCWMOD_USUARIO_INSERT(String inCwmod_usuario_insert){
		this.myCwmod_usuario_insert = inCwmod_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCWMOD_USUARIO_INSERT(){
		return this.myCwmod_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCwmod_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCWMOD_USUARIO_UPDATE(String inCwmod_usuario_update){
		this.myCwmod_usuario_update = inCwmod_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCWMOD_USUARIO_UPDATE(){
		return this.myCwmod_usuario_update;
	}

}
