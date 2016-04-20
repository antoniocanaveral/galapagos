package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_cierre_detalle
* TABLA: CIERRE DETALLE
* DESCRIPCION:ALMACENA INFORMACION DETALLADO DEL CIERRE DE CAJA.
* ABREVIATURA:CKCDT
*/
public class Cgg_kdx_cierre_detalle implements Serializable{
	private static final long serialVersionUID = 1390865550;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCkcdt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCkdnm_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCkcrr_codigo;
	/**
	* CANTIDAD
	*/
	private int myCkcdt_cantidad;
	/**
	* VALOR MONETARIO DE LA DENOMINACION
	*/
	private java.math.BigDecimal myCkcdt_valor;
	/**
	* TOTAL CONTABLE
	*/
	private java.math.BigDecimal myCkcdt_total;
	/**
	* DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
	*/
	private String myCkcdt_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkcdt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkcdt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkcdt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_cierre_detalle
	*/
	public Cgg_kdx_cierre_detalle(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_cierre_detalle
	* @param inCkcdt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkdnm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkcdt_cantidad CANTIDAD
	* @param inCkcdt_valor VALOR MONETARIO DE LA DENOMINACION
	* @param inCkcdt_total TOTAL CONTABLE
	* @param inCkcdt_observacion DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
	* @param inCkcdt_estado ESTADO DEL REGISTRO
	* @param inCkcdt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcdt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_cierre_detalle(
		String inCkcdt_codigo,
		String inCkdnm_codigo,
		String inCkcrr_codigo,
		int inCkcdt_cantidad,
		java.math.BigDecimal inCkcdt_valor,
		java.math.BigDecimal inCkcdt_total,
		String inCkcdt_observacion,
		boolean inCkcdt_estado,
		String inCkcdt_usuario_insert,
		String inCkcdt_usuario_update
	){
		this.setCKCDT_CODIGO(inCkcdt_codigo);
		this.setCKDNM_CODIGO(inCkdnm_codigo);
		this.setCKCRR_CODIGO(inCkcrr_codigo);
		this.setCKCDT_CANTIDAD(inCkcdt_cantidad);
		this.setCKCDT_VALOR(inCkcdt_valor);
		this.setCKCDT_TOTAL(inCkcdt_total);
		this.setCKCDT_OBSERVACION(inCkcdt_observacion);
		this.setCKCDT_ESTADO(inCkcdt_estado);
		this.setCKCDT_USUARIO_INSERT(inCkcdt_usuario_insert);
		this.setCKCDT_USUARIO_UPDATE(inCkcdt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkcdt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCKCDT_CODIGO(String inCkcdt_codigo){
		this.myCkcdt_codigo = inCkcdt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCKCDT_CODIGO(){
		return this.myCkcdt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkdnm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCKDNM_CODIGO(String inCkdnm_codigo){
		this.myCkdnm_codigo = inCkdnm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCKDNM_CODIGO(){
		return this.myCkdnm_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCKCRR_CODIGO(String inCkcrr_codigo){
		this.myCkcrr_codigo = inCkcrr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCKCRR_CODIGO(){
		return this.myCkcrr_codigo;
	}

	/**
	* ESTABLECE CANTIDAD
	* @param inCkcdt_cantidad CANTIDAD
	*/
	public void setCKCDT_CANTIDAD(int inCkcdt_cantidad){
		this.myCkcdt_cantidad = inCkcdt_cantidad;
	}
	/**
	* OBTIENE CANTIDAD
	* @return int CANTIDAD
	*/
	public int getCKCDT_CANTIDAD(){
		return this.myCkcdt_cantidad;
	}

	/**
	* ESTABLECE VALOR MONETARIO DE LA DENOMINACION
	* @param inCkcdt_valor VALOR MONETARIO DE LA DENOMINACION
	*/
	public void setCKCDT_VALOR(java.math.BigDecimal inCkcdt_valor){
		this.myCkcdt_valor = inCkcdt_valor;
	}
	/**
	* OBTIENE VALOR MONETARIO DE LA DENOMINACION
	* @return java.math.BigDecimal VALOR MONETARIO DE LA DENOMINACION
	*/
	public java.math.BigDecimal getCKCDT_VALOR(){
		return this.myCkcdt_valor;
	}

	/**
	* ESTABLECE TOTAL CONTABLE
	* @param inCkcdt_total TOTAL CONTABLE
	*/
	public void setCKCDT_TOTAL(java.math.BigDecimal inCkcdt_total){
		this.myCkcdt_total = inCkcdt_total;
	}
	/**
	* OBTIENE TOTAL CONTABLE
	* @return java.math.BigDecimal TOTAL CONTABLE
	*/
	public java.math.BigDecimal getCKCDT_TOTAL(){
		return this.myCkcdt_total;
	}

	/**
	* ESTABLECE DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
	* @param inCkcdt_observacion DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
	*/
	public void setCKCDT_OBSERVACION(String inCkcdt_observacion){
		this.myCkcdt_observacion = inCkcdt_observacion;
	}
	/**
	* OBTIENE DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
	* @return String DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
	*/
	public String getCKCDT_OBSERVACION(){
		return this.myCkcdt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkcdt_estado ESTADO DEL REGISTRO
	*/
	public void setCKCDT_ESTADO(boolean inCkcdt_estado){
		this.myCkcdt_estado = inCkcdt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKCDT_ESTADO(){
		return this.myCkcdt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcdt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKCDT_USUARIO_INSERT(String inCkcdt_usuario_insert){
		this.myCkcdt_usuario_insert = inCkcdt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKCDT_USUARIO_INSERT(){
		return this.myCkcdt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkcdt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKCDT_USUARIO_UPDATE(String inCkcdt_usuario_update){
		this.myCkcdt_usuario_update = inCkcdt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKCDT_USUARIO_UPDATE(){
		return this.myCkcdt_usuario_update;
	}

}
