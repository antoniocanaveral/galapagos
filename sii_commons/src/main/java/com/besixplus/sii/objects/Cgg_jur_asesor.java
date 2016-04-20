package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_asesor
* TABLA: ASESOR DE PROCESO JUDICIAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS ASESORES JUDICIALES ASIGNADOS A UN PROCESO JUDICIAL
* ABREVIATURA:CJASE
*/
public class Cgg_jur_asesor implements Serializable{
	private static final long serialVersionUID = 1787627058;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
	*/
	private String myCjase_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	private String myCjpju_codigo;
	/**
	* ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
0 - NO ACTIVO
1 - ACTIVO
2 - OTRO
	*/
	private int myCjase_activo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjase_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjase_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjase_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor
	*/
	public Cgg_jur_asesor(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_asesor
	* @param inCjase_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCjase_activo ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
0 - NO ACTIVO
1 - ACTIVO
2 - OTRO
	* @param inCjase_estado ESTADO DEL REGISTRO
	* @param inCjase_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjase_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_asesor(
		String inCjase_codigo,
		String inCusu_codigo,
		String inCjpju_codigo,
		int inCjase_activo,
		boolean inCjase_estado,
		String inCjase_usuario_insert,
		String inCjase_usuario_update
	){
		this.setCJASE_CODIGO(inCjase_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCJPJU_CODIGO(inCjpju_codigo);
		this.setCJASE_ACTIVO(inCjase_activo);
		this.setCJASE_ESTADO(inCjase_estado);
		this.setCJASE_USUARIO_INSERT(inCjase_usuario_insert);
		this.setCJASE_USUARIO_UPDATE(inCjase_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
	* @param inCjase_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
	*/
	public void setCJASE_CODIGO(String inCjase_codigo){
		this.myCjase_codigo = inCjase_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
	*/
	public String getCJASE_CODIGO(){
		return this.myCjase_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	public void setCJPJU_CODIGO(String inCjpju_codigo){
		this.myCjpju_codigo = inCjpju_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	public String getCJPJU_CODIGO(){
		return this.myCjpju_codigo;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
0 - NO ACTIVO
1 - ACTIVO
2 - OTRO
	* @param inCjase_activo ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
0 - NO ACTIVO
1 - ACTIVO
2 - OTRO
	*/
	public void setCJASE_ACTIVO(int inCjase_activo){
		this.myCjase_activo = inCjase_activo;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
0 - NO ACTIVO
1 - ACTIVO
2 - OTRO
	* @return int ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
0 - NO ACTIVO
1 - ACTIVO
2 - OTRO
	*/
	public int getCJASE_ACTIVO(){
		return this.myCjase_activo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjase_estado ESTADO DEL REGISTRO
	*/
	public void setCJASE_ESTADO(boolean inCjase_estado){
		this.myCjase_estado = inCjase_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJASE_ESTADO(){
		return this.myCjase_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjase_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJASE_USUARIO_INSERT(String inCjase_usuario_insert){
		this.myCjase_usuario_insert = inCjase_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJASE_USUARIO_INSERT(){
		return this.myCjase_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjase_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJASE_USUARIO_UPDATE(String inCjase_usuario_update){
		this.myCjase_usuario_update = inCjase_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJASE_USUARIO_UPDATE(){
		return this.myCjase_usuario_update;
	}

}
