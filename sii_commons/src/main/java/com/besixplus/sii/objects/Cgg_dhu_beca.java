package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_beca
* TABLA: BECA
* DESCRIPCION:ALMACENA INFORMACION DE LAS BECAS RECIBIDAS POR LOS RESIDENTES
* ABREVIATURA:CDBEC
*/
public class Cgg_dhu_beca implements Serializable{
	private static final long serialVersionUID = 36470095;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	private String myCdbec_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	private String myCdtbc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	private String myCgesp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	private String myCgied_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	private String myCpais_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	*/
	private String myCgtpr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	*/
	private String myCgg_crper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE TIENE EL FINANCIAMIENTO
	*/
	private String myCrpjr_codigo;
	/**
	* NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	*/
	private String myCdbec_numero;
	/**
	* FECHA DE INGRESO A LA BECA O CARRERA
	*/
	private java.util.Date myCdbec_fecha_ingreso;
	/**
	* NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	*/
	private String myCdbec_funcionario;
	/**
	* NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	private String myCdbec_numero_aprobacion;
	/**
	* FECHA DE INICIO DE LA BECA 
	*/
	private java.util.Date myCdbec_fecha_inicio;
	/**
	* FECHA DE FINALIZACION DE LA BECA 
	*/
	private java.util.Date myCdbec_fecha_fin;
	/**
	* NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	*/
	private String myCdbec_numero_convenio;
	/**
	* ORIGEN DEL VUELO DE SALIDA
	*/
	private String myCdbec_vsalida_origen;
	/**
	* DESTINO DEL VUELO DE SALIDA
	*/
	private String myCdbec_vsalida_destino;
	/**
	* VALOR DEL PASAJE DE SALIDA
	*/
	private java.math.BigDecimal myCdbec_vsalida_valor;
	/**
	* ORIGEN DEL VUELO DE RETORNO
	*/
	private String myCdbec_vretorno_origen;
	/**
	* DESTINO DEL VUELO DE RETORNO
	*/
	private String myCdbec_vretorno_destino;
	/**
	* VALOR DEL PASAJE DE RETORNO
	*/
	private java.math.BigDecimal myCdbec_vretorno_valor;
	/**
	* NOMBRE DE LA CARRERA A SEGUIR 
	*/
	private String myCdbec_carrera;
	/**
	* TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
0 - ANUAL
1 - SEMESTRAL
2 - QUIMESTRAL
3 - OTROS
	*/
	private int myCdbec_tipo_ciclo;
	/**
	* TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	*/
	private int myCdbec_total_ciclos;
	/**
	* NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	*/
	private String myCdbec_numero_cuento;
	/**
	* NUMERO DEL DOCUMENTO DE APROBACION MODIFICATORIO DE LA BECA
	*/
	private String myCdbec_numero_aprobacion_modificatorio;
	/**
	* NUMERO DEL DOCUMENTO DE CONTRATO MODIFICATORIO DE LA BECA
	*/
	private String myCdbec_numero_contrato_modificatorio;
	/**
	* INFORMACION ADICIONAL DE CONTRATO MODIFICATORIO DE LA BECA
	*/
	private String myCdbec_observacion_contrato_modificatorio;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCdbec_observacion;
	/**
	* ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	*/
	private boolean myCdbec_titulo_entregado;
	/**
	* DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	*/
	private boolean myCdbec_beca_devengada;
	/**
	* CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 0 - NO CONCLUIDA 
 1 - CONCLUIDA
 2 - REPROBADA
 3 - TERMINADA POR CASO FORTUITO

	*/
	private int myCdbec_estado_aprobacion;
	/**
	* CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	*/
	private java.math.BigDecimal myCdbec_valor_reembolso;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdbec_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdbec_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdbec_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca
	*/
	public Cgg_dhu_beca(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	 * @param inCrpjr_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA JURIDICA 
	* @param inCretf_codigo IDENTIFICATIVO UNICO DE REGSITRO  ENTIDAD FINANCIERA
	* @param inCdbec_numero NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	* @param inCdbec_fecha_ingreso FECHA DE INGRESO A LA BECA O CARRERA
	* @param inCdbec_funcionario NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	* @param inCdbec_numero_aprobacion NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	* @param inCdbec_fecha_inicio FECHA DE INICIO DE LA BECA 
	* @param inCdbec_fecha_fin FECHA DE FINALIZACION DE LA BECA 
	* @param inCdbec_numero_convenio NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	* @param inCdbec_vsalida_origen ORIGEN DEL VUELO DE SALIDA
	* @param inCdbec_vsalida_destino DESTINO DEL VUELO DE SALIDA
	* @param inCdbec_vsalida_valor VALOR DEL PASAJE DE SALIDA
	* @param inCdbec_vretorno_origen ORIGEN DEL VUELO DE RETORNO
	* @param inCdbec_vretorno_destino DESTINO DEL VUELO DE RETORNO
	* @param inCdbec_vretorno_valor VALOR DEL PASAJE DE RETORNO
	* @param inCdbec_carrera NOMBRE DE LA CARRERA A SEGUIR 
	* @param inCdbec_tipo_ciclo TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
0 - ANUAL
1 - SEMESTRAL
2 - QUIMESTRAL
3 - OTROS
	* @param inCdbec_total_ciclos TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	* @param inCdbec_numero_cuento NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	* @param inCdbec_numero_cuento NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA.
	* @param inCdbec_numero_aprobacion_modificatorio NUMERO DEL DOCUMENTO DE APROBACION MODIFICATORIO DE LA BECA.
	* @param inCdbec_numero_contrato_modificatorio NUMERO DEL DOCUMENTO DE CONTRATO MODIFICATORIO DE LA BECA.
	 * @param inCdbec_observacion_contrato_modificatorio INFORMACCION ADICONAL DEL CONTRATO MODIFICATORIO
	* @param inCdbec_observacion INFORMACION ADICIONAL
	* @param inCdbec_titulo_entregado ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	* @param inCdbec_beca_devengada DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	* @param inCdbec_estado_aprobacion CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 0 - NO CONCLUIDA 
 1 - CONCLUIDA
 2 - REPROBADA
 3 - TERMINADA POR CASO FORTUITO

	* @param inCdbec_valor_reembolso CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	* @param inCdbec_estado ESTADO DEL REGISTRO
	* @param inCdbec_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdbec_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_beca(
		String inCdbec_codigo,
		String inCdtbc_codigo,
		String inCgesp_codigo,
		String inCgied_codigo,
		String inCpais_codigo,
		String inCgtpr_codigo,
		String inCrper_codigo,
		String inCgg_crper_codigo,
		String inCrpjr_codigo,
		String inCdbec_numero,
		java.util.Date inCdbec_fecha_ingreso,
		String inCdbec_funcionario,
		String inCdbec_numero_aprobacion,
		java.util.Date inCdbec_fecha_inicio,
		java.util.Date inCdbec_fecha_fin,
		String inCdbec_numero_convenio,
		String inCdbec_vsalida_origen,
		String inCdbec_vsalida_destino,
		java.math.BigDecimal inCdbec_vsalida_valor,
		String inCdbec_vretorno_origen,
		String inCdbec_vretorno_destino,
		java.math.BigDecimal inCdbec_vretorno_valor,
		String inCdbec_carrera,
		int inCdbec_tipo_ciclo,
		int inCdbec_total_ciclos,
		String inCdbec_numero_cuento,
		String inCdbec_numero_aprobacion_modificatorio,
		String inCdbec_numero_contrato_modificatorio,
		String inCdbec_observacion_contrato_modificatorio,
		String inCdbec_observacion,
		boolean inCdbec_titulo_entregado,
		boolean inCdbec_beca_devengada,
		int inCdbec_estado_aprobacion,
		java.math.BigDecimal inCdbec_valor_reembolso,
		boolean inCdbec_estado,
		String inCdbec_usuario_insert,
		String inCdbec_usuario_update
	){
		this.setCDBEC_CODIGO(inCdbec_codigo);
		this.setCDTBC_CODIGO(inCdtbc_codigo);
		this.setCGESP_CODIGO(inCgesp_codigo);
		this.setCGIED_CODIGO(inCgied_codigo);
		this.setCPAIS_CODIGO(inCpais_codigo);
		this.setCGTPR_CODIGO(inCgtpr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCDBEC_NUMERO(inCdbec_numero);
		this.setCDBEC_FECHA_INGRESO(inCdbec_fecha_ingreso);
		this.setCDBEC_FUNCIONARIO(inCdbec_funcionario);
		this.setCDBEC_NUMERO_APROBACION(inCdbec_numero_aprobacion);
		this.setCDBEC_FECHA_INICIO(inCdbec_fecha_inicio);
		this.setCDBEC_FECHA_FIN(inCdbec_fecha_fin);
		this.setCDBEC_NUMERO_CONVENIO(inCdbec_numero_convenio);
		this.setCDBEC_VSALIDA_ORIGEN(inCdbec_vsalida_origen);
		this.setCDBEC_VSALIDA_DESTINO(inCdbec_vsalida_destino);
		this.setCDBEC_VSALIDA_VALOR(inCdbec_vsalida_valor);
		this.setCDBEC_VRETORNO_ORIGEN(inCdbec_vretorno_origen);
		this.setCDBEC_VRETORNO_DESTINO(inCdbec_vretorno_destino);
		this.setCDBEC_VRETORNO_VALOR(inCdbec_vretorno_valor);
		this.setCDBEC_CARRERA(inCdbec_carrera);
		this.setCDBEC_TIPO_CICLO(inCdbec_tipo_ciclo);
		this.setCDBEC_TOTAL_CICLOS(inCdbec_total_ciclos);
		this.setCDBEC_NUMERO_CUENTO(inCdbec_numero_cuento);
		this.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(inCdbec_numero_aprobacion_modificatorio);
		this.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(inCdbec_numero_contrato_modificatorio);
		this.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(inCdbec_observacion_contrato_modificatorio);
		this.setCDBEC_OBSERVACION(inCdbec_observacion);
		this.setCDBEC_TITULO_ENTREGADO(inCdbec_titulo_entregado);
		this.setCDBEC_BECA_DEVENGADA(inCdbec_beca_devengada);
		this.setCDBEC_ESTADO_APROBACION(inCdbec_estado_aprobacion);
		this.setCDBEC_VALOR_REEMBOLSO(inCdbec_valor_reembolso);
		this.setCDBEC_ESTADO(inCdbec_estado);
		this.setCDBEC_USUARIO_INSERT(inCdbec_usuario_insert);
		this.setCDBEC_USUARIO_UPDATE(inCdbec_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	public void setCDTBC_CODIGO(String inCdtbc_codigo){
		this.myCdtbc_codigo = inCdtbc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	public String getCDTBC_CODIGO(){
		return this.myCdtbc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	public void setCGESP_CODIGO(String inCgesp_codigo){
		this.myCgesp_codigo = inCgesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	public String getCGESP_CODIGO(){
		return this.myCgesp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	public void setCGIED_CODIGO(String inCgied_codigo){
		this.myCgied_codigo = inCgied_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	public String getCGIED_CODIGO(){
		return this.myCgied_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	public void setCPAIS_CODIGO(String inCpais_codigo){
		this.myCpais_codigo = inCpais_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	*/
	public String getCPAIS_CODIGO(){
		return this.myCpais_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	*/
	public void setCGTPR_CODIGO(String inCgtpr_codigo){
		this.myCgtpr_codigo = inCgtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	*/
	public String getCGTPR_CODIGO(){
		return this.myCgtpr_codigo;
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
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	*/
	public void setCGG_CRPER_CODIGO(String inCgg_crper_codigo){
		this.myCgg_crper_codigo = inCgg_crper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	*/
	public String getCGG_CRPER_CODIGO(){
		return this.myCgg_crper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO  ENTIDAD FINANCIERA
	* @return String IDENTIFICATIVO UNICO DE REGSITRO  ENTIDAD FINANCIERA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	* @param inCdbec_numero NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	*/
	public void setCDBEC_NUMERO(String inCdbec_numero){
		this.myCdbec_numero = inCdbec_numero;
	}
	/**
	* OBTIENE NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	* @return String NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	*/
	public String getCDBEC_NUMERO(){
		return this.myCdbec_numero;
	}

	/**
	* ESTABLECE FECHA DE INGRESO A LA BECA O CARRERA
	* @param inCdbec_fecha_ingreso FECHA DE INGRESO A LA BECA O CARRERA
	*/
	public void setCDBEC_FECHA_INGRESO(java.util.Date inCdbec_fecha_ingreso){
		this.myCdbec_fecha_ingreso = inCdbec_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO A LA BECA O CARRERA
	* @return java.util.Date FECHA DE INGRESO A LA BECA O CARRERA
	*/
	public java.util.Date getCDBEC_FECHA_INGRESO(){
		return this.myCdbec_fecha_ingreso;
	}

	/**
	* ESTABLECE NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	* @param inCdbec_funcionario NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	*/
	public void setCDBEC_FUNCIONARIO(String inCdbec_funcionario){
		this.myCdbec_funcionario = inCdbec_funcionario;
	}
	/**
	* OBTIENE NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	* @return String NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	*/
	public String getCDBEC_FUNCIONARIO(){
		return this.myCdbec_funcionario;
	}

	/**
	* ESTABLECE NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	* @param inCdbec_numero_aprobacion NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	public void setCDBEC_NUMERO_APROBACION(String inCdbec_numero_aprobacion){
		this.myCdbec_numero_aprobacion = inCdbec_numero_aprobacion;
	}
	/**
	* OBTIENE NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	* @return String NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	public String getCDBEC_NUMERO_APROBACION(){
		return this.myCdbec_numero_aprobacion;
	}

	/**
	* ESTABLECE FECHA DE INICIO DE LA BECA 
	* @param inCdbec_fecha_inicio FECHA DE INICIO DE LA BECA 
	*/
	public void setCDBEC_FECHA_INICIO(java.util.Date inCdbec_fecha_inicio){
		this.myCdbec_fecha_inicio = inCdbec_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DE LA BECA 
	* @return java.util.Date FECHA DE INICIO DE LA BECA 
	*/
	public java.util.Date getCDBEC_FECHA_INICIO(){
		return this.myCdbec_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DE LA BECA 
	* @param inCdbec_fecha_fin FECHA DE FINALIZACION DE LA BECA 
	*/
	public void setCDBEC_FECHA_FIN(java.util.Date inCdbec_fecha_fin){
		this.myCdbec_fecha_fin = inCdbec_fecha_fin;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DE LA BECA 
	* @return java.util.Date FECHA DE FINALIZACION DE LA BECA 
	*/
	public java.util.Date getCDBEC_FECHA_FIN(){
		return this.myCdbec_fecha_fin;
	}

	/**
	* ESTABLECE NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	* @param inCdbec_numero_convenio NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	*/
	public void setCDBEC_NUMERO_CONVENIO(String inCdbec_numero_convenio){
		this.myCdbec_numero_convenio = inCdbec_numero_convenio;
	}
	/**
	* OBTIENE NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	* @return String NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	*/
	public String getCDBEC_NUMERO_CONVENIO(){
		return this.myCdbec_numero_convenio;
	}

	/**
	* ESTABLECE ORIGEN DEL VUELO DE SALIDA
	* @param inCdbec_vsalida_origen ORIGEN DEL VUELO DE SALIDA
	*/
	public void setCDBEC_VSALIDA_ORIGEN(String inCdbec_vsalida_origen){
		this.myCdbec_vsalida_origen = inCdbec_vsalida_origen;
	}
	/**
	* OBTIENE ORIGEN DEL VUELO DE SALIDA
	* @return String ORIGEN DEL VUELO DE SALIDA
	*/
	public String getCDBEC_VSALIDA_ORIGEN(){
		return this.myCdbec_vsalida_origen;
	}

	/**
	* ESTABLECE DESTINO DEL VUELO DE SALIDA
	* @param inCdbec_vsalida_destino DESTINO DEL VUELO DE SALIDA
	*/
	public void setCDBEC_VSALIDA_DESTINO(String inCdbec_vsalida_destino){
		this.myCdbec_vsalida_destino = inCdbec_vsalida_destino;
	}
	/**
	* OBTIENE DESTINO DEL VUELO DE SALIDA
	* @return String DESTINO DEL VUELO DE SALIDA
	*/
	public String getCDBEC_VSALIDA_DESTINO(){
		return this.myCdbec_vsalida_destino;
	}

	/**
	* ESTABLECE VALOR DEL PASAJE DE SALIDA
	* @param inCdbec_vsalida_valor VALOR DEL PASAJE DE SALIDA
	*/
	public void setCDBEC_VSALIDA_VALOR(java.math.BigDecimal inCdbec_vsalida_valor){
		this.myCdbec_vsalida_valor = inCdbec_vsalida_valor;
	}
	/**
	* OBTIENE VALOR DEL PASAJE DE SALIDA
	* @return java.math.BigDecimal VALOR DEL PASAJE DE SALIDA
	*/
	public java.math.BigDecimal getCDBEC_VSALIDA_VALOR(){
		return this.myCdbec_vsalida_valor;
	}

	/**
	* ESTABLECE ORIGEN DEL VUELO DE RETORNO
	* @param inCdbec_vretorno_origen ORIGEN DEL VUELO DE RETORNO
	*/
	public void setCDBEC_VRETORNO_ORIGEN(String inCdbec_vretorno_origen){
		this.myCdbec_vretorno_origen = inCdbec_vretorno_origen;
	}
	/**
	* OBTIENE ORIGEN DEL VUELO DE RETORNO
	* @return String ORIGEN DEL VUELO DE RETORNO
	*/
	public String getCDBEC_VRETORNO_ORIGEN(){
		return this.myCdbec_vretorno_origen;
	}

	/**
	* ESTABLECE DESTINO DEL VUELO DE RETORNO
	* @param inCdbec_vretorno_destino DESTINO DEL VUELO DE RETORNO
	*/
	public void setCDBEC_VRETORNO_DESTINO(String inCdbec_vretorno_destino){
		this.myCdbec_vretorno_destino = inCdbec_vretorno_destino;
	}
	/**
	* OBTIENE DESTINO DEL VUELO DE RETORNO
	* @return String DESTINO DEL VUELO DE RETORNO
	*/
	public String getCDBEC_VRETORNO_DESTINO(){
		return this.myCdbec_vretorno_destino;
	}

	/**
	* ESTABLECE VALOR DEL PASAJE DE RETORNO
	* @param inCdbec_vretorno_valor VALOR DEL PASAJE DE RETORNO
	*/
	public void setCDBEC_VRETORNO_VALOR(java.math.BigDecimal inCdbec_vretorno_valor){
		this.myCdbec_vretorno_valor = inCdbec_vretorno_valor;
	}
	/**
	* OBTIENE VALOR DEL PASAJE DE RETORNO
	* @return java.math.BigDecimal VALOR DEL PASAJE DE RETORNO
	*/
	public java.math.BigDecimal getCDBEC_VRETORNO_VALOR(){
		return this.myCdbec_vretorno_valor;
	}

	/**
	* ESTABLECE NOMBRE DE LA CARRERA A SEGUIR 
	* @param inCdbec_carrera NOMBRE DE LA CARRERA A SEGUIR 
	*/
	public void setCDBEC_CARRERA(String inCdbec_carrera){
		this.myCdbec_carrera = inCdbec_carrera;
	}
	/**
	* OBTIENE NOMBRE DE LA CARRERA A SEGUIR 
	* @return String NOMBRE DE LA CARRERA A SEGUIR 
	*/
	public String getCDBEC_CARRERA(){
		return this.myCdbec_carrera;
	}

	/**
	* ESTABLECE TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
0 - ANUAL
1 - SEMESTRAL
2 - QUIMESTRAL
3 - OTROS
	* @param inCdbec_tipo_ciclo TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
0 - ANUAL
1 - SEMESTRAL
2 - QUIMESTRAL
3 - OTROS
	*/
	public void setCDBEC_TIPO_CICLO(int inCdbec_tipo_ciclo){
		this.myCdbec_tipo_ciclo = inCdbec_tipo_ciclo;
	}
	/**
	* OBTIENE TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
0 - ANUAL
1 - SEMESTRAL
2 - QUIMESTRAL
3 - OTROS
	* @return int TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
0 - ANUAL
1 - SEMESTRAL
2 - QUIMESTRAL
3 - OTROS
	*/
	public int getCDBEC_TIPO_CICLO(){
		return this.myCdbec_tipo_ciclo;
	}

	/**
	* ESTABLECE TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	* @param inCdbec_total_ciclos TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	*/
	public void setCDBEC_TOTAL_CICLOS(int inCdbec_total_ciclos){
		this.myCdbec_total_ciclos = inCdbec_total_ciclos;
	}
	/**
	* OBTIENE TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	* @return int TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	*/
	public int getCDBEC_TOTAL_CICLOS(){
		return this.myCdbec_total_ciclos;
	}

	/**
	* ESTABLECE NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	* @param inCdbec_numero_cuento NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	*/
	public void setCDBEC_NUMERO_CUENTO(String inCdbec_numero_cuento){
		this.myCdbec_numero_cuento = inCdbec_numero_cuento;
	}
	/**
	* OBTIENE NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	* @return String NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	*/
	public String getCDBEC_NUMERO_CUENTO(){
		return this.myCdbec_numero_cuento;
	}
	/**
	* ESTABLECE NUMERO DEL DOCUMENTO DE APROBACION MODIFICATORIO DE LA BECA
	* @param inCdbec_numero_aprobacion_modificatorio NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	public void setCDBEC_NUMERO_APROBACION_MODIFICATORIO(String inCdbec_numero_aprobacion_modificatorio){
		this.myCdbec_numero_aprobacion_modificatorio = inCdbec_numero_aprobacion_modificatorio;
	}
	/**
	* OBTIENE NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	* @return String NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	public String getCDBEC_NUMERO_APROBACION_MODIFICATORIO(){
		return this.myCdbec_numero_aprobacion_modificatorio;
	}
	/**
	* ESTABLECE NUMERO DEL DOCUMENTO DE CONTRATO MODIFICATORIO DE LA BECA
	* @param inCdbec_numero_contrato_modificatorio NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	public void setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(String inCdbec_numero_contrato_modificatorio){
		this.myCdbec_numero_contrato_modificatorio = inCdbec_numero_contrato_modificatorio;
	}
	/**
	* OBTIENE NUMERO DEL DOCUMENTO DE CONTRATO MODIFICATORIODE LA BECA
	* @return String NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	*/
	public String getCDBEC_NUMERO_CONTRATO_MODIFICATORIO(){
		return this.myCdbec_numero_contrato_modificatorio;
	}
	/**
	* ESTABLECE INFORMACION ADICIONAL DE CONTRATO MODIFICATORIO
	* @param inCdbec_observacion_contrato_modificatorio INFORMACION ADICIONAL
	*/
	public void setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(String inCdbec_observacion_contrato_modificatorio){
		this.myCdbec_observacion_contrato_modificatorio = inCdbec_observacion_contrato_modificatorio;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL CONTRATO MODIFICATORIO
	* @return String INFORMACION ADICIONAL
	*/
	public String getCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(){
		return this.myCdbec_observacion_contrato_modificatorio;
	}
	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCdbec_observacion INFORMACION ADICIONAL
	*/
	public void setCDBEC_OBSERVACION(String inCdbec_observacion){
		this.myCdbec_observacion = inCdbec_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCDBEC_OBSERVACION(){
		return this.myCdbec_observacion;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	* @param inCdbec_titulo_entregado ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	*/
	public void setCDBEC_TITULO_ENTREGADO(boolean inCdbec_titulo_entregado){
		this.myCdbec_titulo_entregado = inCdbec_titulo_entregado;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	* @return boolean ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	*/
	public boolean getCDBEC_TITULO_ENTREGADO(){
		return this.myCdbec_titulo_entregado;
	}

	/**
	* ESTABLECE DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	* @param inCdbec_beca_devengada DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	*/
	public void setCDBEC_BECA_DEVENGADA(boolean inCdbec_beca_devengada){
		this.myCdbec_beca_devengada = inCdbec_beca_devengada;
	}
	/**
	* OBTIENE DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	* @return boolean DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	*/
	public boolean getCDBEC_BECA_DEVENGADA(){
		return this.myCdbec_beca_devengada;
	}

	/**
	* ESTABLECE CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 0 - NO CONCLUIDA 
 1 - CONCLUIDA
 2 - REPROBADA
 3 - TERMINADA POR CASO FORTUITO

	* @param inCdbec_estado_aprobacion CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 0 - NO CONCLUIDA 
 1 - CONCLUIDA
 2 - REPROBADA
 3 - TERMINADA POR CASO FORTUITO

	*/
	public void setCDBEC_ESTADO_APROBACION(int inCdbec_estado_aprobacion){
		this.myCdbec_estado_aprobacion = inCdbec_estado_aprobacion;
	}
	/**
	* OBTIENE CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 0 - NO CONCLUIDA 
 1 - CONCLUIDA
 2 - REPROBADA
 3 - TERMINADA POR CASO FORTUITO

	* @return int CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 0 - NO CONCLUIDA 
 1 - CONCLUIDA
 2 - REPROBADA
 3 - TERMINADA POR CASO FORTUITO

	*/
	public int getCDBEC_ESTADO_APROBACION(){
		return this.myCdbec_estado_aprobacion;
	}

	/**
	* ESTABLECE CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	* @param inCdbec_valor_reembolso CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	*/
	public void setCDBEC_VALOR_REEMBOLSO(java.math.BigDecimal inCdbec_valor_reembolso){
		this.myCdbec_valor_reembolso = inCdbec_valor_reembolso;
	}
	/**
	* OBTIENE CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	* @return java.math.BigDecimal CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	*/
	public java.math.BigDecimal getCDBEC_VALOR_REEMBOLSO(){
		return this.myCdbec_valor_reembolso;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdbec_estado ESTADO DEL REGISTRO
	*/
	public void setCDBEC_ESTADO(boolean inCdbec_estado){
		this.myCdbec_estado = inCdbec_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDBEC_ESTADO(){
		return this.myCdbec_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdbec_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDBEC_USUARIO_INSERT(String inCdbec_usuario_insert){
		this.myCdbec_usuario_insert = inCdbec_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDBEC_USUARIO_INSERT(){
		return this.myCdbec_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdbec_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDBEC_USUARIO_UPDATE(String inCdbec_usuario_update){
		this.myCdbec_usuario_update = inCdbec_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDBEC_USUARIO_UPDATE(){
		return this.myCdbec_usuario_update;
	}

}
