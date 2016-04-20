package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_nacionalidad
* TABLA: NACIONALIDAD
* DESCRIPCION:ALMACENA INFORMACION DE LAS NACIONALIDADES
* ABREVIATURA:CGNCN
*/
public class Cgg_nacionalidad implements Serializable{
	private static final long serialVersionUID = 1439307063;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	*/
	private String myCgncn_codigo;
	/**
	* NOMBRE DE LA NACIONALIDAD
	*/
	private String myCgncn_nacionalidad;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgncn_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgncn_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgncn_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_nacionalidad
	*/
	public Cgg_nacionalidad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_nacionalidad
	* @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	* @param inCgncn_nacionalidad NOMBRE DE LA NACIONALIDAD
	* @param inCgncn_estado ESTADO DEL REGISTRO
	* @param inCgncn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgncn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_nacionalidad(
		String inCgncn_codigo,
		String inCgncn_nacionalidad,
		boolean inCgncn_estado,
		String inCgncn_usuario_insert,
		String inCgncn_usuario_update
	){
		this.setCGNCN_CODIGO(inCgncn_codigo);
		this.setCGNCN_NACIONALIDAD(inCgncn_nacionalidad);
		this.setCGNCN_ESTADO(inCgncn_estado);
		this.setCGNCN_USUARIO_INSERT(inCgncn_usuario_insert);
		this.setCGNCN_USUARIO_UPDATE(inCgncn_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	* @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	*/
	public void setCGNCN_CODIGO(String inCgncn_codigo){
		this.myCgncn_codigo = inCgncn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	*/
	public String getCGNCN_CODIGO(){
		return this.myCgncn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA NACIONALIDAD
	* @param inCgncn_nacionalidad NOMBRE DE LA NACIONALIDAD
	*/
	public void setCGNCN_NACIONALIDAD(String inCgncn_nacionalidad){
		this.myCgncn_nacionalidad = inCgncn_nacionalidad;
	}
	/**
	* OBTIENE NOMBRE DE LA NACIONALIDAD
	* @return String NOMBRE DE LA NACIONALIDAD
	*/
	public String getCGNCN_NACIONALIDAD(){
		return this.myCgncn_nacionalidad;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgncn_estado ESTADO DEL REGISTRO
	*/
	public void setCGNCN_ESTADO(boolean inCgncn_estado){
		this.myCgncn_estado = inCgncn_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGNCN_ESTADO(){
		return this.myCgncn_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgncn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGNCN_USUARIO_INSERT(String inCgncn_usuario_insert){
		this.myCgncn_usuario_insert = inCgncn_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGNCN_USUARIO_INSERT(){
		return this.myCgncn_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgncn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGNCN_USUARIO_UPDATE(String inCgncn_usuario_update){
		this.myCgncn_usuario_update = inCgncn_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGNCN_USUARIO_UPDATE(){
		return this.myCgncn_usuario_update;
	}

}
