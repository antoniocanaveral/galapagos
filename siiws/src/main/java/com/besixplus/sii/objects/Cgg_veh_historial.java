package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_historial
* TABLA: HISTORIAL
* DESCRIPCION:ALMACENA INFORMACION DE LOS VEHICULOS QUE HA TENIDO UN RESIDENTE
* ABREVIATURA:CVHST
*/
public class Cgg_veh_historial implements Serializable{
	private static final long serialVersionUID = 590625922;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	*/
	private String myCvhst_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	private String myCvveh_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	private String myCrpjr_codigo;
	/**
	* SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	*/
	private boolean myCvhst_expulsado;
	/**
	* FECHA DE TRASPASO DEL VEHICULO
	*/
	private java.util.Date myCvhst_fecha_traspaso;
	/**
	* ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	*/
	private boolean myCvhst_propietario;
	/**
	* JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	*/
	private String myCvhst_concepto;
	/**
	* DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	*/
	private int myCvhst_tipo_permanencia;
	/**
	* FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	*/
	private java.util.Date myCvhst_fecha_ingreso;
	/**
	* FECHA DE SALIDA DEL VEHICULO
	*/
	private java.util.Date myCvhst_fecha_salida;
	/**
	* TIEMPO DE ESTADIA (DIAS)
	*/
	private int myCvhst_tiempo_estadia;
	/**
	* OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	*/
	private String myCvhst_observaciones;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvhst_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvhst_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvhst_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_historial
	*/
	public Cgg_veh_historial(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_historial
	* @param inCvhst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCvhst_expulsado SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	* @param inCvhst_fecha_traspaso FECHA DE TRASPASO DEL VEHICULO
	* @param inCvhst_propietario ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	* @param inCvhst_concepto JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	* @param inCvhst_tipo_permanencia DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	* @param inCvhst_fecha_ingreso FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	* @param inCvhst_fecha_salida FECHA DE SALIDA DEL VEHICULO
	* @param inCvhst_tiempo_estadia TIEMPO DE ESTADIA (DIAS)
	* @param inCvhst_observaciones OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	* @param inCvhst_estado ESTADO DEL REGISTRO
	* @param inCvhst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvhst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_historial(
		String inCvhst_codigo,
		String inCvveh_codigo,
		String inCrper_codigo,
		String inCrpjr_codigo,
		boolean inCvhst_expulsado,
		java.util.Date inCvhst_fecha_traspaso,
		boolean inCvhst_propietario,
		String inCvhst_concepto,
		int inCvhst_tipo_permanencia,
		java.util.Date inCvhst_fecha_ingreso,
		java.util.Date inCvhst_fecha_salida,
		int inCvhst_tiempo_estadia,
		String inCvhst_observaciones,
		boolean inCvhst_estado,
		String inCvhst_usuario_insert,
		String inCvhst_usuario_update
	){
		this.setCVHST_CODIGO(inCvhst_codigo);
		this.setCVVEH_CODIGO(inCvveh_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRPJR_CODIGO(inCrpjr_codigo);
		this.setCVHST_EXPULSADO(inCvhst_expulsado);
		this.setCVHST_FECHA_TRASPASO(inCvhst_fecha_traspaso);
		this.setCVHST_PROPIETARIO(inCvhst_propietario);
		this.setCVHST_CONCEPTO(inCvhst_concepto);
		this.setCVHST_TIPO_PERMANENCIA(inCvhst_tipo_permanencia);
		this.setCVHST_FECHA_INGRESO(inCvhst_fecha_ingreso);
		this.setCVHST_FECHA_SALIDA(inCvhst_fecha_salida);
		this.setCVHST_TIEMPO_ESTADIA(inCvhst_tiempo_estadia);
		this.setCVHST_OBSERVACIONES(inCvhst_observaciones);
		this.setCVHST_ESTADO(inCvhst_estado);
		this.setCVHST_USUARIO_INSERT(inCvhst_usuario_insert);
		this.setCVHST_USUARIO_UPDATE(inCvhst_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	* @param inCvhst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	*/
	public void setCVHST_CODIGO(String inCvhst_codigo){
		this.myCvhst_codigo = inCvhst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	*/
	public String getCVHST_CODIGO(){
		return this.myCvhst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public void setCVVEH_CODIGO(String inCvveh_codigo){
		this.myCvveh_codigo = inCvveh_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public String getCVVEH_CODIGO(){
		return this.myCvveh_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public void setCRPJR_CODIGO(String inCrpjr_codigo){
		this.myCrpjr_codigo = inCrpjr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	*/
	public String getCRPJR_CODIGO(){
		return this.myCrpjr_codigo;
	}

	/**
	* ESTABLECE SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	* @param inCvhst_expulsado SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	*/
	public void setCVHST_EXPULSADO(boolean inCvhst_expulsado){
		this.myCvhst_expulsado = inCvhst_expulsado;
	}
	/**
	* OBTIENE SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	* @return boolean SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	*/
	public boolean getCVHST_EXPULSADO(){
		return this.myCvhst_expulsado;
	}

	/**
	* ESTABLECE FECHA DE TRASPASO DEL VEHICULO
	* @param inCvhst_fecha_traspaso FECHA DE TRASPASO DEL VEHICULO
	*/
	public void setCVHST_FECHA_TRASPASO(java.util.Date inCvhst_fecha_traspaso){
		this.myCvhst_fecha_traspaso = inCvhst_fecha_traspaso;
	}
	/**
	* OBTIENE FECHA DE TRASPASO DEL VEHICULO
	* @return java.util.Date FECHA DE TRASPASO DEL VEHICULO
	*/
	public java.util.Date getCVHST_FECHA_TRASPASO(){
		return this.myCvhst_fecha_traspaso;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	* @param inCvhst_propietario ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	*/
	public void setCVHST_PROPIETARIO(boolean inCvhst_propietario){
		this.myCvhst_propietario = inCvhst_propietario;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	* @return boolean ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	*/
	public boolean getCVHST_PROPIETARIO(){
		return this.myCvhst_propietario;
	}

	/**
	* ESTABLECE JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	* @param inCvhst_concepto JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	*/
	public void setCVHST_CONCEPTO(String inCvhst_concepto){
		this.myCvhst_concepto = inCvhst_concepto;
	}
	/**
	* OBTIENE JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	* @return String JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	*/
	public String getCVHST_CONCEPTO(){
		return this.myCvhst_concepto;
	}

	/**
	* ESTABLECE DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	* @param inCvhst_tipo_permanencia DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	*/
	public void setCVHST_TIPO_PERMANENCIA(int inCvhst_tipo_permanencia){
		this.myCvhst_tipo_permanencia = inCvhst_tipo_permanencia;
	}
	/**
	* OBTIENE DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	* @return int DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	*/
	public int getCVHST_TIPO_PERMANENCIA(){
		return this.myCvhst_tipo_permanencia;
	}

	/**
	* ESTABLECE FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	* @param inCvhst_fecha_ingreso FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	*/
	public void setCVHST_FECHA_INGRESO(java.util.Date inCvhst_fecha_ingreso){
		this.myCvhst_fecha_ingreso = inCvhst_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	* @return java.util.Date FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	*/
	public java.util.Date getCVHST_FECHA_INGRESO(){
		return this.myCvhst_fecha_ingreso;
	}

	/**
	* ESTABLECE FECHA DE SALIDA DEL VEHICULO
	* @param inCvhst_fecha_salida FECHA DE SALIDA DEL VEHICULO
	*/
	public void setCVHST_FECHA_SALIDA(java.util.Date inCvhst_fecha_salida){
		this.myCvhst_fecha_salida = inCvhst_fecha_salida;
	}
	/**
	* OBTIENE FECHA DE SALIDA DEL VEHICULO
	* @return java.util.Date FECHA DE SALIDA DEL VEHICULO
	*/
	public java.util.Date getCVHST_FECHA_SALIDA(){
		return this.myCvhst_fecha_salida;
	}

	/**
	* ESTABLECE TIEMPO DE ESTADIA (DIAS)
	* @param inCvhst_tiempo_estadia TIEMPO DE ESTADIA (DIAS)
	*/
	public void setCVHST_TIEMPO_ESTADIA(int inCvhst_tiempo_estadia){
		this.myCvhst_tiempo_estadia = inCvhst_tiempo_estadia;
	}
	/**
	* OBTIENE TIEMPO DE ESTADIA (DIAS)
	* @return int TIEMPO DE ESTADIA (DIAS)
	*/
	public int getCVHST_TIEMPO_ESTADIA(){
		return this.myCvhst_tiempo_estadia;
	}

	/**
	* ESTABLECE OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	* @param inCvhst_observaciones OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	*/
	public void setCVHST_OBSERVACIONES(String inCvhst_observaciones){
		this.myCvhst_observaciones = inCvhst_observaciones;
	}
	/**
	* OBTIENE OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	* @return String OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	*/
	public String getCVHST_OBSERVACIONES(){
		return this.myCvhst_observaciones;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvhst_estado ESTADO DEL REGISTRO
	*/
	public void setCVHST_ESTADO(boolean inCvhst_estado){
		this.myCvhst_estado = inCvhst_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVHST_ESTADO(){
		return this.myCvhst_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvhst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVHST_USUARIO_INSERT(String inCvhst_usuario_insert){
		this.myCvhst_usuario_insert = inCvhst_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVHST_USUARIO_INSERT(){
		return this.myCvhst_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvhst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVHST_USUARIO_UPDATE(String inCvhst_usuario_update){
		this.myCvhst_usuario_update = inCvhst_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVHST_USUARIO_UPDATE(){
		return this.myCvhst_usuario_update;
	}

}
