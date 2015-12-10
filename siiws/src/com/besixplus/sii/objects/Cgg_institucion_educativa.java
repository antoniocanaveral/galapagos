package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_institucion_educativa
* TABLA: INSTITUCION EDUCATIVA
* DESCRIPCION:ALMACENA INFORMACION DE LAS INSTITUCIONES EDUCATIVAS
* ABREVIATURA:CGIED
*/
public class Cgg_institucion_educativa implements Serializable{
	private static final long serialVersionUID = 1060503828;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	private String myCgied_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	private String myCpais_codigo;
	/**
	* NOMBRE DE LA INSTITUCION EDUCATIVA
	*/
	private String myCgied_nombre;
	/**
	* DESCRIPCION DE LA INSTITUCION EDUCATIVA
	*/
	private String myCgied_descripcion;
	/**
	* DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	*/
	private String myCgied_direccion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgied_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgied_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgied_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_educativa
	*/
	public Cgg_institucion_educativa(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_educativa
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 * @param inCgied_nombre NOMBRE PARA LA INSTITUCION EDUCATIVA
	* @param inCgied_descripcion DESCRIPCION DE LA INSTITUCION EDUCATIVA
	* @param inCgied_direccion DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	* @param inCgied_estado ESTADO DEL REGISTRO
	* @param inCgied_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgied_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_institucion_educativa(
		String inCgied_codigo,
		String inCpais_codigo,
		String inCgied_nombre,
		String inCgied_descripcion,
		String inCgied_direccion,
		boolean inCgied_estado,
		String inCgied_usuario_insert,
		String inCgied_usuario_update
	){
		this.setCGIED_CODIGO(inCgied_codigo);
		this.setCPAIS_CODIGO(inCpais_codigo);
		this.setCGIED_NOMBRE(inCgied_nombre);
		this.setCGIED_DESCRIPCION(inCgied_descripcion);
		this.setCGIED_DIRECCION(inCgied_direccion);
		this.setCGIED_ESTADO(inCgied_estado);
		this.setCGIED_USUARIO_INSERT(inCgied_usuario_insert);
		this.setCGIED_USUARIO_UPDATE(inCgied_usuario_update);
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
	* ESTABLECE NOMBRE PARA LA INSTITUCION EDUCATIVA
	* @param inCgied_nombre NOMBRE DE LA INSTITUCION EDUCATIVA
	*/
	public void setCGIED_NOMBRE(String inCgied_nombre){
		this.myCgied_nombre = inCgied_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA INSTITUCION EDUCATIVA
	* @return String NOMBRE DE LA INSTITUCION EDUCATIVA
	*/
	public String getCGIED_NOMBRE(){
		return this.myCgied_nombre;
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
	* ESTABLECE DESCRIPCION DE LA INSTITUCION EDUCATIVA
	* @param inCgied_descripcion DESCRIPCION DE LA INSTITUCION EDUCATIVA
	*/
	public void setCGIED_DESCRIPCION(String inCgied_descripcion){
		this.myCgied_descripcion = inCgied_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA INSTITUCION EDUCATIVA
	* @return String DESCRIPCION DE LA INSTITUCION EDUCATIVA
	*/
	public String getCGIED_DESCRIPCION(){
		return this.myCgied_descripcion;
	}

	/**
	* ESTABLECE DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	* @param inCgied_direccion DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	*/
	public void setCGIED_DIRECCION(String inCgied_direccion){
		this.myCgied_direccion = inCgied_direccion;
	}
	/**
	* OBTIENE DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	* @return String DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	*/
	public String getCGIED_DIRECCION(){
		return this.myCgied_direccion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgied_estado ESTADO DEL REGISTRO
	*/
	public void setCGIED_ESTADO(boolean inCgied_estado){
		this.myCgied_estado = inCgied_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGIED_ESTADO(){
		return this.myCgied_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgied_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGIED_USUARIO_INSERT(String inCgied_usuario_insert){
		this.myCgied_usuario_insert = inCgied_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGIED_USUARIO_INSERT(){
		return this.myCgied_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgied_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGIED_USUARIO_UPDATE(String inCgied_usuario_update){
		this.myCgied_usuario_update = inCgied_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGIED_USUARIO_UPDATE(){
		return this.myCgied_usuario_update;
	}

}
