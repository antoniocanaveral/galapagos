package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_sesion_miembro
* TABLA: SESION MIEMBRO
* DESCRIPCION:ALMACENA INFORMACION DE LOS MIEMBROS DE COMITE QUE INTEGRAN UNA SESION
* ABREVIATURA:CRSMB
*/
public class Cgg_res_sesion_miembro implements Serializable{
	private static final long serialVersionUID = 815025139;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	*/
	private String myCrsmb_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	*/
	private String myCrssc_codigo;
	/**
	* IDENTIFICATIVO DE LA SESION DE COMITE
	*/
	private String mySesion;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	*/
	private String myCrmbc_codigo;
	/**
	* IDENTIFICATIVO DEL NOMBRE DEL MIEMBRO PRINCIPAL DE COMITE
	*/
	private String myPrincipal;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	*/
	private String myCgg_crmbc_codigo;
	/**
	* IDENTIFICATIVO DEL NOMBRE DEL MIEMBRO SUPLENTE DE COMITE 
	*/
	private String mySuplente;
	/**
	* DETERMINAR EL PRESIDENTE DE LA SESION
	*/
	private boolean myCrsmb_presidente;
	/**
	* DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	*/
	private boolean myCrsmb_presente;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrsmb_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrsmb_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrsmb_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_miembro
	*/
	public Cgg_res_sesion_miembro(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_sesion_miembro
	* @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	* @param inCrmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	* @param inCgg_crmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	* @param inCrsmb_presidente DETERMINAR EL PRESIDENTE DE LA SESION
	* @param inCrsmb_presente DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	* @param inCrsmb_estado ESTADO DEL REGISTRO
	* @param inCrsmb_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrsmb_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_sesion_miembro(
		String inCrsmb_codigo,
		String inCrssc_codigo,
		String inCrmbc_codigo,
		String inCgg_crmbc_codigo,
		boolean inCrsmb_presidente,
		boolean inCrsmb_presente,
		boolean inCrsmb_estado,
		String inCrsmb_usuario_insert,
		String inCrsmb_usuario_update
	){
		this.setCRSMB_CODIGO(inCrsmb_codigo);
		this.setCRSSC_CODIGO(inCrssc_codigo);
		this.setCRMBC_CODIGO(inCrmbc_codigo);
		this.setCGG_CRMBC_CODIGO(inCgg_crmbc_codigo);
		this.setCRSMB_PRESIDENTE(inCrsmb_presidente);
		this.setCRSMB_PRESENTE(inCrsmb_presente);
		this.setCRSMB_ESTADO(inCrsmb_estado);
		this.setCRSMB_USUARIO_INSERT(inCrsmb_usuario_insert);
		this.setCRSMB_USUARIO_UPDATE(inCrsmb_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	*/
	public void setCRSSC_CODIGO(String inCrssc_codigo){
		this.myCrssc_codigo = inCrssc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	*/
	public String getCRSSC_CODIGO(){
		return this.myCrssc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	* @param inCrmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	*/
	public void setCRMBC_CODIGO(String inCrmbc_codigo){
		this.myCrmbc_codigo = inCrmbc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	*/
	public String getCRMBC_CODIGO(){
		return this.myCrmbc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	* @param inCgg_crmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	*/
	public void setCGG_CRMBC_CODIGO(String inCgg_crmbc_codigo){
		this.myCgg_crmbc_codigo = inCgg_crmbc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	*/
	public String getCGG_CRMBC_CODIGO(){
		return this.myCgg_crmbc_codigo;
	}

	/**
	* ESTABLECE DETERMINAR EL PRESIDENTE DE LA SESION
	* @param inCrsmb_presidente DETERMINAR EL PRESIDENTE DE LA SESION
	*/
	public void setCRSMB_PRESIDENTE(boolean inCrsmb_presidente){
		this.myCrsmb_presidente = inCrsmb_presidente;
	}
	/**
	* OBTIENE DETERMINAR EL PRESIDENTE DE LA SESION
	* @return boolean DETERMINAR EL PRESIDENTE DE LA SESION
	*/
	public boolean getCRSMB_PRESIDENTE(){
		return this.myCrsmb_presidente;
	}
	/**
	* ESTABLECE DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	* @param inCrsmb_presente DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	*/
	public void setCRSMB_PRESENTE(boolean inCrsmb_presente){
		this.myCrsmb_presente = inCrsmb_presente;
	}
	/**
	* OBTIENE DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	* @return boolean DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	*/
	public boolean getCRSMB_PRESENTE(){
		return this.myCrsmb_presente;
	}
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrsmb_estado ESTADO DEL REGISTRO
	*/
	public void setCRSMB_ESTADO(boolean inCrsmb_estado){
		this.myCrsmb_estado = inCrsmb_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRSMB_ESTADO(){
		return this.myCrsmb_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrsmb_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRSMB_USUARIO_INSERT(String inCrsmb_usuario_insert){
		this.myCrsmb_usuario_insert = inCrsmb_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRSMB_USUARIO_INSERT(){
		return this.myCrsmb_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrsmb_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRSMB_USUARIO_UPDATE(String inCrsmb_usuario_update){
		this.myCrsmb_usuario_update = inCrsmb_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRSMB_USUARIO_UPDATE(){
		return this.myCrsmb_usuario_update;
	}
	/**
	* ESTABLECE EL NOMBRE DE LA SESION COMITE 
	* @param inSesion NOMBRE DE LA SESION COMITE 
	*/
	public void setSESION(String inSesion){
		this.mySesion = inSesion;
	}
	/**
	* OBTIENE EL NOMBRE DE LA SESION COMITE 
	* @return String NOMBRE DE LA SESION COMITE 
	*/
	public String getSESION(){
		return this.mySesion;
	}
	/**
	* ESTABLECE EL NOMBRE DEL MIEMBRO COMITE PRINCIPAL 
	* @param inPrincipal NOMBRE DEL MIEMBRO COMITE PRINCIPAL  
	*/
	public void setPRINCIPAL(String inPrincipal){
		this.myPrincipal = inPrincipal;
	}
	/**
	* OBTIENE NOMBRE DEL MIEMBRO COMITE PRINCIPAL 
	* @return String NOMBRE DEL MIEMBRO COMITE PRINCIPAL 
	*/
	public String getPRINCIPAL(){
		return this.myPrincipal;
	}
	/**
	* ESTABLECE EL NOMBRE DEL MIEMBRO COMITE SUPLENTE  
	* @param inSuplente NOMBRE DEL MIEMBRO COMITE SUPLENTE  
	*/
	public void setSUPLENTE(String inSuplente){
		this.mySuplente = inSuplente;
	}
	/**
	* OBTIENE EL NOMBRE DEL MIEMBRO COMITE SUPLENTE  
	* @return String NOMBRE DEL MIEMBRO COMITE SUPLENTE  
	*/
	public String getSUPLENTE(){
		return this.mySuplente;
	}

}
