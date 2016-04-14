package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_pais
* TABLA: PAIS
* DESCRIPCION:ALMACENA INFORMACION DE PAISES
* ABREVIATURA:CPAIS
*/
public class Cgg_pais implements Serializable{
	private static final long serialVersionUID = 1770831096;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	private String myCpais_codigo;
	/**
	* NOMBRE DEL PAIS
	*/
	private String myCpais_nombre;
	/**
	* ABREVIATURA ISO DEL NOMBRE DEL PAIS
	*/
	private String myCpais_iso;
	/**
	* DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	*/
	private String myCpais_descripcion;
	/**
	* ESTADO DEL RESGISTRO
	*/
	private boolean myCpais_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCpais_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCpais_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_pais
	*/
	public Cgg_pais(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_pais
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @param inCpais_nombre NOMBRE DEL PAIS
	* @param inCpais_iso ABREVIATURA ISO DEL NOMBRE DEL PAIS
	* @param inCpais_descripcion DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	* @param inCpais_estado ESTADO DEL RESGISTRO
	* @param inCpais_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCpais_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_pais(
		String inCpais_codigo,
		String inCpais_nombre,
		String inCpais_iso,
		String inCpais_descripcion,
		boolean inCpais_estado,
		String inCpais_usuario_insert,
		String inCpais_usuario_update
	){
		this.setCPAIS_CODIGO(inCpais_codigo);
		this.setCPAIS_NOMBRE(inCpais_nombre);
		this.setCPAIS_ISO(inCpais_iso);
		this.setCPAIS_DESCRIPCION(inCpais_descripcion);
		this.setCPAIS_ESTADO(inCpais_estado);
		this.setCPAIS_USUARIO_INSERT(inCpais_usuario_insert);
		this.setCPAIS_USUARIO_UPDATE(inCpais_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	public void setCPAIS_CODIGO(String inCpais_codigo){
		this.myCpais_codigo = inCpais_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	public String getCPAIS_CODIGO(){
		return this.myCpais_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL PAIS
	* @param inCpais_nombre NOMBRE DEL PAIS
	*/
	public void setCPAIS_NOMBRE(String inCpais_nombre){
		this.myCpais_nombre = inCpais_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL PAIS
	* @return String NOMBRE DEL PAIS
	*/
	public String getCPAIS_NOMBRE(){
		return this.myCpais_nombre;
	}

	/**
	* ESTABLECE ABREVIATURA ISO DEL NOMBRE DEL PAIS
	* @param inCpais_iso ABREVIATURA ISO DEL NOMBRE DEL PAIS
	*/
	public void setCPAIS_ISO(String inCpais_iso){
		this.myCpais_iso = inCpais_iso;
	}
	/**
	* OBTIENE ABREVIATURA ISO DEL NOMBRE DEL PAIS
	* @return String ABREVIATURA ISO DEL NOMBRE DEL PAIS
	*/
	public String getCPAIS_ISO(){
		return this.myCpais_iso;
	}

	/**
	* ESTABLECE DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	* @param inCpais_descripcion DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	*/
	public void setCPAIS_DESCRIPCION(String inCpais_descripcion){
		this.myCpais_descripcion = inCpais_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	* @return String DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	*/
	public String getCPAIS_DESCRIPCION(){
		return this.myCpais_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL RESGISTRO
	* @param inCpais_estado ESTADO DEL RESGISTRO
	*/
	public void setCPAIS_ESTADO(boolean inCpais_estado){
		this.myCpais_estado = inCpais_estado;
	}
	/**
	* OBTIENE ESTADO DEL RESGISTRO
	* @return boolean ESTADO DEL RESGISTRO
	*/
	public boolean getCPAIS_ESTADO(){
		return this.myCpais_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCpais_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCPAIS_USUARIO_INSERT(String inCpais_usuario_insert){
		this.myCpais_usuario_insert = inCpais_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCPAIS_USUARIO_INSERT(){
		return this.myCpais_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCpais_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCPAIS_USUARIO_UPDATE(String inCpais_usuario_update){
		this.myCpais_usuario_update = inCpais_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCPAIS_USUARIO_UPDATE(){
		return this.myCpais_usuario_update;
	}

}
