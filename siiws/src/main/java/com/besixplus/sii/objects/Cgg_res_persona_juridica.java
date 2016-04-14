package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_persona_juridica
* TABLA: EMPRESA
* DESCRIPCION:ALMACENA INFORMACION DE LAS EMPRESAS QUE PUEDE INTERACTUAR DE DIFERENTES MANERAS DENTRO DE LA ADMINISTRACION DE LA INSTITUCION
* ABREVIATURA:CRPJR
*/
public class Cgg_res_persona_juridica implements Serializable{
	private static final long serialVersionUID = 1645045292;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	*/
	private String myCvsct_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	*/
	private String myCrpjr_razon_social;
	/**
	* NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA EN MUCHOS DE LOS CASOS RUC
	*/
	private String myCrpjr_numero_identificacion;
	/**
	* FECHA DE CONSTITUCION DE LA EMPRESA
	*/
	private java.util.Date myCrpjr_fecha_constitucion;
	/**
	* DIRECCION DE LA PERSONA JURIDICA
	*/
	private String myCrpjr_direccion;
	/**
	* DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DEDICA LA PERSONA JURIDICA
	*/
	private String myCrpjr_actividad;
	/**
	* NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	*/
	private java.math.BigDecimal myCrpjr_numero_empleados;
	/**
	* INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	*/
	private int myCrpjr_tipo;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCrpjr_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrpjr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrpjr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrpjr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona_juridica
	*/
	public Cgg_res_persona_juridica(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona_juridica
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	* @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA EN MUCHOS DE LOS CASOS RUC
	* @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA
	* @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA
	* @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DEDICA LA PERSONA JURIDICA
	* @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	* @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	* @param inCrpjr_observacion INFORMACION ADICIONAL
	* @param inCrpjr_estado ESTADO DEL REGISTRO
	* @param inCrpjr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpjr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_persona_juridica(
		String inCrpjr_codigo,
		String inCsctp_codigo,
		String inCvsct_codigo,
		String inCctn_codigo,
		String inCrpjr_razon_social,
		String inCrpjr_numero_identificacion,
		java.util.Date inCrpjr_fecha_constitucion,
		String inCrpjr_direccion,
		String inCrpjr_actividad,
		java.math.BigDecimal inCrpjr_numero_empleados,
		int inCrpjr_tipo,
		String inCrpjr_observacion,
		boolean inCrpjr_estado,
		String inCrpjr_usuario_insert,
		String inCrpjr_usuario_update
	){
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCVSCT_CODIGO(inCvsct_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCRPJR_RAZON_SOCIAL(inCrpjr_razon_social);
		this.setCRPJR_NUMERO_IDENTIFICACION(inCrpjr_numero_identificacion);
		this.setCRPJR_FECHA_CONSTITUCION(inCrpjr_fecha_constitucion);
		this.setCRPJR_DIRECCION(inCrpjr_direccion);
		this.setCRPJR_ACTIVIDAD(inCrpjr_actividad);
		this.setCRPJR_NUMERO_EMPLEADOS(inCrpjr_numero_empleados);
		this.setCRPJR_TIPO(inCrpjr_tipo);
		this.setCRPJR_OBSERVACION(inCrpjr_observacion);
		this.setCRPJR_ESTADO(inCrpjr_estado);
		this.setCRPJR_USUARIO_INSERT(inCrpjr_usuario_insert);
		this.setCRPJR_USUARIO_UPDATE(inCrpjr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	*/
	public void setCSCTP_CODIGO(String inCsctp_codigo){
		this.myCsctp_codigo = inCsctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	*/
	public String getCSCTP_CODIGO(){
		return this.myCsctp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	*/
	public void setCVSCT_CODIGO(String inCvsct_codigo){
		this.myCvsct_codigo = inCvsct_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	*/
	public String getCVSCT_CODIGO(){
		return this.myCvsct_codigo;
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
	* ESTABLECE NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	* @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	*/
	public void setCRPJR_RAZON_SOCIAL(String inCrpjr_razon_social){
		this.myCrpjr_razon_social = inCrpjr_razon_social;
	}
	/**
	* OBTIENE NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	* @return String NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	*/
	public String getCRPJR_RAZON_SOCIAL(){
		return this.myCrpjr_razon_social;
	}

	/**
	* ESTABLECE NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA EN MUCHOS DE LOS CASOS RUC
	* @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA EN MUCHOS DE LOS CASOS RUC
	*/
	public void setCRPJR_NUMERO_IDENTIFICACION(String inCrpjr_numero_identificacion){
		this.myCrpjr_numero_identificacion = inCrpjr_numero_identificacion;
	}
	/**
	* OBTIENE NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA EN MUCHOS DE LOS CASOS RUC
	* @return String NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA EN MUCHOS DE LOS CASOS RUC
	*/
	public String getCRPJR_NUMERO_IDENTIFICACION(){
		return this.myCrpjr_numero_identificacion;
	}

	/**
	* ESTABLECE FECHA DE CONSTITUCION DE LA EMPRESA
	* @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA
	*/
	public void setCRPJR_FECHA_CONSTITUCION(java.util.Date inCrpjr_fecha_constitucion){
		this.myCrpjr_fecha_constitucion = inCrpjr_fecha_constitucion;
	}
	/**
	* OBTIENE FECHA DE CONSTITUCION DE LA EMPRESA
	* @return java.util.Date FECHA DE CONSTITUCION DE LA EMPRESA
	*/
	public java.util.Date getCRPJR_FECHA_CONSTITUCION(){
		return this.myCrpjr_fecha_constitucion;
	}

	/**
	* ESTABLECE DIRECCION DE LA PERSONA JURIDICA
	* @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA
	*/
	public void setCRPJR_DIRECCION(String inCrpjr_direccion){
		this.myCrpjr_direccion = inCrpjr_direccion;
	}
	/**
	* OBTIENE DIRECCION DE LA PERSONA JURIDICA
	* @return String DIRECCION DE LA PERSONA JURIDICA
	*/
	public String getCRPJR_DIRECCION(){
		return this.myCrpjr_direccion;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DEDICA LA PERSONA JURIDICA
	* @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DEDICA LA PERSONA JURIDICA
	*/
	public void setCRPJR_ACTIVIDAD(String inCrpjr_actividad){
		this.myCrpjr_actividad = inCrpjr_actividad;
	}
	/**
	* OBTIENE DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DEDICA LA PERSONA JURIDICA
	* @return String DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DEDICA LA PERSONA JURIDICA
	*/
	public String getCRPJR_ACTIVIDAD(){
		return this.myCrpjr_actividad;
	}

	/**
	* ESTABLECE NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	* @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	*/
	public void setCRPJR_NUMERO_EMPLEADOS(java.math.BigDecimal inCrpjr_numero_empleados){
		this.myCrpjr_numero_empleados = inCrpjr_numero_empleados;
	}
	/**
	* OBTIENE NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	* @return java.math.BigDecimal NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	*/
	public java.math.BigDecimal getCRPJR_NUMERO_EMPLEADOS(){
		return this.myCrpjr_numero_empleados;
	}

	/**
	* ESTABLECE INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	* @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	*/
	public void setCRPJR_TIPO(int inCrpjr_tipo){
		this.myCrpjr_tipo = inCrpjr_tipo;
	}
	/**
	* OBTIENE INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	* @return int INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	*/
	public int getCRPJR_TIPO(){
		return this.myCrpjr_tipo;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCrpjr_observacion INFORMACION ADICIONAL
	*/
	public void setCRPJR_OBSERVACION(String inCrpjr_observacion){
		this.myCrpjr_observacion = inCrpjr_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCRPJR_OBSERVACION(){
		return this.myCrpjr_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrpjr_estado ESTADO DEL REGISTRO
	*/
	public void setCRPJR_ESTADO(boolean inCrpjr_estado){
		this.myCrpjr_estado = inCrpjr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPJR_ESTADO(){
		return this.myCrpjr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrpjr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPJR_USUARIO_INSERT(String inCrpjr_usuario_insert){
		this.myCrpjr_usuario_insert = inCrpjr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPJR_USUARIO_INSERT(){
		return this.myCrpjr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrpjr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPJR_USUARIO_UPDATE(String inCrpjr_usuario_update){
		this.myCrpjr_usuario_update = inCrpjr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPJR_USUARIO_UPDATE(){
		return this.myCrpjr_usuario_update;
	}

}
