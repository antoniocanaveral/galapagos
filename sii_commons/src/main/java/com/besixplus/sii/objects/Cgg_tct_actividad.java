package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_actividad
* TABLA: ACTIVIDAD A REALIZAR
* DESCRIPCION:ALMACENA INFORMACION DE LAS ACTIVIDADES QUE PUEDEN CUMPLIR QUIENES INGRESAN A LA PROVINCIA
* ABREVIATURA:CTACT
*/
public class Cgg_tct_actividad implements Serializable{
	private static final long serialVersionUID = 1117402182;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	private String myCtact_codigo;
	/**
	* NOMBRE DE LA ACTIVIDAD  A REALIZAR
	*/
	private String myCtact_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtact_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtact_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtact_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_actividad
	*/
	public Cgg_tct_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_actividad
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCtact_nombre NOMBRE DE LA ACTIVIDAD  A REALIZAR
	* @param inCtact_estado ESTADO DEL REGISTRO
	* @param inCtact_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtact_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_actividad(
		String inCtact_codigo,
		String inCtact_nombre,
		boolean inCtact_estado,
		String inCtact_usuario_insert,
		String inCtact_usuario_update
	){
		this.setCTACT_CODIGO(inCtact_codigo);
		this.setCTACT_NOMBRE(inCtact_nombre);
		this.setCTACT_ESTADO(inCtact_estado);
		this.setCTACT_USUARIO_INSERT(inCtact_usuario_insert);
		this.setCTACT_USUARIO_UPDATE(inCtact_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	public void setCTACT_CODIGO(String inCtact_codigo){
		this.myCtact_codigo = inCtact_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	public String getCTACT_CODIGO(){
		return this.myCtact_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA ACTIVIDAD  A REALIZAR
	* @param inCtact_nombre NOMBRE DE LA ACTIVIDAD  A REALIZAR
	*/
	public void setCTACT_NOMBRE(String inCtact_nombre){
		this.myCtact_nombre = inCtact_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA ACTIVIDAD  A REALIZAR
	* @return String NOMBRE DE LA ACTIVIDAD  A REALIZAR
	*/
	public String getCTACT_NOMBRE(){
		return this.myCtact_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtact_estado ESTADO DEL REGISTRO
	*/
	public void setCTACT_ESTADO(boolean inCtact_estado){
		this.myCtact_estado = inCtact_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTACT_ESTADO(){
		return this.myCtact_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtact_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTACT_USUARIO_INSERT(String inCtact_usuario_insert){
		this.myCtact_usuario_insert = inCtact_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTACT_USUARIO_INSERT(){
		return this.myCtact_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtact_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTACT_USUARIO_UPDATE(String inCtact_usuario_update){
		this.myCtact_usuario_update = inCtact_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTACT_USUARIO_UPDATE(){
		return this.myCtact_usuario_update;
	}

}
