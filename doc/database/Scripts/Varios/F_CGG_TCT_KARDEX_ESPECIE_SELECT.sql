/**
* FUNCION SII.F_CGG_TCT_KARDEX_ESPECIE_SELECT
* SELECCIONA N REGISTROS DE LA TABLA CGG_KARDEX_ESPECIE. 
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_TCT_KARDEX_ESPECIE_SELECT()
  RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT 		
		CKESP_CODIGO,
		CKESP_NOMBRE
	FROM SII.CGG_KDX_ESPECIE
	WHERE CKESP_TIPO = 1;
	RETURN NEXT TMP_REF;
END
$BODY$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;
