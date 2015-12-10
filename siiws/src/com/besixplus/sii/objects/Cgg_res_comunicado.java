package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_comunicado
* TABLA: COMUNICADO
* DESCRIPCION:ALMACENA INFORMACION DE LOS COMUNICADOS RECIBIDOS EN CONTROL DE RESIDENCIA
* ABREVIATURA:CRCOM
*/
public class Cgg_res_comunicado implements Serializable{
	private static final long serialVersionUID = 1122970580;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	*/
	private String myCrcom_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	*/
	private String myCrper_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	*/
	private String myCgg_crper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	*/
	private String myCrpjr_codigo;
	/**
	* PERSONA QUE RECIBE DEL COMUNICADO
	*/
	private String myCrcom_destinatario;
	/**
	* ASUNTO DEL COMUNICADO
	*/
	private String myCrcom_asunto;
	/**
	* FECHA DE RECEPCION DEL COMUNICADO
	*/
	private java.util.Date myCrcom_fecha_recepcion;
	/**
	* FECHA DE REVISION 
	*/
	private java.util.Date myCrcom_fecha_revision;
	/**
	* NUMERO DE DOCUMENTO
	*/
	private String myCrcom_numero_documento;
	/**
	* DETALLE CORTO DEL COMUNICADO
	*/
	private String myCrcom_descripcion;
	/**
	* OBSERVACION DEL COMUNICADO
	*/
	private String myCrcom_observacion;
	/**
	* DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	private String myCrcom_descripcion_adjunto;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCrcom_nombre_adjunto;
	/**
	* PERSONA QUE EMITE EL COMUNICADO
	*/
	private String myCrcom_remitente;
	/**
	* ARCHIVO DIGITAL ANEXO
	*/
	private byte[] myCrcom_adjunto;
	/**
	* ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	*/
	private int myCrcom_estado_comunicado;
	/**
	* ESTADO DEL REGISTRO


	*/
	private boolean myCrcom_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrcom_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrcom_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_comunicado
	*/
	public Cgg_res_comunicado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_comunicado
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	* @param inCrcom_destinatario PERSONA QUE RECIBE DEL COMUNICADO
	* @param inCrcom_asunto ASUNTO DEL COMUNICADO
	* @param inCrcom_fecha_recepcion FECHA DE RECEPCION DEL COMUNICADO
	* @param inCrcom_fecha_revision FECHA DE REVISION 
	* @param inCrcom_numero_documento NUMERO DE DOCUMENTO
	* @param inCrcom_descripcion DETALLE CORTO DEL COMUNICADO
	* @param inCrcom_observacion OBSERVACION DEL COMUNICADO
	* @param inCrcom_descripcion_adjunto DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCrcom_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrcom_remitente PERSONA QUE EMITE EL COMUNICADO
	* @param inCrcom_adjunto ARCHIVO DIGITAL ANEXO
	* @param inCrcom_estado_comunicado ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	* @param inCrcom_estado ESTADO DEL REGISTRO


	* @param inCrcom_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcom_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_comunicado(
		String inCrcom_codigo,
		String inCrres_codigo,
		String inCrper_codigo,
		String inCgg_crper_codigo,
		String inCrpjr_codigo,
		String inCrcom_destinatario,
		String inCrcom_asunto,
		java.util.Date inCrcom_fecha_recepcion,
		java.util.Date inCrcom_fecha_revision,
		String inCrcom_numero_documento,
		String inCrcom_descripcion,
		String inCrcom_observacion,
		String inCrcom_descripcion_adjunto,
		String inCrcom_nombre_adjunto,
		String inCrcom_remitente,
		byte[] inCrcom_adjunto,
		int inCrcom_estado_comunicado,
		boolean inCrcom_estado,
		String inCrcom_usuario_insert,
		String inCrcom_usuario_update
	){
		this.setCRCOM_CODIGO(inCrcom_codigo);
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCRCOM_DESTINATARIO(inCrcom_destinatario);
		this.setCRCOM_ASUNTO(inCrcom_asunto);
		this.setCRCOM_FECHA_RECEPCION(inCrcom_fecha_recepcion);
		this.setCRCOM_FECHA_REVISION(inCrcom_fecha_revision);
		this.setCRCOM_NUMERO_DOCUMENTO(inCrcom_numero_documento);
		this.setCRCOM_DESCRIPCION(inCrcom_descripcion);
		this.setCRCOM_OBSERVACION(inCrcom_observacion);
		this.setCRCOM_DESCRIPCION_ADJUNTO(inCrcom_descripcion_adjunto);
		this.setCRCOM_NOMBRE_ADJUNTO(inCrcom_nombre_adjunto);
		this.setCRCOM_REMITENTE(inCrcom_remitente);
		this.setCRCOM_ADJUNTO(inCrcom_adjunto);
		this.setCRCOM_ESTADO_COMUNICADO(inCrcom_estado_comunicado);
		this.setCRCOM_ESTADO(inCrcom_estado);
		this.setCRCOM_USUARIO_INSERT(inCrcom_usuario_insert);
		this.setCRCOM_USUARIO_UPDATE(inCrcom_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	*/
	public void setCRCOM_CODIGO(String inCrcom_codigo){
		this.myCrcom_codigo = inCrcom_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	*/
	public String getCRCOM_CODIGO(){
		return this.myCrcom_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public void setCRRES_CODIGO(String inCrres_codigo){
		this.myCrres_codigo = inCrres_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	public String getCRRES_CODIGO(){
		return this.myCrres_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	*/
	public void setCGG_CRPER_CODIGO(String inCgg_crper_codigo){
		this.myCgg_crper_codigo = inCgg_crper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	*/
	public String getCGG_CRPER_CODIGO(){
		return this.myCgg_crper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE PERSONA QUE RECIBE DEL COMUNICADO
	* @param inCrcom_destinatario PERSONA QUE RECIBE DEL COMUNICADO
	*/
	public void setCRCOM_DESTINATARIO(String inCrcom_destinatario){
		this.myCrcom_destinatario = inCrcom_destinatario;
	}
	/**
	* OBTIENE PERSONA QUE RECIBE DEL COMUNICADO
	* @return String PERSONA QUE RECIBE DEL COMUNICADO
	*/
	public String getCRCOM_DESTINATARIO(){
		return this.myCrcom_destinatario;
	}

	/**
	* ESTABLECE ASUNTO DEL COMUNICADO
	* @param inCrcom_asunto ASUNTO DEL COMUNICADO
	*/
	public void setCRCOM_ASUNTO(String inCrcom_asunto){
		this.myCrcom_asunto = inCrcom_asunto;
	}
	/**
	* OBTIENE ASUNTO DEL COMUNICADO
	* @return String ASUNTO DEL COMUNICADO
	*/
	public String getCRCOM_ASUNTO(){
		return this.myCrcom_asunto;
	}

	/**
	* ESTABLECE FECHA DE RECEPCION DEL COMUNICADO
	* @param inCrcom_fecha_recepcion FECHA DE RECEPCION DEL COMUNICADO
	*/
	public void setCRCOM_FECHA_RECEPCION(java.util.Date inCrcom_fecha_recepcion){
		this.myCrcom_fecha_recepcion = inCrcom_fecha_recepcion;
	}
	/**
	* OBTIENE FECHA DE RECEPCION DEL COMUNICADO
	* @return java.util.Date FECHA DE RECEPCION DEL COMUNICADO
	*/
	public java.util.Date getCRCOM_FECHA_RECEPCION(){
		return this.myCrcom_fecha_recepcion;
	}

	/**
	* ESTABLECE FECHA DE REVISION 
	* @param inCrcom_fecha_revision FECHA DE REVISION 
	*/
	public void setCRCOM_FECHA_REVISION(java.util.Date inCrcom_fecha_revision){
		this.myCrcom_fecha_revision = inCrcom_fecha_revision;
	}
	/**
	* OBTIENE FECHA DE REVISION 
	* @return java.util.Date FECHA DE REVISION 
	*/
	public java.util.Date getCRCOM_FECHA_REVISION(){
		return this.myCrcom_fecha_revision;
	}

	/**
	* ESTABLECE NUMERO DE DOCUMENTO
	* @param inCrcom_numero_documento NUMERO DE DOCUMENTO
	*/
	public void setCRCOM_NUMERO_DOCUMENTO(String inCrcom_numero_documento){
		this.myCrcom_numero_documento = inCrcom_numero_documento;
	}
	/**
	* OBTIENE NUMERO DE DOCUMENTO
	* @return String NUMERO DE DOCUMENTO
	*/
	public String getCRCOM_NUMERO_DOCUMENTO(){
		return this.myCrcom_numero_documento;
	}

	/**
	* ESTABLECE DETALLE CORTO DEL COMUNICADO
	* @param inCrcom_descripcion DETALLE CORTO DEL COMUNICADO
	*/
	public void setCRCOM_DESCRIPCION(String inCrcom_descripcion){
		this.myCrcom_descripcion = inCrcom_descripcion;
	}
	/**
	* OBTIENE DETALLE CORTO DEL COMUNICADO
	* @return String DETALLE CORTO DEL COMUNICADO
	*/
	public String getCRCOM_DESCRIPCION(){
		return this.myCrcom_descripcion;
	}

	/**
	* ESTABLECE OBSERVACION DEL COMUNICADO
	* @param inCrcom_observacion OBSERVACION DEL COMUNICADO
	*/
	public void setCRCOM_OBSERVACION(String inCrcom_observacion){
		this.myCrcom_observacion = inCrcom_observacion;
	}
	/**
	* OBTIENE OBSERVACION DEL COMUNICADO
	* @return String OBSERVACION DEL COMUNICADO
	*/
	public String getCRCOM_OBSERVACION(){
		return this.myCrcom_observacion;
	}

	/**
	* ESTABLECE DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCrcom_descripcion_adjunto DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	public void setCRCOM_DESCRIPCION_ADJUNTO(String inCrcom_descripcion_adjunto){
		this.myCrcom_descripcion_adjunto = inCrcom_descripcion_adjunto;
	}
	/**
	* OBTIENE DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @return String DESCRIPCION DEL DOCUMENTO ADJUNTO
	*/
	public String getCRCOM_DESCRIPCION_ADJUNTO(){
		return this.myCrcom_descripcion_adjunto;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrcom_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCRCOM_NOMBRE_ADJUNTO(String inCrcom_nombre_adjunto){
		this.myCrcom_nombre_adjunto = inCrcom_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCRCOM_NOMBRE_ADJUNTO(){
		return this.myCrcom_nombre_adjunto;
	}

	/**
	* ESTABLECE PERSONA QUE EMITE EL COMUNICADO
	* @param inCrcom_remitente PERSONA QUE EMITE EL COMUNICADO
	*/
	public void setCRCOM_REMITENTE(String inCrcom_remitente){
		this.myCrcom_remitente = inCrcom_remitente;
	}
	/**
	* OBTIENE PERSONA QUE EMITE EL COMUNICADO
	* @return String PERSONA QUE EMITE EL COMUNICADO
	*/
	public String getCRCOM_REMITENTE(){
		return this.myCrcom_remitente;
	}

	/**
	* ESTABLECE ARCHIVO DIGITAL ANEXO
	* @param inCrcom_adjunto ARCHIVO DIGITAL ANEXO
	*/
	public void setCRCOM_ADJUNTO(byte[] inCrcom_adjunto){
		this.myCrcom_adjunto = inCrcom_adjunto;
	}
	/**
	* OBTIENE ARCHIVO DIGITAL ANEXO
	* @return byte[] ARCHIVO DIGITAL ANEXO
	*/
	public byte[] getCRCOM_ADJUNTO(){
		return this.myCrcom_adjunto;
	}

	/**
	* ESTABLECE ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	* @param inCrcom_estado_comunicado ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	*/
	public void setCRCOM_ESTADO_COMUNICADO(int inCrcom_estado_comunicado){
		this.myCrcom_estado_comunicado = inCrcom_estado_comunicado;
	}
	/**
	* OBTIENE ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	* @return int ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	*/
	public int getCRCOM_ESTADO_COMUNICADO(){
		return this.myCrcom_estado_comunicado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO


	* @param inCrcom_estado ESTADO DEL REGISTRO


	*/
	public void setCRCOM_ESTADO(boolean inCrcom_estado){
		this.myCrcom_estado = inCrcom_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO


	* @return boolean ESTADO DEL REGISTRO


	*/
	public boolean getCRCOM_ESTADO(){
		return this.myCrcom_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrcom_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRCOM_USUARIO_INSERT(String inCrcom_usuario_insert){
		this.myCrcom_usuario_insert = inCrcom_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRCOM_USUARIO_INSERT(){
		return this.myCrcom_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrcom_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRCOM_USUARIO_UPDATE(String inCrcom_usuario_update){
		this.myCrcom_usuario_update = inCrcom_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRCOM_USUARIO_UPDATE(){
		return this.myCrcom_usuario_update;
	}

}
