package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_kardex
* TABLA: KARDEX
* DESCRIPCION:ALMACENA INFORMACION DE LOS MOVIMIENTOS DE LAS ESPECIES.
* ABREVIATURA:CKKRD
*/
public class Cgg_kdx_kardex implements Serializable{
	private static final long serialVersionUID = 30830213;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	*/
	private String myCkkrd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	*/
	private String myCkesp_codigo;
	/**
	* NUMERO DEL MOVIMIENTO
	*/
	private int myCkkrd_numero;
	/**
	* DETALLE DEL MOVIMIENTO
	*/
	private String myCkkrd_detalle;
	/**
	* FECHA DE REGISTRO DE MOVIMIENTO
	*/
	private java.util.Date myCkkrd_fecha_registro;
	/**
	* TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	*/
	private int myCkkrd_tipo_movimiento;
	/**
	* TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	*/
	private int myCkkrd_tipo_operacion;
	/**
	* CANTIDAD DE ESPECIES QUE INGRESARON
	*/
	private int myCkkrd_ingreso_cantidad;
	/**
	* PRECIO UNITARIO DE COMPRA
	*/
	private java.math.BigDecimal myCkkrd_ingreso_pu;
	/**
	* TOTAL CONTABLE DE INGRESO
	*/
	private java.math.BigDecimal myCkkrd_ingreso_total;
	/**
	* CANTIDAD DE ESPECIES ENTREGADAS
	*/
	private int myCkkrd_salida_cantidad;
	/**
	* PRECIO UNITARIO DE VENTA
	*/
	private java.math.BigDecimal myCkkrd_salida_pu;
	/**
	* TOTAL CONTABLE DE VENTA
	*/
	private java.math.BigDecimal myCkkrd_salida_total;
	/**
	* CANTIDAD TOTAL
	*/
	private int myCkkrd_total_cantidad;
	/**
	* PRECIO UNITARIO
	*/
	private java.math.BigDecimal myCkkrd_total_pu;
	/**
	* TOTAL CONTABLE
	*/
	private java.math.BigDecimal myCkkrd_total_total;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkkrd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkkrd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkkrd_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_kardex
	*/
	public Cgg_kdx_kardex(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_kardex
	* @param inCkkrd_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	* @param inCkkrd_numero NUMERO DEL MOVIMIENTO
	* @param inCkkrd_detalle DETALLE DEL MOVIMIENTO
	* @param inCkkrd_fecha_registro FECHA DE REGISTRO DE MOVIMIENTO
	* @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	* @param inCkkrd_tipo_operacion TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	* @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON
	* @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA
	* @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO
	* @param inCkkrd_salida_cantidad CANTIDAD DE ESPECIES ENTREGADAS
	* @param inCkkrd_salida_pu PRECIO UNITARIO DE VENTA
	* @param inCkkrd_salida_total TOTAL CONTABLE DE VENTA
	* @param inCkkrd_total_cantidad CANTIDAD TOTAL
	* @param inCkkrd_total_pu PRECIO UNITARIO
	* @param inCkkrd_total_total TOTAL CONTABLE
	* @param inCkkrd_estado ESTADO DEL REGISTRO
	* @param inCkkrd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkkrd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_kardex(
		String inCkkrd_codigo,
		String inCkesp_codigo,
		int inCkkrd_numero,
		String inCkkrd_detalle,
		java.util.Date inCkkrd_fecha_registro,
		int inCkkrd_tipo_movimiento,
		int inCkkrd_tipo_operacion,
		int inCkkrd_ingreso_cantidad,
		java.math.BigDecimal inCkkrd_ingreso_pu,
		java.math.BigDecimal inCkkrd_ingreso_total,
		int inCkkrd_salida_cantidad,
		java.math.BigDecimal inCkkrd_salida_pu,
		java.math.BigDecimal inCkkrd_salida_total,
		int inCkkrd_total_cantidad,
		java.math.BigDecimal inCkkrd_total_pu,
		java.math.BigDecimal inCkkrd_total_total,
		boolean inCkkrd_estado,
		String inCkkrd_usuario_insert,
		String inCkkrd_usuario_update
	){
		this.setCKKRD_CODIGO(inCkkrd_codigo);
		this.setCKESP_CODIGO(inCkesp_codigo);
		this.setCKKRD_NUMERO(inCkkrd_numero);
		this.setCKKRD_DETALLE(inCkkrd_detalle);
		this.setCKKRD_FECHA_REGISTRO(inCkkrd_fecha_registro);
		this.setCKKRD_TIPO_MOVIMIENTO(inCkkrd_tipo_movimiento);
		this.setCKKRD_TIPO_OPERACION(inCkkrd_tipo_operacion);
		this.setCKKRD_INGRESO_CANTIDAD(inCkkrd_ingreso_cantidad);
		this.setCKKRD_INGRESO_PU(inCkkrd_ingreso_pu);
		this.setCKKRD_INGRESO_TOTAL(inCkkrd_ingreso_total);
		this.setCKKRD_SALIDA_CANTIDAD(inCkkrd_salida_cantidad);
		this.setCKKRD_SALIDA_PU(inCkkrd_salida_pu);
		this.setCKKRD_SALIDA_TOTAL(inCkkrd_salida_total);
		this.setCKKRD_TOTAL_CANTIDAD(inCkkrd_total_cantidad);
		this.setCKKRD_TOTAL_PU(inCkkrd_total_pu);
		this.setCKKRD_TOTAL_TOTAL(inCkkrd_total_total);
		this.setCKKRD_ESTADO(inCkkrd_estado);
		this.setCKKRD_USUARIO_INSERT(inCkkrd_usuario_insert);
		this.setCKKRD_USUARIO_UPDATE(inCkkrd_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	* @param inCkkrd_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	*/
	public void setCKKRD_CODIGO(String inCkkrd_codigo){
		this.myCkkrd_codigo = inCkkrd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	*/
	public String getCKKRD_CODIGO(){
		return this.myCkkrd_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	*/
	public void setCKESP_CODIGO(String inCkesp_codigo){
		this.myCkesp_codigo = inCkesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	*/
	public String getCKESP_CODIGO(){
		return this.myCkesp_codigo;
	}

	/**
	* ESTABLECE NUMERO DEL MOVIMIENTO
	* @param inCkkrd_numero NUMERO DEL MOVIMIENTO
	*/
	public void setCKKRD_NUMERO(int inCkkrd_numero){
		this.myCkkrd_numero = inCkkrd_numero;
	}
	/**
	* OBTIENE NUMERO DEL MOVIMIENTO
	* @return int NUMERO DEL MOVIMIENTO
	*/
	public int getCKKRD_NUMERO(){
		return this.myCkkrd_numero;
	}

	/**
	* ESTABLECE DETALLE DEL MOVIMIENTO
	* @param inCkkrd_detalle DETALLE DEL MOVIMIENTO
	*/
	public void setCKKRD_DETALLE(String inCkkrd_detalle){
		this.myCkkrd_detalle = inCkkrd_detalle;
	}
	/**
	* OBTIENE DETALLE DEL MOVIMIENTO
	* @return String DETALLE DEL MOVIMIENTO
	*/
	public String getCKKRD_DETALLE(){
		return this.myCkkrd_detalle;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DE MOVIMIENTO
	* @param inCkkrd_fecha_registro FECHA DE REGISTRO DE MOVIMIENTO
	*/
	public void setCKKRD_FECHA_REGISTRO(java.util.Date inCkkrd_fecha_registro){
		this.myCkkrd_fecha_registro = inCkkrd_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DE MOVIMIENTO
	* @return java.util.Date FECHA DE REGISTRO DE MOVIMIENTO
	*/
	public java.util.Date getCKKRD_FECHA_REGISTRO(){
		return this.myCkkrd_fecha_registro;
	}

	/**
	* ESTABLECE TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	* @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	*/
	public void setCKKRD_TIPO_MOVIMIENTO(int inCkkrd_tipo_movimiento){
		this.myCkkrd_tipo_movimiento = inCkkrd_tipo_movimiento;
	}
	/**
	* OBTIENE TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	* @return int TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	*/
	public int getCKKRD_TIPO_MOVIMIENTO(){
		return this.myCkkrd_tipo_movimiento;
	}

	/**
	* ESTABLECE TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	* @param inCkkrd_tipo_operacion TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	*/
	public void setCKKRD_TIPO_OPERACION(int inCkkrd_tipo_operacion){
		this.myCkkrd_tipo_operacion = inCkkrd_tipo_operacion;
	}
	/**
	* OBTIENE TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	* @return int TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	*/
	public int getCKKRD_TIPO_OPERACION(){
		return this.myCkkrd_tipo_operacion;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES QUE INGRESARON
	* @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON
	*/
	public void setCKKRD_INGRESO_CANTIDAD(int inCkkrd_ingreso_cantidad){
		this.myCkkrd_ingreso_cantidad = inCkkrd_ingreso_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES QUE INGRESARON
	* @return int CANTIDAD DE ESPECIES QUE INGRESARON
	*/
	public int getCKKRD_INGRESO_CANTIDAD(){
		return this.myCkkrd_ingreso_cantidad;
	}

	/**
	* ESTABLECE PRECIO UNITARIO DE COMPRA
	* @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA
	*/
	public void setCKKRD_INGRESO_PU(java.math.BigDecimal inCkkrd_ingreso_pu){
		this.myCkkrd_ingreso_pu = inCkkrd_ingreso_pu;
	}
	/**
	* OBTIENE PRECIO UNITARIO DE COMPRA
	* @return java.math.BigDecimal PRECIO UNITARIO DE COMPRA
	*/
	public java.math.BigDecimal getCKKRD_INGRESO_PU(){
		return this.myCkkrd_ingreso_pu;
	}

	/**
	* ESTABLECE TOTAL CONTABLE DE INGRESO
	* @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO
	*/
	public void setCKKRD_INGRESO_TOTAL(java.math.BigDecimal inCkkrd_ingreso_total){
		this.myCkkrd_ingreso_total = inCkkrd_ingreso_total;
	}
	/**
	* OBTIENE TOTAL CONTABLE DE INGRESO
	* @return java.math.BigDecimal TOTAL CONTABLE DE INGRESO
	*/
	public java.math.BigDecimal getCKKRD_INGRESO_TOTAL(){
		return this.myCkkrd_ingreso_total;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES ENTREGADAS
	* @param inCkkrd_salida_cantidad CANTIDAD DE ESPECIES ENTREGADAS
	*/
	public void setCKKRD_SALIDA_CANTIDAD(int inCkkrd_salida_cantidad){
		this.myCkkrd_salida_cantidad = inCkkrd_salida_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES ENTREGADAS
	* @return int CANTIDAD DE ESPECIES ENTREGADAS
	*/
	public int getCKKRD_SALIDA_CANTIDAD(){
		return this.myCkkrd_salida_cantidad;
	}

	/**
	* ESTABLECE PRECIO UNITARIO DE VENTA
	* @param inCkkrd_salida_pu PRECIO UNITARIO DE VENTA
	*/
	public void setCKKRD_SALIDA_PU(java.math.BigDecimal inCkkrd_salida_pu){
		this.myCkkrd_salida_pu = inCkkrd_salida_pu;
	}
	/**
	* OBTIENE PRECIO UNITARIO DE VENTA
	* @return java.math.BigDecimal PRECIO UNITARIO DE VENTA
	*/
	public java.math.BigDecimal getCKKRD_SALIDA_PU(){
		return this.myCkkrd_salida_pu;
	}

	/**
	* ESTABLECE TOTAL CONTABLE DE VENTA
	* @param inCkkrd_salida_total TOTAL CONTABLE DE VENTA
	*/
	public void setCKKRD_SALIDA_TOTAL(java.math.BigDecimal inCkkrd_salida_total){
		this.myCkkrd_salida_total = inCkkrd_salida_total;
	}
	/**
	* OBTIENE TOTAL CONTABLE DE VENTA
	* @return java.math.BigDecimal TOTAL CONTABLE DE VENTA
	*/
	public java.math.BigDecimal getCKKRD_SALIDA_TOTAL(){
		return this.myCkkrd_salida_total;
	}

	/**
	* ESTABLECE CANTIDAD TOTAL
	* @param inCkkrd_total_cantidad CANTIDAD TOTAL
	*/
	public void setCKKRD_TOTAL_CANTIDAD(int inCkkrd_total_cantidad){
		this.myCkkrd_total_cantidad = inCkkrd_total_cantidad;
	}
	/**
	* OBTIENE CANTIDAD TOTAL
	* @return int CANTIDAD TOTAL
	*/
	public int getCKKRD_TOTAL_CANTIDAD(){
		return this.myCkkrd_total_cantidad;
	}

	/**
	* ESTABLECE PRECIO UNITARIO
	* @param inCkkrd_total_pu PRECIO UNITARIO
	*/
	public void setCKKRD_TOTAL_PU(java.math.BigDecimal inCkkrd_total_pu){
		this.myCkkrd_total_pu = inCkkrd_total_pu;
	}
	/**
	* OBTIENE PRECIO UNITARIO
	* @return java.math.BigDecimal PRECIO UNITARIO
	*/
	public java.math.BigDecimal getCKKRD_TOTAL_PU(){
		return this.myCkkrd_total_pu;
	}

	/**
	* ESTABLECE TOTAL CONTABLE
	* @param inCkkrd_total_total TOTAL CONTABLE
	*/
	public void setCKKRD_TOTAL_TOTAL(java.math.BigDecimal inCkkrd_total_total){
		this.myCkkrd_total_total = inCkkrd_total_total;
	}
	/**
	* OBTIENE TOTAL CONTABLE
	* @return java.math.BigDecimal TOTAL CONTABLE
	*/
	public java.math.BigDecimal getCKKRD_TOTAL_TOTAL(){
		return this.myCkkrd_total_total;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkkrd_estado ESTADO DEL REGISTRO
	*/
	public void setCKKRD_ESTADO(boolean inCkkrd_estado){
		this.myCkkrd_estado = inCkkrd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKKRD_ESTADO(){
		return this.myCkkrd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkkrd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKKRD_USUARIO_INSERT(String inCkkrd_usuario_insert){
		this.myCkkrd_usuario_insert = inCkkrd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKKRD_USUARIO_INSERT(){
		return this.myCkkrd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkkrd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKKRD_USUARIO_UPDATE(String inCkkrd_usuario_update){
		this.myCkkrd_usuario_update = inCkkrd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKKRD_USUARIO_UPDATE(){
		return this.myCkkrd_usuario_update;
	}

}
