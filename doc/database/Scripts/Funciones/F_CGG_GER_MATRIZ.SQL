/**
* FUNCION SII.F_CGG_GER_MATRIZ_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_GER_MATRIZ
* @param IN_CGGMA_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
* @param IN_CGGIN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
* @param IN_CGGMA_MES MES DEL INDICADOR
* @param IN_CGGMA_ANIO AÑO DEL INIDICADOR
* @param IN_CGGMA_VALOR VALOR DEL INDICADOR
* @param IN_CGGMA_DESCRIPCION DESCRIPCION DEL VALOR DE LA MATRIZ
* @param IN_CGGMA_ACTUALIZACIONES NUMERO DE ACTUALIZACIONES DEL REGISTRO
* @param IN_CGGMA_ESTADO ESTADO DEL REGISTRO
* @param IN_CGGMA_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CGGMA_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_INSERT(
IN IN_CGGMA_CODIGO SII.CGG_GER_MATRIZ.CGGMA_CODIGO%TYPE,
IN IN_CCTN_CODIGO SII.CGG_GER_MATRIZ.CCTN_CODIGO%TYPE,
IN IN_CGGIN_CODIGO SII.CGG_GER_MATRIZ.CGGIN_CODIGO%TYPE,
IN IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE,
IN IN_CGGMA_MES SII.CGG_GER_MATRIZ.CGGMA_MES%TYPE,
IN IN_CGGMA_ANIO SII.CGG_GER_MATRIZ.CGGMA_ANIO%TYPE,
IN IN_CGGMA_VALOR SII.CGG_GER_MATRIZ.CGGMA_VALOR%TYPE,
IN IN_CGGMA_DESCRIPCION SII.CGG_GER_MATRIZ.CGGMA_DESCRIPCION%TYPE,
IN IN_CGGMA_ACTUALIZACIONES SII.CGG_GER_MATRIZ.CGGMA_ACTUALIZACIONES%TYPE,
IN IN_CGGMA_ESTADO SII.CGG_GER_MATRIZ.CGGMA_ESTADO%TYPE,
IN IN_CGGMA_USUARIO_INSERT SII.CGG_GER_MATRIZ.CGGMA_USUARIO_INSERT%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CGGMA_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_GER_MATRIZ','CGGMA_CODIGO','CGGMA') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CGGMA_CODIGO;
	END IF;
	INSERT INTO SII.CGG_GER_MATRIZ(
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CCTN_CODIGO, 
		IN_CGGIN_CODIGO, 
		IN_CUSU_CODIGO, 
		IN_CGGMA_MES, 
		IN_CGGMA_ANIO, 
		IN_CGGMA_VALOR, 
		IN_CGGMA_DESCRIPCION, 
		IN_CGGMA_ACTUALIZACIONES, 
		IN_CGGMA_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CGGMA_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CGGMA_USUARIO_INSERT
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_GER_MATRIZ
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_GER_MATRIZ
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_SELECT(
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
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CGGMA_MES, '''')||'' ''||COALESCE(CGGMA_ANIO, '''')||'' ''||COALESCE(CGGMA_VALOR, 0)||'' ''||COALESCE(CGGMA_DESCRIPCION, '''')||'' ''||COALESCE(CGGMA_ACTUALIZACIONES, 0)||'' ''||COALESCE(CGGMA_ESTADO, FALSE)||'' ''||COALESCE(CGGMA_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CGGMA_USUARIO_INSERT, '''')||'' ''||COALESCE(CGGMA_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CGGMA_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GER_MATRIZ
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GER_MATRIZ
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CGGMA_MES, '''')||' '||COALESCE(CGGMA_ANIO, '''')||' '||COALESCE(CGGMA_VALOR, 0)||' '||COALESCE(CGGMA_DESCRIPCION, '''')||' '||COALESCE(CGGMA_ACTUALIZACIONES, 0)||' '||COALESCE(CGGMA_ESTADO, FALSE)||' '||COALESCE(CGGMA_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CGGMA_USUARIO_INSERT, '''')||' '||COALESCE(CGGMA_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CGGMA_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_GER_MATRIZ
* @param IN_CGGMA_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
* @param IN_CGGIN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
* @param IN_CGGMA_MES MES DEL INDICADOR
* @param IN_CGGMA_ANIO AÑO DEL INIDICADOR
* @param IN_CGGMA_VALOR VALOR DEL INDICADOR
* @param IN_CGGMA_DESCRIPCION DESCRIPCION DEL VALOR DE LA MATRIZ
* @param IN_CGGMA_ACTUALIZACIONES NUMERO DE ACTUALIZACIONES DEL REGISTRO
* @param IN_CGGMA_ESTADO ESTADO DEL REGISTRO
* @param IN_CGGMA_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_UPDATE(
IN IN_CGGMA_CODIGO SII.CGG_GER_MATRIZ.CGGMA_CODIGO%TYPE,
IN IN_CCTN_CODIGO SII.CGG_GER_MATRIZ.CCTN_CODIGO%TYPE,
IN IN_CGGIN_CODIGO SII.CGG_GER_MATRIZ.CGGIN_CODIGO%TYPE,
IN IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE,
IN IN_CGGMA_MES SII.CGG_GER_MATRIZ.CGGMA_MES%TYPE,
IN IN_CGGMA_ANIO SII.CGG_GER_MATRIZ.CGGMA_ANIO%TYPE,
IN IN_CGGMA_VALOR SII.CGG_GER_MATRIZ.CGGMA_VALOR%TYPE,
IN IN_CGGMA_DESCRIPCION SII.CGG_GER_MATRIZ.CGGMA_DESCRIPCION%TYPE,
IN IN_CGGMA_ACTUALIZACIONES SII.CGG_GER_MATRIZ.CGGMA_ACTUALIZACIONES%TYPE,
IN IN_CGGMA_ESTADO SII.CGG_GER_MATRIZ.CGGMA_ESTADO%TYPE,
IN IN_CGGMA_USUARIO_UPDATE SII.CGG_GER_MATRIZ.CGGMA_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GER_MATRIZ SET
		CCTN_CODIGO = IN_CCTN_CODIGO, 
		CGGIN_CODIGO = IN_CGGIN_CODIGO, 
		CUSU_CODIGO = IN_CUSU_CODIGO, 
		CGGMA_MES = IN_CGGMA_MES, 
		CGGMA_ANIO = IN_CGGMA_ANIO, 
		CGGMA_VALOR = IN_CGGMA_VALOR, 
		CGGMA_DESCRIPCION = IN_CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES = IN_CGGMA_ACTUALIZACIONES+1, 
		CGGMA_ESTADO = IN_CGGMA_ESTADO, 
		CGGMA_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CGGMA_USUARIO_UPDATE = IN_CGGMA_USUARIO_UPDATE
	WHERE
		CGGMA_CODIGO = IN_CGGMA_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_GER_MATRIZ
* @param IN_CGGMA_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_SELECT(
IN IN_CGGMA_CODIGO SII.CGG_GER_MATRIZ.CGGMA_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE AND 
		CGGMA_CODIGO = IN_CGGMA_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_GER_MATRIZ.
* @param IN_CGGMA_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_DELETE(
IN IN_CGGMA_CODIGO SII.CGG_GER_MATRIZ.CGGMA_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GER_MATRIZ
	WHERE
		CGGMA_CODIGO = IN_CGGMA_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_GER_MATRIZ
* @param IN_CGGMA_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_DELETE_SOFT(
IN IN_CGGMA_CODIGO SII.CGG_GER_MATRIZ.CGGMA_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GER_MATRIZ SET
		CGGMA_ESTADO = FALSE
	WHERE
		CGGMA_CODIGO = IN_CGGMA_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_S_CGG_GER_INDICADOR
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_GER_INDICADOR.
* @param IN_CGGIN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_S_CGG_GER_INDICADOR(
IN IN_CGGIN_CODIGO SII.CGG_GER_MATRIZ.CGGIN_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE AND 
		CGGIN_CODIGO = IN_CGGIN_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_D_CGG_GER_INDICADOR
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_GER_INDICADOR.
* @param IN_CGGIN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_D_CGG_GER_INDICADOR(
IN IN_CGGIN_CODIGO SII.CGG_GER_MATRIZ.CGGIN_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GER_MATRIZ
	WHERE
		CGGIN_CODIGO = IN_CGGIN_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_D_CGG_GER_INDICADOR
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_GER_INDICADOR.
* @param IN_CGGIN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE INDICADOR.
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_DS_CGG_GER_INDICADOR(
IN IN_CGGIN_CODIGO SII.CGG_GER_MATRIZ.CGGIN_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GER_MATRIZ SET
		cggma_estado = false
	WHERE
		CGGIN_CODIGO = IN_CGGIN_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_S_CGG_CANTON
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_CANTON.
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_S_CGG_CANTON(
IN IN_CCTN_CODIGO SII.CGG_GER_MATRIZ.CCTN_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE AND 
		CCTN_CODIGO = IN_CCTN_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_D_CGG_CANTON
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_CANTON.
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_D_CGG_CANTON(
IN IN_CCTN_CODIGO SII.CGG_GER_MATRIZ.CCTN_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GER_MATRIZ
	WHERE
		CCTN_CODIGO = IN_CCTN_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_D_CGG_CANTON
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_CANTON.
* @param IN_CCTN_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_DS_CGG_CANTON(
IN IN_CCTN_CODIGO SII.CGG_GER_MATRIZ.CCTN_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GER_MATRIZ SET
		cggma_estado = false
	WHERE
		CCTN_CODIGO = IN_CCTN_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_S_CGG_USUARIO
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_USUARIO.
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_S_CGG_USUARIO(
IN IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGGMA_CODIGO, 
		CCTN_CODIGO, 
		CGGIN_CODIGO, 
		CUSU_CODIGO, 
		CGGMA_MES, 
		CGGMA_ANIO, 
		CGGMA_VALOR, 
		CGGMA_DESCRIPCION, 
		CGGMA_ACTUALIZACIONES, 
		CGGMA_ESTADO, 
		CGGMA_FECHA_INSERT, 
		CGGMA_USUARIO_INSERT, 
		CGGMA_FECHA_UPDATE, 
		CGGMA_USUARIO_UPDATE
	FROM SII.CGG_GER_MATRIZ
	WHERE CGGMA_ESTADO = TRUE AND 
		CUSU_CODIGO = IN_CUSU_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_D_CGG_USUARIO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_USUARIO.
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_D_CGG_USUARIO(
IN IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GER_MATRIZ
	WHERE
		CUSU_CODIGO = IN_CUSU_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_D_CGG_USUARIO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GER_MATRIZ QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_USUARIO.
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_DS_CGG_USUARIO(
IN IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GER_MATRIZ SET
		cggma_estado = false
	WHERE
		CUSU_CODIGO = IN_CUSU_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GER_MATRIZ_SELECT_GRID
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_GER_MATRIZ
* @param IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE CODIGO DEL USUARIO
* @param CGGIN_CODIGO CODIGO DEL INDICADOR
* @param CGGMA_ANIO AÑO DEL INDICADOR
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GER_MATRIZ_SELECT_GRID(
IN IN_CUSU_CODIGO SII.CGG_GER_MATRIZ.CUSU_CODIGO%TYPE,
IN CGGIN_CODIGO VARCHAR,
IN CGGMA_ANIO VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_SQL TEXT;
	TMP_REF REFCURSOR;
BEGIN
	TMP_SQL := 'SELECT DISTINCT(CCTN.CCTN_CODIGO),CCTN.CCTN_NOMBRE,array_to_string(ARRAY(
			SELECT 
				''''''''||CGGMA_MES||'''''':{''''CGGMA_CODIGO'''':''''''||CGGMA_CODIGO||
				'''''',''''CCTN_CODIGO'''':''''''||CCTN_CODIGO||
				'''''',''''CGGIN_CODIGO'''':''''''||CGGIN_CODIGO||
				'''''',''''CUSU_CODIGO'''':''''''||SII.F_CUSU_NOMBRE_PERSONA(CUSU_CODIGO,0)||
				'''''',''''CRCRG_NOMBRE'''':''''''||SII.F_CUSU_CARGO_PERSONA(CUSU_CODIGO,0)||				
				'''''',''''CGGMA_MES'''':''''''||CGGMA_MES||
				'''''',''''CGGMA_ANIO'''':''''''||CGGMA_ANIO||
				'''''',''''CGGMA_DESCRIPCION'''':''''''||CGGMA_DESCRIPCION||	
				'''''',''''CGGMA_VALOR'''':''''''||CGGMA_VALOR||
				'''''',''''CGGMA_ACTUALIZACIONES'''':''''''||CGGMA_ACTUALIZACIONES||
				'''''',''''CGGMA_USUARIO_UPDATE'''':''''''||CGGMA_VALOR||
				'''''',''''CGGMA_FECHA_UPDATE'''':''''''||to_char(CGGMA_FECHA_UPDATE,''dd/mm/YYYY HH24:MI'')||''''''}''
			FROM CGG_GER_MATRIZ
			WHERE CGGMA_ESTADO AND CGGMA_ANIO = '''||CGGMA_ANIO ||'''  AND
			CCTN_CODIGO = CGGMA.CCTN_CODIGO  AND
			CGGIN_CODIGO = '''||CGGIN_CODIGO||'''
			),'','') JSON_INFO
		FROM CGG_GER_MATRIZ CGGMA
		RIGHT JOIN CGG_CANTON CCTN ON CGGMA.CCTN_CODIGO = CCTN.CCTN_CODIGO
		WHERE CCTN.CCTN_CODIGO in (''74'',''75'',''76'') ORDER BY CCTN.CCTN_CODIGO';	
	OPEN TMP_REF FOR EXECUTE TMP_SQL;	
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;
