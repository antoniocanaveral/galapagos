package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_requisito_tramite
* TABLA: REQUISITO TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS REQUISITOS PRESENTADOS PARA INICIAR UN TRAMITE
* ABREVIATURA:CRRQT
*/
public class Cgg_res_requisito_tramite implements Serializable{
	private static final long serialVersionUID = 1260193326;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrrqt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrtra_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	*/
	private String myCrsrq_codigo;
	/**
	* ESTADO DE CONTROL QUE DETERMINA LA INCORPORACION DEL REQUISITO EN EL TRAMITE
	*/
	private boolean myCrrqt_cumple;
	/**
	* NO ESPECIFICADO
	*/
	private String myCrrqt_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrrqt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrrqt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrrqt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_requisito_tramite
	*/
	public Cgg_res_requisito_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_requisito_tramite
	* @param inCrrqt_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrsrq_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	* @param inCrrqt_cumple ESTADO DE CONTROL QUE DETERMINA LA INCORPORACION DEL REQUISITO EN EL TRAMITE
	* @param inCrrqt_observacion NO ESPECIFICADO
	* @param inCrrqt_estado ESTADO DEL REGISTRO
	* @param inCrrqt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrqt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_requisito_tramite(
		String inCrrqt_codigo,
		String inCrtra_codigo,
		String inCrsrq_codigo,
		boolean inCrrqt_cumple,
		String inCrrqt_observacion,
		boolean inCrrqt_estado,
		String inCrrqt_usuario_insert,
		String inCrrqt_usuario_update
	){
		this.setCRRQT_CODIGO(inCrrqt_codigo);
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCRSRQ_CODIGO(inCrsrq_codigo);
		this.setCRRQT_CUMPLE(inCrrqt_cumple);
		this.setCRRQT_OBSERVACION(inCrrqt_observacion);
		this.setCRRQT_ESTADO(inCrrqt_estado);
		this.setCRRQT_USUARIO_INSERT(inCrrqt_usuario_insert);
		this.setCRRQT_USUARIO_UPDATE(inCrrqt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrrqt_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRRQT_CODIGO(String inCrrqt_codigo){
		this.myCrrqt_codigo = inCrrqt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRRQT_CODIGO(){
		return this.myCrrqt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	* @param inCrsrq_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	*/
	public void setCRSRQ_CODIGO(String inCrsrq_codigo){
		this.myCrsrq_codigo = inCrsrq_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	*/
	public String getCRSRQ_CODIGO(){
		return this.myCrsrq_codigo;
	}

	/**
	* ESTABLECE ESTADO DE CONTROL QUE DETERMINA LA INCORPORACION DEL REQUISITO EN EL TRAMITE
	* @param inCrrqt_cumple ESTADO DE CONTROL QUE DETERMINA LA INCORPORACION DEL REQUISITO EN EL TRAMITE
	*/
	public void setCRRQT_CUMPLE(boolean inCrrqt_cumple){
		this.myCrrqt_cumple = inCrrqt_cumple;
	}
	/**
	* OBTIENE ESTADO DE CONTROL QUE DETERMINA LA INCORPORACION DEL REQUISITO EN EL TRAMITE
	* @return boolean ESTADO DE CONTROL QUE DETERMINA LA INCORPORACION DEL REQUISITO EN EL TRAMITE
	*/
	public boolean getCRRQT_CUMPLE(){
		return this.myCrrqt_cumple;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCrrqt_observacion NO ESPECIFICADO
	*/
	public void setCRRQT_OBSERVACION(String inCrrqt_observacion){
		this.myCrrqt_observacion = inCrrqt_observacion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCRRQT_OBSERVACION(){
		return this.myCrrqt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrrqt_estado ESTADO DEL REGISTRO
	*/
	public void setCRRQT_ESTADO(boolean inCrrqt_estado){
		this.myCrrqt_estado = inCrrqt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRRQT_ESTADO(){
		return this.myCrrqt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrqt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRRQT_USUARIO_INSERT(String inCrrqt_usuario_insert){
		this.myCrrqt_usuario_insert = inCrrqt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRRQT_USUARIO_INSERT(){
		return this.myCrrqt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrrqt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRRQT_USUARIO_UPDATE(String inCrrqt_usuario_update){
		this.myCrrqt_usuario_update = inCrrqt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRRQT_USUARIO_UPDATE(){
		return this.myCrrqt_usuario_update;
	}

}
