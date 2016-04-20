package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_acuerdo
* TABLA: ACUERDO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CONVENIOS Y/O CONTRATOS ADMINISTRADOS POR EL DEPARTAMENTO JURIDICO
* ABREVIATURA:CJACU
*/
public class Cgg_jur_acuerdo implements Serializable{
	private static final long serialVersionUID = 1321717319;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	private String myCjacu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	*/
	private String myCrpjr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	*/
	private String myCgg_cusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	*/
	private String myCjtpr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	*/
	private String myCainf_codigo;
	/**
	* ANIO EN EL QUE SE REALIZA EL ACUERDO
	*/
	private java.math.BigDecimal myCjacu_anio;
	/**
	* NUMERO SECUENCIAL UNICO DEL ACUERDO
	*/
	private String myCjacu_numero;
	/**
	* OBJETO O MOTIVO DEL ACUERDO
	*/
	private String myCjacu_objeto;
	/**
	* NO ESPECIFICADO
	*/
	private String myCjacu_descripcion;
	/**
	* LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	*/
	private String myCjacu_jurisdiccion_ambito;
	/**
	* FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	*/
	private java.util.Date myCjacu_fecha_suscripcion;
	/**
	* INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	*/
	private String myCjacu_institucion_firma;
	/**
	* FECHA DE INICIO DEL ACUERDO
	*/
	private java.util.Date myCjacu_fecha_inicio;
	/**
	* PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	*/
	private String myCjacu_responsable;
	/**
	* NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	*/
	private String myCjacu_partida_presupuestaria;
	/**
	* COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	*/
	private java.math.BigDecimal myCjacu_costo;
	/**
	* TIEMPO DE DURACION DEL ACUERDO EN DIAS
	*/
	private int myCjacu_tiempo;
	/**
	* ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	*/
	private int myCjacu_estado_ejecucion;
	/**
	* FECHA DE FINALIZACION DEL ACUERDO
	*/
	private java.util.Date myCjacu_fecha_finalizacion;
	/**
	* OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	*/
	private String myCjacu_observacion;
	/**
	* TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	*/
	private int myCjacu_tipo;
	/**
	* TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	*/
	private int myCjacu_tipo_persona;
	/**
	* INDICA SI EL ACUERDO TIENE UN ADENDUM
	*/
	private boolean myCjacu_adendum;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCjacu_fecha_adendum;
	/**
	* NO ESPECIFICADO
	*/
	private String myCjacu_objeto_adendum;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjacu_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjacu_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjacu_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_acuerdo
	*/
	public Cgg_jur_acuerdo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_acuerdo
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCjtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	* @param inCainf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	* @param inCjacu_anio ANIO EN EL QUE SE REALIZA EL ACUERDO
	* @param inCjacu_numero NUMERO SECUENCIAL UNICO DEL ACUERDO
	* @param inCjacu_objeto OBJETO O MOTIVO DEL ACUERDO
	* @param inCjacu_descripcion NO ESPECIFICADO
	* @param inCjacu_jurisdiccion_ambito LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	* @param inCjacu_fecha_suscripcion FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	* @param inCjacu_institucion_firma INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	* @param inCjacu_fecha_inicio FECHA DE INICIO DEL ACUERDO
	* @param inCjacu_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	* @param inCjacu_partida_presupuestaria NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	* @param inCjacu_costo COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	* @param inCjacu_tiempo TIEMPO DE DURACION DEL ACUERDO EN DIAS
	* @param inCjacu_estado_ejecucion ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	* @param inCjacu_fecha_finalizacion FECHA DE FINALIZACION DEL ACUERDO
	* @param inCjacu_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	* @param inCjacu_tipo TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	* @param inCjacu_tipo_persona TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	* @param inCjacu_adendum INDICA SI EL ACUERDO TIENE UN ADENDUM
	* @param inCjacu_fecha_adendum NO ESPECIFICADO
	* @param inCjacu_objeto_adendum NO ESPECIFICADO
	* @param inCjacu_estado ESTADO DEL REGISTRO
	* @param inCjacu_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjacu_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_acuerdo(
		String inCjacu_codigo,
		String inCusu_codigo,
		String inCrpjr_codigo,
		String inCrper_codigo,
		String inCgg_cusu_codigo,
		String inCsctp_codigo,
		String inCjtpr_codigo,
		String inCainf_codigo,
		java.math.BigDecimal inCjacu_anio,
		String inCjacu_numero,
		String inCjacu_objeto,
		String inCjacu_descripcion,
		String inCjacu_jurisdiccion_ambito,
		java.util.Date inCjacu_fecha_suscripcion,
		String inCjacu_institucion_firma,
		java.util.Date inCjacu_fecha_inicio,
		String inCjacu_responsable,
		String inCjacu_partida_presupuestaria,
		java.math.BigDecimal inCjacu_costo,
		int inCjacu_tiempo,
		int inCjacu_estado_ejecucion,
		java.util.Date inCjacu_fecha_finalizacion,
		String inCjacu_observacion,
		int inCjacu_tipo,
		int inCjacu_tipo_persona,
		boolean inCjacu_adendum,
		java.util.Date inCjacu_fecha_adendum,
		String inCjacu_objeto_adendum,
		boolean inCjacu_estado,
		String inCjacu_usuario_insert,
		String inCjacu_usuario_update
	){
		this.setCJACU_CODIGO(inCjacu_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCJTPR_CODIGO(inCjtpr_codigo);
		this.setCAINF_CODIGO(inCainf_codigo);
		this.setCJACU_ANIO(inCjacu_anio);
		this.setCJACU_NUMERO(inCjacu_numero);
		this.setCJACU_OBJETO(inCjacu_objeto);
		this.setCJACU_DESCRIPCION(inCjacu_descripcion);
		this.setCJACU_JURISDICCION_AMBITO(inCjacu_jurisdiccion_ambito);
		this.setCJACU_FECHA_SUSCRIPCION(inCjacu_fecha_suscripcion);
		this.setCJACU_INSTITUCION_FIRMA(inCjacu_institucion_firma);
		this.setCJACU_FECHA_INICIO(inCjacu_fecha_inicio);
		this.setCJACU_RESPONSABLE(inCjacu_responsable);
		this.setCJACU_PARTIDA_PRESUPUESTARIA(inCjacu_partida_presupuestaria);
		this.setCJACU_COSTO(inCjacu_costo);
		this.setCJACU_TIEMPO(inCjacu_tiempo);
		this.setCJACU_ESTADO_EJECUCION(inCjacu_estado_ejecucion);
		this.setCJACU_FECHA_FINALIZACION(inCjacu_fecha_finalizacion);
		this.setCJACU_OBSERVACION(inCjacu_observacion);
		this.setCJACU_TIPO(inCjacu_tipo);
		this.setCJACU_TIPO_PERSONA(inCjacu_tipo_persona);
		this.setCJACU_ADENDUM(inCjacu_adendum);
		this.setCJACU_FECHA_ADENDUM(inCjacu_fecha_adendum);
		this.setCJACU_OBJETO_ADENDUM(inCjacu_objeto_adendum);
		this.setCJACU_ESTADO(inCjacu_estado);
		this.setCJACU_USUARIO_INSERT(inCjacu_usuario_insert);
		this.setCJACU_USUARIO_UPDATE(inCjacu_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	public void setCJACU_CODIGO(String inCjacu_codigo){
		this.myCjacu_codigo = inCjacu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	public String getCJACU_CODIGO(){
		return this.myCjacu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	*/
	public void setCGG_CUSU_CODIGO(String inCgg_cusu_codigo){
		this.myCgg_cusu_codigo = inCgg_cusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	*/
	public String getCGG_CUSU_CODIGO(){
		return this.myCgg_cusu_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	* @param inCjtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	*/
	public void setCJTPR_CODIGO(String inCjtpr_codigo){
		this.myCjtpr_codigo = inCjtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	*/
	public String getCJTPR_CODIGO(){
		return this.myCjtpr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	* @param inCainf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	*/
	public void setCAINF_CODIGO(String inCainf_codigo){
		this.myCainf_codigo = inCainf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	*/
	public String getCAINF_CODIGO(){
		return this.myCainf_codigo;
	}

	/**
	* ESTABLECE ANIO EN EL QUE SE REALIZA EL ACUERDO
	* @param inCjacu_anio ANIO EN EL QUE SE REALIZA EL ACUERDO
	*/
	public void setCJACU_ANIO(java.math.BigDecimal inCjacu_anio){
		this.myCjacu_anio = inCjacu_anio;
	}
	/**
	* OBTIENE ANIO EN EL QUE SE REALIZA EL ACUERDO
	* @return java.math.BigDecimal ANIO EN EL QUE SE REALIZA EL ACUERDO
	*/
	public java.math.BigDecimal getCJACU_ANIO(){
		return this.myCjacu_anio;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DEL ACUERDO
	* @param inCjacu_numero NUMERO SECUENCIAL UNICO DEL ACUERDO
	*/
	public void setCJACU_NUMERO(String inCjacu_numero){
		this.myCjacu_numero = inCjacu_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DEL ACUERDO
	* @return String NUMERO SECUENCIAL UNICO DEL ACUERDO
	*/
	public String getCJACU_NUMERO(){
		return this.myCjacu_numero;
	}

	/**
	* ESTABLECE OBJETO O MOTIVO DEL ACUERDO
	* @param inCjacu_objeto OBJETO O MOTIVO DEL ACUERDO
	*/
	public void setCJACU_OBJETO(String inCjacu_objeto){
		this.myCjacu_objeto = inCjacu_objeto;
	}
	/**
	* OBTIENE OBJETO O MOTIVO DEL ACUERDO
	* @return String OBJETO O MOTIVO DEL ACUERDO
	*/
	public String getCJACU_OBJETO(){
		return this.myCjacu_objeto;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCjacu_descripcion NO ESPECIFICADO
	*/
	public void setCJACU_DESCRIPCION(String inCjacu_descripcion){
		this.myCjacu_descripcion = inCjacu_descripcion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCJACU_DESCRIPCION(){
		return this.myCjacu_descripcion;
	}

	/**
	* ESTABLECE LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	* @param inCjacu_jurisdiccion_ambito LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	*/
	public void setCJACU_JURISDICCION_AMBITO(String inCjacu_jurisdiccion_ambito){
		this.myCjacu_jurisdiccion_ambito = inCjacu_jurisdiccion_ambito;
	}
	/**
	* OBTIENE LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	* @return String LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	*/
	public String getCJACU_JURISDICCION_AMBITO(){
		return this.myCjacu_jurisdiccion_ambito;
	}

	/**
	* ESTABLECE FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	* @param inCjacu_fecha_suscripcion FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	*/
	public void setCJACU_FECHA_SUSCRIPCION(java.util.Date inCjacu_fecha_suscripcion){
		this.myCjacu_fecha_suscripcion = inCjacu_fecha_suscripcion;
	}
	/**
	* OBTIENE FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	* @return java.util.Date FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	*/
	public java.util.Date getCJACU_FECHA_SUSCRIPCION(){
		return this.myCjacu_fecha_suscripcion;
	}

	/**
	* ESTABLECE INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	* @param inCjacu_institucion_firma INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	*/
	public void setCJACU_INSTITUCION_FIRMA(String inCjacu_institucion_firma){
		this.myCjacu_institucion_firma = inCjacu_institucion_firma;
	}
	/**
	* OBTIENE INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	* @return String INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	*/
	public String getCJACU_INSTITUCION_FIRMA(){
		return this.myCjacu_institucion_firma;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL ACUERDO
	* @param inCjacu_fecha_inicio FECHA DE INICIO DEL ACUERDO
	*/
	public void setCJACU_FECHA_INICIO(java.util.Date inCjacu_fecha_inicio){
		this.myCjacu_fecha_inicio = inCjacu_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL ACUERDO
	* @return java.util.Date FECHA DE INICIO DEL ACUERDO
	*/
	public java.util.Date getCJACU_FECHA_INICIO(){
		return this.myCjacu_fecha_inicio;
	}

	/**
	* ESTABLECE PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	* @param inCjacu_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	*/
	public void setCJACU_RESPONSABLE(String inCjacu_responsable){
		this.myCjacu_responsable = inCjacu_responsable;
	}
	/**
	* OBTIENE PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	* @return String PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	*/
	public String getCJACU_RESPONSABLE(){
		return this.myCjacu_responsable;
	}

	/**
	* ESTABLECE NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	* @param inCjacu_partida_presupuestaria NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	*/
	public void setCJACU_PARTIDA_PRESUPUESTARIA(String inCjacu_partida_presupuestaria){
		this.myCjacu_partida_presupuestaria = inCjacu_partida_presupuestaria;
	}
	/**
	* OBTIENE NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	* @return String NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	*/
	public String getCJACU_PARTIDA_PRESUPUESTARIA(){
		return this.myCjacu_partida_presupuestaria;
	}

	/**
	* ESTABLECE COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	* @param inCjacu_costo COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	*/
	public void setCJACU_COSTO(java.math.BigDecimal inCjacu_costo){
		this.myCjacu_costo = inCjacu_costo;
	}
	/**
	* OBTIENE COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	* @return java.math.BigDecimal COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	*/
	public java.math.BigDecimal getCJACU_COSTO(){
		return this.myCjacu_costo;
	}

	/**
	* ESTABLECE TIEMPO DE DURACION DEL ACUERDO EN DIAS
	* @param inCjacu_tiempo TIEMPO DE DURACION DEL ACUERDO EN DIAS
	*/
	public void setCJACU_TIEMPO(int inCjacu_tiempo){
		this.myCjacu_tiempo = inCjacu_tiempo;
	}
	/**
	* OBTIENE TIEMPO DE DURACION DEL ACUERDO EN DIAS
	* @return int TIEMPO DE DURACION DEL ACUERDO EN DIAS
	*/
	public int getCJACU_TIEMPO(){
		return this.myCjacu_tiempo;
	}

	/**
	* ESTABLECE ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	* @param inCjacu_estado_ejecucion ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	*/
	public void setCJACU_ESTADO_EJECUCION(int inCjacu_estado_ejecucion){
		this.myCjacu_estado_ejecucion = inCjacu_estado_ejecucion;
	}
	/**
	* OBTIENE ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	* @return int ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	*/
	public int getCJACU_ESTADO_EJECUCION(){
		return this.myCjacu_estado_ejecucion;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DEL ACUERDO
	* @param inCjacu_fecha_finalizacion FECHA DE FINALIZACION DEL ACUERDO
	*/
	public void setCJACU_FECHA_FINALIZACION(java.util.Date inCjacu_fecha_finalizacion){
		this.myCjacu_fecha_finalizacion = inCjacu_fecha_finalizacion;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DEL ACUERDO
	* @return java.util.Date FECHA DE FINALIZACION DEL ACUERDO
	*/
	public java.util.Date getCJACU_FECHA_FINALIZACION(){
		return this.myCjacu_fecha_finalizacion;
	}

	/**
	* ESTABLECE OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	* @param inCjacu_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	*/
	public void setCJACU_OBSERVACION(String inCjacu_observacion){
		this.myCjacu_observacion = inCjacu_observacion;
	}
	/**
	* OBTIENE OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	* @return String OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	*/
	public String getCJACU_OBSERVACION(){
		return this.myCjacu_observacion;
	}

	/**
	* ESTABLECE TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	* @param inCjacu_tipo TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	*/
	public void setCJACU_TIPO(int inCjacu_tipo){
		this.myCjacu_tipo = inCjacu_tipo;
	}
	/**
	* OBTIENE TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	* @return int TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	*/
	public int getCJACU_TIPO(){
		return this.myCjacu_tipo;
	}

	/**
	* ESTABLECE TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	* @param inCjacu_tipo_persona TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	*/
	public void setCJACU_TIPO_PERSONA(int inCjacu_tipo_persona){
		this.myCjacu_tipo_persona = inCjacu_tipo_persona;
	}
	/**
	* OBTIENE TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	* @return int TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	*/
	public int getCJACU_TIPO_PERSONA(){
		return this.myCjacu_tipo_persona;
	}

	/**
	* ESTABLECE INDICA SI EL ACUERDO TIENE UN ADENDUM
	* @param inCjacu_adendum INDICA SI EL ACUERDO TIENE UN ADENDUM
	*/
	public void setCJACU_ADENDUM(boolean inCjacu_adendum){
		this.myCjacu_adendum = inCjacu_adendum;
	}
	/**
	* OBTIENE INDICA SI EL ACUERDO TIENE UN ADENDUM
	* @return boolean INDICA SI EL ACUERDO TIENE UN ADENDUM
	*/
	public boolean getCJACU_ADENDUM(){
		return this.myCjacu_adendum;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCjacu_fecha_adendum NO ESPECIFICADO
	*/
	public void setCJACU_FECHA_ADENDUM(java.util.Date inCjacu_fecha_adendum){
		this.myCjacu_fecha_adendum = inCjacu_fecha_adendum;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCJACU_FECHA_ADENDUM(){
		return this.myCjacu_fecha_adendum;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCjacu_objeto_adendum NO ESPECIFICADO
	*/
	public void setCJACU_OBJETO_ADENDUM(String inCjacu_objeto_adendum){
		this.myCjacu_objeto_adendum = inCjacu_objeto_adendum;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCJACU_OBJETO_ADENDUM(){
		return this.myCjacu_objeto_adendum;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjacu_estado ESTADO DEL REGISTRO
	*/
	public void setCJACU_ESTADO(boolean inCjacu_estado){
		this.myCjacu_estado = inCjacu_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJACU_ESTADO(){
		return this.myCjacu_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjacu_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJACU_USUARIO_INSERT(String inCjacu_usuario_insert){
		this.myCjacu_usuario_insert = inCjacu_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJACU_USUARIO_INSERT(){
		return this.myCjacu_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjacu_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJACU_USUARIO_UPDATE(String inCjacu_usuario_update){
		this.myCjacu_usuario_update = inCjacu_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJACU_USUARIO_UPDATE(){
		return this.myCjacu_usuario_update;
	}

}
