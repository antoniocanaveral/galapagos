package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_enumerador
* TABLA: ENUMERADORES
* DEF:TABLA QUE ALMACENA TODOS LOS VALORES ESTATICOS DEL SISTEMA Y SUS DESCRIPCIONES A MODO DE ENUMERADORES.
* ABR: CENUM
*/
public class Cgg_enumerador implements Serializable{
	private static final long serialVersionUID = 2023225560;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	private String myCenum_codigo;
	/**
	* NO ESPECIFICADO
	*/
	private String myCenum_tabla;
	/**
	* NO ESPECIFICADO
	*/
	private String myCenum_columna;
	/**
	* NO ESPECIFICADO
	*/
	private int myCenum_valor;
	/**
	* NO ESPECIFICADO
	*/
	private String myCenum_descripcion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCenum__estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCenum__usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCenum__usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_enumerador
	*/
	public Cgg_enumerador(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_enumerador
	* @param inCenum_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCenum_tabla NO ESPECIFICADO
	* @param inCenum_columna NO ESPECIFICADO
	* @param inCenum_valor NO ESPECIFICADO
	* @param inCenum_descripcion NO ESPECIFICADO
	* @param inCenum__estado ESTADO DEL REGISTRO
	* @param inCenum__usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCenum__usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_enumerador(
		String inCenum_codigo,
		String inCenum_tabla,
		String inCenum_columna,
		int inCenum_valor,
		String inCenum_descripcion,
		boolean inCenum__estado,
		String inCenum__usuario_insert,
		String inCenum__usuario_update
	){
		this.setCENUM_CODIGO(inCenum_codigo);
		this.setCENUM_TABLA(inCenum_tabla);
		this.setCENUM_COLUMNA(inCenum_columna);
		this.setCENUM_VALOR(inCenum_valor);
		this.setCENUM_DESCRIPCION(inCenum_descripcion);
		this.setCENUM__ESTADO(inCenum__estado);
		this.setCENUM__USUARIO_INSERT(inCenum__usuario_insert);
		this.setCENUM__USUARIO_UPDATE(inCenum__usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCenum_codigo IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public void setCENUM_CODIGO(String inCenum_codigo){
		this.myCenum_codigo = inCenum_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO
	*/
	public String getCENUM_CODIGO(){
		return this.myCenum_codigo;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCenum_tabla NO ESPECIFICADO
	*/
	public void setCENUM_TABLA(String inCenum_tabla){
		this.myCenum_tabla = inCenum_tabla;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCENUM_TABLA(){
		return this.myCenum_tabla;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCenum_columna NO ESPECIFICADO
	*/
	public void setCENUM_COLUMNA(String inCenum_columna){
		this.myCenum_columna = inCenum_columna;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCENUM_COLUMNA(){
		return this.myCenum_columna;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCenum_valor NO ESPECIFICADO
	*/
	public void setCENUM_VALOR(int inCenum_valor){
		this.myCenum_valor = inCenum_valor;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return int NO ESPECIFICADO
	*/
	public int getCENUM_VALOR(){
		return this.myCenum_valor;
	}

	/**
	* ESTABLECE NO ESPECIFICADO
	* @param inCenum_descripcion NO ESPECIFICADO
	*/
	public void setCENUM_DESCRIPCION(String inCenum_descripcion){
		this.myCenum_descripcion = inCenum_descripcion;
	}
	/**
	* OBTIENE NO ESPECIFICADO
	* @return String NO ESPECIFICADO
	*/
	public String getCENUM_DESCRIPCION(){
		return this.myCenum_descripcion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCenum__estado ESTADO DEL REGISTRO
	*/
	public void setCENUM__ESTADO(boolean inCenum__estado){
		this.myCenum__estado = inCenum__estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCENUM__ESTADO(){
		return this.myCenum__estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCenum__usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCENUM__USUARIO_INSERT(String inCenum__usuario_insert){
		this.myCenum__usuario_insert = inCenum__usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCENUM__USUARIO_INSERT(){
		return this.myCenum__usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCenum__usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCENUM__USUARIO_UPDATE(String inCenum__usuario_update){
		this.myCenum__usuario_update = inCenum__usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCENUM__USUARIO_UPDATE(){
		return this.myCenum__usuario_update;
	}

}
