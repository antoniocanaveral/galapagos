package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_tipo_proceso
* TABLA: TIPO DE PROCESO DE CONTRATACION
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE PROCESOS PARA CONTRATACION.
* ABREVIATURA:CJTPR
*/
public class Cgg_jur_tipo_proceso implements Serializable{
	private static final long serialVersionUID = 301000081;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	*/
	private String myCjtpr_codigo;
	/**
	* NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
	*/
	private String myCjtpr_nombre;
	/**
	* CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	*/
	private String myCjtpr_descripcion;
	/**
	* ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	*/
	private boolean myCjtpr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjtpr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjtpr_usuario_update;
	/**
	* TIPO DE PROCESO:
0 - CONTRATO
1 - CONVENIO
	*/
	private int myCjtpr_tipo;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_tipo_proceso
	*/
	public Cgg_jur_tipo_proceso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_tipo_proceso
	* @param inCjtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	* @param inCjtpr_nombre NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
	* @param inCjtpr_descripcion CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	* @param inCjtpr_estado ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	* @param inCjtpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjtpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjtpr_tipo TIPO DE PROCESO:
0 - CONTRATO
1 - CONVENIO
	*/
	public Cgg_jur_tipo_proceso(
		String inCjtpr_codigo,
		String inCjtpr_nombre,
		String inCjtpr_descripcion,
		boolean inCjtpr_estado,
		String inCjtpr_usuario_insert,
		String inCjtpr_usuario_update,
		int inCjtpr_tipo
	){
		this.setCJTPR_CODIGO(inCjtpr_codigo);
		this.setCJTPR_NOMBRE(inCjtpr_nombre);
		this.setCJTPR_DESCRIPCION(inCjtpr_descripcion);
		this.setCJTPR_ESTADO(inCjtpr_estado);
		this.setCJTPR_USUARIO_INSERT(inCjtpr_usuario_insert);
		this.setCJTPR_USUARIO_UPDATE(inCjtpr_usuario_update);
		this.setCJTPR_TIPO(inCjtpr_tipo);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	* @param inCjtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	*/
	public void setCJTPR_CODIGO(String inCjtpr_codigo){
		this.myCjtpr_codigo = inCjtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	*/
	public String getCJTPR_CODIGO(){
		return this.myCjtpr_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
	* @param inCjtpr_nombre NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
	*/
	public void setCJTPR_NOMBRE(String inCjtpr_nombre){
		this.myCjtpr_nombre = inCjtpr_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
	* @return String NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
	*/
	public String getCJTPR_NOMBRE(){
		return this.myCjtpr_nombre;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	* @param inCjtpr_descripcion CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	*/
	public void setCJTPR_DESCRIPCION(String inCjtpr_descripcion){
		this.myCjtpr_descripcion = inCjtpr_descripcion;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	* @return String CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	*/
	public String getCJTPR_DESCRIPCION(){
		return this.myCjtpr_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	* @param inCjtpr_estado ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	*/
	public void setCJTPR_ESTADO(boolean inCjtpr_estado){
		this.myCjtpr_estado = inCjtpr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	* @return boolean ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	*/
	public boolean getCJTPR_ESTADO(){
		return this.myCjtpr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjtpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJTPR_USUARIO_INSERT(String inCjtpr_usuario_insert){
		this.myCjtpr_usuario_insert = inCjtpr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJTPR_USUARIO_INSERT(){
		return this.myCjtpr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjtpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJTPR_USUARIO_UPDATE(String inCjtpr_usuario_update){
		this.myCjtpr_usuario_update = inCjtpr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJTPR_USUARIO_UPDATE(){
		return this.myCjtpr_usuario_update;
	}

	/**
	* ESTABLECE TIPO DE PROCESO:
0 - CONTRATO
1 - CONVENIO
	* @param inCjtpr_tipo TIPO DE PROCESO:
0 - CONTRATO
1 - CONVENIO
	*/
	public void setCJTPR_TIPO(int inCjtpr_tipo){
		this.myCjtpr_tipo = inCjtpr_tipo;
	}
	/**
	* OBTIENE TIPO DE PROCESO:
0 - CONTRATO
1 - CONVENIO
	* @return int TIPO DE PROCESO:
0 - CONTRATO
1 - CONVENIO
	*/
	public int getCJTPR_TIPO(){
		return this.myCjtpr_tipo;
	}

}
