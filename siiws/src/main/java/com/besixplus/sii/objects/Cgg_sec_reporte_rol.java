package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_reporte_rol
* TABLA: ROL REPORTE
* DESCRIPCION: CONTIENE LOS PRIVILEGIOS PARA LOS REPORTES
* ABREVIATURA:CSRPR
*/
public class Cgg_sec_reporte_rol implements Serializable{
	private static final long serialVersionUID = 624171339;
	/**
	* NO ESPECIFICADO
	*/
	private String myCsrpr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	private String myCsrol_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	private String myCsrpt_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsrpr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsrpr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsrpr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_reporte_rol
	*/
	public Cgg_sec_reporte_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_reporte_rol
	* @param inCsrpr_codigo NO ESPECIFICADO
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCsrpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @param inCsrpr_estado ESTADO DEL REGISTRO
	* @param inCsrpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsrpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_reporte_rol(
		String inCsrpr_codigo,
		String inCsrol_codigo,
		String inCsrpt_codigo,
		boolean inCsrpr_estado,
		String inCsrpr_usuario_insert,
		String inCsrpr_usuario_update
	){
		this.setCSRPR_CODIGO(inCsrpr_codigo);
		this.setCSROL_CODIGO(inCsrol_codigo);
		this.setCSRPT_CODIGO(inCsrpt_codigo);
		this.setCSRPR_ESTADO(inCsrpr_estado);
		this.setCSRPR_USUARIO_INSERT(inCsrpr_usuario_insert);
		this.setCSRPR_USUARIO_UPDATE(inCsrpr_usuario_update);
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCsrpr_codigo NO ESPECIFICADO
	*/
	public void setCSRPR_CODIGO(String inCsrpr_codigo){
		this.myCsrpr_codigo = inCsrpr_codigo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCSRPR_CODIGO(){
		return this.myCsrpr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @param inCsrol_codigo IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	public void setCSROL_CODIGO(String inCsrol_codigo){
		this.myCsrol_codigo = inCsrol_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO ROL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO ROL
	*/
	public String getCSROL_CODIGO(){
		return this.myCsrol_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @param inCsrpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	public void setCSRPT_CODIGO(String inCsrpt_codigo){
		this.myCsrpt_codigo = inCsrpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	public String getCSRPT_CODIGO(){
		return this.myCsrpt_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsrpr_estado ESTADO DEL REGISTRO
	*/
	public void setCSRPR_ESTADO(boolean inCsrpr_estado){
		this.myCsrpr_estado = inCsrpr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSRPR_ESTADO(){
		return this.myCsrpr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsrpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSRPR_USUARIO_INSERT(String inCsrpr_usuario_insert){
		this.myCsrpr_usuario_insert = inCsrpr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSRPR_USUARIO_INSERT(){
		return this.myCsrpr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsrpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSRPR_USUARIO_UPDATE(String inCsrpr_usuario_update){
		this.myCsrpr_usuario_update = inCsrpr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSRPR_USUARIO_UPDATE(){
		return this.myCsrpr_usuario_update;
	}

}
