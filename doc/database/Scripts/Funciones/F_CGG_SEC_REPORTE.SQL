/**
* FUNCION SII.F_CGG_SEC_REPORTE_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_SEC_REPORTE
* @param IN_CSRPT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
* @param IN_CSRPT_REPORTE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
* @param IN_CSRPT_DESCRIPCION SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
* @param IN_CSRPT_ACTIVO TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
* @param IN_CSRPT_ESTADO ESTADO DEL REGISTRO
* @param IN_CSRPT_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CSRPT_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_INSERT(
IN IN_CSRPT_CODIGO SII.CGG_SEC_REPORTE.CSRPT_CODIGO%TYPE,
IN IN_CSRPT_REPORTE SII.CGG_SEC_REPORTE.CSRPT_REPORTE%TYPE,
IN IN_CSRPT_DESCRIPCION SII.CGG_SEC_REPORTE.CSRPT_DESCRIPCION%TYPE,
IN IN_CSRPT_ACTIVO SII.CGG_SEC_REPORTE.CSRPT_ACTIVO%TYPE,
IN IN_CSRPT_ESTADO SII.CGG_SEC_REPORTE.CSRPT_ESTADO%TYPE,
IN IN_CSRPT_USUARIO_INSERT SII.CGG_SEC_REPORTE.CSRPT_USUARIO_INSERT%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CSRPT_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_SEC_REPORTE','CSRPT_CODIGO','CSRPT') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CSRPT_CODIGO;
	END IF;
	INSERT INTO SII.CGG_SEC_REPORTE(
		CSRPT_CODIGO, 
		CSRPT_REPORTE, 
		CSRPT_DESCRIPCION, 
		CSRPT_ACTIVO, 
		CSRPT_ESTADO, 
		CSRPT_FECHA_INSERT, 
		CSRPT_USUARIO_INSERT, 
		CSRPT_FECHA_UPDATE, 
		CSRPT_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CSRPT_REPORTE, 
		IN_CSRPT_DESCRIPCION, 
		IN_CSRPT_ACTIVO, 
		IN_CSRPT_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CSRPT_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CSRPT_USUARIO_INSERT
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_SEC_REPORTE
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @param IN_ROL IDENTIFICATIVO UNICO DE ROL.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_SELECT(
IN IN_USER_NAME VARCHAR,
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT,
IN IN_ROL VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		RPT.CSRPT_CODIGO, 
		CSRPT_REPORTE, 
		CSRPT_DESCRIPCION, 
		CSRPT_ACTIVO,
		CSRPR_ESTADO
	FROM SII.CGG_SEC_REPORTE RPT 
	LEFT JOIN SII.CGG_SEC_REPORTE_ROL RROL ON RROL.CSRPT_CODIGO = RPT.CSRPT_CODIGO AND RROL.CSROL_CODIGO = '''||IN_ROL||'''
	WHERE CSRPT_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CSRPT_REPORTE, '''')||'' ''||COALESCE(CSRPT_DESCRIPCION, '''')||'' ''||COALESCE(CSRPT_ACTIVO, FALSE)||'' ''||COALESCE(CSRPT_ESTADO, FALSE)||'' ''||COALESCE(CSRPT_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CSRPT_USUARIO_INSERT, '''')||'' ''||COALESCE(CSRPT_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CSRPT_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_SELECT_USER
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_SEC_REPORTE  QUE EL USUARIO TIENE PROVILEGIOS
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_SELECT_USER(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR 
	SELECT distinct(RPT.CSRPT_CODIGO),CSRPT_REPORTE,CSRPT_DESCRIPCION,CSRPT_ESTADO
	FROM SII.CGG_SEC_REPORTE RPT
	INNER JOIN SII.CGG_SEC_REPORTE_ROL RPR ON RPR.CSRPT_CODIGO = RPT.CSRPT_CODIGO
	INNER JOIN SII.CGG_SEC_ROL ROL ON RPR.CSROL_CODIGO = ROL.CSROL_CODIGO
	INNER JOIN SII.CGG_SEC_USUARIO_ROL USR ON ROL.CSROL_CODIGO = USR.CSROL_CODIGO
	INNER JOIN SII.CGG_USUARIO CUSU ON USR.CUSU_CODIGO = CUSU.CUSU_CODIGO
	WHERE CSRPT_ESTADO AND RPR.CSRPR_ESTADO AND
	CSROL_ESTADO AND CSPER_ESTADO AND CUSU.CUSU_NOMBRE_USUARIO = IN_USER_NAME ;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_SEC_REPORTE
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_SEC_REPORTE
	WHERE CSRPT_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_SEC_REPORTE
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_SEC_REPORTE
	WHERE CSRPT_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CSRPT_REPORTE, '''')||' '||COALESCE(CSRPT_DESCRIPCION, '''')||' '||COALESCE(CSRPT_ACTIVO, FALSE)||' '||COALESCE(CSRPT_ESTADO, FALSE)||' '||COALESCE(CSRPT_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CSRPT_USUARIO_INSERT, '''')||' '||COALESCE(CSRPT_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CSRPT_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_SEC_REPORTE
* @param IN_CSRPT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
* @param IN_CSRPT_REPORTE SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
* @param IN_CSRPT_DESCRIPCION SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
* @param IN_CSRPT_ACTIVO TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
* @param IN_CSRPT_ESTADO ESTADO DEL REGISTRO
* @param IN_CSRPT_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_UPDATE(
IN IN_CSRPT_CODIGO SII.CGG_SEC_REPORTE.CSRPT_CODIGO%TYPE,
IN IN_CSRPT_REPORTE SII.CGG_SEC_REPORTE.CSRPT_REPORTE%TYPE,
IN IN_CSRPT_DESCRIPCION SII.CGG_SEC_REPORTE.CSRPT_DESCRIPCION%TYPE,
IN IN_CSRPT_ACTIVO SII.CGG_SEC_REPORTE.CSRPT_ACTIVO%TYPE,
IN IN_CSRPT_ESTADO SII.CGG_SEC_REPORTE.CSRPT_ESTADO%TYPE,
IN IN_CSRPT_USUARIO_UPDATE SII.CGG_SEC_REPORTE.CSRPT_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_SEC_REPORTE SET
		CSRPT_REPORTE = IN_CSRPT_REPORTE, 
		CSRPT_DESCRIPCION = IN_CSRPT_DESCRIPCION, 
		CSRPT_ACTIVO = IN_CSRPT_ACTIVO, 
		CSRPT_ESTADO = IN_CSRPT_ESTADO, 
		CSRPT_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CSRPT_USUARIO_UPDATE = IN_CSRPT_USUARIO_UPDATE
	WHERE
		CSRPT_CODIGO = IN_CSRPT_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_SEC_REPORTE
* @param IN_CSRPT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_DELETE(
IN IN_CSRPT_CODIGO SII.CGG_SEC_REPORTE.CSRPT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_SEC_REPORTE
	WHERE
		CSRPT_CODIGO = IN_CSRPT_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_REPORTE_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_SEC_REPORTE
* @param IN_CSRPT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_DELETE_SOFT(
IN IN_CSRPT_CODIGO SII.CGG_SEC_REPORTE.CSRPT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_SEC_REPORTE SET
		CSRPT_ESTADO = FALSE
	WHERE
		CSRPT_CODIGO = IN_CSRPT_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;


/**
* FUNCION SII.F_CGG_SEC_REPORTE_ROL_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_SEC_REPORTE_ROL
* @param IN_CSRPR_CODIGO NO ESPECIFICADO
* @param IN_CSROL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO ROL
* @param IN_CSRPT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
* @param IN_CSRPR_ESTADO ESTADO DEL REGISTRO
* @param IN_CSRPR_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CSRPR_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_ROL_INSERT_DELETE(
IN IN_CSRPR_CODIGO SII.CGG_SEC_REPORTE_ROL.CSRPR_CODIGO%TYPE,
IN IN_CSROL_CODIGO SII.CGG_SEC_REPORTE_ROL.CSROL_CODIGO%TYPE,
IN IN_CSRPT_CODIGO SII.CGG_SEC_REPORTE_ROL.CSRPT_CODIGO%TYPE,
IN IN_CSRPR_ESTADO SII.CGG_SEC_REPORTE_ROL.CSRPR_ESTADO%TYPE,
IN IN_CSRPR_USUARIO_INSERT SII.CGG_SEC_REPORTE_ROL.CSRPR_USUARIO_INSERT%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
TMP_COUNT INTEGER;
TMP_B BOOLEAN;
BEGIN
	SELECT CSRPR_ESTADO INTO  TMP_B FROM SII.CGG_SEC_REPORTE_ROL 
	WHERE CSRPT_CODIGO = IN_CSRPT_CODIGO 
	AND CSROL_CODIGO = IN_CSROL_CODIGO;
	
	IF TMP_B IS NOT NULL THEN 
		IF TMP_B = TRUE THEN
			TMP_B :=FALSE;
		ELSE 
			TMP_B :=TRUE;
		END IF;
		UPDATE SII.CGG_SEC_REPORTE_ROL SET			
			CSRPR_ESTADO = TMP_B, 
			CSRPR_FECHA_UPDATE = CURRENT_TIMESTAMP, 
			CSRPR_USUARIO_UPDATE = IN_CSRPR_USUARIO_INSERT
		WHERE
			CSRPT_CODIGO = IN_CSRPT_CODIGO 
			AND CSROL_CODIGO = IN_CSROL_CODIGO;
	ELSE
		SELECT SII.F_KEYGEN('CGG_SEC_REPORTE_ROL','CSRPR_CODIGO','CSRPR') INTO OUT_KEY;
		INSERT INTO SII.CGG_SEC_REPORTE_ROL(
			CSRPR_CODIGO, 
			CSROL_CODIGO, 
			CSRPT_CODIGO, 
			CSRPR_ESTADO, 
			CSRPR_FECHA_INSERT, 
			CSRPR_USUARIO_INSERT, 
			CSRPR_FECHA_UPDATE, 
			CSRPR_USUARIO_UPDATE
		) VALUES (
			OUT_KEY, 
			IN_CSROL_CODIGO, 
			IN_CSRPT_CODIGO, 
			IN_CSRPR_ESTADO, 
			CURRENT_TIMESTAMP, 
			IN_CSRPR_USUARIO_INSERT, 
			CURRENT_TIMESTAMP, 
			IN_CSRPR_USUARIO_INSERT
		);
	END IF;
	RETURN 'true';
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;


/**
* FUNCION SII.F_CGG_SEC_REPORTE_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_SEC_REPORTE
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_REPORTE_ALL_SELECT(
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
		CSRPT_CODIGO, 
		CSRPT_REPORTE, 
		CSRPT_DESCRIPCION, 
		CSRPT_ACTIVO, 
		CSRPT_ESTADO, 
		CSRPT_FECHA_INSERT, 
		CSRPT_USUARIO_INSERT, 
		CSRPT_FECHA_UPDATE, 
		CSRPT_USUARIO_UPDATE
	FROM SII.CGG_SEC_REPORTE
	WHERE CSRPT_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CSRPT_REPORTE, '''')||'' ''||COALESCE(CSRPT_DESCRIPCION, '''')||'' ''||COALESCE(CSRPT_ACTIVO, FALSE)||'' ''||COALESCE(CSRPT_ESTADO, FALSE)||'' ''||COALESCE(CSRPT_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CSRPT_USUARIO_INSERT, '''')||'' ''||COALESCE(CSRPT_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CSRPT_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;