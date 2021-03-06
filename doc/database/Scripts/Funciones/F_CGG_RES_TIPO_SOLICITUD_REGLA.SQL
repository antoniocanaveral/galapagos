/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_CRTSE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @param IN_CRTSE_CAMPO_EVALUACION CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
* @param IN_CRTSE_VALOR_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
* @param IN_CRTSE_ESTADO ESTADO DEL REGISTRO
* @param IN_CRTSE_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CRTSE_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_INSERT(
IN IN_CRTSE_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CODIGO%TYPE, 
IN IN_CRTST_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTST_CODIGO%TYPE, 
IN IN_CRVAL_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRVAL_CODIGO%TYPE, 
IN IN_CRTSE_CAMPO_EVALUACION SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CAMPO_EVALUACION%TYPE, 
IN IN_CRTSE_VALOR_1 SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_VALOR_1%TYPE, 
IN IN_CRTSE_ESTADO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_ESTADO%TYPE, 
IN IN_CRTSE_USUARIO_INSERT SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_USUARIO_INSERT%TYPE, 
IN IN_CRTSE_USUARIO_UPDATE SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CRTSE_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_TIPO_SOLICITUD_REGLA','CRTSE_CODIGO','CRTSE') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRTSE_CODIGO;
	END IF;
	INSERT INTO SII.CGG_RES_TIPO_SOLICITUD_REGLA(
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1, 
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CRTST_CODIGO, 
		IN_CRVAL_CODIGO, 
		IN_CRTSE_CAMPO_EVALUACION, 
		IN_CRTSE_VALOR_1, 
		IN_CRTSE_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CRTSE_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CRTSE_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1, 
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT(
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
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1, 
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CRTSE_CAMPO_EVALUACION, '''')||'' ''||COALESCE(CRTSE_VALOR_1, '''')||'' ''||COALESCE(CRTSE_ESTADO, FALSE)||'' ''||COALESCE(CRTSE_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CRTSE_USUARIO_INSERT, '''')||'' ''||COALESCE(CRTSE_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CRTSE_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CRTSE_CAMPO_EVALUACION, '''')||' '||COALESCE(CRTSE_VALOR_1, '''')||' '||COALESCE(CRTSE_ESTADO, FALSE)||' '||COALESCE(CRTSE_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CRTSE_USUARIO_INSERT, '''')||' '||COALESCE(CRTSE_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CRTSE_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_CRTSE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @param IN_CRTSE_CAMPO_EVALUACION CADENA DE TEXTO DE CAMPO QUE SE VA A EVALUAR CON LA REGLA DE VALIDACION
* @param IN_CRTSE_VALOR_1 CADENA DE TEXTO DE VALOR NUMERICO AUXILIAR PARA VALORES ADICIONALES DE LA TABLA
* @param IN_CRTSE_ESTADO ESTADO DEL REGISTRO
* @param IN_CRTSE_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_UPDATE(
IN IN_CRTSE_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CODIGO%TYPE, 
IN IN_CRTST_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTST_CODIGO%TYPE, 
IN IN_CRVAL_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRVAL_CODIGO%TYPE, 
IN IN_CRTSE_CAMPO_EVALUACION SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CAMPO_EVALUACION%TYPE, 
IN IN_CRTSE_VALOR_1 SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_VALOR_1%TYPE, 
IN IN_CRTSE_ESTADO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_ESTADO%TYPE, 
IN IN_CRTSE_USUARIO_UPDATE SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_TIPO_SOLICITUD_REGLA SET
		CRTST_CODIGO = IN_CRTST_CODIGO, 
		CRVAL_CODIGO = IN_CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION = IN_CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1 = IN_CRTSE_VALOR_1, 
		CRTSE_ESTADO = IN_CRTSE_ESTADO, 
		CRTSE_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CRTSE_USUARIO_UPDATE = IN_CRTSE_USUARIO_UPDATE
	WHERE
		CRTSE_CODIGO = IN_CRTSE_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_CRTSE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_SELECT(
IN IN_CRTSE_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1, 
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE AND 
		CRTSE_CODIGO = IN_CRTSE_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_CRTSE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_DELETE(
IN IN_CRTSE_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE
		CRTSE_CODIGO = IN_CRTSE_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA
* @param IN_CRTSE_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE TIPO DE SOLICITUD
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_DELETE_SOFT(
IN IN_CRTSE_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTSE_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_TIPO_SOLICITUD_REGLA SET
		CRTSE_ESTADO = FALSE
	WHERE
		CRTSE_CODIGO = IN_CRTSE_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_REGLA_VALIDACION
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_REGLA_VALIDACION.
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_REGLA_VALIDACION(
IN IN_CRVAL_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRVAL_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1, 
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE AND 
		CRVAL_CODIGO = IN_CRVAL_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_REGLA_VALIDACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_REGLA_VALIDACION.
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_REGLA_VALIDACION(
IN IN_CRVAL_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRVAL_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE
		CRVAL_CODIGO = IN_CRVAL_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_REGLA_VALIDACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_REGLA_VALIDACION.
* @param IN_CRVAL_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_DS_CGG_REGLA_VALIDACION(
IN IN_CRVAL_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRVAL_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_TIPO_SOLICITUD_REGLA SET
		crtse_estado = false
	WHERE
		CRVAL_CODIGO = IN_CRVAL_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_RES_TIPO_SOLICITUD_TRAMITE
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_TIPO_SOLICITUD_TRAMITE.
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_RES_TIPO_SOLICITUD_TRAMITE(
IN IN_CRTST_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTST_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO, 
		CRTSE_CAMPO_EVALUACION, 
		CRTSE_VALOR_1, 
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE CRTSE_ESTADO = TRUE AND 
		CRTST_CODIGO = IN_CRTST_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_RES_TIPO_SOLICITUD_TRAMITE
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_TIPO_SOLICITUD_TRAMITE.
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_RES_TIPO_SOLICITUD_TRAMITE(
IN IN_CRTST_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTST_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA
	WHERE
		CRTST_CODIGO = IN_CRTST_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_D_CGG_RES_TIPO_SOLICITUD_TRAMITE
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_TIPO_SOLICITUD_TRAMITE.
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_DS_CGG_RES_TIPO_SOLICITUD_TRAMITE(
IN IN_CRTST_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTST_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_TIPO_SOLICITUD_REGLA SET
		crtse_estado = false
	WHERE
		CRTST_CODIGO = IN_CRTST_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;
/**
* FUNCION SII.F_CGG_RES_TIPO_SOLICITUD_REGLA_S_CGG_RES_TIPO_SOLICITUD_TRAMITE1
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_TIPO_SOLICITUD_REGLA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_TIPO_SOLICITUD_TRAMITE.
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_TIPO_SOLIC_REGLA_S_CGG_RES_TIPO_SOLIC_TRAMITE1(
IN IN_CRTST_CODIGO SII.CGG_RES_TIPO_SOLICITUD_REGLA.CRTST_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	select 
		CRTSE_CODIGO, 
		CRTST_CODIGO, 
		CRVAL_CODIGO,
		CRVAL_NOMBRE,
		trim(substring(CRTSE_CAMPO_EVALUACION from '^(.*:)'),'":"') CRTSE_VALOR_1,
		trim(SUBSTRING(CRTSE_CAMPO_EVALUACION,position(':' in CRTSE_CAMPO_EVALUACION)+1,length(CRTSE_CAMPO_EVALUACION)),'"') CRTSE_CAMPO_EVALUACION,
		CRTSE_ESTADO, 
		CRTSE_FECHA_INSERT, 
		CRTSE_USUARIO_INSERT, 
		CRTSE_FECHA_UPDATE, 
		CRTSE_USUARIO_UPDATE
	from 
	(SELECT
			CRTSE_CODIGO, 
			CRTST_CODIGO, 
			CRTSE.CRVAL_CODIGO,
			CRVAL.CRVAL_NOMBRE, 
			regexp_split_to_table(trim(CRTSE_CAMPO_EVALUACION::text, '[{}]'), E',') CRTSE_CAMPO_EVALUACION,
			CRTSE_VALOR_1, 
			CRTSE_ESTADO, 
			CRTSE_FECHA_INSERT, 
			CRTSE_USUARIO_INSERT, 
			CRTSE_FECHA_UPDATE, 
			CRTSE_USUARIO_UPDATE
		FROM SII.CGG_RES_TIPO_SOLICITUD_REGLA CRTSE
		INNER JOIN SII.CGG_REGLA_VALIDACION CRVAL
		ON(CRTSE.CRVAL_CODIGO = CRVAL.CRVAL_CODIGO)
		WHERE CRTSE_ESTADO = TRUE AND 
		CRTST_CODIGO = IN_CRTST_CODIGO) CGG_RES_TIPO_SOLICITUD_REGLA ; 
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

