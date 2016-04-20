package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_operacion_regla_validacion
* TABLA: OPERACION REGLA DE VALIDACION
* DESCRIPCION:ALMACENA INFORMACION DE LAS REGLAS A EJECUTAR POR UNA OPERACION
* ABREVIATURA:CORV
*/
public class Cgg_operacion_regla_validacion implements Serializable{
	private static final long serialVersionUID = 511143968;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
	*/
	private String myCorv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	private String myCrval_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
	*/
	private String myCopvl_codigo;
	/**
	* CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	*/
	private String myCorv_campo_evaluacion;
	/**
	* CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	*/
	private java.math.BigDecimal myCorv_valor_1;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCorv_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCorv_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCorv_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_operacion_regla_validacion
	*/
	public Cgg_operacion_regla_validacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_operacion_regla_validacion
	* @param inCorv_codigo IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
	* @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @param inCopvl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
	* @param inCorv_campo_evaluacion CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	* @param inCorv_valor_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	* @param inCorv_estado ESTADO DEL REGISTRO
	* @param inCorv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCorv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_operacion_regla_validacion(
		String inCorv_codigo,
		String inCrval_codigo,
		String inCopvl_codigo,
		String inCorv_campo_evaluacion,
		java.math.BigDecimal inCorv_valor_1,
		boolean inCorv_estado,
		String inCorv_usuario_insert,
		String inCorv_usuario_update
	){
		this.setCORV_CODIGO(inCorv_codigo);
		this.setCRVAL_CODIGO(inCrval_codigo);
		this.setCOPVL_CODIGO(inCopvl_codigo);
		this.setCORV_CAMPO_EVALUACION(inCorv_campo_evaluacion);
		this.setCORV_VALOR_1(inCorv_valor_1);
		this.setCORV_ESTADO(inCorv_estado);
		this.setCORV_USUARIO_INSERT(inCorv_usuario_insert);
		this.setCORV_USUARIO_UPDATE(inCorv_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
	* @param inCorv_codigo IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
	*/
	public void setCORV_CODIGO(String inCorv_codigo){
		this.myCorv_codigo = inCorv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
	*/
	public String getCORV_CODIGO(){
		return this.myCorv_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
	* @param inCopvl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
	*/
	public void setCOPVL_CODIGO(String inCopvl_codigo){
		this.myCopvl_codigo = inCopvl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
	*/
	public String getCOPVL_CODIGO(){
		return this.myCopvl_codigo;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	* @param inCorv_campo_evaluacion CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	*/
	public void setCORV_CAMPO_EVALUACION(String inCorv_campo_evaluacion){
		this.myCorv_campo_evaluacion = inCorv_campo_evaluacion;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	* @return String CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
	*/
	public String getCORV_CAMPO_EVALUACION(){
		return this.myCorv_campo_evaluacion;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	* @param inCorv_valor_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	*/
	public void setCORV_VALOR_1(java.math.BigDecimal inCorv_valor_1){
		this.myCorv_valor_1 = inCorv_valor_1;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	* @return java.math.BigDecimal CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
	*/
	public java.math.BigDecimal getCORV_VALOR_1(){
		return this.myCorv_valor_1;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCorv_estado ESTADO DEL REGISTRO
	*/
	public void setCORV_ESTADO(boolean inCorv_estado){
		this.myCorv_estado = inCorv_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCORV_ESTADO(){
		return this.myCorv_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCorv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCORV_USUARIO_INSERT(String inCorv_usuario_insert){
		this.myCorv_usuario_insert = inCorv_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCORV_USUARIO_INSERT(){
		return this.myCorv_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCorv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCORV_USUARIO_UPDATE(String inCorv_usuario_update){
		this.myCorv_usuario_update = inCorv_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCORV_USUARIO_UPDATE(){
		return this.myCorv_usuario_update;
	}

}
