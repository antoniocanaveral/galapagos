package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_categoria
* TABLA: CATEGORIA
* DESCRIPCION: GRUPOS A LOS QUE PUEDE PERTENCER LOS VEHICULOS.
* ABREVIATURA: CVCTG
*/
public class Cgg_veh_categoria implements Serializable{
	private static final long serialVersionUID = 287629066;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	private String myCvctg_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	*/
	private String myCgg_cvctg_codigo;
	/**
	* NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	*/
	private String myCvctg_nombre;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvctg_observacion;
	/**
	* ESTADO DEL REGISTRO.
	*/
	private boolean myCvctg_estado;
	/**
	* USUARIO QUE CREO EL REGISTRO.
	*/
	private String myCvctg_usuario_insert;
	/**
	* USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	private String myCvctg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_categoria
	*/
	public Cgg_veh_categoria(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_categoria
	* @param inCvctg_codigo IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @param inCgg_cvctg_codigo IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	* @param inCvctg_nombre NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	* @param inCvctg_observacion INFORMACION ADICIONAL
	* @param inCvctg_estado ESTADO DEL REGISTRO.
	* @param inCvctg_usuario_insert USUARIO QUE CREO EL REGISTRO.
	* @param inCvctg_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public Cgg_veh_categoria(
		String inCvctg_codigo,
		String inCgg_cvctg_codigo,
		String inCvctg_nombre,
		String inCvctg_observacion,
		boolean inCvctg_estado,
		String inCvctg_usuario_insert,
		String inCvctg_usuario_update
	){
		this.setCVCTG_CODIGO(inCvctg_codigo);
		this.setCGG_CVCTG_CODIGO(inCgg_cvctg_codigo);
		this.setCVCTG_NOMBRE(inCvctg_nombre);
		this.setCVCTG_OBSERVACION(inCvctg_observacion);
		this.setCVCTG_ESTADO(inCvctg_estado);
		this.setCVCTG_USUARIO_INSERT(inCvctg_usuario_insert);
		this.setCVCTG_USUARIO_UPDATE(inCvctg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @param inCvctg_codigo IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	public void setCVCTG_CODIGO(String inCvctg_codigo){
		this.myCvctg_codigo = inCvctg_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	public String getCVCTG_CODIGO(){
		return this.myCvctg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	* @param inCgg_cvctg_codigo IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	*/
	public void setCGG_CVCTG_CODIGO(String inCgg_cvctg_codigo){
		this.myCgg_cvctg_codigo = inCgg_cvctg_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	* @return String IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	*/
	public String getCGG_CVCTG_CODIGO(){
		return this.myCgg_cvctg_codigo;
	}

	/**
	* ESTABLECE NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	* @param inCvctg_nombre NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	*/
	public void setCVCTG_NOMBRE(String inCvctg_nombre){
		this.myCvctg_nombre = inCvctg_nombre;
	}
	/**
	* OBTIENE NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	* @return String NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	*/
	public String getCVCTG_NOMBRE(){
		return this.myCvctg_nombre;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvctg_observacion INFORMACION ADICIONAL
	*/
	public void setCVCTG_OBSERVACION(String inCvctg_observacion){
		this.myCvctg_observacion = inCvctg_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVCTG_OBSERVACION(){
		return this.myCvctg_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO.
	* @param inCvctg_estado ESTADO DEL REGISTRO.
	*/
	public void setCVCTG_ESTADO(boolean inCvctg_estado){
		this.myCvctg_estado = inCvctg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO.
	* @return boolean ESTADO DEL REGISTRO.
	*/
	public boolean getCVCTG_ESTADO(){
		return this.myCvctg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE CREO EL REGISTRO.
	* @param inCvctg_usuario_insert USUARIO QUE CREO EL REGISTRO.
	*/
	public void setCVCTG_USUARIO_INSERT(String inCvctg_usuario_insert){
		this.myCvctg_usuario_insert = inCvctg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE CREO EL REGISTRO.
	* @return String USUARIO QUE CREO EL REGISTRO.
	*/
	public String getCVCTG_USUARIO_INSERT(){
		return this.myCvctg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @param inCvctg_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public void setCVCTG_USUARIO_UPDATE(String inCvctg_usuario_update){
		this.myCvctg_usuario_update = inCvctg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @return String USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public String getCVCTG_USUARIO_UPDATE(){
		return this.myCvctg_usuario_update;
	}

}
