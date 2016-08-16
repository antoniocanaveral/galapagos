-- Function: sii.f_cgg_tct_categoria_select_as(character varying)

-- DROP FUNCTION sii.f_cgg_tct_categoria_select_as(character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_tct_categoria_select_as(in_user_name character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		TCTCAT_CODIGO, 
		TCTCAT_NOMBRE	
	FROM SII.CGG_TCT_CATEGORIA
	WHERE TCTCAT_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION sii.f_cgg_tct_categoria_select_as(character varying)
  OWNER TO postgres;
