package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_registro
* TABLA: REGISTRO
* DESCRIPCION:ALMACENA INFORMACION DE LOS REGISTROS PARA LA OBTENCION DE LAS TARJETAS DE CONTROL DE TRANSITO
* ABREVIATURA:CTREG
*/
public class Cgg_tct_registro implements Serializable{
	private static final long serialVersionUID = 1094943198;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	private String myCtreg_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	*/
	private String myCtgtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	*/
	private String myCgg_cusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	*/
	private String myCarpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	*/
	private String myCgg_carpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	*/
	private String myCraln_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	*/
	private String myCrtra_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	*/
	private int myCtreg_numero;
	/**
	* FECHA DE RESERVA DEL TCT O PREREGISTRO
	*/
	private java.util.Date myCtreg_fecha_preregistro;
	/**
	* FECHA DE INGRESO  A LA PROVINCIA POR TCT
	*/
	private java.util.Date myCtreg_fecha_ingreso;
	/**
	* CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	*/
	private String myCtreg_codigo_barras;
	/**
	* FECHA DE SALIDA DE LA PROVINCIA
	*/
	private java.util.Date myCtreg_fecha_salida;
	/**
	* FECHA DE IMPRESION DE LA ESPECIE DE TCT
	*/
	private java.util.Date myCtreg_impresion_especie;
	/**
	* ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	*/
	private int myCtreg_estado_registro;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCtreg_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtreg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtreg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtreg_usuario_update;
	
	private String myCtreg_ctreg_categoria; 
	private String myCtreg_ctreg_tipo_registro; 
	private String myCtreg_ctreg_numero_vuelo; 
	private String myCtreg_ctreg_tipo_hospedaje; 
	private String myCtreg_ctreg_isla_hospedaje; 
	private String myCtreg_ctreg_nombre_hospedaje_crucero; 
	private String myCtreg_ctreg_nombre_hospedaje_hotel; 
	private String myCtreg_ctreg_lugar_hospedaje;
	private String myCtreg_ctreg_viaje_acompanante; 
	private String myCtreg_ctreg_viaje_motivo; 
	private String myCtreg_ctreg_viaje_actividades; 
	private String myCtreg_ctreg_viaje_num_miembros;
	private String myCtreg_ctreg_viaje_tour; 
	private String myCtreg_ctreg_viaje_cual;

	
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro
	*/
	public Cgg_tct_registro(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_registro
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	* @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	* @param inCtreg_numero NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	* @param inCtreg_fecha_preregistro FECHA DE RESERVA DEL TCT O PREREGISTRO
	* @param inCtreg_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA POR TCT
	* @param inCtreg_codigo_barras CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	* @param inCtreg_fecha_salida FECHA DE SALIDA DE LA PROVINCIA
	* @param inCtreg_impresion_especie FECHA DE IMPRESION DE LA ESPECIE DE TCT
	* @param inCtreg_estado_registro ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	* @param inCtreg_observacion INFORMACION ADICIONAL
	* @param inCtreg_estado ESTADO DEL REGISTRO
	* @param inCtreg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtreg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_registro(
		String inCtreg_codigo,
		String inCrper_codigo,
		String inCtgtr_codigo,
		String inCusu_codigo,
		String inCgg_cusu_codigo,
		String inCarpt_codigo,
		String inCgg_carpt_codigo,
		String inCraln_codigo,
		String inCrtra_codigo,
		int inCtreg_numero,
		java.util.Date inCtreg_fecha_preregistro,
		java.util.Date inCtreg_fecha_ingreso,
		String inCtreg_codigo_barras,
		java.util.Date inCtreg_fecha_salida,
		java.util.Date inCtreg_impresion_especie,
		int inCtreg_estado_registro,
		String inCtreg_observacion,
		boolean inCtreg_estado,
		String inCtreg_usuario_insert,
		String inCtreg_usuario_update,
		String inCtreg_categoria, 
		String inCtreg_tipo_registro, 
		String inCtreg_numero_vuelo,
		String inCtreg_tipo_hospedaje, 
		String inCtreg_isla_hospedaje, 
		String inCtreg_nombre_hospedaje_crucero, 
		String inCtreg_nombre_hospedaje_hotel, 
		String inCtreg_lugar_hospedaje,
		String inCtreg_viaje_acompanante, 
		String inCtreg_viaje_motivo, 
		String inCtreg_viaje_actividades, 
		String inCtreg_viaje_num_miembros,
		String inCtreg_viaje_tour, 
		String inCtreg_viaje_cual
	){
		this.setCTREG_CODIGO(inCtreg_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCTGTR_CODIGO(inCtgtr_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		this.setCARPT_CODIGO(inCarpt_codigo);
		this.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
		this.setCRALN_CODIGO(inCraln_codigo);
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCTREG_NUMERO(inCtreg_numero);
		this.setCTREG_FECHA_PREREGISTRO(inCtreg_fecha_preregistro);
		this.setCTREG_FECHA_INGRESO(inCtreg_fecha_ingreso);
		this.setCTREG_CODIGO_BARRAS(inCtreg_codigo_barras);
		this.setCTREG_FECHA_SALIDA(inCtreg_fecha_salida);
		this.setCTREG_IMPRESION_ESPECIE(inCtreg_impresion_especie);
		this.setCTREG_ESTADO_REGISTRO(inCtreg_estado_registro);
		this.setCTREG_OBSERVACION(inCtreg_observacion);
		this.setCTREG_ESTADO(inCtreg_estado);
		this.setCTREG_USUARIO_INSERT(inCtreg_usuario_insert);
		this.setCTREG_USUARIO_UPDATE(inCtreg_usuario_update);
		this.setCTREG_CATEGORIA(inCtreg_categoria); 
		this.setCTREG_TIPO_REGISTRO(inCtreg_tipo_registro); 
		this.setCTREG_NUMERO_VUELO(inCtreg_numero_vuelo); 
		this.setCTREG_TIPO_HOSPEDAJE(inCtreg_tipo_hospedaje); 
		this.setCTREG_ISLA_HOSPEDAJE(inCtreg_isla_hospedaje); 
		this.setCTREG_NOMBRE_HOSPEDAJE_CRUCERO(inCtreg_nombre_hospedaje_crucero); 
		this.setCTREG_NOMBRE_HOSPEDAJE_HOTEL(inCtreg_nombre_hospedaje_hotel); 
		this.setCTREG_LUGAR_HOSPEDAJE(inCtreg_lugar_hospedaje);
		this.setCTREG_VIAJE_ACOMPANANTE(inCtreg_viaje_acompanante); 
		this.setCTREG_VIAJE_MOTIVO(inCtreg_viaje_motivo); 
		this.setCTREG_VIAJE_ACTIVIDADES(inCtreg_viaje_actividades); 
		this.setCTREG_VIAJE_NUM_MIEMBROS(inCtreg_viaje_num_miembros);
		this.setCTREG_VIAJE_TOUR(inCtreg_viaje_tour); 
		this.setCTREG_VIAJE_CUAL(inCtreg_viaje_cual);

	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public void setCTREG_CODIGO(String inCtreg_codigo){
		this.myCtreg_codigo = inCtreg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	*/
	public String getCTREG_CODIGO(){
		return this.myCtreg_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO D EPERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	* @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	*/
	public void setCTGTR_CODIGO(String inCtgtr_codigo){
		this.myCtgtr_codigo = inCtgtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	*/
	public String getCTGTR_CODIGO(){
		return this.myCtgtr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	*/
	public void setCGG_CUSU_CODIGO(String inCgg_cusu_codigo){
		this.myCgg_cusu_codigo = inCgg_cusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO PARA SABER EL USUARIO QUE REALIZO LA IMPRESION DEL FORMULARIO
	*/
	public String getCGG_CUSU_CODIGO(){
		return this.myCgg_cusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	*/
	public void setCARPT_CODIGO(String inCarpt_codigo){
		this.myCarpt_codigo = inCarpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO AEROPUERTO DE ENTRADA
	*/
	public String getCARPT_CODIGO(){
		return this.myCarpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	* @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	*/
	public void setCGG_CARPT_CODIGO(String inCgg_carpt_codigo){
		this.myCgg_carpt_codigo = inCgg_carpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AEROPUERTO DE SALIDA
	*/
	public String getCGG_CARPT_CODIGO(){
		return this.myCgg_carpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	*/
	public void setCRALN_CODIGO(String inCraln_codigo){
		this.myCraln_codigo = inCraln_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AEROLINEA
	*/
	public String getCRALN_CODIGO(){
		return this.myCraln_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE AL QUE CORRESPONDE EL REGISTRO DE TCT PARA EL CASO DE TRANSEUNTES.
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	* @param inCtreg_numero NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	*/
	public void setCTREG_NUMERO(int inCtreg_numero){
		this.myCtreg_numero = inCtreg_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	* @return int NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	*/
	public int getCTREG_NUMERO(){
		return this.myCtreg_numero;
	}

	/**
	* ESTABLECE FECHA DE RESERVA DEL TCT O PREREGISTRO
	* @param inCtreg_fecha_preregistro FECHA DE RESERVA DEL TCT O PREREGISTRO
	*/
	public void setCTREG_FECHA_PREREGISTRO(java.util.Date inCtreg_fecha_preregistro){
		this.myCtreg_fecha_preregistro = inCtreg_fecha_preregistro;
	}
	/**
	* OBTIENE FECHA DE RESERVA DEL TCT O PREREGISTRO
	* @return java.util.Date FECHA DE RESERVA DEL TCT O PREREGISTRO
	*/
	public java.util.Date getCTREG_FECHA_PREREGISTRO(){
		return this.myCtreg_fecha_preregistro;
	}

	/**
	* ESTABLECE FECHA DE INGRESO  A LA PROVINCIA POR TCT
	* @param inCtreg_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA POR TCT
	*/
	public void setCTREG_FECHA_INGRESO(java.util.Date inCtreg_fecha_ingreso){
		this.myCtreg_fecha_ingreso = inCtreg_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO  A LA PROVINCIA POR TCT
	* @return java.util.Date FECHA DE INGRESO  A LA PROVINCIA POR TCT
	*/
	public java.util.Date getCTREG_FECHA_INGRESO(){
		return this.myCtreg_fecha_ingreso;
	}

	/**
	* ESTABLECE CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	* @param inCtreg_codigo_barras CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	*/
	public void setCTREG_CODIGO_BARRAS(String inCtreg_codigo_barras){
		this.myCtreg_codigo_barras = inCtreg_codigo_barras;
	}
	/**
	* OBTIENE CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	* @return String CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	*/
	public String getCTREG_CODIGO_BARRAS(){
		return this.myCtreg_codigo_barras;
	}

	/**
	* ESTABLECE FECHA DE SALIDA DE LA PROVINCIA
	* @param inCtreg_fecha_salida FECHA DE SALIDA DE LA PROVINCIA
	*/
	public void setCTREG_FECHA_SALIDA(java.util.Date inCtreg_fecha_salida){
		this.myCtreg_fecha_salida = inCtreg_fecha_salida;
	}
	/**
	* OBTIENE FECHA DE SALIDA DE LA PROVINCIA
	* @return java.util.Date FECHA DE SALIDA DE LA PROVINCIA
	*/
	public java.util.Date getCTREG_FECHA_SALIDA(){
		return this.myCtreg_fecha_salida;
	}

	/**
	* ESTABLECE FECHA DE IMPRESION DE LA ESPECIE DE TCT
	* @param inCtreg_impresion_especie FECHA DE IMPRESION DE LA ESPECIE DE TCT
	*/
	public void setCTREG_IMPRESION_ESPECIE(java.util.Date inCtreg_impresion_especie){
		this.myCtreg_impresion_especie = inCtreg_impresion_especie;
	}
	/**
	* OBTIENE FECHA DE IMPRESION DE LA ESPECIE DE TCT
	* @return java.util.Date FECHA DE IMPRESION DE LA ESPECIE DE TCT
	*/
	public java.util.Date getCTREG_IMPRESION_ESPECIE(){
		return this.myCtreg_impresion_especie;
	}

	/**
	* ESTABLECE ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	* @param inCtreg_estado_registro ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	*/
	public void setCTREG_ESTADO_REGISTRO(int inCtreg_estado_registro){
		this.myCtreg_estado_registro = inCtreg_estado_registro;
	}
	/**
	* OBTIENE ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	* @return int ESTADO DEL PROCESO DE REGISTRO DE TCT
0 - PREREGISTRADA
1 - IMPRESA
2 - ACTIVA
3 - ANULADA
	*/
	public int getCTREG_ESTADO_REGISTRO(){
		return this.myCtreg_estado_registro;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCtreg_observacion INFORMACION ADICIONAL
	*/
	public void setCTREG_OBSERVACION(String inCtreg_observacion){
		this.myCtreg_observacion = inCtreg_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCTREG_OBSERVACION(){
		return this.myCtreg_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtreg_estado ESTADO DEL REGISTRO
	*/
	public void setCTREG_ESTADO(boolean inCtreg_estado){
		this.myCtreg_estado = inCtreg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTREG_ESTADO(){
		return this.myCtreg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtreg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTREG_USUARIO_INSERT(String inCtreg_usuario_insert){
		this.myCtreg_usuario_insert = inCtreg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTREG_USUARIO_INSERT(){
		return this.myCtreg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtreg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTREG_USUARIO_UPDATE(String inCtreg_usuario_update){
		this.myCtreg_usuario_update = inCtreg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTREG_USUARIO_UPDATE(){
		return this.myCtreg_usuario_update;
	}
	
	public String getCTREG_CATEGORIA() {
		return this.myCtreg_ctreg_categoria;
	}
	public void setCTREG_CATEGORIA(String inCtreg_categoria) {
		this.myCtreg_ctreg_categoria = inCtreg_categoria;
	}
	public String getCTREG_TIPO_REGISTRO() {
		return this.myCtreg_ctreg_tipo_registro;
	}
	public void setCTREG_TIPO_REGISTRO(String inCtreg_tipo_registro) {
		this.myCtreg_ctreg_tipo_registro=inCtreg_tipo_registro;
	}
	public String getCTREG_NUMERO_VUELO() {
		return this.myCtreg_ctreg_numero_vuelo;
	}
	public void setCTREG_NUMERO_VUELO(String inCtreg_numero_vuelo) {
		this.myCtreg_ctreg_numero_vuelo=inCtreg_numero_vuelo;
	}
	public String getCTREG_TIPO_HOSPEDAJE() {
		return this.myCtreg_ctreg_tipo_hospedaje;
	}
	public void setCTREG_TIPO_HOSPEDAJE(String inCtreg_tipo_hospedaje) {
		this.myCtreg_ctreg_tipo_hospedaje=inCtreg_tipo_hospedaje;
	}
	public String getCTREG_ISLA_HOSPEDAJE() {
		return this.myCtreg_ctreg_isla_hospedaje;
	}
	public void setCTREG_ISLA_HOSPEDAJE(String inCtreg_isla_hospedaje) {
		this.myCtreg_ctreg_isla_hospedaje=inCtreg_isla_hospedaje;
	}
	public String getCTREG_NOMBRE_HOSPEDAJE_CRUCERO() {
		return this.myCtreg_ctreg_nombre_hospedaje_crucero;
	}
	public void setCTREG_NOMBRE_HOSPEDAJE_CRUCERO(
			String inCtreg_nombre_hospedaje_crucero) {
		this.myCtreg_ctreg_nombre_hospedaje_crucero=inCtreg_nombre_hospedaje_crucero;
	}
	public String getCTREG_NOMBRE_HOSPEDAJE_HOTEL() {
		return this.myCtreg_ctreg_nombre_hospedaje_hotel;
	}
	public void setCTREG_NOMBRE_HOSPEDAJE_HOTEL(String inCtreg_nombre_hospedaje_hotel) {
		this.myCtreg_ctreg_nombre_hospedaje_hotel=inCtreg_nombre_hospedaje_hotel;
	}
	public String getCTREG_LUGAR_HOSPEDAJE() {
		return this.myCtreg_ctreg_lugar_hospedaje;
	}
	public void setCTREG_LUGAR_HOSPEDAJE(String inCtreg_lugar_hospedaje) {
		this.myCtreg_ctreg_lugar_hospedaje=inCtreg_lugar_hospedaje;
	}
	public String getCTREG_VIAJE_ACOMPANANTE() {
		return this.myCtreg_ctreg_viaje_acompanante;
	}
	public void setCTREG_VIAJE_ACOMPANANTE(String inCtreg_viaje_acompanante) {
		this.myCtreg_ctreg_viaje_acompanante=inCtreg_viaje_acompanante;
	}
	public String getCTREG_VIAJE_MOTIVO() {
		return this.myCtreg_ctreg_viaje_motivo;
	}
	public void setCTREG_VIAJE_MOTIVO(String inCtreg_viaje_motivo) {
		this.myCtreg_ctreg_viaje_motivo=inCtreg_viaje_motivo;
	}
	public String getCTREG_VIAJE_ACTIVIDADES() {
		return this.myCtreg_ctreg_viaje_actividades;
	}
	public void setCTREG_VIAJE_ACTIVIDADES(String inCtreg_viaje_actividades) {
		this.myCtreg_ctreg_viaje_actividades=inCtreg_viaje_actividades;
	}
	public String getCTREG_VIAJE_NUM_MIEMBROS() {
		return this.myCtreg_ctreg_viaje_num_miembros;
	}
	public void setCTREG_VIAJE_NUM_MIEMBROS(String inCtreg_viaje_num_miembros) {
		this.myCtreg_ctreg_viaje_num_miembros=inCtreg_viaje_num_miembros;
	}
	public String getCTREG_VIAJE_TOUR() {
		return this.myCtreg_ctreg_viaje_tour;
	}
	public void setCTREG_VIAJE_TOUR(String inCtreg_viaje_tour) {
		this.myCtreg_ctreg_viaje_tour=inCtreg_viaje_tour;
	}
	public String getCTREG_VIAJE_CUAL() {
		return this.myCtreg_ctreg_viaje_cual;
	}
	public void setCTREG_VIAJE_CUAL(String inCtreg_viaje_cual) {
		this.myCtreg_ctreg_viaje_cual=inCtreg_viaje_cual;
	}

}
