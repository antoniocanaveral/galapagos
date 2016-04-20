package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_carnet
* TABLA: CARNET
* DESCRIPCION:ALMACENA INFORMACION DE LOS CARNET DE RESIDENCIA
* ABREVIATURA:CRCNT
*/
public class Cgg_res_carnet implements Serializable{
	private static final long serialVersionUID = 1426851006;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	*/
	private String myCrcnt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	*/
	private String myCrcom_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	private String myCradj_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	*/
	private String myCrrsd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	*/
	private String myCrcpj_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	*/
	private String myCrcnt_serie;
	/**
	* MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	*/
	private int myCrcnt_motivo;
	/**
	* FECHA DE EMISION DEL CARNET
	*/
	private java.util.Date myCrcnt_fecha_emision;
	/**
	* FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	*/
	private java.util.Date myCrcnt_fecha_aprobacion;
	/**
	* FECHA DE CADUCIDAD DE LA ESPECIE
	*/
	private java.util.Date myCrcnt_fecha_caducidad;
	/**
	* FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	*/
	private java.util.Date myCrcnt_fecha_deposito;
	/**
	* SI EL CARNET YA FUE IMPRESO
	*/
	private boolean myCrcnt_carnet_impreso;
	/**
	* NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	*/
	private String myCrcnt_numero_comp;
	/**
	* VALOR DEPOSITADO
	*/
	private java.math.BigDecimal myCrcnt_valor;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCrcnt_observacion;
	/**
	* ESTADO DEL CARNET 
ACTIVO
INACTIVO
	*/
	private boolean myCrcnt_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrcnt_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrcnt_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_carnet
	*/
	public Cgg_res_carnet(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_carnet
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	* @param inCrcnt_serie CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	* @param inCrcnt_motivo MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	* @param inCrcnt_fecha_emision FECHA DE EMISION DEL CARNET
	* @param inCrcnt_fecha_aprobacion FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	* @param inCrcnt_fecha_caducidad FECHA DE CADUCIDAD DE LA ESPECIE
	* @param inCrcnt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	* @param inCrcnt_carnet_impreso SI EL CARNET YA FUE IMPRESO
	* @param inCrcnt_numero_comp NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	* @param inCrcnt_valor VALOR DEPOSITADO
	* @param inCrcnt_observacion INFORMACION ADICIONAL
	* @param inCrcnt_estado ESTADO DEL CARNET 
ACTIVO
INACTIVO
	* @param inCrcnt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcnt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_carnet(
		String inCrcnt_codigo,
		String inCrcom_codigo,
		String inCradj_codigo,
		String inCrrsd_codigo,
		String inCrcpj_codigo,
		String inCrcnt_serie,
		int inCrcnt_motivo,
		java.util.Date inCrcnt_fecha_emision,
		java.util.Date inCrcnt_fecha_aprobacion,
		java.util.Date inCrcnt_fecha_caducidad,
		java.util.Date inCrcnt_fecha_deposito,
		boolean inCrcnt_carnet_impreso,
		String inCrcnt_numero_comp,
		java.math.BigDecimal inCrcnt_valor,
		String inCrcnt_observacion,
		boolean inCrcnt_estado,
		String inCrcnt_usuario_insert,
		String inCrcnt_usuario_update
	){
		this.setCRCNT_CODIGO(inCrcnt_codigo);
		this.setCRCOM_CODIGO(inCrcom_codigo);
		this.setCRADJ_CODIGO(inCradj_codigo);
		this.setCRRSD_CODIGO(inCrrsd_codigo);
		this.setCRCPJ_CODIGO(inCrcpj_codigo);
		this.setCRCNT_SERIE(inCrcnt_serie);
		this.setCRCNT_MOTIVO(inCrcnt_motivo);
		this.setCRCNT_FECHA_EMISION(inCrcnt_fecha_emision);
		this.setCRCNT_FECHA_APROBACION(inCrcnt_fecha_aprobacion);
		this.setCRCNT_FECHA_CADUCIDAD(inCrcnt_fecha_caducidad);
		this.setCRCNT_FECHA_DEPOSITO(inCrcnt_fecha_deposito);
		this.setCRCNT_CARNET_IMPRESO(inCrcnt_carnet_impreso);
		this.setCRCNT_NUMERO_COMP(inCrcnt_numero_comp);
		this.setCRCNT_VALOR(inCrcnt_valor);
		this.setCRCNT_OBSERVACION(inCrcnt_observacion);
		this.setCRCNT_ESTADO(inCrcnt_estado);
		this.setCRCNT_USUARIO_INSERT(inCrcnt_usuario_insert);
		this.setCRCNT_USUARIO_UPDATE(inCrcnt_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	*/
	public void setCRCNT_CODIGO(String inCrcnt_codigo){
		this.myCrcnt_codigo = inCrcnt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	*/
	public String getCRCNT_CODIGO(){
		return this.myCrcnt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	*/
	public void setCRCOM_CODIGO(String inCrcom_codigo){
		this.myCrcom_codigo = inCrcom_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	*/
	public String getCRCOM_CODIGO(){
		return this.myCrcom_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	public void setCRADJ_CODIGO(String inCradj_codigo){
		this.myCradj_codigo = inCradj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	public String getCRADJ_CODIGO(){
		return this.myCradj_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	*/
	public void setCRRSD_CODIGO(String inCrrsd_codigo){
		this.myCrrsd_codigo = inCrrsd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	*/
	public String getCRRSD_CODIGO(){
		return this.myCrrsd_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	*/
	public void setCRCPJ_CODIGO(String inCrcpj_codigo){
		this.myCrcpj_codigo = inCrcpj_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	*/
	public String getCRCPJ_CODIGO(){
		return this.myCrcpj_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	* @param inCrcnt_serie CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	*/
	public void setCRCNT_SERIE(String inCrcnt_serie){
		this.myCrcnt_serie = inCrcnt_serie;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	* @return String CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	*/
	public String getCRCNT_SERIE(){
		return this.myCrcnt_serie;
	}

	/**
	* ESTABLECE MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	* @param inCrcnt_motivo MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	*/
	public void setCRCNT_MOTIVO(int inCrcnt_motivo){
		this.myCrcnt_motivo = inCrcnt_motivo;
	}
	/**
	* OBTIENE MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	* @return int MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	*/
	public int getCRCNT_MOTIVO(){
		return this.myCrcnt_motivo;
	}

	/**
	* ESTABLECE FECHA DE EMISION DEL CARNET
	* @param inCrcnt_fecha_emision FECHA DE EMISION DEL CARNET
	*/
	public void setCRCNT_FECHA_EMISION(java.util.Date inCrcnt_fecha_emision){
		this.myCrcnt_fecha_emision = inCrcnt_fecha_emision;
	}
	/**
	* OBTIENE FECHA DE EMISION DEL CARNET
	* @return java.util.Date FECHA DE EMISION DEL CARNET
	*/
	public java.util.Date getCRCNT_FECHA_EMISION(){
		return this.myCrcnt_fecha_emision;
	}

	/**
	* ESTABLECE FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	* @param inCrcnt_fecha_aprobacion FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	*/
	public void setCRCNT_FECHA_APROBACION(java.util.Date inCrcnt_fecha_aprobacion){
		this.myCrcnt_fecha_aprobacion = inCrcnt_fecha_aprobacion;
	}
	/**
	* OBTIENE FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	* @return java.util.Date FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	*/
	public java.util.Date getCRCNT_FECHA_APROBACION(){
		return this.myCrcnt_fecha_aprobacion;
	}

	/**
	* ESTABLECE FECHA DE CADUCIDAD DE LA ESPECIE
	* @param inCrcnt_fecha_caducidad FECHA DE CADUCIDAD DE LA ESPECIE
	*/
	public void setCRCNT_FECHA_CADUCIDAD(java.util.Date inCrcnt_fecha_caducidad){
		this.myCrcnt_fecha_caducidad = inCrcnt_fecha_caducidad;
	}
	/**
	* OBTIENE FECHA DE CADUCIDAD DE LA ESPECIE
	* @return java.util.Date FECHA DE CADUCIDAD DE LA ESPECIE
	*/
	public java.util.Date getCRCNT_FECHA_CADUCIDAD(){
		return this.myCrcnt_fecha_caducidad;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	* @param inCrcnt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	*/
	public void setCRCNT_FECHA_DEPOSITO(java.util.Date inCrcnt_fecha_deposito){
		this.myCrcnt_fecha_deposito = inCrcnt_fecha_deposito;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	* @return java.util.Date FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	*/
	public java.util.Date getCRCNT_FECHA_DEPOSITO(){
		return this.myCrcnt_fecha_deposito;
	}

	/**
	* ESTABLECE SI EL CARNET YA FUE IMPRESO
	* @param inCrcnt_carnet_impreso SI EL CARNET YA FUE IMPRESO
	*/
	public void setCRCNT_CARNET_IMPRESO(boolean inCrcnt_carnet_impreso){
		this.myCrcnt_carnet_impreso = inCrcnt_carnet_impreso;
	}
	/**
	* OBTIENE SI EL CARNET YA FUE IMPRESO
	* @return boolean SI EL CARNET YA FUE IMPRESO
	*/
	public boolean getCRCNT_CARNET_IMPRESO(){
		return this.myCrcnt_carnet_impreso;
	}

	/**
	* ESTABLECE NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	* @param inCrcnt_numero_comp NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	*/
	public void setCRCNT_NUMERO_COMP(String inCrcnt_numero_comp){
		this.myCrcnt_numero_comp = inCrcnt_numero_comp;
	}
	/**
	* OBTIENE NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	* @return String NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	*/
	public String getCRCNT_NUMERO_COMP(){
		return this.myCrcnt_numero_comp;
	}

	/**
	* ESTABLECE VALOR DEPOSITADO
	* @param inCrcnt_valor VALOR DEPOSITADO
	*/
	public void setCRCNT_VALOR(java.math.BigDecimal inCrcnt_valor){
		this.myCrcnt_valor = inCrcnt_valor;
	}
	/**
	* OBTIENE VALOR DEPOSITADO
	* @return java.math.BigDecimal VALOR DEPOSITADO
	*/
	public java.math.BigDecimal getCRCNT_VALOR(){
		return this.myCrcnt_valor;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCrcnt_observacion INFORMACION ADICIONAL
	*/
	public void setCRCNT_OBSERVACION(String inCrcnt_observacion){
		this.myCrcnt_observacion = inCrcnt_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCRCNT_OBSERVACION(){
		return this.myCrcnt_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL CARNET 
ACTIVO
INACTIVO
	* @param inCrcnt_estado ESTADO DEL CARNET 
ACTIVO
INACTIVO
	*/
	public void setCRCNT_ESTADO(boolean inCrcnt_estado){
		this.myCrcnt_estado = inCrcnt_estado;
	}
	/**
	* OBTIENE ESTADO DEL CARNET 
ACTIVO
INACTIVO
	* @return boolean ESTADO DEL CARNET 
ACTIVO
INACTIVO
	*/
	public boolean getCRCNT_ESTADO(){
		return this.myCrcnt_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcnt_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRCNT_USUARIO_INSERT(String inCrcnt_usuario_insert){
		this.myCrcnt_usuario_insert = inCrcnt_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRCNT_USUARIO_INSERT(){
		return this.myCrcnt_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrcnt_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRCNT_USUARIO_UPDATE(String inCrcnt_usuario_update){
		this.myCrcnt_usuario_update = inCrcnt_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRCNT_USUARIO_UPDATE(){
		return this.myCrcnt_usuario_update;
	}

}
