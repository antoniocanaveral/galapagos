package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_adjunto_proceso
* TABLA: ADJUNTO PROCESO
* DESCRIPCION:ALMACENA INFORMACION DE LOS ARCHIVOS DIGITALES ANEXOS A LOS PROCESOS JUDICIALES
* ABREVIATURA:CJADP
*/
public class Cgg_jur_adjunto_proceso implements Serializable{
	private static final long serialVersionUID = 166261924;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
	*/
	private String myCjadp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	private String myCjpju_codigo;
	/**
	* DESCRIP`CION DEL ARCHIVO ADJUNTO
	*/
	private String myCjadp_descripcion;
	/**
	* FECHA DE REGISTRO DEL ADJUNTO
	*/
	private java.util.Date myCjhtp_fecha_registro;
	/**
	* NOMBRE DEL ADJUNTO
	*/
	private String myCjadp_nombre_adjunto;
	/**
	* ARCHIVO DIGITAL 
	*/
	private byte[] myCjadp_adjunto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjadp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjadp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjadp_usuario_update;
	/**
	* IDENTIFICATIVO DEL LA TABLA HISTORIAL PROCESO

	*/
	private String myCjhtp_codigo;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_proceso
	*/
	public Cgg_jur_adjunto_proceso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_proceso
	* @param inCjadp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCjadp_descripcion DESCRIP`CION DEL ARCHIVO ADJUNTO
	* @param inCjhtp_fecha_registro FECHA DE REGISTRO DEL ADJUNTO
	* @param inCjadp_nombre_adjunto NOMBRE DEL ADJUNTO
	* @param inCjadp_adjunto ARCHIVO DIGITAL 
	* @param inCjadp_estado ESTADO DEL REGISTRO
	* @param inCjadp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjadp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjhtp_codigo IDENTIFICATIVO DEL LA TABLA HISTORIAL PROCESO

	*/
	public Cgg_jur_adjunto_proceso(
		String inCjadp_codigo,
		String inCjpju_codigo,
		String inCjadp_descripcion,
		java.util.Date inCjhtp_fecha_registro,
		String inCjadp_nombre_adjunto,
		byte[] inCjadp_adjunto,
		boolean inCjadp_estado,
		String inCjadp_usuario_insert,
		String inCjadp_usuario_update,
		String inCjhtp_codigo
	){
		this.setCJADP_CODIGO(inCjadp_codigo);
		this.setCJPJU_CODIGO(inCjpju_codigo);
		this.setCJADP_DESCRIPCION(inCjadp_descripcion);
		this.setCJHTP_FECHA_REGISTRO(inCjhtp_fecha_registro);
		this.setCJADP_NOMBRE_ADJUNTO(inCjadp_nombre_adjunto);
		this.setCJADP_ADJUNTO(inCjadp_adjunto);
		this.setCJADP_ESTADO(inCjadp_estado);
		this.setCJADP_USUARIO_INSERT(inCjadp_usuario_insert);
		this.setCJADP_USUARIO_UPDATE(inCjadp_usuario_update);
		this.setCJHTP_CODIGO(inCjhtp_codigo);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
	* @param inCjadp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
	*/
	public void setCJADP_CODIGO(String inCjadp_codigo){
		this.myCjadp_codigo = inCjadp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
	*/
	public String getCJADP_CODIGO(){
		return this.myCjadp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	public void setCJPJU_CODIGO(String inCjpju_codigo){
		this.myCjpju_codigo = inCjpju_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	public String getCJPJU_CODIGO(){
		return this.myCjpju_codigo;
	}

	/**
	* ESTABLECE DESCRIP`CION DEL ARCHIVO ADJUNTO
	* @param inCjadp_descripcion DESCRIP`CION DEL ARCHIVO ADJUNTO
	*/
	public void setCJADP_DESCRIPCION(String inCjadp_descripcion){
		this.myCjadp_descripcion = inCjadp_descripcion;
	}
	/**
	* OBTIENE DESCRIP`CION DEL ARCHIVO ADJUNTO
	* @return String DESCRIP`CION DEL ARCHIVO ADJUNTO
	*/
	public String getCJADP_DESCRIPCION(){
		return this.myCjadp_descripcion;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DEL ADJUNTO
	* @param inCjhtp_fecha_registro FECHA DE REGISTRO DEL ADJUNTO
	*/
	public void setCJHTP_FECHA_REGISTRO(java.util.Date inCjhtp_fecha_registro){
		this.myCjhtp_fecha_registro = inCjhtp_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DEL ADJUNTO
	* @return java.util.Date FECHA DE REGISTRO DEL ADJUNTO
	*/
	public java.util.Date getCJHTP_FECHA_REGISTRO(){
		return this.myCjhtp_fecha_registro;
	}

	/**
	* ESTABLECE NOMBRE DEL ADJUNTO
	* @param inCjadp_nombre_adjunto NOMBRE DEL ADJUNTO
	*/
	public void setCJADP_NOMBRE_ADJUNTO(String inCjadp_nombre_adjunto){
		this.myCjadp_nombre_adjunto = inCjadp_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL ADJUNTO
	* @return String NOMBRE DEL ADJUNTO
	*/
	public String getCJADP_NOMBRE_ADJUNTO(){
		return this.myCjadp_nombre_adjunto;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL 
	* @param inCjadp_adjunto ARCHIVO DIGITAL 
	*/
	public void setCJADP_ADJUNTO(byte[] inCjadp_adjunto){
		this.myCjadp_adjunto = inCjadp_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL 
	* @return byte[] ARCHIVO DIGITAL 
	*/
	public byte[] getCJADP_ADJUNTO(){
		return this.myCjadp_adjunto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjadp_estado ESTADO DEL REGISTRO
	*/
	public void setCJADP_ESTADO(boolean inCjadp_estado){
		this.myCjadp_estado = inCjadp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJADP_ESTADO(){
		return this.myCjadp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjadp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJADP_USUARIO_INSERT(String inCjadp_usuario_insert){
		this.myCjadp_usuario_insert = inCjadp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJADP_USUARIO_INSERT(){
		return this.myCjadp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjadp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJADP_USUARIO_UPDATE(String inCjadp_usuario_update){
		this.myCjadp_usuario_update = inCjadp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJADP_USUARIO_UPDATE(){
		return this.myCjadp_usuario_update;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DEL LA TABLA HISTORIAL PROCESO

	* @param inCjhtp_codigo IDENTIFICATIVO DEL LA TABLA HISTORIAL PROCESO

	*/
	public void setCJHTP_CODIGO(String inCjhtp_codigo){
		this.myCjhtp_codigo = inCjhtp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO DEL LA TABLA HISTORIAL PROCESO

	* @return String IDENTIFICATIVO DEL LA TABLA HISTORIAL PROCESO

	*/
	public String getCJHTP_CODIGO(){
		return this.myCjhtp_codigo;
	}

}
