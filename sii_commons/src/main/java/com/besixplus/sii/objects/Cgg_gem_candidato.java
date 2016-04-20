package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_candidato
* TABLA: CANDIDATO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CANDIDATOS QUE APLICARON PARA LA VACANTE.
* ABREVIATURA:CGCND
*/
public class Cgg_gem_candidato implements Serializable{
	private static final long serialVersionUID = 1225706275;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	*/
	private String myCgcnd_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	*/
	private String myCgvcn_codigo;
	/**
	* FECHA TENTATIVA PARA LA ENTREVISTA
	*/
	private java.util.Date myCgcnd_fecha_entrevista;
	/**
	* VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	*/
	private java.math.BigDecimal myCgcnd_aspiracion_salarial;
	/**
	* OBSERVACION QUE USUARIO REGISTRA AL APLICAR PARA UNA OFERTA
	*/
	private String myCgcnd_observacion;
	/**
	* DESCRIPCION DETALLADA DE PARTE DEL AMINISTRADOR A LA ACEPTACION O RECHAZO DEL CANDIDATO
	*/
	private String myCgcnd_descripcion;
	/**
	* SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
0 - NO SELECCIONADO
1 - SELECCIONADO PARA LA ENTREVISTA
2 - RECHAZADO  PARA LA ENTREVISTA
3 - SELECCIONADO PARA EL TRABAJO
	*/
	private int myCgcnd_seleccionado;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgcnd_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgcnd_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgcnd_usuario_update;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCgcnd_fecha_seleccion;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgcnd_detalle;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgcnd_motivo_salida;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCgcnd_fecha_salida;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_candidato
	*/
	public Cgg_gem_candidato(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_candidato
	* @param inCgcnd_codigo IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	* @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	* @param inCgcnd_fecha_entrevista FECHA TENTATIVA PARA LA ENTREVISTA
	* @param inCgcnd_aspiracion_salarial VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	* @param inCgcnd_observacion OBSERVACION QUE USUARIO REGISTRA AL APLICAR PARA UNA OFERTA
	* @param inCgcnd_descripcion DESCRIPCION DETALLADA DE PARTE DEL AMINISTRADOR A LA ACEPTACION O RECHAZO DEL CANDIDATO
	* @param inCgcnd_seleccionado SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
0 - NO SELECCIONADO
1 - SELECCIONADO PARA LA ENTREVISTA
2 - RECHAZADO  PARA LA ENTREVISTA
3 - SELECCIONADO PARA EL TRABAJO
	* @param inCgcnd_estado ESTADO DEL REGISTRO
	* @param inCgcnd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgcnd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgcnd_fecha_seleccion NO ESPECIFICADO
	* @param inCgcnd_detalle NO ESPECIFICADO
	* @param inCgcnd_motivo_salida NO ESPECIFICADO
	* @param inCgcnd_fecha_salida NO ESPECIFICADO
	*/
	public Cgg_gem_candidato(
		String inCgcnd_codigo,
		String inCusu_codigo,
		String inCgvcn_codigo,
		java.util.Date inCgcnd_fecha_entrevista,
		java.math.BigDecimal inCgcnd_aspiracion_salarial,
		String inCgcnd_observacion,
		String inCgcnd_descripcion,
		int inCgcnd_seleccionado,
		boolean inCgcnd_estado,
		String inCgcnd_usuario_insert,
		String inCgcnd_usuario_update,
		java.util.Date inCgcnd_fecha_seleccion,
		String inCgcnd_detalle,
		String inCgcnd_motivo_salida,
		java.util.Date inCgcnd_fecha_salida
	){
		this.setCGCND_CODIGO(inCgcnd_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGVCN_CODIGO(inCgvcn_codigo);
		this.setCGCND_FECHA_ENTREVISTA(inCgcnd_fecha_entrevista);
		this.setCGCND_ASPIRACION_SALARIAL(inCgcnd_aspiracion_salarial);
		this.setCGCND_OBSERVACION(inCgcnd_observacion);
		this.setCGCND_DESCRIPCION(inCgcnd_descripcion);
		this.setCGCND_SELECCIONADO(inCgcnd_seleccionado);
		this.setCGCND_ESTADO(inCgcnd_estado);
		this.setCGCND_USUARIO_INSERT(inCgcnd_usuario_insert);
		this.setCGCND_USUARIO_UPDATE(inCgcnd_usuario_update);
		this.setCGCND_FECHA_SELECCION(inCgcnd_fecha_seleccion);
		this.setCGCND_DETALLE(inCgcnd_detalle);
		this.setCGCND_MOTIVO_SALIDA(inCgcnd_motivo_salida);
		this.setCGCND_FECHA_SALIDA(inCgcnd_fecha_salida);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
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
	* ESTABLECE FECHA TENTATIVA PARA LA ENTREVISTA
	* @param inCgcnd_fecha_entrevista FECHA TENTATIVA PARA LA ENTREVISTA
	*/
	public void setCGCND_FECHA_ENTREVISTA(java.util.Date inCgcnd_fecha_entrevista){
		this.myCgcnd_fecha_entrevista = inCgcnd_fecha_entrevista;
	}
	/**
	* OBTIENE FECHA TENTATIVA PARA LA ENTREVISTA
	* @return java.util.Date FECHA TENTATIVA PARA LA ENTREVISTA
	*/
	public java.util.Date getCGCND_FECHA_ENTREVISTA(){
		return this.myCgcnd_fecha_entrevista;
	}

	/**
	* ESTABLECE VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	* @param inCgcnd_aspiracion_salarial VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	*/
	public void setCGCND_ASPIRACION_SALARIAL(java.math.BigDecimal inCgcnd_aspiracion_salarial){
		this.myCgcnd_aspiracion_salarial = inCgcnd_aspiracion_salarial;
	}
	/**
	* OBTIENE VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	* @return java.math.BigDecimal VALOR APROXIMADO A PERCIBIR POR EL TRABAJO REALIZADO
	*/
	public java.math.BigDecimal getCGCND_ASPIRACION_SALARIAL(){
		return this.myCgcnd_aspiracion_salarial;
	}

	/**
	* ESTABLECE OBSERVACION QUE USUARIO REGISTRA AL APLICAR PARA UNA OFERTA
	* @param inCgcnd_observacion OBSERVACION QUE USUARIO REGISTRA AL APLICAR PARA UNA OFERTA
	*/
	public void setCGCND_OBSERVACION(String inCgcnd_observacion){
		this.myCgcnd_observacion = inCgcnd_observacion;
	}
	/**
	* OBTIENE OBSERVACION QUE USUARIO REGISTRA AL APLICAR PARA UNA OFERTA
	* @return String OBSERVACION QUE USUARIO REGISTRA AL APLICAR PARA UNA OFERTA
	*/
	public String getCGCND_OBSERVACION(){
		return this.myCgcnd_observacion;
	}

	/**
	* ESTABLECE DESCRIPCION DETALLADA DE PARTE DEL AMINISTRADOR A LA ACEPTACION O RECHAZO DEL CANDIDATO
	* @param inCgcnd_descripcion DESCRIPCION DETALLADA DE PARTE DEL AMINISTRADOR A LA ACEPTACION O RECHAZO DEL CANDIDATO
	*/
	public void setCGCND_DESCRIPCION(String inCgcnd_descripcion){
		this.myCgcnd_descripcion = inCgcnd_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DETALLADA DE PARTE DEL AMINISTRADOR A LA ACEPTACION O RECHAZO DEL CANDIDATO
	* @return String DESCRIPCION DETALLADA DE PARTE DEL AMINISTRADOR A LA ACEPTACION O RECHAZO DEL CANDIDATO
	*/
	public String getCGCND_DESCRIPCION(){
		return this.myCgcnd_descripcion;
	}

	/**
	* ESTABLECE SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
0 - NO SELECCIONADO
1 - SELECCIONADO PARA LA ENTREVISTA
2 - RECHAZADO  PARA LA ENTREVISTA
3 - SELECCIONADO PARA EL TRABAJO
	* @param inCgcnd_seleccionado SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
0 - NO SELECCIONADO
1 - SELECCIONADO PARA LA ENTREVISTA
2 - RECHAZADO  PARA LA ENTREVISTA
3 - SELECCIONADO PARA EL TRABAJO
	*/
	public void setCGCND_SELECCIONADO(int inCgcnd_seleccionado){
		this.myCgcnd_seleccionado = inCgcnd_seleccionado;
	}
	/**
	* OBTIENE SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
0 - NO SELECCIONADO
1 - SELECCIONADO PARA LA ENTREVISTA
2 - RECHAZADO  PARA LA ENTREVISTA
3 - SELECCIONADO PARA EL TRABAJO
	* @return int SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
0 - NO SELECCIONADO
1 - SELECCIONADO PARA LA ENTREVISTA
2 - RECHAZADO  PARA LA ENTREVISTA
3 - SELECCIONADO PARA EL TRABAJO
	*/
	public int getCGCND_SELECCIONADO(){
		return this.myCgcnd_seleccionado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgcnd_estado ESTADO DEL REGISTRO
	*/
	public void setCGCND_ESTADO(boolean inCgcnd_estado){
		this.myCgcnd_estado = inCgcnd_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGCND_ESTADO(){
		return this.myCgcnd_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgcnd_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGCND_USUARIO_INSERT(String inCgcnd_usuario_insert){
		this.myCgcnd_usuario_insert = inCgcnd_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGCND_USUARIO_INSERT(){
		return this.myCgcnd_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgcnd_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGCND_USUARIO_UPDATE(String inCgcnd_usuario_update){
		this.myCgcnd_usuario_update = inCgcnd_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGCND_USUARIO_UPDATE(){
		return this.myCgcnd_usuario_update;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgcnd_fecha_seleccion NO ESPECIFICADO
	*/
	public void setCGCND_FECHA_SELECCION(java.util.Date inCgcnd_fecha_seleccion){
		this.myCgcnd_fecha_seleccion = inCgcnd_fecha_seleccion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCGCND_FECHA_SELECCION(){
		return this.myCgcnd_fecha_seleccion;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgcnd_detalle NO ESPECIFICADO
	*/
	public void setCGCND_DETALLE(String inCgcnd_detalle){
		this.myCgcnd_detalle = inCgcnd_detalle;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGCND_DETALLE(){
		return this.myCgcnd_detalle;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgcnd_motivo_salida NO ESPECIFICADO
	*/
	public void setCGCND_MOTIVO_SALIDA(String inCgcnd_motivo_salida){
		this.myCgcnd_motivo_salida = inCgcnd_motivo_salida;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGCND_MOTIVO_SALIDA(){
		return this.myCgcnd_motivo_salida;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgcnd_fecha_salida NO ESPECIFICADO
	*/
	public void setCGCND_FECHA_SALIDA(java.util.Date inCgcnd_fecha_salida){
		this.myCgcnd_fecha_salida = inCgcnd_fecha_salida;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCGCND_FECHA_SALIDA(){
		return this.myCgcnd_fecha_salida;
	}

}
