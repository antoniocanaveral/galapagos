package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_especie
* TABLA: ESPECIE
* DESCRIPCION:ALMACENA INFORMACION DE LAS ESPECIES VALORADAS
* ABREVIATURA:CKESP
*/
public class Cgg_kdx_especie implements Serializable{
	private static final long serialVersionUID = 1760617622;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	private String myCkesp_codigo;
	/**
	* NOMBRE DEL TIPO DE ESPECIE
	*/
	private String myCkesp_nombre;
	/**
	* VALOR DE VENTA DE LA ESPECIE
	*/
	private java.math.BigDecimal myCkesp_precio;
	/**
	* CANTIDAD DISPONIBLE DE LA ESPECIE
	*/
	private int myCkesp_cantidad;
	/**
	* CANTIDAD MINIMA DE DISPONIBILIDAD
	*/
	private int myCkesp_disponible_min;
	/**
	* CANTIDAD MAXIMA DE DISPONIBILIDAD
	*/
	private int myCkesp_disponible_max;
	/**
	* TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	*/
	private int myCkesp_tipo;
	/**
	* INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	*/
	private int myCkesp_indice;
	/**
	* NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	*/
	private String myCkesp_reporte;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkesp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkesp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkesp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_especie
	*/
	public Cgg_kdx_especie(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_especie
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCkesp_nombre NOMBRE DEL TIPO DE ESPECIE
	* @param inCkesp_precio VALOR DE VENTA DE LA ESPECIE
	* @param inCkesp_cantidad CANTIDAD DISPONIBLE DE LA ESPECIE
	* @param inCkesp_disponible_min CANTIDAD MINIMA DE DISPONIBILIDAD
	* @param inCkesp_disponible_max CANTIDAD MAXIMA DE DISPONIBILIDAD
	* @param inCkesp_tipo TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	* @param inCkesp_indice INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	* @param inCkesp_reporte NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	* @param inCkesp_estado ESTADO DEL REGISTRO
	* @param inCkesp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkesp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_especie(
		String inCkesp_codigo,
		String inCkesp_nombre,
		java.math.BigDecimal inCkesp_precio,
		int inCkesp_cantidad,
		int inCkesp_disponible_min,
		int inCkesp_disponible_max,
		int inCkesp_tipo,
		int inCkesp_indice,
		String inCkesp_reporte,
		boolean inCkesp_estado,
		String inCkesp_usuario_insert,
		String inCkesp_usuario_update
	){
		this.setCKESP_CODIGO(inCkesp_codigo);
		this.setCKESP_NOMBRE(inCkesp_nombre);
		this.setCKESP_PRECIO(inCkesp_precio);
		this.setCKESP_CANTIDAD(inCkesp_cantidad);
		this.setCKESP_DISPONIBLE_MIN(inCkesp_disponible_min);
		this.setCKESP_DISPONIBLE_MAX(inCkesp_disponible_max);
		this.setCKESP_TIPO(inCkesp_tipo);
		this.setCKESP_INDICE(inCkesp_indice);
		this.setCKESP_REPORTE(inCkesp_reporte);
		this.setCKESP_ESTADO(inCkesp_estado);
		this.setCKESP_USUARIO_INSERT(inCkesp_usuario_insert);
		this.setCKESP_USUARIO_UPDATE(inCkesp_usuario_update);
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
	* ESTABLECE NOMBRE DEL TIPO DE ESPECIE
	* @param inCkesp_nombre NOMBRE DEL TIPO DE ESPECIE
	*/
	public void setCKESP_NOMBRE(String inCkesp_nombre){
		this.myCkesp_nombre = inCkesp_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL TIPO DE ESPECIE
	* @return String NOMBRE DEL TIPO DE ESPECIE
	*/
	public String getCKESP_NOMBRE(){
		return this.myCkesp_nombre;
	}

	/**
	* ESTABLECE VALOR DE VENTA DE LA ESPECIE
	* @param inCkesp_precio VALOR DE VENTA DE LA ESPECIE
	*/
	public void setCKESP_PRECIO(java.math.BigDecimal inCkesp_precio){
		this.myCkesp_precio = inCkesp_precio;
	}
	/**
	* OBTIENE VALOR DE VENTA DE LA ESPECIE
	* @return java.math.BigDecimal VALOR DE VENTA DE LA ESPECIE
	*/
	public java.math.BigDecimal getCKESP_PRECIO(){
		return this.myCkesp_precio;
	}

	/**
	* ESTABLECE CANTIDAD DISPONIBLE DE LA ESPECIE
	* @param inCkesp_cantidad CANTIDAD DISPONIBLE DE LA ESPECIE
	*/
	public void setCKESP_CANTIDAD(int inCkesp_cantidad){
		this.myCkesp_cantidad = inCkesp_cantidad;
	}
	/**
	* OBTIENE CANTIDAD DISPONIBLE DE LA ESPECIE
	* @return int CANTIDAD DISPONIBLE DE LA ESPECIE
	*/
	public int getCKESP_CANTIDAD(){
		return this.myCkesp_cantidad;
	}

	/**
	* ESTABLECE CANTIDAD MINIMA DE DISPONIBILIDAD
	* @param inCkesp_disponible_min CANTIDAD MINIMA DE DISPONIBILIDAD
	*/
	public void setCKESP_DISPONIBLE_MIN(int inCkesp_disponible_min){
		this.myCkesp_disponible_min = inCkesp_disponible_min;
	}
	/**
	* OBTIENE CANTIDAD MINIMA DE DISPONIBILIDAD
	* @return int CANTIDAD MINIMA DE DISPONIBILIDAD
	*/
	public int getCKESP_DISPONIBLE_MIN(){
		return this.myCkesp_disponible_min;
	}

	/**
	* ESTABLECE CANTIDAD MAXIMA DE DISPONIBILIDAD
	* @param inCkesp_disponible_max CANTIDAD MAXIMA DE DISPONIBILIDAD
	*/
	public void setCKESP_DISPONIBLE_MAX(int inCkesp_disponible_max){
		this.myCkesp_disponible_max = inCkesp_disponible_max;
	}
	/**
	* OBTIENE CANTIDAD MAXIMA DE DISPONIBILIDAD
	* @return int CANTIDAD MAXIMA DE DISPONIBILIDAD
	*/
	public int getCKESP_DISPONIBLE_MAX(){
		return this.myCkesp_disponible_max;
	}

	/**
	* ESTABLECE TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	* @param inCkesp_tipo TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	*/
	public void setCKESP_TIPO(int inCkesp_tipo){
		this.myCkesp_tipo = inCkesp_tipo;
	}
	/**
	* OBTIENE TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	* @return int TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	*/
	public int getCKESP_TIPO(){
		return this.myCkesp_tipo;
	}

	/**
	* ESTABLECE INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	* @param inCkesp_indice INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	*/
	public void setCKESP_INDICE(int inCkesp_indice){
		this.myCkesp_indice = inCkesp_indice;
	}
	/**
	* OBTIENE INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	* @return int INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	*/
	public int getCKESP_INDICE(){
		return this.myCkesp_indice;
	}

	/**
	* ESTABLECE NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	* @param inCkesp_reporte NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	*/
	public void setCKESP_REPORTE(String inCkesp_reporte){
		this.myCkesp_reporte = inCkesp_reporte;
	}
	/**
	* OBTIENE NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	* @return String NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	*/
	public String getCKESP_REPORTE(){
		return this.myCkesp_reporte;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkesp_estado ESTADO DEL REGISTRO
	*/
	public void setCKESP_ESTADO(boolean inCkesp_estado){
		this.myCkesp_estado = inCkesp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKESP_ESTADO(){
		return this.myCkesp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkesp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKESP_USUARIO_INSERT(String inCkesp_usuario_insert){
		this.myCkesp_usuario_insert = inCkesp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKESP_USUARIO_INSERT(){
		return this.myCkesp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkesp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKESP_USUARIO_UPDATE(String inCkesp_usuario_update){
		this.myCkesp_usuario_update = inCkesp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKESP_USUARIO_UPDATE(){
		return this.myCkesp_usuario_update;
	}

}
