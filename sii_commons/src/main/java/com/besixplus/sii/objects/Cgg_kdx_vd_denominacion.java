package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_vd_denominacion
* TABLA: VENTA DETALLE DENOMINACION
* DESCRIPCION:ALMACENA INFORMACION DETALLADO DE LAS DENOMINACIONES DE LA VENTA.
* ABREVIATURA:CKVDD
*/
public class Cgg_kdx_vd_denominacion implements Serializable{
	private static final long serialVersionUID = 1267084059;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
	*/
	private String myCkvdd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	*/
	private String myCkvnt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	*/
	private String myCkdnm_codigo;
	/**
	* CANTIDAD
	*/
	private int myCkvdd_cantidad;
	/**
	* VALOR MONETARIO DE LA DENOMINACION
	*/
	private java.math.BigDecimal myCkvdd_valor;
	/**
	* TOTAL CONTABLE
	*/
	private java.math.BigDecimal myCkvdd_total;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkvdd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkvdd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkvdd_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_vd_denominacion
	*/
	public Cgg_kdx_vd_denominacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_vd_denominacion
	* @param inCkvdd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	* @param inCkdnm_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	* @param inCkvdd_cantidad CANTIDAD
	* @param inCkvdd_valor VALOR MONETARIO DE LA DENOMINACION
	* @param inCkvdd_total TOTAL CONTABLE
	* @param inCkvdd_estado ESTADO DEL REGISTRO
	* @param inCkvdd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvdd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_vd_denominacion(
		String inCkvdd_codigo,
		String inCkvnt_codigo,
		String inCkdnm_codigo,
		int inCkvdd_cantidad,
		java.math.BigDecimal inCkvdd_valor,
		java.math.BigDecimal inCkvdd_total,
		boolean inCkvdd_estado,
		String inCkvdd_usuario_insert,
		String inCkvdd_usuario_update
	){
		this.setCKVDD_CODIGO(inCkvdd_codigo);
		this.setCKVNT_CODIGO(inCkvnt_codigo);
		this.setCKDNM_CODIGO(inCkdnm_codigo);
		this.setCKVDD_CANTIDAD(inCkvdd_cantidad);
		this.setCKVDD_VALOR(inCkvdd_valor);
		this.setCKVDD_TOTAL(inCkvdd_total);
		this.setCKVDD_ESTADO(inCkvdd_estado);
		this.setCKVDD_USUARIO_INSERT(inCkvdd_usuario_insert);
		this.setCKVDD_USUARIO_UPDATE(inCkvdd_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
	* @param inCkvdd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
	*/
	public void setCKVDD_CODIGO(String inCkvdd_codigo){
		this.myCkvdd_codigo = inCkvdd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
	*/
	public String getCKVDD_CODIGO(){
		return this.myCkvdd_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	*/
	public void setCKVNT_CODIGO(String inCkvnt_codigo){
		this.myCkvnt_codigo = inCkvnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	*/
	public String getCKVNT_CODIGO(){
		return this.myCkvnt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	* @param inCkdnm_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	*/
	public void setCKDNM_CODIGO(String inCkdnm_codigo){
		this.myCkdnm_codigo = inCkdnm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	*/
	public String getCKDNM_CODIGO(){
		return this.myCkdnm_codigo;
	}

	/**
	* ESTABLECE CANTIDAD
	* @param inCkvdd_cantidad CANTIDAD
	*/
	public void setCKVDD_CANTIDAD(int inCkvdd_cantidad){
		this.myCkvdd_cantidad = inCkvdd_cantidad;
	}
	/**
	* OBTIENE CANTIDAD
	* @return int CANTIDAD
	*/
	public int getCKVDD_CANTIDAD(){
		return this.myCkvdd_cantidad;
	}

	/**
	* ESTABLECE VALOR MONETARIO DE LA DENOMINACION
	* @param inCkvdd_valor VALOR MONETARIO DE LA DENOMINACION
	*/
	public void setCKVDD_VALOR(java.math.BigDecimal inCkvdd_valor){
		this.myCkvdd_valor = inCkvdd_valor;
	}
	/**
	* OBTIENE VALOR MONETARIO DE LA DENOMINACION
	* @return java.math.BigDecimal VALOR MONETARIO DE LA DENOMINACION
	*/
	public java.math.BigDecimal getCKVDD_VALOR(){
		return this.myCkvdd_valor;
	}

	/**
	* ESTABLECE TOTAL CONTABLE
	* @param inCkvdd_total TOTAL CONTABLE
	*/
	public void setCKVDD_TOTAL(java.math.BigDecimal inCkvdd_total){
		this.myCkvdd_total = inCkvdd_total;
	}
	/**
	* OBTIENE TOTAL CONTABLE
	* @return java.math.BigDecimal TOTAL CONTABLE
	*/
	public java.math.BigDecimal getCKVDD_TOTAL(){
		return this.myCkvdd_total;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkvdd_estado ESTADO DEL REGISTRO
	*/
	public void setCKVDD_ESTADO(boolean inCkvdd_estado){
		this.myCkvdd_estado = inCkvdd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKVDD_ESTADO(){
		return this.myCkvdd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvdd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKVDD_USUARIO_INSERT(String inCkvdd_usuario_insert){
		this.myCkvdd_usuario_insert = inCkvdd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKVDD_USUARIO_INSERT(){
		return this.myCkvdd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkvdd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKVDD_USUARIO_UPDATE(String inCkvdd_usuario_update){
		this.myCkvdd_usuario_update = inCkvdd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKVDD_USUARIO_UPDATE(){
		return this.myCkvdd_usuario_update;
	}

}
