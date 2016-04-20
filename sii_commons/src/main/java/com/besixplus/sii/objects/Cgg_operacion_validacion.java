package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_operacion_validacion
* TABLA: OPERACION VALIDACION
* DESCRIPCION:ALMACENA INFORMACION DE LAS OPERACIONES QUE PUEDEN REALIZARSE A TRAVES DE VARIAS REGLAS DE VALIDACION
* ABREVIATURA:COPVL
*/
public class Cgg_operacion_validacion implements Serializable{
	private static final long serialVersionUID = 30051070;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
	*/
	private String myCopvl_codigo;
	/**
	* DESCRIPCION DE LA OPERACION
	*/
	private String myCopvl_descripcion;
	/**
	* FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO
	*/
	private String myCopvl_formulario;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCopvl_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCopvl_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCopvl_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_operacion_validacion
	*/
	public Cgg_operacion_validacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_operacion_validacion
	* @param inCopvl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
	* @param inCopvl_descripcion DESCRIPCION DE LA OPERACION
	* @param inCopvl_formulario FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO
	* @param inCopvl_estado ESTADO DEL REGISTRO
	* @param inCopvl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCopvl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_operacion_validacion(
		String inCopvl_codigo,
		String inCopvl_descripcion,
		String inCopvl_formulario,
		boolean inCopvl_estado,
		String inCopvl_usuario_insert,
		String inCopvl_usuario_update
	){
		this.setCOPVL_CODIGO(inCopvl_codigo);
		this.setCOPVL_DESCRIPCION(inCopvl_descripcion);
		this.setCOPVL_FORMULARIO(inCopvl_formulario);
		this.setCOPVL_ESTADO(inCopvl_estado);
		this.setCOPVL_USUARIO_INSERT(inCopvl_usuario_insert);
		this.setCOPVL_USUARIO_UPDATE(inCopvl_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
	* @param inCopvl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
	*/
	public void setCOPVL_CODIGO(String inCopvl_codigo){
		this.myCopvl_codigo = inCopvl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION
	*/
	public String getCOPVL_CODIGO(){
		return this.myCopvl_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA OPERACION
	* @param inCopvl_descripcion DESCRIPCION DE LA OPERACION
	*/
	public void setCOPVL_DESCRIPCION(String inCopvl_descripcion){
		this.myCopvl_descripcion = inCopvl_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA OPERACION
	* @return String DESCRIPCION DE LA OPERACION
	*/
	public String getCOPVL_DESCRIPCION(){
		return this.myCopvl_descripcion;
	}

	/**
	* ESTABLECE FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO
	* @param inCopvl_formulario FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO
	*/
	public void setCOPVL_FORMULARIO(String inCopvl_formulario){
		this.myCopvl_formulario = inCopvl_formulario;
	}
	/**
	* OBTIENE FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO
	* @return String FORMULARIO EN EL QUE EJECUTARIA LA OPERACION POR DEFECTO
	*/
	public String getCOPVL_FORMULARIO(){
		return this.myCopvl_formulario;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCopvl_estado ESTADO DEL REGISTRO
	*/
	public void setCOPVL_ESTADO(boolean inCopvl_estado){
		this.myCopvl_estado = inCopvl_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCOPVL_ESTADO(){
		return this.myCopvl_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCopvl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCOPVL_USUARIO_INSERT(String inCopvl_usuario_insert){
		this.myCopvl_usuario_insert = inCopvl_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCOPVL_USUARIO_INSERT(){
		return this.myCopvl_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCopvl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCOPVL_USUARIO_UPDATE(String inCopvl_usuario_update){
		this.myCopvl_usuario_update = inCopvl_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCOPVL_USUARIO_UPDATE(){
		return this.myCopvl_usuario_update;
	}

}
