package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_area_funcional
* TABLA: AREA
* DESCRIPCION:ALMACENA INFORMACION DE LAS AREAS DE LAS EMPRESAS.
* ABREVIATURA:CGARE
*/
public class Cgg_gem_area_funcional implements Serializable{
	private static final long serialVersionUID = 1510006788;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	private String myCgare_codigo;
	/**
	* IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
	*/
	private String myCgare_nombre;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgare_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgare_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgare_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgare_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_area_funcional
	*/
	public Cgg_gem_area_funcional(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_area_funcional
	* @param inCgare_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @param inCgare_nombre IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
	* @param inCgare_descripcion NO ESPECIFICADO
	* @param inCgare_estado ESTADO DEL REGISTRO
	* @param inCgare_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgare_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_area_funcional(
		String inCgare_codigo,
		String inCgare_nombre,
		String inCgare_descripcion,
		boolean inCgare_estado,
		String inCgare_usuario_insert,
		String inCgare_usuario_update
	){
		this.setCGARE_CODIGO(inCgare_codigo);
		this.setCGARE_NOMBRE(inCgare_nombre);
		this.setCGARE_DESCRIPCION(inCgare_descripcion);
		this.setCGARE_ESTADO(inCgare_estado);
		this.setCGARE_USUARIO_INSERT(inCgare_usuario_insert);
		this.setCGARE_USUARIO_UPDATE(inCgare_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @param inCgare_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	public void setCGARE_CODIGO(String inCgare_codigo){
		this.myCgare_codigo = inCgare_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	public String getCGARE_CODIGO(){
		return this.myCgare_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
	* @param inCgare_nombre IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
	*/
	public void setCGARE_NOMBRE(String inCgare_nombre){
		this.myCgare_nombre = inCgare_nombre;
	}
	/**
	* OBTIENE IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
	* @return String IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
	*/
	public String getCGARE_NOMBRE(){
		return this.myCgare_nombre;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgare_descripcion NO ESPECIFICADO
	*/
	public void setCGARE_DESCRIPCION(String inCgare_descripcion){
		this.myCgare_descripcion = inCgare_descripcion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGARE_DESCRIPCION(){
		return this.myCgare_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgare_estado ESTADO DEL REGISTRO
	*/
	public void setCGARE_ESTADO(boolean inCgare_estado){
		this.myCgare_estado = inCgare_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGARE_ESTADO(){
		return this.myCgare_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgare_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGARE_USUARIO_INSERT(String inCgare_usuario_insert){
		this.myCgare_usuario_insert = inCgare_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGARE_USUARIO_INSERT(){
		return this.myCgare_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgare_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGARE_USUARIO_UPDATE(String inCgare_usuario_update){
		this.myCgare_usuario_update = inCgare_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGARE_USUARIO_UPDATE(){
		return this.myCgare_usuario_update;
	}

}
