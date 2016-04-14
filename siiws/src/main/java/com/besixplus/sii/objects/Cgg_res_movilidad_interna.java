package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_movilidad_interna
* TABLA: MOVILIDAD INTERNA
* DESCRIPCION:ALMACENA INFORMACION DE LOS VIAJES REALIZADOS POR LAS PERSONAS DENTRO DE LA PROVINCIA
* ABREVIATURA:CRMVI
*/
public class Cgg_res_movilidad_interna implements Serializable{
	private static final long serialVersionUID = 1908572065;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	*/
	private String myCrmvi_codigo;
	/**
	* MUELLE ORIGEN
	*/
	private String myCrmle_codigo;
	/**
	* MUELLE DESTINO
	*/
	private String myCgg_crmle_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
	*/
	private String myCremb_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	private String myCrmov_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCarpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgg_carpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCraln_codigo;
	/**
	* DESCRIPCION DEL VUELO 
	*/
	private String myCraln_descripcion_vuelo;
	/**
	* FECHA DE VIAJE
	*/
	private java.util.Date myCrmvi_fecha_viaje;
	/**
	* TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
	*/
	private int myCrmvi_tipo_operacion;
	/**
	* DESCRIPCION CORTA 
	*/
	private String myCrmvi_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrmvi_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrmvi_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrmvi_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad_interna
	*/
	public Cgg_res_movilidad_interna(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_movilidad_interna
	* @param inCrmvi_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD INTERNA
	* @param inCrmle_codigo MUELLE ORIGEN
	* @param inCgg_crmle_codigo MUELLE DESTINO
	* @param inCremb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCraln_descripcion_vuelo DESCRIPCION DEL VUELO 
	* @param inCrmvi_fecha_viaje FECHA DE VIAJE
	* @param inCrmvi_tipo_operacion TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
	* @param inCrmvi_observacion DESCRIPCION CORTA 
	* @param inCrmvi_estado ESTADO DEL REGISTRO
	* @param inCrmvi_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmvi_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_movilidad_interna(
		String inCrmvi_codigo,
		String inCrmle_codigo,
		String inCgg_crmle_codigo,
		String inCremb_codigo,
		String inCrper_codigo,
		String inCrmov_codigo,
		String inCarpt_codigo,
		String inCgg_carpt_codigo,
		String inCraln_codigo,
		String inCraln_descripcion_vuelo,
		java.util.Date inCrmvi_fecha_viaje,
		int inCrmvi_tipo_operacion,
		String inCrmvi_observacion,
		boolean inCrmvi_estado,
		String inCrmvi_usuario_insert,
		String inCrmvi_usuario_update
	){
		this.setCRMVI_CODIGO(inCrmvi_codigo);
		this.setCRMLE_CODIGO(inCrmle_codigo);
		this.setCGG_CRMLE_CODIGO(inCgg_crmle_codigo);
		this.setCREMB_CODIGO(inCremb_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRMOV_CODIGO(inCrmov_codigo);
		this.setCARPT_CODIGO(inCarpt_codigo);
		this.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
		this.setCRALN_CODIGO(inCraln_codigo);
		this.setCRALN_DESCRIPCION_VUELO(inCraln_descripcion_vuelo);
		this.setCRMVI_FECHA_VIAJE(inCrmvi_fecha_viaje);
		this.setCRMVI_TIPO_OPERACION(inCrmvi_tipo_operacion);
		this.setCRMVI_OBSERVACION(inCrmvi_observacion);
		this.setCRMVI_ESTADO(inCrmvi_estado);
		this.setCRMVI_USUARIO_INSERT(inCrmvi_usuario_insert);
		this.setCRMVI_USUARIO_UPDATE(inCrmvi_usuario_update);
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
	* ESTABLECE MUELLE ORIGEN
	* @param inCrmle_codigo MUELLE ORIGEN
	*/
	public void setCRMLE_CODIGO(String inCrmle_codigo){
		this.myCrmle_codigo = inCrmle_codigo;
	}
	/**
	* OBTIENE MUELLE ORIGEN
	* @return String MUELLE ORIGEN
	*/
	public String getCRMLE_CODIGO(){
		return this.myCrmle_codigo;
	}

	/**
	* ESTABLECE MUELLE DESTINO
	* @param inCgg_crmle_codigo MUELLE DESTINO
	*/
	public void setCGG_CRMLE_CODIGO(String inCgg_crmle_codigo){
		this.myCgg_crmle_codigo = inCgg_crmle_codigo;
	}
	/**
	* OBTIENE MUELLE DESTINO
	* @return String MUELLE DESTINO
	*/
	public String getCGG_CRMLE_CODIGO(){
		return this.myCgg_crmle_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
	* @param inCremb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
	*/
	public void setCREMB_CODIGO(String inCremb_codigo){
		this.myCremb_codigo = inCremb_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE EMBARCACION
	*/
	public String getCREMB_CODIGO(){
		return this.myCremb_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO  DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	public void setCRMOV_CODIGO(String inCrmov_codigo){
		this.myCrmov_codigo = inCrmov_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOVILIDAD
	*/
	public String getCRMOV_CODIGO(){
		return this.myCrmov_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCARPT_CODIGO(String inCarpt_codigo){
		this.myCarpt_codigo = inCarpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCARPT_CODIGO(){
		return this.myCarpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGG_CARPT_CODIGO(String inCgg_carpt_codigo){
		this.myCgg_carpt_codigo = inCgg_carpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGG_CARPT_CODIGO(){
		return this.myCgg_carpt_codigo;
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
	* ESTABLECE DESCRIPCION DEL VUELO 
	* @param inCraln_descripcion_vuelo DESCRIPCION DEL VUELO 
	*/
	public void setCRALN_DESCRIPCION_VUELO(String inCraln_descripcion_vuelo){
		this.myCraln_descripcion_vuelo = inCraln_descripcion_vuelo;
	}
	/**
	* OBTIENE DESCRIPCION DEL VUELO 
	* @return String DESCRIPCION DEL VUELO 
	*/
	public String getCRALN_DESCRIPCION_VUELO(){
		return this.myCraln_descripcion_vuelo;
	}

	/**
	* ESTABLECE FECHA DE VIAJE
	* @param inCrmvi_fecha_viaje FECHA DE VIAJE
	*/
	public void setCRMVI_FECHA_VIAJE(java.util.Date inCrmvi_fecha_viaje){
		this.myCrmvi_fecha_viaje = inCrmvi_fecha_viaje;
	}
	/**
	* OBTIENE FECHA DE VIAJE
	* @return java.util.Date FECHA DE VIAJE
	*/
	public java.util.Date getCRMVI_FECHA_VIAJE(){
		return this.myCrmvi_fecha_viaje;
	}

	/**
	* ESTABLECE TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
	* @param inCrmvi_tipo_operacion TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
	*/
	public void setCRMVI_TIPO_OPERACION(int inCrmvi_tipo_operacion){
		this.myCrmvi_tipo_operacion = inCrmvi_tipo_operacion;
	}
	/**
	* OBTIENE TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
	* @return int TIPO DE OPERACION DE LA PERSONA SOBRE LAS ISLAS
	*/
	public int getCRMVI_TIPO_OPERACION(){
		return this.myCrmvi_tipo_operacion;
	}

	/**
	* ESTABLECE DESCRIPCION CORTA 
	* @param inCrmvi_observacion DESCRIPCION CORTA 
	*/
	public void setCRMVI_OBSERVACION(String inCrmvi_observacion){
		this.myCrmvi_observacion = inCrmvi_observacion;
	}
	/**
	* OBTIENE DESCRIPCION CORTA 
	* @return String DESCRIPCION CORTA 
	*/
	public String getCRMVI_OBSERVACION(){
		return this.myCrmvi_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrmvi_estado ESTADO DEL REGISTRO
	*/
	public void setCRMVI_ESTADO(boolean inCrmvi_estado){
		this.myCrmvi_estado = inCrmvi_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRMVI_ESTADO(){
		return this.myCrmvi_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmvi_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRMVI_USUARIO_INSERT(String inCrmvi_usuario_insert){
		this.myCrmvi_usuario_insert = inCrmvi_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRMVI_USUARIO_INSERT(){
		return this.myCrmvi_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrmvi_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRMVI_USUARIO_UPDATE(String inCrmvi_usuario_update){
		this.myCrmvi_usuario_update = inCrmvi_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRMVI_USUARIO_UPDATE(){
		return this.myCrmvi_usuario_update;
	}

}
