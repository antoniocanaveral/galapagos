package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_residencia
* TABLA: RESIDENCIA
* DESCRIPCION:ALMACENA INFORMACION DE RESIDENCIAS
* ABREVIATURA:CRRSD
*/
public class Cgg_res_residencia implements Serializable{
	private static final long serialVersionUID = 210210873;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	private String myCrrsd_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	*/
	private String myCrtst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	private String myCrtra_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	*/
	private String myCgg_crtra_codigo;
	/**
	* NUMERO DE RESIDENCIA
	*/
	private int myCrrsd_numero;
	/**
	* ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	*/
	private int myCrrsd_modalidad;
	/**
	* FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	*/
	private java.util.Date myCrrsd_fecha_inicio;
	/**
	* FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	*/
	private java.util.Date myCrrsd_fecha_caducidad;
	/**
	* SI LA RESIDENCIA ESTA REVOCADA
	*/
	private boolean myCrrsd_revocada;
	/**
	* FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	*/
	private java.util.Date myCrrsd_fecha_revocatoria;
	/**
	* DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	*/
	private String myCrrsd_motivo_revocatoria;
	/**
	* DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	*/
	private boolean myCrrsd_vigente;
	/**
	* ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	*/
	private boolean myCrrsd_tramite_pendiente;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrrsd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrrsd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrrsd_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_residencia
	*/
	public Cgg_res_residencia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_residencia
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCgg_crtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	* @param inCrrsd_numero NUMERO DE RESIDENCIA
	* @param inCrrsd_modalidad ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	* @param inCrrsd_fecha_inicio FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	* @param inCrrsd_fecha_caducidad FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	* @param inCrrsd_revocada SI LA RESIDENCIA ESTA REVOCADA
	* @param inCrrsd_fecha_revocatoria FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	* @param inCrrsd_motivo_revocatoria DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	* @param inCrrsd_vigente DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	* @param inCrrsd_tramite_pendiente ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	* @param inCrrsd_estado ESTADO DEL REGISTRO
	* @param inCrrsd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrsd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_residencia(
		String inCrrsd_codigo,
		String inCrper_codigo,
		String inCrtst_codigo,
		String inCrtra_codigo,
		String inCgg_crtra_codigo,
		int inCrrsd_numero,
		int inCrrsd_modalidad,
		java.util.Date inCrrsd_fecha_inicio,
		java.util.Date inCrrsd_fecha_caducidad,
		boolean inCrrsd_revocada,
		java.util.Date inCrrsd_fecha_revocatoria,
		String inCrrsd_motivo_revocatoria,
		boolean inCrrsd_vigente,
		boolean inCrrsd_tramite_pendiente,
		boolean inCrrsd_estado,
		String inCrrsd_usuario_insert,
		String inCrrsd_usuario_update
	){
		this.setCRRSD_CODIGO(inCrrsd_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCGG_CRTRA_CODIGO(inCgg_crtra_codigo);
		this.setCRRSD_NUMERO(inCrrsd_numero);
		this.setCRRSD_MODALIDAD(inCrrsd_modalidad);
		this.setCRRSD_FECHA_INICIO(inCrrsd_fecha_inicio);
		this.setCRRSD_FECHA_CADUCIDAD(inCrrsd_fecha_caducidad);
		this.setCRRSD_REVOCADA(inCrrsd_revocada);
		this.setCRRSD_FECHA_REVOCATORIA(inCrrsd_fecha_revocatoria);
		this.setCRRSD_MOTIVO_REVOCATORIA(inCrrsd_motivo_revocatoria);
		this.setCRRSD_VIGENTE(inCrrsd_vigente);
		this.setCRRSD_TRAMITE_PENDIENTE(inCrrsd_tramite_pendiente);
		this.setCRRSD_ESTADO(inCrrsd_estado);
		this.setCRRSD_USUARIO_INSERT(inCrrsd_usuario_insert);
		this.setCRRSD_USUARIO_UPDATE(inCrrsd_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	public void setCRRSD_CODIGO(String inCrrsd_codigo){
		this.myCrrsd_codigo = inCrrsd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	*/
	public String getCRRSD_CODIGO(){
		return this.myCrrsd_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	*/
	public void setCRTST_CODIGO(String inCrtst_codigo){
		this.myCrtst_codigo = inCrtst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	*/
	public String getCRTST_CODIGO(){
		return this.myCrtst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	* @param inCgg_crtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	*/
	public void setCGG_CRTRA_CODIGO(String inCgg_crtra_codigo){
		this.myCgg_crtra_codigo = inCgg_crtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	*/
	public String getCGG_CRTRA_CODIGO(){
		return this.myCgg_crtra_codigo;
	}

	/**
	* ESTABLECE NUMERO DE RESIDENCIA
	* @param inCrrsd_numero NUMERO DE RESIDENCIA
	*/
	public void setCRRSD_NUMERO(int inCrrsd_numero){
		this.myCrrsd_numero = inCrrsd_numero;
	}
	/**
	* OBTIENE NUMERO DE RESIDENCIA
	* @return int NUMERO DE RESIDENCIA
	*/
	public int getCRRSD_NUMERO(){
		return this.myCrrsd_numero;
	}

	/**
	* ESTABLECE ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	* @param inCrrsd_modalidad ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	*/
	public void setCRRSD_MODALIDAD(int inCrrsd_modalidad){
		this.myCrrsd_modalidad = inCrrsd_modalidad;
	}
	/**
	* OBTIENE ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	* @return int ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	*/
	public int getCRRSD_MODALIDAD(){
		return this.myCrrsd_modalidad;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	* @param inCrrsd_fecha_inicio FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	*/
	public void setCRRSD_FECHA_INICIO(java.util.Date inCrrsd_fecha_inicio){
		this.myCrrsd_fecha_inicio = inCrrsd_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	* @return java.util.Date FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	*/
	public java.util.Date getCRRSD_FECHA_INICIO(){
		return this.myCrrsd_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	* @param inCrrsd_fecha_caducidad FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	*/
	public void setCRRSD_FECHA_CADUCIDAD(java.util.Date inCrrsd_fecha_caducidad){
		this.myCrrsd_fecha_caducidad = inCrrsd_fecha_caducidad;
	}
	/**
	* OBTIENE FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	* @return java.util.Date FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	*/
	public java.util.Date getCRRSD_FECHA_CADUCIDAD(){
		return this.myCrrsd_fecha_caducidad;
	}

	/**
	* ESTABLECE SI LA RESIDENCIA ESTA REVOCADA
	* @param inCrrsd_revocada SI LA RESIDENCIA ESTA REVOCADA
	*/
	public void setCRRSD_REVOCADA(boolean inCrrsd_revocada){
		this.myCrrsd_revocada = inCrrsd_revocada;
	}
	/**
	* OBTIENE SI LA RESIDENCIA ESTA REVOCADA
	* @return boolean SI LA RESIDENCIA ESTA REVOCADA
	*/
	public boolean getCRRSD_REVOCADA(){
		return this.myCrrsd_revocada;
	}

	/**
	* ESTABLECE FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	* @param inCrrsd_fecha_revocatoria FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	*/
	public void setCRRSD_FECHA_REVOCATORIA(java.util.Date inCrrsd_fecha_revocatoria){
		this.myCrrsd_fecha_revocatoria = inCrrsd_fecha_revocatoria;
	}
	/**
	* OBTIENE FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	* @return java.util.Date FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	*/
	public java.util.Date getCRRSD_FECHA_REVOCATORIA(){
		return this.myCrrsd_fecha_revocatoria;
	}

	/**
	* ESTABLECE DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	* @param inCrrsd_motivo_revocatoria DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	*/
	public void setCRRSD_MOTIVO_REVOCATORIA(String inCrrsd_motivo_revocatoria){
		this.myCrrsd_motivo_revocatoria = inCrrsd_motivo_revocatoria;
	}
	/**
	* OBTIENE DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	* @return String DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	*/
	public String getCRRSD_MOTIVO_REVOCATORIA(){
		return this.myCrrsd_motivo_revocatoria;
	}

	/**
	* ESTABLECE DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	* @param inCrrsd_vigente DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	*/
	public void setCRRSD_VIGENTE(boolean inCrrsd_vigente){
		this.myCrrsd_vigente = inCrrsd_vigente;
	}
	/**
	* OBTIENE DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	* @return boolean DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	*/
	public boolean getCRRSD_VIGENTE(){
		return this.myCrrsd_vigente;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	* @param inCrrsd_tramite_pendiente ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	*/
	public void setCRRSD_TRAMITE_PENDIENTE(boolean inCrrsd_tramite_pendiente){
		this.myCrrsd_tramite_pendiente = inCrrsd_tramite_pendiente;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	* @return boolean ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	*/
	public boolean getCRRSD_TRAMITE_PENDIENTE(){
		return this.myCrrsd_tramite_pendiente;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrrsd_estado ESTADO DEL REGISTRO
	*/
	public void setCRRSD_ESTADO(boolean inCrrsd_estado){
		this.myCrrsd_estado = inCrrsd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRRSD_ESTADO(){
		return this.myCrrsd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrrsd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRRSD_USUARIO_INSERT(String inCrrsd_usuario_insert){
		this.myCrrsd_usuario_insert = inCrrsd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRRSD_USUARIO_INSERT(){
		return this.myCrrsd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrrsd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRRSD_USUARIO_UPDATE(String inCrrsd_usuario_update){
		this.myCrrsd_usuario_update = inCrrsd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRRSD_USUARIO_UPDATE(){
		return this.myCrrsd_usuario_update;
	}

}
