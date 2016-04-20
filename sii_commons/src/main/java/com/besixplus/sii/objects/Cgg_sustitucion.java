package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_sustitucion
* TABLA: SUSTITUCION
* DESCRIPCION:ALMACENA INFORMACION DE LOS ENCARGOS TEMPORALES DE RESPONSABILIDADES ENTRE USUARIOS INTERNOS DE LA INSTITUCION
* ABREVIATURA:CSUST
*/
public class Cgg_sustitucion implements Serializable{
	private static final long serialVersionUID = 5298114;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCsust_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
	*/
	private String myCusu_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
	*/
	private String myCgg_cusu_codigo;
	/**
	* TIPO DE SUSTITUCION
0 - TEMPORAL DENTRO DEL PERIODO INDICADO
1 - INDEFINIDA A PARTIR DE LA FECHA DE INICIO
	*/
	private int myCsust_modalidad;
	/**
	* INICIO DEL PERIODO DE SUSTITUCION
	*/
	private java.util.Date myCsust_fecha_inicio;
	/**
	* FIN DEL PERIODO DE SUSTITUCION
	*/
	private java.util.Date myCsust_fecha_fin;
	/**
	* ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
0 - INACTIVO
1 - ACTIVO
	*/
	private boolean myCsust_estado_encargo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCsust_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCsust_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCsust_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sustitucion
	*/
	public Cgg_sustitucion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sustitucion
	* @param inCsust_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
	* @param inCsust_modalidad TIPO DE SUSTITUCION
0 - TEMPORAL DENTRO DEL PERIODO INDICADO
1 - INDEFINIDA A PARTIR DE LA FECHA DE INICIO
	* @param inCsust_fecha_inicio INICIO DEL PERIODO DE SUSTITUCION
	* @param inCsust_fecha_fin FIN DEL PERIODO DE SUSTITUCION
	* @param inCsust_estado_encargo ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
0 - INACTIVO
1 - ACTIVO
	* @param inCsust_estado ESTADO DEL REGISTRO
	* @param inCsust_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsust_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_sustitucion(
		String inCsust_codigo,
		String inCusu_codigo,
		String inCgg_cusu_codigo,
		int inCsust_modalidad,
		java.util.Date inCsust_fecha_inicio,
		java.util.Date inCsust_fecha_fin,
		boolean inCsust_estado_encargo,
		boolean inCsust_estado,
		String inCsust_usuario_insert,
		String inCsust_usuario_update
	){
		this.setCSUST_CODIGO(inCsust_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		this.setCSUST_MODALIDAD(inCsust_modalidad);
		this.setCSUST_FECHA_INICIO(inCsust_fecha_inicio);
		this.setCSUST_FECHA_FIN(inCsust_fecha_fin);
		this.setCSUST_ESTADO_ENCARGO(inCsust_estado_encargo);
		this.setCSUST_ESTADO(inCsust_estado);
		this.setCSUST_USUARIO_INSERT(inCsust_usuario_insert);
		this.setCSUST_USUARIO_UPDATE(inCsust_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCsust_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCSUST_CODIGO(String inCsust_codigo){
		this.myCsust_codigo = inCsust_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCSUST_CODIGO(){
		return this.myCsust_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
	* @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
	*/
	public void setCGG_CUSU_CODIGO(String inCgg_cusu_codigo){
		this.myCgg_cusu_codigo = inCgg_cusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
	*/
	public String getCGG_CUSU_CODIGO(){
		return this.myCgg_cusu_codigo;
	}

	/**
	* ESTABLECE TIPO DE SUSTITUCION
0 - TEMPORAL DENTRO DEL PERIODO INDICADO
1 - INDEFINIDA A PARTIR DE LA FECHA DE INICIO
	* @param inCsust_modalidad TIPO DE SUSTITUCION
0 - TEMPORAL DENTRO DEL PERIODO INDICADO
1 - INDEFINIDA A PARTIR DE LA FECHA DE INICIO
	*/
	public void setCSUST_MODALIDAD(int inCsust_modalidad){
		this.myCsust_modalidad = inCsust_modalidad;
	}
	/**
	* OBTIENE TIPO DE SUSTITUCION
0 - TEMPORAL DENTRO DEL PERIODO INDICADO
1 - INDEFINIDA A PARTIR DE LA FECHA DE INICIO
	* @return int TIPO DE SUSTITUCION
0 - TEMPORAL DENTRO DEL PERIODO INDICADO
1 - INDEFINIDA A PARTIR DE LA FECHA DE INICIO
	*/
	public int getCSUST_MODALIDAD(){
		return this.myCsust_modalidad;
	}

	/**
	* ESTABLECE INICIO DEL PERIODO DE SUSTITUCION
	* @param inCsust_fecha_inicio INICIO DEL PERIODO DE SUSTITUCION
	*/
	public void setCSUST_FECHA_INICIO(java.util.Date inCsust_fecha_inicio){
		this.myCsust_fecha_inicio = inCsust_fecha_inicio;
	}
	/**
	* OBTIENE INICIO DEL PERIODO DE SUSTITUCION
	* @return java.util.Date INICIO DEL PERIODO DE SUSTITUCION
	*/
	public java.util.Date getCSUST_FECHA_INICIO(){
		return this.myCsust_fecha_inicio;
	}

	/**
	* ESTABLECE FIN DEL PERIODO DE SUSTITUCION
	* @param inCsust_fecha_fin FIN DEL PERIODO DE SUSTITUCION
	*/
	public void setCSUST_FECHA_FIN(java.util.Date inCsust_fecha_fin){
		this.myCsust_fecha_fin = inCsust_fecha_fin;
	}
	/**
	* OBTIENE FIN DEL PERIODO DE SUSTITUCION
	* @return java.util.Date FIN DEL PERIODO DE SUSTITUCION
	*/
	public java.util.Date getCSUST_FECHA_FIN(){
		return this.myCsust_fecha_fin;
	}

	/**
	* ESTABLECE ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
0 - INACTIVO
1 - ACTIVO
	* @param inCsust_estado_encargo ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
0 - INACTIVO
1 - ACTIVO
	*/
	public void setCSUST_ESTADO_ENCARGO(boolean inCsust_estado_encargo){
		this.myCsust_estado_encargo = inCsust_estado_encargo;
	}
	/**
	* OBTIENE ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
0 - INACTIVO
1 - ACTIVO
	* @return boolean ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
0 - INACTIVO
1 - ACTIVO
	*/
	public boolean getCSUST_ESTADO_ENCARGO(){
		return this.myCsust_estado_encargo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCsust_estado ESTADO DEL REGISTRO
	*/
	public void setCSUST_ESTADO(boolean inCsust_estado){
		this.myCsust_estado = inCsust_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCSUST_ESTADO(){
		return this.myCsust_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCsust_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCSUST_USUARIO_INSERT(String inCsust_usuario_insert){
		this.myCsust_usuario_insert = inCsust_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCSUST_USUARIO_INSERT(){
		return this.myCsust_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCsust_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCSUST_USUARIO_UPDATE(String inCsust_usuario_update){
		this.myCsust_usuario_update = inCsust_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCSUST_USUARIO_UPDATE(){
		return this.myCsust_usuario_update;
	}

}
