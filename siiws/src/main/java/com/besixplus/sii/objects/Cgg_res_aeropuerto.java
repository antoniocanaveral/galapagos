package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_aeropuerto
* TABLA: AEROPUERTO
* DESCRIPCION:ALMACENA INFORMACION DE AEROPUERTOS
* ABREVIATURA:CARPT
*/
public class Cgg_res_aeropuerto implements Serializable{
	private static final long serialVersionUID = 35597519;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCarpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE DEL AEROPUERTO
	*/
	private String myCarpt_nombre;
	/**
	* IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
	*/
	private int myCarpt_tipo_aereopuerto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCarpt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCarpt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCarpt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_aeropuerto
	*/
	public Cgg_res_aeropuerto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_aeropuerto
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCarpt_nombre NOMBRE DEL AEROPUERTO
	* @param inCarpt_tipo_aereopuerto IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
	* @param inCarpt_estado ESTADO DEL REGISTRO
	* @param inCarpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCarpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_aeropuerto(
		String inCarpt_codigo,
		String inCctn_codigo,
		String inCarpt_nombre,
		int inCarpt_tipo_aereopuerto,
		boolean inCarpt_estado,
		String inCarpt_usuario_insert,
		String inCarpt_usuario_update
	){
		this.setCARPT_CODIGO(inCarpt_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCARPT_NOMBRE(inCarpt_nombre);
		this.setCARPT_TIPO_AEREOPUERTO(inCarpt_tipo_aereopuerto);
		this.setCARPT_ESTADO(inCarpt_estado);
		this.setCARPT_USUARIO_INSERT(inCarpt_usuario_insert);
		this.setCARPT_USUARIO_UPDATE(inCarpt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCARPT_CODIGO(String inCarpt_codigo){
		this.myCarpt_codigo = inCarpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCARPT_CODIGO(){
		return this.myCarpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL AEROPUERTO
	* @param inCarpt_nombre NOMBRE DEL AEROPUERTO
	*/
	public void setCARPT_NOMBRE(String inCarpt_nombre){
		this.myCarpt_nombre = inCarpt_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL AEROPUERTO
	* @return String NOMBRE DEL AEROPUERTO
	*/
	public String getCARPT_NOMBRE(){
		return this.myCarpt_nombre;
	}

	/**
	* ESTABLECE IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
	* @param inCarpt_tipo_aereopuerto IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
	*/
	public void setCARPT_TIPO_AEREOPUERTO(int inCarpt_tipo_aereopuerto){
		this.myCarpt_tipo_aereopuerto = inCarpt_tipo_aereopuerto;
	}
	/**
	* OBTIENE IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
	* @return int IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
	*/
	public int getCARPT_TIPO_AEREOPUERTO(){
		return this.myCarpt_tipo_aereopuerto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCarpt_estado ESTADO DEL REGISTRO
	*/
	public void setCARPT_ESTADO(boolean inCarpt_estado){
		this.myCarpt_estado = inCarpt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCARPT_ESTADO(){
		return this.myCarpt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCarpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCARPT_USUARIO_INSERT(String inCarpt_usuario_insert){
		this.myCarpt_usuario_insert = inCarpt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCARPT_USUARIO_INSERT(){
		return this.myCarpt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCarpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCARPT_USUARIO_UPDATE(String inCarpt_usuario_update){
		this.myCarpt_usuario_update = inCarpt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCARPT_USUARIO_UPDATE(){
		return this.myCarpt_usuario_update;
	}

}
