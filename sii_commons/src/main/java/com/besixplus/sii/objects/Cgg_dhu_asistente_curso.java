package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_asistente_curso
* TABLA: ASISTENTE CURSO
* DESCRIPCION:ALMACENA INFORMACION DE LAS PERSONAS QUE PARTICIPAN DE UN CURSO
* ABREVIATURA:CDASC
*/
public class Cgg_dhu_asistente_curso implements Serializable{
	private static final long serialVersionUID = 688745008;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	*/
	private String myCdasc_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	private String myCdcur_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	*/
	private String myCdasc_actividad_realizada;
	/**
	* NOTA FINAL DEL CURSO RECIBIDO
	*/
	private java.math.BigDecimal myCdasc_nota_final;
	/**
	* NUMERO DE CERTIFICADO
	*/
	private String myCdasc_numero_certificado;
	/**
	* CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	*/
	private java.util.Date myCdasc_fecha_emision_certificado;
	/**
	* ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
0 - PRE INSCRITO
1 - INSCRITO


	*/
	private int myCdasc_estado_inscripcion;
	/**
	* ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
0 - REPROBADO
1 - APROBADO
2 - RETIRADO
	*/
	private int myCdasc_aprobado;
	/**
	* ESTADO DEL REGISTRO 

	*/
	private boolean myCdasc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdasc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdasc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_asistente_curso
	*/
	public Cgg_dhu_asistente_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_asistente_curso
	* @param inCdasc_codigo IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCdasc_actividad_realizada ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	* @param inCdasc_nota_final NOTA FINAL DEL CURSO RECIBIDO
	* @param inCdasc_numero_certificado NUMERO DE CERTIFICADO
	* @param inCdasc_fecha_emision_certificado CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	* @param inCdasc_estado_inscripcion ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
0 - PRE INSCRITO
1 - INSCRITO


	* @param inCdasc_aprobado ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
0 - REPROBADO
1 - APROBADO
2 - RETIRADO
	* @param inCdasc_estado ESTADO DEL REGISTRO 

	* @param inCdasc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdasc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_asistente_curso(
		String inCdasc_codigo,
		String inCrper_codigo,
		String inCdcur_codigo,
		String inCsctp_codigo,
		String inCusu_codigo,
		String inCdasc_actividad_realizada,
		java.math.BigDecimal inCdasc_nota_final,
		String inCdasc_numero_certificado,
		java.util.Date inCdasc_fecha_emision_certificado,
		int inCdasc_estado_inscripcion,
		int inCdasc_aprobado,
		boolean inCdasc_estado,
		String inCdasc_usuario_insert,
		String inCdasc_usuario_update
	){
		this.setCDASC_CODIGO(inCdasc_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCDCUR_CODIGO(inCdcur_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCDASC_ACTIVIDAD_REALIZADA(inCdasc_actividad_realizada);
		this.setCDASC_NOTA_FINAL(inCdasc_nota_final);
		this.setCDASC_NUMERO_CERTIFICADO(inCdasc_numero_certificado);
		this.setCDASC_FECHA_EMISION_CERTIFICADO(inCdasc_fecha_emision_certificado);
		this.setCDASC_ESTADO_INSCRIPCION(inCdasc_estado_inscripcion);
		this.setCDASC_APROBADO(inCdasc_aprobado);
		this.setCDASC_ESTADO(inCdasc_estado);
		this.setCDASC_USUARIO_INSERT(inCdasc_usuario_insert);
		this.setCDASC_USUARIO_UPDATE(inCdasc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	* @param inCdasc_codigo IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	*/
	public void setCDASC_CODIGO(String inCdasc_codigo){
		this.myCdasc_codigo = inCdasc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	* @return String IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	*/
	public String getCDASC_CODIGO(){
		return this.myCdasc_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	public void setCDCUR_CODIGO(String inCdcur_codigo){
		this.myCdcur_codigo = inCdcur_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	public String getCDCUR_CODIGO(){
		return this.myCdcur_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	public void setCSCTP_CODIGO(String inCsctp_codigo){
		this.myCsctp_codigo = inCsctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	public String getCSCTP_CODIGO(){
		return this.myCsctp_codigo;
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
	* ESTABLECE ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	* @param inCdasc_actividad_realizada ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	*/
	public void setCDASC_ACTIVIDAD_REALIZADA(String inCdasc_actividad_realizada){
		this.myCdasc_actividad_realizada = inCdasc_actividad_realizada;
	}
	/**
	* OBTIENE ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	* @return String ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	*/
	public String getCDASC_ACTIVIDAD_REALIZADA(){
		return this.myCdasc_actividad_realizada;
	}

	/**
	* ESTABLECE NOTA FINAL DEL CURSO RECIBIDO
	* @param inCdasc_nota_final NOTA FINAL DEL CURSO RECIBIDO
	*/
	public void setCDASC_NOTA_FINAL(java.math.BigDecimal inCdasc_nota_final){
		this.myCdasc_nota_final = inCdasc_nota_final;
	}
	/**
	* OBTIENE NOTA FINAL DEL CURSO RECIBIDO
	* @return java.math.BigDecimal NOTA FINAL DEL CURSO RECIBIDO
	*/
	public java.math.BigDecimal getCDASC_NOTA_FINAL(){
		return this.myCdasc_nota_final;
	}

	/**
	* ESTABLECE NUMERO DE CERTIFICADO
	* @param inCdasc_numero_certificado NUMERO DE CERTIFICADO
	*/
	public void setCDASC_NUMERO_CERTIFICADO(String inCdasc_numero_certificado){
		this.myCdasc_numero_certificado = inCdasc_numero_certificado;
	}
	/**
	* OBTIENE NUMERO DE CERTIFICADO
	* @return String NUMERO DE CERTIFICADO
	*/
	public String getCDASC_NUMERO_CERTIFICADO(){
		return this.myCdasc_numero_certificado;
	}

	/**
	* ESTABLECE CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	* @param inCdasc_fecha_emision_certificado CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	*/
	public void setCDASC_FECHA_EMISION_CERTIFICADO(java.util.Date inCdasc_fecha_emision_certificado){
		this.myCdasc_fecha_emision_certificado = inCdasc_fecha_emision_certificado;
	}
	/**
	* OBTIENE CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	* @return java.util.Date CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	*/
	public java.util.Date getCDASC_FECHA_EMISION_CERTIFICADO(){
		return this.myCdasc_fecha_emision_certificado;
	}

	/**
	* ESTABLECE ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
0 - PRE INSCRITO
1 - INSCRITO


	* @param inCdasc_estado_inscripcion ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
0 - PRE INSCRITO
1 - INSCRITO


	*/
	public void setCDASC_ESTADO_INSCRIPCION(int inCdasc_estado_inscripcion){
		this.myCdasc_estado_inscripcion = inCdasc_estado_inscripcion;
	}
	/**
	* OBTIENE ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
0 - PRE INSCRITO
1 - INSCRITO


	* @return int ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
0 - PRE INSCRITO
1 - INSCRITO


	*/
	public int getCDASC_ESTADO_INSCRIPCION(){
		return this.myCdasc_estado_inscripcion;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
0 - REPROBADO
1 - APROBADO
2 - RETIRADO
	* @param inCdasc_aprobado ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
0 - REPROBADO
1 - APROBADO
2 - RETIRADO
	*/
	public void setCDASC_APROBADO(int inCdasc_aprobado){
		this.myCdasc_aprobado = inCdasc_aprobado;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
0 - REPROBADO
1 - APROBADO
2 - RETIRADO
	* @return int ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
0 - REPROBADO
1 - APROBADO
2 - RETIRADO
	*/
	public int getCDASC_APROBADO(){
		return this.myCdasc_aprobado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO 

	* @param inCdasc_estado ESTADO DEL REGISTRO 

	*/
	public void setCDASC_ESTADO(boolean inCdasc_estado){
		this.myCdasc_estado = inCdasc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO 

	* @return boolean ESTADO DEL REGISTRO 

	*/
	public boolean getCDASC_ESTADO(){
		return this.myCdasc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdasc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDASC_USUARIO_INSERT(String inCdasc_usuario_insert){
		this.myCdasc_usuario_insert = inCdasc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDASC_USUARIO_INSERT(){
		return this.myCdasc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdasc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDASC_USUARIO_UPDATE(String inCdasc_usuario_update){
		this.myCdasc_usuario_update = inCdasc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDASC_USUARIO_UPDATE(){
		return this.myCdasc_usuario_update;
	}

}
