package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_grupo_actividad
* TABLA:  GRUPO ACTIVIDAD
* DESCRIPCION:ALMACENA INFORMACION DE DE LAS ACTIVIDADES QUE VA A CUMPLIR UN GRUPO DE TURISTAS
* ABREVIATURA:CTGAC
*/
public class Cgg_tct_grupo_actividad implements Serializable{
	private static final long serialVersionUID = 575830620;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtgac_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtgtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	private String myCtact_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtgac_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtgac_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtgac_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_actividad
	*/
	public Cgg_tct_grupo_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_actividad
	* @param inCtgac_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCtgac_estado ESTADO DEL REGISTRO
	* @param inCtgac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtgac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_grupo_actividad(
		String inCtgac_codigo,
		String inCtgtr_codigo,
		String inCtact_codigo,
		boolean inCtgac_estado,
		String inCtgac_usuario_insert,
		String inCtgac_usuario_update
	){
		this.setCTGAC_CODIGO(inCtgac_codigo);
		this.setCTGTR_CODIGO(inCtgtr_codigo);
		this.setCTACT_CODIGO(inCtact_codigo);
		this.setCTGAC_ESTADO(inCtgac_estado);
		this.setCTGAC_USUARIO_INSERT(inCtgac_usuario_insert);
		this.setCTGAC_USUARIO_UPDATE(inCtgac_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtgac_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTGAC_CODIGO(String inCtgac_codigo){
		this.myCtgac_codigo = inCtgac_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTGAC_CODIGO(){
		return this.myCtgac_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTGTR_CODIGO(String inCtgtr_codigo){
		this.myCtgtr_codigo = inCtgtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTGTR_CODIGO(){
		return this.myCtgtr_codigo;
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
	* @param inCtgac_estado ESTADO DEL REGISTRO
	*/
	public void setCTGAC_ESTADO(boolean inCtgac_estado){
		this.myCtgac_estado = inCtgac_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTGAC_ESTADO(){
		return this.myCtgac_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtgac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTGAC_USUARIO_INSERT(String inCtgac_usuario_insert){
		this.myCtgac_usuario_insert = inCtgac_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTGAC_USUARIO_INSERT(){
		return this.myCtgac_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtgac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTGAC_USUARIO_UPDATE(String inCtgac_usuario_update){
		this.myCtgac_usuario_update = inCtgac_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTGAC_USUARIO_UPDATE(){
		return this.myCtgac_usuario_update;
	}

}
