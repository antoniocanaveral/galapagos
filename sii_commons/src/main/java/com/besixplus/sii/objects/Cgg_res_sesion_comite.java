package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_sesion_comite
* TABLA: SESION COMITE
* DESCRIPCION:ALMACENA INFORMACION DE LAS REUNIONES DE COMITE
* ABREVIATURA:CRSSC
*/
public class Cgg_res_sesion_comite implements Serializable{
	private static final long serialVersionUID = 56505693;
	/**
	* IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	private String myCrssc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	*/
	private String myCisla_codigo;
	/**
	* NOMBRE IDENTIFICATIVO DE LA ISLA
	*/
	private String myIsla;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrcom_codigo;
	/**
	* NOMBRE IDENTIFICATIVO DEL COMITE
	*/
	private String myComite;
	
	
	/**
	* NOMBRE IDENTIFICATIVO DEL COMITE
	*/
	private String myResAdjunto;
	
	
	
	/**
	* FECHA DE REALIZACION DE LA SESION
	*/
	private java.util.Date myCrssc_fecha_reunion;
	/**
	* FECHA DE FINALIZACION DE SESION  
	*/
	private java.util.Date myCrssc_fecha_finalizacion;
	/**
	* NUMERO IDENTIFICATIVO DE LA SESION
	*/
	private String myCrssc_numero_sesion;
	/**
	* RESUMEN DEL CONTENIDO DE LA SESION
	*/
	private String myCrssc_extracto;
	/**
	* OBSERVACIONES DE LA SESION
	*/
	private String myCrssc_observacion;
	/**
	* FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	*/
	private java.util.Date myCrssc_fecha_convocatoria;
	/**
	* RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	*/
	private String myCrssc_motivo_convocatoria;
	/**
	* DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	*/
	private String myCrssc_descripcion_adjunto;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCrssc_nombre_adjunto;
	/**
	* ARCHIVO DIGITAL ANEXO A LA SESION
	*/
	private byte[] myCrssc_adjunto;
	/**
	* ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
	*/
	private int myCrssc_estado_convocatoria;
	/**
	* TRAMITES PARA GENERAR LAS RESOLUCIONES
	*/
	private String myTramite;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrssc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrssc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrssc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_comite
	*/
	public Cgg_res_sesion_comite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_comite
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrssc_fecha_reunion FECHA DE REALIZACION DE LA SESION
	* @param inCrssc_fecha_finalizacion FECHA DE FINALIZACION DE SESION  
	* @param inCrssc_numero_sesion NUMERO IDENTIFICATIVO DE LA SESION
	* @param inCrssc_extracto RESUMEN DEL CONTENIDO DE LA SESION
	* @param inCrssc_observacion OBSERVACIONES DE LA SESION
	* @param inCrssc_fecha_convocatoria FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	* @param inCrssc_motivo_convocatoria RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	* @param inCrssc_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	* @param inCrssc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrssc_adjunto ARCHIVO DIGITAL ANEXO A LA SESION
	* @param inCrssc_estado_convocatoria ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
	* @param inCrssc_estado ESTADO DEL REGISTRO
	* @param inCrssc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrssc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_sesion_comite(
		String inCrssc_codigo,
		String inCisla_codigo,
		String inCrcom_codigo,
		java.util.Date inCrssc_fecha_reunion,
		java.util.Date inCrssc_fecha_finalizacion,
		String inCrssc_numero_sesion,
		String inCrssc_extracto,
		String inCrssc_observacion,
		java.util.Date inCrssc_fecha_convocatoria,
		String inCrssc_motivo_convocatoria,
		String inCrssc_descripcion_adjunto,
		String inCrssc_nombre_adjunto,
		byte[] inCrssc_adjunto,
		int inCrssc_estado_convocatoria,
		boolean inCrssc_estado,
		String inCrssc_usuario_insert,
		String inCrssc_usuario_update
	){
		this.setCRSSC_CODIGO(inCrssc_codigo);
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCRCOM_CODIGO(inCrcom_codigo);
		this.setCRSSC_FECHA_REUNION(inCrssc_fecha_reunion);
		this.setCRSSC_FECHA_FINALIZACION(inCrssc_fecha_finalizacion);
		this.setCRSSC_NUMERO_SESION(inCrssc_numero_sesion);
		this.setCRSSC_EXTRACTO(inCrssc_extracto);
		this.setCRSSC_OBSERVACION(inCrssc_observacion);
		this.setCRSSC_FECHA_CONVOCATORIA(inCrssc_fecha_convocatoria);
		this.setCRSSC_MOTIVO_CONVOCATORIA(inCrssc_motivo_convocatoria);
		this.setCRSSC_DESCRIPCION_ADJUNTO(inCrssc_descripcion_adjunto);
		this.setCRSSC_NOMBRE_ADJUNTO(inCrssc_nombre_adjunto);
		this.setCRSSC_ADJUNTO(inCrssc_adjunto);
		this.setCRSSC_ESTADO_CONVOCATORIA(inCrssc_estado_convocatoria);
		this.setCRSSC_ESTADO(inCrssc_estado);
		this.setCRSSC_USUARIO_INSERT(inCrssc_usuario_insert);
		this.setCRSSC_USUARIO_UPDATE(inCrssc_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	*/
	public void setCISLA_CODIGO(String inCisla_codigo){
		this.myCisla_codigo = inCisla_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	*/
	public String getCISLA_CODIGO(){
		return this.myCisla_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRCOM_CODIGO(String inCrcom_codigo){
		this.myCrcom_codigo = inCrcom_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRCOM_CODIGO(){
		return this.myCrcom_codigo;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DE LA SESION
	* @param inCrssc_fecha_reunion FECHA DE REALIZACION DE LA SESION
	*/
	public void setCRSSC_FECHA_REUNION(java.util.Date inCrssc_fecha_reunion){
		this.myCrssc_fecha_reunion = inCrssc_fecha_reunion;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DE LA SESION
	* @return java.util.Date FECHA DE REALIZACION DE LA SESION
	*/
	public java.util.Date getCRSSC_FECHA_REUNION(){
		return this.myCrssc_fecha_reunion;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DE SESION  
	* @param inCrssc_fecha_finalizacion FECHA DE FINALIZACION DE SESION  
	*/
	public void setCRSSC_FECHA_FINALIZACION(java.util.Date inCrssc_fecha_finalizacion){
		this.myCrssc_fecha_finalizacion = inCrssc_fecha_finalizacion;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DE SESION  
	* @return java.util.Date FECHA DE FINALIZACION DE SESION  
	*/
	public java.util.Date getCRSSC_FECHA_FINALIZACION(){
		return this.myCrssc_fecha_finalizacion;
	}

	/**
	* ESTABLECE NUMERO IDENTIFICATIVO DE LA SESION
	* @param inCrssc_numero_sesion NUMERO IDENTIFICATIVO DE LA SESION
	*/
	public void setCRSSC_NUMERO_SESION(String inCrssc_numero_sesion){
		this.myCrssc_numero_sesion = inCrssc_numero_sesion;
	}
	/**
	* OBTIENE NUMERO IDENTIFICATIVO DE LA SESION
	* @return String NUMERO IDENTIFICATIVO DE LA SESION
	*/
	public String getCRSSC_NUMERO_SESION(){
		return this.myCrssc_numero_sesion;
	}

	/**
	* ESTABLECE RESUMEN DEL CONTENIDO DE LA SESION
	* @param inCrssc_extracto RESUMEN DEL CONTENIDO DE LA SESION
	*/
	public void setCRSSC_EXTRACTO(String inCrssc_extracto){
		this.myCrssc_extracto = inCrssc_extracto;
	}
	/**
	* OBTIENE RESUMEN DEL CONTENIDO DE LA SESION
	* @return String RESUMEN DEL CONTENIDO DE LA SESION
	*/
	public String getCRSSC_EXTRACTO(){
		return this.myCrssc_extracto;
	}

	/**
	* ESTABLECE OBSERVACIONES DE LA SESION
	* @param inCrssc_observacion OBSERVACIONES DE LA SESION
	*/
	public void setCRSSC_OBSERVACION(String inCrssc_observacion){
		this.myCrssc_observacion = inCrssc_observacion;
	}
	/**
	* OBTIENE OBSERVACIONES DE LA SESION
	* @return String OBSERVACIONES DE LA SESION
	*/
	public String getCRSSC_OBSERVACION(){
		return this.myCrssc_observacion;
	}
	/**
	* ESTABLECE FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	* @param inCrssc_fecha_convocatoria FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	*/
	public void setCRSSC_FECHA_CONVOCATORIA(java.util.Date inCrssc_fecha_convocatoria){
		this.myCrssc_fecha_convocatoria = inCrssc_fecha_convocatoria;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	* @return java.util.Date FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	*/
	public java.util.Date getCRSSC_FECHA_CONVOCATORIA(){
		return this.myCrssc_fecha_convocatoria;
	}

	/**
	* ESTABLECE RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	* @param inCrssc_motivo_convocatoria RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	*/
	public void setCRSSC_MOTIVO_CONVOCATORIA(String inCrssc_motivo_convocatoria){
		this.myCrssc_motivo_convocatoria = inCrssc_motivo_convocatoria;
	}
	/**
	* OBTIENE RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	* @return String RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	*/
	public String getCRSSC_MOTIVO_CONVOCATORIA(){
		return this.myCrssc_motivo_convocatoria;
	}

	/**
	* ESTABLECE DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	* @param inCrssc_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	*/
	public void setCRSSC_DESCRIPCION_ADJUNTO(String inCrssc_descripcion_adjunto){
		this.myCrssc_descripcion_adjunto = inCrssc_descripcion_adjunto;
	}
	/**
	* OBTIENE DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	* @return String DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	*/
	public String getCRSSC_DESCRIPCION_ADJUNTO(){
		return this.myCrssc_descripcion_adjunto;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrssc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCRSSC_NOMBRE_ADJUNTO(String inCrssc_nombre_adjunto){
		this.myCrssc_nombre_adjunto = inCrssc_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCRSSC_NOMBRE_ADJUNTO(){
		return this.myCrssc_nombre_adjunto;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL ANEXO A LA SESION
	* @param inCrssc_adjunto ARCHIVO DIGITAL ANEXO A LA SESION
	*/
	public void setCRSSC_ADJUNTO(byte[] inCrssc_adjunto){
		this.myCrssc_adjunto = inCrssc_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL ANEXO A LA SESION
	* @return byte[] ARCHIVO DIGITAL ANEXO A LA SESION
	*/
	public byte[] getCRSSC_ADJUNTO(){
		return this.myCrssc_adjunto;
	}

	/**
	* ESTABLECE ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
	* @param inCrssc_estado_convocatoria ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
	*/
	public void setCRSSC_ESTADO_CONVOCATORIA(int inCrssc_estado_convocatoria){
		this.myCrssc_estado_convocatoria = inCrssc_estado_convocatoria;
	}
	/**
	* OBTIENE ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
	* @return int ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
	*/
	public int getCRSSC_ESTADO_CONVOCATORIA(){
		return this.myCrssc_estado_convocatoria;
	}

	/**
	* ESTABLECE EL TRAMITE
	 * @param inTramite 
	*/
	public void setTRAMITE(String inTramite){
		this.myTramite = inTramite;
	}
	/**
	* OBTIENE EL TRAMITE
	 * @return string TRAMITE
	*/
	public String getTRAMITE(){
		return this.myTramite;
	}
	
	/**
	* ESTABLECE ALMACENA INFORMACION DE LOS ARCHIVOS DIGITALIZADOS
	 * @param inRes_adjunto INFORMACION DE LOS ARCHIVOS DIGITALIZADOS
	*/
	public void setRESADJUNTO(String inRes_adjunto){
		this.myResAdjunto = inRes_adjunto;
	}
	/**
	* OBTIENE INFORMACION DE LOS ARCHIVOS DIGITALIZADOS
	 * @return String INFORMACION DE LOS ARCHIVOS DIGITALIZADOS
	*/
	public String getRESADJUNTO(){
		return this.myResAdjunto;
	}
	
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrssc_estado ESTADO DEL REGISTRO
	*/
	public void setCRSSC_ESTADO(boolean inCrssc_estado){
		this.myCrssc_estado = inCrssc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRSSC_ESTADO(){
		return this.myCrssc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrssc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRSSC_USUARIO_INSERT(String inCrssc_usuario_insert){
		this.myCrssc_usuario_insert = inCrssc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRSSC_USUARIO_INSERT(){
		return this.myCrssc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrssc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRSSC_USUARIO_UPDATE(String inCrssc_usuario_update){
		this.myCrssc_usuario_update = inCrssc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRSSC_USUARIO_UPDATE(){
		return this.myCrssc_usuario_update;
	}
	/**
	* ESTABLECE EL NOMBRE DE LA ISLA
	* @param inIsla NOMBRE DE LA ISLA
	*/
	public void setISLA(String inIsla){
		this.myIsla = inIsla;
	}
	/**
	* OBTIENE EL NOMBRE DE LA ISLA
	* @return String NOMBRE DE LA ISLA
	*/
	public String getISLA(){
		return this.myIsla;
	}
	/**
	* ESTABLECE EL NOMBRE DEL COMITE
	* @param inComite NOMBRE DEL COMITE
	*/
	public void setCOMITE(String inComite){
		this.myComite = inComite;
	}
	/**
	* OBTIENE EL NOMBRE DEL COMITE
	* @return String NOMBRE DEL COMITE
	*/
	public String getCOMITE(){
		return this.myComite;
	}

}
