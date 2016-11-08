CREATE OR REPLACE FUNCTION f_cgg_tct_registro_select(
    in_user_name character varying,
    in_start_index integer,
    in_limit integer,
    in_sort_field_name character varying,
    in_direction character varying,
    in_find_text text,
    in_operational boolean)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
	TMP_TIPO_USUARIO BOOLEAN;
	TMP_DATOS CHARACTER VARYING;
	TMP_TIME_ZONE VARCHAR;
	TMP_QUERY VARCHAR;
BEGIN
	SELECT CSSSN_ZONA_TIEMPO INTO TMP_TIME_ZONE
	FROM SII.CGG_SEC_SESION
	WHERE CUSU_CODIGO = (SELECT CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME AND CUSU_ESTADO) AND
		CSSSN_ACTIVO
	ORDER BY CSSSN_FECHA_INICIO DESC LIMIT 1;

	IF (TMP_TIME_ZONE IS NULL OR LENGTH(TMP_TIME_ZONE) = 0) THEN
		SELECT ABS(EXTRACT(TIMEZONE FROM CURRENT_TIMESTAMP)/3600) INTO TMP_TIME_ZONE;
	END IF;

	IF (LENGTH(IN_FIND_TEXT) > 0) THEN
		TMP_QUERY = ' to_tsvector(
		COALESCE(GTR.CTGTR_NUMERO::VARCHAR,'''')||'' ''||
		COALESCE(PJR.CRPJR_RAZON_SOCIAL,'''')||'' ''||
		COALESCE(CRPER_NUM_DOC_IDENTIFIC,'''')||'' ''||
		COALESCE(CRPER.CRPER_NOMBRES,'''')||'' ''||
		COALESCE(CRPER.CRPER_APELLIDO_PATERNO, '''')||'' ''||
		COALESCE(CRPER.CRPER_APELLIDO_MATERNO, '''')) @@ plainto_tsquery('||QUOTE_LITERAL(IN_FIND_TEXT)||') AND';
	END IF;
	IF (TMP_QUERY IS NULL) THEN
		TMP_QUERY = '';
	END IF;
	SELECT CUSU_USUARIO_INTERNO INTO TMP_TIPO_USUARIO
	FROM SII.CGG_USUARIO
	WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME;
	TMP_DATOS:='SELECT
		RS.CTREG_CODIGO,
		RS.CARPT_CODIGO,
		ARO.CARPT_NOMBRE AEROPUER_ORIGEN,
		RS.CGG_CARPT_CODIGO,
		ARD.CARPT_NOMBRE AEROPUER_DESTINO,
		RS.CRALN_CODIGO,
		AL.CRALN_NOMBRE AEROLINEA,
		RS.CTREG_NUMERO_VUELO,
		RS.CTGTR_CODIGO,
		RS.CRTRA_CODIGO,
		(SELECT CRTRA_NUMERO FROM SII.CGG_RES_TRAMITE TA WHERE TA.CRTRA_CODIGO = RSD.CRTRA_CODIGO) NUMERO,
		RS.CTREG_NUMERO,
		GTR.CTGTR_NUMERO,
		RS.CTREG_FECHA_PREREGISTRO,
		RS.CTREG_FECHA_INGRESO,
		RS.CTREG_CODIGO_BARRAS,
		RS.CTREG_FECHA_SALIDA,
		CASE WHEN CTREG_ESTADO_REGISTRO != 1 THEN NULL ELSE RS.CTREG_IMPRESION_ESPECIE AT TIME ZONE '||QUOTE_LITERAL('UTC+'||TMP_TIME_ZONE)||' END CTREG_IMPRESION_ESPECIE,
		RS.CTREG_ESTADO_REGISTRO,
		RS.CTREG_OBSERVACION,
		RS.CTREG_ESTADO,
		(PJR.CRPJR_RAZON_SOCIAL||'' - ''||US.CUSU_NOMBRE_USUARIO) CTAGV_NOMBRE,
		CRPER.CRPER_NUM_DOC_IDENTIFIC,
		COALESCE(CRPER.CRPER_NOMBRES,'''')||'' ''||COALESCE(CRPER.CRPER_APELLIDO_PATERNO,'''')||COALESCE('' ''||CRPER.CRPER_APELLIDO_MATERNO,'''') AS CRPER_NOMBRES,
		CRPER.CRPER_FECHA_NACIMIENTO,
		(SELECT CPAIS_NOMBRE FROM SII.CGG_PAIS PAIS WHERE PAIS.CPAIS_CODIGO = CRPER.CGNCN_CODIGO) CGNCN_CODIGO,
		(SELECT CPAIS_NOMBRE FROM SII.CGG_PAIS PAIS WHERE PAIS.CPAIS_CODIGO = CRPER.CGG_CPAIS_CODIGO) CGG_CPAIS_CODIGO,
		RS.CTREG_FECHA_INSERT,
		RS.CTREG_USUARIO_INSERT,
		RS.CTREG_FECHA_UPDATE,
		RS.CTREG_USUARIO_UPDATE,
		(SELECT COALESCE(CRPER_NOMBRES,'''')||'' ''||COALESCE(CRPER_APELLIDO_PATERNO,'''') FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = US.CRPER_CODIGO) USUARIO_UPDATE,
		RS.CTREG_NUMERO_VUELO
	FROM SII.CGG_TCT_REGISTRO RS
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GTR ON GTR.CTGTR_CODIGO = RS.CTGTR_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARO ON ARO.CARPT_CODIGO = RS.CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARD ON ARD.CARPT_CODIGO = RS.CGG_CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROLINEA AL ON AL.CRALN_CODIGO = RS.CRALN_CODIGO
	INNER JOIN SII.CGG_RES_PERSONA CRPER ON (RS.CRPER_CODIGO = CRPER.CRPER_CODIGO)
	LEFT JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = CRPER.CRPER_CODIGO AND RSD.CRRSD_ESTADO AND RSD.CRRSD_VIGENTE AND RSD.CRRSD_FECHA_INICIO::DATE = RS.CTREG_FECHA_INGRESO::DATE AND
			RSD.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = ''05'')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO)
	LEFT JOIN SII.CGG_USUARIO US ON US.CUSU_CODIGO = RS.CUSU_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA_JURIDICA PJR ON PJR.CRPJR_CODIGO = US.CRPJR_CODIGO
	WHERE CTREG_ESTADO AND RS.CTREG_ESTADO_REGISTRO IN '||CASE WHEN in_operational THEN '(0)' ELSE '(0,1)' END ||' AND '
		||TMP_QUERY||'
		NOT RS.CTREG_COMPLETO AND
		('||TMP_TIPO_USUARIO||' OR US.CUSU_CODIGO IN (SELECT CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CRPJR_CODIGO IN (SELECT CRPJR_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = '||QUOTE_LITERAL(IN_USER_NAME)||')))
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX ;

	OPEN TMP_REF FOR EXECUTE TMP_DATOS;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;



  CREATE OR REPLACE FUNCTION f_cgg_tct_registro_persona_insert(
    in_crper_codigo character varying,
    in_crdid_codigo character varying,
    in_cgncn_codigo character varying,
    in_crper_nombres character varying,
    in_crper_apellido_paterno character varying,
    in_crper_apellido_materno character varying,
    in_crper_num_doc_identific character varying,
    in_crper_fecha_nacimiento timestamp with time zone,
    in_crper_genero smallint,
    in_cgg_cpais_codigo character varying,
    in_crper_estado boolean,
    in_crper_usuario_insert character varying,
    in_crper_usuario_update character varying,
    in_crper_seguimiento boolean)
  RETURNS character varying AS
$BODY$
DECLARE
TMP_RECORD RECORD;
OUT_KEY VARCHAR;
TMP_CODIGO VARCHAR;
BEGIN
	SELECT CRPER_CODIGO INTO TMP_CODIGO FROM SII.CGG_RES_PERSONA WHERE CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC;
	IF (UPPER(IN_CRPER_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_PERSONA','CRPER_CODIGO','CRPER') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRPER_CODIGO;
	END IF;
	IF (TMP_CODIGO IS NULL ) THEN
		INSERT INTO SII.CGG_RES_PERSONA(
			CRPER_CODIGO,
			CRDID_CODIGO,
			CGNCN_CODIGO,
			CRPER_NOMBRES,
			CRPER_APELLIDO_PATERNO,
			CRPER_APELLIDO_MATERNO,
			CRPER_NUM_DOC_IDENTIFIC,
			CRPER_FECHA_NACIMIENTO,
			CRPER_GENERO,
			CGG_CPAIS_CODIGO,
			CRPER_ESTADO,
			CRPER_FECHA_INSERT,
			CRPER_USUARIO_INSERT,
			CRPER_FECHA_UPDATE,
			CRPER_USUARIO_UPDATE,
			CRPER_SEGUIMIENTO
		) VALUES (
			OUT_KEY,
			IN_CRDID_CODIGO,
			IN_CGNCN_CODIGO,
			IN_CRPER_NOMBRES,
			IN_CRPER_APELLIDO_PATERNO,
			IN_CRPER_APELLIDO_MATERNO,
			UPPER(TRIM(IN_CRPER_NUM_DOC_IDENTIFIC)),
			IN_CRPER_FECHA_NACIMIENTO,
			IN_CRPER_GENERO,
			IN_CGG_CPAIS_CODIGO,
			IN_CRPER_ESTADO,
			CURRENT_TIMESTAMP,
			IN_CRPER_USUARIO_INSERT,
			CURRENT_TIMESTAMP,
			IN_CRPER_USUARIO_UPDATE,
			IN_CRPER_SEGUIMIENTO
		);
		FOR TMP_RECORD IN (SELECT
			CRPER_CODIGO,
			CRPER_NOMBRES,
			CRPER_APELLIDO_PATERNO,
			CRPER_APELLIDO_MATERNO,
			CRPER_NUM_DOC_IDENTIFIC,
			CRPER_FECHA_NACIMIENTO,
			CRPER_LUGAR_NACIMIENTO,
			CRPER_OBSERVACIONES,
			CRPER_NUMERO_RESIDENCIA,
			CRPER_NUMERO_EXPEDIENTE,
			CRPER_FECHA_ARCHIVO,
			CRPER_FECHA_ULTIMO_EMPLEO,
			CRPER_ASPIRACION_SALARIAL,
			CRPER_FECHA_DEFUNCION,
			CRPER_NUMERO_ACTA
			FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = OUT_KEY ) LOOP
			UPDATE SII.CGG_RES_PERSONA SET CRPER_INDEX = TO_TSVECTOR(TMP_RECORD::VARCHAR)
				WHERE CRPER_CODIGO = TMP_RECORD.CRPER_CODIGO;
		END LOOP;
	ELSE
		OUT_KEY := TMP_CODIGO;
	END IF;
	RETURN OUT_KEY;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;




  CREATE OR REPLACE FUNCTION f_cgg_tct_registro_persona(
    in_ctgtr_codigo character varying,
    in_ctreg_estado_registro character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		),
	RESIDENCIA AS(
		SELECT RG.CRPER_CODIGO,RS.CRTRA_CODIGO,RS.CRTST_CODIGO FROM  SII.CGG_TCT_REGISTRO RG
		LEFT JOIN SII.CGG_RES_RESIDENCIA RS ON (RS.CRPER_CODIGO = RG.CRPER_CODIGO AND RS.CRRSD_VIGENTE AND RS.CRRSD_FECHA_INICIO::DATE = RG.CTREG_FECHA_INGRESO::DATE)
		AND RS.CRTST_CODIGO IN (SELECT CRTST_CODIGO  FROM TIPO)
		WHERE CTGTR_CODIGO = IN_CTGTR_CODIGO)
	SELECT DISTINCT
		RG.CTREG_CODIGO,
		GT.CTGTR_CODIGO,
		LPAD(GT.CTGTR_NUMERO::VARCHAR,7,'0'::VARCHAR) CTGTR_NUMERO,
		PR.CRPER_CODIGO,
		PR.CRDID_CODIGO,
		PR.CRPER_NUM_DOC_IDENTIFIC,
		PR.CRPER_NOMBRES,
		PR.CRPER_APELLIDO_PATERNO,
		PR.CRPER_APELLIDO_MATERNO,
		PR.CRPER_GENERO,
		PR.CGNCN_CODIGO,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CGG_CPAIS_CODIGO,
		--VDT.CKESP_CODIGO,
		--CKESP_REPORTE,
		RG.CTREG_ESTADO_REGISTRO,
		RG.CTREG_OBSERVACION,
		TR.CRTRA_CODIGO,
		TR.CRTRA_NUMERO,
		PR.CRPER_SEGUIMIENTO,
		(CASE WHEN RS.CRTST_CODIGO IS NULL THEN 'Turista' ELSE 'Transeunte' END)TIPO_RESIDENCIA,
		RG.CTREG_FECHA_INSERT
	FROM  SII.CGG_TCT_REGISTRO RG
	INNER JOIN SII.CGG_RES_PERSONA PR ON PR.CRPER_CODIGO = RG.CRPER_CODIGO
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GT ON (GT.CTGTR_CODIGO = RG.CTGTR_CODIGO)
	--INNER JOIN SII.CGG_KDX_VENTA_DETALLE VDT ON (VDT.CTREG_CODIGO = RG.CTREG_CODIGO)
	--INNER JOIN SII.CGG_KDX_ESPECIE CKESP ON (CKESP.CKESP_CODIGO = VDT.CKESP_CODIGO)
	INNER JOIN RESIDENCIA RS ON (RS.CRPER_CODIGO = RG.CRPER_CODIGO)
	LEFT JOIN SII.CGG_RES_TRAMITE TR ON (TR.CRTRA_CODIGO=RS.CRTRA_CODIGO)
	WHERE RG.CTREG_ESTADO AND
		GT.CTGTR_CODIGO = IN_CTGTR_CODIGO AND
		CTREG_ESTADO_REGISTRO = ANY(STRING_TO_ARRAY(IN_CTREG_ESTADO_REGISTRO,',')::smallint[])
		AND NOT RG.CTREG_COMPLETO
	ORDER BY RG.CTREG_FECHA_INSERT;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;