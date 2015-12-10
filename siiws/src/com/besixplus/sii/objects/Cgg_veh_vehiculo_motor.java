package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_vehiculo_motor
* TABLA: VEHICULO MOTOR
* DESCRIPCION:ALMACENA INFORMACION DE LOS MOTORES PERTENECIENTES A UN VEHICULO
* ABREVIATURA:CVVMT
*/
public class Cgg_veh_vehiculo_motor implements Serializable{
	private static final long serialVersionUID = 523947901;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO  DE VEHICULO MOTOR
	*/
	private String myCvvmt_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	private String myCvveh_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	private String myCvmtr_codigo;
	/**
	* FECHA QUE SE ASIGNO EL MOTOR
	*/
	private java.util.Date myCvvmt_fecha;
	/**
	* OBSERVACION DEL MOTOR DEL VEHICULO
	*/
	private String myCvvmt_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvvmt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvvmt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvvmt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_motor
	*/
	public Cgg_veh_vehiculo_motor(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_motor
	* @param inCvvmt_codigo IDENTIFICATIVO UNICO DE REGISTRO  DE VEHICULO MOTOR
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvvmt_fecha FECHA QUE SE ASIGNO EL MOTOR
	* @param inCvvmt_observacion OBSERVACION DEL MOTOR DEL VEHICULO
	* @param inCvvmt_estado ESTADO DEL REGISTRO
	* @param inCvvmt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvvmt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_vehiculo_motor(
		String inCvvmt_codigo,
		String inCvveh_codigo,
		String inCvmtr_codigo,
		java.util.Date inCvvmt_fecha,
		String inCvvmt_observacion,
		boolean inCvvmt_estado,
		String inCvvmt_usuario_insert,
		String inCvvmt_usuario_update
	){
		this.setCVVMT_CODIGO(inCvvmt_codigo);
		this.setCVVEH_CODIGO(inCvveh_codigo);
		this.setCVMTR_CODIGO(inCvmtr_codigo);
		this.setCVVMT_FECHA(inCvvmt_fecha);
		this.setCVVMT_OBSERVACION(inCvvmt_observacion);
		this.setCVVMT_ESTADO(inCvvmt_estado);
		this.setCVVMT_USUARIO_INSERT(inCvvmt_usuario_insert);
		this.setCVVMT_USUARIO_UPDATE(inCvvmt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO  DE VEHICULO MOTOR
	* @param inCvvmt_codigo IDENTIFICATIVO UNICO DE REGISTRO  DE VEHICULO MOTOR
	*/
	public void setCVVMT_CODIGO(String inCvvmt_codigo){
		this.myCvvmt_codigo = inCvvmt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO  DE VEHICULO MOTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO  DE VEHICULO MOTOR
	*/
	public String getCVVMT_CODIGO(){
		return this.myCvvmt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public void setCVVEH_CODIGO(String inCvveh_codigo){
		this.myCvveh_codigo = inCvveh_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public String getCVVEH_CODIGO(){
		return this.myCvveh_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	public void setCVMTR_CODIGO(String inCvmtr_codigo){
		this.myCvmtr_codigo = inCvmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	public String getCVMTR_CODIGO(){
		return this.myCvmtr_codigo;
	}

	/**
	* ESTABLECE FECHA QUE SE ASIGNO EL MOTOR
	* @param inCvvmt_fecha FECHA QUE SE ASIGNO EL MOTOR
	*/
	public void setCVVMT_FECHA(java.util.Date inCvvmt_fecha){
		this.myCvvmt_fecha = inCvvmt_fecha;
	}
	/**
	* OBTIENE FECHA QUE SE ASIGNO EL MOTOR
	* @return java.util.Date FECHA QUE SE ASIGNO EL MOTOR
	*/
	public java.util.Date getCVVMT_FECHA(){
		return this.myCvvmt_fecha;
	}

	/**
	* ESTABLECE OBSERVACION DEL MOTOR DEL VEHICULO
	* @param inCvvmt_observacion OBSERVACION DEL MOTOR DEL VEHICULO
	*/
	public void setCVVMT_OBSERVACION(String inCvvmt_observacion){
		this.myCvvmt_observacion = inCvvmt_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL MOTOR DEL VEHICULO
	* @return String OBSERVACION DEL MOTOR DEL VEHICULO
	*/
	public String getCVVMT_OBSERVACION(){
		return this.myCvvmt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvvmt_estado ESTADO DEL REGISTRO
	*/
	public void setCVVMT_ESTADO(boolean inCvvmt_estado){
		this.myCvvmt_estado = inCvvmt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVVMT_ESTADO(){
		return this.myCvvmt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvvmt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVVMT_USUARIO_INSERT(String inCvvmt_usuario_insert){
		this.myCvvmt_usuario_insert = inCvvmt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVVMT_USUARIO_INSERT(){
		return this.myCvvmt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvvmt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVVMT_USUARIO_UPDATE(String inCvvmt_usuario_update){
		this.myCvvmt_usuario_update = inCvvmt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVVMT_USUARIO_UPDATE(){
		return this.myCvvmt_usuario_update;
	}

}
