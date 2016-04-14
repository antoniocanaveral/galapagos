package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tst_opcion
* TABLA: OPCIONES DE LOS TIPOS DE SOLICITUD DE TRAMITE
* DESCRIPCION: CONTIENE LAS OPCIONES ESPECIALES DE LOS TIPOS DE SOLICITUDES
* ABREVIATURA: CRTSO
*/
public class Cgg_res_tst_opcion implements Serializable{
	private static final long serialVersionUID = 365365574;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	*/
	private String myCrtso_codigo;
	/**
	* NOMBRE CORTO DE LA OPCION
	*/
	private String myCrtso_nombre;
	/**
	* DESCRIPCION DE LA OPCION DEL TST
	*/
	private String myCrtso_descripcion;
	/**
	* ESTADO DEL REGISTRO, SI ESTA VALIDO O NO
	*/
	private boolean myCrtso_estado;
	/**
	* NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	*/
	private String myCrtso_usuario_insert;
	/**
	* NOMBRE DEL USUARIO QUE HIZO LA ACTUALIZACION
	*/
	private String myCrtso_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tst_opcion
	*/
	public Cgg_res_tst_opcion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tst_opcion
	* @param inCrtso_codigo IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	* @param inCrtso_nombre NOMBRE CORTO DE LA OPCION
	* @param inCrtso_descripcion DESCRIPCION DE LA OPCION DEL TST
	* @param inCrtso_estado ESTADO DEL REGISTRO, SI ESTA VALIDO O NO
	* @param inCrtso_usuario_insert NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	* @param inCrtso_usuario_update NOMBRE DEL USUARIO QUE HIZO LA ACTUALIZACION
	*/
	public Cgg_res_tst_opcion(
		String inCrtso_codigo,
		String inCrtso_nombre,
		String inCrtso_descripcion,
		boolean inCrtso_estado,
		String inCrtso_usuario_insert,
		String inCrtso_usuario_update
	){
		this.setCRTSO_CODIGO(inCrtso_codigo);
		this.setCRTSO_NOMBRE(inCrtso_nombre);
		this.setCRTSO_DESCRIPCION(inCrtso_descripcion);
		this.setCRTSO_ESTADO(inCrtso_estado);
		this.setCRTSO_USUARIO_INSERT(inCrtso_usuario_insert);
		this.setCRTSO_USUARIO_UPDATE(inCrtso_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	* @param inCrtso_codigo IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	*/
	public void setCRTSO_CODIGO(String inCrtso_codigo){
		this.myCrtso_codigo = inCrtso_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE TST OPCIONES
	*/
	public String getCRTSO_CODIGO(){
		return this.myCrtso_codigo;
	}

	/**
	* ESTABLECE NOMBRE CORTO DE LA OPCION
	* @param inCrtso_nombre NOMBRE CORTO DE LA OPCION
	*/
	public void setCRTSO_NOMBRE(String inCrtso_nombre){
		this.myCrtso_nombre = inCrtso_nombre;
	}
	/**
	* OBTIENE NOMBRE CORTO DE LA OPCION
	* @return String NOMBRE CORTO DE LA OPCION
	*/
	public String getCRTSO_NOMBRE(){
		return this.myCrtso_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA OPCION DEL TST
	* @param inCrtso_descripcion DESCRIPCION DE LA OPCION DEL TST
	*/
	public void setCRTSO_DESCRIPCION(String inCrtso_descripcion){
		this.myCrtso_descripcion = inCrtso_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA OPCION DEL TST
	* @return String DESCRIPCION DE LA OPCION DEL TST
	*/
	public String getCRTSO_DESCRIPCION(){
		return this.myCrtso_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO, SI ESTA VALIDO O NO
	* @param inCrtso_estado ESTADO DEL REGISTRO, SI ESTA VALIDO O NO
	*/
	public void setCRTSO_ESTADO(boolean inCrtso_estado){
		this.myCrtso_estado = inCrtso_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO, SI ESTA VALIDO O NO
	* @return boolean ESTADO DEL REGISTRO, SI ESTA VALIDO O NO
	*/
	public boolean getCRTSO_ESTADO(){
		return this.myCrtso_estado;
	}

	/**
	* ESTABLECE NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	* @param inCrtso_usuario_insert NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	*/
	public void setCRTSO_USUARIO_INSERT(String inCrtso_usuario_insert){
		this.myCrtso_usuario_insert = inCrtso_usuario_insert;
	}
	/**
	* OBTIENE NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	* @return String NOMBRE DEL USUARIO QUE CREO EL REGISTRO
	*/
	public String getCRTSO_USUARIO_INSERT(){
		return this.myCrtso_usuario_insert;
	}

	/**
	* ESTABLECE NOMBRE DEL USUARIO QUE HIZO LA ACTUALIZACION
	* @param inCrtso_usuario_update NOMBRE DEL USUARIO QUE HIZO LA ACTUALIZACION
	*/
	public void setCRTSO_USUARIO_UPDATE(String inCrtso_usuario_update){
		this.myCrtso_usuario_update = inCrtso_usuario_update;
	}
	/**
	* OBTIENE NOMBRE DEL USUARIO QUE HIZO LA ACTUALIZACION
	* @return String NOMBRE DEL USUARIO QUE HIZO LA ACTUALIZACION
	*/
	public String getCRTSO_USUARIO_UPDATE(){
		return this.myCrtso_usuario_update;
	}

}
