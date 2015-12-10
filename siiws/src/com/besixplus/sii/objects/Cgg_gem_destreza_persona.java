package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_destreza_persona
* TABLA: DESTREZA PERSONA
* DESCRIPCION:ALMACENA INFORMACION DE LAS HABILIDADES QUE TIENEN LOS RESIDENTES.
* ABREVIATURA:CGDPR
*/
public class Cgg_gem_destreza_persona implements Serializable{
	private static final long serialVersionUID = 224105531;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgdpr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgdst_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgdpr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgdpr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgdpr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_destreza_persona
	*/
	public Cgg_gem_destreza_persona(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_destreza_persona
	* @param inCgdpr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCgdst_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdpr_estado ESTADO DEL REGISTRO
	* @param inCgdpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgdpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_destreza_persona(
		String inCgdpr_codigo,
		String inCrper_codigo,
		String inCgdst_codigo,
		boolean inCgdpr_estado,
		String inCgdpr_usuario_insert,
		String inCgdpr_usuario_update
	){
		this.setCGDPR_CODIGO(inCgdpr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGDST_CODIGO(inCgdst_codigo);
		this.setCGDPR_ESTADO(inCgdpr_estado);
		this.setCGDPR_USUARIO_INSERT(inCgdpr_usuario_insert);
		this.setCGDPR_USUARIO_UPDATE(inCgdpr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdpr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGDPR_CODIGO(String inCgdpr_codigo){
		this.myCgdpr_codigo = inCgdpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGDPR_CODIGO(){
		return this.myCgdpr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgdst_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGDST_CODIGO(String inCgdst_codigo){
		this.myCgdst_codigo = inCgdst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGDST_CODIGO(){
		return this.myCgdst_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgdpr_estado ESTADO DEL REGISTRO
	*/
	public void setCGDPR_ESTADO(boolean inCgdpr_estado){
		this.myCgdpr_estado = inCgdpr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGDPR_ESTADO(){
		return this.myCgdpr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgdpr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGDPR_USUARIO_INSERT(String inCgdpr_usuario_insert){
		this.myCgdpr_usuario_insert = inCgdpr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGDPR_USUARIO_INSERT(){
		return this.myCgdpr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgdpr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGDPR_USUARIO_UPDATE(String inCgdpr_usuario_update){
		this.myCgdpr_usuario_update = inCgdpr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGDPR_USUARIO_UPDATE(){
		return this.myCgdpr_usuario_update;
	}

}
