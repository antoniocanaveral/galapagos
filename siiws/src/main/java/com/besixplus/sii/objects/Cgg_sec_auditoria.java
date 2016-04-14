package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_auditoria
* TABLA: AUDITORIA
* DESCRIPCION:ALMACENA INFORMACION DE LOS CAMBIOS REALIZADOS EN LAS TABLAS DEL SISTEMA
* ABREVIATURA:CSADT
*/
public class Cgg_sec_auditoria implements Serializable{
	private static final long serialVersionUID = 1823824732;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	*/
	private String myCsadt_codigo;
	/**
	* FECHA DEL CAMBIO DE INFORMACION
	*/
	private java.util.Date myCsadt_fecha;
	/**
	* USUARIO QUE REALIZO LA MODIFICACION
	*/
	private String myCsadt_usuario;
	/**
	* IP REMOTA DEL USUARIO
	*/
	private String myCsadt_ip;
	/**
	* IDENTIFICADOR DE LA SESION DEL USUARIO
	*/
	private String myCsadt_sesion;
	/**
	* NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	*/
	private String myCsadt_tabla;
	/**
	* TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	*/
	private String myCsadt_operacion;
	/**
	* REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	private String myCsadt_dato_antiguo;
	/**
	* REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	*/
	private String myCsadt_dato_nuevo;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_auditoria
	*/
	public Cgg_sec_auditoria(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_auditoria
	* @param inCsadt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	* @param inCsadt_fecha FECHA DEL CAMBIO DE INFORMACION
	* @param inCsadt_usuario USUARIO QUE REALIZO LA MODIFICACION
	* @param inCsadt_ip IP REMOTA DEL USUARIO
	* @param inCsadt_sesion IDENTIFICADOR DE LA SESION DEL USUARIO
	* @param inCsadt_tabla NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @param inCsadt_operacion TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @param inCsadt_dato_antiguo REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	* @param inCsadt_dato_nuevo REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	*/
	public Cgg_sec_auditoria(
		String inCsadt_codigo,
		java.util.Date inCsadt_fecha,
		String inCsadt_usuario,
		String inCsadt_ip,
		String inCsadt_sesion,
		String inCsadt_tabla,
		String inCsadt_operacion,
		String inCsadt_dato_antiguo,
		String inCsadt_dato_nuevo
	){
		this.setCSADT_CODIGO(inCsadt_codigo);
		this.setCSADT_FECHA(inCsadt_fecha);
		this.setCSADT_USUARIO(inCsadt_usuario);
		this.setCSADT_IP(inCsadt_ip);
		this.setCSADT_SESION(inCsadt_sesion);
		this.setCSADT_TABLA(inCsadt_tabla);
		this.setCSADT_OPERACION(inCsadt_operacion);
		this.setCSADT_DATO_ANTIGUO(inCsadt_dato_antiguo);
		this.setCSADT_DATO_NUEVO(inCsadt_dato_nuevo);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	* @param inCsadt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	*/
	public void setCSADT_CODIGO(String inCsadt_codigo){
		this.myCsadt_codigo = inCsadt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	*/
	public String getCSADT_CODIGO(){
		return this.myCsadt_codigo;
	}

	/**
	* ESTABLECE FECHA DEL CAMBIO DE INFORMACION
	* @param inCsadt_fecha FECHA DEL CAMBIO DE INFORMACION
	*/
	public void setCSADT_FECHA(java.util.Date inCsadt_fecha){
		this.myCsadt_fecha = inCsadt_fecha;
	}
	/**
	* OBTIENE FECHA DEL CAMBIO DE INFORMACION
	* @return java.util.Date FECHA DEL CAMBIO DE INFORMACION
	*/
	public java.util.Date getCSADT_FECHA(){
		return this.myCsadt_fecha;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA MODIFICACION
	* @param inCsadt_usuario USUARIO QUE REALIZO LA MODIFICACION
	*/
	public void setCSADT_USUARIO(String inCsadt_usuario){
		this.myCsadt_usuario = inCsadt_usuario;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA MODIFICACION
	* @return String USUARIO QUE REALIZO LA MODIFICACION
	*/
	public String getCSADT_USUARIO(){
		return this.myCsadt_usuario;
	}

	/**
	* ESTABLECE IP REMOTA DEL USUARIO
	* @param inCsadt_ip IP REMOTA DEL USUARIO
	*/
	public void setCSADT_IP(String inCsadt_ip){
		this.myCsadt_ip = inCsadt_ip;
	}
	/**
	* OBTIENE IP REMOTA DEL USUARIO
	* @return String IP REMOTA DEL USUARIO
	*/
	public String getCSADT_IP(){
		return this.myCsadt_ip;
	}

	/**
	* ESTABLECE IDENTIFICADOR DE LA SESION DEL USUARIO
	* @param inCsadt_sesion IDENTIFICADOR DE LA SESION DEL USUARIO
	*/
	public void setCSADT_SESION(String inCsadt_sesion){
		this.myCsadt_sesion = inCsadt_sesion;
	}
	/**
	* OBTIENE IDENTIFICADOR DE LA SESION DEL USUARIO
	* @return String IDENTIFICADOR DE LA SESION DEL USUARIO
	*/
	public String getCSADT_SESION(){
		return this.myCsadt_sesion;
	}

	/**
	* ESTABLECE NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @param inCsadt_tabla NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	*/
	public void setCSADT_TABLA(String inCsadt_tabla){
		this.myCsadt_tabla = inCsadt_tabla;
	}
	/**
	* OBTIENE NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @return String NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	*/
	public String getCSADT_TABLA(){
		return this.myCsadt_tabla;
	}

	/**
	* ESTABLECE TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @param inCsadt_operacion TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	*/
	public void setCSADT_OPERACION(String inCsadt_operacion){
		this.myCsadt_operacion = inCsadt_operacion;
	}
	/**
	* OBTIENE TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @return String TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	*/
	public String getCSADT_OPERACION(){
		return this.myCsadt_operacion;
	}

	/**
	* ESTABLECE REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	* @param inCsadt_dato_antiguo REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	public void setCSADT_DATO_ANTIGUO(String inCsadt_dato_antiguo){
		this.myCsadt_dato_antiguo = inCsadt_dato_antiguo;
	}
	/**
	* OBTIENE REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	* @return String REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	*/
	public String getCSADT_DATO_ANTIGUO(){
		return this.myCsadt_dato_antiguo;
	}

	/**
	* ESTABLECE REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	* @param inCsadt_dato_nuevo REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	*/
	public void setCSADT_DATO_NUEVO(String inCsadt_dato_nuevo){
		this.myCsadt_dato_nuevo = inCsadt_dato_nuevo;
	}
	/**
	* OBTIENE REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	* @return String REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	*/
	public String getCSADT_DATO_NUEVO(){
		return this.myCsadt_dato_nuevo;
	}

}
