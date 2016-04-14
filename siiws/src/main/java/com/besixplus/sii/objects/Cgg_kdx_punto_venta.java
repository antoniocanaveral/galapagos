package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_punto_venta
* TABLA: PUNTO DE VENTA
* DESCRIPCION:ALMACENA INFORMACION DE LOS PUNTOS DE VENTA DE TCT
* ABREVIATURA:CKPVT
*/
public class Cgg_kdx_punto_venta implements Serializable{
	private static final long serialVersionUID = 2121751000;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	private String myCkpvt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
	*/
	private String myCctn_codigo;
	/**
	* NOMBRE DEL PUNTO DE VENTA
	*/
	private String myCkpvt_nombre;
	/**
	* OBSERVACION DEL PUNTO DE VENTA
	*/
	private String myCkpvt_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkpvt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkpvt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkpvt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_punto_venta
	*/
	public Cgg_kdx_punto_venta(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_punto_venta
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
	* @param inCkpvt_nombre NOMBRE DEL PUNTO DE VENTA
	* @param inCkpvt_observacion OBSERVACION DEL PUNTO DE VENTA
	* @param inCkpvt_estado ESTADO DEL REGISTRO
	* @param inCkpvt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkpvt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_punto_venta(
		String inCkpvt_codigo,
		String inCctn_codigo,
		String inCkpvt_nombre,
		String inCkpvt_observacion,
		boolean inCkpvt_estado,
		String inCkpvt_usuario_insert,
		String inCkpvt_usuario_update
	){
		this.setCKPVT_CODIGO(inCkpvt_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCKPVT_NOMBRE(inCkpvt_nombre);
		this.setCKPVT_OBSERVACION(inCkpvt_observacion);
		this.setCKPVT_ESTADO(inCkpvt_estado);
		this.setCKPVT_USUARIO_INSERT(inCkpvt_usuario_insert);
		this.setCKPVT_USUARIO_UPDATE(inCkpvt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	public void setCKPVT_CODIGO(String inCkpvt_codigo){
		this.myCkpvt_codigo = inCkpvt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	*/
	public String getCKPVT_CODIGO(){
		return this.myCkpvt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON / CIUDAD
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL PUNTO DE VENTA
	* @param inCkpvt_nombre NOMBRE DEL PUNTO DE VENTA
	*/
	public void setCKPVT_NOMBRE(String inCkpvt_nombre){
		this.myCkpvt_nombre = inCkpvt_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL PUNTO DE VENTA
	* @return String NOMBRE DEL PUNTO DE VENTA
	*/
	public String getCKPVT_NOMBRE(){
		return this.myCkpvt_nombre;
	}

	/**
	* ESTABLECE OBSERVACION DEL PUNTO DE VENTA
	* @param inCkpvt_observacion OBSERVACION DEL PUNTO DE VENTA
	*/
	public void setCKPVT_OBSERVACION(String inCkpvt_observacion){
		this.myCkpvt_observacion = inCkpvt_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL PUNTO DE VENTA
	* @return String OBSERVACION DEL PUNTO DE VENTA
	*/
	public String getCKPVT_OBSERVACION(){
		return this.myCkpvt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkpvt_estado ESTADO DEL REGISTRO
	*/
	public void setCKPVT_ESTADO(boolean inCkpvt_estado){
		this.myCkpvt_estado = inCkpvt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKPVT_ESTADO(){
		return this.myCkpvt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkpvt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKPVT_USUARIO_INSERT(String inCkpvt_usuario_insert){
		this.myCkpvt_usuario_insert = inCkpvt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKPVT_USUARIO_INSERT(){
		return this.myCkpvt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkpvt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKPVT_USUARIO_UPDATE(String inCkpvt_usuario_update){
		this.myCkpvt_usuario_update = inCkpvt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKPVT_USUARIO_UPDATE(){
		return this.myCkpvt_usuario_update;
	}

}
