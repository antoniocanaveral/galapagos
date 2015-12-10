package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_expulsion
* TABLA: EXPULSION
* DESCRIPCION:ALMACENA INFORMACION DE LAS SALIDAS POR EXPULSION
* ABREVIATURA:CREXP
*/
public class Cgg_res_expulsion implements Serializable{
	private static final long serialVersionUID = 1180334876;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrexp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrmov_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	*/
	private String myCrnot_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TESTIGO DE EXPULSION
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE EXPULSION
	*/
	private String myCrosg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtfsl_codigo;
	/**
	* FECHA QUE SE REALIZA LA EXPULSION
	*/
	private java.util.Date myCrexp_fecha_expulsion;
	/**
	* TIPO DE PAGO
0 - PROPIO
1 - CGG
	*/
	private int myCrexp_tipo_pago;
	/**
	* COSTO DEL VUELO
	*/
	private java.math.BigDecimal myCrexp_valor_vuelo;
	/**
	* OBSERVACION DE LA EXPULSION
	*/
	private String myCrexp_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrexp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrexp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrexp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_expulsion
	*/
	public Cgg_res_expulsion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_expulsion
	* @param inCrexp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TESTIGO DE EXPULSION
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE EXPULSION
	* @param inCtfsl_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrexp_fecha_expulsion FECHA QUE SE REALIZA LA EXPULSION
	* @param inCrexp_tipo_pago TIPO DE PAGO
0 - PROPIO
1 - CGG
	* @param inCrexp_valor_vuelo COSTO DEL VUELO
	* @param inCrexp_observacion OBSERVACION DE LA EXPULSION
	* @param inCrexp_estado ESTADO DEL REGISTRO
	* @param inCrexp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrexp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_expulsion(
		String inCrexp_codigo,
		String inCrmov_codigo,
		String inCrnot_codigo,
		String inCrper_codigo,
		String inCrosg_codigo,
		String inCtfsl_codigo,
		java.util.Date inCrexp_fecha_expulsion,
		int inCrexp_tipo_pago,
		java.math.BigDecimal inCrexp_valor_vuelo,
		String inCrexp_observacion,
		boolean inCrexp_estado,
		String inCrexp_usuario_insert,
		String inCrexp_usuario_update
	){
		this.setCREXP_CODIGO(inCrexp_codigo);
		this.setCRMOV_CODIGO(inCrmov_codigo);
		this.setCRNOT_CODIGO(inCrnot_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCROSG_CODIGO(inCrosg_codigo);
		this.setCTFSL_CODIGO(inCtfsl_codigo);
		this.setCREXP_FECHA_EXPULSION(inCrexp_fecha_expulsion);
		this.setCREXP_TIPO_PAGO(inCrexp_tipo_pago);
		this.setCREXP_VALOR_VUELO(inCrexp_valor_vuelo);
		this.setCREXP_OBSERVACION(inCrexp_observacion);
		this.setCREXP_ESTADO(inCrexp_estado);
		this.setCREXP_USUARIO_INSERT(inCrexp_usuario_insert);
		this.setCREXP_USUARIO_UPDATE(inCrexp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrexp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCREXP_CODIGO(String inCrexp_codigo){
		this.myCrexp_codigo = inCrexp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCREXP_CODIGO(){
		return this.myCrexp_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	*/
	public void setCRNOT_CODIGO(String inCrnot_codigo){
		this.myCrnot_codigo = inCrnot_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	*/
	public String getCRNOT_CODIGO(){
		return this.myCrnot_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TESTIGO DE EXPULSION
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TESTIGO DE EXPULSION
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TESTIGO DE EXPULSION
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TESTIGO DE EXPULSION
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE EXPULSION
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE EXPULSION
	*/
	public void setCROSG_CODIGO(String inCrosg_codigo){
		this.myCrosg_codigo = inCrosg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE EXPULSION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE EXPULSION
	*/
	public String getCROSG_CODIGO(){
		return this.myCrosg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtfsl_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTFSL_CODIGO(String inCtfsl_codigo){
		this.myCtfsl_codigo = inCtfsl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTFSL_CODIGO(){
		return this.myCtfsl_codigo;
	}

	/**
	* ESTABLECE FECHA QUE SE REALIZA LA EXPULSION
	* @param inCrexp_fecha_expulsion FECHA QUE SE REALIZA LA EXPULSION
	*/
	public void setCREXP_FECHA_EXPULSION(java.util.Date inCrexp_fecha_expulsion){
		this.myCrexp_fecha_expulsion = inCrexp_fecha_expulsion;
	}
	/**
	* OBTIENE FECHA QUE SE REALIZA LA EXPULSION
	* @return java.util.Date FECHA QUE SE REALIZA LA EXPULSION
	*/
	public java.util.Date getCREXP_FECHA_EXPULSION(){
		return this.myCrexp_fecha_expulsion;
	}

	/**
	* ESTABLECE TIPO DE PAGO
0 - PROPIO
1 - CGG
	* @param inCrexp_tipo_pago TIPO DE PAGO
0 - PROPIO
1 - CGG
	*/
	public void setCREXP_TIPO_PAGO(int inCrexp_tipo_pago){
		this.myCrexp_tipo_pago = inCrexp_tipo_pago;
	}
	/**
	* OBTIENE TIPO DE PAGO
0 - PROPIO
1 - CGG
	* @return int TIPO DE PAGO
0 - PROPIO
1 - CGG
	*/
	public int getCREXP_TIPO_PAGO(){
		return this.myCrexp_tipo_pago;
	}

	/**
	* ESTABLECE COSTO DEL VUELO
	* @param inCrexp_valor_vuelo COSTO DEL VUELO
	*/
	public void setCREXP_VALOR_VUELO(java.math.BigDecimal inCrexp_valor_vuelo){
		this.myCrexp_valor_vuelo = inCrexp_valor_vuelo;
	}
	/**
	* OBTIENE COSTO DEL VUELO
	* @return java.math.BigDecimal COSTO DEL VUELO
	*/
	public java.math.BigDecimal getCREXP_VALOR_VUELO(){
		return this.myCrexp_valor_vuelo;
	}

	/**
	* ESTABLECE OBSERVACION DE LA EXPULSION
	* @param inCrexp_observacion OBSERVACION DE LA EXPULSION
	*/
	public void setCREXP_OBSERVACION(String inCrexp_observacion){
		this.myCrexp_observacion = inCrexp_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA EXPULSION
	* @return String OBSERVACION DE LA EXPULSION
	*/
	public String getCREXP_OBSERVACION(){
		return this.myCrexp_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrexp_estado ESTADO DEL REGISTRO
	*/
	public void setCREXP_ESTADO(boolean inCrexp_estado){
		this.myCrexp_estado = inCrexp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCREXP_ESTADO(){
		return this.myCrexp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrexp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCREXP_USUARIO_INSERT(String inCrexp_usuario_insert){
		this.myCrexp_usuario_insert = inCrexp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCREXP_USUARIO_INSERT(){
		return this.myCrexp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrexp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCREXP_USUARIO_UPDATE(String inCrexp_usuario_update){
		this.myCrexp_usuario_update = inCrexp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCREXP_USUARIO_UPDATE(){
		return this.myCrexp_usuario_update;
	}

}
