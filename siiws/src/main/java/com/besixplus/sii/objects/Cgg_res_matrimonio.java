package com.besixplus.sii.objects;

import java.io.Serializable;
import java.util.ArrayList;
/**
* CLASE Cgg_res_matrimonio
* TABLA: MATRIMONIO
* DESCRIPCION:ALMACENA INFORMACION DE LAS PAREJAS LEGALMENTE CONSTITUIDAS
* ABREVIATURA:CRMTR
*/
public class Cgg_res_matrimonio implements Serializable{
	private static final long serialVersionUID = 302942821;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrmtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	*/
	private String myCrtra_codigo;
	/**
	* NUMERO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	*/
	private String myCrtra_numero;
	/**
	* NOMBRE IDENTIFICATIVO DEL RESIDENTE PERMANENTE
	*/
	private String myResidente;
	/**
	* NOMBRE IDENTIFICATIVO DEL RESIDENTE PERMANENTE
	*/
	private String myConyuge;
	
	/**
	* FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	*/
	private java.util.Date myCrmtr_fecha_matrimonio;
	/**
	* CODIGO DEL OFICIAL DE MATRIMONIO
	*/
	private String myOficialMatrimonio;
	/**
	* ARRAY PARA LOS DATOS DEL OFICIAL DE MATRIMONIO
	*/
	private ArrayList<Usuario> myOficiales;
	/**
	* TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	*/
	private int myCrmtr_tipo;
	/**
	* ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO
	*/
	private int myCrmtr_estado_seguimiento;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrmtr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrmtr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrmtr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_matrimonio
	*/
	public Cgg_res_matrimonio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_matrimonio
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE TRAMITE
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DEL RESIDENTE PERMANENTE
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DEL CONYUGE O BENEFICIARIO
	* @param inCrmtr_fecha_matrimonio FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	* @param inCrmtr_tipo TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	 * @param inCrmtr_estado_seguimiento 
	* @param inCrmtr_estado ESTADO DEL REGISTRO
	* @param inCrmtr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmtr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_matrimonio(
			String inCrmtr_codigo,
			String inCrtra_codigo,
			java.util.Date inCrmtr_fecha_matrimonio,
			int inCrmtr_tipo,
			int inCrmtr_estado_seguimiento,
			boolean inCrmtr_estado,
			String inCrmtr_usuario_insert,
			String inCrmtr_usuario_update
		){
			this.setCRMTR_CODIGO(inCrmtr_codigo);
			this.setCRTRA_CODIGO(inCrtra_codigo);
			this.setCRMTR_FECHA_MATRIMONIO(inCrmtr_fecha_matrimonio);
			this.setCRMTR_TIPO(inCrmtr_tipo);
			this.setCRMTR_ESTADO_SEGUIMIENTO(inCrmtr_estado_seguimiento);
			this.setCRMTR_ESTADO(inCrmtr_estado);
			this.setCRMTR_USUARIO_INSERT(inCrmtr_usuario_insert);
			this.setCRMTR_USUARIO_UPDATE(inCrmtr_usuario_update);
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}	
	
	/**
	* ESTABLECE EL NUMERO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	* @param inCrtra_numero NUMERO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	*/
	public void setCRTRA_NUMERO(String inCrtra_numero){
		this.myCrtra_numero = inCrtra_numero;
	}
	/**
	* OBTIENE EL NUMERO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	*/
	public String getCRTRA_NUMERO(){
		return this.myCrtra_numero;
	}	
	

	/**
	* ESTABLECE FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	* @param inCrmtr_fecha_matrimonio FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	*/
	public void setCRMTR_FECHA_MATRIMONIO(java.util.Date inCrmtr_fecha_matrimonio){
		this.myCrmtr_fecha_matrimonio = inCrmtr_fecha_matrimonio;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	* @return java.util.Date FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	*/
	public java.util.Date getCRMTR_FECHA_MATRIMONIO(){
		return this.myCrmtr_fecha_matrimonio;
	}
	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DEL OFICIAL DEL MATRIMONIO
	* @param inOficialMatrimonio CODIGO IDENTIFICATIVO DEL OFICIAL DEL MATRIMONIO
	*/
	public void setOFICIALMATRIMONIO(String inOficialMatrimonio){
		this.myOficialMatrimonio = inOficialMatrimonio;
	}
	/**
	* OBTIENE CODIGO DEL OFICIAL DEL MATRIMONIO
	* @return String CODIGO IDENTIFICATIVO DEL OFICIAL DEL MATRIMONIO
	*/
	public String getOFICIALMATRIMONIO(){
		return this.myOficialMatrimonio;
	}	
	/**
	* ESTABLECE EL ARRAY DEL OFICIAL DEL MATRIMONIO
	* @param inOficiales CODIGO IDENTIFICATIVO DEL OFICIAL DEL MATRIMONIO
	*/
	public void setOFICIALES(ArrayList<Usuario> inOficiales){
		this.myOficiales = inOficiales;
	}
	/**
	* OBTIENE CODIGO DEL OFICIAL DEL MATRIMONIO
	* @return String CODIGO IDENTIFICATIVO DEL OFICIAL DEL MATRIMONIO
	*/
	public ArrayList<Usuario> getOFICIALES(){
		return this.myOficiales;
	}	
	/**
	* ESTABLECE TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	* @param inCrmtr_tipo TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	*/
	public void setCRMTR_TIPO(int inCrmtr_tipo){
		this.myCrmtr_tipo = inCrmtr_tipo;
	}
	/**
	* OBTIENE TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	* @return int TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	*/
	public int getCRMTR_TIPO(){
		return this.myCrmtr_tipo;
	}

	/**
	* ESTABLECE ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO
	* @param inCrmtr_estado_seguimiento ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO
	*/
	public void setCRMTR_ESTADO_SEGUIMIENTO(int inCrmtr_estado_seguimiento){
		this.myCrmtr_estado_seguimiento = inCrmtr_estado_seguimiento;
	}
	/**
	* OBTIENE ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO
	* @return int ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO
	*/
	public int getCRMTR_ESTADO_SEGUIMIENTO(){
		return this.myCrmtr_estado_seguimiento;
	}
	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrmtr_estado ESTADO DEL REGISTRO
	*/
	public void setCRMTR_ESTADO(boolean inCrmtr_estado){
		this.myCrmtr_estado = inCrmtr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRMTR_ESTADO(){
		return this.myCrmtr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrmtr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRMTR_USUARIO_INSERT(String inCrmtr_usuario_insert){
		this.myCrmtr_usuario_insert = inCrmtr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRMTR_USUARIO_INSERT(){
		return this.myCrmtr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrmtr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRMTR_USUARIO_UPDATE(String inCrmtr_usuario_update){
		this.myCrmtr_usuario_update = inCrmtr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRMTR_USUARIO_UPDATE(){
		return this.myCrmtr_usuario_update;
	}
	/**
	* ESTABLECE EL NOMBRE DEL RESIDENTE
	* @param inResidente NOMBRE DEL RESIDENTE
	*/
	public void setRESIDENTE(String inResidente){
		this.myResidente = inResidente;
	}
	/**
	* OBTIENE EL NOMBRE DEL RESIDENTE
	* @return String NOMBRE DEL RESIDENTE
	*/
	public String getRESIDENTE(){
		return this.myResidente;
	}
	/**
	* ESTABLECE EL NOMBRE DEL CONYUGE
	* @param inConyuge NOMBRE DEL CONYUGE
	*/
	public void setCONYUGE(String inConyuge){
		this.myConyuge = inConyuge;
	}
	/**
	* OBTIENE EL NOMBRE DEL RESIDENTE
	* @return String NOMBRE DEL RESIDENTE
	*/
	public String getCONYUGE(){
		return this.myConyuge;
	}
}
