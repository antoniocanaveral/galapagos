package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_anulacion
* TABLA:ANULACION
* DESCRIPCION:ALMACENA INFORMACION DE LAS ANULACIONES DE ESPECIES REALIZADAS EN LOS PUNTOS DE VENTA
* ABREVIATURA:CKANL
*/
public class Cgg_kdx_anulacion implements Serializable{
	private static final long serialVersionUID = 1442941050;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	*/
	private String myCkanl_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	*/
	private String myCkasg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	private String myCkupv_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	*/
	private String myCkanl_numero_anulacion;
	/**
	* FECHA DE RECEPCION DE LAS ESPECIES
	*/
	private java.util.Date myCkanl_fecha_anulacion;
	/**
	* CANTIDAD DE ESPECIES
	*/
	private int myCkanl_cantidad;
	/**
	* PRECIO DE VENTA DE LA ESPECIE
	*/
	private java.math.BigDecimal myCkanl_precio_unitario;
	/**
	* VALOR TOTAL DE LA ANULACION
	*/
	private java.math.BigDecimal myCkanl_precio_total;
	/**
	* SERIE DE INICIO DE LAS ESPECIES
	*/
	private int myCkanl_serie_inicio;
	/**
	* SERIE DE FIN DE LAS ESPECIES
	*/
	private int myCkanl_serie_fin;
	/**
	* COMENTARIO AFIN A LA ASIGNACION
	*/
	private String myCkanl_observacion;
	/**
	* DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	*/
	private String myCkanl_justificacion;
	/**
	* TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	*/
	private int myCkanl_tipo_anulacion;
	/**
	* ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	*/
	private int myCkanl_estado_anulacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkanl_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkanl_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkanl_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_anulacion
	*/
	public Cgg_kdx_anulacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_anulacion
	* @param inCkanl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCkanl_numero_anulacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @param inCkanl_fecha_anulacion FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCkanl_cantidad CANTIDAD DE ESPECIES
	* @param inCkanl_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	* @param inCkanl_precio_total VALOR TOTAL DE LA ANULACION
	* @param inCkanl_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	* @param inCkanl_serie_fin SERIE DE FIN DE LAS ESPECIES
	* @param inCkanl_observacion COMENTARIO AFIN A LA ASIGNACION
	* @param inCkanl_justificacion DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	* @param inCkanl_tipo_anulacion TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	* @param inCkanl_estado_anulacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	* @param inCkanl_estado ESTADO DEL REGISTRO
	* @param inCkanl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkanl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_anulacion(
		String inCkanl_codigo,
		String inCkasg_codigo,
		String inCkupv_codigo,
		String inCkanl_numero_anulacion,
		java.util.Date inCkanl_fecha_anulacion,
		int inCkanl_cantidad,
		java.math.BigDecimal inCkanl_precio_unitario,
		java.math.BigDecimal inCkanl_precio_total,
		int inCkanl_serie_inicio,
		int inCkanl_serie_fin,
		String inCkanl_observacion,
		String inCkanl_justificacion,
		int inCkanl_tipo_anulacion,
		int inCkanl_estado_anulacion,
		boolean inCkanl_estado,
		String inCkanl_usuario_insert,
		String inCkanl_usuario_update
	){
		this.setCKANL_CODIGO(inCkanl_codigo);
		this.setCKASG_CODIGO(inCkasg_codigo);
		this.setCKUPV_CODIGO(inCkupv_codigo);
		this.setCKANL_NUMERO_ANULACION(inCkanl_numero_anulacion);
		this.setCKANL_FECHA_ANULACION(inCkanl_fecha_anulacion);
		this.setCKANL_CANTIDAD(inCkanl_cantidad);
		this.setCKANL_PRECIO_UNITARIO(inCkanl_precio_unitario);
		this.setCKANL_PRECIO_TOTAL(inCkanl_precio_total);
		this.setCKANL_SERIE_INICIO(inCkanl_serie_inicio);
		this.setCKANL_SERIE_FIN(inCkanl_serie_fin);
		this.setCKANL_OBSERVACION(inCkanl_observacion);
		this.setCKANL_JUSTIFICACION(inCkanl_justificacion);
		this.setCKANL_TIPO_ANULACION(inCkanl_tipo_anulacion);
		this.setCKANL_ESTADO_ANULACION(inCkanl_estado_anulacion);
		this.setCKANL_ESTADO(inCkanl_estado);
		this.setCKANL_USUARIO_INSERT(inCkanl_usuario_insert);
		this.setCKANL_USUARIO_UPDATE(inCkanl_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	* @param inCkanl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	*/
	public void setCKANL_CODIGO(String inCkanl_codigo){
		this.myCkanl_codigo = inCkanl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	*/
	public String getCKANL_CODIGO(){
		return this.myCkanl_codigo;
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
	* ESTABLECE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @param inCkanl_numero_anulacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	*/
	public void setCKANL_NUMERO_ANULACION(String inCkanl_numero_anulacion){
		this.myCkanl_numero_anulacion = inCkanl_numero_anulacion;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @return String NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	*/
	public String getCKANL_NUMERO_ANULACION(){
		return this.myCkanl_numero_anulacion;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCkanl_fecha_anulacion FECHA DE RECEPCION DE LAS ESPECIES
	*/
	public void setCKANL_FECHA_ANULACION(java.util.Date inCkanl_fecha_anulacion){
		this.myCkanl_fecha_anulacion = inCkanl_fecha_anulacion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DE LAS ESPECIES
	* @return java.util.Date FECHA DE RECEPCION DE LAS ESPECIES
	*/
	public java.util.Date getCKANL_FECHA_ANULACION(){
		return this.myCkanl_fecha_anulacion;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES
	* @param inCkanl_cantidad CANTIDAD DE ESPECIES
	*/
	public void setCKANL_CANTIDAD(int inCkanl_cantidad){
		this.myCkanl_cantidad = inCkanl_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES
	* @return int CANTIDAD DE ESPECIES
	*/
	public int getCKANL_CANTIDAD(){
		return this.myCkanl_cantidad;
	}

	/**
	* ESTABLECE PRECIO DE VENTA DE LA ESPECIE
	* @param inCkanl_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	*/
	public void setCKANL_PRECIO_UNITARIO(java.math.BigDecimal inCkanl_precio_unitario){
		this.myCkanl_precio_unitario = inCkanl_precio_unitario;
	}
	/**
	* OBTIENE PRECIO DE VENTA DE LA ESPECIE
	* @return java.math.BigDecimal PRECIO DE VENTA DE LA ESPECIE
	*/
	public java.math.BigDecimal getCKANL_PRECIO_UNITARIO(){
		return this.myCkanl_precio_unitario;
	}

	/**
	* ESTABLECE VALOR TOTAL DE LA ANULACION
	* @param inCkanl_precio_total VALOR TOTAL DE LA ANULACION
	*/
	public void setCKANL_PRECIO_TOTAL(java.math.BigDecimal inCkanl_precio_total){
		this.myCkanl_precio_total = inCkanl_precio_total;
	}
	/**
	* OBTIENE VALOR TOTAL DE LA ANULACION
	* @return java.math.BigDecimal VALOR TOTAL DE LA ANULACION
	*/
	public java.math.BigDecimal getCKANL_PRECIO_TOTAL(){
		return this.myCkanl_precio_total;
	}

	/**
	* ESTABLECE SERIE DE INICIO DE LAS ESPECIES
	* @param inCkanl_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	*/
	public void setCKANL_SERIE_INICIO(int inCkanl_serie_inicio){
		this.myCkanl_serie_inicio = inCkanl_serie_inicio;
	}
	/**
	* OBTIENE SERIE DE INICIO DE LAS ESPECIES
	* @return int SERIE DE INICIO DE LAS ESPECIES
	*/
	public int getCKANL_SERIE_INICIO(){
		return this.myCkanl_serie_inicio;
	}

	/**
	* ESTABLECE SERIE DE FIN DE LAS ESPECIES
	* @param inCkanl_serie_fin SERIE DE FIN DE LAS ESPECIES
	*/
	public void setCKANL_SERIE_FIN(int inCkanl_serie_fin){
		this.myCkanl_serie_fin = inCkanl_serie_fin;
	}
	/**
	* OBTIENE SERIE DE FIN DE LAS ESPECIES
	* @return int SERIE DE FIN DE LAS ESPECIES
	*/
	public int getCKANL_SERIE_FIN(){
		return this.myCkanl_serie_fin;
	}

	/**
	* ESTABLECE COMENTARIO AFIN A LA ASIGNACION
	* @param inCkanl_observacion COMENTARIO AFIN A LA ASIGNACION
	*/
	public void setCKANL_OBSERVACION(String inCkanl_observacion){
		this.myCkanl_observacion = inCkanl_observacion;
	}
	/**
	* OBTIENE COMENTARIO AFIN A LA ASIGNACION
	* @return String COMENTARIO AFIN A LA ASIGNACION
	*/
	public String getCKANL_OBSERVACION(){
		return this.myCkanl_observacion;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	* @param inCkanl_justificacion DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	*/
	public void setCKANL_JUSTIFICACION(String inCkanl_justificacion){
		this.myCkanl_justificacion = inCkanl_justificacion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	* @return String DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	*/
	public String getCKANL_JUSTIFICACION(){
		return this.myCkanl_justificacion;
	}

	/**
	* ESTABLECE TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	* @param inCkanl_tipo_anulacion TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	*/
	public void setCKANL_TIPO_ANULACION(int inCkanl_tipo_anulacion){
		this.myCkanl_tipo_anulacion = inCkanl_tipo_anulacion;
	}
	/**
	* OBTIENE TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	* @return int TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	*/
	public int getCKANL_TIPO_ANULACION(){
		return this.myCkanl_tipo_anulacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	* @param inCkanl_estado_anulacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	*/
	public void setCKANL_ESTADO_ANULACION(int inCkanl_estado_anulacion){
		this.myCkanl_estado_anulacion = inCkanl_estado_anulacion;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	* @return int ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	*/
	public int getCKANL_ESTADO_ANULACION(){
		return this.myCkanl_estado_anulacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkanl_estado ESTADO DEL REGISTRO
	*/
	public void setCKANL_ESTADO(boolean inCkanl_estado){
		this.myCkanl_estado = inCkanl_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKANL_ESTADO(){
		return this.myCkanl_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkanl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKANL_USUARIO_INSERT(String inCkanl_usuario_insert){
		this.myCkanl_usuario_insert = inCkanl_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKANL_USUARIO_INSERT(){
		return this.myCkanl_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkanl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKANL_USUARIO_UPDATE(String inCkanl_usuario_update){
		this.myCkanl_usuario_update = inCkanl_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKANL_USUARIO_UPDATE(){
		return this.myCkanl_usuario_update;
	}

}
