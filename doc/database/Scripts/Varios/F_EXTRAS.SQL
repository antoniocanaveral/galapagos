/**
* FUNCION SII.F_SELECT_RESIDENCIA
* OBTIENE LA RESIDENCIA VIGENTE DE UN PERSONA.
* @param IN_CRPER_CODIGO IDENTIFICATIVO UNICO DE PERSONA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_SELECT_RESIDENCIA(
IN IN_CRPER_CODIGO VARCHAR
)RETURNS REFCURSOR AS
$$
DECLARE
OUT_CURSOR REFCURSOR;
BEGIN
	OPEN OUT_CURSOR FOR
	SELECT RSD.CRRSD_CODIGO, 
		RSD.CRPER_CODIGO,
		PJR.CRPJR_CODIGO,
		PJR.CRPJR_RAZON_SOCIAL,
		TRM.CRPER_CODIGO TRM_CRPER_CODIGO,
		RSD.CRTST_CODIGO,
		RSD.CRTRA_CODIGO,
		RSD.CRRSD_MODALIDAD,
		RSD.CRRSD_FECHA_INICIO,
		RSD.CRRSD_FECHA_CADUCIDAD,
		RSD.CRRSD_FECHA_REVOCATORIA,
		RSD.CRRSD_MOTIVO_REVOCATORIA,
		RSD.CRRSD_VIGENTE,
		RSD.CRRSD_TRAMITE_PENDIENTE,
		RSD.CRRSD_ESTADO,
		SII.F_TRAMITE_TIPO(RSD.CRTST_CODIGO) MOTIVO,
		TST.CRTST_DESCRIPCION,
		CASE WHEN PJR.CRPJR_CODIGO IS NULL THEN COALESCE(PRSA.CRPER_NOMBRES,'')||' '||COALESCE(PRSA.CRPER_APELLIDO_PATERNO,'')||' '||COALESCE(PRSA.CRPER_APELLIDO_MATERNO,'') ELSE PJR.CRPJR_RAZON_SOCIAL END AUSPICIANTE,
		COALESCE(PRSA.CRPER_NOMBRES,'')||' '||COALESCE(PRSA.CRPER_APELLIDO_PATERNO,'')||' '||COALESCE(PRSA.CRPER_APELLIDO_MATERNO,'') REPRESENTANTE_LEGAL,
		COALESCE((SELECT CGCRG_NOMBRE FROM SII.CGG_GEM_CARGO WHERE CGCRG_CODIGO = TRM.CRTRA_ACTIVIDAD_RESIDENCIA),'') OCUPACION
	FROM SII.CGG_RES_RESIDENCIA RSD
	INNER JOIN SII.CGG_RES_PERSONA PRS ON PRS.CRPER_CODIGO = RSD.CRPER_CODIGO
	INNER JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = RSD.CRTST_CODIGO
	LEFT JOIN SII.CGG_RES_TRAMITE TRM ON TRM.CRTRA_CODIGO = RSD.CRTRA_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA PRSA ON PRSA.CRPER_CODIGO = TRM.CRPER_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA_JURIDICA PJR ON PJR.CRPJR_CODIGO = TRM.CRPJR_CODIGO
	WHERE RSD.CRRSD_VIGENTE AND RSD.CRRSD_ESTADO AND RSD.CRPER_CODIGO = IN_CRPER_CODIGO;
	
	RETURN OUT_CURSOR;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_SELECT_CARNET
* SELECCIONA EL CARNET DE RESIDENCIA VIGENTE DE UNA PERSONA.
* @param IN_CRRSD_CODIGO IDENTIFICATIVO UNICO DE RESIDENCIA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_SELECT_CARNET(
IN IN_CRRSD_CODIGO VARCHAR
)RETURNS REFCURSOR AS
$$
DECLARE
	OUT_CURSOR REFCURSOR;
BEGIN
	OPEN OUT_CURSOR FOR
	SELECT
		CRCNT_CODIGO, 
		CRCOM_CODIGO, 
		CRADJ_CODIGO, 
		CRRSD_CODIGO,
		CRCNT_SERIE, 
		CRCNT_MOTIVO, 
		CRCNT_FECHA_EMISION, 
		CRCNT_FECHA_APROBACION, 
		CRCNT_FECHA_CADUCIDAD, 
		CRCNT_FECHA_DEPOSITO, 
		CRCNT_CARNET_IMPRESO, 
		CRCNT_VALOR, 
		CRCNT_OBSERVACION, 
		CRCNT_ESTADO, 
		CRCNT_FECHA_INSERT, 
		CRCNT_USUARIO_INSERT, 
		CRCNT_FECHA_UPDATE, 
		CRCNT_USUARIO_UPDATE
	FROM SII.CGG_RES_CARNET
	WHERE CRCNT_ESTADO AND CRRSD_CODIGO = IN_CRRSD_CODIGO
	ORDER BY CRCNT_FECHA_APROBACION DESC LIMIT 1;
	RETURN OUT_CURSOR;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_S_FASE_COMITE
* SELECCIONA LA FASE ACTUAL DE COMITE.
* @param IN_CRTRA_CODIGO IDENTIFICATIVO UNICO DE TRAMITE.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_S_FASE_COMITE(
IN IN_CRTRA_CODIGO VARCHAR
)RETURNS REFCURSOR AS
$$
DECLARE
OUT_CURSOR REFCURSOR;
TMP_TRAMITES_COMITE VARCHAR;	
BEGIN
	
	SELECT CGCNF_VALOR_CADENA INTO TMP_TRAMITES_COMITE FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = '01';
	OPEN OUT_CURSOR FOR
		SELECT 
			TRM.CRTRA_CODIGO,
			SGM.CRSEG_CODIGO,
			SGM.CRFAS_CODIGO,
			PRC.CRPRO_CODIGO,
			TRM.CRTRA_NUMERO
		FROM SII.CGG_RES_TRAMITE TRM
		INNER JOIN SII.CGG_RES_ESTADO_TRAMITE ETT ON ETT.CRETT_CODIGO = TRM.CRETT_CODIGO
		INNER JOIN SII.CGG_RES_SEGUIMIENTO SGM ON SGM.CRTRA_CODIGO = TRM.CRTRA_CODIGO AND SGM.CRSEG_ESTADO
		INNER JOIN SII.CGG_RES_FASE FS ON FS.CRFAS_CODIGO = SGM.CGG_CRFAS_CODIGO AND FS.CRETT_CODIGO = TRM.CRETT_CODIGO
		INNER JOIN SII.CGG_RES_PROCESO PRC ON PRC.CRPRO_CODIGO = FS.CRPRO_CODIGO
		WHERE SGM.CRSEG_ESTADO_ATENCION IN (0,1) AND 
			SGM.CRSEG_TIPO_RESPUESTA = -1 AND 
			TRM.CRETT_CODIGO = TMP_TRAMITES_COMITE AND
			TRM.CRTRA_CODIGO = IN_CRTRA_CODIGO AND
			CRTRA_ESTADO;
	RETURN OUT_CURSOR;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CHECK_PERSONA
* VERIFICA SI UNA PERSONA PERTENECE A ALGUN TIPO DE RESIDENCIA.
* @param IN_CRPER_CODIGO CODIGO DE REGISTRO DE LA PERSONA 
* @param IN_CRTST_CODIGO CODIGO DEL TIPO DE SOLICITUD
* @return OBSERVACIONES
*/
CREATE OR REPLACE FUNCTION SII.F_CHECK_PERSONA(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_CRTST_CODIGO VARCHAR
)RETURNS BOOLEAN AS
$$
DECLARE
TMP_RECORD RECORD;
TMP_SW BOOLEAN;
BEGIN
	IF (LENGTH(IN_CRTST_CODIGO) = 0) THEN
		RETURN TRUE;
	END IF;
	TMP_SW := FALSE;	
	FOR TMP_RECORD IN (SELECT PRS.CRPER_CODIGO FROM SII.CGG_RES_PERSONA PRS 
		INNER JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = PRS.CRPER_CODIGO AND RSD.CRRSD_VIGENTE
		INNER JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = RSD.CRTST_CODIGO AND TST.CRTST_CODIGO = IN_CRTST_CODIGO
		WHERE PRS.CRPER_CODIGO = IN_CRPER_CODIGO) LOOP
		TMP_SW := TRUE;
	END LOOP;
	
	RETURN TMP_SW;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;
