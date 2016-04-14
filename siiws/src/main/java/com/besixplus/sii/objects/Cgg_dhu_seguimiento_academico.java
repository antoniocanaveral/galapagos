package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_seguimiento_academico
* TABLA: SEGUIMIENTO ACADEMICO
* DESCRIPCION:ALMACENA INFORMACION DEL SEGUIMIENTO REALIZADO A LOS BECARIOS
* ABREVIATURA:CDACD
*/
public class Cgg_dhu_seguimiento_academico implements Serializable{
	private static final long serialVersionUID = 596488097;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	private String myCdbec_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	private String myCdacd_codigo;
	/**
	* NUMERO DE CICLO ACADEMICO
	*/
	private int myCdacd_numero_ciclo;
	/**
	* FECHA DE INICIO DEL CICLO
	*/
	private java.util.Date myCdacd_fecha_inicio;
	/**
	* FECHA DE CULMINACION DEL CICLO
	*/
	private java.util.Date myCdacd_fecha_fin;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCdacd_observacion;
	/**
	* CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	*/
	private int myCdacd_estado_aprobacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdacd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdacd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdacd_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_academico
	*/
	public Cgg_dhu_seguimiento_academico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_academico
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @param inCdacd_numero_ciclo NUMERO DE CICLO ACADEMICO
	* @param inCdacd_fecha_inicio FECHA DE INICIO DEL CICLO
	* @param inCdacd_fecha_fin FECHA DE CULMINACION DEL CICLO
	* @param inCdacd_observacion INFORMACION ADICIONAL
	* @param inCdacd_estado_aprobacion CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	* @param inCdacd_estado ESTADO DEL REGISTRO
	* @param inCdacd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdacd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_seguimiento_academico(
		String inCdbec_codigo,
		String inCdacd_codigo,
		int inCdacd_numero_ciclo,
		java.util.Date inCdacd_fecha_inicio,
		java.util.Date inCdacd_fecha_fin,
		String inCdacd_observacion,
		int inCdacd_estado_aprobacion,
		boolean inCdacd_estado,
		String inCdacd_usuario_insert,
		String inCdacd_usuario_update
	){
		this.setCDBEC_CODIGO(inCdbec_codigo);
		this.setCDACD_CODIGO(inCdacd_codigo);
		this.setCDACD_NUMERO_CICLO(inCdacd_numero_ciclo);
		this.setCDACD_FECHA_INICIO(inCdacd_fecha_inicio);
		this.setCDACD_FECHA_FIN(inCdacd_fecha_fin);
		this.setCDACD_OBSERVACION(inCdacd_observacion);
		this.setCDACD_ESTADO_APROBACION(inCdacd_estado_aprobacion);
		this.setCDACD_ESTADO(inCdacd_estado);
		this.setCDACD_USUARIO_INSERT(inCdacd_usuario_insert);
		this.setCDACD_USUARIO_UPDATE(inCdacd_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	public void setCDACD_CODIGO(String inCdacd_codigo){
		this.myCdacd_codigo = inCdacd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	public String getCDACD_CODIGO(){
		return this.myCdacd_codigo;
	}

	/**
	* ESTABLECE NUMERO DE CICLO ACADEMICO
	* @param inCdacd_numero_ciclo NUMERO DE CICLO ACADEMICO
	*/
	public void setCDACD_NUMERO_CICLO(int inCdacd_numero_ciclo){
		this.myCdacd_numero_ciclo = inCdacd_numero_ciclo;
	}
	/**
	* OBTIENE NUMERO DE CICLO ACADEMICO
	* @return int NUMERO DE CICLO ACADEMICO
	*/
	public int getCDACD_NUMERO_CICLO(){
		return this.myCdacd_numero_ciclo;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL CICLO
	* @param inCdacd_fecha_inicio FECHA DE INICIO DEL CICLO
	*/
	public void setCDACD_FECHA_INICIO(java.util.Date inCdacd_fecha_inicio){
		this.myCdacd_fecha_inicio = inCdacd_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL CICLO
	* @return java.util.Date FECHA DE INICIO DEL CICLO
	*/
	public java.util.Date getCDACD_FECHA_INICIO(){
		return this.myCdacd_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE CULMINACION DEL CICLO
	* @param inCdacd_fecha_fin FECHA DE CULMINACION DEL CICLO
	*/
	public void setCDACD_FECHA_FIN(java.util.Date inCdacd_fecha_fin){
		this.myCdacd_fecha_fin = inCdacd_fecha_fin;
	}
	/**
	* OBTIENE FECHA DE CULMINACION DEL CICLO
	* @return java.util.Date FECHA DE CULMINACION DEL CICLO
	*/
	public java.util.Date getCDACD_FECHA_FIN(){
		return this.myCdacd_fecha_fin;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCdacd_observacion INFORMACION ADICIONAL
	*/
	public void setCDACD_OBSERVACION(String inCdacd_observacion){
		this.myCdacd_observacion = inCdacd_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCDACD_OBSERVACION(){
		return this.myCdacd_observacion;
	}

	/**
	* ESTABLECE CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	* @param inCdacd_estado_aprobacion CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	*/
	public void setCDACD_ESTADO_APROBACION(int inCdacd_estado_aprobacion){
		this.myCdacd_estado_aprobacion = inCdacd_estado_aprobacion;
	}
	/**
	* OBTIENE CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	* @return int CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	*/
	public int getCDACD_ESTADO_APROBACION(){
		return this.myCdacd_estado_aprobacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdacd_estado ESTADO DEL REGISTRO
	*/
	public void setCDACD_ESTADO(boolean inCdacd_estado){
		this.myCdacd_estado = inCdacd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDACD_ESTADO(){
		return this.myCdacd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdacd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDACD_USUARIO_INSERT(String inCdacd_usuario_insert){
		this.myCdacd_usuario_insert = inCdacd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDACD_USUARIO_INSERT(){
		return this.myCdacd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdacd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDACD_USUARIO_UPDATE(String inCdacd_usuario_update){
		this.myCdacd_usuario_update = inCdacd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDACD_USUARIO_UPDATE(){
		return this.myCdacd_usuario_update;
	}

}
