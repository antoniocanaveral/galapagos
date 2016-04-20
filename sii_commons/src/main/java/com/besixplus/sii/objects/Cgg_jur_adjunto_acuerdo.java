package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_adjunto_acuerdo
* TABLA: ADJUNTO ACUERDO
* DESCRIPCION:ALMACENA INFORMACION DE LOS ARCHIVOS DIGITALES ANEXOS A LOS ACUERDOS
* ABREVIATURA:CJADA
*/
public class Cgg_jur_adjunto_acuerdo implements Serializable{
	private static final long serialVersionUID = 1775182555;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
	*/
	private String myCjada_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	*/
	private String myCjacu_codigo;
	/**
	* DESCRIP`CION DEL ARCHIVO ADJUNTO
	*/
	private String myCjada_descripcion;
	/**
	* NOMBRE DEL ADJUNTO
	*/
	private String myCjada_nombre_adjunto;
	/**
	* ARCHIVO DIGITAL 
	*/
	private byte[] myCjada_adjunto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjada_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjada_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjada_usuario_update;
	/**
	* IDENTIFICATIVO PARA LA CLAVE DE CGG_JUR_HISTORIAL_PROCESO
	*/
	private String myCjhac_codigo;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_acuerdo
	*/
	public Cgg_jur_adjunto_acuerdo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_adjunto_acuerdo
	* @param inCjada_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	* @param inCjada_descripcion DESCRIP`CION DEL ARCHIVO ADJUNTO
	* @param inCjada_nombre_adjunto NOMBRE DEL ADJUNTO
	* @param inCjada_adjunto ARCHIVO DIGITAL 
	* @param inCjada_estado ESTADO DEL REGISTRO
	* @param inCjada_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjada_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjhac_codigo IDENTIFICATIVO PARA LA CLAVE DE CGG_JUR_HISTORIAL_PROCESO
	*/
	public Cgg_jur_adjunto_acuerdo(
		String inCjada_codigo,
		String inCjacu_codigo,
		String inCjada_descripcion,
		String inCjada_nombre_adjunto,
		byte[] inCjada_adjunto,
		boolean inCjada_estado,
		String inCjada_usuario_insert,
		String inCjada_usuario_update,
		String inCjhac_codigo
	){
		this.setCJADA_CODIGO(inCjada_codigo);
		this.setCJACU_CODIGO(inCjacu_codigo);
		this.setCJADA_DESCRIPCION(inCjada_descripcion);
		this.setCJADA_NOMBRE_ADJUNTO(inCjada_nombre_adjunto);
		this.setCJADA_ADJUNTO(inCjada_adjunto);
		this.setCJADA_ESTADO(inCjada_estado);
		this.setCJADA_USUARIO_INSERT(inCjada_usuario_insert);
		this.setCJADA_USUARIO_UPDATE(inCjada_usuario_update);
		this.setCJHAC_CODIGO(inCjhac_codigo);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
	* @param inCjada_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
	*/
	public void setCJADA_CODIGO(String inCjada_codigo){
		this.myCjada_codigo = inCjada_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
	*/
	public String getCJADA_CODIGO(){
		return this.myCjada_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	*/
	public void setCJACU_CODIGO(String inCjacu_codigo){
		this.myCjacu_codigo = inCjacu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CONVENIO
	*/
	public String getCJACU_CODIGO(){
		return this.myCjacu_codigo;
	}

	/**
	* ESTABLECE DESCRIP`CION DEL ARCHIVO ADJUNTO
	* @param inCjada_descripcion DESCRIP`CION DEL ARCHIVO ADJUNTO
	*/
	public void setCJADA_DESCRIPCION(String inCjada_descripcion){
		this.myCjada_descripcion = inCjada_descripcion;
	}
	/**
	* OBTIENE DESCRIP`CION DEL ARCHIVO ADJUNTO
	* @return String DESCRIP`CION DEL ARCHIVO ADJUNTO
	*/
	public String getCJADA_DESCRIPCION(){
		return this.myCjada_descripcion;
	}

	/**
	* ESTABLECE NOMBRE DEL ADJUNTO
	* @param inCjada_nombre_adjunto NOMBRE DEL ADJUNTO
	*/
	public void setCJADA_NOMBRE_ADJUNTO(String inCjada_nombre_adjunto){
		this.myCjada_nombre_adjunto = inCjada_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL ADJUNTO
	* @return String NOMBRE DEL ADJUNTO
	*/
	public String getCJADA_NOMBRE_ADJUNTO(){
		return this.myCjada_nombre_adjunto;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL 
	* @param inCjada_adjunto ARCHIVO DIGITAL 
	*/
	public void setCJADA_ADJUNTO(byte[] inCjada_adjunto){
		this.myCjada_adjunto = inCjada_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL 
	* @return byte[] ARCHIVO DIGITAL 
	*/
	public byte[] getCJADA_ADJUNTO(){
		return this.myCjada_adjunto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjada_estado ESTADO DEL REGISTRO
	*/
	public void setCJADA_ESTADO(boolean inCjada_estado){
		this.myCjada_estado = inCjada_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJADA_ESTADO(){
		return this.myCjada_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjada_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJADA_USUARIO_INSERT(String inCjada_usuario_insert){
		this.myCjada_usuario_insert = inCjada_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJADA_USUARIO_INSERT(){
		return this.myCjada_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjada_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJADA_USUARIO_UPDATE(String inCjada_usuario_update){
		this.myCjada_usuario_update = inCjada_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJADA_USUARIO_UPDATE(){
		return this.myCjada_usuario_update;
	}

	/**
	* ESTABLECE IDENTIFICATIVO PARA LA CLAVE DE CGG_JUR_HISTORIAL_PROCESO
	* @param inCjhac_codigo IDENTIFICATIVO PARA LA CLAVE DE CGG_JUR_HISTORIAL_PROCESO
	*/
	public void setCJHAC_CODIGO(String inCjhac_codigo){
		this.myCjhac_codigo = inCjhac_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO PARA LA CLAVE DE CGG_JUR_HISTORIAL_PROCESO
	* @return String IDENTIFICATIVO PARA LA CLAVE DE CGG_JUR_HISTORIAL_PROCESO
	*/
	public String getCJHAC_CODIGO(){
		return this.myCjhac_codigo;
	}

}
