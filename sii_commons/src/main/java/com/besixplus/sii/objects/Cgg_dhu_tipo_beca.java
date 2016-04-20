package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_tipo_beca
* TABLA: TIPO BECA
* DESCRIPCION:ALMACENA INFORMACION DE LOS TIPOS DE BECAS QUE PUEDEN ACCEDER LOS RESIDENTES
* ABREVIATURA:CDTBC
*/
public class Cgg_dhu_tipo_beca implements Serializable{
	private static final long serialVersionUID = 1048917112;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	*/
	private String myCdtbc_codigo;
	/**
	* NOMBRE DE LA BECA
	*/
	private String myCdtbc_nombre;
	/**
	* ABREVIATURA DE LA BECA
	*/
	private String myCdtbc_abreviatura;
	/**
	* ESTADO DE LA BECA
0 - ELIMINADO
1 - ACTIVO
2 - NO VIGENTE

	*/
	private int myCdtbc_estado_beca;
	/**
	* ESTADO DEL REGISTRO 

	*/
	private boolean myCdtbc_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdtbc_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdtbc_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_beca
	*/
	public Cgg_dhu_tipo_beca(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_tipo_beca
	* @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	* @param inCdtbc_nombre NOMBRE DE LA BECA
	* @param inCdtbc_abreviatura ABREVIATURA DE LA BECA
	* @param inCdtbc_estado_beca ESTADO DE LA BECA
0 - ELIMINADO
1 - ACTIVO
2 - NO VIGENTE

	* @param inCdtbc_estado ESTADO DEL REGISTRO 

	* @param inCdtbc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtbc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_tipo_beca(
		String inCdtbc_codigo,
		String inCdtbc_nombre,
		String inCdtbc_abreviatura,
		int inCdtbc_estado_beca,
		boolean inCdtbc_estado,
		String inCdtbc_usuario_insert,
		String inCdtbc_usuario_update
	){
		this.setCDTBC_CODIGO(inCdtbc_codigo);
		this.setCDTBC_NOMBRE(inCdtbc_nombre);
		this.setCDTBC_ABREVIATURA(inCdtbc_abreviatura);
		this.setCDTBC_ESTADO_BECA(inCdtbc_estado_beca);
		this.setCDTBC_ESTADO(inCdtbc_estado);
		this.setCDTBC_USUARIO_INSERT(inCdtbc_usuario_insert);
		this.setCDTBC_USUARIO_UPDATE(inCdtbc_usuario_update);
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
	* ESTABLECE NOMBRE DE LA BECA
	* @param inCdtbc_nombre NOMBRE DE LA BECA
	*/
	public void setCDTBC_NOMBRE(String inCdtbc_nombre){
		this.myCdtbc_nombre = inCdtbc_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA BECA
	* @return String NOMBRE DE LA BECA
	*/
	public String getCDTBC_NOMBRE(){
		return this.myCdtbc_nombre;
	}

	/**
	* ESTABLECE ABREVIATURA DE LA BECA
	* @param inCdtbc_abreviatura ABREVIATURA DE LA BECA
	*/
	public void setCDTBC_ABREVIATURA(String inCdtbc_abreviatura){
		this.myCdtbc_abreviatura = inCdtbc_abreviatura;
	}
	/**
	* OBTIENE ABREVIATURA DE LA BECA
	* @return String ABREVIATURA DE LA BECA
	*/
	public String getCDTBC_ABREVIATURA(){
		return this.myCdtbc_abreviatura;
	}

	/**
	* ESTABLECE ESTADO DE LA BECA
0 - ELIMINADO
1 - ACTIVO
2 - NO VIGENTE

	* @param inCdtbc_estado_beca ESTADO DE LA BECA
0 - ELIMINADO
1 - ACTIVO
2 - NO VIGENTE

	*/
	public void setCDTBC_ESTADO_BECA(int inCdtbc_estado_beca){
		this.myCdtbc_estado_beca = inCdtbc_estado_beca;
	}
	/**
	* OBTIENE ESTADO DE LA BECA
0 - ELIMINADO
1 - ACTIVO
2 - NO VIGENTE

	* @return int ESTADO DE LA BECA
0 - ELIMINADO
1 - ACTIVO
2 - NO VIGENTE

	*/
	public int getCDTBC_ESTADO_BECA(){
		return this.myCdtbc_estado_beca;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO 

	* @param inCdtbc_estado ESTADO DEL REGISTRO 

	*/
	public void setCDTBC_ESTADO(boolean inCdtbc_estado){
		this.myCdtbc_estado = inCdtbc_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO 

	* @return boolean ESTADO DEL REGISTRO 

	*/
	public boolean getCDTBC_ESTADO(){
		return this.myCdtbc_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdtbc_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDTBC_USUARIO_INSERT(String inCdtbc_usuario_insert){
		this.myCdtbc_usuario_insert = inCdtbc_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDTBC_USUARIO_INSERT(){
		return this.myCdtbc_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdtbc_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDTBC_USUARIO_UPDATE(String inCdtbc_usuario_update){
		this.myCdtbc_usuario_update = inCdtbc_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDTBC_USUARIO_UPDATE(){
		return this.myCdtbc_usuario_update;
	}

}
