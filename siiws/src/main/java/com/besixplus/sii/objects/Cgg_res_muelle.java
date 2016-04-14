package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_muelle
* TABLA: MUELLE
* DESCRIPCION:ALMACENA INFORMACION DE LOS MUELLES  PARA CONTROL INTERNO DE MOVILIDAD
* ABREVIATURA:CRMLE
*/
public class Cgg_res_muelle implements Serializable{
	private static final long serialVersionUID = 840760802;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrmle_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE DEL CANTON
	*/
	private String myCanton;
	/**
	* NOMBRE DEL MUELLE
	*/
	private String myCrmle_nombre;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrmle_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrmle_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrmle_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_muelle
	*/
	public Cgg_res_muelle(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_muelle
	* @param inCrmle_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmle_nombre NOMBRE DEL MUELLE
	* @param inCrmle_estado ESTADO DEL REGISTRO
	* @param inCrmle_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmle_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_muelle(
		String inCrmle_codigo,
		String inCctn_codigo,
		String inCrmle_nombre,
		boolean inCrmle_estado,
		String inCrmle_usuario_insert,
		String inCrmle_usuario_update
	){
		this.setCRMLE_CODIGO(inCrmle_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCRMLE_NOMBRE(inCrmle_nombre);
		this.setCRMLE_ESTADO(inCrmle_estado);
		this.setCRMLE_USUARIO_INSERT(inCrmle_usuario_insert);
		this.setCRMLE_USUARIO_UPDATE(inCrmle_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmle_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRMLE_CODIGO(String inCrmle_codigo){
		this.myCrmle_codigo = inCrmle_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRMLE_CODIGO(){
		return this.myCrmle_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL MUELLE
	* @param inCrmle_nombre NOMBRE DEL MUELLE
	*/
	public void setCRMLE_NOMBRE(String inCrmle_nombre){
		this.myCrmle_nombre = inCrmle_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL MUELLE
	* @return String NOMBRE DEL MUELLE
	*/
	public String getCRMLE_NOMBRE(){
		return this.myCrmle_nombre;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrmle_estado ESTADO DEL REGISTRO
	*/
	public void setCRMLE_ESTADO(boolean inCrmle_estado){
		this.myCrmle_estado = inCrmle_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRMLE_ESTADO(){
		return this.myCrmle_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmle_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRMLE_USUARIO_INSERT(String inCrmle_usuario_insert){
		this.myCrmle_usuario_insert = inCrmle_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRMLE_USUARIO_INSERT(){
		return this.myCrmle_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrmle_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRMLE_USUARIO_UPDATE(String inCrmle_usuario_update){
		this.myCrmle_usuario_update = inCrmle_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRMLE_USUARIO_UPDATE(){
		return this.myCrmle_usuario_update;
	}
	
	/**
	* ESTABLECE EL NOMBRE DEL CANTON  
	* @param inCanton NOMBRE DEL CANTON  
	*/
	public void setCANTON(String inCanton){
		this.myCanton = inCanton;
	}
	/**
	* OBTIENE EL NOMBRE DEL CANTON
	* @return String NOMBRE DEL CANTON
	*/
	public String getCANTON(){
		return this.myCanton;
	}

}
