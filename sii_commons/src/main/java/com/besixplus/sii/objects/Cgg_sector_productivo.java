package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sector_productivo
* TABLA: SECTOR PRODUCTIVO
* DESCRIPCION:ALMACENA INFORMACION DE LOS IDENTIFICADORES DE LOS SECTORES PRODUCTIVOS QUE OFRECE LA PROVINCIA.
* ABREVIATURA:CSCTP
*/
public class Cgg_sector_productivo implements Serializable{
	private static final long serialVersionUID = 278565452;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	*/
	private String myCgg_csctp_codigo;
	/**
	* NOMBRE DEL SECTOR PRODUCTIVO
	*/
	private String myCsctp_nombre;
	/**
	* ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
	*/
	private String myCsctp_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsctp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsctp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsctp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sector_productivo
	*/
	public Cgg_sector_productivo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sector_productivo
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCgg_csctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	* @param inCsctp_nombre NOMBRE DEL SECTOR PRODUCTIVO
	* @param inCsctp_descripcion ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
	* @param inCsctp_estado ESTADO DEL REGISTRO
	* @param inCsctp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsctp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sector_productivo(
		String inCsctp_codigo,
		String inCgg_csctp_codigo,
		String inCsctp_nombre,
		String inCsctp_descripcion,
		boolean inCsctp_estado,
		String inCsctp_usuario_insert,
		String inCsctp_usuario_update
	){
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCGG_CSCTP_CODIGO(inCgg_csctp_codigo);
		this.setCSCTP_NOMBRE(inCsctp_nombre);
		this.setCSCTP_DESCRIPCION(inCsctp_descripcion);
		this.setCSCTP_ESTADO(inCsctp_estado);
		this.setCSCTP_USUARIO_INSERT(inCsctp_usuario_insert);
		this.setCSCTP_USUARIO_UPDATE(inCsctp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	public void setCSCTP_CODIGO(String inCsctp_codigo){
		this.myCsctp_codigo = inCsctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	public String getCSCTP_CODIGO(){
		return this.myCsctp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	* @param inCgg_csctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	*/
	public void setCGG_CSCTP_CODIGO(String inCgg_csctp_codigo){
		this.myCgg_csctp_codigo = inCgg_csctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	*/
	public String getCGG_CSCTP_CODIGO(){
		return this.myCgg_csctp_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL SECTOR PRODUCTIVO
	* @param inCsctp_nombre NOMBRE DEL SECTOR PRODUCTIVO
	*/
	public void setCSCTP_NOMBRE(String inCsctp_nombre){
		this.myCsctp_nombre = inCsctp_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL SECTOR PRODUCTIVO
	* @return String NOMBRE DEL SECTOR PRODUCTIVO
	*/
	public String getCSCTP_NOMBRE(){
		return this.myCsctp_nombre;
	}

	/**
	* ESTABLECE ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
	* @param inCsctp_descripcion ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
	*/
	public void setCSCTP_DESCRIPCION(String inCsctp_descripcion){
		this.myCsctp_descripcion = inCsctp_descripcion;
	}
	/**
	* OBTIENE ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
	* @return String ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
	*/
	public String getCSCTP_DESCRIPCION(){
		return this.myCsctp_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsctp_estado ESTADO DEL REGISTRO
	*/
	public void setCSCTP_ESTADO(boolean inCsctp_estado){
		this.myCsctp_estado = inCsctp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSCTP_ESTADO(){
		return this.myCsctp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsctp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSCTP_USUARIO_INSERT(String inCsctp_usuario_insert){
		this.myCsctp_usuario_insert = inCsctp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSCTP_USUARIO_INSERT(){
		return this.myCsctp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsctp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSCTP_USUARIO_UPDATE(String inCsctp_usuario_update){
		this.myCsctp_usuario_update = inCsctp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSCTP_USUARIO_UPDATE(){
		return this.myCsctp_usuario_update;
	}

}
