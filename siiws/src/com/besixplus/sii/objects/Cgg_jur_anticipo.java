package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_jur_anticipo
* TABLA: ANTICIPO DE ACUERDO
* DESCRIPCION:ALMACENA INFORMACION DE LOS ANTICIPOS REALIZADOS A UN ACUERDO
* ABREVIATURA:CJAAC
*/
public class Cgg_jur_anticipo implements Serializable{
	private static final long serialVersionUID = 1585830341;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
	*/
	private String myCjaac_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	*/
	private String myCjacu_codigo;
	/**
	* VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
	*/
	private java.math.BigDecimal myCjaac_porcentaje;
	/**
	* CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	*/
	private String myCjaac_observacion;
	/**
	* FECHA DE REALIZACION DEL ANTICIPO
	*/
	private java.util.Date myCjaac_fecha;
	/**
	* MONTO DEL ANTICIPO
	*/
	private java.math.BigDecimal myCjaac_monto;
	/**
	* VALOR AUXILIAR DE ANTICIPO
	*/
	private String myCjaac_valor_1;
	/**
	* ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	*/
	private boolean myCjaac_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCjaac_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCjaac_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_anticipo
	*/
	public Cgg_jur_anticipo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_jur_anticipo
	* @param inCjaac_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
	* @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	* @param inCjaac_porcentaje VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
	* @param inCjaac_observacion CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	* @param inCjaac_fecha FECHA DE REALIZACION DEL ANTICIPO
	* @param inCjaac_monto MONTO DEL ANTICIPO
	* @param inCjaac_valor_1 VALOR AUXILIAR DE ANTICIPO
	* @param inCjaac_estado ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	* @param inCjaac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjaac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_jur_anticipo(
		String inCjaac_codigo,
		String inCjacu_codigo,
		java.math.BigDecimal inCjaac_porcentaje,
		String inCjaac_observacion,
		java.util.Date inCjaac_fecha,
		java.math.BigDecimal inCjaac_monto,
		String inCjaac_valor_1,
		boolean inCjaac_estado,
		String inCjaac_usuario_insert,
		String inCjaac_usuario_update
	){
		this.setCJAAC_CODIGO(inCjaac_codigo);
		this.setCJACU_CODIGO(inCjacu_codigo);
		this.setCJAAC_PORCENTAJE(inCjaac_porcentaje);
		this.setCJAAC_OBSERVACION(inCjaac_observacion);
		this.setCJAAC_FECHA(inCjaac_fecha);
		this.setCJAAC_MONTO(inCjaac_monto);
		this.setCJAAC_VALOR_1(inCjaac_valor_1);
		this.setCJAAC_ESTADO(inCjaac_estado);
		this.setCJAAC_USUARIO_INSERT(inCjaac_usuario_insert);
		this.setCJAAC_USUARIO_UPDATE(inCjaac_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
	* @param inCjaac_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
	*/
	public void setCJAAC_CODIGO(String inCjaac_codigo){
		this.myCjaac_codigo = inCjaac_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ANTICIPO DE ACUERDO
	*/
	public String getCJAAC_CODIGO(){
		return this.myCjaac_codigo;
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
	* ESTABLECE VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
	* @param inCjaac_porcentaje VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
	*/
	public void setCJAAC_PORCENTAJE(java.math.BigDecimal inCjaac_porcentaje){
		this.myCjaac_porcentaje = inCjaac_porcentaje;
	}
	/**
	* OBTIENE VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
	* @return java.math.BigDecimal VALOR NUMERICO DEL PORCENAJE CORRESPONDIENTE(EJM. 50%)
	*/
	public java.math.BigDecimal getCJAAC_PORCENTAJE(){
		return this.myCjaac_porcentaje;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	* @param inCjaac_observacion CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	*/
	public void setCJAAC_OBSERVACION(String inCjaac_observacion){
		this.myCjaac_observacion = inCjaac_observacion;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	* @return String CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
	*/
	public String getCJAAC_OBSERVACION(){
		return this.myCjaac_observacion;
	}

	/**
	* ESTABLECE FECHA DE REALIZACION DEL ANTICIPO
	* @param inCjaac_fecha FECHA DE REALIZACION DEL ANTICIPO
	*/
	public void setCJAAC_FECHA(java.util.Date inCjaac_fecha){
		this.myCjaac_fecha = inCjaac_fecha;
	}
	/**
	* OBTIENE FECHA DE REALIZACION DEL ANTICIPO
	* @return java.util.Date FECHA DE REALIZACION DEL ANTICIPO
	*/
	public java.util.Date getCJAAC_FECHA(){
		return this.myCjaac_fecha;
	}

	/**
	* ESTABLECE MONTO DEL ANTICIPO
	* @param inCjaac_monto MONTO DEL ANTICIPO
	*/
	public void setCJAAC_MONTO(java.math.BigDecimal inCjaac_monto){
		this.myCjaac_monto = inCjaac_monto;
	}
	/**
	* OBTIENE MONTO DEL ANTICIPO
	* @return java.math.BigDecimal MONTO DEL ANTICIPO
	*/
	public java.math.BigDecimal getCJAAC_MONTO(){
		return this.myCjaac_monto;
	}

	/**
	* ESTABLECE VALOR AUXILIAR DE ANTICIPO
	* @param inCjaac_valor_1 VALOR AUXILIAR DE ANTICIPO
	*/
	public void setCJAAC_VALOR_1(String inCjaac_valor_1){
		this.myCjaac_valor_1 = inCjaac_valor_1;
	}
	/**
	* OBTIENE VALOR AUXILIAR DE ANTICIPO
	* @return String VALOR AUXILIAR DE ANTICIPO
	*/
	public String getCJAAC_VALOR_1(){
		return this.myCjaac_valor_1;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	* @param inCjaac_estado ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	*/
	public void setCJAAC_ESTADO(boolean inCjaac_estado){
		this.myCjaac_estado = inCjaac_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	* @return boolean ESTADO DEL REGISTRO DE PROCESO DE CONTRATACION
	*/
	public boolean getCJAAC_ESTADO(){
		return this.myCjaac_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCjaac_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCJAAC_USUARIO_INSERT(String inCjaac_usuario_insert){
		this.myCjaac_usuario_insert = inCjaac_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCJAAC_USUARIO_INSERT(){
		return this.myCjaac_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCjaac_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCJAAC_USUARIO_UPDATE(String inCjaac_usuario_update){
		this.myCjaac_usuario_update = inCjaac_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCJAAC_USUARIO_UPDATE(){
		return this.myCjaac_usuario_update;
	}

}
