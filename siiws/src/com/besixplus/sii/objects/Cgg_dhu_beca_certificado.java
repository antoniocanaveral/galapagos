package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_beca_certificado
* TABLA: BECA CERTIFICADO
* DESCRIPCION:ALMACENA INFORMACION DE LOS CERTIFICADOS REQUERIDOS PARA LA BECAS
* ABREVIATURA:CDBCR
*/
public class Cgg_dhu_beca_certificado implements Serializable{
	private static final long serialVersionUID = 736914838;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	*/
	private String myCdbcr_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	*/
	private String myCdtca_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	private String myCdtbc_codigo;
	/**
	* OBLIGATORIEDAD DEL CERTIFICADO.
	*/
	private boolean myCdbcr_obligatorio;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdbcr_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdbcr_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdbcr_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca_certificado
	*/
	public Cgg_dhu_beca_certificado(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_beca_certificado
	* @param inCdbcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	* @param inCdtca_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
	* @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @param inCdbcr_obligatorio OBLIGATORIEDAD DEL CERTIFICADO.
	* @param inCdbcr_estado ESTADO DEL REGISTRO
	* @param inCdbcr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdbcr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_beca_certificado(
		String inCdbcr_codigo,
		String inCdtca_codigo,
		String inCdtbc_codigo,
		boolean inCdbcr_obligatorio,
		boolean inCdbcr_estado,
		String inCdbcr_usuario_insert,
		String inCdbcr_usuario_update
	){
		this.setCDBCR_CODIGO(inCdbcr_codigo);
		this.setCDTCA_CODIGO(inCdtca_codigo);
		this.setCDTBC_CODIGO(inCdtbc_codigo);
		this.setCDBCR_OBLIGATORIO(inCdbcr_obligatorio);
		this.setCDBCR_ESTADO(inCdbcr_estado);
		this.setCDBCR_USUARIO_INSERT(inCdbcr_usuario_insert);
		this.setCDBCR_USUARIO_UPDATE(inCdbcr_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	* @param inCdbcr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	*/
	public void setCDBCR_CODIGO(String inCdbcr_codigo){
		this.myCdbcr_codigo = inCdbcr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
	*/
	public String getCDBCR_CODIGO(){
		return this.myCdbcr_codigo;
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
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	public void setCDTBC_CODIGO(String inCdtbc_codigo){
		this.myCdtbc_codigo = inCdtbc_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	public String getCDTBC_CODIGO(){
		return this.myCdtbc_codigo;
	}

	/**
	* ESTABLECE OBLIGATORIEDAD DEL CERTIFICADO.
	* @param inCdbcr_obligatorio OBLIGATORIEDAD DEL CERTIFICADO.
	*/
	public void setCDBCR_OBLIGATORIO(boolean inCdbcr_obligatorio){
		this.myCdbcr_obligatorio = inCdbcr_obligatorio;
	}
	/**
	* OBTIENE OBLIGATORIEDAD DEL CERTIFICADO.
	* @return boolean OBLIGATORIEDAD DEL CERTIFICADO.
	*/
	public boolean getCDBCR_OBLIGATORIO(){
		return this.myCdbcr_obligatorio;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdbcr_estado ESTADO DEL REGISTRO
	*/
	public void setCDBCR_ESTADO(boolean inCdbcr_estado){
		this.myCdbcr_estado = inCdbcr_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDBCR_ESTADO(){
		return this.myCdbcr_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdbcr_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDBCR_USUARIO_INSERT(String inCdbcr_usuario_insert){
		this.myCdbcr_usuario_insert = inCdbcr_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDBCR_USUARIO_INSERT(){
		return this.myCdbcr_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdbcr_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDBCR_USUARIO_UPDATE(String inCdbcr_usuario_update){
		this.myCdbcr_usuario_update = inCdbcr_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDBCR_USUARIO_UPDATE(){
		return this.myCdbcr_usuario_update;
	}

}
