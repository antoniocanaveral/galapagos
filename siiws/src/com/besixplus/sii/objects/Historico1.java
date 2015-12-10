package com.besixplus.sii.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Historico1 {

	ArrayList<HashMap<String,Object>> notificado = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> transeunte = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> excedido =  new ArrayList<HashMap<String,Object>>();
	
	ArrayList<HashMap<String,Object>> grupoTuristaRegistro =  new ArrayList<HashMap<String,Object>>();	
	
	public Historico1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HashMap<String, Object>> getNotificado() {
		return notificado;
	}

	public void setNotificado(ArrayList<HashMap<String, Object>> notificado) {
		this.notificado = notificado;
	}

	public ArrayList<HashMap<String, Object>> getTranseunte() {
		return transeunte;
	}

	public void setTranseunte(ArrayList<HashMap<String, Object>> transeunte) {
		this.transeunte = transeunte;
	}

	public ArrayList<HashMap<String, Object>> getExcedido() {
		return excedido;
	}

	public void setExcedido(ArrayList<HashMap<String, Object>> excedido) {
		this.excedido = excedido;
	}

	public ArrayList<HashMap<String, Object>> getGrupoTuristaRegistro() {
		return grupoTuristaRegistro;
	}

	public void setGrupoTuristaRegistro(
			ArrayList<HashMap<String, Object>> grupoTuristaRegistro) {
		this.grupoTuristaRegistro = grupoTuristaRegistro;
	}	
	
}
