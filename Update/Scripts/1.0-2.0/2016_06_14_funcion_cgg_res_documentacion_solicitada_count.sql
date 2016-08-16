-- Function: sii.f_cgg_res_documentacion_solicitada_count()

-- DROP FUNCTION sii.f_cgg_res_documentacion_solicitada_count();

CREATE OR REPLACE FUNCTION sii.f_cgg_res_documentacion_solicitada_count()
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_DOCUMENTACION_SOLICITADA
	WHERE CRDCSL_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_res_documentacion_solicitada_count()
  OWNER TO postgres;
