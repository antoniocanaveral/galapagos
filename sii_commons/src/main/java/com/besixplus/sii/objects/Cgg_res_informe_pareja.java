package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_informe_pareja
* TABLA: INFORME
* DESCRIPCION:ALMACENA INFORMACION DE LOS INFORMES GENERADOS DESDE SEGUIMIENTO DE PAREJAS
* ABREVIATURA:CRINF
*/
public class Cgg_res_informe_pareja implements Serializable{
	private static final long serialVersionUID = 710791392;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrinf_codigo;
	/**
	* INFORMACION DEL ADJUNTO
	*/
	private String myCodigoAdjunto;
	/**
	* INFORMACION DEL ADJUNTO
	*/
	private String myAdjunto;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrofm_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO
	*/
	private String myCrmtr_codigo;
	/**
	* FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
	*/
	private java.util.Date myCrinf_fecha_entrega;
	/**
	* RESUMEN DEL CONTENIDO DEL INFORME
	*/
	private String myCrinf_extracto;
	/**
	* NUMERO SECUENCIAL DE INFORME
	*/
	private String myCrinf_numero_documento;
	/**
	* INFORMACION ADICIONAL - HISTORIAL JSON
	*/
	private String myCrinf_observacion;	
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrinf_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrinf_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrinf_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_pareja
	*/
	public Cgg_res_informe_pareja(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_informe_pareja
	* @param inCrinf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrofm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrinf_fecha_entrega FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
	* @param inCrinf_extracto RESUMEN DEL CONTENIDO DEL INFORME
	* @param inCrinf_numero_documento NUMERO SECUENCIAL DE INFORME
	* @param inCrinf_observacion INFORMACION ADICIONAL - HISTORIAL JSON
	* @param inCrinf_estado ESTADO DEL REGISTRO
	* @param inCrinf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrinf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_informe_pareja(
		String inCrinf_codigo,
		String inCrofm_codigo,
		java.util.Date inCrinf_fecha_entrega,
		String inCrinf_extracto,
		String inCrinf_numero_documento,
		String inCrinf_observacion,
		boolean inCrinf_estado,
		String inCrinf_usuario_insert,
		String inCrinf_usuario_update
	){
		this.setCRINF_CODIGO(inCrinf_codigo);
		this.setCROFM_CODIGO(inCrofm_codigo);
		this.setCRINF_FECHA_ENTREGA(inCrinf_fecha_entrega);
		this.setCRINF_EXTRACTO(inCrinf_extracto);
		this.setCRINF_NUMERO_DOCUMENTO(inCrinf_numero_documento);
		this.setCRINF_OBSERVACION(inCrinf_observacion);
		this.setCRINF_ESTADO(inCrinf_estado);
		this.setCRINF_USUARIO_INSERT(inCrinf_usuario_insert);
		this.setCRINF_USUARIO_UPDATE(inCrinf_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrinf_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRINF_CODIGO(String inCrinf_codigo){
		this.myCrinf_codigo = inCrinf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRINF_CODIGO(){
		return this.myCrinf_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrofm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCROFM_CODIGO(String inCrofm_codigo){
		this.myCrofm_codigo = inCrofm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCROFM_CODIGO(){
		return this.myCrofm_codigo;
	}

	/**
	* ESTABLECE FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
	* @param inCrinf_fecha_entrega FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
	*/
	public void setCRINF_FECHA_ENTREGA(java.util.Date inCrinf_fecha_entrega){
		this.myCrinf_fecha_entrega = inCrinf_fecha_entrega;
	}
	/**
	* OBTIENE FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
	* @return java.util.Date FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
	*/
	public java.util.Date getCRINF_FECHA_ENTREGA(){
		return this.myCrinf_fecha_entrega;
	}

	/**
	* ESTABLECE RESUMEN DEL CONTENIDO DEL INFORME
	* @param inCrinf_extracto RESUMEN DEL CONTENIDO DEL INFORME
	*/
	public void setCRINF_EXTRACTO(String inCrinf_extracto){
		this.myCrinf_extracto = inCrinf_extracto;
	}
	/**
	* OBTIENE RESUMEN DEL CONTENIDO DEL INFORME
	* @return String RESUMEN DEL CONTENIDO DEL INFORME
	*/
	public String getCRINF_EXTRACTO(){
		return this.myCrinf_extracto;
	}

	/**
	* ESTABLECE NUMERO SECUENCIAL DE INFORME
	* @param inCrinf_numero_documento NUMERO SECUENCIAL DE INFORME
	*/
	public void setCRINF_NUMERO_DOCUMENTO(String inCrinf_numero_documento){
		this.myCrinf_numero_documento = inCrinf_numero_documento;
	}
	/**
	* OBTIENE NUMERO SECUENCIAL DE INFORME
	* @return String NUMERO SECUENCIAL DE INFORME
	*/
	public String getCRINF_NUMERO_DOCUMENTO(){
		return this.myCrinf_numero_documento;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL - HISTORIAL JSON
	* @param inCrinf_observacion INFORMACION ADICIONAL - HISTORIAL JSON
	*/
	public void setCRINF_OBSERVACION(String inCrinf_observacion){
		this.myCrinf_observacion = inCrinf_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL - HISTORIAL JSON
	* @return String INFORMACION ADICIONAL - HISTORIAL JSON
	*/
	public String getCRINF_OBSERVACION(){
		return this.myCrinf_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrinf_estado ESTADO DEL REGISTRO
	*/
	public void setCRINF_ESTADO(boolean inCrinf_estado){
		this.myCrinf_estado = inCrinf_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRINF_ESTADO(){
		return this.myCrinf_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrinf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRINF_USUARIO_INSERT(String inCrinf_usuario_insert){
		this.myCrinf_usuario_insert = inCrinf_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRINF_USUARIO_INSERT(){
		return this.myCrinf_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrinf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRINF_USUARIO_UPDATE(String inCrinf_usuario_update){
		this.myCrinf_usuario_update = inCrinf_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRINF_USUARIO_UPDATE(){
		return this.myCrinf_usuario_update;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCRMTR_CODIGO(String inCrmtr_codigo){
		this.myCrmtr_codigo = inCrmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCRMTR_CODIGO(){
		return this.myCrmtr_codigo;
	}
	/**
	* ESTABLECE EL CODIGO DEL ADJUNTO
	* @param inCodigoAdjunto CODIGO DEL ADJUNTO
	*/
	public void setCODIGO_ADJUNTO(String inCodigoAdjunto){
		this.myCodigoAdjunto = inCodigoAdjunto;
	}
	/**
	* OBTIENE EL CODIGO DEL ADJUNTO
	* @return String EL CODIGO DEL ADJUNTO
	*/
	public String getCODIGO_ADJUNTO(){
		return this.myCodigoAdjunto;
	}
	/**
	* ESTABLECE EL NOMBRE DEL ADJUNTO
	* @param inAdjunto NOMBRE DEL ADJUNTO
	*/
	public void setADJUNTO(String inAdjunto){
		this.myAdjunto = inAdjunto;
	}
	/**
	* OBTIENE EL NOMBRE DEL ADJUNTO
	* @return String EL NOMBRE DEL ADJUNTO
	*/
	public String getADJUNTO(){
		return this.myAdjunto;
	}
}
