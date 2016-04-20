package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_proceso_judicial
* TABLA: PROCESO JUDICIAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS PROCESOS JUDICIALES ADMINSITRADOS POR EL AREA JURIDICA
* ABREVIATURA:CJPJU
*/
public class Cgg_jur_proceso_judicial implements Serializable{
	private static final long serialVersionUID = 1923421516;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	private String myCjpju_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	*/
	private String myCjpju_numero;
	/**
	* TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	*/
	private int myCjpju_tipo_proceso;
	/**
	* TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	*/
	private int myCjpju_tipo_adversario;
	/**
	* FECHA DE INICIO DEL PROCESO
	*/
	private java.util.Date myCjpju_fecha_inicio;
	/**
	* FECHA DE FINALIZACION DEL PROCESO
	*/
	private java.util.Date myCjpju_fecha_finalizacion;
	/**
	* ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	*/
	private int myCjpju_estado_ejecucion;
	/**
	* PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	*/
	private String myCjpju_responsable;
	/**
	* OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	*/
	private String myCjpju_observacion;
	/**
	* ESTADO DEL REGISTRO DE PROCESO JUDICIAL
	*/
	private boolean myCjpju_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjpju_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjpju_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_proceso_judicial
	*/
	public Cgg_jur_proceso_judicial(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_proceso_judicial
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCjpju_numero NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	* @param inCjpju_tipo_proceso TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	* @param inCjpju_tipo_adversario TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	* @param inCjpju_fecha_inicio FECHA DE INICIO DEL PROCESO
	* @param inCjpju_fecha_finalizacion FECHA DE FINALIZACION DEL PROCESO
	* @param inCjpju_estado_ejecucion ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	* @param inCjpju_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	* @param inCjpju_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	* @param inCjpju_estado ESTADO DEL REGISTRO DE PROCESO JUDICIAL
	* @param inCjpju_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjpju_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_proceso_judicial(
		String inCjpju_codigo,
		String inCctn_codigo,
		String inCrpjr_codigo,
		String inCrper_codigo,
		String inCjpju_numero,
		int inCjpju_tipo_proceso,
		int inCjpju_tipo_adversario,
		java.util.Date inCjpju_fecha_inicio,
		java.util.Date inCjpju_fecha_finalizacion,
		int inCjpju_estado_ejecucion,
		String inCjpju_responsable,
		String inCjpju_observacion,
		boolean inCjpju_estado,
		String inCjpju_usuario_insert,
		String inCjpju_usuario_update
	){
		this.setCJPJU_CODIGO(inCjpju_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCJPJU_NUMERO(inCjpju_numero);
		this.setCJPJU_TIPO_PROCESO(inCjpju_tipo_proceso);
		this.setCJPJU_TIPO_ADVERSARIO(inCjpju_tipo_adversario);
		this.setCJPJU_FECHA_INICIO(inCjpju_fecha_inicio);
		this.setCJPJU_FECHA_FINALIZACION(inCjpju_fecha_finalizacion);
		this.setCJPJU_ESTADO_EJECUCION(inCjpju_estado_ejecucion);
		this.setCJPJU_RESPONSABLE(inCjpju_responsable);
		this.setCJPJU_OBSERVACION(inCjpju_observacion);
		this.setCJPJU_ESTADO(inCjpju_estado);
		this.setCJPJU_USUARIO_INSERT(inCjpju_usuario_insert);
		this.setCJPJU_USUARIO_UPDATE(inCjpju_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	public void setCJPJU_CODIGO(String inCjpju_codigo){
		this.myCjpju_codigo = inCjpju_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	*/
	public String getCJPJU_CODIGO(){
		return this.myCjpju_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
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
	* ESTABLECE NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	* @param inCjpju_numero NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	*/
	public void setCJPJU_NUMERO(String inCjpju_numero){
		this.myCjpju_numero = inCjpju_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	* @return String NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	*/
	public String getCJPJU_NUMERO(){
		return this.myCjpju_numero;
	}

	/**
	* ESTABLECE TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	* @param inCjpju_tipo_proceso TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	*/
	public void setCJPJU_TIPO_PROCESO(int inCjpju_tipo_proceso){
		this.myCjpju_tipo_proceso = inCjpju_tipo_proceso;
	}
	/**
	* OBTIENE TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	* @return int TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	*/
	public int getCJPJU_TIPO_PROCESO(){
		return this.myCjpju_tipo_proceso;
	}

	/**
	* ESTABLECE TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	* @param inCjpju_tipo_adversario TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	*/
	public void setCJPJU_TIPO_ADVERSARIO(int inCjpju_tipo_adversario){
		this.myCjpju_tipo_adversario = inCjpju_tipo_adversario;
	}
	/**
	* OBTIENE TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	* @return int TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	*/
	public int getCJPJU_TIPO_ADVERSARIO(){
		return this.myCjpju_tipo_adversario;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL PROCESO
	* @param inCjpju_fecha_inicio FECHA DE INICIO DEL PROCESO
	*/
	public void setCJPJU_FECHA_INICIO(java.util.Date inCjpju_fecha_inicio){
		this.myCjpju_fecha_inicio = inCjpju_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL PROCESO
	* @return java.util.Date FECHA DE INICIO DEL PROCESO
	*/
	public java.util.Date getCJPJU_FECHA_INICIO(){
		return this.myCjpju_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DEL PROCESO
	* @param inCjpju_fecha_finalizacion FECHA DE FINALIZACION DEL PROCESO
	*/
	public void setCJPJU_FECHA_FINALIZACION(java.util.Date inCjpju_fecha_finalizacion){
		this.myCjpju_fecha_finalizacion = inCjpju_fecha_finalizacion;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DEL PROCESO
	* @return java.util.Date FECHA DE FINALIZACION DEL PROCESO
	*/
	public java.util.Date getCJPJU_FECHA_FINALIZACION(){
		return this.myCjpju_fecha_finalizacion;
	}

	/**
	* ESTABLECE ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	* @param inCjpju_estado_ejecucion ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	*/
	public void setCJPJU_ESTADO_EJECUCION(int inCjpju_estado_ejecucion){
		this.myCjpju_estado_ejecucion = inCjpju_estado_ejecucion;
	}
	/**
	* OBTIENE ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	* @return int ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	*/
	public int getCJPJU_ESTADO_EJECUCION(){
		return this.myCjpju_estado_ejecucion;
	}

	/**
	* ESTABLECE PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	* @param inCjpju_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	*/
	public void setCJPJU_RESPONSABLE(String inCjpju_responsable){
		this.myCjpju_responsable = inCjpju_responsable;
	}
	/**
	* OBTIENE PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	* @return String PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	*/
	public String getCJPJU_RESPONSABLE(){
		return this.myCjpju_responsable;
	}

	/**
	* ESTABLECE OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	* @param inCjpju_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	*/
	public void setCJPJU_OBSERVACION(String inCjpju_observacion){
		this.myCjpju_observacion = inCjpju_observacion;
	}
	/**
	* OBTIENE OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	* @return String OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	*/
	public String getCJPJU_OBSERVACION(){
		return this.myCjpju_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE PROCESO JUDICIAL
	* @param inCjpju_estado ESTADO DEL REGISTRO DE PROCESO JUDICIAL
	*/
	public void setCJPJU_ESTADO(boolean inCjpju_estado){
		this.myCjpju_estado = inCjpju_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE PROCESO JUDICIAL
	* @return boolean ESTADO DEL REGISTRO DE PROCESO JUDICIAL
	*/
	public boolean getCJPJU_ESTADO(){
		return this.myCjpju_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjpju_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJPJU_USUARIO_INSERT(String inCjpju_usuario_insert){
		this.myCjpju_usuario_insert = inCjpju_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJPJU_USUARIO_INSERT(){
		return this.myCjpju_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjpju_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJPJU_USUARIO_UPDATE(String inCjpju_usuario_update){
		this.myCjpju_usuario_update = inCjpju_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJPJU_USUARIO_UPDATE(){
		return this.myCjpju_usuario_update;
	}

}
