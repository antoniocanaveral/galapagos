package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_web_preguntas
* TABLA: PREGUNTAS
* DESCRIPCION: ALMACENA LAS DIFERENTES PREGUNTAS REALIZADAS POR LOS USUARIOS.
* ABREVIATURA: CWPRG
*/
public class Cgg_web_preguntas implements Serializable{
	private static final long serialVersionUID = 1540922514;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	private String myCwprg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCwmod_codigo;
	/**
	* PREGUNTA EMITIDA POR EL USUARIO
	*/
	private String myCwprg_pregunta;
	/**
	* RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	private String myCwprg_respuesta;
	/**
	* OBSERVACION REFERENTE AL MODULO
	*/
	private String myCwprg_observacion;
	/**
	* ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	*/
	private int myCwprg_prioridad;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCwprg_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCwprg_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCwprg_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_preguntas
	*/
	public Cgg_web_preguntas(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_web_preguntas
	* @param inCwprg_codigo IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	* @param inCwmod_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCwprg_pregunta PREGUNTA EMITIDA POR EL USUARIO
	* @param inCwprg_respuesta RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	* @param inCwprg_observacion OBSERVACION REFERENTE AL MODULO
	* @param inCwprg_prioridad ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	* @param inCwprg_estado ESTADO DEL REGISTRO
	* @param inCwprg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwprg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_web_preguntas(
		String inCwprg_codigo,
		String inCwmod_codigo,
		String inCwprg_pregunta,
		String inCwprg_respuesta,
		String inCwprg_observacion,
		int inCwprg_prioridad,
		boolean inCwprg_estado,
		String inCwprg_usuario_insert,
		String inCwprg_usuario_update
	){
		this.setCWPRG_CODIGO(inCwprg_codigo);
		this.setCWMOD_CODIGO(inCwmod_codigo);
		this.setCWPRG_PREGUNTA(inCwprg_pregunta);
		this.setCWPRG_RESPUESTA(inCwprg_respuesta);
		this.setCWPRG_OBSERVACION(inCwprg_observacion);
		this.setCWPRG_PRIORIDAD(inCwprg_prioridad);
		this.setCWPRG_ESTADO(inCwprg_estado);
		this.setCWPRG_USUARIO_INSERT(inCwprg_usuario_insert);
		this.setCWPRG_USUARIO_UPDATE(inCwprg_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	* @param inCwprg_codigo IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	public void setCWPRG_CODIGO(String inCwprg_codigo){
		this.myCwprg_codigo = inCwprg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	* @return String IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	public String getCWPRG_CODIGO(){
		return this.myCwprg_codigo;
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
	* @param inCwprg_pregunta PREGUNTA EMITIDA POR EL USUARIO
	*/
	public void setCWPRG_PREGUNTA(String inCwprg_pregunta){
		this.myCwprg_pregunta = inCwprg_pregunta;
	}
	/**
	* OBTIENE PREGUNTA EMITIDA POR EL USUARIO
	* @return String PREGUNTA EMITIDA POR EL USUARIO
	*/
	public String getCWPRG_PREGUNTA(){
		return this.myCwprg_pregunta;
	}

	/**
	* ESTABLECE RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	* @param inCwprg_respuesta RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	public void setCWPRG_RESPUESTA(String inCwprg_respuesta){
		this.myCwprg_respuesta = inCwprg_respuesta;
	}
	/**
	* OBTIENE RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	* @return String RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	public String getCWPRG_RESPUESTA(){
		return this.myCwprg_respuesta;
	}

	/**
	* ESTABLECE OBSERVACION REFERENTE AL MODULO
	* @param inCwprg_observacion OBSERVACION REFERENTE AL MODULO
	*/
	public void setCWPRG_OBSERVACION(String inCwprg_observacion){
		this.myCwprg_observacion = inCwprg_observacion;
	}
	/**
	* OBTIENE OBSERVACION REFERENTE AL MODULO
	* @return String OBSERVACION REFERENTE AL MODULO
	*/
	public String getCWPRG_OBSERVACION(){
		return this.myCwprg_observacion;
	}

	/**
	* ESTABLECE ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	* @param inCwprg_prioridad ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	*/
	public void setCWPRG_PRIORIDAD(int inCwprg_prioridad){
		this.myCwprg_prioridad = inCwprg_prioridad;
	}
	/**
	* OBTIENE ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	* @return int ALMACENA LA PRIORIDAD DE LA PREGUNTA.
0 - BUENA
1 - MALA
2 - PESIMA
	*/
	public int getCWPRG_PRIORIDAD(){
		return this.myCwprg_prioridad;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCwprg_estado ESTADO DEL REGISTRO
	*/
	public void setCWPRG_ESTADO(boolean inCwprg_estado){
		this.myCwprg_estado = inCwprg_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCWPRG_ESTADO(){
		return this.myCwprg_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCwprg_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCWPRG_USUARIO_INSERT(String inCwprg_usuario_insert){
		this.myCwprg_usuario_insert = inCwprg_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCWPRG_USUARIO_INSERT(){
		return this.myCwprg_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCwprg_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCWPRG_USUARIO_UPDATE(String inCwprg_usuario_update){
		this.myCwprg_usuario_update = inCwprg_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCWPRG_USUARIO_UPDATE(){
		return this.myCwprg_usuario_update;
	}

}
