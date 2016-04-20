package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_seguimiento_profesional
* TABLA: SEGUIMIENTO PROFESIONAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS BECARIOS DURANTE EL TIEMPO QUE SE HALLAN PRESTANDO SUS SERVICIOS PROFESIONALES BAJO CONTROL DE LA INSTITUCION PATROCINADORA
* ABREVIATURA:CDSPR
*/
public class Cgg_dhu_seguimiento_profesional implements Serializable{
	private static final long serialVersionUID = 978276734;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
	*/
	private String myCdspr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	private String myCdbec_codigo;
	/**
	* NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
	*/
	private int myCdspr_anio;
	/**
	* FECHA DE INGRESO A LA INSTITUCION
	*/
	private java.util.Date myCdspr_fecha_ingreso;
	/**
	* INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
	*/
	private String myCdspr_institucion;
	/**
	* CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
	*/
	private String myCdspr_cargo;
	/**
	* FECHA DE SALIDA DE LA INSTITUCION
	*/
	private java.util.Date myCdspr_fecha_salida;
	/**
	* OBSERVACIONES AL SEGUIMIENTO
	*/
	private String myCdspr_observaciones;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdspr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdspr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdspr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_profesional
	*/
	public Cgg_dhu_seguimiento_profesional(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_profesional
	* @param inCdspr_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdspr_anio NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
	* @param inCdspr_fecha_ingreso FECHA DE INGRESO A LA INSTITUCION
	* @param inCdspr_institucion INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
	* @param inCdspr_cargo CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
	* @param inCdspr_fecha_salida FECHA DE SALIDA DE LA INSTITUCION
	* @param inCdspr_observaciones OBSERVACIONES AL SEGUIMIENTO
	* @param inCdspr_estado ESTADO DEL REGISTRO
	* @param inCdspr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdspr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_seguimiento_profesional(
		String inCdspr_codigo,
		String inCdbec_codigo,
		int inCdspr_anio,
		java.util.Date inCdspr_fecha_ingreso,
		String inCdspr_institucion,
		String inCdspr_cargo,
		java.util.Date inCdspr_fecha_salida,
		String inCdspr_observaciones,
		boolean inCdspr_estado,
		String inCdspr_usuario_insert,
		String inCdspr_usuario_update
	){
		this.setCDSPR_CODIGO(inCdspr_codigo);
		this.setCDBEC_CODIGO(inCdbec_codigo);
		this.setCDSPR_ANIO(inCdspr_anio);
		this.setCDSPR_FECHA_INGRESO(inCdspr_fecha_ingreso);
		this.setCDSPR_INSTITUCION(inCdspr_institucion);
		this.setCDSPR_CARGO(inCdspr_cargo);
		this.setCDSPR_FECHA_SALIDA(inCdspr_fecha_salida);
		this.setCDSPR_OBSERVACIONES(inCdspr_observaciones);
		this.setCDSPR_ESTADO(inCdspr_estado);
		this.setCDSPR_USUARIO_INSERT(inCdspr_usuario_insert);
		this.setCDSPR_USUARIO_UPDATE(inCdspr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
	* @param inCdspr_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
	*/
	public void setCDSPR_CODIGO(String inCdspr_codigo){
		this.myCdspr_codigo = inCdspr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL SEGUIMIENTO PROFESIONAL
	*/
	public String getCDSPR_CODIGO(){
		return this.myCdspr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	public void setCDBEC_CODIGO(String inCdbec_codigo){
		this.myCdbec_codigo = inCdbec_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	public String getCDBEC_CODIGO(){
		return this.myCdbec_codigo;
	}

	/**
	* ESTABLECE NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
	* @param inCdspr_anio NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
	*/
	public void setCDSPR_ANIO(int inCdspr_anio){
		this.myCdspr_anio = inCdspr_anio;
	}
	/**
	* OBTIENE NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
	* @return int NUMERO DEL ANIO DEL CUAL SE ESTA REGISTRANDO EL SEGUIMIENTO
	*/
	public int getCDSPR_ANIO(){
		return this.myCdspr_anio;
	}

	/**
	* ESTABLECE FECHA DE INGRESO A LA INSTITUCION
	* @param inCdspr_fecha_ingreso FECHA DE INGRESO A LA INSTITUCION
	*/
	public void setCDSPR_FECHA_INGRESO(java.util.Date inCdspr_fecha_ingreso){
		this.myCdspr_fecha_ingreso = inCdspr_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO A LA INSTITUCION
	* @return java.util.Date FECHA DE INGRESO A LA INSTITUCION
	*/
	public java.util.Date getCDSPR_FECHA_INGRESO(){
		return this.myCdspr_fecha_ingreso;
	}

	/**
	* ESTABLECE INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
	* @param inCdspr_institucion INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
	*/
	public void setCDSPR_INSTITUCION(String inCdspr_institucion){
		this.myCdspr_institucion = inCdspr_institucion;
	}
	/**
	* OBTIENE INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
	* @return String INSTITUCION DONDE EL BECARIO ESTA PRESTANDO SUS SERVICIOS
	*/
	public String getCDSPR_INSTITUCION(){
		return this.myCdspr_institucion;
	}

	/**
	* ESTABLECE CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
	* @param inCdspr_cargo CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
	*/
	public void setCDSPR_CARGO(String inCdspr_cargo){
		this.myCdspr_cargo = inCdspr_cargo;
	}
	/**
	* OBTIENE CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
	* @return String CARGO QUE SE HALLA DESEMPENIANDO EL BECARIO
	*/
	public String getCDSPR_CARGO(){
		return this.myCdspr_cargo;
	}

	/**
	* ESTABLECE FECHA DE SALIDA DE LA INSTITUCION
	* @param inCdspr_fecha_salida FECHA DE SALIDA DE LA INSTITUCION
	*/
	public void setCDSPR_FECHA_SALIDA(java.util.Date inCdspr_fecha_salida){
		this.myCdspr_fecha_salida = inCdspr_fecha_salida;
	}
	/**
	* OBTIENE FECHA DE SALIDA DE LA INSTITUCION
	* @return java.util.Date FECHA DE SALIDA DE LA INSTITUCION
	*/
	public java.util.Date getCDSPR_FECHA_SALIDA(){
		return this.myCdspr_fecha_salida;
	}

	/**
	* ESTABLECE OBSERVACIONES AL SEGUIMIENTO
	* @param inCdspr_observaciones OBSERVACIONES AL SEGUIMIENTO
	*/
	public void setCDSPR_OBSERVACIONES(String inCdspr_observaciones){
		this.myCdspr_observaciones = inCdspr_observaciones;
	}
	/**
	* OBTIENE OBSERVACIONES AL SEGUIMIENTO
	* @return String OBSERVACIONES AL SEGUIMIENTO
	*/
	public String getCDSPR_OBSERVACIONES(){
		return this.myCdspr_observaciones;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdspr_estado ESTADO DEL REGISTRO
	*/
	public void setCDSPR_ESTADO(boolean inCdspr_estado){
		this.myCdspr_estado = inCdspr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDSPR_ESTADO(){
		return this.myCdspr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdspr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDSPR_USUARIO_INSERT(String inCdspr_usuario_insert){
		this.myCdspr_usuario_insert = inCdspr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDSPR_USUARIO_INSERT(){
		return this.myCdspr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdspr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDSPR_USUARIO_UPDATE(String inCdspr_usuario_update){
		this.myCdspr_usuario_update = inCdspr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDSPR_USUARIO_UPDATE(){
		return this.myCdspr_usuario_update;
	}

}
