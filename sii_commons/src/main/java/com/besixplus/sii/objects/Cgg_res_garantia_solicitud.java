package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_garantia_solicitud
* TABLA: GARANTIA SOLICITUD DE RESIDENCIA
* DESCRIPCION:ALMACENA INFORMACION DE LAS GARANTIAS QUE SE PUEDEN APLICAR A UN TIPO DE SOLICITUD DE RESIDENCIA
* ABREVIATURA:CRGTS
*/
public class Cgg_res_garantia_solicitud implements Serializable{
	private static final long serialVersionUID = 1163302365;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrgts_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrgrt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrgts_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrgts_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrgts_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_garantia_solicitud
	*/
	public Cgg_res_garantia_solicitud(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_garantia_solicitud
	* @param inCrgts_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrgts_estado ESTADO DEL REGISTRO
	* @param inCrgts_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrgts_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_garantia_solicitud(
		String inCrgts_codigo,
		String inCrgrt_codigo,
		String inCrtst_codigo,
		boolean inCrgts_estado,
		String inCrgts_usuario_insert,
		String inCrgts_usuario_update
	){
		this.setCRGTS_CODIGO(inCrgts_codigo);
		this.setCRGRT_CODIGO(inCrgrt_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRGTS_ESTADO(inCrgts_estado);
		this.setCRGTS_USUARIO_INSERT(inCrgts_usuario_insert);
		this.setCRGTS_USUARIO_UPDATE(inCrgts_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrgts_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRGTS_CODIGO(String inCrgts_codigo){
		this.myCrgts_codigo = inCrgts_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRGTS_CODIGO(){
		return this.myCrgts_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRGRT_CODIGO(String inCrgrt_codigo){
		this.myCrgrt_codigo = inCrgrt_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRGRT_CODIGO(){
		return this.myCrgrt_codigo;
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
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrgts_estado ESTADO DEL REGISTRO
	*/
	public void setCRGTS_ESTADO(boolean inCrgts_estado){
		this.myCrgts_estado = inCrgts_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRGTS_ESTADO(){
		return this.myCrgts_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrgts_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRGTS_USUARIO_INSERT(String inCrgts_usuario_insert){
		this.myCrgts_usuario_insert = inCrgts_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRGTS_USUARIO_INSERT(){
		return this.myCrgts_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrgts_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRGTS_USUARIO_UPDATE(String inCrgts_usuario_update){
		this.myCrgts_usuario_update = inCrgts_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRGTS_USUARIO_UPDATE(){
		return this.myCrgts_usuario_update;
	}

}
