package com.besixplus.sii.objects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SE UTILIZA PARA ASEGURAR LA COMPATIBILIDAD ENTRE LOS NAVEGADORES.
 *
 */
public class InfoConfigNotificacion {

	
	ArrayList<com.besixplus.sii.objects.Cgg_canton> cgg_canton = null;
	ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> cgg_tipo_notificacion = null;
	ArrayList<HashMap<String,Object>> oficial_seguimiento = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> notificado = new ArrayList<HashMap<String,Object>>();
	
	/**
	 * CONSTRUCTOR DE LA CLASE.
	 */
	public InfoConfigNotificacion(){
	}

	
	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE CANTON
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_canton> getCgg_canton() {
		return cgg_canton;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE CANTON
	 * @param cgg_canton IDENTIFICATIVO DE LA TABLA DE CANTON.
	 */
	public void setCgg_canton(
			ArrayList<com.besixplus.sii.objects.Cgg_canton> cgg_canton) {
		this.cgg_canton = cgg_canton;
	}

	/**
	 * OBTIENE LA INFORMACION DE LA TABLA DE TIPO_NOTIFICACION.
	 * @return COLECCION DE INFORMACION.
	 */
	public ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> getCgg_tipo_notificacion() {
		return cgg_tipo_notificacion;
	}

	/**
	 * ESTABLECE LA INFORMACION DE LA TABLA DE TIPO_NOTIFICACION.
	 * @param cgg_res_aerolinea IDENTIFICATIVO UNICO DE TIPO_NOTIFICACION.
	 */
	public void setCgg_tipo_notificacion(
			ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> cgg_tipo_notificacion) {
		this.cgg_tipo_notificacion = cgg_tipo_notificacion;
	}


	public ArrayList<HashMap<String, Object>> getOficial_seguimiento() {
		return oficial_seguimiento;
	}


	public void setOficial_seguimiento(
			ArrayList<HashMap<String, Object>> oficial_seguimiento) {
		this.oficial_seguimiento = oficial_seguimiento;
	}


	public ArrayList<HashMap<String, Object>> getNotificado() {
		return notificado;
	}


	public void setNotificado(ArrayList<HashMap<String, Object>> notificado) {
		this.notificado = notificado;
	}
		
}
