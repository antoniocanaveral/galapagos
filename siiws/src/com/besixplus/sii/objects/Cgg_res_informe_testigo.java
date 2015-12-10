package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_informe_testigo
* TABLA: INFORME DE TESTIGO
* DESCRIPCION:ALMACENA INFORMACION DE LOS INFORMES REALIZADOS POR LOS TESTIGOS DE UN MATRIMONIO
* ABREVIATURA:CRINT
*/
public class Cgg_res_informe_testigo implements Serializable{
	private static final long serialVersionUID = 1639819063;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	*/
	private String myCrint_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrmtr_codigo;
	/**
	* NUMERO DE INFORME TESTIGOS
	*/
	private String myCrint_numero;
	/**
	* INFORMACION ADICIONAL - HISTORIAL JSON
	*/
	private String myCrint_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrint_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrint_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrint_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_testigo
	*/
	public Cgg_res_informe_testigo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_testigo
	* @param inCrint_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrint_numero NUMERO DE INFORME TESTIGOS
	* @param inCrint_observacion INFORMACION ADICIONAL - HISTORIAL JSON
	* @param inCrint_estado ESTADO DEL REGISTRO
	* @param inCrint_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrint_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_informe_testigo(
		String inCrint_codigo,
		String inCrmtr_codigo,
		String inCrint_numero,
		String inCrint_observacion,
		boolean inCrint_estado,
		String inCrint_usuario_insert,
		String inCrint_usuario_update
	){
		this.setCRINT_CODIGO(inCrint_codigo);
		this.setCRMTR_CODIGO(inCrmtr_codigo);
		this.setCRINT_NUMERO(inCrint_numero);
		this.setCRINT_OBSERVACION(inCrint_observacion);
		this.setCRINT_ESTADO(inCrint_estado);
		this.setCRINT_USUARIO_INSERT(inCrint_usuario_insert);
		this.setCRINT_USUARIO_UPDATE(inCrint_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	* @param inCrint_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	*/
	public void setCRINT_CODIGO(String inCrint_codigo){
		this.myCrint_codigo = inCrint_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	*/
	public String getCRINT_CODIGO(){
		return this.myCrint_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRMTR_CODIGO(String inCrmtr_codigo){
		this.myCrmtr_codigo = inCrmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRMTR_CODIGO(){
		return this.myCrmtr_codigo;
	}

	/**
	* ESTABLECE NUMERO DE INFORME TESTIGOS
	* @param inCrint_numero NUMERO DE INFORME TESTIGOS
	*/
	public void setCRINT_NUMERO(String inCrint_numero){
		this.myCrint_numero = inCrint_numero;
	}
	/**
	* OBTIENE NUMERO DE INFORME TESTIGOS
	* @return java.math.BigDecimal NUMERO DE INFORME TESTIGOS
	*/
	public String getCRINT_NUMERO(){
		return this.myCrint_numero;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL - HISTORIAL JSON
	* @param inCrint_observacion INFORMACION ADICIONAL - HISTORIAL JSON
	*/
	public void setCRINT_OBSERVACION(String inCrint_observacion){
		this.myCrint_observacion = inCrint_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL - HISTORIAL JSON
	* @return String INFORMACION ADICIONAL - HISTORIAL JSON
	*/
	public String getCRINT_OBSERVACION(){
		return this.myCrint_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrint_estado ESTADO DEL REGISTRO
	*/
	public void setCRINT_ESTADO(boolean inCrint_estado){
		this.myCrint_estado = inCrint_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRINT_ESTADO(){
		return this.myCrint_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrint_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRINT_USUARIO_INSERT(String inCrint_usuario_insert){
		this.myCrint_usuario_insert = inCrint_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRINT_USUARIO_INSERT(){
		return this.myCrint_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrint_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRINT_USUARIO_UPDATE(String inCrint_usuario_update){
		this.myCrint_usuario_update = inCrint_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRINT_USUARIO_UPDATE(){
		return this.myCrint_usuario_update;
	}

}
