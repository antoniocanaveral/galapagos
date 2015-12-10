/*
* FUNCION SII.F_CGG_RES_CARGO_COMITE__SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_CARGO_COMITE
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS.
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS.
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO. 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC. 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @param IN_CRCOM_CODIGO CODIGO DE LA TABLA CGG_RES_COMITE PARA LA BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_COMITE_CARGO_COMITE_SELECT(
IN IN_USER_NAME varchar(50),
IN IN_START_INDEX int,
IN IN_LIMIT int,
IN IN_SORT_FIELD_NAME varchar,
IN IN_DIRECTION varchar,
IN IN_FIND_TEXT text,
IN IN_CRCOM_CODIGO SII.CGG_RES_COMITE.CRCOM_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		CC.CRCRG_CODIGO, 
		CC.CRCOM_CODIGO, 
		CC.CRCRG_NOMBRE, 
		CC.CRCRG_VOTO_DIRIMENTE, 
		CC.CRCRG_ESTADO, 
		CC.CRCRG_FECHA_INSERT, 
		CC.CRCRG_USUARIO_INSERT, 
		CC.CRCRG_FECHA_UPDATE, 
		CC.CRCRG_USUARIO_UPDATE
	FROM SII.CGG_RES_CARGO_COMITE CC
	INNER JOIN SII.CGG_RES_COMITE MT ON (MT.CRCOM_CODIGO = CC.CRCOM_CODIGO)
	WHERE CRCRG_ESTADO = TRUE 
	AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
		CASE WHEN CC.CRCRG_CODIGO IS NULL THEN '''' ELSE CC.CRCRG_CODIGO END ||'' ''||
		CASE WHEN CC.CRCOM_CODIGO IS NULL THEN '''' ELSE CC.CRCOM_CODIGO END ||'' ''||
		CASE WHEN CC.CRCRG_NOMBRE IS NULL THEN '''' ELSE CC.CRCRG_NOMBRE END ||'' ''||
		CASE WHEN CC.CRCRG_VOTO_DIRIMENTE IS NULL THEN FALSE ELSE CC.CRCRG_VOTO_DIRIMENTE END ||'' ''||
		CASE WHEN CC.CRCRG_ESTADO IS NULL THEN FALSE ELSE CC.CRCRG_ESTADO END ||'' ''||
		CASE WHEN CC.CRCRG_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE CC.CRCRG_FECHA_INSERT END ||'' ''||
		CASE WHEN CC.CRCRG_USUARIO_INSERT IS NULL THEN '''' ELSE CC.CRCRG_USUARIO_INSERT END ||'' ''||
		CASE WHEN CC.CRCRG_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE CC.CRCRG_FECHA_UPDATE END ||'' ''||
		CASE WHEN CC.CRCRG_USUARIO_UPDATE IS NULL THEN '''' ELSE CC.CRCRG_USUARIO_UPDATE END ) = 1
	AND  MT.CRCOM_CODIGO = '''||IN_CRCOM_CODIGO||'''
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_CARGO_COMITE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_CARGO_COMITE
* @param IN_CRCOM_CODIGO CODIGO DE LA TABLA CGG_RES_COMITE PARA LA BUSQUEDA
* @return INT
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_COMITE_CARGO_COMITE_COUNT(
IN IN_CRCOM_CODIGO SII.CGG_RES_COMITE.CRCOM_CODIGO%TYPE
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_CARGO_COMITE CC
	INNER JOIN SII.CGG_RES_COMITE MT ON (MT.CRCOM_CODIGO = CC.CRCOM_CODIGO)
	WHERE CRCRG_ESTADO = TRUE
	AND  MT.CRCOM_CODIGO =IN_CRCOM_CODIGO;
	
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_RES_CARGO_COMITE_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_CARGO_COMITE
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA.
* @param IN_CRCOM_CODIGO CODIGO DE LA TABLA CGG_RES_COMITE PARA LA BUSQUEDA
* @return TOTAL DE REGISTROS.
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_COMITE_CARGO_COMITE_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_CRCOM_CODIGO SII.CGG_RES_COMITE.CRCOM_CODIGO%TYPE
)RETURNS INT AS
$$
DECLARE
TMP_ROWS int2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_CARGO_COMITE CC
	INNER JOIN SII.CGG_RES_COMITE MT ON (MT.CRCOM_CODIGO = CC.CRCOM_CODIGO)
	WHERE CRCRG_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,CASE WHEN CRCRG_CODIGO IS NULL THEN '''' ELSE CRCRG_CODIGO END ||' '||
	CASE WHEN CRCOM_CODIGO IS NULL THEN '''' ELSE CRCOM_CODIGO END ||' '||CASE WHEN CRCRG_NOMBRE IS NULL THEN '''' ELSE CRCRG_NOMBRE END ||' '||
	CASE WHEN CRCRG_VOTO_DIRIMENTE IS NULL THEN FALSE ELSE CRCRG_VOTO_DIRIMENTE END ||' '||
	CASE WHEN CRCRG_ESTADO IS NULL THEN FALSE ELSE CRCRG_ESTADO END ||' '||
	CASE WHEN CRCRG_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE CRCRG_FECHA_INSERT END ||' '||
	CASE WHEN CRCRG_USUARIO_INSERT IS NULL THEN '''' ELSE CRCRG_USUARIO_INSERT END ||' '||
	CASE WHEN CRCRG_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE CRCRG_FECHA_UPDATE END ||' '||
	CASE WHEN CRCRG_USUARIO_UPDATE IS NULL THEN '''' ELSE CRCRG_USUARIO_UPDATE END ) = 1
	AND  MT.CRCOM_CODIGO =IN_CRCOM_CODIGO;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;