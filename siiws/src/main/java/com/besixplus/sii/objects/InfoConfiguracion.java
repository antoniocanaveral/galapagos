package com.besixplus.sii.objects;

import java.util.ArrayList;

/**
 * SE UTILIZA PARA ASEGURAR LA COMPATIBILIDAD ENTRE LOS NAVEGADORES.
 *
 */
public class InfoConfiguracion {

	private ArrayList<Cgg_kdx_especie> cgg_kdx_especie = null;	
	private ArrayList<com.besixplus.sii.objects.Cgg_pais> cgg_pais =null;
	private ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> cgg_res_aeropuerto = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> cgg_res_aerolinea = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> cgg_res_documento_identificacio = null;	
	private ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> cgg_tct_tipo_hospedaje = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> cgg_tct_actividad = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> cgg_nacionalidad = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_configuracion> cgg_configuracion = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario> Cgg_kdx_punto_venta_usuario = null; 
	private ArrayList<com.besixplus.sii.objects.Cgg_canton> Cgg_canton = null;
	private String cgg_offline_numeracion_grupo = null;
	private String cgg_offline_numeracion_registro = null;
		
	/**
	 * CONSTRUCTOR DE LA CLASE.
	 */
	public InfoConfiguracion(){
	}

	/**OBTIENE LA INFORMACION DE LA TABLA ESPECIE.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<Cgg_kdx_especie> getCgg_kdx_especie() {
		return cgg_kdx_especie;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE ESPECIE 
	 * @param cgg_kdx_especie IDENTIFICATIVO DE LA TABLA DE ESPECIE.
	 */
	public void setCgg_kdx_especie(ArrayList<Cgg_kdx_especie> cgg_kdx_especie) {
		this.cgg_kdx_especie = cgg_kdx_especie;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE PAIS.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_pais> getCgg_pais() {
		return cgg_pais;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE PAIS.
	 * @param cgg_pais IDENTIFICATIVO DE LA TABLA DE PAIS.
	 */
	public void setCgg_pais(ArrayList<com.besixplus.sii.objects.Cgg_pais> cgg_pais) {
		this.cgg_pais = cgg_pais;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE AEROPUERTO
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> getCgg_res_aeropuerto() {
		return cgg_res_aeropuerto;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE AEROPUERTO
	 * @param cgg_res_aeropuerto IDENTIFICATIVO DE LA TABLA DE AEROPUERTO.
	 */
	public void setCgg_res_aeropuerto(
			ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> cgg_res_aeropuerto) {
		this.cgg_res_aeropuerto = cgg_res_aeropuerto;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE AEROLINEA.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> getCgg_res_aerolinea() {
		return cgg_res_aerolinea;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE AEROLINEA.
	 * @param cgg_res_aerolinea IDENTIFICATIVO UNICO DE AEROLINEA.
	 */
	public void setCgg_res_aerolinea(
			ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> cgg_res_aerolinea) {
		this.cgg_res_aerolinea = cgg_res_aerolinea;
	}

	/**
	 * OBTIENE LA INFORMACION DEL DOCUMENTO DE IDENTIFICACION DE UNA PERSONA.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> getCgg_res_documento_identificacio() {
		return cgg_res_documento_identificacio;
	}

	/**
	 * ESTABLECE LA INFORMACION DEL DOCUMENTO DE IDENTIFICACION.
	 * @param cgg_res_documento_identificacio IDENTIFICATIVO DEL DOCUMENTO DE IDENTIFICACION.
	 */
	public void setCgg_res_documento_identificacio(
			ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> cgg_res_documento_identificacio) {
		this.cgg_res_documento_identificacio = cgg_res_documento_identificacio;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE TIPO DE HOSPEDAJE.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> getCgg_tct_tipo_hospedaje() {
		return cgg_tct_tipo_hospedaje;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE TIPO DE HOSPEDAJE.
	 * @param cgg_tct_tipo_hospedaje IDENTIFICATIVO DE TIPO DE HOSPEDAJE.
	 */
	public void setCgg_tct_tipo_hospedaje(
			ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> cgg_tct_tipo_hospedaje) {
		this.cgg_tct_tipo_hospedaje = cgg_tct_tipo_hospedaje;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE ACTIVIDAD.
	 * @return COLECCION DE INFORMACION
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> getCgg_tct_actividad() {
		return cgg_tct_actividad;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE ACTIVIDAD.
	 * @param cgg_tct_actividad IDENTIFICATIVO DE LA TABLA DE ACTIVIDAD.
	 */
	public void setCgg_tct_actividad(
			ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> cgg_tct_actividad) {
		this.cgg_tct_actividad = cgg_tct_actividad;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE NACIONALIDAD.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> getCgg_nacionalidad() {
		return cgg_nacionalidad;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE NACIONALIDAD.
	 * @param cgg_nacionalidad IDENTIFICATIVO DE LA TABLA DE NACIONALIDAD.
	 */
	public void setCgg_nacionalidad(
			ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> cgg_nacionalidad) {
		this.cgg_nacionalidad = cgg_nacionalidad;
	}

	public ArrayList<com.besixplus.sii.objects.Cgg_configuracion> getCgg_configuracion() {
		return cgg_configuracion;
	}

	public void setCgg_configuracion(
			ArrayList<com.besixplus.sii.objects.Cgg_configuracion> cgg_configuracion) {
		this.cgg_configuracion = cgg_configuracion;
	}

	public ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario> getCgg_kdx_punto_venta_usuario() {
		return Cgg_kdx_punto_venta_usuario;
	}

	public void setCgg_kdx_punto_venta_usuario(
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario> cgg_kdx_punto_venta_usuario) {
		Cgg_kdx_punto_venta_usuario = cgg_kdx_punto_venta_usuario;
	}

	public ArrayList<com.besixplus.sii.objects.Cgg_canton> getCgg_canton() {
		return Cgg_canton;
	}

	public void setCgg_canton(
			ArrayList<com.besixplus.sii.objects.Cgg_canton> cgg_canton) {
		Cgg_canton = cgg_canton;
	}

	public String getCgg_offline_numeracion_grupo() {
		return cgg_offline_numeracion_grupo;
	}

	public void setCgg_offline_numeracion_grupo(String cgg_offline_numeracion_grupo) {
		this.cgg_offline_numeracion_grupo = cgg_offline_numeracion_grupo;
	}

	public String getCgg_offline_numeracion_registro() {
		return cgg_offline_numeracion_registro;
	}

	public void setCgg_offline_numeracion_registro(
			String cgg_offline_numeracion_registro) {
		this.cgg_offline_numeracion_registro = cgg_offline_numeracion_registro;
	}	
			
}
