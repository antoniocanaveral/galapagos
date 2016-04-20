package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_aerolinea
* TABLA: AEROLINEA
* DESCRIPCION:ALMACENA INFORMACION DE LAS AEROLINEAS
* ABREVIATURA:CRALN
*/
public class Cgg_res_aerolinea implements Serializable{
	private static final long serialVersionUID = 1604214326;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCraln_codigo;
	/**
	* NOMBRE DE LA AEROLINEA
	*/
	private String myCraln_nombre;
	/**
	* IDENTIFICATIVO DEL TIPO DE AEROLINEA
0 - EXTERNO
1 - INTERNO
	*/
	private int myCraln_tipo_aerolinea;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCraln_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCraln_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCraln_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_aerolinea
	*/
	public Cgg_res_aerolinea(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_aerolinea
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCraln_nombre NOMBRE DE LA AEROLINEA
	* @param inCraln_tipo_aerolinea IDENTIFICATIVO DEL TIPO DE AEROLINEA
0 - EXTERNO
1 - INTERNO
	* @param inCraln_estado ESTADO DEL REGISTRO
	* @param inCraln_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCraln_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_aerolinea(
		String inCraln_codigo,
		String inCraln_nombre,
		int inCraln_tipo_aerolinea,
		boolean inCraln_estado,
		String inCraln_usuario_insert,
		String inCraln_usuario_update
	){
		this.setCRALN_CODIGO(inCraln_codigo);
		this.setCRALN_NOMBRE(inCraln_nombre);
		this.setCRALN_TIPO_AEROLINEA(inCraln_tipo_aerolinea);
		this.setCRALN_ESTADO(inCraln_estado);
		this.setCRALN_USUARIO_INSERT(inCraln_usuario_insert);
		this.setCRALN_USUARIO_UPDATE(inCraln_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRALN_CODIGO(String inCraln_codigo){
		this.myCraln_codigo = inCraln_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRALN_CODIGO(){
		return this.myCraln_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA AEROLINEA
	* @param inCraln_nombre NOMBRE DE LA AEROLINEA
	*/
	public void setCRALN_NOMBRE(String inCraln_nombre){
		this.myCraln_nombre = inCraln_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA AEROLINEA
	* @return String NOMBRE DE LA AEROLINEA
	*/
	public String getCRALN_NOMBRE(){
		return this.myCraln_nombre;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DEL TIPO DE AEROLINEA
0 - EXTERNO
1 - INTERNO
	* @param inCraln_tipo_aerolinea IDENTIFICATIVO DEL TIPO DE AEROLINEA
0 - EXTERNO
1 - INTERNO
	*/
	public void setCRALN_TIPO_AEROLINEA(int inCraln_tipo_aerolinea){
		this.myCraln_tipo_aerolinea = inCraln_tipo_aerolinea;
	}
	/**
	* OBTIENE IDENTIFICATIVO DEL TIPO DE AEROLINEA
0 - EXTERNO
1 - INTERNO
	* @return int IDENTIFICATIVO DEL TIPO DE AEROLINEA
0 - EXTERNO
1 - INTERNO
	*/
	public int getCRALN_TIPO_AEROLINEA(){
		return this.myCraln_tipo_aerolinea;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCraln_estado ESTADO DEL REGISTRO
	*/
	public void setCRALN_ESTADO(boolean inCraln_estado){
		this.myCraln_estado = inCraln_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRALN_ESTADO(){
		return this.myCraln_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCraln_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRALN_USUARIO_INSERT(String inCraln_usuario_insert){
		this.myCraln_usuario_insert = inCraln_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRALN_USUARIO_INSERT(){
		return this.myCraln_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCraln_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRALN_USUARIO_UPDATE(String inCraln_usuario_update){
		this.myCraln_usuario_update = inCraln_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRALN_USUARIO_UPDATE(){
		return this.myCraln_usuario_update;
	}

}
