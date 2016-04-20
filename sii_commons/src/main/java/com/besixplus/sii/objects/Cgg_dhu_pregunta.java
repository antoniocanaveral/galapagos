package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_pregunta
* TABLA: PREGUNTA
* DESCRIPCION:ALMACENA INFORMACION DE LAS PREGUNTAS QUE PUEDEN APLICARSE A UNA EVALUACION
* ABREVIATURA:CDPRG
*/
public class Cgg_dhu_pregunta implements Serializable{
	private static final long serialVersionUID = 954524766;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	private String myCdprg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	private String myCdcat_codigo;
	/**
	* DESCRIPCION DE LA PREGUNTA
	*/
	private String myCdprg_descripcion;
	/**
	* ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	*/
	private boolean myCdprg_cuantificable;
	/**
	* IDENTIFICA SI LA PREGUNTA ES DE SELECCION MULTIPLE O SI SOLO PUEDE ESCOGER SOLO UNA OPCION 
	*/
	private boolean myCdprg_multiple;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdprg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdprg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdprg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta
	*/
	public Cgg_dhu_pregunta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta
	* @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @param inCdprg_descripcion DESCRIPCION DE LA PREGUNTA
	* @param inCdprg_cuantificable ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	* @param inCdprg_multiple IDENTIFICA SI LA PREGUNTA ES DE SELECCION MULTIPLE O SI SOLO PUEDE ESCOGER SOLO UNA OPCION 
	* @param inCdprg_estado ESTADO DEL REGISTRO
	* @param inCdprg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdprg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_pregunta(
		String inCdprg_codigo,
		String inCdcat_codigo,
		String inCdprg_descripcion,
		boolean inCdprg_cuantificable,
		boolean inCdprg_multiple,
		boolean inCdprg_estado,
		String inCdprg_usuario_insert,
		String inCdprg_usuario_update
	){
		this.setCDPRG_CODIGO(inCdprg_codigo);
		this.setCDCAT_CODIGO(inCdcat_codigo);
		this.setCDPRG_DESCRIPCION(inCdprg_descripcion);
		this.setCDPRG_CUANTIFICABLE(inCdprg_cuantificable);
		this.setCDPRG_MULTIPLE(inCdprg_multiple);
		this.setCDPRG_ESTADO(inCdprg_estado);
		this.setCDPRG_USUARIO_INSERT(inCdprg_usuario_insert);
		this.setCDPRG_USUARIO_UPDATE(inCdprg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	public void setCDPRG_CODIGO(String inCdprg_codigo){
		this.myCdprg_codigo = inCdprg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	public String getCDPRG_CODIGO(){
		return this.myCdprg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	public void setCDCAT_CODIGO(String inCdcat_codigo){
		this.myCdcat_codigo = inCdcat_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	public String getCDCAT_CODIGO(){
		return this.myCdcat_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA PREGUNTA
	* @param inCdprg_descripcion DESCRIPCION DE LA PREGUNTA
	*/
	public void setCDPRG_DESCRIPCION(String inCdprg_descripcion){
		this.myCdprg_descripcion = inCdprg_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA PREGUNTA
	* @return String DESCRIPCION DE LA PREGUNTA
	*/
	public String getCDPRG_DESCRIPCION(){
		return this.myCdprg_descripcion;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	* @param inCdprg_cuantificable ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	*/
	public void setCDPRG_CUANTIFICABLE(boolean inCdprg_cuantificable){
		this.myCdprg_cuantificable = inCdprg_cuantificable;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	* @return boolean ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	*/
	public boolean getCDPRG_CUANTIFICABLE(){
		return this.myCdprg_cuantificable;
	}

	/**
	* ESTABLECE IDENTIFICA SI LA PREGUNTA ES DE SELECCION MULTIPLE O SI SOLO PUEDE ESCOGER SOLO UNA OPCION 
	* @param inCdprg_multiple IDENTIFICA SI LA PREGUNTA ES DE SELECCION MULTIPLE O SI SOLO PUEDE ESCOGER SOLO UNA OPCION 
	*/
	public void setCDPRG_MULTIPLE(boolean inCdprg_multiple){
		this.myCdprg_multiple = inCdprg_multiple;
	}
	/**
	* OBTIENE IDENTIFICA SI LA PREGUNTA ES DE SELECCION MULTIPLE O SI SOLO PUEDE ESCOGER SOLO UNA OPCION 
	* @return boolean IDENTIFICA SI LA PREGUNTA ES DE SELECCION MULTIPLE O SI SOLO PUEDE ESCOGER SOLO UNA OPCION 
	*/
	public boolean getCDPRG_MULTIPLE(){
		return this.myCdprg_multiple;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdprg_estado ESTADO DEL REGISTRO
	*/
	public void setCDPRG_ESTADO(boolean inCdprg_estado){
		this.myCdprg_estado = inCdprg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDPRG_ESTADO(){
		return this.myCdprg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdprg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDPRG_USUARIO_INSERT(String inCdprg_usuario_insert){
		this.myCdprg_usuario_insert = inCdprg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDPRG_USUARIO_INSERT(){
		return this.myCdprg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdprg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDPRG_USUARIO_UPDATE(String inCdprg_usuario_update){
		this.myCdprg_usuario_update = inCdprg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDPRG_USUARIO_UPDATE(){
		return this.myCdprg_usuario_update;
	}

}
