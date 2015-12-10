package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tipo_doc_iden
* TABLA: TIPO DE DOCUMENTO DE IDENTIFICACION
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE DOCUMENTOS HABILITANTES PARA IDENTIFICAR UNA PERSONA.
* ABREVIATURA:CTDID
*/
public class Cgg_tipo_doc_iden implements Serializable{
	private static final long serialVersionUID = 1883095659;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO DE IDENTIFICACION
	*/
	private String myCtdid_codigo;
	/**
	* NOMBRE DEL DOCUMENTO
	*/
	private String myCtdid_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtdid_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtdid_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtdid_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tipo_doc_iden
	*/
	public Cgg_tipo_doc_iden(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tipo_doc_iden
	* @param inCtdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO DE IDENTIFICACION
	* @param inCtdid_nombre NOMBRE DEL DOCUMENTO
	* @param inCtdid_estado ESTADO DEL REGISTRO
	* @param inCtdid_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtdid_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tipo_doc_iden(
		String inCtdid_codigo,
		String inCtdid_nombre,
		boolean inCtdid_estado,
		String inCtdid_usuario_insert,
		String inCtdid_usuario_update
	){
		this.setCTDID_CODIGO(inCtdid_codigo);
		this.setCTDID_NOMBRE(inCtdid_nombre);
		this.setCTDID_ESTADO(inCtdid_estado);
		this.setCTDID_USUARIO_INSERT(inCtdid_usuario_insert);
		this.setCTDID_USUARIO_UPDATE(inCtdid_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO DE IDENTIFICACION
	* @param inCtdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO DE IDENTIFICACION
	*/
	public void setCTDID_CODIGO(String inCtdid_codigo){
		this.myCtdid_codigo = inCtdid_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO DE IDENTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO DE IDENTIFICACION
	*/
	public String getCTDID_CODIGO(){
		return this.myCtdid_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO
	* @param inCtdid_nombre NOMBRE DEL DOCUMENTO
	*/
	public void setCTDID_NOMBRE(String inCtdid_nombre){
		this.myCtdid_nombre = inCtdid_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO
	* @return String NOMBRE DEL DOCUMENTO
	*/
	public String getCTDID_NOMBRE(){
		return this.myCtdid_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtdid_estado ESTADO DEL REGISTRO
	*/
	public void setCTDID_ESTADO(boolean inCtdid_estado){
		this.myCtdid_estado = inCtdid_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTDID_ESTADO(){
		return this.myCtdid_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtdid_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTDID_USUARIO_INSERT(String inCtdid_usuario_insert){
		this.myCtdid_usuario_insert = inCtdid_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTDID_USUARIO_INSERT(){
		return this.myCtdid_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtdid_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTDID_USUARIO_UPDATE(String inCtdid_usuario_update){
		this.myCtdid_usuario_update = inCtdid_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTDID_USUARIO_UPDATE(){
		return this.myCtdid_usuario_update;
	}

}
