package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tipo_notificacion
* TABLA: TIPO DE NOTIFICACION
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE NOTIFICACIONES
* ABREVIATURA:CRTNT
*/
public class Cgg_res_tipo_notificacion implements Serializable{
	private static final long serialVersionUID = 1043745851;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO
	*/
	private String myCrtnt_codigo;
	/**
	* DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	private String myCrtnt_descripcion;
	/**
	* ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
	*/
	private boolean myCrtnt_causal_salida;
	/**
	* DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
	*/
	private String myCrtnt_sustento_legal;
	/**
	* ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
	*/
	private boolean myCrtnt_causal_caducidad;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtnt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtnt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtnt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_notificacion
	*/
	public Cgg_res_tipo_notificacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_notificacion
	* @param inCrtnt_codigo IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrtnt_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrtnt_causal_salida ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
	* @param inCrtnt_sustento_legal DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
	* @param inCrtnt_causal_caducidad ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
	* @param inCrtnt_estado ESTADO DEL REGISTRO
	* @param inCrtnt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtnt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tipo_notificacion(
		String inCrtnt_codigo,
		String inCrtnt_descripcion,
		boolean inCrtnt_causal_salida,
		String inCrtnt_sustento_legal,
		boolean inCrtnt_causal_caducidad,
		boolean inCrtnt_estado,
		String inCrtnt_usuario_insert,
		String inCrtnt_usuario_update
	){
		this.setCRTNT_CODIGO(inCrtnt_codigo);
		this.setCRTNT_DESCRIPCION(inCrtnt_descripcion);
		this.setCRTNT_CAUSAL_SALIDA(inCrtnt_causal_salida);
		this.setCRTNT_SUSTENTO_LEGAL(inCrtnt_sustento_legal);
		this.setCRTNT_CAUSAL_CADUCIDAD(inCrtnt_causal_caducidad);
		this.setCRTNT_ESTADO(inCrtnt_estado);
		this.setCRTNT_USUARIO_INSERT(inCrtnt_usuario_insert);
		this.setCRTNT_USUARIO_UPDATE(inCrtnt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO
	* @param inCrtnt_codigo IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public void setCRTNT_CODIGO(String inCrtnt_codigo){
		this.myCrtnt_codigo = inCrtnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO
	*/
	public String getCRTNT_CODIGO(){
		return this.myCrtnt_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrtnt_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public void setCRTNT_DESCRIPCION(String inCrtnt_descripcion){
		this.myCrtnt_descripcion = inCrtnt_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @return String DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public String getCRTNT_DESCRIPCION(){
		return this.myCrtnt_descripcion;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
	* @param inCrtnt_causal_salida ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
	*/
	public void setCRTNT_CAUSAL_SALIDA(boolean inCrtnt_causal_salida){
		this.myCrtnt_causal_salida = inCrtnt_causal_salida;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
	* @return boolean ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
	*/
	public boolean getCRTNT_CAUSAL_SALIDA(){
		return this.myCrtnt_causal_salida;
	}

	/**
	* ESTABLECE DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
	* @param inCrtnt_sustento_legal DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
	*/
	public void setCRTNT_SUSTENTO_LEGAL(String inCrtnt_sustento_legal){
		this.myCrtnt_sustento_legal = inCrtnt_sustento_legal;
	}
	/**
	* OBTIENE DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
	* @return String DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
	*/
	public String getCRTNT_SUSTENTO_LEGAL(){
		return this.myCrtnt_sustento_legal;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
	* @param inCrtnt_causal_caducidad ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
	*/
	public void setCRTNT_CAUSAL_CADUCIDAD(boolean inCrtnt_causal_caducidad){
		this.myCrtnt_causal_caducidad = inCrtnt_causal_caducidad;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
	* @return boolean ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
	*/
	public boolean getCRTNT_CAUSAL_CADUCIDAD(){
		return this.myCrtnt_causal_caducidad;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtnt_estado ESTADO DEL REGISTRO
	*/
	public void setCRTNT_ESTADO(boolean inCrtnt_estado){
		this.myCrtnt_estado = inCrtnt_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTNT_ESTADO(){
		return this.myCrtnt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtnt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTNT_USUARIO_INSERT(String inCrtnt_usuario_insert){
		this.myCrtnt_usuario_insert = inCrtnt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTNT_USUARIO_INSERT(){
		return this.myCrtnt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtnt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTNT_USUARIO_UPDATE(String inCrtnt_usuario_update){
		this.myCrtnt_usuario_update = inCrtnt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTNT_USUARIO_UPDATE(){
		return this.myCrtnt_usuario_update;
	}

}
