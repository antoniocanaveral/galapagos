package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_res_adjunto_temporal
* TABLA: TABLA DE ADJUNTO TEMPORALES
* DESCRIPCION:ALMACENA INFORMACION DE ADJUNTOS TEMPORALES PARA LA APLICACION.
* ABREVIATURA:CRATE
*/
public class Cgg_res_adjunto_temporal implements Serializable{
	private static final long serialVersionUID = 1998547335;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
	*/
	private String myCrate_codigo;
	/**
	* NOMBRE DE ADJUNTO TEMPORAL
	*/
	private String myCrate_nombre;
	/**
	* CADENA DE TEXTO DEL TIPO DE CONTENIDO MIME DEL ADJUNTO TEMPORAL
	*/
	private String myCrate_tipo_contenido;
	/**
	* CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
	*/
	private byte[] myCrate_archivo;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrate_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrate_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrate_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto_temporal
	*/
	public Cgg_res_adjunto_temporal(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_adjunto_temporal
	* @param inCrate_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
	* @param inCrate_nombre NOMBRE DE ADJUNTO TEMPORAL
	* @param inCrate_tipo_contenido CADENA DE TEXTO DEL TIPO DE CONTENIDO MIME DEL ADJUNTO TEMPORAL
	* @param inCrate_archivo CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
	* @param inCrate_estado ESTADO DEL REGISTRO
	* @param inCrate_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrate_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_adjunto_temporal(
		String inCrate_codigo,
		String inCrate_nombre,
		String inCrate_tipo_contenido,
		byte[] inCrate_archivo,
		boolean inCrate_estado,
		String inCrate_usuario_insert,
		String inCrate_usuario_update
	){
		this.setCRATE_CODIGO(inCrate_codigo);
		this.setCRATE_NOMBRE(inCrate_nombre);
		this.setCRATE_TIPO_CONTENIDO(inCrate_tipo_contenido);
		this.setCRATE_ARCHIVO(inCrate_archivo);
		this.setCRATE_ESTADO(inCrate_estado);
		this.setCRATE_USUARIO_INSERT(inCrate_usuario_insert);
		this.setCRATE_USUARIO_UPDATE(inCrate_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
	* @param inCrate_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
	*/
	public void setCRATE_CODIGO(String inCrate_codigo){
		this.myCrate_codigo = inCrate_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
	*/
	public String getCRATE_CODIGO(){
		return this.myCrate_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE ADJUNTO TEMPORAL
	* @param inCrate_nombre NOMBRE DE ADJUNTO TEMPORAL
	*/
	public void setCRATE_NOMBRE(String inCrate_nombre){
		this.myCrate_nombre = inCrate_nombre;
	}
	/**
	* OBTIENE NOMBRE DE ADJUNTO TEMPORAL
	* @return String NOMBRE DE ADJUNTO TEMPORAL
	*/
	public String getCRATE_NOMBRE(){
		return this.myCrate_nombre;
	}

	/**
	* ESTABLECE CADENA DE TEXTO DEL TIPO DE CONTENIDO MIME DEL ADJUNTO TEMPORAL
	* @param inCrate_tipo_contenido CADENA DE TEXTO DEL TIPO DE CONTENIDO MIME DEL ADJUNTO TEMPORAL
	*/
	public void setCRATE_TIPO_CONTENIDO(String inCrate_tipo_contenido){
		this.myCrate_tipo_contenido = inCrate_tipo_contenido;
	}
	/**
	* OBTIENE CADENA DE TEXTO DEL TIPO DE CONTENIDO MIME DEL ADJUNTO TEMPORAL
	* @return String CADENA DE TEXTO DEL TIPO DE CONTENIDO MIME DEL ADJUNTO TEMPORAL
	*/
	public String getCRATE_TIPO_CONTENIDO(){
		return this.myCrate_tipo_contenido;
	}

	/**
	* ESTABLECE CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
	* @param inCrate_archivo CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
	*/
	public void setCRATE_ARCHIVO(byte[] inCrate_archivo){
		this.myCrate_archivo = inCrate_archivo;
	}
	/**
	* OBTIENE CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
	* @return byte[] CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
	*/
	public byte[] getCRATE_ARCHIVO(){
		return this.myCrate_archivo;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrate_estado ESTADO DEL REGISTRO
	*/
	public void setCRATE_ESTADO(boolean inCrate_estado){
		this.myCrate_estado = inCrate_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRATE_ESTADO(){
		return this.myCrate_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrate_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRATE_USUARIO_INSERT(String inCrate_usuario_insert){
		this.myCrate_usuario_insert = inCrate_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRATE_USUARIO_INSERT(){
		return this.myCrate_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrate_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRATE_USUARIO_UPDATE(String inCrate_usuario_update){
		this.myCrate_usuario_update = inCrate_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRATE_USUARIO_UPDATE(){
		return this.myCrate_usuario_update;
	}

}
