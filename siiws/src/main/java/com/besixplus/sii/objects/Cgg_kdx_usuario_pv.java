package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_kdx_usuario_pv
* TABLA: USUARIO PUNTO DE VENTA
* DESCRIPCION:ALMACENA INFORMACION DE LOS USUARIOS ASIGNADOS A LOS PUNTOS DE VENTA
* ABREVIATURA:CKUPV
*/
public class Cgg_kdx_usuario_pv implements Serializable{
	private static final long serialVersionUID = 826777218;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	private String myCkupv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
	*/
	private String myCkpvt_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
	*/
	private boolean myCkpvt_activo;
	/**
	* ESTADO QUE DETERMINA SI EL USUARIO ES RESPONSABLE DEL PUNTO DE VENTA
	*/
	private boolean myCkupv_supervisor;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCkupv_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCkupv_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCkupv_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_usuario_pv
	*/
	public Cgg_kdx_usuario_pv(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_kdx_usuario_pv
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCkpvt_activo ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
	* @param inCkupv_supervisor ESTADO QUE DETERMINA SI EL USUARIO ES RESPONSABLE DEL PUNTO DE VENTA
	* @param inCkupv_estado ESTADO DEL REGISTRO
	* @param inCkupv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkupv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_kdx_usuario_pv(
		String inCkupv_codigo,
		String inCkpvt_codigo,
		String inCusu_codigo,
		boolean inCkpvt_activo,
		boolean inCkupv_supervisor,
		boolean inCkupv_estado,
		String inCkupv_usuario_insert,
		String inCkupv_usuario_update
	){
		this.setCKUPV_CODIGO(inCkupv_codigo);
		this.setCKPVT_CODIGO(inCkpvt_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCKPVT_ACTIVO(inCkpvt_activo);
		this.setCKUPV_SUPERVISOR(inCkupv_supervisor);
		this.setCKUPV_ESTADO(inCkupv_estado);
		this.setCKUPV_USUARIO_INSERT(inCkupv_usuario_insert);
		this.setCKUPV_USUARIO_UPDATE(inCkupv_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	public void setCKUPV_CODIGO(String inCkupv_codigo){
		this.myCkupv_codigo = inCkupv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	*/
	public String getCKUPV_CODIGO(){
		return this.myCkupv_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
	* @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
	*/
	public void setCKPVT_CODIGO(String inCkpvt_codigo){
		this.myCkpvt_codigo = inCkpvt_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA 
	*/
	public String getCKPVT_CODIGO(){
		return this.myCkpvt_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
	* @param inCkpvt_activo ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
	*/
	public void setCKPVT_ACTIVO(boolean inCkpvt_activo){
		this.myCkpvt_activo = inCkpvt_activo;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
	* @return boolean ESTADO QUE DETERMINA SI EL USUARIO SE HALLA ACTIVO EN EL PUNTO DE VENTA
	*/
	public boolean getCKPVT_ACTIVO(){
		return this.myCkpvt_activo;
	}

	/**
	* ESTABLECE ESTADO QUE DETERMINA SI EL USUARIO ES RESPONSABLE DEL PUNTO DE VENTA
	* @param inCkupv_supervisor ESTADO QUE DETERMINA SI EL USUARIO ES RESPONSABLE DEL PUNTO DE VENTA
	*/
	public void setCKUPV_SUPERVISOR(boolean inCkupv_supervisor){
		this.myCkupv_supervisor = inCkupv_supervisor;
	}
	/**
	* OBTIENE ESTADO QUE DETERMINA SI EL USUARIO ES RESPONSABLE DEL PUNTO DE VENTA
	* @return boolean ESTADO QUE DETERMINA SI EL USUARIO ES RESPONSABLE DEL PUNTO DE VENTA
	*/
	public boolean getCKUPV_SUPERVISOR(){
		return this.myCkupv_supervisor;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCkupv_estado ESTADO DEL REGISTRO
	*/
	public void setCKUPV_ESTADO(boolean inCkupv_estado){
		this.myCkupv_estado = inCkupv_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCKUPV_ESTADO(){
		return this.myCkupv_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCkupv_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCKUPV_USUARIO_INSERT(String inCkupv_usuario_insert){
		this.myCkupv_usuario_insert = inCkupv_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCKUPV_USUARIO_INSERT(){
		return this.myCkupv_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCkupv_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCKUPV_USUARIO_UPDATE(String inCkupv_usuario_update){
		this.myCkupv_usuario_update = inCkupv_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCKUPV_USUARIO_UPDATE(){
		return this.myCkupv_usuario_update;
	}

}
