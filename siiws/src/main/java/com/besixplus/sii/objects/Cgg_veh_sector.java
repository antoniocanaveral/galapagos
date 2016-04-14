package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_sector
* TABLA: SECTOR
* DESCRIPCION: ALMACENA INFORMACION DE SECTOR
* ABREVIATURA:CVSCT
*/
public class Cgg_veh_sector implements Serializable{
	private static final long serialVersionUID = 2062825899;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	private String myCvsct_codigo;
	/**
	* NOMBRE DESCRIPTIVO DEL SECTOR
	*/
	private String myCvsct_nombre;
	/**
	* DESCRIPCION DEL VEHICULO SECTOR
	*/
	private String myCvsct_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvsct_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvsct_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvsct_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_sector
	*/
	public Cgg_veh_sector(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_sector
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @param inCvsct_nombre NOMBRE DESCRIPTIVO DEL SECTOR
	* @param inCvsct_descripcion DESCRIPCION DEL VEHICULO SECTOR
	* @param inCvsct_estado ESTADO DEL REGISTRO
	* @param inCvsct_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsct_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_sector(
		String inCvsct_codigo,
		String inCvsct_nombre,
		String inCvsct_descripcion,
		boolean inCvsct_estado,
		String inCvsct_usuario_insert,
		String inCvsct_usuario_update
	){
		this.setCVSCT_CODIGO(inCvsct_codigo);
		this.setCVSCT_NOMBRE(inCvsct_nombre);
		this.setCVSCT_DESCRIPCION(inCvsct_descripcion);
		this.setCVSCT_ESTADO(inCvsct_estado);
		this.setCVSCT_USUARIO_INSERT(inCvsct_usuario_insert);
		this.setCVSCT_USUARIO_UPDATE(inCvsct_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	public void setCVSCT_CODIGO(String inCvsct_codigo){
		this.myCvsct_codigo = inCvsct_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	public String getCVSCT_CODIGO(){
		return this.myCvsct_codigo;
	}

	/**
	* ESTABLECE NOMBRE DESCRIPTIVO DEL SECTOR
	* @param inCvsct_nombre NOMBRE DESCRIPTIVO DEL SECTOR
	*/
	public void setCVSCT_NOMBRE(String inCvsct_nombre){
		this.myCvsct_nombre = inCvsct_nombre;
	}
	/**
	* OBTIENE NOMBRE DESCRIPTIVO DEL SECTOR
	* @return String NOMBRE DESCRIPTIVO DEL SECTOR
	*/
	public String getCVSCT_NOMBRE(){
		return this.myCvsct_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DEL VEHICULO SECTOR
	* @param inCvsct_descripcion DESCRIPCION DEL VEHICULO SECTOR
	*/
	public void setCVSCT_DESCRIPCION(String inCvsct_descripcion){
		this.myCvsct_descripcion = inCvsct_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL VEHICULO SECTOR
	* @return String DESCRIPCION DEL VEHICULO SECTOR
	*/
	public String getCVSCT_DESCRIPCION(){
		return this.myCvsct_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvsct_estado ESTADO DEL REGISTRO
	*/
	public void setCVSCT_ESTADO(boolean inCvsct_estado){
		this.myCvsct_estado = inCvsct_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVSCT_ESTADO(){
		return this.myCvsct_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvsct_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVSCT_USUARIO_INSERT(String inCvsct_usuario_insert){
		this.myCvsct_usuario_insert = inCvsct_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVSCT_USUARIO_INSERT(){
		return this.myCvsct_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvsct_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVSCT_USUARIO_UPDATE(String inCvsct_usuario_update){
		this.myCvsct_usuario_update = inCvsct_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVSCT_USUARIO_UPDATE(){
		return this.myCvsct_usuario_update;
	}

}
