package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_ocupacion_laboral
* TABLA: OCUPACION LABORAL
* DESCRIPCION:ALMACENA INFORMACION DE LA OCUPACION LABORAL DE LAS PERSONAS
* ABREVIATURA:CROCL
*/
public class Cgg_res_ocupacion_laboral implements Serializable{
	private static final long serialVersionUID = 2029590341;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	*/
	private String myCrocl_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	*/
	private String myCrper_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	*/
	private String myCgg_crper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	private String myCgcrg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA 
	*/
	private String myCrpjr_codigo;
	/**
	* TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	*/
	private int myCrocl_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrocl_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrocl_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrocl_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_ocupacion_laboral
	*/
	public Cgg_res_ocupacion_laboral(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_ocupacion_laboral
	* @param inCrocl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA 
	* @param inCrocl_tipo TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	* @param inCrocl_estado ESTADO DEL REGISTRO
	* @param inCrocl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrocl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_ocupacion_laboral(
		String inCrocl_codigo,
		String inCrper_codigo,
		String inCgg_crper_codigo,
		String inCgcrg_codigo,
		String inCsctp_codigo,
		String inCrpjr_codigo,
		int inCrocl_tipo,
		boolean inCrocl_estado,
		String inCrocl_usuario_insert,
		String inCrocl_usuario_update
	){
		this.setCROCL_CODIGO(inCrocl_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		this.setCGCRG_CODIGO(inCgcrg_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCROCL_TIPO(inCrocl_tipo);
		this.setCROCL_ESTADO(inCrocl_estado);
		this.setCROCL_USUARIO_INSERT(inCrocl_usuario_insert);
		this.setCROCL_USUARIO_UPDATE(inCrocl_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	* @param inCrocl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	*/
	public void setCROCL_CODIGO(String inCrocl_codigo){
		this.myCrocl_codigo = inCrocl_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	*/
	public String getCROCL_CODIGO(){
		return this.myCrocl_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	*/
	public void setCGG_CRPER_CODIGO(String inCgg_crper_codigo){
		this.myCgg_crper_codigo = inCgg_crper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	*/
	public String getCGG_CRPER_CODIGO(){
		return this.myCgg_crper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public void setCGCRG_CODIGO(String inCgcrg_codigo){
		this.myCgcrg_codigo = inCgcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public String getCGCRG_CODIGO(){
		return this.myCgcrg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	public void setCSCTP_CODIGO(String inCsctp_codigo){
		this.myCsctp_codigo = inCsctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	public String getCSCTP_CODIGO(){
		return this.myCsctp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA 
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA 
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
	* ESTABLECE TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	* @param inCrocl_tipo TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	*/
	public void setCROCL_TIPO(int inCrocl_tipo){
		this.myCrocl_tipo = inCrocl_tipo;
	}
	/**
	* OBTIENE TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	* @return int TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	*/
	public int getCROCL_TIPO(){
		return this.myCrocl_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrocl_estado ESTADO DEL REGISTRO
	*/
	public void setCROCL_ESTADO(boolean inCrocl_estado){
		this.myCrocl_estado = inCrocl_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCROCL_ESTADO(){
		return this.myCrocl_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrocl_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCROCL_USUARIO_INSERT(String inCrocl_usuario_insert){
		this.myCrocl_usuario_insert = inCrocl_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCROCL_USUARIO_INSERT(){
		return this.myCrocl_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrocl_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCROCL_USUARIO_UPDATE(String inCrocl_usuario_update){
		this.myCrocl_usuario_update = inCrocl_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCROCL_USUARIO_UPDATE(){
		return this.myCrocl_usuario_update;
	}

}
