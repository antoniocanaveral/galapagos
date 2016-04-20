package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_pregunta_respuesta
* TABLA: PREGUNTA RESPUESTA
* DESCRIPCION:ALMACENA INFORMACION DE LAS RESPUESTAS VALIDAS COMO OPCION A UNA PREGUNTA
* ABREVIATURA:CDPRS
*/
public class Cgg_dhu_pregunta_respuesta implements Serializable{
	private static final long serialVersionUID = 1254437862;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA RESPUESTA
	*/
	private String myCdprs_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	private String myCdprg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	private String myCdres_codigo;
	/**
	* VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
	*/
	private int myCdprs_valoracion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdprs_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdprs_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdprs_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta_respuesta
	*/
	public Cgg_dhu_pregunta_respuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_pregunta_respuesta
	* @param inCdprs_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA RESPUESTA
	* @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @param inCdres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	* @param inCdprs_valoracion VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
	* @param inCdprs_estado ESTADO DEL REGISTRO
	* @param inCdprs_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdprs_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_pregunta_respuesta(
		String inCdprs_codigo,
		String inCdprg_codigo,
		String inCdres_codigo,
		int inCdprs_valoracion,
		boolean inCdprs_estado,
		String inCdprs_usuario_insert,
		String inCdprs_usuario_update
	){
		this.setCDPRS_CODIGO(inCdprs_codigo);
		this.setCDPRG_CODIGO(inCdprg_codigo);
		this.setCDRES_CODIGO(inCdres_codigo);
		this.setCDPRS_VALORACION(inCdprs_valoracion);
		this.setCDPRS_ESTADO(inCdprs_estado);
		this.setCDPRS_USUARIO_INSERT(inCdprs_usuario_insert);
		this.setCDPRS_USUARIO_UPDATE(inCdprs_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA RESPUESTA
	* @param inCdprs_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA RESPUESTA
	*/
	public void setCDPRS_CODIGO(String inCdprs_codigo){
		this.myCdprs_codigo = inCdprs_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA RESPUESTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA RESPUESTA
	*/
	public String getCDPRS_CODIGO(){
		return this.myCdprs_codigo;
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
	* ESTABLECE VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
	* @param inCdprs_valoracion VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
	*/
	public void setCDPRS_VALORACION(int inCdprs_valoracion){
		this.myCdprs_valoracion = inCdprs_valoracion;
	}
	/**
	* OBTIENE VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
	* @return int VALOR ASIGNADO A UNA RESPUESTA SOBRE UNA PREGUNTA
	*/
	public int getCDPRS_VALORACION(){
		return this.myCdprs_valoracion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdprs_estado ESTADO DEL REGISTRO
	*/
	public void setCDPRS_ESTADO(boolean inCdprs_estado){
		this.myCdprs_estado = inCdprs_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDPRS_ESTADO(){
		return this.myCdprs_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdprs_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDPRS_USUARIO_INSERT(String inCdprs_usuario_insert){
		this.myCdprs_usuario_insert = inCdprs_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDPRS_USUARIO_INSERT(){
		return this.myCdprs_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdprs_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDPRS_USUARIO_UPDATE(String inCdprs_usuario_update){
		this.myCdprs_usuario_update = inCdprs_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDPRS_USUARIO_UPDATE(){
		return this.myCdprs_usuario_update;
	}

}
