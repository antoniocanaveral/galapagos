package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_informacion_representan
* TABLA: INFORMACION DE REPRESENTANTE
* DESCRIPCION:ALMACENA INFORMACION DE LOS DATOS DE LOS PADRES DE FAMILIA, REPRESENTANTE LEGALES, GARANTES Y APODERADOS
* ABREVIATURA:CDINR
*/
public class Cgg_dhu_informacion_representan implements Serializable{
	private static final long serialVersionUID = 1637983042;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INFORMACION DE REPRESENTANTE
	*/
	private String myCdinr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	private String myCdbec_codigo;
	/**
	* DESCRIPCION DEL REPRESENTANTE
	*/
	private String myCdinr_descripcion;
	/**
	* IDENTIFICA EL TIPO DE REPRESENTANTE
0 - PADRE
1 - MADRE
2 - REPRESENTANTE LEGAL
3 - GARANTE
4 - APODERADO

	*/
	private int myCdinr_tipo_representante;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdinr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdinr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdinr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_informacion_representan
	*/
	public Cgg_dhu_informacion_representan(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_informacion_representan
	* @param inCdinr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORMACION DE REPRESENTANTE
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdinr_descripcion DESCRIPCION DEL REPRESENTANTE
	* @param inCdinr_tipo_representante IDENTIFICA EL TIPO DE REPRESENTANTE
0 - PADRE
1 - MADRE
2 - REPRESENTANTE LEGAL
3 - GARANTE
4 - APODERADO

	* @param inCdinr_estado ESTADO DEL REGISTRO
	* @param inCdinr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdinr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_informacion_representan(
		String inCdinr_codigo,
		String inCrper_codigo,
		String inCdbec_codigo,
		String inCdinr_descripcion,
		int inCdinr_tipo_representante,
		boolean inCdinr_estado,
		String inCdinr_usuario_insert,
		String inCdinr_usuario_update
	){
		this.setCDINR_CODIGO(inCdinr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCDBEC_CODIGO(inCdbec_codigo);
		this.setCDINR_DESCRIPCION(inCdinr_descripcion);
		this.setCDINR_TIPO_REPRESENTANTE(inCdinr_tipo_representante);
		this.setCDINR_ESTADO(inCdinr_estado);
		this.setCDINR_USUARIO_INSERT(inCdinr_usuario_insert);
		this.setCDINR_USUARIO_UPDATE(inCdinr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INFORMACION DE REPRESENTANTE
	* @param inCdinr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORMACION DE REPRESENTANTE
	*/
	public void setCDINR_CODIGO(String inCdinr_codigo){
		this.myCdinr_codigo = inCdinr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INFORMACION DE REPRESENTANTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INFORMACION DE REPRESENTANTE
	*/
	public String getCDINR_CODIGO(){
		return this.myCdinr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	public void setCDBEC_CODIGO(String inCdbec_codigo){
		this.myCdbec_codigo = inCdbec_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	public String getCDBEC_CODIGO(){
		return this.myCdbec_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL REPRESENTANTE
	* @param inCdinr_descripcion DESCRIPCION DEL REPRESENTANTE
	*/
	public void setCDINR_DESCRIPCION(String inCdinr_descripcion){
		this.myCdinr_descripcion = inCdinr_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL REPRESENTANTE
	* @return String DESCRIPCION DEL REPRESENTANTE
	*/
	public String getCDINR_DESCRIPCION(){
		return this.myCdinr_descripcion;
	}

	/**
	* ESTABLECE IDENTIFICA EL TIPO DE REPRESENTANTE
0 - PADRE
1 - MADRE
2 - REPRESENTANTE LEGAL
3 - GARANTE
4 - APODERADO

	* @param inCdinr_tipo_representante IDENTIFICA EL TIPO DE REPRESENTANTE
0 - PADRE
1 - MADRE
2 - REPRESENTANTE LEGAL
3 - GARANTE
4 - APODERADO

	*/
	public void setCDINR_TIPO_REPRESENTANTE(int inCdinr_tipo_representante){
		this.myCdinr_tipo_representante = inCdinr_tipo_representante;
	}
	/**
	* OBTIENE IDENTIFICA EL TIPO DE REPRESENTANTE
0 - PADRE
1 - MADRE
2 - REPRESENTANTE LEGAL
3 - GARANTE
4 - APODERADO

	* @return int IDENTIFICA EL TIPO DE REPRESENTANTE
0 - PADRE
1 - MADRE
2 - REPRESENTANTE LEGAL
3 - GARANTE
4 - APODERADO

	*/
	public int getCDINR_TIPO_REPRESENTANTE(){
		return this.myCdinr_tipo_representante;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdinr_estado ESTADO DEL REGISTRO
	*/
	public void setCDINR_ESTADO(boolean inCdinr_estado){
		this.myCdinr_estado = inCdinr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDINR_ESTADO(){
		return this.myCdinr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdinr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDINR_USUARIO_INSERT(String inCdinr_usuario_insert){
		this.myCdinr_usuario_insert = inCdinr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDINR_USUARIO_INSERT(){
		return this.myCdinr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdinr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDINR_USUARIO_UPDATE(String inCdinr_usuario_update){
		this.myCdinr_usuario_update = inCdinr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDINR_USUARIO_UPDATE(){
		return this.myCdinr_usuario_update;
	}

}
