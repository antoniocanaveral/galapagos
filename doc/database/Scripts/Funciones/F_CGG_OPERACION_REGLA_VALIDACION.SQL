/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @param IN_CORV_CODIGO IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @param IN_COPVL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
* @param IN_CORV_CAMPO_EVALUACION CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
* @param IN_CORV_VALOR_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
* @param IN_CORV_ESTADO ESTADO DEL REGISTRO
* @param IN_CORV_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CORV_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_INSERT(
IN IN_CORV_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CODIGO%TYPE, 
IN IN_CRVAL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CRVAL_CODIGO%TYPE, 
IN IN_COPVL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.COPVL_CODIGO%TYPE, 
IN IN_CORV_CAMPO_EVALUACION SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CAMPO_EVALUACION%TYPE, 
IN IN_CORV_VALOR_1 SII.CGG_OPERACION_REGLA_VALIDACION.CORV_VALOR_1%TYPE, 
IN IN_CORV_ESTADO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_ESTADO%TYPE, 
IN IN_CORV_USUARIO_INSERT SII.CGG_OPERACION_REGLA_VALIDACION.CORV_USUARIO_INSERT%TYPE, 
IN IN_CORV_USUARIO_UPDATE SII.CGG_OPERACION_REGLA_VALIDACION.CORV_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CORV_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_OPERACION_REGLA_VALIDACION','CORV_CODIGO','CORV') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CORV_CODIGO;
	END IF;
	INSERT INTO SII.CGG_OPERACION_REGLA_VALIDACION(
		CORV_CODIGO, 
		CRVAL_CODIGO, 
		COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1, 
		CORV_ESTADO, 
		CORV_FECHA_INSERT, 
		CORV_USUARIO_INSERT, 
		CORV_FECHA_UPDATE, 
		CORV_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CRVAL_CODIGO, 
		IN_COPVL_CODIGO, 
		IN_CORV_CAMPO_EVALUACION, 
		IN_CORV_VALOR_1, 
		IN_CORV_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CORV_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CORV_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CORV_CODIGO, 
		CRVAL_CODIGO, 
		COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1, 
		CORV_ESTADO, 
		CORV_FECHA_INSERT, 
		CORV_USUARIO_INSERT, 
		CORV_FECHA_UPDATE, 
		CORV_USUARIO_UPDATE
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_SELECT(
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
		CORV_CODIGO, 
		CRVAL_CODIGO, 
		COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1, 
		CORV_ESTADO, 
		CORV_FECHA_INSERT, 
		CORV_USUARIO_INSERT, 
		CORV_FECHA_UPDATE, 
		CORV_USUARIO_UPDATE
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CORV_CAMPO_EVALUACION, '''')||'' ''||COALESCE(CORV_VALOR_1, 0)||'' ''||COALESCE(CORV_ESTADO, FALSE)||'' ''||COALESCE(CORV_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CORV_USUARIO_INSERT, '''')||'' ''||COALESCE(CORV_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CORV_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CORV_CAMPO_EVALUACION, '''')||' '||COALESCE(CORV_VALOR_1, 0)||' '||COALESCE(CORV_ESTADO, FALSE)||' '||COALESCE(CORV_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CORV_USUARIO_INSERT, '''')||' '||COALESCE(CORV_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CORV_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_OPERACION_REGLA_VALIDACION
* @param IN_CORV_CODIGO IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @param IN_COPVL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
* @param IN_CORV_CAMPO_EVALUACION CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
* @param IN_CORV_VALOR_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
* @param IN_CORV_ESTADO ESTADO DEL REGISTRO
* @param IN_CORV_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_UPDATE(
IN IN_CORV_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CODIGO%TYPE, 
IN IN_CRVAL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CRVAL_CODIGO%TYPE, 
IN IN_COPVL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.COPVL_CODIGO%TYPE, 
IN IN_CORV_CAMPO_EVALUACION SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CAMPO_EVALUACION%TYPE, 
IN IN_CORV_VALOR_1 SII.CGG_OPERACION_REGLA_VALIDACION.CORV_VALOR_1%TYPE, 
IN IN_CORV_ESTADO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_ESTADO%TYPE, 
IN IN_CORV_USUARIO_UPDATE SII.CGG_OPERACION_REGLA_VALIDACION.CORV_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_OPERACION_REGLA_VALIDACION SET
		CRVAL_CODIGO = IN_CRVAL_CODIGO, 
		COPVL_CODIGO = IN_COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION = IN_CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1 = IN_CORV_VALOR_1, 
		CORV_ESTADO = IN_CORV_ESTADO, 
		CORV_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CORV_USUARIO_UPDATE = IN_CORV_USUARIO_UPDATE
	WHERE
		CORV_CODIGO = IN_CORV_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @param IN_CORV_CODIGO IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_SELECT(
IN IN_CORV_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CORV_CODIGO, 
		CRVAL_CODIGO, 
		COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1, 
		CORV_ESTADO, 
		CORV_FECHA_INSERT, 
		CORV_USUARIO_INSERT, 
		CORV_FECHA_UPDATE, 
		CORV_USUARIO_UPDATE
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE AND 
		CORV_CODIGO = IN_CORV_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @param IN_CORV_CODIGO IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_DELETE(
IN IN_CORV_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE
		CORV_CODIGO = IN_CORV_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION
* @param IN_CORV_CODIGO IDENTIFICATIVO UNICO DE REGISTRO OPERACION REGLA DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_DELETE_SOFT(
IN IN_CORV_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CORV_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_OPERACION_REGLA_VALIDACION SET
		CORV_ESTADO = FALSE
	WHERE
		CORV_CODIGO = IN_CORV_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_OPERACION_VALIDACION
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_OPERACION_VALIDACION.
* @param IN_COPVL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_OPERACION_VALIDACION(
IN IN_COPVL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.COPVL_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CORV_CODIGO, 
		CRVAL_CODIGO, 
		COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1, 
		CORV_ESTADO, 
		CORV_FECHA_INSERT, 
		CORV_USUARIO_INSERT, 
		CORV_FECHA_UPDATE, 
		CORV_USUARIO_UPDATE
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE AND 
		COPVL_CODIGO = IN_COPVL_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_OPERACION_VALIDACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_OPERACION_VALIDACION.
* @param IN_COPVL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_OPERACION_VALIDACION(
IN IN_COPVL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.COPVL_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE
		COPVL_CODIGO = IN_COPVL_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_OPERACION_VALIDACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_OPERACION_VALIDACION.
* @param IN_COPVL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_DS_CGG_OPERACION_VALIDACION(
IN IN_COPVL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.COPVL_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_OPERACION_REGLA_VALIDACION SET
		corv_estado = false
	WHERE
		COPVL_CODIGO = IN_COPVL_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_REGLA_VALIDACION
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_REGLA_VALIDACION.
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_REGLA_VALIDACION(
IN IN_CRVAL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CRVAL_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CORV_CODIGO, 
		CRVAL_CODIGO, 
		COPVL_CODIGO, 
		CORV_CAMPO_EVALUACION, 
		CORV_VALOR_1, 
		CORV_ESTADO, 
		CORV_FECHA_INSERT, 
		CORV_USUARIO_INSERT, 
		CORV_FECHA_UPDATE, 
		CORV_USUARIO_UPDATE
	FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE CORV_ESTADO = TRUE AND 
		CRVAL_CODIGO = IN_CRVAL_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_REGLA_VALIDACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_REGLA_VALIDACION.
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_REGLA_VALIDACION(
IN IN_CRVAL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CRVAL_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_OPERACION_REGLA_VALIDACION
	WHERE
		CRVAL_CODIGO = IN_CRVAL_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_D_CGG_REGLA_VALIDACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_REGLA_VALIDACION.
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_DS_CGG_REGLA_VALIDACION(
IN IN_CRVAL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.CRVAL_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_OPERACION_REGLA_VALIDACION SET
		corv_estado = false
	WHERE
		CRVAL_CODIGO = IN_CRVAL_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_OPERACION_VALIDACION1
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA CGG_OPERACION_REGLA_VALIDACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_OPERACION_VALIDACION.
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_OPERACION_REGLA_VALIDACION_S_CGG_OPERACION_VALIDACION1(
IN IN_COPVL_CODIGO SII.CGG_OPERACION_REGLA_VALIDACION.COPVL_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	select 
		CORV_CODIGO, 
		COPVL_CODIGO, 
		CRVAL_CODIGO,
		CRVAL_NOMBRE, 
		trim(substring(CORV_CAMPO_EVALUACION from '^(.*:)'),'":"') CORV_VALOR_1,
		trim(SUBSTRING(CORV_CAMPO_EVALUACION,position(':' in CORV_CAMPO_EVALUACION)+1,length(CORV_CAMPO_EVALUACION)),'"') CORV_CAMPO_EVALUACION
	from 
	(SELECT
			CORV_CODIGO, 
			COPVL_CODIGO, 
			CORV.CRVAL_CODIGO,
			CRVAL.CRVAL_NOMBRE, 
			regexp_split_to_table(trim(CORV_CAMPO_EVALUACION, '[{}]'), E',') CORV_CAMPO_EVALUACION,
			CORV_VALOR_1
		FROM SII.CGG_OPERACION_REGLA_VALIDACION CORV
		INNER JOIN SII.CGG_REGLA_VALIDACION CRVAL
		ON(CORV.CRVAL_CODIGO = CRVAL.CRVAL_CODIGO)
		WHERE CORV_ESTADO = TRUE AND 
		COPVL_CODIGO = IN_COPVL_CODIGO) CGG_OPERACION_REGLA_VALIDACION ; 
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;


