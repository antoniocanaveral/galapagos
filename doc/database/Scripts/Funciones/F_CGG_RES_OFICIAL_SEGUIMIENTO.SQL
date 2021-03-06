/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_CROSG_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CROSG_TIPO_OFICIAL IDENTIFICATIVO UNICO DE REGISTRO
0 - JEFE
1 - OFICIAL
* @param IN_CROSG_ESTADO ESTADO DEL REGISTRO
* @param IN_CROSG_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CROSG_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_INSERT(
IN IN_CROSG_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_CODIGO%TYPE, 
IN IN_CUSU_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CUSU_CODIGO%TYPE, 
IN IN_CROSG_TIPO_OFICIAL SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_TIPO_OFICIAL%TYPE,
IN IN_CROSG_ESTADO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_ESTADO%TYPE, 
IN IN_CROSG_USUARIO_INSERT SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_USUARIO_INSERT%TYPE, 
IN IN_CROSG_USUARIO_UPDATE SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_USUARIO_UPDATE%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
TMP_EXIST INT;
BEGIN
	SELECT COUNT(CUSU_CODIGO) INTO TMP_EXIST FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO WHERE CUSU_CODIGO = IN_CUSU_CODIGO AND CROSG_ESTADO = TRUE;
	IF (TMP_EXIST > 0) THEN
		RAISE EXCEPTION 'El usuario seleccionado ya se encuentra registrado.';
	END IF;
	IF (UPPER(IN_CROSG_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_OFICIAL_SEGUIMIENTO','CROSG_CODIGO','CROSG') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CROSG_CODIGO;
	END IF;
	INSERT INTO SII.CGG_RES_OFICIAL_SEGUIMIENTO(
		CROSG_CODIGO, 
		CUSU_CODIGO, 
		CROSG_TIPO_OFICIAL,
		CROSG_ESTADO, 
		CROSG_FECHA_INSERT, 
		CROSG_USUARIO_INSERT, 
		CROSG_FECHA_UPDATE, 
		CROSG_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CUSU_CODIGO,
		IN_CROSG_TIPO_OFICIAL,
		IN_CROSG_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CROSG_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CROSG_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_SELECT_AS(
IN IN_USER_NAME varchar(50)
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CROSG_CODIGO, 
		CUSU_CODIGO, 
		CROSG_TIPO_OFICIAL,
		CROSG_ESTADO, 
		CROSG_FECHA_INSERT, 
		CROSG_USUARIO_INSERT, 
		CROSG_FECHA_UPDATE, 
		CROSG_USUARIO_UPDATE
	FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO
	WHERE CROSG_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/*
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO__SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_SELECT(
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
		OS.CROSG_CODIGO,
		OS.CROSG_TIPO_OFICIAL,
		U.CUSU_CODIGO, 
		U.CRCRG_CODIGO, 
		U.CRPER_CODIGO, 
		U.CRPJR_CODIGO, 
		U.CCTN_CODIGO, 
		PER.CRPER_NOMBRES NOMBRES,
		PER.CRPER_APELLIDO_PATERNO||'' ''||COALESCE(PER.CRPER_APELLIDO_MATERNO,'''') APELLIDOS,
		U.CUSU_NOMBRE_USUARIO, 
		U.CUSU_CLAVE_ACCESO, 
		U.CUSU_USUARIO_INTERNO, 
		U.CUSU_ESTADO, 
		U.CUSU_FECHA_INSERT, 
		U.CUSU_USUARIO_INSERT, 
		U.CUSU_FECHA_UPDATE, 
		U.CUSU_USUARIO_UPDATE
	FROM SII.CGG_USUARIO U
	INNER JOIN SII.CGG_RES_OFICIAL_SEGUIMIENTO OS ON OS.CUSU_CODIGO = U.CUSU_CODIGO
	INNER JOIN SII.CGG_RES_PERSONA PER ON PER.CRPER_CODIGO = U.CRPER_CODIGO
	WHERE OS.CROSG_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',CASE WHEN PER.CRPER_NOMBRES IS NULL THEN '''' ELSE PER.CRPER_NOMBRES END ||'' ''||CASE WHEN PER.CRPER_APELLIDO_PATERNO IS NULL THEN '''' ELSE PER.CRPER_APELLIDO_PATERNO END||'' ''||CASE WHEN PER.CRPER_APELLIDO_MATERNO IS NULL THEN '''' ELSE PER.CRPER_APELLIDO_MATERNO END||'' ''||CASE WHEN CUSU_NOMBRE_USUARIO IS NULL THEN '''' ELSE CUSU_NOMBRE_USUARIO END ||'' ''||CASE WHEN CUSU_CLAVE_ACCESO IS NULL THEN '''' ELSE CUSU_CLAVE_ACCESO END||'' ''||CASE WHEN CUSU_USUARIO_INTERNO IS NULL THEN FALSE ELSE CUSU_USUARIO_INTERNO END) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO
	WHERE CROSG_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_USUARIO U
	INNER JOIN SII.CGG_RES_OFICIAL_SEGUIMIENTO OS ON OS.CUSU_CODIGO = U.CUSU_CODIGO
	INNER JOIN SII.CGG_RES_PERSONA PER ON PER.CRPER_CODIGO = U.CRPER_CODIGO
	WHERE U.CUSU_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,CASE WHEN PER.CRPER_NOMBRES IS NULL THEN '''' ELSE PER.CRPER_NOMBRES END ||' '||CASE WHEN PER.CRPER_APELLIDO_PATERNO IS NULL THEN '' ELSE PER.CRPER_APELLIDO_PATERNO END||' '||CASE WHEN PER.CRPER_APELLIDO_MATERNO IS NULL THEN '' ELSE PER.CRPER_APELLIDO_MATERNO END ||' '||CASE WHEN CUSU_NOMBRE_USUARIO IS NULL THEN '''' ELSE CUSU_NOMBRE_USUARIO END ||' '||CASE WHEN CUSU_CLAVE_ACCESO IS NULL THEN '''' ELSE CUSU_CLAVE_ACCESO END ||' '||CASE WHEN CUSU_USUARIO_INTERNO IS NULL THEN FALSE ELSE CUSU_USUARIO_INTERNO END ) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_CROSG_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @param IN_CROSG_TIPO_OFICIAL TIPO OFICIAL DE SEGUIMIENTO
0 - OFICIAL
1- JEFE
* @param IN_CROSG_ESTADO ESTADO DEL REGISTRO
* @param IN_CROSG_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_UPDATE(
IN IN_CROSG_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_CODIGO%TYPE, 
IN IN_CUSU_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CUSU_CODIGO%TYPE, 
IN IN_CROSG_TIPO_OFICIAL SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_TIPO_OFICIAL%TYPE,
IN IN_CROSG_ESTADO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_ESTADO%TYPE, 
IN IN_CROSG_USUARIO_UPDATE SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_OFICIAL_SEGUIMIENTO SET
		CROSG_TIPO_OFICIAL= IN_CROSG_TIPO_OFICIAL,
		CUSU_CODIGO = IN_CUSU_CODIGO, 
		CROSG_ESTADO = IN_CROSG_ESTADO, 
		CROSG_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CROSG_USUARIO_UPDATE = IN_CROSG_USUARIO_UPDATE
	WHERE
		CROSG_CODIGO = IN_CROSG_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_CROSG_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_SELECT(
IN IN_CROSG_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CROSG_CODIGO, 
		CUSU_CODIGO, 
		CROSG_TIPO_OFICIAL,
		CROSG_ESTADO, 
		CROSG_FECHA_INSERT, 
		CROSG_USUARIO_INSERT, 
		CROSG_FECHA_UPDATE, 
		CROSG_USUARIO_UPDATE
	FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO
	WHERE CROSG_ESTADO = TRUE AND 
		CROSG_CODIGO = IN_CROSG_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_CROSG_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_DELETE(
IN IN_CROSG_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO
	WHERE
		CROSG_CODIGO = IN_CROSG_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO
* @param IN_CROSG_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_DELETE_SOFT(
IN IN_CROSG_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CROSG_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_OFICIAL_SEGUIMIENTO SET
		CROSG_ESTADO = FALSE
	WHERE
		CROSG_CODIGO = IN_CROSG_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_S_CGG_USUARIO
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_USUARIO.
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_S_CGG_USUARIO(
IN IN_CUSU_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CUSU_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CROSG_CODIGO, 
		CUSU_CODIGO, 
		CROSG_TIPO_OFICIAL,
		CROSG_ESTADO, 
		CROSG_FECHA_INSERT, 
		CROSG_USUARIO_INSERT, 
		CROSG_FECHA_UPDATE, 
		CROSG_USUARIO_UPDATE
	FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO
	WHERE CROSG_ESTADO = TRUE AND 
		CUSU_CODIGO = IN_CUSU_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_D_CGG_USUARIO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_USUARIO.
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_D_CGG_USUARIO(
IN IN_CUSU_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CUSU_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_RES_OFICIAL_SEGUIMIENTO
	WHERE
		CUSU_CODIGO = IN_CUSU_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_D_CGG_USUARIO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_RES_OFICIAL_SEGUIMIENTO QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_USUARIO.
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE REGISTRO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_OFICIAL_SEGUIMIENTO_DS_CGG_USUARIO(
IN IN_CUSU_CODIGO SII.CGG_RES_OFICIAL_SEGUIMIENTO.CUSU_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_RES_OFICIAL_SEGUIMIENTO SET
		crosg_estado = false
	WHERE
		CUSU_CODIGO = IN_CUSU_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

