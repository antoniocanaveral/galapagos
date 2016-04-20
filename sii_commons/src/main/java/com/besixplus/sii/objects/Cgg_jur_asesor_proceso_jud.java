package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_asesor_proceso_jud
* TABLA: ASESOR_PROCESO JUDICIAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS ASESORES JUDICIALES ASIGNADOS A UN PROCESO JUDICIAL
* ABREVIATURA:CJASP
*/
public class Cgg_jur_asesor_proceso_jud implements Serializable{
	private static final long serialVersionUID = 998121566;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCjasp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	*/
	private String myCjpju_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
	*/
	private boolean myCjasp_activo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjasp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjasp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjasp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor_proceso_jud
	*/
	public Cgg_jur_asesor_proceso_jud(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor_proceso_jud
	* @param inCjasp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCjasp_activo ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
	* @param inCjasp_estado ESTADO DEL REGISTRO
	* @param inCjasp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjasp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_asesor_proceso_jud(
		String inCjasp_codigo,
		String inCjpju_codigo,
		String inCusu_codigo,
		boolean inCjasp_activo,
		boolean inCjasp_estado,
		String inCjasp_usuario_insert,
		String inCjasp_usuario_update
	){
		this.setCJASP_CODIGO(inCjasp_codigo);
		this.setCJPJU_CODIGO(inCjpju_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCJASP_ACTIVO(inCjasp_activo);
		this.setCJASP_ESTADO(inCjasp_estado);
		this.setCJASP_USUARIO_INSERT(inCjasp_usuario_insert);
		this.setCJASP_USUARIO_UPDATE(inCjasp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCjasp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCJASP_CODIGO(String inCjasp_codigo){
		this.myCjasp_codigo = inCjasp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCJASP_CODIGO(){
		return this.myCjasp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	*/
	public void setCJPJU_CODIGO(String inCjpju_codigo){
		this.myCjpju_codigo = inCjpju_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	*/
	public String getCJPJU_CODIGO(){
		return this.myCjpju_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
	* @param inCjasp_activo ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
	*/
	public void setCJASP_ACTIVO(boolean inCjasp_activo){
		this.myCjasp_activo = inCjasp_activo;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
	* @return boolean ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
	*/
	public boolean getCJASP_ACTIVO(){
		return this.myCjasp_activo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjasp_estado ESTADO DEL REGISTRO
	*/
	public void setCJASP_ESTADO(boolean inCjasp_estado){
		this.myCjasp_estado = inCjasp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJASP_ESTADO(){
		return this.myCjasp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjasp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJASP_USUARIO_INSERT(String inCjasp_usuario_insert){
		this.myCjasp_usuario_insert = inCjasp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJASP_USUARIO_INSERT(){
		return this.myCjasp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjasp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJASP_USUARIO_UPDATE(String inCjasp_usuario_update){
		this.myCjasp_usuario_update = inCjasp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJASP_USUARIO_UPDATE(){
		return this.myCjasp_usuario_update;
	}

}
