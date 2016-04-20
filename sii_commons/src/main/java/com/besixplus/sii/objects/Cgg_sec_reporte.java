package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_reporte
* TABLA: OBJETO
* DESCRIPCION: CONTIENE EL LISTADO DE REPORTES
* ABREVIATURA:CSRPT
*/
public class Cgg_sec_reporte implements Serializable{
	private static final long serialVersionUID = 596940356;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	private String myCsrpt_codigo;
	/**
	* SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	private String myCsrpt_reporte;
	/**
	* SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	private String myCsrpt_descripcion;
	/**
	* TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	*/
	private boolean myCsrpt_activo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsrpt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsrpt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsrpt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_reporte
	*/
	public Cgg_sec_reporte(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_reporte
	* @param inCsrpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	* @param inCsrpt_reporte SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @param inCsrpt_descripcion SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @param inCsrpt_activo TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	* @param inCsrpt_estado ESTADO DEL REGISTRO
	* @param inCsrpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsrpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_reporte(
		String inCsrpt_codigo,
		String inCsrpt_reporte,
		String inCsrpt_descripcion,
		boolean inCsrpt_activo,
		boolean inCsrpt_estado,
		String inCsrpt_usuario_insert,
		String inCsrpt_usuario_update
	){
		this.setCSRPT_CODIGO(inCsrpt_codigo);
		this.setCSRPT_REPORTE(inCsrpt_reporte);
		this.setCSRPT_DESCRIPCION(inCsrpt_descripcion);
		this.setCSRPT_ACTIVO(inCsrpt_activo);
		this.setCSRPT_ESTADO(inCsrpt_estado);
		this.setCSRPT_USUARIO_INSERT(inCsrpt_usuario_insert);
		this.setCSRPT_USUARIO_UPDATE(inCsrpt_usuario_update);
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
	* ESTABLECE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @param inCsrpt_reporte SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	public void setCSRPT_REPORTE(String inCsrpt_reporte){
		this.myCsrpt_reporte = inCsrpt_reporte;
	}
	/**
	* OBTIENE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @return String SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	public String getCSRPT_REPORTE(){
		return this.myCsrpt_reporte;
	}

	/**
	* ESTABLECE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @param inCsrpt_descripcion SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	public void setCSRPT_DESCRIPCION(String inCsrpt_descripcion){
		this.myCsrpt_descripcion = inCsrpt_descripcion;
	}
	/**
	* OBTIENE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	* @return String SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	public String getCSRPT_DESCRIPCION(){
		return this.myCsrpt_descripcion;
	}

	/**
	* ESTABLECE TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	* @param inCsrpt_activo TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	*/
	public void setCSRPT_ACTIVO(boolean inCsrpt_activo){
		this.myCsrpt_activo = inCsrpt_activo;
	}
	/**
	* OBTIENE TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	* @return boolean TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	*/
	public boolean getCSRPT_ACTIVO(){
		return this.myCsrpt_activo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsrpt_estado ESTADO DEL REGISTRO
	*/
	public void setCSRPT_ESTADO(boolean inCsrpt_estado){
		this.myCsrpt_estado = inCsrpt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSRPT_ESTADO(){
		return this.myCsrpt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsrpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSRPT_USUARIO_INSERT(String inCsrpt_usuario_insert){
		this.myCsrpt_usuario_insert = inCsrpt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSRPT_USUARIO_INSERT(){
		return this.myCsrpt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsrpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSRPT_USUARIO_UPDATE(String inCsrpt_usuario_update){
		this.myCsrpt_usuario_update = inCsrpt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSRPT_USUARIO_UPDATE(){
		return this.myCsrpt_usuario_update;
	}

}
