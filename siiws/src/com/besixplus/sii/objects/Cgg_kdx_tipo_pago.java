package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_tipo_pago
* TABLA: TIPO PAGO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE PAGO UTILIZADOS PARA LA CONTABILIZACION DE MONTOS RECAUDADOS.
* ABREVIATURA:CKTPG
*/
public class Cgg_kdx_tipo_pago implements Serializable{
	private static final long serialVersionUID = 363336588;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	*/
	private String myCktpg_codigo;
	/**
	* NOMBRE DEL TIPO DE PAGO
	*/
	private String myCktpg_descripcion;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCktpg_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCktpg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCktpg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCktpg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_tipo_pago
	*/
	public Cgg_kdx_tipo_pago(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_tipo_pago
	* @param inCktpg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	* @param inCktpg_descripcion NOMBRE DEL TIPO DE PAGO
	* @param inCktpg_observacion INFORMACION ADICIONAL
	* @param inCktpg_estado ESTADO DEL REGISTRO
	* @param inCktpg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCktpg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_tipo_pago(
		String inCktpg_codigo,
		String inCktpg_descripcion,
		String inCktpg_observacion,
		boolean inCktpg_estado,
		String inCktpg_usuario_insert,
		String inCktpg_usuario_update
	){
		this.setCKTPG_CODIGO(inCktpg_codigo);
		this.setCKTPG_DESCRIPCION(inCktpg_descripcion);
		this.setCKTPG_OBSERVACION(inCktpg_observacion);
		this.setCKTPG_ESTADO(inCktpg_estado);
		this.setCKTPG_USUARIO_INSERT(inCktpg_usuario_insert);
		this.setCKTPG_USUARIO_UPDATE(inCktpg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	* @param inCktpg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	*/
	public void setCKTPG_CODIGO(String inCktpg_codigo){
		this.myCktpg_codigo = inCktpg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
	*/
	public String getCKTPG_CODIGO(){
		return this.myCktpg_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL TIPO DE PAGO
	* @param inCktpg_descripcion NOMBRE DEL TIPO DE PAGO
	*/
	public void setCKTPG_DESCRIPCION(String inCktpg_descripcion){
		this.myCktpg_descripcion = inCktpg_descripcion;
	}
	/**
	* OBTIENE NOMBRE DEL TIPO DE PAGO
	* @return String NOMBRE DEL TIPO DE PAGO
	*/
	public String getCKTPG_DESCRIPCION(){
		return this.myCktpg_descripcion;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCktpg_observacion INFORMACION ADICIONAL
	*/
	public void setCKTPG_OBSERVACION(String inCktpg_observacion){
		this.myCktpg_observacion = inCktpg_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCKTPG_OBSERVACION(){
		return this.myCktpg_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCktpg_estado ESTADO DEL REGISTRO
	*/
	public void setCKTPG_ESTADO(boolean inCktpg_estado){
		this.myCktpg_estado = inCktpg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKTPG_ESTADO(){
		return this.myCktpg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCktpg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKTPG_USUARIO_INSERT(String inCktpg_usuario_insert){
		this.myCktpg_usuario_insert = inCktpg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKTPG_USUARIO_INSERT(){
		return this.myCktpg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCktpg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKTPG_USUARIO_UPDATE(String inCktpg_usuario_update){
		this.myCktpg_usuario_update = inCktpg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKTPG_USUARIO_UPDATE(){
		return this.myCktpg_usuario_update;
	}

}
