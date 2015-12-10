package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_sadjunto
* TABLA: SEGUIMIENTO ADJUNTO
* DESCRIPCION:ALMACENA INFORMACION DE LA INFORMACION DIGITALIZADA QUE RESPALDAN EL SEGUIMIENTO
* ABREVIATURA:CDSAD
*/
public class Cgg_dhu_sadjunto implements Serializable{
	private static final long serialVersionUID = 1915750529;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
	*/
	private String myCdsad_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	private String myCdacd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCdbcr_codigo;
	/**
	* FECHA DE REGISTRO DEL ADJUNTO
	*/
	private java.util.Date myCdsad_fecha_registro;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCdsad_nombre_adjunto;
	/**
	* DOCUMENTO DIGITALIZADO
	*/
	private byte[] myCdsad_adjunto;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCdsad_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdsad_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdsad_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdsad_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_sadjunto
	*/
	public Cgg_dhu_sadjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_sadjunto
	* @param inCdsad_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
	* @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @param inCdbcr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCdsad_fecha_registro FECHA DE REGISTRO DEL ADJUNTO
	* @param inCdsad_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCdsad_adjunto DOCUMENTO DIGITALIZADO
	* @param inCdsad_observacion INFORMACION ADICIONAL
	* @param inCdsad_estado ESTADO DEL REGISTRO
	* @param inCdsad_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdsad_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_sadjunto(
		String inCdsad_codigo,
		String inCdacd_codigo,
		String inCdbcr_codigo,
		java.util.Date inCdsad_fecha_registro,
		String inCdsad_nombre_adjunto,
		byte[] inCdsad_adjunto,
		String inCdsad_observacion,
		boolean inCdsad_estado,
		String inCdsad_usuario_insert,
		String inCdsad_usuario_update
	){
		this.setCDSAD_CODIGO(inCdsad_codigo);
		this.setCDACD_CODIGO(inCdacd_codigo);
		this.setCDBCR_CODIGO(inCdbcr_codigo);
		this.setCDSAD_FECHA_REGISTRO(inCdsad_fecha_registro);
		this.setCDSAD_NOMBRE_ADJUNTO(inCdsad_nombre_adjunto);
		this.setCDSAD_ADJUNTO(inCdsad_adjunto);
		this.setCDSAD_OBSERVACION(inCdsad_observacion);
		this.setCDSAD_ESTADO(inCdsad_estado);
		this.setCDSAD_USUARIO_INSERT(inCdsad_usuario_insert);
		this.setCDSAD_USUARIO_UPDATE(inCdsad_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
	* @param inCdsad_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
	*/
	public void setCDSAD_CODIGO(String inCdsad_codigo){
		this.myCdsad_codigo = inCdsad_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL ADJUNTO DE SEGUIMIENTO
	*/
	public String getCDSAD_CODIGO(){
		return this.myCdsad_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	public void setCDACD_CODIGO(String inCdacd_codigo){
		this.myCdacd_codigo = inCdacd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	public String getCDACD_CODIGO(){
		return this.myCdacd_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCdbcr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCDBCR_CODIGO(String inCdbcr_codigo){
		this.myCdbcr_codigo = inCdbcr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCDBCR_CODIGO(){
		return this.myCdbcr_codigo;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DEL ADJUNTO
	* @param inCdsad_fecha_registro FECHA DE REGISTRO DEL ADJUNTO
	*/
	public void setCDSAD_FECHA_REGISTRO(java.util.Date inCdsad_fecha_registro){
		this.myCdsad_fecha_registro = inCdsad_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DEL ADJUNTO
	* @return java.util.Date FECHA DE REGISTRO DEL ADJUNTO
	*/
	public java.util.Date getCDSAD_FECHA_REGISTRO(){
		return this.myCdsad_fecha_registro;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCdsad_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCDSAD_NOMBRE_ADJUNTO(String inCdsad_nombre_adjunto){
		this.myCdsad_nombre_adjunto = inCdsad_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCDSAD_NOMBRE_ADJUNTO(){
		return this.myCdsad_nombre_adjunto;
	}

	/**
	* ESTABLECE DOCUMENTO DIGITALIZADO
	* @param inCdsad_adjunto DOCUMENTO DIGITALIZADO
	*/
	public void setCDSAD_ADJUNTO(byte[] inCdsad_adjunto){
		this.myCdsad_adjunto = inCdsad_adjunto;
	}
	/**
	* OBTIENE DOCUMENTO DIGITALIZADO
	* @return byte[] DOCUMENTO DIGITALIZADO
	*/
	public byte[] getCDSAD_ADJUNTO(){
		return this.myCdsad_adjunto;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCdsad_observacion INFORMACION ADICIONAL
	*/
	public void setCDSAD_OBSERVACION(String inCdsad_observacion){
		this.myCdsad_observacion = inCdsad_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCDSAD_OBSERVACION(){
		return this.myCdsad_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdsad_estado ESTADO DEL REGISTRO
	*/
	public void setCDSAD_ESTADO(boolean inCdsad_estado){
		this.myCdsad_estado = inCdsad_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDSAD_ESTADO(){
		return this.myCdsad_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdsad_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDSAD_USUARIO_INSERT(String inCdsad_usuario_insert){
		this.myCdsad_usuario_insert = inCdsad_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDSAD_USUARIO_INSERT(){
		return this.myCdsad_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdsad_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDSAD_USUARIO_UPDATE(String inCdsad_usuario_update){
		this.myCdsad_usuario_update = inCdsad_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDSAD_USUARIO_UPDATE(){
		return this.myCdsad_usuario_update;
	}

}
