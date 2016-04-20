package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_requisito_vacante
* TABLA: REQUISITO_VACANTE
* DESCRIPCION:ALMACENA INFORMACION DE LOS REQUISITOS QUE DEBE CUMPLIR EL ASPIRANTE
* ABREVIATURA:CGRVC
*/
public class Cgg_gem_requisito_vacante implements Serializable{
	private static final long serialVersionUID = 632470444;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE VACANTE
	*/
	private String myCgrvc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	*/
	private String myCgvcn_codigo;
	/**
	* NOMBRE DEL REQUISITO
	*/
	private String myCgrvc_requisito;
	/**
	* CAMPO DE OBLIGATORIEDAD DEL REQUISITO
	*/
	private boolean myCgrvc_obligatorio;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgrvc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgrvc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgrvc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_requisito_vacante
	*/
	public Cgg_gem_requisito_vacante(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_requisito_vacante
	* @param inCgrvc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE VACANTE
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	* @param inCgrvc_requisito NOMBRE DEL REQUISITO
	* @param inCgrvc_obligatorio CAMPO DE OBLIGATORIEDAD DEL REQUISITO
	* @param inCgrvc_estado ESTADO DEL REGISTRO
	* @param inCgrvc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgrvc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_requisito_vacante(
		String inCgrvc_codigo,
		String inCgvcn_codigo,
		String inCgrvc_requisito,
		boolean inCgrvc_obligatorio,
		boolean inCgrvc_estado,
		String inCgrvc_usuario_insert,
		String inCgrvc_usuario_update
	){
		this.setCGRVC_CODIGO(inCgrvc_codigo);
		this.setCGVCN_CODIGO(inCgvcn_codigo);
		this.setCGRVC_REQUISITO(inCgrvc_requisito);
		this.setCGRVC_OBLIGATORIO(inCgrvc_obligatorio);
		this.setCGRVC_ESTADO(inCgrvc_estado);
		this.setCGRVC_USUARIO_INSERT(inCgrvc_usuario_insert);
		this.setCGRVC_USUARIO_UPDATE(inCgrvc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE VACANTE
	* @param inCgrvc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE VACANTE
	*/
	public void setCGRVC_CODIGO(String inCgrvc_codigo){
		this.myCgrvc_codigo = inCgrvc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE VACANTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO DE VACANTE
	*/
	public String getCGRVC_CODIGO(){
		return this.myCgrvc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	*/
	public void setCGVCN_CODIGO(String inCgvcn_codigo){
		this.myCgvcn_codigo = inCgvcn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	*/
	public String getCGVCN_CODIGO(){
		return this.myCgvcn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL REQUISITO
	* @param inCgrvc_requisito NOMBRE DEL REQUISITO
	*/
	public void setCGRVC_REQUISITO(String inCgrvc_requisito){
		this.myCgrvc_requisito = inCgrvc_requisito;
	}
	/**
	* OBTIENE NOMBRE DEL REQUISITO
	* @return String NOMBRE DEL REQUISITO
	*/
	public String getCGRVC_REQUISITO(){
		return this.myCgrvc_requisito;
	}

	/**
	* ESTABLECE CAMPO DE OBLIGATORIEDAD DEL REQUISITO
	* @param inCgrvc_obligatorio CAMPO DE OBLIGATORIEDAD DEL REQUISITO
	*/
	public void setCGRVC_OBLIGATORIO(boolean inCgrvc_obligatorio){
		this.myCgrvc_obligatorio = inCgrvc_obligatorio;
	}
	/**
	* OBTIENE CAMPO DE OBLIGATORIEDAD DEL REQUISITO
	* @return boolean CAMPO DE OBLIGATORIEDAD DEL REQUISITO
	*/
	public boolean getCGRVC_OBLIGATORIO(){
		return this.myCgrvc_obligatorio;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgrvc_estado ESTADO DEL REGISTRO
	*/
	public void setCGRVC_ESTADO(boolean inCgrvc_estado){
		this.myCgrvc_estado = inCgrvc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGRVC_ESTADO(){
		return this.myCgrvc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgrvc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGRVC_USUARIO_INSERT(String inCgrvc_usuario_insert){
		this.myCgrvc_usuario_insert = inCgrvc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGRVC_USUARIO_INSERT(){
		return this.myCgrvc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgrvc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGRVC_USUARIO_UPDATE(String inCgrvc_usuario_update){
		this.myCgrvc_usuario_update = inCgrvc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGRVC_USUARIO_UPDATE(){
		return this.myCgrvc_usuario_update;
	}

}
