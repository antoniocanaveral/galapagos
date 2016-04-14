package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_adjunto_csv
* TABLA: ADJUNTO CSV
* DESCRIPCION:ALMACENA INFORMACION DE LOS ARCHIVOS ADJUNTOS INGRESADOS AL SISTEMA POR PARTE DE LAS AGENCIAS DE VIAJES
* ABREVIATURA:CTADC
*/
public class Cgg_tct_adjunto_csv implements Serializable{
	private static final long serialVersionUID = 1327835627;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	*/
	private String myCtadc_codigo;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCtadc_nombre_adjunto;
	/**
	* DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	private String myCtadc_descripcion_adjunto;
	/**
	* FECHA DE REGISTRO DEL ARCHIVO DIGITAL
	*/
	private java.util.Date myCtadc_fecha_registro;
	/**
	* DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
	*/
	private byte[] myCtadc_adjunto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtadc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtadc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtadc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_adjunto_csv
	*/
	public Cgg_tct_adjunto_csv(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_adjunto_csv
	* @param inCtadc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	* @param inCtadc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCtadc_descripcion_adjunto DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCtadc_fecha_registro FECHA DE REGISTRO DEL ARCHIVO DIGITAL
	* @param inCtadc_adjunto DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
	* @param inCtadc_estado ESTADO DEL REGISTRO
	* @param inCtadc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtadc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_adjunto_csv(
		String inCtadc_codigo,
		String inCtadc_nombre_adjunto,
		String inCtadc_descripcion_adjunto,
		java.util.Date inCtadc_fecha_registro,
		byte[] inCtadc_adjunto,
		boolean inCtadc_estado,
		String inCtadc_usuario_insert,
		String inCtadc_usuario_update
	){
		this.setCTADC_CODIGO(inCtadc_codigo);
		this.setCTADC_NOMBRE_ADJUNTO(inCtadc_nombre_adjunto);
		this.setCTADC_DESCRIPCION_ADJUNTO(inCtadc_descripcion_adjunto);
		this.setCTADC_FECHA_REGISTRO(inCtadc_fecha_registro);
		this.setCTADC_ADJUNTO(inCtadc_adjunto);
		this.setCTADC_ESTADO(inCtadc_estado);
		this.setCTADC_USUARIO_INSERT(inCtadc_usuario_insert);
		this.setCTADC_USUARIO_UPDATE(inCtadc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	* @param inCtadc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	*/
	public void setCTADC_CODIGO(String inCtadc_codigo){
		this.myCtadc_codigo = inCtadc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	*/
	public String getCTADC_CODIGO(){
		return this.myCtadc_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCtadc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCTADC_NOMBRE_ADJUNTO(String inCtadc_nombre_adjunto){
		this.myCtadc_nombre_adjunto = inCtadc_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCTADC_NOMBRE_ADJUNTO(){
		return this.myCtadc_nombre_adjunto;
	}

	/**
	* ESTABLECE DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCtadc_descripcion_adjunto DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	public void setCTADC_DESCRIPCION_ADJUNTO(String inCtadc_descripcion_adjunto){
		this.myCtadc_descripcion_adjunto = inCtadc_descripcion_adjunto;
	}
	/**
	* OBTIENE DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @return String DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	public String getCTADC_DESCRIPCION_ADJUNTO(){
		return this.myCtadc_descripcion_adjunto;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DEL ARCHIVO DIGITAL
	* @param inCtadc_fecha_registro FECHA DE REGISTRO DEL ARCHIVO DIGITAL
	*/
	public void setCTADC_FECHA_REGISTRO(java.util.Date inCtadc_fecha_registro){
		this.myCtadc_fecha_registro = inCtadc_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DEL ARCHIVO DIGITAL
	* @return java.util.Date FECHA DE REGISTRO DEL ARCHIVO DIGITAL
	*/
	public java.util.Date getCTADC_FECHA_REGISTRO(){
		return this.myCtadc_fecha_registro;
	}

	/**
	* ESTABLECE DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
	* @param inCtadc_adjunto DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
	*/
	public void setCTADC_ADJUNTO(byte[] inCtadc_adjunto){
		this.myCtadc_adjunto = inCtadc_adjunto;
	}
	/**
	* OBTIENE DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
	* @return byte[] DOCUMENTO DIGITAL ANEXO EN FORMATO CSV
	*/
	public byte[] getCTADC_ADJUNTO(){
		return this.myCtadc_adjunto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtadc_estado ESTADO DEL REGISTRO
	*/
	public void setCTADC_ESTADO(boolean inCtadc_estado){
		this.myCtadc_estado = inCtadc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTADC_ESTADO(){
		return this.myCtadc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtadc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTADC_USUARIO_INSERT(String inCtadc_usuario_insert){
		this.myCtadc_usuario_insert = inCtadc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTADC_USUARIO_INSERT(){
		return this.myCtadc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtadc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTADC_USUARIO_UPDATE(String inCtadc_usuario_update){
		this.myCtadc_usuario_update = inCtadc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTADC_USUARIO_UPDATE(){
		return this.myCtadc_usuario_update;
	}

}
