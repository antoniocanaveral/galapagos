package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_observado
* TABLA: OBSERVADO
* DESCRIPCION:ALMACENA INFORMACION DE LOS DOCUMENTOS PENDIENTES DE REGULARIZAR POR UNA PERSONA
* ABREVIATURA:CROBS
*/
public class Cgg_res_observado implements Serializable{
	private static final long serialVersionUID = 1112892930;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrobs_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* FECHA DE REGISTRO DE LA 0BSERVACION
	*/
	private java.util.Date myCrobs_fecha_observacion;
	/**
	* DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
	*/
	private String myCrobs_descripcion;
	/**
	* ESTADO QUE DETERMINA SI YA SE RESOLCIO LA OBSERVACION
	*/
	private int myCrobs_resuelto;
	/**
	* FECHA DE RESOLUCION DE LA OBSERVACION
	*/
	private java.util.Date myCrobs_fecha_resuelto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrobs_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrobs_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrobs_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_observado
	*/
	public Cgg_res_observado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_observado
	* @param inCrobs_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrobs_fecha_observacion FECHA DE REGISTRO DE LA 0BSERVACION
	* @param inCrobs_descripcion DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
	* @param inCrobs_resuelto ESTADO QUE DETERMINA SI YA SE RESOLCIO LA OBSERVACION
	* @param inCrobs_fecha_resuelto FECHA DE RESOLUCION DE LA OBSERVACION
	* @param inCrobs_estado ESTADO DEL REGISTRO
	* @param inCrobs_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrobs_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_observado(
		String inCrobs_codigo,
		String inCrper_codigo,
		java.util.Date inCrobs_fecha_observacion,
		String inCrobs_descripcion,
		int inCrobs_resuelto,
		java.util.Date inCrobs_fecha_resuelto,
		boolean inCrobs_estado,
		String inCrobs_usuario_insert,
		String inCrobs_usuario_update
	){
		this.setCROBS_CODIGO(inCrobs_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCROBS_FECHA_OBSERVACION(inCrobs_fecha_observacion);
		this.setCROBS_DESCRIPCION(inCrobs_descripcion);
		this.setCROBS_RESUELTO(inCrobs_resuelto);
		this.setCROBS_FECHA_RESUELTO(inCrobs_fecha_resuelto);
		this.setCROBS_ESTADO(inCrobs_estado);
		this.setCROBS_USUARIO_INSERT(inCrobs_usuario_insert);
		this.setCROBS_USUARIO_UPDATE(inCrobs_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrobs_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCROBS_CODIGO(String inCrobs_codigo){
		this.myCrobs_codigo = inCrobs_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCROBS_CODIGO(){
		return this.myCrobs_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DE LA 0BSERVACION
	* @param inCrobs_fecha_observacion FECHA DE REGISTRO DE LA 0BSERVACION
	*/
	public void setCROBS_FECHA_OBSERVACION(java.util.Date inCrobs_fecha_observacion){
		this.myCrobs_fecha_observacion = inCrobs_fecha_observacion;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DE LA 0BSERVACION
	* @return java.util.Date FECHA DE REGISTRO DE LA 0BSERVACION
	*/
	public java.util.Date getCROBS_FECHA_OBSERVACION(){
		return this.myCrobs_fecha_observacion;
	}

	/**
	* ESTABLECE DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
	* @param inCrobs_descripcion DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
	*/
	public void setCROBS_DESCRIPCION(String inCrobs_descripcion){
		this.myCrobs_descripcion = inCrobs_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
	* @return String DESCRIPCION DEL INCONVENIENTE QUE GENERO LA OBSERVACION
	*/
	public String getCROBS_DESCRIPCION(){
		return this.myCrobs_descripcion;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI YA SE RESOLCIO LA OBSERVACION
	* @param inCrobs_resuelto ESTADO QUE DETERMINA SI YA SE RESOLCIO LA OBSERVACION
	*/
	public void setCROBS_RESUELTO(int inCrobs_resuelto){
		this.myCrobs_resuelto = inCrobs_resuelto;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI YA SE RESOLCIO LA OBSERVACION
	* @return boolean ESTADO QUE DETERMINA SI YA SE RESOLCIO LA OBSERVACION
	*/
	public int getCROBS_RESUELTO(){
		return this.myCrobs_resuelto;
	}

	/**
	* ESTABLECE FECHA DE RESOLUCION DE LA OBSERVACION
	* @param inCrobs_fecha_resuelto FECHA DE RESOLUCION DE LA OBSERVACION
	*/
	public void setCROBS_FECHA_RESUELTO(java.util.Date inCrobs_fecha_resuelto){
		this.myCrobs_fecha_resuelto = inCrobs_fecha_resuelto;
	}
	/**
	* OBTIENE FECHA DE RESOLUCION DE LA OBSERVACION
	* @return java.util.Date FECHA DE RESOLUCION DE LA OBSERVACION
	*/
	public java.util.Date getCROBS_FECHA_RESUELTO(){
		return this.myCrobs_fecha_resuelto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrobs_estado ESTADO DEL REGISTRO
	*/
	public void setCROBS_ESTADO(boolean inCrobs_estado){
		this.myCrobs_estado = inCrobs_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCROBS_ESTADO(){
		return this.myCrobs_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrobs_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCROBS_USUARIO_INSERT(String inCrobs_usuario_insert){
		this.myCrobs_usuario_insert = inCrobs_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCROBS_USUARIO_INSERT(){
		return this.myCrobs_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrobs_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCROBS_USUARIO_UPDATE(String inCrobs_usuario_update){
		this.myCrobs_usuario_update = inCrobs_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCROBS_USUARIO_UPDATE(){
		return this.myCrobs_usuario_update;
	}

}
