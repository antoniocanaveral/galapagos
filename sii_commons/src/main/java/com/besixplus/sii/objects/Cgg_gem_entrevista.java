package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_entrevista
* TABLA: ENTREVISTA
* DESCRIPCION:ALMACENA INFORMACION DE LAS ENTREVISTAS PLANIFICADAS PARA LA COBERTURA DE UNA VACANTE
* ABREVIATURA:CGENT
*/
public class Cgg_gem_entrevista implements Serializable{
	private static final long serialVersionUID = 1557024093;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
	*/
	private String myCgent_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	*/
	private String myCgcnd_codigo;
	/**
	* ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
	*/
	private String myCgent_estado_entrevista;
	/**
	* FECHA DE REALIZACION DE LA ENTREVISTA
	*/
	private java.util.Date myCgent_fecha_realizacion;
	/**
	* LUGAR DE REALIZACION DE LA ENTREVISTA
	*/
	private String myCgent_lugar;
	/**
	* OBSERVACION DE LA ENTREVISTA
	*/
	private String myCgent_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgent_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgent_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgent_usuario_update;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgent_criterio_tecnico;
	/**
	**/
	private java.util.Date myCgent_fecha_criterio_tecnico;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_entrevista
	*/
	public Cgg_gem_entrevista(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_entrevista
	* @param inCgent_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
	* @param inCgcnd_codigo IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	* @param inCgent_estado_entrevista ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
	* @param inCgent_fecha_realizacion FECHA DE REALIZACION DE LA ENTREVISTA
	* @param inCgent_lugar LUGAR DE REALIZACION DE LA ENTREVISTA
	* @param inCgent_observacion OBSERVACION DE LA ENTREVISTA
	* @param inCgent_estado ESTADO DEL REGISTRO
	* @param inCgent_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgent_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgent_criterio_tecnico NO ESPECIFICADO
	* @param inCgent_fecha_criterio_tecnico TABLA: ENTREVISTA
DESCRIPCION:ALMACENA INFORMACION DE LAS ENTREVISTAS PLANIFICADAS PARA LA COBERTURA DE UNA VACANTE
ABREVIATURA:CGENT
	*/
	public Cgg_gem_entrevista(
		String inCgent_codigo,
		String inCgcnd_codigo,
		String inCgent_estado_entrevista,
		java.util.Date inCgent_fecha_realizacion,
		String inCgent_lugar,
		String inCgent_observacion,
		boolean inCgent_estado,
		String inCgent_usuario_insert,
		String inCgent_usuario_update,
		String inCgent_criterio_tecnico,
		java.util.Date inCgent_fecha_criterio_tecnico
	){
		this.setCGENT_CODIGO(inCgent_codigo);
		this.setCGCND_CODIGO(inCgcnd_codigo);
		this.setCGENT_ESTADO_ENTREVISTA(inCgent_estado_entrevista);
		this.setCGENT_FECHA_REALIZACION(inCgent_fecha_realizacion);
		this.setCGENT_LUGAR(inCgent_lugar);
		this.setCGENT_OBSERVACION(inCgent_observacion);
		this.setCGENT_ESTADO(inCgent_estado);
		this.setCGENT_USUARIO_INSERT(inCgent_usuario_insert);
		this.setCGENT_USUARIO_UPDATE(inCgent_usuario_update);
		this.setCGENT_CRITERIO_TECNICO(inCgent_criterio_tecnico);
		this.setCGENT_FECHA_CRITERIO_TECNICO(inCgent_fecha_criterio_tecnico);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
	* @param inCgent_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
	*/
	public void setCGENT_CODIGO(String inCgent_codigo){
		this.myCgent_codigo = inCgent_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
	*/
	public String getCGENT_CODIGO(){
		return this.myCgent_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	* @param inCgcnd_codigo IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	*/
	public void setCGCND_CODIGO(String inCgcnd_codigo){
		this.myCgcnd_codigo = inCgcnd_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	*/
	public String getCGCND_CODIGO(){
		return this.myCgcnd_codigo;
	}

	/**
	* ESTABLECE ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
	* @param inCgent_estado_entrevista ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
	*/
	public void setCGENT_ESTADO_ENTREVISTA(String inCgent_estado_entrevista){
		this.myCgent_estado_entrevista = inCgent_estado_entrevista;
	}
	/**
	* OBTIENE ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
	* @return String ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
	*/
	public String getCGENT_ESTADO_ENTREVISTA(){
		return this.myCgent_estado_entrevista;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DE LA ENTREVISTA
	* @param inCgent_fecha_realizacion FECHA DE REALIZACION DE LA ENTREVISTA
	*/
	public void setCGENT_FECHA_REALIZACION(java.util.Date inCgent_fecha_realizacion){
		this.myCgent_fecha_realizacion = inCgent_fecha_realizacion;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DE LA ENTREVISTA
	* @return java.util.Date FECHA DE REALIZACION DE LA ENTREVISTA
	*/
	public java.util.Date getCGENT_FECHA_REALIZACION(){
		return this.myCgent_fecha_realizacion;
	}

	/**
	* ESTABLECE LUGAR DE REALIZACION DE LA ENTREVISTA
	* @param inCgent_lugar LUGAR DE REALIZACION DE LA ENTREVISTA
	*/
	public void setCGENT_LUGAR(String inCgent_lugar){
		this.myCgent_lugar = inCgent_lugar;
	}
	/**
	* OBTIENE LUGAR DE REALIZACION DE LA ENTREVISTA
	* @return String LUGAR DE REALIZACION DE LA ENTREVISTA
	*/
	public String getCGENT_LUGAR(){
		return this.myCgent_lugar;
	}

	/**
	* ESTABLECE OBSERVACION DE LA ENTREVISTA
	* @param inCgent_observacion OBSERVACION DE LA ENTREVISTA
	*/
	public void setCGENT_OBSERVACION(String inCgent_observacion){
		this.myCgent_observacion = inCgent_observacion;
	}
	/**
	* OBTIENE OBSERVACION DE LA ENTREVISTA
	* @return String OBSERVACION DE LA ENTREVISTA
	*/
	public String getCGENT_OBSERVACION(){
		return this.myCgent_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgent_estado ESTADO DEL REGISTRO
	*/
	public void setCGENT_ESTADO(boolean inCgent_estado){
		this.myCgent_estado = inCgent_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGENT_ESTADO(){
		return this.myCgent_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgent_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGENT_USUARIO_INSERT(String inCgent_usuario_insert){
		this.myCgent_usuario_insert = inCgent_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGENT_USUARIO_INSERT(){
		return this.myCgent_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgent_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGENT_USUARIO_UPDATE(String inCgent_usuario_update){
		this.myCgent_usuario_update = inCgent_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGENT_USUARIO_UPDATE(){
		return this.myCgent_usuario_update;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgent_criterio_tecnico NO ESPECIFICADO
	*/
	public void setCGENT_CRITERIO_TECNICO(String inCgent_criterio_tecnico){
		this.myCgent_criterio_tecnico = inCgent_criterio_tecnico;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGENT_CRITERIO_TECNICO(){
		return this.myCgent_criterio_tecnico;
	}

	/**
	* ESTABLECE TABLA: ENTREVISTA
DESCRIPCION:ALMACENA INFORMACION DE LAS ENTREVISTAS PLANIFICADAS PARA LA COBERTURA DE UNA VACANTE
ABREVIATURA:CGENT
	* @param inCgent_fecha_criterio_tecnico TABLA: ENTREVISTA
DESCRIPCION:ALMACENA INFORMACION DE LAS ENTREVISTAS PLANIFICADAS PARA LA COBERTURA DE UNA VACANTE
ABREVIATURA:CGENT
	*/
	public void setCGENT_FECHA_CRITERIO_TECNICO(java.util.Date inCgent_fecha_criterio_tecnico){
		this.myCgent_fecha_criterio_tecnico = inCgent_fecha_criterio_tecnico;
	}
	/**
	* OBTIENE TABLA: ENTREVISTA
DESCRIPCION:ALMACENA INFORMACION DE LAS ENTREVISTAS PLANIFICADAS PARA LA COBERTURA DE UNA VACANTE
ABREVIATURA:CGENT
	* @return java.util.Date TABLA: ENTREVISTA
DESCRIPCION:ALMACENA INFORMACION DE LAS ENTREVISTAS PLANIFICADAS PARA LA COBERTURA DE UNA VACANTE
ABREVIATURA:CGENT
	*/
	public java.util.Date getCGENT_FECHA_CRITERIO_TECNICO(){
		return this.myCgent_fecha_criterio_tecnico;
	}

}
