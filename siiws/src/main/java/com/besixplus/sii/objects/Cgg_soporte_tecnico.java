package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_soporte_tecnico
* TABLA: SOPORTE TECNICO
* DESCRIPCION:ALMACENA INFORMACION DE MICRO SOPORTES TECNICOS DE GESTION DE EMPLEO Y DEL SISTEMA EN GENERAL
* ABREVIATURA:CSOTE
*/
public class Cgg_soporte_tecnico implements Serializable{
	private static final long serialVersionUID = 162640748;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
	*/
	private String myCsote_codigo;
	/**
	* NOMBRE DEL SOPORTE TECNICO
	*/
	private String myCsote_asunto;
	/**
	* NUMERO DE SOPORTE TECNICO
	*/
	private String myCsote_numero;
	/**
	* DESCRIPCION DEL SOPORTE TECNICO
	*/
	private String myCsote_descripcion;
	/**
	* CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
	*/
	private String myCsote_contacto;
	/**
	* CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
	*/
	private int myCsote_atendido;
	/**
	* ESTADO DEL REGISTRO

	*/
	private boolean myCsote_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsote_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsote_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_soporte_tecnico
	*/
	public Cgg_soporte_tecnico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_soporte_tecnico
	* @param inCsote_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
	* @param inCsote_asunto NOMBRE DEL SOPORTE TECNICO
	* @param inCsote_numero NUMERO DE SOPORTE TECNICO
	* @param inCsote_descripcion DESCRIPCION DEL SOPORTE TECNICO
	* @param inCsote_contacto CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
	* @param inCsote_atendido CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
	* @param inCsote_estado ESTADO DEL REGISTRO

	* @param inCsote_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsote_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_soporte_tecnico(
		String inCsote_codigo,
		String inCsote_asunto,
		String inCsote_numero,
		String inCsote_descripcion,
		String inCsote_contacto,
		int inCsote_atendido,
		boolean inCsote_estado,
		String inCsote_usuario_insert,
		String inCsote_usuario_update
	){
		this.setCSOTE_CODIGO(inCsote_codigo);
		this.setCSOTE_ASUNTO(inCsote_asunto);
		this.setCSOTE_NUMERO(inCsote_numero);
		this.setCSOTE_DESCRIPCION(inCsote_descripcion);
		this.setCSOTE_CONTACTO(inCsote_contacto);
		this.setCSOTE_ATENDIDO(inCsote_atendido);
		this.setCSOTE_ESTADO(inCsote_estado);
		this.setCSOTE_USUARIO_INSERT(inCsote_usuario_insert);
		this.setCSOTE_USUARIO_UPDATE(inCsote_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
	* @param inCsote_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
	*/
	public void setCSOTE_CODIGO(String inCsote_codigo){
		this.myCsote_codigo = inCsote_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SOPORTE TECNICO
	*/
	public String getCSOTE_CODIGO(){
		return this.myCsote_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL SOPORTE TECNICO
	* @param inCsote_asunto NOMBRE DEL SOPORTE TECNICO
	*/
	public void setCSOTE_ASUNTO(String inCsote_asunto){
		this.myCsote_asunto = inCsote_asunto;
	}
	/**
	* OBTIENE NOMBRE DEL SOPORTE TECNICO
	* @return String NOMBRE DEL SOPORTE TECNICO
	*/
	public String getCSOTE_ASUNTO(){
		return this.myCsote_asunto;
	}

	/**
	* ESTABLECE NUMERO DE SOPORTE TECNICO
	* @param inCsote_numero NUMERO DE SOPORTE TECNICO
	*/
	public void setCSOTE_NUMERO(String inCsote_numero){
		this.myCsote_numero = inCsote_numero;
	}
	/**
	* OBTIENE NUMERO DE SOPORTE TECNICO
	* @return String NUMERO DE SOPORTE TECNICO
	*/
	public String getCSOTE_NUMERO(){
		return this.myCsote_numero;
	}

	/**
	* ESTABLECE DESCRIPCION DEL SOPORTE TECNICO
	* @param inCsote_descripcion DESCRIPCION DEL SOPORTE TECNICO
	*/
	public void setCSOTE_DESCRIPCION(String inCsote_descripcion){
		this.myCsote_descripcion = inCsote_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL SOPORTE TECNICO
	* @return String DESCRIPCION DEL SOPORTE TECNICO
	*/
	public String getCSOTE_DESCRIPCION(){
		return this.myCsote_descripcion;
	}

	/**
	* ESTABLECE CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
	* @param inCsote_contacto CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
	*/
	public void setCSOTE_CONTACTO(String inCsote_contacto){
		this.myCsote_contacto = inCsote_contacto;
	}
	/**
	* OBTIENE CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
	* @return String CAMPO QUE REGISTRA EL  EL CORREO ELECTRONICO O NUEMRO DE TELEFONO
	*/
	public String getCSOTE_CONTACTO(){
		return this.myCsote_contacto;
	}

	/**
	* ESTABLECE CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
	* @param inCsote_atendido CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
	*/
	public void setCSOTE_ATENDIDO(int inCsote_atendido){
		this.myCsote_atendido = inCsote_atendido;
	}
	/**
	* OBTIENE CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
	* @return int CAMPO QUE REGISTRA SE SE ATENDIO A UN SOPRTE TECNICO
0 - NO SOLUCIONADO
1 - SOLUCIONADO
2 - EN ESPERA
	*/
	public int getCSOTE_ATENDIDO(){
		return this.myCsote_atendido;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO

	* @param inCsote_estado ESTADO DEL REGISTRO

	*/
	public void setCSOTE_ESTADO(boolean inCsote_estado){
		this.myCsote_estado = inCsote_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO

	* @return boolean ESTADO DEL REGISTRO

	*/
	public boolean getCSOTE_ESTADO(){
		return this.myCsote_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsote_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSOTE_USUARIO_INSERT(String inCsote_usuario_insert){
		this.myCsote_usuario_insert = inCsote_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSOTE_USUARIO_INSERT(){
		return this.myCsote_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsote_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSOTE_USUARIO_UPDATE(String inCsote_usuario_update){
		this.myCsote_usuario_update = inCsote_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSOTE_USUARIO_UPDATE(){
		return this.myCsote_usuario_update;
	}

}
