-- Function: sii.f_cgg_res_documentacion_solicitada_select(character varying, integer, integer, character varying, character varying, text)

-- DROP FUNCTION sii.f_cgg_res_documentacion_solicitada_select(character varying, integer, integer, character varying, character varying, text);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_documentacion_solicitada_select(in_user_name character varying, in_start_index integer, in_limit integer, in_sort_field_name character varying, in_direction character varying, in_find_text text)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		CRDCSL_CODIGO,
		CRDCSL_DESCRIPCION, 
		CRDCSL_ESTADO, 
		CRDCSL_TIPO 
	FROM SII.CGG_RES_DOCUMENTACION_SOLICITADA
	WHERE CRDCSL_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CRDCSL_DESCRIPCION, '''')||'' ''||COALESCE(CRDCSL_ESTADO, FALSE)||'' ''||COALESCE(CRDCSL_TIPO, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION sii.f_cgg_res_documentacion_solicitada_select(character varying, integer, integer, character varying, character varying, text)
  OWNER TO postgres;
