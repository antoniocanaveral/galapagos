package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_cierre
* TABLA: CIERRE DE CAJA
* DESCRIPCION:ALMACENA INFORMACION DE CIERRES DE CAJA DE LOS PUNTOS DE VENTA.
* ABREVIATURA:CKCRR
*/
public class Cgg_kdx_cierre implements Serializable{
	private static final long serialVersionUID = 184994039;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	*/
	private String myCkcrr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	private String myCkpvt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	private String myCkupv_codigo;
	/**
	* FECHA DE REALIZACION DEL CIERRE
	*/
	private java.util.Date myCkcrr_fecha_cierre;
	/**
	* NUMERO SECUENCIAL IDENTIFICATIVO
	*/
	private String myCkcrr_numero_cierre;
	/**
	* VALOR TOTAL REGISTRADO EN LA VENTA
	*/
	private java.math.BigDecimal myCkcrr_total_venta;
	/**
	* VALOR TOTAL CONTABILIZADO EN EL CIERRE
	*/
	private java.math.BigDecimal myCkcrr_total;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCkcrr_observacion;
	/**
	* VALOR DE DIFERENCIA
	*/
	private java.math.BigDecimal myCkcrr_diferencia;
	/**
	* ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	*/
	private int myCkcrr_estado_cierre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkcrr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkcrr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkcrr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_cierre
	*/
	public Cgg_kdx_cierre(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_cierre
	* @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCkcrr_fecha_cierre FECHA DE REALIZACION DEL CIERRE
	* @param inCkcrr_numero_cierre NUMERO SECUENCIAL IDENTIFICATIVO
	* @param inCkcrr_total_venta VALOR TOTAL REGISTRADO EN LA VENTA
	* @param inCkcrr_total VALOR TOTAL CONTABILIZADO EN EL CIERRE
	* @param inCkcrr_observacion INFORMACION ADICIONAL
	* @param inCkcrr_diferencia VALOR DE DIFERENCIA
	* @param inCkcrr_estado_cierre ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	* @param inCkcrr_estado ESTADO DEL REGISTRO
	* @param inCkcrr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcrr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_cierre(
		String inCkcrr_codigo,
		String inCkpvt_codigo,
		String inCkvnt_codigo,
		String inCkupv_codigo,
		java.util.Date inCkcrr_fecha_cierre,
		String inCkcrr_numero_cierre,
		java.math.BigDecimal inCkcrr_total_venta,
		java.math.BigDecimal inCkcrr_total,
		String inCkcrr_observacion,
		java.math.BigDecimal inCkcrr_diferencia,
		int inCkcrr_estado_cierre,
		boolean inCkcrr_estado,
		String inCkcrr_usuario_insert,
		String inCkcrr_usuario_update
	){
		this.setCKCRR_CODIGO(inCkcrr_codigo);
		this.setCKPVT_CODIGO(inCkpvt_codigo);
		this.setCKUPV_CODIGO(inCkupv_codigo);
		this.setCKCRR_FECHA_CIERRE(inCkcrr_fecha_cierre);
		this.setCKCRR_NUMERO_CIERRE(inCkcrr_numero_cierre);
		this.setCKCRR_TOTAL_VENTA(inCkcrr_total_venta);
		this.setCKCRR_TOTAL(inCkcrr_total);
		this.setCKCRR_OBSERVACION(inCkcrr_observacion);
		this.setCKCRR_DIFERENCIA(inCkcrr_diferencia);
		this.setCKCRR_ESTADO_CIERRE(inCkcrr_estado_cierre);
		this.setCKCRR_ESTADO(inCkcrr_estado);
		this.setCKCRR_USUARIO_INSERT(inCkcrr_usuario_insert);
		this.setCKCRR_USUARIO_UPDATE(inCkcrr_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	public void setCKPVT_CODIGO(String inCkpvt_codigo){
		this.myCkpvt_codigo = inCkpvt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	public String getCKPVT_CODIGO(){
		return this.myCkpvt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	public void setCKUPV_CODIGO(String inCkupv_codigo){
		this.myCkupv_codigo = inCkupv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	public String getCKUPV_CODIGO(){
		return this.myCkupv_codigo;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DEL CIERRE
	* @param inCkcrr_fecha_cierre FECHA DE REALIZACION DEL CIERRE
	*/
	public void setCKCRR_FECHA_CIERRE(java.util.Date inCkcrr_fecha_cierre){
		this.myCkcrr_fecha_cierre = inCkcrr_fecha_cierre;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DEL CIERRE
	* @return java.util.Date FECHA DE REALIZACION DEL CIERRE
	*/
	public java.util.Date getCKCRR_FECHA_CIERRE(){
		return this.myCkcrr_fecha_cierre;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL IDENTIFICATIVO
	* @param inCkcrr_numero_cierre NUMERO SECUENCIAL IDENTIFICATIVO
	*/
	public void setCKCRR_NUMERO_CIERRE(String inCkcrr_numero_cierre){
		this.myCkcrr_numero_cierre = inCkcrr_numero_cierre;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL IDENTIFICATIVO
	* @return String NUMERO SECUENCIAL IDENTIFICATIVO
	*/
	public String getCKCRR_NUMERO_CIERRE(){
		return this.myCkcrr_numero_cierre;
	}

	/**
	* ESTABLECE VALOR TOTAL REGISTRADO EN LA VENTA
	* @param inCkcrr_total_venta VALOR TOTAL REGISTRADO EN LA VENTA
	*/
	public void setCKCRR_TOTAL_VENTA(java.math.BigDecimal inCkcrr_total_venta){
		this.myCkcrr_total_venta = inCkcrr_total_venta;
	}
	/**
	* OBTIENE VALOR TOTAL REGISTRADO EN LA VENTA
	* @return java.math.BigDecimal VALOR TOTAL REGISTRADO EN LA VENTA
	*/
	public java.math.BigDecimal getCKCRR_TOTAL_VENTA(){
		return this.myCkcrr_total_venta;
	}

	/**
	* ESTABLECE VALOR TOTAL CONTABILIZADO EN EL CIERRE
	* @param inCkcrr_total VALOR TOTAL CONTABILIZADO EN EL CIERRE
	*/
	public void setCKCRR_TOTAL(java.math.BigDecimal inCkcrr_total){
		this.myCkcrr_total = inCkcrr_total;
	}
	/**
	* OBTIENE VALOR TOTAL CONTABILIZADO EN EL CIERRE
	* @return java.math.BigDecimal VALOR TOTAL CONTABILIZADO EN EL CIERRE
	*/
	public java.math.BigDecimal getCKCRR_TOTAL(){
		return this.myCkcrr_total;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCkcrr_observacion INFORMACION ADICIONAL
	*/
	public void setCKCRR_OBSERVACION(String inCkcrr_observacion){
		this.myCkcrr_observacion = inCkcrr_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCKCRR_OBSERVACION(){
		return this.myCkcrr_observacion;
	}

	/**
	* ESTABLECE VALOR DE DIFERENCIA
	* @param inCkcrr_diferencia VALOR DE DIFERENCIA
	*/
	public void setCKCRR_DIFERENCIA(java.math.BigDecimal inCkcrr_diferencia){
		this.myCkcrr_diferencia = inCkcrr_diferencia;
	}
	/**
	* OBTIENE VALOR DE DIFERENCIA
	* @return java.math.BigDecimal VALOR DE DIFERENCIA
	*/
	public java.math.BigDecimal getCKCRR_DIFERENCIA(){
		return this.myCkcrr_diferencia;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	* @param inCkcrr_estado_cierre ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	*/
	public void setCKCRR_ESTADO_CIERRE(int inCkcrr_estado_cierre){
		this.myCkcrr_estado_cierre = inCkcrr_estado_cierre;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	* @return int ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	*/
	public int getCKCRR_ESTADO_CIERRE(){
		return this.myCkcrr_estado_cierre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkcrr_estado ESTADO DEL REGISTRO
	*/
	public void setCKCRR_ESTADO(boolean inCkcrr_estado){
		this.myCkcrr_estado = inCkcrr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKCRR_ESTADO(){
		return this.myCkcrr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcrr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKCRR_USUARIO_INSERT(String inCkcrr_usuario_insert){
		this.myCkcrr_usuario_insert = inCkcrr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKCRR_USUARIO_INSERT(){
		return this.myCkcrr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkcrr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKCRR_USUARIO_UPDATE(String inCkcrr_usuario_update){
		this.myCkcrr_usuario_update = inCkcrr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKCRR_USUARIO_UPDATE(){
		return this.myCkcrr_usuario_update;
	}

}
