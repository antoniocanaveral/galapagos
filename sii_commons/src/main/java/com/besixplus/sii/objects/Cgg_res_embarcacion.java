package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_embarcacion
* TABLA: EMBARCACION
* DESCRIPCION:ALMACENA INFORMACION DE EMBARCACIONES AUTORIZADAS PARA BRINDAR SERVICIO DE TRANSPORTE DE PASAJEROS
* ABREVIATURA:CREMB
*/
public class Cgg_res_embarcacion implements Serializable{
	private static final long serialVersionUID = 2010293535;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCremb_codigo;
	/**
	* NOMBRE DE LA EMBARCACION
	*/
	private String myCremb_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCremb_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCremb_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCremb_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_embarcacion
	*/
	public Cgg_res_embarcacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_embarcacion
	* @param inCremb_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCremb_nombre NOMBRE DE LA EMBARCACION
	* @param inCremb_estado ESTADO DEL REGISTRO
	* @param inCremb_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCremb_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_embarcacion(
		String inCremb_codigo,
		String inCremb_nombre,
		boolean inCremb_estado,
		String inCremb_usuario_insert,
		String inCremb_usuario_update
	){
		this.setCREMB_CODIGO(inCremb_codigo);
		this.setCREMB_NOMBRE(inCremb_nombre);
		this.setCREMB_ESTADO(inCremb_estado);
		this.setCREMB_USUARIO_INSERT(inCremb_usuario_insert);
		this.setCREMB_USUARIO_UPDATE(inCremb_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCremb_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCREMB_CODIGO(String inCremb_codigo){
		this.myCremb_codigo = inCremb_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCREMB_CODIGO(){
		return this.myCremb_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA EMBARCACION
	* @param inCremb_nombre NOMBRE DE LA EMBARCACION
	*/
	public void setCREMB_NOMBRE(String inCremb_nombre){
		this.myCremb_nombre = inCremb_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA EMBARCACION
	* @return String NOMBRE DE LA EMBARCACION
	*/
	public String getCREMB_NOMBRE(){
		return this.myCremb_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCremb_estado ESTADO DEL REGISTRO
	*/
	public void setCREMB_ESTADO(boolean inCremb_estado){
		this.myCremb_estado = inCremb_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCREMB_ESTADO(){
		return this.myCremb_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCremb_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCREMB_USUARIO_INSERT(String inCremb_usuario_insert){
		this.myCremb_usuario_insert = inCremb_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCREMB_USUARIO_INSERT(){
		return this.myCremb_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCremb_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCREMB_USUARIO_UPDATE(String inCremb_usuario_update){
		this.myCremb_usuario_update = inCremb_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCREMB_USUARIO_UPDATE(){
		return this.myCremb_usuario_update;
	}

}
