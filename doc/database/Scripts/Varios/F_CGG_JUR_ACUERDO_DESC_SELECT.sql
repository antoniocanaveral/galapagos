/**
* FUNCION SII.F_CGG_JUR_ACUERDO_DESC_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_JUR_ACUERDO.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_ACUERDO_DESC_SELECT(
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
	TMP_SQL TEXT;
BEGIN	
	TMP_SQL := 'SELECT
		ACR.CJACU_CODIGO, 		
		ACR.CRPJR_CODIGO,
		(SELECT CRPJR_RAZON_SOCIAL FROM CGG_RES_PERSONA_JURIDICA PJA WHERE (PJA.CRPJR_CODIGO = ACR.CRPJR_CODIGO)) RAZON_SOCIAL,			
		ACR.CRPER_CODIGO, 
		(SELECT CRPER_NOMBRES||'' ''||CRPER_APELLIDO_PATERNO||'' ''||CRPER_APELLIDO_MATERNO FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = ACR.CRPER_CODIGO) PERSONA,			
		ACR.CJTPR_CODIGO, 
		(SELECT CJTPR_NOMBRE FROM CGG_JUR_TIPO_PROCESO TP WHERE (TP.CJTPR_CODIGO = ACR.CJTPR_CODIGO)) NOMBRE_PROCESO,	
		ACR.CGG_CUSU_CODIGO, 
		(SELECT PR.CRPER_NOMBRES||'' ''||PR.CRPER_APELLIDO_PATERNO||'' ''||PR.CRPER_APELLIDO_MATERNO 
		FROM SII.CGG_RES_PERSONA PR
		INNER JOIN SII.CGG_USUARIO US  ON (US.CRPER_CODIGO = PR.CRPER_CODIGO)
		WHERE US.CUSU_CODIGO = ACR.CGG_CUSU_CODIGO) RESPONSABLE,
		ACR.CJACU_ANIO, 
		ACR.CJACU_NUMERO, 
		ACR.CJACU_OBJETO, 
		ACR.CJACU_FECHA_SUSCRIPCION, 
		ACR.CJACU_FECHA_INICIO, 		
		ACR.CJACU_FECHA_FINALIZACION,
		ACR.CJACU_ESTADO_EJECUCION,
		ACR.CJACU_COSTO,
		(SELECT COALESCE(SUM(CJAAC_VALOR_1::INTEGER),0) FROM CGG_JUR_ANTICIPO A WHERE A.CJACU_CODIGO=ACR.CJACU_CODIGO) PAGOS,
		(SELECT CJTPR_TIPO FROM CGG_JUR_TIPO_PROCESO TP WHERE (TP.CJTPR_CODIGO = ACR.CJTPR_CODIGO)) CJACU_TIPO,	
		ACR.CJACU_TIPO_PERSONA		
	FROM SII.CGG_JUR_ACUERDO ACR
	WHERE CJACU_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
	COALESCE(ACR.CJACU_ANIO, 0)||'' ''||
	COALESCE(ACR.CJACU_NUMERO, '''')||'' ''||
	COALESCE(ACR.CJACU_OBJETO, '''')||'' ''||	
	COALESCE(ACR.CJACU_FECHA_SUSCRIPCION, CURRENT_TIMESTAMP)||'' ''||	
	COALESCE(ACR.CJACU_FECHA_INICIO, CURRENT_TIMESTAMP)||'' ''||
	COALESCE(ACR.CJACU_RESPONSABLE, '''')||'' ''||
	COALESCE(ACR.CJACU_ESTADO_EJECUCION, 0)||'' ''||
	COALESCE(ACR.CJACU_TIPO, 0)||'' ''||
	COALESCE(ACR.CJACU_TIPO_PERSONA, 0)) = 1
	AND (CJACU_ESTADO_EJECUCION = 0 OR CJACU_ESTADO_EJECUCION = 1)
	AND ACR.CGG_CUSU_CODIGO IN (SELECT USR.CUSU_CODIGO
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
	OPEN TMP_REF FOR EXECUTE TMP_SQL;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_ACUERDO_DESC_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_JUR_ACUERDO.
* @param IN_USER_NAME NOMBRE DE USUARIO
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_ACUERDO_DESC_COUNT(
IN IN_USER_NAME VARCHAR
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_JUR_ACUERDO ACR
	WHERE CJACU_ESTADO = TRUE
	AND (CJACU_ESTADO_EJECUCION = 0 OR CJACU_ESTADO_EJECUCION = 1)
	AND ACR.CGG_CUSU_CODIGO IN (SELECT USR.CUSU_CODIGO
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
* FUNCION SII.SII.F_CGG_JUR_ACUERDO_DESC_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_JUR_ACUERDO.
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @param IN_USER_NAME
* @return TOTAL DE REGISTROS
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_ACUERDO_DESC_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_USER_NAME VARCHAR
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_JUR_ACUERDO ACR
	WHERE CJACU_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,
	COALESCE(ACR.CJACU_ANIO, 0)||''||
	COALESCE(ACR.CJACU_NUMERO, '''')||' '||
	COALESCE(ACR.CJACU_OBJETO, '''')||' '||	
	COALESCE(ACR.CJACU_FECHA_SUSCRIPCION, CURRENT_TIMESTAMP)||' '||	
	COALESCE(ACR.CJACU_FECHA_INICIO, CURRENT_TIMESTAMP)||' '||
	COALESCE(ACR.CJACU_RESPONSABLE, '''')||' '||
	COALESCE(ACR.CJACU_ESTADO_EJECUCION, 0)||' '||
	COALESCE(ACR.CJACU_TIPO, 0)||' '||
	COALESCE(ACR.CJACU_TIPO_PERSONA, 0)) = 1
	AND (CJACU_ESTADO_EJECUCION = 0 OR CJACU_ESTADO_EJECUCION = 1)
	AND ACR.CGG_CUSU_CODIGO IN (SELECT USR.CUSU_CODIGO
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