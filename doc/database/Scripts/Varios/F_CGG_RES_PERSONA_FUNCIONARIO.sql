/**
* FUNCION F_CGG_RES_PERSONA_FUNCIONARIO
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_PERSONA,SII_CGG_USUARIO.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/

CREATE OR REPLACE FUNCTION F_CGG_RES_PERSONA_FUNCIONARIO(IN_USER_NAME CHARACTER VARYING, IN_START_INDEX INTEGER, IN_LIMIT INTEGER, IN_SORT_FIELD_NAME CHARACTER VARYING, IN_DIRECTION CHARACTER VARYING, IN_FIND_TEXT TEXT)
  RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
	TMP TEXT;
BEGIN
	
	TMP:='SELECT PER.CRPER_CODIGO,
	--(SELECT TDI.CRDID_DESCRIPCION FROM SII.CGG_RES_DOCUMENTO_IDENTIFICACIO TDI WHERE TDI.CRDID_CODIGO =PER.CRDID_CODIGO)AS CRDID_TIPO,
	--(SELECT NAC.CGNCN_NACIONALIDAD FROM SII.CGG_NACIONALIDAD NAC WHERE NAC.CGNCN_CODIGO =PER.CGNCN_CODIGO)AS CGNCN_NOMBRE,
	--(SELECT PAR.CPRR_NOMBRE FROM SII.CGG_PARROQUIA PAR WHERE PAR.CPRR_CODIGO =PER.CPRR_CODIGO)AS CPRR_NOMBRE,
	--(SELECT CTN.CCTN_NOMBRE FROM SII.CGG_CANTON CTN WHERE CTN.CCTN_CODIGO =PER.CCTN_CODIGO)AS CCNT_NOMBRE,
        --(SELECT CAN.CCTN_NOMBRE FROM SII.CGG_CANTON CAN WHERE CAN.CCTN_CODIGO =PER.CGG_CCTN_CODIGO)AS CCNT_NOMBRE_ORIGEN,
       PER.CRPER_NOMBRES,
       PER.CRPER_APELLIDO_PATERNO,
       PER.CRPER_APELLIDO_MATERNO,
       PER.CRPER_NUM_DOC_IDENTIFIC,
       U.CUSU_USUARIO_INTERNO  
	
	FROM SII.CGG_RES_PERSONA PER INNER JOIN SII.CGG_USUARIO U ON(PER.CRPER_CODIGO=U.CRPER_CODIGO)
        WHERE PER.CRPER_ESTADO = TRUE AND U.CUSU_ESTADO = TRUE  AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
	CASE WHEN PER.CRPER_CODIGO IS NULL THEN '''' ELSE PER.CRPER_CODIGO END ||'' ''||
	CASE WHEN PER.CRECV_CODIGO IS NULL THEN '''' ELSE PER.CRECV_CODIGO END ||'' ''||
	CASE WHEN PER.CRDID_CODIGO IS NULL THEN '''' ELSE PER.CRDID_CODIGO END ||'' ''||
	CASE WHEN PER.CRTSG_CODIGO IS NULL THEN '''' ELSE PER.CRTSG_CODIGO END ||'' ''||
	CASE WHEN PER.CGNCN_CODIGO IS NULL THEN '''' ELSE PER.CGNCN_CODIGO END ||'' ''||
	CASE WHEN PER.CPRR_CODIGO IS NULL THEN '''' ELSE PER.CPRR_CODIGO END ||'' ''||
	CASE WHEN PER.CCTN_CODIGO IS NULL THEN '''' ELSE PER.CCTN_CODIGO END ||'' ''||
	CASE WHEN PER.CGG_CCTN_CODIGO IS NULL THEN '''' ELSE PER.CGG_CCTN_CODIGO END ||'' ''||
	CASE WHEN PER.CRPER_NOMBRES IS NULL THEN '''' ELSE PER.CRPER_NOMBRES END ||'' ''||
	CASE WHEN PER.CRPER_APELLIDO_PATERNO IS NULL THEN '''' ELSE PER.CRPER_APELLIDO_PATERNO END ||'' ''||
	CASE WHEN PER.CRPER_APELLIDO_MATERNO IS NULL THEN '''' ELSE PER.CRPER_APELLIDO_MATERNO END ||'' ''||
	CASE WHEN PER.CRPER_NUM_DOC_IDENTIFIC IS NULL THEN '''' ELSE PER.CRPER_NUM_DOC_IDENTIFIC END ||'' ''||
	CASE WHEN PER.CRPER_FECHA_NACIMIENTO IS NULL THEN CURRENT_TIMESTAMP ELSE PER.CRPER_FECHA_NACIMIENTO END ||'' ''||
	CASE WHEN PER.CRPER_LUGAR_NACIMIENTO IS NULL THEN '''' ELSE PER.CRPER_LUGAR_NACIMIENTO END ||'' ''||
	CASE WHEN PER.CRPER_GENERO IS NULL THEN 0 ELSE PER.CRPER_GENERO END ||'' ''||
	CASE WHEN PER.CRPER_NUMERO_RESIDENCIA IS NULL THEN '''' ELSE PER.CRPER_NUMERO_RESIDENCIA END ||'' ''||
	CASE WHEN PER.CRPER_TIPO_PERSONA IS NULL THEN 0 ELSE PER.CRPER_TIPO_PERSONA END ||'' ''||
	CASE WHEN PER.CRPER_TIPO IS NULL THEN 0 ELSE PER.CRPER_TIPO END ||'' ''||
	CASE WHEN PER.CRPER_ESTADO IS NULL THEN FALSE ELSE PER.CRPER_ESTADO END ||'' ''||CASE WHEN PER.CRPER_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE PER.CRPER_FECHA_INSERT END ||'' ''||
	CASE WHEN PER.CRPER_USUARIO_INSERT IS NULL THEN '''' ELSE PER.CRPER_USUARIO_INSERT END ||'' ''||
	CASE WHEN PER.CRPER_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE PER.CRPER_FECHA_UPDATE END ||'' ''||
	CASE WHEN PER.CRPER_USUARIO_UPDATE IS NULL THEN '''' ELSE PER.CRPER_USUARIO_UPDATE END ) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	OPEN TMP_REF FOR EXECUTE TMP;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION F_CGG_RES_PERSONA_FUNCIONARIO(CHARACTER VARYING, INTEGER, INTEGER, CHARACTER VARYING, CHARACTER VARYING, TEXT) OWNER TO SII;
