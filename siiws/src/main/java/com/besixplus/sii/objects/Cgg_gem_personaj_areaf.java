package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_personaj_areaf
* TABLA: PERSONA JURIDICA AREA FUNCIONAL
* DESCRIPCION:ALMACENA INFORMACION DE LAS AREAS FUNCIONALES DE INTERES PARA LA PERSONA JURIDICA
* ABREVIATURA:CGPJA
*/
public class Cgg_gem_personaj_areaf implements Serializable{
	private static final long serialVersionUID = 1910655857;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA AREA FUNCIONAL
	*/
	private String myCgpja_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	private String myCgare_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgpja_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgpja_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgpja_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_personaj_areaf
	*/
	public Cgg_gem_personaj_areaf(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_personaj_areaf
	* @param inCgpja_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA AREA FUNCIONAL
	* @param inCgare_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCgpja_estado ESTADO DEL REGISTRO
	* @param inCgpja_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgpja_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_personaj_areaf(
		String inCgpja_codigo,
		String inCgare_codigo,
		String inCrpjr_codigo,
		boolean inCgpja_estado,
		String inCgpja_usuario_insert,
		String inCgpja_usuario_update
	){
		this.setCGPJA_CODIGO(inCgpja_codigo);
		this.setCGARE_CODIGO(inCgare_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCGPJA_ESTADO(inCgpja_estado);
		this.setCGPJA_USUARIO_INSERT(inCgpja_usuario_insert);
		this.setCGPJA_USUARIO_UPDATE(inCgpja_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA AREA FUNCIONAL
	* @param inCgpja_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA AREA FUNCIONAL
	*/
	public void setCGPJA_CODIGO(String inCgpja_codigo){
		this.myCgpja_codigo = inCgpja_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA AREA FUNCIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA AREA FUNCIONAL
	*/
	public String getCGPJA_CODIGO(){
		return this.myCgpja_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @param inCgare_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	public void setCGARE_CODIGO(String inCgare_codigo){
		this.myCgare_codigo = inCgare_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
	*/
	public String getCGARE_CODIGO(){
		return this.myCgare_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgpja_estado ESTADO DEL REGISTRO
	*/
	public void setCGPJA_ESTADO(boolean inCgpja_estado){
		this.myCgpja_estado = inCgpja_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGPJA_ESTADO(){
		return this.myCgpja_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgpja_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGPJA_USUARIO_INSERT(String inCgpja_usuario_insert){
		this.myCgpja_usuario_insert = inCgpja_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGPJA_USUARIO_INSERT(){
		return this.myCgpja_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgpja_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGPJA_USUARIO_UPDATE(String inCgpja_usuario_update){
		this.myCgpja_usuario_update = inCgpja_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGPJA_USUARIO_UPDATE(){
		return this.myCgpja_usuario_update;
	}

}
