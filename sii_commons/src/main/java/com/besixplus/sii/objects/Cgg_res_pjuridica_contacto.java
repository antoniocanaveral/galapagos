package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_pjuridica_contacto
* TABLA: PERSONA JURIDICA  CONTACO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CONTACTOS ASOCIADOS A UNA PERSONA JURIDICA
* ABREVIATURA:CRPJC
*/
public class Cgg_res_pjuridica_contacto implements Serializable{
	private static final long serialVersionUID = 395883671;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
	*/
	private String myCrpjc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrpjr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* VALOR ASIGNADO AL CONTACTO
	*/
	private String myCrpjc_descripcion;
	/**
	* NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	private String myCrpjc_contacto;
	/**
	* CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
	*/
	private boolean myCrpjc_prinCipal;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrpjc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrpjc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrpjc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_pjuridica_contacto
	*/
	public Cgg_res_pjuridica_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_pjuridica_contacto
	* @param inCrpjc_codigo IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCrpjc_descripcion VALOR ASIGNADO AL CONTACTO
	* @param inCrpjc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCrpjc_prinCipal CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
	* @param inCrpjc_estado ESTADO DEL REGISTRO
	* @param inCrpjc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpjc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_pjuridica_contacto(
		String inCrpjc_codigo,
		String inCrpjr_codigo,
		String inCrtco_codigo,
		String inCrpjc_descripcion,
		String inCrpjc_contacto,
		boolean inCrpjc_prinCipal,
		boolean inCrpjc_estado,
		String inCrpjc_usuario_insert,
		String inCrpjc_usuario_update
	){
		this.setCRPJC_CODIGO(inCrpjc_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCRPJC_DESCRIPCION(inCrpjc_descripcion);
		this.setCRPJC_CONTACTO(inCrpjc_contacto);
		this.setCRPJC_PRINCIPAL(inCrpjc_prinCipal);
		this.setCRPJC_ESTADO(inCrpjc_estado);
		this.setCRPJC_USUARIO_INSERT(inCrpjc_usuario_insert);
		this.setCRPJC_USUARIO_UPDATE(inCrpjc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
	* @param inCrpjc_codigo IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
	*/
	public void setCRPJC_CODIGO(String inCrpjc_codigo){
		this.myCrpjc_codigo = inCrpjc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO AL CONTACTO DE LA PERSONA JURIDICA
	*/
	public String getCRPJC_CODIGO(){
		return this.myCrpjc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
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
	* @param inCrpjc_descripcion VALOR ASIGNADO AL CONTACTO
	*/
	public void setCRPJC_DESCRIPCION(String inCrpjc_descripcion){
		this.myCrpjc_descripcion = inCrpjc_descripcion;
	}
	/**
	* OBTIENE VALOR ASIGNADO AL CONTACTO
	* @return String VALOR ASIGNADO AL CONTACTO
	*/
	public String getCRPJC_DESCRIPCION(){
		return this.myCrpjc_descripcion;
	}

	/**
	* ESTABLECE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCrpjc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public void setCRPJC_CONTACTO(String inCrpjc_contacto){
		this.myCrpjc_contacto = inCrpjc_contacto;
	}
	/**
	* OBTIENE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @return String NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public String getCRPJC_CONTACTO(){
		return this.myCrpjc_contacto;
	}

	/**
	* ESTABLECE CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
	* @param inCrpjc_prinCipal CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
	*/
	public void setCRPJC_PRINCIPAL(boolean inCrpjc_prinCipal){
		this.myCrpjc_prinCipal = inCrpjc_prinCipal;
	}
	/**
	* OBTIENE CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
	* @return boolean CAMPO QUE INDICA SI EL CONTACTO ES PRINCIPAL O NO DE UN REGISTRO
	*/
	public boolean getCRPJC_PRINCIPAL(){
		return this.myCrpjc_prinCipal;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrpjc_estado ESTADO DEL REGISTRO
	*/
	public void setCRPJC_ESTADO(boolean inCrpjc_estado){
		this.myCrpjc_estado = inCrpjc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPJC_ESTADO(){
		return this.myCrpjc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpjc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPJC_USUARIO_INSERT(String inCrpjc_usuario_insert){
		this.myCrpjc_usuario_insert = inCrpjc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPJC_USUARIO_INSERT(){
		return this.myCrpjc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrpjc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPJC_USUARIO_UPDATE(String inCrpjc_usuario_update){
		this.myCrpjc_usuario_update = inCrpjc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPJC_USUARIO_UPDATE(){
		return this.myCrpjc_usuario_update;
	}

}
