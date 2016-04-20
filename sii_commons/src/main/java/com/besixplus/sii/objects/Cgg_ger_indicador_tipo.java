package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_ger_indicador_tipo
* TABLA: GERENCIAL INDICADOR TIPO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE INDICADORES QUE PUEDEN EXISTIR
* ABREVIATURA:CGGIT
*/
public class Cgg_ger_indicador_tipo implements Serializable{
	private static final long serialVersionUID = 261353783;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggit_codigo;
	/**
	* DESCRIPCION DEL TIPO DE INDICADOR
	*/
	private String myCggit_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCggit_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCggit_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCggit_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_tipo
	*/
	public Cgg_ger_indicador_tipo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_tipo
	* @param inCggit_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggit_descripcion DESCRIPCION DEL TIPO DE INDICADOR
	* @param inCggit_estado ESTADO DEL REGISTRO
	* @param inCggit_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggit_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_ger_indicador_tipo(
		String inCggit_codigo,
		String inCggit_descripcion,
		boolean inCggit_estado,
		String inCggit_usuario_insert,
		String inCggit_usuario_update
	){
		this.setCGGIT_CODIGO(inCggit_codigo);
		this.setCGGIT_DESCRIPCION(inCggit_descripcion);
		this.setCGGIT_ESTADO(inCggit_estado);
		this.setCGGIT_USUARIO_INSERT(inCggit_usuario_insert);
		this.setCGGIT_USUARIO_UPDATE(inCggit_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggit_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGGIT_CODIGO(String inCggit_codigo){
		this.myCggit_codigo = inCggit_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGGIT_CODIGO(){
		return this.myCggit_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO DE INDICADOR
	* @param inCggit_descripcion DESCRIPCION DEL TIPO DE INDICADOR
	*/
	public void setCGGIT_DESCRIPCION(String inCggit_descripcion){
		this.myCggit_descripcion = inCggit_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO DE INDICADOR
	* @return String DESCRIPCION DEL TIPO DE INDICADOR
	*/
	public String getCGGIT_DESCRIPCION(){
		return this.myCggit_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCggit_estado ESTADO DEL REGISTRO
	*/
	public void setCGGIT_ESTADO(boolean inCggit_estado){
		this.myCggit_estado = inCggit_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGGIT_ESTADO(){
		return this.myCggit_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggit_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGGIT_USUARIO_INSERT(String inCggit_usuario_insert){
		this.myCggit_usuario_insert = inCggit_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGGIT_USUARIO_INSERT(){
		return this.myCggit_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCggit_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGGIT_USUARIO_UPDATE(String inCggit_usuario_update){
		this.myCggit_usuario_update = inCggit_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGGIT_USUARIO_UPDATE(){
		return this.myCggit_usuario_update;
	}

}
