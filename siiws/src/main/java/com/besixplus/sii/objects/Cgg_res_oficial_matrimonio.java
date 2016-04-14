package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_oficial_matrimonio
* TABLA: OFICIAL MATRIMONIO
* DESCRIPCION:ALMACENA INFORMACION DE LOS OFICIALES ENCARGADOS DE REALIZAR SEGUIMIENTO A PAREJAS
* ABREVIATURA:CROFM
*/
public class Cgg_res_oficial_matrimonio implements Serializable{
	private static final long serialVersionUID = 1228879763;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrofm_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrmtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_nombres;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_apellidos;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrofm_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrofm_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrofm_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_matrimonio
	*/
	public Cgg_res_oficial_matrimonio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_matrimonio
	* @param inCrofm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrofm_estado ESTADO DEL REGISTRO
	* @param inCrofm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrofm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_oficial_matrimonio(
		String inCrofm_codigo,
		String inCrmtr_codigo,
		String inCusu_codigo,
		boolean inCrofm_estado,
		String inCrofm_usuario_insert,
		String inCrofm_usuario_update
	){
		this.setCROFM_CODIGO(inCrofm_codigo);
		this.setCRMTR_CODIGO(inCrmtr_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);		
		this.setCROFM_ESTADO(inCrofm_estado);
		this.setCROFM_USUARIO_INSERT(inCrofm_usuario_insert);
		this.setCROFM_USUARIO_UPDATE(inCrofm_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrofm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCROFM_CODIGO(String inCrofm_codigo){
		this.myCrofm_codigo = inCrofm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCROFM_CODIGO(){
		return this.myCrofm_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRMTR_CODIGO(String inCrmtr_codigo){
		this.myCrmtr_codigo = inCrmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRMTR_CODIGO(){
		return this.myCrmtr_codigo;
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
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrofm_estado ESTADO DEL REGISTRO
	*/
	public void setCROFM_ESTADO(boolean inCrofm_estado){
		this.myCrofm_estado = inCrofm_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCROFM_ESTADO(){
		return this.myCrofm_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrofm_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCROFM_USUARIO_INSERT(String inCrofm_usuario_insert){
		this.myCrofm_usuario_insert = inCrofm_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCROFM_USUARIO_INSERT(){
		return this.myCrofm_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrofm_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCROFM_USUARIO_UPDATE(String inCrofm_usuario_update){
		this.myCrofm_usuario_update = inCrofm_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCROFM_USUARIO_UPDATE(){
		return this.myCrofm_usuario_update;
	}
	/**
	* ESTABLECE EL NOMBRE DEL USUARIO 
	* @param inCusu_nombres NOMBRE DEL USUARIO
	*/
	public void setCUSU_NOMBRES(String inCusu_nombres){
		this.myCusu_nombres = inCusu_nombres;
	}
	/**
	* OBTIENE EL NOMMBRE DEL USUARIO 
	* @return String  NOMBRE DEL USUARIO 
	*/
	public String getCUSU_NOMBRES(){
		return this.myCusu_nombres;
	}
	/**
	* ESTABLECE EL APELLIDO DEL USUARIO 
	* @param inCusu_apellidos APELLIDO DEL USUARIO
	*/
	public void setCUSU_APELLIDOS(String inCusu_apellidos){
		this.myCusu_apellidos = inCusu_apellidos;
	}
	/**
	* OBTIENE EL NOMMBRE DEL USUARIO 
	* @return String  NOMBRE DEL USUARIO 
	*/
	public String getCUSU_APELLIDOS(){
		return this.myCusu_apellidos;
	}

}
