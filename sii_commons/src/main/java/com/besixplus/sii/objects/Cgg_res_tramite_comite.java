package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tramite_comite
* TABLA: TRAMITE COMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE TRAMITES QUE PUEDEN TRATARSE EN UN COMITE
* ABREVIATURA:CRTRC
*/
public class Cgg_res_tramite_comite implements Serializable{
	private static final long serialVersionUID = 897229733;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE COMITE
	*/
	private String myCrtrc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrcom_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtrc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtrc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtrc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite_comite
	*/
	public Cgg_res_tramite_comite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite_comite
	* @param inCrtrc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE COMITE
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtrc_estado ESTADO DEL REGISTRO
	* @param inCrtrc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtrc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tramite_comite(
		String inCrtrc_codigo,
		String inCrtst_codigo,
		String inCrcom_codigo,
		boolean inCrtrc_estado,
		String inCrtrc_usuario_insert,
		String inCrtrc_usuario_update
	){
		this.setCRTRC_CODIGO(inCrtrc_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRCOM_CODIGO(inCrcom_codigo);
		this.setCRTRC_ESTADO(inCrtrc_estado);
		this.setCRTRC_USUARIO_INSERT(inCrtrc_usuario_insert);
		this.setCRTRC_USUARIO_UPDATE(inCrtrc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE COMITE
	* @param inCrtrc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE COMITE
	*/
	public void setCRTRC_CODIGO(String inCrtrc_codigo){
		this.myCrtrc_codigo = inCrtrc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE COMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE COMITE
	*/
	public String getCRTRC_CODIGO(){
		return this.myCrtrc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	public void setCRTST_CODIGO(String inCrtst_codigo){
		this.myCrtst_codigo = inCrtst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	public String getCRTST_CODIGO(){
		return this.myCrtst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRCOM_CODIGO(String inCrcom_codigo){
		this.myCrcom_codigo = inCrcom_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRCOM_CODIGO(){
		return this.myCrcom_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtrc_estado ESTADO DEL REGISTRO
	*/
	public void setCRTRC_ESTADO(boolean inCrtrc_estado){
		this.myCrtrc_estado = inCrtrc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTRC_ESTADO(){
		return this.myCrtrc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtrc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTRC_USUARIO_INSERT(String inCrtrc_usuario_insert){
		this.myCrtrc_usuario_insert = inCrtrc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTRC_USUARIO_INSERT(){
		return this.myCrtrc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtrc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTRC_USUARIO_UPDATE(String inCrtrc_usuario_update){
		this.myCrtrc_usuario_update = inCrtrc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTRC_USUARIO_UPDATE(){
		return this.myCrtrc_usuario_update;
	}

}
