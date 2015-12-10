package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_certificado
* TABLA: CERTIFICADO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CERTIFICADOS EMITIDOS POR EL ESTATUS MIGRATORIO DE LAS PERSONAS EN LA PROVINCIA
* ABREVIATURA:CRCRT
*/
public class Cgg_res_certificado implements Serializable{
	private static final long serialVersionUID = 1780893067;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	*/
	private String myCrcrt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	private String myCrrsd_codigo;
	/**
	* FECHA DE EMISION DEL CERTIFICADO
	*/
	private java.util.Date myCrcrt_fecha_emision;
	/**
	* NUMERO SECUENCIAL UNICO DEL CERTIFICADO
	*/
	private String myCrcrt_numero;
	/**
	* DESCRIPCION DEL CUERPO DEL CERTIFICADO
	*/
	private String myCrcrt_contenido;
	/**
	* ANIO DE EMISION DEL CERTIFICADO
	*/
	private int myCrcrt_anio;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrcrt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrcrt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrcrt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_certificado
	*/
	public Cgg_res_certificado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_certificado
	* @param inCrcrt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrcrt_fecha_emision FECHA DE EMISION DEL CERTIFICADO
	* @param inCrcrt_numero NUMERO SECUENCIAL UNICO DEL CERTIFICADO
	* @param inCrcrt_contenido DESCRIPCION DEL CUERPO DEL CERTIFICADO
	* @param inCrcrt_anio ANIO DE EMISION DEL CERTIFICADO
	* @param inCrcrt_estado ESTADO DEL REGISTRO
	* @param inCrcrt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcrt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_certificado(
		String inCrcrt_codigo,
		String inCrrsd_codigo,
		java.util.Date inCrcrt_fecha_emision,
		String inCrcrt_numero,
		String inCrcrt_contenido,
		int inCrcrt_anio,
		boolean inCrcrt_estado,
		String inCrcrt_usuario_insert,
		String inCrcrt_usuario_update
	){
		this.setCRCRT_CODIGO(inCrcrt_codigo);
		this.setCRRSD_CODIGO(inCrrsd_codigo);
		this.setCRCRT_FECHA_EMISION(inCrcrt_fecha_emision);
		this.setCRCRT_NUMERO(inCrcrt_numero);
		this.setCRCRT_CONTENIDO(inCrcrt_contenido);
		this.setCRCRT_ANIO(inCrcrt_anio);
		this.setCRCRT_ESTADO(inCrcrt_estado);
		this.setCRCRT_USUARIO_INSERT(inCrcrt_usuario_insert);
		this.setCRCRT_USUARIO_UPDATE(inCrcrt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	* @param inCrcrt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	*/
	public void setCRCRT_CODIGO(String inCrcrt_codigo){
		this.myCrcrt_codigo = inCrcrt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	*/
	public String getCRCRT_CODIGO(){
		return this.myCrcrt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	public void setCRRSD_CODIGO(String inCrrsd_codigo){
		this.myCrrsd_codigo = inCrrsd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	public String getCRRSD_CODIGO(){
		return this.myCrrsd_codigo;
	}

	/**
	* ESTABLECE FECHA DE EMISION DEL CERTIFICADO
	* @param inCrcrt_fecha_emision FECHA DE EMISION DEL CERTIFICADO
	*/
	public void setCRCRT_FECHA_EMISION(java.util.Date inCrcrt_fecha_emision){
		this.myCrcrt_fecha_emision = inCrcrt_fecha_emision;
	}
	/**
	* OBTIENE FECHA DE EMISION DEL CERTIFICADO
	* @return java.util.Date FECHA DE EMISION DEL CERTIFICADO
	*/
	public java.util.Date getCRCRT_FECHA_EMISION(){
		return this.myCrcrt_fecha_emision;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DEL CERTIFICADO
	* @param inCrcrt_numero NUMERO SECUENCIAL UNICO DEL CERTIFICADO
	*/
	public void setCRCRT_NUMERO(String inCrcrt_numero){
		this.myCrcrt_numero = inCrcrt_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DEL CERTIFICADO
	* @return String NUMERO SECUENCIAL UNICO DEL CERTIFICADO
	*/
	public String getCRCRT_NUMERO(){
		return this.myCrcrt_numero;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CUERPO DEL CERTIFICADO
	* @param inCrcrt_contenido DESCRIPCION DEL CUERPO DEL CERTIFICADO
	*/
	public void setCRCRT_CONTENIDO(String inCrcrt_contenido){
		this.myCrcrt_contenido = inCrcrt_contenido;
	}
	/**
	* OBTIENE DESCRIPCION DEL CUERPO DEL CERTIFICADO
	* @return String DESCRIPCION DEL CUERPO DEL CERTIFICADO
	*/
	public String getCRCRT_CONTENIDO(){
		return this.myCrcrt_contenido;
	}

	/**
	* ESTABLECE ANIO DE EMISION DEL CERTIFICADO
	* @param inCrcrt_anio ANIO DE EMISION DEL CERTIFICADO
	*/
	public void setCRCRT_ANIO(int inCrcrt_anio){
		this.myCrcrt_anio = inCrcrt_anio;
	}
	/**
	* OBTIENE ANIO DE EMISION DEL CERTIFICADO
	* @return int ANIO DE EMISION DEL CERTIFICADO
	*/
	public int getCRCRT_ANIO(){
		return this.myCrcrt_anio;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrcrt_estado ESTADO DEL REGISTRO
	*/
	public void setCRCRT_ESTADO(boolean inCrcrt_estado){
		this.myCrcrt_estado = inCrcrt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRCRT_ESTADO(){
		return this.myCrcrt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcrt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRCRT_USUARIO_INSERT(String inCrcrt_usuario_insert){
		this.myCrcrt_usuario_insert = inCrcrt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRCRT_USUARIO_INSERT(){
		return this.myCrcrt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrcrt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRCRT_USUARIO_UPDATE(String inCrcrt_usuario_update){
		this.myCrcrt_usuario_update = inCrcrt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRCRT_USUARIO_UPDATE(){
		return this.myCrcrt_usuario_update;
	}

}
