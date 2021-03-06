/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @param IN_CGARE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
* @param IN_CGARE_NOMBRE IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
* @param IN_CGARE_DESCRIPCION NO ESPECIFICADO
* @param IN_CGARE_ESTADO ESTADO DEL REGISTRO
* @param IN_CGARE_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CGARE_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_INSERT(
IN IN_CGARE_CODIGO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_CODIGO%TYPE, 
IN IN_CGARE_NOMBRE SII.CGG_GEM_AREA_FUNCIONAL.CGARE_NOMBRE%TYPE, 
IN IN_CGARE_DESCRIPCION SII.CGG_GEM_AREA_FUNCIONAL.CGARE_DESCRIPCION%TYPE, 
IN IN_CGARE_ESTADO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_ESTADO%TYPE, 
IN IN_CGARE_USUARIO_INSERT SII.CGG_GEM_AREA_FUNCIONAL.CGARE_USUARIO_INSERT%TYPE, 
IN IN_CGARE_USUARIO_UPDATE SII.CGG_GEM_AREA_FUNCIONAL.CGARE_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
TMP_COUNT INT2;
BEGIN
	SELECT COUNT(CGARE_NOMBRE) INTO TMP_COUNT
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE AND UPPER(CGARE_NOMBRE) = UPPER(RTRIM(LTRIM(IN_CGARE_NOMBRE)));
	
	IF (TMP_COUNT>0) THEN
		RAISE EXCEPTION 'No se puede ingresar varias �reas funcionales con el mismo nombre';
	END IF;
	
	IF (UPPER(IN_CGARE_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_GEM_AREA_FUNCIONAL','CGARE_CODIGO','CGARE') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CGARE_CODIGO;
	END IF;
	INSERT INTO SII.CGG_GEM_AREA_FUNCIONAL(
		CGARE_CODIGO, 
		CGARE_NOMBRE, 
		CGARE_DESCRIPCION, 
		CGARE_ESTADO, 
		CGARE_FECHA_INSERT, 
		CGARE_USUARIO_INSERT, 
		CGARE_FECHA_UPDATE, 
		CGARE_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CGARE_NOMBRE, 
		IN_CGARE_DESCRIPCION, 
		IN_CGARE_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CGARE_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CGARE_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGARE_CODIGO, 
		CGARE_NOMBRE, 
		CGARE_DESCRIPCION, 
		CGARE_ESTADO, 
		CGARE_FECHA_INSERT, 
		CGARE_USUARIO_INSERT, 
		CGARE_FECHA_UPDATE, 
		CGARE_USUARIO_UPDATE
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_SELECT(
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
		CGARE_CODIGO, 
		CGARE_NOMBRE, 
		CGARE_DESCRIPCION, 
		CGARE_ESTADO, 
		CGARE_FECHA_INSERT, 
		CGARE_USUARIO_INSERT, 
		CGARE_FECHA_UPDATE, 
		CGARE_USUARIO_UPDATE
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CGARE_NOMBRE, '''')||'' ''||COALESCE(CGARE_DESCRIPCION, '''')||'' ''||COALESCE(CGARE_ESTADO, FALSE)||'' ''||COALESCE(CGARE_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CGARE_USUARIO_INSERT, '''')||'' ''||COALESCE(CGARE_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CGARE_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GEM_AREA_FUNCIONAL
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CGARE_NOMBRE, '''')||' '||COALESCE(CGARE_DESCRIPCION, '''')||' '||COALESCE(CGARE_ESTADO, FALSE)||' '||COALESCE(CGARE_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CGARE_USUARIO_INSERT, '''')||' '||COALESCE(CGARE_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CGARE_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_GEM_AREA_FUNCIONAL.
* @param IN_CGARE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
* @param IN_CGARE_NOMBRE IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
* @param IN_CGARE_DESCRIPCION NO ESPECIFICADO
* @param IN_CGARE_ESTADO ESTADO DEL REGISTRO
* @param IN_CGARE_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_UPDATE(
IN IN_CGARE_CODIGO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_CODIGO%TYPE, 
IN IN_CGARE_NOMBRE SII.CGG_GEM_AREA_FUNCIONAL.CGARE_NOMBRE%TYPE, 
IN IN_CGARE_DESCRIPCION SII.CGG_GEM_AREA_FUNCIONAL.CGARE_DESCRIPCION%TYPE, 
IN IN_CGARE_ESTADO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_ESTADO%TYPE, 
IN IN_CGARE_USUARIO_UPDATE SII.CGG_GEM_AREA_FUNCIONAL.CGARE_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
DECLARE
TMP_COUNT INT2;
TMP_NOMBRE VARCHAR;
TMP INT2;
BEGIN
	
	SELECT COUNT(CGARE_NOMBRE) INTO TMP_COUNT
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE AND UPPER(CGARE_NOMBRE) = UPPER(RTRIM(LTRIM(IN_CGARE_NOMBRE)));
	
	SELECT CGARE_NOMBRE INTO TMP_NOMBRE
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_CODIGO = IN_CGARE_CODIGO; 
	
	IF (TMP_NOMBRE <> IN_CGARE_NOMBRE) THEN
		TMP := 0;
	ELSE
		TMP :=1;
	END IF;
	
	IF (TMP_COUNT>TMP) THEN
		RAISE EXCEPTION 'No se puede ingresar varias �reas funcionales con el mismo nombre';
	END IF;
	
	UPDATE SII.CGG_GEM_AREA_FUNCIONAL SET
		CGARE_NOMBRE = IN_CGARE_NOMBRE, 
		CGARE_DESCRIPCION = IN_CGARE_DESCRIPCION, 
		CGARE_ESTADO = IN_CGARE_ESTADO, 
		CGARE_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CGARE_USUARIO_UPDATE = IN_CGARE_USUARIO_UPDATE
	WHERE
		CGARE_CODIGO = IN_CGARE_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @param IN_CGARE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_SELECT(
IN IN_CGARE_CODIGO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGARE_CODIGO, 
		CGARE_NOMBRE, 
		CGARE_DESCRIPCION, 
		CGARE_ESTADO, 
		CGARE_FECHA_INSERT, 
		CGARE_USUARIO_INSERT, 
		CGARE_FECHA_UPDATE, 
		CGARE_USUARIO_UPDATE
	FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE CGARE_ESTADO = TRUE AND 
		CGARE_CODIGO = IN_CGARE_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @param IN_CGARE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_DELETE(
IN IN_CGARE_CODIGO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GEM_AREA_FUNCIONAL
	WHERE
		CGARE_CODIGO = IN_CGARE_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_AREA_FUNCIONAL_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_GEM_AREA_FUNCIONAL.
* @param IN_CGARE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_AREA_FUNCIONAL_DELETE_SOFT(
IN IN_CGARE_CODIGO SII.CGG_GEM_AREA_FUNCIONAL.CGARE_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GEM_AREA_FUNCIONAL SET
		CGARE_ESTADO = FALSE
	WHERE
		CGARE_CODIGO = IN_CGARE_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

