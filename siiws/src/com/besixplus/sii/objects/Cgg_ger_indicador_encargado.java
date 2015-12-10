package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_ger_indicador_encargado
* TABLA: GERENCIAL INDICADOR_ENCARGADO
* DESCRIPCION:ALMACENA INFORMACION DE LOS ENCARGADO DE LLENAR LOS INDICADORES
* ABREVIATURA:CGGIE
*/
public class Cgg_ger_indicador_encargado implements Serializable{
	private static final long serialVersionUID = 167470206;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggie_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggin_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCggie_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCggie_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCggie_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_encargado
	*/
	public Cgg_ger_indicador_encargado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador_encargado
	* @param inCggie_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggie_estado ESTADO DEL REGISTRO
	* @param inCggie_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggie_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_ger_indicador_encargado(
		String inCggie_codigo,
		String inCctn_codigo,
		String inCusu_codigo,
		String inCggin_codigo,
		boolean inCggie_estado,
		String inCggie_usuario_insert,
		String inCggie_usuario_update
	){
		this.setCGGIE_CODIGO(inCggie_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGGIN_CODIGO(inCggin_codigo);
		this.setCGGIE_ESTADO(inCggie_estado);
		this.setCGGIE_USUARIO_INSERT(inCggie_usuario_insert);
		this.setCGGIE_USUARIO_UPDATE(inCggie_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggie_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGGIE_CODIGO(String inCggie_codigo){
		this.myCggie_codigo = inCggie_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGGIE_CODIGO(){
		return this.myCggie_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGGIN_CODIGO(String inCggin_codigo){
		this.myCggin_codigo = inCggin_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGGIN_CODIGO(){
		return this.myCggin_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCggie_estado ESTADO DEL REGISTRO
	*/
	public void setCGGIE_ESTADO(boolean inCggie_estado){
		this.myCggie_estado = inCggie_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGGIE_ESTADO(){
		return this.myCggie_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggie_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGGIE_USUARIO_INSERT(String inCggie_usuario_insert){
		this.myCggie_usuario_insert = inCggie_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGGIE_USUARIO_INSERT(){
		return this.myCggie_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCggie_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGGIE_USUARIO_UPDATE(String inCggie_usuario_update){
		this.myCggie_usuario_update = inCggie_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGGIE_USUARIO_UPDATE(){
		return this.myCggie_usuario_update;
	}

}
