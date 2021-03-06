/**
* FUNCCION SII.F_GET_FILE
* OBTIENE EL CONTENIDO DE UN ARCHIVO.
* @param IN_TABLE_NAME NOMBRE DE LA TABLA DONDE SE ENCUENTRA EL ARCHIVO
* @param IN_KEY_COLUMN NOMBRE DE LA COLUMNA QUE ES CLAVE PRIMARIA DE LA TABLA
* @param IN_KEY_VALUE CLAVE PRIMARIA DEL REGISTRO
* @param IN_BINARY_COLUMN NOMBRE DE LA COLUMNA QUE CONTIENE EL ARCHIVO
* @return SETOF REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_GET_FILE(
IN IN_TABLE_NAME VARCHAR,
IN IN_KEY_COLUMN VARCHAR,
IN IN_KEY_VALUE VARCHAR,
IN IN_BINARY_COLUMN VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
	STMT_SQL TEXT;
BEGIN
	STMT_SQL:=' ';
	STMT_SQL:='SELECT
		'||IN_BINARY_COLUMN||'
	FROM SII.'||IN_TABLE_NAME||'
	WHERE '||IN_KEY_COLUMN||' = '||QUOTE_LITERAL(IN_KEY_VALUE);
	
	OPEN TMP_REF FOR EXECUTE STMT_SQL;	
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;