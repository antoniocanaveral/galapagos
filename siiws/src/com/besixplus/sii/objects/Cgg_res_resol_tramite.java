package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_resol_tramite
* TABLA: RESOLUCION TRAMITE
* DESCRIPCION: ALMACENA INFORMACION DE LOS TRAMITES CON LAS RESOLUCIONES
* ABREVIATURA:CRRST
*/
public class Cgg_res_resol_tramite implements Serializable{
	private static final long serialVersionUID = 1951060867;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION TRAMITE
	*/
	private String myCrrst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	private String myCrtra_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrrst_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrrst_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrrst_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_resol_tramite
	*/
	public Cgg_res_resol_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_resol_tramite
	* @param inCrrst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION TRAMITE
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrrst_estado ESTADO DEL REGISTRO
	* @param inCrrst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_resol_tramite(
		String inCrrst_codigo,
		String inCrres_codigo,
		String inCrtra_codigo,
		boolean inCrrst_estado,
		String inCrrst_usuario_insert,
		String inCrrst_usuario_update
	){
		this.setCRRST_CODIGO(inCrrst_codigo);
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCRRST_ESTADO(inCrrst_estado);
		this.setCRRST_USUARIO_INSERT(inCrrst_usuario_insert);
		this.setCRRST_USUARIO_UPDATE(inCrrst_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION TRAMITE
	* @param inCrrst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION TRAMITE
	*/
	public void setCRRST_CODIGO(String inCrrst_codigo){
		this.myCrrst_codigo = inCrrst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION TRAMITE
	*/
	public String getCRRST_CODIGO(){
		return this.myCrrst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public void setCRRES_CODIGO(String inCrres_codigo){
		this.myCrres_codigo = inCrres_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public String getCRRES_CODIGO(){
		return this.myCrres_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrrst_estado ESTADO DEL REGISTRO
	*/
	public void setCRRST_ESTADO(boolean inCrrst_estado){
		this.myCrrst_estado = inCrrst_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRRST_ESTADO(){
		return this.myCrrst_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRRST_USUARIO_INSERT(String inCrrst_usuario_insert){
		this.myCrrst_usuario_insert = inCrrst_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRRST_USUARIO_INSERT(){
		return this.myCrrst_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrrst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRRST_USUARIO_UPDATE(String inCrrst_usuario_update){
		this.myCrrst_usuario_update = inCrrst_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRRST_USUARIO_UPDATE(){
		return this.myCrrst_usuario_update;
	}

}
