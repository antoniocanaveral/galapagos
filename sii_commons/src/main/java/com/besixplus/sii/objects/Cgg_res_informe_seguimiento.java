package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_informe_seguimiento
* TABLA: INFORME DE SEGUIMIENTO
* DESCRIPCION:ALMACENA INFORMACION DE LOS INFORMES  GENERADOS EN EL SEGUIMIENTO
* ABREVIATURA:CRISE
*/
public class Cgg_res_informe_seguimiento implements Serializable{
	private static final long serialVersionUID = 1803801752;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	*/
	private String myCrise_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	private String myCrseg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	private String myCrsec_codigo;
	/**
	* NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	*/
	private String myCrise_numero_informe;
	/**
	* FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	*/
	private java.util.Date myCrise_fecha_informe;
	/**
	* ASUNTO DEL INFORME SE SEGUIMIENTO
	*/
	private String myCrise_asunto_informe;
	/**
	* RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	*/
	private String myCrise_extracto_informe;
	/**
	* DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	*/
	private String myCrise_descripcion_adjunto;
	/**
	* ESTADO DEL REGISTRO DE INFORME DE SEGUIMIENTO
	*/
	private boolean myCrise_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrise_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrise_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_seguimiento
	*/
	public Cgg_res_informe_seguimiento(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_seguimiento
	* @param inCrise_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @param inCrise_numero_informe NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	* @param inCrise_fecha_informe FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	* @param inCrise_asunto_informe ASUNTO DEL INFORME SE SEGUIMIENTO
	* @param inCrise_extracto_informe RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	* @param inCrise_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	* @param inCrise_estado ESTADO DEL REGISTRO DE INFORME DE SEGUIMIENTO
	* @param inCrise_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrise_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_informe_seguimiento(
		String inCrise_codigo,
		String inCrseg_codigo,
		String inCrsec_codigo,
		String inCrise_numero_informe,
		java.util.Date inCrise_fecha_informe,
		String inCrise_asunto_informe,
		String inCrise_extracto_informe,
		String inCrise_descripcion_adjunto,
		boolean inCrise_estado,
		String inCrise_usuario_insert,
		String inCrise_usuario_update
	){
		this.setCRISE_CODIGO(inCrise_codigo);
		this.setCRSEG_CODIGO(inCrseg_codigo);
		this.setCRSEC_CODIGO(inCrsec_codigo);
		this.setCRISE_NUMERO_INFORME(inCrise_numero_informe);
		this.setCRISE_FECHA_INFORME(inCrise_fecha_informe);
		this.setCRISE_ASUNTO_INFORME(inCrise_asunto_informe);
		this.setCRISE_EXTRACTO_INFORME(inCrise_extracto_informe);
		this.setCRISE_DESCRIPCION_ADJUNTO(inCrise_descripcion_adjunto);
		this.setCRISE_ESTADO(inCrise_estado);
		this.setCRISE_USUARIO_INSERT(inCrise_usuario_insert);
		this.setCRISE_USUARIO_UPDATE(inCrise_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	* @param inCrise_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	*/
	public void setCRISE_CODIGO(String inCrise_codigo){
		this.myCrise_codigo = inCrise_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	*/
	public String getCRISE_CODIGO(){
		return this.myCrise_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	public void setCRSEG_CODIGO(String inCrseg_codigo){
		this.myCrseg_codigo = inCrseg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	public String getCRSEG_CODIGO(){
		return this.myCrseg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	public void setCRSEC_CODIGO(String inCrsec_codigo){
		this.myCrsec_codigo = inCrsec_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	public String getCRSEC_CODIGO(){
		return this.myCrsec_codigo;
	}

	/**
	* ESTABLECE NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	* @param inCrise_numero_informe NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	*/
	public void setCRISE_NUMERO_INFORME(String inCrise_numero_informe){
		this.myCrise_numero_informe = inCrise_numero_informe;
	}
	/**
	* OBTIENE NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	* @return String NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	*/
	public String getCRISE_NUMERO_INFORME(){
		return this.myCrise_numero_informe;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	* @param inCrise_fecha_informe FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	*/
	public void setCRISE_FECHA_INFORME(java.util.Date inCrise_fecha_informe){
		this.myCrise_fecha_informe = inCrise_fecha_informe;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	* @return java.util.Date FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	*/
	public java.util.Date getCRISE_FECHA_INFORME(){
		return this.myCrise_fecha_informe;
	}

	/**
	* ESTABLECE ASUNTO DEL INFORME SE SEGUIMIENTO
	* @param inCrise_asunto_informe ASUNTO DEL INFORME SE SEGUIMIENTO
	*/
	public void setCRISE_ASUNTO_INFORME(String inCrise_asunto_informe){
		this.myCrise_asunto_informe = inCrise_asunto_informe;
	}
	/**
	* OBTIENE ASUNTO DEL INFORME SE SEGUIMIENTO
	* @return String ASUNTO DEL INFORME SE SEGUIMIENTO
	*/
	public String getCRISE_ASUNTO_INFORME(){
		return this.myCrise_asunto_informe;
	}

	/**
	* ESTABLECE RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	* @param inCrise_extracto_informe RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	*/
	public void setCRISE_EXTRACTO_INFORME(String inCrise_extracto_informe){
		this.myCrise_extracto_informe = inCrise_extracto_informe;
	}
	/**
	* OBTIENE RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	* @return String RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	*/
	public String getCRISE_EXTRACTO_INFORME(){
		return this.myCrise_extracto_informe;
	}

	/**
	* ESTABLECE DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	* @param inCrise_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	*/
	public void setCRISE_DESCRIPCION_ADJUNTO(String inCrise_descripcion_adjunto){
		this.myCrise_descripcion_adjunto = inCrise_descripcion_adjunto;
	}
	/**
	* OBTIENE DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	* @return String DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	*/
	public String getCRISE_DESCRIPCION_ADJUNTO(){
		return this.myCrise_descripcion_adjunto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE INFORME DE SEGUIMIENTO
	* @param inCrise_estado ESTADO DEL REGISTRO DE INFORME DE SEGUIMIENTO
	*/
	public void setCRISE_ESTADO(boolean inCrise_estado){
		this.myCrise_estado = inCrise_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE INFORME DE SEGUIMIENTO
	* @return boolean ESTADO DEL REGISTRO DE INFORME DE SEGUIMIENTO
	*/
	public boolean getCRISE_ESTADO(){
		return this.myCrise_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrise_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRISE_USUARIO_INSERT(String inCrise_usuario_insert){
		this.myCrise_usuario_insert = inCrise_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRISE_USUARIO_INSERT(){
		return this.myCrise_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrise_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRISE_USUARIO_UPDATE(String inCrise_usuario_update){
		this.myCrise_usuario_update = inCrise_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRISE_USUARIO_UPDATE(){
		return this.myCrise_usuario_update;
	}

}
