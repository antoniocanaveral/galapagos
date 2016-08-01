ALTER TABLE sii.cgg_res_tramite ADD COLUMN CHANGE_CRTST_CODIGO character varying(20);
COMMENT ON COLUMN sii.cgg_res_tramite.CHANGE_CRTST_CODIGO IS 'MOTIVO PARA CAMBIO';

INSERT INTO sii.cgg_res_tst_opcion(
            crtso_codigo, crtso_nombre, crtso_descripcion, crtso_estado,
            crtso_fecha_insert, crtso_usuario_insert, crtso_fecha_update,
            crtso_usuario_update)
    VALUES ('CRTSO16', 'Tipo.Solicitud.Referencia', 'Cuando es cambio de motivo se habilita el cambio para tipo solicitud de referencia', TRUE,
            CURRENT_TIMESTAMP , 'admin', CURRENT_TIMESTAMP ,
            'admin');
--sii.f_keygen('cgg_res_tst_opcion','crtso_codigo','CRTSO')



CREATE OR REPLACE FUNCTION sii.f_cgg_res_tramite_insert_1(in_crtra_codigo character varying, in_crper_codigo character varying, in_crpjr_codigo character varying,
  in_cgg_crper_codigo character varying, in_crpro_codigo character varying, in_crtst_codigo character varying, in_cvveh_codigo character varying, in_crett_codigo character varying,
  in_cisla_codigo character varying, in_cvmtr_codigo character varying, in_cgg_cvmtr_codigo character varying, in_cgg_cvveh_codigo character varying, in_crtra_anio numeric,
  in_crtra_numero numeric, in_crtra_fecha_recepcion timestamp with time zone, in_crtra_actividad_residencia character varying, in_crtra_observacion text,
  in_crtra_dias_permanencia smallint, in_crtra_pendiente smallint, in_crtra_observacion_pendiente text, in_crtra_atencion_cliente boolean, in_crtra_comunicado_radial character varying,
  in_crtra_motivo character varying, in_crtra_folio numeric, in_crtra_fecha_salida timestamp with time zone, in_crtra_estado boolean, in_crtra_usuario_insert character varying,
  in_crtra_usuario_update character varying, in_rep_crper_codigo character varying, inChange_crtst_codigo character varying)
  RETURNS character varying AS
$BODY$
DECLARE
OUT_KEY VARCHAR;
OUT_NUM NUMERIC;
OUT_RESULT VARCHAR;
BEGIN
	IF (UPPER(IN_CRTRA_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_TRAMITE','CRTRA_CODIGO','CRTRA') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRTRA_CODIGO;
	END IF;

	IF(IN_CRTRA_NUMERO = 0)THEN
		SELECT SII.F_NUMERO('CGG_RES_TRAMITE','CRTRA_NUMERO','CRTRA_ANIO') INTO OUT_NUM;
	ELSE
		OUT_NUM := IN_CRTRA_NUMERO;
	END IF;

	INSERT INTO SII.CGG_RES_TRAMITE(
		CRTRA_CODIGO,
		CRPER_CODIGO,
		CRPJR_CODIGO,
		CGG_CRPER_CODIGO,
		CRPRO_CODIGO,
		CRTST_CODIGO,
		CVVEH_CODIGO,
		CRETT_CODIGO,
		CISLA_CODIGO,
		CVMTR_CODIGO,
		CGG_CVMTR_CODIGO,
		CGG_CVVEH_CODIGO,
		CRTRA_ANIO,
		CRTRA_NUMERO,
		CRTRA_FECHA_RECEPCION,
		CRTRA_ACTIVIDAD_RESIDENCIA,
		CRTRA_OBSERVACION,
		CRTRA_DIAS_PERMANENCIA,
		CRTRA_PENDIENTE,
		CRTRA_OBSERVACION_PENDIENTE,
		CRTRA_ATENCION_CLIENTE,
		CRTRA_COMUNICADO_RADIAL,
		CRTRA_MOTIVO,
		CRTRA_FOLIO,
	    CRTRA_FECHA_SALIDA,
		CRTRA_ESTADO,
		CRTRA_FECHA_INSERT,
		CRTRA_USUARIO_INSERT,
		CRTRA_FECHA_UPDATE,
		CRTRA_USUARIO_UPDATE,
		REP_CRPER_CODIGO,
		CHANGE_CRTST_CODIGO
	) VALUES (
		OUT_KEY,
		IN_CRPER_CODIGO,
		IN_CRPJR_CODIGO,
		IN_CGG_CRPER_CODIGO,
		IN_CRPRO_CODIGO,
		IN_CRTST_CODIGO,
		IN_CVVEH_CODIGO,
		IN_CRETT_CODIGO,
		IN_CISLA_CODIGO,
		IN_CVMTR_CODIGO,
		IN_CGG_CVMTR_CODIGO,
		IN_CGG_CVVEH_CODIGO,
		IN_CRTRA_ANIO,
		OUT_NUM,
		IN_CRTRA_FECHA_RECEPCION,
		IN_CRTRA_ACTIVIDAD_RESIDENCIA,
		IN_CRTRA_OBSERVACION,
		IN_CRTRA_DIAS_PERMANENCIA,
		IN_CRTRA_PENDIENTE,
		IN_CRTRA_OBSERVACION_PENDIENTE,
		IN_CRTRA_ATENCION_CLIENTE,
		IN_CRTRA_COMUNICADO_RADIAL,
		IN_CRTRA_MOTIVO,
		IN_CRTRA_FOLIO,
		IN_CRTRA_FECHA_SALIDA,
		IN_CRTRA_ESTADO,
		CURRENT_TIMESTAMP,
		IN_CRTRA_USUARIO_INSERT,
		CURRENT_TIMESTAMP,
		IN_CRTRA_USUARIO_UPDATE,
		IN_REP_CRPER_CODIGO,
		INCHANGE_CRTST_CODIGO
	);
	OUT_RESULT:=OUT_KEY||','||OUT_NUM;
	RETURN OUT_RESULT;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION sii.f_cgg_res_tramite_update(in_crtra_codigo character varying, in_crper_codigo character varying, in_crpjr_codigo character varying, in_cgg_crper_codigo character varying, in_crpro_codigo character varying,
in_crtst_codigo character varying, in_cvveh_codigo character varying, in_crett_codigo character varying, in_cisla_codigo character varying, in_cvmtr_codigo character varying, in_cgg_cvmtr_codigo character varying,
in_cgg_cvveh_codigo character varying, in_crtra_anio numeric, in_crtra_numero numeric, in_crtra_fecha_recepcion timestamp with time zone, in_crtra_actividad_residencia character varying, in_crtra_observacion text,
in_crtra_dias_permanencia smallint, in_crtra_pendiente smallint, in_crtra_observacion_pendiente text, in_crtra_atencion_cliente boolean, in_crtra_comunicado_radial character varying, in_crtra_motivo character varying,
in_crtra_folio numeric, in_crtra_grupo boolean, in_crtra_orden numeric, in_crtra_fecha_ingreso timestamp with time zone, in_crtra_fecha_salida timestamp with time zone, in_crtra_estado boolean, in_crtra_usuario_update character varying,
in_rep_crper_codigo character varying, inChange_crtst_codigo character varying)
  RETURNS void AS
$BODY$
BEGIN
	UPDATE SII.CGG_RES_TRAMITE SET
		CRPER_CODIGO = IN_CRPER_CODIGO,
		CRPJR_CODIGO = IN_CRPJR_CODIGO,
		CGG_CRPER_CODIGO = IN_CGG_CRPER_CODIGO,
		CRPRO_CODIGO = IN_CRPRO_CODIGO,
		CRTST_CODIGO = IN_CRTST_CODIGO,
		CVVEH_CODIGO = IN_CVVEH_CODIGO,
		CRETT_CODIGO = IN_CRETT_CODIGO,
		CISLA_CODIGO = IN_CISLA_CODIGO,
		CVMTR_CODIGO = IN_CVMTR_CODIGO,
		CGG_CVMTR_CODIGO = IN_CGG_CVMTR_CODIGO,
		CGG_CVVEH_CODIGO = IN_CGG_CVVEH_CODIGO,
		CRTRA_ANIO = IN_CRTRA_ANIO,
		CRTRA_NUMERO = IN_CRTRA_NUMERO,
		CRTRA_FECHA_RECEPCION = IN_CRTRA_FECHA_RECEPCION,
		CRTRA_ACTIVIDAD_RESIDENCIA = IN_CRTRA_ACTIVIDAD_RESIDENCIA,
		CRTRA_OBSERVACION = IN_CRTRA_OBSERVACION,
		CRTRA_DIAS_PERMANENCIA = IN_CRTRA_DIAS_PERMANENCIA,
		CRTRA_PENDIENTE = IN_CRTRA_PENDIENTE,
		CRTRA_OBSERVACION_PENDIENTE = IN_CRTRA_OBSERVACION_PENDIENTE,
		CRTRA_ATENCION_CLIENTE = IN_CRTRA_ATENCION_CLIENTE,
		CRTRA_COMUNICADO_RADIAL = IN_CRTRA_COMUNICADO_RADIAL,
		CRTRA_MOTIVO = IN_CRTRA_MOTIVO,
		CRTRA_FOLIO = IN_CRTRA_FOLIO,
		CRTRA_GRUPO = IN_CRTRA_GRUPO,
		CRTRA_ORDEN = IN_CRTRA_ORDEN,
		CRTRA_FECHA_INGRESO = IN_CRTRA_FECHA_INGRESO,
		CRTRA_FECHA_SALIDA = IN_CRTRA_FECHA_SALIDA,
		CRTRA_ESTADO = IN_CRTRA_ESTADO,
		CRTRA_FECHA_UPDATE = CURRENT_TIMESTAMP,
		CRTRA_USUARIO_UPDATE = IN_CRTRA_USUARIO_UPDATE,
		REP_CRPER_CODIGO = IN_REP_CRPER_CODIGO,
		CHANGE_CRTST_CODIGO = INCHANGE_CRTST_CODIGO
	WHERE
		CRTRA_CODIGO = IN_CRTRA_CODIGO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION f_cgg_res_tramite_select(in_crtra_codigo character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTRA_CODIGO,
		CRPER_CODIGO,
		CRPJR_CODIGO,
		CGG_CRPER_CODIGO,
		CRPRO_CODIGO,
		CRTST_CODIGO,
		CVVEH_CODIGO,
		CRETT_CODIGO,
		CISLA_CODIGO,
		CVMTR_CODIGO,
		CGG_CVMTR_CODIGO,
		CGG_CVVEH_CODIGO,
		CRTRA_ANIO,
		CRTRA_NUMERO,
		CRTRA_FECHA_RECEPCION,
		CRTRA_ACTIVIDAD_RESIDENCIA,
		CRTRA_OBSERVACION,
		CRTRA_DIAS_PERMANENCIA,
		CRTRA_PENDIENTE,
		CRTRA_OBSERVACION_PENDIENTE,
		CRTRA_ATENCION_CLIENTE,
		CRTRA_COMUNICADO_RADIAL,
		CRTRA_MOTIVO,
		CRTRA_FOLIO,
		CRTRA_GRUPO,
		CRTRA_ORDEN,
		CRTRA_FECHA_INGRESO,
		CRTRA_FECHA_SALIDA,
		CRTRA_ESTADO,
		CRTRA_FECHA_INSERT,
		CRTRA_USUARIO_INSERT,
		CRTRA_USUARIO_INSERT,
		CRTRA_FECHA_UPDATE,
		CRTRA_USUARIO_UPDATE,
		REP_CRPER_CODIGO,
		CHANGE_CRTST_CODIGO
	FROM SII.CGG_RES_TRAMITE
	WHERE CRTRA_ESTADO = TRUE AND
		CRTRA_CODIGO = IN_CRTRA_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


----->>>>><<<<<<------

CREATE OR REPLACE FUNCTION f_cgg_res_residencia_generar(in_user_name character varying, in_crtra_codigo character varying, in_crseg_codigo character varying)
  RETURNS character varying AS
$BODY$
DECLARE
TMP_CRTST_CODIGO VARCHAR;
TMP_PERMANENTE VARCHAR;
TMP_TEMPORAL VARCHAR;
TMP_TRANSEUNTE VARCHAR;
TMP_IS_PERMANENTE BOOLEAN;
TMP_IS_TEMPORAL BOOLEAN;
TMP_IS_TRANSEUNTE BOOLEAN;
--FECHA DE INGRESO
TMP_CRTRA_FECHA_INGRESO TIMESTAMP WITH TIME ZONE;
--CODIGO DE RESIDENCIA
TMP_CRRSD_CODIGO VARCHAR;
--CODIGO DE LA NUEVA RESIDENCIA
TMP_NEW_CRRSD_CODIGO VARCHAR;
--FECHA DE CADUCIDAD DE LA RESIDENCIA
TMP_CRRSD_FECHA_CADUCIDAD TIMESTAMP WITH TIME ZONE;
--CODIGO DEL AUSPICIANTE DEL TRAMITE
TMP_CRPER_CODIGO VARCHAR;
--MODALIDAD DE LA RESIDENCIA ACTUAL
TMP_CRRSD_MODALIDAD INT;
--NUMERO DE RESIDENCIA ACTUAL
TMP_CRRSD_NUMERO INT;
--CODIGO DEL BENEFICIARIO DEL TRAMITE
TMP_CGG_CRPER_CODIGO VARCHAR;
--DIAS DE AUTORIZACION DE PERMANENCIA DENTRO DE LA PROVINCIA
TMP_DIAS_AUTORIZADOS INT;
--FECHA DE CADUCIDAD DE LA AUTORIZACION DE PERMANENCIA DENTRO DE LA PROVINCIA
TMP_FECHA_CADUCIDAD TIMESTAMP WITH TIME ZONE;
--CODIGO DE LA RESOLUCION ASOCIADA AL TRAMITE
TMP_CRRES_CODIGO VARCHAR;
--ESTADO DE LA RESOLUCION ASOCIADA AL TRAMITE
TMP_CRRES_ESTADO_RESOLUCION INT;
--BUFFER PARA ALMANCENAR EL CODIGO ASIGNADO EN LA INSERCION DE UN NUEVO REGISTRO.
TMP_CODIGO VARCHAR;
--FECHA DE APROBACION DE LA RESOLUCION
TMP_CRRES_FECHA_EMISION TIMESTAMP WITH TIME ZONE;
--NUMERO DE RESIDENCIA MAXIMO
TMP_MAX_RESIDENCIA INT;
--INDICE DE LA ISLA DONDE SE PRESENTO EL TRAMITE
TMP_CISLA_INDICE INT;
--INDICE PARA TIPO DE SOLICITUD PERMANENTE
TMP_INDICE_PERM INT;
--INDICE DEL TIPO DE RESIDENCIA
TMP_INDICE INT;
--INDICE PARA TIPO DE SOLICITUD TEMPORAL
TMP_INDICE_TEMP INT;
--MODALIDAD DE LA RESIDENCIA PERMANENTE O TEMPORAL
TMP_MODALIDAD INT;
--REGISTRO DE TABLA DE SEGUIMIENTO
TMP_RSGM RECORD;
--ESTADO DEL TRAMITE
TMP_CRETT_CODIGO VARCHAR;
--SI EL TIPO DE SOLICITUD DEBE GENERAR TRANSEUNTE TEMPORAL
TMP_APLICA_OTRO BOOLEAN;
--OBTIENE EL ESTADO DE TRAMITE PARA CUANDO ESTA LISTO PARA TRATARSE EN COMITE
TMP_ESTADO_COMITE VARCHAR;
--SI LA RESIDENCIA TIENE UN TRAMITE PENDIENTE
TMP_CRRSD_TRAMITE_PENDIENTE BOOLEAN;
--REGISTRO DE FASE QUE ESTA CUMPLIENDO EL SEGUIMIENTO
TMP_RFS RECORD;
--ISLA DE PRESENTACION
TMP_CISLA_CODIGO VARCHAR;
--ISLA DE LA OBTENCION DE LA RESIDENCIA
TMP_RSD_ISLA VARCHAR;
--CODIGO DE LA TABLA RESOL_TRAMITE
TMP_CRRST_CODIGO VARCHAR;
BEGIN
TMP_CRRSD_TRAMITE_PENDIENTE := FALSE;

--OBTIENE EL REGISTRO DEL TABLA SEGUIMIENTO
SELECT * INTO TMP_RSGM
FROM SII.CGG_RES_SEGUIMIENTO
WHERE CRSEG_CODIGO = IN_CRSEG_CODIGO AND
CRTRA_CODIGO = IN_CRTRA_CODIGO;

--OBTIENE LA FASE QUE ESTA CUMPLIENDO EL SEGUIMIENTO
SELECT * INTO TMP_RFS
FROM SII.CGG_RES_FASE
WHERE CRFAS_CODIGO = TMP_RSGM.CRFAS_CODIGO;

--OBTIENE EL TIPO DE SOLICITUD DEL TRAMITE
SELECT TST.CRRES_CODIGO,
TST.CRTST_CODIGO,
TRM.CRPER_CODIGO,
TRM.CGG_CRPER_CODIGO,
TRM.CRTRA_DIAS_PERMANENCIA,
TRM.CRTRA_FECHA_INGRESO,
TRM.CRTRA_FECHA_SALIDA,
SL.CISLA_INDICE,
TRM.CRETT_CODIGO,
TST.CRTST_APLICA_OTRO,
TRM.CISLA_CODIGO
INTO TMP_CRRES_CODIGO,
TMP_CRTST_CODIGO,
TMP_CRPER_CODIGO,
TMP_CGG_CRPER_CODIGO,
TMP_DIAS_AUTORIZADOS,
TMP_CRTRA_FECHA_INGRESO,
TMP_FECHA_CADUCIDAD,
TMP_CISLA_INDICE,
TMP_CRETT_CODIGO,
TMP_APLICA_OTRO,
TMP_CISLA_CODIGO
FROM SII.CGG_RES_TRAMITE TRM
INNER JOIN SII.CGG_ISLA SL ON SL.CISLA_CODIGO = TRM.CISLA_CODIGO AND SL.CISLA_ESTADO
INNER JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = case when TRM.CHANGE_CRTST_CODIGO is null then TRM.CRTST_CODIGO else TRM.CHANGE_CRTST_CODIGO end AND TST.CRTST_ESTADO
WHERE TRM.CRTRA_CODIGO = IN_CRTRA_CODIGO;

SELECT CRRST_CODIGO INTO TMP_CRRST_CODIGO
FROM SII.CGG_RES_RESOL_TRAMITE
WHERE CRTRA_CODIGO = IN_CRTRA_CODIGO AND
CRRST_ESTADO;

IF (TMP_CRRES_CODIGO IS NOT NULL AND TMP_CRRST_CODIGO IS NULL) THEN
SELECT SII.F_CGG_RES_RESOL_TRAMITE_INSERT(
'KEYGEN'::VARCHAR,
TMP_CRRES_CODIGO,
IN_CRTRA_CODIGO,
TRUE,
IN_USER_NAME
) INTO TMP_CODIGO;
END IF;

--OBTIENE INFORMACION DE LA RESOLUCION ASOCIADA AL TRAMITE
SELECT RSL.CRRES_CODIGO,
RSL.CRRES_ESTADO_RESOLUCION,
RSL.CRRES_FECHA_EMISION
INTO TMP_CRRES_CODIGO,
TMP_CRRES_ESTADO_RESOLUCION,
TMP_CRRES_FECHA_EMISION
FROM SII.CGG_RES_RESOL_TRAMITE RST
INNER JOIN SII.CGG_RES_RESOLUCION RSL ON RSL.CRRES_CODIGO = RST.CRRES_CODIGO AND RSL.CRRES_ESTADO
WHERE RST.CRTRA_CODIGO = IN_CRTRA_CODIGO AND
RST.CRRST_ESTADO;

--SI LA RESIDENCIA SE APRUEBA CON RESOLUCION ANTERIOR, SE ESCOGE LA FECHA DE APROBACION DEL SEGUIMIENTO
IF (TMP_CODIGO IS NOT NULL OR TMP_CRRES_CODIGO IS NULL) THEN
SELECT CRSEG_FECHA_DESPACHO INTO TMP_CRRES_FECHA_EMISION
FROM SII.CGG_RES_SEGUIMIENTO SGM
WHERE SGM.CRTRA_CODIGO = IN_CRTRA_CODIGO AND
SGM.CRSEG_ESTADO
ORDER BY CRSEG_FECHA_DESPACHO DESC
LIMIT 1;
END IF;

--OBTIENE EL TIPO DE SOLICITUD PADRE PARA RESIDENCIA PERMANENTE
SELECT CGCNF_VALOR_CADENA INTO TMP_PERMANENTE
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '03';
--OBTIENE EL INDICE DEL TIPO DE SOLICITUD DE TRAMITE PARA PERMANENTES
SELECT CRTST_INDICE INTO TMP_INDICE_PERM
FROM SII.CGG_RES_TIPO_SOLICITUD_TRAMITE
WHERE CRTST_CODIGO = TMP_PERMANENTE;

--OBTIENE EL TIPO DE SOLICITUD PADRE PARA RESIDENCIA TEMPORAL
SELECT CGCNF_VALOR_CADENA INTO TMP_TEMPORAL
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '04';
--OBTIENE EL INDICE DEL TIPO DE SOLICITUD DE TRAMITE PARA TEMPORALES
SELECT CRTST_INDICE INTO TMP_INDICE_TEMP
FROM SII.CGG_RES_TIPO_SOLICITUD_TRAMITE
WHERE CRTST_CODIGO = TMP_TEMPORAL;

--OBTIENE EL TIPO DE SOLICITUD PADRE PARA TRANSEUNTES
SELECT CGCNF_VALOR_CADENA INTO TMP_TRANSEUNTE
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '05';

--VERIFICA SI EL TIPO DE SOLICITUD DEL TRAMITE ES PARA RESIDENCIA PERMANENTE O TEMPORAL
TMP_IS_PERMANENTE := SII.F_PARENT_OF(TMP_PERMANENTE, TMP_CRTST_CODIGO);
TMP_IS_TEMPORAL := SII.F_PARENT_OF(TMP_TEMPORAL, TMP_CRTST_CODIGO);
TMP_IS_TRANSEUNTE := SII.F_PARENT_OF(TMP_TRANSEUNTE, TMP_CRTST_CODIGO);

--OBTIENE EL ESTADO DE TRAMITE QUE INDICA QUE EL TRAMITE ESTA LISTO PARA TRATARSE EN COMITE
SELECT CGCNF_VALOR_CADENA INTO TMP_ESTADO_COMITE
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '01';

IF (TMP_IS_TEMPORAL AND TMP_APLICA_OTRO AND (TMP_RFS.CRETT_CODIGO = TMP_ESTADO_COMITE OR TMP_RFS.CGG_CRETT_CODIGO = TMP_ESTADO_COMITE)) THEN
TMP_IS_TEMPORAL = FALSE;
TMP_IS_TRANSEUNTE = TRUE;
TMP_CRTST_CODIGO := TMP_TRANSEUNTE;
TMP_CRRSD_TRAMITE_PENDIENTE := TRUE;
END IF;

IF(NOT TMP_IS_PERMANENTE AND NOT TMP_IS_TEMPORAL AND NOT TMP_IS_TRANSEUNTE) THEN
RETURN 'El tramite indicado no genera residencia para el beneficiario.';
END IF;

IF(TMP_IS_PERMANENTE)THEN
TMP_MODALIDAD := 0;
TMP_CRRSD_FECHA_CADUCIDAD := NULL;
TMP_INDICE := TMP_INDICE_PERM;
ELSIF(TMP_IS_TEMPORAL OR TMP_IS_TRANSEUNTE)THEN
TMP_MODALIDAD := 1;
TMP_INDICE := TMP_INDICE_TEMP;
IF(TMP_DIAS_AUTORIZADOS <= 0 )THEN
TMP_CRRSD_FECHA_CADUCIDAD := TMP_FECHA_CADUCIDAD::DATE;
ELSE
TMP_CRRSD_FECHA_CADUCIDAD := TMP_CRRES_FECHA_EMISION::DATE + TMP_DIAS_AUTORIZADOS;
END IF;
TMP_CRRSD_FECHA_CADUCIDAD := TMP_CRRSD_FECHA_CADUCIDAD + interval '23:59:00';
END IF;

--OBTIENE EL NUMERO DE RESIDENCIA MAXIMO DE ENTRE TODAS LAS RESIDENCIAS DE ACUERDO A LA MODALIDAD
SELECT MAX(CRRSD_NUMERO) INTO TMP_MAX_RESIDENCIA
FROM SII.CGG_RES_RESIDENCIA RSD
WHERE CRRSD_MODALIDAD = TMP_MODALIDAD AND
CISLA_CODIGO = TMP_CISLA_CODIGO AND
CRRSD_ESTADO;

IF (TMP_MAX_RESIDENCIA IS NULL) THEN
TMP_MAX_RESIDENCIA := 0;
END IF;

IF (NOT TMP_IS_TRANSEUNTE) THEN
TMP_MAX_RESIDENCIA := (TMP_MAX_RESIDENCIA + 1);
ELSE
TMP_CRRES_FECHA_EMISION := TMP_CRTRA_FECHA_INGRESO::DATE;
TMP_MAX_RESIDENCIA := NULL;
END IF;

--SELECCIONA LA RESIDENCIA DE LA PERSONA QUE HAYA SIDO DE LA MISMA MODALIDAD DE LA NUEVA RESIDENCIA
SELECT CRRSD_CODIGO, CRRSD_MODALIDAD
INTO TMP_CRRSD_CODIGO, TMP_CRRSD_MODALIDAD
FROM SII.CGG_RES_RESIDENCIA
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO AND
CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
FROM CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '03') OR CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
FROM CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '04'))
UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
) SELECT CRTST_CODIGO  FROM TIPO) AND
CRRSD_ESTADO
ORDER BY CRRSD_FECHA_INICIO DESC LIMIT 1;
IF (TMP_CRRSD_CODIGO IS NOT NULL AND NOT TMP_IS_TRANSEUNTE) THEN
IF(TMP_CRRSD_MODALIDAD = TMP_MODALIDAD)THEN
SELECT CRRSD_NUMERO, CISLA_CODIGO INTO TMP_CRRSD_NUMERO, TMP_RSD_ISLA
FROM SII.CGG_RES_RESIDENCIA
WHERE CRRSD_CODIGO = TMP_CRRSD_CODIGO;
IF(TMP_CRRSD_NUMERO IS NOT NULL)THEN
TMP_MAX_RESIDENCIA := TMP_CRRSD_NUMERO;
TMP_CISLA_CODIGO := TMP_RSD_ISLA;
SELECT CISLA_INDICE INTO TMP_CISLA_INDICE FROM SII.CGG_ISLA WHERE CISLA_CODIGO = TMP_CISLA_CODIGO;
END IF;
END IF;
END IF;

--SELECCIONA LA RESIDENCIA VIGENTE DEL BENEFICIARIO PARA CERRAR
SELECT CRRSD_CODIGO INTO TMP_CRRSD_CODIGO
FROM SII.CGG_RES_RESIDENCIA
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO AND
CRRSD_VIGENTE AND
CRRSD_ESTADO;
IF (TMP_CRRSD_CODIGO IS NOT NULL AND CURRENT_DATE::DATE >= TMP_CRRES_FECHA_EMISION::DATE) THEN
UPDATE SII.CGG_RES_RESIDENCIA SET CRRSD_VIGENTE = FALSE,
--CRRSD_FECHA_CADUCIDAD = TMP_CRRES_FECHA_EMISION - interval '00:01:00',
CRRSD_USUARIO_UPDATE = IN_USER_NAME,
CRRSD_FECHA_UPDATE = CURRENT_TIMESTAMP
WHERE CRRSD_CODIGO = TMP_CRRSD_CODIGO;
END IF;

--CREACION DE LA RESIDENCIA
SELECT SII.F_CGG_RES_RESIDENCIA_INSERT(
'KEYGEN'::VARCHAR,
TMP_CGG_CRPER_CODIGO,
TMP_CRTST_CODIGO,
IN_CRTRA_CODIGO,
NULL::VARCHAR,
TMP_MAX_RESIDENCIA::INTEGER,
TMP_MODALIDAD::SMALLINT,
TMP_CRRES_FECHA_EMISION::TIMESTAMP WITH TIME ZONE,
TMP_CRRSD_FECHA_CADUCIDAD::TIMESTAMP WITH TIME ZONE,
FALSE,
NULL::TIMESTAMP WITH TIME ZONE,
NULL::VARCHAR,
(TMP_CRRSD_CODIGO IS NULL OR CURRENT_DATE::DATE >= COALESCE(TMP_CRRES_FECHA_EMISION::DATE, CURRENT_DATE + 1) ), --VIGENTE
TMP_CRRSD_TRAMITE_PENDIENTE,
TRUE,
IN_USER_NAME
)INTO TMP_NEW_CRRSD_CODIGO;

--ACTUALIZACION DE LA ISLA DE LA RESIDENCIA
UPDATE SII.CGG_RES_RESIDENCIA SET CISLA_CODIGO = TMP_CISLA_CODIGO
WHERE CRRSD_CODIGO = TMP_NEW_CRRSD_CODIGO;

--ACTUALIZACION DEL NUMERO DE RESIDENCIA DE LA PERSONA
IF (NOT TMP_IS_TRANSEUNTE) THEN
UPDATE SII.CGG_RES_PERSONA SET
CRPER_NUMERO_RESIDENCIA = TMP_CISLA_INDICE::VARCHAR||TMP_INDICE::VARCHAR||LPAD(TMP_MAX_RESIDENCIA::VARCHAR,5,'0'),
CRPER_USUARIO_UPDATE = IN_USER_NAME,
CRPER_FECHA_UPDATE = CURRENT_TIMESTAMP
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO;
UPDATE SII.CGG_RES_RESIDENCIA SET
CRRSD_NUMERO_RESIDENCIA = TMP_CISLA_INDICE::VARCHAR||TMP_INDICE::VARCHAR||LPAD(TMP_MAX_RESIDENCIA::VARCHAR,5,'0'),
CRRSD_USUARIO_UPDATE = IN_USER_NAME,
CRRSD_FECHA_UPDATE = CURRENT_TIMESTAMP
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO AND CRRSD_CODIGO = TMP_NEW_CRRSD_CODIGO;
END IF;

--CREA UN NUEVO USUARIO PARA EL RESIDENTE PERMANENTE
IF (TMP_IS_PERMANENTE) THEN
SELECT SII.F_CGG_RES_RESIDENCIA_USUARIO(IN_USER_NAME,TMP_CGG_CRPER_CODIGO,IN_CRTRA_CODIGO) INTO TMP_CODIGO;
END IF;


--CREA LOS REGISTRO DE SOPORTE SI LA PERSONA ESTA DENTRO DE LA PROVINCIA Y CAMBIA DE RESIDENCIA
IF (CURRENT_DATE::DATE >= TMP_CRRES_FECHA_EMISION::DATE) THEN
SELECT SII.F_CREAR_REGISTROS_SOPORTE(IN_USER_NAME,
TMP_CGG_CRPER_CODIGO,
TMP_NEW_CRRSD_CODIGO,
TMP_CRRES_FECHA_EMISION,
TMP_CRRSD_FECHA_CADUCIDAD,
IN_CRTRA_CODIGO
) INTO TMP_CODIGO;
END IF;
RETURN 'TRUE';
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','CAMBIO DE MOTIVO','Parametros y Modificaciones para cambio de motivo',
	'2.0','2016_07_29_TipoSolicitud_Cambio.sql',true);