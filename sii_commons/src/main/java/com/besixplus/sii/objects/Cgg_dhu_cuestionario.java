package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_cuestionario
* TABLA: CUESTIONARIO
* DESCRIPCION:ALMACENA INFORMACION DEL CUESTIONARIO PARA APLICAR UNA ENCUESTA
* ABREVIATURA:CDCST
*/
public class Cgg_dhu_cuestionario implements Serializable{
	private static final long serialVersionUID = 2102988908;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
	*/
	private String myCdcst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	private String myCdprg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	private String myCdenc_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdcst_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdcst_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdcst_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_cuestionario
	*/
	public Cgg_dhu_cuestionario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_cuestionario
	* @param inCdcst_codigo IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
	* @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @param inCdenc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @param inCdcst_estado ESTADO DEL REGISTRO
	* @param inCdcst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_cuestionario(
		String inCdcst_codigo,
		String inCdprg_codigo,
		String inCdenc_codigo,
		boolean inCdcst_estado,
		String inCdcst_usuario_insert,
		String inCdcst_usuario_update
	){
		this.setCDCST_CODIGO(inCdcst_codigo);
		this.setCDPRG_CODIGO(inCdprg_codigo);
		this.setCDENC_CODIGO(inCdenc_codigo);
		this.setCDCST_ESTADO(inCdcst_estado);
		this.setCDCST_USUARIO_INSERT(inCdcst_usuario_insert);
		this.setCDCST_USUARIO_UPDATE(inCdcst_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
	* @param inCdcst_codigo IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
	*/
	public void setCDCST_CODIGO(String inCdcst_codigo){
		this.myCdcst_codigo = inCdcst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO CUESTIONARIO
	*/
	public String getCDCST_CODIGO(){
		return this.myCdcst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	public void setCDPRG_CODIGO(String inCdprg_codigo){
		this.myCdprg_codigo = inCdprg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	public String getCDPRG_CODIGO(){
		return this.myCdprg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @param inCdenc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	public void setCDENC_CODIGO(String inCdenc_codigo){
		this.myCdenc_codigo = inCdenc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	public String getCDENC_CODIGO(){
		return this.myCdenc_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdcst_estado ESTADO DEL REGISTRO
	*/
	public void setCDCST_ESTADO(boolean inCdcst_estado){
		this.myCdcst_estado = inCdcst_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDCST_ESTADO(){
		return this.myCdcst_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDCST_USUARIO_INSERT(String inCdcst_usuario_insert){
		this.myCdcst_usuario_insert = inCdcst_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDCST_USUARIO_INSERT(){
		return this.myCdcst_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdcst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDCST_USUARIO_UPDATE(String inCdcst_usuario_update){
		this.myCdcst_usuario_update = inCdcst_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDCST_USUARIO_UPDATE(){
		return this.myCdcst_usuario_update;
	}

}
