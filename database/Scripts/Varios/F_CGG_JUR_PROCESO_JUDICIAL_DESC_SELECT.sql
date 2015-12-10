/**
* FUNCION SII.F_CGG_JUR_PROCESO_JUDICIAL_DESC_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_JUR_PROCESO_JUDICIAL.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_PROCESO_JUDICIAL_DESC_SELECT(
IN IN_USER_NAME VARCHAR,
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		PJ.CJPJU_CODIGO, 
		PJ.CCTN_CODIGO, 
		(SELECT CCTN_NOMBRE FROM CGG_CANTON CT WHERE (CT.CCTN_CODIGO = PJ.CCTN_CODIGO)) CANTON,		
		PJ.CRPJR_CODIGO, 
		(SELECT CRPJR_RAZON_SOCIAL FROM CGG_RES_PERSONA_JURIDICA PJA WHERE (PJA.CRPJR_CODIGO = PJ.CRPJR_CODIGO)) RAZON_SOCIAL,		
		PJ.CRPER_CODIGO, 
		(SELECT CRPER_NOMBRES||'' ''||CRPER_APELLIDO_PATERNO||'' ''||CRPER_APELLIDO_MATERNO FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = PJ.CRPER_CODIGO) PERSONA,
		PJ.CJPJU_NUMERO, 
		PJ.CJPJU_TIPO_PROCESO, 
		PJ.CJPJU_TIPO_ADVERSARIO, 
		PJ.CJPJU_FECHA_INICIO, 
		PJ.CJPJU_FECHA_FINALIZACION, 
		PJ.CJPJU_ESTADO_EJECUCION, 	
		PJ.CJPJU_ESTADO, 
		PJ.CJPJU_FECHA_INSERT, 
		PJ.CJPJU_USUARIO_INSERT, 
		PJ.CJPJU_FECHA_UPDATE, 
		PJ.CJPJU_USUARIO_UPDATE
	FROM SII.CGG_JUR_PROCESO_JUDICIAL PJ
	INNER JOIN CGG_JUR_ASESOR ASR ON (ASR.CJPJU_CODIGO=PJ.CJPJU_CODIGO)	
	WHERE CJPJU_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CJPJU_NUMERO, '''')||'' ''||COALESCE(CJPJU_TIPO_PROCESO, 0)||'' ''||COALESCE(CJPJU_TIPO_ADVERSARIO, 0)||'' ''||COALESCE(CJPJU_FECHA_INICIO, CURRENT_TIMESTAMP)||'' ''||COALESCE(CJPJU_FECHA_FINALIZACION, CURRENT_TIMESTAMP)||'' ''||COALESCE(CJPJU_ESTADO_EJECUCION, 0)||'' ''||COALESCE(CJPJU_OBSERVACION, '''')||'' ''||COALESCE(CJPJU_ESTADO, FALSE)||'' ''||COALESCE(CJPJU_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CJPJU_USUARIO_INSERT, '''')||'' ''||COALESCE(CJPJU_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CJPJU_USUARIO_UPDATE, '''')) = 1
	AND PJ.CJPJU_ESTADO_EJECUCION = 1
	AND CJASE_ACTIVO=1
	AND ASR.CUSU_CODIGO IN (SELECT USR.CUSU_CODIGO
							FROM CGG_USUARIO USR							
							WHERE USR.CUSU_NOMBRE_USUARIO='''||IN_USER_NAME||'''
							AND USR.CUSU_ACTIVO= TRUE
							UNION 
							SELECT ST.CUSU_CODIGO
							FROM CGG_SUSTITUCION ST
							LEFT JOIN CGG_USUARIO US ON (US.CUSU_CODIGO = ST.CGG_CUSU_CODIGO)
							WHERE  CSUST_ESTADO_ENCARGO = TRUE
							AND CUSU_NOMBRE_USUARIO='''||IN_USER_NAME||''')
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_PROCESO_JUDICIAL_DESC_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_JUR_PROCESO_JUDICIAL.
* @param IN_USER_NAME NOMBRE DEL USUARIO 
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_PROCESO_JUDICIAL_DESC_COUNT(
IN IN_USER_NAME VARCHAR,
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_JUR_PROCESO_JUDICIAL PJ
	INNER JOIN CGG_JUR_ASESOR ASR ON (ASR.CJPJU_CODIGO=PJ.CJPJU_CODIGO)	
	WHERE CJPJU_ESTADO AND SII.F_STRING_IN(IN_FIND_TEXT, 
		COALESCE(CJPJU_NUMERO, '')||' '||
		COALESCE(CJPJU_TIPO_PROCESO, 0)||' '||
		COALESCE(CJPJU_TIPO_ADVERSARIO, 0)||' '||
		COALESCE(CJPJU_FECHA_INICIO, CURRENT_TIMESTAMP)||' '||
		COALESCE(CJPJU_FECHA_FINALIZACION, CURRENT_TIMESTAMP)||' '||
		COALESCE(CJPJU_ESTADO_EJECUCION, 0)||' '||
		COALESCE(CJPJU_OBSERVACION, '')||' '||
		COALESCE(CJPJU_ESTADO, FALSE)||' '||
		COALESCE(CJPJU_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||
		COALESCE(CJPJU_USUARIO_INSERT, '')||' '||
		COALESCE(CJPJU_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||
		COALESCE(CJPJU_USUARIO_UPDATE, '')) = 1
		AND PJ.CJPJU_ESTADO_EJECUCION = 1
	AND CJASE_ACTIVO=1
	AND ASR.CUSU_CODIGO IN (SELECT USR.CUSU_CODIGO
							FROM CGG_USUARIO USR							
							WHERE USR.CUSU_NOMBRE_USUARIO=IN_USER_NAME
							AND USR.CUSU_ACTIVO= TRUE
							UNION 
							SELECT ST.CUSU_CODIGO
							FROM CGG_SUSTITUCION ST
							LEFT JOIN CGG_USUARIO US ON (US.CUSU_CODIGO = ST.CGG_CUSU_CODIGO)
							WHERE  CSUST_ESTADO_ENCARGO = TRUE
							AND CUSU_NOMBRE_USUARIO=IN_USER_NAME);
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_PROCESO_JUDICIAL_DESC_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_JUR_PROCESO_JUDICIAL.
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @param IN_USER_NAME NOMBRE DEL USUARIO 
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_PROCESO_JUDICIAL_DESC_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_USER_NAME VARCHAR
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_JUR_PROCESO_JUDICIAL PJ
	INNER JOIN CGG_JUR_ASESOR ASR ON (ASR.CJPJU_CODIGO=PJ.CJPJU_CODIGO)	
	WHERE CJPJU_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CJPJU_NUMERO, '''')||' '||COALESCE(CJPJU_TIPO_PROCESO, 0)||' '||COALESCE(CJPJU_TIPO_ADVERSARIO, 0)||' '||COALESCE(CJPJU_FECHA_INICIO, CURRENT_TIMESTAMP)||' '||COALESCE(CJPJU_FECHA_FINALIZACION, CURRENT_TIMESTAMP)||' '||COALESCE(CJPJU_ESTADO_EJECUCION, 0)||' '||COALESCE(CJPJU_OBSERVACION, '''')||' '||COALESCE(CJPJU_ESTADO, FALSE)||' '||COALESCE(CJPJU_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CJPJU_USUARIO_INSERT, '''')||' '||COALESCE(CJPJU_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CJPJU_USUARIO_UPDATE, '''')) = 1
	AND PJ.CJPJU_ESTADO_EJECUCION = 1
	AND CJASE_ACTIVO=1
	AND ASR.CUSU_CODIGO IN (SELECT USR.CUSU_CODIGO
							FROM CGG_USUARIO USR							
							WHERE USR.CUSU_NOMBRE_USUARIO=IN_USER_NAME
							AND USR.CUSU_ACTIVO= TRUE
							UNION 
							SELECT ST.CUSU_CODIGO
							FROM CGG_SUSTITUCION ST
							LEFT JOIN CGG_USUARIO US ON (US.CUSU_CODIGO = ST.CGG_CUSU_CODIGO)
							WHERE  CSUST_ESTADO_ENCARGO = TRUE
							AND CUSU_NOMBRE_USUARIO=IN_USER_NAME);
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;