package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_motor
* TABLA: MOTOR
* DESCRIPCION:ALMACENA INFORMACION DE LOS MOTORES DE LOS VEHICULOS
* ABREVIATURA:CVMTR
*/
public class Cgg_veh_motor implements Serializable{
	private static final long serialVersionUID = 29471467;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	private String myCvmtr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	*/
	private String myCvcln_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	private String myCvmrc_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	private String myCvcmb_codigo;
	/**
	* SERIE DE FABRICA DEL MOTOR
	*/
	private String myCvmtr_serie;
	/**
	* ANIO DE FABRICACION DEL MOTOR.
	*/
	private int myCvmtr_anio_fabricacion;
	/**
	* ESTADO DE FUNCIONAMIENTO DEL MOTOR
	*/
	private boolean myCvmtr_estado_funcional;
	/**
	* CAPACIDAD DE CARGA
	*/
	private int myCvmtr_tonelaje;
	/**
	* INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	*/
	private boolean myCvmtr_ingreso;
	/**
	* FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	*/
	private java.util.Date myCvmtr_fecha_ingreso;
	/**
	* INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	*/
	private boolean myCvmtr_salio;
	/**
	* FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	*/
	private java.util.Date myCvmtr_fecha_salida;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvmtr_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvmtr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvmtr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvmtr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_motor
	*/
	public Cgg_veh_motor(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_motor
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvcln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvcmb_codigo IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @param inCvmtr_serie SERIE DE FABRICA DEL MOTOR
	* @param inCvmtr_anio_fabricacion ANIO DE FABRICACION DEL MOTOR.
	* @param inCvmtr_estado_funcional ESTADO DE FUNCIONAMIENTO DEL MOTOR
	* @param inCvmtr_tonelaje CAPACIDAD DE CARGA
	* @param inCvmtr_ingreso INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	* @param inCvmtr_fecha_ingreso FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	* @param inCvmtr_salio INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	* @param inCvmtr_fecha_salida FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	* @param inCvmtr_observacion INFORMACION ADICIONAL
	* @param inCvmtr_estado ESTADO DEL REGISTRO
	* @param inCvmtr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvmtr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_motor(
		String inCvmtr_codigo,
		String inCvcln_codigo,
		String inCvmrc_codigo,
		String inCvcmb_codigo,
		String inCvmtr_serie,
		int inCvmtr_anio_fabricacion,
		boolean inCvmtr_estado_funcional,
		int inCvmtr_tonelaje,
		boolean inCvmtr_ingreso,
		java.util.Date inCvmtr_fecha_ingreso,
		boolean inCvmtr_salio,
		java.util.Date inCvmtr_fecha_salida,
		String inCvmtr_observacion,
		boolean inCvmtr_estado,
		String inCvmtr_usuario_insert,
		String inCvmtr_usuario_update
	){
		this.setCVMTR_CODIGO(inCvmtr_codigo);
		this.setCVCLN_CODIGO(inCvcln_codigo);
		this.setCVMRC_CODIGO(inCvmrc_codigo);
		this.setCVCMB_CODIGO(inCvcmb_codigo);
		this.setCVMTR_SERIE(inCvmtr_serie);
		this.setCVMTR_ANIO_FABRICACION(inCvmtr_anio_fabricacion);
		this.setCVMTR_ESTADO_FUNCIONAL(inCvmtr_estado_funcional);
		this.setCVMTR_TONELAJE(inCvmtr_tonelaje);
		this.setCVMTR_INGRESO(inCvmtr_ingreso);
		this.setCVMTR_FECHA_INGRESO(inCvmtr_fecha_ingreso);
		this.setCVMTR_SALIO(inCvmtr_salio);
		this.setCVMTR_FECHA_SALIDA(inCvmtr_fecha_salida);
		this.setCVMTR_OBSERVACION(inCvmtr_observacion);
		this.setCVMTR_ESTADO(inCvmtr_estado);
		this.setCVMTR_USUARIO_INSERT(inCvmtr_usuario_insert);
		this.setCVMTR_USUARIO_UPDATE(inCvmtr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	public void setCVMTR_CODIGO(String inCvmtr_codigo){
		this.myCvmtr_codigo = inCvmtr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	*/
	public String getCVMTR_CODIGO(){
		return this.myCvmtr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @param inCvcln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	*/
	public void setCVCLN_CODIGO(String inCvcln_codigo){
		this.myCvcln_codigo = inCvcln_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	*/
	public String getCVCLN_CODIGO(){
		return this.myCvcln_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	public void setCVMRC_CODIGO(String inCvmrc_codigo){
		this.myCvmrc_codigo = inCvmrc_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	public String getCVMRC_CODIGO(){
		return this.myCvmrc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @param inCvcmb_codigo IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	public void setCVCMB_CODIGO(String inCvcmb_codigo){
		this.myCvcmb_codigo = inCvcmb_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	public String getCVCMB_CODIGO(){
		return this.myCvcmb_codigo;
	}

	/**
	* ESTABLECE SERIE DE FABRICA DEL MOTOR
	* @param inCvmtr_serie SERIE DE FABRICA DEL MOTOR
	*/
	public void setCVMTR_SERIE(String inCvmtr_serie){
		this.myCvmtr_serie = inCvmtr_serie;
	}
	/**
	* OBTIENE SERIE DE FABRICA DEL MOTOR
	* @return String SERIE DE FABRICA DEL MOTOR
	*/
	public String getCVMTR_SERIE(){
		return this.myCvmtr_serie;
	}

	/**
	* ESTABLECE ANIO DE FABRICACION DEL MOTOR.
	* @param inCvmtr_anio_fabricacion ANIO DE FABRICACION DEL MOTOR.
	*/
	public void setCVMTR_ANIO_FABRICACION(int inCvmtr_anio_fabricacion){
		this.myCvmtr_anio_fabricacion = inCvmtr_anio_fabricacion;
	}
	/**
	* OBTIENE ANIO DE FABRICACION DEL MOTOR.
	* @return int ANIO DE FABRICACION DEL MOTOR.
	*/
	public int getCVMTR_ANIO_FABRICACION(){
		return this.myCvmtr_anio_fabricacion;
	}

	/**
	* ESTABLECE ESTADO DE FUNCIONAMIENTO DEL MOTOR
	* @param inCvmtr_estado_funcional ESTADO DE FUNCIONAMIENTO DEL MOTOR
	*/
	public void setCVMTR_ESTADO_FUNCIONAL(boolean inCvmtr_estado_funcional){
		this.myCvmtr_estado_funcional = inCvmtr_estado_funcional;
	}
	/**
	* OBTIENE ESTADO DE FUNCIONAMIENTO DEL MOTOR
	* @return boolean ESTADO DE FUNCIONAMIENTO DEL MOTOR
	*/
	public boolean getCVMTR_ESTADO_FUNCIONAL(){
		return this.myCvmtr_estado_funcional;
	}

	/**
	* ESTABLECE CAPACIDAD DE CARGA
	* @param inCvmtr_tonelaje CAPACIDAD DE CARGA
	*/
	public void setCVMTR_TONELAJE(int inCvmtr_tonelaje){
		this.myCvmtr_tonelaje = inCvmtr_tonelaje;
	}
	/**
	* OBTIENE CAPACIDAD DE CARGA
	* @return int CAPACIDAD DE CARGA
	*/
	public int getCVMTR_TONELAJE(){
		return this.myCvmtr_tonelaje;
	}

	/**
	* ESTABLECE INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	* @param inCvmtr_ingreso INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	*/
	public void setCVMTR_INGRESO(boolean inCvmtr_ingreso){
		this.myCvmtr_ingreso = inCvmtr_ingreso;
	}
	/**
	* OBTIENE INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	* @return boolean INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	*/
	public boolean getCVMTR_INGRESO(){
		return this.myCvmtr_ingreso;
	}

	/**
	* ESTABLECE FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	* @param inCvmtr_fecha_ingreso FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	*/
	public void setCVMTR_FECHA_INGRESO(java.util.Date inCvmtr_fecha_ingreso){
		this.myCvmtr_fecha_ingreso = inCvmtr_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	* @return java.util.Date FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	*/
	public java.util.Date getCVMTR_FECHA_INGRESO(){
		return this.myCvmtr_fecha_ingreso;
	}

	/**
	* ESTABLECE INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	* @param inCvmtr_salio INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	*/
	public void setCVMTR_SALIO(boolean inCvmtr_salio){
		this.myCvmtr_salio = inCvmtr_salio;
	}
	/**
	* OBTIENE INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	* @return boolean INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	*/
	public boolean getCVMTR_SALIO(){
		return this.myCvmtr_salio;
	}

	/**
	* ESTABLECE FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	* @param inCvmtr_fecha_salida FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	*/
	public void setCVMTR_FECHA_SALIDA(java.util.Date inCvmtr_fecha_salida){
		this.myCvmtr_fecha_salida = inCvmtr_fecha_salida;
	}
	/**
	* OBTIENE FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	* @return java.util.Date FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	*/
	public java.util.Date getCVMTR_FECHA_SALIDA(){
		return this.myCvmtr_fecha_salida;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvmtr_observacion INFORMACION ADICIONAL
	*/
	public void setCVMTR_OBSERVACION(String inCvmtr_observacion){
		this.myCvmtr_observacion = inCvmtr_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVMTR_OBSERVACION(){
		return this.myCvmtr_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvmtr_estado ESTADO DEL REGISTRO
	*/
	public void setCVMTR_ESTADO(boolean inCvmtr_estado){
		this.myCvmtr_estado = inCvmtr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVMTR_ESTADO(){
		return this.myCvmtr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvmtr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVMTR_USUARIO_INSERT(String inCvmtr_usuario_insert){
		this.myCvmtr_usuario_insert = inCvmtr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVMTR_USUARIO_INSERT(){
		return this.myCvmtr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvmtr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVMTR_USUARIO_UPDATE(String inCvmtr_usuario_update){
		this.myCvmtr_usuario_update = inCvmtr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVMTR_USUARIO_UPDATE(){
		return this.myCvmtr_usuario_update;
	}

}
