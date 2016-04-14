package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_vacante_perfil
* TABLA: VACANTE PERFIL
* DESCRIPCION:ALMACENA INFORMACION DEL PERFIL REQUERIDO PARA UNA VACANTE.
* ABREVIATURA:CGVPR
*/
public class Cgg_gem_vacante_perfil implements Serializable{
	private static final long serialVersionUID = 1531787580;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO VACANTE PERFIL
	*/
	private String myCgvpr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	*/
	private String myCgvcn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO PERFIL
	*/
	private String myCgprf_codigo;
	/**
	* DESCRIPCION DEL PERFIL DE VACANTES
	*/
	private String myCgvpr_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgvpr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgvpr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgvpr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante_perfil
	*/
	public Cgg_gem_vacante_perfil(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante_perfil
	* @param inCgvpr_codigo IDENTIFICATIVO UNICO DE REGISTRO VACANTE PERFIL
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO VACANTE
	* @param inCgprf_codigo IDENTIFICATIVO UNICO DE REGISTRO PERFIL
	* @param inCgvpr_descripcion DESCRIPCION DEL PERFIL DE VACANTES
	* @param inCgvpr_estado ESTADO DEL REGISTRO
	* @param inCgvpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgvpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_vacante_perfil(
		String inCgvpr_codigo,
		String inCgvcn_codigo,
		String inCgprf_codigo,
		String inCgvpr_descripcion,
		boolean inCgvpr_estado,
		String inCgvpr_usuario_insert,
		String inCgvpr_usuario_update
	){
		this.setCGVPR_CODIGO(inCgvpr_codigo);
		this.setCGVCN_CODIGO(inCgvcn_codigo);
		this.setCGPRF_CODIGO(inCgprf_codigo);
		this.setCGVPR_DESCRIPCION(inCgvpr_descripcion);
		this.setCGVPR_ESTADO(inCgvpr_estado);
		this.setCGVPR_USUARIO_INSERT(inCgvpr_usuario_insert);
		this.setCGVPR_USUARIO_UPDATE(inCgvpr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO VACANTE PERFIL
	* @param inCgvpr_codigo IDENTIFICATIVO UNICO DE REGISTRO VACANTE PERFIL
	*/
	public void setCGVPR_CODIGO(String inCgvpr_codigo){
		this.myCgvpr_codigo = inCgvpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO VACANTE PERFIL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO VACANTE PERFIL
	*/
	public String getCGVPR_CODIGO(){
		return this.myCgvpr_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO PERFIL
	* @param inCgprf_codigo IDENTIFICATIVO UNICO DE REGISTRO PERFIL
	*/
	public void setCGPRF_CODIGO(String inCgprf_codigo){
		this.myCgprf_codigo = inCgprf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO PERFIL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO PERFIL
	*/
	public String getCGPRF_CODIGO(){
		return this.myCgprf_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL PERFIL DE VACANTES
	* @param inCgvpr_descripcion DESCRIPCION DEL PERFIL DE VACANTES
	*/
	public void setCGVPR_DESCRIPCION(String inCgvpr_descripcion){
		this.myCgvpr_descripcion = inCgvpr_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL PERFIL DE VACANTES
	* @return String DESCRIPCION DEL PERFIL DE VACANTES
	*/
	public String getCGVPR_DESCRIPCION(){
		return this.myCgvpr_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgvpr_estado ESTADO DEL REGISTRO
	*/
	public void setCGVPR_ESTADO(boolean inCgvpr_estado){
		this.myCgvpr_estado = inCgvpr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGVPR_ESTADO(){
		return this.myCgvpr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgvpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGVPR_USUARIO_INSERT(String inCgvpr_usuario_insert){
		this.myCgvpr_usuario_insert = inCgvpr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGVPR_USUARIO_INSERT(){
		return this.myCgvpr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgvpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGVPR_USUARIO_UPDATE(String inCgvpr_usuario_update){
		this.myCgvpr_usuario_update = inCgvpr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGVPR_USUARIO_UPDATE(){
		return this.myCgvpr_usuario_update;
	}

}
