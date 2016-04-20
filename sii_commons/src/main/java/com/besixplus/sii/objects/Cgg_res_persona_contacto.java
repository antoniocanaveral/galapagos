package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_persona_contacto
* TABLA: PERSONA CONTACO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CONTACTOS ASOCIADOS A UNA PERSONA
* ABREVIATURA:CRPRC
*/
public class Cgg_res_persona_contacto implements Serializable{
	private static final long serialVersionUID = 744682135;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrprc_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* VALOR ASIGNADO AL CONTACTO
	*/
	private String myCrprc_descripcion;
	/**
	* NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	private String myCrprc_contacto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrprc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrprc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrprc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona_contacto
	*/
	public Cgg_res_persona_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona_contacto
	* @param inCrprc_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCrprc_descripcion VALOR ASIGNADO AL CONTACTO
	* @param inCrprc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCrprc_estado ESTADO DEL REGISTRO
	* @param inCrprc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrprc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_persona_contacto(
		String inCrprc_codigo,
		String inCrper_codigo,
		String inCrtco_codigo,
		String inCrprc_descripcion,
		String inCrprc_contacto,
		boolean inCrprc_estado,
		String inCrprc_usuario_insert,
		String inCrprc_usuario_update
	){
		this.setCRPRC_CODIGO(inCrprc_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCRPRC_DESCRIPCION(inCrprc_descripcion);
		this.setCRPRC_CONTACTO(inCrprc_contacto);
		this.setCRPRC_ESTADO(inCrprc_estado);
		this.setCRPRC_USUARIO_INSERT(inCrprc_usuario_insert);
		this.setCRPRC_USUARIO_UPDATE(inCrprc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrprc_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRPRC_CODIGO(String inCrprc_codigo){
		this.myCrprc_codigo = inCrprc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRPRC_CODIGO(){
		return this.myCrprc_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	public void setCRTCO_CODIGO(String inCrtco_codigo){
		this.myCrtco_codigo = inCrtco_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	public String getCRTCO_CODIGO(){
		return this.myCrtco_codigo;
	}

	/**
	* ESTABLECE VALOR ASIGNADO AL CONTACTO
	* @param inCrprc_descripcion VALOR ASIGNADO AL CONTACTO
	*/
	public void setCRPRC_DESCRIPCION(String inCrprc_descripcion){
		this.myCrprc_descripcion = inCrprc_descripcion;
	}
	/**
	* OBTIENE VALOR ASIGNADO AL CONTACTO
	* @return String VALOR ASIGNADO AL CONTACTO
	*/
	public String getCRPRC_DESCRIPCION(){
		return this.myCrprc_descripcion;
	}

	/**
	* ESTABLECE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCrprc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public void setCRPRC_CONTACTO(String inCrprc_contacto){
		this.myCrprc_contacto = inCrprc_contacto;
	}
	/**
	* OBTIENE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @return String NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public String getCRPRC_CONTACTO(){
		return this.myCrprc_contacto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrprc_estado ESTADO DEL REGISTRO
	*/
	public void setCRPRC_ESTADO(boolean inCrprc_estado){
		this.myCrprc_estado = inCrprc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPRC_ESTADO(){
		return this.myCrprc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrprc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPRC_USUARIO_INSERT(String inCrprc_usuario_insert){
		this.myCrprc_usuario_insert = inCrprc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPRC_USUARIO_INSERT(){
		return this.myCrprc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrprc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPRC_USUARIO_UPDATE(String inCrprc_usuario_update){
		this.myCrprc_usuario_update = inCrprc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPRC_USUARIO_UPDATE(){
		return this.myCrprc_usuario_update;
	}

}
