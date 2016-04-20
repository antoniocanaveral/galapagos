package com.besixplus.sii.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoricoMovi {

	ArrayList<HashMap<String,Object>> movilidad_ingreso = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> movilidad_salida = new ArrayList<HashMap<String,Object>>();
	//ArrayList<HashMap<String,Object>> movilidad_residente =  new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> grupo_actividad =  new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> grupo_hospedaje =  new ArrayList<HashMap<String,Object>>();
	
	public HistoricoMovi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HashMap<String, Object>> getMovilidad_ingreso() {
		return movilidad_ingreso;
	}

	public void setMovilidad_ingreso(ArrayList<HashMap<String, Object>> movilidad_ingreso) {
		this.movilidad_ingreso = movilidad_ingreso;
	}

	public ArrayList<HashMap<String, Object>> getMovilidad_salida() {
		return movilidad_salida;
	}

	public void setMovilidad_salida(ArrayList<HashMap<String, Object>> movilidad_salida) {
		this.movilidad_salida = movilidad_salida;
	}

	public ArrayList<HashMap<String, Object>> getGrupo_actividad() {
		return grupo_actividad;
	}

	public void setGrupo_actividad(ArrayList<HashMap<String, Object>> grupo_actividad) {
		this.grupo_actividad = grupo_actividad;
	}
	public ArrayList<HashMap<String, Object>> getGrupo_hospedaje() {
		return grupo_hospedaje;
	}

	public void setGrupo_hospedaje(ArrayList<HashMap<String, Object>> grupo_hospedaje) {
		this.grupo_hospedaje = grupo_hospedaje;
	}
	/*public ArrayList<HashMap<String, Object>> getMovilidad_residente() {
		return movilidad_residente;
	}

	public void setMovilidad_residente(ArrayList<HashMap<String, Object>> movilidad_residente) {
		this.movilidad_residente = movilidad_residente;
	}*/
}
