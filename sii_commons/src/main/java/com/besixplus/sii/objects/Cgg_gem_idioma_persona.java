package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_gem_idioma_persona
* TABLA: IDIOMA
* DESCRIPCION:ALMACENA INFORMACION DE LOS IDIOMAS ADICINALES QUE CONOCE LA PERSONA
* ABREVIATURA:CGIDP
*/
public class Cgg_gem_idioma_persona implements Serializable{
	private static final long serialVersionUID = 526417006;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgidp_codigo;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgidm_codigo;
	/**
	* IDENTIFICATIVO DEL IDIOMA
	*/
	private String myCgidp_nombre;
	/**
	* PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	*/
	private java.math.BigDecimal myCgidp_escritura;
	/**
	* PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	*/
	private java.math.BigDecimal myCgidp_lectura;
	/**
	* PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	*/
	private java.math.BigDecimal myCgidp_hablar;
	/**
	* PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	*/
	private java.math.BigDecimal myCgidp_escuchar;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgidp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgidp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgidp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_idioma_persona
	*/
	public Cgg_gem_idioma_persona(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_idioma_persona
	* @param inCgidp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCgidm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgidp_nombre IDENTIFICATIVO DEL IDIOMA
	* @param inCgidp_escritura PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	* @param inCgidp_lectura PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	* @param inCgidp_hablar PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	* @param inCgidp_escuchar PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	* @param inCgidp_estado ESTADO DEL REGISTRO
	* @param inCgidp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgidp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_gem_idioma_persona(
		String inCgidp_codigo,
		String inCrper_codigo,
		String inCgidm_codigo,
		String inCgidp_nombre,
		java.math.BigDecimal inCgidp_escritura,
		java.math.BigDecimal inCgidp_lectura,
		java.math.BigDecimal inCgidp_hablar,
		java.math.BigDecimal inCgidp_escuchar,
		boolean inCgidp_estado,
		String inCgidp_usuario_insert,
		String inCgidp_usuario_update
	){
		this.setCGIDP_CODIGO(inCgidp_codigo);
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCGIDM_CODIGO(inCgidm_codigo);
		this.setCGIDP_NOMBRE(inCgidp_nombre);
		this.setCGIDP_ESCRITURA(inCgidp_escritura);
		this.setCGIDP_LECTURA(inCgidp_lectura);
		this.setCGIDP_HABLAR(inCgidp_hablar);
		this.setCGIDP_ESCUCHAR(inCgidp_escuchar);
		this.setCGIDP_ESTADO(inCgidp_estado);
		this.setCGIDP_USUARIO_INSERT(inCgidp_usuario_insert);
		this.setCGIDP_USUARIO_UPDATE(inCgidp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgidp_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGIDP_CODIGO(String inCgidp_codigo){
		this.myCgidp_codigo = inCgidp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGIDP_CODIGO(){
		return this.myCgidp_codigo;
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgidm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGIDM_CODIGO(String inCgidm_codigo){
		this.myCgidm_codigo = inCgidm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGIDM_CODIGO(){
		return this.myCgidm_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO DEL IDIOMA
	* @param inCgidp_nombre IDENTIFICATIVO DEL IDIOMA
	*/
	public void setCGIDP_NOMBRE(String inCgidp_nombre){
		this.myCgidp_nombre = inCgidp_nombre;
	}
	/**
	* OBTIENE IDENTIFICATIVO DEL IDIOMA
	* @return String IDENTIFICATIVO DEL IDIOMA
	*/
	public String getCGIDP_NOMBRE(){
		return this.myCgidp_nombre;
	}

	/**
	* ESTABLECE PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	* @param inCgidp_escritura PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	*/
	public void setCGIDP_ESCRITURA(java.math.BigDecimal inCgidp_escritura){
		this.myCgidp_escritura = inCgidp_escritura;
	}
	/**
	* OBTIENE PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	* @return java.math.BigDecimal PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	*/
	public java.math.BigDecimal getCGIDP_ESCRITURA(){
		return this.myCgidp_escritura;
	}

	/**
	* ESTABLECE PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	* @param inCgidp_lectura PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	*/
	public void setCGIDP_LECTURA(java.math.BigDecimal inCgidp_lectura){
		this.myCgidp_lectura = inCgidp_lectura;
	}
	/**
	* OBTIENE PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	* @return java.math.BigDecimal PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	*/
	public java.math.BigDecimal getCGIDP_LECTURA(){
		return this.myCgidp_lectura;
	}

	/**
	* ESTABLECE PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	* @param inCgidp_hablar PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	*/
	public void setCGIDP_HABLAR(java.math.BigDecimal inCgidp_hablar){
		this.myCgidp_hablar = inCgidp_hablar;
	}
	/**
	* OBTIENE PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	* @return java.math.BigDecimal PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	*/
	public java.math.BigDecimal getCGIDP_HABLAR(){
		return this.myCgidp_hablar;
	}

	/**
	* ESTABLECE PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	* @param inCgidp_escuchar PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	*/
	public void setCGIDP_ESCUCHAR(java.math.BigDecimal inCgidp_escuchar){
		this.myCgidp_escuchar = inCgidp_escuchar;
	}
	/**
	* OBTIENE PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	* @return java.math.BigDecimal PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	*/
	public java.math.BigDecimal getCGIDP_ESCUCHAR(){
		return this.myCgidp_escuchar;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgidp_estado ESTADO DEL REGISTRO
	*/
	public void setCGIDP_ESTADO(boolean inCgidp_estado){
		this.myCgidp_estado = inCgidp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGIDP_ESTADO(){
		return this.myCgidp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgidp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGIDP_USUARIO_INSERT(String inCgidp_usuario_insert){
		this.myCgidp_usuario_insert = inCgidp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGIDP_USUARIO_INSERT(){
		return this.myCgidp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgidp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGIDP_USUARIO_UPDATE(String inCgidp_usuario_update){
		this.myCgidp_usuario_update = inCgidp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGIDP_USUARIO_UPDATE(){
		return this.myCgidp_usuario_update;
	}

}
