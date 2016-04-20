package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_cronograma_encuesta
* TABLA:  CRONOGRAMA ENCUESTA
* DESCRIPCION:ALMACENA INFORMACION DE LA PLANIFICACION DE ENCUESTAS
* ABREVIATURA:CDCRE
*/
public class Cgg_dhu_cronograma_encuesta implements Serializable{
	private static final long serialVersionUID = 205477606;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
	*/
	private String myCdcre_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	private String myCdenc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	private String myCdcur_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCisla_codigo;
	/**
	* DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
	*/
	private String myCdcre_descripcion;
	/**
	* FECHA DE EJECUCION DEL CRONOGRAMA
	*/
	private java.util.Date myCdcre_fecha_ejecucion;
	/**
	* FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
	*/
	private java.util.Date myCdcre_fecha_maxima_realizacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdcre_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdcre_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdcre_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_cronograma_encuesta
	*/
	public Cgg_dhu_cronograma_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_cronograma_encuesta
	* @param inCdcre_codigo IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
	* @param inCdenc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCdcre_descripcion DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
	* @param inCdcre_fecha_ejecucion FECHA DE EJECUCION DEL CRONOGRAMA
	* @param inCdcre_fecha_maxima_realizacion FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
	* @param inCdcre_estado ESTADO DEL REGISTRO
	* @param inCdcre_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcre_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_cronograma_encuesta(
		String inCdcre_codigo,
		String inCdenc_codigo,
		String inCdcur_codigo,
		String inCisla_codigo,
		String inCdcre_descripcion,
		java.util.Date inCdcre_fecha_ejecucion,
		java.util.Date inCdcre_fecha_maxima_realizacion,
		boolean inCdcre_estado,
		String inCdcre_usuario_insert,
		String inCdcre_usuario_update
	){
		this.setCDCRE_CODIGO(inCdcre_codigo);
		this.setCDENC_CODIGO(inCdenc_codigo);
		this.setCDCUR_CODIGO(inCdcur_codigo);
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCDCRE_DESCRIPCION(inCdcre_descripcion);
		this.setCDCRE_FECHA_EJECUCION(inCdcre_fecha_ejecucion);
		this.setCDCRE_FECHA_MAXIMA_REALIZACION(inCdcre_fecha_maxima_realizacion);
		this.setCDCRE_ESTADO(inCdcre_estado);
		this.setCDCRE_USUARIO_INSERT(inCdcre_usuario_insert);
		this.setCDCRE_USUARIO_UPDATE(inCdcre_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
	* @param inCdcre_codigo IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
	*/
	public void setCDCRE_CODIGO(String inCdcre_codigo){
		this.myCdcre_codigo = inCdcre_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
	*/
	public String getCDCRE_CODIGO(){
		return this.myCdcre_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @param inCdenc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	public void setCDENC_CODIGO(String inCdenc_codigo){
		this.myCdenc_codigo = inCdenc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	public String getCDENC_CODIGO(){
		return this.myCdenc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	public void setCDCUR_CODIGO(String inCdcur_codigo){
		this.myCdcur_codigo = inCdcur_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	public String getCDCUR_CODIGO(){
		return this.myCdcur_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCISLA_CODIGO(String inCisla_codigo){
		this.myCisla_codigo = inCisla_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCISLA_CODIGO(){
		return this.myCisla_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
	* @param inCdcre_descripcion DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
	*/
	public void setCDCRE_DESCRIPCION(String inCdcre_descripcion){
		this.myCdcre_descripcion = inCdcre_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
	* @return String DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
	*/
	public String getCDCRE_DESCRIPCION(){
		return this.myCdcre_descripcion;
	}

	/**
	* ESTABLECE FECHA DE EJECUCION DEL CRONOGRAMA
	* @param inCdcre_fecha_ejecucion FECHA DE EJECUCION DEL CRONOGRAMA
	*/
	public void setCDCRE_FECHA_EJECUCION(java.util.Date inCdcre_fecha_ejecucion){
		this.myCdcre_fecha_ejecucion = inCdcre_fecha_ejecucion;
	}
	/**
	* OBTIENE FECHA DE EJECUCION DEL CRONOGRAMA
	* @return java.util.Date FECHA DE EJECUCION DEL CRONOGRAMA
	*/
	public java.util.Date getCDCRE_FECHA_EJECUCION(){
		return this.myCdcre_fecha_ejecucion;
	}

	/**
	* ESTABLECE FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
	* @param inCdcre_fecha_maxima_realizacion FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
	*/
	public void setCDCRE_FECHA_MAXIMA_REALIZACION(java.util.Date inCdcre_fecha_maxima_realizacion){
		this.myCdcre_fecha_maxima_realizacion = inCdcre_fecha_maxima_realizacion;
	}
	/**
	* OBTIENE FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
	* @return java.util.Date FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
	*/
	public java.util.Date getCDCRE_FECHA_MAXIMA_REALIZACION(){
		return this.myCdcre_fecha_maxima_realizacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdcre_estado ESTADO DEL REGISTRO
	*/
	public void setCDCRE_ESTADO(boolean inCdcre_estado){
		this.myCdcre_estado = inCdcre_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDCRE_ESTADO(){
		return this.myCdcre_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcre_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDCRE_USUARIO_INSERT(String inCdcre_usuario_insert){
		this.myCdcre_usuario_insert = inCdcre_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDCRE_USUARIO_INSERT(){
		return this.myCdcre_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdcre_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDCRE_USUARIO_UPDATE(String inCdcre_usuario_update){
		this.myCdcre_usuario_update = inCdcre_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDCRE_USUARIO_UPDATE(){
		return this.myCdcre_usuario_update;
	}

}
