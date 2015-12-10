package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_respuesta
* TABLA: RESPUESTA
* DESCRIPCION:ALMACENA INFORMACION DE LAS RESPUESTAS QUE PUEDE CORRESPONDERSE A VARIAS PREGUNTAS
* ABREVIATURA:CDRES
*/
public class Cgg_dhu_respuesta implements Serializable{
	private static final long serialVersionUID = 47516634;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	private String myCdres_codigo;
	/**
	* DESCRIPCION DE LA RESPUESTA
	*/
	private String myCdres_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdres_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdres_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdres_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_respuesta
	*/
	public Cgg_dhu_respuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_respuesta
	* @param inCdres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @param inCdres_descripcion DESCRIPCION DE LA RESPUESTA
	* @param inCdres_estado ESTADO DEL REGISTRO
	* @param inCdres_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdres_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_respuesta(
		String inCdres_codigo,
		String inCdres_descripcion,
		boolean inCdres_estado,
		String inCdres_usuario_insert,
		String inCdres_usuario_update
	){
		this.setCDRES_CODIGO(inCdres_codigo);
		this.setCDRES_DESCRIPCION(inCdres_descripcion);
		this.setCDRES_ESTADO(inCdres_estado);
		this.setCDRES_USUARIO_INSERT(inCdres_usuario_insert);
		this.setCDRES_USUARIO_UPDATE(inCdres_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @param inCdres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	public void setCDRES_CODIGO(String inCdres_codigo){
		this.myCdres_codigo = inCdres_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	public String getCDRES_CODIGO(){
		return this.myCdres_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA RESPUESTA
	* @param inCdres_descripcion DESCRIPCION DE LA RESPUESTA
	*/
	public void setCDRES_DESCRIPCION(String inCdres_descripcion){
		this.myCdres_descripcion = inCdres_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA RESPUESTA
	* @return String DESCRIPCION DE LA RESPUESTA
	*/
	public String getCDRES_DESCRIPCION(){
		return this.myCdres_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdres_estado ESTADO DEL REGISTRO
	*/
	public void setCDRES_ESTADO(boolean inCdres_estado){
		this.myCdres_estado = inCdres_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDRES_ESTADO(){
		return this.myCdres_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdres_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDRES_USUARIO_INSERT(String inCdres_usuario_insert){
		this.myCdres_usuario_insert = inCdres_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDRES_USUARIO_INSERT(){
		return this.myCdres_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdres_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDRES_USUARIO_UPDATE(String inCdres_usuario_update){
		this.myCdres_usuario_update = inCdres_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDRES_USUARIO_UPDATE(){
		return this.myCdres_usuario_update;
	}

}
