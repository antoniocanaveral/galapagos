package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_vehiculo_estado
* TABLA: VEHICULO ESTADO 
* DESCRIPCION: ALMACENA LOS ESTADOS QUE TIENE UN VEHICULO
* ABREVIATURA: CVSVH
*/
public class Cgg_veh_vehiculo_estado implements Serializable{
	private static final long serialVersionUID = 1735036088;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO VEHICULO ESTADO
	*/
	private String myCvsvh_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	private String myCvveh_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	*/
	private String myCvsvm_codigo;
	/**
	* FECHA DE INICIO DEL ESTADO
	*/
	private java.util.Date myCvsvh_fecha;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvsvh_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvsvh_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvsvh_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvsvh_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_estado
	*/
	public Cgg_veh_vehiculo_estado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo_estado
	* @param inCvsvh_codigo IDENTIFICATIVO UNICO DE REGISTRO VEHICULO ESTADO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvsvm_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	* @param inCvsvh_fecha FECHA DE INICIO DEL ESTADO
	* @param inCvsvh_observacion INFORMACION ADICIONAL
	* @param inCvsvh_estado ESTADO DEL REGISTRO
	* @param inCvsvh_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsvh_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_vehiculo_estado(
		String inCvsvh_codigo,
		String inCvveh_codigo,
		String inCvsvm_codigo,
		java.util.Date inCvsvh_fecha,
		String inCvsvh_observacion,
		boolean inCvsvh_estado,
		String inCvsvh_usuario_insert,
		String inCvsvh_usuario_update
	){
		this.setCVSVH_CODIGO(inCvsvh_codigo);
		this.setCVVEH_CODIGO(inCvveh_codigo);
		this.setCVSVM_CODIGO(inCvsvm_codigo);
		this.setCVSVH_FECHA(inCvsvh_fecha);
		this.setCVSVH_OBSERVACION(inCvsvh_observacion);
		this.setCVSVH_ESTADO(inCvsvh_estado);
		this.setCVSVH_USUARIO_INSERT(inCvsvh_usuario_insert);
		this.setCVSVH_USUARIO_UPDATE(inCvsvh_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO VEHICULO ESTADO
	* @param inCvsvh_codigo IDENTIFICATIVO UNICO DE REGISTRO VEHICULO ESTADO
	*/
	public void setCVSVH_CODIGO(String inCvsvh_codigo){
		this.myCvsvh_codigo = inCvsvh_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO VEHICULO ESTADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO VEHICULO ESTADO
	*/
	public String getCVSVH_CODIGO(){
		return this.myCvsvh_codigo;
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
	* @param inCvsvh_fecha FECHA DE INICIO DEL ESTADO
	*/
	public void setCVSVH_FECHA(java.util.Date inCvsvh_fecha){
		this.myCvsvh_fecha = inCvsvh_fecha;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL ESTADO
	* @return java.util.Date FECHA DE INICIO DEL ESTADO
	*/
	public java.util.Date getCVSVH_FECHA(){
		return this.myCvsvh_fecha;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvsvh_observacion INFORMACION ADICIONAL
	*/
	public void setCVSVH_OBSERVACION(String inCvsvh_observacion){
		this.myCvsvh_observacion = inCvsvh_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVSVH_OBSERVACION(){
		return this.myCvsvh_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvsvh_estado ESTADO DEL REGISTRO
	*/
	public void setCVSVH_ESTADO(boolean inCvsvh_estado){
		this.myCvsvh_estado = inCvsvh_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVSVH_ESTADO(){
		return this.myCvsvh_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsvh_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVSVH_USUARIO_INSERT(String inCvsvh_usuario_insert){
		this.myCvsvh_usuario_insert = inCvsvh_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVSVH_USUARIO_INSERT(){
		return this.myCvsvh_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvsvh_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVSVH_USUARIO_UPDATE(String inCvsvh_usuario_update){
		this.myCvsvh_usuario_update = inCvsvh_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVSVH_USUARIO_UPDATE(){
		return this.myCvsvh_usuario_update;
	}

}
