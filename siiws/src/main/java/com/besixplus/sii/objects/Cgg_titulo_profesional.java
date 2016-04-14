package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_titulo_profesional
* TABLA: TITULO PROFESIONAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS TITULOS PROFESIONALES
* ABREVIATURA:CGTPR
*/
public class Cgg_titulo_profesional implements Serializable{
	private static final long serialVersionUID = 1324778626;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	private String myCgtpr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgnes_codigo;
	/**
	* DESCRIPCION DEL NIVEL DE ESTUDIO AL Q PERTENECE
	*/
	private String myCgnes_descripcion;
	/**
	* DESCRIPCION DEL TITULO PROFESIONAL
	*/
	private String myCgtpr_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgtpr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgtpr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgtpr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_titulo_profesional
	*/
	public Cgg_titulo_profesional(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_titulo_profesional
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCgnes_descripcion DESCRIPCION DEL NIVEL DE ESTUDIO
	* @param inCgtpr_descripcion DESCRIPCION DEL TITULO PROFESIONAL
	* @param inCgtpr_estado ESTADO DEL REGISTRO
	* @param inCgtpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgtpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_titulo_profesional(
		String inCgtpr_codigo,
		String inCgnes_codigo,
		String inCgnes_descripcion,
		String inCgtpr_descripcion,
		boolean inCgtpr_estado,
		String inCgtpr_usuario_insert,
		String inCgtpr_usuario_update
	){
		this.setCGTPR_CODIGO(inCgtpr_codigo);
		this.setCGNES_CODIGO(inCgnes_codigo);
		this.setCGNES_DESCRIPCION(inCgnes_descripcion);
		this.setCGTPR_DESCRIPCION(inCgtpr_descripcion);
		this.setCGTPR_ESTADO(inCgtpr_estado);
		this.setCGTPR_USUARIO_INSERT(inCgtpr_usuario_insert);
		this.setCGTPR_USUARIO_UPDATE(inCgtpr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	public void setCGTPR_CODIGO(String inCgtpr_codigo){
		this.myCgtpr_codigo = inCgtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	public String getCGTPR_CODIGO(){
		return this.myCgtpr_codigo;
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
	* ESTABLECE DESCRIPCION DEL NIVEL DE ESTUDIO
	* @param inCgnes_descripcion IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGNES_DESCRIPCION(String inCgnes_descripcion){
		this.myCgnes_descripcion = inCgnes_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL NIVEL DE ESTUDIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGNES_DESCRIPCION(){
		return this.myCgnes_descripcion;
	}
	/**
	* ESTABLECE DESCRIPCION DEL TITULO PROFESIONAL
	* @param inCgtpr_descripcion DESCRIPCION DEL TITULO PROFESIONAL
	*/
	public void setCGTPR_DESCRIPCION(String inCgtpr_descripcion){
		this.myCgtpr_descripcion = inCgtpr_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TITULO PROFESIONAL
	* @return String DESCRIPCION DEL TITULO PROFESIONAL
	*/
	public String getCGTPR_DESCRIPCION(){
		return this.myCgtpr_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgtpr_estado ESTADO DEL REGISTRO
	*/
	public void setCGTPR_ESTADO(boolean inCgtpr_estado){
		this.myCgtpr_estado = inCgtpr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGTPR_ESTADO(){
		return this.myCgtpr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgtpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGTPR_USUARIO_INSERT(String inCgtpr_usuario_insert){
		this.myCgtpr_usuario_insert = inCgtpr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGTPR_USUARIO_INSERT(){
		return this.myCgtpr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgtpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGTPR_USUARIO_UPDATE(String inCgtpr_usuario_update){
		this.myCgtpr_usuario_update = inCgtpr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGTPR_USUARIO_UPDATE(){
		return this.myCgtpr_usuario_update;
	}

}
