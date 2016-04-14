package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_aplicacion_encuesta
* TABLA: APLICACION ENCUESTA
* DESCRIPCION:ALMACENA INFORMACION DE LA APLICACION DE UNA ENCUESTA
* ABREVIATURA:CDAPE
*/
public class Cgg_dhu_aplicacion_encuesta implements Serializable{
	private static final long serialVersionUID = 737367960;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	*/
	private String myCdape_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCdcre_codigo;
	/**
	* FECHA DE APLICACION DE LA ENCUESTA
	*/
	private java.util.Date myCdape_fecha;
	/**
	* OBSERVACION DE LA ENCUESTA
	*/
	private String myCdape_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdape_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdape_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdape_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_aplicacion_encuesta
	*/
	public Cgg_dhu_aplicacion_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_aplicacion_encuesta
	* @param inCdape_codigo IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	* @param inCdcre_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCdape_fecha FECHA DE APLICACION DE LA ENCUESTA
	* @param inCdape_observacion OBSERVACION DE LA ENCUESTA
	* @param inCdape_estado ESTADO DEL REGISTRO
	* @param inCdape_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdape_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_aplicacion_encuesta(
		String inCdape_codigo,
		String inCdcre_codigo,
		java.util.Date inCdape_fecha,
		String inCdape_observacion,
		boolean inCdape_estado,
		String inCdape_usuario_insert,
		String inCdape_usuario_update
	){
		this.setCDAPE_CODIGO(inCdape_codigo);
		this.setCDCRE_CODIGO(inCdcre_codigo);
		this.setCDAPE_FECHA(inCdape_fecha);
		this.setCDAPE_OBSERVACION(inCdape_observacion);
		this.setCDAPE_ESTADO(inCdape_estado);
		this.setCDAPE_USUARIO_INSERT(inCdape_usuario_insert);
		this.setCDAPE_USUARIO_UPDATE(inCdape_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCdcre_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCDCRE_CODIGO(String inCdcre_codigo){
		this.myCdcre_codigo = inCdcre_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCDCRE_CODIGO(){
		return this.myCdcre_codigo;
	}

	/**
	* ESTABLECE FECHA DE APLICACION DE LA ENCUESTA
	* @param inCdape_fecha FECHA DE APLICACION DE LA ENCUESTA
	*/
	public void setCDAPE_FECHA(java.util.Date inCdape_fecha){
		this.myCdape_fecha = inCdape_fecha;
	}
	/**
	* OBTIENE FECHA DE APLICACION DE LA ENCUESTA
	* @return java.util.Date FECHA DE APLICACION DE LA ENCUESTA
	*/
	public java.util.Date getCDAPE_FECHA(){
		return this.myCdape_fecha;
	}

	/**
	* ESTABLECE OBSERVACION DE LA ENCUESTA
	* @param inCdape_observacion OBSERVACION DE LA ENCUESTA
	*/
	public void setCDAPE_OBSERVACION(String inCdape_observacion){
		this.myCdape_observacion = inCdape_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA ENCUESTA
	* @return String OBSERVACION DE LA ENCUESTA
	*/
	public String getCDAPE_OBSERVACION(){
		return this.myCdape_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdape_estado ESTADO DEL REGISTRO
	*/
	public void setCDAPE_ESTADO(boolean inCdape_estado){
		this.myCdape_estado = inCdape_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDAPE_ESTADO(){
		return this.myCdape_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdape_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDAPE_USUARIO_INSERT(String inCdape_usuario_insert){
		this.myCdape_usuario_insert = inCdape_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDAPE_USUARIO_INSERT(){
		return this.myCdape_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdape_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDAPE_USUARIO_UPDATE(String inCdape_usuario_update){
		this.myCdape_usuario_update = inCdape_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDAPE_USUARIO_UPDATE(){
		return this.myCdape_usuario_update;
	}

}
