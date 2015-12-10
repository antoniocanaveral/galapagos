package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_movilidad_int_actividad
* TABLA:MOVILIDAD INTERNA ACTIVIDAD
* DESCRIPCION:ALMACENA INFORMACION DE DE LAS ACTIVIDADES QUE VA A CUMPLIR UNA PERSONA MIENTRAS SE DESPLAZA POR LA PROVINCIA
* ABREVIATURA:CTMAC
*/
public class Cgg_tct_movilidad_int_actividad implements Serializable{
	private static final long serialVersionUID = 156158704;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtmac_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	private String myCtact_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	private String myCrmvi_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtmac_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtmac_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtmac_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_int_actividad
	*/
	public Cgg_tct_movilidad_int_actividad(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_movilidad_int_actividad
	* @param inCtmac_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @param inCtmac_estado ESTADO DEL REGISTRO
	* @param inCtmac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_movilidad_int_actividad(
		String inCtmac_codigo,
		String inCtact_codigo,
		String inCrmvi_codigo,
		boolean inCtmac_estado,
		String inCtmac_usuario_insert,
		String inCtmac_usuario_update
	){
		this.setCTMAC_CODIGO(inCtmac_codigo);
		this.setCTACT_CODIGO(inCtact_codigo);
		this.setCRMVI_CODIGO(inCrmvi_codigo);
		this.setCTMAC_ESTADO(inCtmac_estado);
		this.setCTMAC_USUARIO_INSERT(inCtmac_usuario_insert);
		this.setCTMAC_USUARIO_UPDATE(inCtmac_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtmac_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTMAC_CODIGO(String inCtmac_codigo){
		this.myCtmac_codigo = inCtmac_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTMAC_CODIGO(){
		return this.myCtmac_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @param inCtact_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	public void setCTACT_CODIGO(String inCtact_codigo){
		this.myCtact_codigo = inCtact_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
	*/
	public String getCTACT_CODIGO(){
		return this.myCtact_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	public void setCRMVI_CODIGO(String inCrmvi_codigo){
		this.myCrmvi_codigo = inCrmvi_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	public String getCRMVI_CODIGO(){
		return this.myCrmvi_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtmac_estado ESTADO DEL REGISTRO
	*/
	public void setCTMAC_ESTADO(boolean inCtmac_estado){
		this.myCtmac_estado = inCtmac_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTMAC_ESTADO(){
		return this.myCtmac_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtmac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTMAC_USUARIO_INSERT(String inCtmac_usuario_insert){
		this.myCtmac_usuario_insert = inCtmac_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTMAC_USUARIO_INSERT(){
		return this.myCtmac_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtmac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTMAC_USUARIO_UPDATE(String inCtmac_usuario_update){
		this.myCtmac_usuario_update = inCtmac_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTMAC_USUARIO_UPDATE(){
		return this.myCtmac_usuario_update;
	}

}
