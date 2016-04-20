package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_movilidad
* TABLA: MOVILIDAD
* DESCRIPCION:ALMACENA INFORMACION DE LOS VIAJES REALIZADOS POR LAS PERSONAS
* ABREVIATURA:CRMOV
*/
public class Cgg_res_movilidad implements Serializable{
	private static final long serialVersionUID = 630398474;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrmov_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCraln_codigo;
	/**
	* IDENTIFICATIVO AEROPUERTO DE PARTIDA
	*/
	private String myCarpt_codigo;
	/**
	* IDENTIFICATIVO AEROPUERTO DE ARRIVO
	*/
	private String myCgg_carpt_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	private String myCtreg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	private String myCrrsd_codigo;
	/**
	* FECHA DE VIAJE
	*/
	private java.util.Date myCrmov_fecha_viaje;
	/**
	* TIPO DE OPERACION
0 - ENTRADA
1 - SALIDA    
	*/
	private int myCrmov_tipo_operacion;
	/**
	* NUMERO DE VUELO
	*/
	private String myCrmov_numero_vuelo;
	/**
	* DESCRIPCION CORTA DE LA OPERACION
	*/
	private String myCrmov_observacion;
	/**
	* TIPO DE SALIDA DE LA PROVINCIA
0.-  NORMAL
1.- ESPECIAL
	*/
	private int myCrmov_tipo_salida;
	/**
	* IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	*/
	private boolean myCrmov_filtro_interno;
	/**
	* INDICADOR DEL REGISTRO FUE CREADO COMO INDICADOR DE CADUCIDAD DE UNA RESIDENCIA
	*/
	private boolean myCrmov_soporte;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrmov_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrmov_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrmov_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad
	*/
	public Cgg_res_movilidad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCarpt_codigo IDENTIFICATIVO AEROPUERTO DE PARTIDA
	* @param inCgg_carpt_codigo IDENTIFICATIVO AEROPUERTO DE ARRIVO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrmov_fecha_viaje FECHA DE VIAJE
	* @param inCrmov_tipo_operacion TIPO DE OPERACION
0 - ENTRADA
1 - SALIDA    
	* @param inCrmov_numero_vuelo NUMERO DE VUELO
	* @param inCrmov_observacion DESCRIPCION CORTA DE LA OPERACION
	* @param inCrmov_tipo_salida TIPO DE SALIDA DE LA PROVINCIA
0.-  NORMAL
1.- ESPECIAL
	* @param inCrmov_filtro_interno IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	* @param inCrmov_soporte INDICADOR DEL REGISTRO FUE CREADO COMO INDICADOR DE CADUCIDAD DE UNA RESIDENCIA
	* @param inCrmov_estado ESTADO DEL REGISTRO
	* @param inCrmov_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmov_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_movilidad(
		String inCrmov_codigo,
		String inCraln_codigo,
		String inCarpt_codigo,
		String inCgg_carpt_codigo,
		String inCrper_codigo,
		String inCtreg_codigo,
		String inCrrsd_codigo,
		java.util.Date inCrmov_fecha_viaje,
		int inCrmov_tipo_operacion,
		String inCrmov_numero_vuelo,
		String inCrmov_observacion,
		int inCrmov_tipo_salida,
		boolean inCrmov_filtro_interno,
		boolean inCrmov_soporte,
		boolean inCrmov_estado,
		String inCrmov_usuario_insert,
		String inCrmov_usuario_update
	){
		this.setCRMOV_CODIGO(inCrmov_codigo);
		this.setCRALN_CODIGO(inCraln_codigo);
		this.setCARPT_CODIGO(inCarpt_codigo);
		this.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCTREG_CODIGO(inCtreg_codigo);
		this.setCRRSD_CODIGO(inCrrsd_codigo);
		this.setCRMOV_FECHA_VIAJE(inCrmov_fecha_viaje);
		this.setCRMOV_TIPO_OPERACION(inCrmov_tipo_operacion);
		this.setCRMOV_NUMERO_VUELO(inCrmov_numero_vuelo);
		this.setCRMOV_OBSERVACION(inCrmov_observacion);
		this.setCRMOV_TIPO_SALIDA(inCrmov_tipo_salida);
		this.setCRMOV_FILTRO_INTERNO(inCrmov_filtro_interno);
		this.setCRMOV_SOPORTE(inCrmov_soporte);
		this.setCRMOV_ESTADO(inCrmov_estado);
		this.setCRMOV_USUARIO_INSERT(inCrmov_usuario_insert);
		this.setCRMOV_USUARIO_UPDATE(inCrmov_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRMOV_CODIGO(String inCrmov_codigo){
		this.myCrmov_codigo = inCrmov_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRMOV_CODIGO(){
		return this.myCrmov_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRALN_CODIGO(String inCraln_codigo){
		this.myCraln_codigo = inCraln_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRALN_CODIGO(){
		return this.myCraln_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO AEROPUERTO DE PARTIDA
	* @param inCarpt_codigo IDENTIFICATIVO AEROPUERTO DE PARTIDA
	*/
	public void setCARPT_CODIGO(String inCarpt_codigo){
		this.myCarpt_codigo = inCarpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO AEROPUERTO DE PARTIDA
	* @return String IDENTIFICATIVO AEROPUERTO DE PARTIDA
	*/
	public String getCARPT_CODIGO(){
		return this.myCarpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO AEROPUERTO DE ARRIVO
	* @param inCgg_carpt_codigo IDENTIFICATIVO AEROPUERTO DE ARRIVO
	*/
	public void setCGG_CARPT_CODIGO(String inCgg_carpt_codigo){
		this.myCgg_carpt_codigo = inCgg_carpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO AEROPUERTO DE ARRIVO
	* @return String IDENTIFICATIVO AEROPUERTO DE ARRIVO
	*/
	public String getCGG_CARPT_CODIGO(){
		return this.myCgg_carpt_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public void setCTREG_CODIGO(String inCtreg_codigo){
		this.myCtreg_codigo = inCtreg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public String getCTREG_CODIGO(){
		return this.myCtreg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	public void setCRRSD_CODIGO(String inCrrsd_codigo){
		this.myCrrsd_codigo = inCrrsd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	public String getCRRSD_CODIGO(){
		return this.myCrrsd_codigo;
	}

	/**
	* ESTABLECE FECHA DE VIAJE
	* @param inCrmov_fecha_viaje FECHA DE VIAJE
	*/
	public void setCRMOV_FECHA_VIAJE(java.util.Date inCrmov_fecha_viaje){
		this.myCrmov_fecha_viaje = inCrmov_fecha_viaje;
	}
	/**
	* OBTIENE FECHA DE VIAJE
	* @return java.util.Date FECHA DE VIAJE
	*/
	public java.util.Date getCRMOV_FECHA_VIAJE(){
		return this.myCrmov_fecha_viaje;
	}

	/**
	* ESTABLECE TIPO DE OPERACION
0 - ENTRADA
1 - SALIDA    
	* @param inCrmov_tipo_operacion TIPO DE OPERACION
0 - ENTRADA
1 - SALIDA    
	*/
	public void setCRMOV_TIPO_OPERACION(int inCrmov_tipo_operacion){
		this.myCrmov_tipo_operacion = inCrmov_tipo_operacion;
	}
	/**
	* OBTIENE TIPO DE OPERACION
0 - ENTRADA
1 - SALIDA    
	* @return int TIPO DE OPERACION
0 - ENTRADA
1 - SALIDA    
	*/
	public int getCRMOV_TIPO_OPERACION(){
		return this.myCrmov_tipo_operacion;
	}

	/**
	* ESTABLECE NUMERO DE VUELO
	* @param inCrmov_numero_vuelo NUMERO DE VUELO
	*/
	public void setCRMOV_NUMERO_VUELO(String inCrmov_numero_vuelo){
		this.myCrmov_numero_vuelo = inCrmov_numero_vuelo;
	}
	/**
	* OBTIENE NUMERO DE VUELO
	* @return String NUMERO DE VUELO
	*/
	public String getCRMOV_NUMERO_VUELO(){
		return this.myCrmov_numero_vuelo;
	}

	/**
	* ESTABLECE DESCRIPCION CORTA DE LA OPERACION
	* @param inCrmov_observacion DESCRIPCION CORTA DE LA OPERACION
	*/
	public void setCRMOV_OBSERVACION(String inCrmov_observacion){
		this.myCrmov_observacion = inCrmov_observacion;
	}
	/**
	* OBTIENE DESCRIPCION CORTA DE LA OPERACION
	* @return String DESCRIPCION CORTA DE LA OPERACION
	*/
	public String getCRMOV_OBSERVACION(){
		return this.myCrmov_observacion;
	}

	/**
	* ESTABLECE TIPO DE SALIDA DE LA PROVINCIA
0.-  NORMAL
1.- ESPECIAL
	* @param inCrmov_tipo_salida TIPO DE SALIDA DE LA PROVINCIA
0.-  NORMAL
1.- ESPECIAL
	*/
	public void setCRMOV_TIPO_SALIDA(int inCrmov_tipo_salida){
		this.myCrmov_tipo_salida = inCrmov_tipo_salida;
	}
	/**
	* OBTIENE TIPO DE SALIDA DE LA PROVINCIA
0.-  NORMAL
1.- ESPECIAL
	* @return int TIPO DE SALIDA DE LA PROVINCIA
0.-  NORMAL
1.- ESPECIAL
	*/
	public int getCRMOV_TIPO_SALIDA(){
		return this.myCrmov_tipo_salida;
	}

	/**
	* ESTABLECE IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	* @param inCrmov_filtro_interno IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	*/
	public void setCRMOV_FILTRO_INTERNO(boolean inCrmov_filtro_interno){
		this.myCrmov_filtro_interno = inCrmov_filtro_interno;
	}
	/**
	* OBTIENE IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	* @return boolean IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	*/
	public boolean getCRMOV_FILTRO_INTERNO(){
		return this.myCrmov_filtro_interno;
	}

	/**
	* ESTABLECE INDICADOR DEL REGISTRO FUE CREADO COMO INDICADOR DE CADUCIDAD DE UNA RESIDENCIA
	* @param inCrmov_soporte INDICADOR DEL REGISTRO FUE CREADO COMO INDICADOR DE CADUCIDAD DE UNA RESIDENCIA
	*/
	public void setCRMOV_SOPORTE(boolean inCrmov_soporte){
		this.myCrmov_soporte = inCrmov_soporte;
	}
	/**
	* OBTIENE INDICADOR DEL REGISTRO FUE CREADO COMO INDICADOR DE CADUCIDAD DE UNA RESIDENCIA
	* @return boolean INDICADOR DEL REGISTRO FUE CREADO COMO INDICADOR DE CADUCIDAD DE UNA RESIDENCIA
	*/
	public boolean getCRMOV_SOPORTE(){
		return this.myCrmov_soporte;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrmov_estado ESTADO DEL REGISTRO
	*/
	public void setCRMOV_ESTADO(boolean inCrmov_estado){
		this.myCrmov_estado = inCrmov_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRMOV_ESTADO(){
		return this.myCrmov_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmov_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRMOV_USUARIO_INSERT(String inCrmov_usuario_insert){
		this.myCrmov_usuario_insert = inCrmov_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRMOV_USUARIO_INSERT(){
		return this.myCrmov_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrmov_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRMOV_USUARIO_UPDATE(String inCrmov_usuario_update){
		this.myCrmov_usuario_update = inCrmov_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRMOV_USUARIO_UPDATE(){
		return this.myCrmov_usuario_update;
	}

}
