package com.besixplus.sii.objects;

/**
 * Clase para el envio de respuestas formateadas hacia el lado del cliente. Generalmente utilizadas para un correcto formateo de servlet hacia json.
 *@author BESIXPLUS CIA. LTDA.
 */
public class ServerResponse {
	private boolean success=false;
	private String msg = "";
	private Object objData = null;
	
	public ServerResponse(boolean success, String msg, Object objData) {
		super();
		this.success = success;
		this.msg = msg;
		this.objData = objData;
	}
	
	public ServerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObjData() {
		return objData;
	}

	public void setObjData(Object objData) {
		this.objData = objData;
	}	

}
