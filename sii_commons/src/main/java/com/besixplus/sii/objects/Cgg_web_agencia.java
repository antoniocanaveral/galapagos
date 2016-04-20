package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_web_agencia
* TABLA: AGENCIA
* DESCRIPCION: ALMACENA INFORMACION SOBRE LAS DIFERENTES AGENCIAS
* ABREVIATURA:CWAGE
*/
public class Cgg_web_agencia implements Serializable{
	private static final long serialVersionUID = 271973273;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwage_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwmod_codigo;
	/**
	* NOMBRE DE LA AGENCIA
	*/
	private String myCwage_nombre;
	/**
	* DESCRIPCION ACERCA DE LA AGENCIA
	*/
	private String myCwage_descripcion;
	/**
	* ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
	*/
	private String myCwage_encargado;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCwage_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCwage_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCwage_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_agencia
	*/
	public Cgg_web_agencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_agencia
	* @param inCwage_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwage_nombre NOMBRE DE LA AGENCIA
	* @param inCwage_descripcion DESCRIPCION ACERCA DE LA AGENCIA
	* @param inCwage_encargado ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
	* @param inCwage_estado ESTADO DEL REGISTRO
	* @param inCwage_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwage_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_web_agencia(
		String inCwage_codigo,
		String inCwmod_codigo,
		String inCwage_nombre,
		String inCwage_descripcion,
		String inCwage_encargado,
		boolean inCwage_estado,
		String inCwage_usuario_insert,
		String inCwage_usuario_update
	){
		this.setCWAGE_CODIGO(inCwage_codigo);
		this.setCWMOD_CODIGO(inCwmod_codigo);
		this.setCWAGE_NOMBRE(inCwage_nombre);
		this.setCWAGE_DESCRIPCION(inCwage_descripcion);
		this.setCWAGE_ENCARGADO(inCwage_encargado);
		this.setCWAGE_ESTADO(inCwage_estado);
		this.setCWAGE_USUARIO_INSERT(inCwage_usuario_insert);
		this.setCWAGE_USUARIO_UPDATE(inCwage_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwage_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCWAGE_CODIGO(String inCwage_codigo){
		this.myCwage_codigo = inCwage_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCWAGE_CODIGO(){
		return this.myCwage_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCWMOD_CODIGO(String inCwmod_codigo){
		this.myCwmod_codigo = inCwmod_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCWMOD_CODIGO(){
		return this.myCwmod_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA AGENCIA
	* @param inCwage_nombre NOMBRE DE LA AGENCIA
	*/
	public void setCWAGE_NOMBRE(String inCwage_nombre){
		this.myCwage_nombre = inCwage_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA AGENCIA
	* @return String NOMBRE DE LA AGENCIA
	*/
	public String getCWAGE_NOMBRE(){
		return this.myCwage_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION ACERCA DE LA AGENCIA
	* @param inCwage_descripcion DESCRIPCION ACERCA DE LA AGENCIA
	*/
	public void setCWAGE_DESCRIPCION(String inCwage_descripcion){
		this.myCwage_descripcion = inCwage_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION ACERCA DE LA AGENCIA
	* @return String DESCRIPCION ACERCA DE LA AGENCIA
	*/
	public String getCWAGE_DESCRIPCION(){
		return this.myCwage_descripcion;
	}

	/**
	* ESTABLECE ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
	* @param inCwage_encargado ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
	*/
	public void setCWAGE_ENCARGADO(String inCwage_encargado){
		this.myCwage_encargado = inCwage_encargado;
	}
	/**
	* OBTIENE ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
	* @return String ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
	*/
	public String getCWAGE_ENCARGADO(){
		return this.myCwage_encargado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCwage_estado ESTADO DEL REGISTRO
	*/
	public void setCWAGE_ESTADO(boolean inCwage_estado){
		this.myCwage_estado = inCwage_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCWAGE_ESTADO(){
		return this.myCwage_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwage_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCWAGE_USUARIO_INSERT(String inCwage_usuario_insert){
		this.myCwage_usuario_insert = inCwage_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCWAGE_USUARIO_INSERT(){
		return this.myCwage_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCwage_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCWAGE_USUARIO_UPDATE(String inCwage_usuario_update){
		this.myCwage_usuario_update = inCwage_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCWAGE_USUARIO_UPDATE(){
		return this.myCwage_usuario_update;
	}

}
