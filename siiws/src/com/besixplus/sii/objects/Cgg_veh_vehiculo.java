package com.besixplus.sii.objects;

import java.io.Serializable;
/**
* CLASE Cgg_veh_vehiculo
* TABLA: VEHICULO
* DESCRIPCION: INFORMACION DE LOS VEHICULOS INGRESADOS A LAS ISLAS.
* ABREVIATURA: CVVEH
*/
public class Cgg_veh_vehiculo implements Serializable{
	private static final long serialVersionUID = 1451502052;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	private String myCvveh_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	private String myCvmrc_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	*/
	private String myCvclr_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	private String myCvctg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	private String myCsctp_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	private String myCvsct_codigo;
	/**
	* IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	*/
	private String myCgg_cvclr_codigo;
	/**
	* NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	*/
	private String myCvveh_nombre;
	/**
	* NOMBRE DEL MODELO DEL VEHICULO
	*/
	private String myCvveh_modelo;
	/**
	* TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	*/
	private int myCvveh_tipo;
	/**
	* ANIO DE FABRICACION DEL VEHICULO
	*/
	private int myCvveh_anio_produccion;
	/**
	* SERIE DEL CHASIS DEL VEHICULO
	*/
	private String myCvveh_chasis;
	/**
	* PLACA DEL VEHICULO
	*/
	private String myCvveh_placa;
	/**
	* FOTO DEL VEHICULO
	*/
	private byte[] myCvveh_foto;
	/**
	* INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	private java.math.BigDecimal myCvveh_eslora;
	/**
	* INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	private java.math.BigDecimal myCvveh_manga;
	/**
	* INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	private java.math.BigDecimal myCvveh_puntal;
	/**
	* MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	*/
	private String myCvveh_material;
	/**
	* IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	*/
	private boolean myCvveh_ingreso;
	/**
	* FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	*/
	private java.util.Date myCvveh_fecha_ingreso;
	/**
	* MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	*/
	private int myCvveh_tipo_ingreso;
	/**
	* PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	*/
	private int myCvveh_tiempo_estadia;
	/**
	* SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	*/
	private boolean myCvveh_salio;
	/**
	* FECHA CUANDO EL VEHICULO SALIO
	*/
	private java.util.Date myCvveh_fecha_salida;
	/**
	* INFORMACION ADICIONAL
	*/
	private String myCvveh_observacion;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCvveh_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCvveh_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCvveh_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo
	*/
	public Cgg_veh_vehiculo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	* @param inCvctg_codigo IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @param inCgg_cvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	* @param inCvveh_nombre NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	* @param inCvveh_modelo NOMBRE DEL MODELO DEL VEHICULO
	* @param inCvveh_tipo TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	* @param inCvveh_anio_produccion ANIO DE FABRICACION DEL VEHICULO
	* @param inCvveh_chasis SERIE DEL CHASIS DEL VEHICULO
	* @param inCvveh_placa PLACA DEL VEHICULO
	* @param inCvveh_foto FOTO DEL VEHICULO
	* @param inCvveh_eslora INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_manga INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_puntal INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_material MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	* @param inCvveh_ingreso IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	* @param inCvveh_fecha_ingreso FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	* @param inCvveh_tipo_ingreso MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	* @param inCvveh_tiempo_estadia PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	* @param inCvveh_salio SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	* @param inCvveh_fecha_salida FECHA CUANDO EL VEHICULO SALIO
	* @param inCvveh_observacion INFORMACION ADICIONAL
	* @param inCvveh_estado ESTADO DEL REGISTRO
	* @param inCvveh_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvveh_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_veh_vehiculo(
		String inCvveh_codigo,
		String inCvmrc_codigo,
		String inCvclr_codigo,
		String inCvctg_codigo,
		String inCsctp_codigo,
		String inCvsct_codigo,
		String inCgg_cvclr_codigo,
		String inCvveh_nombre,
		String inCvveh_modelo,
		int inCvveh_tipo,
		int inCvveh_anio_produccion,
		String inCvveh_chasis,
		String inCvveh_placa,
		byte[] inCvveh_foto,
		java.math.BigDecimal inCvveh_eslora,
		java.math.BigDecimal inCvveh_manga,
		java.math.BigDecimal inCvveh_puntal,
		String inCvveh_material,
		boolean inCvveh_ingreso,
		java.util.Date inCvveh_fecha_ingreso,
		int inCvveh_tipo_ingreso,
		int inCvveh_tiempo_estadia,
		boolean inCvveh_salio,
		java.util.Date inCvveh_fecha_salida,
		String inCvveh_observacion,
		boolean inCvveh_estado,
		String inCvveh_usuario_insert,
		String inCvveh_usuario_update
	){
		this.setCVVEH_CODIGO(inCvveh_codigo);
		this.setCVMRC_CODIGO(inCvmrc_codigo);
		this.setCVCLR_CODIGO(inCvclr_codigo);
		this.setCVCTG_CODIGO(inCvctg_codigo);
		this.setCSCTP_CODIGO(inCsctp_codigo);
		this.setCVSCT_CODIGO(inCvsct_codigo);
		this.setCGG_CVCLR_CODIGO(inCgg_cvclr_codigo);
		this.setCVVEH_NOMBRE(inCvveh_nombre);
		this.setCVVEH_MODELO(inCvveh_modelo);
		this.setCVVEH_TIPO(inCvveh_tipo);
		this.setCVVEH_ANIO_PRODUCCION(inCvveh_anio_produccion);
		this.setCVVEH_CHASIS(inCvveh_chasis);
		this.setCVVEH_PLACA(inCvveh_placa);
		this.setCVVEH_FOTO(inCvveh_foto);
		this.setCVVEH_ESLORA(inCvveh_eslora);
		this.setCVVEH_MANGA(inCvveh_manga);
		this.setCVVEH_PUNTAL(inCvveh_puntal);
		this.setCVVEH_MATERIAL(inCvveh_material);
		this.setCVVEH_INGRESO(inCvveh_ingreso);
		this.setCVVEH_FECHA_INGRESO(inCvveh_fecha_ingreso);
		this.setCVVEH_TIPO_INGRESO(inCvveh_tipo_ingreso);
		this.setCVVEH_TIEMPO_ESTADIA(inCvveh_tiempo_estadia);
		this.setCVVEH_SALIO(inCvveh_salio);
		this.setCVVEH_FECHA_SALIDA(inCvveh_fecha_salida);
		this.setCVVEH_OBSERVACION(inCvveh_observacion);
		this.setCVVEH_ESTADO(inCvveh_estado);
		this.setCVVEH_USUARIO_INSERT(inCvveh_usuario_insert);
		this.setCVVEH_USUARIO_UPDATE(inCvveh_usuario_update);
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public void setCVVEH_CODIGO(String inCvveh_codigo){
		this.myCvveh_codigo = inCvveh_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	public String getCVVEH_CODIGO(){
		return this.myCvveh_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	public void setCVMRC_CODIGO(String inCvmrc_codigo){
		this.myCvmrc_codigo = inCvmrc_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	*/
	public String getCVMRC_CODIGO(){
		return this.myCvmrc_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	* @param inCvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	*/
	public void setCVCLR_CODIGO(String inCvclr_codigo){
		this.myCvclr_codigo = inCvclr_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	* @return String IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	*/
	public String getCVCLR_CODIGO(){
		return this.myCvclr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @param inCvctg_codigo IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	public void setCVCTG_CODIGO(String inCvctg_codigo){
		this.myCvctg_codigo = inCvctg_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @return String IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	public String getCVCTG_CODIGO(){
		return this.myCvctg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	public void setCSCTP_CODIGO(String inCsctp_codigo){
		this.myCsctp_codigo = inCsctp_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	*/
	public String getCSCTP_CODIGO(){
		return this.myCsctp_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	public void setCVSCT_CODIGO(String inCvsct_codigo){
		this.myCvsct_codigo = inCvsct_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	*/
	public String getCVSCT_CODIGO(){
		return this.myCvsct_codigo;
	}

	/**
	* ESTABLECE IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	* @param inCgg_cvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	*/
	public void setCGG_CVCLR_CODIGO(String inCgg_cvclr_codigo){
		this.myCgg_cvclr_codigo = inCgg_cvclr_codigo;
	}
	/**
	* OBTIENE IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	* @return String IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	*/
	public String getCGG_CVCLR_CODIGO(){
		return this.myCgg_cvclr_codigo;
	}

	/**
	* ESTABLECE NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	* @param inCvveh_nombre NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	*/
	public void setCVVEH_NOMBRE(String inCvveh_nombre){
		this.myCvveh_nombre = inCvveh_nombre;
	}
	/**
	* OBTIENE NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	* @return String NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	*/
	public String getCVVEH_NOMBRE(){
		return this.myCvveh_nombre;
	}

	/**
	* ESTABLECE NOMBRE DEL MODELO DEL VEHICULO
	* @param inCvveh_modelo NOMBRE DEL MODELO DEL VEHICULO
	*/
	public void setCVVEH_MODELO(String inCvveh_modelo){
		this.myCvveh_modelo = inCvveh_modelo;
	}
	/**
	* OBTIENE NOMBRE DEL MODELO DEL VEHICULO
	* @return String NOMBRE DEL MODELO DEL VEHICULO
	*/
	public String getCVVEH_MODELO(){
		return this.myCvveh_modelo;
	}

	/**
	* ESTABLECE TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	* @param inCvveh_tipo TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	*/
	public void setCVVEH_TIPO(int inCvveh_tipo){
		this.myCvveh_tipo = inCvveh_tipo;
	}
	/**
	* OBTIENE TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	* @return int TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	*/
	public int getCVVEH_TIPO(){
		return this.myCvveh_tipo;
	}

	/**
	* ESTABLECE ANIO DE FABRICACION DEL VEHICULO
	* @param inCvveh_anio_produccion ANIO DE FABRICACION DEL VEHICULO
	*/
	public void setCVVEH_ANIO_PRODUCCION(int inCvveh_anio_produccion){
		this.myCvveh_anio_produccion = inCvveh_anio_produccion;
	}
	/**
	* OBTIENE ANIO DE FABRICACION DEL VEHICULO
	* @return int ANIO DE FABRICACION DEL VEHICULO
	*/
	public int getCVVEH_ANIO_PRODUCCION(){
		return this.myCvveh_anio_produccion;
	}

	/**
	* ESTABLECE SERIE DEL CHASIS DEL VEHICULO
	* @param inCvveh_chasis SERIE DEL CHASIS DEL VEHICULO
	*/
	public void setCVVEH_CHASIS(String inCvveh_chasis){
		this.myCvveh_chasis = inCvveh_chasis;
	}
	/**
	* OBTIENE SERIE DEL CHASIS DEL VEHICULO
	* @return String SERIE DEL CHASIS DEL VEHICULO
	*/
	public String getCVVEH_CHASIS(){
		return this.myCvveh_chasis;
	}

	/**
	* ESTABLECE PLACA DEL VEHICULO
	* @param inCvveh_placa PLACA DEL VEHICULO
	*/
	public void setCVVEH_PLACA(String inCvveh_placa){
		this.myCvveh_placa = inCvveh_placa;
	}
	/**
	* OBTIENE PLACA DEL VEHICULO
	* @return String PLACA DEL VEHICULO
	*/
	public String getCVVEH_PLACA(){
		return this.myCvveh_placa;
	}

	/**
	* ESTABLECE FOTO DEL VEHICULO
	* @param inCvveh_foto FOTO DEL VEHICULO
	*/
	public void setCVVEH_FOTO(byte[] inCvveh_foto){
		this.myCvveh_foto = inCvveh_foto;
	}
	/**
	* OBTIENE FOTO DEL VEHICULO
	* @return byte[] FOTO DEL VEHICULO
	*/
	public byte[] getCVVEH_FOTO(){
		return this.myCvveh_foto;
	}

	/**
	* ESTABLECE INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_eslora INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	public void setCVVEH_ESLORA(java.math.BigDecimal inCvveh_eslora){
		this.myCvveh_eslora = inCvveh_eslora;
	}
	/**
	* OBTIENE INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @return java.math.BigDecimal INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	public java.math.BigDecimal getCVVEH_ESLORA(){
		return this.myCvveh_eslora;
	}

	/**
	* ESTABLECE INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_manga INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	public void setCVVEH_MANGA(java.math.BigDecimal inCvveh_manga){
		this.myCvveh_manga = inCvveh_manga;
	}
	/**
	* OBTIENE INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @return java.math.BigDecimal INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	public java.math.BigDecimal getCVVEH_MANGA(){
		return this.myCvveh_manga;
	}

	/**
	* ESTABLECE INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_puntal INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	public void setCVVEH_PUNTAL(java.math.BigDecimal inCvveh_puntal){
		this.myCvveh_puntal = inCvveh_puntal;
	}
	/**
	* OBTIENE INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @return java.math.BigDecimal INFORMACION DE VEHICULOS MARITIMOS (METROS)
	*/
	public java.math.BigDecimal getCVVEH_PUNTAL(){
		return this.myCvveh_puntal;
	}

	/**
	* ESTABLECE MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	* @param inCvveh_material MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	*/
	public void setCVVEH_MATERIAL(String inCvveh_material){
		this.myCvveh_material = inCvveh_material;
	}
	/**
	* OBTIENE MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	* @return String MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	*/
	public String getCVVEH_MATERIAL(){
		return this.myCvveh_material;
	}

	/**
	* ESTABLECE IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	* @param inCvveh_ingreso IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	*/
	public void setCVVEH_INGRESO(boolean inCvveh_ingreso){
		this.myCvveh_ingreso = inCvveh_ingreso;
	}
	/**
	* OBTIENE IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	* @return boolean IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	*/
	public boolean getCVVEH_INGRESO(){
		return this.myCvveh_ingreso;
	}

	/**
	* ESTABLECE FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	* @param inCvveh_fecha_ingreso FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	*/
	public void setCVVEH_FECHA_INGRESO(java.util.Date inCvveh_fecha_ingreso){
		this.myCvveh_fecha_ingreso = inCvveh_fecha_ingreso;
	}
	/**
	* OBTIENE FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	* @return java.util.Date FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	*/
	public java.util.Date getCVVEH_FECHA_INGRESO(){
		return this.myCvveh_fecha_ingreso;
	}

	/**
	* ESTABLECE MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	* @param inCvveh_tipo_ingreso MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	*/
	public void setCVVEH_TIPO_INGRESO(int inCvveh_tipo_ingreso){
		this.myCvveh_tipo_ingreso = inCvveh_tipo_ingreso;
	}
	/**
	* OBTIENE MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	* @return int MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	*/
	public int getCVVEH_TIPO_INGRESO(){
		return this.myCvveh_tipo_ingreso;
	}

	/**
	* ESTABLECE PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	* @param inCvveh_tiempo_estadia PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	*/
	public void setCVVEH_TIEMPO_ESTADIA(int inCvveh_tiempo_estadia){
		this.myCvveh_tiempo_estadia = inCvveh_tiempo_estadia;
	}
	/**
	* OBTIENE PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	* @return int PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	*/
	public int getCVVEH_TIEMPO_ESTADIA(){
		return this.myCvveh_tiempo_estadia;
	}

	/**
	* ESTABLECE SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	* @param inCvveh_salio SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	*/
	public void setCVVEH_SALIO(boolean inCvveh_salio){
		this.myCvveh_salio = inCvveh_salio;
	}
	/**
	* OBTIENE SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	* @return boolean SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	*/
	public boolean getCVVEH_SALIO(){
		return this.myCvveh_salio;
	}

	/**
	* ESTABLECE FECHA CUANDO EL VEHICULO SALIO
	* @param inCvveh_fecha_salida FECHA CUANDO EL VEHICULO SALIO
	*/
	public void setCVVEH_FECHA_SALIDA(java.util.Date inCvveh_fecha_salida){
		this.myCvveh_fecha_salida = inCvveh_fecha_salida;
	}
	/**
	* OBTIENE FECHA CUANDO EL VEHICULO SALIO
	* @return java.util.Date FECHA CUANDO EL VEHICULO SALIO
	*/
	public java.util.Date getCVVEH_FECHA_SALIDA(){
		return this.myCvveh_fecha_salida;
	}

	/**
	* ESTABLECE INFORMACION ADICIONAL
	* @param inCvveh_observacion INFORMACION ADICIONAL
	*/
	public void setCVVEH_OBSERVACION(String inCvveh_observacion){
		this.myCvveh_observacion = inCvveh_observacion;
	}
	/**
	* OBTIENE INFORMACION ADICIONAL
	* @return String INFORMACION ADICIONAL
	*/
	public String getCVVEH_OBSERVACION(){
		return this.myCvveh_observacion;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCvveh_estado ESTADO DEL REGISTRO
	*/
	public void setCVVEH_ESTADO(boolean inCvveh_estado){
		this.myCvveh_estado = inCvveh_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCVVEH_ESTADO(){
		return this.myCvveh_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCvveh_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCVVEH_USUARIO_INSERT(String inCvveh_usuario_insert){
		this.myCvveh_usuario_insert = inCvveh_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCVVEH_USUARIO_INSERT(){
		return this.myCvveh_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCvveh_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCVVEH_USUARIO_UPDATE(String inCvveh_usuario_update){
		this.myCvveh_usuario_update = inCvveh_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCVVEH_USUARIO_UPDATE(){
		return this.myCvveh_usuario_update;
	}

}
