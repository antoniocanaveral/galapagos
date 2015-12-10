package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sec_usuario_contacto
* TABLA: USUARIO CONTACTO
* DESCRIPCION: CONTIENE LA INFORMACION DE LOCALIZACION INSTITUCIONAL DE UNA PERSONA
* ABREVIATURA: CSUCT
*/
public class Cgg_sec_usuario_contacto implements Serializable{
	private static final long serialVersionUID = 1118134770;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CONTACTO
	*/
	private String myCsuct_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	private String myCrtco_codigo;
	/**
	* INFORMACION DE LOCALIZACION
	*/
	private String myCsuct_contacto;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCsuct_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsuct_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsuct_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsuct_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_usuario_contacto
	*/
	public Cgg_sec_usuario_contacto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_usuario_contacto
	* @param inCsuct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CONTACTO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCrtco_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	* @param inCsuct_contacto INFORMACION DE LOCALIZACION
	* @param inCsuct_observacion INFORMACION ADICIONAL
	* @param inCsuct_estado ESTADO DEL REGISTRO
	* @param inCsuct_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsuct_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sec_usuario_contacto(
		String inCsuct_codigo,
		String inCusu_codigo,
		String inCrtco_codigo,
		String inCsuct_contacto,
		String inCsuct_observacion,
		boolean inCsuct_estado,
		String inCsuct_usuario_insert,
		String inCsuct_usuario_update
	){
		this.setCSUCT_CODIGO(inCsuct_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRTCO_CODIGO(inCrtco_codigo);
		this.setCSUCT_CONTACTO(inCsuct_contacto);
		this.setCSUCT_OBSERVACION(inCsuct_observacion);
		this.setCSUCT_ESTADO(inCsuct_estado);
		this.setCSUCT_USUARIO_INSERT(inCsuct_usuario_insert);
		this.setCSUCT_USUARIO_UPDATE(inCsuct_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CONTACTO
	* @param inCsuct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CONTACTO
	*/
	public void setCSUCT_CODIGO(String inCsuct_codigo){
		this.myCsuct_codigo = inCsuct_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CONTACTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO CONTACTO
	*/
	public String getCSUCT_CODIGO(){
		return this.myCsuct_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
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
	* ESTABLECE INFORMACION DE LOCALIZACION
	* @param inCsuct_contacto INFORMACION DE LOCALIZACION
	*/
	public void setCSUCT_CONTACTO(String inCsuct_contacto){
		this.myCsuct_contacto = inCsuct_contacto;
	}
	/**
	* OBTIENE INFORMACION DE LOCALIZACION
	* @return String INFORMACION DE LOCALIZACION
	*/
	public String getCSUCT_CONTACTO(){
		return this.myCsuct_contacto;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCsuct_observacion INFORMACION ADICIONAL
	*/
	public void setCSUCT_OBSERVACION(String inCsuct_observacion){
		this.myCsuct_observacion = inCsuct_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCSUCT_OBSERVACION(){
		return this.myCsuct_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsuct_estado ESTADO DEL REGISTRO
	*/
	public void setCSUCT_ESTADO(boolean inCsuct_estado){
		this.myCsuct_estado = inCsuct_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSUCT_ESTADO(){
		return this.myCsuct_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsuct_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSUCT_USUARIO_INSERT(String inCsuct_usuario_insert){
		this.myCsuct_usuario_insert = inCsuct_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSUCT_USUARIO_INSERT(){
		return this.myCsuct_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsuct_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSUCT_USUARIO_UPDATE(String inCsuct_usuario_update){
		this.myCsuct_usuario_update = inCsuct_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSUCT_USUARIO_UPDATE(){
		return this.myCsuct_usuario_update;
	}

}
