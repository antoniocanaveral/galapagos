package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_perfil
* TABLA: PERFIL
* DESCRIPCION:ALMACENA INFORMACION DE LOS PERFILES GENERALES PARA LAS VACANTES DE EMPLEO.
* ABREVIATURA:CGPRF
*/
public class Cgg_gem_perfil implements Serializable{
	private static final long serialVersionUID = 644027744;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgprf_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgesp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgtpr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgnes_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgdst_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgprf_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgprf_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgprf_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil
	*/
	public Cgg_gem_perfil(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil
	* @param inCgprf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdst_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgprf_estado ESTADO DEL REGISTRO
	* @param inCgprf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgprf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_perfil(
		String inCgprf_codigo,
		String inCgesp_codigo,
		String inCgtpr_codigo,
		String inCgnes_codigo,
		String inCgdst_codigo,
		boolean inCgprf_estado,
		String inCgprf_usuario_insert,
		String inCgprf_usuario_update
	){
		this.setCGPRF_CODIGO(inCgprf_codigo);
		this.setCGESP_CODIGO(inCgesp_codigo);
		this.setCGTPR_CODIGO(inCgtpr_codigo);
		this.setCGNES_CODIGO(inCgnes_codigo);
		this.setCGDST_CODIGO(inCgdst_codigo);
		this.setCGPRF_ESTADO(inCgprf_estado);
		this.setCGPRF_USUARIO_INSERT(inCgprf_usuario_insert);
		this.setCGPRF_USUARIO_UPDATE(inCgprf_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgprf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGPRF_CODIGO(String inCgprf_codigo){
		this.myCgprf_codigo = inCgprf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGPRF_CODIGO(){
		return this.myCgprf_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGESP_CODIGO(String inCgesp_codigo){
		this.myCgesp_codigo = inCgesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGESP_CODIGO(){
		return this.myCgesp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGTPR_CODIGO(String inCgtpr_codigo){
		this.myCgtpr_codigo = inCgtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGTPR_CODIGO(){
		return this.myCgtpr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGNES_CODIGO(String inCgnes_codigo){
		this.myCgnes_codigo = inCgnes_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGNES_CODIGO(){
		return this.myCgnes_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdst_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGDST_CODIGO(String inCgdst_codigo){
		this.myCgdst_codigo = inCgdst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGDST_CODIGO(){
		return this.myCgdst_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgprf_estado ESTADO DEL REGISTRO
	*/
	public void setCGPRF_ESTADO(boolean inCgprf_estado){
		this.myCgprf_estado = inCgprf_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGPRF_ESTADO(){
		return this.myCgprf_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgprf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGPRF_USUARIO_INSERT(String inCgprf_usuario_insert){
		this.myCgprf_usuario_insert = inCgprf_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGPRF_USUARIO_INSERT(){
		return this.myCgprf_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgprf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGPRF_USUARIO_UPDATE(String inCgprf_usuario_update){
		this.myCgprf_usuario_update = inCgprf_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGPRF_USUARIO_UPDATE(){
		return this.myCgprf_usuario_update;
	}

}
