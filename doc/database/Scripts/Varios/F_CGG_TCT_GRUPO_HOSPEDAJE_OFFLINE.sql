--FUNCION: f_cgg_tct_grupo_hospedaje_offline
/*SELECCIONA INFORMACION DE LAS TABLAS CGG_TCT_GRUPO_HOSPEDAJE
*@PARAM in_user_name*/
CREATE OR REPLACE FUNCTION f_cgg_tct_grupo_hospedaje_offline(in_user_name character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT DISTINCT GH.CTGHJ_CODIGO,GH.CTGTR_CODIGO,GH.CTTHJ_CODIGO 
	FROM CGG_TCT_GRUPO_HOSPEDAJE GH
	INNER JOIN CGG_TCT_REGISTRO TCT ON(TCT.CTGTR_CODIGO=GH.CTGTR_CODIGO)
	WHERE CTREG_ESTADO AND  
	TCT.CTREG_ESTADO_REGISTRO IN (1,4); 
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION f_cgg_tct_grupo_hospedaje_offline(character varying) OWNER TO sii;