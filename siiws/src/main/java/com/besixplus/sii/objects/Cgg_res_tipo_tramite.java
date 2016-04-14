package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tipo_tramite
* TABLA: TIPO TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS DIVERSOS TIPOS DE TRAMITE QUE PUEDEN LLEVARSE EN EL SISTEMA
* ABREVIATURA:CRTPT
*/
public class Cgg_res_tipo_tramite implements Serializable{
	private static final long serialVersionUID = 323488210;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	private String myCrtpt_codigo;
	/**
	* NOMBRE DEL TIPO DE TRAMITE
	*/
	private String myCrtpt_nombre;
	/**
	* ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	*/
	private String myCrtpt_abreviatura;
	/**
	* INDICE DE RELEVANCIA
	*/
	private int myCrtpt_indice;
	/**
	* OBSERVACIONES AL TIPO DE TRAMITE
	*/
	private String myCrtpt_observaciones;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtpt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtpt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtpt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_tramite
	*/
	public Cgg_res_tipo_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_tramite
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrtpt_nombre NOMBRE DEL TIPO DE TRAMITE
	* @param inCrtpt_abreviatura ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	* @param inCrtpt_indice INDICE DE RELEVANCIA
	* @param inCrtpt_observaciones OBSERVACIONES AL TIPO DE TRAMITE
	* @param inCrtpt_estado ESTADO DEL REGISTRO
	* @param inCrtpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tipo_tramite(
		String inCrtpt_codigo,
		String inCrtpt_nombre,
		String inCrtpt_abreviatura,
		int inCrtpt_indice,
		String inCrtpt_observaciones,
		boolean inCrtpt_estado,
		String inCrtpt_usuario_insert,
		String inCrtpt_usuario_update
	){
		this.setCRTPT_CODIGO(inCrtpt_codigo);
		this.setCRTPT_NOMBRE(inCrtpt_nombre);
		this.setCRTPT_ABREVIATURA(inCrtpt_abreviatura);
		this.setCRTPT_INDICE(inCrtpt_indice);
		this.setCRTPT_OBSERVACIONES(inCrtpt_observaciones);
		this.setCRTPT_ESTADO(inCrtpt_estado);
		this.setCRTPT_USUARIO_INSERT(inCrtpt_usuario_insert);
		this.setCRTPT_USUARIO_UPDATE(inCrtpt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public void setCRTPT_CODIGO(String inCrtpt_codigo){
		this.myCrtpt_codigo = inCrtpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public String getCRTPT_CODIGO(){
		return this.myCrtpt_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL TIPO DE TRAMITE
	* @param inCrtpt_nombre NOMBRE DEL TIPO DE TRAMITE
	*/
	public void setCRTPT_NOMBRE(String inCrtpt_nombre){
		this.myCrtpt_nombre = inCrtpt_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL TIPO DE TRAMITE
	* @return String NOMBRE DEL TIPO DE TRAMITE
	*/
	public String getCRTPT_NOMBRE(){
		return this.myCrtpt_nombre;
	}

	/**
	* ESTABLECE ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	* @param inCrtpt_abreviatura ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	*/
	public void setCRTPT_ABREVIATURA(String inCrtpt_abreviatura){
		this.myCrtpt_abreviatura = inCrtpt_abreviatura;
	}
	/**
	* OBTIENE ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	* @return String ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	*/
	public String getCRTPT_ABREVIATURA(){
		return this.myCrtpt_abreviatura;
	}

	/**
	* ESTABLECE INDICE DE RELEVANCIA
	* @param inCrtpt_indice INDICE DE RELEVANCIA
	*/
	public void setCRTPT_INDICE(int inCrtpt_indice){
		this.myCrtpt_indice = inCrtpt_indice;
	}
	/**
	* OBTIENE INDICE DE RELEVANCIA
	* @return int INDICE DE RELEVANCIA
	*/
	public int getCRTPT_INDICE(){
		return this.myCrtpt_indice;
	}

	/**
	* ESTABLECE OBSERVACIONES AL TIPO DE TRAMITE
	* @param inCrtpt_observaciones OBSERVACIONES AL TIPO DE TRAMITE
	*/
	public void setCRTPT_OBSERVACIONES(String inCrtpt_observaciones){
		this.myCrtpt_observaciones = inCrtpt_observaciones;
	}
	/**
	* OBTIENE OBSERVACIONES AL TIPO DE TRAMITE
	* @return String OBSERVACIONES AL TIPO DE TRAMITE
	*/
	public String getCRTPT_OBSERVACIONES(){
		return this.myCrtpt_observaciones;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtpt_estado ESTADO DEL REGISTRO
	*/
	public void setCRTPT_ESTADO(boolean inCrtpt_estado){
		this.myCrtpt_estado = inCrtpt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTPT_ESTADO(){
		return this.myCrtpt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTPT_USUARIO_INSERT(String inCrtpt_usuario_insert){
		this.myCrtpt_usuario_insert = inCrtpt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTPT_USUARIO_INSERT(){
		return this.myCrtpt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTPT_USUARIO_UPDATE(String inCrtpt_usuario_update){
		this.myCrtpt_usuario_update = inCrtpt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTPT_USUARIO_UPDATE(){
		return this.myCrtpt_usuario_update;
	}

}
