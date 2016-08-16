-- Function: sii.f_cgg_tipo_tramite_select_as(character varying)

-- DROP FUNCTION sii.f_cgg_tipo_tramite_select_as(character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_tipo_tramite_select_as(in_user_name character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTT_CODIGO, 
		CRTT_NOMBRE	
	FROM SII.CGG_TIPO_TRAMITE
	WHERE CRTT_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION sii.f_cgg_tipo_tramite_select_as(character varying)
  OWNER TO postgres;
