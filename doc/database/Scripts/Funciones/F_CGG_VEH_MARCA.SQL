/**
* FUNCION SII.F_CGG_VEH_MARCA_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_VEH_MARCA
* @param IN_CVMRC_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE MARCA
* @param IN_CVMRC_NOMBRE NOMBRE IDENTIFICADOR DE LA MARCA.
* @param IN_CVMRC_OBSERVACION INFORMACION ADICIONAL
* @param IN_CVMRC_ESTADO ESTADO DEL REGISTRO.
* @param IN_CVMRC_USUARIO_INSERT USUARIO DE LA APLICACION.
* @param IN_CVMRC_USUARIO_UPDATE USUARIO QUE ACTUALIZO EL REGISTRO.
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_INSERT(
IN IN_CVMRC_CODIGO SII.CGG_VEH_MARCA.CVMRC_CODIGO%TYPE, 
IN IN_CVMRC_NOMBRE SII.CGG_VEH_MARCA.CVMRC_NOMBRE%TYPE, 
IN IN_CVMRC_OBSERVACION SII.CGG_VEH_MARCA.CVMRC_OBSERVACION%TYPE, 
IN IN_CVMRC_ESTADO SII.CGG_VEH_MARCA.CVMRC_ESTADO%TYPE, 
IN IN_CVMRC_USUARIO_INSERT SII.CGG_VEH_MARCA.CVMRC_USUARIO_INSERT%TYPE, 
IN IN_CVMRC_USUARIO_UPDATE SII.CGG_VEH_MARCA.CVMRC_USUARIO_UPDATE%TYPE 
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CVMRC_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_VEH_MARCA','CVMRC_CODIGO','CVMRC') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CVMRC_CODIGO;
	END IF;
	INSERT INTO SII.CGG_VEH_MARCA(
		CVMRC_CODIGO, 
		CVMRC_NOMBRE, 
		CVMRC_OBSERVACION, 
		CVMRC_ESTADO, 
		CVMRC_USUARIO_INSERT, 
		CVMRC_FECHA_INSERT, 
		CVMRC_USUARIO_UPDATE, 
		CVMRC_FECHA_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CVMRC_NOMBRE, 
		IN_CVMRC_OBSERVACION, 
		IN_CVMRC_ESTADO, 
		IN_CVMRC_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CVMRC_USUARIO_UPDATE, 
		CURRENT_TIMESTAMP
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_VEH_MARCA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVMRC_CODIGO, 
		CVMRC_NOMBRE, 
		CVMRC_OBSERVACION, 
		CVMRC_ESTADO, 
		CVMRC_USUARIO_INSERT, 
		CVMRC_FECHA_INSERT, 
		CVMRC_USUARIO_UPDATE, 
		CVMRC_FECHA_UPDATE
	FROM SII.CGG_VEH_MARCA
	WHERE CVMRC_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_VEH_MARCA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_SELECT(
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
		CVMRC_CODIGO, 
		CVMRC_NOMBRE, 
		CVMRC_OBSERVACION, 
		CVMRC_ESTADO, 
		CVMRC_USUARIO_INSERT, 
		CVMRC_FECHA_INSERT, 
		CVMRC_USUARIO_UPDATE, 
		CVMRC_FECHA_UPDATE
	FROM SII.CGG_VEH_MARCA
	WHERE CVMRC_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CVMRC_NOMBRE, '''')||'' ''||COALESCE(CVMRC_OBSERVACION, '''')||'' ''||COALESCE(CVMRC_ESTADO, FALSE)||'' ''||COALESCE(CVMRC_USUARIO_INSERT, '''')||'' ''||COALESCE(CVMRC_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CVMRC_USUARIO_UPDATE, '''')||'' ''||COALESCE(CVMRC_FECHA_UPDATE, CURRENT_TIMESTAMP)) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_VEH_MARCA
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_VEH_MARCA
	WHERE CVMRC_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_VEH_MARCA
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_VEH_MARCA
	WHERE CVMRC_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CVMRC_NOMBRE, '''')||' '||COALESCE(CVMRC_OBSERVACION, '''')||' '||COALESCE(CVMRC_ESTADO, FALSE)||' '||COALESCE(CVMRC_USUARIO_INSERT, '''')||' '||COALESCE(CVMRC_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CVMRC_USUARIO_UPDATE, '''')||' '||COALESCE(CVMRC_FECHA_UPDATE, CURRENT_TIMESTAMP)) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_VEH_MARCA
* @param IN_CVMRC_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE MARCA
* @param IN_CVMRC_NOMBRE NOMBRE IDENTIFICADOR DE LA MARCA.
* @param IN_CVMRC_OBSERVACION INFORMACION ADICIONAL
* @param IN_CVMRC_ESTADO ESTADO DEL REGISTRO.
* @param IN_CVMRC_USUARIO_UPDATE USUARIO QUE ACTUALIZO EL REGISTRO.
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_UPDATE(
IN IN_CVMRC_CODIGO SII.CGG_VEH_MARCA.CVMRC_CODIGO%TYPE, 
IN IN_CVMRC_NOMBRE SII.CGG_VEH_MARCA.CVMRC_NOMBRE%TYPE, 
IN IN_CVMRC_OBSERVACION SII.CGG_VEH_MARCA.CVMRC_OBSERVACION%TYPE, 
IN IN_CVMRC_ESTADO SII.CGG_VEH_MARCA.CVMRC_ESTADO%TYPE, 
IN IN_CVMRC_USUARIO_UPDATE SII.CGG_VEH_MARCA.CVMRC_USUARIO_UPDATE%TYPE 
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_MARCA SET
		CVMRC_NOMBRE = IN_CVMRC_NOMBRE, 
		CVMRC_OBSERVACION = IN_CVMRC_OBSERVACION, 
		CVMRC_ESTADO = IN_CVMRC_ESTADO, 
		CVMRC_USUARIO_UPDATE = IN_CVMRC_USUARIO_UPDATE, 
		CVMRC_FECHA_UPDATE = CURRENT_TIMESTAMP
	WHERE
		CVMRC_CODIGO = IN_CVMRC_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_VEH_MARCA
* @param IN_CVMRC_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE MARCA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_SELECT(
IN IN_CVMRC_CODIGO SII.CGG_VEH_MARCA.CVMRC_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVMRC_CODIGO, 
		CVMRC_NOMBRE, 
		CVMRC_OBSERVACION, 
		CVMRC_ESTADO, 
		CVMRC_USUARIO_INSERT, 
		CVMRC_FECHA_INSERT, 
		CVMRC_USUARIO_UPDATE, 
		CVMRC_FECHA_UPDATE
	FROM SII.CGG_VEH_MARCA
	WHERE CVMRC_ESTADO = TRUE AND 
		CVMRC_CODIGO = IN_CVMRC_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_VEH_MARCA
* @param IN_CVMRC_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE MARCA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_DELETE(
IN IN_CVMRC_CODIGO SII.CGG_VEH_MARCA.CVMRC_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_VEH_MARCA
	WHERE
		CVMRC_CODIGO = IN_CVMRC_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_MARCA_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_VEH_MARCA
* @param IN_CVMRC_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE MARCA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_MARCA_DELETE_SOFT(
IN IN_CVMRC_CODIGO SII.CGG_VEH_MARCA.CVMRC_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_MARCA SET
		CVMRC_ESTADO = FALSE
	WHERE
		CVMRC_CODIGO = IN_CVMRC_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

