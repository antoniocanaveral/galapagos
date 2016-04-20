package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_especialidad
* TABLA: ESPECIALIDAD
* DESCRIPCION:ALMACENA INFORMACION DE LAS ESPECIALIDADES O PROFESIONES
* ABREVIATURA:CGESP
*/
public class Cgg_especialidad implements Serializable{
	private static final long serialVersionUID = 1514818810;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	private String myCgesp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgnes_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgnes_descripcion;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgesp_nombre;
	/**
	* DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	*/
	private String myCgesp_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgesp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgesp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgesp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_especialidad
	*/
	public Cgg_especialidad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_especialidad
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgnes_descripcion DESCRIPCION DEL NIVEL DE ESTUDIO
	* @param inCgesp_nombre NO ESPECIFICADO
	* @param inCgesp_descripcion DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	* @param inCgesp_estado ESTADO DEL REGISTRO
	* @param inCgesp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgesp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_especialidad(
		String inCgesp_codigo,
		String inCgnes_codigo,
		String inCgnes_descripcion,
		String inCgesp_nombre,
		String inCgesp_descripcion,
		boolean inCgesp_estado,
		String inCgesp_usuario_insert,
		String inCgesp_usuario_update
	){
		this.setCGESP_CODIGO(inCgesp_codigo);
		this.setCGNES_CODIGO(inCgnes_codigo);
		this.setCGNES_DESCRIPCION(inCgnes_descripcion);
		this.setCGESP_NOMBRE(inCgesp_nombre);
		this.setCGESP_DESCRIPCION(inCgesp_descripcion);
		this.setCGESP_ESTADO(inCgesp_estado);
		this.setCGESP_USUARIO_INSERT(inCgesp_usuario_insert);
		this.setCGESP_USUARIO_UPDATE(inCgesp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	public void setCGESP_CODIGO(String inCgesp_codigo){
		this.myCgesp_codigo = inCgesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	public String getCGESP_CODIGO(){
		return this.myCgesp_codigo;
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
	* ESTABLECE LA DESCRIPCION DEL NIVEL DE ESTUDIO
	* @param inCgnes_descripcion DESCRIPCION DEL NIVEL DE ESTUDIO
	*/
	public void setCGNES_DESCRIPCION(String inCgnes_descripcion){
		this.myCgnes_descripcion = inCgnes_descripcion;
	}
	/**
	* OBTIENE LA DESCRIPCION DEL NIVEL DE ESTUDIO
	* @return String DESCRIPCION DEL NIVEL DE ESTUDIO
	*/
	public String getCGNES_DESCRIPCION(){
		return this.myCgnes_descripcion;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgesp_nombre NO ESPECIFICADO
	*/
	public void setCGESP_NOMBRE(String inCgesp_nombre){
		this.myCgesp_nombre = inCgesp_nombre;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGESP_NOMBRE(){
		return this.myCgesp_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	* @param inCgesp_descripcion DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	*/
	public void setCGESP_DESCRIPCION(String inCgesp_descripcion){
		this.myCgesp_descripcion = inCgesp_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	* @return String DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	*/
	public String getCGESP_DESCRIPCION(){
		return this.myCgesp_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgesp_estado ESTADO DEL REGISTRO
	*/
	public void setCGESP_ESTADO(boolean inCgesp_estado){
		this.myCgesp_estado = inCgesp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGESP_ESTADO(){
		return this.myCgesp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgesp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGESP_USUARIO_INSERT(String inCgesp_usuario_insert){
		this.myCgesp_usuario_insert = inCgesp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGESP_USUARIO_INSERT(){
		return this.myCgesp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgesp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGESP_USUARIO_UPDATE(String inCgesp_usuario_update){
		this.myCgesp_usuario_update = inCgesp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGESP_USUARIO_UPDATE(){
		return this.myCgesp_usuario_update;
	}

}
