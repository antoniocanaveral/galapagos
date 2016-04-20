package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_obj_dependencia
* TABLA: OBJETO
* DESCRIPCION: CONTIENE LAS DEPENDENCIAS DE LOS OBJETOS DEL SISTEMA
* ABREVIATURA:CSBJD
*/
public class Cgg_sec_obj_dependencia implements Serializable{
	private static final long serialVersionUID = 736783525;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	*/
	private String myCsbjd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	*/
	private String myCsobj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	private String myCgg_csobj_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsbjd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsbjd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsbjd_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_obj_dependencia
	*/
	public Cgg_sec_obj_dependencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_obj_dependencia
	* @param inCsbjd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	* @param inCsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	* @param inCgg_csobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @param inCsbjd_estado ESTADO DEL REGISTRO
	* @param inCsbjd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsbjd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_obj_dependencia(
		String inCsbjd_codigo,
		String inCsobj_codigo,
		String inCgg_csobj_codigo,
		boolean inCsbjd_estado,
		String inCsbjd_usuario_insert,
		String inCsbjd_usuario_update
	){
		this.setCSBJD_CODIGO(inCsbjd_codigo);
		this.setCSOBJ_CODIGO(inCsobj_codigo);
		this.setCGG_CSOBJ_CODIGO(inCgg_csobj_codigo);
		this.setCSBJD_ESTADO(inCsbjd_estado);
		this.setCSBJD_USUARIO_INSERT(inCsbjd_usuario_insert);
		this.setCSBJD_USUARIO_UPDATE(inCsbjd_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	* @param inCsbjd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	*/
	public void setCSBJD_CODIGO(String inCsbjd_codigo){
		this.myCsbjd_codigo = inCsbjd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	*/
	public String getCSBJD_CODIGO(){
		return this.myCsbjd_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	* @param inCsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	*/
	public void setCSOBJ_CODIGO(String inCsobj_codigo){
		this.myCsobj_codigo = inCsobj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	*/
	public String getCSOBJ_CODIGO(){
		return this.myCsobj_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @param inCgg_csobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	public void setCGG_CSOBJ_CODIGO(String inCgg_csobj_codigo){
		this.myCgg_csobj_codigo = inCgg_csobj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	public String getCGG_CSOBJ_CODIGO(){
		return this.myCgg_csobj_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsbjd_estado ESTADO DEL REGISTRO
	*/
	public void setCSBJD_ESTADO(boolean inCsbjd_estado){
		this.myCsbjd_estado = inCsbjd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSBJD_ESTADO(){
		return this.myCsbjd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsbjd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSBJD_USUARIO_INSERT(String inCsbjd_usuario_insert){
		this.myCsbjd_usuario_insert = inCsbjd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSBJD_USUARIO_INSERT(){
		return this.myCsbjd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsbjd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSBJD_USUARIO_UPDATE(String inCsbjd_usuario_update){
		this.myCsbjd_usuario_update = inCsbjd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSBJD_USUARIO_UPDATE(){
		return this.myCsbjd_usuario_update;
	}

}
