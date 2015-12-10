/**
* FUNCION SII.F_CGG_RES_MATRIMONIO_DELETE_OFICIAL_MATRIMONIO
* ELIMINA LA INFORMACION DEL OFICIAL DEL MATRIMONIO.
* @param IN_CRMTR_CODIGO IDENTIFICATIVO UNICO DE MATRIMONIO
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_MATRIMONIO_DELETE_OFICIAL_MATRIMONIO(IN_CRMTR_CODIGO CHARACTER VARYING)
RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	DELETE
	FROM SII.CGG_RES_OFICIAL_MATRIMONIO OM	
	WHERE
		OM.CRMTR_CODIGO = IN_CRMTR_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100
  ROWS 1000;
  