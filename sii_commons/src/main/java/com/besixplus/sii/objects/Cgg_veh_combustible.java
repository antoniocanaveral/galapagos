package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_combustible
* TABLA: COMBUSTIBLE
* DESCRIPCION: COMBUSTIBLES QUE UTILIZAN LOS VEHICULOS.
* ABREVIATURA: CVCMB
*/
public class Cgg_veh_combustible implements Serializable{
	private static final long serialVersionUID = 1481757197;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	private String myCvcmb_codigo;
	/**
	* IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	*/
	private String myCvcmb_nombre;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvcmb_observacion;
	/**
	* ESTADO DEL REGISTRO.
	*/
	private boolean myCvcmb_estado;
	/**
	* USUARIO QUE CREO EL REGISTRO.
	*/
	private String myCvcmb_usuario_insert;
	/**
	* USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	private String myCvcmb_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_combustible
	*/
	public Cgg_veh_combustible(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_combustible
	* @param inCvcmb_codigo IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @param inCvcmb_nombre IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	* @param inCvcmb_observacion INFORMACION ADICIONAL
	* @param inCvcmb_estado ESTADO DEL REGISTRO.
	* @param inCvcmb_usuario_insert USUARIO QUE CREO EL REGISTRO.
	* @param inCvcmb_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public Cgg_veh_combustible(
		String inCvcmb_codigo,
		String inCvcmb_nombre,
		String inCvcmb_observacion,
		boolean inCvcmb_estado,
		String inCvcmb_usuario_insert,
		String inCvcmb_usuario_update
	){
		this.setCVCMB_CODIGO(inCvcmb_codigo);
		this.setCVCMB_NOMBRE(inCvcmb_nombre);
		this.setCVCMB_OBSERVACION(inCvcmb_observacion);
		this.setCVCMB_ESTADO(inCvcmb_estado);
		this.setCVCMB_USUARIO_INSERT(inCvcmb_usuario_insert);
		this.setCVCMB_USUARIO_UPDATE(inCvcmb_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @param inCvcmb_codigo IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	public void setCVCMB_CODIGO(String inCvcmb_codigo){
		this.myCvcmb_codigo = inCvcmb_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	public String getCVCMB_CODIGO(){
		return this.myCvcmb_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	* @param inCvcmb_nombre IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	*/
	public void setCVCMB_NOMBRE(String inCvcmb_nombre){
		this.myCvcmb_nombre = inCvcmb_nombre;
	}
	/**
	* OBTIENE IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	* @return String IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	*/
	public String getCVCMB_NOMBRE(){
		return this.myCvcmb_nombre;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvcmb_observacion INFORMACION ADICIONAL
	*/
	public void setCVCMB_OBSERVACION(String inCvcmb_observacion){
		this.myCvcmb_observacion = inCvcmb_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVCMB_OBSERVACION(){
		return this.myCvcmb_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO.
	* @param inCvcmb_estado ESTADO DEL REGISTRO.
	*/
	public void setCVCMB_ESTADO(boolean inCvcmb_estado){
		this.myCvcmb_estado = inCvcmb_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO.
	* @return boolean ESTADO DEL REGISTRO.
	*/
	public boolean getCVCMB_ESTADO(){
		return this.myCvcmb_estado;
	}

	/**
	* ESTABLECE USUARIO QUE CREO EL REGISTRO.
	* @param inCvcmb_usuario_insert USUARIO QUE CREO EL REGISTRO.
	*/
	public void setCVCMB_USUARIO_INSERT(String inCvcmb_usuario_insert){
		this.myCvcmb_usuario_insert = inCvcmb_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE CREO EL REGISTRO.
	* @return String USUARIO QUE CREO EL REGISTRO.
	*/
	public String getCVCMB_USUARIO_INSERT(){
		return this.myCvcmb_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @param inCvcmb_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public void setCVCMB_USUARIO_UPDATE(String inCvcmb_usuario_update){
		this.myCvcmb_usuario_update = inCvcmb_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @return String USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public String getCVCMB_USUARIO_UPDATE(){
		return this.myCvcmb_usuario_update;
	}

}
