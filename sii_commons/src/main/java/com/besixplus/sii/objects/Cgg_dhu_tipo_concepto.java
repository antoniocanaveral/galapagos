package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_tipo_concepto
* TABLA: TIPO CONCEPTO DE DESEMBOLSO
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE DESEMBOLSOS ECONOMICOS QUE SE LE PUEDEN REALIZAR A LOS BECARIOS
* ABREVIATURA:CDTCP
*/
public class Cgg_dhu_tipo_concepto implements Serializable{
	private static final long serialVersionUID = 1613255846;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	*/
	private String myCdtcp_codigo;
	/**
	* NOMBRE DEL CONCEPTO DE DESEMBOLSO
	*/
	private String myCdtcp_nombre_desembolso;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdtcp_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdtcp_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdtcp_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_concepto
	*/
	public Cgg_dhu_tipo_concepto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_concepto
	* @param inCdtcp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	* @param inCdtcp_nombre_desembolso NOMBRE DEL CONCEPTO DE DESEMBOLSO
	* @param inCdtcp_estado ESTADO DEL REGISTRO
	* @param inCdtcp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtcp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_tipo_concepto(
		String inCdtcp_codigo,
		String inCdtcp_nombre_desembolso,
		boolean inCdtcp_estado,
		String inCdtcp_usuario_insert,
		String inCdtcp_usuario_update
	){
		this.setCDTCP_CODIGO(inCdtcp_codigo);
		this.setCDTCP_NOMBRE_DESEMBOLSO(inCdtcp_nombre_desembolso);
		this.setCDTCP_ESTADO(inCdtcp_estado);
		this.setCDTCP_USUARIO_INSERT(inCdtcp_usuario_insert);
		this.setCDTCP_USUARIO_UPDATE(inCdtcp_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	* @param inCdtcp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	*/
	public void setCDTCP_CODIGO(String inCdtcp_codigo){
		this.myCdtcp_codigo = inCdtcp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
	*/
	public String getCDTCP_CODIGO(){
		return this.myCdtcp_codigo;
	}

	/**
	* ESTABLECE NOMBRE DEL CONCEPTO DE DESEMBOLSO
	* @param inCdtcp_nombre_desembolso NOMBRE DEL CONCEPTO DE DESEMBOLSO
	*/
	public void setCDTCP_NOMBRE_DESEMBOLSO(String inCdtcp_nombre_desembolso){
		this.myCdtcp_nombre_desembolso = inCdtcp_nombre_desembolso;
	}
	/**
	* OBTIENE NOMBRE DEL CONCEPTO DE DESEMBOLSO
	* @return String NOMBRE DEL CONCEPTO DE DESEMBOLSO
	*/
	public String getCDTCP_NOMBRE_DESEMBOLSO(){
		return this.myCdtcp_nombre_desembolso;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdtcp_estado ESTADO DEL REGISTRO
	*/
	public void setCDTCP_ESTADO(boolean inCdtcp_estado){
		this.myCdtcp_estado = inCdtcp_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDTCP_ESTADO(){
		return this.myCdtcp_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtcp_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDTCP_USUARIO_INSERT(String inCdtcp_usuario_insert){
		this.myCdtcp_usuario_insert = inCdtcp_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDTCP_USUARIO_INSERT(){
		return this.myCdtcp_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdtcp_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDTCP_USUARIO_UPDATE(String inCdtcp_usuario_update){
		this.myCdtcp_usuario_update = inCdtcp_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDTCP_USUARIO_UPDATE(){
		return this.myCdtcp_usuario_update;
	}

}
