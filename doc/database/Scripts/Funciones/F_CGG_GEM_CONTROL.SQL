
/**
* FUNCION SII.F_CGG_GEM_VACANTE_COUNT_ROL
* CONTABILIZA EL NUMERO DE REGISTROS DE LA TABLA SII.CGG_GEM_VACANTE DE ACEURDO AL ROL
* QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @param IN_CUSU_CODIGO IDENTIFICATIVO UNICO DE USUARIO
* @param IN_CSROL_CODIGO IDENTIFICATIVO UNICO DE ROL
* @return TOTAL DE REGISTROS
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_VACANTE_COUNT_ROL(
IN IN_CUSU_CODIGO SII.CGG_GEM_VACANTE.CUSU_CODIGO%TYPE,
IN IN_FIND_TEXT TEXT,
IN IN_CSROL_CODIGO SII.CGG_SEC_ROL.CSROL_CODIGO%TYPE
)RETURNS INT AS
$$
DECLARE
TMP_ROWS INT2;
TMP_WHERE VARCHAR;
TMP_SQL TEXT;
TMP_USER VARCHAR;
TMP VARCHAR;
TMP_ISLA varchar;
BEGIN
	SELECT CUSU_CODIGO,CISLA_CODIGO INTO TMP_USER,TMP_ISLA FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = IN_CUSU_CODIGO; 
	TMP:='';
	IF (IN_CSROL_CODIGO = 'CSROL_GEADM') THEN
		TMP_WHERE:='(CGVCN_ESTADO_OFERTA <>-1 OR CGVCN.CUSU_CODIGO ='''||TMP_USER||''') ';
		--Para filtrar solo las ofertas de cada isla
		TMP_WHERE:=TMP_WHERE||' AND CGVCN.CISLA_CODIGO = '''||TMP_ISLA||'''';
	ELSIF (IN_CSROL_CODIGO = 'CSROL_GEEMP' OR IN_CSROL_CODIGO = 'CSROL_GEAPL') THEN
		TMP_WHERE := 'CGVCN.CUSU_CODIGO= '''||IN_CUSU_CODIGO ||'''';
	ELSIF (IN_CSROL_CODIGO = 'CSROL_GEAPL_WEB') THEN
		TMP_WHERE := 'CGVCN_ESTADO_OFERTA > 0 ';
	ELSE
		TMP_WHERE :='CGVCN_ESTADO_OFERTA = 1 AND  (CGVCN_FECHA_PUBLICACION + CAST(CGVCN_DURACION_OFERTA ||'' days'' AS INTERVAL)) >= CURRENT_DATE ';	
	END IF;
	
	TMP_SQL:='SELECT COUNT(distinct(CGVCN.CGVCN_CODIGO))
		FROM SII.CGG_GEM_VACANTE CGVCN
	INNER JOIN SII.CGG_GEM_CARGO CGCRG ON CGCRG.CGCRG_CODIGO = CGVCN.CGCRG_CODIGO
	INNER JOIN SII.CGG_TITULO_PROFESIONAL CGTPR ON CGTPR.CGTPR_CODIGO = CGVCN.CGTPR_CODIGO
		WHERE CGVCN_ESTADO = TRUE AND '||TMP_WHERE||' AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
		COALESCE(CGVCN_NUMERO, 0)||'' ''||		
		COALESCE(CGVCN_FECHA_PUBLICACION, CURRENT_TIMESTAMP)||'' ''||		
		COALESCE(CGVCN_FECHA_EXPIRACION, CURRENT_TIMESTAMP)||'' ''||		
		COALESCE(CGVCN_NUMERO_VACANTES, 0)||'' ''||			
		COALESCE(CGVCN_NUMERO_MANOBRA, '''')||'' ''||
		COALESCE(CGCRG.CGCRG_NOMBRE, '''')||'' ''||
		COALESCE(CGTPR.CGTPR_DESCRIPCION, '''')||'' ''||
		COALESCE(CGVCN_ANIO, 0)||'' ''||
		COALESCE(CGVCN_NUMERO_COMUNICADO, '''')
		) = 1';
	EXECUTE TMP_SQL INTO TMP_ROWS;
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_VACANTE_SELECT_ROL
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_GEM_VACANTE DE ACUERDO AL ROL DEL USUARIO.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_VACANTE_SELECT_ROL(
IN IN_USER_NAME VARCHAR,
IN IN_START_INDEX INT,
IN IN_LIMIT INT,
IN IN_SORT_FIELD_NAME VARCHAR,
IN IN_DIRECTION VARCHAR,
IN IN_FIND_TEXT TEXT,
IN IN_CSROL_CODIGO SII.CGG_SEC_ROL.CSROL_CODIGO%TYPE
)RETURNS SETOF REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;
	TMP VARCHAR;
	TMP_USER VARCHAR;
	TMP_ISLA VARCHAR;	
	TMP_SQL TEXT;
BEGIN
	SELECT CUSU_CODIGO,CISLA_CODIGO INTO TMP_USER,TMP_ISLA FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME; 
	IF (IN_CSROL_CODIGO = 'CSROL_GEADM') THEN
		TMP:='AND (CGVCN_ESTADO_OFERTA <>-1 OR CGVCN.CUSU_CODIGO ='''||TMP_USER||''') ';
		--Para filtrar solo las ofertas de cada isla
		TMP:=TMP||' AND CGVCN.CISLA_CODIGO = '''||TMP_ISLA||'''';
	ELSIF (IN_CSROL_CODIGO = 'CSROL_GEEMP' OR IN_CSROL_CODIGO = 'CSROL_GEAPL') THEN
		TMP:=' AND CGVCN.CUSU_CODIGO = '''||TMP_USER||''' ';
	ELSE
		TMP:=' AND CGVCN_ESTADO_OFERTA = 1 AND  (CGVCN_FECHA_PUBLICACION + CAST(CGVCN_DURACION_OFERTA ||'' days'' AS INTERVAL)) >= CURRENT_DATE ';	
	END IF;
	
	TMP_SQL:=	'SELECT DISTINCT(CGVCN.CGVCN_CODIGO), 
		CGVCN.CUSU_CODIGO, 
		CUSU.CUSU_NOMBRE_USUARIO,
		CASE WHEN CRPJR.CRPJR_CODIGO IS NULL THEN 0 ELSE 1 END AS EMPRESA,
		CASE WHEN CGCND.CGCND_CODIGO IS NULL THEN 0 ELSE 1 END AS CANDIDATOS,
		''0'' APLICO,		
		CGVCN.CSCTP_CODIGO, 
		CGTCN_CODIGO, 
		CGTSA.CGTSA_CODIGO,CGTSA.CGTSA_NOMBRE, 
		CGCRG.CGCRG_CODIGO,CGCRG.CGCRG_NOMBRE, 
		CGTPR.CGTPR_CODIGO,CGTPR.CGTPR_DESCRIPCION,
		CGVCN_NUMERO, 
		CGVCN_TITULO, 
		CGVCN_DESCRIPCION, 
		CGVCN_SALARIO, 
		CGVCN_DIRECCION, 
		CGVCN_FECHA_INGRESO, 
		CGVCN_FECHA_PUBLICACION, 
		CGVCN_DURACION_OFERTA, 
		CGVCN_FECHA_EXPIRACION, 
		CGVCN_ESTADO_OFERTA, 
		CGVCN_NUMERO_VACANTES, 
		CGVCN_DURACION, 
		CGVCN_DURACION_TIEMPO, 
		CGVCN_EXPERIENCIA, 
		CGVCN_EXISTENCIA_MANOBRA, 
		CGVCN_NUMERO_MANOBRA, 
		CGVCN_ANIO, 
		CGVCN_NUMERO_COMUNICADO, 
		CGVCN_OFERTA_APROBADA, 
		CGVCN_CUBIERTA, 
		CGVCN_JUSTIFICACION_NO_CONTRAT		
	FROM SII.CGG_GEM_VACANTE CGVCN
	INNER JOIN SII.CGG_USUARIO CUSU ON CUSU.CUSU_CODIGO = CGVCN.CUSU_CODIGO
	INNER JOIN SII.CGG_GEM_TIPO_SALARIO CGTSA ON CGVCN.CGTSA_CODIGO = CGTSA.CGTSA_CODIGO
	INNER JOIN SII.CGG_GEM_CARGO CGCRG ON CGCRG.CGCRG_CODIGO = CGVCN.CGCRG_CODIGO
	INNER JOIN SII.CGG_TITULO_PROFESIONAL CGTPR ON CGTPR.CGTPR_CODIGO = CGVCN.CGTPR_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA_JURIDICA CRPJR ON ( CRPJR.CRPJR_CODIGO =  CUSU.CRPJR_CODIGO)
	LEFT JOIN SII.CGG_GEM_CANDIDATO CGCND ON ( CGCND.CGVCN_CODIGO =  CGVCN.CGVCN_CODIGO)	
	WHERE CGVCN_ESTADO = TRUE '||TMP||' AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
		COALESCE(CGVCN_NUMERO, 0)||'' ''||		
		COALESCE(CGVCN_FECHA_PUBLICACION, CURRENT_TIMESTAMP)||'' ''||		
		COALESCE(CGVCN_FECHA_EXPIRACION, CURRENT_TIMESTAMP)||'' ''||		
		COALESCE(CGVCN_NUMERO_VACANTES, 0)||'' ''||			
		COALESCE(CGVCN_NUMERO_MANOBRA, '''')||'' ''||
		COALESCE(CGCRG.CGCRG_NOMBRE, '''')||'' ''||
		COALESCE(CGTPR.CGTPR_DESCRIPCION, '''')||'' ''||
		COALESCE(CGVCN_ANIO, 0)||'' ''||
		COALESCE(CGVCN_NUMERO_COMUNICADO, '''')
		) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	OPEN TMP_REF FOR EXECUTE TMP_SQL;
	RETURN NEXT TMP_REF;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_GET_ROL_USUARIO
* OBTIENE EL ROL QUE TIENE EL USUARIO
* @param IN_CUSU_NOMBRE_USUARIO NOMBRE DE USARIO
* @return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_GET_ROL_USUARIO(
IN IN_CUSU_NOMBRE_USUARIO SII.CGG_USUARIO.CUSU_NOMBRE_USUARIO%TYPE
)RETURNS VARCHAR AS
$$
DECLARE	
	OUT_ROL VARCHAR;
BEGIN
	SELECT CSROL_CODIGO INTO OUT_ROL
	FROM SII.CGG_SEC_USUARIO_ROL UR
	INNER JOIN SII.CGG_USUARIO US ON UR.CUSU_CODIGO = US.CUSU_CODIGO
	WHERE US.CUSU_NOMBRE_USUARIO = IN_CUSU_NOMBRE_USUARIO AND UR.CSPER_ESTADO = TRUE	
	AND UR.CSROL_CODIGO IN ('CSROL_GEADM','CSROL_GEEMP','CSROL_GEAPL');
	IF (OUT_ROL IS NULL) THEN
		OUT_ROL:='';
	END IF;
	RETURN OUT_ROL;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CGG_GEM_SET_VENCIDA
* ESTABLECE ESTADO DE LA VACANTE.
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GEM_SET_VENCIDA(	
)RETURNS VOID AS
$$
BEGIN
	UPDATE SII.CGG_GEM_VACANTE SET
		CGVCN_ESTADO_OFERTA = 2
	WHERE 
		CGVCN_FECHA_PUBLICACION IS NOT NULL 
		AND CGVCN_FECHA_EXPIRACION IS NOT NULL
		AND CGVCN_ESTADO_OFERTA = 1
		AND DATE_TRUNC('DAY', CGVCN_FECHA_EXPIRACION)< CURRENT_DATE;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;
