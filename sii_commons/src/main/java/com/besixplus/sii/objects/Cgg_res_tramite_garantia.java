package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_tramite_garantia
* TABLA: TRAMITE GARANTIA
* DESCRIPCION: ALMACENA LAS GARANTIAS ASIGNADAS A UN TRAMITE
* ABREVIATURA: CRTGR 
*/
public class Cgg_res_tramite_garantia implements Serializable{
	private static final long serialVersionUID = 1136911651;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	*/
	private String myCrtgr_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	*/
	private String myCrdpt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	private String myCrtra_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrgrt_codigo;
	/**
	* VALOR DE LA GARANTIA INDIVIDUAL
	*/
	private java.math.BigDecimal myCrtgr_valor;
	/**
	* FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	*/
	private java.util.Date myCrtgr_fecha_soli_devol;
	/**
	* FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	*/
	private java.util.Date myCrtgr_fecha_devolucion;
	/**
	* SI LA GARANTIA ESTA DEVUELTA
	*/
	private boolean myCrtgr_devuelto;
	/**
	* ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	*/
	private int myCrtgr_estado_asignacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrtgr_estado;
	/**
	* USUARIO QUE CREO EL REGISTRO
	*/
	private String myCrtgr_usuario_insert;
	/**
	* USUARIO QUE ACTUALIZO EL REGISTRO
	*/
	private String myCrtgr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite_garantia
	*/
	public Cgg_res_tramite_garantia(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_tramite_garantia
	* @param inCrtgr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrtgr_valor VALOR DE LA GARANTIA INDIVIDUAL
	* @param inCrtgr_fecha_soli_devol FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	* @param inCrtgr_fecha_devolucion FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	* @param inCrtgr_devuelto SI LA GARANTIA ESTA DEVUELTA
	* @param inCrtgr_estado_asignacion ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	* @param inCrtgr_estado ESTADO DEL REGISTRO
	* @param inCrtgr_usuario_insert USUARIO QUE CREO EL REGISTRO
	* @param inCrtgr_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO
	*/
	public Cgg_res_tramite_garantia(
		String inCrtgr_codigo,
		String inCrdpt_codigo,
		String inCrtra_codigo,
		String inCrgrt_codigo,
		java.math.BigDecimal inCrtgr_valor,
		java.util.Date inCrtgr_fecha_soli_devol,
		java.util.Date inCrtgr_fecha_devolucion,
		boolean inCrtgr_devuelto,
		int inCrtgr_estado_asignacion,
		boolean inCrtgr_estado,
		String inCrtgr_usuario_insert,
		String inCrtgr_usuario_update
	){
		this.setCRTGR_CODIGO(inCrtgr_codigo);
		this.setCRDPT_CODIGO(inCrdpt_codigo);
		this.setCRTRA_CODIGO(inCrtra_codigo);
		this.setCRGRT_CODIGO(inCrgrt_codigo);
		this.setCRTGR_VALOR(inCrtgr_valor);
		this.setCRTGR_FECHA_SOLI_DEVOL(inCrtgr_fecha_soli_devol);
		this.setCRTGR_FECHA_DEVOLUCION(inCrtgr_fecha_devolucion);
		this.setCRTGR_DEVUELTO(inCrtgr_devuelto);
		this.setCRTGR_ESTADO_ASIGNACION(inCrtgr_estado_asignacion);
		this.setCRTGR_ESTADO(inCrtgr_estado);
		this.setCRTGR_USUARIO_INSERT(inCrtgr_usuario_insert);
		this.setCRTGR_USUARIO_UPDATE(inCrtgr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	* @param inCrtgr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	*/
	public void setCRTGR_CODIGO(String inCrtgr_codigo){
		this.myCrtgr_codigo = inCrtgr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	*/
	public String getCRTGR_CODIGO(){
		return this.myCrtgr_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	*/
	public void setCRDPT_CODIGO(String inCrdpt_codigo){
		this.myCrdpt_codigo = inCrdpt_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	*/
	public String getCRDPT_CODIGO(){
		return this.myCrdpt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public void setCRTRA_CODIGO(String inCrtra_codigo){
		this.myCrtra_codigo = inCrtra_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	*/
	public String getCRTRA_CODIGO(){
		return this.myCrtra_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRGRT_CODIGO(String inCrgrt_codigo){
		this.myCrgrt_codigo = inCrgrt_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRGRT_CODIGO(){
		return this.myCrgrt_codigo;
	}

	/**
	* ESTABLECE VALOR DE LA GARANTIA INDIVIDUAL
	* @param inCrtgr_valor VALOR DE LA GARANTIA INDIVIDUAL
	*/
	public void setCRTGR_VALOR(java.math.BigDecimal inCrtgr_valor){
		this.myCrtgr_valor = inCrtgr_valor;
	}
	/**
	* OBTIENE VALOR DE LA GARANTIA INDIVIDUAL
	* @return java.math.BigDecimal VALOR DE LA GARANTIA INDIVIDUAL
	*/
	public java.math.BigDecimal getCRTGR_VALOR(){
		return this.myCrtgr_valor;
	}

	/**
	* ESTABLECE FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	* @param inCrtgr_fecha_soli_devol FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	*/
	public void setCRTGR_FECHA_SOLI_DEVOL(java.util.Date inCrtgr_fecha_soli_devol){
		this.myCrtgr_fecha_soli_devol = inCrtgr_fecha_soli_devol;
	}
	/**
	* OBTIENE FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	* @return java.util.Date FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	*/
	public java.util.Date getCRTGR_FECHA_SOLI_DEVOL(){
		return this.myCrtgr_fecha_soli_devol;
	}

	/**
	* ESTABLECE FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	* @param inCrtgr_fecha_devolucion FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	*/
	public void setCRTGR_FECHA_DEVOLUCION(java.util.Date inCrtgr_fecha_devolucion){
		this.myCrtgr_fecha_devolucion = inCrtgr_fecha_devolucion;
	}
	/**
	* OBTIENE FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	* @return java.util.Date FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	*/
	public java.util.Date getCRTGR_FECHA_DEVOLUCION(){
		return this.myCrtgr_fecha_devolucion;
	}

	/**
	* ESTABLECE SI LA GARANTIA ESTA DEVUELTA
	* @param inCrtgr_devuelto SI LA GARANTIA ESTA DEVUELTA
	*/
	public void setCRTGR_DEVUELTO(boolean inCrtgr_devuelto){
		this.myCrtgr_devuelto = inCrtgr_devuelto;
	}
	/**
	* OBTIENE SI LA GARANTIA ESTA DEVUELTA
	* @return boolean SI LA GARANTIA ESTA DEVUELTA
	*/
	public boolean getCRTGR_DEVUELTO(){
		return this.myCrtgr_devuelto;
	}

	/**
	* ESTABLECE ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	* @param inCrtgr_estado_asignacion ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	*/
	public void setCRTGR_ESTADO_ASIGNACION(int inCrtgr_estado_asignacion){
		this.myCrtgr_estado_asignacion = inCrtgr_estado_asignacion;
	}
	/**
	* OBTIENE ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	* @return int ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	*/
	public int getCRTGR_ESTADO_ASIGNACION(){
		return this.myCrtgr_estado_asignacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrtgr_estado ESTADO DEL REGISTRO
	*/
	public void setCRTGR_ESTADO(boolean inCrtgr_estado){
		this.myCrtgr_estado = inCrtgr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRTGR_ESTADO(){
		return this.myCrtgr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE CREO EL REGISTRO
	* @param inCrtgr_usuario_insert USUARIO QUE CREO EL REGISTRO
	*/
	public void setCRTGR_USUARIO_INSERT(String inCrtgr_usuario_insert){
		this.myCrtgr_usuario_insert = inCrtgr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE CREO EL REGISTRO
	* @return String USUARIO QUE CREO EL REGISTRO
	*/
	public String getCRTGR_USUARIO_INSERT(){
		return this.myCrtgr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE ACTUALIZO EL REGISTRO
	* @param inCrtgr_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO
	*/
	public void setCRTGR_USUARIO_UPDATE(String inCrtgr_usuario_update){
		this.myCrtgr_usuario_update = inCrtgr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE ACTUALIZO EL REGISTRO
	* @return String USUARIO QUE ACTUALIZO EL REGISTRO
	*/
	public String getCRTGR_USUARIO_UPDATE(){
		return this.myCrtgr_usuario_update;
	}

}
