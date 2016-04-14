package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_ger_indicador
* TABLA: GERENCIAL INDICADOR
* DESCRIPCION:ALMACENA INFORMACION DE LOS INDICADORE QUE PUEDEN EXISTIR
* ABREVIATURA:CGGIN
*/
public class Cgg_ger_indicador implements Serializable{
	private static final long serialVersionUID = 120962638;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggin_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCggit_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE DEL INDICADOR
	*/
	private String myCggin_nombre;
	/**
	* DESCRIPCION DEL INDICADOR
	*/
	private String myCggin_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCggin_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCggin_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCggin_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador
	*/
	public Cgg_ger_indicador(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_ger_indicador
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggit_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE USUARIO
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE CANTON
	* @param inCggin_nombre NOMBRE DEL INDICADOR
	* @param inCggin_descripcion DESCRIPCION DEL INDICADOR
	* @param inCggin_estado ESTADO DEL REGISTRO
	* @param inCggin_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggin_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_ger_indicador(
		String inCggin_codigo,
		String inCggit_codigo,
		String inCusu_codigo,
		String inCctn_codigo,
		String inCggin_nombre,
		String inCggin_descripcion,
		boolean inCggin_estado,
		String inCggin_usuario_insert,
		String inCggin_usuario_update
	){
		this.setCGGIN_CODIGO(inCggin_codigo);
		this.setCGGIT_CODIGO(inCggit_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCGGIN_NOMBRE(inCggin_nombre);
		this.setCGGIN_DESCRIPCION(inCggin_descripcion);
		this.setCGGIN_ESTADO(inCggin_estado);
		this.setCGGIN_USUARIO_INSERT(inCggin_usuario_insert);
		this.setCGGIN_USUARIO_UPDATE(inCggin_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggit_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGGIT_CODIGO(String inCggit_codigo){
		this.myCggit_codigo = inCggit_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGGIT_CODIGO(){
		return this.myCggit_codigo;
	}
	
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE USUARIO
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
	* ESTABLECE IDENTIFICATIVO UNICO DE CANTON
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE CANTON
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE CANTON
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL INDICADOR
	* @param inCggin_nombre NOMBRE DEL INDICADOR
	*/
	public void setCGGIN_NOMBRE(String inCggin_nombre){
		this.myCggin_nombre = inCggin_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL INDICADOR
	* @return String NOMBRE DEL INDICADOR
	*/
	public String getCGGIN_NOMBRE(){
		return this.myCggin_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DEL INDICADOR
	* @param inCggin_descripcion DESCRIPCION DEL INDICADOR
	*/
	public void setCGGIN_DESCRIPCION(String inCggin_descripcion){
		this.myCggin_descripcion = inCggin_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL INDICADOR
	* @return String DESCRIPCION DEL INDICADOR
	*/
	public String getCGGIN_DESCRIPCION(){
		return this.myCggin_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCggin_estado ESTADO DEL REGISTRO
	*/
	public void setCGGIN_ESTADO(boolean inCggin_estado){
		this.myCggin_estado = inCggin_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGGIN_ESTADO(){
		return this.myCggin_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCggin_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGGIN_USUARIO_INSERT(String inCggin_usuario_insert){
		this.myCggin_usuario_insert = inCggin_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGGIN_USUARIO_INSERT(){
		return this.myCggin_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCggin_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGGIN_USUARIO_UPDATE(String inCggin_usuario_update){
		this.myCggin_usuario_update = inCggin_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGGIN_USUARIO_UPDATE(){
		return this.myCggin_usuario_update;
	}

}
