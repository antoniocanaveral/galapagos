package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_objeto_rol
* TABLA: OBJETO
* DESCRIPCION: CONTIENE LOS OBJETOS QUE AUTORIZADO UN ROL
* ABREVIATURA:CSBJR
*/
public class Cgg_sec_objeto_rol implements Serializable{
	private static final long serialVersionUID = 666527835;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	private String myCsbjr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	private String myCsrol_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	private String myCsobj_codigo;
	/**
	* SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	private boolean myCsbjr_acceso_directo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsbjr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsbjr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsbjr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto_rol
	*/
	public Cgg_sec_objeto_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto_rol
	* @param inCsbjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @param inCsbjr_acceso_directo SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @param inCsbjr_estado ESTADO DEL REGISTRO
	* @param inCsbjr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsbjr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_objeto_rol(
		String inCsbjr_codigo,
		String inCsrol_codigo,
		String inCsobj_codigo,
		boolean inCsbjr_acceso_directo,
		boolean inCsbjr_estado,
		String inCsbjr_usuario_insert,
		String inCsbjr_usuario_update
	){
		this.setCSBJR_CODIGO(inCsbjr_codigo);
		this.setCSROL_CODIGO(inCsrol_codigo);
		this.setCSOBJ_CODIGO(inCsobj_codigo);
		this.setCSBJR_ACCESO_DIRECTO(inCsbjr_acceso_directo);
		this.setCSBJR_ESTADO(inCsbjr_estado);
		this.setCSBJR_USUARIO_INSERT(inCsbjr_usuario_insert);
		this.setCSBJR_USUARIO_UPDATE(inCsbjr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @param incsbjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	public void setCSBJR_CODIGO(String inCsbjr_codigo){
		this.myCsbjr_codigo = inCsbjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	public String getCSBJR_CODIGO(){
		return this.myCsbjr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param incsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @param incsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	public void setCSOBJ_CODIGO(String inCsobj_codigo){
		this.myCsobj_codigo = inCsobj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	public String getCSOBJ_CODIGO(){
		return this.myCsobj_codigo;
	}

	/**
	* ESTABLECE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @param incsbjr_acceso_directo SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	public void setCSBJR_ACCESO_DIRECTO(boolean inCsbjr_acceso_directo){
		this.myCsbjr_acceso_directo = inCsbjr_acceso_directo;
	}
	/**
	* OBTIENE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @return boolean SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	public boolean getCSBJR_ACCESO_DIRECTO(){
		return this.myCsbjr_acceso_directo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param incsbjr_estado ESTADO DEL REGISTRO
	*/
	public void setCSBJR_ESTADO(boolean inCsbjr_estado){
		this.myCsbjr_estado = inCsbjr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSBJR_ESTADO(){
		return this.myCsbjr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param incsbjr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSBJR_USUARIO_INSERT(String inCsbjr_usuario_insert){
		this.myCsbjr_usuario_insert = inCsbjr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSBJR_USUARIO_INSERT(){
		return this.myCsbjr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param incsbjr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSBJR_USUARIO_UPDATE(String inCsbjr_usuario_update){
		this.myCsbjr_usuario_update = inCsbjr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSBJR_USUARIO_UPDATE(){
		return this.myCsbjr_usuario_update;
	}

}
