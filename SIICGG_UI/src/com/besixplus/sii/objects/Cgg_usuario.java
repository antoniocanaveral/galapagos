package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_usuario
* TABLA: USUARIO
* DESCRIPCION:ALMACENA INFORMACION DE LOS USUARIOS DEL SISTEMA
* ABREVIATURA:CUSU
*/
public class Cgg_usuario implements Serializable{
	private static final long serialVersionUID = 1071789662;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	private String myCrcrg_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	private String myCisla_codigo;
	/**
	* IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	*/
	private String myCusu_nombre_usuario;
	/**
	* CLAVE DE ACCESO
	*/
	private String myCusu_clave_acceso;
	/**
	* TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	*/
	private boolean myCusu_usuario_interno;
	/**
	* SI LA CLAVE DEL USUARIO CADUCA
	*/
	private boolean myCusu_caduca_clave;
	/**
	* FECHA DE LA ULTIMA ACTUALIZACION DE LA CLAVE DE ACCESO DEL USUARIO
	*/
	private java.util.Date myCusu_fecha_clave_act;
	/**
	* SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	*/
	private boolean myCusu_activo;
	/**
	* SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	*/
	private boolean myCusu_cambiar_clave;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCusu_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCusu_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCusu_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_usuario
	*/
	public Cgg_usuario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_usuario
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCtagv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param inCusu_nombre_usuario IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	* @param inCusu_clave_acceso CLAVE DE ACCESO
	* @param inCusu_usuario_interno TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	* @param inCusu_caduca_clave SI LA CLAVE DEL USUARIO CADUCA
	* @param inCusu_fecha_clave_act FECHA DE LA ULTIMA ACTUALIZACION DE LA CLAVE DE ACCESO DEL USUARIO
	* @param inCusu_activo SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	* @param inCusu_estado ESTADO DEL REGISTRO
	* @param inCusu_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCusu_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_usuario(
		String inCusu_codigo,
		String inCrcrg_codigo,
		String inCrper_codigo,
		String inCrpjr_codigo,
		String inCctn_codigo,
		String inCisla_codigo,
		String inCusu_nombre_usuario,
		String inCusu_clave_acceso,
		boolean inCusu_usuario_interno,
		boolean inCusu_caduca_clave,
		java.util.Date inCusu_fecha_clave_act,
		boolean inCusu_activo,
		boolean inCusu_estado,
		String inCusu_usuario_insert,
		String inCusu_usuario_update
	){
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRCRG_CODIGO(inCrcrg_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCISLA_CODIGO(inCisla_codigo);
		this.setCUSU_NOMBRE_USUARIO(inCusu_nombre_usuario);
		this.setCUSU_CLAVE_ACCESO(inCusu_clave_acceso);
		this.setCUSU_USUARIO_INTERNO(inCusu_usuario_interno);
		this.setCUSU_CADUCA_CLAVE(inCusu_caduca_clave);
		this.setCUSU_FECHA_CLAVE_ACT(inCusu_fecha_clave_act);
		this.setCUSU_ACTIVO(inCusu_activo);
		this.setCUSU_ESTADO(inCusu_estado);
		this.setCUSU_USUARIO_INSERT(inCusu_usuario_insert);
		this.setCUSU_USUARIO_UPDATE(inCusu_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param incusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param incrcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public void setCRCRG_CODIGO(String inCrcrg_codigo){
		this.myCrcrg_codigo = inCrcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public String getCRCRG_CODIGO(){
		return this.myCrcrg_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param incrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param incrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param incctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param incisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	public void setCISLA_CODIGO(String inCisla_codigo){
		this.myCisla_codigo = inCisla_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
	public String getCISLA_CODIGO(){
		return this.myCisla_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	* @param incusu_nombre_usuario IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	*/
	public void setCUSU_NOMBRE_USUARIO(String inCusu_nombre_usuario){
		this.myCusu_nombre_usuario = inCusu_nombre_usuario;
	}
	/**
	* OBTIENE IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	* @return String IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	*/
	public String getCUSU_NOMBRE_USUARIO(){
		return this.myCusu_nombre_usuario;
	}

	/**
	* ESTABLECE CLAVE DE ACCESO
	* @param incusu_clave_acceso CLAVE DE ACCESO
	*/
	public void setCUSU_CLAVE_ACCESO(String inCusu_clave_acceso){
		this.myCusu_clave_acceso = inCusu_clave_acceso;
	}
	/**
	* OBTIENE CLAVE DE ACCESO
	* @return String CLAVE DE ACCESO
	*/
	public String getCUSU_CLAVE_ACCESO(){
		return this.myCusu_clave_acceso;
	}

	/**
	* ESTABLECE TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	* @param incusu_usuario_interno TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	*/
	public void setCUSU_USUARIO_INTERNO(boolean inCusu_usuario_interno){
		this.myCusu_usuario_interno = inCusu_usuario_interno;
	}
	/**
	* OBTIENE TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	* @return boolean TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	*/
	public boolean getCUSU_USUARIO_INTERNO(){
		return this.myCusu_usuario_interno;
	}

	/**
	* ESTABLECE SI LA CLAVE DEL USUARIO CADUCA
	* @param incusu_caduca_clave SI LA CLAVE DEL USUARIO CADUCA
	*/
	public void setCUSU_CADUCA_CLAVE(boolean inCusu_caduca_clave){
		this.myCusu_caduca_clave = inCusu_caduca_clave;
	}
	/**
	* OBTIENE SI LA CLAVE DEL USUARIO CADUCA
	* @return boolean SI LA CLAVE DEL USUARIO CADUCA
	*/
	public boolean getCUSU_CADUCA_CLAVE(){
		return this.myCusu_caduca_clave;
	}

	/**
	* ESTABLECE FECHA DE LA ULTIMA ACTUALIZACION DE LA CLAVE DE ACCESO DEL USUARIO
	* @param incusu_fecha_clave_act FECHA DE LA ULTIMA ACTUALIZACION DE LA CLAVE DE ACCESO DEL USUARIO
	*/
	public void setCUSU_FECHA_CLAVE_ACT(java.util.Date inCusu_fecha_clave_act){
		this.myCusu_fecha_clave_act = inCusu_fecha_clave_act;
	}
	/**
	* OBTIENE FECHA DE LA ULTIMA ACTUALIZACION DE LA CLAVE DE ACCESO DEL USUARIO
	* @return java.util.Date FECHA DE LA ULTIMA ACTUALIZACION DE LA CLAVE DE ACCESO DEL USUARIO
	*/
	public java.util.Date getCUSU_FECHA_CLAVE_ACT(){
		return this.myCusu_fecha_clave_act;
	}

	/**
	* ESTABLECE SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	* @param incusu_activo SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	*/
	public void setCUSU_ACTIVO(boolean inCusu_activo){
		this.myCusu_activo = inCusu_activo;
	}
	/**
	* OBTIENE SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	* @return boolean SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	*/
	public boolean getCUSU_ACTIVO(){
		return this.myCusu_activo;
	}

	/**
	* ESTABLECE SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	* @param incusu_cambiar_clave SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	*/
	public void setCUSU_CAMBIAR_CLAVE(boolean inCusu_cambiar_clave){
		this.myCusu_cambiar_clave = inCusu_cambiar_clave;
	}
	/**
	* OBTIENE SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	* @return boolean SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	*/
	public boolean getCUSU_CAMBIAR_CLAVE(){
		return this.myCusu_cambiar_clave;
	}
	
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param incusu_estado ESTADO DEL REGISTRO
	*/
	public void setCUSU_ESTADO(boolean inCusu_estado){
		this.myCusu_estado = inCusu_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCUSU_ESTADO(){
		return this.myCusu_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param incusu_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCUSU_USUARIO_INSERT(String inCusu_usuario_insert){
		this.myCusu_usuario_insert = inCusu_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCUSU_USUARIO_INSERT(){
		return this.myCusu_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param incusu_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCUSU_USUARIO_UPDATE(String inCusu_usuario_update){
		this.myCusu_usuario_update = inCusu_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCUSU_USUARIO_UPDATE(){
		return this.myCusu_usuario_update;
	}

}
