package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_provincia
* TABLA: PROVINCIA
* DESCRIPCION:ALMACENA INFORMACION DE PROVINCIAS
* ABREVIATURA:CGPRV
*/
public class Cgg_provincia implements Serializable{
	private static final long serialVersionUID = 1870637030;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgprv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCpais_codigo;
	/**
	* NOMBRE DE LA PROVINCIA
	*/
	private String myCgprv_nombre;
	/**
	* DESCRIPCION DE LA PROVINCIA
	*/
	private String myCgprv_descripcion;
	/**
	* ESTADO DEL REGSITRO
	*/
	private boolean myCgprv_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgprv_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgprv_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_provincia
	*/
	public Cgg_provincia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_provincia
	* @param inCgprv_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgprv_nombre NOMBRE DE LA PROVINCIA
	* @param inCgprv_descripcion DESCRIPCION DE LA PROVINCIA
	* @param inCgprv_estado ESTADO DEL REGSITRO
	* @param inCgprv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgprv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_provincia(
		String inCgprv_codigo,
		String inCpais_codigo,
		String inCgprv_nombre,
		String inCgprv_descripcion,
		boolean inCgprv_estado,
		String inCgprv_usuario_insert,
		String inCgprv_usuario_update
	){
		this.setCGPRV_CODIGO(inCgprv_codigo);
		this.setCPAIS_CODIGO(inCpais_codigo);
		this.setCGPRV_NOMBRE(inCgprv_nombre);
		this.setCGPRV_DESCRIPCION(inCgprv_descripcion);
		this.setCGPRV_ESTADO(inCgprv_estado);
		this.setCGPRV_USUARIO_INSERT(inCgprv_usuario_insert);
		this.setCGPRV_USUARIO_UPDATE(inCgprv_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgprv_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGPRV_CODIGO(String inCgprv_codigo){
		this.myCgprv_codigo = inCgprv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGPRV_CODIGO(){
		return this.myCgprv_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCPAIS_CODIGO(String inCpais_codigo){
		this.myCpais_codigo = inCpais_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCPAIS_CODIGO(){
		return this.myCpais_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA PROVINCIA
	* @param inCgprv_nombre NOMBRE DE LA PROVINCIA
	*/
	public void setCGPRV_NOMBRE(String inCgprv_nombre){
		this.myCgprv_nombre = inCgprv_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA PROVINCIA
	* @return String NOMBRE DE LA PROVINCIA
	*/
	public String getCGPRV_NOMBRE(){
		return this.myCgprv_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA PROVINCIA
	* @param inCgprv_descripcion DESCRIPCION DE LA PROVINCIA
	*/
	public void setCGPRV_DESCRIPCION(String inCgprv_descripcion){
		this.myCgprv_descripcion = inCgprv_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA PROVINCIA
	* @return String DESCRIPCION DE LA PROVINCIA
	*/
	public String getCGPRV_DESCRIPCION(){
		return this.myCgprv_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGSITRO
	* @param inCgprv_estado ESTADO DEL REGSITRO
	*/
	public void setCGPRV_ESTADO(boolean inCgprv_estado){
		this.myCgprv_estado = inCgprv_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGSITRO
	* @return boolean ESTADO DEL REGSITRO
	*/
	public boolean getCGPRV_ESTADO(){
		return this.myCgprv_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgprv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGPRV_USUARIO_INSERT(String inCgprv_usuario_insert){
		this.myCgprv_usuario_insert = inCgprv_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGPRV_USUARIO_INSERT(){
		return this.myCgprv_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgprv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGPRV_USUARIO_UPDATE(String inCgprv_usuario_update){
		this.myCgprv_usuario_update = inCgprv_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGPRV_USUARIO_UPDATE(){
		return this.myCgprv_usuario_update;
	}

}
