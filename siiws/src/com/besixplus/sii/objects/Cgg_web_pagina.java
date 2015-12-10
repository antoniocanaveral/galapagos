package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_web_pagina
* TABLA: PAGINAS 
* DESCRIPCION: ALMACENA INFORMACION DE LAS PAGINAS WEB QUE COMPONEN EL SITIO WEB
* ABREVIATURA:CWPAG
*/
public class Cgg_web_pagina implements Serializable{
	private static final long serialVersionUID = 7181547;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCwpag_codigo;
	/**
	* NOMBRE COMPLETO DE LA PAGINA WEB
	*/
	private String myCwpag_nombre;
	/**
	* CONTENIDO DE LA FRASE O MENSAJE
	*/
	private String myCwpag_titulo;
	/**
	* CONTENIDO DE LA FRASE O MENSAJE
	*/
	private String myCwpag_descripcion;
	/**
	* DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	*/
	private String myCwpag_configuracion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCwpag_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCwpag_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCwpag_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_pagina
	*/
	public Cgg_web_pagina(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_pagina
	* @param inCwpag_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCwpag_nombre NOMBRE COMPLETO DE LA PAGINA WEB
	* @param inCwpag_titulo CONTENIDO DE LA FRASE O MENSAJE
	* @param inCwpag_descripcion CONTENIDO DE LA FRASE O MENSAJE
	* @param inCwpag_configuracion DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	* @param inCwpag_estado ESTADO DEL REGISTRO
	* @param inCwpag_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwpag_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_web_pagina(
		String inCwpag_codigo,
		String inCwpag_nombre,
		String inCwpag_titulo,
		String inCwpag_descripcion,
		String inCwpag_configuracion,
		boolean inCwpag_estado,
		String inCwpag_usuario_insert,
		String inCwpag_usuario_update
	){
		this.setCWPAG_CODIGO(inCwpag_codigo);
		this.setCWPAG_NOMBRE(inCwpag_nombre);
		this.setCWPAG_TITULO(inCwpag_titulo);
		this.setCWPAG_DESCRIPCION(inCwpag_descripcion);
		this.setCWPAG_CONFIGURACION(inCwpag_configuracion);
		this.setCWPAG_ESTADO(inCwpag_estado);
		this.setCWPAG_USUARIO_INSERT(inCwpag_usuario_insert);
		this.setCWPAG_USUARIO_UPDATE(inCwpag_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCwpag_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCWPAG_CODIGO(String inCwpag_codigo){
		this.myCwpag_codigo = inCwpag_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCWPAG_CODIGO(){
		return this.myCwpag_codigo;
	}

	/**
	* ESTABLECE NOMBRE COMPLETO DE LA PAGINA WEB
	* @param inCwpag_nombre NOMBRE COMPLETO DE LA PAGINA WEB
	*/
	public void setCWPAG_NOMBRE(String inCwpag_nombre){
		this.myCwpag_nombre = inCwpag_nombre;
	}
	/**
	* OBTIENE NOMBRE COMPLETO DE LA PAGINA WEB
	* @return String NOMBRE COMPLETO DE LA PAGINA WEB
	*/
	public String getCWPAG_NOMBRE(){
		return this.myCwpag_nombre;
	}

	/**
	* ESTABLECE CONTENIDO DE LA FRASE O MENSAJE
	* @param inCwpag_titulo CONTENIDO DE LA FRASE O MENSAJE
	*/
	public void setCWPAG_TITULO(String inCwpag_titulo){
		this.myCwpag_titulo = inCwpag_titulo;
	}
	/**
	* OBTIENE CONTENIDO DE LA FRASE O MENSAJE
	* @return String CONTENIDO DE LA FRASE O MENSAJE
	*/
	public String getCWPAG_TITULO(){
		return this.myCwpag_titulo;
	}

	/**
	* ESTABLECE CONTENIDO DE LA FRASE O MENSAJE
	* @param inCwpag_descripcion CONTENIDO DE LA FRASE O MENSAJE
	*/
	public void setCWPAG_DESCRIPCION(String inCwpag_descripcion){
		this.myCwpag_descripcion = inCwpag_descripcion;
	}
	/**
	* OBTIENE CONTENIDO DE LA FRASE O MENSAJE
	* @return String CONTENIDO DE LA FRASE O MENSAJE
	*/
	public String getCWPAG_DESCRIPCION(){
		return this.myCwpag_descripcion;
	}

	/**
	* ESTABLECE DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	* @param inCwpag_configuracion DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	*/
	public void setCWPAG_CONFIGURACION(String inCwpag_configuracion){
		this.myCwpag_configuracion = inCwpag_configuracion;
	}
	/**
	* OBTIENE DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	* @return String DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	*/
	public String getCWPAG_CONFIGURACION(){
		return this.myCwpag_configuracion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCwpag_estado ESTADO DEL REGISTRO
	*/
	public void setCWPAG_ESTADO(boolean inCwpag_estado){
		this.myCwpag_estado = inCwpag_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCWPAG_ESTADO(){
		return this.myCwpag_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwpag_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCWPAG_USUARIO_INSERT(String inCwpag_usuario_insert){
		this.myCwpag_usuario_insert = inCwpag_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCWPAG_USUARIO_INSERT(){
		return this.myCwpag_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCwpag_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCWPAG_USUARIO_UPDATE(String inCwpag_usuario_update){
		this.myCwpag_usuario_update = inCwpag_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCWPAG_USUARIO_UPDATE(){
		return this.myCwpag_usuario_update;
	}

}
