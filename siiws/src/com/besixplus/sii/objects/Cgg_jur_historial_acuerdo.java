package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_historial_acuerdo
* TABLA: HISTORIAL DE ACUERDO
* DESCRIPCION:ALMACENA INFORMACION DEL HISTORIAL FORMADO POR LOS MOVIMIENTOS RECIBIDOS Y ENVIADOS DE UN ACUERDO
* ABREVIATURA:CJHAC
*/
public class Cgg_jur_historial_acuerdo implements Serializable{
	private static final long serialVersionUID = 1222258177;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	*/
	private String myCjhac_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	private String myCjacu_codigo;
	/**
	* DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	*/
	private String myCjhac_descripcion;
	/**
	* NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	*/
	private String myCjhac_responsable;
	/**
	* FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	*/
	private java.util.Date myCjhac_fecha;
	/**
	* ESTADO DEL REGISTRO DEL ACUERDO
	*/
	private boolean myCjhac_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DE HISTORIAL DE ACUERDO
	*/
	private String myCjhac_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DE HISTORIAL DE ACUERDO
	*/
	private String myCjhac_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_historial_acuerdo
	*/
	public Cgg_jur_historial_acuerdo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_historial_acuerdo
	* @param inCjhac_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @param inCjhac_descripcion DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	* @param inCjhac_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	* @param inCjhac_fecha FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	* @param inCjhac_estado ESTADO DEL REGISTRO DEL ACUERDO
	* @param inCjhac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DE HISTORIAL DE ACUERDO
	* @param inCjhac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DE HISTORIAL DE ACUERDO
	*/
	public Cgg_jur_historial_acuerdo(
		String inCjhac_codigo,
		String inCjacu_codigo,
		String inCjhac_descripcion,
		String inCjhac_responsable,
		java.util.Date inCjhac_fecha,
		boolean inCjhac_estado,
		String inCjhac_usuario_insert,
		String inCjhac_usuario_update
	){
		this.setCJHAC_CODIGO(inCjhac_codigo);
		this.setCJACU_CODIGO(inCjacu_codigo);
		this.setCJHAC_DESCRIPCION(inCjhac_descripcion);
		this.setCJHAC_RESPONSABLE(inCjhac_responsable);
		this.setCJHAC_FECHA(inCjhac_fecha);
		this.setCJHAC_ESTADO(inCjhac_estado);
		this.setCJHAC_USUARIO_INSERT(inCjhac_usuario_insert);
		this.setCJHAC_USUARIO_UPDATE(inCjhac_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	* @param inCjhac_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	*/
	public void setCJHAC_CODIGO(String inCjhac_codigo){
		this.myCjhac_codigo = inCjhac_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	*/
	public String getCJHAC_CODIGO(){
		return this.myCjhac_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	public void setCJACU_CODIGO(String inCjacu_codigo){
		this.myCjacu_codigo = inCjacu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	public String getCJACU_CODIGO(){
		return this.myCjacu_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	* @param inCjhac_descripcion DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	*/
	public void setCJHAC_DESCRIPCION(String inCjhac_descripcion){
		this.myCjhac_descripcion = inCjhac_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	* @return String DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	*/
	public String getCJHAC_DESCRIPCION(){
		return this.myCjhac_descripcion;
	}

	/**
	* ESTABLECE NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	* @param inCjhac_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	*/
	public void setCJHAC_RESPONSABLE(String inCjhac_responsable){
		this.myCjhac_responsable = inCjhac_responsable;
	}
	/**
	* OBTIENE NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	* @return String NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	*/
	public String getCJHAC_RESPONSABLE(){
		return this.myCjhac_responsable;
	}

	/**
	* ESTABLECE FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	* @param inCjhac_fecha FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	*/
	public void setCJHAC_FECHA(java.util.Date inCjhac_fecha){
		this.myCjhac_fecha = inCjhac_fecha;
	}
	/**
	* OBTIENE FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	* @return java.util.Date FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	*/
	public java.util.Date getCJHAC_FECHA(){
		return this.myCjhac_fecha;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DEL ACUERDO
	* @param inCjhac_estado ESTADO DEL REGISTRO DEL ACUERDO
	*/
	public void setCJHAC_ESTADO(boolean inCjhac_estado){
		this.myCjhac_estado = inCjhac_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DEL ACUERDO
	* @return boolean ESTADO DEL REGISTRO DEL ACUERDO
	*/
	public boolean getCJHAC_ESTADO(){
		return this.myCjhac_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DE HISTORIAL DE ACUERDO
	* @param inCjhac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DE HISTORIAL DE ACUERDO
	*/
	public void setCJHAC_USUARIO_INSERT(String inCjhac_usuario_insert){
		this.myCjhac_usuario_insert = inCjhac_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DE HISTORIAL DE ACUERDO
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA DE HISTORIAL DE ACUERDO
	*/
	public String getCJHAC_USUARIO_INSERT(){
		return this.myCjhac_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DE HISTORIAL DE ACUERDO
	* @param inCjhac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DE HISTORIAL DE ACUERDO
	*/
	public void setCJHAC_USUARIO_UPDATE(String inCjhac_usuario_update){
		this.myCjhac_usuario_update = inCjhac_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DE HISTORIAL DE ACUERDO
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION DE HISTORIAL DE ACUERDO
	*/
	public String getCJHAC_USUARIO_UPDATE(){
		return this.myCjhac_usuario_update;
	}

}
