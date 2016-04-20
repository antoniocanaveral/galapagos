package com.besixplus.sii.objects;

/**
* CLASE Cgg_res_oficial_seguimiento_usuario
* TABLA: OFICIAL SEGUIMIENTO y USUARIOS
* DESCRIPCION:SELECCIONAR INFORMACION DE LOS OFICIALES DE SEGUIMIENTO ASIGNADOS PARA CONTROLAR LOS ESTADOS DE RESIDENCIA DE LA TABLA USUARIOS
* ABREVIATURA:CROSG
*/
public class Cgg_res_oficial_seguimiento_usuario {
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrosg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCrofm_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCusu_codigo;
	/**
	* NOMBRES DEL USUARIO 
	*/
	private String myCusu_nombres;
	/**
	* APELLIDOS DEL USUARIO
	*/
	private String myCusu_apellidos;
	
	/**
	 * CONSTRUCTOR DE LA CLASE Cgg_res_oficial_seguimiento
	 */
	public Cgg_res_oficial_seguimiento_usuario(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_oficial_seguimiento
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrofm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_nombres NOMBRES DEL USUARIO 
	* @param inCusu_apellidos APELLIDOS DEL USUARIO	
	*/
	public Cgg_res_oficial_seguimiento_usuario(
			String inCrosg_codigo,
			String inCrofm_codigo,
			String inCusu_codigo,
			String inCusu_nombres,
			String inCusu_apellidos
		){
			this.setCROSG_CODIGO(inCrosg_codigo);
			this.setCROFM_CODIGO(inCrofm_codigo);
			this.setCROSG_CODIGO(inCrofm_codigo);
			this.setCUSU_CODIGO(inCusu_codigo);
			this.setCUSU_NOMBRES(inCusu_nombres);
			this.setCUSU_APELLIDOS(inCusu_apellidos);			
		}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrofm_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCROFM_CODIGO(String inCrofm_codigo){
		this.myCrofm_codigo = inCrofm_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCROFM_CODIGO(){
		return this.myCrofm_codigo;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCROSG_CODIGO(String inCrosg_codigo){
		this.myCrosg_codigo = inCrosg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCROSG_CODIGO(){
		return this.myCrosg_codigo;
	}
	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCUSU_CODIGO(String inCusu_codigo){
		this.myCusu_codigo = inCusu_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCUSU_CODIGO(){
		return this.myCusu_codigo;
	}
	/**
	* ESTABLECE NOMBRES DEL USUARIO 
	* @param inCusu_nombres NOMBRES DEL USUARIO 
	*/
	public void setCUSU_NOMBRES(String inCusu_nombres){
		this.myCusu_nombres = inCusu_nombres;
	}
	/**
	* OBTIENE NOMBRES DEL USUARIO 
	* @return String NOMBRES DEL USUARIO 
	*/
	public String getCUSU_NOMBRES(){
		return this.myCusu_nombres;
	}

	/**
	* ESTABLECE APELLIDOS DEL USUARIO
	* @param inCusu_apellidos APELLIDOS DEL USUARIO
	*/
	public void setCUSU_APELLIDOS(String inCusu_apellidos){
		this.myCusu_apellidos = inCusu_apellidos;
	}
	/**
	* OBTIENE APELLIDOS DEL USUARIO
	* @return String APELLIDOS DEL USUARIO
	*/
	public String getCUSU_APELLIDOS(){
		return this.myCusu_apellidos;
	}
	
}
