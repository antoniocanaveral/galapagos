package com.besixplus.sii.objects;

public class ExportableTct {

	private InfoConfiguracion configuracion = null;
	private Historico1 historico = null;
	
	public ExportableTct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExportableTct(InfoConfiguracion configuracion, Historico1 historico) {
		super();
		this.configuracion = configuracion;
		this.historico = historico;
	}

	public InfoConfiguracion getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(InfoConfiguracion configuracion) {
		this.configuracion = configuracion;
	}

	public Historico1 getHistorico() {
		return historico;
	}

	public void setHistorico(Historico1 historico) {
		this.historico = historico;
	}	
	
}
