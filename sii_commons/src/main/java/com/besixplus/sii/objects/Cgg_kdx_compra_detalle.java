package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_compra_detalle
* TABLA: COMPRA DETALLE
* DESCRIPCION:ALMACENA INFORMACION DEL DETALLE DE UN FACTURA DE COMPRA.
* ABREVIATURA:CKCMD
*/
public class Cgg_kdx_compra_detalle implements Serializable{
	private static final long serialVersionUID = 972225973;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
	*/
	private String myCkcmd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	*/
	private String myCkcmp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	private String myCkesp_codigo;
	/**
	* SERIE DE INICIO DE LAS ESPECIES
	*/
	private int myCkcmd_serie_inicio;
	/**
	* SERIE DE FIN DE LAS ESPECIES
	*/
	private int myCkcmd_serie_fin;
	/**
	* CANTIDAD DE ESPECIES
	*/
	private int myCkcmd_cantidad;
	/**
	* PRECIO UNITARIO DE LA ESPECIE
	*/
	private java.math.BigDecimal myCkcmd_precio_unitario;
	/**
	* TOTAL DE LA COMPRA
	*/
	private java.math.BigDecimal myCkcmd_total;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkcmd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkcmd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkcmd_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra_detalle
	*/
	public Cgg_kdx_compra_detalle(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra_detalle
	* @param inCkcmd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCkcmd_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	* @param inCkcmd_serie_fin SERIE DE FIN DE LAS ESPECIES
	* @param inCkcmd_cantidad CANTIDAD DE ESPECIES
	* @param inCkcmd_precio_unitario PRECIO UNITARIO DE LA ESPECIE
	* @param inCkcmd_total TOTAL DE LA COMPRA
	* @param inCkcmd_estado ESTADO DEL REGISTRO
	* @param inCkcmd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcmd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_compra_detalle(
		String inCkcmd_codigo,
		String inCkcmp_codigo,
		String inCkesp_codigo,
		int inCkcmd_serie_inicio,
		int inCkcmd_serie_fin,
		int inCkcmd_cantidad,
		java.math.BigDecimal inCkcmd_precio_unitario,
		java.math.BigDecimal inCkcmd_total,
		boolean inCkcmd_estado,
		String inCkcmd_usuario_insert,
		String inCkcmd_usuario_update
	){
		this.setCKCMD_CODIGO(inCkcmd_codigo);
		this.setCKCMP_CODIGO(inCkcmp_codigo);
		this.setCKESP_CODIGO(inCkesp_codigo);
		this.setCKCMD_SERIE_INICIO(inCkcmd_serie_inicio);
		this.setCKCMD_SERIE_FIN(inCkcmd_serie_fin);
		this.setCKCMD_CANTIDAD(inCkcmd_cantidad);
		this.setCKCMD_PRECIO_UNITARIO(inCkcmd_precio_unitario);
		this.setCKCMD_TOTAL(inCkcmd_total);
		this.setCKCMD_ESTADO(inCkcmd_estado);
		this.setCKCMD_USUARIO_INSERT(inCkcmd_usuario_insert);
		this.setCKCMD_USUARIO_UPDATE(inCkcmd_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
	* @param inCkcmd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
	*/
	public void setCKCMD_CODIGO(String inCkcmd_codigo){
		this.myCkcmd_codigo = inCkcmd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
	*/
	public String getCKCMD_CODIGO(){
		return this.myCkcmd_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	*/
	public void setCKCMP_CODIGO(String inCkcmp_codigo){
		this.myCkcmp_codigo = inCkcmp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	*/
	public String getCKCMP_CODIGO(){
		return this.myCkcmp_codigo;
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
	* ESTABLECE SERIE DE INICIO DE LAS ESPECIES
	* @param inCkcmd_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	*/
	public void setCKCMD_SERIE_INICIO(int inCkcmd_serie_inicio){
		this.myCkcmd_serie_inicio = inCkcmd_serie_inicio;
	}
	/**
	* OBTIENE SERIE DE INICIO DE LAS ESPECIES
	* @return int SERIE DE INICIO DE LAS ESPECIES
	*/
	public int getCKCMD_SERIE_INICIO(){
		return this.myCkcmd_serie_inicio;
	}

	/**
	* ESTABLECE SERIE DE FIN DE LAS ESPECIES
	* @param inCkcmd_serie_fin SERIE DE FIN DE LAS ESPECIES
	*/
	public void setCKCMD_SERIE_FIN(int inCkcmd_serie_fin){
		this.myCkcmd_serie_fin = inCkcmd_serie_fin;
	}
	/**
	* OBTIENE SERIE DE FIN DE LAS ESPECIES
	* @return int SERIE DE FIN DE LAS ESPECIES
	*/
	public int getCKCMD_SERIE_FIN(){
		return this.myCkcmd_serie_fin;
	}

	/**
	* ESTABLECE CANTIDAD DE ESPECIES
	* @param inCkcmd_cantidad CANTIDAD DE ESPECIES
	*/
	public void setCKCMD_CANTIDAD(int inCkcmd_cantidad){
		this.myCkcmd_cantidad = inCkcmd_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DE ESPECIES
	* @return int CANTIDAD DE ESPECIES
	*/
	public int getCKCMD_CANTIDAD(){
		return this.myCkcmd_cantidad;
	}

	/**
	* ESTABLECE PRECIO UNITARIO DE LA ESPECIE
	* @param inCkcmd_precio_unitario PRECIO UNITARIO DE LA ESPECIE
	*/
	public void setCKCMD_PRECIO_UNITARIO(java.math.BigDecimal inCkcmd_precio_unitario){
		this.myCkcmd_precio_unitario = inCkcmd_precio_unitario;
	}
	/**
	* OBTIENE PRECIO UNITARIO DE LA ESPECIE
	* @return java.math.BigDecimal PRECIO UNITARIO DE LA ESPECIE
	*/
	public java.math.BigDecimal getCKCMD_PRECIO_UNITARIO(){
		return this.myCkcmd_precio_unitario;
	}

	/**
	* ESTABLECE TOTAL DE LA COMPRA
	* @param inCkcmd_total TOTAL DE LA COMPRA
	*/
	public void setCKCMD_TOTAL(java.math.BigDecimal inCkcmd_total){
		this.myCkcmd_total = inCkcmd_total;
	}
	/**
	* OBTIENE TOTAL DE LA COMPRA
	* @return java.math.BigDecimal TOTAL DE LA COMPRA
	*/
	public java.math.BigDecimal getCKCMD_TOTAL(){
		return this.myCkcmd_total;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkcmd_estado ESTADO DEL REGISTRO
	*/
	public void setCKCMD_ESTADO(boolean inCkcmd_estado){
		this.myCkcmd_estado = inCkcmd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKCMD_ESTADO(){
		return this.myCkcmd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcmd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKCMD_USUARIO_INSERT(String inCkcmd_usuario_insert){
		this.myCkcmd_usuario_insert = inCkcmd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKCMD_USUARIO_INSERT(){
		return this.myCkcmd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkcmd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKCMD_USUARIO_UPDATE(String inCkcmd_usuario_update){
		this.myCkcmd_usuario_update = inCkcmd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKCMD_USUARIO_UPDATE(){
		return this.myCkcmd_usuario_update;
	}

}
