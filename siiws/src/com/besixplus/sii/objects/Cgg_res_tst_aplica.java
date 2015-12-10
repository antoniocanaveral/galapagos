package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* Clase Cgg_res_tst_aplica. Representa a la tabla sii.cgg_res_tst_aplica.
* @author BESIXPLUS CIA. LTDA. www.besixplus.com.
*/
public class Cgg_res_tst_aplica implements Serializable{
	private static final long serialVersionUID = 1791259690;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE TSAO
	*/
	private String myCrtao_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	*/
	private String myCrtso_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* ESTADO DEL REGISTRO, SI ESTA VIGENTE O ELIMINADO
	*/
	private boolean myCrtao_estado;
	/**
	* NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	*/
	private String myCrtao_usuario_insert;
	/**
	* NOMBRE DEL USUARIO QUE REALIZO LA ACTUALIZACION
	*/
	private String myCrtao_usuario_update;
	/**
	* Constructor.
	*/
	public Cgg_res_tst_aplica(){}
	/**
	* Constructor.
	* @param inCrtao_codigo IDENTIFICADOR UNICO DE REGISTRO DE TSAO
	* @param inCrtso_codigo IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrtao_estado ESTADO DEL REGISTRO, SI ESTA VIGENTE O ELIMINADO
	* @param inCrtao_usuario_insert NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	* @param inCrtao_usuario_update NOMBRE DEL USUARIO QUE REALIZO LA ACTUALIZACION
	*/
	public Cgg_res_tst_aplica(
		String inCrtao_codigo,
		String inCrtso_codigo,
		String inCrtst_codigo,
		boolean inCrtao_estado,
		String inCrtao_usuario_insert,
		String inCrtao_usuario_update
	){
		this.setCRTAO_CODIGO(inCrtao_codigo);
		this.setCRTSO_CODIGO(inCrtso_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRTAO_ESTADO(inCrtao_estado);
		this.setCRTAO_USUARIO_INSERT(inCrtao_usuario_insert);
		this.setCRTAO_USUARIO_UPDATE(inCrtao_usuario_update);
	}

	/**
	* Establece IDENTIFICADOR UNICO DE REGISTRO DE TSAO.
	* @param inCrtao_codigo IDENTIFICADOR UNICO DE REGISTRO DE TSAO.
	*/
	public void setCRTAO_CODIGO(String inCrtao_codigo){
		this.myCrtao_codigo = inCrtao_codigo;
	}
	/**
	* Obtiene IDENTIFICADOR UNICO DE REGISTRO DE TSAO.
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE TSAO.
	*/
	public String getCRTAO_CODIGO(){
		return this.myCrtao_codigo;
	}

	/**
	* Establece IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES.
	* @param inCrtso_codigo IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES.
	*/
	public void setCRTSO_CODIGO(String inCrtso_codigo){
		this.myCrtso_codigo = inCrtso_codigo;
	}
	/**
	* Obtiene IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES.
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES.
	*/
	public String getCRTSO_CODIGO(){
		return this.myCrtso_codigo;
	}

	/**
	* Establece IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	*/
	public void setCRTST_CODIGO(String inCrtst_codigo){
		this.myCrtst_codigo = inCrtst_codigo;
	}
	/**
	* Obtiene IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	*/
	public String getCRTST_CODIGO(){
		return this.myCrtst_codigo;
	}

	/**
	* Establece ESTADO DEL REGISTRO, SI ESTA VIGENTE O ELIMINADO.
	* @param inCrtao_estado ESTADO DEL REGISTRO, SI ESTA VIGENTE O ELIMINADO.
	*/
	public void setCRTAO_ESTADO(boolean inCrtao_estado){
		this.myCrtao_estado = inCrtao_estado;
	}
	/**
	* Obtiene ESTADO DEL REGISTRO, SI ESTA VIGENTE O ELIMINADO.
	* @return boolean ESTADO DEL REGISTRO, SI ESTA VIGENTE O ELIMINADO.
	*/
	public boolean getCRTAO_ESTADO(){
		return this.myCrtao_estado;
	}

	/**
	* Establece NOMBRE DEL USUARIO QUE CREO EL REGISTRO.
	* @param inCrtao_usuario_insert NOMBRE DEL USUARIO QUE CREO EL REGISTRO.
	*/
	public void setCRTAO_USUARIO_INSERT(String inCrtao_usuario_insert){
		this.myCrtao_usuario_insert = inCrtao_usuario_insert;
	}
	/**
	* Obtiene NOMBRE DEL USUARIO QUE CREO EL REGISTRO.
	* @return String NOMBRE DEL USUARIO QUE CREO EL REGISTRO.
	*/
	public String getCRTAO_USUARIO_INSERT(){
		return this.myCrtao_usuario_insert;
	}

	/**
	* Establece NOMBRE DEL USUARIO QUE REALIZO LA ACTUALIZACION.
	* @param inCrtao_usuario_update NOMBRE DEL USUARIO QUE REALIZO LA ACTUALIZACION.
	*/
	public void setCRTAO_USUARIO_UPDATE(String inCrtao_usuario_update){
		this.myCrtao_usuario_update = inCrtao_usuario_update;
	}
	/**
	* Obtiene NOMBRE DEL USUARIO QUE REALIZO LA ACTUALIZACION.
	* @return String NOMBRE DEL USUARIO QUE REALIZO LA ACTUALIZACION.
	*/
	public String getCRTAO_USUARIO_UPDATE(){
		return this.myCrtao_usuario_update;
	}

}
