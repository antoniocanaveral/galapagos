package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_seguimiento
* TABLA: SEGUIMIENTO
* DESCRIPCION:ALMACENA INFORMACION DEL SEGUIMIENTO QUE PUEDE DARSE A UN TRAMITE
* ABREVIATURA:CRSEG
*/
public class Cgg_res_seguimiento implements Serializable{
	private static final long serialVersionUID = 207443252;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	private String myCrseg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgg_crseg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrtra_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	*/
	private String myCrfas_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	*/
	private String myCgg_crfas_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* DESCRIPCION DEL SEGUIMIENTO
	*/
	private String myCrseg_descripcion;
	/**
	* VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	*/
	private int myCrseg_estado_atencion;
	/**
	* DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	*/
	private String myCrseg_observacion;
	/**
	* VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	*/
	private int myCrseg_tipo_respuesta;
	/**
	* ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	*/
	private String myCrseg_tipo_actividad;
	/**
	* FECHA DE RECEPCION DEL SEGUIMIENTO
	*/
	private java.util.Date myCrseg_fecha_recepcion;
	/**
	* FECHA DE REVISION DEL SEGUIMIENTO
	*/
	private java.util.Date myCrseg_fecha_revision;
	/**
	* FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	*/
	private java.util.Date myCrseg_fecha_despacho;
	/**
	* ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	*/
	private int myCrseg_estado_hijo;
	/**
	* FECHA DE REAPERTURA DEL SEGUIMIENTO
	*/
	private java.util.Date myCrseg_fecha_reapertura;
	/**
	* NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	*/
	private java.math.BigDecimal myCrseg_veces_revision;
	/**
	* NUMERO ASIGNADO AL SEGUIMIENTO
	*/
	private java.math.BigDecimal myCrseg_numero;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrseg_estado;
	/**
	* USUARIO QUE REGISTRO LA INFORMACION
	*/
	private String myCrseg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrseg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_seguimiento
	*/
	public Cgg_res_seguimiento(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_seguimiento
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCgg_crseg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	* @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCrseg_descripcion DESCRIPCION DEL SEGUIMIENTO
	* @param inCrseg_estado_atencion VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	* @param inCrseg_observacion DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	* @param inCrseg_tipo_respuesta VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	* @param inCrseg_tipo_actividad ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	* @param inCrseg_fecha_recepcion FECHA DE RECEPCION DEL SEGUIMIENTO
	* @param inCrseg_fecha_revision FECHA DE REVISION DEL SEGUIMIENTO
	* @param inCrseg_fecha_despacho FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	* @param inCrseg_estado_hijo ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	* @param inCrseg_fecha_reapertura FECHA DE REAPERTURA DEL SEGUIMIENTO
	* @param inCrseg_veces_revision NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	* @param inCrseg_numero NUMERO ASIGNADO AL SEGUIMIENTO
	* @param inCrseg_estado ESTADO DEL REGISTRO
	* @param inCrseg_usuario_insert USUARIO QUE REGISTRO LA INFORMACION
	* @param inCrseg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_seguimiento(
		String inCrseg_codigo,
		String inCgg_crseg_codigo,
		String inCrtra_codigo,
		String inCrfas_codigo,
		String inCgg_crfas_codigo,
		String inCusu_codigo,
		String inCrseg_descripcion,
		int inCrseg_estado_atencion,
		String inCrseg_observacion,
		int inCrseg_tipo_respuesta,
		String inCrseg_tipo_actividad,
		java.util.Date inCrseg_fecha_recepcion,
		java.util.Date inCrseg_fecha_revision,
		java.util.Date inCrseg_fecha_despacho,
		int inCrseg_estado_hijo,
		java.util.Date inCrseg_fecha_reapertura,
		java.math.BigDecimal inCrseg_veces_revision,
		java.math.BigDecimal inCrseg_numero,
		boolean inCrseg_estado,
		String inCrseg_usuario_insert,
		String inCrseg_usuario_update
	){
		this.setCRSEG_CODIGO(inCrseg_codigo);
		this.setCGG_CRSEG_CODIGO(inCgg_crseg_codigo);
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCRFAS_CODIGO(inCrfas_codigo);
		this.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCRSEG_DESCRIPCION(inCrseg_descripcion);
		this.setCRSEG_ESTADO_ATENCION(inCrseg_estado_atencion);
		this.setCRSEG_OBSERVACION(inCrseg_observacion);
		this.setCRSEG_TIPO_RESPUESTA(inCrseg_tipo_respuesta);
		this.setCRSEG_TIPO_ACTIVIDAD(inCrseg_tipo_actividad);
		this.setCRSEG_FECHA_RECEPCION(inCrseg_fecha_recepcion);
		this.setCRSEG_FECHA_REVISION(inCrseg_fecha_revision);
		this.setCRSEG_FECHA_DESPACHO(inCrseg_fecha_despacho);
		this.setCRSEG_ESTADO_HIJO(inCrseg_estado_hijo);
		this.setCRSEG_FECHA_REAPERTURA(inCrseg_fecha_reapertura);
		this.setCRSEG_VECES_REVISION(inCrseg_veces_revision);
		this.setCRSEG_NUMERO(inCrseg_numero);
		this.setCRSEG_ESTADO(inCrseg_estado);
		this.setCRSEG_USUARIO_INSERT(inCrseg_usuario_insert);
		this.setCRSEG_USUARIO_UPDATE(inCrseg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	public void setCRSEG_CODIGO(String inCrseg_codigo){
		this.myCrseg_codigo = inCrseg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	public String getCRSEG_CODIGO(){
		return this.myCrseg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgg_crseg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGG_CRSEG_CODIGO(String inCgg_crseg_codigo){
		this.myCgg_crseg_codigo = inCgg_crseg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGG_CRSEG_CODIGO(){
		return this.myCgg_crseg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	* @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	*/
	public void setCRFAS_CODIGO(String inCrfas_codigo){
		this.myCrfas_codigo = inCrfas_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	*/
	public String getCRFAS_CODIGO(){
		return this.myCrfas_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	* @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	*/
	public void setCGG_CRFAS_CODIGO(String inCgg_crfas_codigo){
		this.myCgg_crfas_codigo = inCgg_crfas_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	*/
	public String getCGG_CRFAS_CODIGO(){
		return this.myCgg_crfas_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL SEGUIMIENTO
	* @param inCrseg_descripcion DESCRIPCION DEL SEGUIMIENTO
	*/
	public void setCRSEG_DESCRIPCION(String inCrseg_descripcion){
		this.myCrseg_descripcion = inCrseg_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL SEGUIMIENTO
	* @return String DESCRIPCION DEL SEGUIMIENTO
	*/
	public String getCRSEG_DESCRIPCION(){
		return this.myCrseg_descripcion;
	}

	/**
	* ESTABLECE VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	* @param inCrseg_estado_atencion VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	*/
	public void setCRSEG_ESTADO_ATENCION(int inCrseg_estado_atencion){
		this.myCrseg_estado_atencion = inCrseg_estado_atencion;
	}
	/**
	* OBTIENE VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	* @return int VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	*/
	public int getCRSEG_ESTADO_ATENCION(){
		return this.myCrseg_estado_atencion;
	}

	/**
	* ESTABLECE DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	* @param inCrseg_observacion DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	*/
	public void setCRSEG_OBSERVACION(String inCrseg_observacion){
		this.myCrseg_observacion = inCrseg_observacion;
	}
	/**
	* OBTIENE DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	* @return String DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	*/
	public String getCRSEG_OBSERVACION(){
		return this.myCrseg_observacion;
	}

	/**
	* ESTABLECE VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	* @param inCrseg_tipo_respuesta VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	*/
	public void setCRSEG_TIPO_RESPUESTA(int inCrseg_tipo_respuesta){
		this.myCrseg_tipo_respuesta = inCrseg_tipo_respuesta;
	}
	/**
	* OBTIENE VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	* @return int VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	*/
	public int getCRSEG_TIPO_RESPUESTA(){
		return this.myCrseg_tipo_respuesta;
	}

	/**
	* ESTABLECE ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	* @param inCrseg_tipo_actividad ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	*/
	public void setCRSEG_TIPO_ACTIVIDAD(String inCrseg_tipo_actividad){
		this.myCrseg_tipo_actividad = inCrseg_tipo_actividad;
	}
	/**
	* OBTIENE ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	* @return String ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	*/
	public String getCRSEG_TIPO_ACTIVIDAD(){
		return this.myCrseg_tipo_actividad;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DEL SEGUIMIENTO
	* @param inCrseg_fecha_recepcion FECHA DE RECEPCION DEL SEGUIMIENTO
	*/
	public void setCRSEG_FECHA_RECEPCION(java.util.Date inCrseg_fecha_recepcion){
		this.myCrseg_fecha_recepcion = inCrseg_fecha_recepcion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DEL SEGUIMIENTO
	* @return java.util.Date FECHA DE RECEPCION DEL SEGUIMIENTO
	*/
	public java.util.Date getCRSEG_FECHA_RECEPCION(){
		return this.myCrseg_fecha_recepcion;
	}

	/**
	* ESTABLECE FECHA DE REVISION DEL SEGUIMIENTO
	* @param inCrseg_fecha_revision FECHA DE REVISION DEL SEGUIMIENTO
	*/
	public void setCRSEG_FECHA_REVISION(java.util.Date inCrseg_fecha_revision){
		this.myCrseg_fecha_revision = inCrseg_fecha_revision;
	}
	/**
	* OBTIENE FECHA DE REVISION DEL SEGUIMIENTO
	* @return java.util.Date FECHA DE REVISION DEL SEGUIMIENTO
	*/
	public java.util.Date getCRSEG_FECHA_REVISION(){
		return this.myCrseg_fecha_revision;
	}

	/**
	* ESTABLECE FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	* @param inCrseg_fecha_despacho FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	*/
	public void setCRSEG_FECHA_DESPACHO(java.util.Date inCrseg_fecha_despacho){
		this.myCrseg_fecha_despacho = inCrseg_fecha_despacho;
	}
	/**
	* OBTIENE FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	* @return java.util.Date FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	*/
	public java.util.Date getCRSEG_FECHA_DESPACHO(){
		return this.myCrseg_fecha_despacho;
	}

	/**
	* ESTABLECE ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	* @param inCrseg_estado_hijo ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	*/
	public void setCRSEG_ESTADO_HIJO(int inCrseg_estado_hijo){
		this.myCrseg_estado_hijo = inCrseg_estado_hijo;
	}
	/**
	* OBTIENE ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	* @return int ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	*/
	public int getCRSEG_ESTADO_HIJO(){
		return this.myCrseg_estado_hijo;
	}

	/**
	* ESTABLECE FECHA DE REAPERTURA DEL SEGUIMIENTO
	* @param inCrseg_fecha_reapertura FECHA DE REAPERTURA DEL SEGUIMIENTO
	*/
	public void setCRSEG_FECHA_REAPERTURA(java.util.Date inCrseg_fecha_reapertura){
		this.myCrseg_fecha_reapertura = inCrseg_fecha_reapertura;
	}
	/**
	* OBTIENE FECHA DE REAPERTURA DEL SEGUIMIENTO
	* @return java.util.Date FECHA DE REAPERTURA DEL SEGUIMIENTO
	*/
	public java.util.Date getCRSEG_FECHA_REAPERTURA(){
		return this.myCrseg_fecha_reapertura;
	}

	/**
	* ESTABLECE NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	* @param inCrseg_veces_revision NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	*/
	public void setCRSEG_VECES_REVISION(java.math.BigDecimal inCrseg_veces_revision){
		this.myCrseg_veces_revision = inCrseg_veces_revision;
	}
	/**
	* OBTIENE NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	* @return java.math.BigDecimal NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	*/
	public java.math.BigDecimal getCRSEG_VECES_REVISION(){
		return this.myCrseg_veces_revision;
	}

	/**
	* ESTABLECE NUMERO ASIGNADO AL SEGUIMIENTO
	* @param inCrseg_numero NUMERO ASIGNADO AL SEGUIMIENTO
	*/
	public void setCRSEG_NUMERO(java.math.BigDecimal inCrseg_numero){
		this.myCrseg_numero = inCrseg_numero;
	}
	/**
	* OBTIENE NUMERO ASIGNADO AL SEGUIMIENTO
	* @return java.math.BigDecimal NUMERO ASIGNADO AL SEGUIMIENTO
	*/
	public java.math.BigDecimal getCRSEG_NUMERO(){
		return this.myCrseg_numero;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrseg_estado ESTADO DEL REGISTRO
	*/
	public void setCRSEG_ESTADO(boolean inCrseg_estado){
		this.myCrseg_estado = inCrseg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRSEG_ESTADO(){
		return this.myCrseg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE REGISTRO LA INFORMACION
	* @param inCrseg_usuario_insert USUARIO QUE REGISTRO LA INFORMACION
	*/
	public void setCRSEG_USUARIO_INSERT(String inCrseg_usuario_insert){
		this.myCrseg_usuario_insert = inCrseg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE REGISTRO LA INFORMACION
	* @return String USUARIO QUE REGISTRO LA INFORMACION
	*/
	public String getCRSEG_USUARIO_INSERT(){
		return this.myCrseg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrseg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRSEG_USUARIO_UPDATE(String inCrseg_usuario_update){
		this.myCrseg_usuario_update = inCrseg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRSEG_USUARIO_UPDATE(){
		return this.myCrseg_usuario_update;
	}

}
