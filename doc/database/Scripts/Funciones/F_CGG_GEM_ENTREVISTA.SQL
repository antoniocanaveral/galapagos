/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_GEM_ENTREVISTA.
* @param IN_CGENT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
* @param IN_CGCND_CODIGO IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
* @param IN_CGENT_ESTADO_ENTREVISTA ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
* @param IN_CGENT_FECHA_REALIZACION FECHA DE REALIZACION DE LA ENTREVISTA
* @param IN_CGENT_LUGAR LUGAR DE REALIZACION DE LA ENTREVISTA
* @param IN_CGENT_OBSERVACION OBSERVACION DE LA ENTREVISTA
* @param IN_CGENT_ESTADO ESTADO DEL REGISTRO
* @param IN_CGENT_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CGENT_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_INSERT(
IN IN_CGENT_CODIGO SII.CGG_GEM_ENTREVISTA.CGENT_CODIGO%TYPE,
IN IN_CGCND_CODIGO SII.CGG_GEM_ENTREVISTA.CGCND_CODIGO%TYPE,
IN IN_CGENT_ESTADO_ENTREVISTA SII.CGG_GEM_ENTREVISTA.CGENT_ESTADO_ENTREVISTA%TYPE,
IN IN_CGENT_FECHA_REALIZACION SII.CGG_GEM_ENTREVISTA.CGENT_FECHA_REALIZACION%TYPE,
IN IN_CGENT_LUGAR SII.CGG_GEM_ENTREVISTA.CGENT_LUGAR%TYPE,
IN IN_CGENT_OBSERVACION SII.CGG_GEM_ENTREVISTA.CGENT_OBSERVACION%TYPE,
IN IN_CGENT_ESTADO SII.CGG_GEM_ENTREVISTA.CGENT_ESTADO%TYPE,
IN IN_CGENT_USUARIO_INSERT SII.CGG_GEM_ENTREVISTA.CGENT_USUARIO_INSERT%TYPE
)RETURNS VARCHAR AS
$$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CGENT_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_GEM_ENTREVISTA','CGENT_CODIGO','CGENT') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CGENT_CODIGO;
	END IF;
	INSERT INTO SII.CGG_GEM_ENTREVISTA(
		CGENT_CODIGO, 
		CGCND_CODIGO, 
		CGENT_ESTADO_ENTREVISTA, 
		CGENT_FECHA_REALIZACION, 
		CGENT_LUGAR, 
		CGENT_OBSERVACION, 
		CGENT_ESTADO, 
		CGENT_FECHA_INSERT, 
		CGENT_USUARIO_INSERT, 
		CGENT_FECHA_UPDATE, 
		CGENT_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 
		IN_CGCND_CODIGO, 
		IN_CGENT_ESTADO_ENTREVISTA, 
		IN_CGENT_FECHA_REALIZACION, 
		IN_CGENT_LUGAR, 
		IN_CGENT_OBSERVACION, 
		IN_CGENT_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CGENT_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CGENT_USUARIO_INSERT
	);	
	RETURN OUT_KEY;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_SELECT_AS
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_GEM_ENTREVISTA.
* @param IN_CGVCN_CODIGO IDENTIFICATIVO UNICO DE VACANTE
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_SELECT_AS(
IN IN_CGVCN_CODIGO VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGENT_CODIGO, 
		CGENT.CGCND_CODIGO, 
		CGENT_ESTADO_ENTREVISTA, 
		CGENT_FECHA_REALIZACION, 
		CGENT_LUGAR, 
		CGENT_OBSERVACION, 
		CGENT_ESTADO, 
		CGENT_FECHA_INSERT, 
		CGENT_USUARIO_INSERT, 
		CGENT_FECHA_UPDATE, 
		CGENT_USUARIO_UPDATE
	FROM SII.CGG_GEM_ENTREVISTA CGENT
	INNER JOIN SII.CGG_GEM_CANDIDATO CGCAN ON CGENT.CGCND_CODIGO = CGCAN.CGCND_CODIGO
	WHERE CGENT_ESTADO = TRUE AND CGCAN.CGVCN_CODIGO = IN_CGVCN_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;


/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GEM_ENTREVISTA
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_CGVCN_CODIGO CODIGO DE LA VACANTE
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return TOTAL DE REGISTROS
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_CGVCN_CODIGO VARCHAR
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(DISTINCT(CGENT.CGENT_CODIGO)) INTO TMP_ROWS
	FROM SII.CGG_GEM_ENTREVISTA CGENT
	INNER JOIN SII.CGG_GEM_CANDIDATO CGCAN ON CGENT.CGCND_CODIGO = CGCAN.CGCND_CODIGO
	WHERE CGENT_ESTADO = TRUE AND CGCAN.CGVCN_CODIGO = IN_CGVCN_CODIGO AND
	SII.F_STRING_IN(
		IN_FIND_TEXT,
		COALESCE(CGENT_ESTADO_ENTREVISTA, '''')||' '||
		COALESCE(CGENT_FECHA_REALIZACION, CURRENT_TIMESTAMP)||' '||
		COALESCE(CGENT_LUGAR, '''')||' '||
		COALESCE(CGENT_OBSERVACION, '''')
	) = 1;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_NOMBRE_USUARIO_BY_ID
* OBTIENE EL NOMBRE DE LA PERSONA CORRESPONDIENTE AL USUARIO.
* @param IN_IDENTIFICADOR IDENTIFICADOR DEL USUARIO 
* @param IN_TIPO TIPO DEL IDENTIFICADOR
* 0 - CODIGO
* 1 - NOMBRE
* @return NOMBRES
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_NOMBRE_USUARIO_BY_ID(
	IN IN_IDENTIFICADOR VARCHAR,
	IN IN_TIPO VARCHAR
)RETURNS VARCHAR AS
$$
DECLARE	
	TMP_IDENTIFICADOR VARCHAR;
	TMP_RETURN VARCHAR;
BEGIN
	TMP_IDENTIFICADOR:=IN_IDENTIFICADOR;
	IF (IN_TIPO = '1') THEN
		SELECT CUSU_CODIGO INTO TMP_IDENTIFICADOR 
		FROM SII.CGG_USUARIO 
		WHERE CUSU_NOMBRE_USUARIO = IN_IDENTIFICADOR;
	END IF;
	SELECT DISTINCT(CRPER_NOMBRES||' '||CRPER_APELLIDO_PATERNO) INTO TMP_RETURN
	FROM CGG_RES_PERSONA CRPER
	INNER JOIN CGG_USUARIO CUSU ON CUSU.CRPER_CODIGO = CRPER.CRPER_CODIGO
	WHERE CUSU.CUSU_CODIGO = TMP_IDENTIFICADOR;
	RETURN TMP_RETURN;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_GEM_ENTREVISTA.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @param IN_CGVCN_CODIGO CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_SELECT(
IN IN_USER_NAME VARCHAR,
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT,
IN IN_CGVCN_CODIGO VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
	TMP_SQL  VARCHAR;
BEGIN
	
	TMP_SQL := 'SELECT
		CGENT.CGENT_CODIGO, 
		CGENT.CGCND_CODIGO, 
		SII.F_CGG_NOMBRE_USUARIO_BY_ID( CGCAN.CUSU_CODIGO ,''0'') AS NOMBRE_USUARIO,
		CGENT_ESTADO_ENTREVISTA, 
		CGENT_FECHA_REALIZACION, 
		CGENT_LUGAR, 
		CGENT_OBSERVACION,		
		CGENT_CRITERIO_TECNICO, 
		CGENT_FECHA_CRITERIO_TECNICO		
	FROM SII.CGG_GEM_ENTREVISTA CGENT
	INNER JOIN SII.CGG_GEM_CANDIDATO CGCAN ON CGENT.CGCND_CODIGO = CGCAN.CGCND_CODIGO
	WHERE CGENT_ESTADO = TRUE AND CGCAN.CGVCN_CODIGO = '''|| IN_CGVCN_CODIGO ||''' AND
	SII.F_STRING_IN(
		'''||IN_FIND_TEXT||''',
		COALESCE(CGENT_ESTADO_ENTREVISTA, '''')||'' ''||
		COALESCE(CGENT_FECHA_REALIZACION, CURRENT_TIMESTAMP)||'' ''||
		COALESCE(CGENT_LUGAR, '''')||'' ''||
		COALESCE(CGENT_CRITERIO_TECNICO, '''')||'' ''||
		COALESCE(CGENT_FECHA_CRITERIO_TECNICO,  CURRENT_TIMESTAMP)||'' ''||
		COALESCE(CGENT_OBSERVACION, '''')		
	) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	OPEN TMP_REF FOR EXECUTE TMP_SQL;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GEM_ENTREVISTA.
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_COUNT(
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_GEM_ENTREVISTA
	WHERE CGENT_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_UPDATE
* ACTUALIZA UN REGISTRO EN LA TABLA sii.CGG_GEM_ENTREVISTA.
* @param IN_CGENT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
* @param IN_CGCND_CODIGO IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
* @param IN_CGENT_ESTADO_ENTREVISTA ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
0 - NO REALIZADA
1 - REALIZADA
2 - NO FINALIZADA
3 - FINALIZADA
* @param IN_CGENT_FECHA_REALIZACION FECHA DE REALIZACION DE LA ENTREVISTA
* @param IN_CGENT_LUGAR LUGAR DE REALIZACION DE LA ENTREVISTA
* @param IN_CGENT_OBSERVACION OBSERVACION DE LA ENTREVISTA
* @param IN_CGENT_ESTADO ESTADO DEL REGISTRO
* @param IN_CGENT_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_UPDATE(
IN IN_CGENT_CODIGO SII.CGG_GEM_ENTREVISTA.CGENT_CODIGO%TYPE,
IN IN_CGCND_CODIGO SII.CGG_GEM_ENTREVISTA.CGCND_CODIGO%TYPE,
IN IN_CGENT_ESTADO_ENTREVISTA SII.CGG_GEM_ENTREVISTA.CGENT_ESTADO_ENTREVISTA%TYPE,
IN IN_CGENT_FECHA_REALIZACION SII.CGG_GEM_ENTREVISTA.CGENT_FECHA_REALIZACION%TYPE,
IN IN_CGENT_LUGAR SII.CGG_GEM_ENTREVISTA.CGENT_LUGAR%TYPE,
IN IN_CGENT_OBSERVACION SII.CGG_GEM_ENTREVISTA.CGENT_OBSERVACION%TYPE,
IN IN_CGENT_ESTADO SII.CGG_GEM_ENTREVISTA.CGENT_ESTADO%TYPE,
IN IN_CGENT_USUARIO_UPDATE SII.CGG_GEM_ENTREVISTA.CGENT_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GEM_ENTREVISTA SET
		CGCND_CODIGO = IN_CGCND_CODIGO, 
		CGENT_ESTADO_ENTREVISTA = IN_CGENT_ESTADO_ENTREVISTA, 
		CGENT_FECHA_REALIZACION = IN_CGENT_FECHA_REALIZACION, 
		CGENT_LUGAR = IN_CGENT_LUGAR, 
		CGENT_OBSERVACION = IN_CGENT_OBSERVACION, 
		CGENT_ESTADO = IN_CGENT_ESTADO, 
		CGENT_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CGENT_USUARIO_UPDATE = IN_CGENT_USUARIO_UPDATE
	WHERE
		CGENT_CODIGO = IN_CGENT_CODIGO;	
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_CRITERIO
* ACTUALIZA UN REGISTRO CON INFORMACION DEL CRITERIO TECNICO DEL ADMINISTRADOR HACIA LA OFERTA.
* @param IN_CGENT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
* @param IN_CGENT_ESTADO ESTADO DEL REGISTRO
* @param IN_CRITERIO_TECNICO IDENTIFICATIVO DE CRITERIO TECNICO.
* @param IN_FECHA_CRITERIO_TECNICO FECHA DEL CRITERIO TECNICO.
* @param IN_CGENT_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_CRITERIO(
IN IN_CGENT_CODIGO SII.CGG_GEM_ENTREVISTA.CGENT_CODIGO%TYPE,
IN IN_CGENT_CRITERIO_TECNICO SII.CGG_GEM_ENTREVISTA.CGENT_CRITERIO_TECNICO%TYPE,
IN IN_CGENT_FECHA_CRITERIO_TECNICO SII.CGG_GEM_ENTREVISTA.CGENT_FECHA_CRITERIO_TECNICO%TYPE,
IN IN_CGENT_ESTADO SII.CGG_GEM_ENTREVISTA.CGENT_ESTADO%TYPE,
IN IN_CGENT_USUARIO_UPDATE SII.CGG_GEM_ENTREVISTA.CGENT_USUARIO_UPDATE%TYPE
)RETURNS VOID AS
$$
DECLARE
	TMP_SEL VARCHAR;
	COD_CND VARCHAR;
BEGIN
	UPDATE SII.CGG_GEM_ENTREVISTA SET
		CGENT_CRITERIO_TECNICO = IN_CGENT_CRITERIO_TECNICO, 
		CGENT_FECHA_CRITERIO_TECNICO = IN_CGENT_FECHA_CRITERIO_TECNICO,
		CGENT_ESTADO = IN_CGENT_ESTADO, 
		CGENT_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CGENT_USUARIO_UPDATE = IN_CGENT_USUARIO_UPDATE
	WHERE
		CGENT_CODIGO = IN_CGENT_CODIGO;
	SELECT CGENT_ESTADO_ENTREVISTA,CGCND_CODIGO INTO TMP_SEL,COD_CND
	FROM SII.CGG_GEM_ENTREVISTA 
	WHERE CGENT_CODIGO = IN_CGENT_CODIGO;
	IF TMP_SEL <> '2' THEN
		UPDATE SII.CGG_GEM_CANDIDATO SET			
			CGCND_SELECCIONADO = 4,
			CGCND_DETALLE = 'Lo sentimos, ha sido rechazado debido a que no se realizo la entrevista.',
			CGCND_FECHA_UPDATE = CURRENT_TIMESTAMP, 
			CGCND_USUARIO_UPDATE = IN_CGENT_USUARIO_UPDATE
		WHERE
			CGCND_CODIGO = COD_CND;
	END IF;	
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_GEM_ENTREVISTA.
* @param IN_CGENT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_SELECT(
IN IN_CGENT_CODIGO SII.CGG_GEM_ENTREVISTA.CGENT_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGENT_CODIGO, 
		CGCND_CODIGO, 
		CGENT_ESTADO_ENTREVISTA, 
		CGENT_FECHA_REALIZACION, 
		CGENT_LUGAR, 
		CGENT_OBSERVACION, 
		CGENT_ESTADO, 
		CGENT_FECHA_INSERT, 
		CGENT_USUARIO_INSERT, 
		CGENT_FECHA_UPDATE, 
		CGENT_USUARIO_UPDATE
	FROM SII.CGG_GEM_ENTREVISTA
	WHERE CGENT_ESTADO = TRUE AND 
		CGENT_CODIGO = IN_CGENT_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_DELETE
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_GEM_ENTREVISTA.
* @param IN_CGENT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_DELETE(
IN IN_CGENT_CODIGO SII.CGG_GEM_ENTREVISTA.CGENT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GEM_ENTREVISTA
	WHERE
		CGENT_CODIGO = IN_CGENT_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_DELETE_SOFT
* ELIMINA LOGICAMENTE UN REGISTRO EN LA TABLA SII.CGG_GEM_ENTREVISTA
* @param IN_CGENT_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_DELETE_SOFT(
IN IN_CGENT_CODIGO SII.CGG_GEM_ENTREVISTA.CGENT_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GEM_ENTREVISTA SET
		CGENT_ESTADO = FALSE
	WHERE
		CGENT_CODIGO = IN_CGENT_CODIGO;
END$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_S_CGG_GEM_CANDIDATO
* SELECCIONA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GEM_ENTREVISTA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_GEM_CANDIDATO.
* @param IN_CGCND_CODIGO IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_S_CGG_GEM_CANDIDATO(
IN IN_CGCND_CODIGO SII.CGG_GEM_ENTREVISTA.CGCND_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGENT_CODIGO, 
		CGCND_CODIGO, 
		CGENT_ESTADO_ENTREVISTA, 
		CGENT_FECHA_REALIZACION, 
		CGENT_LUGAR, 
		CGENT_OBSERVACION, 
		CGENT_ESTADO, 
		CGENT_FECHA_INSERT, 
		CGENT_USUARIO_INSERT, 
		CGENT_FECHA_UPDATE, 
		CGENT_USUARIO_UPDATE
	FROM SII.CGG_GEM_ENTREVISTA
	WHERE CGENT_ESTADO = TRUE AND 
		CGCND_CODIGO = IN_CGCND_CODIGO;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_D_CGG_GEM_CANDIDATO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GEM_ENTREVISTA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_GEM_CANDIDATO.
* @param IN_CGCND_CODIGO IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_D_CGG_GEM_CANDIDATO(
IN IN_CGCND_CODIGO SII.CGG_GEM_ENTREVISTA.CGCND_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	DELETE FROM SII.CGG_GEM_ENTREVISTA
	WHERE
		CGCND_CODIGO = IN_CGCND_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_ENTREVISTA_D_CGG_GEM_CANDIDATO
* ELIMINA TODOS LOS REGISTRO DE LA TABLA SII.CGG_GEM_ENTREVISTA QUE ESTAN
* RELACIONADOS CON LA TABLA SII.CGG_GEM_CANDIDATO.
* @param IN_CGCND_CODIGO IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_ENTREVISTA_DS_CGG_GEM_CANDIDATO(
IN IN_CGCND_CODIGO SII.CGG_GEM_ENTREVISTA.CGCND_CODIGO%TYPE
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GEM_ENTREVISTA SET
		cgent_estado = false
	WHERE
		CGCND_CODIGO = IN_CGCND_CODIGO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

