package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_resolucion
* TABLA: RESOLUCION
* DESCRIPCION:ALMACENA INFORMACION DE LAS RESOLUCIONES GENERADAS EN LAS SESIONES DE COMITE
* ABREVIATURA:CRRES
*/
public class Cgg_res_resolucion implements Serializable{
	private static final long serialVersionUID = 429099974;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* NUMERO DE TRAMITE
	*/
	private int myNumero;
	/**
	* IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	private String myCrssc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGIsTRO DEL MIEMBRO COMITE
	*/
	private String myCrsmb_codigo;
	/**
	* NUMERO DE SESION
	*/
	private String myNumero_Sesion;
	/**
	* NUMERO IDENTIFICATIVO DE LA RESOLUCION
	*/
	private String myCrres_numero_resolucion;
	/**
	* TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	*/
	private int myCrres_tipo;
	/**
	* OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	*/
	private String myCrres_observaciones;
	/**
	* RESUMEN DEL CONTENIDO DE LA RESOLUCION
	*/
	private String myCrres_extracto_resolucion;
	/**
	* NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	*/
	private int myCrres_votos_aprobacion;
	/**
	* NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	*/
	private int myCrres_votos_negacion;
	/**
	* NUMERO DE VOTOS DE ABSTENCION
	*/
	private int myCrres_votos_abstencion;
	/**
	* FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	*/
	private java.util.Date myCrres_fecha_emision;
	/**
	* FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	*/
	private java.util.Date myCrres_fecha_ejecucion;
	/**
	* FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	*/
	private java.util.Date myCrres_fecha_anulacion;
	/**
	* FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA.
	*/
	private java.util.Date myCrres_fecha_confirmacion;
	/**
	* RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	*/
	private String myCrres_resolucion_reemplaza;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCrres_nombre_adjunto_resol;
	/**
	* ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	*/
	private byte[] myCrres_adjunto_resolucion;
	/**
	* DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	*/
	private String myCrres_descripcion_adjunto;
	/**
	* FECHA DE APELACION A LA RESOLUCION
	*/
	private java.util.Date myCrres_fecha_apelacion;
	/**
	* EXTRACTO DE LA APELACION
	*/
	private String myCrres_extracto_apelacion;
	/**
	* NUMERO DE DOCUMENTO DE APELACION
	*/
	private String myCrres_numero_apelacion;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCrres_nombre_adjunto_apelac;
	/**
	* ARCHIVO ADJUNTO A LA APELACION
	*/
	private byte[] myCrres_adjunto_apelacion;
	/**
	* ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	*/
	private int myCrres_estado_resolucion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrres_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrres_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrres_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_resolucion
	*/
	public Cgg_res_resolucion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_resolucion
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inCrres_numero_resolucion NUMERO IDENTIFICATIVO DE LA RESOLUCION
	* @param inCrres_tipo TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	* @param inCrres_observaciones OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	* @param inCrres_extracto_resolucion RESUMEN DEL CONTENIDO DE LA RESOLUCION
	* @param inCrres_votos_aprobacion NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	* @param inCrres_votos_negacion NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	* @param inCrres_votos_abstencion NUMERO DE VOTOS DE ABSTENCION
	* @param inCrres_fecha_emision FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	* @param inCrres_fecha_ejecucion FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	* @param inCrres_fecha_anulacion FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	* @param inCrres_fecha_confirmacion FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA.
	* @param inCrres_resolucion_reemplaza RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	* @param inCrres_nombre_adjunto_resol NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrres_adjunto_resolucion ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	* @param inCrres_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	* @param inCrres_fecha_apelacion FECHA DE APELACION A LA RESOLUCION
	* @param inCrres_extracto_apelacion EXTRACTO DE LA APELACION
	* @param inCrres_numero_apelacion NUMERO DE DOCUMENTO DE APELACION
	* @param inCrres_nombre_adjunto_apelac NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrres_adjunto_apelacion ARCHIVO ADJUNTO A LA APELACION
	* @param inCrres_estado_resolucion ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	* @param inCrres_estado ESTADO DEL REGISTRO
	* @param inCrres_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrres_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_resolucion(
		String inCrres_codigo,
		String inCrssc_codigo,
		String inCrres_numero_resolucion,
		int inCrres_tipo,
		String inCrres_observaciones,
		String inCrres_extracto_resolucion,
		int inCrres_votos_aprobacion,
		int inCrres_votos_negacion,
		int inCrres_votos_abstencion,
		java.util.Date inCrres_fecha_emision,
		java.util.Date inCrres_fecha_ejecucion,
		java.util.Date inCrres_fecha_anulacion,
		java.util.Date inCrres_fecha_confirmacion,
		String inCrres_resolucion_reemplaza,
		String inCrres_nombre_adjunto_resol,
		byte[] inCrres_adjunto_resolucion,
		String inCrres_descripcion_adjunto,
		java.util.Date inCrres_fecha_apelacion,
		String inCrres_extracto_apelacion,
		String inCrres_numero_apelacion,
		String inCrres_nombre_adjunto_apelac,
		byte[] inCrres_adjunto_apelacion,
		int inCrres_estado_resolucion,
		boolean inCrres_estado,
		String inCrres_usuario_insert,
		String inCrres_usuario_update
	){
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCRSSC_CODIGO(inCrssc_codigo);
		this.setCRRES_NUMERO_RESOLUCION(inCrres_numero_resolucion);
		this.setCRRES_TIPO(inCrres_tipo);
		this.setCRRES_OBSERVACIONES(inCrres_observaciones);
		this.setCRRES_EXTRACTO_RESOLUCION(inCrres_extracto_resolucion);
		this.setCRRES_VOTOS_APROBACION(inCrres_votos_aprobacion);
		this.setCRRES_VOTOS_NEGACION(inCrres_votos_negacion);
		this.setCRRES_VOTOS_ABSTENCION(inCrres_votos_abstencion);
		this.setCRRES_FECHA_EMISION(inCrres_fecha_emision);
		this.setCRRES_FECHA_EJECUCION(inCrres_fecha_ejecucion);
		this.setCRRES_FECHA_ANULACION(inCrres_fecha_anulacion);
		this.setCRRES_FECHA_CONFIRMACION(inCrres_fecha_confirmacion);
		this.setCRRES_RESOLUCION_REEMPLAZA(inCrres_resolucion_reemplaza);
		this.setCRRES_NOMBRE_ADJUNTO_RESOL(inCrres_nombre_adjunto_resol);
		this.setCRRES_ADJUNTO_RESOLUCION(inCrres_adjunto_resolucion);
		this.setCRRES_DESCRIPCION_ADJUNTO(inCrres_descripcion_adjunto);
		this.setCRRES_FECHA_APELACION(inCrres_fecha_apelacion);
		this.setCRRES_EXTRACTO_APELACION(inCrres_extracto_apelacion);
		this.setCRRES_NUMERO_APELACION(inCrres_numero_apelacion);
		this.setCRRES_NOMBRE_ADJUNTO_APELAC(inCrres_nombre_adjunto_apelac);
		this.setCRRES_ADJUNTO_APELACION(inCrres_adjunto_apelacion);
		this.setCRRES_ESTADO_RESOLUCION(inCrres_estado_resolucion);
		this.setCRRES_ESTADO(inCrres_estado);
		this.setCRRES_USUARIO_INSERT(inCrres_usuario_insert);
		this.setCRRES_USUARIO_UPDATE(inCrres_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public void setCRRES_CODIGO(String inCrres_codigo){
		this.myCrres_codigo = inCrres_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public String getCRRES_CODIGO(){
		return this.myCrres_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	public void setCRSSC_CODIGO(String inCrssc_codigo){
		this.myCrssc_codigo = inCrssc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @return String IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	public String getCRSSC_CODIGO(){
		return this.myCrssc_codigo;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inNumero_Sesion IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	public void setNUMERO_SESION(String inNumero_Sesion){
		this.myNumero_Sesion = inNumero_Sesion;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @return String IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	public String getNUMERO_SESION(){
		return this.myNumero_Sesion;
	}
	/**
	* ESTABLECE NUMERO DE TRAMITE
	* @param inNumero NUMERO DE TRAMITE
	*/
	public void setNUMERO(int inNumero){
		this.myNumero = inNumero;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public int getNUMERO(){
		return this.myNumero;
	}
	
	/**
	* ESTABLECE NUMERO IDENTIFICATIVO DE LA RESOLUCION
	* @param inCrres_numero_resolucion NUMERO IDENTIFICATIVO DE LA RESOLUCION
	*/
	public void setCRRES_NUMERO_RESOLUCION(String inCrres_numero_resolucion){
		this.myCrres_numero_resolucion = inCrres_numero_resolucion;
	}
	/**
	* OBTIENE NUMERO IDENTIFICATIVO DE LA RESOLUCION
	* @return String NUMERO IDENTIFICATIVO DE LA RESOLUCION
	*/
	public String getCRRES_NUMERO_RESOLUCION(){
		return this.myCrres_numero_resolucion;
	}

	/**
	* ESTABLECE TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	* @param inCrres_tipo TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	*/
	public void setCRRES_TIPO(int inCrres_tipo){
		this.myCrres_tipo = inCrres_tipo;
	}
	/**
	* OBTIENE TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	* @return int TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	*/
	public int getCRRES_TIPO(){
		return this.myCrres_tipo;
	}

	/**
	* ESTABLECE OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	* @param inCrres_observaciones OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	*/
	public void setCRRES_OBSERVACIONES(String inCrres_observaciones){
		this.myCrres_observaciones = inCrres_observaciones;
	}
	/**
	* OBTIENE OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	* @return String OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	*/
	public String getCRRES_OBSERVACIONES(){
		return this.myCrres_observaciones;
	}

	/**
	* ESTABLECE RESUMEN DEL CONTENIDO DE LA RESOLUCION
	* @param inCrres_extracto_resolucion RESUMEN DEL CONTENIDO DE LA RESOLUCION
	*/
	public void setCRRES_EXTRACTO_RESOLUCION(String inCrres_extracto_resolucion){
		this.myCrres_extracto_resolucion = inCrres_extracto_resolucion;
	}
	/**
	* OBTIENE RESUMEN DEL CONTENIDO DE LA RESOLUCION
	* @return String RESUMEN DEL CONTENIDO DE LA RESOLUCION
	*/
	public String getCRRES_EXTRACTO_RESOLUCION(){
		return this.myCrres_extracto_resolucion;
	}

	/**
	* ESTABLECE NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	* @param inCrres_votos_aprobacion NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	*/
	public void setCRRES_VOTOS_APROBACION(int inCrres_votos_aprobacion){
		this.myCrres_votos_aprobacion = inCrres_votos_aprobacion;
	}
	/**
	* OBTIENE NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	* @return int NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	*/
	public int getCRRES_VOTOS_APROBACION(){
		return this.myCrres_votos_aprobacion;
	}

	/**
	* ESTABLECE NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	* @param inCrres_votos_negacion NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	*/
	public void setCRRES_VOTOS_NEGACION(int inCrres_votos_negacion){
		this.myCrres_votos_negacion = inCrres_votos_negacion;
	}
	/**
	* OBTIENE NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	* @return int NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	*/
	public int getCRRES_VOTOS_NEGACION(){
		return this.myCrres_votos_negacion;
	}

	/**
	* ESTABLECE NUMERO DE VOTOS DE ABSTENCION
	* @param inCrres_votos_abstencion NUMERO DE VOTOS DE ABSTENCION
	*/
	public void setCRRES_VOTOS_ABSTENCION(int inCrres_votos_abstencion){
		this.myCrres_votos_abstencion = inCrres_votos_abstencion;
	}
	/**
	* OBTIENE NUMERO DE VOTOS DE ABSTENCION
	* @return int NUMERO DE VOTOS DE ABSTENCION
	*/
	public int getCRRES_VOTOS_ABSTENCION(){
		return this.myCrres_votos_abstencion;
	}

	/**
	* ESTABLECE FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	* @param inCrres_fecha_emision FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	*/
	public void setCRRES_FECHA_EMISION(java.util.Date inCrres_fecha_emision){
		this.myCrres_fecha_emision = inCrres_fecha_emision;
	}
	/**
	* OBTIENE FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	* @return java.util.Date FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	*/
	public java.util.Date getCRRES_FECHA_EMISION(){
		return this.myCrres_fecha_emision;
	}

	/**
	* ESTABLECE FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	* @param inCrres_fecha_ejecucion FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	*/
	public void setCRRES_FECHA_EJECUCION(java.util.Date inCrres_fecha_ejecucion){
		this.myCrres_fecha_ejecucion = inCrres_fecha_ejecucion;
	}
	/**
	* OBTIENE FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	* @return java.util.Date FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	*/
	public java.util.Date getCRRES_FECHA_EJECUCION(){
		return this.myCrres_fecha_ejecucion;
	}

	/**
	* ESTABLECE FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	* @param inCrres_fecha_anulacion FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	*/
	public void setCRRES_FECHA_ANULACION(java.util.Date inCrres_fecha_anulacion){
		this.myCrres_fecha_anulacion = inCrres_fecha_anulacion;
	}
	/**
	* OBTIENE FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	* @return java.util.Date FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	*/
	public java.util.Date getCRRES_FECHA_ANULACION(){
		return this.myCrres_fecha_anulacion;
	}

	/**
	* ESTABLECE FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA.
	* @param inCrres_fecha_confirmacion FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA.
	*/
	public void setCRRES_FECHA_CONFIRMACION(java.util.Date inCrres_fecha_confirmacion){
		this.myCrres_fecha_confirmacion = inCrres_fecha_confirmacion;
	}
	/**
	* OBTIENE FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA.
	* @return java.util.Date FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA.
	*/
	public java.util.Date getCRRES_FECHA_CONFIRMACION(){
		return this.myCrres_fecha_confirmacion;
	}

	/**
	* ESTABLECE RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	* @param inCrres_resolucion_reemplaza RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	*/
	public void setCRRES_RESOLUCION_REEMPLAZA(String inCrres_resolucion_reemplaza){
		this.myCrres_resolucion_reemplaza = inCrres_resolucion_reemplaza;
	}
	/**
	* OBTIENE RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	* @return String RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	*/
	public String getCRRES_RESOLUCION_REEMPLAZA(){
		return this.myCrres_resolucion_reemplaza;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrres_nombre_adjunto_resol NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCRRES_NOMBRE_ADJUNTO_RESOL(String inCrres_nombre_adjunto_resol){
		this.myCrres_nombre_adjunto_resol = inCrres_nombre_adjunto_resol;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCRRES_NOMBRE_ADJUNTO_RESOL(){
		return this.myCrres_nombre_adjunto_resol;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	* @param inCrres_adjunto_resolucion ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	*/
	public void setCRRES_ADJUNTO_RESOLUCION(byte[] inCrres_adjunto_resolucion){
		this.myCrres_adjunto_resolucion = inCrres_adjunto_resolucion;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	* @return byte[] ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	*/
	public byte[] getCRRES_ADJUNTO_RESOLUCION(){
		return this.myCrres_adjunto_resolucion;
	}

	/**
	* ESTABLECE DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	* @param inCrres_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	*/
	public void setCRRES_DESCRIPCION_ADJUNTO(String inCrres_descripcion_adjunto){
		this.myCrres_descripcion_adjunto = inCrres_descripcion_adjunto;
	}
	/**
	* OBTIENE DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	* @return String DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	*/
	public String getCRRES_DESCRIPCION_ADJUNTO(){
		return this.myCrres_descripcion_adjunto;
	}

	/**
	* ESTABLECE FECHA DE APELACION A LA RESOLUCION
	* @param inCrres_fecha_apelacion FECHA DE APELACION A LA RESOLUCION
	*/
	public void setCRRES_FECHA_APELACION(java.util.Date inCrres_fecha_apelacion){
		this.myCrres_fecha_apelacion = inCrres_fecha_apelacion;
	}
	/**
	* OBTIENE FECHA DE APELACION A LA RESOLUCION
	* @return java.util.Date FECHA DE APELACION A LA RESOLUCION
	*/
	public java.util.Date getCRRES_FECHA_APELACION(){
		return this.myCrres_fecha_apelacion;
	}

	/**
	* ESTABLECE EXTRACTO DE LA APELACION
	* @param inCrres_extracto_apelacion EXTRACTO DE LA APELACION
	*/
	public void setCRRES_EXTRACTO_APELACION(String inCrres_extracto_apelacion){
		this.myCrres_extracto_apelacion = inCrres_extracto_apelacion;
	}
	/**
	* OBTIENE EXTRACTO DE LA APELACION
	* @return String EXTRACTO DE LA APELACION
	*/
	public String getCRRES_EXTRACTO_APELACION(){
		return this.myCrres_extracto_apelacion;
	}

	/**
	* ESTABLECE NUMERO DE DOCUMENTO DE APELACION
	* @param inCrres_numero_apelacion NUMERO DE DOCUMENTO DE APELACION
	*/
	public void setCRRES_NUMERO_APELACION(String inCrres_numero_apelacion){
		this.myCrres_numero_apelacion = inCrres_numero_apelacion;
	}
	/**
	* OBTIENE NUMERO DE DOCUMENTO DE APELACION
	* @return String NUMERO DE DOCUMENTO DE APELACION
	*/
	public String getCRRES_NUMERO_APELACION(){
		return this.myCrres_numero_apelacion;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrres_nombre_adjunto_apelac NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCRRES_NOMBRE_ADJUNTO_APELAC(String inCrres_nombre_adjunto_apelac){
		this.myCrres_nombre_adjunto_apelac = inCrres_nombre_adjunto_apelac;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCRRES_NOMBRE_ADJUNTO_APELAC(){
		return this.myCrres_nombre_adjunto_apelac;
	}

	/**
	* ESTABLECE ARCHIVO ADJUNTO A LA APELACION
	* @param inCrres_adjunto_apelacion ARCHIVO ADJUNTO A LA APELACION
	*/
	public void setCRRES_ADJUNTO_APELACION(byte[] inCrres_adjunto_apelacion){
		this.myCrres_adjunto_apelacion = inCrres_adjunto_apelacion;
	}
	/**
	* OBTIENE ARCHIVO ADJUNTO A LA APELACION
	* @return byte[] ARCHIVO ADJUNTO A LA APELACION
	*/
	public byte[] getCRRES_ADJUNTO_APELACION(){
		return this.myCrres_adjunto_apelacion;
	}

	/**
	* ESTABLECE ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	* @param inCrres_estado_resolucion ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	*/
	public void setCRRES_ESTADO_RESOLUCION(int inCrres_estado_resolucion){
		this.myCrres_estado_resolucion = inCrres_estado_resolucion;
	}
	/**
	* OBTIENE ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	* @return int ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	*/
	public int getCRRES_ESTADO_RESOLUCION(){
		return this.myCrres_estado_resolucion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrres_estado ESTADO DEL REGISTRO
	*/
	public void setCRRES_ESTADO(boolean inCrres_estado){
		this.myCrres_estado = inCrres_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRRES_ESTADO(){
		return this.myCrres_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrres_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRRES_USUARIO_INSERT(String inCrres_usuario_insert){
		this.myCrres_usuario_insert = inCrres_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRRES_USUARIO_INSERT(){
		return this.myCrres_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrres_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRRES_USUARIO_UPDATE(String inCrres_usuario_update){
		this.myCrres_usuario_update = inCrres_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRRES_USUARIO_UPDATE(){
		return this.myCrres_usuario_update;
	}
	/**
	* ESTABLECE EL CODIGO DEL MIEMBRO DEL COMITE
	* @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	*/
	public void setCRSMB_CODIGO(String inCrsmb_codigo){
		this.myCrsmb_codigo = inCrsmb_codigo;
	}
	/**
	* OBTIENE EL CODIGO DEL MIEMBRO DEL COMITE
	* @return String EL CODIGO DEL MIEMBRO DEL COMITE
	*/
	public String getCRSMB_CODIGO(){
		return this.myCrsmb_codigo;
	}

}
