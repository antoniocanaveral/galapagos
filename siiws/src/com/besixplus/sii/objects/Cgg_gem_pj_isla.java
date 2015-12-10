package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_pj_isla
* TABLA: PERSONA JURIDICA
* DESCRIPCION:ALMACENA INFORMACION DE LAS EMPRESAS LOCALIZADAS EN LAS ISLAS.
* ABREVIATURA:CPJIS
*/
public class Cgg_gem_pj_isla implements Serializable{
	private static final long serialVersionUID = 1653339698;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCpjis_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrpjr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCisla_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCpjis_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCpjis_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCpjis_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_pj_isla
	*/
	public Cgg_gem_pj_isla(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_pj_isla
	* @param inCpjis_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCpjis_estado ESTADO DEL REGISTRO
	* @param inCpjis_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCpjis_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_pj_isla(
		String inCpjis_codigo,
		String inCrpjr_codigo,
		String inCisla_codigo,
		boolean inCpjis_estado,
		String inCpjis_usuario_insert,
		String inCpjis_usuario_update
	){
		this.setCPJIS_CODIGO(inCpjis_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCPJIS_ESTADO(inCpjis_estado);
		this.setCPJIS_USUARIO_INSERT(inCpjis_usuario_insert);
		this.setCPJIS_USUARIO_UPDATE(inCpjis_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCpjis_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCPJIS_CODIGO(String inCpjis_codigo){
		this.myCpjis_codigo = inCpjis_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCPJIS_CODIGO(){
		return this.myCpjis_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCISLA_CODIGO(String inCisla_codigo){
		this.myCisla_codigo = inCisla_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCISLA_CODIGO(){
		return this.myCisla_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCpjis_estado ESTADO DEL REGISTRO
	*/
	public void setCPJIS_ESTADO(boolean inCpjis_estado){
		this.myCpjis_estado = inCpjis_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCPJIS_ESTADO(){
		return this.myCpjis_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCpjis_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCPJIS_USUARIO_INSERT(String inCpjis_usuario_insert){
		this.myCpjis_usuario_insert = inCpjis_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCPJIS_USUARIO_INSERT(){
		return this.myCpjis_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCpjis_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCPJIS_USUARIO_UPDATE(String inCpjis_usuario_update){
		this.myCpjis_usuario_update = inCpjis_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCPJIS_USUARIO_UPDATE(){
		return this.myCpjis_usuario_update;
	}

}
