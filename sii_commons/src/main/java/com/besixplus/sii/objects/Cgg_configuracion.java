package com.besixplus.sii.objects;

import java.io.Serializable;

/**
* CLASE Cgg_configuracion
* TABLA: CONFIGURACION
* DESCRIPCION:ALMACENA INFORMACION DE PARAMETROS DE FUNCIONAMIENTO DEL SISTEMA
* ABREVIATURA:CGCNF
*/
public class Cgg_configuracion implements Serializable{
	private static final long serialVersionUID = 1219364018;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	*/
	private String myCgcnf_codigo;
	/**
	* NOMBRE DEL VALOR DE CONFIGURACION
	*/
	private String myCgcnf_configuracion;
	/**
	* VALOR DE CONFIGURACION TIPO TEXTO
	*/
	private String myCgcnf_valor_cadena;
	/**
	* VALOR DE CONFIGURACION TIPO NUMERICO
	*/
	private int myCgcnf_valor_numerico;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgcnf_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgcnf_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgcnf_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_configuracion
	*/
	public Cgg_configuracion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_configuracion
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	* @param inCgcnf_configuracion NOMBRE DEL VALOR DE CONFIGURACION
	* @param inCgcnf_valor_cadena VALOR DE CONFIGURACION TIPO TEXTO
	* @param inCgcnf_valor_numerico VALOR DE CONFIGURACION TIPO NUMERICO
	* @param inCgcnf_estado ESTADO DEL REGISTRO
	* @param inCgcnf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgcnf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_configuracion(
			String inCgcnf_codigo,
			String inCgcnf_configuracion,
			String inCgcnf_valor_cadena,
			int inCgcnf_valor_numerico,
			boolean inCgcnf_estado,
			String inCgcnf_usuario_insert,
			String inCgcnf_usuario_update
	){
		this.setCGCNF_CODIGO(inCgcnf_codigo);
		this.setCGCNF_CONFIGURACION(inCgcnf_configuracion);
		this.setCGCNF_VALOR_CADENA(inCgcnf_valor_cadena);
		this.setCGCNF_VALOR_NUMERICO(inCgcnf_valor_numerico);
		this.setCGCNF_ESTADO(inCgcnf_estado);
		this.setCGCNF_USUARIO_INSERT(inCgcnf_usuario_insert);
		this.setCGCNF_USUARIO_UPDATE(inCgcnf_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	*/
	public void setCGCNF_CODIGO(String inCgcnf_codigo){
		this.myCgcnf_codigo = inCgcnf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	*/
	public String getCGCNF_CODIGO(){
		return this.myCgcnf_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL VALOR DE CONFIGURACION
	* @param inCgcnf_configuracion NOMBRE DEL VALOR DE CONFIGURACION
	*/
	public void setCGCNF_CONFIGURACION(String inCgcnf_configuracion){
		this.myCgcnf_configuracion = inCgcnf_configuracion;
	}
	/**
	* OBTIENE NOMBRE DEL VALOR DE CONFIGURACION
	* @return String NOMBRE DEL VALOR DE CONFIGURACION
	*/
	public String getCGCNF_CONFIGURACION(){
		return this.myCgcnf_configuracion;
	}

	/**
	* ESTABLECE VALOR DE CONFIGURACION TIPO TEXTO
	* @param inCgcnf_valor_cadena VALOR DE CONFIGURACION TIPO TEXTO
	*/
	public void setCGCNF_VALOR_CADENA(String inCgcnf_valor_cadena){
		this.myCgcnf_valor_cadena = inCgcnf_valor_cadena;
	}
	/**
	* OBTIENE VALOR DE CONFIGURACION TIPO TEXTO
	* @return String VALOR DE CONFIGURACION TIPO TEXTO
	*/
	public String getCGCNF_VALOR_CADENA(){
		return this.myCgcnf_valor_cadena;
	}

	/**
	* ESTABLECE VALOR DE CONFIGURACION TIPO NUMERICO
	* @param inCgcnf_valor_numerico VALOR DE CONFIGURACION TIPO NUMERICO
	*/
	public void setCGCNF_VALOR_NUMERICO(int inCgcnf_valor_numerico){
		this.myCgcnf_valor_numerico = inCgcnf_valor_numerico;
	}
	/**
	* OBTIENE VALOR DE CONFIGURACION TIPO NUMERICO
	* @return java.math.BigDecimal VALOR DE CONFIGURACION TIPO NUMERICO
	*/
	public int getCGCNF_VALOR_NUMERICO(){
		return this.myCgcnf_valor_numerico;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgcnf_estado ESTADO DEL REGISTRO
	*/
	public void setCGCNF_ESTADO(boolean inCgcnf_estado){
		this.myCgcnf_estado = inCgcnf_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGCNF_ESTADO(){
		return this.myCgcnf_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgcnf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGCNF_USUARIO_INSERT(String inCgcnf_usuario_insert){
		this.myCgcnf_usuario_insert = inCgcnf_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGCNF_USUARIO_INSERT(){
		return this.myCgcnf_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgcnf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGCNF_USUARIO_UPDATE(String inCgcnf_usuario_update){
		this.myCgcnf_usuario_update = inCgcnf_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGCNF_USUARIO_UPDATE(){
		return this.myCgcnf_usuario_update;
	}

}
