/**
* FUNCION SII.F_CGG_RES_MUELLE_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_RES_MUELLE
* @param IN_CRMLE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CRMLE_NOMBRE NOMBRE DEL MUELLE
* @param IN_CRMLE_ESTADO ESTADO DEL REGISTRO
* @param IN_CRMLE_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CRMLE_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_INSERT(
IN IN_CRMLE_CODIGO SII.CGG_RES_MUELLE.CRMLE_CODIGO%TYPE, 
IN IN_CCTN_CODIGO SII.CGG_RES_MUELLE.CCTN_CODIGO%TYPE, 
IN IN_CRMLE_NOMBRE SII.CGG_RES_MUELLE.CRMLE_NOMBRE%TYPE, 
IN IN_CRMLE_ESTADO SII.CGG_RES_MUELLE.CRMLE_ESTADO%TYPE, 
IN IN_CRMLE_USUARIO_INSERT SII.CGG_RES_MUELLE.CRMLE_USUARIO_INSERT%TYPE, 
IN IN_CRMLE_USUARIO_UPDATE SII.CGG_RES_MUELLE.CRMLE_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CRMLE_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_MUELLE','CRMLE_CODIGO','CRMLE') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRMLE_CODIGO;
	END IF;
	INSERT INTO SII.CGG_RES_MUELLE(
		CRMLE_CODIGO, 
		CCTN_CODIGO, 
		CRMLE_NOMBRE, 
		CRMLE_ESTADO, 
		CRMLE_FECHA_INSERT, 
		CRMLE_USUARIO_INSERT, 
		CRMLE_FECHA_UPDATE, 
		CRMLE_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CCTN_CODIGO, 
		IN_CRMLE_NOMBRE, 
		IN_CRMLE_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CRMLE_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CRMLE_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_RES_MUELLE
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_SELECT_AS(
IN IN_USER_NAME varchar(50)
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRMLE_CODIGO, 
		CCTN_CODIGO, 
		CRMLE_NOMBRE, 
		CRMLE_ESTADO, 
		CRMLE_FECHA_INSERT, 
		CRMLE_USUARIO_INSERT, 
		CRMLE_FECHA_UPDATE, 
		CRMLE_USUARIO_UPDATE
	FROM SII.CGG_RES_MUELLE
	WHERE CRMLE_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/*
* FUNCION SII.F_CGG_RES_MUELLE__SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_MUELLE
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_SELECT(
IN IN_USER_NAME varchar(50),
IN IN_START_INDEX int,
IN IN_LIMIT int,
IN IN_SORT_FIELD_NAME varchar,
IN IN_DIRECTION varchar,
IN IN_FIND_TEXT text
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		CRMLE_CODIGO, 
		CCTN_CODIGO, 
		CRMLE_NOMBRE, 
		CRMLE_ESTADO, 
		CRMLE_FECHA_INSERT, 
		CRMLE_USUARIO_INSERT, 
		CRMLE_FECHA_UPDATE, 
		CRMLE_USUARIO_UPDATE
	FROM SII.CGG_RES_MUELLE
	WHERE CRMLE_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',CASE WHEN CRMLE_CODIGO IS NULL THEN '''' ELSE CRMLE_CODIGO END ||'' ''||CASE WHEN CCTN_CODIGO IS NULL THEN '''' ELSE CCTN_CODIGO END ||'' ''||CASE WHEN CRMLE_NOMBRE IS NULL THEN '''' ELSE CRMLE_NOMBRE END ||'' ''||CASE WHEN CRMLE_ESTADO IS NULL THEN FALSE ELSE CRMLE_ESTADO END ||'' ''||CASE WHEN CRMLE_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE CRMLE_FECHA_INSERT END ||'' ''||CASE WHEN CRMLE_USUARIO_INSERT IS NULL THEN '''' ELSE CRMLE_USUARIO_INSERT END ||'' ''||CASE WHEN CRMLE_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE CRMLE_FECHA_UPDATE END ||'' ''||CASE WHEN CRMLE_USUARIO_UPDATE IS NULL THEN '''' ELSE CRMLE_USUARIO_UPDATE END ) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_MUELLE
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_MUELLE
	WHERE CRMLE_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_MUELLE
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_MUELLE
	WHERE CRMLE_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,CASE WHEN CRMLE_CODIGO IS NULL THEN '''' ELSE CRMLE_CODIGO END ||' '||CASE WHEN CCTN_CODIGO IS NULL THEN '''' ELSE CCTN_CODIGO END ||' '||CASE WHEN CRMLE_NOMBRE IS NULL THEN '''' ELSE CRMLE_NOMBRE END ||' '||CASE WHEN CRMLE_ESTADO IS NULL THEN FALSE ELSE CRMLE_ESTADO END ||' '||CASE WHEN CRMLE_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE CRMLE_FECHA_INSERT END ||' '||CASE WHEN CRMLE_USUARIO_INSERT IS NULL THEN '''' ELSE CRMLE_USUARIO_INSERT END ||' '||CASE WHEN CRMLE_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE CRMLE_FECHA_UPDATE END ||' '||CASE WHEN CRMLE_USUARIO_UPDATE IS NULL THEN '''' ELSE CRMLE_USUARIO_UPDATE END ) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_RES_MUELLE
* @param IN_CRMLE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CRMLE_NOMBRE NOMBRE DEL MUELLE
* @param IN_CRMLE_ESTADO ESTADO DEL REGISTRO
* @param IN_CRMLE_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_UPDATE(
IN IN_CRMLE_CODIGO SII.CGG_RES_MUELLE.CRMLE_CODIGO%TYPE, 
IN IN_CCTN_CODIGO SII.CGG_RES_MUELLE.CCTN_CODIGO%TYPE, 
IN IN_CRMLE_NOMBRE SII.CGG_RES_MUELLE.CRMLE_NOMBRE%TYPE, 
IN IN_CRMLE_ESTADO SII.CGG_RES_MUELLE.CRMLE_ESTADO%TYPE, 
IN IN_CRMLE_USUARIO_UPDATE SII.CGG_RES_MUELLE.CRMLE_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_MUELLE SET
		CCTN_CODIGO = IN_CCTN_CODIGO, 
		CRMLE_NOMBRE = IN_CRMLE_NOMBRE, 
		CRMLE_ESTADO = IN_CRMLE_ESTADO, 
		CRMLE_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CRMLE_USUARIO_UPDATE = IN_CRMLE_USUARIO_UPDATE
	WHERE
		CRMLE_CODIGO = IN_CRMLE_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_RES_MUELLE
* @param IN_CRMLE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_SELECT(
IN IN_CRMLE_CODIGO SII.CGG_RES_MUELLE.CRMLE_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRMLE_CODIGO, 
		CCTN_CODIGO, 
		CRMLE_NOMBRE, 
		CRMLE_ESTADO, 
		CRMLE_FECHA_INSERT, 
		CRMLE_USUARIO_INSERT, 
		CRMLE_FECHA_UPDATE, 
		CRMLE_USUARIO_UPDATE
	FROM SII.CGG_RES_MUELLE
	WHERE CRMLE_ESTADO = TRUE AND 
		CRMLE_CODIGO = IN_CRMLE_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_RES_MUELLE
* @param IN_CRMLE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_DELETE(
IN IN_CRMLE_CODIGO SII.CGG_RES_MUELLE.CRMLE_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_MUELLE
	WHERE
		CRMLE_CODIGO = IN_CRMLE_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_RES_MUELLE
* @param IN_CRMLE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_DELETE_SOFT(
IN IN_CRMLE_CODIGO SII.CGG_RES_MUELLE.CRMLE_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_MUELLE SET
		CRMLE_ESTADO = FALSE
	WHERE
		CRMLE_CODIGO = IN_CRMLE_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_S_CGG_CANTON
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_MUELLE QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_CANTON.
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_S_CGG_CANTON(
IN IN_CCTN_CODIGO SII.CGG_RES_MUELLE.CCTN_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRMLE_CODIGO, 
		CCTN_CODIGO, 
		CRMLE_NOMBRE, 
		CRMLE_ESTADO, 
		CRMLE_FECHA_INSERT, 
		CRMLE_USUARIO_INSERT, 
		CRMLE_FECHA_UPDATE, 
		CRMLE_USUARIO_UPDATE
	FROM SII.CGG_RES_MUELLE
	WHERE CRMLE_ESTADO = TRUE AND 
		CCTN_CODIGO = IN_CCTN_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_D_CGG_CANTON
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_MUELLE QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_CANTON.
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_D_CGG_CANTON(
IN IN_CCTN_CODIGO SII.CGG_RES_MUELLE.CCTN_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_MUELLE
	WHERE
		CCTN_CODIGO = IN_CCTN_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_MUELLE_D_CGG_CANTON
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_MUELLE QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_CANTON.
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MUELLE_DS_CGG_CANTON(
IN IN_CCTN_CODIGO SII.CGG_RES_MUELLE.CCTN_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_MUELLE SET
		crmle_estado = false
	WHERE
		CCTN_CODIGO = IN_CCTN_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

