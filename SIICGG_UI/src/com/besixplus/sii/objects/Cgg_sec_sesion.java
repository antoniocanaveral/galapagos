package com.besixplus.sii.objects;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
/**
* CLASE Cgg_sec_sesion
* TABLA: SESION
* DESCRIPCION:ALMACENA INFORMACION DE LAS CONEXIONES DEL USUARIO DEL SISTEMA
* ABREVIATURA:CSSSN
*/
public class Cgg_sec_sesion implements Serializable{
	private static final long serialVersionUID = 1353107025;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SESIONES DE CONEXION
	*/
	private String myCsssn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	private String myCusu_codigo;
	/**
	* FECHA DE INICIO DE LA SESION
	*/
	private java.util.Date myCsssn_fecha_inicio;
	/**
	* FECHA DE FINALIZACION DE LA SESION
	*/
	private java.util.Date myCsssn_fecha_fin;
	/**
	* IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES
	*/
	private String myCsssn_id;
	/**
	* DIRECCION IP REMOTA DEL USUARIO QUE SE CONECTA
	*/
	private String myCsssn_ip;
	/**
	* ZONA DE TIEMPO DEL USUARIO QUE SE CONECTA
	*/
	private String myCsssn_zona_tiempo;
	/**
	* SI LA SESION DEL USUARIO ESTA ACTIVA
	*/
	private boolean myCsssn_activo;
	/**
	 * HTTPSession del Usuario.
	 */
	private HttpSession myHttpSession;
	/**
	* NOMBRE DE USUARIO 
	*/
	private String myCusu_nombre_usuario;
	/**
	* CONTEXTO DE LA APLICACION QUE ACCEDIO EL USUARIO
	*/
	private String myCsssn_contexto;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_sesion
	*/
	public Cgg_sec_sesion(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_sesion
	* @param inCsssn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESIONES DE CONEXION
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param inCsssn_fecha_inicio FECHA DE INICIO DE LA SESION
	* @param inCsssn_fecha_fin FECHA DE FINALIZACION DE LA SESION
	* @param inCsssn_id IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES
	* @param inCsssn_ip DIRECCION IP REMOTA DEL USUARIO QUE SE CONECTA
	* @param inCsssn_zona_tiempo ZONA DE TIEMPO DEL USUARIO QUE SE CONECTA
	* @param inCsssn_activo SI LA SESION DEL USUARIO ESTA ACTIVA
	* @param inCsssn_contexto CONTEXTO DE LA APLICACION QUE ACCEDIO EL USUARIO
	*/
	public Cgg_sec_sesion(
		String inCsssn_codigo,
		String inCusu_codigo,
		java.util.Date inCsssn_fecha_inicio,
		java.util.Date inCsssn_fecha_fin,
		String inCsssn_id,
		String inCsssn_ip,
		String inCsssn_zona_tiempo,
		boolean inCsssn_activo,
		String inCsssn_contexto
	){
		this.setCSSSN_CODIGO(inCsssn_codigo);
		this.setCUSU_CODIGO(inCusu_codigo);
		this.setCSSSN_FECHA_INICIO(inCsssn_fecha_inicio);
		this.setCSSSN_FECHA_FIN(inCsssn_fecha_fin);
		this.setCSSSN_ID(inCsssn_id);
		this.setCSSSN_IP(inCsssn_ip);
		this.setCSSSN_ZONA_TIEMPO(inCsssn_zona_tiempo);
		this.setCSSSN_ACTIVO(inCsssn_activo);
		this.setCSSSN_CONTEXTO(inCsssn_contexto);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SESIONES DE CONEXION
	* @param incsssn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESIONES DE CONEXION
	*/
	public void setCSSSN_CODIGO(String inCsssn_codigo){
		this.myCsssn_codigo = inCsssn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SESIONES DE CONEXION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SESIONES DE CONEXION
	*/
	public String getCSSSN_CODIGO(){
		return this.myCsssn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	* @param incusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
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
	* ESTABLECE FECHA DE INICIO DE LA SESION
	* @param incsssn_fecha_inicio FECHA DE INICIO DE LA SESION
	*/
	public void setCSSSN_FECHA_INICIO(java.util.Date inCsssn_fecha_inicio){
		this.myCsssn_fecha_inicio = inCsssn_fecha_inicio;
	}
	/**
	* OBTIENE FECHA DE INICIO DE LA SESION
	* @return java.util.Date FECHA DE INICIO DE LA SESION
	*/
	public java.util.Date getCSSSN_FECHA_INICIO(){
		return this.myCsssn_fecha_inicio;
	}

	/**
	* ESTABLECE FECHA DE FINALIZACION DE LA SESION
	* @param incsssn_fecha_fin FECHA DE FINALIZACION DE LA SESION
	*/
	public void setCSSSN_FECHA_FIN(java.util.Date inCsssn_fecha_fin){
		this.myCsssn_fecha_fin = inCsssn_fecha_fin;
	}
	/**
	* OBTIENE FECHA DE FINALIZACION DE LA SESION
	* @return java.util.Date FECHA DE FINALIZACION DE LA SESION
	*/
	public java.util.Date getCSSSN_FECHA_FIN(){
		return this.myCsssn_fecha_fin;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES
	* @param incsssn_id IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES
	*/
	public void setCSSSN_ID(String inCsssn_id){
		this.myCsssn_id = inCsssn_id;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES
	* @return String IDENTIFICATIVO UNICO DE LA SESION DADO POR EL SERVIDOR DE APLICACIONES
	*/
	public String getCSSSN_ID(){
		return this.myCsssn_id;
	}

	/**
	* ESTABLECE DIRECCION IP REMOTA DEL USUARIO QUE SE CONECTA
	* @param incsssn_ip DIRECCION IP REMOTA DEL USUARIO QUE SE CONECTA
	*/
	public void setCSSSN_IP(String inCsssn_ip){
		this.myCsssn_ip = inCsssn_ip;
	}
	/**
	* OBTIENE DIRECCION IP REMOTA DEL USUARIO QUE SE CONECTA
	* @return String DIRECCION IP REMOTA DEL USUARIO QUE SE CONECTA
	*/
	public String getCSSSN_IP(){
		return this.myCsssn_ip;
	}

	/**
	* ESTABLECE ZONA DE TIEMPO DEL USUARIO QUE SE CONECTA
	* @param incsssn_zona_tiempo ZONA DE TIEMPO DEL USUARIO QUE SE CONECTA
	*/
	public void setCSSSN_ZONA_TIEMPO(String inCsssn_zona_tiempo){
		this.myCsssn_zona_tiempo = inCsssn_zona_tiempo;
	}
	/**
	* OBTIENE ZONA DE TIEMPO DEL USUARIO QUE SE CONECTA
	* @return String ZONA DE TIEMPO DEL USUARIO QUE SE CONECTA
	*/
	public String getCSSSN_ZONA_TIEMPO(){
		return this.myCsssn_zona_tiempo;
	}

	/**
	* ESTABLECE SI LA SESION DEL USUARIO ESTA ACTIVA
	* @param incsssn_activo SI LA SESION DEL USUARIO ESTA ACTIVA
	*/
	public void setCSSSN_ACTIVO(boolean inCsssn_activo){
		this.myCsssn_activo = inCsssn_activo;
	}
	/**
	* OBTIENE SI LA SESION DEL USUARIO ESTA ACTIVA
	* @return boolean SI LA SESION DEL USUARIO ESTA ACTIVA
	*/
	public boolean getCSSSN_ACTIVO(){
		return this.myCsssn_activo;
	}
	
	public HttpSession getHTTP_SESSION() {
		return myHttpSession;
	}
	public void setHTTP_SESSION(HttpSession inHttpSession) {
		this.myHttpSession = inHttpSession;
	}
	
	public void setCUSU_NOMBRE_USUARIO(String inCusuNombreUsuario) {
		myCusu_nombre_usuario = inCusuNombreUsuario;
	}
	public String getCUSU_NOMBRE_USUARIO() {
		return myCusu_nombre_usuario;
	}
	/**
	* ESTABLECE CONTEXTO DE LA APLICACION QUE ACCEDIO EL USUARIO
	* @param incsssn_contexto CONTEXTO DE LA APLICACION QUE ACCEDIO EL USUARIO
	*/
	public void setCSSSN_CONTEXTO(String inCsssn_contexto){
		this.myCsssn_contexto = inCsssn_contexto;
	}
	/**
	* OBTIENE CONTEXTO DE LA APLICACION QUE ACCEDIO EL USUARIO
	* @return String CONTEXTO DE LA APLICACION QUE ACCEDIO EL USUARIO
	*/
	public String getCSSSN_CONTEXTO(){
		return this.myCsssn_contexto;
	}
}
