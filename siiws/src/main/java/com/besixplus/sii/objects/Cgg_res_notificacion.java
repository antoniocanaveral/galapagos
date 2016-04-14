package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_notificacion
* TABLA: NOTIFICACION
* DESCRIPCION:ALMACENA INFORMACION DE LAS NOTIFICACIONES  O LLAMADOS DE ATENCION APLICADOS  A UNA PERSONA
* ABREVIATURA:CRNOT
*/
public class Cgg_res_notificacion implements Serializable{
	private static final long serialVersionUID = 494150196;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	*/
	private String myCrnot_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	*/
	private String myCrtnt_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	*/
	private String myCgg_cusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	*/
	private String myCrden_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	*/
	private String myCrosg_codigo;
	/**
	* NOMBRE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	*/
	private String myCrosg_nombre_notificacion;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	*/
	private String myCgg_crosg_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	*/
	private String myCrnot_numero_notificacion;
	/**
	* FECHA EN QUE SE REALIZO LA NOTIFICACION
	*/
	private java.util.Date myCrnot_fecha_notificacion;
	/**
	* LUGAR/LOCAL DE LA NOTIFICACION
	*/
	private String myCrnot_lugar_notificacion;
	/**
	* REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	*/
	private String myCrnot_referencia;
	/**
	* OBSERVACION DE LA NOTIFICACION
	*/
	private String myCrnot_observacion;
	/**
	* ESTADO DE LA NOTIFICACION
0 - REGISTRADA
1 - PROCESADA
2 - ANULADA
	*/
	private int myCrnot_estado_notificacion;
	/**
	* ESTADO DEL REGISTRO
REGISTRADA
APLICADA
ANULADA

	*/
	private boolean myCrnot_estado;
	/**
	* DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	*/
	private String myCrnot_regularizacion;
	/**
	* FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	*/
	private java.util.Date myCrnot_fecha_audiencia;
	/**
	* RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	*/
	private String myCrnot_extracto_audiencia;
	/**
	* OBSERVACION REGSITRADA EN AL AUDIENCIA
	*/
	private String myCrnot_observacion_audiencia;
	/**
	* ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	*/
	private boolean myCrnot_procede_notificacion;
	/**
	* DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	private String myCrnot_descripcion_adjunto_aud;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	*/
	private String myCrnot_nombre_adjunto_audiencia;
	/**
	* DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	*/
	private byte[] myCrnot_adjunto_audiencia;
	/**
	* FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	*/
	private java.util.Date myCrnot_fecha_salida_volunt;
	/**
	* FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	*/
	private java.util.Date myCrnot_fecha_expulsion;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrnot_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrnot_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_notificacion
	*/
	public Cgg_res_notificacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_notificacion
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	* @param inCrtnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCusu_codigo IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	* @param inCgg_cusu_codigo IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	* @param inCgg_crosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	* @param inCrnot_numero_notificacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	* @param inCrnot_fecha_notificacion FECHA EN QUE SE REALIZO LA NOTIFICACION
	* @param inCrnot_lugar_notificacion LUGAR/LOCAL DE LA NOTIFICACION
	* @param inCrnot_referencia REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	* @param inCrnot_observacion OBSERVACION DE LA NOTIFICACION
	* @param inCrnot_estado_notificacion ESTADO DE LA NOTIFICACION
0 - REGISTRADA
1 - PROCESADA
2 - ANULADA
	* @param inCrnot_estado ESTADO DEL REGISTRO
REGISTRADA
APLICADA
ANULADA

	* @param inCrnot_regularizacion DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	* @param inCrnot_fecha_audiencia FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	* @param inCrnot_extracto_audiencia RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	* @param inCrnot_observacion_audiencia OBSERVACION REGSITRADA EN AL AUDIENCIA
	* @param inCrnot_procede_notificacion ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	* @param inCrnot_descripcion_adjunto_aud DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCrnot_nombre_adjunto_audiencia NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	* @param inCrnot_adjunto_audiencia DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	* @param inCrnot_fecha_salida_volunt FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	* @param inCrnot_fecha_expulsion FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	* @param inCrnot_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrnot_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_notificacion(
		String inCrnot_codigo,
		String inCrtnt_codigo,
		String inCrper_codigo,
		String inCusu_codigo,
		String inCgg_cusu_codigo,
		String inCrres_codigo,
		String inCrden_codigo,
		String inCctn_codigo,
		String inCrosg_codigo,
		String inCgg_crosg_codigo,
		String inCrnot_numero_notificacion,
		java.util.Date inCrnot_fecha_notificacion,
		String inCrnot_lugar_notificacion,
		String inCrnot_referencia,
		String inCrnot_observacion,
		int inCrnot_estado_notificacion,
		boolean inCrnot_estado,
		String inCrnot_regularizacion,
		java.util.Date inCrnot_fecha_audiencia,
		String inCrnot_extracto_audiencia,
		String inCrnot_observacion_audiencia,
		boolean inCrnot_procede_notificacion,
		String inCrnot_descripcion_adjunto_aud,
		String inCrnot_nombre_adjunto_audiencia,
		byte[] inCrnot_adjunto_audiencia,
		java.util.Date inCrnot_fecha_salida_volunt,
		java.util.Date inCrnot_fecha_expulsion,
		String inCrnot_usuario_insert,
		String inCrnot_usuario_update
	){
		this.setCRNOT_CODIGO(inCrnot_codigo);
		this.setCRTNT_CODIGO(inCrtnt_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCRDEN_CODIGO(inCrden_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCROSG_CODIGO(inCrosg_codigo);
		this.setCGG_CROSG_CODIGO(inCgg_crosg_codigo);
		this.setCRNOT_NUMERO_NOTIFICACION(inCrnot_numero_notificacion);
		this.setCRNOT_FECHA_NOTIFICACION(inCrnot_fecha_notificacion);
		this.setCRNOT_LUGAR_NOTIFICACION(inCrnot_lugar_notificacion);
		this.setCRNOT_REFERENCIA(inCrnot_referencia);
		this.setCRNOT_OBSERVACION(inCrnot_observacion);
		this.setCRNOT_ESTADO_NOTIFICACION(inCrnot_estado_notificacion);
		this.setCRNOT_ESTADO(inCrnot_estado);
		this.setCRNOT_REGULARIZACION(inCrnot_regularizacion);
		this.setCRNOT_FECHA_AUDIENCIA(inCrnot_fecha_audiencia);
		this.setCRNOT_EXTRACTO_AUDIENCIA(inCrnot_extracto_audiencia);
		this.setCRNOT_OBSERVACION_AUDIENCIA(inCrnot_observacion_audiencia);
		this.setCRNOT_PROCEDE_NOTIFICACION(inCrnot_procede_notificacion);
		this.setCRNOT_DESCRIPCION_ADJUNTO_AUD(inCrnot_descripcion_adjunto_aud);
		this.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(inCrnot_nombre_adjunto_audiencia);
		this.setCRNOT_ADJUNTO_AUDIENCIA(inCrnot_adjunto_audiencia);
		this.setCRNOT_FECHA_SALIDA_VOLUNT(inCrnot_fecha_salida_volunt);
		this.setCRNOT_FECHA_EXPULSION(inCrnot_fecha_expulsion);
		this.setCRNOT_USUARIO_INSERT(inCrnot_usuario_insert);
		this.setCRNOT_USUARIO_UPDATE(inCrnot_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	* @param inCrtnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	*/
	public void setCRTNT_CODIGO(String inCrtnt_codigo){
		this.myCrtnt_codigo = inCrtnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	*/
	public String getCRTNT_CODIGO(){
		return this.myCrtnt_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	* @param inCusu_codigo IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	* @return String IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	* @param inCgg_cusu_codigo IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	*/
	public void setCGG_CUSU_CODIGO(String inCgg_cusu_codigo){
		this.myCgg_cusu_codigo = inCgg_cusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	* @return String IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	*/
	public String getCGG_CUSU_CODIGO(){
		return this.myCgg_cusu_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	*/
	public void setCRDEN_CODIGO(String inCrden_codigo){
		this.myCrden_codigo = inCrden_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	*/
	public String getCRDEN_CODIGO(){
		return this.myCrden_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	*/
	public void setCROSG_CODIGO(String inCrosg_codigo){
		this.myCrosg_codigo = inCrosg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	*/
	public String getCROSG_CODIGO(){
		return this.myCrosg_codigo;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	* @param inCrosg_nombre_notificacion IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	*/
	public void setCROSG_NOMBRE_NOTIFICACION(String inCrosg_nombre_notificacion){
		this.myCrosg_nombre_notificacion = inCrosg_nombre_notificacion;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	*/
	public String getCROSG_NOMBRE_NOTIFICACION(){
		return this.myCrosg_nombre_notificacion;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	* @param inCgg_crosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	*/
	public void setCGG_CROSG_CODIGO(String inCgg_crosg_codigo){
		this.myCgg_crosg_codigo = inCgg_crosg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	*/
	public String getCGG_CROSG_CODIGO(){
		return this.myCgg_crosg_codigo;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	* @param inCrnot_numero_notificacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	*/
	public void setCRNOT_NUMERO_NOTIFICACION(String inCrnot_numero_notificacion){
		this.myCrnot_numero_notificacion = inCrnot_numero_notificacion;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	* @return String NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	*/
	public String getCRNOT_NUMERO_NOTIFICACION(){
		return this.myCrnot_numero_notificacion;
	}

	/**
	* ESTABLECE FECHA EN QUE SE REALIZO LA NOTIFICACION
	* @param inCrnot_fecha_notificacion FECHA EN QUE SE REALIZO LA NOTIFICACION
	*/
	public void setCRNOT_FECHA_NOTIFICACION(java.util.Date inCrnot_fecha_notificacion){
		this.myCrnot_fecha_notificacion = inCrnot_fecha_notificacion;
	}
	/**
	* OBTIENE FECHA EN QUE SE REALIZO LA NOTIFICACION
	* @return java.util.Date FECHA EN QUE SE REALIZO LA NOTIFICACION
	*/
	public java.util.Date getCRNOT_FECHA_NOTIFICACION(){
		return this.myCrnot_fecha_notificacion;
	}

	/**
	* ESTABLECE LUGAR/LOCAL DE LA NOTIFICACION
	* @param inCrnot_lugar_notificacion LUGAR/LOCAL DE LA NOTIFICACION
	*/
	public void setCRNOT_LUGAR_NOTIFICACION(String inCrnot_lugar_notificacion){
		this.myCrnot_lugar_notificacion = inCrnot_lugar_notificacion;
	}
	/**
	* OBTIENE LUGAR/LOCAL DE LA NOTIFICACION
	* @return String LUGAR/LOCAL DE LA NOTIFICACION
	*/
	public String getCRNOT_LUGAR_NOTIFICACION(){
		return this.myCrnot_lugar_notificacion;
	}

	/**
	* ESTABLECE REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	* @param inCrnot_referencia REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	*/
	public void setCRNOT_REFERENCIA(String inCrnot_referencia){
		this.myCrnot_referencia = inCrnot_referencia;
	}
	/**
	* OBTIENE REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	* @return String REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	*/
	public String getCRNOT_REFERENCIA(){
		return this.myCrnot_referencia;
	}

	/**
	* ESTABLECE OBSERVACION DE LA NOTIFICACION
	* @param inCrnot_observacion OBSERVACION DE LA NOTIFICACION
	*/
	public void setCRNOT_OBSERVACION(String inCrnot_observacion){
		this.myCrnot_observacion = inCrnot_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA NOTIFICACION
	* @return String OBSERVACION DE LA NOTIFICACION
	*/
	public String getCRNOT_OBSERVACION(){
		return this.myCrnot_observacion;
	}

	/**
	* ESTABLECE ESTADO DE LA NOTIFICACION
	* 0 - REGISTRADA
	* 1 - PROCESADA
	* 2 - ANULADA
	* 3 - EJECUTADA
	* @param inCrnot_estado_notificacion ESTADO DE LA NOTIFICACION
	* 0 - REGISTRADA
	* 1 - PROCESADA
	* 2 - ANULADA
	* 3 - EJECUTADA
	*/
	public void setCRNOT_ESTADO_NOTIFICACION(int inCrnot_estado_notificacion){
		this.myCrnot_estado_notificacion = inCrnot_estado_notificacion;
	}
	/**
	* OBTIENE ESTADO DE LA NOTIFICACION
0 - REGISTRADA
1 - PROCESADA
2 - ANULADA
	* @return int ESTADO DE LA NOTIFICACION
0 - REGISTRADA
1 - PROCESADA
2 - ANULADA
	*/
	public int getCRNOT_ESTADO_NOTIFICACION(){
		return this.myCrnot_estado_notificacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
REGISTRADA
APLICADA
ANULADA

	* @param inCrnot_estado ESTADO DEL REGISTRO
REGISTRADA
APLICADA
ANULADA

	*/
	public void setCRNOT_ESTADO(boolean inCrnot_estado){
		this.myCrnot_estado = inCrnot_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
REGISTRADA
APLICADA
ANULADA

	* @return boolean ESTADO DEL REGISTRO
REGISTRADA
APLICADA
ANULADA

	*/
	public boolean getCRNOT_ESTADO(){
		return this.myCrnot_estado;
	}

	/**
	* ESTABLECE DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	* @param inCrnot_regularizacion DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	*/
	public void setCRNOT_REGULARIZACION(String inCrnot_regularizacion){
		this.myCrnot_regularizacion = inCrnot_regularizacion;
	}
	/**
	* OBTIENE DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	* @return String DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	*/
	public String getCRNOT_REGULARIZACION(){
		return this.myCrnot_regularizacion;
	}

	/**
	* ESTABLECE FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	* @param inCrnot_fecha_audiencia FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	*/
	public void setCRNOT_FECHA_AUDIENCIA(java.util.Date inCrnot_fecha_audiencia){
		this.myCrnot_fecha_audiencia = inCrnot_fecha_audiencia;
	}
	/**
	* OBTIENE FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	* @return java.util.Date FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	*/
	public java.util.Date getCRNOT_FECHA_AUDIENCIA(){
		return this.myCrnot_fecha_audiencia;
	}

	/**
	* ESTABLECE RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	* @param inCrnot_extracto_audiencia RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	*/
	public void setCRNOT_EXTRACTO_AUDIENCIA(String inCrnot_extracto_audiencia){
		this.myCrnot_extracto_audiencia = inCrnot_extracto_audiencia;
	}
	/**
	* OBTIENE RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	* @return String RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	*/
	public String getCRNOT_EXTRACTO_AUDIENCIA(){
		return this.myCrnot_extracto_audiencia;
	}

	/**
	* ESTABLECE OBSERVACION REGSITRADA EN AL AUDIENCIA
	* @param inCrnot_observacion_audiencia OBSERVACION REGSITRADA EN AL AUDIENCIA
	*/
	public void setCRNOT_OBSERVACION_AUDIENCIA(String inCrnot_observacion_audiencia){
		this.myCrnot_observacion_audiencia = inCrnot_observacion_audiencia;
	}
	/**
	* OBTIENE OBSERVACION REGSITRADA EN AL AUDIENCIA
	* @return String OBSERVACION REGSITRADA EN AL AUDIENCIA
	*/
	public String getCRNOT_OBSERVACION_AUDIENCIA(){
		return this.myCrnot_observacion_audiencia;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	* @param inCrnot_procede_notificacion ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	*/
	public void setCRNOT_PROCEDE_NOTIFICACION(boolean inCrnot_procede_notificacion){
		this.myCrnot_procede_notificacion = inCrnot_procede_notificacion;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	* @return boolean ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	*/
	public boolean getCRNOT_PROCEDE_NOTIFICACION(){
		return this.myCrnot_procede_notificacion;
	}

	/**
	* ESTABLECE DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCrnot_descripcion_adjunto_aud DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	public void setCRNOT_DESCRIPCION_ADJUNTO_AUD(String inCrnot_descripcion_adjunto_aud){
		this.myCrnot_descripcion_adjunto_aud = inCrnot_descripcion_adjunto_aud;
	}
	/**
	* OBTIENE DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @return String DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	public String getCRNOT_DESCRIPCION_ADJUNTO_AUD(){
		return this.myCrnot_descripcion_adjunto_aud;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	* @param inCrnot_nombre_adjunto_audiencia NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	*/
	public void setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(String inCrnot_nombre_adjunto_audiencia){
		this.myCrnot_nombre_adjunto_audiencia = inCrnot_nombre_adjunto_audiencia;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	*/
	public String getCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(){
		return this.myCrnot_nombre_adjunto_audiencia;
	}

	/**
	* ESTABLECE DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	* @param inCrnot_adjunto_audiencia DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	*/
	public void setCRNOT_ADJUNTO_AUDIENCIA(byte[] inCrnot_adjunto_audiencia){
		this.myCrnot_adjunto_audiencia = inCrnot_adjunto_audiencia;
	}
	/**
	* OBTIENE DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	* @return byte[] DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	*/
	public byte[] getCRNOT_ADJUNTO_AUDIENCIA(){
		return this.myCrnot_adjunto_audiencia;
	}

	/**
	* ESTABLECE FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	* @param inCrnot_fecha_salida_volunt FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	*/
	public void setCRNOT_FECHA_SALIDA_VOLUNT(java.util.Date inCrnot_fecha_salida_volunt){
		this.myCrnot_fecha_salida_volunt = inCrnot_fecha_salida_volunt;
	}
	/**
	* OBTIENE FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	* @return java.util.Date FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	*/
	public java.util.Date getCRNOT_FECHA_SALIDA_VOLUNT(){
		return this.myCrnot_fecha_salida_volunt;
	}

	/**
	* ESTABLECE FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	* @param inCrnot_fecha_expulsion FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	*/
	public void setCRNOT_FECHA_EXPULSION(java.util.Date inCrnot_fecha_expulsion){
		this.myCrnot_fecha_expulsion = inCrnot_fecha_expulsion;
	}
	/**
	* OBTIENE FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	* @return java.util.Date FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	*/
	public java.util.Date getCRNOT_FECHA_EXPULSION(){
		return this.myCrnot_fecha_expulsion;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrnot_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRNOT_USUARIO_INSERT(String inCrnot_usuario_insert){
		this.myCrnot_usuario_insert = inCrnot_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRNOT_USUARIO_INSERT(){
		return this.myCrnot_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrnot_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRNOT_USUARIO_UPDATE(String inCrnot_usuario_update){
		this.myCrnot_usuario_update = inCrnot_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRNOT_USUARIO_UPDATE(){
		return this.myCrnot_usuario_update;
	}


}
