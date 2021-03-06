/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @param IN_CKVDD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
* @param IN_CKVNT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
* @param IN_CKDNM_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
* @param IN_CKVDD_CANTIDAD CANTIDAD
* @param IN_CKVDD_VALOR VALOR MONETARIO DE LA DENOMINACION
* @param IN_CKVDD_TOTAL TOTAL CONTABLE
* @param IN_CKVDD_ESTADO ESTADO DEL REGISTRO
* @param IN_CKVDD_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CKVDD_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_INSERT(
IN IN_CKVDD_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVDD_CODIGO%TYPE, 
IN IN_CKVNT_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVNT_CODIGO%TYPE, 
IN IN_CKDNM_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKDNM_CODIGO%TYPE, 
IN IN_CKVDD_CANTIDAD SII.CGG_KDX_VD_DENOMINACION.CKVDD_CANTIDAD%TYPE, 
IN IN_CKVDD_VALOR SII.CGG_KDX_VD_DENOMINACION.CKVDD_VALOR%TYPE, 
IN IN_CKVDD_TOTAL SII.CGG_KDX_VD_DENOMINACION.CKVDD_TOTAL%TYPE, 
IN IN_CKVDD_ESTADO SII.CGG_KDX_VD_DENOMINACION.CKVDD_ESTADO%TYPE, 
IN IN_CKVDD_USUARIO_INSERT SII.CGG_KDX_VD_DENOMINACION.CKVDD_USUARIO_INSERT%TYPE, 
IN IN_CKVDD_USUARIO_UPDATE SII.CGG_KDX_VD_DENOMINACION.CKVDD_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CKVDD_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_KDX_VD_DENOMINACION','CKVDD_CODIGO','CKVDD') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CKVDD_CODIGO;
	END IF;
	INSERT INTO SII.CGG_KDX_VD_DENOMINACION(
		CKVDD_CODIGO, 
		CKVNT_CODIGO, 
		CKDNM_CODIGO, 
		CKVDD_CANTIDAD, 
		CKVDD_VALOR, 
		CKVDD_TOTAL, 
		CKVDD_ESTADO, 
		CKVDD_FECHA_INSERT, 
		CKVDD_USUARIO_INSERT, 
		CKVDD_FECHA_UPDATE, 
		CKVDD_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CKVNT_CODIGO, 
		IN_CKDNM_CODIGO, 
		IN_CKVDD_CANTIDAD, 
		IN_CKVDD_VALOR, 
		IN_CKVDD_TOTAL, 
		IN_CKVDD_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CKVDD_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CKVDD_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKVDD_CODIGO, 
		CKVNT_CODIGO, 
		CKDNM_CODIGO, 
		CKVDD_CANTIDAD, 
		CKVDD_VALOR, 
		CKVDD_TOTAL, 
		CKVDD_ESTADO, 
		CKVDD_FECHA_INSERT, 
		CKVDD_USUARIO_INSERT, 
		CKVDD_FECHA_UPDATE, 
		CKVDD_USUARIO_UPDATE
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_SELECT(
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
		CKVDD_CODIGO, 
		CKVNT_CODIGO, 
		CKDNM_CODIGO, 
		CKVDD_CANTIDAD, 
		CKVDD_VALOR, 
		CKVDD_TOTAL, 
		CKVDD_ESTADO, 
		CKVDD_FECHA_INSERT, 
		CKVDD_USUARIO_INSERT, 
		CKVDD_FECHA_UPDATE, 
		CKVDD_USUARIO_UPDATE
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CKVDD_CANTIDAD, 0)||'' ''||COALESCE(CKVDD_VALOR, 0)||'' ''||COALESCE(CKVDD_TOTAL, 0)||'' ''||COALESCE(CKVDD_ESTADO, FALSE)||'' ''||COALESCE(CKVDD_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CKVDD_USUARIO_INSERT, '''')||'' ''||COALESCE(CKVDD_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CKVDD_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_KDX_VD_DENOMINACION
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CKVDD_CANTIDAD, 0)||' '||COALESCE(CKVDD_VALOR, 0)||' '||COALESCE(CKVDD_TOTAL, 0)||' '||COALESCE(CKVDD_ESTADO, FALSE)||' '||COALESCE(CKVDD_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CKVDD_USUARIO_INSERT, '''')||' '||COALESCE(CKVDD_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CKVDD_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_KDX_VD_DENOMINACION
* @param IN_CKVDD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
* @param IN_CKVNT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
* @param IN_CKDNM_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
* @param IN_CKVDD_CANTIDAD CANTIDAD
* @param IN_CKVDD_VALOR VALOR MONETARIO DE LA DENOMINACION
* @param IN_CKVDD_TOTAL TOTAL CONTABLE
* @param IN_CKVDD_ESTADO ESTADO DEL REGISTRO
* @param IN_CKVDD_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_UPDATE(
IN IN_CKVDD_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVDD_CODIGO%TYPE, 
IN IN_CKVNT_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVNT_CODIGO%TYPE, 
IN IN_CKDNM_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKDNM_CODIGO%TYPE, 
IN IN_CKVDD_CANTIDAD SII.CGG_KDX_VD_DENOMINACION.CKVDD_CANTIDAD%TYPE, 
IN IN_CKVDD_VALOR SII.CGG_KDX_VD_DENOMINACION.CKVDD_VALOR%TYPE, 
IN IN_CKVDD_TOTAL SII.CGG_KDX_VD_DENOMINACION.CKVDD_TOTAL%TYPE, 
IN IN_CKVDD_ESTADO SII.CGG_KDX_VD_DENOMINACION.CKVDD_ESTADO%TYPE, 
IN IN_CKVDD_USUARIO_UPDATE SII.CGG_KDX_VD_DENOMINACION.CKVDD_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_VD_DENOMINACION SET
		CKVNT_CODIGO = IN_CKVNT_CODIGO, 
		CKDNM_CODIGO = IN_CKDNM_CODIGO, 
		CKVDD_CANTIDAD = IN_CKVDD_CANTIDAD, 
		CKVDD_VALOR = IN_CKVDD_VALOR, 
		CKVDD_TOTAL = IN_CKVDD_TOTAL, 
		CKVDD_ESTADO = IN_CKVDD_ESTADO, 
		CKVDD_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CKVDD_USUARIO_UPDATE = IN_CKVDD_USUARIO_UPDATE
	WHERE
		CKVDD_CODIGO = IN_CKVDD_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @param IN_CKVDD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_SELECT(
IN IN_CKVDD_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVDD_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKVDD_CODIGO, 
		CKVNT_CODIGO, 
		CKDNM_CODIGO, 
		CKVDD_CANTIDAD, 
		CKVDD_VALOR, 
		CKVDD_TOTAL, 
		CKVDD_ESTADO, 
		CKVDD_FECHA_INSERT, 
		CKVDD_USUARIO_INSERT, 
		CKVDD_FECHA_UPDATE, 
		CKVDD_USUARIO_UPDATE
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE AND 
		CKVDD_CODIGO = IN_CKVDD_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @param IN_CKVDD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_DELETE(
IN IN_CKVDD_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVDD_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE
		CKVDD_CODIGO = IN_CKVDD_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_KDX_VD_DENOMINACION
* @param IN_CKVDD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA DETALLE DENOMINACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_DELETE_SOFT(
IN IN_CKVDD_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVDD_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_VD_DENOMINACION SET
		CKVDD_ESTADO = FALSE
	WHERE
		CKVDD_CODIGO = IN_CKVDD_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_S_CGG_KDX_VENTA
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_VD_DENOMINACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_VENTA.
* @param IN_CKVNT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_S_CGG_KDX_VENTA(
IN IN_CKVNT_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVNT_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKVDD_CODIGO, 
		CKVNT_CODIGO, 
		CKDNM_CODIGO, 
		CKVDD_CANTIDAD, 
		CKVDD_VALOR, 
		CKVDD_TOTAL, 
		CKVDD_ESTADO, 
		CKVDD_FECHA_INSERT, 
		CKVDD_USUARIO_INSERT, 
		CKVDD_FECHA_UPDATE, 
		CKVDD_USUARIO_UPDATE
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE AND 
		CKVNT_CODIGO = IN_CKVNT_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_VENTA
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_VD_DENOMINACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_VENTA.
* @param IN_CKVNT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_VENTA(
IN IN_CKVNT_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVNT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE
		CKVNT_CODIGO = IN_CKVNT_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_VENTA
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_VD_DENOMINACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_VENTA.
* @param IN_CKVNT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_DS_CGG_KDX_VENTA(
IN IN_CKVNT_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKVNT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_VD_DENOMINACION SET
		ckvdd_estado = false
	WHERE
		CKVNT_CODIGO = IN_CKVNT_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_S_CGG_KDX_DENOMINACION
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_VD_DENOMINACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_DENOMINACION.
* @param IN_CKDNM_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_S_CGG_KDX_DENOMINACION(
IN IN_CKDNM_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKDNM_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKVDD_CODIGO, 
		CKVNT_CODIGO, 
		CKDNM_CODIGO, 
		CKVDD_CANTIDAD, 
		CKVDD_VALOR, 
		CKVDD_TOTAL, 
		CKVDD_ESTADO, 
		CKVDD_FECHA_INSERT, 
		CKVDD_USUARIO_INSERT, 
		CKVDD_FECHA_UPDATE, 
		CKVDD_USUARIO_UPDATE
	FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE CKVDD_ESTADO = TRUE AND 
		CKDNM_CODIGO = IN_CKDNM_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_DENOMINACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_VD_DENOMINACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_DENOMINACION.
* @param IN_CKDNM_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_DENOMINACION(
IN IN_CKDNM_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKDNM_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_KDX_VD_DENOMINACION
	WHERE
		CKDNM_CODIGO = IN_CKDNM_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_VD_DENOMINACION_D_CGG_KDX_DENOMINACION
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_VD_DENOMINACION QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_DENOMINACION.
* @param IN_CKDNM_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_VD_DENOMINACION_DS_CGG_KDX_DENOMINACION(
IN IN_CKDNM_CODIGO SII.CGG_KDX_VD_DENOMINACION.CKDNM_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_VD_DENOMINACION SET
		ckvdd_estado = false
	WHERE
		CKDNM_CODIGO = IN_CKDNM_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

