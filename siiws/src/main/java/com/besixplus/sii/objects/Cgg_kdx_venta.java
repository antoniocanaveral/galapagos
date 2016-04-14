package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_venta
* TABLA: VENTA
* DESCRIPCION:ALMACENA INFORMACION DE LAS VENTAS DE LAS ESPECIES VALORADAS
* ABREVIATURA:CKVNT
*/
public class Cgg_kdx_venta implements Serializable{
	private static final long serialVersionUID = 1048692065;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	*/
	private String myCkvnt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	*/
	private String myCkasg_codigo;
	/**
	* LOTE AL QUE CORRESPONDE LA VENTA
	*/
	private int myCkvnt_lote;
	/**
	* FECHA DE INGRESO DE LAS ESPECIES
	*/
	private java.util.Date myCkvnt_fecha_ingreso;
	/**
	* NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
	*/
	private String myCkvnt_numero_venta;
	/**
	* SERIE DE INICIO DE ESPECIES
	*/
	private int myCkvnt_serie_inicio;
	/**
	* SERIE DE FIN DE ESPECIES
	*/
	private int myCkvnt_serie_fin;
	/**
	* TOTAL DE ESPECIES DE LA FACTURA
	*/
	private int myCkvnt_cantidad;
	/**
	* TOTAL DE LA FACTURA
	*/
	private String myCkvnt_total;
	/**
	* ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONTABILIZADA
	*/
	private int myCkvnt_estado_venta;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkvnt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkvnt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkvnt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta
	*/
	public Cgg_kdx_venta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_venta
	* @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @param inCkvnt_lote LOTE AL QUE CORRESPONDE LA VENTA
	* @param inCkvnt_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES
	* @param inCkvnt_numero_venta NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
	* @param inCkvnt_serie_inicio SERIE DE INICIO DE ESPECIES
	* @param inCkvnt_serie_fin SERIE DE FIN DE ESPECIES
	* @param inCkvnt_cantidad TOTAL DE ESPECIES DE LA FACTURA
	* @param inCkvnt_total TOTAL DE LA FACTURA
	* @param inCkvnt_estado_venta ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONTABILIZADA
	* @param inCkvnt_estado ESTADO DEL REGISTRO
	* @param inCkvnt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvnt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_venta(
		String inCkvnt_codigo,
		String inCkasg_codigo,
		int inCkvnt_lote,
		java.util.Date inCkvnt_fecha_ingreso,
		String inCkvnt_numero_venta,
		int inCkvnt_serie_inicio,
		int inCkvnt_serie_fin,
		int inCkvnt_cantidad,
		String inCkvnt_total,
		int inCkvnt_estado_venta,
		boolean inCkvnt_estado,
		String inCkvnt_usuario_insert,
		String inCkvnt_usuario_update
	){
		this.setCKVNT_CODIGO(inCkvnt_codigo);
		this.setCKASG_CODIGO(inCkasg_codigo);
		this.setCKVNT_LOTE(inCkvnt_lote);
		this.setCKVNT_FECHA_INGRESO(inCkvnt_fecha_ingreso);
		this.setCKVNT_NUMERO_VENTA(inCkvnt_numero_venta);
		this.setCKVNT_SERIE_INICIO(inCkvnt_serie_inicio);
		this.setCKVNT_SERIE_FIN(inCkvnt_serie_fin);
		this.setCKVNT_CANTIDAD(inCkvnt_cantidad);
		this.setCKVNT_TOTAL(inCkvnt_total);
		this.setCKVNT_ESTADO_VENTA(inCkvnt_estado_venta);
		this.setCKVNT_ESTADO(inCkvnt_estado);
		this.setCKVNT_USUARIO_INSERT(inCkvnt_usuario_insert);
		this.setCKVNT_USUARIO_UPDATE(inCkvnt_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	*/
	public void setCKASG_CODIGO(String inCkasg_codigo){
		this.myCkasg_codigo = inCkasg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	*/
	public String getCKASG_CODIGO(){
		return this.myCkasg_codigo;
	}

	/**
	* ESTABLECE LOTE AL QUE CORRESPONDE LA VENTA
	* @param inCkvnt_lote LOTE AL QUE CORRESPONDE LA VENTA
	*/
	public void setCKVNT_LOTE(int inCkvnt_lote){
		this.myCkvnt_lote = inCkvnt_lote;
	}
	/**
	* OBTIENE LOTE AL QUE CORRESPONDE LA VENTA
	* @return int LOTE AL QUE CORRESPONDE LA VENTA
	*/
	public int getCKVNT_LOTE(){
		return this.myCkvnt_lote;
	}

	/**
	* ESTABLECE FECHA DE INGRESO DE LAS ESPECIES
	* @param inCkvnt_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES
	*/
	public void setCKVNT_FECHA_INGRESO(java.util.Date inCkvnt_fecha_ingreso){
		this.myCkvnt_fecha_ingreso = inCkvnt_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO DE LAS ESPECIES
	* @return java.util.Date FECHA DE INGRESO DE LAS ESPECIES
	*/
	public java.util.Date getCKVNT_FECHA_INGRESO(){
		return this.myCkvnt_fecha_ingreso;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
	* @param inCkvnt_numero_venta NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
	*/
	public void setCKVNT_NUMERO_VENTA(String inCkvnt_numero_venta){
		this.myCkvnt_numero_venta = inCkvnt_numero_venta;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
	* @return String NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
	*/
	public String getCKVNT_NUMERO_VENTA(){
		return this.myCkvnt_numero_venta;
	}

	/**
	* ESTABLECE SERIE DE INICIO DE ESPECIES
	* @param inCkvnt_serie_inicio SERIE DE INICIO DE ESPECIES
	*/
	public void setCKVNT_SERIE_INICIO(int inCkvnt_serie_inicio){
		this.myCkvnt_serie_inicio = inCkvnt_serie_inicio;
	}
	/**
	* OBTIENE SERIE DE INICIO DE ESPECIES
	* @return int SERIE DE INICIO DE ESPECIES
	*/
	public int getCKVNT_SERIE_INICIO(){
		return this.myCkvnt_serie_inicio;
	}

	/**
	* ESTABLECE SERIE DE FIN DE ESPECIES
	* @param inCkvnt_serie_fin SERIE DE FIN DE ESPECIES
	*/
	public void setCKVNT_SERIE_FIN(int inCkvnt_serie_fin){
		this.myCkvnt_serie_fin = inCkvnt_serie_fin;
	}
	/**
	* OBTIENE SERIE DE FIN DE ESPECIES
	* @return int SERIE DE FIN DE ESPECIES
	*/
	public int getCKVNT_SERIE_FIN(){
		return this.myCkvnt_serie_fin;
	}

	/**
	* ESTABLECE TOTAL DE ESPECIES DE LA FACTURA
	* @param inCkvnt_cantidad TOTAL DE ESPECIES DE LA FACTURA
	*/
	public void setCKVNT_CANTIDAD(int inCkvnt_cantidad){
		this.myCkvnt_cantidad = inCkvnt_cantidad;
	}
	/**
	* OBTIENE TOTAL DE ESPECIES DE LA FACTURA
	* @return int TOTAL DE ESPECIES DE LA FACTURA
	*/
	public int getCKVNT_CANTIDAD(){
		return this.myCkvnt_cantidad;
	}

	/**
	* ESTABLECE TOTAL DE LA FACTURA
	* @param inCkvnt_total TOTAL DE LA FACTURA
	*/
	public void setCKVNT_TOTAL(String inCkvnt_total){
		this.myCkvnt_total = inCkvnt_total;
	}
	/**
	* OBTIENE TOTAL DE LA FACTURA
	* @return String TOTAL DE LA FACTURA
	*/
	public String getCKVNT_TOTAL(){
		return this.myCkvnt_total;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONTABILIZADA
	* @param inCkvnt_estado_venta ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONTABILIZADA
	*/
	public void setCKVNT_ESTADO_VENTA(int inCkvnt_estado_venta){
		this.myCkvnt_estado_venta = inCkvnt_estado_venta;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONTABILIZADA
	* @return int ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONTABILIZADA
	*/
	public int getCKVNT_ESTADO_VENTA(){
		return this.myCkvnt_estado_venta;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkvnt_estado ESTADO DEL REGISTRO
	*/
	public void setCKVNT_ESTADO(boolean inCkvnt_estado){
		this.myCkvnt_estado = inCkvnt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKVNT_ESTADO(){
		return this.myCkvnt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkvnt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKVNT_USUARIO_INSERT(String inCkvnt_usuario_insert){
		this.myCkvnt_usuario_insert = inCkvnt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKVNT_USUARIO_INSERT(){
		return this.myCkvnt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkvnt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKVNT_USUARIO_UPDATE(String inCkvnt_usuario_update){
		this.myCkvnt_usuario_update = inCkvnt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKVNT_USUARIO_UPDATE(){
		return this.myCkvnt_usuario_update;
	}

}
