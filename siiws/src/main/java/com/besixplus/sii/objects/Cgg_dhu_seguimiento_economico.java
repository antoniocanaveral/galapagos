package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_seguimiento_economico
* TABLA: SEGUIMIENTO ECONOMICO A BECARIO
* DESCRIPCION:ALMACENA INFORMACION DE LOS DESEMBOLSOS REALIZADOS POR PARTE DE LA INSTITUCION A LOS BECARIOS
* ABREVIATURA:CDSEC
*/
public class Cgg_dhu_seguimiento_economico implements Serializable{
	private static final long serialVersionUID = 1426701274;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
	*/
	private String myCdsec_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	*/
	private String myCdtcp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	*/
	private String myCdacd_codigo;
	/**
	* CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
	*/
	private String myCdsec_codigo_transferencia;
	/**
	* VALOR DE LA TRANSFERENCIA
	*/
	private java.math.BigDecimal myCdsec_valor;
	/**
	* FECHA DE REALIZACION  DEL DESEMBOLSO
	*/
	private java.util.Date myCdsec_fecha_transferencia;
	/**
	* CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
	*/
	private String myCdsec_codigo_transf_iece;
	/**
	* VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
	*/
	private java.math.BigDecimal myCdsec_valor_iece;
	/**
	* ESTADO DEL REGISTRO DE CIERRE DE DESEMBOLSO
	*/
	private boolean myCdsec_cierre_desembolso;
	/**
	* FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
	*/
	private java.util.Date myCdsec_fecha_transf_iece;
	/**
	* OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
	*/
	private String myCdsec_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdsec_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdsec_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdsec_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_economico
	*/
	public Cgg_dhu_seguimiento_economico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_seguimiento_economico
	* @param inCdsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
	* @param inCdtcp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	* @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	* @param inCdsec_codigo_transferencia CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
	* @param inCdsec_valor VALOR DE LA TRANSFERENCIA
	* @param inCdsec_fecha_transferencia FECHA DE REALIZACION  DEL DESEMBOLSO
	* @param inCdsec_codigo_transf_iece CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
	* @param inCdsec_valor_iece VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
	* @param inCdsec_fecha_transf_iece FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
	 * @param inCdsec_cierre_desembolso ESTADO QUE IDENTIFICA EL CIERRE DEL DESEMBOLSO
	* @param inCdsec_cierre_estado ESTADO DEL REGISTRO DE CIERRE DE DESEMBOLSO
	* @param inCdsec_observacion OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
	* @param inCdsec_estado ESTADO DEL REGISTRO
	* @param inCdsec_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdsec_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_seguimiento_economico(
		String inCdsec_codigo,
		String inCdtcp_codigo,
		String inCdacd_codigo,
		String inCdsec_codigo_transferencia,
		java.math.BigDecimal inCdsec_valor,
		java.util.Date inCdsec_fecha_transferencia,
		String inCdsec_codigo_transf_iece,
		java.math.BigDecimal inCdsec_valor_iece,
		java.util.Date inCdsec_fecha_transf_iece,
		boolean inCdsec_cierre_desembolso,
		String inCdsec_observacion,
		boolean inCdsec_estado,
		String inCdsec_usuario_insert,
		String inCdsec_usuario_update
	){
		this.setCDSEC_CODIGO(inCdsec_codigo);
		this.setCDTCP_CODIGO(inCdtcp_codigo);
		this.setCDACD_CODIGO(inCdacd_codigo);
		this.setCDSEC_CODIGO_TRANSFERENCIA(inCdsec_codigo_transferencia);
		this.setCDSEC_VALOR(inCdsec_valor);
		this.setCDSEC_FECHA_TRANSFERENCIA(inCdsec_fecha_transferencia);
		this.setCDSEC_CODIGO_TRANSF_IECE(inCdsec_codigo_transf_iece);
		this.setCDSEC_VALOR_IECE(inCdsec_valor_iece);
		this.setCDSEC_FECHA_TRANSF_IECE(inCdsec_fecha_transf_iece);
		this.setCDSEC_CIERRE_DESEMBOLSO(inCdsec_cierre_desembolso);
		this.setCDSEC_OBSERVACION(inCdsec_observacion);
		this.setCDSEC_ESTADO(inCdsec_estado);
		this.setCDSEC_USUARIO_INSERT(inCdsec_usuario_insert);
		this.setCDSEC_USUARIO_UPDATE(inCdsec_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
	* @param inCdsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
	*/
	public void setCDSEC_CODIGO(String inCdsec_codigo){
		this.myCdsec_codigo = inCdsec_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
	*/
	public String getCDSEC_CODIGO(){
		return this.myCdsec_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	* @param inCdtcp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	*/
	public void setCDTCP_CODIGO(String inCdtcp_codigo){
		this.myCdtcp_codigo = inCdtcp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	*/
	public String getCDTCP_CODIGO(){
		return this.myCdtcp_codigo;
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
	* ESTABLECE CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
	* @param inCdsec_codigo_transferencia CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
	*/
	public void setCDSEC_CODIGO_TRANSFERENCIA(String inCdsec_codigo_transferencia){
		this.myCdsec_codigo_transferencia = inCdsec_codigo_transferencia;
	}
	/**
	* OBTIENE CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
	* @return String CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
	*/
	public String getCDSEC_CODIGO_TRANSFERENCIA(){
		return this.myCdsec_codigo_transferencia;
	}

	/**
	* ESTABLECE VALOR DE LA TRANSFERENCIA
	* @param inCdsec_valor VALOR DE LA TRANSFERENCIA
	*/
	public void setCDSEC_VALOR(java.math.BigDecimal inCdsec_valor){
		this.myCdsec_valor = inCdsec_valor;
	}
	/**
	* OBTIENE VALOR DE LA TRANSFERENCIA
	* @return java.math.BigDecimal VALOR DE LA TRANSFERENCIA
	*/
	public java.math.BigDecimal getCDSEC_VALOR(){
		return this.myCdsec_valor;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION  DEL DESEMBOLSO
	* @param inCdsec_fecha_transferencia FECHA DE REALIZACION  DEL DESEMBOLSO
	*/
	public void setCDSEC_FECHA_TRANSFERENCIA(java.util.Date inCdsec_fecha_transferencia){
		this.myCdsec_fecha_transferencia = inCdsec_fecha_transferencia;
	}
	/**
	* OBTIENE FECHA DE REALIZACION  DEL DESEMBOLSO
	* @return java.util.Date FECHA DE REALIZACION  DEL DESEMBOLSO
	*/
	public java.util.Date getCDSEC_FECHA_TRANSFERENCIA(){
		return this.myCdsec_fecha_transferencia;
	}

	/**
	* ESTABLECE CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
	* @param inCdsec_codigo_transf_iece CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
	*/
	public void setCDSEC_CODIGO_TRANSF_IECE(String inCdsec_codigo_transf_iece){
		this.myCdsec_codigo_transf_iece = inCdsec_codigo_transf_iece;
	}
	/**
	* OBTIENE CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
	* @return String CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
	*/
	public String getCDSEC_CODIGO_TRANSF_IECE(){
		return this.myCdsec_codigo_transf_iece;
	}

	/**
	* ESTABLECE VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
	* @param inCdsec_valor_iece VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
	*/
	public void setCDSEC_VALOR_IECE(java.math.BigDecimal inCdsec_valor_iece){
		this.myCdsec_valor_iece = inCdsec_valor_iece;
	}
	/**
	* OBTIENE VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
	* @return java.math.BigDecimal VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
	*/
	public java.math.BigDecimal getCDSEC_VALOR_IECE(){
		return this.myCdsec_valor_iece;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
	* @param inCdsec_fecha_transf_iece FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
	*/
	public void setCDSEC_FECHA_TRANSF_IECE(java.util.Date inCdsec_fecha_transf_iece){
		this.myCdsec_fecha_transf_iece = inCdsec_fecha_transf_iece;
	}
	/**
	* OBTIENE FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
	* @return java.util.Date FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
	*/
	public java.util.Date getCDSEC_FECHA_TRANSF_IECE(){
		return this.myCdsec_fecha_transf_iece;
	}
	/**
	* ESTABLECE ESTADO DEL REGISTRO DE CIERRE DE DESEMBOLSO 
	* @param inCdsec_cierre_desembolso ESTADO DEL REGISTRO DE CIERRE DE DESEMBOLSO
	*/
	public void setCDSEC_CIERRE_DESEMBOLSO(boolean inCdsec_cierre_desembolso){
		this.myCdsec_cierre_desembolso = inCdsec_cierre_desembolso;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE CIERRE DE DESEMBOLSO
	* @return boolean ESTADO DEL REGISTRO DE CIERRE DE DESEMBOLSO
	*/
	public boolean getCDSEC_CIERRE_DESEMBOLSO(){
		return this.myCdsec_cierre_desembolso;
	}

	/**
	* ESTABLECE OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
	* @param inCdsec_observacion OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
	*/
	public void setCDSEC_OBSERVACION(String inCdsec_observacion){
		this.myCdsec_observacion = inCdsec_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
	* @return String OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
	*/
	public String getCDSEC_OBSERVACION(){
		return this.myCdsec_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdsec_estado ESTADO DEL REGISTRO
	*/
	public void setCDSEC_ESTADO(boolean inCdsec_estado){
		this.myCdsec_estado = inCdsec_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDSEC_ESTADO(){
		return this.myCdsec_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdsec_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDSEC_USUARIO_INSERT(String inCdsec_usuario_insert){
		this.myCdsec_usuario_insert = inCdsec_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDSEC_USUARIO_INSERT(){
		return this.myCdsec_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdsec_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDSEC_USUARIO_UPDATE(String inCdsec_usuario_update){
		this.myCdsec_usuario_update = inCdsec_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDSEC_USUARIO_UPDATE(){
		return this.myCdsec_usuario_update;
	}

}
