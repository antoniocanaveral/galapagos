package com.besixplus.sii.objects;

import java.io.Serializable;
import java.util.ArrayList;
/**
* CLASE Cgg_res_persona
* TABLA: PERSONA
* DESCRIPCION: ALMACENA LA INFORMACION DE RESIDENTES
* ABREVIATURA: CRPER
*/
public class Cgg_res_persona implements Serializable{
	private static final long serialVersionUID = 1939021964;
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	private String myCrper_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	*/
	private String myCrecv_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	private String myCrdid_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	*/
	private String myCrtsg_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	*/
	private String myCgncn_codigo;
	/**
	 * DESCRIPCION DE LA NACIONALIDAD DE UNA PERSONA
	 */
	private String myCrper_nacionalidad_descripcion;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	*/
	private String myCprr_codigo;
	/**
	 * DESCRIPCION DE LA PARROQUIA ORIGEN DE UNA PERSONA
	 */
	private String myCrper_parroquia_descripcion;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	private String myCctn_codigo;
	/**
	 * DESCRIPCION DEL CANTON ORIGEN DE UNA PERSONA
	 */
	private String myCrper_canton_origen;
	/**
	 * DESCRIPCION DEL CANTON DE UNA PERSONA
	 */
	private String myCrper_canton_descripcion;
	/**
	* CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	*/
	private String myCgg_cctn_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	*/
	private String myCpais_codigo;
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	*/
	private String myCgg_cpais_codigo;
	/**
	* NOMBRES DE LA PERSONA
	*/
	private String myCrper_nombres;
	/**
	 * NOMBRE PERSONA
	 */
	private String myCrper_nombre_persona;
	/**
	* APELLIDO PATERNO
	*/
	private String myCrper_apellido_paterno;
	/**
	* APELLIDO MATERNO
	*/
	private String myCrper_apellido_materno;
	/**
	* NUMERO DE DOCUMENTO DE IDENTIFICACION
	*/
	private String myCrper_num_doc_identific;
	/**
	 * DESCRIPCION DEL ESTADO CIVIL DE UNA PERSONA
	 */
	private String myCrper_estado_civil_persona;
	/**
	* FECHA DE NACIMIENTO
	*/
	private java.util.Date myCrper_fecha_nacimiento;
	/**
	* LUGAR DE NACIMIENTO
	*/
	private String myCrper_lugar_nacimiento;
	/**
	* GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	*/
	private int myCrper_genero;
	/**
	* OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	*/
	private String myCrper_observaciones;
	/**
	* NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	*/
	private String myCrper_numero_residencia;
	/**
	* FOTOGRAFIA DE LA PERSONA
	*/
	private byte[] myCrper_foto;
	/**
	* FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	*/
	private byte[] myCrper_foto_curriculum;
	/**
	* INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES.
	*/
	private String myCrper_huella_dactilar;
	/**
	* IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	*/
	private byte[] myCrper_huella_imagen;
	/**
	* INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES.
	*/
	private String myCrper_huella_cadena;
	/**
	* FIRMA DIGITAL DE LA PERSONA
	*/
	private byte[] myCrper_firma;
	/**
	* ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	*/
	private boolean myCrper_autorizado;
	/**
	* NUMERO DE EXPEDIENTE UNICO
	*/
	private String myCrper_numero_expediente;
	/**
	* FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	*/
	private java.util.Date myCrper_fecha_archivo;
	/**
	* ARRAY PARA LOS DATOS DEL PRESTAMO EXPEDIENTE
	*/
	private ArrayList<Cgg_res_prestamo_expediente> myPrestamoMovimiento;
	/**
	* ESTADO LABORAL DE LA PERSONA
	*/
	private boolean myCrper_empleado;
	/**
	* FECHA DE INICIO DEL ULTIMO EMPLEO
	*/
	private java.util.Date myCrper_fecha_ultimo_empleo;
	/**
	* SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	*/
	private java.math.BigDecimal myCrper_aspiracion_salarial;
	/**
	* SI TIENE DISPONIBLE UN CUPO VEHICULAR
	*/
	private boolean myCrper_cupo_vehicular;
	/**
	* CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	*/
	private int myCrper_tipo_persona;
	/**
	* CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	*/
	private boolean myCrper_estado_interfecto;
	/**
	* FECHA DE DEFUNCION
	*/
	private java.util.Date myCrper_fecha_defuncion;
	/**
	* NUMERO DE ACTA DE DEFUNCION
	*/
	private String myCrper_numero_acta;
	/**
	* CODIGO DEL PRESTAMO EXPEDIENTE SALIDA
	*/
	private String myPrestamoExpediente;
	/**
	* DIGITALIZACION DEL ACTA DE DEFUNCION
	*/
	private byte[] myCrper_adjunto_acta;
	/**
	* NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	*/
	private String myCrper_nombre_adjunto_acta;
	/**
	* ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	*/
	private int myCrper_tipo;
	/**
	 * NOMBRE DEL TIPO DE DOCUMENTO DE IDENTIDAD
	 */
	private String myCrper_tipo_documento;
	/**
	* SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	*/
	private boolean myCrper_atencion_cliente;
	/**
	* ESTADO DEL REGISTRO
	*/
	private boolean myCrper_estado;
	/**
	* USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	private String myCrper_usuario_insert;
	/**
	* USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	private String myCrper_usuario_update;
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona
	*/
	public Cgg_res_persona(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_res_persona
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	* @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	* @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	* @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCgg_cctn_codigo CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	* @param inCgg_cpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	* @param inCrper_nombres NOMBRES DE LA PERSONA
	* @param inCrper_apellido_paterno APELLIDO PATERNO
	* @param inCrper_apellido_materno APELLIDO MATERNO
	* @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrper_fecha_nacimiento FECHA DE NACIMIENTO
	* @param inCrper_lugar_nacimiento LUGAR DE NACIMIENTO
	* @param inCrper_genero GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	* @param inCrper_observaciones OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	* @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	* @param inCrper_foto FOTOGRAFIA DE LA PERSONA
	* @param inCrper_foto_curriculum FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	* @param inCrper_huella_dactilar HUELLA DACTILAR DE LA PERSONA
	* @param inCrper_huella_imagen IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	* @param inCrper_huella_cadena TEXTO QUE REPRESENTA LA HUELLA CAPTURADA. ESTE TEXTO ES VARIABLE.
	* @param inCrper_firma FIRMA DIGITAL DE LA PERSONA
	* @param inCrper_autorizado ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	* @param inCrper_numero_expediente NUMERO DE EXPEDIENTE UNICO
	* @param inCrper_fecha_archivo FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	* @param inCrper_empleado ESTADO LABORAL DE LA PERSONA
	* @param inCrper_fecha_ultimo_empleo FECHA DE INICIO DEL ULTIMO EMPLEO
	* @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	* @param inCrper_cupo_vehicular SI TIENE DISPONIBLE UN CUPO VEHICULAR
	* @param inCrper_tipo_persona CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	* @param inCrper_estado_interfecto CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	* @param inCrper_fecha_defuncion FECHA DE DEFUNCION
	* @param inCrper_numero_acta NUMERO DE ACTA DE DEFUNCION
	* @param inCrper_adjunto_acta DIGITALIZACION DEL ACTA DE DEFUNCION
	* @param inCrper_nombre_adjunto_acta NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	* @param inCrper_tipo ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	* @param inCrper_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	* @param inCrper_estado ESTADO DEL REGISTRO
	* @param inCrper_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrper_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public Cgg_res_persona(
		String inCrper_codigo,
		String inCrecv_codigo,
		String inCrdid_codigo,
		String inCrtsg_codigo,
		String inCgncn_codigo,
		String inCprr_codigo,
		String inCctn_codigo,
		String inCgg_cctn_codigo,
		String inCpais_codigo,
		String inCgg_cpais_codigo,
		String inCrper_nombres,
		String inCrper_apellido_paterno,
		String inCrper_apellido_materno,
		String inCrper_num_doc_identific,
		java.util.Date inCrper_fecha_nacimiento,
		String inCrper_lugar_nacimiento,
		int inCrper_genero,
		String inCrper_observaciones,
		String inCrper_numero_residencia,
		byte[] inCrper_foto,
		byte[] inCrper_foto_curriculum,
		String inCrper_huella_dactilar,
		byte[] inCrper_huella_imagen,
		String inCrper_huella_cadena,
		byte[] inCrper_firma,
		boolean inCrper_autorizado,
		String inCrper_numero_expediente,
		java.util.Date inCrper_fecha_archivo,
		boolean inCrper_empleado,
		java.util.Date inCrper_fecha_ultimo_empleo,
		java.math.BigDecimal inCrper_aspiracion_salarial,
		boolean inCrper_cupo_vehicular,
		int inCrper_tipo_persona,
		boolean inCrper_estado_interfecto,
		java.util.Date inCrper_fecha_defuncion,
		String inCrper_numero_acta,
		byte[] inCrper_adjunto_acta,
		String inCrper_nombre_adjunto_acta,
		int inCrper_tipo,
		boolean inCrper_atencion_cliente,
		boolean inCrper_estado,
		String inCrper_usuario_insert,
		String inCrper_usuario_update
	){
		this.setCRPER_CODIGO(inCrper_codigo);
		this.setCRECV_CODIGO(inCrecv_codigo);
		this.setCRDID_CODIGO(inCrdid_codigo);
		this.setCRTSG_CODIGO(inCrtsg_codigo);
		this.setCGNCN_CODIGO(inCgncn_codigo);
		this.setCPRR_CODIGO(inCprr_codigo);
		this.setCCTN_CODIGO(inCctn_codigo);
		this.setCGG_CCTN_CODIGO(inCgg_cctn_codigo);
		this.setCPAIS_CODIGO(inCpais_codigo);
		this.setCGG_CPAIS_CODIGO(inCgg_cpais_codigo);
		this.setCRPER_NOMBRES(inCrper_nombres);
		this.setCRPER_APELLIDO_PATERNO(inCrper_apellido_paterno);
		this.setCRPER_APELLIDO_MATERNO(inCrper_apellido_materno);
		this.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific);
		this.setCRPER_FECHA_NACIMIENTO(inCrper_fecha_nacimiento);
		this.setCRPER_LUGAR_NACIMIENTO(inCrper_lugar_nacimiento);
		this.setCRPER_GENERO(inCrper_genero);
		this.setCRPER_OBSERVACIONES(inCrper_observaciones);
		this.setCRPER_NUMERO_RESIDENCIA(inCrper_numero_residencia);
		this.setCRPER_FOTO(inCrper_foto);
		this.setCRPER_FOTO_CURRICULUM(inCrper_foto_curriculum);
		this.setCRPER_HUELLA_DACTILAR(inCrper_huella_dactilar);
		this.setCRPER_HUELLA_IMAGEN(inCrper_huella_imagen);
		this.setCRPER_HUELLA_CADENA(inCrper_huella_cadena);
		this.setCRPER_FIRMA(inCrper_firma);
		this.setCRPER_AUTORIZADO(inCrper_autorizado);
		this.setCRPER_NUMERO_EXPEDIENTE(inCrper_numero_expediente);
		this.setCRPER_FECHA_ARCHIVO(inCrper_fecha_archivo);
		this.setCRPER_EMPLEADO(inCrper_empleado);
		this.setCRPER_FECHA_ULTIMO_EMPLEO(inCrper_fecha_ultimo_empleo);
		this.setCRPER_ASPIRACION_SALARIAL(inCrper_aspiracion_salarial);
		this.setCRPER_CUPO_VEHICULAR(inCrper_cupo_vehicular);
		this.setCRPER_TIPO_PERSONA(inCrper_tipo_persona);
		this.setCRPER_ESTADO_INTERFECTO(inCrper_estado_interfecto);
		this.setCRPER_FECHA_DEFUNCION(inCrper_fecha_defuncion);
		this.setCRPER_NUMERO_ACTA(inCrper_numero_acta);
		this.setCRPER_ADJUNTO_ACTA(inCrper_adjunto_acta);
		this.setCRPER_NOMBRE_ADJUNTO_ACTA(inCrper_nombre_adjunto_acta);
		this.setCRPER_TIPO(inCrper_tipo);
		this.setCRPER_ATENCION_CLIENTE(inCrper_atencion_cliente);
		this.setCRPER_ESTADO(inCrper_estado);
		this.setCRPER_USUARIO_INSERT(inCrper_usuario_insert);
		this.setCRPER_USUARIO_UPDATE(inCrper_usuario_update);
	}

	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public void setCRPER_CODIGO(String inCrper_codigo){
		this.myCrper_codigo = inCrper_codigo;
	}
	/**
	* OBTIENE CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @return String CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	*/
	public String getCRPER_CODIGO(){
		return this.myCrper_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	* @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	*/
	public void setCRECV_CODIGO(String inCrecv_codigo){
		this.myCrecv_codigo = inCrecv_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	*/
	public String getCRECV_CODIGO(){
		return this.myCrecv_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	public void setCRDID_CODIGO(String inCrdid_codigo){
		this.myCrdid_codigo = inCrdid_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	*/
	public String getCRDID_CODIGO(){
		return this.myCrdid_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	* @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	*/
	public void setCRTSG_CODIGO(String inCrtsg_codigo){
		this.myCrtsg_codigo = inCrtsg_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	*/
	public String getCRTSG_CODIGO(){
		return this.myCrtsg_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	* @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	*/
	public void setCGNCN_CODIGO(String inCgncn_codigo){
		this.myCgncn_codigo = inCgncn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	*/
	public String getCGNCN_CODIGO(){
		return this.myCgncn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	* @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	*/
	public void setCPRR_CODIGO(String inCprr_codigo){
		this.myCprr_codigo = inCprr_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	*/
	public String getCPRR_CODIGO(){
		return this.myCprr_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public void setCCTN_CODIGO(String inCctn_codigo){
		this.myCctn_codigo = inCctn_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	public String getCCTN_CODIGO(){
		return this.myCctn_codigo;
	}

	/**
	* ESTABLECE CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	* @param inCgg_cctn_codigo CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	*/
	public void setCGG_CCTN_CODIGO(String inCgg_cctn_codigo){
		this.myCgg_cctn_codigo = inCgg_cctn_codigo;
	}
	/**
	* OBTIENE CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	* @return String CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	*/
	public String getCGG_CCTN_CODIGO(){
		return this.myCgg_cctn_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	*/
	public void setCPAIS_CODIGO(String inCpais_codigo){
		this.myCpais_codigo = inCpais_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	*/
	public String getCPAIS_CODIGO(){
		return this.myCpais_codigo;
	}

	/**
	* ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	* @param inCgg_cpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	*/
	public void setCGG_CPAIS_CODIGO(String inCgg_cpais_codigo){
		this.myCgg_cpais_codigo = inCgg_cpais_codigo;
	}
	/**
	* OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	* @return String IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	*/
	public String getCGG_CPAIS_CODIGO(){
		return this.myCgg_cpais_codigo;
	}

	/**
	* ESTABLECE NOMBRES DE LA PERSONA
	* @param inCrper_nombres NOMBRES DE LA PERSONA
	*/
	public void setCRPER_NOMBRES(String inCrper_nombres){
		this.myCrper_nombres = inCrper_nombres;
	}
	/**
	* OBTIENE NOMBRES DE LA PERSONA
	* @return String NOMBRES DE LA PERSONA
	*/
	public String getCRPER_NOMBRES(){
		return this.myCrper_nombres;
	}

	/**
	* ESTABLECE APELLIDO PATERNO
	* @param inCrper_apellido_paterno APELLIDO PATERNO
	*/
	public void setCRPER_APELLIDO_PATERNO(String inCrper_apellido_paterno){
		this.myCrper_apellido_paterno = inCrper_apellido_paterno;
	}
	/**
	* OBTIENE APELLIDO PATERNO
	* @return String APELLIDO PATERNO
	*/
	public String getCRPER_APELLIDO_PATERNO(){
		return this.myCrper_apellido_paterno;
	}

	/**
	* ESTABLECE APELLIDO MATERNO
	* @param inCrper_apellido_materno APELLIDO MATERNO
	*/
	public void setCRPER_APELLIDO_MATERNO(String inCrper_apellido_materno){
		this.myCrper_apellido_materno = inCrper_apellido_materno;
	}
	/**
	* OBTIENE APELLIDO MATERNO
	* @return String APELLIDO MATERNO
	*/
	public String getCRPER_APELLIDO_MATERNO(){
		return this.myCrper_apellido_materno;
	}

	/**
	* ESTABLECE NUMERO DE DOCUMENTO DE IDENTIFICACION
	* @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION
	*/
	public void setCRPER_NUM_DOC_IDENTIFIC(String inCrper_num_doc_identific){
		this.myCrper_num_doc_identific = inCrper_num_doc_identific;
	}
	/**
	* OBTIENE NUMERO DE DOCUMENTO DE IDENTIFICACION
	* @return String NUMERO DE DOCUMENTO DE IDENTIFICACION
	*/
	public String getCRPER_NUM_DOC_IDENTIFIC(){
		return this.myCrper_num_doc_identific;
	}

	/**
	* ESTABLECE FECHA DE NACIMIENTO
	* @param inCrper_fecha_nacimiento FECHA DE NACIMIENTO
	*/
	public void setCRPER_FECHA_NACIMIENTO(java.util.Date inCrper_fecha_nacimiento){
		this.myCrper_fecha_nacimiento = inCrper_fecha_nacimiento;
	}
	/**
	* OBTIENE FECHA DE NACIMIENTO
	* @return java.util.Date FECHA DE NACIMIENTO
	*/
	public java.util.Date getCRPER_FECHA_NACIMIENTO(){
		return this.myCrper_fecha_nacimiento;
	}

	/**
	* ESTABLECE LUGAR DE NACIMIENTO
	* @param inCrper_lugar_nacimiento LUGAR DE NACIMIENTO
	*/
	public void setCRPER_LUGAR_NACIMIENTO(String inCrper_lugar_nacimiento){
		this.myCrper_lugar_nacimiento = inCrper_lugar_nacimiento;
	}
	/**
	* OBTIENE LUGAR DE NACIMIENTO
	* @return String LUGAR DE NACIMIENTO
	*/
	public String getCRPER_LUGAR_NACIMIENTO(){
		return this.myCrper_lugar_nacimiento;
	}

	/**
	* ESTABLECE GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	* @param inCrper_genero GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	*/
	public void setCRPER_GENERO(int inCrper_genero){
		this.myCrper_genero = inCrper_genero;
	}
	/**
	* OBTIENE GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	* @return int GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	*/
	public int getCRPER_GENERO(){
		return this.myCrper_genero;
	}

	/**
	* ESTABLECE OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	* @param inCrper_observaciones OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	*/
	public void setCRPER_OBSERVACIONES(String inCrper_observaciones){
		this.myCrper_observaciones = inCrper_observaciones;
	}
	/**
	* OBTIENE OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	* @return String OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	*/
	public String getCRPER_OBSERVACIONES(){
		return this.myCrper_observaciones;
	}

	/**
	* ESTABLECE NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	* @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	*/
	public void setCRPER_NUMERO_RESIDENCIA(String inCrper_numero_residencia){
		this.myCrper_numero_residencia = inCrper_numero_residencia;
	}
	/**
	* OBTIENE NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	* @return String NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	*/
	public String getCRPER_NUMERO_RESIDENCIA(){
		return this.myCrper_numero_residencia;
	}

	/**
	* ESTABLECE FOTOGRAFIA DE LA PERSONA
	* @param inCrper_foto FOTOGRAFIA DE LA PERSONA
	*/
	public void setCRPER_FOTO(byte[] inCrper_foto){
		this.myCrper_foto = inCrper_foto;
	}
	/**
	* OBTIENE FOTOGRAFIA DE LA PERSONA
	* @return byte[] FOTOGRAFIA DE LA PERSONA
	*/
	public byte[] getCRPER_FOTO(){
		return this.myCrper_foto;
	}

	/**
	* ESTABLECE FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	* @param inCrper_foto_curriculum FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	*/
	public void setCRPER_FOTO_CURRICULUM(byte[] inCrper_foto_curriculum){
		this.myCrper_foto_curriculum = inCrper_foto_curriculum;
	}
	/**
	* OBTIENE FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	* @return byte[] FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	*/
	public byte[] getCRPER_FOTO_CURRICULUM(){
		return this.myCrper_foto_curriculum;
	}

	/**
	* ESTABLECE INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES.
	* @param inCrper_huella_dactilar INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES.
	*/
	public void setCRPER_HUELLA_DACTILAR(String inCrper_huella_dactilar){
		this.myCrper_huella_dactilar = inCrper_huella_dactilar;
	}
	/**
	* OBTIENE INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES.
	* @return byte[] INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES.
	*/
	public String getCRPER_HUELLA_DACTILAR(){
		return this.myCrper_huella_dactilar;
	}

	/**
	* ESTABLECE IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	* @param inCrper_huella_imagen IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	*/
	public void setCRPER_HUELLA_IMAGEN(byte[] inCrper_huella_imagen){
		this.myCrper_huella_imagen = inCrper_huella_imagen;
	}
	/**
	* OBTIENE IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	* @return byte[] IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	*/
	public byte[] getCRPER_HUELLA_IMAGEN(){
		return this.myCrper_huella_imagen;
	}

	/**
	* ESTABLECE INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES.
	* @param inCrper_huella_cadena INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES.
	*/
	public void setCRPER_HUELLA_CADENA(String inCrper_huella_cadena){
		this.myCrper_huella_cadena = inCrper_huella_cadena;
	}
	/**
	* OBTIENE INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES.
	* @return String INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES.
	*/
	public String getCRPER_HUELLA_CADENA(){
		return this.myCrper_huella_cadena;
	}

	/**
	* ESTABLECE FIRMA DIGITAL DE LA PERSONA
	* @param inCrper_firma FIRMA DIGITAL DE LA PERSONA
	*/
	public void setCRPER_FIRMA(byte[] inCrper_firma){
		this.myCrper_firma = inCrper_firma;
	}
	/**
	* OBTIENE FIRMA DIGITAL DE LA PERSONA
	* @return byte[] FIRMA DIGITAL DE LA PERSONA
	*/
	public byte[] getCRPER_FIRMA(){
		return this.myCrper_firma;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	* @param inCrper_autorizado ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	*/
	public void setCRPER_AUTORIZADO(boolean inCrper_autorizado){
		this.myCrper_autorizado = inCrper_autorizado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	* @return boolean ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	*/
	public boolean getCRPER_AUTORIZADO(){
		return this.myCrper_autorizado;
	}

	/**
	* ESTABLECE NUMERO DE EXPEDIENTE UNICO
	* @param inCrper_numero_expediente NUMERO DE EXPEDIENTE UNICO
	*/
	public void setCRPER_NUMERO_EXPEDIENTE(String inCrper_numero_expediente){
		this.myCrper_numero_expediente = inCrper_numero_expediente;
	}
	/**
	* OBTIENE NUMERO DE EXPEDIENTE UNICO
	* @return String NUMERO DE EXPEDIENTE UNICO
	*/
	public String getCRPER_NUMERO_EXPEDIENTE(){
		return this.myCrper_numero_expediente;
	}

	/**
	* ESTABLECE FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	* @param inCrper_fecha_archivo FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	*/
	public void setCRPER_FECHA_ARCHIVO(java.util.Date inCrper_fecha_archivo){
		this.myCrper_fecha_archivo = inCrper_fecha_archivo;
	}
	/**
	* OBTIENE FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	* @return java.util.Date FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	*/
	public java.util.Date getCRPER_FECHA_ARCHIVO(){
		return this.myCrper_fecha_archivo;
	}

	/**
	* ESTABLECE ESTADO LABORAL DE LA PERSONA
	* @param inCrper_empleado ESTADO LABORAL DE LA PERSONA
	*/
	public void setCRPER_EMPLEADO(boolean inCrper_empleado){
		this.myCrper_empleado = inCrper_empleado;
	}
	/**
	* OBTIENE ESTADO LABORAL DE LA PERSONA
	* @return boolean ESTADO LABORAL DE LA PERSONA
	*/
	public boolean getCRPER_EMPLEADO(){
		return this.myCrper_empleado;
	}

	/**
	* ESTABLECE FECHA DE INICIO DEL ULTIMO EMPLEO
	* @param inCrper_fecha_ultimo_empleo FECHA DE INICIO DEL ULTIMO EMPLEO
	*/
	public void setCRPER_FECHA_ULTIMO_EMPLEO(java.util.Date inCrper_fecha_ultimo_empleo){
		this.myCrper_fecha_ultimo_empleo = inCrper_fecha_ultimo_empleo;
	}
	/**
	* OBTIENE FECHA DE INICIO DEL ULTIMO EMPLEO
	* @return java.util.Date FECHA DE INICIO DEL ULTIMO EMPLEO
	*/
	public java.util.Date getCRPER_FECHA_ULTIMO_EMPLEO(){
		return this.myCrper_fecha_ultimo_empleo;
	}

	/**
	* ESTABLECE SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	* @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	*/
	public void setCRPER_ASPIRACION_SALARIAL(java.math.BigDecimal inCrper_aspiracion_salarial){
		this.myCrper_aspiracion_salarial = inCrper_aspiracion_salarial;
	}
	/**
	* OBTIENE SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	* @return java.math.BigDecimal SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	*/
	public java.math.BigDecimal getCRPER_ASPIRACION_SALARIAL(){
		return this.myCrper_aspiracion_salarial;
	}

	/**
	* ESTABLECE SI TIENE DISPONIBLE UN CUPO VEHICULAR
	* @param inCrper_cupo_vehicular SI TIENE DISPONIBLE UN CUPO VEHICULAR
	*/
	public void setCRPER_CUPO_VEHICULAR(boolean inCrper_cupo_vehicular){
		this.myCrper_cupo_vehicular = inCrper_cupo_vehicular;
	}
	/**
	* OBTIENE SI TIENE DISPONIBLE UN CUPO VEHICULAR
	* @return boolean SI TIENE DISPONIBLE UN CUPO VEHICULAR
	*/
	public boolean getCRPER_CUPO_VEHICULAR(){
		return this.myCrper_cupo_vehicular;
	}

	/**
	* ESTABLECE CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	* @param inCrper_tipo_persona CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	*/
	public void setCRPER_TIPO_PERSONA(int inCrper_tipo_persona){
		this.myCrper_tipo_persona = inCrper_tipo_persona;
	}
	/**
	* OBTIENE CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	* @return int CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	*/
	public int getCRPER_TIPO_PERSONA(){
		return this.myCrper_tipo_persona;
	}

	/**
	* ESTABLECE CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	* @param inCrper_estado_interfecto CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	*/
	public void setCRPER_ESTADO_INTERFECTO(boolean inCrper_estado_interfecto){
		this.myCrper_estado_interfecto = inCrper_estado_interfecto;
	}
	/**
	* OBTIENE CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	* @return boolean CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	*/
	public boolean getCRPER_ESTADO_INTERFECTO(){
		return this.myCrper_estado_interfecto;
	}

	/**
	* ESTABLECE FECHA DE DEFUNCION
	* @param inCrper_fecha_defuncion FECHA DE DEFUNCION
	*/
	public void setCRPER_FECHA_DEFUNCION(java.util.Date inCrper_fecha_defuncion){
		this.myCrper_fecha_defuncion = inCrper_fecha_defuncion;
	}
	/**
	* OBTIENE FECHA DE DEFUNCION
	* @return java.util.Date FECHA DE DEFUNCION
	*/
	public java.util.Date getCRPER_FECHA_DEFUNCION(){
		return this.myCrper_fecha_defuncion;
	}

	/**
	* ESTABLECE NUMERO DE ACTA DE DEFUNCION
	* @param inCrper_numero_acta NUMERO DE ACTA DE DEFUNCION
	*/
	public void setCRPER_NUMERO_ACTA(String inCrper_numero_acta){
		this.myCrper_numero_acta = inCrper_numero_acta;
	}
	/**
	* OBTIENE NUMERO DE ACTA DE DEFUNCION
	* @return String NUMERO DE ACTA DE DEFUNCION
	*/
	public String getCRPER_NUMERO_ACTA(){
		return this.myCrper_numero_acta;
	}

	/**
	* ESTABLECE DIGITALIZACION DEL ACTA DE DEFUNCION
	* @param inCrper_adjunto_acta DIGITALIZACION DEL ACTA DE DEFUNCION
	*/
	public void setCRPER_ADJUNTO_ACTA(byte[] inCrper_adjunto_acta){
		this.myCrper_adjunto_acta = inCrper_adjunto_acta;
	}
	/**
	* OBTIENE DIGITALIZACION DEL ACTA DE DEFUNCION
	* @return byte[] DIGITALIZACION DEL ACTA DE DEFUNCION
	*/
	public byte[] getCRPER_ADJUNTO_ACTA(){
		return this.myCrper_adjunto_acta;
	}

	/**
	* ESTABLECE NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	* @param inCrper_nombre_adjunto_acta NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	*/
	public void setCRPER_NOMBRE_ADJUNTO_ACTA(String inCrper_nombre_adjunto_acta){
		this.myCrper_nombre_adjunto_acta = inCrper_nombre_adjunto_acta;
	}
	/**
	* OBTIENE NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	* @return String NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	*/
	public String getCRPER_NOMBRE_ADJUNTO_ACTA(){
		return this.myCrper_nombre_adjunto_acta;
	}

	/**
	* ESTABLECE ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	* @param inCrper_tipo ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	*/
	public void setCRPER_TIPO(int inCrper_tipo){
		this.myCrper_tipo = inCrper_tipo;
	}
	/**
	* OBTIENE ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	* @return int ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	*/
	public int getCRPER_TIPO(){
		return this.myCrper_tipo;
	}

	/**
	* ESTABLECE SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	* @param inCrper_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	*/
	public void setCRPER_ATENCION_CLIENTE(boolean inCrper_atencion_cliente){
		this.myCrper_atencion_cliente = inCrper_atencion_cliente;
	}
	/**
	* OBTIENE SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	* @return boolean SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	*/
	public boolean getCRPER_ATENCION_CLIENTE(){
		return this.myCrper_atencion_cliente;
	}

	/**
	* ESTABLECE ESTADO DEL REGISTRO
	* @param inCrper_estado ESTADO DEL REGISTRO
	*/
	public void setCRPER_ESTADO(boolean inCrper_estado){
		this.myCrper_estado = inCrper_estado;
	}
	/**
	* OBTIENE ESTADO DEL REGISTRO
	* @return boolean ESTADO DEL REGISTRO
	*/
	public boolean getCRPER_ESTADO(){
		return this.myCrper_estado;
	}

	/**
	* ESTABLECE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @param inCrper_usuario_insert USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public void setCRPER_USUARIO_INSERT(String inCrper_usuario_insert){
		this.myCrper_usuario_insert = inCrper_usuario_insert;
	}
	/**
	* OBTIENE USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	* @return String USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
	*/
	public String getCRPER_USUARIO_INSERT(){
		return this.myCrper_usuario_insert;
	}

	/**
	* ESTABLECE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @param inCrper_usuario_update USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public void setCRPER_USUARIO_UPDATE(String inCrper_usuario_update){
		this.myCrper_usuario_update = inCrper_usuario_update;
	}
	/**
	* OBTIENE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	* @return String USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
	*/
	public String getCRPER_USUARIO_UPDATE(){
		return this.myCrper_usuario_update;
	}
	
	/**
	 * ESTABLECE NOMBRE PERSONA
	 * @param inCrper_nombre_persona NOMBRE PERSONA
	 */
	public void setCRPER_NOMBRE_PERSONA(String inCrper_nombre_persona){
		this.myCrper_nombre_persona = inCrper_nombre_persona;
	}
	/**
	 * OBTIENE NOMBRE PERSONA
	 * @return String NOMBRE PERSONA
	 */
	public String getCRPER_NOMBRE_PERSONA(){
		return this.myCrper_nombre_persona;
	}
	
	/**
	* ESTABLECE CODIGO IDENTIFICATIVO DEL PRESTAMO EXPEDIENTE
	* @param inPrestamoExpediente CODIGO IDENTIFICATIVO DEL PRESTAMO EXPEDIENTE
	*/
	public void setPRESTAMOEXPEDIENTE(String inPrestamoExpediente){
		this.myPrestamoExpediente = inPrestamoExpediente;
	}
	/**
	* OBTIENE CODIGO DEL PRESTAMO EXPEDIENTE
	* @return String CODIGO IDENTIFICATIVO DEL PRESTAMO EXPEDIENTE
	*/
	public String getPRESTAMOEXPEDIENTE(){
		return this.myPrestamoExpediente;
	}
	
	/**
	* ESTABLECE EL ARRAY DEL PRESTAMO EXPEDIENTE
	* @param inMovimiento IDENTIFICATIVO DEL PRESTAMO EXPEDIENTE
	*/
	public void setMOVIMIENTO(ArrayList<Cgg_res_prestamo_expediente> inMovimiento){
		this.myPrestamoMovimiento = inMovimiento;
	}
	/**
	* OBTIENE EL ARRAY DEL PRESTAMO EXPEDIENTE 
	* @return String IDENTIFICATIVO DEL PRESTAMO EXPEDIENTE
	*/
	public ArrayList<Cgg_res_prestamo_expediente> getMOVIMIENTO(){
		return this.myPrestamoMovimiento ;
	}
	
	/**
	 * ESTABLECE LA DESCRIPCION DEL ESTADO CIVIL
	 * @param inCrper_myCrper_estado_civil DESCRIPCION DEL ESTADO CIVIL
	 */
	public void setCRECV_ESTADO_CIVIL(String inCrper_myCrper_estado_civil){
		this.myCrper_estado_civil_persona = inCrper_myCrper_estado_civil;
	}
	/**
	 * OBTIENE DESCRIPCION DEL ESTADO CIVIL
	 * @return String DESCRIPCION DEL ESTADO CIVIL
	 */
	public String getCRECV_ESTADO_CIVIL(){
		return this.myCrper_estado_civil_persona;
	}
	
	/**
	 * ESTABLECE LA DESCRIPCION DEL TIPO DOCUMENYO
	 * @param inCrper_tipo_documento DESCRIPCION DEL TIPO DOCUMENYO
	 */
	public void setCRDID_TIPO(String inCrper_tipo_documento){
		this.myCrper_tipo_documento = inCrper_tipo_documento;
	}
	/**
	 * OBTIENE DESCRIPCION DEL TIPO DOCUMENYO
	 * @return String DESCRIPCION DEL ESTADO CIVIL
	 */
	public String getCRDID_TIPO(){
		return this.myCrper_tipo_documento;
	}
	
	/**
	 * ESTABLECE LA DESCRIPCION DE LA NACIONALIDAD
	 * @param inCrper_nacionalidad_descripcion DESCRIPCION DE LA NACIONALIDAD
	 */
	public void setCGNCN_NOMBRE(String inCrper_nacionalidad_descripcion){
		this.myCrper_nacionalidad_descripcion = inCrper_nacionalidad_descripcion;
	}
	/**
	 * OBTIENE DESCRIPCION DE LA NACIONALIDAD
	 * @return String DESCRIPCION DE LA NACIONALIDAD
	 */
	public String getCGNCN_NOMBRE(){
		return this.myCrper_nacionalidad_descripcion;
	}
	
	/**
	 * ESTABLECE LA DESCRIPCION DE LA PARROQUIA
	 * @param inCrper_parroquia_descripcion DESCRIPCIONDE LA PARROQUIA
	 */
	public void setCPRR_NOMBRE(String inCrper_parroquia_descripcion){
		this.myCrper_parroquia_descripcion = inCrper_parroquia_descripcion;
	}
	/**
	 * OBTIENE DESCRIPCION DE LA PARROQUIA
	 * @return String DESCRIPCION DE LA PARROQUIA
	 */
	public String getCPRR_NOMBRE(){
		return this.myCrper_parroquia_descripcion;
	}
	
	/**
	 * ESTABLECE LA DESCRIPCION DEL CANTON
	 * @param inCrper_canton_descripcion DESCRIPCION DEL CANTON
	 */
	public void setCCNT_NOMBRE(String inCrper_canton_descripcion){
		this.myCrper_canton_descripcion = inCrper_canton_descripcion;
	}
	/**
	 * OBTIENE DESCRIPCION DEL CANTON
	 * @return String DESCRIPCION DEL CANTON
	 */
	public String getCCNT_NOMBRE(){
		return this.myCrper_canton_descripcion;
	}
	
	/**
	 * ESTABLECE LA DESCRIPCION DEL CANTON
	 * @param inCrper_canton_origen DESCRIPCION DEL CANTON
	 */
	public void setCCNT_NOMBRE_ORIGEN(String inCrper_canton_origen){
		this.myCrper_canton_origen = inCrper_canton_origen;
	}
	/**
	 * OBTIENE DESCRIPCION DEL CANTON
	 * @return String DESCRIPCION DEL CANTON
	 */
	public String getCCNT_NOMBRE_ORIGEN(){
		return this.myCrper_canton_origen;
	}
}
