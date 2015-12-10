package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_destreza
* TABLA: DESTREZA
* DESCRIPCION:ALMACENA INFORMACION DE LAS HABILIDADES DEL PERSONAL
* ABREVIATURA:CGDST
*/
public class Cgg_gem_destreza implements Serializable{
	private static final long serialVersionUID = 94045793;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgdst_codigo;
	/**
	* DESCRIPCION DE LA EXPERIENCIA LABORAL
	*/
	private String myCgdst_descripcion;
	/**
	* TIPO DEL REGISTRO 
	* TRUE - DESTREZA
	* FALSE - HABILIDAD
	*/
	private boolean myCgdst_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgdst_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgdst_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgdst_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_destreza
	*/
	public Cgg_gem_destreza(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_destreza
	* @param inCgdst_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdst_descripcion DESCRIPCION DE LA EXPERIENCIA LABORAL
	* @param inCgdst_tipo ALMACENA EL TIPO QUE PUEDE SER:TRUE - DESTREZAS, FALSE - HABILIDADES
	* @param inCgdst_estado ESTADO DEL REGISTRO
	* @param inCgdst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgdst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_destreza(
		String inCgdst_codigo,
		String inCgdst_descripcion,
		boolean inCgdst_tipo,
		boolean inCgdst_estado,
		String inCgdst_usuario_insert,
		String inCgdst_usuario_update
	){
		this.setCGDST_CODIGO(inCgdst_codigo);
		this.setCGDST_DESCRIPCION(inCgdst_descripcion);
		this.setCGDST_TIPO(inCgdst_tipo);
		this.setCGDST_ESTADO(inCgdst_estado);
		this.setCGDST_USUARIO_INSERT(inCgdst_usuario_insert);
		this.setCGDST_USUARIO_UPDATE(inCgdst_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdst_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGDST_CODIGO(String inCgdst_codigo){
		this.myCgdst_codigo = inCgdst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGDST_CODIGO(){
		return this.myCgdst_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA EXPERIENCIA LABORAL
	* @param inCgdst_descripcion DESCRIPCION DE LA EXPERIENCIA LABORAL
	*/
	public void setCGDST_DESCRIPCION(String inCgdst_descripcion){
		this.myCgdst_descripcion = inCgdst_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA EXPERIENCIA LABORAL
	* @return String DESCRIPCION DE LA EXPERIENCIA LABORAL
	*/
	public String getCGDST_DESCRIPCION(){
		return this.myCgdst_descripcion;
	}
	/**
	* ESTABLECE EL TIPO DE RESGISTRO
	* TRUE - DESTREZA
	* FALSE - HABILIDAD
	* @param inCgdst_tipo TIPO DEL REGISTRO
	*/
	public void setCGDST_TIPO(boolean inCgdst_tipo){
		this.myCgdst_tipo = inCgdst_tipo;
	}
	/**
	* OBTIENE EL TIPO AL QUE PERTENECE EL REGISTRO
	* TRUE - DESTREZA
	* FALSE - HABILIDAD
	* @return boolean TIPO DEL REGISTRO
	*/
	public boolean getCGDST_TIPO(){
		return this.myCgdst_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgdst_estado ESTADO DEL REGISTRO
	*/
	public void setCGDST_ESTADO(boolean inCgdst_estado){
		this.myCgdst_estado = inCgdst_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGDST_ESTADO(){
		return this.myCgdst_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgdst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGDST_USUARIO_INSERT(String inCgdst_usuario_insert){
		this.myCgdst_usuario_insert = inCgdst_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGDST_USUARIO_INSERT(){
		return this.myCgdst_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgdst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGDST_USUARIO_UPDATE(String inCgdst_usuario_update){
		this.myCgdst_usuario_update = inCgdst_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGDST_USUARIO_UPDATE(){
		return this.myCgdst_usuario_update;
	}

}
