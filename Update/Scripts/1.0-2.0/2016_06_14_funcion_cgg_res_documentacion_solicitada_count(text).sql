-- Function: sii.f_cgg_res_documentacion_solicitada_count(text)

-- DROP FUNCTION sii.f_cgg_res_documentacion_solicitada_count(text);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_documentacion_solicitada_count(in_find_text text)
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_DOCUMENTACION_SOLICITADA
	WHERE CRDCSL_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CRDCSL_DESCRIPCION, '''')||' '||COALESCE(CRDCSL_TIPO, '''')) = 1;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_res_documentacion_solicitada_count(text)
  OWNER TO postgres;
