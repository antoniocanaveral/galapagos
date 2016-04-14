package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_buzon_correo
* TABLA: BUZON CORREO
* DESCRIPCION:ALMACENA INFORMACION DEL DETALLE QUE DEBE SER NOTIFICADA VIA CORREO ELECTRONICO.
* ABREVIATURA: CBZC
*/
public class Cgg_buzon_correo implements Serializable{
	private static final long serialVersionUID = 1300433984;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO BUZON DE CORREO DE SALIDA
	*/
	private String myCbzc_codigo;
	/**
	* INFORMACION DEL DESTINATARIO DEL CORREO ELECTRONICO
	*/
	private String myCbzc_destinatario;
	/**
	* ASUNTO DEL CORREO ELECTRONICO
	*/
	private String myCbzc_asunto;
	/**
	* CUERPO O CONTENIDO DEL CORREO ELECTRONICO
	*/
	private String myCbzc_mensaje;
	/**
	* TIPO DE CONTENIDO PARA EL CUERPO DEL MENSAJE
	*/
	private String myCbzc_tipo_contenido;
	/**
	* CANTIDAD DE PRUEBAS DE ENVIO FALLIDAS 
	*/
	private java.math.BigDecimal myCbzc_numero_intentos;
	/**
	* INDICADOR SI EL CORREO FUE ENVIADO
	*/
	private boolean myCbzc_enviado;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCbzc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCbzc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCbzc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_buzon_correo
	*/
	public Cgg_buzon_correo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_buzon_correo
	* @param inCbzc_codigo IDENTIFICATIVO UNICO DE REGISTRO BUZON DE CORREO DE SALIDA
	* @param inCbzc_destinatario INFORMACION DEL DESTINATARIO DEL CORREO ELECTRONICO
	* @param inCbzc_asunto ASUNTO DEL CORREO ELECTRONICO
	* @param inCbzc_mensaje CUERPO O CONTENIDO DEL CORREO ELECTRONICO
	* @param inCbzc_tipo_contenido TIPO DE CONTENIDO PARA EL CUERPO DEL MENSAJE
	* @param inCbzc_numero_intentos CANTIDAD DE PRUEBAS DE ENVIO FALLIDAS 
	* @param inCbzc_enviado INDICADOR SI EL CORREO FUE ENVIADO
	* @param inCbzc_estado ESTADO DEL REGISTRO
	* @param inCbzc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCbzc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_buzon_correo(
		String inCbzc_codigo,
		String inCbzc_destinatario,
		String inCbzc_asunto,
		String inCbzc_mensaje,
		String inCbzc_tipo_contenido,
		java.math.BigDecimal inCbzc_numero_intentos,
		boolean inCbzc_enviado,
		boolean inCbzc_estado,
		String inCbzc_usuario_insert,
		String inCbzc_usuario_update
	){
		this.setCBZC_CODIGO(inCbzc_codigo);
		this.setCBZC_DESTINATARIO(inCbzc_destinatario);
		this.setCBZC_ASUNTO(inCbzc_asunto);
		this.setCBZC_MENSAJE(inCbzc_mensaje);
		this.setCBZC_TIPO_CONTENIDO(inCbzc_tipo_contenido);
		this.setCBZC_NUMERO_INTENTOS(inCbzc_numero_intentos);
		this.setCBZC_ENVIADO(inCbzc_enviado);
		this.setCBZC_ESTADO(inCbzc_estado);
		this.setCBZC_USUARIO_INSERT(inCbzc_usuario_insert);
		this.setCBZC_USUARIO_UPDATE(inCbzc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO BUZON DE CORREO DE SALIDA
	* @param inCbzc_codigo IDENTIFICATIVO UNICO DE REGISTRO BUZON DE CORREO DE SALIDA
	*/
	public void setCBZC_CODIGO(String inCbzc_codigo){
		this.myCbzc_codigo = inCbzc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO BUZON DE CORREO DE SALIDA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO BUZON DE CORREO DE SALIDA
	*/
	public String getCBZC_CODIGO(){
		return this.myCbzc_codigo;
	}

	/**
	* ESTABLECE INFORMACION DEL DESTINATARIO DEL CORREO ELECTRONICO
	* @param inCbzc_destinatario INFORMACION DEL DESTINATARIO DEL CORREO ELECTRONICO
	*/
	public void setCBZC_DESTINATARIO(String inCbzc_destinatario){
		this.myCbzc_destinatario = inCbzc_destinatario;
	}
	/**
	* OBTIENE INFORMACION DEL DESTINATARIO DEL CORREO ELECTRONICO
	* @return String INFORMACION DEL DESTINATARIO DEL CORREO ELECTRONICO
	*/
	public String getCBZC_DESTINATARIO(){
		return this.myCbzc_destinatario;
	}

	/**
	* ESTABLECE ASUNTO DEL CORREO ELECTRONICO
	* @param inCbzc_asunto ASUNTO DEL CORREO ELECTRONICO
	*/
	public void setCBZC_ASUNTO(String inCbzc_asunto){
		this.myCbzc_asunto = inCbzc_asunto;
	}
	/**
	* OBTIENE ASUNTO DEL CORREO ELECTRONICO
	* @return String ASUNTO DEL CORREO ELECTRONICO
	*/
	public String getCBZC_ASUNTO(){
		return this.myCbzc_asunto;
	}

	/**
	* ESTABLECE CUERPO O CONTENIDO DEL CORREO ELECTRONICO
	* @param inCbzc_mensaje CUERPO O CONTENIDO DEL CORREO ELECTRONICO
	*/
	public void setCBZC_MENSAJE(String inCbzc_mensaje){
		this.myCbzc_mensaje = inCbzc_mensaje;
	}
	/**
	* OBTIENE CUERPO O CONTENIDO DEL CORREO ELECTRONICO
	* @return String CUERPO O CONTENIDO DEL CORREO ELECTRONICO
	*/
	public String getCBZC_MENSAJE(){
		return this.myCbzc_mensaje;
	}

	/**
	* ESTABLECE TIPO DE CONTENIDO PARA EL CUERPO DEL MENSAJE
	* @param inCbzc_tipo_contenido TIPO DE CONTENIDO PARA EL CUERPO DEL MENSAJE
	*/
	public void setCBZC_TIPO_CONTENIDO(String inCbzc_tipo_contenido){
		this.myCbzc_tipo_contenido = inCbzc_tipo_contenido;
	}
	/**
	* OBTIENE TIPO DE CONTENIDO PARA EL CUERPO DEL MENSAJE
	* @return String TIPO DE CONTENIDO PARA EL CUERPO DEL MENSAJE
	*/
	public String getCBZC_TIPO_CONTENIDO(){
		return this.myCbzc_tipo_contenido;
	}

	/**
	* ESTABLECE CANTIDAD DE PRUEBAS DE ENVIO FALLIDAS 
	* @param inCbzc_numero_intentos CANTIDAD DE PRUEBAS DE ENVIO FALLIDAS 
	*/
	public void setCBZC_NUMERO_INTENTOS(java.math.BigDecimal inCbzc_numero_intentos){
		this.myCbzc_numero_intentos = inCbzc_numero_intentos;
	}
	/**
	* OBTIENE CANTIDAD DE PRUEBAS DE ENVIO FALLIDAS 
	* @return java.math.BigDecimal CANTIDAD DE PRUEBAS DE ENVIO FALLIDAS 
	*/
	public java.math.BigDecimal getCBZC_NUMERO_INTENTOS(){
		return this.myCbzc_numero_intentos;
	}

	/**
	* ESTABLECE INDICADOR SI EL CORREO FUE ENVIADO
	* @param inCbzc_enviado INDICADOR SI EL CORREO FUE ENVIADO
	*/
	public void setCBZC_ENVIADO(boolean inCbzc_enviado){
		this.myCbzc_enviado = inCbzc_enviado;
	}
	/**
	* OBTIENE INDICADOR SI EL CORREO FUE ENVIADO
	* @return boolean INDICADOR SI EL CORREO FUE ENVIADO
	*/
	public boolean getCBZC_ENVIADO(){
		return this.myCbzc_enviado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCbzc_estado ESTADO DEL REGISTRO
	*/
	public void setCBZC_ESTADO(boolean inCbzc_estado){
		this.myCbzc_estado = inCbzc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCBZC_ESTADO(){
		return this.myCbzc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCbzc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCBZC_USUARIO_INSERT(String inCbzc_usuario_insert){
		this.myCbzc_usuario_insert = inCbzc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCBZC_USUARIO_INSERT(){
		return this.myCbzc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCbzc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCBZC_USUARIO_UPDATE(String inCbzc_usuario_update){
		this.myCbzc_usuario_update = inCbzc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCBZC_USUARIO_UPDATE(){
		return this.myCbzc_usuario_update;
	}

}
