package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_perfil_adjunto
* TABLA: PERFIL ADJUNTO
* DESCRIPCION: ALMACENA INFORMACION DE LOS ARCHIVOS ADJUNTOS EXISTENTES PARA RESPALDAR LOS PERFILES INGRESADOS
* ABREVIATURA:CGPFA
*/
public class Cgg_gem_perfil_adjunto implements Serializable{
	private static final long serialVersionUID = 1478747953;
	/**
	* CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	*/
	private String myCgpfa_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	private String myCgpfa_descripcion;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCgpfa_nombre_adjunto;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgpfa_tipo_adjunto;
	/**
	* CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	private byte[] myCgpfa_adjunto;
	/**
	* TIPO DE ARCHIVO
	*/
	private int myCgpfa_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgpfa_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgpfa_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgpfa_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_adjunto
	*/
	public Cgg_gem_perfil_adjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_adjunto
	* @param inCgpfa_codigo CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCgppr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	* @param inCgpfa_descripcion CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	* @param inCgpfa_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCgpfa_tipo_adjunto NO ESPECIFICADO
	* @param inCgpfa_adjunto CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	* @param inCgpfa_tipo ESPECIFICA EL TIPO DE ARCHIVO
	0 - TIPO PERFIL
	1 - TIPO CERTIFICADO
	* @param inCgpfa_estado ESTADO DEL REGISTRO
	* @param inCgpfa_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgpfa_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_perfil_adjunto(
		String inCgpfa_codigo,
		String inCrper_codigo,
		String inCgpfa_descripcion,
		String inCgpfa_nombre_adjunto,
		String inCgpfa_tipo_adjunto,
		byte[] inCgpfa_adjunto,
		int inCgpfa_tipo,
		boolean inCgpfa_estado,
		String inCgpfa_usuario_insert,
		String inCgpfa_usuario_update
	){
		this.setCGPFA_CODIGO(inCgpfa_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGPFA_DESCRIPCION(inCgpfa_descripcion);
		this.setCGPFA_NOMBRE_ADJUNTO(inCgpfa_nombre_adjunto);
		this.setCGPFA_TIPO_ADJUNTO(inCgpfa_tipo_adjunto);
		this.setCGPFA_ADJUNTO(inCgpfa_adjunto);
		this.setCGPFA_TIPO(inCgpfa_tipo);
		this.setCGPFA_ESTADO(inCgpfa_estado);
		this.setCGPFA_USUARIO_INSERT(inCgpfa_usuario_insert);
		this.setCGPFA_USUARIO_UPDATE(inCgpfa_usuario_update);
	}

	/**
	* ESTABLECE CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	* @param inCgpfa_codigo CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	*/
	public void setCGPFA_CODIGO(String inCgpfa_codigo){
		this.myCgpfa_codigo = inCgpfa_codigo;
	}
	/**
	* OBTIENE CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	* @return String CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	*/
	public String getCGPFA_CODIGO(){
		return this.myCgpfa_codigo;
	}

	/**
	* ESTABLECE EL CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	* @param inCgpfa_descripcion CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	public void setCGPFA_DESCRIPCION(String inCgpfa_descripcion){
		this.myCgpfa_descripcion = inCgpfa_descripcion;
	}
	/**
	* OBTIENE CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	* @return String CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	public String getCGPFA_DESCRIPCION(){
		return this.myCgpfa_descripcion;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCgpfa_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCGPFA_NOMBRE_ADJUNTO(String inCgpfa_nombre_adjunto){
		this.myCgpfa_nombre_adjunto = inCgpfa_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCGPFA_NOMBRE_ADJUNTO(){
		return this.myCgpfa_nombre_adjunto;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgpfa_tipo_adjunto NO ESPECIFICADO
	*/
	public void setCGPFA_TIPO_ADJUNTO(String inCgpfa_tipo_adjunto){
		this.myCgpfa_tipo_adjunto = inCgpfa_tipo_adjunto;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGPFA_TIPO_ADJUNTO(){
		return this.myCgpfa_tipo_adjunto;
	}

	/**
	* ESTABLECE CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	* @param inCgpfa_adjunto CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	public void setCGPFA_ADJUNTO(byte[] inCgpfa_adjunto){
		this.myCgpfa_adjunto = inCgpfa_adjunto;
	}
	/**
	* OBTIENE CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	* @return byte[] CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	public byte[] getCGPFA_ADJUNTO(){
		return this.myCgpfa_adjunto;
	}
	/**
	* ESTABLECE TIPO DE ARCHIVO
	* @param inCgpfa_tipo NO ESPECIFICADO
	*/
	public void setCGPFA_TIPO(int inCgpfa_tipo){
		this.myCgpfa_tipo = inCgpfa_tipo;
	}
	/**
	* OBTIENE EL TIPO DE ARCHIVO
	* @return INT TIPO DE ARCHIVO
	*/
	public int getCGPFA_TIPO(){
		return this.myCgpfa_tipo;
	}
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgpfa_estado ESTADO DEL REGISTRO
	*/
	public void setCGPFA_ESTADO(boolean inCgpfa_estado){
		this.myCgpfa_estado = inCgpfa_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGPFA_ESTADO(){
		return this.myCgpfa_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgpfa_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGPFA_USUARIO_INSERT(String inCgpfa_usuario_insert){
		this.myCgpfa_usuario_insert = inCgpfa_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGPFA_USUARIO_INSERT(){
		return this.myCgpfa_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgpfa_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGPFA_USUARIO_UPDATE(String inCgpfa_usuario_update){
		this.myCgpfa_usuario_update = inCgpfa_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGPFA_USUARIO_UPDATE(){
		return this.myCgpfa_usuario_update;
	}

}
