package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_tct_ingreso_fallido
* TABLA: INGRESO FALLIDO
* DESCRIPCION:ALMACENA INFORMACION DE LOS INTENTOS DE INGRESO A LA PROVINCIA DE PERSONAS NO HABILITADAS
* ABREVIATURA:CTIGF
*/
public class Cgg_tct_ingreso_fallido implements Serializable{
	private static final long serialVersionUID = 1414731919;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCtigf_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCarpt_codigo;
	/**
	* FECHA DE INTENTO DE INGRESO
	*/
	private java.util.Date myCtigf_fecha_intento;
	/**
	* TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
	*/
	private int myCtigf_tipo_ingreso_fallido;
	/**
	* DESCRIPCION DEL INGRESO FALLIDO
	*/
	private String myCtigf_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCtigf_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCtigf_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCtigf_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_ingreso_fallido
	*/
	public Cgg_tct_ingreso_fallido(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_tct_ingreso_fallido
	* @param inCtigf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtigf_fecha_intento FECHA DE INTENTO DE INGRESO
	* @param inCtigf_tipo_ingreso_fallido TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
	* @param inCtigf_descripcion DESCRIPCION DEL INGRESO FALLIDO
	* @param inCtigf_estado ESTADO DEL REGISTRO
	* @param inCtigf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtigf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_tct_ingreso_fallido(
		String inCtigf_codigo,
		String inCrper_codigo,
		String inCarpt_codigo,
		java.util.Date inCtigf_fecha_intento,
		int inCtigf_tipo_ingreso_fallido,
		String inCtigf_descripcion,
		boolean inCtigf_estado,
		String inCtigf_usuario_insert,
		String inCtigf_usuario_update
	){
		this.setCTIGF_CODIGO(inCtigf_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCARPT_CODIGO(inCarpt_codigo);
		this.setCTIGF_FECHA_INTENTO(inCtigf_fecha_intento);
		this.setCTIGF_TIPO_INGRESO_FALLIDO(inCtigf_tipo_ingreso_fallido);
		this.setCTIGF_DESCRIPCION(inCtigf_descripcion);
		this.setCTIGF_ESTADO(inCtigf_estado);
		this.setCTIGF_USUARIO_INSERT(inCtigf_usuario_insert);
		this.setCTIGF_USUARIO_UPDATE(inCtigf_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCtigf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCTIGF_CODIGO(String inCtigf_codigo){
		this.myCtigf_codigo = inCtigf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCTIGF_CODIGO(){
		return this.myCtigf_codigo;
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
	* @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCARPT_CODIGO(String inCarpt_codigo){
		this.myCarpt_codigo = inCarpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCARPT_CODIGO(){
		return this.myCarpt_codigo;
	}

	/**
	* ESTABLECE FECHA DE INTENTO DE INGRESO
	* @param inCtigf_fecha_intento FECHA DE INTENTO DE INGRESO
	*/
	public void setCTIGF_FECHA_INTENTO(java.util.Date inCtigf_fecha_intento){
		this.myCtigf_fecha_intento = inCtigf_fecha_intento;
	}
	/**
	* OBTIENE FECHA DE INTENTO DE INGRESO
	* @return java.util.Date FECHA DE INTENTO DE INGRESO
	*/
	public java.util.Date getCTIGF_FECHA_INTENTO(){
		return this.myCtigf_fecha_intento;
	}

	/**
	* ESTABLECE TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
	* @param inCtigf_tipo_ingreso_fallido TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
	*/
	public void setCTIGF_TIPO_INGRESO_FALLIDO(int inCtigf_tipo_ingreso_fallido){
		this.myCtigf_tipo_ingreso_fallido = inCtigf_tipo_ingreso_fallido;
	}
	/**
	* OBTIENE TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
	* @return int TIPO DE INGRESO FALLIDO
0 - NOTIFICACION
1 - ESTADIA
2 - OTROS
	*/
	public int getCTIGF_TIPO_INGRESO_FALLIDO(){
		return this.myCtigf_tipo_ingreso_fallido;
	}

	/**
	* ESTABLECE DESCRIPCION DEL INGRESO FALLIDO
	* @param inCtigf_descripcion DESCRIPCION DEL INGRESO FALLIDO
	*/
	public void setCTIGF_DESCRIPCION(String inCtigf_descripcion){
		this.myCtigf_descripcion = inCtigf_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL INGRESO FALLIDO
	* @return String DESCRIPCION DEL INGRESO FALLIDO
	*/
	public String getCTIGF_DESCRIPCION(){
		return this.myCtigf_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCtigf_estado ESTADO DEL REGISTRO
	*/
	public void setCTIGF_ESTADO(boolean inCtigf_estado){
		this.myCtigf_estado = inCtigf_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCTIGF_ESTADO(){
		return this.myCtigf_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCtigf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCTIGF_USUARIO_INSERT(String inCtigf_usuario_insert){
		this.myCtigf_usuario_insert = inCtigf_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCTIGF_USUARIO_INSERT(){
		return this.myCtigf_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCtigf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCTIGF_USUARIO_UPDATE(String inCtigf_usuario_update){
		this.myCtigf_usuario_update = inCtigf_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCTIGF_USUARIO_UPDATE(){
		return this.myCtigf_usuario_update;
	}

}
