package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_institucion_responsable
* TABLA: INSTITUCION RESPONSABLE
* DESCRIPCION:ALMACENA INFORMACION DE LAS INSTITUCIONES RESPONSABLES DE LOS CURSOS DE INDUCCION,CAPACITACION Y FORMACION
* ABREVIATURA:CDITR
*/
public class Cgg_dhu_institucion_responsable implements Serializable{
	private static final long serialVersionUID = 227867355;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	*/
	private String myCditr_codigo;
	/**
	* NOMBRE DE LA INSTITUCION RESPONSABLE
	*/
	private String myCditr_nombre;
	/**
	* DESCRIPCION DE 
	*/
	private String myCditr_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCditr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCditr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCditr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_institucion_responsable
	*/
	public Cgg_dhu_institucion_responsable(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_institucion_responsable
	* @param inCditr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	* @param inCditr_nombre NOMBRE DE LA INSTITUCION RESPONSABLE
	* @param inCditr_descripcion DESCRIPCION DE 
	* @param inCditr_estado ESTADO DEL REGISTRO
	* @param inCditr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCditr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_institucion_responsable(
		String inCditr_codigo,
		String inCditr_nombre,
		String inCditr_descripcion,
		boolean inCditr_estado,
		String inCditr_usuario_insert,
		String inCditr_usuario_update
	){
		this.setCDITR_CODIGO(inCditr_codigo);
		this.setCDITR_NOMBRE(inCditr_nombre);
		this.setCDITR_DESCRIPCION(inCditr_descripcion);
		this.setCDITR_ESTADO(inCditr_estado);
		this.setCDITR_USUARIO_INSERT(inCditr_usuario_insert);
		this.setCDITR_USUARIO_UPDATE(inCditr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	* @param inCditr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	*/
	public void setCDITR_CODIGO(String inCditr_codigo){
		this.myCditr_codigo = inCditr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	*/
	public String getCDITR_CODIGO(){
		return this.myCditr_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA INSTITUCION RESPONSABLE
	* @param inCditr_nombre NOMBRE DE LA INSTITUCION RESPONSABLE
	*/
	public void setCDITR_NOMBRE(String inCditr_nombre){
		this.myCditr_nombre = inCditr_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA INSTITUCION RESPONSABLE
	* @return String NOMBRE DE LA INSTITUCION RESPONSABLE
	*/
	public String getCDITR_NOMBRE(){
		return this.myCditr_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DE 
	* @param inCditr_descripcion DESCRIPCION DE 
	*/
	public void setCDITR_DESCRIPCION(String inCditr_descripcion){
		this.myCditr_descripcion = inCditr_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE 
	* @return String DESCRIPCION DE 
	*/
	public String getCDITR_DESCRIPCION(){
		return this.myCditr_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCditr_estado ESTADO DEL REGISTRO
	*/
	public void setCDITR_ESTADO(boolean inCditr_estado){
		this.myCditr_estado = inCditr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDITR_ESTADO(){
		return this.myCditr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCditr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDITR_USUARIO_INSERT(String inCditr_usuario_insert){
		this.myCditr_usuario_insert = inCditr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDITR_USUARIO_INSERT(){
		return this.myCditr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCditr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDITR_USUARIO_UPDATE(String inCditr_usuario_update){
		this.myCditr_usuario_update = inCditr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDITR_USUARIO_UPDATE(){
		return this.myCditr_usuario_update;
	}

}
