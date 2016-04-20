package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_informacion_laboral
* TABLA: INFORMACION_LABORAL
* DESCRIPCION:ALMACENA INFORMACION ADICIONAL DE LAS PERSONAS PARA EL MODULO DE GESTION DE EMPLEO
* ABREVIATURA:CGINF
*/
public class Cgg_gem_informacion_laboral implements Serializable{
	private static final long serialVersionUID = 2131023027;
	/**
	* NO ESPECIFICADO
	*/
	private String myCginf_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	*/
	private String myCrper_codigo;
	/**
	* TRABAJARIA O NO EN OTRA CIUDAD
	*/
	private String myCginf_trab_otra_ciudad;
	/**
	* EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	*/
	private String myCginf_disponibilidad;
	/**
	* SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	*/
	private java.math.BigDecimal myCrper_aspiracion_salarial;
	/**
	* CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
0 - NO
1 - SI
2 - PRONTO
	*/
	private String myCGINF_CALIFICACION;
	/**
	* DETERMINA SI TIENE O NO LICENCIA DE CONDUCIR
0 - NO
1 - SI 
2 - PRONTO
	*/
	private String myCginf_licencia_conducir;
	/**
	* DETERMINA SI LA PERSONA TIENE ALGUNA DISCAPACIDAD

	*/
	private boolean myCginf_discapacidad;
	/**
	* NO ESPECIFICADO
	*/
	private String myCginf_estado_laboral;
	/**
	* NUMERO DE HIJOS
	*/
	private int myCginf_hijos;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCginf_observaciones;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCginf_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCginf_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCginf_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_informacion_laboral
	*/
	public Cgg_gem_informacion_laboral(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_informacion_laboral
	* @param inCginf_codigo NO ESPECIFICADO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	* @param inCginf_trab_otra_ciudad ESPECIFICA SI TRABAJARIA O NO FUERA DE LA CIUDAD.
	0 - NO
	1 - SI
	* @param inCginf_disponibilidad EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	* @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	* @param inCGINF_CALIFICACION CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
	0 - NO
	1 - SI
	2 - PRONTO
	* @param inCginf_licencia_conducir DETERMINA SI TIENE O NO LICENCIA DE CONDUCIR
	0 - NO
	1 - SI 
	2 - PRONTO
	* @param inCginf_discapacidad DETERMINA SI LA PERSONA TIENE ALGUNA DISCAPACIDAD

	* @param inCginf_estado_laboral NO ESPECIFICADO
	 * @param inCginf_hijos NUMERO DE HIJOS QUE TIENE LA PERSONA
	* @param inCginf_observaciones INFORMACION ADICIONAL
	* @param inCginf_estado ESTADO DEL REGISTRO
	* @param inCginf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCginf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_informacion_laboral(
		String inCginf_codigo,
		String inCrper_codigo,
		String inCginf_trab_otra_ciudad,
		String inCginf_disponibilidad,
		java.math.BigDecimal inCrper_aspiracion_salarial,
		String inCGINF_CALIFICACION,
		String inCginf_licencia_conducir,
		boolean inCginf_discapacidad,
		String inCginf_estado_laboral,
		int inCginf_hijos,
		String inCginf_observaciones,
		boolean inCginf_estado,
		String inCginf_usuario_insert,
		String inCginf_usuario_update
	){
		this.setCGINF_CODIGO(inCginf_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGINF_TRAB_OTRA_CIUDAD(inCginf_trab_otra_ciudad);
		this.setCGINF_DISPONIBILIDAD(inCginf_disponibilidad);
		this.setCRPER_ASPIRACION_SALARIAL(inCrper_aspiracion_salarial);
		this.setCGINF_CALIFICACION(inCGINF_CALIFICACION);
		this.setCGINF_LICENCIA_CONDUCIR(inCginf_licencia_conducir);
		this.setCGINF_DISCAPACIDAD(inCginf_discapacidad);
		this.setCGINF_ESTADO_LABORAL(inCginf_estado_laboral);
		this.setCGINF_HIJOS(inCginf_hijos);
		this.setCGINF_OBSERVACIONES(inCginf_observaciones);
		this.setCGINF_ESTADO(inCginf_estado);
		this.setCGINF_USUARIO_INSERT(inCginf_usuario_insert);
		this.setCGINF_USUARIO_UPDATE(inCginf_usuario_update);
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCginf_codigo NO ESPECIFICADO
	*/
	public void setCGINF_CODIGO(String inCginf_codigo){
		this.myCginf_codigo = inCginf_codigo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGINF_CODIGO(){
		return this.myCginf_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE LA TABLA PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}
	/**
	* ESTABLECE SI TRABAJARIA O NO FUERA DE LA CIUDAD.
	* @param inCginf_trab_otra_ciudad ESPECIFICA SI TRABAJARIA O NO FUERA DE LA CIUDAD.
	*/
	public void setCGINF_TRAB_OTRA_CIUDAD(String inCginf_trab_otra_ciudad){
		this.myCginf_trab_otra_ciudad = inCginf_trab_otra_ciudad;
	}
	/**
	* OBTIENE SI TRABAJARIA O NO FUERA DE LA CIUDAD.
	* @return String ESPECIFICA SI TRABAJARIA O NO FUERA DE LA CIUDAD
	*/
	public String getCGINF_TRAB_OTRA_CIUDAD(){
		return this.myCginf_trab_otra_ciudad;
	}
	/**
	* ESTABLECE EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	* @param inCginf_disponibilidad EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	*/
	public void setCGINF_DISPONIBILIDAD(String inCginf_disponibilidad){
		this.myCginf_disponibilidad = inCginf_disponibilidad;
	}
	/**
	* OBTIENE EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	* @return String EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	*/
	public String getCGINF_DISPONIBILIDAD(){
		return this.myCginf_disponibilidad;
	}	
	
	/**
	* ESTABLECE EL SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	* @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	*/
	public void setCRPER_ASPIRACION_SALARIAL(java.math.BigDecimal inCrper_aspiracion_salarial){
		this.myCrper_aspiracion_salarial = inCrper_aspiracion_salarial;
	}
	/**
	* OBTIENE EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	* @return String EN QUE TIEMPO ESTA DISPONIBLE PARA APLICAR A OTRO TRABAJO
	*/
	public java.math.BigDecimal getCRPER_ASPIRACION_SALARIAL(){
		return this.myCrper_aspiracion_salarial;
	}
	/**
	* ESTABLECE CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
0 - NO
1 - SI
2 - PRONTO
	* @param inCGINF_CALIFICACION CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
0 - NO
1 - SI
2 - PRONTO
	*/
	public void setCGINF_CALIFICACION(String inCGINF_CALIFICACION){
		this.myCGINF_CALIFICACION = inCGINF_CALIFICACION;
	}
	/**
	* OBTIENE CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
0 - NO
1 - SI
2 - PRONTO
	* @return String CAMPO QUE REPRESENTA SI UN RESIDENTE TIENE VEHICULO
0 - NO
1 - SI
2 - PRONTO
	*/
	public String getCGINF_CALIFICACION(){
		return this.myCGINF_CALIFICACION;
	}

	/**
	* ESTABLECE DETERMINA SI TIENE O NO LICENCIA DE CONDUCIR
0 - NO
1 - SI 
2 - PRONTO
	* @param inCginf_licencia_conducir DETERMINA SI TIENE O NO LICENCIA DE CONDUCIR
0 - NO
1 - SI 
2 - PRONTO
	*/
	public void setCGINF_LICENCIA_CONDUCIR(String inCginf_licencia_conducir){
		this.myCginf_licencia_conducir = inCginf_licencia_conducir;
	}
	/**
	* OBTIENE DETERMINA SI TIENE O NO LICENCIA DE CONDUCIR
0 - NO
1 - SI 
2 - PRONTO
	* @return String DETERMINA SI TIENE O NO LICENCIA DE CONDUCIR
0 - NO
1 - SI 
2 - PRONTO
	*/
	public String getCGINF_LICENCIA_CONDUCIR(){
		return this.myCginf_licencia_conducir;
	}

	/**
	* ESTABLECE DETERMINA SI LA PERSONA TIENE ALGUNA DISCAPACIDAD

	* @param inCginf_discapacidad DETERMINA SI LA PERSONA TIENE ALGUNA DISCAPACIDAD

	*/
	public void setCGINF_DISCAPACIDAD(boolean inCginf_discapacidad){
		this.myCginf_discapacidad = inCginf_discapacidad;
	}
	/**
	* OBTIENE DETERMINA SI LA PERSONA TIENE ALGUNA DISCAPACIDAD

	* @return boolean DETERMINA SI LA PERSONA TIENE ALGUNA DISCAPACIDAD

	*/
	public boolean getCGINF_DISCAPACIDAD(){
		return this.myCginf_discapacidad;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCginf_estado_laboral NO ESPECIFICADO
	*/
	public void setCGINF_ESTADO_LABORAL(String inCginf_estado_laboral){
		this.myCginf_estado_laboral = inCginf_estado_laboral;
	}	
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGINF_ESTADO_LABORAL(){
		return this.myCginf_estado_laboral;
	}
	/**
	* NUMERO DE HIJOS
	* @param inCginf_hijos Numero de Hijos
	*/
	public void setCGINF_HIJOS(int inCginf_hijos){
		this.myCginf_hijos = inCginf_hijos;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public int getCGINF_HIJOS(){
		return this.myCginf_hijos;
	}
	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCginf_observaciones INFORMACION ADICIONAL
	*/
	public void setCGINF_OBSERVACIONES(String inCginf_observaciones){
		this.myCginf_observaciones = inCginf_observaciones;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCGINF_OBSERVACIONES(){
		return this.myCginf_observaciones;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCginf_estado ESTADO DEL REGISTRO
	*/
	public void setCGINF_ESTADO(boolean inCginf_estado){
		this.myCginf_estado = inCginf_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGINF_ESTADO(){
		return this.myCginf_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCginf_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGINF_USUARIO_INSERT(String inCginf_usuario_insert){
		this.myCginf_usuario_insert = inCginf_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGINF_USUARIO_INSERT(){
		return this.myCginf_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCginf_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGINF_USUARIO_UPDATE(String inCginf_usuario_update){
		this.myCginf_usuario_update = inCginf_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGINF_USUARIO_UPDATE(){
		return this.myCginf_usuario_update;
	}

}
