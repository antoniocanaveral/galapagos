package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tipo_contacto
* TABLA: TIPO CONTACTO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE CONTACTO
* ABREVIATURA:CRTCO
*/
public class Cgg_res_tipo_contacto implements Serializable{
	private static final long serialVersionUID = 1057673175;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* NOMBRE DEL TIPO DE CONTACTO
	*/
	private String myCrtco_nombre;
	/**
	* NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
	*/
	private String myCrtco_nombre_imagen;
	/**
	* IMAGEN DESCRIPTIVA AFIN AL TIPO DE CONTACTO
	*/
	private byte[] myCrtco_imagen;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtco_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtco_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtco_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_contacto
	*/
	public Cgg_res_tipo_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_contacto
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCrtco_nombre NOMBRE DEL TIPO DE CONTACTO
	* @param inCrtco_nombre_imagen NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
	* @param inCrtco_imagen IMAGEN DESCRIPTIVA AFIN AL TIPO DE CONTACTO
	* @param inCrtco_estado ESTADO DEL REGISTRO
	* @param inCrtco_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtco_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tipo_contacto(
		String inCrtco_codigo,
		String inCrtco_nombre,
		String inCrtco_nombre_imagen,
		byte[] inCrtco_imagen,
		boolean inCrtco_estado,
		String inCrtco_usuario_insert,
		String inCrtco_usuario_update
	){
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCRTCO_NOMBRE(inCrtco_nombre);
		this.setCRTCO_NOMBRE_IMAGEN(inCrtco_nombre_imagen);
		this.setCRTCO_IMAGEN(inCrtco_imagen);
		this.setCRTCO_ESTADO(inCrtco_estado);
		this.setCRTCO_USUARIO_INSERT(inCrtco_usuario_insert);
		this.setCRTCO_USUARIO_UPDATE(inCrtco_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	public void setCRTCO_CODIGO(String inCrtco_codigo){
		this.myCrtco_codigo = inCrtco_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	public String getCRTCO_CODIGO(){
		return this.myCrtco_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL TIPO DE CONTACTO
	* @param inCrtco_nombre NOMBRE DEL TIPO DE CONTACTO
	*/
	public void setCRTCO_NOMBRE(String inCrtco_nombre){
		this.myCrtco_nombre = inCrtco_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL TIPO DE CONTACTO
	* @return String NOMBRE DEL TIPO DE CONTACTO
	*/
	public String getCRTCO_NOMBRE(){
		return this.myCrtco_nombre;
	}

	/**
	* ESTABLECE NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
	* @param inCrtco_nombre_imagen NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
	*/
	public void setCRTCO_NOMBRE_IMAGEN(String inCrtco_nombre_imagen){
		this.myCrtco_nombre_imagen = inCrtco_nombre_imagen;
	}
	/**
	* OBTIENE NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
	* @return String NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
	*/
	public String getCRTCO_NOMBRE_IMAGEN(){
		return this.myCrtco_nombre_imagen;
	}

	/**
	* ESTABLECE IMAGEN DESCRIPTIVA AFIN AL TIPO DE CONTACTO
	* @param inCrtco_imagen IMAGEN DESCRIPTIVA AFIN AL TIPO DE CONTACTO
	*/
	public void setCRTCO_IMAGEN(byte[] inCrtco_imagen){
		this.myCrtco_imagen = inCrtco_imagen;
	}
	/**
	* OBTIENE IMAGEN DESCRIPTIVA AFIN AL TIPO DE CONTACTO
	* @return byte[] IMAGEN DESCRIPTIVA AFIN AL TIPO DE CONTACTO
	*/
	public byte[] getCRTCO_IMAGEN(){
		return this.myCrtco_imagen;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtco_estado ESTADO DEL REGISTRO
	*/
	public void setCRTCO_ESTADO(boolean inCrtco_estado){
		this.myCrtco_estado = inCrtco_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTCO_ESTADO(){
		return this.myCrtco_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtco_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTCO_USUARIO_INSERT(String inCrtco_usuario_insert){
		this.myCrtco_usuario_insert = inCrtco_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTCO_USUARIO_INSERT(){
		return this.myCrtco_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtco_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTCO_USUARIO_UPDATE(String inCrtco_usuario_update){
		this.myCrtco_usuario_update = inCrtco_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTCO_USUARIO_UPDATE(){
		return this.myCrtco_usuario_update;
	}

}
