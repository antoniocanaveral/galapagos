package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_
* TABLA: 
* DESCRIPCION:ALMACENA INFORMACION DE
* ABREVIATURA:CD
*/
public class Cgg_dhu_ implements Serializable{
	private static final long serialVersionUID = 102999642;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String my_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean my_estado;
	/**
	* FECHA DE INGRESO DE INFORMACION AL SISTEMA
	*/
	private java.util.Date my_fecha_insert;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String my_usuario_insert;
	/**
	* FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private java.util.Date my_fecha_update;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String my_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_
	*/
	public Cgg_dhu_(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_
	* @param in_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param in_estado ESTADO DEL REGISTRO
	* @param in_fecha_insert FECHA DE INGRESO DE INFORMACION AL SISTEMA
	* @param in_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param in_fecha_update FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param in_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_(
		String in_codigo,
		boolean in_estado,
		java.util.Date in_fecha_insert,
		String in_usuario_insert,
		java.util.Date in_fecha_update,
		String in_usuario_update
	){
		this.set_CODIGO(in_codigo);
		this.set_ESTADO(in_estado);
		this.set_FECHA_INSERT(in_fecha_insert);
		this.set_USUARIO_INSERT(in_usuario_insert);
		this.set_FECHA_UPDATE(in_fecha_update);
		this.set_USUARIO_UPDATE(in_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param in_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void set_CODIGO(String in_codigo){
		this.my_codigo = in_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String get_CODIGO(){
		return this.my_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param in_estado ESTADO DEL REGISTRO
	*/
	public void set_ESTADO(boolean in_estado){
		this.my_estado = in_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean get_ESTADO(){
		return this.my_estado;
	}

	/**
	* ESTABLECE FECHA DE INGRESO DE INFORMACION AL SISTEMA
	* @param in_fecha_insert FECHA DE INGRESO DE INFORMACION AL SISTEMA
	*/
	public void set_FECHA_INSERT(java.util.Date in_fecha_insert){
		this.my_fecha_insert = in_fecha_insert;
	}
	/**
	* OBTIENE FECHA DE INGRESO DE INFORMACION AL SISTEMA
	* @return java.util.Date FECHA DE INGRESO DE INFORMACION AL SISTEMA
	*/
	public java.util.Date get_FECHA_INSERT(){
		return this.my_fecha_insert;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param in_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void set_USUARIO_INSERT(String in_usuario_insert){
		this.my_usuario_insert = in_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String get_USUARIO_INSERT(){
		return this.my_usuario_insert;
	}

	/**
	* ESTABLECE FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param in_fecha_update FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void set_FECHA_UPDATE(java.util.Date in_fecha_update){
		this.my_fecha_update = in_fecha_update;
	}
	/**
	* OBTIENE FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return java.util.Date FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public java.util.Date get_FECHA_UPDATE(){
		return this.my_fecha_update;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param in_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void set_USUARIO_UPDATE(String in_usuario_update){
		this.my_usuario_update = in_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String get_USUARIO_UPDATE(){
		return this.my_usuario_update;
	}

}
