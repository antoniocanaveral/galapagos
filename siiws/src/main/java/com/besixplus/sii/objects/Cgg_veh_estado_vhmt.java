package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_estado_vhmt
* TABLA: ESTADO VEHICULO MOTOR
* DESCRIPCION: ALMACENA LOS ESTADOS QUE PUEDE TENER UN VEHICULO O UN MOTOR
* ABREVIATURA: CVSVM
*/
public class Cgg_veh_estado_vhmt implements Serializable{
	private static final long serialVersionUID = 2060476303;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	*/
	private String myCvsvm_codigo;
	/**
	* NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	*/
	private String myCvsvm_nombre;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvsvm_obervacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvsvm_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvsvm_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvsvm_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_estado_vhmt
	*/
	public Cgg_veh_estado_vhmt(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_estado_vhmt
	* @param inCvsvm_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	* @param inCvsvm_nombre NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	* @param inCvsvm_obervacion INFORMACION ADICIONAL
	* @param inCvsvm_estado ESTADO DEL REGISTRO
	* @param inCvsvm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsvm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_estado_vhmt(
		String inCvsvm_codigo,
		String inCvsvm_nombre,
		String inCvsvm_obervacion,
		boolean inCvsvm_estado,
		String inCvsvm_usuario_insert,
		String inCvsvm_usuario_update
	){
		this.setCVSVM_CODIGO(inCvsvm_codigo);
		this.setCVSVM_NOMBRE(inCvsvm_nombre);
		this.setCVSVM_OBERVACION(inCvsvm_obervacion);
		this.setCVSVM_ESTADO(inCvsvm_estado);
		this.setCVSVM_USUARIO_INSERT(inCvsvm_usuario_insert);
		this.setCVSVM_USUARIO_UPDATE(inCvsvm_usuario_update);
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
	* ESTABLECE NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	* @param inCvsvm_nombre NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	*/
	public void setCVSVM_NOMBRE(String inCvsvm_nombre){
		this.myCvsvm_nombre = inCvsvm_nombre;
	}
	/**
	* OBTIENE NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	* @return String NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	*/
	public String getCVSVM_NOMBRE(){
		return this.myCvsvm_nombre;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvsvm_obervacion INFORMACION ADICIONAL
	*/
	public void setCVSVM_OBERVACION(String inCvsvm_obervacion){
		this.myCvsvm_obervacion = inCvsvm_obervacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVSVM_OBERVACION(){
		return this.myCvsvm_obervacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvsvm_estado ESTADO DEL REGISTRO
	*/
	public void setCVSVM_ESTADO(boolean inCvsvm_estado){
		this.myCvsvm_estado = inCvsvm_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVSVM_ESTADO(){
		return this.myCvsvm_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsvm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVSVM_USUARIO_INSERT(String inCvsvm_usuario_insert){
		this.myCvsvm_usuario_insert = inCvsvm_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVSVM_USUARIO_INSERT(){
		return this.myCvsvm_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvsvm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVSVM_USUARIO_UPDATE(String inCvsvm_usuario_update){
		this.myCvsvm_usuario_update = inCvsvm_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVSVM_USUARIO_UPDATE(){
		return this.myCvsvm_usuario_update;
	}

}
