package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_solicitud_requisito
* TABLA: TIPO DE SOLICITUD REQUISITOS
* DESCRIPCION:ALMACENA INFORMACION DE LOS REQUISITOS PARA LOS TRAMITES DE SOLICITUD DE RESIDENCIA DE ACUERDO A SU TIPO
* ABREVIATURA:CRSRQ
*/
public class Cgg_res_solicitud_requisito implements Serializable{
	private static final long serialVersionUID = 796966511;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	*/
	private String myCrsrq_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrreq_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* DESCRIPCION DEL REQUERIMIENTO POR EL TIPO DE SOLICITUD DE RESIDENCIA
	*/
	private String myCrsrq_descripcion;
	/**
	* DETERMINA OBLIGATORIEDAD
	*/
	private boolean myCrsrq_requerido;
	/**
	* TIPO DE PARTICIPANTE DEL TRAMITE
VALORES:
0-AUSPICIANTE
1-BENEFICIARIO - AUSPICIADO
2-GENERAL - OTRO
	*/
	private int myCrsrq_participante;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrsrq_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrsrq_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrsrq_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_solicitud_requisito
	*/
	public Cgg_res_solicitud_requisito(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_solicitud_requisito
	* @param inCrsrq_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE SOLICITUD DE TRAMITE
	* @param inCrreq_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrsrq_descripcion DESCRIPCION DEL REQUERIMIENTO POR EL TIPO DE SOLICITUD DE RESIDENCIA
	* @param inCrsrq_requerido DETERMINA OBLIGATORIEDAD
	* @param inCrsrq_participante TIPO DE PARTICIPANTE DEL TRAMITE
VALORES:
0-AUSPICIANTE
1-BENEFICIARIO - AUSPICIADO
2-GENERAL - OTRO
	* @param inCrsrq_estado ESTADO DEL REGISTRO
	* @param inCrsrq_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrsrq_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_solicitud_requisito(
		String inCrsrq_codigo,
		String inCrreq_codigo,
		String inCrtst_codigo,
		String inCrsrq_descripcion,
		boolean inCrsrq_requerido,
		int inCrsrq_participante,
		boolean inCrsrq_estado,
		String inCrsrq_usuario_insert,
		String inCrsrq_usuario_update
	){
		this.setCRSRQ_CODIGO(inCrsrq_codigo);
		this.setCRREQ_CODIGO(inCrreq_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRSRQ_DESCRIPCION(inCrsrq_descripcion);
		this.setCRSRQ_REQUERIDO(inCrsrq_requerido);
		this.setCRSRQ_PARTICIPANTE(inCrsrq_participante);
		this.setCRSRQ_ESTADO(inCrsrq_estado);
		this.setCRSRQ_USUARIO_INSERT(inCrsrq_usuario_insert);
		this.setCRSRQ_USUARIO_UPDATE(inCrsrq_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrreq_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRREQ_CODIGO(String inCrreq_codigo){
		this.myCrreq_codigo = inCrreq_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRREQ_CODIGO(){
		return this.myCrreq_codigo;
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
	* ESTABLECE DESCRIPCION DEL REQUERIMIENTO POR EL TIPO DE SOLICITUD DE RESIDENCIA
	* @param inCrsrq_descripcion DESCRIPCION DEL REQUERIMIENTO POR EL TIPO DE SOLICITUD DE RESIDENCIA
	*/
	public void setCRSRQ_DESCRIPCION(String inCrsrq_descripcion){
		this.myCrsrq_descripcion = inCrsrq_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL REQUERIMIENTO POR EL TIPO DE SOLICITUD DE RESIDENCIA
	* @return String DESCRIPCION DEL REQUERIMIENTO POR EL TIPO DE SOLICITUD DE RESIDENCIA
	*/
	public String getCRSRQ_DESCRIPCION(){
		return this.myCrsrq_descripcion;
	}

	/**
	* ESTABLECE DETERMINA OBLIGATORIEDAD
	* @param inCrsrq_requerido DETERMINA OBLIGATORIEDAD
	*/
	public void setCRSRQ_REQUERIDO(boolean inCrsrq_requerido){
		this.myCrsrq_requerido = inCrsrq_requerido;
	}
	/**
	* OBTIENE DETERMINA OBLIGATORIEDAD
	* @return boolean DETERMINA OBLIGATORIEDAD
	*/
	public boolean getCRSRQ_REQUERIDO(){
		return this.myCrsrq_requerido;
	}

	/**
	* ESTABLECE TIPO DE PARTICIPANTE DEL TRAMITE
VALORES:
0-AUSPICIANTE
1-BENEFICIARIO - AUSPICIADO
2-GENERAL - OTRO
	* @param inCrsrq_participante TIPO DE PARTICIPANTE DEL TRAMITE
VALORES:
0-AUSPICIANTE
1-BENEFICIARIO - AUSPICIADO
2-GENERAL - OTRO
	*/
	public void setCRSRQ_PARTICIPANTE(int inCrsrq_participante){
		this.myCrsrq_participante = inCrsrq_participante;
	}
	/**
	* OBTIENE TIPO DE PARTICIPANTE DEL TRAMITE
VALORES:
0-AUSPICIANTE
1-BENEFICIARIO - AUSPICIADO
2-GENERAL - OTRO
	* @return int TIPO DE PARTICIPANTE DEL TRAMITE
VALORES:
0-AUSPICIANTE
1-BENEFICIARIO - AUSPICIADO
2-GENERAL - OTRO
	*/
	public int getCRSRQ_PARTICIPANTE(){
		return this.myCrsrq_participante;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrsrq_estado ESTADO DEL REGISTRO
	*/
	public void setCRSRQ_ESTADO(boolean inCrsrq_estado){
		this.myCrsrq_estado = inCrsrq_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRSRQ_ESTADO(){
		return this.myCrsrq_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrsrq_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRSRQ_USUARIO_INSERT(String inCrsrq_usuario_insert){
		this.myCrsrq_usuario_insert = inCrsrq_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRSRQ_USUARIO_INSERT(){
		return this.myCrsrq_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrsrq_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRSRQ_USUARIO_UPDATE(String inCrsrq_usuario_update){
		this.myCrsrq_usuario_update = inCrsrq_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRSRQ_USUARIO_UPDATE(){
		return this.myCrsrq_usuario_update;
	}

}
