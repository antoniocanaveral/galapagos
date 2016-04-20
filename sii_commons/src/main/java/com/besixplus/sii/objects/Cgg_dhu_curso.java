package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_curso
* TABLA: CURSO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CURSOS DE CAPACITACION, FORMACION E INDUCCION PARA RESIDENTES ADMINSITRADOS POR DESARROLLO HUMANO PARA LA COMUNIDAD
* ABREVIATURA:CDCUR
*/
public class Cgg_dhu_curso implements Serializable{
	private static final long serialVersionUID = 817192115;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	private String myCdcur_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	*/
	private String myCdtcr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	*/
	private String myCditr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
	*/
	private String myCrper_codigo;
	/**
	* DESCRIPCION DEL CURSO
	*/
	private String myCdcur_descripcion;
	/**
	* FECHA PREVISTA DE INICIO DEL CURSO
	*/
	private java.util.Date myCdcur_fecha_prevista_inicio;
	/**
	/**
	* FECHA DE INICIO DEL CURSO
	*/
	private java.util.Date myCdcur_fecha_inicio;
	/**
	* FECHA DE FINALIZACION DEL CURSO
	*/
	private java.util.Date myCdcur_fecha_culminacion;
	/**
	* FECHA PREVISTA DE FINALIZACION DEL CURSO
	*/
	private java.util.Date myCdcur_fecha_prevista_culminacion;
	/**
	* HORARIO DEL CURSO
	*/
	private String myCdcur_horario;
	/**
	* HORARIO1 DEL CURSO
	*/
	private String myCdcur_horario1;
	/**
	* NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
	*/
	private int myCdcur_numero_horas_pedagogicas;
	/**
	* NUMERO DE HORAS RELOJ DE DURACION
	*/
	private int myCdcur_numero_horas;
	/**
	* MODULOS DEL CURSO
	*/
	private int myCdcur_numero_modulos;
	/**
	* CONTENIDO DEL CURSO
	*/
	private String myCdcur_contenido;
	/**
	* NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
	*/
	private String myCdcur_institucion;
	/**
	* LUGAR DONDE SE REALIZA EL CURSO
	*/
	private String myCdcur_establecimiento;
	/**
	* COSTO DEL CURSO
	*/
	private java.math.BigDecimal myCdcur_costo;
	/**
	* PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
	*/
	private java.math.BigDecimal myCdcur_porcentaje_financiado;
	/**
	* OBSERVACION DEL CURSO
	*/
	private String myCdcur_observacion;
	/**
	* PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	*/
	private int myCdcur_valoracion;
	/**
	* NUMERO DE ASISTENTES RESPECTO AL CURSO
	*/
	private int myCdcur_numero_asistente;
	/**
	* ESTADO PROPIOS DEL CURSO
0 - REGISTRADO
1 - PROCESO MATRICULA
2 - INICIADO
3 - FINALIZADO
4 - SUSPENDIDO
5 - CANCELADO
	*/
	private int myCdcur_estado_curso;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdcur_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdcur_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdcur_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_curso
	*/
	public Cgg_dhu_curso(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_curso
	* @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @param inCditr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
	* @param inCdcur_descripcion DESCRIPCION DEL CURSO
	* @param inCdcur_fecha_prevista_inicio FECHA PREVISTA DE INICIO DEL CURSO
	* @param inCdcur_fecha_inicio FECHA DE INICIO DEL CURSO
	* @param inCdcur_fecha_culminacion FECHA DE FINALIZACION DEL CURSO
	* @param inCdcur_fecha_prevista_culminacion FECHA PREVISTA DE FINALIZACION DEL CURSO
	* @param inCdcur_horario HORARIO DEL CURSO
	* @param inCdcur_horario1 HORARIO DEL CURSO
	* @param inCdcur_numero_horas_pedagogicas NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
	* @param inCdcur_numero_horas NUMERO DE HORAS RELOJ DE DURACION
	* @param inCdcur_numero_modulos MODULOS DEL CURSO
	* @param inCdcur_contenido CONTENIDO DEL CURSO
	* @param inCdcur_institucion NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
	* @param inCdcur_establecimiento LUGAR DONDE SE REALIZA EL CURSO
	* @param inCdcur_costo COSTO DEL CURSO
	* @param inCdcur_porcentaje_financiado PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
	* @param inCdcur_observacion OBSERVACION DEL CURSO
	* @param inCdcur_valoracion PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	* @param inCdcur_numero_asistente NUMERO DE ASISTENTE DEL CURSO
	* @param inCdcur_estado_curso ESTADO PROPIOS DEL CURSO
0 - REGISTRADO
1 - PROCESO MATRICULA
2 - INICIADO
3 - FINALIZADO
4 - SUSPENDIDO
5 - CANCELADO
	* @param inCdcur_estado ESTADO DEL REGISTRO
	* @param inCdcur_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcur_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_curso(
		String inCdcur_codigo,
		String inCdtcr_codigo,
		String inCctn_codigo,
		String inCsctp_codigo,
		String inCditr_codigo,
		String inCrper_codigo,
		String inCdcur_descripcion,
		java.util.Date inCdcur_fecha_prevista_inicio,
		java.util.Date inCdcur_fecha_inicio,
		java.util.Date inCdcur_fecha_culminacion,
		java.util.Date inCdcur_fecha_prevista_culminacion,
		String inCdcur_horario,
		String inCdcur_horario1,
		int inCdcur_numero_horas_pedagogicas,
		int inCdcur_numero_horas,
		int inCdcur_numero_modulos,
		String inCdcur_contenido,
		String inCdcur_institucion,
		String inCdcur_establecimiento,
		java.math.BigDecimal inCdcur_costo,
		java.math.BigDecimal inCdcur_porcentaje_financiado,
		String inCdcur_observacion,
		int inCdcur_valoracion,
		int inCdcur_numero_asistente,
		int inCdcur_estado_curso,
		boolean inCdcur_estado,
		String inCdcur_usuario_insert,
		String inCdcur_usuario_update
	){
		this.setCDCUR_CODIGO(inCdcur_codigo);
		this.setCDTCR_CODIGO(inCdtcr_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCDITR_CODIGO(inCditr_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCDCUR_DESCRIPCION(inCdcur_descripcion);
		this.setCDCUR_FECHA_PREVISTA_INICIO(inCdcur_fecha_prevista_inicio);
		this.setCDCUR_FECHA_INICIO(inCdcur_fecha_inicio);
		this.setCDCUR_FECHA_CULMINACION(inCdcur_fecha_culminacion);
		this.setCDCUR_FECHA_PREVISTA_CULMINACION(inCdcur_fecha_prevista_culminacion);
		this.setCDCUR_HORARIO(inCdcur_horario);
		this.setCDCUR_HORARIO1(inCdcur_horario1);
		this.setCDCUR_NUMERO_HORAS_PEDAGOGICAS(inCdcur_numero_horas_pedagogicas);
		this.setCDCUR_NUMERO_HORAS(inCdcur_numero_horas);
		this.setCDCUR_NUMERO_MODULOS(inCdcur_numero_modulos);
		this.setCDCUR_CONTENIDO(inCdcur_contenido);
		this.setCDCUR_INSTITUCION(inCdcur_institucion);
		this.setCDCUR_ESTABLECIMIENTO(inCdcur_establecimiento);
		this.setCDCUR_COSTO(inCdcur_costo);
		this.setCDCUR_PORCENTAJE_FINANCIADO(inCdcur_porcentaje_financiado);
		this.setCDCUR_OBSERVACION(inCdcur_observacion);
		this.setCDCUR_VALORACION(inCdcur_valoracion);
		this.setCDCUR_NUMERO_ASISTENTE(inCdcur_numero_asistente);
		this.setCDCUR_ESTADO_CURSO(inCdcur_estado_curso);
		this.setCDCUR_ESTADO(inCdcur_estado);
		this.setCDCUR_USUARIO_INSERT(inCdcur_usuario_insert);
		this.setCDCUR_USUARIO_UPDATE(inCdcur_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	public void setCDCUR_CODIGO(String inCdcur_codigo){
		this.myCdcur_codigo = inCdcur_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	*/
	public String getCDCUR_CODIGO(){
		return this.myCdcur_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	* @param inCdtcr_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	*/
	public void setCDTCR_CODIGO(String inCdtcr_codigo){
		this.myCdtcr_codigo = inCdtcr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
	*/
	public String getCDTCR_CODIGO(){
		return this.myCdtcr_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	public void setCSCTP_CODIGO(String inCsctp_codigo){
		this.myCsctp_codigo = inCsctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	public String getCSCTP_CODIGO(){
		return this.myCsctp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	* @param inCditr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	*/
	public void setCDITR_CODIGO(String inCditr_codigo){
		this.myCditr_codigo = inCditr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
	*/
	public String getCDITR_CODIGO(){
		return this.myCditr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA INSTRUCTOR DEL CURSO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CURSO
	* @param inCdcur_descripcion DESCRIPCION DEL CURSO
	*/
	public void setCDCUR_DESCRIPCION(String inCdcur_descripcion){
		this.myCdcur_descripcion = inCdcur_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL CURSO
	* @return String DESCRIPCION DEL CURSO
	*/
	public String getCDCUR_DESCRIPCION(){
		return this.myCdcur_descripcion;
	}
		/**
	* ESTABLECE FECHA PREVISTA DE INICIO DEL CURSO
	* @param inCdcur_fecha_prevista_inicio FECHA DE INICIO DEL CURSO
	*/
	public void setCDCUR_FECHA_PREVISTA_INICIO(java.util.Date inCdcur_fecha_prevista_inicio){
		this.myCdcur_fecha_prevista_inicio = inCdcur_fecha_prevista_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL CURSO
	* @return java.util.Date FECHA DE INICIO DEL CURSO
	*/
	public java.util.Date getCDCUR_FECHA_PREVISTA_INICIO(){
		return this.myCdcur_fecha_prevista_inicio;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL CURSO
	* @param inCdcur_fecha_inicio FECHA DE INICIO DEL CURSO
	*/
	public void setCDCUR_FECHA_INICIO(java.util.Date inCdcur_fecha_inicio){
		this.myCdcur_fecha_inicio = inCdcur_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL CURSO
	* @return java.util.Date FECHA DE INICIO DEL CURSO
	*/
	public java.util.Date getCDCUR_FECHA_INICIO(){
		return this.myCdcur_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DEL CURSO
	* @param inCdcur_fecha_culminacion FECHA DE FINALIZACION DEL CURSO
	*/
	public void setCDCUR_FECHA_CULMINACION(java.util.Date inCdcur_fecha_culminacion){
		this.myCdcur_fecha_culminacion = inCdcur_fecha_culminacion;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DEL CURSO
	* @return java.util.Date FECHA DE FINALIZACION DEL CURSO
	*/
	public java.util.Date getCDCUR_FECHA_CULMINACION(){
		return this.myCdcur_fecha_culminacion;
	}

	/**
	* ESTABLECE FECHA PREVISTA DE FINALIZACION DEL CURSO
	* @param inCdcur_fecha_prevista_culminacion FECHA PREVISTA DE FINALIZACION DEL CURSO
	*/
	public void setCDCUR_FECHA_PREVISTA_CULMINACION(java.util.Date  inCdcur_fecha_prevista_culminacion){
		this.myCdcur_fecha_prevista_culminacion = inCdcur_fecha_prevista_culminacion;
	}
	/**
	* OBTIENE FECHA PREVISTA DE FINALIZACION DEL CURSO
	* @return java.util.Date FECHA PREVISTA DE FINALIZACION DEL CURSO
	*/
	public java.util.Date getCDCUR_FECHA_PREVISTA_CULMINACION(){
		return this.myCdcur_fecha_prevista_culminacion;
	}

	/**
	* ESTABLECE HORARIO DEL CURSO
	* @param inCdcur_horario HORARIO DEL CURSO
	*/
	public void setCDCUR_HORARIO(String inCdcur_horario){
		this.myCdcur_horario = inCdcur_horario;
	}
	/**
	* OBTIENE HORARIO DEL CURSO
	* @return String HORARIO DEL CURSO
	*/
	public String getCDCUR_HORARIO(){
		return this.myCdcur_horario;
	}
	/**
	* ESTABLECE HORARIO DEL CURSO
	* @param inCdcur_horario1 HORARIO DEL CURSO
	*/
	public void setCDCUR_HORARIO1(String inCdcur_horario1){
		this.myCdcur_horario1 = inCdcur_horario1;
	}
	/**
	* OBTIENE HORARIO DEL CURSO
	* @return String HORARIO DEL CURSO
	*/
	public String getCDCUR_HORARIO1(){
		return this.myCdcur_horario1;
	}
	/**
	* ESTABLECE NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
	* @param inCdcur_numero_horas_pedagogicas NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
	*/
	public void setCDCUR_NUMERO_HORAS_PEDAGOGICAS(int inCdcur_numero_horas_pedagogicas){
		this.myCdcur_numero_horas_pedagogicas = inCdcur_numero_horas_pedagogicas;
	}
	/**
	* OBTIENE NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
	* @return int NUMERO DE HORAS PEDAGOGICAS DE DURACION DEL CURSO
	*/
	public int getCDCUR_NUMERO_HORAS_PEDAGOGICAS(){
		return this.myCdcur_numero_horas_pedagogicas;
	}

	/**
	* ESTABLECE NUMERO DE HORAS RELOJ DE DURACION
	* @param inCdcur_numero_horas NUMERO DE HORAS RELOJ DE DURACION
	*/
	public void setCDCUR_NUMERO_HORAS(int inCdcur_numero_horas){
		this.myCdcur_numero_horas = inCdcur_numero_horas;
	}
	/**
	* OBTIENE NUMERO DE HORAS RELOJ DE DURACION
	* @return int NUMERO DE HORAS RELOJ DE DURACION
	*/
	public int getCDCUR_NUMERO_HORAS(){
		return this.myCdcur_numero_horas;
	}

	/**
	* ESTABLECE MODULOS DEL CURSO
	* @param inCdcur_numero_modulos MODULOS DEL CURSO
	*/
	public void setCDCUR_NUMERO_MODULOS(int inCdcur_numero_modulos){
		this.myCdcur_numero_modulos = inCdcur_numero_modulos;
	}
	/**
	* OBTIENE MODULOS DEL CURSO
	* @return int MODULOS DEL CURSO
	*/
	public int getCDCUR_NUMERO_MODULOS(){
		return this.myCdcur_numero_modulos;
	}

	/**
	* ESTABLECE CONTENIDO DEL CURSO
	* @param inCdcur_contenido CONTENIDO DEL CURSO
	*/
	public void setCDCUR_CONTENIDO(String inCdcur_contenido){
		this.myCdcur_contenido = inCdcur_contenido;
	}
	/**
	* OBTIENE CONTENIDO DEL CURSO
	* @return String CONTENIDO DEL CURSO
	*/
	public String getCDCUR_CONTENIDO(){
		return this.myCdcur_contenido;
	}

	/**
	* ESTABLECE NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
	* @param inCdcur_institucion NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
	*/
	public void setCDCUR_INSTITUCION(String inCdcur_institucion){
		this.myCdcur_institucion = inCdcur_institucion;
	}
	/**
	* OBTIENE NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
	* @return String NOMBRE DE LA INSTITUCION RESPONSABLE DEL CURSO
	*/
	public String getCDCUR_INSTITUCION(){
		return this.myCdcur_institucion;
	}

	/**
	* ESTABLECE LUGAR DONDE SE REALIZA EL CURSO
	* @param inCdcur_establecimiento LUGAR DONDE SE REALIZA EL CURSO
	*/
	public void setCDCUR_ESTABLECIMIENTO(String inCdcur_establecimiento){
		this.myCdcur_establecimiento = inCdcur_establecimiento;
	}
	/**
	* OBTIENE LUGAR DONDE SE REALIZA EL CURSO
	* @return String LUGAR DONDE SE REALIZA EL CURSO
	*/
	public String getCDCUR_ESTABLECIMIENTO(){
		return this.myCdcur_establecimiento;
	}

	/**
	* ESTABLECE COSTO DEL CURSO
	* @param inCdcur_costo COSTO DEL CURSO
	*/
	public void setCDCUR_COSTO(java.math.BigDecimal inCdcur_costo){
		this.myCdcur_costo = inCdcur_costo;
	}
	/**
	* OBTIENE COSTO DEL CURSO
	* @return java.math.BigDecimal COSTO DEL CURSO
	*/
	public java.math.BigDecimal getCDCUR_COSTO(){
		return this.myCdcur_costo;
	}

	/**
	* ESTABLECE PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
	* @param inCdcur_porcentaje_financiado PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
	*/
	public void setCDCUR_PORCENTAJE_FINANCIADO(java.math.BigDecimal inCdcur_porcentaje_financiado){
		this.myCdcur_porcentaje_financiado = inCdcur_porcentaje_financiado;
	}
	/**
	* OBTIENE PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
	* @return java.math.BigDecimal PORCENTAJE APORTADO POR EL CGG PARA EL CURSO
	*/
	public java.math.BigDecimal getCDCUR_PORCENTAJE_FINANCIADO(){
		return this.myCdcur_porcentaje_financiado;
	}

	/**
	* ESTABLECE OBSERVACION DEL CURSO
	* @param inCdcur_observacion OBSERVACION DEL CURSO
	*/
	public void setCDCUR_OBSERVACION(String inCdcur_observacion){
		this.myCdcur_observacion = inCdcur_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL CURSO
	* @return String OBSERVACION DEL CURSO
	*/
	public String getCDCUR_OBSERVACION(){
		return this.myCdcur_observacion;
	}

	/**
	* ESTABLECE PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	* @param inCdcur_valoracion PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	*/
	public void setCDCUR_VALORACION(int inCdcur_valoracion){
		this.myCdcur_valoracion = inCdcur_valoracion;
	}
	/**
	* OBTIENE PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	* @return int PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	*/
	public int getCDCUR_VALORACION(){
		return this.myCdcur_valoracion;
	}
		/**
	* ESTABLECE EL NUMERO DE ASISTENTES RESPECTO AL CURSO
	* @param inCdcur_numero_asistente PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	*/
	public void setCDCUR_NUMERO_ASISTENTE(int inCdcur_numero_asistente){
		this.myCdcur_numero_asistente = inCdcur_numero_asistente;
	}
	/**
	* OBTIENE NUMERO DE LOS ASISTENTES RESPECTO AL CURSO
	* @return int PORCENTAJE DE ACEPTACION DE LOS ASISTENTES RESPECTO AL CURSO
	*/
	public int getCDCUR_NUMERO_ASISTENTE(){
		return this.myCdcur_numero_asistente;
	}

	/**
	* ESTABLECE ESTADO PROPIOS DEL CURSO
0 - REGISTRADO
1 - PROCESO MATRICULA
2 - INICIADO
3 - FINALIZADO
4 - SUSPENDIDO
5 - CANCELADO
	* @param inCdcur_estado_curso ESTADO PROPIOS DEL CURSO
0 - REGISTRADO
1 - PROCESO MATRICULA
2 - INICIADO
3 - FINALIZADO
4 - SUSPENDIDO
5 - CANCELADO
	*/
	public void setCDCUR_ESTADO_CURSO(int inCdcur_estado_curso){
		this.myCdcur_estado_curso = inCdcur_estado_curso;
	}
	/**
	* OBTIENE ESTADO PROPIOS DEL CURSO
0 - REGISTRADO
1 - PROCESO MATRICULA
2 - INICIADO
3 - FINALIZADO
4 - SUSPENDIDO
5 - CANCELADO
	* @return int ESTADO PROPIOS DEL CURSO
0 - REGISTRADO
1 - PROCESO MATRICULA
2 - INICIADO
3 - FINALIZADO
4 - SUSPENDIDO
5 - CANCELADO
	*/
	public int getCDCUR_ESTADO_CURSO(){
		return this.myCdcur_estado_curso;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdcur_estado ESTADO DEL REGISTRO
	*/
	public void setCDCUR_ESTADO(boolean inCdcur_estado){
		this.myCdcur_estado = inCdcur_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDCUR_ESTADO(){
		return this.myCdcur_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdcur_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDCUR_USUARIO_INSERT(String inCdcur_usuario_insert){
		this.myCdcur_usuario_insert = inCdcur_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDCUR_USUARIO_INSERT(){
		return this.myCdcur_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdcur_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDCUR_USUARIO_UPDATE(String inCdcur_usuario_update){
		this.myCdcur_usuario_update = inCdcur_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDCUR_USUARIO_UPDATE(){
		return this.myCdcur_usuario_update;
	}

}
