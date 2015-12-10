package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_asignacion
* TABLA: ASIGNACION
* DESCRIPCION:ALMACENA INFORMACION DE LAS ASIGNACIONES A LOS PUNTOS DE VENTA
* ABREVIATURA:CKASG
*/
public class Cgg_kdx_asignacion implements Serializable{
	private static final long serialVersionUID = 1986887231;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	*/
	private String myCkasg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	*/
	private String myCktrn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	private String myCkupv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	private String myCgg_ckupv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	*/
	private String myCgg_ckasg_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	*/
	private String myCkasg_numero_asignacion;
	/**
	* FECHA DE RECEPCION DE LAS ESPECIES
	*/
	private java.util.Date myCkasg_fecha_recepcion;
	/**
	* CANTIDAD DE ESPECIES
	*/
	private int myCkasg_cantidad;
	/**
	* PRECIO DE VENTA DE LA ESPECIE
	*/
	private java.math.BigDecimal myCkasg_precio_unitario;
	/**
	* SERIE DE INICIO DE LAS ESPECIES
	*/
	private int myCkasg_serie_inicio;
	/**
	* SERIE DE FIN DE LAS ESPECIES
	*/
	private int myCkasg_serie_fin;
	/**
	* COMENTARIO AFIN A LA ASIGNACION
	*/
	private String myCkasg_observacion;
	/**
	* CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	*/
	private int myCkasg_cantidad_disponible;
	/**
	* ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	*/
	private int myCkasg_estado_asignacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkasg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkasg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkasg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_asignacion
	*/
	public Cgg_kdx_asignacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_asignacion
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @param inCktrn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCgg_ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCgg_ckasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	* @param inCkasg_numero_asignacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @param inCkasg_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCkasg_cantidad CANTIDAD DE ESPECIES
	* @param inCkasg_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	* @param inCkasg_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	* @param inCkasg_serie_fin SERIE DE FIN DE LAS ESPECIES
	* @param inCkasg_observacion COMENTARIO AFIN A LA ASIGNACION
	* @param inCkasg_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @param inCkasg_estado_asignacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	* @param inCkasg_estado ESTADO DEL REGISTRO
	* @param inCkasg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkasg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_asignacion(
		String inCkasg_codigo,
		String inCktrn_codigo,
		String inCkupv_codigo,
		String inCgg_ckupv_codigo,
		String inCgg_ckasg_codigo,
		String inCkasg_numero_asignacion,
		java.util.Date inCkasg_fecha_recepcion,
		int inCkasg_cantidad,
		java.math.BigDecimal inCkasg_precio_unitario,
		int inCkasg_serie_inicio,
		int inCkasg_serie_fin,
		String inCkasg_observacion,
		int inCkasg_cantidad_disponible,
		int inCkasg_estado_asignacion,
		boolean inCkasg_estado,
		String inCkasg_usuario_insert,
		String inCkasg_usuario_update
	){
		this.setCKASG_CODIGO(inCkasg_codigo);
		this.setCKTRN_CODIGO(inCktrn_codigo);
		this.setCKUPV_CODIGO(inCkupv_codigo);
		this.setCGG_CKUPV_CODIGO(inCgg_ckupv_codigo);
		this.setCGG_CKASG_CODIGO(inCgg_ckasg_codigo);
		this.setCKASG_NUMERO_ASIGNACION(inCkasg_numero_asignacion);
		this.setCKASG_FECHA_RECEPCION(inCkasg_fecha_recepcion);
		this.setCKASG_CANTIDAD(inCkasg_cantidad);
		this.setCKASG_PRECIO_UNITARIO(inCkasg_precio_unitario);
		this.setCKASG_SERIE_INICIO(inCkasg_serie_inicio);
		this.setCKASG_SERIE_FIN(inCkasg_serie_fin);
		this.setCKASG_OBSERVACION(inCkasg_observacion);
		this.setCKASG_CANTIDAD_DISPONIBLE(inCkasg_cantidad_disponible);
		this.setCKASG_ESTADO_ASIGNACION(inCkasg_estado_asignacion);
		this.setCKASG_ESTADO(inCkasg_estado);
		this.setCKASG_USUARIO_INSERT(inCkasg_usuario_insert);
		this.setCKASG_USUARIO_UPDATE(inCkasg_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCgg_ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	public void setCGG_CKUPV_CODIGO(String inCgg_ckupv_codigo){
		this.myCgg_ckupv_codigo = inCgg_ckupv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	public String getCGG_CKUPV_CODIGO(){
		return this.myCgg_ckupv_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	* @param inCgg_ckasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	*/
	public void setCGG_CKASG_CODIGO(String inCgg_ckasg_codigo){
		this.myCgg_ckasg_codigo = inCgg_ckasg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	*/
	public String getCGG_CKASG_CODIGO(){
		return this.myCgg_ckasg_codigo;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @param inCkasg_numero_asignacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	*/
	public void setCKASG_NUMERO_ASIGNACION(String inCkasg_numero_asignacion){
		this.myCkasg_numero_asignacion = inCkasg_numero_asignacion;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @return String NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	*/
	public String getCKASG_NUMERO_ASIGNACION(){
		return this.myCkasg_numero_asignacion;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCkasg_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES
	*/
	public void setCKASG_FECHA_RECEPCION(java.util.Date inCkasg_fecha_recepcion){
		this.myCkasg_fecha_recepcion = inCkasg_fecha_recepcion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DE LAS ESPECIES
	* @return java.util.Date FECHA DE RECEPCION DE LAS ESPECIES
	*/
	public java.util.Date getCKASG_FECHA_RECEPCION(){
		return this.myCkasg_fecha_recepcion;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES
	* @param inCkasg_cantidad CANTIDAD DE ESPECIES
	*/
	public void setCKASG_CANTIDAD(int inCkasg_cantidad){
		this.myCkasg_cantidad = inCkasg_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES
	* @return int CANTIDAD DE ESPECIES
	*/
	public int getCKASG_CANTIDAD(){
		return this.myCkasg_cantidad;
	}

	/**
	* ESTABLECE PRECIO DE VENTA DE LA ESPECIE
	* @param inCkasg_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	*/
	public void setCKASG_PRECIO_UNITARIO(java.math.BigDecimal inCkasg_precio_unitario){
		this.myCkasg_precio_unitario = inCkasg_precio_unitario;
	}
	/**
	* OBTIENE PRECIO DE VENTA DE LA ESPECIE
	* @return java.math.BigDecimal PRECIO DE VENTA DE LA ESPECIE
	*/
	public java.math.BigDecimal getCKASG_PRECIO_UNITARIO(){
		return this.myCkasg_precio_unitario;
	}

	/**
	* ESTABLECE SERIE DE INICIO DE LAS ESPECIES
	* @param inCkasg_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	*/
	public void setCKASG_SERIE_INICIO(int inCkasg_serie_inicio){
		this.myCkasg_serie_inicio = inCkasg_serie_inicio;
	}
	/**
	* OBTIENE SERIE DE INICIO DE LAS ESPECIES
	* @return int SERIE DE INICIO DE LAS ESPECIES
	*/
	public int getCKASG_SERIE_INICIO(){
		return this.myCkasg_serie_inicio;
	}

	/**
	* ESTABLECE SERIE DE FIN DE LAS ESPECIES
	* @param inCkasg_serie_fin SERIE DE FIN DE LAS ESPECIES
	*/
	public void setCKASG_SERIE_FIN(int inCkasg_serie_fin){
		this.myCkasg_serie_fin = inCkasg_serie_fin;
	}
	/**
	* OBTIENE SERIE DE FIN DE LAS ESPECIES
	* @return int SERIE DE FIN DE LAS ESPECIES
	*/
	public int getCKASG_SERIE_FIN(){
		return this.myCkasg_serie_fin;
	}

	/**
	* ESTABLECE COMENTARIO AFIN A LA ASIGNACION
	* @param inCkasg_observacion COMENTARIO AFIN A LA ASIGNACION
	*/
	public void setCKASG_OBSERVACION(String inCkasg_observacion){
		this.myCkasg_observacion = inCkasg_observacion;
	}
	/**
	* OBTIENE COMENTARIO AFIN A LA ASIGNACION
	* @return String COMENTARIO AFIN A LA ASIGNACION
	*/
	public String getCKASG_OBSERVACION(){
		return this.myCkasg_observacion;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @param inCkasg_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	*/
	public void setCKASG_CANTIDAD_DISPONIBLE(int inCkasg_cantidad_disponible){
		this.myCkasg_cantidad_disponible = inCkasg_cantidad_disponible;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @return int CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	*/
	public int getCKASG_CANTIDAD_DISPONIBLE(){
		return this.myCkasg_cantidad_disponible;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	* @param inCkasg_estado_asignacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	*/
	public void setCKASG_ESTADO_ASIGNACION(int inCkasg_estado_asignacion){
		this.myCkasg_estado_asignacion = inCkasg_estado_asignacion;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	* @return int ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	*/
	public int getCKASG_ESTADO_ASIGNACION(){
		return this.myCkasg_estado_asignacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkasg_estado ESTADO DEL REGISTRO
	*/
	public void setCKASG_ESTADO(boolean inCkasg_estado){
		this.myCkasg_estado = inCkasg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKASG_ESTADO(){
		return this.myCkasg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkasg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKASG_USUARIO_INSERT(String inCkasg_usuario_insert){
		this.myCkasg_usuario_insert = inCkasg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKASG_USUARIO_INSERT(){
		return this.myCkasg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkasg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKASG_USUARIO_UPDATE(String inCkasg_usuario_update){
		this.myCkasg_usuario_update = inCkasg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKASG_USUARIO_UPDATE(){
		return this.myCkasg_usuario_update;
	}

}
