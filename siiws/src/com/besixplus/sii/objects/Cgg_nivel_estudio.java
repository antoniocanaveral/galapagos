package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_nivel_estudio
* TABLA: NIVEL DE ESTUDIO
* DESCRIPCION:ALMACENA INFORMACION DE LOS NIVELES DE ESTUDIO QUE PUEDE TENER UNA PERSONA
* ABREVIATURA:CGNES
*/
public class Cgg_nivel_estudio implements Serializable{
	private static final long serialVersionUID = 657975674;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCgnes_codigo;
	/**
	* DESCRIPCION DEL NIVEL DE ESTUDIO
	*/
	private String myCgnes_descripcion;
	/**
	* JERARQUIA DEL NIVEL DE ESTUDIO
	*/
	private int myCgnes_grado;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCgnes_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCgnes_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCgnes_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_nivel_estudio
	*/
	public Cgg_nivel_estudio(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_nivel_estudio
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgnes_descripcion DESCRIPCION DEL NIVEL DE ESTUDIO
	* @param inCgnes_grado JERARQUIA DEL NIVEL DE ESTUDIO
	* @param inCgnes_estado ESTADO DEL REGISTRO
	* @param inCgnes_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgnes_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_nivel_estudio(
		String inCgnes_codigo,
		String inCgnes_descripcion,
		int inCgnes_grado,
		boolean inCgnes_estado,
		String inCgnes_usuario_insert,
		String inCgnes_usuario_update
	){
		this.setCGNES_CODIGO(inCgnes_codigo);
		this.setCGNES_DESCRIPCION(inCgnes_descripcion);
		this.setCGNES_GRADO(inCgnes_grado);
		this.setCGNES_ESTADO(inCgnes_estado);
		this.setCGNES_USUARIO_INSERT(inCgnes_usuario_insert);
		this.setCGNES_USUARIO_UPDATE(inCgnes_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCgnes_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCGNES_CODIGO(String inCgnes_codigo){
		this.myCgnes_codigo = inCgnes_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCGNES_CODIGO(){
		return this.myCgnes_codigo;
	}

	/**
	* ESTABLECE DESCRIPCION DEL NIVEL DE ESTUDIO
	* @param inCgnes_descripcion DESCRIPCION DEL NIVEL DE ESTUDIO
	*/
	public void setCGNES_DESCRIPCION(String inCgnes_descripcion){
		this.myCgnes_descripcion = inCgnes_descripcion;
	}
	/**
	* OBTIENE DESCRIPCION DEL NIVEL DE ESTUDIO
	* @return String DESCRIPCION DEL NIVEL DE ESTUDIO
	*/
	public String getCGNES_DESCRIPCION(){
		return this.myCgnes_descripcion;
	}

	/**
	* ESTABLECE JERARQUIA DEL NIVEL DE ESTUDIO
	* @param inCgnes_grado JERARQUIA DEL NIVEL DE ESTUDIO
	*/
	public void setCGNES_GRADO(int inCgnes_grado){
		this.myCgnes_grado = inCgnes_grado;
	}
	/**
	* OBTIENE JERARQUIA DEL NIVEL DE ESTUDIO
	* @return int JERARQUIA DEL NIVEL DE ESTUDIO
	*/
	public int getCGNES_GRADO(){
		return this.myCgnes_grado;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCgnes_estado ESTADO DEL REGISTRO
	*/
	public void setCGNES_ESTADO(boolean inCgnes_estado){
		this.myCgnes_estado = inCgnes_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCGNES_ESTADO(){
		return this.myCgnes_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCgnes_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCGNES_USUARIO_INSERT(String inCgnes_usuario_insert){
		this.myCgnes_usuario_insert = inCgnes_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCGNES_USUARIO_INSERT(){
		return this.myCgnes_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCgnes_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCGNES_USUARIO_UPDATE(String inCgnes_usuario_update){
		this.myCgnes_usuario_update = inCgnes_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCGNES_USUARIO_UPDATE(){
		return this.myCgnes_usuario_update;
	}

}
