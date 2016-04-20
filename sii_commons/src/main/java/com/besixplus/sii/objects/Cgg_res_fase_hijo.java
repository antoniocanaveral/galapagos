package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_fase
* TABLA: FASE
* DESCRIPCION:ALMACENA INFORMACION DE LAS FASES EN LAS QUE PUEDE ORGANIZARSE UN PROCESO
* ABREVIATURA:CRFAS
*/
public class Cgg_res_fase_hijo implements Serializable{
	private static final long serialVersionUID = 1608074587;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	private String myCrfas_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	private String myCrpro_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	*/
	private String myCrett_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	*/
	private String myCgg_crett_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SECCION
	*/
	private String myCrsec_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	private String myCgg_crfas_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	*/
	private String myCgg_cusu_codigo;
	/**
	* INFORMACION DE IDENTIFICACION DE LA FASE
	*/
	private String myCrfas_nombre;
	/**
	* ORDEN DE EJECUCION DE LA FASE
	*/
	private int myCrfas_orden;
	/**
	* TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	*/
	private String myCrfas_tarea_realiza;
	/**
	* NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	*/
	private String myCrfas_funcion_ejecuta;
	/**
	* ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	*/
	private boolean myCrfas_sube_adjunto;
	/**
	* ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	*/
	private boolean myCrfas_sube_adjunto_requisito;
	/**
	* ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	*/
	private boolean myCrfas_ejecuta_despacho;
	/**
	* ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	*/
	private boolean myCrfas_atencion_normal;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrfas_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrfas_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrfas_usuario_update;
	
	/**
	 * TEXTO DE SUMILLA PARA LA FASE.
	 */
	private String crfas_sumilla="";
	
	/**
	 * CODIGO DE USUARIO ENCARGADO ORIGINALMENTE DE LA FASE.
	 */
	private String cusu_codigo = "";
	
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase
	*/
	public Cgg_res_fase_hijo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_fase
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	* @param inCgg_crett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	* @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	* @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	* @param inCrfas_nombre INFORMACION DE IDENTIFICACION DE LA FASE
	* @param inCrfas_orden ORDEN DE EJECUCION DE LA FASE
	* @param inCrfas_tarea_realiza TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	* @param inCrfas_funcion_ejecuta NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	* @param inCrfas_sube_adjunto ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	* @param inCrfas_sube_adjunto_requisito ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	* @param inCrfas_estado ESTADO DEL REGISTRO
	* @param inCrfas_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrfas_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	 * @param inCrfas_sumilla 
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public Cgg_res_fase_hijo(
		String inCrfas_codigo,
		String inCrpro_codigo,
		String inCrett_codigo,
		String inCgg_crett_codigo,
		String inCrsec_codigo,
		String inCgg_crfas_codigo,
		String inCgg_cusu_codigo,
		String inCrfas_nombre,
		int inCrfas_orden,
		String inCrfas_tarea_realiza,
		String inCrfas_funcion_ejecuta,
		boolean inCrfas_sube_adjunto,
		boolean inCrfas_sube_adjunto_requisito,
		boolean inCrfas_estado,
		String inCrfas_usuario_insert,
		String inCrfas_usuario_update,
		String inCrfas_sumilla,
		String inCusu_codigo
	){
		this.setCRFAS_CODIGO(inCrfas_codigo);
		this.setCRPRO_CODIGO(inCrpro_codigo);
		this.setCRETT_CODIGO(inCrett_codigo);
		this.setCGG_CRETT_CODIGO(inCgg_crett_codigo);
		this.setCRSEC_CODIGO(inCrsec_codigo);
		this.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		this.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		this.setCRFAS_NOMBRE(inCrfas_nombre);
		this.setCRFAS_ORDEN(inCrfas_orden);
		this.setCRFAS_TAREA_REALIZA(inCrfas_tarea_realiza);
		this.setCRFAS_FUNCION_EJECUTA(inCrfas_funcion_ejecuta);
		this.setCRFAS_SUBE_ADJUNTO(inCrfas_sube_adjunto);
		this.setCRFAS_SUBE_ADJUNTO_REQUISITO(inCrfas_sube_adjunto_requisito);
		this.setCRFAS_ESTADO(inCrfas_estado);
		this.setCRFAS_USUARIO_INSERT(inCrfas_usuario_insert);
		this.setCRFAS_USUARIO_UPDATE(inCrfas_usuario_update);		
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	public void setCRFAS_CODIGO(String inCrfas_codigo){
		this.myCrfas_codigo = inCrfas_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	public String getCRFAS_CODIGO(){
		return this.myCrfas_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	* @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	*/
	public void setCRETT_CODIGO(String inCrett_codigo){
		this.myCrett_codigo = inCrett_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	*/
	public String getCRETT_CODIGO(){
		return this.myCrett_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	* @param inCgg_crett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	*/
	public void setCGG_CRETT_CODIGO(String inCgg_crett_codigo){
		this.myCgg_crett_codigo = inCgg_crett_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	*/
	public String getCGG_CRETT_CODIGO(){
		return this.myCgg_crett_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	public void setCGG_CRFAS_CODIGO(String inCgg_crfas_codigo){
		this.myCgg_crfas_codigo = inCgg_crfas_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	*/
	public String getCGG_CRFAS_CODIGO(){
		return this.myCgg_crfas_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	*/
	public void setCGG_CUSU_CODIGO(String inCgg_cusu_codigo){
		this.myCgg_cusu_codigo = inCgg_cusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	*/
	public String getCGG_CUSU_CODIGO(){
		return this.myCgg_cusu_codigo;
	}

	/**
	* ESTABLECE INFORMACION DE IDENTIFICACION DE LA FASE
	* @param inCrfas_nombre INFORMACION DE IDENTIFICACION DE LA FASE
	*/
	public void setCRFAS_NOMBRE(String inCrfas_nombre){
		this.myCrfas_nombre = inCrfas_nombre;
	}
	/**
	* OBTIENE INFORMACION DE IDENTIFICACION DE LA FASE
	* @return String INFORMACION DE IDENTIFICACION DE LA FASE
	*/
	public String getCRFAS_NOMBRE(){
		return this.myCrfas_nombre;
	}

	/**
	* ESTABLECE ORDEN DE EJECUCION DE LA FASE
	* @param inCrfas_orden ORDEN DE EJECUCION DE LA FASE
	*/
	public void setCRFAS_ORDEN(int inCrfas_orden){
		this.myCrfas_orden = inCrfas_orden;
	}
	/**
	* OBTIENE ORDEN DE EJECUCION DE LA FASE
	* @return int ORDEN DE EJECUCION DE LA FASE
	*/
	public int getCRFAS_ORDEN(){
		return this.myCrfas_orden;
	}

	/**
	* ESTABLECE TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	* @param inCrfas_tarea_realiza TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	*/
	public void setCRFAS_TAREA_REALIZA(String inCrfas_tarea_realiza){
		this.myCrfas_tarea_realiza = inCrfas_tarea_realiza;
	}
	/**
	* OBTIENE TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	* @return String TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	*/
	public String getCRFAS_TAREA_REALIZA(){
		return this.myCrfas_tarea_realiza;
	}
	/**
	* ESTABLECE NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	* @param inCrfas_funcion_ejecuta NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	*/
	public void setCRFAS_FUNCION_EJECUTA(String inCrfas_funcion_ejecuta){
		this.myCrfas_funcion_ejecuta = inCrfas_funcion_ejecuta;
	}
	/**
	* OBTIENE NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	* @return String NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	*/
	public String getCRFAS_FUNCION_EJECUTA(){
		return this.myCrfas_funcion_ejecuta;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	* @param inCrfas_sube_adjunto ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	*/
	public void setCRFAS_SUBE_ADJUNTO(boolean inCrfas_sube_adjunto){
		this.myCrfas_sube_adjunto = inCrfas_sube_adjunto;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	* @return boolean ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	*/
	public boolean getCRFAS_SUBE_ADJUNTO(){
		return this.myCrfas_sube_adjunto;
	}
	
	/**
	* ESTABLECE ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	* @param inCrfas_sube_adjunto_requisito ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	*/
	public void setCRFAS_SUBE_ADJUNTO_REQUISITO(boolean inCrfas_sube_adjunto_requisito){
		this.myCrfas_sube_adjunto_requisito = inCrfas_sube_adjunto_requisito;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	* @return boolean ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	*/
	public boolean getCRFAS_SUBE_ADJUNTO_REQUISITO(){
		return this.myCrfas_sube_adjunto_requisito;
	}
	
	/**
	* ESTABLECE ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	* @param inCrfas_ejecuta_despacho ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	*/
	public void setCRFAS_EJECUTA_DESPACHO(boolean inCrfas_ejecuta_despacho){
		this.myCrfas_ejecuta_despacho = inCrfas_ejecuta_despacho;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	* @return boolean ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	*/
	public boolean getCRFAS_EJECUTA_DESPACHO(){
		return this.myCrfas_ejecuta_despacho;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	* @param inCrfas_atencion_normal ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	*/
	public void setCRFAS_ATENCION_NORMAL(boolean inCrfas_atencion_normal){
		this.myCrfas_atencion_normal = inCrfas_atencion_normal;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	* @return boolean ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	*/
	public boolean getCRFAS_ATENCION_NORMAL(){
		return this.myCrfas_atencion_normal;
	}
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrfas_estado ESTADO DEL REGISTRO
	*/
	public void setCRFAS_ESTADO(boolean inCrfas_estado){
		this.myCrfas_estado = inCrfas_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRFAS_ESTADO(){
		return this.myCrfas_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrfas_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRFAS_USUARIO_INSERT(String inCrfas_usuario_insert){
		this.myCrfas_usuario_insert = inCrfas_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRFAS_USUARIO_INSERT(){
		return this.myCrfas_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrfas_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRFAS_USUARIO_UPDATE(String inCrfas_usuario_update){
		this.myCrfas_usuario_update = inCrfas_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRFAS_USUARIO_UPDATE(){
		return this.myCrfas_usuario_update;
	}
	
	/**
	 * OBTIENE DESCRIPCION DE UN COMENTARIO	
	 * @return DESCRIPCION DE UN COMENTARIO 
	 */
	public String getCRFAS_SUMILLA() {
		return crfas_sumilla;
	}
	/**
	 * ESTABLECE UNA DESCRIPCION DE UN COMENTARIO
	 * @param crfas_sumilla DESCRIPCION DE UN COMNENTARIO
	 */
	public void setCRFAS_SUMILLA(String crfas_sumilla) {
		this.crfas_sumilla = crfas_sumilla;
	}
	/**
	 * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @return String cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 */
	public String getCUSU_CODIGO() {
		return cusu_codigo;
	}
	/**
	 * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @param cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 */
	public void setCUSU_CODIGO(String cusu_codigo) {
		this.cusu_codigo = cusu_codigo;
	}
		
}
