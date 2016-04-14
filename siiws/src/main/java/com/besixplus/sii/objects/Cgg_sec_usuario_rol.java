package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_usuario_rol
* TABLA: PERFIL ROL
* DESCRIPCION:ALMACENA INFORMACION DE LOS ROLES QUE TIENE UN USUARIO
* ABREVIATURA:CSPER
*/
public class Cgg_sec_usuario_rol implements Serializable{
	private static final long serialVersionUID = 310262370;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO USUARIO - ROL
	*/
	private String myCsper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	private String myCsrol_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsper_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsper_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsper_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_usuario_rol
	*/
	public Cgg_sec_usuario_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_usuario_rol
	* @param inCsper_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO - ROL
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCsper_estado ESTADO DEL REGISTRO
	* @param inCsper_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsper_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_usuario_rol(
		String inCsper_codigo,
		String inCsrol_codigo,
		String inCusu_codigo,
		boolean inCsper_estado,
		String inCsper_usuario_insert,
		String inCsper_usuario_update
	){
		this.setCSPER_CODIGO(inCsper_codigo);
		this.setCSROL_CODIGO(inCsrol_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCSPER_ESTADO(inCsper_estado);
		this.setCSPER_USUARIO_INSERT(inCsper_usuario_insert);
		this.setCSPER_USUARIO_UPDATE(inCsper_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO USUARIO - ROL
	* @param inCsper_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO - ROL
	*/
	public void setCSPER_CODIGO(String inCsper_codigo){
		this.myCsper_codigo = inCsper_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO USUARIO - ROL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO USUARIO - ROL
	*/
	public String getCSPER_CODIGO(){
		return this.myCsper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	public void setCSROL_CODIGO(String inCsrol_codigo){
		this.myCsrol_codigo = inCsrol_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	public String getCSROL_CODIGO(){
		return this.myCsrol_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsper_estado ESTADO DEL REGISTRO
	*/
	public void setCSPER_ESTADO(boolean inCsper_estado){
		this.myCsper_estado = inCsper_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSPER_ESTADO(){
		return this.myCsper_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsper_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSPER_USUARIO_INSERT(String inCsper_usuario_insert){
		this.myCsper_usuario_insert = inCsper_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSPER_USUARIO_INSERT(){
		return this.myCsper_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsper_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSPER_USUARIO_UPDATE(String inCsper_usuario_update){
		this.myCsper_usuario_update = inCsper_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSPER_USUARIO_UPDATE(){
		return this.myCsper_usuario_update;
	}

}
