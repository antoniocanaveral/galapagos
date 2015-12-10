package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_transferencia
* TABLA: TRANSFERENCIA
* DESCRIPCION:ALMACENA INFORMACION DE LAS ASIGNACIONES A LOS PUNTOS DE VENTA
* ABREVIATURA:CKTRN
*/
public class Cgg_kdx_transferencia implements Serializable{
	private static final long serialVersionUID = 1343668313;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	*/
	private String myCktrn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	private String myCkpvt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	private String myCkesp_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
	*/
	private String myCktrn_numero_transferencia;
	/**
	* FECHA DE RECEPCION DE LAS ESPECIES
	*/
	private java.util.Date myCktrn_fecha_recepcion;
	/**
	* CANTIDAD DE ESPECIES
	*/
	private int myCktrn_cantidad;
	/**
	* PRECIO DE VENTA DE LA ESPECIE
	*/
	private java.math.BigDecimal myCktrn_precio_unitario;
	/**
	* SERIE DE INICIO DE LAS ESPECIES
	*/
	private int myCktrn_serie_inicio;
	/**
	* SERIE DE FIN DE LAS ESPECIES
	*/
	private int myCktrn_serie_fin;
	/**
	* COMENTARIO AFIN A LA TRANSFERENCIA
	*/
	private String myCktrn_observacion;
	/**
	* CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	*/
	private int myCktrn_cantidad_disponible;
	/**
	* ESTADO PARA ADMINISTRACION DE INFORMACION DE TRANSFERENCIAS
	*/
	private int myCktrn_estado_transferencia;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCktrn_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCktrn_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCktrn_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_transferencia
	*/
	public Cgg_kdx_transferencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_transferencia
	* @param inCktrn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCktrn_numero_transferencia NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
	* @param inCktrn_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCktrn_cantidad CANTIDAD DE ESPECIES
	* @param inCktrn_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	* @param inCktrn_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	* @param inCktrn_serie_fin SERIE DE FIN DE LAS ESPECIES
	* @param inCktrn_observacion COMENTARIO AFIN A LA TRANSFERENCIA
	* @param inCktrn_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @param inCktrn_estado_transferencia ESTADO PARA ADMINISTRACION DE INFORMACION DE TRANSFERENCIAS
	* @param inCktrn_estado ESTADO DEL REGISTRO
	* @param inCktrn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCktrn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_transferencia(
		String inCktrn_codigo,
		String inCkpvt_codigo,
		String inCkesp_codigo,
		String inCktrn_numero_transferencia,
		java.util.Date inCktrn_fecha_recepcion,
		int inCktrn_cantidad,
		java.math.BigDecimal inCktrn_precio_unitario,
		int inCktrn_serie_inicio,
		int inCktrn_serie_fin,
		String inCktrn_observacion,
		int inCktrn_cantidad_disponible,
		int inCktrn_estado_transferencia,
		boolean inCktrn_estado,
		String inCktrn_usuario_insert,
		String inCktrn_usuario_update
	){
		this.setCKTRN_CODIGO(inCktrn_codigo);
		this.setCKPVT_CODIGO(inCkpvt_codigo);
		this.setCKESP_CODIGO(inCkesp_codigo);
		this.setCKTRN_NUMERO_TRANSFERENCIA(inCktrn_numero_transferencia);
		this.setCKTRN_FECHA_RECEPCION(inCktrn_fecha_recepcion);
		this.setCKTRN_CANTIDAD(inCktrn_cantidad);
		this.setCKTRN_PRECIO_UNITARIO(inCktrn_precio_unitario);
		this.setCKTRN_SERIE_INICIO(inCktrn_serie_inicio);
		this.setCKTRN_SERIE_FIN(inCktrn_serie_fin);
		this.setCKTRN_OBSERVACION(inCktrn_observacion);
		this.setCKTRN_CANTIDAD_DISPONIBLE(inCktrn_cantidad_disponible);
		this.setCKTRN_ESTADO_TRANSFERENCIA(inCktrn_estado_transferencia);
		this.setCKTRN_ESTADO(inCktrn_estado);
		this.setCKTRN_USUARIO_INSERT(inCktrn_usuario_insert);
		this.setCKTRN_USUARIO_UPDATE(inCktrn_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	* @param inCktrn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	*/
	public void setCKTRN_CODIGO(String inCktrn_codigo){
		this.myCktrn_codigo = inCktrn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	*/
	public String getCKTRN_CODIGO(){
		return this.myCktrn_codigo;
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
	* ESTABLECE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
	* @param inCktrn_numero_transferencia NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
	*/
	public void setCKTRN_NUMERO_TRANSFERENCIA(String inCktrn_numero_transferencia){
		this.myCktrn_numero_transferencia = inCktrn_numero_transferencia;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
	* @return String NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA TRANSFERENCIA
	*/
	public String getCKTRN_NUMERO_TRANSFERENCIA(){
		return this.myCktrn_numero_transferencia;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCktrn_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES
	*/
	public void setCKTRN_FECHA_RECEPCION(java.util.Date inCktrn_fecha_recepcion){
		this.myCktrn_fecha_recepcion = inCktrn_fecha_recepcion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DE LAS ESPECIES
	* @return java.util.Date FECHA DE RECEPCION DE LAS ESPECIES
	*/
	public java.util.Date getCKTRN_FECHA_RECEPCION(){
		return this.myCktrn_fecha_recepcion;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES
	* @param inCktrn_cantidad CANTIDAD DE ESPECIES
	*/
	public void setCKTRN_CANTIDAD(int inCktrn_cantidad){
		this.myCktrn_cantidad = inCktrn_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES
	* @return int CANTIDAD DE ESPECIES
	*/
	public int getCKTRN_CANTIDAD(){
		return this.myCktrn_cantidad;
	}

	/**
	* ESTABLECE PRECIO DE VENTA DE LA ESPECIE
	* @param inCktrn_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	*/
	public void setCKTRN_PRECIO_UNITARIO(java.math.BigDecimal inCktrn_precio_unitario){
		this.myCktrn_precio_unitario = inCktrn_precio_unitario;
	}
	/**
	* OBTIENE PRECIO DE VENTA DE LA ESPECIE
	* @return java.math.BigDecimal PRECIO DE VENTA DE LA ESPECIE
	*/
	public java.math.BigDecimal getCKTRN_PRECIO_UNITARIO(){
		return this.myCktrn_precio_unitario;
	}

	/**
	* ESTABLECE SERIE DE INICIO DE LAS ESPECIES
	* @param inCktrn_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	*/
	public void setCKTRN_SERIE_INICIO(int inCktrn_serie_inicio){
		this.myCktrn_serie_inicio = inCktrn_serie_inicio;
	}
	/**
	* OBTIENE SERIE DE INICIO DE LAS ESPECIES
	* @return int SERIE DE INICIO DE LAS ESPECIES
	*/
	public int getCKTRN_SERIE_INICIO(){
		return this.myCktrn_serie_inicio;
	}

	/**
	* ESTABLECE SERIE DE FIN DE LAS ESPECIES
	* @param inCktrn_serie_fin SERIE DE FIN DE LAS ESPECIES
	*/
	public void setCKTRN_SERIE_FIN(int inCktrn_serie_fin){
		this.myCktrn_serie_fin = inCktrn_serie_fin;
	}
	/**
	* OBTIENE SERIE DE FIN DE LAS ESPECIES
	* @return int SERIE DE FIN DE LAS ESPECIES
	*/
	public int getCKTRN_SERIE_FIN(){
		return this.myCktrn_serie_fin;
	}

	/**
	* ESTABLECE COMENTARIO AFIN A LA TRANSFERENCIA
	* @param inCktrn_observacion COMENTARIO AFIN A LA TRANSFERENCIA
	*/
	public void setCKTRN_OBSERVACION(String inCktrn_observacion){
		this.myCktrn_observacion = inCktrn_observacion;
	}
	/**
	* OBTIENE COMENTARIO AFIN A LA TRANSFERENCIA
	* @return String COMENTARIO AFIN A LA TRANSFERENCIA
	*/
	public String getCKTRN_OBSERVACION(){
		return this.myCktrn_observacion;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @param inCktrn_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	*/
	public void setCKTRN_CANTIDAD_DISPONIBLE(int inCktrn_cantidad_disponible){
		this.myCktrn_cantidad_disponible = inCktrn_cantidad_disponible;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @return int CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	*/
	public int getCKTRN_CANTIDAD_DISPONIBLE(){
		return this.myCktrn_cantidad_disponible;
	}

	/**
	* ESTABLECE ESTADO PARA ADMINISTRACION DE INFORMACION DE TRANSFERENCIAS
	* @param inCktrn_estado_transferencia ESTADO PARA ADMINISTRACION DE INFORMACION DE TRANSFERENCIAS
	*/
	public void setCKTRN_ESTADO_TRANSFERENCIA(int inCktrn_estado_transferencia){
		this.myCktrn_estado_transferencia = inCktrn_estado_transferencia;
	}
	/**
	* OBTIENE ESTADO PARA ADMINISTRACION DE INFORMACION DE TRANSFERENCIAS
	* @return int ESTADO PARA ADMINISTRACION DE INFORMACION DE TRANSFERENCIAS
	*/
	public int getCKTRN_ESTADO_TRANSFERENCIA(){
		return this.myCktrn_estado_transferencia;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCktrn_estado ESTADO DEL REGISTRO
	*/
	public void setCKTRN_ESTADO(boolean inCktrn_estado){
		this.myCktrn_estado = inCktrn_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKTRN_ESTADO(){
		return this.myCktrn_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCktrn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKTRN_USUARIO_INSERT(String inCktrn_usuario_insert){
		this.myCktrn_usuario_insert = inCktrn_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKTRN_USUARIO_INSERT(){
		return this.myCktrn_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCktrn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKTRN_USUARIO_UPDATE(String inCktrn_usuario_update){
		this.myCktrn_usuario_update = inCktrn_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKTRN_USUARIO_UPDATE(){
		return this.myCktrn_usuario_update;
	}

}
