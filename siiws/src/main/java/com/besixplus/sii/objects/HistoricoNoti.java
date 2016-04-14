package com.besixplus.sii.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoricoNoti {

	ArrayList<HashMap<String,Object>> persona_notificacion = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> oficial_seguimiento = new ArrayList<HashMap<String,Object>>();

	
	public HistoricoNoti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HashMap<String, Object>> getPersona_notificacion() {
		return persona_notificacion;
	}

	public void setPersona_notificacion(ArrayList<HashMap<String, Object>> persona_notificacion) {
		this.persona_notificacion = persona_notificacion;
	}
	public ArrayList<HashMap<String, Object>> getOficial_seguimiento() {
		return oficial_seguimiento;
	}

	public void setOficial_seguimiento(ArrayList<HashMap<String, Object>> oficial_seguimiento) {
		this.oficial_seguimiento = oficial_seguimiento;
	}


	
}
