package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_venta_cierre
* TABLA: VENTA CIERRE
* DESCRIPCION:ALMACENA INFORMACION DE LAS VENTAS CONTABILIZADAS DENTRO DE UN CIERRE DE CAJA
* ABREVIATURA:CKVTC
*/
public class Cgg_kdx_venta_cierre implements Serializable{
	private static final long serialVersionUID = 939196230;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
	*/
	private String myCkvtc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	*/
	private String myCkvnt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	*/
	private String myCkcrr_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkvtc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkvtc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkvtc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_cierre
	*/
	public Cgg_kdx_venta_cierre(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_cierre
	* @param inCkvtc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	* @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	* @param inCkvtc_estado ESTADO DEL REGISTRO
	* @param inCkvtc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvtc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_venta_cierre(
		String inCkvtc_codigo,
		String inCkvnt_codigo,
		String inCkcrr_codigo,
		boolean inCkvtc_estado,
		String inCkvtc_usuario_insert,
		String inCkvtc_usuario_update
	){
		this.setCKVTC_CODIGO(inCkvtc_codigo);
		this.setCKVNT_CODIGO(inCkvnt_codigo);
		this.setCKCRR_CODIGO(inCkcrr_codigo);
		this.setCKVTC_ESTADO(inCkvtc_estado);
		this.setCKVTC_USUARIO_INSERT(inCkvtc_usuario_insert);
		this.setCKVTC_USUARIO_UPDATE(inCkvtc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
	* @param inCkvtc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
	*/
	public void setCKVTC_CODIGO(String inCkvtc_codigo){
		this.myCkvtc_codigo = inCkvtc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE VENTA CIERRE
	*/
	public String getCKVTC_CODIGO(){
		return this.myCkvtc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	*/
	public void setCKVNT_CODIGO(String inCkvnt_codigo){
		this.myCkvnt_codigo = inCkvnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	*/
	public String getCKVNT_CODIGO(){
		return this.myCkvnt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	* @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	*/
	public void setCKCRR_CODIGO(String inCkcrr_codigo){
		this.myCkcrr_codigo = inCkcrr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	*/
	public String getCKCRR_CODIGO(){
		return this.myCkcrr_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkvtc_estado ESTADO DEL REGISTRO
	*/
	public void setCKVTC_ESTADO(boolean inCkvtc_estado){
		this.myCkvtc_estado = inCkvtc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKVTC_ESTADO(){
		return this.myCkvtc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvtc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKVTC_USUARIO_INSERT(String inCkvtc_usuario_insert){
		this.myCkvtc_usuario_insert = inCkvtc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKVTC_USUARIO_INSERT(){
		return this.myCkvtc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkvtc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKVTC_USUARIO_UPDATE(String inCkvtc_usuario_update){
		this.myCkvtc_usuario_update = inCkvtc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKVTC_USUARIO_UPDATE(){
		return this.myCkvtc_usuario_update;
	}

}
