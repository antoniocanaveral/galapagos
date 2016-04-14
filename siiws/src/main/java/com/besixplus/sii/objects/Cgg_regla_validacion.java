package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_regla_validacion
* TABLA: REGLAS DE VALIDACION	
* DESCRIPCION:ALMACENA INFORMACION DE LAS DIFERENTES REGLAS DE VALIDACION A SER PROCESADAS PARA EL REGISTRO, PROCESAMIENTO Y DEMAS TIPO DE OPERACION SOBRE LA INFORMACION.
* ABREVIATURA:CRVAL
*/
public class Cgg_regla_validacion implements Serializable{
	private static final long serialVersionUID = 1177168384;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	private String myCrval_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	*/
	private String myCgcnf_codigo;
	/**
	* NOMBRE DE LA REGLA DE VALIDACION
	*/
	private String myCrval_nombre;
	/**
	* CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	*/
	private String myCrval_descripcion;
	/**
	* CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	*/
	private String myCrval_funcion_validacion;
	/**
	* CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	*/
	private String myCrval_operador_comparador;
	/**
	* CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	*/
	private String myCrval_valor_libre;
	/**
	* CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	*/
	private String myCrval_resultado_aceptacion;
	/**
	* CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	*/
	private String myCrval_sugerencia;
	/**
	* TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	*/
	private int myCrval_tipo;
	/**
	* FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	*/
	private java.util.Date myCrvar_fecha_inicio;
	/**
	* FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	*/
	private java.util.Date myCrvar_fecha_fin;
	/**
	* CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	*/
	private String myCrval_valor_1;
	/**
	* NO ESPECIFICADO
	*/
	private String myCrval_valor_2;
	/**
	* ESTADO DEL REGISTRO DE LA REGLA DE VALIDACION
	*/
	private boolean myCrval_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrval_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrval_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_regla_validacion
	*/
	public Cgg_regla_validacion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_regla_validacion
	* @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	* @param inCrval_nombre NOMBRE DE LA REGLA DE VALIDACION
	* @param inCrval_descripcion CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	* @param inCrval_funcion_validacion CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	* @param inCrval_operador_comparador CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	* @param inCrval_valor_libre CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	* @param inCrval_resultado_aceptacion CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	* @param inCrval_sugerencia CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	* @param inCrval_tipo TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	* @param inCrvar_fecha_inicio FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	* @param inCrvar_fecha_fin FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	* @param inCrval_valor_1 CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	* @param inCrval_valor_2 NO ESPECIFICADO
	* @param inCrval_estado ESTADO DEL REGISTRO DE LA REGLA DE VALIDACION
	* @param inCrval_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrval_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_regla_validacion(
		String inCrval_codigo,
		String inCgcnf_codigo,
		String inCrval_nombre,
		String inCrval_descripcion,
		String inCrval_funcion_validacion,
		String inCrval_operador_comparador,
		String inCrval_valor_libre,
		String inCrval_resultado_aceptacion,
		String inCrval_sugerencia,
		int inCrval_tipo,
		java.util.Date inCrvar_fecha_inicio,
		java.util.Date inCrvar_fecha_fin,
		String inCrval_valor_1,
		String inCrval_valor_2,
		boolean inCrval_estado,
		String inCrval_usuario_insert,
		String inCrval_usuario_update
	){
		this.setCRVAL_CODIGO(inCrval_codigo);
		this.setCGCNF_CODIGO(inCgcnf_codigo);
		this.setCRVAL_NOMBRE(inCrval_nombre);
		this.setCRVAL_DESCRIPCION(inCrval_descripcion);
		this.setCRVAL_FUNCION_VALIDACION(inCrval_funcion_validacion);
		this.setCRVAL_OPERADOR_COMPARADOR(inCrval_operador_comparador);
		this.setCRVAL_VALOR_LIBRE(inCrval_valor_libre);
		this.setCRVAL_RESULTADO_ACEPTACION(inCrval_resultado_aceptacion);
		this.setCRVAL_SUGERENCIA(inCrval_sugerencia);
		this.setCRVAL_TIPO(inCrval_tipo);
		this.setCRVAR_FECHA_INICIO(inCrvar_fecha_inicio);
		this.setCRVAR_FECHA_FIN(inCrvar_fecha_fin);
		this.setCRVAL_VALOR_1(inCrval_valor_1);
		this.setCRVAL_VALOR_2(inCrval_valor_2);
		this.setCRVAL_ESTADO(inCrval_estado);
		this.setCRVAL_USUARIO_INSERT(inCrval_usuario_insert);
		this.setCRVAL_USUARIO_UPDATE(inCrval_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	public void setCRVAL_CODIGO(String inCrval_codigo){
		this.myCrval_codigo = inCrval_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	*/
	public String getCRVAL_CODIGO(){
		return this.myCrval_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	* @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	*/
	public void setCGCNF_CODIGO(String inCgcnf_codigo){
		this.myCgcnf_codigo = inCgcnf_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	*/
	public String getCGCNF_CODIGO(){
		return this.myCgcnf_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA REGLA DE VALIDACION
	* @param inCrval_nombre NOMBRE DE LA REGLA DE VALIDACION
	*/
	public void setCRVAL_NOMBRE(String inCrval_nombre){
		this.myCrval_nombre = inCrval_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA REGLA DE VALIDACION
	* @return String NOMBRE DE LA REGLA DE VALIDACION
	*/
	public String getCRVAL_NOMBRE(){
		return this.myCrval_nombre;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	* @param inCrval_descripcion CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	*/
	public void setCRVAL_DESCRIPCION(String inCrval_descripcion){
		this.myCrval_descripcion = inCrval_descripcion;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	* @return String CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	*/
	public String getCRVAL_DESCRIPCION(){
		return this.myCrval_descripcion;
	}

	/**
	* ESTABLECE CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	* @param inCrval_funcion_validacion CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	*/
	public void setCRVAL_FUNCION_VALIDACION(String inCrval_funcion_validacion){
		this.myCrval_funcion_validacion = inCrval_funcion_validacion;
	}
	/**
	* OBTIENE CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	* @return String CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	*/
	public String getCRVAL_FUNCION_VALIDACION(){
		return this.myCrval_funcion_validacion;
	}

	/**
	* ESTABLECE CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	* @param inCrval_operador_comparador CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	*/
	public void setCRVAL_OPERADOR_COMPARADOR(String inCrval_operador_comparador){
		this.myCrval_operador_comparador = inCrval_operador_comparador;
	}
	/**
	* OBTIENE CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	* @return String CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	*/
	public String getCRVAL_OPERADOR_COMPARADOR(){
		return this.myCrval_operador_comparador;
	}

	/**
	* ESTABLECE CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	* @param inCrval_valor_libre CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	*/
	public void setCRVAL_VALOR_LIBRE(String inCrval_valor_libre){
		this.myCrval_valor_libre = inCrval_valor_libre;
	}
	/**
	* OBTIENE CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	* @return String CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	*/
	public String getCRVAL_VALOR_LIBRE(){
		return this.myCrval_valor_libre;
	}

	/**
	* ESTABLECE CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	* @param inCrval_resultado_aceptacion CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	*/
	public void setCRVAL_RESULTADO_ACEPTACION(String inCrval_resultado_aceptacion){
		this.myCrval_resultado_aceptacion = inCrval_resultado_aceptacion;
	}
	/**
	* OBTIENE CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	* @return String CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	*/
	public String getCRVAL_RESULTADO_ACEPTACION(){
		return this.myCrval_resultado_aceptacion;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	* @param inCrval_sugerencia CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	*/
	public void setCRVAL_SUGERENCIA(String inCrval_sugerencia){
		this.myCrval_sugerencia = inCrval_sugerencia;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	* @return String CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	*/
	public String getCRVAL_SUGERENCIA(){
		return this.myCrval_sugerencia;
	}

	/**
	* ESTABLECE TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	* @param inCrval_tipo TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	*/
	public void setCRVAL_TIPO(int inCrval_tipo){
		this.myCrval_tipo = inCrval_tipo;
	}
	/**
	* OBTIENE TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	* @return int TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	*/
	public int getCRVAL_TIPO(){
		return this.myCrval_tipo;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	* @param inCrvar_fecha_inicio FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	*/
	public void setCRVAR_FECHA_INICIO(java.util.Date inCrvar_fecha_inicio){
		this.myCrvar_fecha_inicio = inCrvar_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	* @return java.util.Date FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	*/
	public java.util.Date getCRVAR_FECHA_INICIO(){
		return this.myCrvar_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	* @param inCrvar_fecha_fin FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	*/
	public void setCRVAR_FECHA_FIN(java.util.Date inCrvar_fecha_fin){
		this.myCrvar_fecha_fin = inCrvar_fecha_fin;
	}
	/**
	* OBTIENE FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	* @return java.util.Date FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	*/
	public java.util.Date getCRVAR_FECHA_FIN(){
		return this.myCrvar_fecha_fin;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	* @param inCrval_valor_1 CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	*/
	public void setCRVAL_VALOR_1(String inCrval_valor_1){
		this.myCrval_valor_1 = inCrval_valor_1;
	}
	/**
	* OBTIENE CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	* @return String CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	*/
	public String getCRVAL_VALOR_1(){
		return this.myCrval_valor_1;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCrval_valor_2 NO ESPECIFICADO
	*/
	public void setCRVAL_VALOR_2(String inCrval_valor_2){
		this.myCrval_valor_2 = inCrval_valor_2;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCRVAL_VALOR_2(){
		return this.myCrval_valor_2;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO DE LA REGLA DE VALIDACION
	* @param inCrval_estado ESTADO DEL REGISTRO DE LA REGLA DE VALIDACION
	*/
	public void setCRVAL_ESTADO(boolean inCrval_estado){
		this.myCrval_estado = inCrval_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO DE LA REGLA DE VALIDACION
	* @return boolean ESTADO DEL REGISTRO DE LA REGLA DE VALIDACION
	*/
	public boolean getCRVAL_ESTADO(){
		return this.myCrval_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrval_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRVAL_USUARIO_INSERT(String inCrval_usuario_insert){
		this.myCrval_usuario_insert = inCrval_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRVAL_USUARIO_INSERT(){
		return this.myCrval_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrval_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRVAL_USUARIO_UPDATE(String inCrval_usuario_update){
		this.myCrval_usuario_update = inCrval_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRVAL_USUARIO_UPDATE(){
		return this.myCrval_usuario_update;
	}

}
