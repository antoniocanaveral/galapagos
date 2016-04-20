package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_denuncia
* TABLA: DENUNCIA
* DESCRIPCION:ALMACENA INFORMACION DE LAS DENUNCIAS
* ABREVIATURA:CRDEN
*/
public class Cgg_res_denuncia implements Serializable{
	private static final long serialVersionUID = 1495260935;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrden_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* ANIO DE LA DENUNCIA
	*/
	private String myCrden_anio;
	/**
	* NUMERO DE LA DENUNCIA
	*/
	private String myCrden_numero;
	/**
	* FECHA DE RECEPCION DE LA  DENUNCIA
	*/
	private java.util.Date myCrden_fecha_recepcion;
	/**
	* NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	*/
	private String myCrden_numero_doc_ident;
	/**
	* NOMBRES DEL DENUNCIANTE
	*/
	private String myCrden_nombres;
	/**
	* APELLIDOS DEL DENUNCIANTE
	*/
	private String myCrden_apellidos;
	/**
	* MOTIVO DE LA DENUNCIA
	*/
	private String myCrden_descripcion;
	/**
	* PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	*/
	private String myCrden_contacto;
	/**
	* TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	*/
	private int myCrden_tipo;
	/**
	* ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	*/
	private boolean myCrden_denuncia;
	/**
	* CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	*/
	private String myCrden_seguimiento;
	/**
	* ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	*/
	private int myCrden_estado_denuncia;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrden_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrden_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrden_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_denuncia
	*/
	public Cgg_res_denuncia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_denuncia
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrden_anio ANIO DE LA DENUNCIA
	* @param inCrden_numero NUMERO DE LA DENUNCIA
	* @param inCrden_fecha_recepcion FECHA DE RECEPCION DE LA  DENUNCIA
	* @param inCrden_numero_doc_ident NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	* @param inCrden_nombres NOMBRES DEL DENUNCIANTE
	* @param inCrden_apellidos APELLIDOS DEL DENUNCIANTE
	* @param inCrden_descripcion MOTIVO DE LA DENUNCIA
	* @param inCrden_contacto PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	* @param inCrden_tipo TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	* @param inCrden_denuncia ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	* @param inCrden_seguimiento CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	* @param inCrden_estado_denuncia ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	* @param inCrden_estado ESTADO DEL REGISTRO
	* @param inCrden_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrden_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_denuncia(
		String inCrden_codigo,
		String inCusu_codigo,
		String inCrden_anio,
		String inCrden_numero,
		java.util.Date inCrden_fecha_recepcion,
		String inCrden_numero_doc_ident,
		String inCrden_nombres,
		String inCrden_apellidos,
		String inCrden_descripcion,
		String inCrden_contacto,
		int inCrden_tipo,
		boolean inCrden_denuncia,
		String inCrden_seguimiento,
		int inCrden_estado_denuncia,
		boolean inCrden_estado,
		String inCrden_usuario_insert,
		String inCrden_usuario_update
	){
		this.setCRDEN_CODIGO(inCrden_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRDEN_ANIO(inCrden_anio);
		this.setCRDEN_NUMERO(inCrden_numero);
		this.setCRDEN_FECHA_RECEPCION(inCrden_fecha_recepcion);
		this.setCRDEN_NUMERO_DOC_IDENT(inCrden_numero_doc_ident);
		this.setCRDEN_NOMBRES(inCrden_nombres);
		this.setCRDEN_APELLIDOS(inCrden_apellidos);
		this.setCRDEN_DESCRIPCION(inCrden_descripcion);
		this.setCRDEN_CONTACTO(inCrden_contacto);
		this.setCRDEN_TIPO(inCrden_tipo);
		this.setCRDEN_DENUNCIA(inCrden_denuncia);
		this.setCRDEN_SEGUIMIENTO(inCrden_seguimiento);
		this.setCRDEN_ESTADO_DENUNCIA(inCrden_estado_denuncia);
		this.setCRDEN_ESTADO(inCrden_estado);
		this.setCRDEN_USUARIO_INSERT(inCrden_usuario_insert);
		this.setCRDEN_USUARIO_UPDATE(inCrden_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRDEN_CODIGO(String inCrden_codigo){
		this.myCrden_codigo = inCrden_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRDEN_CODIGO(){
		return this.myCrden_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE ANIO DE LA DENUNCIA
	* @param inCrden_anio ANIO DE LA DENUNCIA
	*/
	public void setCRDEN_ANIO(String inCrden_anio){
		this.myCrden_anio = inCrden_anio;
	}
	/**
	* OBTIENE ANIO DE LA DENUNCIA
	* @return String ANIO DE LA DENUNCIA
	*/
	public String getCRDEN_ANIO(){
		return this.myCrden_anio;
	}

	/**
	* ESTABLECE NUMERO DE LA DENUNCIA
	* @param inCrden_numero NUMERO DE LA DENUNCIA
	*/
	public void setCRDEN_NUMERO(String inCrden_numero){
		this.myCrden_numero = inCrden_numero;
	}
	/**
	* OBTIENE NUMERO DE LA DENUNCIA
	* @return String NUMERO DE LA DENUNCIA
	*/
	public String getCRDEN_NUMERO(){
		return this.myCrden_numero;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DE LA  DENUNCIA
	* @param inCrden_fecha_recepcion FECHA DE RECEPCION DE LA  DENUNCIA
	*/
	public void setCRDEN_FECHA_RECEPCION(java.util.Date inCrden_fecha_recepcion){
		this.myCrden_fecha_recepcion = inCrden_fecha_recepcion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DE LA  DENUNCIA
	* @return java.util.Date FECHA DE RECEPCION DE LA  DENUNCIA
	*/
	public java.util.Date getCRDEN_FECHA_RECEPCION(){
		return this.myCrden_fecha_recepcion;
	}

	/**
	* ESTABLECE NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	* @param inCrden_numero_doc_ident NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	*/
	public void setCRDEN_NUMERO_DOC_IDENT(String inCrden_numero_doc_ident){
		this.myCrden_numero_doc_ident = inCrden_numero_doc_ident;
	}
	/**
	* OBTIENE NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	* @return String NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	*/
	public String getCRDEN_NUMERO_DOC_IDENT(){
		return this.myCrden_numero_doc_ident;
	}

	/**
	* ESTABLECE NOMBRES DEL DENUNCIANTE
	* @param inCrden_nombres NOMBRES DEL DENUNCIANTE
	*/
	public void setCRDEN_NOMBRES(String inCrden_nombres){
		this.myCrden_nombres = inCrden_nombres;
	}
	/**
	* OBTIENE NOMBRES DEL DENUNCIANTE
	* @return String NOMBRES DEL DENUNCIANTE
	*/
	public String getCRDEN_NOMBRES(){
		return this.myCrden_nombres;
	}

	/**
	* ESTABLECE APELLIDOS DEL DENUNCIANTE
	* @param inCrden_apellidos APELLIDOS DEL DENUNCIANTE
	*/
	public void setCRDEN_APELLIDOS(String inCrden_apellidos){
		this.myCrden_apellidos = inCrden_apellidos;
	}
	/**
	* OBTIENE APELLIDOS DEL DENUNCIANTE
	* @return String APELLIDOS DEL DENUNCIANTE
	*/
	public String getCRDEN_APELLIDOS(){
		return this.myCrden_apellidos;
	}

	/**
	* ESTABLECE MOTIVO DE LA DENUNCIA
	* @param inCrden_descripcion MOTIVO DE LA DENUNCIA
	*/
	public void setCRDEN_DESCRIPCION(String inCrden_descripcion){
		this.myCrden_descripcion = inCrden_descripcion;
	}
	/**
	* OBTIENE MOTIVO DE LA DENUNCIA
	* @return String MOTIVO DE LA DENUNCIA
	*/
	public String getCRDEN_DESCRIPCION(){
		return this.myCrden_descripcion;
	}

	/**
	* ESTABLECE PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	* @param inCrden_contacto PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	*/
	public void setCRDEN_CONTACTO(String inCrden_contacto){
		this.myCrden_contacto = inCrden_contacto;
	}
	/**
	* OBTIENE PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	* @return String PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	*/
	public String getCRDEN_CONTACTO(){
		return this.myCrden_contacto;
	}

	/**
	* ESTABLECE TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	* @param inCrden_tipo TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	*/
	public void setCRDEN_TIPO(int inCrden_tipo){
		this.myCrden_tipo = inCrden_tipo;
	}
	/**
	* OBTIENE TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	* @return int TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	*/
	public int getCRDEN_TIPO(){
		return this.myCrden_tipo;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	* @param inCrden_denuncia ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	*/
	public void setCRDEN_DENUNCIA(boolean inCrden_denuncia){
		this.myCrden_denuncia = inCrden_denuncia;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	* @return boolean ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	*/
	public boolean getCRDEN_DENUNCIA(){
		return this.myCrden_denuncia;
	}

	/**
	* ESTABLECE CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	* @param inCrden_seguimiento CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	*/
	public void setCRDEN_SEGUIMIENTO(String inCrden_seguimiento){
		this.myCrden_seguimiento = inCrden_seguimiento;
	}
	/**
	* OBTIENE CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	* @return String CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	*/
	public String getCRDEN_SEGUIMIENTO(){
		return this.myCrden_seguimiento;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	* @param inCrden_estado_denuncia ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	*/
	public void setCRDEN_ESTADO_DENUNCIA(int inCrden_estado_denuncia){
		this.myCrden_estado_denuncia = inCrden_estado_denuncia;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	* @return int ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	*/
	public int getCRDEN_ESTADO_DENUNCIA(){
		return this.myCrden_estado_denuncia;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrden_estado ESTADO DEL REGISTRO
	*/
	public void setCRDEN_ESTADO(boolean inCrden_estado){
		this.myCrden_estado = inCrden_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRDEN_ESTADO(){
		return this.myCrden_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrden_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRDEN_USUARIO_INSERT(String inCrden_usuario_insert){
		this.myCrden_usuario_insert = inCrden_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRDEN_USUARIO_INSERT(){
		return this.myCrden_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrden_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRDEN_USUARIO_UPDATE(String inCrden_usuario_update){
		this.myCrden_usuario_update = inCrden_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRDEN_USUARIO_UPDATE(){
		return this.myCrden_usuario_update;
	}

}
