package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_compra
* TABLA: INGRESO
* DESCRIPCION:ALMACENA INFORMACION DE LAS COMPRAS DE LAS ESPECIES VALORADAS
* ABREVIATURA:CKCMP
*/
public class Cgg_kdx_compra implements Serializable{
	private static final long serialVersionUID = 2126609180;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	*/
	private String myCkcmp_codigo;
	/**
	* LOTE AL QUE CORRESPONDE LA COMPRA
	*/
	private int myCkcmp_lote;
	/**
	* FECHA DE INGRESO DE LAS ESPECIES
	*/
	private java.util.Date myCkcmp_fecha_ingreso;
	/**
	* SERIE DEL LOTE DE ESPECIES
	*/
	private String myCkcmp_serie;
	/**
	* NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	*/
	private String myCkcmp_procedencia;
	/**
	* TOTAL DE ESPECIES DE LA FACTURA
	*/
	private int myCkcmp_cantidad;
	/**
	* NUMERO DE FACTURA DE LA COMPRA.
	*/
	private String myCkcmp_factura;
	/**
	* TOTAL DE LA FACTURA
	*/
	private String myCkcmp_total;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkcmp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkcmp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkcmp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra
	*/
	public Cgg_kdx_compra(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_compra
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @param inCkcmp_lote LOTE AL QUE CORRESPONDE LA COMPRA
	* @param inCkcmp_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES
	* @param inCkcmp_serie SERIE DEL LOTE DE ESPECIES
	* @param inCkcmp_procedencia NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	* @param inCkcmp_cantidad TOTAL DE ESPECIES DE LA FACTURA
	* @param inCkcmp_factura NUMERO DE FACTURA DE LA COMPRA.
	* @param inCkcmp_total TOTAL DE LA FACTURA
	* @param inCkcmp_estado ESTADO DEL REGISTRO
	* @param inCkcmp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcmp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_compra(
		String inCkcmp_codigo,
		int inCkcmp_lote,
		java.util.Date inCkcmp_fecha_ingreso,
		String inCkcmp_serie,
		String inCkcmp_procedencia,
		int inCkcmp_cantidad,
		String inCkcmp_factura,
		String inCkcmp_total,
		boolean inCkcmp_estado,
		String inCkcmp_usuario_insert,
		String inCkcmp_usuario_update
	){
		this.setCKCMP_CODIGO(inCkcmp_codigo);
		this.setCKCMP_LOTE(inCkcmp_lote);
		this.setCKCMP_FECHA_INGRESO(inCkcmp_fecha_ingreso);
		this.setCKCMP_SERIE(inCkcmp_serie);
		this.setCKCMP_PROCEDENCIA(inCkcmp_procedencia);
		this.setCKCMP_CANTIDAD(inCkcmp_cantidad);
		this.setCKCMP_FACTURA(inCkcmp_factura);
		this.setCKCMP_TOTAL(inCkcmp_total);
		this.setCKCMP_ESTADO(inCkcmp_estado);
		this.setCKCMP_USUARIO_INSERT(inCkcmp_usuario_insert);
		this.setCKCMP_USUARIO_UPDATE(inCkcmp_usuario_update);
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
	* ESTABLECE LOTE AL QUE CORRESPONDE LA COMPRA
	* @param inCkcmp_lote LOTE AL QUE CORRESPONDE LA COMPRA
	*/
	public void setCKCMP_LOTE(int inCkcmp_lote){
		this.myCkcmp_lote = inCkcmp_lote;
	}
	/**
	* OBTIENE LOTE AL QUE CORRESPONDE LA COMPRA
	* @return int LOTE AL QUE CORRESPONDE LA COMPRA
	*/
	public int getCKCMP_LOTE(){
		return this.myCkcmp_lote;
	}

	/**
	* ESTABLECE FECHA DE INGRESO DE LAS ESPECIES
	* @param inCkcmp_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES
	*/
	public void setCKCMP_FECHA_INGRESO(java.util.Date inCkcmp_fecha_ingreso){
		this.myCkcmp_fecha_ingreso = inCkcmp_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO DE LAS ESPECIES
	* @return java.util.Date FECHA DE INGRESO DE LAS ESPECIES
	*/
	public java.util.Date getCKCMP_FECHA_INGRESO(){
		return this.myCkcmp_fecha_ingreso;
	}

	/**
	* ESTABLECE SERIE DEL LOTE DE ESPECIES
	* @param inCkcmp_serie SERIE DEL LOTE DE ESPECIES
	*/
	public void setCKCMP_SERIE(String inCkcmp_serie){
		this.myCkcmp_serie = inCkcmp_serie;
	}
	/**
	* OBTIENE SERIE DEL LOTE DE ESPECIES
	* @return String SERIE DEL LOTE DE ESPECIES
	*/
	public String getCKCMP_SERIE(){
		return this.myCkcmp_serie;
	}

	/**
	* ESTABLECE NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	* @param inCkcmp_procedencia NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	*/
	public void setCKCMP_PROCEDENCIA(String inCkcmp_procedencia){
		this.myCkcmp_procedencia = inCkcmp_procedencia;
	}
	/**
	* OBTIENE NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	* @return String NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	*/
	public String getCKCMP_PROCEDENCIA(){
		return this.myCkcmp_procedencia;
	}

	/**
	* ESTABLECE TOTAL DE ESPECIES DE LA FACTURA
	* @param inCkcmp_cantidad TOTAL DE ESPECIES DE LA FACTURA
	*/
	public void setCKCMP_CANTIDAD(int inCkcmp_cantidad){
		this.myCkcmp_cantidad = inCkcmp_cantidad;
	}
	/**
	* OBTIENE TOTAL DE ESPECIES DE LA FACTURA
	* @return int TOTAL DE ESPECIES DE LA FACTURA
	*/
	public int getCKCMP_CANTIDAD(){
		return this.myCkcmp_cantidad;
	}

	/**
	* ESTABLECE NUMERO DE FACTURA DE LA COMPRA.
	* @param inCkcmp_factura NUMERO DE FACTURA DE LA COMPRA.
	*/
	public void setCKCMP_FACTURA(String inCkcmp_factura){
		this.myCkcmp_factura = inCkcmp_factura;
	}
	/**
	* OBTIENE NUMERO DE FACTURA DE LA COMPRA.
	* @return String NUMERO DE FACTURA DE LA COMPRA.
	*/
	public String getCKCMP_FACTURA(){
		return this.myCkcmp_factura;
	}

	/**
	* ESTABLECE TOTAL DE LA FACTURA
	* @param inCkcmp_total TOTAL DE LA FACTURA
	*/
	public void setCKCMP_TOTAL(String inCkcmp_total){
		this.myCkcmp_total = inCkcmp_total;
	}
	/**
	* OBTIENE TOTAL DE LA FACTURA
	* @return String TOTAL DE LA FACTURA
	*/
	public String getCKCMP_TOTAL(){
		return this.myCkcmp_total;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkcmp_estado ESTADO DEL REGISTRO
	*/
	public void setCKCMP_ESTADO(boolean inCkcmp_estado){
		this.myCkcmp_estado = inCkcmp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKCMP_ESTADO(){
		return this.myCkcmp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkcmp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKCMP_USUARIO_INSERT(String inCkcmp_usuario_insert){
		this.myCkcmp_usuario_insert = inCkcmp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKCMP_USUARIO_INSERT(){
		return this.myCkcmp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkcmp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKCMP_USUARIO_UPDATE(String inCkcmp_usuario_update){
		this.myCkcmp_usuario_update = inCkcmp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKCMP_USUARIO_UPDATE(){
		return this.myCkcmp_usuario_update;
	}

}
