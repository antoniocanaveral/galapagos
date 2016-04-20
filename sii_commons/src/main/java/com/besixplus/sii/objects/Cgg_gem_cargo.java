package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_cargo
* TABLA: CARGO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CARGOS QUE LAS EMPRESAS UTILIZAN PARA LAS VACANTES
* ABREVIATURA:CGCRG
*/
public class Cgg_gem_cargo implements Serializable{
	private static final long serialVersionUID = 1648864820;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	private String myCgcrg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	private String myCgare_codigo;
	/**
	* IDENTIFICATIVO DEL CARGO
	*/
	private String myCgcrg_nombre;
	/**
	* DESCRIPCION BREVE DEL CARGO
	*/
	private String myCgcrg_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgcrg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgcrg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgcrg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_cargo
	*/
	public Cgg_gem_cargo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_cargo
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgare_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @param inCgcrg_nombre IDENTIFICATIVO DEL CARGO
	* @param inCgcrg_descripcion DESCRIPCION BREVE DEL CARGO
	* @param inCgcrg_estado ESTADO DEL REGISTRO
	* @param inCgcrg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgcrg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_cargo(
		String inCgcrg_codigo,
		String inCgare_codigo,
		String inCgcrg_nombre,
		String inCgcrg_descripcion,
		boolean inCgcrg_estado,
		String inCgcrg_usuario_insert,
		String inCgcrg_usuario_update
	){
		this.setCGCRG_CODIGO(inCgcrg_codigo);
		this.setCGARE_CODIGO(inCgare_codigo);
		this.setCGCRG_NOMBRE(inCgcrg_nombre);
		this.setCGCRG_DESCRIPCION(inCgcrg_descripcion);
		this.setCGCRG_ESTADO(inCgcrg_estado);
		this.setCGCRG_USUARIO_INSERT(inCgcrg_usuario_insert);
		this.setCGCRG_USUARIO_UPDATE(inCgcrg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public void setCGCRG_CODIGO(String inCgcrg_codigo){
		this.myCgcrg_codigo = inCgcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public String getCGCRG_CODIGO(){
		return this.myCgcrg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @param inCgare_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	public void setCGARE_CODIGO(String inCgare_codigo){
		this.myCgare_codigo = inCgare_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	public String getCGARE_CODIGO(){
		return this.myCgare_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DEL CARGO
	* @param inCgcrg_nombre IDENTIFICATIVO DEL CARGO
	*/
	public void setCGCRG_NOMBRE(String inCgcrg_nombre){
		this.myCgcrg_nombre = inCgcrg_nombre;
	}
	/**
	* OBTIENE IDENTIFICATIVO DEL CARGO
	* @return String IDENTIFICATIVO DEL CARGO
	*/
	public String getCGCRG_NOMBRE(){
		return this.myCgcrg_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION BREVE DEL CARGO
	* @param inCgcrg_descripcion DESCRIPCION BREVE DEL CARGO
	*/
	public void setCGCRG_DESCRIPCION(String inCgcrg_descripcion){
		this.myCgcrg_descripcion = inCgcrg_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION BREVE DEL CARGO
	* @return String DESCRIPCION BREVE DEL CARGO
	*/
	public String getCGCRG_DESCRIPCION(){
		return this.myCgcrg_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgcrg_estado ESTADO DEL REGISTRO
	*/
	public void setCGCRG_ESTADO(boolean inCgcrg_estado){
		this.myCgcrg_estado = inCgcrg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGCRG_ESTADO(){
		return this.myCgcrg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgcrg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGCRG_USUARIO_INSERT(String inCgcrg_usuario_insert){
		this.myCgcrg_usuario_insert = inCgcrg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGCRG_USUARIO_INSERT(){
		return this.myCgcrg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgcrg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGCRG_USUARIO_UPDATE(String inCgcrg_usuario_update){
		this.myCgcrg_usuario_update = inCgcrg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGCRG_USUARIO_UPDATE(){
		return this.myCgcrg_usuario_update;
	}

}
