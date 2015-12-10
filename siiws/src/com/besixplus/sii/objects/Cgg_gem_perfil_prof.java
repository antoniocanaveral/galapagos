package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_perfil_prof
* TABLA: PERFIL PROFESIONAL
* DESCRIPCION:ALMACENA INFORMACION DEL NIVEL DE EDUCACION DE LA PERSONA
* ABREVIATURA:CGPPR
*/
public class Cgg_gem_perfil_prof implements Serializable{
	private static final long serialVersionUID = 1057380983;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	*/
	private String myCgppr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	private String myCgesp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	private String myCgtpr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
	private String myCgmdc_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* NO ESPECIFICADO
	*/
	private String myCgien_codigo;
	/**
	* ULTIMO NIVEL QUE APROBO.
0 - APROBADO TODOS LOS NIVELES

	*/
	private int myCgppr_nivel_aprobado;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCgppr_fecha_inicio;
	/**
	* NO ESPECIFICADO
	*/
	private java.util.Date myCgppr_fecha_fin;
	/**
	* SI LA INFORMACION YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
SI
NO
	*/
	private boolean myCgppr_confirmado;
	/**
	* FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	*/
	private java.util.Date myCgppr_fecha_confirmacion;
	/**
	* DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	*/
	private boolean myCgppr_predeterminado;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgppr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgppr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgppr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_prof
	*/
	public Cgg_gem_perfil_prof(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_perfil_prof
	* @param inCgppr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	* @param inCgmdc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCgien_codigo NO ESPECIFICADO
	* @param inCgppr_nivel_aprobado ULTIMO NIVEL QUE APROBO.
0 - APROBADO TODOS LOS NIVELES

	* @param inCgppr_fecha_inicio NO ESPECIFICADO
	* @param inCgppr_fecha_fin NO ESPECIFICADO
	* @param inCgppr_confirmado SI LA INFORMACION YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
SI
NO
	* @param inCgppr_fecha_confirmacion FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	* @param inCgppr_predeterminado DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	* @param inCgppr_estado ESTADO DEL REGISTRO
	* @param inCgppr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgppr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_perfil_prof(
		String inCgppr_codigo,
		String inCgesp_codigo,
		String inCgtpr_codigo,
		String inCgmdc_codigo,
		String inCrper_codigo,
		String inCgien_codigo,
		int inCgppr_nivel_aprobado,
		java.util.Date inCgppr_fecha_inicio,
		java.util.Date inCgppr_fecha_fin,
		boolean inCgppr_confirmado,
		java.util.Date inCgppr_fecha_confirmacion,
		boolean inCgppr_predeterminado,
		boolean inCgppr_estado,
		String inCgppr_usuario_insert,
		String inCgppr_usuario_update
	){
		this.setCGPPR_CODIGO(inCgppr_codigo);
		this.setCGESP_CODIGO(inCgesp_codigo);
		this.setCGTPR_CODIGO(inCgtpr_codigo);
		this.setCGMDC_CODIGO(inCgmdc_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGIEN_CODIGO(inCgien_codigo);
		this.setCGPPR_NIVEL_APROBADO(inCgppr_nivel_aprobado);
		this.setCGPPR_FECHA_INICIO(inCgppr_fecha_inicio);
		this.setCGPPR_FECHA_FIN(inCgppr_fecha_fin);
		this.setCGPPR_CONFIRMADO(inCgppr_confirmado);
		this.setCGPPR_FECHA_CONFIRMACION(inCgppr_fecha_confirmacion);
		this.setCGPPR_PREDETERMINADO(inCgppr_predeterminado);
		this.setCGPPR_ESTADO(inCgppr_estado);
		this.setCGPPR_USUARIO_INSERT(inCgppr_usuario_insert);
		this.setCGPPR_USUARIO_UPDATE(inCgppr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	* @param inCgppr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	*/
	public void setCGPPR_CODIGO(String inCgppr_codigo){
		this.myCgppr_codigo = inCgppr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	*/
	public String getCGPPR_CODIGO(){
		return this.myCgppr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	public void setCGESP_CODIGO(String inCgesp_codigo){
		this.myCgesp_codigo = inCgesp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	public String getCGESP_CODIGO(){
		return this.myCgesp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	* @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	public void setCGTPR_CODIGO(String inCgtpr_codigo){
		this.myCgtpr_codigo = inCgtpr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	public String getCGTPR_CODIGO(){
		return this.myCgtpr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	* @param inCgmdc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
	public void setCGMDC_CODIGO(String inCgmdc_codigo){
		this.myCgmdc_codigo = inCgmdc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
	*/
	public String getCGMDC_CODIGO(){
		return this.myCgmdc_codigo;
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
	* ESTABLECE NO ESPECIFICADO
	* @param inCgien_codigo NO ESPECIFICADO
	*/
	public void setCGIEN_CODIGO(String inCgien_codigo){
		this.myCgien_codigo = inCgien_codigo;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCGIEN_CODIGO(){
		return this.myCgien_codigo;
	}

	/**
	* ESTABLECE ULTIMO NIVEL QUE APROBO.
0 - APROBADO TODOS LOS NIVELES

	* @param inCgppr_nivel_aprobado ULTIMO NIVEL QUE APROBO.
0 - APROBADO TODOS LOS NIVELES

	*/
	public void setCGPPR_NIVEL_APROBADO(int inCgppr_nivel_aprobado){
		this.myCgppr_nivel_aprobado = inCgppr_nivel_aprobado;
	}
	/**
	* OBTIENE ULTIMO NIVEL QUE APROBO.
0 - APROBADO TODOS LOS NIVELES

	* @return int ULTIMO NIVEL QUE APROBO.
0 - APROBADO TODOS LOS NIVELES

	*/
	public int getCGPPR_NIVEL_APROBADO(){
		return this.myCgppr_nivel_aprobado;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgppr_fecha_inicio NO ESPECIFICADO
	*/
	public void setCGPPR_FECHA_INICIO(java.util.Date inCgppr_fecha_inicio){
		this.myCgppr_fecha_inicio = inCgppr_fecha_inicio;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCGPPR_FECHA_INICIO(){
		return this.myCgppr_fecha_inicio;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCgppr_fecha_fin NO ESPECIFICADO
	*/
	public void setCGPPR_FECHA_FIN(java.util.Date inCgppr_fecha_fin){
		this.myCgppr_fecha_fin = inCgppr_fecha_fin;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return java.util.Date NO ESPECIFICADO
	*/
	public java.util.Date getCGPPR_FECHA_FIN(){
		return this.myCgppr_fecha_fin;
	}

	/**
	* ESTABLECE SI LA INFORMACION YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
SI
NO
	* @param inCgppr_confirmado SI LA INFORMACION YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
SI
NO
	*/
	public void setCGPPR_CONFIRMADO(boolean inCgppr_confirmado){
		this.myCgppr_confirmado = inCgppr_confirmado;
	}
	/**
	* OBTIENE SI LA INFORMACION YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
SI
NO
	* @return boolean SI LA INFORMACION YA FUE REVISADA POR ADMINISTRACION DE RESIDENCIA
SI
NO
	*/
	public boolean getCGPPR_CONFIRMADO(){
		return this.myCgppr_confirmado;
	}

	/**
	* ESTABLECE FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	* @param inCgppr_fecha_confirmacion FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	*/
	public void setCGPPR_FECHA_CONFIRMACION(java.util.Date inCgppr_fecha_confirmacion){
		this.myCgppr_fecha_confirmacion = inCgppr_fecha_confirmacion;
	}
	/**
	* OBTIENE FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	* @return java.util.Date FECHA EN LA QUE SE COMPROBO LA VERACIDAD DE LA INFORMACION
	*/
	public java.util.Date getCGPPR_FECHA_CONFIRMACION(){
		return this.myCgppr_fecha_confirmacion;
	}

	/**
	* ESTABLECE DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	* @param inCgppr_predeterminado DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	*/
	public void setCGPPR_PREDETERMINADO(boolean inCgppr_predeterminado){
		this.myCgppr_predeterminado = inCgppr_predeterminado;
	}
	/**
	* OBTIENE DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	* @return boolean DETERMINA SI EL REGISTRO ES EL ULTIMO ALCANZADO
	*/
	public boolean getCGPPR_PREDETERMINADO(){
		return this.myCgppr_predeterminado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgppr_estado ESTADO DEL REGISTRO
	*/
	public void setCGPPR_ESTADO(boolean inCgppr_estado){
		this.myCgppr_estado = inCgppr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGPPR_ESTADO(){
		return this.myCgppr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgppr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGPPR_USUARIO_INSERT(String inCgppr_usuario_insert){
		this.myCgppr_usuario_insert = inCgppr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGPPR_USUARIO_INSERT(){
		return this.myCgppr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgppr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGPPR_USUARIO_UPDATE(String inCgppr_usuario_update){
		this.myCgppr_usuario_update = inCgppr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGPPR_USUARIO_UPDATE(){
		return this.myCgppr_usuario_update;
	}

}
