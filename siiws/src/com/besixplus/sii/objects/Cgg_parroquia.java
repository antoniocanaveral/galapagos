package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_parroquia
* TABLA: PARROQUIA
* DESCRIPCION:ALMACENA INFORMACION DE PARROQUIAS
* ABREVIATURA:CPRR
*/
public class Cgg_parroquia implements Serializable{
	private static final long serialVersionUID = 294097605;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	*/
	private String myCprr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE DE LA PARROQUIA
	*/
	private String myCprr_nombre;
	/**
	* DESCRIPCION DE LA PARROQUIA
	*/
	private String myCprr_descripcion;
	/**
	* UBICACION GEOGRAFICA DETERMINADA
0 - URBANA
1 - RURAL
	*/
	private int myCprr_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCprr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCprr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCprr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_parroquia
	*/
	public Cgg_parroquia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_parroquia
	* @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCprr_nombre NOMBRE DE LA PARROQUIA
	* @param inCprr_descripcion DESCRIPCION DE LA PARROQUIA
	* @param inCprr_tipo UBICACION GEOGRAFICA DETERMINADA
0 - URBANA
1 - RURAL
	* @param inCprr_estado ESTADO DEL REGISTRO
	* @param inCprr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCprr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_parroquia(
		String inCprr_codigo,
		String inCctn_codigo,
		String inCprr_nombre,
		String inCprr_descripcion,
		int inCprr_tipo,
		boolean inCprr_estado,
		String inCprr_usuario_insert,
		String inCprr_usuario_update
	){
		this.setCPRR_CODIGO(inCprr_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCPRR_NOMBRE(inCprr_nombre);
		this.setCPRR_DESCRIPCION(inCprr_descripcion);
		this.setCPRR_TIPO(inCprr_tipo);
		this.setCPRR_ESTADO(inCprr_estado);
		this.setCPRR_USUARIO_INSERT(inCprr_usuario_insert);
		this.setCPRR_USUARIO_UPDATE(inCprr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	* @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	*/
	public void setCPRR_CODIGO(String inCprr_codigo){
		this.myCprr_codigo = inCprr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	*/
	public String getCPRR_CODIGO(){
		return this.myCprr_codigo;
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
	* ESTABLECE NOMBRE DE LA PARROQUIA
	* @param inCprr_nombre NOMBRE DE LA PARROQUIA
	*/
	public void setCPRR_NOMBRE(String inCprr_nombre){
		this.myCprr_nombre = inCprr_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA PARROQUIA
	* @return String NOMBRE DE LA PARROQUIA
	*/
	public String getCPRR_NOMBRE(){
		return this.myCprr_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA PARROQUIA
	* @param inCprr_descripcion DESCRIPCION DE LA PARROQUIA
	*/
	public void setCPRR_DESCRIPCION(String inCprr_descripcion){
		this.myCprr_descripcion = inCprr_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA PARROQUIA
	* @return String DESCRIPCION DE LA PARROQUIA
	*/
	public String getCPRR_DESCRIPCION(){
		return this.myCprr_descripcion;
	}

	/**
	* ESTABLECE UBICACION GEOGRAFICA DETERMINADA
0 - URBANA
1 - RURAL
	* @param inCprr_tipo UBICACION GEOGRAFICA DETERMINADA
0 - URBANA
1 - RURAL
	*/
	public void setCPRR_TIPO(int inCprr_tipo){
		this.myCprr_tipo = inCprr_tipo;
	}
	/**
	* OBTIENE UBICACION GEOGRAFICA DETERMINADA
0 - URBANA
1 - RURAL
	* @return int UBICACION GEOGRAFICA DETERMINADA
0 - URBANA
1 - RURAL
	*/
	public int getCPRR_TIPO(){
		return this.myCprr_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCprr_estado ESTADO DEL REGISTRO
	*/
	public void setCPRR_ESTADO(boolean inCprr_estado){
		this.myCprr_estado = inCprr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCPRR_ESTADO(){
		return this.myCprr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCprr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCPRR_USUARIO_INSERT(String inCprr_usuario_insert){
		this.myCprr_usuario_insert = inCprr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCPRR_USUARIO_INSERT(){
		return this.myCprr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCprr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCPRR_USUARIO_UPDATE(String inCprr_usuario_update){
		this.myCprr_usuario_update = inCprr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCPRR_USUARIO_UPDATE(){
		return this.myCprr_usuario_update;
	}

}
