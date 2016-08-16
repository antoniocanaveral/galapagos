package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tipo_solicitud_regla
* TABLA: REGLAS DE TIPO DE SOLICITUD DE TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LAS REGLAS A APLICARSE PARA LOS DIFERENTES TIPOS DE SOLICITUD DE TRAMITE.
* ABREVIATURA:CRTSE
*/
public class Cgg_res_tipo_solicitud_regla implements Serializable{
	private static final long serialVersionUID = 1743760319;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
	*/
	private String myCrtse_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	private String myCrval_codigo;
	/**
	* CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	*/
	private String myCrtse_campo_evaluacion;
	/**
	* CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	*/
	private String myCrtse_valor_1;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtse_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtse_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtse_usuario_update;
	/*AC=> Tipo Tramite*/
	private String CRTT_CODIGO;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_regla
	*/
	public Cgg_res_tipo_solicitud_regla(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_regla
	* @param inCrtse_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @param inCrtse_campo_evaluacion CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	* @param inCrtse_valor_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	* @param inCrtse_estado ESTADO DEL REGISTRO
	* @param inCrtse_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtse_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tipo_solicitud_regla(
		String inCrtse_codigo,
		String inCrtst_codigo,
		String inCrval_codigo,
		String inCrtse_campo_evaluacion,
		String inCrtse_valor_1,
		boolean inCrtse_estado,
		String inCrtse_usuario_insert,
		String inCrtse_usuario_update
	){
		this.setCRTSE_CODIGO(inCrtse_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRVAL_CODIGO(inCrval_codigo);
		this.setCRTSE_CAMPO_EVALUACION(inCrtse_campo_evaluacion);
		this.setCRTSE_VALOR_1(inCrtse_valor_1);
		this.setCRTSE_ESTADO(inCrtse_estado);
		this.setCRTSE_USUARIO_INSERT(inCrtse_usuario_insert);
		this.setCRTSE_USUARIO_UPDATE(inCrtse_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
	* @param inCrtse_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
	*/
	public void setCRTSE_CODIGO(String inCrtse_codigo){
		this.myCrtse_codigo = inCrtse_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
	*/
	public String getCRTSE_CODIGO(){
		return this.myCrtse_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	public void setCRTST_CODIGO(String inCrtst_codigo){
		this.myCrtst_codigo = inCrtst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	public String getCRTST_CODIGO(){
		return this.myCrtst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	public void setCRVAL_CODIGO(String inCrval_codigo){
		this.myCrval_codigo = inCrval_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	public String getCRVAL_CODIGO(){
		return this.myCrval_codigo;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	* @param inCrtse_campo_evaluacion CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	*/
	public void setCRTSE_CAMPO_EVALUACION(String inCrtse_campo_evaluacion){
		this.myCrtse_campo_evaluacion = inCrtse_campo_evaluacion;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	* @return String CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	*/
	public String getCRTSE_CAMPO_EVALUACION(){
		return this.myCrtse_campo_evaluacion;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	* @param inCrtse_valor_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	*/
	public void setCRTSE_VALOR_1(String inCrtse_valor_1){
		this.myCrtse_valor_1 = inCrtse_valor_1;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	* @return String CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	*/
	public String getCRTSE_VALOR_1(){
		return this.myCrtse_valor_1;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtse_estado ESTADO DEL REGISTRO
	*/
	public void setCRTSE_ESTADO(boolean inCrtse_estado){
		this.myCrtse_estado = inCrtse_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTSE_ESTADO(){
		return this.myCrtse_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtse_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTSE_USUARIO_INSERT(String inCrtse_usuario_insert){
		this.myCrtse_usuario_insert = inCrtse_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTSE_USUARIO_INSERT(){
		return this.myCrtse_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtse_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTSE_USUARIO_UPDATE(String inCrtse_usuario_update){
		this.myCrtse_usuario_update = inCrtse_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTSE_USUARIO_UPDATE(){
		return this.myCrtse_usuario_update;
	}

	public String getCRTT_CODIGO() {
		return CRTT_CODIGO;
	}

	public void setCRTT_CODIGO(String CRTT_CODIGO) {
		this.CRTT_CODIGO = CRTT_CODIGO;
	}
}
