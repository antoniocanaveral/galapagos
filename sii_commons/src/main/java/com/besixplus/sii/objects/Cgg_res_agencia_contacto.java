package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_agencia_contacto
* TABLA: AGENCIA CONTACO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CONTACTOS ASOCIADOS A UNA AGENCIA
* ABREVIATURA:CWCAG
*/
public class Cgg_res_agencia_contacto implements Serializable{
	private static final long serialVersionUID = 1604714380;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwcag_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwage_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* VALOR ASIGNADO AL CONTACTO
	*/
	private String myCwcag_descripcion;
	/**
	* NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	private String myCwcag_contacto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCwcag_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCwcag_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCwcag_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_agencia_contacto
	*/
	public Cgg_res_agencia_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_agencia_contacto
	* @param inCwcag_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwage_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCwcag_descripcion VALOR ASIGNADO AL CONTACTO
	* @param inCwcag_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCwcag_estado ESTADO DEL REGISTRO
	* @param inCwcag_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwcag_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_agencia_contacto(
		String inCwcag_codigo,
		String inCwage_codigo,
		String inCrtco_codigo,
		String inCwcag_descripcion,
		String inCwcag_contacto,
		boolean inCwcag_estado,
		String inCwcag_usuario_insert,
		String inCwcag_usuario_update
	){
		this.setCWCAG_CODIGO(inCwcag_codigo);
		this.setCWAGE_CODIGO(inCwage_codigo);
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCWCAG_DESCRIPCION(inCwcag_descripcion);
		this.setCWCAG_CONTACTO(inCwcag_contacto);
		this.setCWCAG_ESTADO(inCwcag_estado);
		this.setCWCAG_USUARIO_INSERT(inCwcag_usuario_insert);
		this.setCWCAG_USUARIO_UPDATE(inCwcag_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwcag_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCWCAG_CODIGO(String inCwcag_codigo){
		this.myCwcag_codigo = inCwcag_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCWCAG_CODIGO(){
		return this.myCwcag_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwage_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCWAGE_CODIGO(String inCwage_codigo){
		this.myCwage_codigo = inCwage_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCWAGE_CODIGO(){
		return this.myCwage_codigo;
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
	* @param inCwcag_descripcion VALOR ASIGNADO AL CONTACTO
	*/
	public void setCWCAG_DESCRIPCION(String inCwcag_descripcion){
		this.myCwcag_descripcion = inCwcag_descripcion;
	}
	/**
	* OBTIENE VALOR ASIGNADO AL CONTACTO
	* @return String VALOR ASIGNADO AL CONTACTO
	*/
	public String getCWCAG_DESCRIPCION(){
		return this.myCwcag_descripcion;
	}

	/**
	* ESTABLECE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCwcag_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public void setCWCAG_CONTACTO(String inCwcag_contacto){
		this.myCwcag_contacto = inCwcag_contacto;
	}
	/**
	* OBTIENE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @return String NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public String getCWCAG_CONTACTO(){
		return this.myCwcag_contacto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCwcag_estado ESTADO DEL REGISTRO
	*/
	public void setCWCAG_ESTADO(boolean inCwcag_estado){
		this.myCwcag_estado = inCwcag_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCWCAG_ESTADO(){
		return this.myCwcag_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwcag_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCWCAG_USUARIO_INSERT(String inCwcag_usuario_insert){
		this.myCwcag_usuario_insert = inCwcag_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCWCAG_USUARIO_INSERT(){
		return this.myCwcag_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCwcag_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCWCAG_USUARIO_UPDATE(String inCwcag_usuario_update){
		this.myCwcag_usuario_update = inCwcag_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCWCAG_USUARIO_UPDATE(){
		return this.myCwcag_usuario_update;
	}

}
