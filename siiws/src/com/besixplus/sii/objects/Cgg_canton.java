package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_canton
* TABLA: CANTONES
* DESCRIPCION:ALMACENA INFORMACION DE CANTONES
* ABREVIATURA:CCTN
*/
public class Cgg_canton implements Serializable{
	private static final long serialVersionUID = 1068441950;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgprv_codigo;
	/**
	* NOMBRE DEL CANTON
	*/
	private String myCctn_nombre;
	/**
	* DESCRIPCION DEL CANTON 
	*/
	private String myCctn_descripcion;
	/**
	* DESCRIPCION DEL CANTON 
	*/
	private String myCctn_abreviatura;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCctn_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCctn_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCctn_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_canton
	*/
	public Cgg_canton(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_canton
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCgprv_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_nombre NOMBRE DEL CANTON
	* @param inCctn_descripcion DESCRIPCION DEL CANTON 
	* @param inCctn_abreviatura ALMACENA LA ABREVIATURA DEL CANTON
	* @param inCctn_estado ESTADO DEL REGISTRO
	* @param inCctn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCctn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_canton(
		String inCctn_codigo,
		String inCgprv_codigo,
		String inCctn_nombre,
		String inCctn_descripcion,
		String inCctn_abreviatura,
		boolean inCctn_estado,
		String inCctn_usuario_insert,
		String inCctn_usuario_update
	){
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCGPRV_CODIGO(inCgprv_codigo);
		this.setCCTN_NOMBRE(inCctn_nombre);
		this.setCCTN_DESCRIPCION(inCctn_descripcion);
		this.setCCTN_DESCRIPCION(inCctn_abreviatura);
		this.setCCTN_ESTADO(inCctn_estado);
		this.setCCTN_USUARIO_INSERT(inCctn_usuario_insert);
		this.setCCTN_USUARIO_UPDATE(inCctn_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgprv_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGPRV_CODIGO(String inCgprv_codigo){
		this.myCgprv_codigo = inCgprv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGPRV_CODIGO(){
		return this.myCgprv_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL CANTON
	* @param inCctn_nombre NOMBRE DEL CANTON
	*/
	public void setCCTN_NOMBRE(String inCctn_nombre){
		this.myCctn_nombre = inCctn_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL CANTON
	* @return String NOMBRE DEL CANTON
	*/
	public String getCCTN_NOMBRE(){
		return this.myCctn_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CANTON 
	* @param inCctn_descripcion DESCRIPCION DEL CANTON 
	*/
	public void setCCTN_DESCRIPCION(String inCctn_descripcion){
		this.myCctn_descripcion = inCctn_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL CANTON 
	* @return String DESCRIPCION DEL CANTON 
	*/
	public String getCCTN_DESCRIPCION(){
		return this.myCctn_descripcion;
	}
	/**
	* ESTABLECE DESCRIPCION DEL CANTON 
    * @param inCctn_abreviatura ALMACENA LA ABREVIATURA DEL CANTON
	*/
	public void setCCTN_ABREVIATURA(String inCctn_abreviatura){
		this.myCctn_abreviatura = inCctn_abreviatura;
	}
	/**
	* OBTIENE DESCRIPCION DEL CANTON 
	* @return String DESCRIPCION DEL CANTON 
	*/
	public String getCCTN_ABREVIATURA(){
		return this.myCctn_abreviatura;
	}
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCctn_estado ESTADO DEL REGISTRO
	*/
	public void setCCTN_ESTADO(boolean inCctn_estado){
		this.myCctn_estado = inCctn_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCCTN_ESTADO(){
		return this.myCctn_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCctn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCCTN_USUARIO_INSERT(String inCctn_usuario_insert){
		this.myCctn_usuario_insert = inCctn_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCCTN_USUARIO_INSERT(){
		return this.myCctn_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCctn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCCTN_USUARIO_UPDATE(String inCctn_usuario_update){
		this.myCctn_usuario_update = inCctn_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCCTN_USUARIO_UPDATE(){
		return this.myCctn_usuario_update;
	}

}
