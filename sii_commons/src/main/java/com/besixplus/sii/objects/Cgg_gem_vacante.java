package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_vacante
* TABLA: VACANTE
* DESCRIPCION:ALMACENA INFORMACION DE LAS PLAZAS DE EMPLEO DISPONIBLES DENTRO DE LA PROVINCIA
* ABREVIATURA:CGVCN
*/
public class Cgg_gem_vacante implements Serializable{
	private static final long serialVersionUID = 459565347;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	private String myCgvcn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	*/
	private String myCgtcn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	*/
	private String myCgtsa_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	private String myCgcrg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL TITULO PROFESIONAL
	*/
	private String myCgtpr_codigo;
	/**
	* NUMERO SECUENCIAL UNICO DE LA VACANTE
	*/
	private int myCgvcn_numero;
	/**
	* NOMBRE IDENTIFICATIVO DE LA VACANTE
	*/
	private String myCgvcn_titulo;
	/**
	* DESCRIPCION DE LA VACANTE
	*/
	private String myCgvcn_descripcion;
	/**
	* MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	*/
	private java.math.BigDecimal myCgvcn_salario;
	/**
	* DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	*/
	private String myCgvcn_direccion;
	/**
	* FECHA DE INGRESO DE LA OFERTA
	*/
	private java.util.Date myCgvcn_fecha_ingreso;
	/**
	* FECHA DE PUBLICACION DE LA OFERTA
	*/
	private java.util.Date myCgvcn_fecha_publicacion;
	/**
	* TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	*/
	private int myCgvcn_duracion_oferta;
	/**
	* FECHA EXPIRACION DE LA PUBLICACION
	*/
	private java.util.Date myCgvcn_fecha_expiracion;
	/**
	* ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE

0 - REGISTRADA
1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
2 - RECHAZADA FINALIZADA
3 - VENCIDA FECHA DE PUBLICACION 
4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
7 - FINALIZADA EXITOSAMENTE
8 - FINALIZADA POR OTROS MOTIVOS
	*/
	private int myCgvcn_estado_oferta;
	/**
	* CANTIDAD DE VACANTES DISPONIBLES 
	*/
	private int myCgvcn_numero_vacantes;
	/**
	*  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	*/
	private int myCgvcn_duracion;
	/**
	* TIEMPO DE DURACION NUMERICAMENTE
	*/
	private java.math.BigDecimal myCgvcn_duracion_tiempo;
	/**
	* EXPERIENCIA MINIMA SOLICITADA 
	*/
	private String myCgvcn_experiencia;
	/**
	* EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	*/
	private int myCgvcn_existencia_manobra;
	/**
	* NUMERO DE CERTIFICADO DE MANO DE OBRA
	*/
	private String myCgvcn_numero_manobra;
	/**
	* ANIO DEL COMUNICADO RADIAL
	*/
	private java.math.BigDecimal myCgvcn_anio;
	/**
	* NUMERO DE COMUNICADO RADIAL
	*/
	private String myCgvcn_numero_comunicado;
	/**
	* CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS 
2 - OTROS
	*/
	private int myCgvcn_oferta_aprobada;
	/**
	* ESTADO DE CONTRATACION DE LA VACANTE
	*/
	private boolean myCgvcn_cubierta;
	/**
	* DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	*/
	private String myCgvcn_justificacion_no_contrat;
	/**
	* ESTADO DEL REGISTRO 

	*/
	private boolean myCgvcn_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgvcn_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgvcn_usuario_update;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCgvcn_fecha_manobra;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCgvcn_fecha_justificacion;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante
	*/
	public Cgg_gem_vacante(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_vacante
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @param inCgtcn_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	* @param inCgtsa_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO TITULO PROFESIONAL
	* @param inCgvcn_numero NUMERO SECUENCIAL UNICO DE LA VACANTE
	* @param inCgvcn_titulo NOMBRE IDENTIFICATIVO DE LA VACANTE
	* @param inCgvcn_descripcion DESCRIPCION DE LA VACANTE
	* @param inCgvcn_salario MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	* @param inCgvcn_direccion DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	* @param inCgvcn_fecha_ingreso FECHA DE INGRESO DE LA OFERTA
	* @param inCgvcn_fecha_publicacion FECHA DE PUBLICACION DE LA OFERTA
	* @param inCgvcn_duracion_oferta TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	* @param inCgvcn_fecha_expiracion FECHA EXPIRACION DE LA PUBLICACION
	* @param inCgvcn_estado_oferta ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE

0 - REGISTRADA
1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
2 - RECHAZADA FINALIZADA
3 - VENCIDA FECHA DE PUBLICACION 
4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
7 - FINALIZADA EXITOSAMENTE
8 - FINALIZADA POR OTROS MOTIVOS
	* @param inCgvcn_numero_vacantes CANTIDAD DE VACANTES DISPONIBLES 
	* @param inCgvcn_duracion  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	* @param inCgvcn_duracion_tiempo TIEMPO DE DURACION NUMERICAMENTE
	* @param inCgvcn_experiencia EXPERIENCIA MINIMA SOLICITADA 
	* @param inCgvcn_existencia_manobra EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	* @param inCgvcn_numero_manobra NUMERO DE CERTIFICADO DE MANO DE OBRA
	* @param inCgvcn_anio ANIO DEL COMUNICADO RADIAL
	* @param inCgvcn_numero_comunicado NUMERO DE COMUNICADO RADIAL
	* @param inCgvcn_oferta_aprobada CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS 
2 - OTROS
	* @param inCgvcn_cubierta ESTADO DE CONTRATACION DE LA VACANTE
	* @param inCgvcn_justificacion_no_contrat DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	* @param inCgvcn_estado ESTADO DEL REGISTRO 

	* @param inCgvcn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgvcn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgvcn_fecha_manobra NO ESPECIFICADO
	* @param inCgvcn_fecha_justificacion NO ESPECIFICADO
	*/
	public Cgg_gem_vacante(
		String inCgvcn_codigo,
		String inCusu_codigo,
		String inCsctp_codigo,
		String inCgtcn_codigo,
		String inCgtsa_codigo,
		String inCgcrg_codigo,
		String inCgtpr_codigo,
		int inCgvcn_numero,
		String inCgvcn_titulo,
		String inCgvcn_descripcion,
		java.math.BigDecimal inCgvcn_salario,
		String inCgvcn_direccion,
		java.util.Date inCgvcn_fecha_ingreso,
		java.util.Date inCgvcn_fecha_publicacion,
		int inCgvcn_duracion_oferta,
		java.util.Date inCgvcn_fecha_expiracion,
		int inCgvcn_estado_oferta,
		int inCgvcn_numero_vacantes,
		int inCgvcn_duracion,
		java.math.BigDecimal inCgvcn_duracion_tiempo,
		String inCgvcn_experiencia,
		int inCgvcn_existencia_manobra,
		String inCgvcn_numero_manobra,
		java.math.BigDecimal inCgvcn_anio,
		String inCgvcn_numero_comunicado,
		int inCgvcn_oferta_aprobada,
		boolean inCgvcn_cubierta,
		String inCgvcn_justificacion_no_contrat,
		boolean inCgvcn_estado,
		String inCgvcn_usuario_insert,
		String inCgvcn_usuario_update,
		java.util.Date inCgvcn_fecha_manobra,
		java.util.Date inCgvcn_fecha_justificacion
	){
		this.setCGVCN_CODIGO(inCgvcn_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCGTCN_CODIGO(inCgtcn_codigo);
		this.setCGTSA_CODIGO(inCgtsa_codigo);
		this.setCGCRG_CODIGO(inCgcrg_codigo);
		this.setCGVCN_NUMERO(inCgvcn_numero);
		this.setCGVCN_TITULO(inCgvcn_titulo);
		this.setCGVCN_DESCRIPCION(inCgvcn_descripcion);
		this.setCGVCN_SALARIO(inCgvcn_salario);
		this.setCGVCN_DIRECCION(inCgvcn_direccion);
		this.setCGVCN_FECHA_INGRESO(inCgvcn_fecha_ingreso);
		this.setCGVCN_FECHA_PUBLICACION(inCgvcn_fecha_publicacion);
		this.setCGVCN_DURACION_OFERTA(inCgvcn_duracion_oferta);
		this.setCGVCN_FECHA_EXPIRACION(inCgvcn_fecha_expiracion);
		this.setCGVCN_ESTADO_OFERTA(inCgvcn_estado_oferta);
		this.setCGVCN_NUMERO_VACANTES(inCgvcn_numero_vacantes);
		this.setCGVCN_DURACION(inCgvcn_duracion);
		this.setCGVCN_DURACION_TIEMPO(inCgvcn_duracion_tiempo);
		this.setCGVCN_EXPERIENCIA(inCgvcn_experiencia);
		this.setCGVCN_EXISTENCIA_MANOBRA(inCgvcn_existencia_manobra);
		this.setCGVCN_NUMERO_MANOBRA(inCgvcn_numero_manobra);
		this.setCGVCN_ANIO(inCgvcn_anio);
		this.setCGVCN_NUMERO_COMUNICADO(inCgvcn_numero_comunicado);
		this.setCGVCN_OFERTA_APROBADA(inCgvcn_oferta_aprobada);
		this.setCGVCN_CUBIERTA(inCgvcn_cubierta);
		this.setCGVCN_JUSTIFICACION_NO_CONTRAT(inCgvcn_justificacion_no_contrat);
		this.setCGVCN_ESTADO(inCgvcn_estado);
		this.setCGVCN_USUARIO_INSERT(inCgvcn_usuario_insert);
		this.setCGVCN_USUARIO_UPDATE(inCgvcn_usuario_update);
		this.setCGVCN_FECHA_MANOBRA(inCgvcn_fecha_manobra);
		this.setCGVCN_FECHA_JUSTIFICACION(inCgvcn_fecha_justificacion);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	public void setCGVCN_CODIGO(String inCgvcn_codigo){
		this.myCgvcn_codigo = inCgvcn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	public String getCGVCN_CODIGO(){
		return this.myCgvcn_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TITULO PROFESIONAL
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	public void setCGTPR_CODIGO(String inCgtpr_codigo){
		this.myCgtpr_codigo= inCgtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	*/
	public String getCGTPR_CODIGO(){
		return this.myCgtpr_codigo;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	* @param inCgtcn_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	*/
	public void setCGTCN_CODIGO(String inCgtcn_codigo){
		this.myCgtcn_codigo = inCgtcn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	*/
	public String getCGTCN_CODIGO(){
		return this.myCgtcn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	* @param inCgtsa_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	*/
	public void setCGTSA_CODIGO(String inCgtsa_codigo){
		this.myCgtsa_codigo = inCgtsa_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	*/
	public String getCGTSA_CODIGO(){
		return this.myCgtsa_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public void setCGCRG_CODIGO(String inCgcrg_codigo){
		this.myCgcrg_codigo = inCgcrg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	*/
	public String getCGCRG_CODIGO(){
		return this.myCgcrg_codigo;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL UNICO DE LA VACANTE
	* @param inCgvcn_numero NUMERO SECUENCIAL UNICO DE LA VACANTE
	*/
	public void setCGVCN_NUMERO(int inCgvcn_numero){
		this.myCgvcn_numero = inCgvcn_numero;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL UNICO DE LA VACANTE
	* @return int NUMERO SECUENCIAL UNICO DE LA VACANTE
	*/
	public int getCGVCN_NUMERO(){
		return this.myCgvcn_numero;
	}

	/**
	* ESTABLECE NOMBRE IDENTIFICATIVO DE LA VACANTE
	* @param inCgvcn_titulo NOMBRE IDENTIFICATIVO DE LA VACANTE
	*/
	public void setCGVCN_TITULO(String inCgvcn_titulo){
		this.myCgvcn_titulo = inCgvcn_titulo;
	}
	/**
	* OBTIENE NOMBRE IDENTIFICATIVO DE LA VACANTE
	* @return String NOMBRE IDENTIFICATIVO DE LA VACANTE
	*/
	public String getCGVCN_TITULO(){
		return this.myCgvcn_titulo;
	}

	/**
	* ESTABLECE DESCRIPCION DE LA VACANTE
	* @param inCgvcn_descripcion DESCRIPCION DE LA VACANTE
	*/
	public void setCGVCN_DESCRIPCION(String inCgvcn_descripcion){
		this.myCgvcn_descripcion = inCgvcn_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DE LA VACANTE
	* @return String DESCRIPCION DE LA VACANTE
	*/
	public String getCGVCN_DESCRIPCION(){
		return this.myCgvcn_descripcion;
	}

	/**
	* ESTABLECE MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	* @param inCgvcn_salario MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	*/
	public void setCGVCN_SALARIO(java.math.BigDecimal inCgvcn_salario){
		this.myCgvcn_salario = inCgvcn_salario;
	}
	/**
	* OBTIENE MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	* @return java.math.BigDecimal MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	*/
	public java.math.BigDecimal getCGVCN_SALARIO(){
		return this.myCgvcn_salario;
	}

	/**
	* ESTABLECE DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	* @param inCgvcn_direccion DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	*/
	public void setCGVCN_DIRECCION(String inCgvcn_direccion){
		this.myCgvcn_direccion = inCgvcn_direccion;
	}
	/**
	* OBTIENE DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	* @return String DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	*/
	public String getCGVCN_DIRECCION(){
		return this.myCgvcn_direccion;
	}

	/**
	* ESTABLECE FECHA DE INGRESO DE LA OFERTA
	* @param inCgvcn_fecha_ingreso FECHA DE INGRESO DE LA OFERTA
	*/
	public void setCGVCN_FECHA_INGRESO(java.util.Date inCgvcn_fecha_ingreso){
		this.myCgvcn_fecha_ingreso = inCgvcn_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO DE LA OFERTA
	* @return java.util.Date FECHA DE INGRESO DE LA OFERTA
	*/
	public java.util.Date getCGVCN_FECHA_INGRESO(){
		return this.myCgvcn_fecha_ingreso;
	}

	/**
	* ESTABLECE FECHA DE PUBLICACION DE LA OFERTA
	* @param inCgvcn_fecha_publicacion FECHA DE PUBLICACION DE LA OFERTA
	*/
	public void setCGVCN_FECHA_PUBLICACION(java.util.Date inCgvcn_fecha_publicacion){
		this.myCgvcn_fecha_publicacion = inCgvcn_fecha_publicacion;
	}
	/**
	* OBTIENE FECHA DE PUBLICACION DE LA OFERTA
	* @return java.util.Date FECHA DE PUBLICACION DE LA OFERTA
	*/
	public java.util.Date getCGVCN_FECHA_PUBLICACION(){
		return this.myCgvcn_fecha_publicacion;
	}

	/**
	* ESTABLECE TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	* @param inCgvcn_duracion_oferta TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	*/
	public void setCGVCN_DURACION_OFERTA(int inCgvcn_duracion_oferta){
		this.myCgvcn_duracion_oferta = inCgvcn_duracion_oferta;
	}
	/**
	* OBTIENE TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	* @return int TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	*/
	public int getCGVCN_DURACION_OFERTA(){
		return this.myCgvcn_duracion_oferta;
	}

	/**
	* ESTABLECE FECHA EXPIRACION DE LA PUBLICACION
	* @param inCgvcn_fecha_expiracion FECHA EXPIRACION DE LA PUBLICACION
	*/
	public void setCGVCN_FECHA_EXPIRACION(java.util.Date inCgvcn_fecha_expiracion){
		this.myCgvcn_fecha_expiracion = inCgvcn_fecha_expiracion;
	}
	/**
	* OBTIENE FECHA EXPIRACION DE LA PUBLICACION
	* @return java.util.Date FECHA EXPIRACION DE LA PUBLICACION
	*/
	public java.util.Date getCGVCN_FECHA_EXPIRACION(){
		return this.myCgvcn_fecha_expiracion;
	}

	/**
	* ESTABLECE ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE

0 - REGISTRADA
1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
2 - RECHAZADA FINALIZADA
3 - VENCIDA FECHA DE PUBLICACION 
4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
7 - FINALIZADA EXITOSAMENTE
8 - FINALIZADA POR OTROS MOTIVOS
	* @param inCgvcn_estado_oferta ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE

0 - REGISTRADA
1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
2 - RECHAZADA FINALIZADA
3 - VENCIDA FECHA DE PUBLICACION 
4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
7 - FINALIZADA EXITOSAMENTE
8 - FINALIZADA POR OTROS MOTIVOS
	*/
	public void setCGVCN_ESTADO_OFERTA(int inCgvcn_estado_oferta){
		this.myCgvcn_estado_oferta = inCgvcn_estado_oferta;
	}
	/**
	* OBTIENE ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE

0 - REGISTRADA
1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
2 - RECHAZADA FINALIZADA
3 - VENCIDA FECHA DE PUBLICACION 
4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
7 - FINALIZADA EXITOSAMENTE
8 - FINALIZADA POR OTROS MOTIVOS
	* @return int ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE

0 - REGISTRADA
1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
2 - RECHAZADA FINALIZADA
3 - VENCIDA FECHA DE PUBLICACION 
4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
7 - FINALIZADA EXITOSAMENTE
8 - FINALIZADA POR OTROS MOTIVOS
	*/
	public int getCGVCN_ESTADO_OFERTA(){
		return this.myCgvcn_estado_oferta;
	}

	/**
	* ESTABLECE CANTIDAD DE VACANTES DISPONIBLES 
	* @param inCgvcn_numero_vacantes CANTIDAD DE VACANTES DISPONIBLES 
	*/
	public void setCGVCN_NUMERO_VACANTES(int inCgvcn_numero_vacantes){
		this.myCgvcn_numero_vacantes = inCgvcn_numero_vacantes;
	}
	/**
	* OBTIENE CANTIDAD DE VACANTES DISPONIBLES 
	* @return int CANTIDAD DE VACANTES DISPONIBLES 
	*/
	public int getCGVCN_NUMERO_VACANTES(){
		return this.myCgvcn_numero_vacantes;
	}

	/**
	* ESTABLECE  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	* @param inCgvcn_duracion  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	*/
	public void setCGVCN_DURACION(int inCgvcn_duracion){
		this.myCgvcn_duracion = inCgvcn_duracion;
	}
	/**
	* OBTIENE  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	* @return int  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	*/
	public int getCGVCN_DURACION(){
		return this.myCgvcn_duracion;
	}

	/**
	* ESTABLECE TIEMPO DE DURACION NUMERICAMENTE
	* @param inCgvcn_duracion_tiempo TIEMPO DE DURACION NUMERICAMENTE
	*/
	public void setCGVCN_DURACION_TIEMPO(java.math.BigDecimal inCgvcn_duracion_tiempo){
		this.myCgvcn_duracion_tiempo = inCgvcn_duracion_tiempo;
	}
	/**
	* OBTIENE TIEMPO DE DURACION NUMERICAMENTE
	* @return java.math.BigDecimal TIEMPO DE DURACION NUMERICAMENTE
	*/
	public java.math.BigDecimal getCGVCN_DURACION_TIEMPO(){
		return this.myCgvcn_duracion_tiempo;
	}

	/**
	* ESTABLECE EXPERIENCIA MINIMA SOLICITADA 
	* @param inCgvcn_experiencia EXPERIENCIA MINIMA SOLICITADA 
	*/
	public void setCGVCN_EXPERIENCIA(String inCgvcn_experiencia){
		this.myCgvcn_experiencia = inCgvcn_experiencia;
	}
	/**
	* OBTIENE EXPERIENCIA MINIMA SOLICITADA 
	* @return String EXPERIENCIA MINIMA SOLICITADA 
	*/
	public String getCGVCN_EXPERIENCIA(){
		return this.myCgvcn_experiencia;
	}

	/**
	* ESTABLECE EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	* @param inCgvcn_existencia_manobra EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	*/
	public void setCGVCN_EXISTENCIA_MANOBRA(int inCgvcn_existencia_manobra){
		this.myCgvcn_existencia_manobra = inCgvcn_existencia_manobra;
	}
	/**
	* OBTIENE EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	* @return int EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	*/
	public int getCGVCN_EXISTENCIA_MANOBRA(){
		return this.myCgvcn_existencia_manobra;
	}

	/**
	* ESTABLECE NUMERO DE CERTIFICADO DE MANO DE OBRA
	* @param inCgvcn_numero_manobra NUMERO DE CERTIFICADO DE MANO DE OBRA
	*/
	public void setCGVCN_NUMERO_MANOBRA(String inCgvcn_numero_manobra){
		this.myCgvcn_numero_manobra = inCgvcn_numero_manobra;
	}
	/**
	* OBTIENE NUMERO DE CERTIFICADO DE MANO DE OBRA
	* @return String NUMERO DE CERTIFICADO DE MANO DE OBRA
	*/
	public String getCGVCN_NUMERO_MANOBRA(){
		return this.myCgvcn_numero_manobra;
	}

	/**
	* ESTABLECE ANIO DEL COMUNICADO RADIAL
	* @param inCgvcn_anio ANIO DEL COMUNICADO RADIAL
	*/
	public void setCGVCN_ANIO(java.math.BigDecimal inCgvcn_anio){
		this.myCgvcn_anio = inCgvcn_anio;
	}
	/**
	* OBTIENE ANIO DEL COMUNICADO RADIAL
	* @return java.math.BigDecimal ANIO DEL COMUNICADO RADIAL
	*/
	public java.math.BigDecimal getCGVCN_ANIO(){
		return this.myCgvcn_anio;
	}

	/**
	* ESTABLECE NUMERO DE COMUNICADO RADIAL
	* @param inCgvcn_numero_comunicado NUMERO DE COMUNICADO RADIAL
	*/
	public void setCGVCN_NUMERO_COMUNICADO(String inCgvcn_numero_comunicado){
		this.myCgvcn_numero_comunicado = inCgvcn_numero_comunicado;
	}
	/**
	* OBTIENE NUMERO DE COMUNICADO RADIAL
	* @return java.math.BigDecimal NUMERO DE COMUNICADO RADIAL
	*/
	public String getCGVCN_NUMERO_COMUNICADO(){
		return this.myCgvcn_numero_comunicado;
	}

	/**
	* ESTABLECE CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS 
2 - OTROS
	* @param inCgvcn_oferta_aprobada CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS 
2 - OTROS
	*/
	public void setCGVCN_OFERTA_APROBADA(int inCgvcn_oferta_aprobada){
		this.myCgvcn_oferta_aprobada = inCgvcn_oferta_aprobada;
	}
	/**
	* OBTIENE CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS 
2 - OTROS
	* @return int CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS 
2 - OTROS
	*/
	public int getCGVCN_OFERTA_APROBADA(){
		return this.myCgvcn_oferta_aprobada;
	}

	/**
	* ESTABLECE ESTADO DE CONTRATACION DE LA VACANTE
	* @param inCgvcn_cubierta ESTADO DE CONTRATACION DE LA VACANTE
	*/
	public void setCGVCN_CUBIERTA(boolean inCgvcn_cubierta){
		this.myCgvcn_cubierta = inCgvcn_cubierta;
	}
	/**
	* OBTIENE ESTADO DE CONTRATACION DE LA VACANTE
	* @return boolean ESTADO DE CONTRATACION DE LA VACANTE
	*/
	public boolean getCGVCN_CUBIERTA(){
		return this.myCgvcn_cubierta;
	}

	/**
	* ESTABLECE DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	* @param inCgvcn_justificacion_no_contrat DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	*/
	public void setCGVCN_JUSTIFICACION_NO_CONTRAT(String inCgvcn_justificacion_no_contrat){
		this.myCgvcn_justificacion_no_contrat = inCgvcn_justificacion_no_contrat;
	}
	/**
	* OBTIENE DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	* @return String DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	*/
	public String getCGVCN_JUSTIFICACION_NO_CONTRAT(){
		return this.myCgvcn_justificacion_no_contrat;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO 

	* @param inCgvcn_estado ESTADO DEL REGISTRO 

	*/
	public void setCGVCN_ESTADO(boolean inCgvcn_estado){
		this.myCgvcn_estado = inCgvcn_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO 

	* @return boolean ESTADO DEL REGISTRO 

	*/
	public boolean getCGVCN_ESTADO(){
		return this.myCgvcn_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgvcn_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGVCN_USUARIO_INSERT(String inCgvcn_usuario_insert){
		this.myCgvcn_usuario_insert = inCgvcn_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGVCN_USUARIO_INSERT(){
		return this.myCgvcn_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgvcn_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGVCN_USUARIO_UPDATE(String inCgvcn_usuario_update){
		this.myCgvcn_usuario_update = inCgvcn_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGVCN_USUARIO_UPDATE(){
		return this.myCgvcn_usuario_update;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgvcn_fecha_manobra NO ESPECIFICADO
	*/
	public void setCGVCN_FECHA_MANOBRA(java.util.Date inCgvcn_fecha_manobra){
		this.myCgvcn_fecha_manobra = inCgvcn_fecha_manobra;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCGVCN_FECHA_MANOBRA(){
		return this.myCgvcn_fecha_manobra;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgvcn_fecha_justificacion NO ESPECIFICADO
	*/
	public void setCGVCN_FECHA_JUSTIFICACION(java.util.Date inCgvcn_fecha_justificacion){
		this.myCgvcn_fecha_justificacion = inCgvcn_fecha_justificacion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCGVCN_FECHA_JUSTIFICACION(){
		return this.myCgvcn_fecha_justificacion;
	}

}
