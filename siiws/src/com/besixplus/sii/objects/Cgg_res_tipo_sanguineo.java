package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tipo_sanguineo
* TABLA: TIPO SANGUINEO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS SANGUINEOS
* ABREVIATURA:CRTSG
*/
public class Cgg_res_tipo_sanguineo implements Serializable{
	private static final long serialVersionUID = 222477863;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	*/
	private String myCrtsg_codigo;
	/**
	* DESCRIPCION DEL TIPO SANGUINEO
	*/
	private String myCrtsg_descrpcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtsg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtsg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtsg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_sanguineo
	*/
	public Cgg_res_tipo_sanguineo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_sanguineo
	* @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	* @param inCrtsg_descrpcion DESCRIPCION DEL TIPO SANGUINEO
	* @param inCrtsg_estado ESTADO DEL REGISTRO
	* @param inCrtsg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtsg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tipo_sanguineo(
		String inCrtsg_codigo,
		String inCrtsg_descrpcion,
		boolean inCrtsg_estado,
		String inCrtsg_usuario_insert,
		String inCrtsg_usuario_update
	){
		this.setCRTSG_CODIGO(inCrtsg_codigo);
		this.setCRTSG_DESCRPCION(inCrtsg_descrpcion);
		this.setCRTSG_ESTADO(inCrtsg_estado);
		this.setCRTSG_USUARIO_INSERT(inCrtsg_usuario_insert);
		this.setCRTSG_USUARIO_UPDATE(inCrtsg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	* @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	*/
	public void setCRTSG_CODIGO(String inCrtsg_codigo){
		this.myCrtsg_codigo = inCrtsg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	*/
	public String getCRTSG_CODIGO(){
		return this.myCrtsg_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO SANGUINEO
	* @param inCrtsg_descrpcion DESCRIPCION DEL TIPO SANGUINEO
	*/
	public void setCRTSG_DESCRPCION(String inCrtsg_descrpcion){
		this.myCrtsg_descrpcion = inCrtsg_descrpcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO SANGUINEO
	* @return String DESCRIPCION DEL TIPO SANGUINEO
	*/
	public String getCRTSG_DESCRPCION(){
		return this.myCrtsg_descrpcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtsg_estado ESTADO DEL REGISTRO
	*/
	public void setCRTSG_ESTADO(boolean inCrtsg_estado){
		this.myCrtsg_estado = inCrtsg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTSG_ESTADO(){
		return this.myCrtsg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtsg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTSG_USUARIO_INSERT(String inCrtsg_usuario_insert){
		this.myCrtsg_usuario_insert = inCrtsg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTSG_USUARIO_INSERT(){
		return this.myCrtsg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtsg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTSG_USUARIO_UPDATE(String inCrtsg_usuario_update){
		this.myCrtsg_usuario_update = inCrtsg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTSG_USUARIO_UPDATE(){
		return this.myCrtsg_usuario_update;
	}

}
