package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_oficial_seguimiento
* TABLA: OFICIAL SEGUIMIENTO
* DESCRIPCION:ALMACENA INFORMACION DE LOS OFICIALES DE SEGUIMIENTO ASIGNADOS PARA CONTROLAR LOS ESTADOS DE RESIDENCIA
* ABREVIATURA:CROSG
*/
public class Cgg_res_oficial_seguimiento implements Serializable{
	private static final long serialVersionUID = 1531822584;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrosg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICACION DE TIPO OFICIAL
	*/
	private int myCrosg_tipo_oficial;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrosg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrosg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrosg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_seguimiento
	*/
	public Cgg_res_oficial_seguimiento(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_seguimiento
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrosg_tipo_oficial  REGISTRO DEL TIPO OFICIAL
	* @param inCrosg_estado ESTADO DEL REGISTRO
	* @param inCrosg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrosg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_oficial_seguimiento(
		String inCrosg_codigo,
		String inCusu_codigo,
		int inCrosg_tipo_oficial,
		boolean inCrosg_estado,
		String inCrosg_usuario_insert,
		String inCrosg_usuario_update
	){
		this.setCROSG_CODIGO(inCrosg_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCROSG_TIPO_OFICIAL(inCrosg_tipo_oficial);
		this.setCROSG_ESTADO(inCrosg_estado);
		this.setCROSG_USUARIO_INSERT(inCrosg_usuario_insert);
		this.setCROSG_USUARIO_UPDATE(inCrosg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCROSG_CODIGO(String inCrosg_codigo){
		this.myCrosg_codigo = inCrosg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCROSG_CODIGO(){
		return this.myCrosg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}
	/**
	* ESTABLECE  REGISTRO DEL TIPO OFICIAL
	* @param inCrosg_tipo_oficial REGISTRO DEL TIPO OFICIAL
	*/
	public void setCROSG_TIPO_OFICIAL(int inCrosg_tipo_oficial){
		this.myCrosg_tipo_oficial = inCrosg_tipo_oficial;
	}
	/**
	* OBTIENE REGISTRO DEL TIPO OFICIAL
	* @return int IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public int getCROSG_TIPO_OFICIAL(){
		return this.myCrosg_tipo_oficial;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrosg_estado ESTADO DEL REGISTRO
	*/
	public void setCROSG_ESTADO(boolean inCrosg_estado){
		this.myCrosg_estado = inCrosg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCROSG_ESTADO(){
		return this.myCrosg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrosg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCROSG_USUARIO_INSERT(String inCrosg_usuario_insert){
		this.myCrosg_usuario_insert = inCrosg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCROSG_USUARIO_INSERT(){
		return this.myCrosg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrosg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCROSG_USUARIO_UPDATE(String inCrosg_usuario_update){
		this.myCrosg_usuario_update = inCrosg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCROSG_USUARIO_UPDATE(){
		return this.myCrosg_usuario_update;
	}

}
