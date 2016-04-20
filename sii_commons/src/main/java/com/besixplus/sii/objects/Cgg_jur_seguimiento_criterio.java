package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_seguimiento_criterio
* TABLA: SEGUIMIENTO CRITERIO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CRITERIOS QUE SE PUEDEN REGISTRAR POR CADA SEGUIMIENTO
* ABREVIATURA:CJSGC
*/
public class Cgg_jur_seguimiento_criterio implements Serializable{
	private static final long serialVersionUID = 877509336;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	*/
	private String myCjsgc_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	private String myCrseg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	*/
	private String myCjcri_codigo;
	/**
	* RESPUESTA DEL CRITERIO
SI / NO
	*/
	private boolean myCjsgc_respuesta;
	/**
	* RAZON QUE RESPALDA LA RESPUESTA
	*/
	private String myCjsgc_justificacion;
	/**
	* NO ESPECIFICADO
	*/
	private String myCjsgc_observacion;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCjsgc_nombre_adjunto;
	/**
	* ARCHIVO DIGITAL ANEXO AL CRITERIO
	*/
	private byte[] myCjsgc_adjunto;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCjsgc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjsgc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjsgc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_seguimiento_criterio
	*/
	public Cgg_jur_seguimiento_criterio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_seguimiento_criterio
	* @param inCjsgc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCjcri_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	* @param inCjsgc_respuesta RESPUESTA DEL CRITERIO
SI / NO
	* @param inCjsgc_justificacion RAZON QUE RESPALDA LA RESPUESTA
	* @param inCjsgc_observacion NO ESPECIFICADO
	* @param inCjsgc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCjsgc_adjunto ARCHIVO DIGITAL ANEXO AL CRITERIO
	* @param inCjsgc_estado ESTADO DEL REGISTRO
	* @param inCjsgc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjsgc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_seguimiento_criterio(
		String inCjsgc_codigo,
		String inCrseg_codigo,
		String inCjcri_codigo,
		boolean inCjsgc_respuesta,
		String inCjsgc_justificacion,
		String inCjsgc_observacion,
		String inCjsgc_nombre_adjunto,
		byte[] inCjsgc_adjunto,
		boolean inCjsgc_estado,
		String inCjsgc_usuario_insert,
		String inCjsgc_usuario_update
	){
		this.setCJSGC_CODIGO(inCjsgc_codigo);
		this.setCRSEG_CODIGO(inCrseg_codigo);
		this.setCJCRI_CODIGO(inCjcri_codigo);
		this.setCJSGC_RESPUESTA(inCjsgc_respuesta);
		this.setCJSGC_JUSTIFICACION(inCjsgc_justificacion);
		this.setCJSGC_OBSERVACION(inCjsgc_observacion);
		this.setCJSGC_NOMBRE_ADJUNTO(inCjsgc_nombre_adjunto);
		this.setCJSGC_ADJUNTO(inCjsgc_adjunto);
		this.setCJSGC_ESTADO(inCjsgc_estado);
		this.setCJSGC_USUARIO_INSERT(inCjsgc_usuario_insert);
		this.setCJSGC_USUARIO_UPDATE(inCjsgc_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	* @param inCjsgc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	*/
	public void setCJSGC_CODIGO(String inCjsgc_codigo){
		this.myCjsgc_codigo = inCjsgc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	*/
	public String getCJSGC_CODIGO(){
		return this.myCjsgc_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	* @param inCjcri_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	*/
	public void setCJCRI_CODIGO(String inCjcri_codigo){
		this.myCjcri_codigo = inCjcri_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	*/
	public String getCJCRI_CODIGO(){
		return this.myCjcri_codigo;
	}

	/**
	* ESTABLECE RESPUESTA DEL CRITERIO
SI / NO
	* @param inCjsgc_respuesta RESPUESTA DEL CRITERIO
SI / NO
	*/
	public void setCJSGC_RESPUESTA(boolean inCjsgc_respuesta){
		this.myCjsgc_respuesta = inCjsgc_respuesta;
	}
	/**
	* OBTIENE RESPUESTA DEL CRITERIO
SI / NO
	* @return boolean RESPUESTA DEL CRITERIO
SI / NO
	*/
	public boolean getCJSGC_RESPUESTA(){
		return this.myCjsgc_respuesta;
	}

	/**
	* ESTABLECE RAZON QUE RESPALDA LA RESPUESTA
	* @param inCjsgc_justificacion RAZON QUE RESPALDA LA RESPUESTA
	*/
	public void setCJSGC_JUSTIFICACION(String inCjsgc_justificacion){
		this.myCjsgc_justificacion = inCjsgc_justificacion;
	}
	/**
	* OBTIENE RAZON QUE RESPALDA LA RESPUESTA
	* @return String RAZON QUE RESPALDA LA RESPUESTA
	*/
	public String getCJSGC_JUSTIFICACION(){
		return this.myCjsgc_justificacion;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCjsgc_observacion NO ESPECIFICADO
	*/
	public void setCJSGC_OBSERVACION(String inCjsgc_observacion){
		this.myCjsgc_observacion = inCjsgc_observacion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCJSGC_OBSERVACION(){
		return this.myCjsgc_observacion;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCjsgc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCJSGC_NOMBRE_ADJUNTO(String inCjsgc_nombre_adjunto){
		this.myCjsgc_nombre_adjunto = inCjsgc_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCJSGC_NOMBRE_ADJUNTO(){
		return this.myCjsgc_nombre_adjunto;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL ANEXO AL CRITERIO
	* @param inCjsgc_adjunto ARCHIVO DIGITAL ANEXO AL CRITERIO
	*/
	public void setCJSGC_ADJUNTO(byte[] inCjsgc_adjunto){
		this.myCjsgc_adjunto = inCjsgc_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL ANEXO AL CRITERIO
	* @return byte[] ARCHIVO DIGITAL ANEXO AL CRITERIO
	*/
	public byte[] getCJSGC_ADJUNTO(){
		return this.myCjsgc_adjunto;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCjsgc_estado ESTADO DEL REGISTRO
	*/
	public void setCJSGC_ESTADO(boolean inCjsgc_estado){
		this.myCjsgc_estado = inCjsgc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCJSGC_ESTADO(){
		return this.myCjsgc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjsgc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJSGC_USUARIO_INSERT(String inCjsgc_usuario_insert){
		this.myCjsgc_usuario_insert = inCjsgc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJSGC_USUARIO_INSERT(){
		return this.myCjsgc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjsgc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJSGC_USUARIO_UPDATE(String inCjsgc_usuario_update){
		this.myCjsgc_usuario_update = inCjsgc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJSGC_USUARIO_UPDATE(){
		return this.myCjsgc_usuario_update;
	}

}
