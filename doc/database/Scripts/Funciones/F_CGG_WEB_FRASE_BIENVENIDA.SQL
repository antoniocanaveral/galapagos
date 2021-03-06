/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* @param IN_CWFB_CODIGO IDENTIFICATIVO UNICO DE REGSITRO
* @param IN_CWFB_CONTENIDO CONTENIDO DE LA FRASE O MENSAJE
* @param IN_CWFB_HIBILITADO HABILIDATO PARA MOSTRAR O NO
* @param IN_CWFB_ESTADO ESTADO DEL REGISTRO
* @param IN_CWFB_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CWFB_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_INSERT(
IN IN_CWFB_CODIGO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CODIGO%TYPE,
IN IN_CWFB_CONTENIDO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CONTENIDO%TYPE,
IN IN_CWFB_HIBILITADO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_HIBILITADO%TYPE,
IN IN_CWFB_ESTADO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_ESTADO%TYPE,
IN IN_CWFB_USUARIO_INSERT SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_USUARIO_INSERT%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CWFB_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_WEB_FRASE_BIENVENIDA','CWFB_CODIGO','CWFB') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CWFB_CODIGO;
	END IF;
	INSERT INTO SII.CGG_WEB_FRASE_BIENVENIDA(
		CWFB_CODIGO, 
		CWFB_CONTENIDO, 
		CWFB_HIBILITADO, 
		CWFB_ESTADO, 
		CWFB_FECHA_INSERT, 
		CWFB_USUARIO_INSERT, 
		CWFB_FECHA_UPDATE, 
		CWFB_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CWFB_CONTENIDO, 
		IN_CWFB_HIBILITADO, 
		IN_CWFB_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CWFB_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CWFB_USUARIO_INSERT
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_SELECT(
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
		CWFB_CODIGO, 
		CWFB_CONTENIDO, 
		CWFB_HIBILITADO,
		CWFB_ESTADO
	FROM SII.CGG_WEB_FRASE_BIENVENIDA
	WHERE CWFB_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
		COALESCE(CWFB_CONTENIDO, '''')||'' ''||
		COALESCE(CWFB_HIBILITADO, FALSE)
	) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_WEB_FRASE_BIENVENIDA
	WHERE CWFB_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_WEB_FRASE_BIENVENIDA
	WHERE CWFB_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,
		COALESCE(CWFB_CONTENIDO, '''')||' '||
		COALESCE(CWFB_HIBILITADO, FALSE)
	) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_WEB_FRASE_BIENVENIDA
* @param IN_CWFB_CODIGO IDENTIFICATIVO UNICO DE REGSITRO
* @param IN_CWFB_CONTENIDO CONTENIDO DE LA FRASE O MENSAJE
* @param IN_CWFB_HIBILITADO HABILIDATO PARA MOSTRAR O NO
* @param IN_CWFB_ESTADO ESTADO DEL REGISTRO
* @param IN_CWFB_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_UPDATE(
IN IN_CWFB_CODIGO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CODIGO%TYPE,
IN IN_CWFB_CONTENIDO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CONTENIDO%TYPE,
IN IN_CWFB_HIBILITADO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_HIBILITADO%TYPE,
IN IN_CWFB_ESTADO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_ESTADO%TYPE,
IN IN_CWFB_USUARIO_UPDATE SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_WEB_FRASE_BIENVENIDA SET
		CWFB_CONTENIDO = IN_CWFB_CONTENIDO, 
		CWFB_HIBILITADO = IN_CWFB_HIBILITADO, 
		CWFB_ESTADO = IN_CWFB_ESTADO, 
		CWFB_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CWFB_USUARIO_UPDATE = IN_CWFB_USUARIO_UPDATE
	WHERE
		CWFB_CODIGO = IN_CWFB_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* @param IN_CWFB_CODIGO IDENTIFICATIVO UNICO DE REGSITRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_DELETE(
IN IN_CWFB_CODIGO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_WEB_FRASE_BIENVENIDA
	WHERE
		CWFB_CODIGO = IN_CWFB_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* @param IN_CWFB_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_DELETE_SOFT(
IN IN_CWFB_CODIGO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_WEB_FRASE_BIENVENIDA SET
		CWFB_ESTADO = FALSE
	WHERE
		CWFB_CODIGO = IN_CWFB_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;


/**
* FUNCION SII.F_CGG_WEB_FRASE_BIENVENIDA_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_WEB_FRASE_BIENVENIDA
* @param IN_CWFB_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_WEB_FRASE_BIENVENIDA_SELECT(
IN IN_CWFB_CODIGO SII.CGG_WEB_FRASE_BIENVENIDA.CWFB_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
	TMP_CWFB_CODIGO VARCHAR;
BEGIN
	OPEN TMP_REF FOR	
	SELECT
		CWFB_CODIGO, 
		CWFB_CONTENIDO, 
		CWFB_HIBILITADO, 
		CWFB_ESTADO		
	FROM SII.CGG_WEB_FRASE_BIENVENIDA
	WHERE CWFB_ESTADO = TRUE AND CWFB_HIBILITADO=TRUE		
	ORDER BY RANDOM() LIMIT 1;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;