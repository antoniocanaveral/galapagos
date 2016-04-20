package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_adjunto_personal
* TABLA: ADJUNTO PERSONAL
* DESCRIPCION:ALMACENA INFORMACION DIGITAL PRIVADA DE LA PERSONA 
* ABREVIATURA:CRADP
*/
public class Cgg_res_adjunto_personal implements Serializable{
	private static final long serialVersionUID = 833654810;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCradp_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* FECHA DE RESGITRO DEL ADJUNTO
	*/
	private java.util.Date myCradp_fecha_registro;
	/**
	* DESCRIPCION DEL ARCHIVO ADJUNTO
	*/
	private String myCradp_descripcion;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCradp_nombre_adjunto;
	/**
	* ARCHIVO DIGITAL ANEXO
	*/
	private byte[] myCradp_adjunto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCradp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCradp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCradp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto_personal
	*/
	public Cgg_res_adjunto_personal(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto_personal
	* @param inCradp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCradp_fecha_registro FECHA DE RESGITRO DEL ADJUNTO
	* @param inCradp_descripcion DESCRIPCION DEL ARCHIVO ADJUNTO
	* @param inCradp_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCradp_adjunto ARCHIVO DIGITAL ANEXO
	* @param inCradp_estado ESTADO DEL REGISTRO
	* @param inCradp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCradp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_adjunto_personal(
		String inCradp_codigo,
		String inCrper_codigo,
		java.util.Date inCradp_fecha_registro,
		String inCradp_descripcion,
		String inCradp_nombre_adjunto,
		byte[] inCradp_adjunto,
		boolean inCradp_estado,
		String inCradp_usuario_insert,
		String inCradp_usuario_update
	){
		this.setCRADP_CODIGO(inCradp_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRADP_FECHA_REGISTRO(inCradp_fecha_registro);
		this.setCRADP_DESCRIPCION(inCradp_descripcion);
		this.setCRADP_NOMBRE_ADJUNTO(inCradp_nombre_adjunto);
		this.setCRADP_ADJUNTO(inCradp_adjunto);
		this.setCRADP_ESTADO(inCradp_estado);
		this.setCRADP_USUARIO_INSERT(inCradp_usuario_insert);
		this.setCRADP_USUARIO_UPDATE(inCradp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCradp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRADP_CODIGO(String inCradp_codigo){
		this.myCradp_codigo = inCradp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRADP_CODIGO(){
		return this.myCradp_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE FECHA DE RESGITRO DEL ADJUNTO
	* @param inCradp_fecha_registro FECHA DE RESGITRO DEL ADJUNTO
	*/
	public void setCRADP_FECHA_REGISTRO(java.util.Date inCradp_fecha_registro){
		this.myCradp_fecha_registro = inCradp_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE RESGITRO DEL ADJUNTO
	* @return java.util.Date FECHA DE RESGITRO DEL ADJUNTO
	*/
	public java.util.Date getCRADP_FECHA_REGISTRO(){
		return this.myCradp_fecha_registro;
	}

	/**
	* ESTABLECE DESCRIPCION DEL ARCHIVO ADJUNTO
	* @param inCradp_descripcion DESCRIPCION DEL ARCHIVO ADJUNTO
	*/
	public void setCRADP_DESCRIPCION(String inCradp_descripcion){
		this.myCradp_descripcion = inCradp_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL ARCHIVO ADJUNTO
	* @return String DESCRIPCION DEL ARCHIVO ADJUNTO
	*/
	public String getCRADP_DESCRIPCION(){
		return this.myCradp_descripcion;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCradp_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCRADP_NOMBRE_ADJUNTO(String inCradp_nombre_adjunto){
		this.myCradp_nombre_adjunto = inCradp_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCRADP_NOMBRE_ADJUNTO(){
		return this.myCradp_nombre_adjunto;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL ANEXO
	* @param inCradp_adjunto ARCHIVO DIGITAL ANEXO
	*/
	public void setCRADP_ADJUNTO(byte[] inCradp_adjunto){
		this.myCradp_adjunto = inCradp_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL ANEXO
	* @return byte[] ARCHIVO DIGITAL ANEXO
	*/
	public byte[] getCRADP_ADJUNTO(){
		return this.myCradp_adjunto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCradp_estado ESTADO DEL REGISTRO
	*/
	public void setCRADP_ESTADO(boolean inCradp_estado){
		this.myCradp_estado = inCradp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRADP_ESTADO(){
		return this.myCradp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCradp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRADP_USUARIO_INSERT(String inCradp_usuario_insert){
		this.myCradp_usuario_insert = inCradp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRADP_USUARIO_INSERT(){
		return this.myCradp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCradp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRADP_USUARIO_UPDATE(String inCradp_usuario_update){
		this.myCradp_usuario_update = inCradp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRADP_USUARIO_UPDATE(){
		return this.myCradp_usuario_update;
	}

}
