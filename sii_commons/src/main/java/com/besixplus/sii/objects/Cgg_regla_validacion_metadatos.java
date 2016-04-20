package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_regla_validacion_metadatos
* TABLA: 
* DESCRIPCION:ALMACENA INFORMACION DE LAS REGLAS DE VALIDACION
* ABREVIATURA:
*/
public class Cgg_regla_validacion_metadatos implements Serializable{
	private static final long serialVersionUID = 1177168384;
	/**
	* IDENTIFICATIVO DEL NOMBRE DE LA FUNCION. PRONAME
	*/
	private String myNombreFuncion;
	/**
	* NUMERO DE PARAMETROS DE LA FUNCION. PRONARGS
	*/
	private int myNumeroArgumentos;
	/**
	* DESCRIPCION DE LOS ARGUMENTOS DE LA FUNCION. PROARGNAMES
	*/
	private String myNombreArgumentos;
	/**
	* TIPO DE DATO DE RESPUESTA DE LA FUNCION. TYPNAME
	*/
	private String myTipoRespuesta;
	/**
	* TIPO DE DATO DE LOS PARAMETROS DE LA FUNCION. PROARGSTYPE
	*/
	private String myTipoDatoArgumentos;
	
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_regla_validacion
	*/
	public Cgg_regla_validacion_metadatos(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_regla_validacion
	* @param inNombreFuncion NOMBRE DE LA FUNCION
	 * @param inNumeroArgumentos NUMERO DE ARGUMENTOS	
	 * @param inNombreArgumentos NOMBRE DE LOS ARGUMENTOS
	 * @param inTipoRespuesta TIPO DE RESPUESTA
	 * @param inPTipoDatoArgumentos TIPO DE DATO DEL ARGUMENTO
	* @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	*/
	public Cgg_regla_validacion_metadatos(
		String inNombreFuncion,
		int inNumeroArgumentos,
		String inNombreArgumentos,
		String inTipoRespuesta,
		String inPTipoDatoArgumentos
	){
		this.setNOMBREFUNCION(inNombreFuncion);
		this.setNUMEROARGUMENTOS(inNumeroArgumentos);
		this.setNOMBREARGUMENTOS(inNombreArgumentos);
		this.setTIPORESPUESTA(inTipoRespuesta);
		this.setTIPODATOARGUMENTOS(inPTipoDatoArgumentos);
	}
	/**
	 * OBTIENE EL IDENTIFICATIVO DEL NOMBRE DE LA FUNCION
	 * @return the myNombreFuncion
	 */
	public String getNOMBREFUNCION() {
		return myNombreFuncion;
	}
	/**
	 * ESTABLECE EL IDENTIFICATIVO DEL NOMBRE DE LA FUNCION
	 * @param inNombreFuncion 
	 */
	public void setNOMBREFUNCION(String inNombreFuncion) {
		this.myNombreFuncion = inNombreFuncion;
	}
	/**
	 * OBTIENE EL NUMERO DE PARAMETROS DE LA FUNCION
	 * @return the myNumeroArgumentos
	 */
	public int getNUMEROARGUMENTOS() {
		return myNumeroArgumentos;
	}
	/**
	 * ESTABLECE NUMERO DE PARAMETROS DE LA FUNCION
	 * @param inNumeroArgumentos 
	 */
	public void setNUMEROARGUMENTOS(int inNumeroArgumentos) {
		this.myNumeroArgumentos = inNumeroArgumentos;
	}
	/**
	 * OBTIENE LA DESCRIPCION DE LOS ARGUMENTOS DE LA FUNCION
	 * @return the myNombreArgumentos
	 */
	public String getNOMBREARGUMENTOS() {
		return myNombreArgumentos;
	}
	/**
	 * ESTABLECE LA DESCRIPCION DE LOS ARGUMENTOS DE LA FUNCION
	 * @param inNombreArgumentos 
	 */
	public void setNOMBREARGUMENTOS(String inNombreArgumentos) {
		this.myNombreArgumentos = inNombreArgumentos;
	}
	/**
	 * OBTIENE EL TIPO DE DATO DE RESPUESTA DE LA FUNCION.
	 * @return the myTipoRespuesta
	 */
	public String getTIPORESPUESTA() {
		return myTipoRespuesta;
	}
	/**
	 * ESTABLECE EL TIPO DE DATO DE RESPUESTA DE LA FUNCION.
	 * @param inTipoRespuesta 
	 */
	public void setTIPORESPUESTA(String inTipoRespuesta) {
		this.myTipoRespuesta = inTipoRespuesta;
	}
	/**
	 * OBTIENE EL TIPO DE DATO DE LOS PARAMETROS DE LA FUNCION
	 * @return the myTipoDatoArgumentos
	 */
	public String getTIPODATOARGUMENTOS() {
		return myTipoDatoArgumentos;
	}
	/**
	 * ESTABLECE TIPO DE DATO DE LOS PARAMETROS DE LA FUNCION
	 * @param inTipoDatoArgumentos
	 */
	public void setTIPODATOARGUMENTOS(String inTipoDatoArgumentos) {
		this.myTipoDatoArgumentos = inTipoDatoArgumentos;
	}
	
	
}