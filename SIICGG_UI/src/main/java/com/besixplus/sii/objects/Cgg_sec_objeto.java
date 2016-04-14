package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_objeto
* TABLA: OBJETO
* DESCRIPCION:ALMACENA INFORMACION DE LOS OBJETOS QUE CONFORMAN LA APLICACION.
* ABREVIATURA:CSOBJ
*/
public class Cgg_sec_objeto implements Serializable{
	private static final long serialVersionUID = 1085160475;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	private String myCsobj_codigo;
	/**
	* NOMBRE DEL OBJETO
	*/
	private String myCsobj_nombre;
	/**
	* RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	*/
	private String myCsobj_ruta;
	/**
	* TEXTO DESCRIPTIVO DEL OBJETO
	*/
	private String myCsobj_descripcion;
	/**
	* TIPO DE OBJETO
0 - INTERFACE VISUAL
1 - SERVICIOS WEB
	*/
	private int myCsobj_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsobj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsobj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsobj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto
	*/
	public Cgg_sec_objeto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_objeto
	* @param inCsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @param inCsobj_nombre NOMBRE DEL OBJETO
	* @param inCsobj_ruta RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	* @param inCsobj_descripcion TEXTO DESCRIPTIVO DEL OBJETO
	* @param inCsobj_tipo TIPO DE OBJETO
0 - INTERFACE VISUAL
1 - SERVICIOS WEB
	* @param inCsobj_estado ESTADO DEL REGISTRO
	* @param inCsobj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsobj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_objeto(
		String inCsobj_codigo,
		String inCsobj_nombre,
		String inCsobj_ruta,
		String inCsobj_descripcion,
		int inCsobj_tipo,
		boolean inCsobj_estado,
		String inCsobj_usuario_insert,
		String inCsobj_usuario_update
	){
		this.setCSOBJ_CODIGO(inCsobj_codigo);
		this.setCSOBJ_NOMBRE(inCsobj_nombre);
		this.setCSOBJ_RUTA(inCsobj_ruta);
		this.setCSOBJ_DESCRIPCION(inCsobj_descripcion);
		this.setCSOBJ_TIPO(inCsobj_tipo);
		this.setCSOBJ_ESTADO(inCsobj_estado);
		this.setCSOBJ_USUARIO_INSERT(inCsobj_usuario_insert);
		this.setCSOBJ_USUARIO_UPDATE(inCsobj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @param incsobj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	public void setCSOBJ_CODIGO(String inCsobj_codigo){
		this.myCsobj_codigo = inCsobj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	public String getCSOBJ_CODIGO(){
		return this.myCsobj_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL OBJETO
	* @param incsobj_nombre NOMBRE DEL OBJETO
	*/
	public void setCSOBJ_NOMBRE(String inCsobj_nombre){
		this.myCsobj_nombre = inCsobj_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL OBJETO
	* @return String NOMBRE DEL OBJETO
	*/
	public String getCSOBJ_NOMBRE(){
		return this.myCsobj_nombre;
	}

	/**
	* ESTABLECE RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	* @param incsobj_ruta RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	*/
	public void setCSOBJ_RUTA(String inCsobj_ruta){
		this.myCsobj_ruta = inCsobj_ruta;
	}
	/**
	* OBTIENE RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	* @return String RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	*/
	public String getCSOBJ_RUTA(){
		return this.myCsobj_ruta;
	}

	/**
	* ESTABLECE TEXTO DESCRIPTIVO DEL OBJETO
	* @param incsobj_descripcion TEXTO DESCRIPTIVO DEL OBJETO
	*/
	public void setCSOBJ_DESCRIPCION(String inCsobj_descripcion){
		this.myCsobj_descripcion = inCsobj_descripcion;
	}
	/**
	* OBTIENE TEXTO DESCRIPTIVO DEL OBJETO
	* @return String TEXTO DESCRIPTIVO DEL OBJETO
	*/
	public String getCSOBJ_DESCRIPCION(){
		return this.myCsobj_descripcion;
	}

	/**
	* ESTABLECE TIPO DE OBJETO
0 - INTERFACE VISUAL
1 - SERVICIOS WEB
	* @param incsobj_tipo TIPO DE OBJETO
0 - INTERFACE VISUAL
1 - SERVICIOS WEB
	*/
	public void setCSOBJ_TIPO(int inCsobj_tipo){
		this.myCsobj_tipo = inCsobj_tipo;
	}
	/**
	* OBTIENE TIPO DE OBJETO
0 - INTERFACE VISUAL
1 - SERVICIOS WEB
	* @return int TIPO DE OBJETO
0 - INTERFACE VISUAL
1 - SERVICIOS WEB
	*/
	public int getCSOBJ_TIPO(){
		return this.myCsobj_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param incsobj_estado ESTADO DEL REGISTRO
	*/
	public void setCSOBJ_ESTADO(boolean inCsobj_estado){
		this.myCsobj_estado = inCsobj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSOBJ_ESTADO(){
		return this.myCsobj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param incsobj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSOBJ_USUARIO_INSERT(String inCsobj_usuario_insert){
		this.myCsobj_usuario_insert = inCsobj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSOBJ_USUARIO_INSERT(){
		return this.myCsobj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param incsobj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSOBJ_USUARIO_UPDATE(String inCsobj_usuario_update){
		this.myCsobj_usuario_update = inCsobj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSOBJ_USUARIO_UPDATE(){
		return this.myCsobj_usuario_update;
	}

}
