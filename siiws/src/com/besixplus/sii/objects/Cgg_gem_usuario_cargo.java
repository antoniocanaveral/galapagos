package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_usuario_cargo
* TABLA: USUARIO CARGO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CARGOS DE LOS QUE DESEA RECIBIR INFORMACION O UNA NOTIFICACION
* ABREVIATURA:CGUCR
*/
public class Cgg_gem_usuario_cargo implements Serializable{
	private static final long serialVersionUID = 569180101;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CARGO
	*/
	private String myCgucr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	private String myCgcrg_codigo;
	/**
	* ESTADO DE LAS SUBSCRIPCIONES DE SUBSCRIPCIONES 
0 - NO SUBSCRIPCIONES 
1 - SUBSCRIPCIONES
	*/
	private int myCgcrg_estado_subscripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgucr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgucr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgucr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_usuario_cargo
	*/
	public Cgg_gem_usuario_cargo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_usuario_cargo
	* @param inCgucr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CARGO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgcrg_estado_subscripcion ESTADO DE LAS SUBSCRIPCIONES DE SUBSCRIPCIONES 
0 - NO SUBSCRIPCIONES 
1 - SUBSCRIPCIONES
	* @param inCgucr_estado ESTADO DEL REGISTRO
	* @param inCgucr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgucr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_usuario_cargo(
		String inCgucr_codigo,
		String inCusu_codigo,
		String inCgcrg_codigo,
		int inCgcrg_estado_subscripcion,
		boolean inCgucr_estado,
		String inCgucr_usuario_insert,
		String inCgucr_usuario_update
	){
		this.setCGUCR_CODIGO(inCgucr_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGCRG_CODIGO(inCgcrg_codigo);
		this.setCGCRG_ESTADO_SUBSCRIPCION(inCgcrg_estado_subscripcion);
		this.setCGUCR_ESTADO(inCgucr_estado);
		this.setCGUCR_USUARIO_INSERT(inCgucr_usuario_insert);
		this.setCGUCR_USUARIO_UPDATE(inCgucr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CARGO
	* @param inCgucr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CARGO
	*/
	public void setCGUCR_CODIGO(String inCgucr_codigo){
		this.myCgucr_codigo = inCgucr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CARGO
	*/
	public String getCGUCR_CODIGO(){
		return this.myCgucr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public void setCGCRG_CODIGO(String inCgcrg_codigo){
		this.myCgcrg_codigo = inCgcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public String getCGCRG_CODIGO(){
		return this.myCgcrg_codigo;
	}

	/**
	* ESTABLECE ESTADO DE LAS SUBSCRIPCIONES DE SUBSCRIPCIONES 
0 - NO SUBSCRIPCIONES 
1 - SUBSCRIPCIONES
	* @param inCgcrg_estado_subscripcion ESTADO DE LAS SUBSCRIPCIONES DE SUBSCRIPCIONES 
0 - NO SUBSCRIPCIONES 
1 - SUBSCRIPCIONES
	*/
	public void setCGCRG_ESTADO_SUBSCRIPCION(int inCgcrg_estado_subscripcion){
		this.myCgcrg_estado_subscripcion = inCgcrg_estado_subscripcion;
	}
	/**
	* OBTIENE ESTADO DE LAS SUBSCRIPCIONES DE SUBSCRIPCIONES 
0 - NO SUBSCRIPCIONES 
1 - SUBSCRIPCIONES
	* @return int ESTADO DE LAS SUBSCRIPCIONES DE SUBSCRIPCIONES 
0 - NO SUBSCRIPCIONES 
1 - SUBSCRIPCIONES
	*/
	public int getCGCRG_ESTADO_SUBSCRIPCION(){
		return this.myCgcrg_estado_subscripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgucr_estado ESTADO DEL REGISTRO
	*/
	public void setCGUCR_ESTADO(boolean inCgucr_estado){
		this.myCgucr_estado = inCgucr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGUCR_ESTADO(){
		return this.myCgucr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgucr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGUCR_USUARIO_INSERT(String inCgucr_usuario_insert){
		this.myCgucr_usuario_insert = inCgucr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGUCR_USUARIO_INSERT(){
		return this.myCgucr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgucr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGUCR_USUARIO_UPDATE(String inCgucr_usuario_update){
		this.myCgucr_usuario_update = inCgucr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGUCR_USUARIO_UPDATE(){
		return this.myCgucr_usuario_update;
	}

}
