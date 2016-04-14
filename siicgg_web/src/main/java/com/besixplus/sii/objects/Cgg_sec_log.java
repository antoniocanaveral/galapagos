package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_log
* TABLA: LOG
* DESCRIPCION:ALMACENA INFORMACION DE REGISTRO DE SUCESOS GENERADA POR EL SISTEMA.
* ABREVIATURA:CSLOG
*/
public class Cgg_sec_log implements Serializable{
	public enum Tipo {ERROR,DEBUG,WARNING,INFO};
	private static final long serialVersionUID = 1580110691;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LOG
	*/
	private String myCslog_codigo;
	/**
	* FECHA DEL CAMBIO DE INFORMACION
	*/
	private java.util.Date myCslog_fecha;
	/**
	* USUARIO QUE REALIZO LA MODIFICACION
	*/
	private String myCslog_usuario;
	/**
	* NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	*/
	private String myCslog_proceso;
	/**
	* TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	*/
	private String myCslog_tipo;
	/**
	* REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	private String myCslog_mensaje;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_log
	*/
	public Cgg_sec_log(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_log
	* @param inCslog_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LOG
	* @param inCslog_fecha FECHA DEL CAMBIO DE INFORMACION
	* @param inCslog_usuario USUARIO QUE REALIZO LA MODIFICACION
	* @param inCslog_proceso NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @param inCslog_tipo TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @param inCslog_mensaje REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	public Cgg_sec_log(
		String inCslog_codigo,
		java.util.Date inCslog_fecha,
		String inCslog_usuario,
		String inCslog_proceso,
		String inCslog_tipo,
		String inCslog_mensaje
	){
		this.setCSLOG_CODIGO(inCslog_codigo);
		this.setCSLOG_FECHA(inCslog_fecha);
		this.setCSLOG_USUARIO(inCslog_usuario);
		this.setCSLOG_PROCESO(inCslog_proceso);
		this.setCSLOG_TIPO(inCslog_tipo);
		this.setCSLOG_MENSAJE(inCslog_mensaje);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LOG
	* @param incslog_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LOG
	*/
	public void setCSLOG_CODIGO(String inCslog_codigo){
		this.myCslog_codigo = inCslog_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LOG
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LOG
	*/
	public String getCSLOG_CODIGO(){
		return this.myCslog_codigo;
	}

	/**
	* ESTABLECE FECHA DEL CAMBIO DE INFORMACION
	* @param incslog_fecha FECHA DEL CAMBIO DE INFORMACION
	*/
	public void setCSLOG_FECHA(java.util.Date inCslog_fecha){
		this.myCslog_fecha = inCslog_fecha;
	}
	/**
	* OBTIENE FECHA DEL CAMBIO DE INFORMACION
	* @return java.util.Date FECHA DEL CAMBIO DE INFORMACION
	*/
	public java.util.Date getCSLOG_FECHA(){
		return this.myCslog_fecha;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA MODIFICACION
	* @param incslog_usuario USUARIO QUE REALIZO LA MODIFICACION
	*/
	public void setCSLOG_USUARIO(String inCslog_usuario){
		this.myCslog_usuario = inCslog_usuario;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA MODIFICACION
	* @return String USUARIO QUE REALIZO LA MODIFICACION
	*/
	public String getCSLOG_USUARIO(){
		return this.myCslog_usuario;
	}

	/**
	* ESTABLECE NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @param incslog_proceso NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	*/
	public void setCSLOG_PROCESO(String inCslog_proceso){
		this.myCslog_proceso = inCslog_proceso;
	}
	/**
	* OBTIENE NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @return String NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	*/
	public String getCSLOG_PROCESO(){
		return this.myCslog_proceso;
	}

	/**
	* ESTABLECE TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @param incslog_tipo TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	*/
	public void setCSLOG_TIPO(String inCslog_tipo){
		this.myCslog_tipo = inCslog_tipo;
	}
	/**
	* OBTIENE TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @return String TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	*/
	public String getCSLOG_TIPO(){
		return this.myCslog_tipo;
	}

	/**
	* ESTABLECE REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	* @param incslog_mensaje REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	public void setCSLOG_MENSAJE(String inCslog_mensaje){
		this.myCslog_mensaje = inCslog_mensaje;
	}
	/**
	* OBTIENE REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	* @return String REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	public String getCSLOG_MENSAJE(){
		return this.myCslog_mensaje;
	}

}
