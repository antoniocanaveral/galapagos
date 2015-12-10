package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_adjunto
* TABLA: ADJUNTO
* DESCRIPCION:ALMACENA INFORMACION DE LOS ARCHIVOS DIGITALIZADOS
* ABREVIATURA:CRADJ
*/
public class Cgg_res_adjunto implements Serializable{
	private static final long serialVersionUID = 769508784;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	private String myCradj_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	*/
	private String myCrinf_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	*/
	private String myCrnot_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	*/
	private String myCrdpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	private String myCrseg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	private String myCrtpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	private String myCrssc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	*/
	private String myCrrqt_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	private String myCvveh_codigo;
	/**
	* DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	*/
	private String myCradj_contenido;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCradj_nombre_adjunto;
	/**
	* OBSERVACION DEL ARCHIVO ADJUNTO
	*/
	private String myCradj_observacion;
	/**
	* ARCHIVO DIGITAL ANEXO 
	*/
	private byte[] myCradj_archivo_adjunto;
	/**
	* FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	*/
	private java.util.Date myCradj_fecha_registro;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCradj_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCradj_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCradj_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto
	*/
	public Cgg_res_adjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	* @param inCrinf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inCrrqt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	* @param inCradj_contenido DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	* @param inCradj_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCradj_observacion OBSERVACION DEL ARCHIVO ADJUNTO
	* @param inCradj_archivo_adjunto ARCHIVO DIGITAL ANEXO 
	* @param inCradj_fecha_registro FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	* @param inCradj_estado ESTADO DEL REGISTRO
	* @param inCradj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCradj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_adjunto(
		String inCradj_codigo,
		String inCrper_codigo,
		String inCrinf_codigo,
		String inCrnot_codigo,
		String inCrres_codigo,
		String inCrdpt_codigo,
		String inCrseg_codigo,
		String inCrtpt_codigo,
		String inCrssc_codigo,
		String inCrrqt_codigo,
		String inCradj_contenido,
		String inCradj_nombre_adjunto,
		String inCradj_observacion,
		byte[] inCradj_archivo_adjunto,
		java.util.Date inCradj_fecha_registro,
		boolean inCradj_estado,
		String inCradj_usuario_insert,
		String inCradj_usuario_update
	){
		this.setCRADJ_CODIGO(inCradj_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRINF_CODIGO(inCrinf_codigo);
		this.setCRNOT_CODIGO(inCrnot_codigo);
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCRDPT_CODIGO(inCrdpt_codigo);
		this.setCRSEG_CODIGO(inCrseg_codigo);
		this.setCRTPT_CODIGO(inCrtpt_codigo);
		this.setCRSSC_CODIGO(inCrssc_codigo);
		this.setCRRQT_CODIGO(inCrrqt_codigo);
		this.setCRADJ_CONTENIDO(inCradj_contenido);
		this.setCRADJ_NOMBRE_ADJUNTO(inCradj_nombre_adjunto);
		this.setCRADJ_OBSERVACION(inCradj_observacion);
		this.setCRADJ_ARCHIVO_ADJUNTO(inCradj_archivo_adjunto);
		this.setCRADJ_FECHA_REGISTRO(inCradj_fecha_registro);
		this.setCRADJ_ESTADO(inCradj_estado);
		this.setCRADJ_USUARIO_INSERT(inCradj_usuario_insert);
		this.setCRADJ_USUARIO_UPDATE(inCradj_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	public void setCRADJ_CODIGO(String inCradj_codigo){
		this.myCradj_codigo = inCradj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	public String getCRADJ_CODIGO(){
		return this.myCradj_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	* @param inCrinf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	*/
	public void setCRINF_CODIGO(String inCrinf_codigo){
		this.myCrinf_codigo = inCrinf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	*/
	public String getCRINF_CODIGO(){
		return this.myCrinf_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	*/
	public void setCRNOT_CODIGO(String inCrnot_codigo){
		this.myCrnot_codigo = inCrnot_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	*/
	public String getCRNOT_CODIGO(){
		return this.myCrnot_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public void setCRRES_CODIGO(String inCrres_codigo){
		this.myCrres_codigo = inCrres_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public String getCRRES_CODIGO(){
		return this.myCrres_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	*/
	public void setCRDPT_CODIGO(String inCrdpt_codigo){
		this.myCrdpt_codigo = inCrdpt_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	*/
	public String getCRDPT_CODIGO(){
		return this.myCrdpt_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public void setCRTPT_CODIGO(String inCrtpt_codigo){
		this.myCrtpt_codigo = inCrtpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public String getCRTPT_CODIGO(){
		return this.myCrtpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	public void setCRSSC_CODIGO(String inCrssc_codigo){
		this.myCrssc_codigo = inCrssc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @return String IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	public String getCRSSC_CODIGO(){
		return this.myCrssc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	* @param inCrrqt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	*/
	public void setCRRQT_CODIGO(String inCrrqt_codigo){
		this.myCrrqt_codigo = inCrrqt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	*/
	public String getCRRQT_CODIGO(){
		return this.myCrrqt_codigo;
	}
	
	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public void setCVVEH_CODIGO(String inCvveh_codigo){
		this.myCvveh_codigo = inCvveh_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public String getCVVEH_CODIGO(){
		return this.myCvveh_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	* @param inCradj_contenido DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	*/
	public void setCRADJ_CONTENIDO(String inCradj_contenido){
		this.myCradj_contenido = inCradj_contenido;
	}
	/**
	* OBTIENE DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	* @return String DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	*/
	public String getCRADJ_CONTENIDO(){
		return this.myCradj_contenido;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCradj_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCRADJ_NOMBRE_ADJUNTO(String inCradj_nombre_adjunto){
		this.myCradj_nombre_adjunto = inCradj_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCRADJ_NOMBRE_ADJUNTO(){
		return this.myCradj_nombre_adjunto;
	}

	/**
	* ESTABLECE OBSERVACION DEL ARCHIVO ADJUNTO
	* @param inCradj_observacion OBSERVACION DEL ARCHIVO ADJUNTO
	*/
	public void setCRADJ_OBSERVACION(String inCradj_observacion){
		this.myCradj_observacion = inCradj_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL ARCHIVO ADJUNTO
	* @return String OBSERVACION DEL ARCHIVO ADJUNTO
	*/
	public String getCRADJ_OBSERVACION(){
		return this.myCradj_observacion;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL ANEXO 
	* @param inCradj_archivo_adjunto ARCHIVO DIGITAL ANEXO 
	*/
	public void setCRADJ_ARCHIVO_ADJUNTO(byte[] inCradj_archivo_adjunto){
		this.myCradj_archivo_adjunto = inCradj_archivo_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL ANEXO 
	* @return byte[] ARCHIVO DIGITAL ANEXO 
	*/
	public byte[] getCRADJ_ARCHIVO_ADJUNTO(){
		return this.myCradj_archivo_adjunto;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	* @param inCradj_fecha_registro FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	*/
	public void setCRADJ_FECHA_REGISTRO(java.util.Date inCradj_fecha_registro){
		this.myCradj_fecha_registro = inCradj_fecha_registro;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	* @return java.util.Date FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	*/
	public java.util.Date getCRADJ_FECHA_REGISTRO(){
		return this.myCradj_fecha_registro;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCradj_estado ESTADO DEL REGISTRO
	*/
	public void setCRADJ_ESTADO(boolean inCradj_estado){
		this.myCradj_estado = inCradj_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRADJ_ESTADO(){
		return this.myCradj_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCradj_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRADJ_USUARIO_INSERT(String inCradj_usuario_insert){
		this.myCradj_usuario_insert = inCradj_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRADJ_USUARIO_INSERT(){
		return this.myCradj_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCradj_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRADJ_USUARIO_UPDATE(String inCradj_usuario_update){
		this.myCradj_usuario_update = inCradj_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRADJ_USUARIO_UPDATE(){
		return this.myCradj_usuario_update;
	}

}
