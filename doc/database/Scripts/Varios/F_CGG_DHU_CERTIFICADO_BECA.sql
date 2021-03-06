/**
* FUNCION F_CGG_DHU_CERTIFICADO_BECA
* SELECCIONA UN REGISTROS DE LA TABLA SII.CGG_DHU_SEGUIMIENTO_ACADEMICO. 
* @param IN_CDADC_CODIGO CRITERIO DE BUSQUEDA
* @param IN_CDBEC_CODIGO CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/

CREATE OR REPLACE FUNCTION F_CGG_DHU_CERTIFICADO_BECA(IN_CDBEC_CODIGO CHARACTER VARYING,IN_CDACD_CODIGO CHARACTER VARYING)
  RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT DISTINCT        
	SAD.CDSAD_FECHA_REGISTRO, 
	SAD.CDSAD_NOMBRE_ADJUNTO, 
	--SAD.CDSAD_ADJUNTO, 
	CDSAD_CODIGO,
	SAD.CDSAD_OBSERVACION,
	AC.CDACD_CODIGO,
	BECA.* FROM (SELECT 
	BEC.CDBEC_CODIGO,
	BC.CDTBC_CODIGO, 
	BC.CDTCA_CODIGO, 
	CMO.CDTCA_NOMBRE, 
	BC.CDBCR_CODIGO,
	BC.CDBCR_OBLIGATORIO
FROM CGG_DHU_BECA_CERTIFICADO BC
INNER JOIN CGG_DHU_TIPO_CACADEMICO CMO ON (BC.CDTCA_CODIGO=CMO.CDTCA_CODIGO)
INNER JOIN SII.CGG_DHU_TIPO_BECA TB ON (BC.CDTBC_CODIGO=TB.CDTBC_CODIGO )
INNER JOIN CGG_DHU_BECA BEC ON(BEC.CDTBC_CODIGO= BC.CDTBC_CODIGO)
WHERE  BEC.CDBEC_CODIGO=IN_CDBEC_CODIGO AND BC.CDBCR_ESTADO=TRUE) AS BECA
LEFT JOIN SII.CGG_DHU_SEGUIMIENTO_ACADEMICO AC ON(AC.CDBEC_CODIGO =BECA.CDBEC_CODIGO AND (AC.CDACD_CODIGO = IN_CDACD_CODIGO OR AC.CDACD_CODIGO IS NULL))  
LEFT JOIN SII.CGG_DHU_SADJUNTO SAD ON (SAD.CDACD_CODIGO = AC.CDACD_CODIGO)  AND ( SAD.CDBCR_CODIGO = BECA.CDBCR_CODIGO);
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION F_CGG_DHU_CERTIFICADO_BECA(CHARACTER VARYING,CHARACTER VARYING) OWNER TO SII;
