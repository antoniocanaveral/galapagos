package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_area_influencia
* TABLA: TABLA DE AREA DE INFLUENCIA
* DESCRIPCION:ALMACENA INFORMACION DE LAS AREAS DE INFLUENCIA QUE AFECTA A LA PROVINCIA.
* ABREVIATURA:CAINF
*/
public class Cgg_area_influencia implements Serializable{
	private static final long serialVersionUID = 1727589377;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	*/
	private String myCainf_codigo;
	/**
	* NOMBRE DEL AREA DE INFLUENCIA
	*/
	private String myCainf_nombre;
	/**
	* ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
	*/
	private String myCainf_descripcion;
	/**
	* ESTADO DEL REGISTRO DEL AREA DE INFLUENCIA
	*/
	private boolean myCainf_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DEL AREA DE INFLUENCIA
	*/
	private String myCainf_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DEL AREA DE INFLUENCIA
	*/
	private String myCainf_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_area_influencia
	*/
	public Cgg_area_influencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_area_influencia
	* @param inCainf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	* @param inCainf_nombre NOMBRE DEL AREA DE INFLUENCIA
	* @param inCainf_descripcion ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
	* @param inCainf_estado ESTADO DEL REGISTRO DEL AREA DE INFLUENCIA
	* @param inCainf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DEL AREA DE INFLUENCIA
	* @param inCainf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DEL AREA DE INFLUENCIA
	*/
	public Cgg_area_influencia(
		String inCainf_codigo,
		String inCainf_nombre,
		String inCainf_descripcion,
		boolean inCainf_estado,
		String inCainf_usuario_insert,
		String inCainf_usuario_update
	){
		this.setCAINF_CODIGO(inCainf_codigo);
		this.setCAINF_NOMBRE(inCainf_nombre);
		this.setCAINF_DESCRIPCION(inCainf_descripcion);
		this.setCAINF_ESTADO(inCainf_estado);
		this.setCAINF_USUARIO_INSERT(inCainf_usuario_insert);
		this.setCAINF_USUARIO_UPDATE(inCainf_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
    * @param inCainf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA 
	*/
	public void setCAINF_CODIGO(String inCainf_codigo){
		this.myCainf_codigo = inCainf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	*/
	public String getCAINF_CODIGO(){
		return this.myCainf_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL AREA DE INFLUENCIA
	* @param inCainf_nombre NOMBRE DEL AREA DE INFLUENCIA
	*/
	public void setCAINF_NOMBRE(String inCainf_nombre){
		this.myCainf_nombre = inCainf_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL AREA DE INFLUENCIA
	* @return String NOMBRE DEL AREA DE INFLUENCIA
	*/
	public String getCAINF_NOMBRE(){
		return this.myCainf_nombre;
	}

	/**
	* ESTABLECE ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
	* @param inCainf_descripcion ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
	*/
	public void setCAINF_DESCRIPCION(String inCainf_descripcion){
		this.myCainf_descripcion = inCainf_descripcion;
	}
	/**
	* OBTIENE ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
	* @return String ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
	*/
	public String getCAINF_DESCRIPCION(){
		return this.myCainf_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DEL AREA DE INFLUENCIA
	* @param inCainf_estado ESTADO DEL REGISTRO DEL AREA DE INFLUENCIA
	*/
	public void setCAINF_ESTADO(boolean inCainf_estado){
		this.myCainf_estado = inCainf_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DEL AREA DE INFLUENCIA
	* @return boolean ESTADO DEL REGISTRO DEL AREA DE INFLUENCIA
	*/
	public boolean getCAINF_ESTADO(){
		return this.myCainf_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DEL AREA DE INFLUENCIA
	* @param inCainf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DEL AREA DE INFLUENCIA
	*/
	public void setCAINF_USUARIO_INSERT(String inCainf_usuario_insert){
		this.myCainf_usuario_insert = inCainf_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DEL AREA DE INFLUENCIA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DEL AREA DE INFLUENCIA
	*/
	public String getCAINF_USUARIO_INSERT(){
		return this.myCainf_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DEL AREA DE INFLUENCIA
	* @param inCainf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DEL AREA DE INFLUENCIA
	*/
	public void setCAINF_USUARIO_UPDATE(String inCainf_usuario_update){
		this.myCainf_usuario_update = inCainf_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DEL AREA DE INFLUENCIA
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DEL AREA DE INFLUENCIA
	*/
	public String getCAINF_USUARIO_UPDATE(){
		return this.myCainf_usuario_update;
	}

}
