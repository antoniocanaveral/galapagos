package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_deposito_garantia
* TABLA: DEPOSITO GARANTIA
* DESCRIPCION: ALMACENA INFORMACION DE LOS DEPOSITOS POR GARANTIAS PARA RESIDENCIA
* ABREVIATURA: CRDPT 
*/
public class Cgg_res_deposito_garantia implements Serializable{
	private static final long serialVersionUID = 1147948577;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	*/
	private String myCrdpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA
	*/
	private String myCrcpj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE REALIZO EL DEPOSITO
	*/
	private String myCrpjr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO EL DEPOSITO
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
	*/
	private String myCgg_crpjr_codigo;
	/**
	* NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	*/
	private String myCrdpt_numero;
	/**
	* NUMERO DE DOCUMENTO DE DEPOSITO
	*/
	private String myCrdpt_numero_documento;
	/**
	* SI LA GARANTIA CADUCA
	*/
	private boolean myCrdpt_caduca;
	/**
	* TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	*/
	private int myCrdpt_tipo;
	/**
	* VALOR DEPOSITADO POR GARANTIA
	*/
	private java.math.BigDecimal myCrdpt_valor_deposito;
	/**
	* FECHA DE REALIZACION DE DEPOSITO
	*/
	private java.util.Date myCrdpt_fecha_deposito;
	/**
	* FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	*/
	private java.util.Date myCrdpt_fecha_entrega;
	/**
	* FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	*/
	private java.util.Date myCrdpt_fecha_caducidad;
	/**
	* FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	*/
	private java.util.Date myCrdpt_fecha_contabilizacion;
	/**
	* FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	*/
	private java.util.Date myCrdpt_fecha_solic_devolucion;
	/**
	* FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	*/
	private java.util.Date myCrdpt_fecha_devolucion_definiti;
	/**
	* ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	*/
	private boolean myCrdpt_devuelto;
	/**
	* ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	*/
	private int myCrdpt_estado_deposito;
	/**
	* OBSERVACION DEL DEPOSITO DE GARANTIA
	*/
	private String myCrdpt_observacion;
	/**
	* ESTADO DEL DEPOSITO
	*/
	private boolean myCrdpt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrdpt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrdpt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_deposito_garantia
	*/
	public Cgg_res_deposito_garantia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_deposito_garantia
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE REALIZO EL DEPOSITO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
	* @param inCgg_crpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
	* @param inCrdpt_numero NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	* @param inCrdpt_numero_documento NUMERO DE DOCUMENTO DE DEPOSITO
	* @param inCrdpt_caduca SI LA GARANTIA CADUCA
	* @param inCrdpt_tipo TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	* @param inCrdpt_valor_deposito VALOR DEPOSITADO POR GARANTIA
	* @param inCrdpt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO
	* @param inCrdpt_fecha_entrega FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	* @param inCrdpt_fecha_caducidad FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	* @param inCrdpt_fecha_contabilizacion FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	* @param inCrdpt_fecha_solic_devolucion FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	* @param inCrdpt_fecha_devolucion_definiti FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	* @param inCrdpt_devuelto ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	* @param inCrdpt_estado_deposito ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	* @param inCrdpt_observacion OBSERVACION DEL DEPOSITO DE GARANTIA
	* @param inCrdpt_estado ESTADO DEL DEPOSITO
	* @param inCrdpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @param inCrdpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public Cgg_res_deposito_garantia(
		String inCrdpt_codigo,
		String inCrcpj_codigo,
		String inCrpjr_codigo,
		String inCrper_codigo,
		String inCgg_crpjr_codigo,
		String inCrdpt_numero,
		String inCrdpt_numero_documento,
		boolean inCrdpt_caduca,
		int inCrdpt_tipo,
		java.math.BigDecimal inCrdpt_valor_deposito,
		java.util.Date inCrdpt_fecha_deposito,
		java.util.Date inCrdpt_fecha_entrega,
		java.util.Date inCrdpt_fecha_caducidad,
		java.util.Date inCrdpt_fecha_contabilizacion,
		java.util.Date inCrdpt_fecha_solic_devolucion,
		java.util.Date inCrdpt_fecha_devolucion_definiti,
		boolean inCrdpt_devuelto,
		int inCrdpt_estado_deposito,
		String inCrdpt_observacion,
		boolean inCrdpt_estado,
		String inCrdpt_usuario_insert,
		String inCrdpt_usuario_update
	){
		this.setCRDPT_CODIGO(inCrdpt_codigo);
		this.setCRCPJ_CODIGO(inCrcpj_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGG_CRPJR_CODIGO(inCgg_crpjr_codigo);
		this.setCRDPT_NUMERO(inCrdpt_numero);
		this.setCRDPT_NUMERO_DOCUMENTO(inCrdpt_numero_documento);
		this.setCRDPT_CADUCA(inCrdpt_caduca);
		this.setCRDPT_TIPO(inCrdpt_tipo);
		this.setCRDPT_VALOR_DEPOSITO(inCrdpt_valor_deposito);
		this.setCRDPT_FECHA_DEPOSITO(inCrdpt_fecha_deposito);
		this.setCRDPT_FECHA_ENTREGA(inCrdpt_fecha_entrega);
		this.setCRDPT_FECHA_CADUCIDAD(inCrdpt_fecha_caducidad);
		this.setCRDPT_FECHA_CONTABILIZACION(inCrdpt_fecha_contabilizacion);
		this.setCRDPT_FECHA_SOLIC_DEVOLUCION(inCrdpt_fecha_solic_devolucion);
		this.setCRDPT_FECHA_DEVOLUCION_DEFINITI(inCrdpt_fecha_devolucion_definiti);
		this.setCRDPT_DEVUELTO(inCrdpt_devuelto);
		this.setCRDPT_ESTADO_DEPOSITO(inCrdpt_estado_deposito);
		this.setCRDPT_OBSERVACION(inCrdpt_observacion);
		this.setCRDPT_ESTADO(inCrdpt_estado);
		this.setCRDPT_USUARIO_INSERT(inCrdpt_usuario_insert);
		this.setCRDPT_USUARIO_UPDATE(inCrdpt_usuario_update);
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	*/
	public void setCRDPT_CODIGO(String inCrdpt_codigo){
		this.myCrdpt_codigo = inCrdpt_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	*/
	public String getCRDPT_CODIGO(){
		return this.myCrdpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA
	*/
	public void setCRCPJ_CODIGO(String inCrcpj_codigo){
		this.myCrcpj_codigo = inCrcpj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA
	*/
	public String getCRCPJ_CODIGO(){
		return this.myCrcpj_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE REALIZO EL DEPOSITO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE REALIZO EL DEPOSITO
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE REALIZO EL DEPOSITO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE REALIZO EL DEPOSITO
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO 
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
	* @param inCgg_crpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
	*/
	public void setCGG_CRPJR_CODIGO(String inCgg_crpjr_codigo){
		this.myCgg_crpjr_codigo = inCgg_crpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO
	*/
	public String getCGG_CRPJR_CODIGO(){
		return this.myCgg_crpjr_codigo;
	}

	/**
	* ESTABLECE NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	* @param inCrdpt_numero NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	*/
	public void setCRDPT_NUMERO(String inCrdpt_numero){
		this.myCrdpt_numero = inCrdpt_numero;
	}
	/**
	* OBTIENE NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	* @return String NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	*/
	public String getCRDPT_NUMERO(){
		return this.myCrdpt_numero;
	}

	/**
	* ESTABLECE NUMERO DE DOCUMENTO DE DEPOSITO
	* @param inCrdpt_numero_documento NUMERO DE DOCUMENTO DE DEPOSITO
	*/
	public void setCRDPT_NUMERO_DOCUMENTO(String inCrdpt_numero_documento){
		this.myCrdpt_numero_documento = inCrdpt_numero_documento;
	}
	/**
	* OBTIENE NUMERO DE DOCUMENTO DE DEPOSITO
	* @return String NUMERO DE DOCUMENTO DE DEPOSITO
	*/
	public String getCRDPT_NUMERO_DOCUMENTO(){
		return this.myCrdpt_numero_documento;
	}

	/**
	* ESTABLECE SI LA GARANTIA CADUCA
	* @param inCrdpt_caduca SI LA GARANTIA CADUCA
	*/
	public void setCRDPT_CADUCA(boolean inCrdpt_caduca){
		this.myCrdpt_caduca = inCrdpt_caduca;
	}
	/**
	* OBTIENE SI LA GARANTIA CADUCA
	* @return boolean SI LA GARANTIA CADUCA
	*/
	public boolean getCRDPT_CADUCA(){
		return this.myCrdpt_caduca;
	}

	/**
	* ESTABLECE TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	* @param inCrdpt_tipo TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	*/
	public void setCRDPT_TIPO(int inCrdpt_tipo){
		this.myCrdpt_tipo = inCrdpt_tipo;
	}
	/**
	* OBTIENE TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	* @return int TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	*/
	public int getCRDPT_TIPO(){
		return this.myCrdpt_tipo;
	}

	/**
	* ESTABLECE VALOR DEPOSITADO POR GARANTIA
	* @param inCrdpt_valor_deposito VALOR DEPOSITADO POR GARANTIA
	*/
	public void setCRDPT_VALOR_DEPOSITO(java.math.BigDecimal inCrdpt_valor_deposito){
		this.myCrdpt_valor_deposito = inCrdpt_valor_deposito;
	}
	/**
	* OBTIENE VALOR DEPOSITADO POR GARANTIA
	* @return java.math.BigDecimal VALOR DEPOSITADO POR GARANTIA
	*/
	public java.math.BigDecimal getCRDPT_VALOR_DEPOSITO(){
		return this.myCrdpt_valor_deposito;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DE DEPOSITO
	* @param inCrdpt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO
	*/
	public void setCRDPT_FECHA_DEPOSITO(java.util.Date inCrdpt_fecha_deposito){
		this.myCrdpt_fecha_deposito = inCrdpt_fecha_deposito;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DE DEPOSITO
	* @return java.util.Date FECHA DE REALIZACION DE DEPOSITO
	*/
	public java.util.Date getCRDPT_FECHA_DEPOSITO(){
		return this.myCrdpt_fecha_deposito;
	}

	/**
	* ESTABLECE FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	* @param inCrdpt_fecha_entrega FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	*/
	public void setCRDPT_FECHA_ENTREGA(java.util.Date inCrdpt_fecha_entrega){
		this.myCrdpt_fecha_entrega = inCrdpt_fecha_entrega;
	}
	/**
	* OBTIENE FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	* @return java.util.Date FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	*/
	public java.util.Date getCRDPT_FECHA_ENTREGA(){
		return this.myCrdpt_fecha_entrega;
	}

	/**
	* ESTABLECE FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	* @param inCrdpt_fecha_caducidad FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	*/
	public void setCRDPT_FECHA_CADUCIDAD(java.util.Date inCrdpt_fecha_caducidad){
		this.myCrdpt_fecha_caducidad = inCrdpt_fecha_caducidad;
	}
	/**
	* OBTIENE FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	* @return java.util.Date FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	*/
	public java.util.Date getCRDPT_FECHA_CADUCIDAD(){
		return this.myCrdpt_fecha_caducidad;
	}

	/**
	* ESTABLECE FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	* @param inCrdpt_fecha_contabilizacion FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	*/
	public void setCRDPT_FECHA_CONTABILIZACION(java.util.Date inCrdpt_fecha_contabilizacion){
		this.myCrdpt_fecha_contabilizacion = inCrdpt_fecha_contabilizacion;
	}
	/**
	* OBTIENE FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	* @return java.util.Date FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	*/
	public java.util.Date getCRDPT_FECHA_CONTABILIZACION(){
		return this.myCrdpt_fecha_contabilizacion;
	}

	/**
	* ESTABLECE FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	* @param inCrdpt_fecha_solic_devolucion FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	*/
	public void setCRDPT_FECHA_SOLIC_DEVOLUCION(java.util.Date inCrdpt_fecha_solic_devolucion){
		this.myCrdpt_fecha_solic_devolucion = inCrdpt_fecha_solic_devolucion;
	}
	/**
	* OBTIENE FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	* @return java.util.Date FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	*/
	public java.util.Date getCRDPT_FECHA_SOLIC_DEVOLUCION(){
		return this.myCrdpt_fecha_solic_devolucion;
	}

	/**
	* ESTABLECE FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	* @param inCrdpt_fecha_devolucion_definiti FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	*/
	public void setCRDPT_FECHA_DEVOLUCION_DEFINITI(java.util.Date inCrdpt_fecha_devolucion_definiti){
		this.myCrdpt_fecha_devolucion_definiti = inCrdpt_fecha_devolucion_definiti;
	}
	/**
	* OBTIENE FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	* @return java.util.Date FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	*/
	public java.util.Date getCRDPT_FECHA_DEVOLUCION_DEFINITI(){
		return this.myCrdpt_fecha_devolucion_definiti;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	* @param inCrdpt_devuelto ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	*/
	public void setCRDPT_DEVUELTO(boolean inCrdpt_devuelto){
		this.myCrdpt_devuelto = inCrdpt_devuelto;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	* @return boolean ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	*/
	public boolean getCRDPT_DEVUELTO(){
		return this.myCrdpt_devuelto;
	}

	/**
	* ESTABLECE ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	* @param inCrdpt_estado_deposito ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	*/
	public void setCRDPT_ESTADO_DEPOSITO(int inCrdpt_estado_deposito){
		this.myCrdpt_estado_deposito = inCrdpt_estado_deposito;
	}
	/**
	* OBTIENE ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	* @return int ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	*/
	public int getCRDPT_ESTADO_DEPOSITO(){
		return this.myCrdpt_estado_deposito;
	}

	/**
	* ESTABLECE OBSERVACION DEL DEPOSITO DE GARANTIA
	* @param inCrdpt_observacion OBSERVACION DEL DEPOSITO DE GARANTIA
	*/
	public void setCRDPT_OBSERVACION(String inCrdpt_observacion){
		this.myCrdpt_observacion = inCrdpt_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL DEPOSITO DE GARANTIA
	* @return String OBSERVACION DEL DEPOSITO DE GARANTIA
	*/
	public String getCRDPT_OBSERVACION(){
		return this.myCrdpt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL DEPOSITO
	* @param inCrdpt_estado ESTADO DEL DEPOSITO
	*/
	public void setCRDPT_ESTADO(boolean inCrdpt_estado){
		this.myCrdpt_estado = inCrdpt_estado;
	}
	/**
	* OBTIENE ESTADO DEL DEPOSITO
	* @return boolean ESTADO DEL DEPOSITO
	*/
	public boolean getCRDPT_ESTADO(){
		return this.myCrdpt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @param inCrdpt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	*/
	public void setCRDPT_USUARIO_INSERT(String inCrdpt_usuario_insert){
		this.myCrdpt_usuario_insert = inCrdpt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	*/
	public String getCRDPT_USUARIO_INSERT(){
		return this.myCrdpt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	* @param inCrdpt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public void setCRDPT_USUARIO_UPDATE(String inCrdpt_usuario_update){
		this.myCrdpt_usuario_update = inCrdpt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public String getCRDPT_USUARIO_UPDATE(){
		return this.myCrdpt_usuario_update;
	}

}
