package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_experiencia_laboral
* TABLA: EXPERIENCIA LABORAL
* DESCRIPCION:ALMACENA INFORMACION DEL HISTORIAL LABORAL DE LA PERSONA.
* ABREVIATURA:CGEXL
*/
public class Cgg_gem_experiencia_laboral implements Serializable{
	private static final long serialVersionUID = 527306244;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgexl_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	private java.util.Date myCgexl_fecha_inicio;
	/**
	* FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	private java.util.Date myCgexl_fecha_fin;
	/**
	* EMPRESA DONDE LABORO
	*/
	private String myCgexl_razon_social;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgexl_ciudad;
	/**
	* NOMBRE DEL CARGO
	*/
	private String myCgexl_cargo;
	/**
	* DESCRIPCION DEL CARGO DESEMPENIADO
	*/
	private String myCgexl_descripcion;
	/**
	* CANTIDAD DE PERSONAS BAJO SU MANDO
	*/
	private int myCgexl_personas_cargo;
	/**
	* NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	private String myCgexl_contacto;
	/**
	* NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	private String myCgexl_telefono;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCgexl_observaciones;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgexl_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgexl_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgexl_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_experiencia_laboral
	*/
	public Cgg_gem_experiencia_laboral(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_experiencia_laboral
	* @param inCgexl_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCgexl_fecha_inicio FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	* @param inCgexl_fecha_fin FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	* @param inCgexl_razon_social EMPRESA DONDE LABORO
	* @param inCgexl_ciudad NO ESPECIFICADO
	* @param inCgexl_cargo NOMBRE DEL CARGO
	* @param inCgexl_descripcion DESCRIPCION DEL CARGO DESEMPENIADO
	* @param inCgexl_personas_cargo CANTIDAD DE PERSONAS BAJO SU MANDO
	* @param inCgexl_contacto NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	* @param inCgexl_telefono NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	* @param inCgexl_observaciones INFORMACION ADICIONAL
	* @param inCgexl_estado ESTADO DEL REGISTRO
	* @param inCgexl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgexl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_experiencia_laboral(
		String inCgexl_codigo,
		String inCrper_codigo,
		java.util.Date inCgexl_fecha_inicio,
		java.util.Date inCgexl_fecha_fin,
		String inCgexl_razon_social,
		String inCgexl_ciudad,
		String inCgexl_cargo,
		String inCgexl_descripcion,
		int inCgexl_personas_cargo,
		String inCgexl_contacto,
		String inCgexl_telefono,
		String inCgexl_observaciones,
		boolean inCgexl_estado,
		String inCgexl_usuario_insert,
		String inCgexl_usuario_update
	){
		this.setCGEXL_CODIGO(inCgexl_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGEXL_FECHA_INICIO(inCgexl_fecha_inicio);
		this.setCGEXL_FECHA_FIN(inCgexl_fecha_fin);
		this.setCGEXL_RAZON_SOCIAL(inCgexl_razon_social);
		this.setCGEXL_CIUDAD(inCgexl_ciudad);
		this.setCGEXL_CARGO(inCgexl_cargo);
		this.setCGEXL_DESCRIPCION(inCgexl_descripcion);
		this.setCGEXL_PERSONAS_CARGO(inCgexl_personas_cargo);
		this.setCGEXL_CONTACTO(inCgexl_contacto);
		this.setCGEXL_TELEFONO(inCgexl_telefono);
		this.setCGEXL_OBSERVACIONES(inCgexl_observaciones);
		this.setCGEXL_ESTADO(inCgexl_estado);
		this.setCGEXL_USUARIO_INSERT(inCgexl_usuario_insert);
		this.setCGEXL_USUARIO_UPDATE(inCgexl_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgexl_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGEXL_CODIGO(String inCgexl_codigo){
		this.myCgexl_codigo = inCgexl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGEXL_CODIGO(){
		return this.myCgexl_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	* @param inCgexl_fecha_inicio FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	public void setCGEXL_FECHA_INICIO(java.util.Date inCgexl_fecha_inicio){
		this.myCgexl_fecha_inicio = inCgexl_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	* @return java.util.Date FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	public java.util.Date getCGEXL_FECHA_INICIO(){
		return this.myCgexl_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	* @param inCgexl_fecha_fin FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	public void setCGEXL_FECHA_FIN(java.util.Date inCgexl_fecha_fin){
		this.myCgexl_fecha_fin = inCgexl_fecha_fin;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	* @return java.util.Date FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	public java.util.Date getCGEXL_FECHA_FIN(){
		return this.myCgexl_fecha_fin;
	}

	/**
	* ESTABLECE EMPRESA DONDE LABORO
	* @param inCgexl_razon_social EMPRESA DONDE LABORO
	*/
	public void setCGEXL_RAZON_SOCIAL(String inCgexl_razon_social){
		this.myCgexl_razon_social = inCgexl_razon_social;
	}
	/**
	* OBTIENE EMPRESA DONDE LABORO
	* @return String EMPRESA DONDE LABORO
	*/
	public String getCGEXL_RAZON_SOCIAL(){
		return this.myCgexl_razon_social;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgexl_ciudad NO ESPECIFICADO
	*/
	public void setCGEXL_CIUDAD(String inCgexl_ciudad){
		this.myCgexl_ciudad = inCgexl_ciudad;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGEXL_CIUDAD(){
		return this.myCgexl_ciudad;
	}

	/**
	* ESTABLECE NOMBRE DEL CARGO
	* @param inCgexl_cargo NOMBRE DEL CARGO
	*/
	public void setCGEXL_CARGO(String inCgexl_cargo){
		this.myCgexl_cargo = inCgexl_cargo;
	}
	/**
	* OBTIENE NOMBRE DEL CARGO
	* @return String NOMBRE DEL CARGO
	*/
	public String getCGEXL_CARGO(){
		return this.myCgexl_cargo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CARGO DESEMPENIADO
	* @param inCgexl_descripcion DESCRIPCION DEL CARGO DESEMPENIADO
	*/
	public void setCGEXL_DESCRIPCION(String inCgexl_descripcion){
		this.myCgexl_descripcion = inCgexl_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL CARGO DESEMPENIADO
	* @return String DESCRIPCION DEL CARGO DESEMPENIADO
	*/
	public String getCGEXL_DESCRIPCION(){
		return this.myCgexl_descripcion;
	}

	/**
	* ESTABLECE CANTIDAD DE PERSONAS BAJO SU MANDO
	* @param inCgexl_personas_cargo CANTIDAD DE PERSONAS BAJO SU MANDO
	*/
	public void setCGEXL_PERSONAS_CARGO(int inCgexl_personas_cargo){
		this.myCgexl_personas_cargo = inCgexl_personas_cargo;
	}
	/**
	* OBTIENE CANTIDAD DE PERSONAS BAJO SU MANDO
	* @return int CANTIDAD DE PERSONAS BAJO SU MANDO
	*/
	public int getCGEXL_PERSONAS_CARGO(){
		return this.myCgexl_personas_cargo;
	}

	/**
	* ESTABLECE NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	* @param inCgexl_contacto NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	public void setCGEXL_CONTACTO(String inCgexl_contacto){
		this.myCgexl_contacto = inCgexl_contacto;
	}
	/**
	* OBTIENE NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	* @return String NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	public String getCGEXL_CONTACTO(){
		return this.myCgexl_contacto;
	}

	/**
	* ESTABLECE NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	* @param inCgexl_telefono NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	public void setCGEXL_TELEFONO(String inCgexl_telefono){
		this.myCgexl_telefono = inCgexl_telefono;
	}
	/**
	* OBTIENE NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	* @return String NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	public String getCGEXL_TELEFONO(){
		return this.myCgexl_telefono;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCgexl_observaciones INFORMACION ADICIONAL
	*/
	public void setCGEXL_OBSERVACIONES(String inCgexl_observaciones){
		this.myCgexl_observaciones = inCgexl_observaciones;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCGEXL_OBSERVACIONES(){
		return this.myCgexl_observaciones;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgexl_estado ESTADO DEL REGISTRO
	*/
	public void setCGEXL_ESTADO(boolean inCgexl_estado){
		this.myCgexl_estado = inCgexl_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGEXL_ESTADO(){
		return this.myCgexl_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgexl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGEXL_USUARIO_INSERT(String inCgexl_usuario_insert){
		this.myCgexl_usuario_insert = inCgexl_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGEXL_USUARIO_INSERT(){
		return this.myCgexl_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgexl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGEXL_USUARIO_UPDATE(String inCgexl_usuario_update){
		this.myCgexl_usuario_update = inCgexl_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGEXL_USUARIO_UPDATE(){
		return this.myCgexl_usuario_update;
	}

}
