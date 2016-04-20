package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_forma_salida
* TABLA: FORMA DE SALIDA
* DESCRIPCION:ALMACENA INFORMACION DE LAS RAZONES QUE MOTIVARON LA SALIDA DE LA PROVINCIA
* ABREVIATURA:CTFSL
*/
public class Cgg_tct_forma_salida implements Serializable{
	private static final long serialVersionUID = 1370207242;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtfsl_codigo;
	/**
	* NOMBRE DE LA FORMA DE SALIDA
	*/
	private String myCtfsl_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtfsl_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtfsl_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtfsl_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_forma_salida
	*/
	public Cgg_tct_forma_salida(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_forma_salida
	* @param inCtfsl_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtfsl_nombre NOMBRE DE LA FORMA DE SALIDA
	* @param inCtfsl_estado ESTADO DEL REGISTRO
	* @param inCtfsl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtfsl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_forma_salida(
		String inCtfsl_codigo,
		String inCtfsl_nombre,
		boolean inCtfsl_estado,
		String inCtfsl_usuario_insert,
		String inCtfsl_usuario_update
	){
		this.setCTFSL_CODIGO(inCtfsl_codigo);
		this.setCTFSL_NOMBRE(inCtfsl_nombre);
		this.setCTFSL_ESTADO(inCtfsl_estado);
		this.setCTFSL_USUARIO_INSERT(inCtfsl_usuario_insert);
		this.setCTFSL_USUARIO_UPDATE(inCtfsl_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtfsl_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTFSL_CODIGO(String inCtfsl_codigo){
		this.myCtfsl_codigo = inCtfsl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTFSL_CODIGO(){
		return this.myCtfsl_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA FORMA DE SALIDA
	* @param inCtfsl_nombre NOMBRE DE LA FORMA DE SALIDA
	*/
	public void setCTFSL_NOMBRE(String inCtfsl_nombre){
		this.myCtfsl_nombre = inCtfsl_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA FORMA DE SALIDA
	* @return String NOMBRE DE LA FORMA DE SALIDA
	*/
	public String getCTFSL_NOMBRE(){
		return this.myCtfsl_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtfsl_estado ESTADO DEL REGISTRO
	*/
	public void setCTFSL_ESTADO(boolean inCtfsl_estado){
		this.myCtfsl_estado = inCtfsl_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTFSL_ESTADO(){
		return this.myCtfsl_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtfsl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTFSL_USUARIO_INSERT(String inCtfsl_usuario_insert){
		this.myCtfsl_usuario_insert = inCtfsl_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTFSL_USUARIO_INSERT(){
		return this.myCtfsl_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtfsl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTFSL_USUARIO_UPDATE(String inCtfsl_usuario_update){
		this.myCtfsl_usuario_update = inCtfsl_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTFSL_USUARIO_UPDATE(){
		return this.myCtfsl_usuario_update;
	}

}
