package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_ger_matriz
* TABLA: GERENCIAL MATRIZ
* DESCRIPCION:ALMACENA INFORMACION EXTERNA PARA OBTENER REPORTES ESTADISTICOS
* ABREVIATURA:CGGMA
*/
public class Cgg_ger_matriz implements Serializable{
	private static final long serialVersionUID = 542963019;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggma_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggin_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* MES DEL INDICADOR
	*/
	private String myCggma_mes;
	/**
	* AÑO DEL INIDICADOR
	*/
	private String myCggma_anio;
	/**
	* VALOR DEL INDICADOR
	*/
	private java.math.BigDecimal myCggma_valor;
	/**
	* DESCRIPCION DEL VALOR DE LA MATRIZ
	*/
	private String myCggma_descripcion;
	/**
	* NUMERO DE ACTUALIZACIONES DEL REGISTRO
	*/
	private java.math.BigDecimal myCggma_actualizaciones;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCggma_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCggma_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCggma_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_matriz
	*/
	public Cgg_ger_matriz(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_matriz
	* @param inCggma_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCggma_mes MES DEL INDICADOR
	* @param inCggma_anio AÑO DEL INIDICADOR
	* @param inCggma_valor VALOR DEL INDICADOR
	* @param inCggma_descripcion DESCRIPCION DEL VALOR DE LA MATRIZ
	* @param inCggma_actualizaciones NUMERO DE ACTUALIZACIONES DEL REGISTRO
	* @param inCggma_estado ESTADO DEL REGISTRO
	* @param inCggma_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggma_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_ger_matriz(
		String inCggma_codigo,
		String inCctn_codigo,
		String inCggin_codigo,
		String inCusu_codigo,
		String inCggma_mes,
		String inCggma_anio,
		java.math.BigDecimal inCggma_valor,
		String inCggma_descripcion,
		java.math.BigDecimal inCggma_actualizaciones,
		boolean inCggma_estado,
		String inCggma_usuario_insert,
		String inCggma_usuario_update
	){
		this.setCGGMA_CODIGO(inCggma_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCGGIN_CODIGO(inCggin_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGGMA_MES(inCggma_mes);
		this.setCGGMA_ANIO(inCggma_anio);
		this.setCGGMA_VALOR(inCggma_valor);
		this.setCGGMA_DESCRIPCION(inCggma_descripcion);
		this.setCGGMA_ACTUALIZACIONES(inCggma_actualizaciones);
		this.setCGGMA_ESTADO(inCggma_estado);
		this.setCGGMA_USUARIO_INSERT(inCggma_usuario_insert);
		this.setCGGMA_USUARIO_UPDATE(inCggma_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggma_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGGMA_CODIGO(String inCggma_codigo){
		this.myCggma_codigo = inCggma_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGGMA_CODIGO(){
		return this.myCggma_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGGIN_CODIGO(String inCggin_codigo){
		this.myCggin_codigo = inCggin_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGGIN_CODIGO(){
		return this.myCggin_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE MES DEL INDICADOR
	* @param inCggma_mes MES DEL INDICADOR
	*/
	public void setCGGMA_MES(String inCggma_mes){
		this.myCggma_mes = inCggma_mes;
	}
	/**
	* OBTIENE MES DEL INDICADOR
	* @return String MES DEL INDICADOR
	*/
	public String getCGGMA_MES(){
		return this.myCggma_mes;
	}

	/**
	* ESTABLECE AÑO DEL INIDICADOR
	* @param inCggma_anio AÑO DEL INIDICADOR
	*/
	public void setCGGMA_ANIO(String inCggma_anio){
		this.myCggma_anio = inCggma_anio;
	}
	/**
	* OBTIENE AÑO DEL INIDICADOR
	* @return String AÑO DEL INIDICADOR
	*/
	public String getCGGMA_ANIO(){
		return this.myCggma_anio;
	}

	/**
	* ESTABLECE VALOR DEL INDICADOR
	* @param inCggma_valor VALOR DEL INDICADOR
	*/
	public void setCGGMA_VALOR(java.math.BigDecimal inCggma_valor){
		this.myCggma_valor = inCggma_valor;
	}
	/**
	* OBTIENE VALOR DEL INDICADOR
	* @return java.math.BigDecimal VALOR DEL INDICADOR
	*/
	public java.math.BigDecimal getCGGMA_VALOR(){
		return this.myCggma_valor;
	}

	/**
	* ESTABLECE DESCRIPCION DEL VALOR DE LA MATRIZ
	* @param inCggma_descripcion DESCRIPCION DEL VALOR DE LA MATRIZ
	*/
	public void setCGGMA_DESCRIPCION(String inCggma_descripcion){
		this.myCggma_descripcion = inCggma_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL VALOR DE LA MATRIZ
	* @return String DESCRIPCION DEL VALOR DE LA MATRIZ
	*/
	public String getCGGMA_DESCRIPCION(){
		return this.myCggma_descripcion;
	}

	/**
	* ESTABLECE NUMERO DE ACTUALIZACIONES DEL REGISTRO
	* @param inCggma_actualizaciones NUMERO DE ACTUALIZACIONES DEL REGISTRO
	*/
	public void setCGGMA_ACTUALIZACIONES(java.math.BigDecimal inCggma_actualizaciones){
		this.myCggma_actualizaciones = inCggma_actualizaciones;
	}
	/**
	* OBTIENE NUMERO DE ACTUALIZACIONES DEL REGISTRO
	* @return java.math.BigDecimal NUMERO DE ACTUALIZACIONES DEL REGISTRO
	*/
	public java.math.BigDecimal getCGGMA_ACTUALIZACIONES(){
		return this.myCggma_actualizaciones;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCggma_estado ESTADO DEL REGISTRO
	*/
	public void setCGGMA_ESTADO(boolean inCggma_estado){
		this.myCggma_estado = inCggma_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGGMA_ESTADO(){
		return this.myCggma_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggma_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGGMA_USUARIO_INSERT(String inCggma_usuario_insert){
		this.myCggma_usuario_insert = inCggma_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGGMA_USUARIO_INSERT(){
		return this.myCggma_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCggma_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGGMA_USUARIO_UPDATE(String inCggma_usuario_update){
		this.myCggma_usuario_update = inCggma_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGGMA_USUARIO_UPDATE(){
		return this.myCggma_usuario_update;
	}

}
