package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_encuesta
* TABLA: ENCUESTA
* DESCRIPCION:ALMACENA INFORMACION DE LAS EVALUACIONES O ENCUESTAS A APLICARSE 
* ABREVIATURA:CDENC
*/
public class Cgg_dhu_encuesta implements Serializable{
	private static final long serialVersionUID = 1699059107;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	private String myCdenc_codigo;
	/**
	* NOMBRE DE LA EVALUACION
	*/
	private String myCdenc_nombre;
	/**
	* OBSERVACION DE LA EVALUACION
	*/
	private String myCdenc_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdenc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdenc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdenc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_encuesta
	*/
	public Cgg_dhu_encuesta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_encuesta
	* @param inCdenc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @param inCdenc_nombre NOMBRE DE LA EVALUACION
	* @param inCdenc_observacion OBSERVACION DE LA EVALUACION
	* @param inCdenc_estado ESTADO DEL REGISTRO
	* @param inCdenc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdenc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_encuesta(
		String inCdenc_codigo,
		String inCdenc_nombre,
		String inCdenc_observacion,
		boolean inCdenc_estado,
		String inCdenc_usuario_insert,
		String inCdenc_usuario_update
	){
		this.setCDENC_CODIGO(inCdenc_codigo);
		this.setCDENC_NOMBRE(inCdenc_nombre);
		this.setCDENC_OBSERVACION(inCdenc_observacion);
		this.setCDENC_ESTADO(inCdenc_estado);
		this.setCDENC_USUARIO_INSERT(inCdenc_usuario_insert);
		this.setCDENC_USUARIO_UPDATE(inCdenc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @param inCdenc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	public void setCDENC_CODIGO(String inCdenc_codigo){
		this.myCdenc_codigo = inCdenc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
	*/
	public String getCDENC_CODIGO(){
		return this.myCdenc_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA EVALUACION
	* @param inCdenc_nombre NOMBRE DE LA EVALUACION
	*/
	public void setCDENC_NOMBRE(String inCdenc_nombre){
		this.myCdenc_nombre = inCdenc_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA EVALUACION
	* @return String NOMBRE DE LA EVALUACION
	*/
	public String getCDENC_NOMBRE(){
		return this.myCdenc_nombre;
	}

	/**
	* ESTABLECE OBSERVACION DE LA EVALUACION
	* @param inCdenc_observacion OBSERVACION DE LA EVALUACION
	*/
	public void setCDENC_OBSERVACION(String inCdenc_observacion){
		this.myCdenc_observacion = inCdenc_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA EVALUACION
	* @return String OBSERVACION DE LA EVALUACION
	*/
	public String getCDENC_OBSERVACION(){
		return this.myCdenc_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdenc_estado ESTADO DEL REGISTRO
	*/
	public void setCDENC_ESTADO(boolean inCdenc_estado){
		this.myCdenc_estado = inCdenc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDENC_ESTADO(){
		return this.myCdenc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdenc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDENC_USUARIO_INSERT(String inCdenc_usuario_insert){
		this.myCdenc_usuario_insert = inCdenc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDENC_USUARIO_INSERT(){
		return this.myCdenc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdenc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDENC_USUARIO_UPDATE(String inCdenc_usuario_update){
		this.myCdenc_usuario_update = inCdenc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDENC_USUARIO_UPDATE(){
		return this.myCdenc_usuario_update;
	}

}
