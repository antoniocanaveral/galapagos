/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_CVHST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
* @param IN_CVVEH_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
* @param IN_CRPER_CODIGO CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
* @param IN_CRPJR_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
* @param IN_CVHST_FECHA_TRASPASO FECHA DE TRASPASO DEL VEHICULO
* @param IN_CVHST_PROPIETARIO ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
* @param IN_CVHST_CONCEPTO JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
* @param IN_CVHST_OBSERVACIONES OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
* @param IN_CVHST_ESTADO ESTADO DEL REGISTRO
* @param IN_CVHST_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CVHST_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_INSERT(
IN IN_CVHST_CODIGO SII.CGG_VEH_HISTORIAL.CVHST_CODIGO%TYPE,
IN IN_CVVEH_CODIGO SII.CGG_VEH_HISTORIAL.CVVEH_CODIGO%TYPE,
IN IN_CRPER_CODIGO SII.CGG_VEH_HISTORIAL.CRPER_CODIGO%TYPE,
IN IN_CRPJR_CODIGO SII.CGG_VEH_HISTORIAL.CRPJR_CODIGO%TYPE,
IN IN_CVHST_FECHA_TRASPASO SII.CGG_VEH_HISTORIAL.CVHST_FECHA_TRASPASO%TYPE,
IN IN_CVHST_PROPIETARIO SII.CGG_VEH_HISTORIAL.CVHST_PROPIETARIO%TYPE,
IN IN_CVHST_CONCEPTO SII.CGG_VEH_HISTORIAL.CVHST_CONCEPTO%TYPE,
IN IN_CVHST_OBSERVACIONES SII.CGG_VEH_HISTORIAL.CVHST_OBSERVACIONES%TYPE,
IN IN_CVHST_ESTADO SII.CGG_VEH_HISTORIAL.CVHST_ESTADO%TYPE,
IN IN_CVHST_USUARIO_INSERT SII.CGG_VEH_HISTORIAL.CVHST_USUARIO_INSERT%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CVHST_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_VEH_HISTORIAL','CVHST_CODIGO','CVHST') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CVHST_CODIGO;
	END IF;
	INSERT INTO SII.CGG_VEH_HISTORIAL(
		CVHST_CODIGO, 
		CVVEH_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO, 
		CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES, 
		CVHST_ESTADO, 
		CVHST_FECHA_INSERT, 
		CVHST_USUARIO_INSERT, 
		CVHST_FECHA_UPDATE, 
		CVHST_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CVVEH_CODIGO, 
		IN_CRPER_CODIGO, 
		IN_CRPJR_CODIGO, 
		IN_CVHST_FECHA_TRASPASO, 
		IN_CVHST_PROPIETARIO, 
		IN_CVHST_CONCEPTO, 
		IN_CVHST_OBSERVACIONES, 
		IN_CVHST_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CVHST_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CVHST_USUARIO_INSERT
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_SELECT_AS(
IN IN_USER_NAME VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVHST_CODIGO, 
		CVVEH_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO, 
		CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES, 
		CVHST_ESTADO, 
		CVHST_FECHA_INSERT, 
		CVHST_USUARIO_INSERT, 
		CVHST_FECHA_UPDATE, 
		CVHST_USUARIO_UPDATE
	FROM SII.CGG_VEH_HISTORIAL
	WHERE CVHST_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @param IN_CVVEH_CODIGO IDENTIFICATIVO UNICO DE VEHICULO.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_SELECT(
IN IN_USER_NAME VARCHAR,
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT,
IN IN_CVVEH_CODIGO VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		HST.CVHST_CODIGO, 
		HST.CVVEH_CODIGO, 
		HST.CRPER_CODIGO, 
		HST.CRPJR_CODIGO, 
		(CASE WHEN HST.CRPJR_CODIGO IS NULL THEN 
			COALESCE(PRS.CRPER_NOMBRES,'''')||'' ''||COALESCE(PRS.CRPER_APELLIDO_PATERNO,'''')||'' ''||COALESCE(PRS.CRPER_APELLIDO_MATERNO,'''') 
		ELSE
			COALESCE(PJR.CRPJR_RAZON_SOCIAL,'''')||'' - ''||COALESCE(PRS.CRPER_NOMBRES,'''')||'' ''||COALESCE(PRS.CRPER_APELLIDO_PATERNO,'''')||'' ''||COALESCE(PRS.CRPER_APELLIDO_MATERNO,'''') 
		END) PROPIETARIO,
		HST.CVHST_FECHA_TRASPASO, 
		HST.CVHST_PROPIETARIO, 
		HST.CVHST_CONCEPTO, 
		HST.CVHST_OBSERVACIONES, 
		HST.CVHST_ESTADO, 
		HST.CVHST_FECHA_INSERT, 
		HST.CVHST_USUARIO_INSERT, 
		HST.CVHST_FECHA_UPDATE, 
		HST.CVHST_USUARIO_UPDATE
	FROM SII.CGG_VEH_HISTORIAL HST
	INNER JOIN SII.CGG_RES_PERSONA PRS ON PRS.CRPER_CODIGO = HST.CRPER_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA_JURIDICA PJR ON PJR.CRPJR_CODIGO = HST.CRPJR_CODIGO
	WHERE CVHST_ESTADO AND 
		(LENGTH('||QUOTE_LITERAL(IN_CVVEH_CODIGO)||') = 0 OR HST.CVVEH_CODIGO = '||QUOTE_LITERAL(IN_CVVEH_CODIGO)||') AND
		(LENGTH('||QUOTE_LITERAL(IN_FIND_TEXT)||') = 0 OR SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CVHST_FECHA_TRASPASO, CURRENT_TIMESTAMP)||'' ''||COALESCE(CVHST_PROPIETARIO, FALSE)||'' ''||COALESCE(CVHST_CONCEPTO, '''')||'' ''||COALESCE(CVHST_OBSERVACIONES, '''')||'' ''||COALESCE(CVHST_ESTADO, FALSE)||'' ''||COALESCE(CVHST_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CVHST_USUARIO_INSERT, '''')||'' ''||COALESCE(CVHST_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CVHST_USUARIO_UPDATE, '''')) = 1)
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_VEH_HISTORIAL
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_VEH_HISTORIAL
	WHERE CVHST_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_VEH_HISTORIAL
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @param IN_CVVEH_CODIGO IDENTIFICATIVO UNICO DE VEHICULO.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_CVVEH_CODIGO VARCHAR
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_VEH_HISTORIAL HST
	WHERE CVHST_ESTADO AND 
		(LENGTH(IN_CVVEH_CODIGO) = 0 OR HST.CVVEH_CODIGO = IN_CVVEH_CODIGO) AND
		(LENGTH(IN_FIND_TEXT) = 0 OR SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CVHST_FECHA_TRASPASO, CURRENT_TIMESTAMP)||' '||COALESCE(CVHST_PROPIETARIO, FALSE)||' '||COALESCE(CVHST_CONCEPTO, '''')||' '||COALESCE(CVHST_OBSERVACIONES, '''')||' '||COALESCE(CVHST_ESTADO, FALSE)||' '||COALESCE(CVHST_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(CVHST_USUARIO_INSERT, '''')||' '||COALESCE(CVHST_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||COALESCE(CVHST_USUARIO_UPDATE, '''')) = 1);
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_VEH_HISTORIAL
* @param IN_CVHST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
* @param IN_CVVEH_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
* @param IN_CRPER_CODIGO CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
* @param IN_CRPJR_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
* @param IN_CVHST_FECHA_TRASPASO FECHA DE TRASPASO DEL VEHICULO
* @param IN_CVHST_PROPIETARIO ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
* @param IN_CVHST_CONCEPTO JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
* @param IN_CVHST_OBSERVACIONES OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
* @param IN_CVHST_ESTADO ESTADO DEL REGISTRO
* @param IN_CVHST_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_UPDATE(
IN IN_CVHST_CODIGO SII.CGG_VEH_HISTORIAL.CVHST_CODIGO%TYPE,
IN IN_CVVEH_CODIGO SII.CGG_VEH_HISTORIAL.CVVEH_CODIGO%TYPE,
IN IN_CRPER_CODIGO SII.CGG_VEH_HISTORIAL.CRPER_CODIGO%TYPE,
IN IN_CRPJR_CODIGO SII.CGG_VEH_HISTORIAL.CRPJR_CODIGO%TYPE,
IN IN_CVHST_FECHA_TRASPASO SII.CGG_VEH_HISTORIAL.CVHST_FECHA_TRASPASO%TYPE,
IN IN_CVHST_PROPIETARIO SII.CGG_VEH_HISTORIAL.CVHST_PROPIETARIO%TYPE,
IN IN_CVHST_CONCEPTO SII.CGG_VEH_HISTORIAL.CVHST_CONCEPTO%TYPE,
IN IN_CVHST_OBSERVACIONES SII.CGG_VEH_HISTORIAL.CVHST_OBSERVACIONES%TYPE,
IN IN_CVHST_ESTADO SII.CGG_VEH_HISTORIAL.CVHST_ESTADO%TYPE,
IN IN_CVHST_USUARIO_UPDATE SII.CGG_VEH_HISTORIAL.CVHST_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_HISTORIAL SET
		CVVEH_CODIGO = IN_CVVEH_CODIGO, 
		CRPER_CODIGO = IN_CRPER_CODIGO, 
		CRPJR_CODIGO = IN_CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO = IN_CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO = IN_CVHST_PROPIETARIO, 
		CVHST_CONCEPTO = IN_CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES = IN_CVHST_OBSERVACIONES, 
		CVHST_ESTADO = IN_CVHST_ESTADO, 
		CVHST_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CVHST_USUARIO_UPDATE = IN_CVHST_USUARIO_UPDATE
	WHERE
		CVHST_CODIGO = IN_CVHST_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_CVHST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_SELECT(
IN IN_CVHST_CODIGO SII.CGG_VEH_HISTORIAL.CVHST_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVHST_CODIGO, 
		CVVEH_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO, 
		CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES, 
		CVHST_ESTADO, 
		CVHST_FECHA_INSERT, 
		CVHST_USUARIO_INSERT, 
		CVHST_FECHA_UPDATE, 
		CVHST_USUARIO_UPDATE
	FROM SII.CGG_VEH_HISTORIAL
	WHERE CVHST_ESTADO = TRUE AND 
		CVHST_CODIGO = IN_CVHST_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_CVHST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_DELETE(
IN IN_CVHST_CODIGO SII.CGG_VEH_HISTORIAL.CVHST_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_VEH_HISTORIAL
	WHERE
		CVHST_CODIGO = IN_CVHST_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_CVHST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_DELETE_SOFT(
IN IN_CVHST_CODIGO SII.CGG_VEH_HISTORIAL.CVHST_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_HISTORIAL SET
		CVHST_ESTADO = FALSE
	WHERE
		CVHST_CODIGO = IN_CVHST_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_S_CGG_RES_PERSONA_JURIDICA
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_PERSONA_JURIDICA.
* @param IN_CRPJR_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_S_CGG_RES_PERSONA_JURIDICA(
IN IN_CRPJR_CODIGO SII.CGG_VEH_HISTORIAL.CRPJR_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVHST_CODIGO, 
		CVVEH_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO, 
		CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES, 
		CVHST_ESTADO, 
		CVHST_FECHA_INSERT, 
		CVHST_USUARIO_INSERT, 
		CVHST_FECHA_UPDATE, 
		CVHST_USUARIO_UPDATE
	FROM SII.CGG_VEH_HISTORIAL
	WHERE CVHST_ESTADO = TRUE AND 
		CRPJR_CODIGO = IN_CRPJR_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA_JURIDICA
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_PERSONA_JURIDICA.
* @param IN_CRPJR_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA_JURIDICA(
IN IN_CRPJR_CODIGO SII.CGG_VEH_HISTORIAL.CRPJR_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_VEH_HISTORIAL
	WHERE
		CRPJR_CODIGO = IN_CRPJR_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA_JURIDICA
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_PERSONA_JURIDICA.
* @param IN_CRPJR_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_DS_CGG_RES_PERSONA_JURIDICA(
IN IN_CRPJR_CODIGO SII.CGG_VEH_HISTORIAL.CRPJR_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_HISTORIAL SET
		cvhst_estado = false
	WHERE
		CRPJR_CODIGO = IN_CRPJR_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_S_CGG_RES_PERSONA
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_PERSONA.
* @param IN_CRPER_CODIGO CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_S_CGG_RES_PERSONA(
IN IN_CRPER_CODIGO SII.CGG_VEH_HISTORIAL.CRPER_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVHST_CODIGO, 
		CVVEH_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO, 
		CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES, 
		CVHST_ESTADO, 
		CVHST_FECHA_INSERT, 
		CVHST_USUARIO_INSERT, 
		CVHST_FECHA_UPDATE, 
		CVHST_USUARIO_UPDATE
	FROM SII.CGG_VEH_HISTORIAL
	WHERE CVHST_ESTADO = TRUE AND 
		CRPER_CODIGO = IN_CRPER_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_PERSONA.
* @param IN_CRPER_CODIGO CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA(
IN IN_CRPER_CODIGO SII.CGG_VEH_HISTORIAL.CRPER_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_VEH_HISTORIAL
	WHERE
		CRPER_CODIGO = IN_CRPER_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_D_CGG_RES_PERSONA
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_RES_PERSONA.
* @param IN_CRPER_CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_DS_CGG_RES_PERSONA(
IN IN_CRPER_CODIGO SII.CGG_VEH_HISTORIAL.CRPER_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_HISTORIAL SET
		cvhst_estado = false
	WHERE
		CRPER_CODIGO = IN_CRPER_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_S_CGG_VEH_VEHICULO
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_VEH_VEHICULO.
* @param IN_CVVEH_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_S_CGG_VEH_VEHICULO(
IN IN_CVVEH_CODIGO SII.CGG_VEH_HISTORIAL.CVVEH_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CVHST_CODIGO, 
		CVVEH_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CVHST_FECHA_TRASPASO, 
		CVHST_PROPIETARIO, 
		CVHST_CONCEPTO, 
		CVHST_OBSERVACIONES, 
		CVHST_ESTADO, 
		CVHST_FECHA_INSERT, 
		CVHST_USUARIO_INSERT, 
		CVHST_FECHA_UPDATE, 
		CVHST_USUARIO_UPDATE
	FROM SII.CGG_VEH_HISTORIAL
	WHERE CVHST_ESTADO = TRUE AND 
		CVVEH_CODIGO = IN_CVVEH_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_D_CGG_VEH_VEHICULO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_VEH_VEHICULO.
* @param IN_CVVEH_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_D_CGG_VEH_VEHICULO(
IN IN_CVVEH_CODIGO SII.CGG_VEH_HISTORIAL.CVVEH_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_VEH_HISTORIAL
	WHERE
		CVVEH_CODIGO = IN_CVVEH_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_D_CGG_VEH_VEHICULO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_VEH_HISTORIAL QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_VEH_VEHICULO.
* @param IN_CVVEH_CODIGO IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_DS_CGG_VEH_VEHICULO(
IN IN_CVVEH_CODIGO SII.CGG_VEH_HISTORIAL.CVVEH_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_VEH_HISTORIAL SET
		cvhst_estado = false
	WHERE
		CVVEH_CODIGO = IN_CVVEH_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_PERSONAL
* SELECCIONA TODOS LOS VEHICULOS DE UNA PERSONA
* @param IN_CRPER_CODIGO CODIGO DE PERSONA
* @param IN_CVVEH_TIPO TIPO DE VEHICULO
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_HISTORIAL_PERSONAL(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_CVVEH_TIPO INT
)RETURNS REFCURSOR AS
$$
DECLARE
OUT_CURSOR REFCURSOR;
BEGIN
	OPEN OUT_CURSOR FOR
		SELECT 
			VHC.CVVEH_CODIGO,
			'Nombre:'||COALESCE(VHC.CVVEH_NOMBRE,'')||' Placa:'||COALESCE(VHC.CVVEH_PLACA,'')||' Chasis:'||COALESCE(VHC.CVVEH_CHASIS,'') RESUMEN,
			VHC.CVVEH_NOMBRE,
			VHC.CVVEH_TIPO,
			VHC.CVVEH_ANIO_PRODUCCION,
			VHC.CVVEH_CHASIS,
			VHC.CVVEH_PLACA,
			VHC.CVVEH_FECHA_INGRESO,
			VHC.CVVEH_OBSERVACION,
			VHC.CVMRC_CODIGO,
			MRC.CVMRC_NOMBRE MARCA,
			VHC.CVCTG_CODIGO, 
			CTG.CVCTG_NOMBRE CATEGORIA,
			VHC.CSCTP_CODIGO, 
			SCTP.CSCTP_NOMBRE PRODUCTIVO,
			VHC.CVSCT_CODIGO, 
			SCT.CVSCT_NOMBRE AS SECTOR,
			VMTR.CVMTR_CODIGO,
			VMTR.CVMTR_TONELAJE,
			CMB.CVCMB_CODIGO,
			CMB.CVCMB_NOMBRE,
			CLN.CVCLN_CILINDRAJE,
			CLN.CVCLN_OBSERVACION 
		FROM SII.CGG_VEH_VEHICULO VHC
		INNER JOIN SII.CGG_VEH_HISTORIAL VHH ON VHC.CVVEH_CODIGO = VHH.CVVEH_CODIGO AND VHH.CVHST_PROPIETARIO AND VHH.CRPER_CODIGO = IN_CRPER_CODIGO
		LEFT JOIN SII.CGG_VEH_MARCA MRC ON MRC.CVMRC_CODIGO = VHC.CVMRC_CODIGO
		LEFT JOIN SII.CGG_VEH_CATEGORIA CTG ON CTG.CVCTG_CODIGO = VHC.CVCTG_CODIGO
		LEFT JOIN SII.CGG_SECTOR_PRODUCTIVO SCTP ON SCTP.CSCTP_CODIGO = VHC.CSCTP_CODIGO
		LEFT JOIN SII.CGG_VEH_SECTOR SCT ON SCT.CVSCT_CODIGO = VHC.CVSCT_CODIGO
		left JOIN sii.CGG_VEH_VEHICULO_MOTOR VVMT ON (VHC.CVVEH_CODIGO = VVMT.CVVEH_CODIGO)
		left JOIN sii.CGG_VEH_MOTOR VMTR ON (VMTR.CVMTR_CODIGO = VVMT.CVMTR_CODIGO)
		left JOIN sii.CGG_VEH_CILINDRAJE CLN ON (CLN.CVCLN_CODIGO = VMTR.CVCLN_CODIGO)
		left JOIN sii.CGG_VEH_COMBUSTIBLE CMB ON (CMB.CVCMB_CODIGO = VMTR.CVCMB_CODIGO)
		WHERE CVVEH_ESTADO AND CVVEH_TIPO = IN_CVVEH_TIPO AND CVVEH_INGRESO;
	RETURN OUT_CURSOR;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_HISTORIAL_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_VEH_HISTORIAL
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @param IN_CVVEH_TIPO TIPO DE VEHICULO.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_LIBRE_SELECT(
IN IN_USER_NAME VARCHAR,
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT,
IN IN_CVVEH_TIPO INT
)RETURNS REFCURSOR AS
$$
DECLARE
OUT_CURSOR REFCURSOR;
STMT TEXT;
BEGIN
	STMT:='SELECT 
			VHC.CVVEH_CODIGO,			
			VHC.CVVEH_NOMBRE,
			VHC.CVVEH_TIPO,
			VHC.CVVEH_ANIO_PRODUCCION,
			VHC.CVVEH_CHASIS,
			VHC.CVVEH_PLACA,
			VHC.CVVEH_FECHA_INGRESO,
			VHC.CVVEH_OBSERVACION,
			VHC.CVMRC_CODIGO,
			MRC.CVMRC_NOMBRE MARCA,
			VHC.CVCTG_CODIGO, 
			CTG.CVCTG_NOMBRE CATEGORIA,
			VHC.CSCTP_CODIGO, 
			SCTP.CSCTP_NOMBRE PRODUCTIVO,
			VHC.CVSCT_CODIGO, 
			SCT.CVSCT_NOMBRE AS SECTOR,
			VMTR.CVMTR_CODIGO,
			VMTR.CVMTR_TONELAJE,
			CMB.CVCMB_CODIGO,
			CMB.CVCMB_NOMBRE,
			CLN.CVCLN_CILINDRAJE,
			CLN.CVCLN_OBSERVACION 
		FROM SII.CGG_VEH_VEHICULO VHC		
		LEFT JOIN SII.CGG_VEH_MARCA MRC ON MRC.CVMRC_CODIGO = VHC.CVMRC_CODIGO
		LEFT JOIN SII.CGG_VEH_CATEGORIA CTG ON CTG.CVCTG_CODIGO = VHC.CVCTG_CODIGO
		LEFT JOIN SII.CGG_SECTOR_PRODUCTIVO SCTP ON SCTP.CSCTP_CODIGO = VHC.CSCTP_CODIGO
		LEFT JOIN SII.CGG_VEH_SECTOR SCT ON SCT.CVSCT_CODIGO = VHC.CVSCT_CODIGO
		LEFT JOIN SII.CGG_VEH_VEHICULO_MOTOR VVMT ON (VHC.CVVEH_CODIGO = VVMT.CVVEH_CODIGO)
		LEFT JOIN SII.CGG_VEH_MOTOR VMTR ON (VMTR.CVMTR_CODIGO = VVMT.CVMTR_CODIGO)
		LEFT JOIN SII.CGG_VEH_CILINDRAJE CLN ON (CLN.CVCLN_CODIGO = VMTR.CVCLN_CODIGO)
		LEFT JOIN SII.CGG_VEH_COMBUSTIBLE CMB ON (CMB.CVCMB_CODIGO = VMTR.CVCMB_CODIGO)
		WHERE CVVEH_ESTADO AND CVVEH_TIPO ='||QUOTE_LITERAL(IN_CVVEH_TIPO)||' AND CVVEH_INGRESO AND
		(LENGTH(TRIM('||QUOTE_LITERAL(IN_FIND_TEXT)||')) = 0 
		 OR SII.F_STRING_IN('''||IN_FIND_TEXT||''',							
			COALESCE(CVVEH_PLACA, '''')||'' ''||
			COALESCE(CVVEH_CHASIS, '''')||'' ''||
			COALESCE(CVMRC_NOMBRE, '''')) = 1)
		ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
		' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;		
		OPEN OUT_CURSOR FOR EXECUTE STMT;
		
	RETURN OUT_CURSOR;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_VEH_LIBRE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA VEHICULO.
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VEH_LIBRE_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_CVVEH_TIPO INT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_VEH_VEHICULO VHC	
	LEFT JOIN SII.CGG_VEH_MARCA MRC ON MRC.CVMRC_CODIGO = VHC.CVMRC_CODIGO	
	WHERE CVVEH_ESTADO AND CVVEH_TIPO = IN_CVVEH_TIPO AND CVVEH_INGRESO AND
	LENGTH(IN_FIND_TEXT) = 0 
		 OR SII.F_STRING_IN(IN_FIND_TEXT,							
			COALESCE(CVVEH_PLACA,'')||' '||
			COALESCE(CVVEH_CHASIS,'')||' '||
			COALESCE(CVMRC_NOMBRE,'')) = 1;			
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;