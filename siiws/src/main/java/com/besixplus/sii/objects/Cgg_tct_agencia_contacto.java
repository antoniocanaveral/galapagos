package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_agencia_contacto
* TABLA: AGENCIA CONTACO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CONTACTOS ASOCIADOS A UNA AGENCIA DE VIAJES
* ABREVIATURA:CTAGC
*/
public class Cgg_tct_agencia_contacto implements Serializable{
	private static final long serialVersionUID = 533810969;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA CONTACTO
	*/
	private String myCtagc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	*/
	private String myCtagv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* VALOR ASIGNADO AL CONTACTO
	*/
	private String myCtagc_descripcion;
	/**
	* NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	private String myCtagc_contacto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtagc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtagc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtagc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_agencia_contacto
	*/
	public Cgg_tct_agencia_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_agencia_contacto
	* @param inCtagc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA CONTACTO
	* @param inCtagv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCtagc_descripcion VALOR ASIGNADO AL CONTACTO
	* @param inCtagc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCtagc_estado ESTADO DEL REGISTRO
	* @param inCtagc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtagc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_agencia_contacto(
		String inCtagc_codigo,
		String inCtagv_codigo,
		String inCrtco_codigo,
		String inCtagc_descripcion,
		String inCtagc_contacto,
		boolean inCtagc_estado,
		String inCtagc_usuario_insert,
		String inCtagc_usuario_update
	){
		this.setCTAGC_CODIGO(inCtagc_codigo);
		this.setCTAGV_CODIGO(inCtagv_codigo);
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCTAGC_DESCRIPCION(inCtagc_descripcion);
		this.setCTAGC_CONTACTO(inCtagc_contacto);
		this.setCTAGC_ESTADO(inCtagc_estado);
		this.setCTAGC_USUARIO_INSERT(inCtagc_usuario_insert);
		this.setCTAGC_USUARIO_UPDATE(inCtagc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA CONTACTO
	* @param inCtagc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA CONTACTO
	*/
	public void setCTAGC_CODIGO(String inCtagc_codigo){
		this.myCtagc_codigo = inCtagc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA CONTACTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA CONTACTO
	*/
	public String getCTAGC_CODIGO(){
		return this.myCtagc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	* @param inCtagv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	*/
	public void setCTAGV_CODIGO(String inCtagv_codigo){
		this.myCtagv_codigo = inCtagv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	*/
	public String getCTAGV_CODIGO(){
		return this.myCtagv_codigo;
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
	* @param inCtagc_descripcion VALOR ASIGNADO AL CONTACTO
	*/
	public void setCTAGC_DESCRIPCION(String inCtagc_descripcion){
		this.myCtagc_descripcion = inCtagc_descripcion;
	}
	/**
	* OBTIENE VALOR ASIGNADO AL CONTACTO
	* @return String VALOR ASIGNADO AL CONTACTO
	*/
	public String getCTAGC_DESCRIPCION(){
		return this.myCtagc_descripcion;
	}

	/**
	* ESTABLECE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCtagc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public void setCTAGC_CONTACTO(String inCtagc_contacto){
		this.myCtagc_contacto = inCtagc_contacto;
	}
	/**
	* OBTIENE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @return String NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public String getCTAGC_CONTACTO(){
		return this.myCtagc_contacto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtagc_estado ESTADO DEL REGISTRO
	*/
	public void setCTAGC_ESTADO(boolean inCtagc_estado){
		this.myCtagc_estado = inCtagc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTAGC_ESTADO(){
		return this.myCtagc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtagc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTAGC_USUARIO_INSERT(String inCtagc_usuario_insert){
		this.myCtagc_usuario_insert = inCtagc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTAGC_USUARIO_INSERT(){
		return this.myCtagc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtagc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTAGC_USUARIO_UPDATE(String inCtagc_usuario_update){
		this.myCtagc_usuario_update = inCtagc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTAGC_USUARIO_UPDATE(){
		return this.myCtagc_usuario_update;
	}

}
