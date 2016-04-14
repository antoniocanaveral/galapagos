package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_comite
* TABLA: COMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS COMITES ADMINISTRADOS POR EL CGG
* ABREVIATURA:CRCOM
*/
public class Cgg_res_comite implements Serializable{
	private static final long serialVersionUID = 19454;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrcom_codigo;
	/**
	* NOMBRE DEL COMITE
	*/
	private String myCrcom_nombre;
	/**
	* BREVE DESCRIPCION DEL COMITE 
	*/
	private String myCrcom_descripcion;
	/**
	* ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	*/
	private String myCrcom_abreviatura;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrcom_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrcom_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrcom_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_comite
	*/
	public Cgg_res_comite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_comite
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcom_nombre NOMBRE DEL COMITE
	* @param inCrcom_descripcion BREVE DESCRIPCION DEL COMITE 
	* @param inCrcom_abreviatura ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	* @param inCrcom_estado ESTADO DEL REGISTRO
	* @param inCrcom_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcom_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_comite(
		String inCrcom_codigo,
		String inCrcom_nombre,
		String inCrcom_descripcion,
		String inCrcom_abreviatura,
		boolean inCrcom_estado,
		String inCrcom_usuario_insert,
		String inCrcom_usuario_update
	){
		this.setCRCOM_CODIGO(inCrcom_codigo);
		this.setCRCOM_NOMBRE(inCrcom_nombre);
		this.setCRCOM_DESCRIPCION(inCrcom_descripcion);
		this.setCRCOM_ABREVIATURA(inCrcom_abreviatura);
		this.setCRCOM_ESTADO(inCrcom_estado);
		this.setCRCOM_USUARIO_INSERT(inCrcom_usuario_insert);
		this.setCRCOM_USUARIO_UPDATE(inCrcom_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRCOM_CODIGO(String inCrcom_codigo){
		this.myCrcom_codigo = inCrcom_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRCOM_CODIGO(){
		return this.myCrcom_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL COMITE
	* @param inCrcom_nombre NOMBRE DEL COMITE
	*/
	public void setCRCOM_NOMBRE(String inCrcom_nombre){
		this.myCrcom_nombre = inCrcom_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL COMITE
	* @return String NOMBRE DEL COMITE
	*/
	public String getCRCOM_NOMBRE(){
		return this.myCrcom_nombre;
	}

	/**
	* ESTABLECE BREVE DESCRIPCION DEL COMITE 
	* @param inCrcom_descripcion BREVE DESCRIPCION DEL COMITE 
	*/
	public void setCRCOM_DESCRIPCION(String inCrcom_descripcion){
		this.myCrcom_descripcion = inCrcom_descripcion;
	}
	/**
	* OBTIENE BREVE DESCRIPCION DEL COMITE 
	* @return String BREVE DESCRIPCION DEL COMITE 
	*/
	public String getCRCOM_DESCRIPCION(){
		return this.myCrcom_descripcion;
	}

	/**
	* ESTABLECE ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	* @param inCrcom_abreviatura ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	*/
	public void setCRCOM_ABREVIATURA(String inCrcom_abreviatura){
		this.myCrcom_abreviatura = inCrcom_abreviatura;
	}
	/**
	* OBTIENE ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	* @return String ABREVIIATURA DEL NOMBRE DE COMITE UTILIZADO PARA EL NUMERO DE RESOLUCIONES.
	*/
	public String getCRCOM_ABREVIATURA(){
		return this.myCrcom_abreviatura;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrcom_estado ESTADO DEL REGISTRO
	*/
	public void setCRCOM_ESTADO(boolean inCrcom_estado){
		this.myCrcom_estado = inCrcom_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRCOM_ESTADO(){
		return this.myCrcom_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcom_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRCOM_USUARIO_INSERT(String inCrcom_usuario_insert){
		this.myCrcom_usuario_insert = inCrcom_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRCOM_USUARIO_INSERT(){
		return this.myCrcom_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrcom_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRCOM_USUARIO_UPDATE(String inCrcom_usuario_update){
		this.myCrcom_usuario_update = inCrcom_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRCOM_USUARIO_UPDATE(){
		return this.myCrcom_usuario_update;
	}

}
