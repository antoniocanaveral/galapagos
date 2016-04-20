package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_color
* TABLA:COLOR
* DESCRIPCION: COLORES DE VEHICULOS
* ABREVIATURA:CVCLR
*/
public class Cgg_veh_color implements Serializable{
	private static final long serialVersionUID = 1765631852;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE COLOR
	*/
	private String myCvclr_codigo;
	/**
	* NOMBRE DESCRIPTIVO DEL NOMBRE.
	*/
	private String myCvclr_nombre;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvclr_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvclr_estado;
	/**
	* USUARIO QUE CREO EL REGISTRO.
	*/
	private String myCvclr_usuario_insert;
	/**
	* USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	private String myCvclr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_color
	*/
	public Cgg_veh_color(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_color
	* @param inCvclr_codigo IDENTIFICADOR UNICO DE REGISTRO DE COLOR
	* @param inCvclr_nombre NOMBRE DESCRIPTIVO DEL NOMBRE.
	* @param inCvclr_observacion INFORMACION ADICIONAL
	* @param inCvclr_estado ESTADO DEL REGISTRO
	* @param inCvclr_usuario_insert USUARIO QUE CREO EL REGISTRO.
	* @param inCvclr_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public Cgg_veh_color(
		String inCvclr_codigo,
		String inCvclr_nombre,
		String inCvclr_observacion,
		boolean inCvclr_estado,
		String inCvclr_usuario_insert,
		String inCvclr_usuario_update
	){
		this.setCVCLR_CODIGO(inCvclr_codigo);
		this.setCVCLR_NOMBRE(inCvclr_nombre);
		this.setCVCLR_OBSERVACION(inCvclr_observacion);
		this.setCVCLR_ESTADO(inCvclr_estado);
		this.setCVCLR_USUARIO_INSERT(inCvclr_usuario_insert);
		this.setCVCLR_USUARIO_UPDATE(inCvclr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE COLOR
	* @param inCvclr_codigo IDENTIFICADOR UNICO DE REGISTRO DE COLOR
	*/
	public void setCVCLR_CODIGO(String inCvclr_codigo){
		this.myCvclr_codigo = inCvclr_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE COLOR
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE COLOR
	*/
	public String getCVCLR_CODIGO(){
		return this.myCvclr_codigo;
	}

	/**
	* ESTABLECE NOMBRE DESCRIPTIVO DEL NOMBRE.
	* @param inCvclr_nombre NOMBRE DESCRIPTIVO DEL NOMBRE.
	*/
	public void setCVCLR_NOMBRE(String inCvclr_nombre){
		this.myCvclr_nombre = inCvclr_nombre;
	}
	/**
	* OBTIENE NOMBRE DESCRIPTIVO DEL NOMBRE.
	* @return String NOMBRE DESCRIPTIVO DEL NOMBRE.
	*/
	public String getCVCLR_NOMBRE(){
		return this.myCvclr_nombre;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvclr_observacion INFORMACION ADICIONAL
	*/
	public void setCVCLR_OBSERVACION(String inCvclr_observacion){
		this.myCvclr_observacion = inCvclr_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVCLR_OBSERVACION(){
		return this.myCvclr_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvclr_estado ESTADO DEL REGISTRO
	*/
	public void setCVCLR_ESTADO(boolean inCvclr_estado){
		this.myCvclr_estado = inCvclr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVCLR_ESTADO(){
		return this.myCvclr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE CREO EL REGISTRO.
	* @param inCvclr_usuario_insert USUARIO QUE CREO EL REGISTRO.
	*/
	public void setCVCLR_USUARIO_INSERT(String inCvclr_usuario_insert){
		this.myCvclr_usuario_insert = inCvclr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE CREO EL REGISTRO.
	* @return String USUARIO QUE CREO EL REGISTRO.
	*/
	public String getCVCLR_USUARIO_INSERT(){
		return this.myCvclr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @param inCvclr_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public void setCVCLR_USUARIO_UPDATE(String inCvclr_usuario_update){
		this.myCvclr_usuario_update = inCvclr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE ACTUALIZO EL REGISTRO.
	* @return String USUARIO QUE ACTUALIZO EL REGISTRO.
	*/
	public String getCVCLR_USUARIO_UPDATE(){
		return this.myCvclr_usuario_update;
	}

}
