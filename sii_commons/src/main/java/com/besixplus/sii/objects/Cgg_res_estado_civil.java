package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_estado_civil
* TABLA: ESTADO CIVIL
* DESCRIPCION:ALMACENA INFORMACION DE ESTADOS CIVILES
* ABREVIATURA:CRECV
*/
public class Cgg_res_estado_civil implements Serializable{
	private static final long serialVersionUID = 561343021;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	*/
	private String myCrecv_codigo;
	/**
	* DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	private String myCrecv_descrpcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrecv_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrecv_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrecv_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_estado_civil
	*/
	public Cgg_res_estado_civil(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_estado_civil
	* @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	* @param inCrecv_descrpcion DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrecv_estado ESTADO DEL REGISTRO
	* @param inCrecv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrecv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_estado_civil(
		String inCrecv_codigo,
		String inCrecv_descrpcion,
		boolean inCrecv_estado,
		String inCrecv_usuario_insert,
		String inCrecv_usuario_update
	){
		this.setCRECV_CODIGO(inCrecv_codigo);
		this.setCRECV_DESCRPCION(inCrecv_descrpcion);
		this.setCRECV_ESTADO(inCrecv_estado);
		this.setCRECV_USUARIO_INSERT(inCrecv_usuario_insert);
		this.setCRECV_USUARIO_UPDATE(inCrecv_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	* @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	*/
	public void setCRECV_CODIGO(String inCrecv_codigo){
		this.myCrecv_codigo = inCrecv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	*/
	public String getCRECV_CODIGO(){
		return this.myCrecv_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrecv_descrpcion DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public void setCRECV_DESCRPCION(String inCrecv_descrpcion){
		this.myCrecv_descrpcion = inCrecv_descrpcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @return String DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public String getCRECV_DESCRPCION(){
		return this.myCrecv_descrpcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrecv_estado ESTADO DEL REGISTRO
	*/
	public void setCRECV_ESTADO(boolean inCrecv_estado){
		this.myCrecv_estado = inCrecv_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRECV_ESTADO(){
		return this.myCrecv_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrecv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRECV_USUARIO_INSERT(String inCrecv_usuario_insert){
		this.myCrecv_usuario_insert = inCrecv_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRECV_USUARIO_INSERT(){
		return this.myCrecv_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrecv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRECV_USUARIO_UPDATE(String inCrecv_usuario_update){
		this.myCrecv_usuario_update = inCrecv_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRECV_USUARIO_UPDATE(){
		return this.myCrecv_usuario_update;
	}

}
