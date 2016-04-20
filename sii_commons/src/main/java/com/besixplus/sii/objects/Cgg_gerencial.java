package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gerencial
* TABLA: GERENCIAL
* DESCRIPCION: ALMACENA INFORMACION DEL LISTADO RE REPORTES DEL MODULO GERENCIAL
* ABREVIATURA: CGGER
*/
public class Cgg_gerencial implements Serializable{
	private static final long serialVersionUID = 659825853;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	private String myCgger_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwmod_codigo;
	/**
	* PREGUNTA EMITIDA POR EL USUARIO
	*/
	private String myCgger_nombre;
	/**
	* RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	private String myCgger_titulo;
	/**
	* OBSERVACION REFERENTE AL MODULO
	*/
	private String myCgger_url;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgger_parametros;
	/**
	* ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	*/
	private String myCgger_descripcion;
	/**
	* NO ESPECIFICADO
	*/
	private int myCgger_tipo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgger_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgger_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgger_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gerencial
	*/
	public Cgg_gerencial(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gerencial
	* @param inCgger_codigo IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgger_nombre PREGUNTA EMITIDA POR EL USUARIO
	* @param inCgger_titulo RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	* @param inCgger_url OBSERVACION REFERENTE AL MODULO
	* @param inCgger_parametros NO ESPECIFICADO
	* @param inCgger_descripcion ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	* @param inCgger_tipo NO ESPECIFICADO
	* @param inCgger_estado ESTADO DEL REGISTRO
	* @param inCgger_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgger_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gerencial(
		String inCgger_codigo,
		String inCwmod_codigo,
		String inCgger_nombre,
		String inCgger_titulo,
		String inCgger_url,
		String inCgger_parametros,
		String inCgger_descripcion,
		int inCgger_tipo,
		boolean inCgger_estado,
		String inCgger_usuario_insert,
		String inCgger_usuario_update
	){
		this.setCGGER_CODIGO(inCgger_codigo);
		this.setCWMOD_CODIGO(inCwmod_codigo);
		this.setCGGER_NOMBRE(inCgger_nombre);
		this.setCGGER_TITULO(inCgger_titulo);
		this.setCGGER_URL(inCgger_url);
		this.setCGGER_PARAMETROS(inCgger_parametros);
		this.setCGGER_DESCRIPCION(inCgger_descripcion);
		this.setCGGER_TIPO(inCgger_tipo);
		this.setCGGER_ESTADO(inCgger_estado);
		this.setCGGER_USUARIO_INSERT(inCgger_usuario_insert);
		this.setCGGER_USUARIO_UPDATE(inCgger_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	* @param inCgger_codigo IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	public void setCGGER_CODIGO(String inCgger_codigo){
		this.myCgger_codigo = inCgger_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	* @return String IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	public String getCGGER_CODIGO(){
		return this.myCgger_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCWMOD_CODIGO(String inCwmod_codigo){
		this.myCwmod_codigo = inCwmod_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCWMOD_CODIGO(){
		return this.myCwmod_codigo;
	}

	/**
	* ESTABLECE PREGUNTA EMITIDA POR EL USUARIO
	* @param inCgger_nombre PREGUNTA EMITIDA POR EL USUARIO
	*/
	public void setCGGER_NOMBRE(String inCgger_nombre){
		this.myCgger_nombre = inCgger_nombre;
	}
	/**
	* OBTIENE PREGUNTA EMITIDA POR EL USUARIO
	* @return String PREGUNTA EMITIDA POR EL USUARIO
	*/
	public String getCGGER_NOMBRE(){
		return this.myCgger_nombre;
	}

	/**
	* ESTABLECE RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	* @param inCgger_titulo RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	public void setCGGER_TITULO(String inCgger_titulo){
		this.myCgger_titulo = inCgger_titulo;
	}
	/**
	* OBTIENE RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	* @return String RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	public String getCGGER_TITULO(){
		return this.myCgger_titulo;
	}

	/**
	* ESTABLECE OBSERVACION REFERENTE AL MODULO
	* @param inCgger_url OBSERVACION REFERENTE AL MODULO
	*/
	public void setCGGER_URL(String inCgger_url){
		this.myCgger_url = inCgger_url;
	}
	/**
	* OBTIENE OBSERVACION REFERENTE AL MODULO
	* @return String OBSERVACION REFERENTE AL MODULO
	*/
	public String getCGGER_URL(){
		return this.myCgger_url;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgger_parametros NO ESPECIFICADO
	*/
	public void setCGGER_PARAMETROS(String inCgger_parametros){
		this.myCgger_parametros = inCgger_parametros;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGGER_PARAMETROS(){
		return this.myCgger_parametros;
	}

	/**
	* ESTABLECE ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	* @param inCgger_descripcion ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	*/
	public void setCGGER_DESCRIPCION(String inCgger_descripcion){
		this.myCgger_descripcion = inCgger_descripcion;
	}
	/**
	* OBTIENE ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	* @return String ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	*/
	public String getCGGER_DESCRIPCION(){
		return this.myCgger_descripcion;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgger_tipo NO ESPECIFICADO
	*/
	public void setCGGER_TIPO(int inCgger_tipo){
		this.myCgger_tipo = inCgger_tipo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return int NO ESPECIFICADO
	*/
	public int getCGGER_TIPO(){
		return this.myCgger_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgger_estado ESTADO DEL REGISTRO
	*/
	public void setCGGER_ESTADO(boolean inCgger_estado){
		this.myCgger_estado = inCgger_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGGER_ESTADO(){
		return this.myCgger_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgger_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGGER_USUARIO_INSERT(String inCgger_usuario_insert){
		this.myCgger_usuario_insert = inCgger_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGGER_USUARIO_INSERT(){
		return this.myCgger_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgger_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGGER_USUARIO_UPDATE(String inCgger_usuario_update){
		this.myCgger_usuario_update = inCgger_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGGER_USUARIO_UPDATE(){
		return this.myCgger_usuario_update;
	}

}
