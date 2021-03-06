/**
* FUNCION SII.F_CGG_JUR_CRITERIO_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_JUR_CRITERIO.
* @param IN_CJCRI_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CRFAS_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE FASES
* @param IN_CJCRI_REQUERIMIENTO INFORMACION A SER VERIFICADA
* @param IN_CJCRI_REQUERIDO EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
* @param IN_CJCRI_ESTADO ESTADO DEL REGISTRO
* @param IN_CJCRI_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CJCRI_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_INSERT(
IN IN_CJCRI_CODIGO SII.CGG_JUR_CRITERIO.CJCRI_CODIGO%TYPE, 
IN IN_CRFAS_CODIGO SII.CGG_JUR_CRITERIO.CRFAS_CODIGO%TYPE, 
IN IN_CJCRI_REQUERIMIENTO SII.CGG_JUR_CRITERIO.CJCRI_REQUERIMIENTO%TYPE, 
IN IN_CJCRI_REQUERIDO SII.CGG_JUR_CRITERIO.CJCRI_REQUERIDO%TYPE, 
IN IN_CJCRI_ESTADO SII.CGG_JUR_CRITERIO.CJCRI_ESTADO%TYPE, 
IN IN_CJCRI_USUARIO_INSERT SII.CGG_JUR_CRITERIO.CJCRI_USUARIO_INSERT%TYPE, 
IN IN_CJCRI_USUARIO_UPDATE SII.CGG_JUR_CRITERIO.CJCRI_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CJCRI_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_JUR_CRITERIO','CJCRI_CODIGO','CJCRI') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CJCRI_CODIGO;
	END IF;
	INSERT INTO SII.CGG_JUR_CRITERIO(
		CJCRI_CODIGO, 
		CRFAS_CODIGO, 
		CJCRI_REQUERIMIENTO, 
		CJCRI_REQUERIDO, 
		CJCRI_ESTADO, 
		CJCRI_FECHA_INSERT, 
		CJCRI_USUARIO_INSERT, 
		CJCRI_FECHA_UPDATE, 
		CJCRI_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CRFAS_CODIGO, 
		IN_CJCRI_REQUERIMIENTO, 
		IN_CJCRI_REQUERIDO, 
		IN_CJCRI_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CJCRI_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CJCRI_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_JUR_CRITERIO.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CJCRI_CODIGO, 
		CRFAS_CODIGO, 
		CJCRI_REQUERIMIENTO, 
		CJCRI_REQUERIDO, 
		CJCRI_ESTADO, 
		CJCRI_FECHA_INSERT, 
		CJCRI_USUARIO_INSERT, 
		CJCRI_FECHA_UPDATE, 
		CJCRI_USUARIO_UPDATE
	FROM SII.CGG_JUR_CRITERIO
	WHERE CJCRI_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_JUR_CRITERIO.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_SELECT(
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
		CJCRI_CODIGO, 
		CRFAS_CODIGO, 
		CJCRI_REQUERIMIENTO, 
		CJCRI_REQUERIDO, 
		CJCRI_ESTADO, 
		CJCRI_FECHA_INSERT, 
		CJCRI_USUARIO_INSERT, 
		CJCRI_FECHA_UPDATE, 
		CJCRI_USUARIO_UPDATE
	FROM SII.CGG_JUR_CRITERIO
	WHERE CJCRI_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CJCRI_REQUERIMIENTO, '''')||'' ''||COALESCE(CJCRI_REQUERIDO, FALSE)||'' ''||COALESCE(CJCRI_ESTADO, FALSE)||'' ''||COALESCE(CJCRI_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CJCRI_USUARIO_INSERT, '''')||'' ''||COALESCE(CJCRI_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CJCRI_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_JUR_CRITERIO.
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_JUR_CRITERIO
	WHERE CJCRI_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_JUR_CRITERIO
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_JUR_CRITERIO
	WHERE CJCRI_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CJCRI_REQUERIMIENTO, '''')||' '||COALESCE(CJCRI_REQUERIDO, FALSE)||' '||COALESCE(CJCRI_ESTADO, FALSE)||' '||COALESCE(CJCRI_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CJCRI_USUARIO_INSERT, '''')||' '||COALESCE(CJCRI_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CJCRI_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_JUR_CRITERIO.
* @param IN_CJCRI_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CRFAS_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE FASES
* @param IN_CJCRI_REQUERIMIENTO INFORMACION A SER VERIFICADA
* @param IN_CJCRI_REQUERIDO EL REQUERIMIENTO INGRESADO ES OBLIGATORIO O NO
* @param IN_CJCRI_ESTADO ESTADO DEL REGISTRO
* @param IN_CJCRI_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_UPDATE(
IN IN_CJCRI_CODIGO SII.CGG_JUR_CRITERIO.CJCRI_CODIGO%TYPE, 
IN IN_CRFAS_CODIGO SII.CGG_JUR_CRITERIO.CRFAS_CODIGO%TYPE, 
IN IN_CJCRI_REQUERIMIENTO SII.CGG_JUR_CRITERIO.CJCRI_REQUERIMIENTO%TYPE, 
IN IN_CJCRI_REQUERIDO SII.CGG_JUR_CRITERIO.CJCRI_REQUERIDO%TYPE, 
IN IN_CJCRI_ESTADO SII.CGG_JUR_CRITERIO.CJCRI_ESTADO%TYPE, 
IN IN_CJCRI_USUARIO_UPDATE SII.CGG_JUR_CRITERIO.CJCRI_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_JUR_CRITERIO SET
		CRFAS_CODIGO = IN_CRFAS_CODIGO, 
		CJCRI_REQUERIMIENTO = IN_CJCRI_REQUERIMIENTO, 
		CJCRI_REQUERIDO = IN_CJCRI_REQUERIDO, 
		CJCRI_ESTADO = IN_CJCRI_ESTADO, 
		CJCRI_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CJCRI_USUARIO_UPDATE = IN_CJCRI_USUARIO_UPDATE
	WHERE
		CJCRI_CODIGO = IN_CJCRI_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_JUR_CRITERIO.
* @param IN_CJCRI_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_SELECT(
IN IN_CJCRI_CODIGO SII.CGG_JUR_CRITERIO.CJCRI_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CJCRI_CODIGO, 
		CRFAS_CODIGO, 
		CJCRI_REQUERIMIENTO, 
		CJCRI_REQUERIDO, 
		CJCRI_ESTADO, 
		CJCRI_FECHA_INSERT, 
		CJCRI_USUARIO_INSERT, 
		CJCRI_FECHA_UPDATE, 
		CJCRI_USUARIO_UPDATE
	FROM SII.CGG_JUR_CRITERIO
	WHERE CJCRI_ESTADO = TRUE AND 
		CJCRI_CODIGO = IN_CJCRI_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_JUR_CRITERIO.
* @param IN_CJCRI_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_DELETE(
IN IN_CJCRI_CODIGO SII.CGG_JUR_CRITERIO.CJCRI_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_JUR_CRITERIO
	WHERE
		CJCRI_CODIGO = IN_CJCRI_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_JUR_CRITERIO
* @param IN_CJCRI_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_DELETE_SOFT(
IN IN_CJCRI_CODIGO SII.CGG_JUR_CRITERIO.CJCRI_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_JUR_CRITERIO SET
		CJCRI_ESTADO = FALSE
	WHERE
		CJCRI_CODIGO = IN_CJCRI_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_S_CGG_RES_FASE
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_JUR_CRITERIO QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_FASE.
* @param IN_CRFAS_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE FASES
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_S_CGG_RES_FASE(
IN IN_CRFAS_CODIGO SII.CGG_JUR_CRITERIO.CRFAS_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CJCRI_CODIGO, 
		CRFAS_CODIGO, 
		CJCRI_REQUERIMIENTO, 
		CJCRI_REQUERIDO, 
		CJCRI_ESTADO, 
		CJCRI_FECHA_INSERT, 
		CJCRI_USUARIO_INSERT, 
		CJCRI_FECHA_UPDATE, 
		CJCRI_USUARIO_UPDATE
	FROM SII.CGG_JUR_CRITERIO
	WHERE CJCRI_ESTADO = TRUE AND 
		CRFAS_CODIGO = IN_CRFAS_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_D_CGG_RES_FASE
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_JUR_CRITERIO QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_FASE.
* @param IN_CRFAS_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE FASES
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_D_CGG_RES_FASE(
IN IN_CRFAS_CODIGO SII.CGG_JUR_CRITERIO.CRFAS_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_JUR_CRITERIO
	WHERE
		CRFAS_CODIGO = IN_CRFAS_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_JUR_CRITERIO_D_CGG_RES_FASE
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_JUR_CRITERIO QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_FASE.
* @param IN_CRFAS_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE FASES
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_JUR_CRITERIO_DS_CGG_RES_FASE(
IN IN_CRFAS_CODIGO SII.CGG_JUR_CRITERIO.CRFAS_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_JUR_CRITERIO SET
		cjcri_estado = false
	WHERE
		CRFAS_CODIGO = IN_CRFAS_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

