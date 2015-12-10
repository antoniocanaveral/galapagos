package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_marca
* TABLA: MARCA
* DESCRIPCION: NOMBRE DE LOS FABRICANTES AUTOMOTRICES
* ABREVIATURA: CVMRC
*/
public class Cgg_veh_marca implements Serializable{
	private static final long serialVersionUID = 1061949805;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	private String myCvmrc_codigo;
	/**
	* NOMBRE IDENTIFICADOR DE LA MARCA.
	*/
	private String myCvmrc_nombre;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvmrc_observacion;
	/**
	* ESTADO DEL REGISTRO.
	*/
	private boolean myCvmrc_estado;
	/**
	* USUARIO DE LA APLICACION.
	*/
	private String myCvmrc_usuario_insert;
	/**
	* USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	private String myCvmrc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_marca
	*/
	public Cgg_veh_marca(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_marca
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvmrc_nombre NOMBRE IDENTIFICADOR DE LA MARCA.
	* @param inCvmrc_observacion INFORMACION ADICIONAL
	* @param inCvmrc_estado ESTADO DEL REGISTRO.
	* @param inCvmrc_usuario_insert USUARIO DE LA APLICACION.
	* @param inCvmrc_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public Cgg_veh_marca(
		String inCvmrc_codigo,
		String inCvmrc_nombre,
		String inCvmrc_observacion,
		boolean inCvmrc_estado,
		String inCvmrc_usuario_insert,
		String inCvmrc_usuario_update
	){
		this.setCVMRC_CODIGO(inCvmrc_codigo);
		this.setCVMRC_NOMBRE(inCvmrc_nombre);
		this.setCVMRC_OBSERVACION(inCvmrc_observacion);
		this.setCVMRC_ESTADO(inCvmrc_estado);
		this.setCVMRC_USUARIO_INSERT(inCvmrc_usuario_insert);
		this.setCVMRC_USUARIO_UPDATE(inCvmrc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	public void setCVMRC_CODIGO(String inCvmrc_codigo){
		this.myCvmrc_codigo = inCvmrc_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	public String getCVMRC_CODIGO(){
		return this.myCvmrc_codigo;
	}

	/**
	* ESTABLECE NOMBRE IDENTIFICADOR DE LA MARCA.
	* @param inCvmrc_nombre NOMBRE IDENTIFICADOR DE LA MARCA.
	*/
	public void setCVMRC_NOMBRE(String inCvmrc_nombre){
		this.myCvmrc_nombre = inCvmrc_nombre;
	}
	/**
	* OBTIENE NOMBRE IDENTIFICADOR DE LA MARCA.
	* @return String NOMBRE IDENTIFICADOR DE LA MARCA.
	*/
	public String getCVMRC_NOMBRE(){
		return this.myCvmrc_nombre;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvmrc_observacion INFORMACION ADICIONAL
	*/
	public void setCVMRC_OBSERVACION(String inCvmrc_observacion){
		this.myCvmrc_observacion = inCvmrc_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVMRC_OBSERVACION(){
		return this.myCvmrc_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO.
	* @param inCvmrc_estado ESTADO DEL REGISTRO.
	*/
	public void setCVMRC_ESTADO(boolean inCvmrc_estado){
		this.myCvmrc_estado = inCvmrc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO.
	* @return boolean ESTADO DEL REGISTRO.
	*/
	public boolean getCVMRC_ESTADO(){
		return this.myCvmrc_estado;
	}

	/**
	* ESTABLECE USUARIO DE LA APLICACION.
	* @param inCvmrc_usuario_insert USUARIO DE LA APLICACION.
	*/
	public void setCVMRC_USUARIO_INSERT(String inCvmrc_usuario_insert){
		this.myCvmrc_usuario_insert = inCvmrc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO DE LA APLICACION.
	* @return String USUARIO DE LA APLICACION.
	*/
	public String getCVMRC_USUARIO_INSERT(){
		return this.myCvmrc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @param inCvmrc_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public void setCVMRC_USUARIO_UPDATE(String inCvmrc_usuario_update){
		this.myCvmrc_usuario_update = inCvmrc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @return String USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public String getCVMRC_USUARIO_UPDATE(){
		return this.myCvmrc_usuario_update;
	}

}
