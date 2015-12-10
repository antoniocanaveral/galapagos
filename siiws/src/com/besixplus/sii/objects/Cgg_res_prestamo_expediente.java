package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_prestamo_expediente
* TABLA: PRESTAMO EXPEDIENTE
* DESCRIPCION:ALMACENA INFORMACION DE LAS SALIDAS DE DOCUMENTOS DESDE ARCHIVO
* ABREVIATURA:CRPEX
*/
public class Cgg_res_prestamo_expediente implements Serializable{
	private static final long serialVersionUID = 208576598;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrpex_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO NOMBRE RECIBE
	*/
	private String myCrper_nombre_recibe;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCgg_crper_codigo;
	/**
	* FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
	*/
	private java.util.Date myCrpex_fecha_operacion;
	/**
	* TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
	*/
	private int myCrpex_movimiento;
	/**
	* OBSERVACION DE LA OPERACION REALIZADA
	*/
	private String myCrpex_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrpex_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrpex_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrpex_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_prestamo_expediente
	*/
	public Cgg_res_prestamo_expediente(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_prestamo_expediente
	* @param inCrpex_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrpex_fecha_operacion FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
	* @param inCrpex_movimiento TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
	* @param inCrpex_observacion OBSERVACION DE LA OPERACION REALIZADA
	* @param inCrpex_estado ESTADO DEL REGISTRO
	* @param inCrpex_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpex_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_prestamo_expediente(
		String inCrpex_codigo,
		String inCusu_codigo,
		String inCrper_codigo,
		String inCgg_crper_codigo,
		java.util.Date inCrpex_fecha_operacion,
		int inCrpex_movimiento,
		String inCrpex_observacion,
		boolean inCrpex_estado,
		String inCrpex_usuario_insert,
		String inCrpex_usuario_update
	){
		this.setCRPEX_CODIGO(inCrpex_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		this.setCRPEX_FECHA_OPERACION(inCrpex_fecha_operacion);
		this.setCRPEX_MOVIMIENTO(inCrpex_movimiento);
		this.setCRPEX_OBSERVACION(inCrpex_observacion);
		this.setCRPEX_ESTADO(inCrpex_estado);
		this.setCRPEX_USUARIO_INSERT(inCrpex_usuario_insert);
		this.setCRPEX_USUARIO_UPDATE(inCrpex_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrpex_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRPEX_CODIGO(String inCrpex_codigo){
		this.myCrpex_codigo = inCrpex_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRPEX_CODIGO(){
		return this.myCrpex_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}
	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_nombre_recibe CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_NOMBRE_RECIBE(String inCrper_nombre_recibe){
		this.myCrper_nombre_recibe = inCrper_nombre_recibe;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_NOMBRE_RECIBE(){
		return this.myCrper_nombre_recibe;
	}
	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCGG_CRPER_CODIGO(String inCgg_crper_codigo){
		this.myCgg_crper_codigo = inCgg_crper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCGG_CRPER_CODIGO(){
		return this.myCgg_crper_codigo;
	}

	/**
	* ESTABLECE FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
	* @param inCrpex_fecha_operacion FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
	*/
	public void setCRPEX_FECHA_OPERACION(java.util.Date inCrpex_fecha_operacion){
		this.myCrpex_fecha_operacion = inCrpex_fecha_operacion;
	}
	/**
	* OBTIENE FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
	* @return java.util.Date FECHA REGISTRADA DE ULTIMO MOVIMIENTO ENTRADA/SALIDA
	*/
	public java.util.Date getCRPEX_FECHA_OPERACION(){
		return this.myCrpex_fecha_operacion;
	}

	/**
	* ESTABLECE TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
	* @param inCrpex_movimiento TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
	*/
	public void setCRPEX_MOVIMIENTO(int inCrpex_movimiento){
		this.myCrpex_movimiento = inCrpex_movimiento;
	}
	/**
	* OBTIENE TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
	* @return int TIPO DE OPERACION REALIZADA ENTRADA/SALIDA
	*/
	public int getCRPEX_MOVIMIENTO(){
		return this.myCrpex_movimiento;
	}

	/**
	* ESTABLECE OBSERVACION DE LA OPERACION REALIZADA
	* @param inCrpex_observacion OBSERVACION DE LA OPERACION REALIZADA
	*/
	public void setCRPEX_OBSERVACION(String inCrpex_observacion){
		this.myCrpex_observacion = inCrpex_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA OPERACION REALIZADA
	* @return String OBSERVACION DE LA OPERACION REALIZADA
	*/
	public String getCRPEX_OBSERVACION(){
		return this.myCrpex_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrpex_estado ESTADO DEL REGISTRO
	*/
	public void setCRPEX_ESTADO(boolean inCrpex_estado){
		this.myCrpex_estado = inCrpex_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPEX_ESTADO(){
		return this.myCrpex_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpex_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPEX_USUARIO_INSERT(String inCrpex_usuario_insert){
		this.myCrpex_usuario_insert = inCrpex_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPEX_USUARIO_INSERT(){
		return this.myCrpex_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrpex_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPEX_USUARIO_UPDATE(String inCrpex_usuario_update){
		this.myCrpex_usuario_update = inCrpex_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPEX_USUARIO_UPDATE(){
		return this.myCrpex_usuario_update;
	}

}
