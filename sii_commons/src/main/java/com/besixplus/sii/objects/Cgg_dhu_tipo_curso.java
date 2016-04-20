package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_tipo_curso
* TABLA: TIPO CURSO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE CURSOS QUE PUEDEN REALIZARSE
* ABREVIATURA:CDTCR
*/
public class Cgg_dhu_tipo_curso implements Serializable{
	private static final long serialVersionUID = 720210060;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	*/
	private String myCdtcr_codigo;
	/**
	* NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	*/
	private String myCdtcr_nombre;
	/**
	* TIPO RESIDENTE
	*/
	private int myCdtcr_tipo_residente;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdtcr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdtcr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdtcr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_curso
	*/
	public Cgg_dhu_tipo_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_curso
	* @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	* @param inCdtcr_nombre NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	* @param inCdtcr_tipo_residente TIPO DE RESIDENTE PARA LOS CURSOS
	* @param inCdtcr_estado ESTADO DEL REGISTRO
	* @param inCdtcr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtcr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_tipo_curso(
		String inCdtcr_codigo,
		String inCdtcr_nombre,
		int inCdtcr_tipo_residente,
		boolean inCdtcr_estado,
		String inCdtcr_usuario_insert,
		String inCdtcr_usuario_update
	){
		this.setCDTCR_CODIGO(inCdtcr_codigo);
		this.setCDTCR_NOMBRE(inCdtcr_nombre);
		this.setCDTCR_TIPO_RESIDENTE(inCdtcr_tipo_residente);
		this.setCDTCR_ESTADO(inCdtcr_estado);
		this.setCDTCR_USUARIO_INSERT(inCdtcr_usuario_insert);
		this.setCDTCR_USUARIO_UPDATE(inCdtcr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	* @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	*/
	public void setCDTCR_CODIGO(String inCdtcr_codigo){
		this.myCdtcr_codigo = inCdtcr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	*/
	public String getCDTCR_CODIGO(){
		return this.myCdtcr_codigo;
	}

	/**
	* ESTABLECE NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	* @param inCdtcr_nombre NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	*/
	public void setCDTCR_NOMBRE(String inCdtcr_nombre){
		this.myCdtcr_nombre = inCdtcr_nombre;
	}
	/**
	* OBTIENE NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	* @return String NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	*/
	public String getCDTCR_NOMBRE(){
		return this.myCdtcr_nombre;
	}
	/**
	* ESTABLECE TIPO RESIDENTE
	* @param inCdtcr_tipo_residente TIPO RESIDENTE
	*/
	public void setCDTCR_TIPO_RESIDENTE(int inCdtcr_tipo_residente){
		this.myCdtcr_tipo_residente = inCdtcr_tipo_residente;
	}
	/**
	* OBTIENE NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	* @return String NOMBRE O DESCRIPCION DEL TIPO DE CURSO
	*/
	public int getCDTCR_TIPO_RESIDENTE(){
		return this.myCdtcr_tipo_residente;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdtcr_estado ESTADO DEL REGISTRO
	*/
	public void setCDTCR_ESTADO(boolean inCdtcr_estado){
		this.myCdtcr_estado = inCdtcr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDTCR_ESTADO(){
		return this.myCdtcr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtcr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDTCR_USUARIO_INSERT(String inCdtcr_usuario_insert){
		this.myCdtcr_usuario_insert = inCdtcr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDTCR_USUARIO_INSERT(){
		return this.myCdtcr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdtcr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDTCR_USUARIO_UPDATE(String inCdtcr_usuario_update){
		this.myCdtcr_usuario_update = inCdtcr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDTCR_USUARIO_UPDATE(){
		return this.myCdtcr_usuario_update;
	}

}
