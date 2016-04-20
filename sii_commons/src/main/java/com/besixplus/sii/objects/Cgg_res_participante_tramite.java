package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_participante_tramite
* TABLA: PARTICIPANTE TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS PARTICIPANTES QUE INTERVIENEN EN EL SEGUIMIENTO DE LOS TRAMITES
* ABREVIATURA:CRPTR
*/
public class Cgg_res_participante_tramite implements Serializable{
	private static final long serialVersionUID = 1710277146;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO PARTICIPANTE TRAMITE
	*/
	private String myCrptr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	private String myCrtpt_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrptr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrptr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrptr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_participante_tramite
	*/
	public Cgg_res_participante_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_participante_tramite
	* @param inCrptr_codigo IDENTIFICATIVO UNICO DE REGISTRO PARTICIPANTE TRAMITE
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrptr_estado ESTADO DEL REGISTRO
	* @param inCrptr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrptr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_participante_tramite(
		String inCrptr_codigo,
		String inCusu_codigo,
		String inCrtpt_codigo,
		boolean inCrptr_estado,
		String inCrptr_usuario_insert,
		String inCrptr_usuario_update
	){
		this.setCRPTR_CODIGO(inCrptr_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRTPT_CODIGO(inCrtpt_codigo);
		this.setCRPTR_ESTADO(inCrptr_estado);
		this.setCRPTR_USUARIO_INSERT(inCrptr_usuario_insert);
		this.setCRPTR_USUARIO_UPDATE(inCrptr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO PARTICIPANTE TRAMITE
	* @param inCrptr_codigo IDENTIFICATIVO UNICO DE REGISTRO PARTICIPANTE TRAMITE
	*/
	public void setCRPTR_CODIGO(String inCrptr_codigo){
		this.myCrptr_codigo = inCrptr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO PARTICIPANTE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO PARTICIPANTE TRAMITE
	*/
	public String getCRPTR_CODIGO(){
		return this.myCrptr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public void setCRTPT_CODIGO(String inCrtpt_codigo){
		this.myCrtpt_codigo = inCrtpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public String getCRTPT_CODIGO(){
		return this.myCrtpt_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrptr_estado ESTADO DEL REGISTRO
	*/
	public void setCRPTR_ESTADO(boolean inCrptr_estado){
		this.myCrptr_estado = inCrptr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPTR_ESTADO(){
		return this.myCrptr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrptr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPTR_USUARIO_INSERT(String inCrptr_usuario_insert){
		this.myCrptr_usuario_insert = inCrptr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPTR_USUARIO_INSERT(){
		return this.myCrptr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrptr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPTR_USUARIO_UPDATE(String inCrptr_usuario_update){
		this.myCrptr_usuario_update = inCrptr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPTR_USUARIO_UPDATE(){
		return this.myCrptr_usuario_update;
	}

}
