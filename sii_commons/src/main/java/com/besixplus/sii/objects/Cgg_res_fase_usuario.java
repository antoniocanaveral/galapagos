package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_fase_usuario
* TABLA: FASE USUARIO
* DESCRIPCION:ALMACENA INFORMACION DE LOS RESPONSABLES DE ATENDER CADA FASE EN EL CANTON
* ABREVIATURA:CRFSU
*/
public class Cgg_res_fase_usuario implements Serializable{
	private static final long serialVersionUID = 1996559106;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE UNA FASE CON SU USUARIO
	*/
	private String myCrfsu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	private String myCrfas_codigo;
	/**
	* DETERMINA SI EL USUARIO ASIGNADO A LA FASE SE HALLA APTO PARA ATENDERLA
	*/
	private boolean myCrfsu_activo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrfsu_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrfsu_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrfsu_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase_usuario
	*/
	public Cgg_res_fase_usuario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase_usuario
	* @param inCrfsu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE UNA FASE CON SU USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCrfsu_activo DETERMINA SI EL USUARIO ASIGNADO A LA FASE SE HALLA APTO PARA ATENDERLA
	* @param inCrfsu_estado ESTADO DEL REGISTRO
	* @param inCrfsu_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrfsu_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_fase_usuario(
		String inCrfsu_codigo,
		String inCusu_codigo,
		String inCrfas_codigo,
		boolean inCrfsu_activo,
		boolean inCrfsu_estado,
		String inCrfsu_usuario_insert,
		String inCrfsu_usuario_update
	){
		this.setCRFSU_CODIGO(inCrfsu_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRFAS_CODIGO(inCrfas_codigo);
		this.setCRFSU_ACTIVO(inCrfsu_activo);
		this.setCRFSU_ESTADO(inCrfsu_estado);
		this.setCRFSU_USUARIO_INSERT(inCrfsu_usuario_insert);
		this.setCRFSU_USUARIO_UPDATE(inCrfsu_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE UNA FASE CON SU USUARIO
	* @param inCrfsu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE UNA FASE CON SU USUARIO
	*/
	public void setCRFSU_CODIGO(String inCrfsu_codigo){
		this.myCrfsu_codigo = inCrfsu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE UNA FASE CON SU USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE UNA FASE CON SU USUARIO
	*/
	public String getCRFSU_CODIGO(){
		return this.myCrfsu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
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
	* ESTABLECE DETERMINA SI EL USUARIO ASIGNADO A LA FASE SE HALLA APTO PARA ATENDERLA
	* @param inCrfsu_activo DETERMINA SI EL USUARIO ASIGNADO A LA FASE SE HALLA APTO PARA ATENDERLA
	*/
	public void setCRFSU_ACTIVO(boolean inCrfsu_activo){
		this.myCrfsu_activo = inCrfsu_activo;
	}
	/**
	* OBTIENE DETERMINA SI EL USUARIO ASIGNADO A LA FASE SE HALLA APTO PARA ATENDERLA
	* @return boolean DETERMINA SI EL USUARIO ASIGNADO A LA FASE SE HALLA APTO PARA ATENDERLA
	*/
	public boolean getCRFSU_ACTIVO(){
		return this.myCrfsu_activo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrfsu_estado ESTADO DEL REGISTRO
	*/
	public void setCRFSU_ESTADO(boolean inCrfsu_estado){
		this.myCrfsu_estado = inCrfsu_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRFSU_ESTADO(){
		return this.myCrfsu_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrfsu_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRFSU_USUARIO_INSERT(String inCrfsu_usuario_insert){
		this.myCrfsu_usuario_insert = inCrfsu_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRFSU_USUARIO_INSERT(){
		return this.myCrfsu_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrfsu_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRFSU_USUARIO_UPDATE(String inCrfsu_usuario_update){
		this.myCrfsu_usuario_update = inCrfsu_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRFSU_USUARIO_UPDATE(){
		return this.myCrfsu_usuario_update;
	}

}
