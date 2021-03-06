/**
* FUNCION SII.F_CGG_KDX_KARDEX_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_KDX_KARDEX
* @param IN_CKKRD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
* @param IN_CKESP_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
* @param IN_CKKRD_NUMERO NUMERO DEL MOVIMIENTO
* @param IN_CKKRD_DETALLE DETALLE DEL MOVIMIENTO
* @param IN_CKKRD_FECHA_REGISTRO FECHA DE REGISTRO DE MOVIMIENTO
* @param IN_CKKRD_TIPO_MOVIMIENTO TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

* @param IN_CKKRD_TIPO_OPERACION TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
* @param IN_CKKRD_INGRESO_CANTIDAD CANTIDAD DE ESPECIES QUE INGRESARON
* @param IN_CKKRD_INGRESO_PU PRECIO UNITARIO DE COMPRA
* @param IN_CKKRD_INGRESO_TOTAL TOTAL CONTABLE DE INGRESO
* @param IN_CKKRD_SALIDA_CANTIDAD CANTIDAD DE ESPECIES ENTREGADAS
* @param IN_CKKRD_SALIDA_PU PRECIO UNITARIO DE VENTA
* @param IN_CKKRD_SALIDA_TOTAL TOTAL CONTABLE DE VENTA
* @param IN_CKKRD_TOTAL_CANTIDAD CANTIDAD TOTAL
* @param IN_CKKRD_TOTAL_PU PRECIO UNITARIO
* @param IN_CKKRD_TOTAL_TOTAL TOTAL CONTABLE
* @param IN_CKKRD_ESTADO ESTADO DEL REGISTRO
* @param IN_CKKRD_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CKKRD_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_INSERT(
IN IN_CKKRD_CODIGO SII.CGG_KDX_KARDEX.CKKRD_CODIGO%TYPE, 
IN IN_CKESP_CODIGO SII.CGG_KDX_KARDEX.CKESP_CODIGO%TYPE, 
IN IN_CKKRD_NUMERO SII.CGG_KDX_KARDEX.CKKRD_NUMERO%TYPE, 
IN IN_CKKRD_DETALLE SII.CGG_KDX_KARDEX.CKKRD_DETALLE%TYPE, 
IN IN_CKKRD_FECHA_REGISTRO SII.CGG_KDX_KARDEX.CKKRD_FECHA_REGISTRO%TYPE, 
IN IN_CKKRD_TIPO_MOVIMIENTO SII.CGG_KDX_KARDEX.CKKRD_TIPO_MOVIMIENTO%TYPE, 
IN IN_CKKRD_TIPO_OPERACION SII.CGG_KDX_KARDEX.CKKRD_TIPO_OPERACION%TYPE, 
IN IN_CKKRD_INGRESO_CANTIDAD SII.CGG_KDX_KARDEX.CKKRD_INGRESO_CANTIDAD%TYPE, 
IN IN_CKKRD_INGRESO_PU SII.CGG_KDX_KARDEX.CKKRD_INGRESO_PU%TYPE, 
IN IN_CKKRD_INGRESO_TOTAL SII.CGG_KDX_KARDEX.CKKRD_INGRESO_TOTAL%TYPE, 
IN IN_CKKRD_SALIDA_CANTIDAD SII.CGG_KDX_KARDEX.CKKRD_SALIDA_CANTIDAD%TYPE, 
IN IN_CKKRD_SALIDA_PU SII.CGG_KDX_KARDEX.CKKRD_SALIDA_PU%TYPE, 
IN IN_CKKRD_SALIDA_TOTAL SII.CGG_KDX_KARDEX.CKKRD_SALIDA_TOTAL%TYPE, 
IN IN_CKKRD_TOTAL_CANTIDAD SII.CGG_KDX_KARDEX.CKKRD_TOTAL_CANTIDAD%TYPE, 
IN IN_CKKRD_TOTAL_PU SII.CGG_KDX_KARDEX.CKKRD_TOTAL_PU%TYPE, 
IN IN_CKKRD_TOTAL_TOTAL SII.CGG_KDX_KARDEX.CKKRD_TOTAL_TOTAL%TYPE, 
IN IN_CKKRD_ESTADO SII.CGG_KDX_KARDEX.CKKRD_ESTADO%TYPE, 
IN IN_CKKRD_USUARIO_INSERT SII.CGG_KDX_KARDEX.CKKRD_USUARIO_INSERT%TYPE, 
IN IN_CKKRD_USUARIO_UPDATE SII.CGG_KDX_KARDEX.CKKRD_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CKKRD_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_KDX_KARDEX','CKKRD_CODIGO','CKKRD') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CKKRD_CODIGO;
	END IF;
	INSERT INTO SII.CGG_KDX_KARDEX(
		CKKRD_CODIGO, 
		CKESP_CODIGO, 
		CKKRD_NUMERO, 
		CKKRD_DETALLE, 
		CKKRD_FECHA_REGISTRO, 
		CKKRD_TIPO_MOVIMIENTO, 
		CKKRD_TIPO_OPERACION, 
		CKKRD_INGRESO_CANTIDAD, 
		CKKRD_INGRESO_PU, 
		CKKRD_INGRESO_TOTAL, 
		CKKRD_SALIDA_CANTIDAD, 
		CKKRD_SALIDA_PU, 
		CKKRD_SALIDA_TOTAL, 
		CKKRD_TOTAL_CANTIDAD, 
		CKKRD_TOTAL_PU, 
		CKKRD_TOTAL_TOTAL, 
		CKKRD_ESTADO, 
		CKKRD_FECHA_INSERT, 
		CKKRD_USUARIO_INSERT, 
		CKKRD_FECHA_UPDATE, 
		CKKRD_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CKESP_CODIGO, 
		IN_CKKRD_NUMERO, 
		IN_CKKRD_DETALLE, 
		IN_CKKRD_FECHA_REGISTRO, 
		IN_CKKRD_TIPO_MOVIMIENTO, 
		IN_CKKRD_TIPO_OPERACION, 
		IN_CKKRD_INGRESO_CANTIDAD, 
		IN_CKKRD_INGRESO_PU, 
		IN_CKKRD_INGRESO_TOTAL, 
		IN_CKKRD_SALIDA_CANTIDAD, 
		IN_CKKRD_SALIDA_PU, 
		IN_CKKRD_SALIDA_TOTAL, 
		IN_CKKRD_TOTAL_CANTIDAD, 
		IN_CKKRD_TOTAL_PU, 
		IN_CKKRD_TOTAL_TOTAL, 
		IN_CKKRD_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CKKRD_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CKKRD_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_KDX_KARDEX
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKKRD_CODIGO, 
		CKESP_CODIGO, 
		CKKRD_NUMERO, 
		CKKRD_DETALLE, 
		CKKRD_FECHA_REGISTRO, 
		CKKRD_TIPO_MOVIMIENTO, 
		CKKRD_TIPO_OPERACION, 
		CKKRD_INGRESO_CANTIDAD, 
		CKKRD_INGRESO_PU, 
		CKKRD_INGRESO_TOTAL, 
		CKKRD_SALIDA_CANTIDAD, 
		CKKRD_SALIDA_PU, 
		CKKRD_SALIDA_TOTAL, 
		CKKRD_TOTAL_CANTIDAD, 
		CKKRD_TOTAL_PU, 
		CKKRD_TOTAL_TOTAL, 
		CKKRD_ESTADO, 
		CKKRD_FECHA_INSERT, 
		CKKRD_USUARIO_INSERT, 
		CKKRD_FECHA_UPDATE, 
		CKKRD_USUARIO_UPDATE
	FROM SII.CGG_KDX_KARDEX
	WHERE CKKRD_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_KDX_KARDEX
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_SELECT(
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
		CKKRD_CODIGO, 
		CKESP_CODIGO, 
		CKKRD_NUMERO, 
		CKKRD_DETALLE, 
		CKKRD_FECHA_REGISTRO, 
		CKKRD_TIPO_MOVIMIENTO, 
		CKKRD_TIPO_OPERACION, 
		CKKRD_INGRESO_CANTIDAD, 
		CKKRD_INGRESO_PU, 
		CKKRD_INGRESO_TOTAL, 
		CKKRD_SALIDA_CANTIDAD, 
		CKKRD_SALIDA_PU, 
		CKKRD_SALIDA_TOTAL, 
		CKKRD_TOTAL_CANTIDAD, 
		CKKRD_TOTAL_PU, 
		CKKRD_TOTAL_TOTAL, 
		CKKRD_ESTADO, 
		CKKRD_FECHA_INSERT, 
		CKKRD_USUARIO_INSERT, 
		CKKRD_FECHA_UPDATE, 
		CKKRD_USUARIO_UPDATE
	FROM SII.CGG_KDX_KARDEX
	WHERE CKKRD_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CKKRD_NUMERO, 0)||'' ''||COALESCE(CKKRD_DETALLE, '''')||'' ''||COALESCE(CKKRD_FECHA_REGISTRO, CURRENT_TIMESTAMP)||'' ''||COALESCE(CKKRD_TIPO_MOVIMIENTO, 0)||'' ''||COALESCE(CKKRD_TIPO_OPERACION, 0)||'' ''||COALESCE(CKKRD_INGRESO_CANTIDAD, 0)||'' ''||COALESCE(CKKRD_INGRESO_PU, 0)||'' ''||COALESCE(CKKRD_INGRESO_TOTAL, 0)||'' ''||COALESCE(CKKRD_SALIDA_CANTIDAD, 0)||'' ''||COALESCE(CKKRD_SALIDA_PU, 0)||'' ''||COALESCE(CKKRD_SALIDA_TOTAL, 0)||'' ''||COALESCE(CKKRD_TOTAL_CANTIDAD, 0)||'' ''||COALESCE(CKKRD_TOTAL_PU, 0)||'' ''||COALESCE(CKKRD_TOTAL_TOTAL, 0)||'' ''||COALESCE(CKKRD_ESTADO, FALSE)||'' ''||COALESCE(CKKRD_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CKKRD_USUARIO_INSERT, '''')||'' ''||COALESCE(CKKRD_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CKKRD_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_KDX_KARDEX
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_KDX_KARDEX
	WHERE CKKRD_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_KDX_KARDEX
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_KDX_KARDEX
	WHERE CKKRD_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CKKRD_NUMERO, 0)||' '||COALESCE(CKKRD_DETALLE, '''')||' '||COALESCE(CKKRD_FECHA_REGISTRO, CURRENT_TIMESTAMP)||' '||COALESCE(CKKRD_TIPO_MOVIMIENTO, 0)||' '||COALESCE(CKKRD_TIPO_OPERACION, 0)||' '||COALESCE(CKKRD_INGRESO_CANTIDAD, 0)||' '||COALESCE(CKKRD_INGRESO_PU, 0)||' '||COALESCE(CKKRD_INGRESO_TOTAL, 0)||' '||COALESCE(CKKRD_SALIDA_CANTIDAD, 0)||' '||COALESCE(CKKRD_SALIDA_PU, 0)||' '||COALESCE(CKKRD_SALIDA_TOTAL, 0)||' '||COALESCE(CKKRD_TOTAL_CANTIDAD, 0)||' '||COALESCE(CKKRD_TOTAL_PU, 0)||' '||COALESCE(CKKRD_TOTAL_TOTAL, 0)||' '||COALESCE(CKKRD_ESTADO, FALSE)||' '||COALESCE(CKKRD_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CKKRD_USUARIO_INSERT, '''')||' '||COALESCE(CKKRD_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CKKRD_USUARIO_UPDATE, '''')) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_KDX_KARDEX
* @param IN_CKKRD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
* @param IN_CKESP_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
* @param IN_CKKRD_NUMERO NUMERO DEL MOVIMIENTO
* @param IN_CKKRD_DETALLE DETALLE DEL MOVIMIENTO
* @param IN_CKKRD_FECHA_REGISTRO FECHA DE REGISTRO DE MOVIMIENTO
* @param IN_CKKRD_TIPO_MOVIMIENTO TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

* @param IN_CKKRD_TIPO_OPERACION TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
* @param IN_CKKRD_INGRESO_CANTIDAD CANTIDAD DE ESPECIES QUE INGRESARON
* @param IN_CKKRD_INGRESO_PU PRECIO UNITARIO DE COMPRA
* @param IN_CKKRD_INGRESO_TOTAL TOTAL CONTABLE DE INGRESO
* @param IN_CKKRD_SALIDA_CANTIDAD CANTIDAD DE ESPECIES ENTREGADAS
* @param IN_CKKRD_SALIDA_PU PRECIO UNITARIO DE VENTA
* @param IN_CKKRD_SALIDA_TOTAL TOTAL CONTABLE DE VENTA
* @param IN_CKKRD_TOTAL_CANTIDAD CANTIDAD TOTAL
* @param IN_CKKRD_TOTAL_PU PRECIO UNITARIO
* @param IN_CKKRD_TOTAL_TOTAL TOTAL CONTABLE
* @param IN_CKKRD_ESTADO ESTADO DEL REGISTRO
* @param IN_CKKRD_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_UPDATE(
IN IN_CKKRD_CODIGO SII.CGG_KDX_KARDEX.CKKRD_CODIGO%TYPE, 
IN IN_CKESP_CODIGO SII.CGG_KDX_KARDEX.CKESP_CODIGO%TYPE, 
IN IN_CKKRD_NUMERO SII.CGG_KDX_KARDEX.CKKRD_NUMERO%TYPE, 
IN IN_CKKRD_DETALLE SII.CGG_KDX_KARDEX.CKKRD_DETALLE%TYPE, 
IN IN_CKKRD_FECHA_REGISTRO SII.CGG_KDX_KARDEX.CKKRD_FECHA_REGISTRO%TYPE, 
IN IN_CKKRD_TIPO_MOVIMIENTO SII.CGG_KDX_KARDEX.CKKRD_TIPO_MOVIMIENTO%TYPE, 
IN IN_CKKRD_TIPO_OPERACION SII.CGG_KDX_KARDEX.CKKRD_TIPO_OPERACION%TYPE, 
IN IN_CKKRD_INGRESO_CANTIDAD SII.CGG_KDX_KARDEX.CKKRD_INGRESO_CANTIDAD%TYPE, 
IN IN_CKKRD_INGRESO_PU SII.CGG_KDX_KARDEX.CKKRD_INGRESO_PU%TYPE, 
IN IN_CKKRD_INGRESO_TOTAL SII.CGG_KDX_KARDEX.CKKRD_INGRESO_TOTAL%TYPE, 
IN IN_CKKRD_SALIDA_CANTIDAD SII.CGG_KDX_KARDEX.CKKRD_SALIDA_CANTIDAD%TYPE, 
IN IN_CKKRD_SALIDA_PU SII.CGG_KDX_KARDEX.CKKRD_SALIDA_PU%TYPE, 
IN IN_CKKRD_SALIDA_TOTAL SII.CGG_KDX_KARDEX.CKKRD_SALIDA_TOTAL%TYPE, 
IN IN_CKKRD_TOTAL_CANTIDAD SII.CGG_KDX_KARDEX.CKKRD_TOTAL_CANTIDAD%TYPE, 
IN IN_CKKRD_TOTAL_PU SII.CGG_KDX_KARDEX.CKKRD_TOTAL_PU%TYPE, 
IN IN_CKKRD_TOTAL_TOTAL SII.CGG_KDX_KARDEX.CKKRD_TOTAL_TOTAL%TYPE, 
IN IN_CKKRD_ESTADO SII.CGG_KDX_KARDEX.CKKRD_ESTADO%TYPE, 
IN IN_CKKRD_USUARIO_UPDATE SII.CGG_KDX_KARDEX.CKKRD_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_KARDEX SET
		CKESP_CODIGO = IN_CKESP_CODIGO, 
		CKKRD_NUMERO = IN_CKKRD_NUMERO, 
		CKKRD_DETALLE = IN_CKKRD_DETALLE, 
		CKKRD_FECHA_REGISTRO = IN_CKKRD_FECHA_REGISTRO, 
		CKKRD_TIPO_MOVIMIENTO = IN_CKKRD_TIPO_MOVIMIENTO, 
		CKKRD_TIPO_OPERACION = IN_CKKRD_TIPO_OPERACION, 
		CKKRD_INGRESO_CANTIDAD = IN_CKKRD_INGRESO_CANTIDAD, 
		CKKRD_INGRESO_PU = IN_CKKRD_INGRESO_PU, 
		CKKRD_INGRESO_TOTAL = IN_CKKRD_INGRESO_TOTAL, 
		CKKRD_SALIDA_CANTIDAD = IN_CKKRD_SALIDA_CANTIDAD, 
		CKKRD_SALIDA_PU = IN_CKKRD_SALIDA_PU, 
		CKKRD_SALIDA_TOTAL = IN_CKKRD_SALIDA_TOTAL, 
		CKKRD_TOTAL_CANTIDAD = IN_CKKRD_TOTAL_CANTIDAD, 
		CKKRD_TOTAL_PU = IN_CKKRD_TOTAL_PU, 
		CKKRD_TOTAL_TOTAL = IN_CKKRD_TOTAL_TOTAL, 
		CKKRD_ESTADO = IN_CKKRD_ESTADO, 
		CKKRD_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CKKRD_USUARIO_UPDATE = IN_CKKRD_USUARIO_UPDATE
	WHERE
		CKKRD_CODIGO = IN_CKKRD_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_KDX_KARDEX
* @param IN_CKKRD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_SELECT(
IN IN_CKKRD_CODIGO SII.CGG_KDX_KARDEX.CKKRD_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKKRD_CODIGO, 
		CKESP_CODIGO, 
		CKKRD_NUMERO, 
		CKKRD_DETALLE, 
		CKKRD_FECHA_REGISTRO, 
		CKKRD_TIPO_MOVIMIENTO, 
		CKKRD_TIPO_OPERACION, 
		CKKRD_INGRESO_CANTIDAD, 
		CKKRD_INGRESO_PU, 
		CKKRD_INGRESO_TOTAL, 
		CKKRD_SALIDA_CANTIDAD, 
		CKKRD_SALIDA_PU, 
		CKKRD_SALIDA_TOTAL, 
		CKKRD_TOTAL_CANTIDAD, 
		CKKRD_TOTAL_PU, 
		CKKRD_TOTAL_TOTAL, 
		CKKRD_ESTADO, 
		CKKRD_FECHA_INSERT, 
		CKKRD_USUARIO_INSERT, 
		CKKRD_FECHA_UPDATE, 
		CKKRD_USUARIO_UPDATE
	FROM SII.CGG_KDX_KARDEX
	WHERE CKKRD_ESTADO = TRUE AND 
		CKKRD_CODIGO = IN_CKKRD_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_KDX_KARDEX
* @param IN_CKKRD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_DELETE(
IN IN_CKKRD_CODIGO SII.CGG_KDX_KARDEX.CKKRD_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_KDX_KARDEX
	WHERE
		CKKRD_CODIGO = IN_CKKRD_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_KDX_KARDEX
* @param IN_CKKRD_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_DELETE_SOFT(
IN IN_CKKRD_CODIGO SII.CGG_KDX_KARDEX.CKKRD_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_KARDEX SET
		CKKRD_ESTADO = FALSE
	WHERE
		CKKRD_CODIGO = IN_CKKRD_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_S_CGG_KDX_ESPECIE
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_KARDEX QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_ESPECIE.
* @param IN_CKESP_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_S_CGG_KDX_ESPECIE(
IN IN_CKESP_CODIGO SII.CGG_KDX_KARDEX.CKESP_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CKKRD_CODIGO, 
		CKESP_CODIGO, 
		CKKRD_NUMERO, 
		CKKRD_DETALLE, 
		CKKRD_FECHA_REGISTRO, 
		CKKRD_TIPO_MOVIMIENTO, 
		CKKRD_TIPO_OPERACION, 
		CKKRD_INGRESO_CANTIDAD, 
		CKKRD_INGRESO_PU, 
		CKKRD_INGRESO_TOTAL, 
		CKKRD_SALIDA_CANTIDAD, 
		CKKRD_SALIDA_PU, 
		CKKRD_SALIDA_TOTAL, 
		CKKRD_TOTAL_CANTIDAD, 
		CKKRD_TOTAL_PU, 
		CKKRD_TOTAL_TOTAL, 
		CKKRD_ESTADO, 
		CKKRD_FECHA_INSERT, 
		CKKRD_USUARIO_INSERT, 
		CKKRD_FECHA_UPDATE, 
		CKKRD_USUARIO_UPDATE
	FROM SII.CGG_KDX_KARDEX
	WHERE CKKRD_ESTADO = TRUE AND 
		CKESP_CODIGO = IN_CKESP_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_D_CGG_KDX_ESPECIE
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_KARDEX QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_ESPECIE.
* @param IN_CKESP_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_D_CGG_KDX_ESPECIE(
IN IN_CKESP_CODIGO SII.CGG_KDX_KARDEX.CKESP_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_KDX_KARDEX
	WHERE
		CKESP_CODIGO = IN_CKESP_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_KDX_KARDEX_D_CGG_KDX_ESPECIE
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_KDX_KARDEX QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_KDX_ESPECIE.
* @param IN_CKESP_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_KDX_KARDEX_DS_CGG_KDX_ESPECIE(
IN IN_CKESP_CODIGO SII.CGG_KDX_KARDEX.CKESP_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_KDX_KARDEX SET
		ckkrd_estado = false
	WHERE
		CKESP_CODIGO = IN_CKESP_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

