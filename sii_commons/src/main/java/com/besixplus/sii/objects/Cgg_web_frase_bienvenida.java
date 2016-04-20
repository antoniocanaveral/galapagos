package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_web_frase_bienvenida
* TABLA:FRASES DE BIENVENIDA
* DESCRIPCION:ALMACENA INFORMACION DE LAS FRASES DE BIENVENIDA QUE EL USUARIO PODRA OBSERVAR CUANDO INGRESE AL SITIO WEB
* ABREVIATURA:CWFB
*/
public class Cgg_web_frase_bienvenida implements Serializable{
	private static final long serialVersionUID = 1924952976;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCwfb_codigo;
	/**
	* CONTENIDO DE LA FRASE O MENSAJE
	*/
	private String myCwfb_contenido;
	/**
	* HABILIDATO PARA MOSTRAR O NO
	*/
	private boolean myCwfb_hibilitado;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCwfb_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCwfb_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCwfb_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_frase_bienvenida
	*/
	public Cgg_web_frase_bienvenida(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_frase_bienvenida
	* @param inCwfb_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCwfb_contenido CONTENIDO DE LA FRASE O MENSAJE
	* @param inCwfb_hibilitado HABILIDATO PARA MOSTRAR O NO
	* @param inCwfb_estado ESTADO DEL REGISTRO
	* @param inCwfb_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwfb_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_web_frase_bienvenida(
		String inCwfb_codigo,
		String inCwfb_contenido,
		boolean inCwfb_hibilitado,
		boolean inCwfb_estado,
		String inCwfb_usuario_insert,
		String inCwfb_usuario_update
	){
		this.setCWFB_CODIGO(inCwfb_codigo);
		this.setCWFB_CONTENIDO(inCwfb_contenido);
		this.setCWFB_HIBILITADO(inCwfb_hibilitado);
		this.setCWFB_ESTADO(inCwfb_estado);
		this.setCWFB_USUARIO_INSERT(inCwfb_usuario_insert);
		this.setCWFB_USUARIO_UPDATE(inCwfb_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCwfb_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCWFB_CODIGO(String inCwfb_codigo){
		this.myCwfb_codigo = inCwfb_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCWFB_CODIGO(){
		return this.myCwfb_codigo;
	}

	/**
	* ESTABLECE CONTENIDO DE LA FRASE O MENSAJE
	* @param inCwfb_contenido CONTENIDO DE LA FRASE O MENSAJE
	*/
	public void setCWFB_CONTENIDO(String inCwfb_contenido){
		this.myCwfb_contenido = inCwfb_contenido;
	}
	/**
	* OBTIENE CONTENIDO DE LA FRASE O MENSAJE
	* @return String CONTENIDO DE LA FRASE O MENSAJE
	*/
	public String getCWFB_CONTENIDO(){
		return this.myCwfb_contenido;
	}

	/**
	* ESTABLECE HABILIDATO PARA MOSTRAR O NO
	* @param inCwfb_hibilitado HABILIDATO PARA MOSTRAR O NO
	*/
	public void setCWFB_HIBILITADO(boolean inCwfb_hibilitado){
		this.myCwfb_hibilitado = inCwfb_hibilitado;
	}
	/**
	* OBTIENE HABILIDATO PARA MOSTRAR O NO
	* @return boolean HABILIDATO PARA MOSTRAR O NO
	*/
	public boolean getCWFB_HIBILITADO(){
		return this.myCwfb_hibilitado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCwfb_estado ESTADO DEL REGISTRO
	*/
	public void setCWFB_ESTADO(boolean inCwfb_estado){
		this.myCwfb_estado = inCwfb_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCWFB_ESTADO(){
		return this.myCwfb_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwfb_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCWFB_USUARIO_INSERT(String inCwfb_usuario_insert){
		this.myCwfb_usuario_insert = inCwfb_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCWFB_USUARIO_INSERT(){
		return this.myCwfb_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCwfb_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCWFB_USUARIO_UPDATE(String inCwfb_usuario_update){
		this.myCwfb_usuario_update = inCwfb_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCWFB_USUARIO_UPDATE(){
		return this.myCwfb_usuario_update;
	}

}
