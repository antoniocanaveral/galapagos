package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_miembro_comite
* TABLA: MIEMBRO COMITE
* DESCRIPCION:ALMACENA INFORMACION DE LAS PERSONAS DESIGNADAS PARA ACTUAR COMO MIEMBROS DE COMITE
* ABREVIATURA:CRMBC
*/
public class Cgg_res_miembro_comite implements Serializable{
	private static final long serialVersionUID = 390126456;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrmbc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrcrg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	private String myCrdid_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
	*/
	private java.util.Date myCrmbc_fecha_inicio_funciones;
	/**
	* FECHA DE CESE DE FUNCIONES 
	*/
	private java.util.Date myCrmbc_fecha_fin_funciones;
	/**
	* ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
	*/
	private boolean myCrmbc_titular;
	/**
	* ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
	*/
	private boolean myCrmbc_autorizado;
	/**
	* ESTADO DEL REGISTRO QUE DETERMINA SI SE HALLA HABILITADO
SI / NO
	*/
	private boolean myCrmbc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrmbc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrmbc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_miembro_comite
	*/
	public Cgg_res_miembro_comite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_miembro_comite
	* @param inCrmbc_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCrmbc_fecha_inicio_funciones FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
	* @param inCrmbc_fecha_fin_funciones FECHA DE CESE DE FUNCIONES 
	* @param inCrmbc_titular ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
	* @param inCrmbc_autorizado ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
	* @param inCrmbc_estado ESTADO DEL REGISTRO QUE DETERMINA SI SE HALLA HABILITADO
SI / NO
	* @param inCrmbc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmbc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_miembro_comite(
		String inCrmbc_codigo,
		String inCrcrg_codigo,
		String inCrdid_codigo,
		String inCusu_codigo,
		java.util.Date inCrmbc_fecha_inicio_funciones,
		java.util.Date inCrmbc_fecha_fin_funciones,
		boolean inCrmbc_titular,
		boolean inCrmbc_autorizado,
		boolean inCrmbc_estado,
		String inCrmbc_usuario_insert,
		String inCrmbc_usuario_update
	){
		this.setCRMBC_CODIGO(inCrmbc_codigo);
		this.setCRCRG_CODIGO(inCrcrg_codigo);
		this.setCRDID_CODIGO(inCrdid_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRMBC_FECHA_INICIO_FUNCIONES(inCrmbc_fecha_inicio_funciones);
		this.setCRMBC_FECHA_FIN_FUNCIONES(inCrmbc_fecha_fin_funciones);
		this.setCRMBC_TITULAR(inCrmbc_titular);
		this.setCRMBC_AUTORIZADO(inCrmbc_autorizado);
		this.setCRMBC_ESTADO(inCrmbc_estado);
		this.setCRMBC_USUARIO_INSERT(inCrmbc_usuario_insert);
		this.setCRMBC_USUARIO_UPDATE(inCrmbc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrmbc_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRMBC_CODIGO(String inCrmbc_codigo){
		this.myCrmbc_codigo = inCrmbc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRMBC_CODIGO(){
		return this.myCrmbc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRCRG_CODIGO(String inCrcrg_codigo){
		this.myCrcrg_codigo = inCrcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRCRG_CODIGO(){
		return this.myCrcrg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	public void setCRDID_CODIGO(String inCrdid_codigo){
		this.myCrdid_codigo = inCrdid_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	public String getCRDID_CODIGO(){
		return this.myCrdid_codigo;
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
	* ESTABLECE FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
	* @param inCrmbc_fecha_inicio_funciones FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
	*/
	public void setCRMBC_FECHA_INICIO_FUNCIONES(java.util.Date inCrmbc_fecha_inicio_funciones){
		this.myCrmbc_fecha_inicio_funciones = inCrmbc_fecha_inicio_funciones;
	}
	/**
	* OBTIENE FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
	* @return java.util.Date FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
	*/
	public java.util.Date getCRMBC_FECHA_INICIO_FUNCIONES(){
		return this.myCrmbc_fecha_inicio_funciones;
	}

	/**
	* ESTABLECE FECHA DE CESE DE FUNCIONES 
	* @param inCrmbc_fecha_fin_funciones FECHA DE CESE DE FUNCIONES 
	*/
	public void setCRMBC_FECHA_FIN_FUNCIONES(java.util.Date inCrmbc_fecha_fin_funciones){
		this.myCrmbc_fecha_fin_funciones = inCrmbc_fecha_fin_funciones;
	}
	/**
	* OBTIENE FECHA DE CESE DE FUNCIONES 
	* @return java.util.Date FECHA DE CESE DE FUNCIONES 
	*/
	public java.util.Date getCRMBC_FECHA_FIN_FUNCIONES(){
		return this.myCrmbc_fecha_fin_funciones;
	}

	/**
	* ESTABLECE ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
	* @param inCrmbc_titular ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
	*/
	public void setCRMBC_TITULAR(boolean inCrmbc_titular){
		this.myCrmbc_titular = inCrmbc_titular;
	}
	/**
	* OBTIENE ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
	* @return boolean ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
	*/
	public boolean getCRMBC_TITULAR(){
		return this.myCrmbc_titular;
	}

	/**
	* ESTABLECE ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
	* @param inCrmbc_autorizado ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
	*/
	public void setCRMBC_AUTORIZADO(boolean inCrmbc_autorizado){
		this.myCrmbc_autorizado = inCrmbc_autorizado;
	}
	/**
	* OBTIENE ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
	* @return boolean ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
	*/
	public boolean getCRMBC_AUTORIZADO(){
		return this.myCrmbc_autorizado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO QUE DETERMINA SI SE HALLA HABILITADO
SI / NO
	* @param inCrmbc_estado ESTADO DEL REGISTRO QUE DETERMINA SI SE HALLA HABILITADO
SI / NO
	*/
	public void setCRMBC_ESTADO(boolean inCrmbc_estado){
		this.myCrmbc_estado = inCrmbc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO QUE DETERMINA SI SE HALLA HABILITADO
SI / NO
	* @return boolean ESTADO DEL REGISTRO QUE DETERMINA SI SE HALLA HABILITADO
SI / NO
	*/
	public boolean getCRMBC_ESTADO(){
		return this.myCrmbc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmbc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRMBC_USUARIO_INSERT(String inCrmbc_usuario_insert){
		this.myCrmbc_usuario_insert = inCrmbc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRMBC_USUARIO_INSERT(){
		return this.myCrmbc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrmbc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRMBC_USUARIO_UPDATE(String inCrmbc_usuario_update){
		this.myCrmbc_usuario_update = inCrmbc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRMBC_USUARIO_UPDATE(){
		return this.myCrmbc_usuario_update;
	}

}
