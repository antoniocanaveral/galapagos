package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_institucion_nivel
* TABLA: INSTITUCION NIVEL EDUCATIVO
* DESCRIPCION:ALMACENA INFORMACION DE DE LAS INSTITUCIONES EDUCATIVAS POR NIVELES
* ABREVIATURA:CGIEN
*/
public class Cgg_institucion_nivel implements Serializable{
	private static final long serialVersionUID = 1020104205;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgien_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgnes_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	private String myCgied_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgien_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgien_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgien_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_nivel
	*/
	public Cgg_institucion_nivel(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_nivel
	* @param inCgien_codigo NO ESPECIFICADO
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @param inCgien_estado ESTADO DEL REGISTRO
	* @param inCgien_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgien_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_institucion_nivel(
		String inCgien_codigo,
		String inCgnes_codigo,
		String inCgied_codigo,
		boolean inCgien_estado,
		String inCgien_usuario_insert,
		String inCgien_usuario_update
	){
		this.setCGIEN_CODIGO(inCgien_codigo);
		this.setCGNES_CODIGO(inCgnes_codigo);
		this.setCGIED_CODIGO(inCgied_codigo);
		this.setCGIEN_ESTADO(inCgien_estado);
		this.setCGIEN_USUARIO_INSERT(inCgien_usuario_insert);
		this.setCGIEN_USUARIO_UPDATE(inCgien_usuario_update);
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgien_codigo NO ESPECIFICADO
	*/
	public void setCGIEN_CODIGO(String inCgien_codigo){
		this.myCgien_codigo = inCgien_codigo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGIEN_CODIGO(){
		return this.myCgien_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGNES_CODIGO(String inCgnes_codigo){
		this.myCgnes_codigo = inCgnes_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGNES_CODIGO(){
		return this.myCgnes_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	public void setCGIED_CODIGO(String inCgied_codigo){
		this.myCgied_codigo = inCgied_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	public String getCGIED_CODIGO(){
		return this.myCgied_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgien_estado ESTADO DEL REGISTRO
	*/
	public void setCGIEN_ESTADO(boolean inCgien_estado){
		this.myCgien_estado = inCgien_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGIEN_ESTADO(){
		return this.myCgien_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgien_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGIEN_USUARIO_INSERT(String inCgien_usuario_insert){
		this.myCgien_usuario_insert = inCgien_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGIEN_USUARIO_INSERT(){
		return this.myCgien_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgien_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGIEN_USUARIO_UPDATE(String inCgien_usuario_update){
		this.myCgien_usuario_update = inCgien_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGIEN_USUARIO_UPDATE(){
		return this.myCgien_usuario_update;
	}

}
