package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_cilindraje
* TABLA: CILINDRAJE
* DESCRIPCION:ALMACENA INFORMACION DE LOS CILINDRAJE DE LOS MOTORES
* ABREVIATURA:CVCLN
*/
public class Cgg_veh_cilindraje implements Serializable{
	private static final long serialVersionUID = 1625431339;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	*/
	private String myCvcln_codigo;
	/**
	* CILINDRAJE DEL MOTOR
	*/
	private int myCvcln_cilindraje;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvcln_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvcln_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvcln_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvcln_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_cilindraje
	*/
	public Cgg_veh_cilindraje(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_cilindraje
	* @param inCvcln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @param inCvcln_cilindraje CILINDRAJE DEL MOTOR
	* @param inCvcln_observacion INFORMACION ADICIONAL
	* @param inCvcln_estado ESTADO DEL REGISTRO
	* @param inCvcln_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvcln_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_cilindraje(
		String inCvcln_codigo,
		int inCvcln_cilindraje,
		String inCvcln_observacion,
		boolean inCvcln_estado,
		String inCvcln_usuario_insert,
		String inCvcln_usuario_update
	){
		this.setCVCLN_CODIGO(inCvcln_codigo);
		this.setCVCLN_CILINDRAJE(inCvcln_cilindraje);
		this.setCVCLN_OBSERVACION(inCvcln_observacion);
		this.setCVCLN_ESTADO(inCvcln_estado);
		this.setCVCLN_USUARIO_INSERT(inCvcln_usuario_insert);
		this.setCVCLN_USUARIO_UPDATE(inCvcln_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @param inCvcln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	*/
	public void setCVCLN_CODIGO(String inCvcln_codigo){
		this.myCvcln_codigo = inCvcln_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	*/
	public String getCVCLN_CODIGO(){
		return this.myCvcln_codigo;
	}

	/**
	* ESTABLECE CILINDRAJE DEL MOTOR
	* @param inCvcln_cilindraje CILINDRAJE DEL MOTOR
	*/
	public void setCVCLN_CILINDRAJE(int inCvcln_cilindraje){
		this.myCvcln_cilindraje = inCvcln_cilindraje;
	}
	/**
	* OBTIENE CILINDRAJE DEL MOTOR
	* @return int CILINDRAJE DEL MOTOR
	*/
	public int getCVCLN_CILINDRAJE(){
		return this.myCvcln_cilindraje;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvcln_observacion INFORMACION ADICIONAL
	*/
	public void setCVCLN_OBSERVACION(String inCvcln_observacion){
		this.myCvcln_observacion = inCvcln_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVCLN_OBSERVACION(){
		return this.myCvcln_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvcln_estado ESTADO DEL REGISTRO
	*/
	public void setCVCLN_ESTADO(boolean inCvcln_estado){
		this.myCvcln_estado = inCvcln_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVCLN_ESTADO(){
		return this.myCvcln_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvcln_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVCLN_USUARIO_INSERT(String inCvcln_usuario_insert){
		this.myCvcln_usuario_insert = inCvcln_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVCLN_USUARIO_INSERT(){
		return this.myCvcln_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvcln_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVCLN_USUARIO_UPDATE(String inCvcln_usuario_update){
		this.myCvcln_usuario_update = inCvcln_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVCLN_USUARIO_UPDATE(){
		return this.myCvcln_usuario_update;
	}

}
