package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_cuenta_personajuridica
* TABLA: CUENTA DE PERSONA JURIDA
* DESCRIPCION:ALMACENA INFORMACION DE LA CUENTA BACNCARIA DE UNA PERSONA JURIDICA 
* ABREVIATURA:CRCPJ
*/
public class Cgg_res_cuenta_personajuridica implements Serializable{
	private static final long serialVersionUID = 447366860;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	*/
	private String myCrcpj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO DE ENTIDAD FINANCIERA
	*/
	private String myCgg_crpjr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	*/
	private String myCrper_codigo;
	/**
	* NUMERO DE LA CUENTA BANCARIA
	*/
	private String myCrcpj_numero_cuenta;
	/**
	* DESCRIPCION DE LA CUENTA BANCARIA
	*/
	private String myCrcpj_descripcion;
	/**
	* TIPO DE CUENTA BANCARIA
	*/
	private int myCrcpj_tipo_cuenta;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrcpj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrcpj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrcpj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cuenta_personajuridica
	*/
	public Cgg_res_cuenta_personajuridica(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_cuenta_personajuridica
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	 * @param inCgg_crpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCretf_codigo IDENTIFICATIVO UNICO DE REGSITRO DE ENTIDAD FINANCIERA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	* @param inCrcpj_numero_cuenta NUMERO DE LA CUENTA BANCARIA
	* @param inCrcpj_descripcion DESCRIPCION DE LA CUENTA BANCARIA
	* @param inCrcpj_tipo_cuenta TIPO DE CUENTA BANCARIA
	* @param inCrcpj_estado ESTADO DEL REGISTRO
	* @param inCrcpj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcpj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_cuenta_personajuridica(
		String inCrcpj_codigo,
		String inCgg_crpjr_codigo,
		String inCrpjr_codigo,
		String inCrper_codigo,
		String inCrcpj_numero_cuenta,
		String inCrcpj_descripcion,
		int inCrcpj_tipo_cuenta,
		boolean inCrcpj_estado,
		String inCrcpj_usuario_insert,
		String inCrcpj_usuario_update
	){
		this.setCRCPJ_CODIGO(inCrcpj_codigo);
		this.setCGG_CRPJR_CODIGO(inCgg_crpjr_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRCPJ_NUMERO_CUENTA(inCrcpj_numero_cuenta);
		this.setCRCPJ_DESCRIPCION(inCrcpj_descripcion);
		this.setCRCPJ_TIPO_CUENTA(inCrcpj_tipo_cuenta);
		this.setCRCPJ_ESTADO(inCrcpj_estado);
		this.setCRCPJ_USUARIO_INSERT(inCrcpj_usuario_insert);
		this.setCRCPJ_USUARIO_UPDATE(inCrcpj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	*/
	public void setCRCPJ_CODIGO(String inCrcpj_codigo){
		this.myCrcpj_codigo = inCrcpj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	*/
	public String getCRCPJ_CODIGO(){
		return this.myCrcpj_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCgg_crpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCGG_CRPJR_CODIGO(String inCgg_crpjr_codigo){
		this.myCgg_crpjr_codigo = inCgg_crpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public String getCGG_CRPJR_CODIGO(){
		return this.myCgg_crpjr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE NUMERO DE LA CUENTA BANCARIA
	* @param inCrcpj_numero_cuenta NUMERO DE LA CUENTA BANCARIA
	*/
	public void setCRCPJ_NUMERO_CUENTA(String inCrcpj_numero_cuenta){
		this.myCrcpj_numero_cuenta = inCrcpj_numero_cuenta;
	}
	/**
	* OBTIENE NUMERO DE LA CUENTA BANCARIA
	* @return String NUMERO DE LA CUENTA BANCARIA
	*/
	public String getCRCPJ_NUMERO_CUENTA(){
		return this.myCrcpj_numero_cuenta;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA CUENTA BANCARIA
	* @param inCrcpj_descripcion DESCRIPCION DE LA CUENTA BANCARIA
	*/
	public void setCRCPJ_DESCRIPCION(String inCrcpj_descripcion){
		this.myCrcpj_descripcion = inCrcpj_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA CUENTA BANCARIA
	* @return String DESCRIPCION DE LA CUENTA BANCARIA
	*/
	public String getCRCPJ_DESCRIPCION(){
		return this.myCrcpj_descripcion;
	}

	/**
	* ESTABLECE TIPO DE CUENTA BANCARIA
	* @param inCrcpj_tipo_cuenta TIPO DE CUENTA BANCARIA
	*/
	public void setCRCPJ_TIPO_CUENTA(int inCrcpj_tipo_cuenta){
		this.myCrcpj_tipo_cuenta = inCrcpj_tipo_cuenta;
	}
	/**
	* OBTIENE TIPO DE CUENTA BANCARIA
	* @return int TIPO DE CUENTA BANCARIA
	*/
	public int getCRCPJ_TIPO_CUENTA(){
		return this.myCrcpj_tipo_cuenta;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrcpj_estado ESTADO DEL REGISTRO
	*/
	public void setCRCPJ_ESTADO(boolean inCrcpj_estado){
		this.myCrcpj_estado = inCrcpj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRCPJ_ESTADO(){
		return this.myCrcpj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcpj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRCPJ_USUARIO_INSERT(String inCrcpj_usuario_insert){
		this.myCrcpj_usuario_insert = inCrcpj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRCPJ_USUARIO_INSERT(){
		return this.myCrcpj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrcpj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRCPJ_USUARIO_UPDATE(String inCrcpj_usuario_update){
		this.myCrcpj_usuario_update = inCrcpj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRCPJ_USUARIO_UPDATE(){
		return this.myCrcpj_usuario_update;
	}

}
