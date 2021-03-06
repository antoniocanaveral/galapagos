/**
* FUNCION SII.F_CGG_TCT_MOVILIDAD_RESIDENCIA_PAG_SELECT
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_MOVILIDAD.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @param IN_IDENTIFICACION INFORMACION DE LA IDENTIFICACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_TCT_MOVILIDAD_RESIDENCIA_PAG_SELECT(
IN IN_USER_NAME VARCHAR(50),
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT,
IN IN_IDENTIFICACION VARCHAR
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
	TMP_SQL VARCHAR;
BEGIN
	SELECT 'SELECT distinct
		PR.CRPER_CODIGO,
		PR.CRDID_CODIGO,
		DI.CRDID_DESCRIPCION,		
		PR.CRPER_NUM_DOC_IDENTIFIC,
		PR.CRPER_NUMERO_RESIDENCIA,
		PR.CRPER_NOMBRES,
		PR.CRPER_APELLIDO_PATERNO,
		COALESCE(PR.CRPER_GENERO,0) CRPER_GENERO,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CGNCN_CODIGO,		
		NC.CGNCN_NACIONALIDAD,						
		RS.CRRSD_CODIGO,
		TST.CRTST_DESCRIPCION TIPO_RESIDENCIA
	FROM SII.CGG_RES_RESIDENCIA RS
	INNER JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = RS.CRTST_CODIGO
	INNER JOIN SII.CGG_RES_PERSONA PR ON PR.CRPER_CODIGO = RS.CRPER_CODIGO AND PR.CRPER_ESTADO 
	INNER JOIN SII.CGG_RES_DOCUMENTO_IDENTIFICACIO DI ON(DI.CRDID_CODIGO=PR.CRDID_CODIGO)
	LEFT JOIN SII.CGG_NACIONALIDAD NC ON NC.CGNCN_CODIGO = PR.CGNCN_CODIGO
	WHERE RS.CRRSD_VIGENTE AND 
		RS.CRRSD_ESTADO AND
		RS.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
					SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO IN (SELECT CGCNF_VALOR_CADENA
					FROM CGG_CONFIGURACION
					WHERE CGCNF_CODIGO IN (''03'',''04'')) 
					UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
					WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
				) SELECT CRTST_CODIGO  FROM TIPO) AND
		(LENGTH('||QUOTE_LITERAL(IN_FIND_TEXT)||') = 0 OR crper_index @@ plainto_tsquery('||QUOTE_LITERAL(IN_FIND_TEXT)||')) AND 
		(LENGTH('||QUOTE_LITERAL(IN_IDENTIFICACION)||') = 0 OR PR.CRPER_NUM_DOC_IDENTIFIC = '||QUOTE_LITERAL(IN_IDENTIFICACION)||' OR PR.CRPER_NUMERO_RESIDENCIA = '||QUOTE_LITERAL(IN_IDENTIFICACION)||')
	LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX INTO TMP_SQL;
	OPEN TMP_REF FOR EXECUTE TMP_SQL;
	
	--ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_TCT_MOVILIDAD_RESIDENCIA_PAG_COUNT
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_RES_MOVILIDAD.
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return TOTAL DE REGISTROS
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_TCT_MOVILIDAD_RESIDENCIA_PAG_COUNT(
IN IN_FIND_TEXT TEXT
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INTEGER;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_RESIDENCIA RS
	INNER JOIN SII.CGG_RES_PERSONA PR ON PR.CRPER_CODIGO = RS.CRPER_CODIGO AND PR.CRPER_ESTADO 
	INNER JOIN SII.CGG_RES_DOCUMENTO_IDENTIFICACIO DI ON(DI.CRDID_CODIGO=PR.CRDID_CODIGO)
	INNER JOIN SII.CGG_NACIONALIDAD NC ON NC.CGNCN_CODIGO = PR.CGNCN_CODIGO
	WHERE RS.CRRSD_VIGENTE AND 
		RS.CRRSD_ESTADO AND
		RS.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
					SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO IN (SELECT CGCNF_VALOR_CADENA
					FROM CGG_CONFIGURACION
					WHERE CGCNF_CODIGO IN ('03','04')) 
					UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
					WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
				) SELECT CRTST_CODIGO  FROM TIPO) AND
		(LENGTH(IN_FIND_TEXT) = 0 OR crper_index @@ plainto_tsquery(IN_FIND_TEXT));
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;


