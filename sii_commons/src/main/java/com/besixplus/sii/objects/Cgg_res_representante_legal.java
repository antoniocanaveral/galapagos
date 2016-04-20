package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_representante_legal
* TABLA: REPRESENTANTE LEGAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS ENCARGADOS LEGALES QUE TIENEN BAJO SU RESPONSABILIDAD UNA  EMPRESA
* ABREVIATURA:CRRPT
*/
public class Cgg_res_representante_legal implements Serializable{
	private static final long serialVersionUID = 484617986;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
	*/
	private String myCrrpt_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
	*/
	private java.util.Date myCrrpt_fecha_registro;
	/**
	* ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
	*/
	private boolean myCrrpt_activo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrrpt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrrpt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrrpt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_representante_legal
	*/
	public Cgg_res_representante_legal(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_representante_legal
	* @param inCrrpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCrrpt_fecha_registro FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
	* @param inCrrpt_activo ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
	* @param inCrrpt_estado ESTADO DEL REGISTRO
	* @param inCrrpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_representante_legal(
		String inCrrpt_codigo,
		String inCrper_codigo,
		String inCrpjr_codigo,
		java.util.Date inCrrpt_fecha_registro,
		boolean inCrrpt_activo,
		boolean inCrrpt_estado,
		String inCrrpt_usuario_insert,
		String inCrrpt_usuario_update
	){
		this.setCRRPT_CODIGO(inCrrpt_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRRPT_FECHA_REGISTRO(inCrrpt_fecha_registro);
		this.setCRRPT_ACTIVO(inCrrpt_activo);
		this.setCRRPT_ESTADO(inCrrpt_estado);
		this.setCRRPT_USUARIO_INSERT(inCrrpt_usuario_insert);
		this.setCRRPT_USUARIO_UPDATE(inCrrpt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
	* @param inCrrpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
	*/
	public void setCRRPT_CODIGO(String inCrrpt_codigo){
		this.myCrrpt_codigo = inCrrpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REPRESENTANTE LEGAL
	*/
	public String getCRRPT_CODIGO(){
		return this.myCrrpt_codigo;
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
	* ESTABLECE FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
	* @param inCrrpt_fecha_registro FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
	*/
	public void setCRRPT_FECHA_REGISTRO(java.util.Date inCrrpt_fecha_registro){
		this.myCrrpt_fecha_registro = inCrrpt_fecha_registro;
	}
	/**
	* OBTIENE FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
	* @return java.util.Date FECHA QUE SE INGRESO LA INFORMACION DEL REPRESNTANTE LEGAL
	*/
	public java.util.Date getCRRPT_FECHA_REGISTRO(){
		return this.myCrrpt_fecha_registro;
	}

	/**
	* ESTABLECE ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
	* @param inCrrpt_activo ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
	*/
	public void setCRRPT_ACTIVO(boolean inCrrpt_activo){
		this.myCrrpt_activo = inCrrpt_activo;
	}
	/**
	* OBTIENE ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
	* @return boolean ALMACENA INFORMACION DEL ESTADO DEL REPRESENTANTE LEGAL DENTRO D ELA EMPRESA
	*/
	public boolean getCRRPT_ACTIVO(){
		return this.myCrrpt_activo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrrpt_estado ESTADO DEL REGISTRO
	*/
	public void setCRRPT_ESTADO(boolean inCrrpt_estado){
		this.myCrrpt_estado = inCrrpt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRRPT_ESTADO(){
		return this.myCrrpt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRRPT_USUARIO_INSERT(String inCrrpt_usuario_insert){
		this.myCrrpt_usuario_insert = inCrrpt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRRPT_USUARIO_INSERT(){
		return this.myCrrpt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrrpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRRPT_USUARIO_UPDATE(String inCrrpt_usuario_update){
		this.myCrrpt_usuario_update = inCrrpt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRRPT_USUARIO_UPDATE(){
		return this.myCrrpt_usuario_update;
	}

}
