package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_testigo
* TABLA: TESTIGO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TESTIMONIOS REALIZADOS POR LOS TESTIGOS DE UN MATRIMONIO
* ABREVIATURA:CRTST
*/
public class Cgg_res_testigo implements Serializable{
	private static final long serialVersionUID = 903931413;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	*/
	private String myCrtst_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	*/
	private String myCrint_codigo;
	/**
	* NOMBRE IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	
	private String myTestigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	
	private String myCrper_codigo;
	/**
	* TESTIMONIO DE UN PERSONA
	*/
	private String myCrtst_testimonio;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCrtst_observacion;
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
	* CONSTRUCTOR DE LA CLASE Cgg_res_testigo
	*/
	public Cgg_res_testigo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_testigo
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	* @param inCrint_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrtst_testimonio TESTIMONIO DE UN PERSONA
	* @param inCrtst_observacion INFORMACION ADICIONAL
	* @param inCrtst_estado ESTADO DEL REGISTRO
	* @param inCrtst_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrtst_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_testigo(
		String inCrtst_codigo,
		String inCrint_codigo,
		String inCrper_codigo,
		String inCrtst_testimonio,
		String inCrtst_observacion,
		boolean inCrtst_estado,
		String inCrtst_usuario_insert,
		String inCrtst_usuario_update
	){
		this.setCRTST_CODIGO(inCrtst_codigo);
		this.setCRINT_CODIGO(inCrint_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRTST_TESTIMONIO(inCrtst_testimonio);
		this.setCRTST_OBSERVACION(inCrtst_observacion);
		this.setCRTST_ESTADO(inCrtst_estado);
		this.setCRTST_USUARIO_INSERT(inCrtst_usuario_insert);
		this.setCRTST_USUARIO_UPDATE(inCrtst_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	*/
	public void setCRTST_CODIGO(String inCrtst_codigo){
		this.myCrtst_codigo = inCrtst_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	*/
	public String getCRTST_CODIGO(){
		return this.myCrtst_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	* @param inCrint_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	*/
	public void setCRINT_CODIGO(String inCrint_codigo){
		this.myCrint_codigo = inCrint_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	*/
	public String getCRINT_CODIGO(){
		return this.myCrint_codigo;
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
	* ESTABLECE TESTIMONIO DE UN PERSONA
	* @param inCrtst_testimonio TESTIMONIO DE UN PERSONA
	*/
	public void setCRTST_TESTIMONIO(String inCrtst_testimonio){
		this.myCrtst_testimonio = inCrtst_testimonio;
	}
	/**
	* OBTIENE TESTIMONIO DE UN PERSONA
	* @return String TESTIMONIO DE UN PERSONA
	*/
	public String getCRTST_TESTIMONIO(){
		return this.myCrtst_testimonio;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCrtst_observacion INFORMACION ADICIONAL
	*/
	public void setCRTST_OBSERVACION(String inCrtst_observacion){
		this.myCrtst_observacion = inCrtst_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCRTST_OBSERVACION(){
		return this.myCrtst_observacion;
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
	/**
	* ESTABLECE EL NOMBRE DEL TESTIGO 
	* @param inTestigo NOMBRE DEL TESTIGO
	*/
	public void setTESTIGO(String inTestigo){
		this.myTestigo = inTestigo;
	}
	/**
	* OBTIENE EL NOMBRE DEL USUARIO
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getTESTIGO(){
		return this.myTestigo;
	}

}
