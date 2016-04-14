package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_isla_empleo
* TABLA: ISLA DE EMPLEO
* DESCRIPCION:ALMACENA INFORMACION DE LAS ISLAS DONDE SE REALIZARA EL EMPLEO
* ABREVIATURA:CGISE
*/
public class Cgg_gem_isla_empleo implements Serializable{
	private static final long serialVersionUID = 1458671226;
	/**
	* CODIGO IDENTIFICATIVO DE LA TABLA
	*/
	private String myCgise_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	private String myCgvcn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	private String myCisla_codigo;
	/**
	* DIRECCION EN LA QUE VA A REALIZAR EL TRABAJO
	*/
	private String myCgise_direccion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgise_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgise_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgise_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_isla_empleo
	*/
	public Cgg_gem_isla_empleo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_isla_empleo
	* @param inCgise_codigo CODIGO IDENTIFICATIVO DE LA TABLA
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param inCgise_direccion DIRECCION EN LA QUE VA A REALIZAR EL TRABAJO
	* @param inCgise_estado ESTADO DEL REGISTRO
	* @param inCgise_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @param inCgise_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public Cgg_gem_isla_empleo(
		String inCgise_codigo,
		String inCgvcn_codigo,
		String inCisla_codigo,
		String inCgise_direccion,
		boolean inCgise_estado,
		String inCgise_usuario_insert,
		String inCgise_usuario_update
	){
		this.setCGISE_CODIGO(inCgise_codigo);
		this.setCGVCN_CODIGO(inCgvcn_codigo);
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCGISE_DIRECCION(inCgise_direccion);
		this.setCGISE_ESTADO(inCgise_estado);
		this.setCGISE_USUARIO_INSERT(inCgise_usuario_insert);
		this.setCGISE_USUARIO_UPDATE(inCgise_usuario_update);
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE LA TABLA
	* @param inCgise_codigo CODIGO IDENTIFICATIVO DE LA TABLA
	*/
	public void setCGISE_CODIGO(String inCgise_codigo){
		this.myCgise_codigo = inCgise_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE LA TABLA
	* @return String CODIGO IDENTIFICATIVO DE LA TABLA
	*/
	public String getCGISE_CODIGO(){
		return this.myCgise_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	public void setCGVCN_CODIGO(String inCgvcn_codigo){
		this.myCgvcn_codigo = inCgvcn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	public String getCGVCN_CODIGO(){
		return this.myCgvcn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	public void setCISLA_CODIGO(String inCisla_codigo){
		this.myCisla_codigo = inCisla_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	public String getCISLA_CODIGO(){
		return this.myCisla_codigo;
	}

	/**
	* ESTABLECE DIRECCION EN LA QUE VA A REALIZAR EL TRABAJO
	* @param inCgise_direccion DIRECCION EN LA QUE VA A REALIZAR EL TRABAJO
	*/
	public void setCGISE_DIRECCION(String inCgise_direccion){
		this.myCgise_direccion = inCgise_direccion;
	}
	/**
	* OBTIENE DIRECCION EN LA QUE VA A REALIZAR EL TRABAJO
	* @return String DIRECCION EN LA QUE VA A REALIZAR EL TRABAJO
	*/
	public String getCGISE_DIRECCION(){
		return this.myCgise_direccion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgise_estado ESTADO DEL REGISTRO
	*/
	public void setCGISE_ESTADO(boolean inCgise_estado){
		this.myCgise_estado = inCgise_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGISE_ESTADO(){
		return this.myCgise_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @param inCgise_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	*/
	public void setCGISE_USUARIO_INSERT(String inCgise_usuario_insert){
		this.myCgise_usuario_insert = inCgise_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	*/
	public String getCGISE_USUARIO_INSERT(){
		return this.myCgise_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	* @param inCgise_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public void setCGISE_USUARIO_UPDATE(String inCgise_usuario_update){
		this.myCgise_usuario_update = inCgise_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public String getCGISE_USUARIO_UPDATE(){
		return this.myCgise_usuario_update;
	}

}
