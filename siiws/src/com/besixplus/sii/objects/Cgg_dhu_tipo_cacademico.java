package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_tipo_cacademico
* TABLA: TIPO DE CERTIFICADOS ACADEMICOS
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE CERTIFICADOS ACADEMICOS.
* ABREVIATURA:CDTCA
*/
public class Cgg_dhu_tipo_cacademico implements Serializable{
	private static final long serialVersionUID = 696643483;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	*/
	private String myCdtca_codigo;
	/**
	* NOMBRE DEL CERTIFICADO
	*/
	private String myCdtca_nombre;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCdtca_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdtca_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdtca_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdtca_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_cacademico
	*/
	public Cgg_dhu_tipo_cacademico(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_cacademico
	* @param inCdtca_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	* @param inCdtca_nombre NOMBRE DEL CERTIFICADO
	* @param inCdtca_observacion INFORMACION ADICIONAL
	* @param inCdtca_estado ESTADO DEL REGISTRO
	* @param inCdtca_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtca_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_tipo_cacademico(
		String inCdtca_codigo,
		String inCdtca_nombre,
		String inCdtca_observacion,
		boolean inCdtca_estado,
		String inCdtca_usuario_insert,
		String inCdtca_usuario_update
	){
		this.setCDTCA_CODIGO(inCdtca_codigo);
		this.setCDTCA_NOMBRE(inCdtca_nombre);
		this.setCDTCA_OBSERVACION(inCdtca_observacion);
		this.setCDTCA_ESTADO(inCdtca_estado);
		this.setCDTCA_USUARIO_INSERT(inCdtca_usuario_insert);
		this.setCDTCA_USUARIO_UPDATE(inCdtca_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	* @param inCdtca_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	*/
	public void setCDTCA_CODIGO(String inCdtca_codigo){
		this.myCdtca_codigo = inCdtca_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	*/
	public String getCDTCA_CODIGO(){
		return this.myCdtca_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL CERTIFICADO
	* @param inCdtca_nombre NOMBRE DEL CERTIFICADO
	*/
	public void setCDTCA_NOMBRE(String inCdtca_nombre){
		this.myCdtca_nombre = inCdtca_nombre;
	}
	/**
	* OBTIENE NOMBRE DEL CERTIFICADO
	* @return String NOMBRE DEL CERTIFICADO
	*/
	public String getCDTCA_NOMBRE(){
		return this.myCdtca_nombre;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCdtca_observacion INFORMACION ADICIONAL
	*/
	public void setCDTCA_OBSERVACION(String inCdtca_observacion){
		this.myCdtca_observacion = inCdtca_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCDTCA_OBSERVACION(){
		return this.myCdtca_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdtca_estado ESTADO DEL REGISTRO
	*/
	public void setCDTCA_ESTADO(boolean inCdtca_estado){
		this.myCdtca_estado = inCdtca_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDTCA_ESTADO(){
		return this.myCdtca_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtca_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDTCA_USUARIO_INSERT(String inCdtca_usuario_insert){
		this.myCdtca_usuario_insert = inCdtca_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDTCA_USUARIO_INSERT(){
		return this.myCdtca_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdtca_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDTCA_USUARIO_UPDATE(String inCdtca_usuario_update){
		this.myCdtca_usuario_update = inCdtca_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDTCA_USUARIO_UPDATE(){
		return this.myCdtca_usuario_update;
	}

}
