package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_criterio
* TABLA: CRITERIO 
* DESCRIPCION:ALMACENA INFORMACION DE LOS CRITERIOS  APLICADOS A LOS TRAMITES
* ABREVIATURA:CJCRI
*/
public class Cgg_jur_criterio implements Serializable{
	private static final long serialVersionUID = 778697992;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCjcri_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	private String myCrfas_codigo;
	/**
	* INFORMACION A SER VERIFICADA
	*/
	private String myCjcri_requerimiento;
	/**
	* EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
	*/
	private boolean myCjcri_requerido;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjcri_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjcri_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjcri_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_criterio
	*/
	public Cgg_jur_criterio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_criterio
	* @param inCjcri_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCjcri_requerimiento INFORMACION A SER VERIFICADA
	* @param inCjcri_requerido EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
	* @param inCjcri_estado ESTADO DEL REGISTRO
	* @param inCjcri_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjcri_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_criterio(
		String inCjcri_codigo,
		String inCrfas_codigo,
		String inCjcri_requerimiento,
		boolean inCjcri_requerido,
		boolean inCjcri_estado,
		String inCjcri_usuario_insert,
		String inCjcri_usuario_update
	){
		this.setCJCRI_CODIGO(inCjcri_codigo);
		this.setCRFAS_CODIGO(inCrfas_codigo);
		this.setCJCRI_REQUERIMIENTO(inCjcri_requerimiento);
		this.setCJCRI_REQUERIDO(inCjcri_requerido);
		this.setCJCRI_ESTADO(inCjcri_estado);
		this.setCJCRI_USUARIO_INSERT(inCjcri_usuario_insert);
		this.setCJCRI_USUARIO_UPDATE(inCjcri_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCjcri_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCJCRI_CODIGO(String inCjcri_codigo){
		this.myCjcri_codigo = inCjcri_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCJCRI_CODIGO(){
		return this.myCjcri_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	public void setCRFAS_CODIGO(String inCrfas_codigo){
		this.myCrfas_codigo = inCrfas_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	public String getCRFAS_CODIGO(){
		return this.myCrfas_codigo;
	}

	/**
	* ESTABLECE INFORMACION A SER VERIFICADA
	* @param inCjcri_requerimiento INFORMACION A SER VERIFICADA
	*/
	public void setCJCRI_REQUERIMIENTO(String inCjcri_requerimiento){
		this.myCjcri_requerimiento = inCjcri_requerimiento;
	}
	/**
	* OBTIENE INFORMACION A SER VERIFICADA
	* @return String INFORMACION A SER VERIFICADA
	*/
	public String getCJCRI_REQUERIMIENTO(){
		return this.myCjcri_requerimiento;
	}

	/**
	* ESTABLECE EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
	* @param inCjcri_requerido EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
	*/
	public void setCJCRI_REQUERIDO(boolean inCjcri_requerido){
		this.myCjcri_requerido = inCjcri_requerido;
	}
	/**
	* OBTIENE EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
	* @return boolean EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
	*/
	public boolean getCJCRI_REQUERIDO(){
		return this.myCjcri_requerido;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjcri_estado ESTADO DEL REGISTRO
	*/
	public void setCJCRI_ESTADO(boolean inCjcri_estado){
		this.myCjcri_estado = inCjcri_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJCRI_ESTADO(){
		return this.myCjcri_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjcri_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJCRI_USUARIO_INSERT(String inCjcri_usuario_insert){
		this.myCjcri_usuario_insert = inCjcri_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJCRI_USUARIO_INSERT(){
		return this.myCjcri_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjcri_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJCRI_USUARIO_UPDATE(String inCjcri_usuario_update){
		this.myCjcri_usuario_update = inCjcri_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJCRI_USUARIO_UPDATE(){
		return this.myCjcri_usuario_update;
	}

}
