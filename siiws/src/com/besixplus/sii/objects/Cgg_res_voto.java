package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_voto
* TABLA: VOTO
* DESCRIPCION:ALMACENA INFORMACION DE LOS VOTOS APLICADOS EN UNA SESION DE COMITE PARA DEFINIR UNA RESOLUCION
* ABREVIATURA:CRVTO
*/
public class Cgg_res_voto implements Serializable{
	private static final long serialVersionUID = 866087301;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	*/
	private String myCrvto_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	*/
	private String myCrsmb_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	*/
	private int myCrvto_votacion;
	/**
	* OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	*/
	private String myCrvto_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrvto_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrvto_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrvto_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_voto
	*/
	public Cgg_res_voto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_voto
	* @param inCrvto_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	* @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrvto_votacion ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	* @param inCrvto_observacion OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	* @param inCrvto_estado ESTADO DEL REGISTRO
	* @param inCrvto_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrvto_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_voto(
		String inCrvto_codigo,
		String inCrsmb_codigo,
		String inCrres_codigo,
		int inCrvto_votacion,
		String inCrvto_observacion,
		boolean inCrvto_estado,
		String inCrvto_usuario_insert,
		String inCrvto_usuario_update
	){
		this.setCRVTO_CODIGO(inCrvto_codigo);
		this.setCRSMB_CODIGO(inCrsmb_codigo);
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCRVTO_VOTACION(inCrvto_votacion);
		this.setCRVTO_OBSERVACION(inCrvto_observacion);
		this.setCRVTO_ESTADO(inCrvto_estado);
		this.setCRVTO_USUARIO_INSERT(inCrvto_usuario_insert);
		this.setCRVTO_USUARIO_UPDATE(inCrvto_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	* @param inCrvto_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	*/
	public void setCRVTO_CODIGO(String inCrvto_codigo){
		this.myCrvto_codigo = inCrvto_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	*/
	public String getCRVTO_CODIGO(){
		return this.myCrvto_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	* @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	*/
	public void setCRSMB_CODIGO(String inCrsmb_codigo){
		this.myCrsmb_codigo = inCrsmb_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	*/
	public String getCRSMB_CODIGO(){
		return this.myCrsmb_codigo;
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
	* ESTABLECE ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	* @param inCrvto_votacion ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	*/
	public void setCRVTO_VOTACION(int inCrvto_votacion){
		this.myCrvto_votacion = inCrvto_votacion;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	* @return int ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	*/
	public int getCRVTO_VOTACION(){
		return this.myCrvto_votacion;
	}

	/**
	* ESTABLECE OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	* @param inCrvto_observacion OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	*/
	public void setCRVTO_OBSERVACION(String inCrvto_observacion){
		this.myCrvto_observacion = inCrvto_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	* @return String OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	*/
	public String getCRVTO_OBSERVACION(){
		return this.myCrvto_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrvto_estado ESTADO DEL REGISTRO
	*/
	public void setCRVTO_ESTADO(boolean inCrvto_estado){
		this.myCrvto_estado = inCrvto_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRVTO_ESTADO(){
		return this.myCrvto_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrvto_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRVTO_USUARIO_INSERT(String inCrvto_usuario_insert){
		this.myCrvto_usuario_insert = inCrvto_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRVTO_USUARIO_INSERT(){
		return this.myCrvto_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrvto_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRVTO_USUARIO_UPDATE(String inCrvto_usuario_update){
		this.myCrvto_usuario_update = inCrvto_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRVTO_USUARIO_UPDATE(){
		return this.myCrvto_usuario_update;
	}

}
