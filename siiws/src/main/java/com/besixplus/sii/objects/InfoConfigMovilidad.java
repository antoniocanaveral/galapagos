package com.besixplus.sii.objects;

import java.util.ArrayList;

/**
 * SE UTILIZA PARA ASEGURAR LA COMPATIBILIDAD ENTRE LOS NAVEGADORES.
 *
 */
public class InfoConfigMovilidad {

	
	private ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> cgg_res_aeropuerto = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> cgg_res_aerolinea = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> cgg_tct_tipo_hospedaje = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> cgg_tct_actividad = null;
	
	private ArrayList<com.besixplus.sii.objects.Cgg_pais> cgg_pais =null;
	private ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> cgg_res_documento_identificacio = null;
	private ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> cgg_nacionalidad = null;	
	
	/**
	 * CONSTRUCTOR DE LA CLASE.
	 */
	public InfoConfigMovilidad(){
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
	 * @return COLECCION DE INFORMACIONprivate
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


	public ArrayList<com.besixplus.sii.objects.Cgg_pais> getCgg_pais() {
		return cgg_pais;
	}


	public void setCgg_pais(ArrayList<com.besixplus.sii.objects.Cgg_pais> cgg_pais) {
		this.cgg_pais = cgg_pais;
	}


	public ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> getCgg_res_documento_identificacio() {
		return cgg_res_documento_identificacio;
	}


	public void setCgg_res_documento_identificacio(
			ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> cgg_res_documento_identificacio) {
		this.cgg_res_documento_identificacio = cgg_res_documento_identificacio;
	}


	public ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> getCgg_nacionalidad() {
		return cgg_nacionalidad;
	}


	public void setCgg_nacionalidad(
			ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> cgg_nacionalidad) {
		this.cgg_nacionalidad = cgg_nacionalidad;
	}
		
}
