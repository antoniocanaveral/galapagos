package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_certificado
* TABLA:CERTIFICADO ACADEMICO LABORAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS CURSOS, SEMINARIOS  Y CERTIFICADOS LABORABLES O PERSONALES QUE HAN OBTENIDO LAS PERSONAS
* ABREVIATURA:CGCER
*/
public class Cgg_gem_certificado implements Serializable{
	private static final long serialVersionUID = 1396582974;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgcer_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
	*/
	private String myCrper_codigo;
	/**
	* NOMBRE DE LA UNIDAD EDUCATIVA
	*/
	private String myCgcer_institucion;
	/**
	* NOMBRE DEL CURSO
	*/
	private String myCgcer_nombre;
	/**
	* DESCRIPCION DEL CURSO
	*/
	private String myCgcer_descripcion;
	/**
	* DURACION DEL CURSOS (HORAS)
	*/
	private int myCgcer_duracion;
	/**
	* FECHA DE  INICIO DEL CURSO
	*/
	private java.util.Date myCgcer_fecha_inicio;
	/**
	* FECHA DE  FIN DEL CURSO
	*/
	private java.util.Date myCgcer_fecha_fin;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgcer_tipo_adjunto;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCgcer_nombre_adjunto;
	/**
	* ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
	*/
	private byte[] myCgcer_adjunto;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCgcer_observacion;
	/**
	* TIPO DE CERTIFICACION LABORAL O PERSONAL
0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
	*/
	private int myCgcer_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgcer_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgcer_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgcer_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_certificado
	*/
	public Cgg_gem_certificado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_certificado
	* @param inCgcer_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
	* @param inCgcer_institucion NOMBRE DE LA UNIDAD EDUCATIVA
	* @param inCgcer_nombre NOMBRE DEL CURSO
	* @param inCgcer_descripcion DESCRIPCION DEL CURSO
	* @param inCgcer_duracion DURACION DEL CURSOS (HORAS)
	* @param inCgcer_fecha_inicio FECHA DE  INICIO DEL CURSO
	* @param inCgcer_fecha_fin FECHA DE  FIN DEL CURSO
	* @param inCgcer_tipo_adjunto NO ESPECIFICADO
	* @param inCgcer_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCgcer_adjunto ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
	* @param inCgcer_observacion INFORMACION ADICIONAL
	* @param inCgcer_tipo TIPO DE CERTIFICACION LABORAL O PERSONAL
0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
	* @param inCgcer_estado ESTADO DEL REGISTRO
	* @param inCgcer_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @param inCgcer_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public Cgg_gem_certificado(
		String inCgcer_codigo,
		String inCrper_codigo,
		String inCgcer_institucion,
		String inCgcer_nombre,
		String inCgcer_descripcion,
		int inCgcer_duracion,
		java.util.Date inCgcer_fecha_inicio,
		java.util.Date inCgcer_fecha_fin,
		String inCgcer_tipo_adjunto,
		String inCgcer_nombre_adjunto,
		byte[] inCgcer_adjunto,
		String inCgcer_observacion,
		int inCgcer_tipo,
		boolean inCgcer_estado,
		String inCgcer_usuario_insert,
		String inCgcer_usuario_update
	){
		this.setCGCER_CODIGO(inCgcer_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGCER_INSTITUCION(inCgcer_institucion);
		this.setCGCER_NOMBRE(inCgcer_nombre);
		this.setCGCER_DESCRIPCION(inCgcer_descripcion);
		this.setCGCER_DURACION(inCgcer_duracion);
		this.setCGCER_FECHA_INICIO(inCgcer_fecha_inicio);
		this.setCGCER_FECHA_FIN(inCgcer_fecha_fin);
		this.setCGCER_TIPO_ADJUNTO(inCgcer_tipo_adjunto);
		this.setCGCER_NOMBRE_ADJUNTO(inCgcer_nombre_adjunto);
		this.setCGCER_ADJUNTO(inCgcer_adjunto);
		this.setCGCER_OBSERVACION(inCgcer_observacion);
		this.setCGCER_TIPO(inCgcer_tipo);
		this.setCGCER_ESTADO(inCgcer_estado);
		this.setCGCER_USUARIO_INSERT(inCgcer_usuario_insert);
		this.setCGCER_USUARIO_UPDATE(inCgcer_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgcer_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGCER_CODIGO(String inCgcer_codigo){
		this.myCgcer_codigo = inCgcer_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGCER_CODIGO(){
		return this.myCgcer_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA UNIDAD EDUCATIVA
	* @param inCgcer_institucion NOMBRE DE LA UNIDAD EDUCATIVA
	*/
	public void setCGCER_INSTITUCION(String inCgcer_institucion){
		this.myCgcer_institucion = inCgcer_institucion;
	}
	/**
	* OBTIENE NOMBRE DE LA UNIDAD EDUCATIVA
	* @return String NOMBRE DE LA UNIDAD EDUCATIVA
	*/
	public String getCGCER_INSTITUCION(){
		return this.myCgcer_institucion;
	}

	/**
	* ESTABLECE NOMBRE DEL CURSO
	* @param inCgcer_nombre NOMBRE DEL CURSO
	*/
	public void setCGCER_NOMBRE(String inCgcer_nombre){
		this.myCgcer_nombre = inCgcer_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL CURSO
	* @return String NOMBRE DEL CURSO
	*/
	public String getCGCER_NOMBRE(){
		return this.myCgcer_nombre;
	}

	/**
	* ESTABLECE DESCRIPCION DEL CURSO
	* @param inCgcer_descripcion DESCRIPCION DEL CURSO
	*/
	public void setCGCER_DESCRIPCION(String inCgcer_descripcion){
		this.myCgcer_descripcion = inCgcer_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL CURSO
	* @return String DESCRIPCION DEL CURSO
	*/
	public String getCGCER_DESCRIPCION(){
		return this.myCgcer_descripcion;
	}

	/**
	* ESTABLECE DURACION DEL CURSOS (HORAS)
	* @param inCgcer_duracion DURACION DEL CURSOS (HORAS)
	*/
	public void setCGCER_DURACION(int inCgcer_duracion){
		this.myCgcer_duracion = inCgcer_duracion;
	}
	/**
	* OBTIENE DURACION DEL CURSOS (HORAS)
	* @return int DURACION DEL CURSOS (HORAS)
	*/
	public int getCGCER_DURACION(){
		return this.myCgcer_duracion;
	}

	/**
	* ESTABLECE FECHA DE  INICIO DEL CURSO
	* @param inCgcer_fecha_inicio FECHA DE  INICIO DEL CURSO
	*/
	public void setCGCER_FECHA_INICIO(java.util.Date inCgcer_fecha_inicio){
		this.myCgcer_fecha_inicio = inCgcer_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE  INICIO DEL CURSO
	* @return java.util.Date FECHA DE  INICIO DEL CURSO
	*/
	public java.util.Date getCGCER_FECHA_INICIO(){
		return this.myCgcer_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE  FIN DEL CURSO
	* @param inCgcer_fecha_fin FECHA DE  FIN DEL CURSO
	*/
	public void setCGCER_FECHA_FIN(java.util.Date inCgcer_fecha_fin){
		this.myCgcer_fecha_fin = inCgcer_fecha_fin;
	}
	/**
	* OBTIENE FECHA DE  FIN DEL CURSO
	* @return java.util.Date FECHA DE  FIN DEL CURSO
	*/
	public java.util.Date getCGCER_FECHA_FIN(){
		return this.myCgcer_fecha_fin;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgcer_tipo_adjunto NO ESPECIFICADO
	*/
	public void setCGCER_TIPO_ADJUNTO(String inCgcer_tipo_adjunto){
		this.myCgcer_tipo_adjunto = inCgcer_tipo_adjunto;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGCER_TIPO_ADJUNTO(){
		return this.myCgcer_tipo_adjunto;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCgcer_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCGCER_NOMBRE_ADJUNTO(String inCgcer_nombre_adjunto){
		this.myCgcer_nombre_adjunto = inCgcer_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCGCER_NOMBRE_ADJUNTO(){
		return this.myCgcer_nombre_adjunto;
	}

	/**
	* ESTABLECE ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
	* @param inCgcer_adjunto ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
	*/
	public void setCGCER_ADJUNTO(byte[] inCgcer_adjunto){
		this.myCgcer_adjunto = inCgcer_adjunto;
	}
	/**
	* OBTIENE ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
	* @return byte[] ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
	*/
	public byte[] getCGCER_ADJUNTO(){
		return this.myCgcer_adjunto;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCgcer_observacion INFORMACION ADICIONAL
	*/
	public void setCGCER_OBSERVACION(String inCgcer_observacion){
		this.myCgcer_observacion = inCgcer_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCGCER_OBSERVACION(){
		return this.myCgcer_observacion;
	}

	/**
	* ESTABLECE TIPO DE CERTIFICACION LABORAL O PERSONAL
0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
	* @param inCgcer_tipo TIPO DE CERTIFICACION LABORAL O PERSONAL
0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
	*/
	public void setCGCER_TIPO(int inCgcer_tipo){
		this.myCgcer_tipo = inCgcer_tipo;
	}
	/**
	* OBTIENE TIPO DE CERTIFICACION LABORAL O PERSONAL
0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
	* @return int TIPO DE CERTIFICACION LABORAL O PERSONAL
0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
	*/
	public int getCGCER_TIPO(){
		return this.myCgcer_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgcer_estado ESTADO DEL REGISTRO
	*/
	public void setCGCER_ESTADO(boolean inCgcer_estado){
		this.myCgcer_estado = inCgcer_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGCER_ESTADO(){
		return this.myCgcer_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @param inCgcer_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	*/
	public void setCGCER_USUARIO_INSERT(String inCgcer_usuario_insert){
		this.myCgcer_usuario_insert = inCgcer_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA

	*/
	public String getCGCER_USUARIO_INSERT(){
		return this.myCgcer_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	* @param inCgcer_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public void setCGCER_USUARIO_UPDATE(String inCgcer_usuario_update){
		this.myCgcer_usuario_update = inCgcer_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION

	*/
	public String getCGCER_USUARIO_UPDATE(){
		return this.myCgcer_usuario_update;
	}

}
