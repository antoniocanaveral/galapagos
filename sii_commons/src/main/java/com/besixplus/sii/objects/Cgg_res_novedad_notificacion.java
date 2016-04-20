package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_novedad_notificacion
* TABLA: NOVEDAD NOTIFICACION 
* DESCRIPCION:ALMACENA INFORMACION DE LAS NOVEDADES A SER RESUELTAS POR EL SOLICITANTE DE UN TRAMITE 
* ABREVIATURA:CRNOV
*/
public class Cgg_res_novedad_notificacion implements Serializable{
	private static final long serialVersionUID = 1364757699;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrnov_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	private String myCrseg_codigo;
	/**
	* FECHA DE REGISTRO DE LA NOVEDAD
	*/
	private java.util.Date myCrnov_fecha_registro;
	/**
	* DESCRIPCION DE LA NOVEDAD
	*/
	private String myCrnov_descripcion;
	/**
	* TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	*/
	private int myCrnov_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrnov_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrnov_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrnov_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_novedad_notificacion
	*/
	public Cgg_res_novedad_notificacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_novedad_notificacion
	* @param inCrnov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrnov_fecha_registro FECHA DE REGISTRO DE LA NOVEDAD
	* @param inCrnov_descripcion DESCRIPCION DE LA NOVEDAD
	* @param inCrnov_tipo TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	* @param inCrnov_estado ESTADO DEL REGISTRO
	* @param inCrnov_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrnov_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_novedad_notificacion(
		String inCrnov_codigo,
		String inCrseg_codigo,
		java.util.Date inCrnov_fecha_registro,
		String inCrnov_descripcion,
		int inCrnov_tipo,
		boolean inCrnov_estado,
		String inCrnov_usuario_insert,
		String inCrnov_usuario_update
	){
		this.setCRNOV_CODIGO(inCrnov_codigo);
		this.setCRSEG_CODIGO(inCrseg_codigo);
		this.setCRNOV_FECHA_REGISTRO(inCrnov_fecha_registro);
		this.setCRNOV_DESCRIPCION(inCrnov_descripcion);
		this.setCRNOV_TIPO(inCrnov_tipo);
		this.setCRNOV_ESTADO(inCrnov_estado);
		this.setCRNOV_USUARIO_INSERT(inCrnov_usuario_insert);
		this.setCRNOV_USUARIO_UPDATE(inCrnov_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrnov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRNOV_CODIGO(String inCrnov_codigo){
		this.myCrnov_codigo = inCrnov_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRNOV_CODIGO(){
		return this.myCrnov_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	public void setCRSEG_CODIGO(String inCrseg_codigo){
		this.myCrseg_codigo = inCrseg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	public String getCRSEG_CODIGO(){
		return this.myCrseg_codigo;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DE LA NOVEDAD
	* @param inCrnov_fecha_registro FECHA DE REGISTRO DE LA NOVEDAD
	*/
	public void setCRNOV_FECHA_REGISTRO(java.util.Date inCrnov_fecha_registro){
		this.myCrnov_fecha_registro = inCrnov_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DE LA NOVEDAD
	* @return java.util.Date FECHA DE REGISTRO DE LA NOVEDAD
	*/
	public java.util.Date getCRNOV_FECHA_REGISTRO(){
		return this.myCrnov_fecha_registro;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA NOVEDAD
	* @param inCrnov_descripcion DESCRIPCION DE LA NOVEDAD
	*/
	public void setCRNOV_DESCRIPCION(String inCrnov_descripcion){
		this.myCrnov_descripcion = inCrnov_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA NOVEDAD
	* @return String DESCRIPCION DE LA NOVEDAD
	*/
	public String getCRNOV_DESCRIPCION(){
		return this.myCrnov_descripcion;
	}

	/**
	* ESTABLECE TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	* @param inCrnov_tipo TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	*/
	public void setCRNOV_TIPO(int inCrnov_tipo){
		this.myCrnov_tipo = inCrnov_tipo;
	}
	/**
	* OBTIENE TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	* @return int TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	*/
	public int getCRNOV_TIPO(){
		return this.myCrnov_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrnov_estado ESTADO DEL REGISTRO
	*/
	public void setCRNOV_ESTADO(boolean inCrnov_estado){
		this.myCrnov_estado = inCrnov_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRNOV_ESTADO(){
		return this.myCrnov_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrnov_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRNOV_USUARIO_INSERT(String inCrnov_usuario_insert){
		this.myCrnov_usuario_insert = inCrnov_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRNOV_USUARIO_INSERT(){
		return this.myCrnov_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrnov_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRNOV_USUARIO_UPDATE(String inCrnov_usuario_update){
		this.myCrnov_usuario_update = inCrnov_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRNOV_USUARIO_UPDATE(){
		return this.myCrnov_usuario_update;
	}

}
