package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_modalidad_curso
* TABLA: MODALIDAD DE CURSO 
* DESCRIPCION:ALMACENA INFORMACION DE LAS MODALIDADES DE FORMACION PROFESIONAL 
* ABREVIATURA:CGMDC
*/
public class Cgg_modalidad_curso implements Serializable{
	private static final long serialVersionUID = 159538023;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
	private String myCgmdc_codigo;
	/**
	* DESCRIPCION DE LA MODALIDAD DE CURSO
	*/
	private String myCgmdc_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgmdc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgmdc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgmdc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_modalidad_curso
	*/
	public Cgg_modalidad_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_modalidad_curso
	* @param inCgmdc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	* @param inCgmdc_descripcion DESCRIPCION DE LA MODALIDAD DE CURSO
	* @param inCgmdc_estado ESTADO DEL REGISTRO
	* @param inCgmdc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgmdc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_modalidad_curso(
		String inCgmdc_codigo,
		String inCgmdc_descripcion,
		boolean inCgmdc_estado,
		String inCgmdc_usuario_insert,
		String inCgmdc_usuario_update
	){
		this.setCGMDC_CODIGO(inCgmdc_codigo);
		this.setCGMDC_DESCRIPCION(inCgmdc_descripcion);
		this.setCGMDC_ESTADO(inCgmdc_estado);
		this.setCGMDC_USUARIO_INSERT(inCgmdc_usuario_insert);
		this.setCGMDC_USUARIO_UPDATE(inCgmdc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	* @param inCgmdc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
	public void setCGMDC_CODIGO(String inCgmdc_codigo){
		this.myCgmdc_codigo = inCgmdc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
	public String getCGMDC_CODIGO(){
		return this.myCgmdc_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA MODALIDAD DE CURSO
	* @param inCgmdc_descripcion DESCRIPCION DE LA MODALIDAD DE CURSO
	*/
	public void setCGMDC_DESCRIPCION(String inCgmdc_descripcion){
		this.myCgmdc_descripcion = inCgmdc_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA MODALIDAD DE CURSO
	* @return String DESCRIPCION DE LA MODALIDAD DE CURSO
	*/
	public String getCGMDC_DESCRIPCION(){
		return this.myCgmdc_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgmdc_estado ESTADO DEL REGISTRO
	*/
	public void setCGMDC_ESTADO(boolean inCgmdc_estado){
		this.myCgmdc_estado = inCgmdc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGMDC_ESTADO(){
		return this.myCgmdc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgmdc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGMDC_USUARIO_INSERT(String inCgmdc_usuario_insert){
		this.myCgmdc_usuario_insert = inCgmdc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGMDC_USUARIO_INSERT(){
		return this.myCgmdc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgmdc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGMDC_USUARIO_UPDATE(String inCgmdc_usuario_update){
		this.myCgmdc_usuario_update = inCgmdc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGMDC_USUARIO_UPDATE(){
		return this.myCgmdc_usuario_update;
	}

}
