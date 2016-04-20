package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_registro_encuesta
* TABLA: REGISTRO ENCUESTA
* DESCRIPCION:ALMACENA INFORMACION DE LA ENCUESTA  APLICADA
* ABREVIATURA:CDRGE
*/
public class Cgg_dhu_registro_encuesta implements Serializable{
	private static final long serialVersionUID = 378183191;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	*/
	private String myCdrge_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	private String myCdprg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	private String myCdres_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	*/
	private String myCdape_codigo;
	/**
	* REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	*/
	private String myCdrge_respuesta_abierta;
	/**
	* FECHA DE REGISTRO DE LA  ENCUESTA
	*/
	private java.util.Date myCdrge_fecha_registro;
	/**
	* OBSERVACION DE LA ENCUESTA
	*/
	private String myCdrge_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdrge_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdrge_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdrge_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_registro_encuesta
	*/
	public Cgg_dhu_registro_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_registro_encuesta
	* @param inCdrge_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	* @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @param inCdres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @param inCdape_codigo IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	* @param inCdrge_respuesta_abierta REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	* @param inCdrge_fecha_registro FECHA DE REGISTRO DE LA  ENCUESTA
	* @param inCdrge_observacion OBSERVACION DE LA ENCUESTA
	* @param inCdrge_estado ESTADO DEL REGISTRO
	* @param inCdrge_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdrge_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_registro_encuesta(
		String inCdrge_codigo,
		String inCdprg_codigo,
		String inCdres_codigo,
		String inCdape_codigo,
		String inCdrge_respuesta_abierta,
		java.util.Date inCdrge_fecha_registro,
		String inCdrge_observacion,
		boolean inCdrge_estado,
		String inCdrge_usuario_insert,
		String inCdrge_usuario_update
	){
		this.setCDRGE_CODIGO(inCdrge_codigo);
		this.setCDPRG_CODIGO(inCdprg_codigo);
		this.setCDRES_CODIGO(inCdres_codigo);
		this.setCDAPE_CODIGO(inCdape_codigo);
		this.setCDRGE_RESPUESTA_ABIERTA(inCdrge_respuesta_abierta);
		this.setCDRGE_FECHA_REGISTRO(inCdrge_fecha_registro);
		this.setCDRGE_OBSERVACION(inCdrge_observacion);
		this.setCDRGE_ESTADO(inCdrge_estado);
		this.setCDRGE_USUARIO_INSERT(inCdrge_usuario_insert);
		this.setCDRGE_USUARIO_UPDATE(inCdrge_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	* @param inCdrge_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	*/
	public void setCDRGE_CODIGO(String inCdrge_codigo){
		this.myCdrge_codigo = inCdrge_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	*/
	public String getCDRGE_CODIGO(){
		return this.myCdrge_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @param inCdres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	public void setCDRES_CODIGO(String inCdres_codigo){
		this.myCdres_codigo = inCdres_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	public String getCDRES_CODIGO(){
		return this.myCdres_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	* @param inCdape_codigo IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	*/
	public void setCDAPE_CODIGO(String inCdape_codigo){
		this.myCdape_codigo = inCdape_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	*/
	public String getCDAPE_CODIGO(){
		return this.myCdape_codigo;
	}

	/**
	* ESTABLECE REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	* @param inCdrge_respuesta_abierta REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	*/
	public void setCDRGE_RESPUESTA_ABIERTA(String inCdrge_respuesta_abierta){
		this.myCdrge_respuesta_abierta = inCdrge_respuesta_abierta;
	}
	/**
	* OBTIENE REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	* @return String REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	*/
	public String getCDRGE_RESPUESTA_ABIERTA(){
		return this.myCdrge_respuesta_abierta;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DE LA  ENCUESTA
	* @param inCdrge_fecha_registro FECHA DE REGISTRO DE LA  ENCUESTA
	*/
	public void setCDRGE_FECHA_REGISTRO(java.util.Date inCdrge_fecha_registro){
		this.myCdrge_fecha_registro = inCdrge_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DE LA  ENCUESTA
	* @return java.util.Date FECHA DE REGISTRO DE LA  ENCUESTA
	*/
	public java.util.Date getCDRGE_FECHA_REGISTRO(){
		return this.myCdrge_fecha_registro;
	}

	/**
	* ESTABLECE OBSERVACION DE LA ENCUESTA
	* @param inCdrge_observacion OBSERVACION DE LA ENCUESTA
	*/
	public void setCDRGE_OBSERVACION(String inCdrge_observacion){
		this.myCdrge_observacion = inCdrge_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA ENCUESTA
	* @return String OBSERVACION DE LA ENCUESTA
	*/
	public String getCDRGE_OBSERVACION(){
		return this.myCdrge_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdrge_estado ESTADO DEL REGISTRO
	*/
	public void setCDRGE_ESTADO(boolean inCdrge_estado){
		this.myCdrge_estado = inCdrge_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDRGE_ESTADO(){
		return this.myCdrge_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdrge_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDRGE_USUARIO_INSERT(String inCdrge_usuario_insert){
		this.myCdrge_usuario_insert = inCdrge_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDRGE_USUARIO_INSERT(){
		return this.myCdrge_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdrge_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDRGE_USUARIO_UPDATE(String inCdrge_usuario_update){
		this.myCdrge_usuario_update = inCdrge_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDRGE_USUARIO_UPDATE(){
		return this.myCdrge_usuario_update;
	}

}
