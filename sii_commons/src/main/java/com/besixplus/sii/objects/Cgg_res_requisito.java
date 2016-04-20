package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_requisito
* TABLA: REQUISITO TRAMITES DE RESIDENCIA
* DESCRIPCION:ALMACENA INFORMACION DE LOS REQUISITOS QUE SE APLICAN A LOS TRAMITES PARA SOLICITUD DE RESIDENCIA
* ABREVIATURA:CRREQ
*/
public class Cgg_res_requisito implements Serializable{
	private static final long serialVersionUID = 2117829796;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	*/
	private String myCrreq_codigo;
	/**
	* DESCRIPCION DEL REQUISITO
	*/
	private String myCrreq_descripcion;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCrreq_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrreq_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION
	*/
	private String myCrreq_usuario_insert;
	/**
	* USUARIO QUE ACTUALIZO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrreq_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_requisito
	*/
	public Cgg_res_requisito(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_requisito
	* @param inCrreq_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	* @param inCrreq_descripcion DESCRIPCION DEL REQUISITO
	* @param inCrreq_observacion INFORMACION ADICIONAL
	* @param inCrreq_estado ESTADO DEL REGISTRO
	* @param inCrreq_usuario_insert USUARIO QUE INGRESO LA INFORMACION
	* @param inCrreq_usuario_update USUARIO QUE ACTUALIZO LA INFORMACION EN EL SISTEMA
	*/
	public Cgg_res_requisito(
		String inCrreq_codigo,
		String inCrreq_descripcion,
		String inCrreq_observacion,
		boolean inCrreq_estado,
		String inCrreq_usuario_insert,
		String inCrreq_usuario_update
	){
		this.setCRREQ_CODIGO(inCrreq_codigo);
		this.setCRREQ_DESCRIPCION(inCrreq_descripcion);
		this.setCRREQ_OBSERVACION(inCrreq_observacion);
		this.setCRREQ_ESTADO(inCrreq_estado);
		this.setCRREQ_USUARIO_INSERT(inCrreq_usuario_insert);
		this.setCRREQ_USUARIO_UPDATE(inCrreq_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	* @param inCrreq_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	*/
	public void setCRREQ_CODIGO(String inCrreq_codigo){
		this.myCrreq_codigo = inCrreq_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	*/
	public String getCRREQ_CODIGO(){
		return this.myCrreq_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL REQUISITO
	* @param inCrreq_descripcion DESCRIPCION DEL REQUISITO
	*/
	public void setCRREQ_DESCRIPCION(String inCrreq_descripcion){
		this.myCrreq_descripcion = inCrreq_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL REQUISITO
	* @return String DESCRIPCION DEL REQUISITO
	*/
	public String getCRREQ_DESCRIPCION(){
		return this.myCrreq_descripcion;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCrreq_observacion INFORMACION ADICIONAL
	*/
	public void setCRREQ_OBSERVACION(String inCrreq_observacion){
		this.myCrreq_observacion = inCrreq_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCRREQ_OBSERVACION(){
		return this.myCrreq_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrreq_estado ESTADO DEL REGISTRO
	*/
	public void setCRREQ_ESTADO(boolean inCrreq_estado){
		this.myCrreq_estado = inCrreq_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRREQ_ESTADO(){
		return this.myCrreq_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION
	* @param inCrreq_usuario_insert USUARIO QUE INGRESO LA INFORMACION
	*/
	public void setCRREQ_USUARIO_INSERT(String inCrreq_usuario_insert){
		this.myCrreq_usuario_insert = inCrreq_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION
	* @return String USUARIO QUE INGRESO LA INFORMACION
	*/
	public String getCRREQ_USUARIO_INSERT(){
		return this.myCrreq_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE ACTUALIZO LA INFORMACION EN EL SISTEMA
	* @param inCrreq_usuario_update USUARIO QUE ACTUALIZO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRREQ_USUARIO_UPDATE(String inCrreq_usuario_update){
		this.myCrreq_usuario_update = inCrreq_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE ACTUALIZO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE ACTUALIZO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRREQ_USUARIO_UPDATE(){
		return this.myCrreq_usuario_update;
	}

}
