package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tipo_solicitud_tramite
* TABLA: TIPO DE SOLICITUD DE TRAMITE
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE SOLICITUDES O AMPAROS POR LOS QUE SE GENERAN UN TRAMITE
* ABREVIATURA:CRTST
* 
* 
*/
public class Cgg_res_tipo_solicitud_tramite implements Serializable{
	private static final long serialVersionUID = 254300852;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	private String myCrtst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	*/
	private String myCgg_crtst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	private String myCrtpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	private String myCrpro_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	private String myCrres_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	private String myCkesp_codigo;
	/**
	* DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	private String myCrtst_descripcion;
	/**
	* NO ESPECIFICADO
	*/
	private String myCrtst_observacion;
	/**
	* ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	*/
	private boolean myCrtst_aplica_garantia;
	/**
	* ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	*/
	private boolean myCrtst_aplica_tramite;
	/**
	* SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	*/
	private boolean myCrtst_aplica_grupo;
	/**
	* SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	*/
	private boolean myCrtst_atencion_cliente;
	/**
	* SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	*/
	private boolean myCrtst_restringido;
	/**
	* SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	*/
	private boolean myCrtst_comunicado_radial;
	/**
	* NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	*/
	private int myCrtst_numero_dias;
	/**
	* ALMACENA INFORMACION DEL VEHICULO
	*/
	private boolean myCrtst_vehiculo;
	/**
	* CONTEO APLICADO AL TRAMITE
	*/
	private boolean myCrtst_unanimidad;
	/**
	* CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	*/
	private boolean myCrtst_aplica_otro;
	/**
	* SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	*/
	private boolean myCrtst_aplica_beneficiario;
	/**
	* INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	*/
	private java.math.BigDecimal myCrtst_indice;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtst_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrtst_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrtst_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_tramite
	*/
	public Cgg_res_tipo_solicitud_tramite(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tipo_solicitud_tramite
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCgg_crtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCrtst_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrtst_observacion NO ESPECIFICADO
	* @param inCrtst_aplica_garantia ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	* @param inCrtst_aplica_tramite ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	* @param inCrtst_aplica_grupo SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	* @param inCrtst_atencion_cliente SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	* @param inCrtst_restringido SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	* @param inCrtst_comunicado_radial SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	* @param inCrtst_numero_dias NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	* @param inCrtst_vehiculo ALMACENA INFORMACION DEL VEHICULO
	* @param inCrtst_unanimidad CONTEO APLICADO AL TRAMITE
	* @param inCrtst_aplica_otro CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	* @param inCrtst_aplica_beneficiario SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	* @param inCrtst_indice INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	* @param inCrtst_estado ESTADO DEL REGISTRO
	* @param inCrtst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_tipo_solicitud_tramite(
		String inCrtst_codigo,
		String inCgg_crtst_codigo,
		String inCrtpt_codigo,
		String inCrpro_codigo,
		String inCrres_codigo,
		String inCkesp_codigo,
		String inCrtst_descripcion,
		String inCrtst_observacion,
		boolean inCrtst_aplica_garantia,
		boolean inCrtst_aplica_tramite,
		boolean inCrtst_aplica_grupo,
		boolean inCrtst_atencion_cliente,
		boolean inCrtst_restringido,
		boolean inCrtst_comunicado_radial,
		int inCrtst_numero_dias,
		boolean inCrtst_vehiculo,
		boolean inCrtst_unanimidad,
		boolean inCrtst_aplica_otro,
		boolean inCrtst_aplica_beneficiario,
		java.math.BigDecimal inCrtst_indice,
		boolean inCrtst_estado,
		String inCrtst_usuario_insert,
		String inCrtst_usuario_update
	){
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCGG_CRTST_CODIGO(inCgg_crtst_codigo);
		this.setCRTPT_CODIGO(inCrtpt_codigo);
		this.setCRPRO_CODIGO(inCrpro_codigo);
		this.setCRRES_CODIGO(inCrres_codigo);
		this.setCKESP_CODIGO(inCkesp_codigo);
		this.setCRTST_DESCRIPCION(inCrtst_descripcion);
		this.setCRTST_OBSERVACION(inCrtst_observacion);
		this.setCRTST_APLICA_GARANTIA(inCrtst_aplica_garantia);
		this.setCRTST_APLICA_TRAMITE(inCrtst_aplica_tramite);
		this.setCRTST_APLICA_GRUPO(inCrtst_aplica_grupo);
		this.setCRTST_ATENCION_CLIENTE(inCrtst_atencion_cliente);
		this.setCRTST_RESTRINGIDO(inCrtst_restringido);
		this.setCRTST_COMUNICADO_RADIAL(inCrtst_comunicado_radial);
		this.setCRTST_NUMERO_DIAS(inCrtst_numero_dias);
		this.setCRTST_VEHICULO(inCrtst_vehiculo);
		this.setCRTST_UNANIMIDAD(inCrtst_unanimidad);
		this.setCRTST_APLICA_OTRO(inCrtst_aplica_otro);
		this.setCRTST_APLICA_BENEFICIARIO(inCrtst_aplica_beneficiario);
		this.setCRTST_INDICE(inCrtst_indice);
		this.setCRTST_ESTADO(inCrtst_estado);
		this.setCRTST_USUARIO_INSERT(inCrtst_usuario_insert);
		this.setCRTST_USUARIO_UPDATE(inCrtst_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	public void setCRTST_CODIGO(String inCrtst_codigo){
		this.myCrtst_codigo = inCrtst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	*/
	public String getCRTST_CODIGO(){
		return this.myCrtst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	* @param inCgg_crtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	*/
	public void setCGG_CRTST_CODIGO(String inCgg_crtst_codigo){
		this.myCgg_crtst_codigo = inCgg_crtst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	* @return String IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	*/
	public String getCGG_CRTST_CODIGO(){
		return this.myCgg_crtst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public void setCRTPT_CODIGO(String inCrtpt_codigo){
		this.myCrtpt_codigo = inCrtpt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	public String getCRTPT_CODIGO(){
		return this.myCrtpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	public void setCRPRO_CODIGO(String inCrpro_codigo){
		this.myCrpro_codigo = inCrpro_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	*/
	public String getCRPRO_CODIGO(){
		return this.myCrpro_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	public void setCKESP_CODIGO(String inCkesp_codigo){
		this.myCkesp_codigo = inCkesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	*/
	public String getCKESP_CODIGO(){
		return this.myCkesp_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @param inCrtst_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public void setCRTST_DESCRIPCION(String inCrtst_descripcion){
		this.myCrtst_descripcion = inCrtst_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL TIPO DE RESIDENCIA
	* @return String DESCRIPCION DEL TIPO DE RESIDENCIA
	*/
	public String getCRTST_DESCRIPCION(){
		return this.myCrtst_descripcion;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCrtst_observacion NO ESPECIFICADO
	*/
	public void setCRTST_OBSERVACION(String inCrtst_observacion){
		this.myCrtst_observacion = inCrtst_observacion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCRTST_OBSERVACION(){
		return this.myCrtst_observacion;
	}

	/**
	* ESTABLECE ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	* @param inCrtst_aplica_garantia ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	*/
	public void setCRTST_APLICA_GARANTIA(boolean inCrtst_aplica_garantia){
		this.myCrtst_aplica_garantia = inCrtst_aplica_garantia;
	}
	/**
	* OBTIENE ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	* @return boolean ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	*/
	public boolean getCRTST_APLICA_GARANTIA(){
		return this.myCrtst_aplica_garantia;
	}

	/**
	* ESTABLECE ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	* @param inCrtst_aplica_tramite ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	*/
	public void setCRTST_APLICA_TRAMITE(boolean inCrtst_aplica_tramite){
		this.myCrtst_aplica_tramite = inCrtst_aplica_tramite;
	}
	/**
	* OBTIENE ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	* @return boolean ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	*/
	public boolean getCRTST_APLICA_TRAMITE(){
		return this.myCrtst_aplica_tramite;
	}

	/**
	* ESTABLECE SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	* @param inCrtst_aplica_grupo SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	*/
	public void setCRTST_APLICA_GRUPO(boolean inCrtst_aplica_grupo){
		this.myCrtst_aplica_grupo = inCrtst_aplica_grupo;
	}
	/**
	* OBTIENE SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	* @return boolean SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	*/
	public boolean getCRTST_APLICA_GRUPO(){
		return this.myCrtst_aplica_grupo;
	}

	/**
	* ESTABLECE SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	* @param inCrtst_atencion_cliente SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	*/
	public void setCRTST_ATENCION_CLIENTE(boolean inCrtst_atencion_cliente){
		this.myCrtst_atencion_cliente = inCrtst_atencion_cliente;
	}
	/**
	* OBTIENE SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	* @return boolean SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	*/
	public boolean getCRTST_ATENCION_CLIENTE(){
		return this.myCrtst_atencion_cliente;
	}

	/**
	* ESTABLECE SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	* @param inCrtst_restringido SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	*/
	public void setCRTST_RESTRINGIDO(boolean inCrtst_restringido){
		this.myCrtst_restringido = inCrtst_restringido;
	}
	/**
	* OBTIENE SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	* @return boolean SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	*/
	public boolean getCRTST_RESTRINGIDO(){
		return this.myCrtst_restringido;
	}

	/**
	* ESTABLECE SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	* @param inCrtst_comunicado_radial SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	*/
	public void setCRTST_COMUNICADO_RADIAL(boolean inCrtst_comunicado_radial){
		this.myCrtst_comunicado_radial = inCrtst_comunicado_radial;
	}
	/**
	* OBTIENE SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	* @return boolean SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	*/
	public boolean getCRTST_COMUNICADO_RADIAL(){
		return this.myCrtst_comunicado_radial;
	}

	/**
	* ESTABLECE NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	* @param inCrtst_numero_dias NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	*/
	public void setCRTST_NUMERO_DIAS(int inCrtst_numero_dias){
		this.myCrtst_numero_dias = inCrtst_numero_dias;
	}
	/**
	* OBTIENE NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	* @return int NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	*/
	public int getCRTST_NUMERO_DIAS(){
		return this.myCrtst_numero_dias;
	}

	/**
	* ESTABLECE ALMACENA INFORMACION DEL VEHICULO
	* @param inCrtst_vehiculo ALMACENA INFORMACION DEL VEHICULO
	*/
	public void setCRTST_VEHICULO(boolean inCrtst_vehiculo){
		this.myCrtst_vehiculo = inCrtst_vehiculo;
	}
	/**
	* OBTIENE ALMACENA INFORMACION DEL VEHICULO
	* @return boolean ALMACENA INFORMACION DEL VEHICULO
	*/
	public boolean getCRTST_VEHICULO(){
		return this.myCrtst_vehiculo;
	}

	/**
	* ESTABLECE CONTEO APLICADO AL TRAMITE
	* @param inCrtst_unanimidad CONTEO APLICADO AL TRAMITE
	*/
	public void setCRTST_UNANIMIDAD(boolean inCrtst_unanimidad){
		this.myCrtst_unanimidad = inCrtst_unanimidad;
	}
	/**
	* OBTIENE CONTEO APLICADO AL TRAMITE
	* @return boolean CONTEO APLICADO AL TRAMITE
	*/
	public boolean getCRTST_UNANIMIDAD(){
		return this.myCrtst_unanimidad;
	}

	/**
	* ESTABLECE CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	* @param inCrtst_aplica_otro CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	*/
	public void setCRTST_APLICA_OTRO(boolean inCrtst_aplica_otro){
		this.myCrtst_aplica_otro = inCrtst_aplica_otro;
	}
	/**
	* OBTIENE CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	* @return boolean CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	*/
	public boolean getCRTST_APLICA_OTRO(){
		return this.myCrtst_aplica_otro;
	}

	/**
	* ESTABLECE SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	* @param inCrtst_aplica_beneficiario SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	*/
	public void setCRTST_APLICA_BENEFICIARIO(boolean inCrtst_aplica_beneficiario){
		this.myCrtst_aplica_beneficiario = inCrtst_aplica_beneficiario;
	}
	/**
	* OBTIENE SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	* @return boolean SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	*/
	public boolean getCRTST_APLICA_BENEFICIARIO(){
		return this.myCrtst_aplica_beneficiario;
	}

	/**
	* ESTABLECE INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	* @param inCrtst_indice INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	*/
	public void setCRTST_INDICE(java.math.BigDecimal inCrtst_indice){
		this.myCrtst_indice = inCrtst_indice;
	}
	/**
	* OBTIENE INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	* @return java.math.BigDecimal INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	*/
	public java.math.BigDecimal getCRTST_INDICE(){
		return this.myCrtst_indice;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtst_estado ESTADO DEL REGISTRO
	*/
	public void setCRTST_ESTADO(boolean inCrtst_estado){
		this.myCrtst_estado = inCrtst_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTST_ESTADO(){
		return this.myCrtst_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRTST_USUARIO_INSERT(String inCrtst_usuario_insert){
		this.myCrtst_usuario_insert = inCrtst_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRTST_USUARIO_INSERT(){
		return this.myCrtst_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrtst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRTST_USUARIO_UPDATE(String inCrtst_usuario_update){
		this.myCrtst_usuario_update = inCrtst_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRTST_USUARIO_UPDATE(){
		return this.myCrtst_usuario_update;
	}

}
