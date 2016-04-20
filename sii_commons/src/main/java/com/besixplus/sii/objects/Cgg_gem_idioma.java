package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_idioma
* TABLA: IDIOMA
* DESCRIPCION:ALMACENA INFORMACION DE LOS IDIOMAS PRATICADOS POR EL HOMBRE.
* ABREVIATURA:CGIDM
*/
public class Cgg_gem_idioma implements Serializable{
	private static final long serialVersionUID = 1575507402;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgidm_codigo;
	/**
	* IDENTIFICATIVO DEL IDIOMA
	*/
	private String myCgidm_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgidm_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgidm_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgidm_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_idioma
	*/
	public Cgg_gem_idioma(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_idioma
	* @param inCgidm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgidm_nombre IDENTIFICATIVO DEL IDIOMA
	* @param inCgidm_estado ESTADO DEL REGISTRO
	* @param inCgidm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgidm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_idioma(
		String inCgidm_codigo,
		String inCgidm_nombre,
		boolean inCgidm_estado,
		String inCgidm_usuario_insert,
		String inCgidm_usuario_update
	){
		this.setCGIDM_CODIGO(inCgidm_codigo);
		this.setCGIDM_NOMBRE(inCgidm_nombre);
		this.setCGIDM_ESTADO(inCgidm_estado);
		this.setCGIDM_USUARIO_INSERT(inCgidm_usuario_insert);
		this.setCGIDM_USUARIO_UPDATE(inCgidm_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgidm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGIDM_CODIGO(String inCgidm_codigo){
		this.myCgidm_codigo = inCgidm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGIDM_CODIGO(){
		return this.myCgidm_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DEL IDIOMA
	* @param inCgidm_nombre IDENTIFICATIVO DEL IDIOMA
	*/
	public void setCGIDM_NOMBRE(String inCgidm_nombre){
		this.myCgidm_nombre = inCgidm_nombre;
	}
	/**
	* OBTIENE IDENTIFICATIVO DEL IDIOMA
	* @return String IDENTIFICATIVO DEL IDIOMA
	*/
	public String getCGIDM_NOMBRE(){
		return this.myCgidm_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgidm_estado ESTADO DEL REGISTRO
	*/
	public void setCGIDM_ESTADO(boolean inCgidm_estado){
		this.myCgidm_estado = inCgidm_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGIDM_ESTADO(){
		return this.myCgidm_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgidm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGIDM_USUARIO_INSERT(String inCgidm_usuario_insert){
		this.myCgidm_usuario_insert = inCgidm_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGIDM_USUARIO_INSERT(){
		return this.myCgidm_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgidm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGIDM_USUARIO_UPDATE(String inCgidm_usuario_update){
		this.myCgidm_usuario_update = inCgidm_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGIDM_USUARIO_UPDATE(){
		return this.myCgidm_usuario_update;
	}

}
