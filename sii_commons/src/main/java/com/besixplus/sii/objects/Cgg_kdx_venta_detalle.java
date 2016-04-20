package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_venta_detalle
* TABLA: VENTA DETALLE
* DESCRIPCION:ALMACENA INFORMACION DEL DETALLE DE UNA FACTURA DE VENTA.
* ABREVIATURA:CKVDT
*/
public class Cgg_kdx_venta_detalle implements Serializable{
	private static final long serialVersionUID = 2142940747;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
	*/
	private String myCkvdt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
	*/
	private String myCkvnt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	private String myCkesp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	private String myCtreg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	*/
	private String myCrcnt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtigf_codigo;
	/**
	* CANTIDAD DE ESPECIES
	*/
	private int myCkvdt_cantidad;
	/**
	* SERIE DE INICIO DE LAS ESPECIES
	*/
	private int myCkvdt_serie;
	/**
	* PRECIO UNITARIO DE LA ESPECIE
	*/
	private java.math.BigDecimal myCkvdt_precio_unitario;
	/**
	* TOTAL DE LA COMPRA
	*/
	private java.math.BigDecimal myCkvdt_total;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkvdt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkvdt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkvdt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_detalle
	*/
	public Cgg_kdx_venta_detalle(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta_detalle
	* @param inCkvdt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @param inCtigf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCkvdt_cantidad CANTIDAD DE ESPECIES
	* @param inCkvdt_serie SERIE DE INICIO DE LAS ESPECIES
	* @param inCkvdt_precio_unitario PRECIO UNITARIO DE LA ESPECIE
	* @param inCkvdt_total TOTAL DE LA COMPRA
	* @param inCkvdt_estado ESTADO DEL REGISTRO
	* @param inCkvdt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvdt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_venta_detalle(
		String inCkvdt_codigo,
		String inCkvnt_codigo,
		String inCkesp_codigo,
		String inCtreg_codigo,
		String inCrcnt_codigo,
		String inCtigf_codigo,
		int inCkvdt_cantidad,
		int inCkvdt_serie,
		java.math.BigDecimal inCkvdt_precio_unitario,
		java.math.BigDecimal inCkvdt_total,
		boolean inCkvdt_estado,
		String inCkvdt_usuario_insert,
		String inCkvdt_usuario_update
	){
		this.setCKVDT_CODIGO(inCkvdt_codigo);
		this.setCKVNT_CODIGO(inCkvnt_codigo);
		this.setCKESP_CODIGO(inCkesp_codigo);
		this.setCTREG_CODIGO(inCtreg_codigo);
		this.setCRCNT_CODIGO(inCrcnt_codigo);
		this.setCTIGF_CODIGO(inCtigf_codigo);
		this.setCKVDT_CANTIDAD(inCkvdt_cantidad);
		this.setCKVDT_SERIE(inCkvdt_serie);
		this.setCKVDT_PRECIO_UNITARIO(inCkvdt_precio_unitario);
		this.setCKVDT_TOTAL(inCkvdt_total);
		this.setCKVDT_ESTADO(inCkvdt_estado);
		this.setCKVDT_USUARIO_INSERT(inCkvdt_usuario_insert);
		this.setCKVDT_USUARIO_UPDATE(inCkvdt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
	* @param inCkvdt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
	*/
	public void setCKVDT_CODIGO(String inCkvdt_codigo){
		this.myCkvdt_codigo = inCkvdt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA DETALLE
	*/
	public String getCKVDT_CODIGO(){
		return this.myCkvdt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
	*/
	public void setCKVNT_CODIGO(String inCkvnt_codigo){
		this.myCkvnt_codigo = inCkvnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA VENTA
	*/
	public String getCKVNT_CODIGO(){
		return this.myCkvnt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	public void setCKESP_CODIGO(String inCkesp_codigo){
		this.myCkesp_codigo = inCkesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	public String getCKESP_CODIGO(){
		return this.myCkesp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public void setCTREG_CODIGO(String inCtreg_codigo){
		this.myCtreg_codigo = inCtreg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public String getCTREG_CODIGO(){
		return this.myCtreg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	*/
	public void setCRCNT_CODIGO(String inCrcnt_codigo){
		this.myCrcnt_codigo = inCrcnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	*/
	public String getCRCNT_CODIGO(){
		return this.myCrcnt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtigf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTIGF_CODIGO(String inCtigf_codigo){
		this.myCtigf_codigo = inCtigf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTIGF_CODIGO(){
		return this.myCtigf_codigo;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES
	* @param inCkvdt_cantidad CANTIDAD DE ESPECIES
	*/
	public void setCKVDT_CANTIDAD(int inCkvdt_cantidad){
		this.myCkvdt_cantidad = inCkvdt_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES
	* @return int CANTIDAD DE ESPECIES
	*/
	public int getCKVDT_CANTIDAD(){
		return this.myCkvdt_cantidad;
	}

	/**
	* ESTABLECE SERIE DE INICIO DE LAS ESPECIES
	* @param inCkvdt_serie SERIE DE INICIO DE LAS ESPECIES
	*/
	public void setCKVDT_SERIE(int inCkvdt_serie){
		this.myCkvdt_serie = inCkvdt_serie;
	}
	/**
	* OBTIENE SERIE DE INICIO DE LAS ESPECIES
	* @return int SERIE DE INICIO DE LAS ESPECIES
	*/
	public int getCKVDT_SERIE(){
		return this.myCkvdt_serie;
	}

	/**
	* ESTABLECE PRECIO UNITARIO DE LA ESPECIE
	* @param inCkvdt_precio_unitario PRECIO UNITARIO DE LA ESPECIE
	*/
	public void setCKVDT_PRECIO_UNITARIO(java.math.BigDecimal inCkvdt_precio_unitario){
		this.myCkvdt_precio_unitario = inCkvdt_precio_unitario;
	}
	/**
	* OBTIENE PRECIO UNITARIO DE LA ESPECIE
	* @return java.math.BigDecimal PRECIO UNITARIO DE LA ESPECIE
	*/
	public java.math.BigDecimal getCKVDT_PRECIO_UNITARIO(){
		return this.myCkvdt_precio_unitario;
	}

	/**
	* ESTABLECE TOTAL DE LA COMPRA
	* @param inCkvdt_total TOTAL DE LA COMPRA
	*/
	public void setCKVDT_TOTAL(java.math.BigDecimal inCkvdt_total){
		this.myCkvdt_total = inCkvdt_total;
	}
	/**
	* OBTIENE TOTAL DE LA COMPRA
	* @return java.math.BigDecimal TOTAL DE LA COMPRA
	*/
	public java.math.BigDecimal getCKVDT_TOTAL(){
		return this.myCkvdt_total;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkvdt_estado ESTADO DEL REGISTRO
	*/
	public void setCKVDT_ESTADO(boolean inCkvdt_estado){
		this.myCkvdt_estado = inCkvdt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKVDT_ESTADO(){
		return this.myCkvdt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvdt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKVDT_USUARIO_INSERT(String inCkvdt_usuario_insert){
		this.myCkvdt_usuario_insert = inCkvdt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKVDT_USUARIO_INSERT(){
		return this.myCkvdt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkvdt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKVDT_USUARIO_UPDATE(String inCkvdt_usuario_update){
		this.myCkvdt_usuario_update = inCkvdt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKVDT_USUARIO_UPDATE(){
		return this.myCkvdt_usuario_update;
	}

}
