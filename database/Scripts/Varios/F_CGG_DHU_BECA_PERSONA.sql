/** FUNCION: F_CGG_DHU_BECA_PERSONA(CHARACTER VARYING,CHARACTER VARYING)
* PERMITE CONSULTAR UNA PERSONA RESIDENTE PARA EL REGISTRO DE BECA MEDIANTE EL NUMERO DE DOCUMENTO DE IDENTICACION.
* @param IN_CRPER_NUM_DOC_IDENTIFIC NUMERO DE DOCUMENTO IDENTIFICATIVO
* @param IN_CRTST_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE TST
* @return REFCURSOR
-- DROP FUNCTION F_CGG_DHU_BECA_PERSONA(CHARACTER VARYING,CHARACTER VARYING);
*/
CREATE OR REPLACE FUNCTION F_CGG_DHU_BECA_PERSONA(IN_CRPER_NUM_DOC_IDENTIFIC CHARACTER VARYING,IN_CRTST_CODIGO CHARACTER VARYING)
  RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR 
	SELECT
		CRPER_CODIGO, 
		CRPER_NOMBRES, 
		CRPER_APELLIDO_PATERNO, 
		CRPER_APELLIDO_MATERNO, 
		CRPER_NUM_DOC_IDENTIFIC, 
		CRPER_FECHA_NACIMIENTO, 
		CRPER_LUGAR_NACIMIENTO, 
		CRPER_GENERO, 
		CRPER_OBSERVACIONES, 
		CRPER_NUMERO_RESIDENCIA, 
		CRPER_AUTORIZADO, 
		CRPER_NUMERO_EXPEDIENTE, 
		CRPER_FECHA_ARCHIVO 
	FROM SII.CGG_RES_PERSONA
	WHERE CRPER_ESTADO=TRUE AND 
		SII.F_CHECK_PERSONA(CRPER_CODIGO, '''||IN_CRTST_CODIGO||'''::VARCHAR) AND CRPER_NUM_DOC_IDENTIFIC=IN_CRPER_NUM_DOC_IDENTIFIC;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100
  ROWS 1000;