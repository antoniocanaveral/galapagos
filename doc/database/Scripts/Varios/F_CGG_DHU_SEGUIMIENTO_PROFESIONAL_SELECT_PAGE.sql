/**
* FUNCION f_cgg_dhu_seguimiento_profesional_select_page
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_DHU_SEGUIMIENTO_PROFESIONAL.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO 
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC 
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION f_cgg_dhu_seguimiento_profesional_select_page(in_user_name character varying, in_start_index integer, in_limit integer, in_sort_field_name character varying, in_direction character varying, in_find_text text)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		SP.CDSPR_CODIGO, 
		SP.CDBEC_CODIGO, 
		PER.CRPER_NOMBRES,
		PER.CRPER_APELLIDO_PATERNO,
		PER.CRPER_APELLIDO_MATERNO,
		PER.CRPER_NUM_DOC_IDENTIFIC,
		BEC.CDBEC_NUMERO_CONVENIO,
		(SELECT TP.CDTBC_NOMBRE FROM SII.CGG_DHU_TIPO_BECA TP WHERE TP.CDTBC_CODIGO=BEC.CDTBC_CODIGO)AS CDTBC_NOMBRE,
		BEC.CDBEC_BECA_DEVENGADA,
		BEC.CDBEC_FUNCIONARIO,
		(SELECT ESP.CGESP_NOMBRE FROM SII.CGG_ESPECIALIDAD ESP WHERE ESP.CGESP_CODIGO=BEC.CGESP_CODIGO)AS CGESP_NOMBRE,
		SP.CDSPR_ANIO, 
		SP.CDSPR_FECHA_INGRESO, 
		SP.CDSPR_INSTITUCION, 
		SP.CDSPR_CARGO, 
		SP.CDSPR_FECHA_SALIDA, 
		SP.CDSPR_OBSERVACIONES, 
		SP.CDSPR_ESTADO, 
		SP.CDSPR_FECHA_INSERT, 
		SP.CDSPR_USUARIO_INSERT, 
		SP.CDSPR_FECHA_UPDATE, 
		SP.CDSPR_USUARIO_UPDATE
	FROM SII.CGG_DHU_SEGUIMIENTO_PROFESIONAL SP
	INNER JOIN SII.CGG_DHU_BECA BEC ON (BEC.CDBEC_CODIGO=SP.CDBEC_CODIGO)
	INNER JOIN SII.CGG_RES_PERSONA PER ON(PER.CRPER_CODIGO=BEC.CRPER_CODIGO)
	WHERE CDSPR_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
	CASE WHEN SP.CDSPR_CODIGO IS NULL THEN '''' ELSE SP.CDSPR_CODIGO END ||'' ''||
	CASE WHEN SP.CDBEC_CODIGO IS NULL THEN '''' ELSE SP.CDBEC_CODIGO END ||'' ''||
	CASE WHEN SP.CDSPR_ANIO IS NULL THEN 0 ELSE SP.CDSPR_ANIO END ||'' ''||
	CASE WHEN SP.CDSPR_FECHA_INGRESO IS NULL THEN CURRENT_TIMESTAMP ELSE SP.CDSPR_FECHA_INGRESO END ||'' ''||
	CASE WHEN SP.CDSPR_INSTITUCION IS NULL THEN '''' ELSE SP.CDSPR_INSTITUCION END ||'' ''||
	CASE WHEN SP.CDSPR_CARGO IS NULL THEN '''' ELSE SP.CDSPR_CARGO END ||'' ''||
	CASE WHEN SP.CDSPR_FECHA_SALIDA IS NULL THEN CURRENT_TIMESTAMP ELSE SP.CDSPR_FECHA_SALIDA END ||'' ''||
	CASE WHEN SP.CDSPR_OBSERVACIONES IS NULL THEN '''' ELSE SP.CDSPR_OBSERVACIONES END ||'' ''||
	CASE WHEN SP.CDSPR_ESTADO IS NULL THEN FALSE ELSE SP.CDSPR_ESTADO END ||'' ''||
	CASE WHEN SP.CDSPR_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE SP.CDSPR_FECHA_INSERT END ||'' ''||
	CASE WHEN SP.CDSPR_USUARIO_INSERT IS NULL THEN '''' ELSE SP.CDSPR_USUARIO_INSERT END ||'' ''||
	CASE WHEN SP.CDSPR_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE SP.CDSPR_FECHA_UPDATE END ||'' ''||
	CASE WHEN SP.CDSPR_USUARIO_UPDATE IS NULL THEN '''' ELSE SP.CDSPR_USUARIO_UPDATE END ) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION f_cgg_dhu_seguimiento_profesional_select_page(character varying, integer, integer, character varying, character varying, text) OWNER TO sii;