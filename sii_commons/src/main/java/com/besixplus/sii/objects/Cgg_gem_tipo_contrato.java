package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_tipo_contrato
* TABLA: 
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE CONTRANTO A DARSE POR UNA VACANTE
* ABREVIATURA:CGTCN
*/
public class Cgg_gem_tipo_contrato implements Serializable{
	private static final long serialVersionUID = 860439916;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	*/
	private String myCgtcn_codigo;
	/**
	* DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
	*/
	private String myCgtcn_descripcion;
	/**
	* OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
	*/
	private String myCgtcn_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgtcn_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgtcn_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgtcn_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_tipo_contrato
	*/
	public Cgg_gem_tipo_contrato(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_tipo_contrato
	* @param inCgtcn_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	* @param inCgtcn_descripcion DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
	* @param inCgtcn_observacion OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
	* @param inCgtcn_estado ESTADO DEL REGISTRO
	* @param inCgtcn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgtcn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_tipo_contrato(
		String inCgtcn_codigo,
		String inCgtcn_descripcion,
		String inCgtcn_observacion,
		boolean inCgtcn_estado,
		String inCgtcn_usuario_insert,
		String inCgtcn_usuario_update
	){
		this.setCGTCN_CODIGO(inCgtcn_codigo);
		this.setCGTCN_DESCRIPCION(inCgtcn_descripcion);
		this.setCGTCN_OBSERVACION(inCgtcn_observacion);
		this.setCGTCN_ESTADO(inCgtcn_estado);
		this.setCGTCN_USUARIO_INSERT(inCgtcn_usuario_insert);
		this.setCGTCN_USUARIO_UPDATE(inCgtcn_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	* @param inCgtcn_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	*/
	public void setCGTCN_CODIGO(String inCgtcn_codigo){
		this.myCgtcn_codigo = inCgtcn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	*/
	public String getCGTCN_CODIGO(){
		return this.myCgtcn_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
	* @param inCgtcn_descripcion DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
	*/
	public void setCGTCN_DESCRIPCION(String inCgtcn_descripcion){
		this.myCgtcn_descripcion = inCgtcn_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
	* @return String DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
	*/
	public String getCGTCN_DESCRIPCION(){
		return this.myCgtcn_descripcion;
	}

	/**
	* ESTABLECE OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
	* @param inCgtcn_observacion OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
	*/
	public void setCGTCN_OBSERVACION(String inCgtcn_observacion){
		this.myCgtcn_observacion = inCgtcn_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
	* @return String OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
	*/
	public String getCGTCN_OBSERVACION(){
		return this.myCgtcn_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgtcn_estado ESTADO DEL REGISTRO
	*/
	public void setCGTCN_ESTADO(boolean inCgtcn_estado){
		this.myCgtcn_estado = inCgtcn_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGTCN_ESTADO(){
		return this.myCgtcn_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgtcn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGTCN_USUARIO_INSERT(String inCgtcn_usuario_insert){
		this.myCgtcn_usuario_insert = inCgtcn_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGTCN_USUARIO_INSERT(){
		return this.myCgtcn_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgtcn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGTCN_USUARIO_UPDATE(String inCgtcn_usuario_update){
		this.myCgtcn_usuario_update = inCgtcn_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGTCN_USUARIO_UPDATE(){
		return this.myCgtcn_usuario_update;
	}

}
