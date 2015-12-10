
/**FUNCTION: F_CGG_RES_PERSONA_FUNCIONARIO_COUNT
* CONTABILIZA N REGISTROS DE LA TABLA SII.CGG_RES_PERSONA QUE CUMPLE CON EL CRITERIO DE BUSQUEDA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return TMP_ROWS
*/

CREATE OR REPLACE FUNCTION F_CGG_RES_PERSONA_FUNCIONARIO_COUNT(IN_FIND_TEXT TEXT)
  RETURNS INTEGER AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_PERSONA PER INNER JOIN SII.CGG_USUARIO U ON(PER.CRPER_CODIGO=U.CRPER_CODIGO)
        WHERE PER.CRPER_ESTADO = TRUE AND U.CUSU_ESTADO = TRUE  AND SII.F_STRING_IN(IN_FIND_TEXT,
	CASE WHEN PER.CRPER_CODIGO IS NULL THEN '''' ELSE PER.CRPER_CODIGO END ||' '||
	CASE WHEN PER.CRECV_CODIGO IS NULL THEN '''' ELSE PER.CRECV_CODIGO END ||' '||
	CASE WHEN PER.CRDID_CODIGO IS NULL THEN '''' ELSE PER.CRDID_CODIGO END ||' '||
	CASE WHEN PER.CRTSG_CODIGO IS NULL THEN '''' ELSE PER.CRTSG_CODIGO END ||' '||
	CASE WHEN PER.CGNCN_CODIGO IS NULL THEN '''' ELSE PER.CGNCN_CODIGO END ||' '||
	CASE WHEN PER.CPRR_CODIGO IS NULL THEN '''' ELSE PER.CPRR_CODIGO END ||' '||
	CASE WHEN PER.CCTN_CODIGO IS NULL THEN '''' ELSE PER.CCTN_CODIGO END ||' '||
	CASE WHEN PER.CGG_CCTN_CODIGO IS NULL THEN '''' ELSE PER.CGG_CCTN_CODIGO END ||' '||
	CASE WHEN PER.CRPER_NOMBRES IS NULL THEN '''' ELSE PER.CRPER_NOMBRES END ||' '||
	CASE WHEN PER.CRPER_APELLIDO_PATERNO IS NULL THEN '''' ELSE PER.CRPER_APELLIDO_PATERNO END ||' '||
	CASE WHEN PER.CRPER_APELLIDO_MATERNO IS NULL THEN '''' ELSE PER.CRPER_APELLIDO_MATERNO END ||' '||
	CASE WHEN PER.CRPER_NUM_DOC_IDENTIFIC IS NULL THEN '''' ELSE PER.CRPER_NUM_DOC_IDENTIFIC END ||' '||
	CASE WHEN PER.CRPER_FECHA_NACIMIENTO IS NULL THEN CURRENT_TIMESTAMP ELSE PER.CRPER_FECHA_NACIMIENTO END ||' '||
	CASE WHEN PER.CRPER_LUGAR_NACIMIENTO IS NULL THEN '''' ELSE PER.CRPER_LUGAR_NACIMIENTO END ||' '||
	CASE WHEN PER.CRPER_GENERO IS NULL THEN 0 ELSE PER.CRPER_GENERO END ||' '||
	CASE WHEN PER.CRPER_NUMERO_RESIDENCIA IS NULL THEN '''' ELSE PER.CRPER_NUMERO_RESIDENCIA END ||' '||
	CASE WHEN PER.CRPER_TIPO_PERSONA IS NULL THEN 0 ELSE PER.CRPER_TIPO_PERSONA END ||' '||
	CASE WHEN PER.CRPER_TIPO IS NULL THEN 0 ELSE PER.CRPER_TIPO END ||' '||
	CASE WHEN PER.CRPER_ESTADO IS NULL THEN FALSE ELSE PER.CRPER_ESTADO END ||' '||CASE WHEN PER.CRPER_FECHA_INSERT IS NULL THEN CURRENT_TIMESTAMP ELSE PER.CRPER_FECHA_INSERT END ||' '||
	CASE WHEN PER.CRPER_USUARIO_INSERT IS NULL THEN '''' ELSE PER.CRPER_USUARIO_INSERT END ||' '||
	CASE WHEN PER.CRPER_FECHA_UPDATE IS NULL THEN CURRENT_TIMESTAMP ELSE PER.CRPER_FECHA_UPDATE END ||' '||
	CASE WHEN PER.CRPER_USUARIO_UPDATE IS NULL THEN '''' ELSE PER.CRPER_USUARIO_UPDATE END ) = 1;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;
ALTER FUNCTION F_CGG_RES_PERSONA_FUNCIONARIO_COUNT(TEXT) OWNER TO SII;
