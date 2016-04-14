package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_historial_proceso
* TABLA: HISTORIAL PROCESO JUDICIAL
* DESCRIPCION:ALMACENA INFORMACION DEL HISTORIAL FORMADO POR LOS MOVIMIENTOS RECIBIDOS Y PLANTEADOS EN UN PROCESO JUDICIAL
* ABREVIATURA:CJHTP
*/
public class Cgg_jur_historial_proceso implements Serializable{
	private static final long serialVersionUID = 1400514741;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	*/
	private String myCjhtp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	private String myCjpju_codigo;
	/**
	* DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	*/
	private String myCjhtp_descripcion;
	/**
	* TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	*/
	private int myCjhtp_tipo;
	/**
	* NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	*/
	private String myCjhtp_responsable;
	/**
	* FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	*/
	private java.util.Date myCjhtp_fecha;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjhtp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjhtp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjhtp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_historial_proceso
	*/
	public Cgg_jur_historial_proceso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_historial_proceso
	* @param inCjhtp_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCjhtp_descripcion DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	* @param inCjhtp_tipo TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	* @param inCjhtp_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	* @param inCjhtp_fecha FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	* @param inCjhtp_estado ESTADO DEL REGISTRO
	* @param inCjhtp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjhtp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_historial_proceso(
		String inCjhtp_codigo,
		String inCjpju_codigo,
		String inCjhtp_descripcion,
		int inCjhtp_tipo,
		String inCjhtp_responsable,
		java.util.Date inCjhtp_fecha,
		boolean inCjhtp_estado,
		String inCjhtp_usuario_insert,
		String inCjhtp_usuario_update
	){
		this.setCJHTP_CODIGO(inCjhtp_codigo);
		this.setCJPJU_CODIGO(inCjpju_codigo);
		this.setCJHTP_DESCRIPCION(inCjhtp_descripcion);
		this.setCJHTP_TIPO(inCjhtp_tipo);
		this.setCJHTP_RESPONSABLE(inCjhtp_responsable);
		this.setCJHTP_FECHA(inCjhtp_fecha);
		this.setCJHTP_ESTADO(inCjhtp_estado);
		this.setCJHTP_USUARIO_INSERT(inCjhtp_usuario_insert);
		this.setCJHTP_USUARIO_UPDATE(inCjhtp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	* @param inCjhtp_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	*/
	public void setCJHTP_CODIGO(String inCjhtp_codigo){
		this.myCjhtp_codigo = inCjhtp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	*/
	public String getCJHTP_CODIGO(){
		return this.myCjhtp_codigo;
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
	* ESTABLECE DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	* @param inCjhtp_descripcion DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	*/
	public void setCJHTP_DESCRIPCION(String inCjhtp_descripcion){
		this.myCjhtp_descripcion = inCjhtp_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	* @return String DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	*/
	public String getCJHTP_DESCRIPCION(){
		return this.myCjhtp_descripcion;
	}

	/**
	* ESTABLECE TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	* @param inCjhtp_tipo TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	*/
	public void setCJHTP_TIPO(int inCjhtp_tipo){
		this.myCjhtp_tipo = inCjhtp_tipo;
	}
	/**
	* OBTIENE TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	* @return int TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	*/
	public int getCJHTP_TIPO(){
		return this.myCjhtp_tipo;
	}

	/**
	* ESTABLECE NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	* @param inCjhtp_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	*/
	public void setCJHTP_RESPONSABLE(String inCjhtp_responsable){
		this.myCjhtp_responsable = inCjhtp_responsable;
	}
	/**
	* OBTIENE NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	* @return String NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	*/
	public String getCJHTP_RESPONSABLE(){
		return this.myCjhtp_responsable;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	* @param inCjhtp_fecha FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	*/
	public void setCJHTP_FECHA(java.util.Date inCjhtp_fecha){
		this.myCjhtp_fecha = inCjhtp_fecha;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	* @return java.util.Date FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	*/
	public java.util.Date getCJHTP_FECHA(){
		return this.myCjhtp_fecha;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjhtp_estado ESTADO DEL REGISTRO
	*/
	public void setCJHTP_ESTADO(boolean inCjhtp_estado){
		this.myCjhtp_estado = inCjhtp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJHTP_ESTADO(){
		return this.myCjhtp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjhtp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJHTP_USUARIO_INSERT(String inCjhtp_usuario_insert){
		this.myCjhtp_usuario_insert = inCjhtp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJHTP_USUARIO_INSERT(){
		return this.myCjhtp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjhtp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJHTP_USUARIO_UPDATE(String inCjhtp_usuario_update){
		this.myCjhtp_usuario_update = inCjhtp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJHTP_USUARIO_UPDATE(){
		return this.myCjhtp_usuario_update;
	}

}
