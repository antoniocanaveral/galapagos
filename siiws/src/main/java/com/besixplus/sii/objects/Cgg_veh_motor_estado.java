package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_motor_estado
* TABLA: MOTOR ESTADO 
* DESCRIPCION: ALMACENA LOS ESTADOS QUE TIENE UN MOTOR
* ABREVIATURA: CVSMT
*/
public class Cgg_veh_motor_estado implements Serializable{
	private static final long serialVersionUID = 449734037;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO MOTOR ESTADO
	*/
	private String myCvsmt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	private String myCvmtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	*/
	private String myCvsvm_codigo;
	/**
	* FECHA DE INICIO DEL ESTADO
	*/
	private java.util.Date myCvsmt_fecha;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvsmt_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvsmt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvsmt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvsmt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_motor_estado
	*/
	public Cgg_veh_motor_estado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_motor_estado
	* @param inCvsmt_codigo IDENTIFICATIVO UNICO DE REGISTRO MOTOR ESTADO
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvsvm_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	* @param inCvsmt_fecha FECHA DE INICIO DEL ESTADO
	* @param inCvsmt_observacion INFORMACION ADICIONAL
	* @param inCvsmt_estado ESTADO DEL REGISTRO
	* @param inCvsmt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsmt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_motor_estado(
		String inCvsmt_codigo,
		String inCvmtr_codigo,
		String inCvsvm_codigo,
		java.util.Date inCvsmt_fecha,
		String inCvsmt_observacion,
		boolean inCvsmt_estado,
		String inCvsmt_usuario_insert,
		String inCvsmt_usuario_update
	){
		this.setCVSMT_CODIGO(inCvsmt_codigo);
		this.setCVMTR_CODIGO(inCvmtr_codigo);
		this.setCVSVM_CODIGO(inCvsvm_codigo);
		this.setCVSMT_FECHA(inCvsmt_fecha);
		this.setCVSMT_OBSERVACION(inCvsmt_observacion);
		this.setCVSMT_ESTADO(inCvsmt_estado);
		this.setCVSMT_USUARIO_INSERT(inCvsmt_usuario_insert);
		this.setCVSMT_USUARIO_UPDATE(inCvsmt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO MOTOR ESTADO
	* @param inCvsmt_codigo IDENTIFICATIVO UNICO DE REGISTRO MOTOR ESTADO
	*/
	public void setCVSMT_CODIGO(String inCvsmt_codigo){
		this.myCvsmt_codigo = inCvsmt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO MOTOR ESTADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO MOTOR ESTADO
	*/
	public String getCVSMT_CODIGO(){
		return this.myCvsmt_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	* @param inCvsvm_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	*/
	public void setCVSVM_CODIGO(String inCvsvm_codigo){
		this.myCvsvm_codigo = inCvsvm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	*/
	public String getCVSVM_CODIGO(){
		return this.myCvsvm_codigo;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL ESTADO
	* @param inCvsmt_fecha FECHA DE INICIO DEL ESTADO
	*/
	public void setCVSMT_FECHA(java.util.Date inCvsmt_fecha){
		this.myCvsmt_fecha = inCvsmt_fecha;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL ESTADO
	* @return java.util.Date FECHA DE INICIO DEL ESTADO
	*/
	public java.util.Date getCVSMT_FECHA(){
		return this.myCvsmt_fecha;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvsmt_observacion INFORMACION ADICIONAL
	*/
	public void setCVSMT_OBSERVACION(String inCvsmt_observacion){
		this.myCvsmt_observacion = inCvsmt_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVSMT_OBSERVACION(){
		return this.myCvsmt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvsmt_estado ESTADO DEL REGISTRO
	*/
	public void setCVSMT_ESTADO(boolean inCvsmt_estado){
		this.myCvsmt_estado = inCvsmt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVSMT_ESTADO(){
		return this.myCvsmt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsmt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVSMT_USUARIO_INSERT(String inCvsmt_usuario_insert){
		this.myCvsmt_usuario_insert = inCvsmt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVSMT_USUARIO_INSERT(){
		return this.myCvsmt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvsmt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVSMT_USUARIO_UPDATE(String inCvsmt_usuario_update){
		this.myCvsmt_usuario_update = inCvsmt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVSMT_USUARIO_UPDATE(){
		return this.myCvsmt_usuario_update;
	}

}
