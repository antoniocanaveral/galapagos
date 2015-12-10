
/**
* FUNCION F_CGG_DHU_SADJUNTO_CERTIFICADO_BECA
* SELECCIONA UN REGISTROS DE LA TABLA SII.CGG_DHU_SADJUNTO .
* @param IN_CDADC_CODIGO CRITERIO DE BUSQUEDA.
* @return REFCURSOR
*/

CREATE OR REPLACE FUNCTION F_CGG_DHU_SADJUNTO_CERTIFICADO_BECA(in_cdacd_codigo character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
	    BC.CDTBC_CODIGO, 
		BC.CDTCA_CODIGO, 
		CMO.CDTCA_NOMBRE, 
		BC.CDBCR_CODIGO,
		BC.CDBCR_OBLIGATORIO,
               SAD.CDSAD_FECHA_REGISTRO, 
		SAD.CDSAD_NOMBRE_ADJUNTO,
		SAD.CDSAD_CODIGO, 
		SAD.CDSAD_ADJUNTO, 
		SAD.CDSAD_OBSERVACION, 		
		BC.CDBCR_ESTADO, 
		BC.CDBCR_FECHA_INSERT, 
		BC.CDBCR_USUARIO_INSERT, 
		BC.CDBCR_FECHA_UPDATE, 
		BC.CDBCR_USUARIO_UPDATE
	FROM SII.CGG_DHU_BECA_CERTIFICADO BC
	INNER JOIN SII.CGG_DHU_TIPO_BECA TB ON (BC.CDTBC_CODIGO=TB.CDTBC_CODIGO)
	LEFT JOIN SII.CGG_DHU_TIPO_CACADEMICO CMO ON (BC.CDTCA_CODIGO=CMO.CDTCA_CODIGO)
	LEFT JOIN SII.CGG_DHU_SADJUNTO SAD ON (SAD.CDBCR_CODIGO=BC.CDBCR_CODIGO)
	WHERE BC.CDBCR_ESTADO = TRUE AND 
		CDACD_CODIGO = IN_CDACD_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100
  ROWS 1000;