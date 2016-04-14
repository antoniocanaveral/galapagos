package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_garantia
* TABLA: GARANTIA
* DESCRIPCION: ALMACENA LA INFORMACION DE LAS GARANTIAS A APLICARSE A LOS TRAMITES DE RESIDENCIA 
* ABREVIATURA: CRGRT
*/
public class Cgg_res_garantia implements Serializable{
	private static final long serialVersionUID = 1934008550;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrgrt_codigo;
	/**
	* DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	private String myCrgrt_descrpcion;
	/**
	* COSTO A PAGAR POR LA GARANTIA
	*/
	private java.math.BigDecimal myCrgrt_valor;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrgrt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrgrt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrgrt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_garantia
	*/
	public Cgg_res_garantia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_garantia
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrgrt_descrpcion DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrgrt_valor COSTO A PAGAR POR LA GARANTIA
	* @param inCrgrt_estado ESTADO DEL REGISTRO
	* @param inCrgrt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrgrt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_garantia(
		String inCrgrt_codigo,
		String inCrgrt_descrpcion,
		java.math.BigDecimal inCrgrt_valor,
		boolean inCrgrt_estado,
		String inCrgrt_usuario_insert,
		String inCrgrt_usuario_update
	){
		this.setCRGRT_CODIGO(inCrgrt_codigo);
		this.setCRGRT_DESCRPCION(inCrgrt_descrpcion);
		this.setCRGRT_VALOR(inCrgrt_valor);
		this.setCRGRT_ESTADO(inCrgrt_estado);
		this.setCRGRT_USUARIO_INSERT(inCrgrt_usuario_insert);
		this.setCRGRT_USUARIO_UPDATE(inCrgrt_usuario_update);
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRGRT_CODIGO(String inCrgrt_codigo){
		this.myCrgrt_codigo = inCrgrt_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRGRT_CODIGO(){
		return this.myCrgrt_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrgrt_descrpcion DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public void setCRGRT_DESCRPCION(String inCrgrt_descrpcion){
		this.myCrgrt_descrpcion = inCrgrt_descrpcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @return String DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public String getCRGRT_DESCRPCION(){
		return this.myCrgrt_descrpcion;
	}

	/**
	* ESTABLECE COSTO A PAGAR POR LA GARANTIA
	* @param inCrgrt_valor COSTO A PAGAR POR LA GARANTIA
	*/
	public void setCRGRT_VALOR(java.math.BigDecimal inCrgrt_valor){
		this.myCrgrt_valor = inCrgrt_valor;
	}
	/**
	* OBTIENE COSTO A PAGAR POR LA GARANTIA
	* @return java.math.BigDecimal COSTO A PAGAR POR LA GARANTIA
	*/
	public java.math.BigDecimal getCRGRT_VALOR(){
		return this.myCrgrt_valor;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrgrt_estado ESTADO DEL REGISTRO
	*/
	public void setCRGRT_ESTADO(boolean inCrgrt_estado){
		this.myCrgrt_estado = inCrgrt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRGRT_ESTADO(){
		return this.myCrgrt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrgrt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRGRT_USUARIO_INSERT(String inCrgrt_usuario_insert){
		this.myCrgrt_usuario_insert = inCrgrt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRGRT_USUARIO_INSERT(){
		return this.myCrgrt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrgrt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRGRT_USUARIO_UPDATE(String inCrgrt_usuario_update){
		this.myCrgrt_usuario_update = inCrgrt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRGRT_USUARIO_UPDATE(){
		return this.myCrgrt_usuario_update;
	}

}
