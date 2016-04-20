package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_estado_tramite
* TABLA: ESTADO TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS ESTADOS QUE PUEDE TENER UN TRAMITE
* ABREVIATURA:CRETT
*/
public class Cgg_res_estado_tramite implements Serializable{
	private static final long serialVersionUID = 1027712565;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrett_codigo;
	/**
	* NOMBRE DEL ESTADO DEL TRAMITE
	*/
	private String myCrett_nombre;
	/**
	* ABREVIATURA DEL ESTADO DEL TRAMITE
	*/
	private String myCrett_abreviatura;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrett_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrett_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrett_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_estado_tramite
	*/
	public Cgg_res_estado_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_estado_tramite
	* @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrett_nombre NOMBRE DEL ESTADO DEL TRAMITE
	* @param inCrett_abreviatura ABREVIATURA DEL ESTADO DEL TRAMITE
	* @param inCrett_estado ESTADO DEL REGISTRO
	* @param inCrett_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrett_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_estado_tramite(
		String inCrett_codigo,
		String inCrett_nombre,
		String inCrett_abreviatura,
		boolean inCrett_estado,
		String inCrett_usuario_insert,
		String inCrett_usuario_update
	){
		this.setCRETT_CODIGO(inCrett_codigo);
		this.setCRETT_NOMBRE(inCrett_nombre);
		this.setCRETT_ABREVIATURA(inCrett_abreviatura);
		this.setCRETT_ESTADO(inCrett_estado);
		this.setCRETT_USUARIO_INSERT(inCrett_usuario_insert);
		this.setCRETT_USUARIO_UPDATE(inCrett_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRETT_CODIGO(String inCrett_codigo){
		this.myCrett_codigo = inCrett_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRETT_CODIGO(){
		return this.myCrett_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL ESTADO DEL TRAMITE
	* @param inCrett_nombre NOMBRE DEL ESTADO DEL TRAMITE
	*/
	public void setCRETT_NOMBRE(String inCrett_nombre){
		this.myCrett_nombre = inCrett_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL ESTADO DEL TRAMITE
	* @return String NOMBRE DEL ESTADO DEL TRAMITE
	*/
	public String getCRETT_NOMBRE(){
		return this.myCrett_nombre;
	}

	/**
	* ESTABLECE ABREVIATURA DEL ESTADO DEL TRAMITE
	* @param inCrett_abreviatura ABREVIATURA DEL ESTADO DEL TRAMITE
	*/
	public void setCRETT_ABREVIATURA(String inCrett_abreviatura){
		this.myCrett_abreviatura = inCrett_abreviatura;
	}
	/**
	* OBTIENE ABREVIATURA DEL ESTADO DEL TRAMITE
	* @return String ABREVIATURA DEL ESTADO DEL TRAMITE
	*/
	public String getCRETT_ABREVIATURA(){
		return this.myCrett_abreviatura;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrett_estado ESTADO DEL REGISTRO
	*/
	public void setCRETT_ESTADO(boolean inCrett_estado){
		this.myCrett_estado = inCrett_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRETT_ESTADO(){
		return this.myCrett_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrett_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRETT_USUARIO_INSERT(String inCrett_usuario_insert){
		this.myCrett_usuario_insert = inCrett_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRETT_USUARIO_INSERT(){
		return this.myCrett_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrett_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRETT_USUARIO_UPDATE(String inCrett_usuario_update){
		this.myCrett_usuario_update = inCrett_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRETT_USUARIO_UPDATE(){
		return this.myCrett_usuario_update;
	}

}
