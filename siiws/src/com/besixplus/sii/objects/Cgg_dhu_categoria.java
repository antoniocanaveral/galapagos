package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_categoria
* TABLA: CATEGORIA
* DESCRIPCION:ALMACENA INFORMACION DE LAS CATEGORIAS EN LAS QUE SE PUEDEN AGRUPAR LAS PREGUNTAS
* ABREVIATURA:CDCAT
*/
public class Cgg_dhu_categoria implements Serializable{
	private static final long serialVersionUID = 46990166;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	private String myCdcat_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	private String myCgg_cdcat_codigo;
	/**
	* NOMBRE DE LA CATEGORIA
	*/
	private String myCdcat_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdcat_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdcat_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdcat_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_categoria
	*/
	public Cgg_dhu_categoria(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_categoria
	* @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @param inCgg_cdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @param inCdcat_nombre NOMBRE DE LA CATEGORIA
	* @param inCdcat_estado ESTADO DEL REGISTRO
	* @param inCdcat_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcat_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_categoria(
		String inCdcat_codigo,
		String inCgg_cdcat_codigo,
		String inCdcat_nombre,
		boolean inCdcat_estado,
		String inCdcat_usuario_insert,
		String inCdcat_usuario_update
	){
		this.setCDCAT_CODIGO(inCdcat_codigo);
		this.setCGG_CDCAT_CODIGO(inCgg_cdcat_codigo);
		this.setCDCAT_NOMBRE(inCdcat_nombre);
		this.setCDCAT_ESTADO(inCdcat_estado);
		this.setCDCAT_USUARIO_INSERT(inCdcat_usuario_insert);
		this.setCDCAT_USUARIO_UPDATE(inCdcat_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	public void setCDCAT_CODIGO(String inCdcat_codigo){
		this.myCdcat_codigo = inCdcat_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	public String getCDCAT_CODIGO(){
		return this.myCdcat_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @param inCgg_cdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	public void setCGG_CDCAT_CODIGO(String inCgg_cdcat_codigo){
		this.myCgg_cdcat_codigo = inCgg_cdcat_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	*/
	public String getCGG_CDCAT_CODIGO(){
		return this.myCgg_cdcat_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA CATEGORIA
	* @param inCdcat_nombre NOMBRE DE LA CATEGORIA
	*/
	public void setCDCAT_NOMBRE(String inCdcat_nombre){
		this.myCdcat_nombre = inCdcat_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA CATEGORIA
	* @return String NOMBRE DE LA CATEGORIA
	*/
	public String getCDCAT_NOMBRE(){
		return this.myCdcat_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdcat_estado ESTADO DEL REGISTRO
	*/
	public void setCDCAT_ESTADO(boolean inCdcat_estado){
		this.myCdcat_estado = inCdcat_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDCAT_ESTADO(){
		return this.myCdcat_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcat_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDCAT_USUARIO_INSERT(String inCdcat_usuario_insert){
		this.myCdcat_usuario_insert = inCdcat_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDCAT_USUARIO_INSERT(){
		return this.myCdcat_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdcat_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDCAT_USUARIO_UPDATE(String inCdcat_usuario_update){
		this.myCdcat_usuario_update = inCdcat_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDCAT_USUARIO_UPDATE(){
		return this.myCdcat_usuario_update;
	}

}
