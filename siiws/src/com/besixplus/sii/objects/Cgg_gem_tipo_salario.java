package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_tipo_salario
* TABLA: TIPO DE SALARIO
* DESCRIPCION:ALMACENA INFORMACION DEL TIPO DE SALARIO (DIARIO, MENSUAL, QUINCENAL, ETC.)
* ABREVIATURA:CGTSA
*/
public class Cgg_gem_tipo_salario implements Serializable{
	private static final long serialVersionUID = 381567910;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgtsa_codigo;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgtsa_nombre;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgtsa_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgtsa_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgtsa_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgtsa_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_tipo_salario
	*/
	public Cgg_gem_tipo_salario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_tipo_salario
	* @param inCgtsa_codigo NO ESPECIFICADO
	* @param inCgtsa_nombre NO ESPECIFICADO
	* @param inCgtsa_descripcion NO ESPECIFICADO
	* @param inCgtsa_estado ESTADO DEL REGISTRO
	* @param inCgtsa_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgtsa_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_tipo_salario(
		String inCgtsa_codigo,
		String inCgtsa_nombre,
		String inCgtsa_descripcion,
		boolean inCgtsa_estado,
		String inCgtsa_usuario_insert,
		String inCgtsa_usuario_update
	){
		this.setCGTSA_CODIGO(inCgtsa_codigo);
		this.setCGTSA_NOMBRE(inCgtsa_nombre);
		this.setCGTSA_DESCRIPCION(inCgtsa_descripcion);
		this.setCGTSA_ESTADO(inCgtsa_estado);
		this.setCGTSA_USUARIO_INSERT(inCgtsa_usuario_insert);
		this.setCGTSA_USUARIO_UPDATE(inCgtsa_usuario_update);
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgtsa_codigo NO ESPECIFICADO
	*/
	public void setCGTSA_CODIGO(String inCgtsa_codigo){
		this.myCgtsa_codigo = inCgtsa_codigo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGTSA_CODIGO(){
		return this.myCgtsa_codigo;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgtsa_nombre NO ESPECIFICADO
	*/
	public void setCGTSA_NOMBRE(String inCgtsa_nombre){
		this.myCgtsa_nombre = inCgtsa_nombre;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGTSA_NOMBRE(){
		return this.myCgtsa_nombre;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgtsa_descripcion NO ESPECIFICADO
	*/
	public void setCGTSA_DESCRIPCION(String inCgtsa_descripcion){
		this.myCgtsa_descripcion = inCgtsa_descripcion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGTSA_DESCRIPCION(){
		return this.myCgtsa_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgtsa_estado ESTADO DEL REGISTRO
	*/
	public void setCGTSA_ESTADO(boolean inCgtsa_estado){
		this.myCgtsa_estado = inCgtsa_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGTSA_ESTADO(){
		return this.myCgtsa_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgtsa_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGTSA_USUARIO_INSERT(String inCgtsa_usuario_insert){
		this.myCgtsa_usuario_insert = inCgtsa_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGTSA_USUARIO_INSERT(){
		return this.myCgtsa_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgtsa_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGTSA_USUARIO_UPDATE(String inCgtsa_usuario_update){
		this.myCgtsa_usuario_update = inCgtsa_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGTSA_USUARIO_UPDATE(){
		return this.myCgtsa_usuario_update;
	}

}
