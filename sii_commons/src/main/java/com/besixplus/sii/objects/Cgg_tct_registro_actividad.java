package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_registro_actividad
* TABLA: REGISTRO ACTIVIDAD
* DESCRIPCION:ALMACENA INFORMACION DE DE LAS ACTIVIDADES QUE VA A CUMPLIR UNA PERSONA
* ABREVIATURA:CTRAC
*/
public class Cgg_tct_registro_actividad implements Serializable{
	private static final long serialVersionUID = 859962422;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtrac_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	private String myCtreg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	private String myCtact_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtrac_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtrac_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtrac_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro_actividad
	*/
	public Cgg_tct_registro_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro_actividad
	* @param inCtrac_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCtrac_estado ESTADO DEL REGISTRO
	* @param inCtrac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtrac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_registro_actividad(
		String inCtrac_codigo,
		String inCtreg_codigo,
		String inCtact_codigo,
		boolean inCtrac_estado,
		String inCtrac_usuario_insert,
		String inCtrac_usuario_update
	){
		this.setCTRAC_CODIGO(inCtrac_codigo);
		this.setCTREG_CODIGO(inCtreg_codigo);
		this.setCTACT_CODIGO(inCtact_codigo);
		this.setCTRAC_ESTADO(inCtrac_estado);
		this.setCTRAC_USUARIO_INSERT(inCtrac_usuario_insert);
		this.setCTRAC_USUARIO_UPDATE(inCtrac_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtrac_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTRAC_CODIGO(String inCtrac_codigo){
		this.myCtrac_codigo = inCtrac_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTRAC_CODIGO(){
		return this.myCtrac_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public void setCTREG_CODIGO(String inCtreg_codigo){
		this.myCtreg_codigo = inCtreg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public String getCTREG_CODIGO(){
		return this.myCtreg_codigo;
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
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtrac_estado ESTADO DEL REGISTRO
	*/
	public void setCTRAC_ESTADO(boolean inCtrac_estado){
		this.myCtrac_estado = inCtrac_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTRAC_ESTADO(){
		return this.myCtrac_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtrac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTRAC_USUARIO_INSERT(String inCtrac_usuario_insert){
		this.myCtrac_usuario_insert = inCtrac_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTRAC_USUARIO_INSERT(){
		return this.myCtrac_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtrac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTRAC_USUARIO_UPDATE(String inCtrac_usuario_update){
		this.myCtrac_usuario_update = inCtrac_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTRAC_USUARIO_UPDATE(){
		return this.myCtrac_usuario_update;
	}

}
