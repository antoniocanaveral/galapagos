package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_preregistro_empresa
* TABLA: PREREGISTRO EMPRESA
* DESCRIPCION:ALMACENA INFORMACION SOBRE EL PRE REGISTRO DE UNA EMPRESA
* ABREVIATURA:CGPRE
*/
public class Cgg_gem_preregistro_empresa implements Serializable{
	private static final long serialVersionUID = 1875977512;
	/**
	* IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	*/
	private String myCgpre_codigo;
	/**
	* DESCRIPCION SOBRE LA RAZON SOCIAL
	*/
	private String myCgpre_razon_social;
	/**
	* RUC ESPECIFICO DE LA EMPRESA
	*/
	private String myCgpre_ruc;
	/**
	* REPRESENTANTE DE LA EMPRESA
	*/
	private String myCgpre_representante;
	/**
	* FECHA DE CREACION DE LA EMPRESA
	*/
	private java.util.Date myCgpre_fecha_creacion;
	/**
	* ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	*/
	private String myCgpre_actividad;
	/**
	* DIRECCION DE LA EMPRESA
	*/
	private String myCgpre_direccion;
	/**
	* SECTOR DE LA EMPRESA
	*/
	private String myCgpre_sector;
	/**
	* TIPO DE EMPRESA
	*/
	private String myCgpre_tipo;
	/**
	* NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	*/
	private int myCgpre_numero_empleado;
	/**
	* CONTACTO TELEFONICO DE LA EMPRESA
	*/
	private String myCgpre_telefono;
	/**
	* EMAIL DE LA EMPRESA
	*/
	private String myCgpre_email;
	/**
	* CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	*/
	private String myCgpre_cedula;
	/**
	* ADJUNTO REFERENTE A LA EMPRESA
	*/
	private byte[] myCgpre_adjunto;
	/**
	* TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	*/
	private String myCgpre_tipo_adjunto;
	/**
	* NOMBRE DEL ARCHIVO ADJUNTO
	*/
	private String myCgpre_nombre_adjunto;
	/**
	* NOMBRE DEL ARCHIVO ADJUNTO
	*/
	private String myCgpre_cisla_codigo;
	/**
	* NOMBRE DEL ARCHIVO ADJUNTO
	*/
	private String myCgpre_cctn_codigo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgpre_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgpre_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgpre_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_preregistro_empresa
	*/
	public Cgg_gem_preregistro_empresa(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_preregistro_empresa
	* @param inCgpre_codigo IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	* @param inCgpre_razon_social DESCRIPCION SOBRE LA RAZON SOCIAL
	* @param inCgpre_ruc RUC ESPECIFICO DE LA EMPRESA
	* @param inCgpre_representante REPRESENTANTE DE LA EMPRESA
	* @param inCgpre_fecha_creacion FECHA DE CREACION DE LA EMPRESA
	* @param inCgpre_actividad ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	* @param inCgpre_direccion DIRECCION DE LA EMPRESA
	* @param inCgpre_sector SECTOR DE LA EMPRESA
	* @param inCgpre_tipo TIPO DE EMPRESA
	* @param inCgpre_numero_empleado NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	* @param inCgpre_telefono CONTACTO TELEFONICO DE LA EMPRESA
	* @param inCgpre_email EMAIL DE LA EMPRESA
	* @param inCgpre_cedula CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	* @param inCgpre_adjunto ADJUNTO REFERENTE A LA EMPRESA
	* @param inCgpre_tipo_adjunto TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	* @param inCgpre_nombre_adjunto NOMBRE DEL ARCHIVO ADJUNTO
	 * @param inCgpre_cctn_codigo 
	 * @param inCgpre_cisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA 
	* @param inCgpre_estado ESTADO DEL REGISTRO
	* @param inCgpre_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgpre_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_preregistro_empresa(
		String inCgpre_codigo,
		String inCgpre_razon_social,
		String inCgpre_ruc,
		String inCgpre_representante,
		java.util.Date inCgpre_fecha_creacion,
		String inCgpre_actividad,
		String inCgpre_direccion,
		String inCgpre_sector,
		String inCgpre_tipo,
		int inCgpre_numero_empleado,
		String inCgpre_telefono,
		String inCgpre_email,
		String inCgpre_cedula,
		byte[] inCgpre_adjunto,
		String inCgpre_tipo_adjunto,
		String inCgpre_nombre_adjunto,
		String inCgpre_cctn_codigo,
		String inCgpre_cisla_codigo,
		boolean inCgpre_estado,
		String inCgpre_usuario_insert,
		String inCgpre_usuario_update
	){
		this.setCGPRE_CODIGO(inCgpre_codigo);
		this.setCGPRE_RAZON_SOCIAL(inCgpre_razon_social);
		this.setCGPRE_RUC(inCgpre_ruc);
		this.setCGPRE_REPRESENTANTE(inCgpre_representante);
		this.setCGPRE_FECHA_CREACION(inCgpre_fecha_creacion);
		this.setCGPRE_ACTIVIDAD(inCgpre_actividad);
		this.setCGPRE_DIRECCION(inCgpre_direccion);
		this.setCGPRE_SECTOR(inCgpre_sector);
		this.setCGPRE_TIPO(inCgpre_tipo);
		this.setCGPRE_NUMERO_EMPLEADO(inCgpre_numero_empleado);
		this.setCGPRE_TELEFONO(inCgpre_telefono);
		this.setCGPRE_EMAIL(inCgpre_email);
		this.setCGPRE_CEDULA(inCgpre_cedula);
		this.setCGPRE_ADJUNTO(inCgpre_adjunto);
		this.setCGPRE_TIPO_ADJUNTO(inCgpre_tipo_adjunto);
		this.setCGPRE_NOMBRE_ADJUNTO(inCgpre_nombre_adjunto);
		this.setCGPRE_CCTN_CODIGO(inCgpre_cctn_codigo);
		this.setCGPRE_CISLA_CODIGO(inCgpre_cisla_codigo);
		this.setCGPRE_ESTADO(inCgpre_estado);
		this.setCGPRE_USUARIO_INSERT(inCgpre_usuario_insert);
		this.setCGPRE_USUARIO_UPDATE(inCgpre_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	* @param inCgpre_codigo IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	*/
	public void setCGPRE_CODIGO(String inCgpre_codigo){
		this.myCgpre_codigo = inCgpre_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	* @return String IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	*/
	public String getCGPRE_CODIGO(){
		return this.myCgpre_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION SOBRE LA RAZON SOCIAL
	* @param inCgpre_razon_social DESCRIPCION SOBRE LA RAZON SOCIAL
	*/
	public void setCGPRE_RAZON_SOCIAL(String inCgpre_razon_social){
		this.myCgpre_razon_social = inCgpre_razon_social;
	}
	/**
	* OBTIENE DESCRIPCION SOBRE LA RAZON SOCIAL
	* @return String DESCRIPCION SOBRE LA RAZON SOCIAL
	*/
	public String getCGPRE_RAZON_SOCIAL(){
		return this.myCgpre_razon_social;
	}

	/**
	* ESTABLECE RUC ESPECIFICO DE LA EMPRESA
	* @param inCgpre_ruc RUC ESPECIFICO DE LA EMPRESA
	*/
	public void setCGPRE_RUC(String inCgpre_ruc){
		this.myCgpre_ruc = inCgpre_ruc;
	}
	/**
	* OBTIENE RUC ESPECIFICO DE LA EMPRESA
	* @return String RUC ESPECIFICO DE LA EMPRESA
	*/
	public String getCGPRE_RUC(){
		return this.myCgpre_ruc;
	}

	/**
	* ESTABLECE REPRESENTANTE DE LA EMPRESA
	* @param inCgpre_representante REPRESENTANTE DE LA EMPRESA
	*/
	public void setCGPRE_REPRESENTANTE(String inCgpre_representante){
		this.myCgpre_representante = inCgpre_representante;
	}
	/**
	* OBTIENE REPRESENTANTE DE LA EMPRESA
	* @return String REPRESENTANTE DE LA EMPRESA
	*/
	public String getCGPRE_REPRESENTANTE(){
		return this.myCgpre_representante;
	}

	/**
	* ESTABLECE FECHA DE CREACION DE LA EMPRESA
	* @param inCgpre_fecha_creacion FECHA DE CREACION DE LA EMPRESA
	*/
	public void setCGPRE_FECHA_CREACION(java.util.Date inCgpre_fecha_creacion){
		this.myCgpre_fecha_creacion = inCgpre_fecha_creacion;
	}
	/**
	* OBTIENE FECHA DE CREACION DE LA EMPRESA
	* @return java.util.Date FECHA DE CREACION DE LA EMPRESA
	*/
	public java.util.Date getCGPRE_FECHA_CREACION(){
		return this.myCgpre_fecha_creacion;
	}

	/**
	* ESTABLECE ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	* @param inCgpre_actividad ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	*/
	public void setCGPRE_ACTIVIDAD(String inCgpre_actividad){
		this.myCgpre_actividad = inCgpre_actividad;
	}
	/**
	* OBTIENE ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	* @return String ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	*/
	public String getCGPRE_ACTIVIDAD(){
		return this.myCgpre_actividad;
	}

	/**
	* ESTABLECE DIRECCION DE LA EMPRESA
	* @param inCgpre_direccion DIRECCION DE LA EMPRESA
	*/
	public void setCGPRE_DIRECCION(String inCgpre_direccion){
		this.myCgpre_direccion = inCgpre_direccion;
	}
	/**
	* OBTIENE DIRECCION DE LA EMPRESA
	* @return String DIRECCION DE LA EMPRESA
	*/
	public String getCGPRE_DIRECCION(){
		return this.myCgpre_direccion;
	}

	/**
	* ESTABLECE SECTOR DE LA EMPRESA
	* @param inCgpre_sector SECTOR DE LA EMPRESA
	*/
	public void setCGPRE_SECTOR(String inCgpre_sector){
		this.myCgpre_sector = inCgpre_sector;
	}
	/**
	* OBTIENE SECTOR DE LA EMPRESA
	* @return String SECTOR DE LA EMPRESA
	*/
	public String getCGPRE_SECTOR(){
		return this.myCgpre_sector;
	}

	/**
	* ESTABLECE TIPO DE EMPRESA
	* @param inCgpre_tipo TIPO DE EMPRESA
	*/
	public void setCGPRE_TIPO(String inCgpre_tipo){
		this.myCgpre_tipo = inCgpre_tipo;
	}
	/**
	* OBTIENE TIPO DE EMPRESA
	* @return String TIPO DE EMPRESA
	*/
	public String getCGPRE_TIPO(){
		return this.myCgpre_tipo;
	}

	/**
	* ESTABLECE NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	* @param inCgpre_numero_empleado NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	*/
	public void setCGPRE_NUMERO_EMPLEADO(int inCgpre_numero_empleado){
		this.myCgpre_numero_empleado = inCgpre_numero_empleado;
	}
	/**
	* OBTIENE NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	* @return int NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	*/
	public int getCGPRE_NUMERO_EMPLEADO(){
		return this.myCgpre_numero_empleado;
	}

	/**
	* ESTABLECE CONTACTO TELEFONICO DE LA EMPRESA
	* @param inCgpre_telefono CONTACTO TELEFONICO DE LA EMPRESA
	*/
	public void setCGPRE_TELEFONO(String inCgpre_telefono){
		this.myCgpre_telefono = inCgpre_telefono;
	}
	/**
	* OBTIENE CONTACTO TELEFONICO DE LA EMPRESA
	* @return String CONTACTO TELEFONICO DE LA EMPRESA
	*/
	public String getCGPRE_TELEFONO(){
		return this.myCgpre_telefono;
	}

	/**
	* ESTABLECE EMAIL DE LA EMPRESA
	* @param inCgpre_email EMAIL DE LA EMPRESA
	*/
	public void setCGPRE_EMAIL(String inCgpre_email){
		this.myCgpre_email = inCgpre_email;
	}
	/**
	* OBTIENE EMAIL DE LA EMPRESA
	* @return String EMAIL DE LA EMPRESA
	*/
	public String getCGPRE_EMAIL(){
		return this.myCgpre_email;
	}

	/**
	* ESTABLECE CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	* @param inCgpre_cedula CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	*/
	public void setCGPRE_CEDULA(String inCgpre_cedula){
		this.myCgpre_cedula = inCgpre_cedula;
	}
	/**
	* OBTIENE CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	* @return String CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	*/
	public String getCGPRE_CEDULA(){
		return this.myCgpre_cedula;
	}

	/**
	* ESTABLECE ADJUNTO REFERENTE A LA EMPRESA
	* @param inCgpre_adjunto ADJUNTO REFERENTE A LA EMPRESA
	*/
	public void setCGPRE_ADJUNTO(byte[] inCgpre_adjunto){
		this.myCgpre_adjunto = inCgpre_adjunto;
	}
	/**
	* OBTIENE ADJUNTO REFERENTE A LA EMPRESA
	* @return byte[] ADJUNTO REFERENTE A LA EMPRESA
	*/
	public byte[] getCGPRE_ADJUNTO(){
		return this.myCgpre_adjunto;
	}

	/**
	* ESTABLECE TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	* @param inCgpre_tipo_adjunto TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	*/
	public void setCGPRE_TIPO_ADJUNTO(String inCgpre_tipo_adjunto){
		this.myCgpre_tipo_adjunto = inCgpre_tipo_adjunto;
	}
	/**
	* OBTIENE TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	* @return String TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	*/
	public String getCGPRE_TIPO_ADJUNTO(){
		return this.myCgpre_tipo_adjunto;
	}

	/**
	* ESTABLECE NOMBRE DEL ARCHIVO ADJUNTO
	* @param inCgpre_nombre_adjunto NOMBRE DEL ARCHIVO ADJUNTO
	*/
	public void setCGPRE_NOMBRE_ADJUNTO(String inCgpre_nombre_adjunto){
		this.myCgpre_nombre_adjunto = inCgpre_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL ARCHIVO ADJUNTO
	* @return String NOMBRE DEL ARCHIVO ADJUNTO
	*/
	public String getCGPRE_NOMBRE_ADJUNTO(){
		return this.myCgpre_nombre_adjunto;
	}
	/**
	* ESTABLECE EL IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @param inCgpre_cisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA 
	*/
	public void setCGPRE_CISLA_CODIGO(String inCgpre_cisla_codigo){
		this.myCgpre_cisla_codigo = inCgpre_cisla_codigo;
	}
	/**
	* OBTIENE EL IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	* @return String NOMBRE DEL ARCHIVO ADJUNTO
	*/
	public String getCGPRE_CISLA_CODIGO(){
		return this.myCgpre_cisla_codigo;
	}
	/**
	* ESTABLECE EL IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCgpre_cctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public void setCGPRE_CCTN_CODIGO(String inCgpre_cctn_codigo){
		this.myCgpre_cctn_codigo = inCgpre_cctn_codigo;
	}
	/**
	* OBTIENE EL IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public String getCGPRE_CCTN_CODIGO(){
		return this.myCgpre_cctn_codigo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgpre_estado ESTADO DEL REGISTRO
	*/
	public void setCGPRE_ESTADO(boolean inCgpre_estado){
		this.myCgpre_estado = inCgpre_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGPRE_ESTADO(){
		return this.myCgpre_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgpre_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGPRE_USUARIO_INSERT(String inCgpre_usuario_insert){
		this.myCgpre_usuario_insert = inCgpre_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGPRE_USUARIO_INSERT(){
		return this.myCgpre_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgpre_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGPRE_USUARIO_UPDATE(String inCgpre_usuario_update){
		this.myCgpre_usuario_update = inCgpre_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGPRE_USUARIO_UPDATE(){
		return this.myCgpre_usuario_update;
	}

}
