package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_denominacion
* TABLA: DENOMINACION
* DESCRIPCION:ALMACENA INFORMACION DE LAS DENOMINACIONES MONETARIAS.
* ABREVIATURA:CKDNM
*/
public class Cgg_kdx_denominacion implements Serializable{
	private static final long serialVersionUID = 578379345;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	*/
	private String myCkdnm_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	*/
	private String myCktpg_codigo;
	/**
	* NOMBRE DE LA DENOMINACION MONETARIA
	*/
	private String myCkdnm_denominacion;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCkdnm_observacion;
	/**
	* VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
	*/
	private java.math.BigDecimal myCkdnm_valor_monetario;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkdnm_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkdnm_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkdnm_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_denominacion
	*/
	public Cgg_kdx_denominacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_denominacion
	* @param inCkdnm_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	* @param inCktpg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	* @param inCkdnm_denominacion NOMBRE DE LA DENOMINACION MONETARIA
	* @param inCkdnm_observacion INFORMACION ADICIONAL
	* @param inCkdnm_valor_monetario VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
	* @param inCkdnm_estado ESTADO DEL REGISTRO
	* @param inCkdnm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkdnm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_denominacion(
		String inCkdnm_codigo,
		String inCktpg_codigo,
		String inCkdnm_denominacion,
		String inCkdnm_observacion,
		java.math.BigDecimal inCkdnm_valor_monetario,
		boolean inCkdnm_estado,
		String inCkdnm_usuario_insert,
		String inCkdnm_usuario_update
	){
		this.setCKDNM_CODIGO(inCkdnm_codigo);
		this.setCKTPG_CODIGO(inCktpg_codigo);
		this.setCKDNM_DENOMINACION(inCkdnm_denominacion);
		this.setCKDNM_OBSERVACION(inCkdnm_observacion);
		this.setCKDNM_VALOR_MONETARIO(inCkdnm_valor_monetario);
		this.setCKDNM_ESTADO(inCkdnm_estado);
		this.setCKDNM_USUARIO_INSERT(inCkdnm_usuario_insert);
		this.setCKDNM_USUARIO_UPDATE(inCkdnm_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	* @param inCkdnm_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	*/
	public void setCKDNM_CODIGO(String inCkdnm_codigo){
		this.myCkdnm_codigo = inCkdnm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
	*/
	public String getCKDNM_CODIGO(){
		return this.myCkdnm_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	* @param inCktpg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	*/
	public void setCKTPG_CODIGO(String inCktpg_codigo){
		this.myCktpg_codigo = inCktpg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	*/
	public String getCKTPG_CODIGO(){
		return this.myCktpg_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA DENOMINACION MONETARIA
	* @param inCkdnm_denominacion NOMBRE DE LA DENOMINACION MONETARIA
	*/
	public void setCKDNM_DENOMINACION(String inCkdnm_denominacion){
		this.myCkdnm_denominacion = inCkdnm_denominacion;
	}
	/**
	* OBTIENE NOMBRE DE LA DENOMINACION MONETARIA
	* @return String NOMBRE DE LA DENOMINACION MONETARIA
	*/
	public String getCKDNM_DENOMINACION(){
		return this.myCkdnm_denominacion;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCkdnm_observacion INFORMACION ADICIONAL
	*/
	public void setCKDNM_OBSERVACION(String inCkdnm_observacion){
		this.myCkdnm_observacion = inCkdnm_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCKDNM_OBSERVACION(){
		return this.myCkdnm_observacion;
	}

	/**
	* ESTABLECE VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
	* @param inCkdnm_valor_monetario VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
	*/
	public void setCKDNM_VALOR_MONETARIO(java.math.BigDecimal inCkdnm_valor_monetario){
		this.myCkdnm_valor_monetario = inCkdnm_valor_monetario;
	}
	/**
	* OBTIENE VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
	* @return java.math.BigDecimal VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
	*/
	public java.math.BigDecimal getCKDNM_VALOR_MONETARIO(){
		return this.myCkdnm_valor_monetario;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkdnm_estado ESTADO DEL REGISTRO
	*/
	public void setCKDNM_ESTADO(boolean inCkdnm_estado){
		this.myCkdnm_estado = inCkdnm_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKDNM_ESTADO(){
		return this.myCkdnm_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkdnm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKDNM_USUARIO_INSERT(String inCkdnm_usuario_insert){
		this.myCkdnm_usuario_insert = inCkdnm_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKDNM_USUARIO_INSERT(){
		return this.myCkdnm_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkdnm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKDNM_USUARIO_UPDATE(String inCkdnm_usuario_update){
		this.myCkdnm_usuario_update = inCkdnm_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKDNM_USUARIO_UPDATE(){
		return this.myCkdnm_usuario_update;
	}

}
