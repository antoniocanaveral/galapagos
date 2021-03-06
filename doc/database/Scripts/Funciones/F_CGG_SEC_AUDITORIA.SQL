/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_SEC_AUDITORIA
* @param IN_CSADT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
* @param IN_CSADT_FECHA FECHA DEL CAMBIO DE INFORMACION
* @param IN_CSADT_USUARIO USUARIO QUE REALIZO LA MODIFICACION
* @param IN_CSADT_IP IP REMOTA DEL USUARIO
* @param IN_CSADT_SESION IDENTIFICADOR DE LA SESION DEL USUARIO
* @param IN_CSADT_TABLA NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
* @param IN_CSADT_OPERACION TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
* @param IN_CSADT_DATO_ANTIGUO REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
* @param IN_CSADT_DATO_NUEVO REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_INSERT(
IN IN_CSADT_CODIGO SII.CGG_SEC_AUDITORIA.CSADT_CODIGO%TYPE, 
IN IN_CSADT_FECHA SII.CGG_SEC_AUDITORIA.CSADT_FECHA%TYPE, 
IN IN_CSADT_USUARIO SII.CGG_SEC_AUDITORIA.CSADT_USUARIO%TYPE, 
IN IN_CSADT_IP SII.CGG_SEC_AUDITORIA.CSADT_IP%TYPE, 
IN IN_CSADT_SESION SII.CGG_SEC_AUDITORIA.CSADT_SESION%TYPE, 
IN IN_CSADT_TABLA SII.CGG_SEC_AUDITORIA.CSADT_TABLA%TYPE, 
IN IN_CSADT_OPERACION SII.CGG_SEC_AUDITORIA.CSADT_OPERACION%TYPE, 
IN IN_CSADT_DATO_ANTIGUO SII.CGG_SEC_AUDITORIA.CSADT_DATO_ANTIGUO%TYPE, 
IN IN_CSADT_DATO_NUEVO SII.CGG_SEC_AUDITORIA.CSADT_DATO_NUEVO%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CSADT_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_SEC_AUDITORIA','CSADT_CODIGO','CSADT') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CSADT_CODIGO;
	END IF;
	INSERT INTO SII.CGG_SEC_AUDITORIA(
		CSADT_CODIGO, 
		CSADT_FECHA, 
		CSADT_USUARIO, 
		CSADT_IP, 
		CSADT_SESION, 
		CSADT_TABLA, 
		CSADT_OPERACION, 
		CSADT_DATO_ANTIGUO, 
		CSADT_DATO_NUEVO
	) VALUES (
		OUT_KEY, 
		IN_CSADT_FECHA, 
		IN_CSADT_USUARIO, 
		IN_CSADT_IP, 
		IN_CSADT_SESION, 
		IN_CSADT_TABLA, 
		IN_CSADT_OPERACION, 
		IN_CSADT_DATO_ANTIGUO, 
		IN_CSADT_DATO_NUEVO
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_SEC_AUDITORIA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_SELECT_AS(
IN IN_USER_NAME varchar(50)
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CSADT_CODIGO, 
		CSADT_FECHA, 
		CSADT_USUARIO, 
		CSADT_IP, 
		CSADT_SESION, 
		CSADT_TABLA, 
		CSADT_OPERACION, 
		CSADT_DATO_ANTIGUO, 
		CSADT_DATO_NUEVO
	FROM SII.CGG_SEC_AUDITORIA;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/*
* FUNCION SII.F_CGG_SEC_AUDITORIA__SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_SEC_AUDITORIA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_SELECT(
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
		CSADT_CODIGO, 
		CSADT_FECHA, 
		CSADT_USUARIO, 
		CSADT_IP, 
		CSADT_SESION, 
		CSADT_TABLA, 
		CSADT_OPERACION, 
		CSADT_DATO_ANTIGUO, 
		CSADT_DATO_NUEVO
	FROM SII.CGG_SEC_AUDITORIA
	WHERE SII.F_STRING_IN('''||IN_FIND_TEXT||''',CASE WHEN CSADT_CODIGO IS NULL THEN '''' ELSE CSADT_CODIGO END ||'' ''||CASE WHEN CSADT_FECHA IS NULL THEN CURRENT_TIMESTAMP ELSE CSADT_FECHA END ||'' ''||CASE WHEN CSADT_USUARIO IS NULL THEN '''' ELSE CSADT_USUARIO END ||'' ''||CASE WHEN CSADT_IP IS NULL THEN '''' ELSE CSADT_IP END ||'' ''||CASE WHEN CSADT_SESION IS NULL THEN '''' ELSE CSADT_SESION END ||'' ''||CASE WHEN CSADT_TABLA IS NULL THEN '''' ELSE CSADT_TABLA END ||'' ''||CASE WHEN CSADT_OPERACION IS NULL THEN '''' ELSE CSADT_OPERACION END ||'' ''||CASE WHEN CSADT_DATO_ANTIGUO IS NULL THEN '''' ELSE CSADT_DATO_ANTIGUO END ||'' ''||CASE WHEN CSADT_DATO_NUEVO IS NULL THEN '''' ELSE CSADT_DATO_NUEVO END ) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_SEC_AUDITORIA
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_SEC_AUDITORIA;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_SEC_AUDITORIA
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_SEC_AUDITORIA
	WHERE SII.F_STRING_IN(IN_FIND_TEXT,CASE WHEN CSADT_CODIGO IS NULL THEN '''' ELSE CSADT_CODIGO END ||' '||CASE WHEN CSADT_FECHA IS NULL THEN CURRENT_TIMESTAMP ELSE CSADT_FECHA END ||' '||CASE WHEN CSADT_USUARIO IS NULL THEN '''' ELSE CSADT_USUARIO END ||' '||CASE WHEN CSADT_IP IS NULL THEN '''' ELSE CSADT_IP END ||' '||CASE WHEN CSADT_SESION IS NULL THEN '''' ELSE CSADT_SESION END ||' '||CASE WHEN CSADT_TABLA IS NULL THEN '''' ELSE CSADT_TABLA END ||' '||CASE WHEN CSADT_OPERACION IS NULL THEN '''' ELSE CSADT_OPERACION END ||' '||CASE WHEN CSADT_DATO_ANTIGUO IS NULL THEN '''' ELSE CSADT_DATO_ANTIGUO END ||' '||CASE WHEN CSADT_DATO_NUEVO IS NULL THEN '''' ELSE CSADT_DATO_NUEVO END ) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_SEC_AUDITORIA
* @param IN_CSADT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
* @param IN_CSADT_FECHA FECHA DEL CAMBIO DE INFORMACION
* @param IN_CSADT_USUARIO USUARIO QUE REALIZO LA MODIFICACION
* @param IN_CSADT_IP IP REMOTA DEL USUARIO
* @param IN_CSADT_SESION IDENTIFICADOR DE LA SESION DEL USUARIO
* @param IN_CSADT_TABLA NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
* @param IN_CSADT_OPERACION TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
* @param IN_CSADT_DATO_ANTIGUO REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
* @param IN_CSADT_DATO_NUEVO REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_UPDATE(
IN IN_CSADT_CODIGO SII.CGG_SEC_AUDITORIA.CSADT_CODIGO%TYPE, 
IN IN_CSADT_FECHA SII.CGG_SEC_AUDITORIA.CSADT_FECHA%TYPE, 
IN IN_CSADT_USUARIO SII.CGG_SEC_AUDITORIA.CSADT_USUARIO%TYPE, 
IN IN_CSADT_IP SII.CGG_SEC_AUDITORIA.CSADT_IP%TYPE, 
IN IN_CSADT_SESION SII.CGG_SEC_AUDITORIA.CSADT_SESION%TYPE, 
IN IN_CSADT_TABLA SII.CGG_SEC_AUDITORIA.CSADT_TABLA%TYPE, 
IN IN_CSADT_OPERACION SII.CGG_SEC_AUDITORIA.CSADT_OPERACION%TYPE, 
IN IN_CSADT_DATO_ANTIGUO SII.CGG_SEC_AUDITORIA.CSADT_DATO_ANTIGUO%TYPE, 
IN IN_CSADT_DATO_NUEVO SII.CGG_SEC_AUDITORIA.CSADT_DATO_NUEVO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_SEC_AUDITORIA SET
		CSADT_FECHA = IN_CSADT_FECHA, 
		CSADT_USUARIO = IN_CSADT_USUARIO, 
		CSADT_IP = IN_CSADT_IP, 
		CSADT_SESION = IN_CSADT_SESION, 
		CSADT_TABLA = IN_CSADT_TABLA, 
		CSADT_OPERACION = IN_CSADT_OPERACION, 
		CSADT_DATO_ANTIGUO = IN_CSADT_DATO_ANTIGUO, 
		CSADT_DATO_NUEVO = IN_CSADT_DATO_NUEVO
	WHERE
		CSADT_CODIGO = IN_CSADT_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_SEC_AUDITORIA
* @param IN_CSADT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_SELECT(
IN IN_CSADT_CODIGO SII.CGG_SEC_AUDITORIA.CSADT_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CSADT_CODIGO, 
		CSADT_FECHA, 
		CSADT_USUARIO, 
		CSADT_IP, 
		CSADT_SESION, 
		CSADT_TABLA, 
		CSADT_OPERACION, 
		CSADT_DATO_ANTIGUO, 
		CSADT_DATO_NUEVO
	FROM SII.CGG_SEC_AUDITORIA
	WHERE 
		CSADT_CODIGO = IN_CSADT_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_SEC_AUDITORIA
* @param IN_CSADT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_DELETE(
IN IN_CSADT_CODIGO SII.CGG_SEC_AUDITORIA.CSADT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_SEC_AUDITORIA
	WHERE
		CSADT_CODIGO = IN_CSADT_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_SEC_AUDITORIA_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_SEC_AUDITORIA
* @param IN_CSADT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_SEC_AUDITORIA_DELETE_SOFT(
IN IN_CSADT_CODIGO SII.CGG_SEC_AUDITORIA.CSADT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_SEC_AUDITORIA SET
		CSADT_ESTADO = FALSE
	WHERE
		CSADT_CODIGO = IN_CSADT_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

