package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_grupo_turista
* TABLA: GRUPO TURISTA
* DESCRIPCION:ALMACENA INFORMACION DE LOS TURISTAS REGISTRADOS POR UNA AGENCIA DE VIAJES
* ABREVIATURA:CTGTR
*/
public class Cgg_tct_grupo_turista implements Serializable{
	private static final long serialVersionUID = 1827629447;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtgtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	*/
	private String myCtadc_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	*/
	private int myCtgtr_numero;
	/**
	* FECHA DE RESERVA 
	*/
	private java.util.Date myCtgtr_fecha_reserva;
	/**
	* FECHA DE INGRESO  A LA PROVINCIA
	*/
	private java.util.Date myCtgtr_fecha_ingreso;
	/**
	* FECHA DE SALIDA DE LA PROVINCIA
	*/
	private java.util.Date myCtgtr_fecha_salida;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtgtr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtgtr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtgtr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_turista
	*/
	public Cgg_tct_grupo_turista(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_grupo_turista
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCtadc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	* @param inCtgtr_numero NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	* @param inCtgtr_fecha_reserva FECHA DE RESERVA 
	* @param inCtgtr_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA
	* @param inCtgtr_fecha_salida FECHA DE SALIDA DE LA PROVINCIA
	* @param inCtgtr_estado ESTADO DEL REGISTRO
	* @param inCtgtr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtgtr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_grupo_turista(
		String inCtgtr_codigo,
		String inCusu_codigo,
		String inCtadc_codigo,
		int inCtgtr_numero,
		java.util.Date inCtgtr_fecha_reserva,
		java.util.Date inCtgtr_fecha_ingreso,
		java.util.Date inCtgtr_fecha_salida,
		boolean inCtgtr_estado,
		String inCtgtr_usuario_insert,
		String inCtgtr_usuario_update
	){
		this.setCTGTR_CODIGO(inCtgtr_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCTADC_CODIGO(inCtadc_codigo);
		this.setCTGTR_NUMERO(inCtgtr_numero);
		this.setCTGTR_FECHA_RESERVA(inCtgtr_fecha_reserva);
		this.setCTGTR_FECHA_INGRESO(inCtgtr_fecha_ingreso);
		this.setCTGTR_FECHA_SALIDA(inCtgtr_fecha_salida);
		this.setCTGTR_ESTADO(inCtgtr_estado);
		this.setCTGTR_USUARIO_INSERT(inCtgtr_usuario_insert);
		this.setCTGTR_USUARIO_UPDATE(inCtgtr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTGTR_CODIGO(String inCtgtr_codigo){
		this.myCtgtr_codigo = inCtgtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTGTR_CODIGO(){
		return this.myCtgtr_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	* @param inCtadc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	*/
	public void setCTADC_CODIGO(String inCtadc_codigo){
		this.myCtadc_codigo = inCtadc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO CSV
	*/
	public String getCTADC_CODIGO(){
		return this.myCtadc_codigo;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	* @param inCtgtr_numero NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	*/
	public void setCTGTR_NUMERO(int inCtgtr_numero){
		this.myCtgtr_numero = inCtgtr_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	* @return int NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
	*/
	public int getCTGTR_NUMERO(){
		return this.myCtgtr_numero;
	}

	/**
	* ESTABLECE FECHA DE RESERVA 
	* @param inCtgtr_fecha_reserva FECHA DE RESERVA 
	*/
	public void setCTGTR_FECHA_RESERVA(java.util.Date inCtgtr_fecha_reserva){
		this.myCtgtr_fecha_reserva = inCtgtr_fecha_reserva;
	}
	/**
	* OBTIENE FECHA DE RESERVA 
	* @return java.util.Date FECHA DE RESERVA 
	*/
	public java.util.Date getCTGTR_FECHA_RESERVA(){
		return this.myCtgtr_fecha_reserva;
	}

	/**
	* ESTABLECE FECHA DE INGRESO  A LA PROVINCIA
	* @param inCtgtr_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA
	*/
	public void setCTGTR_FECHA_INGRESO(java.util.Date inCtgtr_fecha_ingreso){
		this.myCtgtr_fecha_ingreso = inCtgtr_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO  A LA PROVINCIA
	* @return java.util.Date FECHA DE INGRESO  A LA PROVINCIA
	*/
	public java.util.Date getCTGTR_FECHA_INGRESO(){
		return this.myCtgtr_fecha_ingreso;
	}

	/**
	* ESTABLECE FECHA DE SALIDA DE LA PROVINCIA
	* @param inCtgtr_fecha_salida FECHA DE SALIDA DE LA PROVINCIA
	*/
	public void setCTGTR_FECHA_SALIDA(java.util.Date inCtgtr_fecha_salida){
		this.myCtgtr_fecha_salida = inCtgtr_fecha_salida;
	}
	/**
	* OBTIENE FECHA DE SALIDA DE LA PROVINCIA
	* @return java.util.Date FECHA DE SALIDA DE LA PROVINCIA
	*/
	public java.util.Date getCTGTR_FECHA_SALIDA(){
		return this.myCtgtr_fecha_salida;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtgtr_estado ESTADO DEL REGISTRO
	*/
	public void setCTGTR_ESTADO(boolean inCtgtr_estado){
		this.myCtgtr_estado = inCtgtr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTGTR_ESTADO(){
		return this.myCtgtr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtgtr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTGTR_USUARIO_INSERT(String inCtgtr_usuario_insert){
		this.myCtgtr_usuario_insert = inCtgtr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTGTR_USUARIO_INSERT(){
		return this.myCtgtr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtgtr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTGTR_USUARIO_UPDATE(String inCtgtr_usuario_update){
		this.myCtgtr_usuario_update = inCtgtr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTGTR_USUARIO_UPDATE(){
		return this.myCtgtr_usuario_update;
	}

}
