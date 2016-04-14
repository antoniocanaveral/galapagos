package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_institucion_contacto
* TABLA: INSTITUCION CONTACO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CONTACTOS ASOCIADOS A UNA INSTITUCION EDUCATIVA
* ABREVIATURA:CINTC
*/
public class Cgg_institucion_contacto implements Serializable{
	private static final long serialVersionUID = 240265560;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION CONTACTO
	*/
	private String myCintc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUTUCION EDUCATIVA
	*/
	private String myCgied_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* VALOR ASIGNADO AL CONTACTO
	*/
	private String myCintc_descripcion;
	/**
	* NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	private String myCintc_contacto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCintc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCintc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCintc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_contacto
	*/
	public Cgg_institucion_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_institucion_contacto
	* @param inCintc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION CONTACTO
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUTUCION EDUCATIVA
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCintc_descripcion VALOR ASIGNADO AL CONTACTO
	* @param inCintc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCintc_estado ESTADO DEL REGISTRO
	* @param inCintc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCintc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_institucion_contacto(
		String inCintc_codigo,
		String inCgied_codigo,
		String inCrtco_codigo,
		String inCintc_descripcion,
		String inCintc_contacto,
		boolean inCintc_estado,
		String inCintc_usuario_insert,
		String inCintc_usuario_update
	){
		this.setCINTC_CODIGO(inCintc_codigo);
		this.setCGIED_CODIGO(inCgied_codigo);
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCINTC_DESCRIPCION(inCintc_descripcion);
		this.setCINTC_CONTACTO(inCintc_contacto);
		this.setCINTC_ESTADO(inCintc_estado);
		this.setCINTC_USUARIO_INSERT(inCintc_usuario_insert);
		this.setCINTC_USUARIO_UPDATE(inCintc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION CONTACTO
	* @param inCintc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION CONTACTO
	*/
	public void setCINTC_CODIGO(String inCintc_codigo){
		this.myCintc_codigo = inCintc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION CONTACTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION CONTACTO
	*/
	public String getCINTC_CODIGO(){
		return this.myCintc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUTUCION EDUCATIVA
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUTUCION EDUCATIVA
	*/
	public void setCGIED_CODIGO(String inCgied_codigo){
		this.myCgied_codigo = inCgied_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUTUCION EDUCATIVA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUTUCION EDUCATIVA
	*/
	public String getCGIED_CODIGO(){
		return this.myCgied_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	public void setCRTCO_CODIGO(String inCrtco_codigo){
		this.myCrtco_codigo = inCrtco_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	public String getCRTCO_CODIGO(){
		return this.myCrtco_codigo;
	}

	/**
	* ESTABLECE VALOR ASIGNADO AL CONTACTO
	* @param inCintc_descripcion VALOR ASIGNADO AL CONTACTO
	*/
	public void setCINTC_DESCRIPCION(String inCintc_descripcion){
		this.myCintc_descripcion = inCintc_descripcion;
	}
	/**
	* OBTIENE VALOR ASIGNADO AL CONTACTO
	* @return String VALOR ASIGNADO AL CONTACTO
	*/
	public String getCINTC_DESCRIPCION(){
		return this.myCintc_descripcion;
	}

	/**
	* ESTABLECE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @param inCintc_contacto NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public void setCINTC_CONTACTO(String inCintc_contacto){
		this.myCintc_contacto = inCintc_contacto;
	}
	/**
	* OBTIENE NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	* @return String NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	public String getCINTC_CONTACTO(){
		return this.myCintc_contacto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCintc_estado ESTADO DEL REGISTRO
	*/
	public void setCINTC_ESTADO(boolean inCintc_estado){
		this.myCintc_estado = inCintc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCINTC_ESTADO(){
		return this.myCintc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCintc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCINTC_USUARIO_INSERT(String inCintc_usuario_insert){
		this.myCintc_usuario_insert = inCintc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCINTC_USUARIO_INSERT(){
		return this.myCintc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCintc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCINTC_USUARIO_UPDATE(String inCintc_usuario_update){
		this.myCintc_usuario_update = inCintc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCINTC_USUARIO_UPDATE(){
		return this.myCintc_usuario_update;
	}

}
