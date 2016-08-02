package com.besixplus.sii.objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* CLASE Cgg_res_tramite
* TABLA: TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS PROCESOS DE RESIDENCIA 
* ABREVIATURA:CRTRA
*/
public class Cgg_res_tramite implements Serializable{
	private static final long serialVersionUID = 497939599;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	private String myCrtra_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	*/
	private String myCgg_crper_codigo;

	/*AC Campo para Representante en Temporales*/
	private String myRep_crper_codigo;

	/*AC Campo para Cambio de Motivo*/
	private String myChange_crtst_codigo;

	/*AC Campo para Tipo Residencia*/
	private String myCrtt_codigo;

	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	private String myCrpro_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	private String myCvveh_codigo=null;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	*/
	private String myCrett_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	*/
	private String myCisla_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	private String myCvmtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR REEMPLAZADO
	*/
	private String myCgg_cvmtr_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO REEMPLAZADO
	*/
	private String myCgg_cvveh_codigo;
	/**
	* ANIO DE REALIZACION DEL TRAMITE
	*/
	private java.math.BigDecimal myCrtra_anio;
	/**
	* NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	*/
	private java.math.BigDecimal myCrtra_numero;
	/**
	* FECHA DE RECEPCION DEL TRAMITE
	*/
	private java.util.Date myCrtra_fecha_recepcion;
	/**
	* ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	*/
	private String myCrtra_actividad_residencia;
	/**
	* OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	*/
	private String myCrtra_observacion;
	/**
	* NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	*/
	private int myCrtra_dias_permanencia;
	/**
	* DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-OTRO TIPO DE ESTADO
	*/
	private int myCrtra_pendiente;
	/**
	* JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	*/
	private String myCrtra_observacion_pendiente;
	/**
	* SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	*/
	private boolean myCrtra_atencion_cliente;
	/**
	* NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	*/
	private String myCrtra_comunicado_radial;
	/**
	* NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	*/
	private String myCrtra_motivo;
	/**
	* NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	*/
	private java.math.BigDecimal myCrtra_folio;
	/**
	* DETERMINA SI EL TRAMITE PERTENECE A UN GRUPO

	*/
	private boolean myCrtra_grupo;
	/**
	* DETERMINA EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	*/
	private BigDecimal myCrtra_orden;
	/**
	* FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	*/
	private Date myCrtra_fecha_ingreso;
	/**
	* FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	*/
	private Date myCrtra_fecha_salida;
	/**
	* INDICA SI EL TRAMITE ES UNA RECALIFICACION
	*/
	private boolean myCrtra_recalificacion;
	/**
	* ESTADO DEL REGISTRO FINALIZADO O NO
	*/
	private boolean myCrtra_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtra_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtra_usuario_update;
	
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite
	*/
	public Cgg_res_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR REEMPLAZADO
	* @param inCgg_cvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO REEMPLAZADO
	* @param inCrtra_anio ANIO DE REALIZACION DEL TRAMITE
	* @param inCrtra_numero NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	* @param inCrtra_fecha_recepcion FECHA DE RECEPCION DEL TRAMITE
	* @param inCrtra_actividad_residencia ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	* @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	* @param inCrtra_dias_permanencia NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	* @param inCrtra_pendiente DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO
	* @param inCrtra_observacion_pendiente JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	* @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	* @param inCrtra_comunicado_radial NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	* @param inCrtra_motivo NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	* @param inCrtra_folio NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	* @param inCrtra_grupo DETERMINA SI EL TRAMITE PERTENECE A UN GRUPO
	* @param inCrtra_orden DETERMINA EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	* @param inCrtra_fecha_ingreso FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	* @param inCrtra_fecha_salida FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	* @param inCrtra_recalificacion INDICA SI EL TRAMITE ES UNA RECALIFICACION
	* @param inCrtra_estado ESTADO DEL REGISTRO FINALIZADO O NO
	* @param inCrtra_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtra_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tramite(
		String inCrtra_codigo,
		String inCrper_codigo,
		String inCrpjr_codigo,
		String inCgg_crper_codigo,
		String inCrpro_codigo,
		String inCrtst_codigo,
		String inCvveh_codigo,
		String inCrett_codigo,
		String inCisla_codigo,
		String inCvmtr_codigo,
		String inCgg_cvmtr_codigo,
		String inCgg_cvveh_codigo,
		java.math.BigDecimal inCrtra_anio,
		java.math.BigDecimal inCrtra_numero,
		java.util.Date inCrtra_fecha_recepcion,
		String inCrtra_actividad_residencia,
		String inCrtra_observacion,
		int inCrtra_dias_permanencia,
		int inCrtra_pendiente,
		String inCrtra_observacion_pendiente,
		boolean inCrtra_atencion_cliente,
		String inCrtra_comunicado_radial,
		String inCrtra_motivo,
		java.math.BigDecimal inCrtra_folio,
		boolean inCrtra_grupo,
		java.math.BigDecimal inCrtra_orden,
		java.util.Date inCrtra_fecha_ingreso,
		java.util.Date inCrtra_fecha_salida,
		boolean inCrtra_recalificacion,
		boolean inCrtra_estado,
		String inCrtra_usuario_insert,
		String inCrtra_usuario_update
	){
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		this.setCRPRO_CODIGO(inCrpro_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCVVEH_CODIGO(inCvveh_codigo);
		this.setCRETT_CODIGO(inCrett_codigo);
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCVMTR_CODIGO(inCvmtr_codigo);
		this.setCGG_CVMTR_CODIGO(inCgg_cvmtr_codigo);
		this.setCGG_CVVEH_CODIGO(inCgg_cvveh_codigo);
		this.setCRTRA_ANIO(inCrtra_anio);
		this.setCRTRA_NUMERO(inCrtra_numero);
		this.setCRTRA_FECHA_RECEPCION(inCrtra_fecha_recepcion);
		this.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
		this.setCRTRA_OBSERVACION(inCrtra_observacion);
		this.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);
		this.setCRTRA_PENDIENTE(inCrtra_pendiente);
		this.setCRTRA_OBSERVACION_PENDIENTE(inCrtra_observacion_pendiente);
		this.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
		this.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
		this.setCRTRA_MOTIVO(inCrtra_motivo);
		this.setCRTRA_FOLIO(inCrtra_folio);
		this.setCRTRA_GRUPO(inCrtra_grupo);
		this.setCRTRA_ORDEN(inCrtra_orden);
		this.setCRTRA_FECHA_INGRESO(inCrtra_fecha_ingreso);
		this.setCRTRA_FECHA_SALIDA(inCrtra_fecha_salida);
		this.setCRTRA_RECALIFICACION(inCrtra_recalificacion);
		this.setCRTRA_ESTADO(inCrtra_estado);
		this.setCRTRA_USUARIO_INSERT(inCrtra_usuario_insert);
		this.setCRTRA_USUARIO_UPDATE(inCrtra_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	*/
	public void setCGG_CRPER_CODIGO(String inCgg_crper_codigo){
		this.myCgg_crper_codigo = inCgg_crper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	*/
	public String getCGG_CRPER_CODIGO(){
		return this.myCgg_crper_codigo;
	}

	public String getREP_CRPER_CODIGO() {
		return myRep_crper_codigo;
	}

	public String getCHANGE_CRTST_CODIGO() {
		return myChange_crtst_codigo;
	}

	public void setCHANGE_CRTST_CODIGO(String myChange_crtst_codigo) {
		this.myChange_crtst_codigo = myChange_crtst_codigo;
	}

	public void setREP_CRPER_CODIGO(String myRep_crper_codigo) {
		this.myRep_crper_codigo = myRep_crper_codigo;
	}

	public String getCRTT_CODIGO() {
		return myCrtt_codigo;
	}

	public void setCRTT_CODIGO(String myCrtt_codigo) {
		this.myCrtt_codigo = myCrtt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	public void setCRPRO_CODIGO(String inCrpro_codigo){
		this.myCrpro_codigo = inCrpro_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	public String getCRPRO_CODIGO(){
		return this.myCrpro_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	* @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	*/
	public void setCRETT_CODIGO(String inCrett_codigo){
		this.myCrett_codigo = inCrett_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	*/
	public String getCRETT_CODIGO(){
		return this.myCrett_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	public void setCVMTR_CODIGO(String inCvmtr_codigo){
		this.myCvmtr_codigo = inCvmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	public String getCVMTR_CODIGO(){
		return this.myCvmtr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR REEMPLAZADO
	* @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR REEMPLAZADO
	*/
	public void setCGG_CVMTR_CODIGO(String inCgg_cvmtr_codigo){
		this.myCgg_cvmtr_codigo = inCgg_cvmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR REEMPLAZADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR REEMPLAZADO
	*/
	public String getCGG_CVMTR_CODIGO(){
		return this.myCgg_cvmtr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO REEMPLAZADO
	* @param inCgg_cvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO REEMPLAZADO
	*/
	public void setCGG_CVVEH_CODIGO(String inCgg_cvveh_codigo){
		this.myCgg_cvveh_codigo = inCgg_cvveh_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO REEMPLAZADO
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO REEMPLAZADO
	*/
	public String getCGG_CVVEH_CODIGO(){
		return this.myCgg_cvveh_codigo;
	}
	
	/**
	* ESTABLECE ANIO DE REALIZACION DEL TRAMITE
	* @param inCrtra_anio ANIO DE REALIZACION DEL TRAMITE
	*/
	public void setCRTRA_ANIO(java.math.BigDecimal inCrtra_anio){
		this.myCrtra_anio = inCrtra_anio;
	}
	/**
	* OBTIENE ANIO DE REALIZACION DEL TRAMITE
	* @return java.math.BigDecimal ANIO DE REALIZACION DEL TRAMITE
	*/
	public java.math.BigDecimal getCRTRA_ANIO(){
		return this.myCrtra_anio;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	* @param inCrtra_numero NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	*/
	public void setCRTRA_NUMERO(java.math.BigDecimal inCrtra_numero){
		this.myCrtra_numero = inCrtra_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	* @return java.math.BigDecimal NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	*/
	public java.math.BigDecimal getCRTRA_NUMERO(){
		return this.myCrtra_numero;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DEL TRAMITE
	* @param inCrtra_fecha_recepcion FECHA DE RECEPCION DEL TRAMITE
	*/
	public void setCRTRA_FECHA_RECEPCION(java.util.Date inCrtra_fecha_recepcion){
		this.myCrtra_fecha_recepcion = inCrtra_fecha_recepcion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DEL TRAMITE
	* @return java.util.Date FECHA DE RECEPCION DEL TRAMITE
	*/
	public java.util.Date getCRTRA_FECHA_RECEPCION(){
		return this.myCrtra_fecha_recepcion;
	}

	/**
	* ESTABLECE ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	* @param inCrtra_actividad_residencia ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	*/
	public void setCRTRA_ACTIVIDAD_RESIDENCIA(String inCrtra_actividad_residencia){
		this.myCrtra_actividad_residencia = inCrtra_actividad_residencia;
	}
	/**
	* OBTIENE ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	* @return String ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	*/
	public String getCRTRA_ACTIVIDAD_RESIDENCIA(){
		return this.myCrtra_actividad_residencia;
	}

	/**
	* ESTABLECE OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	* @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	*/
	public void setCRTRA_OBSERVACION(String inCrtra_observacion){
		this.myCrtra_observacion = inCrtra_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	* @return String OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	*/
	public String getCRTRA_OBSERVACION(){
		return this.myCrtra_observacion;
	}

	/**
	* ESTABLECE NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	* @param inCrtra_dias_permanencia NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	*/
	public void setCRTRA_DIAS_PERMANENCIA(int inCrtra_dias_permanencia){
		this.myCrtra_dias_permanencia = inCrtra_dias_permanencia;
	}
	/**
	* OBTIENE NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	* @return int NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	*/
	public int getCRTRA_DIAS_PERMANENCIA(){
		return this.myCrtra_dias_permanencia;
	}

	/**
	* ESTABLECE DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO
	* @param inCrtra_pendiente DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO
	*/
	public void setCRTRA_PENDIENTE(int inCrtra_pendiente){
		this.myCrtra_pendiente = inCrtra_pendiente;
	}
	/**
	* OBTIENE DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO
	* @return int DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO
	*/
	public int getCRTRA_PENDIENTE(){
		return this.myCrtra_pendiente;
	}

	/**
	* ESTABLECE JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	* @param inCrtra_observacion_pendiente JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	*/
	public void setCRTRA_OBSERVACION_PENDIENTE(String inCrtra_observacion_pendiente){
		this.myCrtra_observacion_pendiente = inCrtra_observacion_pendiente;
	}
	/**
	* OBTIENE JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	* @return String JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	*/
	public String getCRTRA_OBSERVACION_PENDIENTE(){
		return this.myCrtra_observacion_pendiente;
	}

	/**
	* ESTABLECE SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	* @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	*/
	public void setCRTRA_ATENCION_CLIENTE(boolean inCrtra_atencion_cliente){
		this.myCrtra_atencion_cliente = inCrtra_atencion_cliente;
	}
	/**
	* OBTIENE SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	* @return boolean SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	*/
	public boolean getCRTRA_ATENCION_CLIENTE(){
		return this.myCrtra_atencion_cliente;
	}

	/**
	* ESTABLECE NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	* @param inCrtra_comunicado_radial NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	*/
	public void setCRTRA_COMUNICADO_RADIAL(String inCrtra_comunicado_radial){
		this.myCrtra_comunicado_radial = inCrtra_comunicado_radial;
	}
	/**
	* OBTIENE NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	* @return String NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	*/
	public String getCRTRA_COMUNICADO_RADIAL(){
		return this.myCrtra_comunicado_radial;
	}

	/**
	* ESTABLECE NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	* @param inCrtra_motivo NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	*/
	public void setCRTRA_MOTIVO(String inCrtra_motivo){
		this.myCrtra_motivo = inCrtra_motivo;
	}
	/**
	* OBTIENE NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	* @return String NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	*/
	public String getCRTRA_MOTIVO(){
		return this.myCrtra_motivo;
	}

	/**
	* ESTABLECE NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	* @param inCrtra_folio NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	*/
	public void setCRTRA_FOLIO(java.math.BigDecimal inCrtra_folio){
		this.myCrtra_folio = inCrtra_folio;
	}
	/**
	* OBTIENE NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	* @return java.math.BigDecimal NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	*/
	public java.math.BigDecimal getCRTRA_FOLIO(){
		return this.myCrtra_folio;
	}

	/**
	* ESTABLECE SI EL TRAMITE PERTENECE A UN GRUPO
	* @param inCrtra_grupo DETERMINA SI EL TRAMITE PERTENECE A UN GRUPO
	*/
	public void setCRTRA_GRUPO(boolean inCrtra_grupo){
		this.myCrtra_grupo = inCrtra_grupo;
	}
	/**
	* OBTIENE SI EL TRAMITE PERTENECE A UN GRUPO
	* @return boolean DETERMINA SI EL TRAMITE PERTENECE A UN GRUPO
	*/
	public boolean getCRTRA_GRUPO(){
		return this.myCrtra_grupo;
	}

	/**
	* ESTABLECE  EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	* @param inCrtra_orden DETERMINA EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	*/
	public void setCRTRA_ORDEN(java.math.BigDecimal inCrtra_orden){
		this.myCrtra_orden = inCrtra_orden;
	}
	/**
	* OBTIENE  EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	* @return java.math.BigDecimal DETERMINA EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	*/
	public java.math.BigDecimal getCRTRA_ORDEN(){
		return this.myCrtra_orden;
	}

	/**
	* ESTABLECE FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	* @param inCrtra_fecha_ingreso FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	*/
	public void setCRTRA_FECHA_INGRESO(java.util.Date inCrtra_fecha_ingreso){
		this.myCrtra_fecha_ingreso = inCrtra_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	* @return java.util.Date FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	*/
	public java.util.Date getCRTRA_FECHA_INGRESO(){
		return this.myCrtra_fecha_ingreso;
	}

	/**
	* ESTABLECE FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	* @param inCrtra_fecha_salida FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	*/
	public void setCRTRA_FECHA_SALIDA(java.util.Date inCrtra_fecha_salida){
		this.myCrtra_fecha_salida = inCrtra_fecha_salida;
	}
	/**
	* OBTIENE FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	* @return java.util.Date FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	*/
	public java.util.Date getCRTRA_FECHA_SALIDA(){
		return this.myCrtra_fecha_salida;
	}

	/**
	* ESTABLECE INDICA SI EL TRAMITE ES UNA RECALIFICACION
	* @param inCrtra_recalificacion INDICA SI EL TRAMITE ES UNA RECALIFICACION
	*/
	public void setCRTRA_RECALIFICACION(boolean inCrtra_recalificacion){
		this.myCrtra_recalificacion = inCrtra_recalificacion;
	}
	/**
	* OBTIENE INDICA SI EL TRAMITE ES UNA RECALIFICACION
	* @return boolean INDICA SI EL TRAMITE ES UNA RECALIFICACION
	*/
	public boolean getCRTRA_RECALIFICACION(){
		return this.myCrtra_recalificacion;
	}
	
	/**
	* ESTABLECE ESTADO DEL REGISTRO FINALIZADO O NO

	* @param inCrtra_estado ESTADO DEL REGISTRO FINALIZADO O NO

	*/
	public void setCRTRA_ESTADO(boolean inCrtra_estado){
		this.myCrtra_estado = inCrtra_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO FINALIZADO O NO

	* @return boolean ESTADO DEL REGISTRO FINALIZADO O NO

	*/
	public boolean getCRTRA_ESTADO(){
		return this.myCrtra_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtra_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTRA_USUARIO_INSERT(String inCrtra_usuario_insert){
		this.myCrtra_usuario_insert = inCrtra_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTRA_USUARIO_INSERT(){
		return this.myCrtra_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtra_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTRA_USUARIO_UPDATE(String inCrtra_usuario_update){
		this.myCrtra_usuario_update = inCrtra_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTRA_USUARIO_UPDATE(){
		return this.myCrtra_usuario_update;
	}

}
