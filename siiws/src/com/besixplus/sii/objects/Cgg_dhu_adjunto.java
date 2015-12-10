package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_dhu_adjunto
* TABLA QUE ALMACENA INFORMACION DE DOCUMENTOS DIGITALIZADOS DE CONTRATOS DE BECA E INFORMES
* ABREVIATURA: CDAD
*/
public class Cgg_dhu_adjunto implements Serializable{
	private static final long serialVersionUID = 862698635;
	/**
	* CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	*/
	private String myCdad_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	private String myCdbec_codigo;
	/**
	* CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	private String myCdad_descripcion;
	/**
	* CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
	*/
	private String myCdad_observacion;
	/**
	* NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	private String myCdad_nombre_adjunto;
	/**
	* CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	private byte[] myCdad_adjunto;
	/**
	* TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
0 - CONTRATO DE BECA
1 - INFORME
2 - MEMORANDUM DE APROBACIONES
3 - OTROS
	*/
	private int myCdad_tipo;
	/**
	* CAMPO DE TEXTO DESCRIPCION CONTENIDO
	*/
	private String myCdad_descripcion_contenido;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCdad_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCdad_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCdad_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_adjunto
	*/
	public Cgg_dhu_adjunto(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_dhu_adjunto
	* @param inCdad_codigo CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdad_descripcion CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	* @param inCdad_observacion CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
	* @param inCdad_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCdad_adjunto CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	* @param inCdad_tipo TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
0 - CONTRATO DE BECA
1 - INFORME
2 - MEMORANDUM DE APROBACIONES
3 - OTROS
	* @param inCdad_descripcion_contenido CAMPO DE TEXTO DESCRIPCION CONTENIDO
	* @param inCdad_estado ESTADO DEL REGISTRO
	* @param inCdad_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdad_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_dhu_adjunto(
		String inCdad_codigo,
		String inCdbec_codigo,
		String inCdad_descripcion,
		String inCdad_observacion,
		String inCdad_nombre_adjunto,
		byte[] inCdad_adjunto,
		int inCdad_tipo,
		String inCdad_descripcion_contenido,
		boolean inCdad_estado,
		String inCdad_usuario_insert,
		String inCdad_usuario_update
	){
		this.setCDAD_CODIGO(inCdad_codigo);
		this.setCDBEC_CODIGO(inCdbec_codigo);
		this.setCDAD_DESCRIPCION(inCdad_descripcion);
		this.setCDAD_OBSERVACION(inCdad_observacion);
		this.setCDAD_NOMBRE_ADJUNTO(inCdad_nombre_adjunto);
		this.setCDAD_ADJUNTO(inCdad_adjunto);
		this.setCDAD_TIPO(inCdad_tipo);
		this.setCDAD_DESCRIPCION_CONTENIDO(inCdad_descripcion_contenido);
		this.setCDAD_ESTADO(inCdad_estado);
		this.setCDAD_USUARIO_INSERT(inCdad_usuario_insert);
		this.setCDAD_USUARIO_UPDATE(inCdad_usuario_update);
	}

	/**
	* ESTABLECE CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	* @param inCdad_codigo CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	*/
	public void setCDAD_CODIGO(String inCdad_codigo){
		this.myCdad_codigo = inCdad_codigo;
	}
	/**
	* OBTIENE CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	* @return String CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 

	*/
	public String getCDAD_CODIGO(){
		return this.myCdad_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	public void setCDBEC_CODIGO(String inCdbec_codigo){
		this.myCdbec_codigo = inCdbec_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	*/
	public String getCDBEC_CODIGO(){
		return this.myCdbec_codigo;
	}

	/**
	* ESTABLECE CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	* @param inCdad_descripcion CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	public void setCDAD_DESCRIPCION(String inCdad_descripcion){
		this.myCdad_descripcion = inCdad_descripcion;
	}
	/**
	* OBTIENE CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	* @return String CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	public String getCDAD_DESCRIPCION(){
		return this.myCdad_descripcion;
	}

	/**
	* ESTABLECE CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
	* @param inCdad_observacion CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
	*/
	public void setCDAD_OBSERVACION(String inCdad_observacion){
		this.myCdad_observacion = inCdad_observacion;
	}
	/**
	* OBTIENE CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
	* @return String CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
	*/
	public String getCDAD_OBSERVACION(){
		return this.myCdad_observacion;
	}

	/**
	* ESTABLECE NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCdad_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public void setCDAD_NOMBRE_ADJUNTO(String inCdad_nombre_adjunto){
		this.myCdad_nombre_adjunto = inCdad_nombre_adjunto;
	}
	/**
	* OBTIENE NOMBRE DEL DOCUMENTO ADJUNTO
	* @return String NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	public String getCDAD_NOMBRE_ADJUNTO(){
		return this.myCdad_nombre_adjunto;
	}

	/**
	* ESTABLECE CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	* @param inCdad_adjunto CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	public void setCDAD_ADJUNTO(byte[] inCdad_adjunto){
		this.myCdad_adjunto = inCdad_adjunto;
	}
	/**
	* OBTIENE CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	* @return byte[] CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	public byte[] getCDAD_ADJUNTO(){
		return this.myCdad_adjunto;
	}

	/**
	* ESTABLECE TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
0 - CONTRATO DE BECA
1 - INFORME
2 - MEMORANDUM DE APROBACIONES
3 - OTROS
	* @param inCdad_tipo TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
0 - CONTRATO DE BECA
1 - INFORME
2 - MEMORANDUM DE APROBACIONES
3 - OTROS
	*/
	public void setCDAD_TIPO(int inCdad_tipo){
		this.myCdad_tipo = inCdad_tipo;
	}
	/**
	* OBTIENE TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
0 - CONTRATO DE BECA
1 - INFORME
2 - MEMORANDUM DE APROBACIONES
3 - OTROS
	* @return int TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
0 - CONTRATO DE BECA
1 - INFORME
2 - MEMORANDUM DE APROBACIONES
3 - OTROS
	*/
	public int getCDAD_TIPO(){
		return this.myCdad_tipo;
	}

	/**
	* ESTABLECE CAMPO DE TEXTO DESCRIPCION CONTENIDO
	* @param inCdad_descripcion_contenido CAMPO DE TEXTO DESCRIPCION CONTENIDO
	*/
	public void setCDAD_DESCRIPCION_CONTENIDO(String inCdad_descripcion_contenido){
		this.myCdad_descripcion_contenido = inCdad_descripcion_contenido;
	}
	/**
	* OBTIENE CAMPO DE TEXTO DESCRIPCION CONTENIDO
	* @return String CAMPO DE TEXTO DESCRIPCION CONTENIDO
	*/
	public String getCDAD_DESCRIPCION_CONTENIDO(){
		return this.myCdad_descripcion_contenido;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCdad_estado ESTADO DEL REGISTRO
	*/
	public void setCDAD_ESTADO(boolean inCdad_estado){
		this.myCdad_estado = inCdad_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCDAD_ESTADO(){
		return this.myCdad_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCdad_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCDAD_USUARIO_INSERT(String inCdad_usuario_insert){
		this.myCdad_usuario_insert = inCdad_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCDAD_USUARIO_INSERT(){
		return this.myCdad_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCdad_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCDAD_USUARIO_UPDATE(String inCdad_usuario_update){
		this.myCdad_usuario_update = inCdad_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCDAD_USUARIO_UPDATE(){
		return this.myCdad_usuario_update;
	}

}
