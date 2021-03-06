/** FUNCION F_CGG_GENERA_NUM_APELACION_RESOLUCION
* GENERA EL NUMERO DE APELACION DE LA RESOLUCION.
* @return CHARACTER VARYING
*/

CREATE OR REPLACE FUNCTION F_CGG_GENERA_NUM_APELACION_RESOLUCION()
  RETURNS CHARACTER VARYING AS
$BODY$
DECLARE
	TMP_SECUENCIA CHARACTER VARYING;
	TMP_ANIO CHARACTER VARYING;
	TMP_ACRONIMO CHARACTER VARYING;	
BEGIN
	SELECT COUNT(CRRES_NUMERO_APELACION )+1 INTO TMP_SECUENCIA  
	FROM SII.CGG_RES_RESOLUCION
	WHERE EXTRACT(YEAR FROM CRRES_FECHA_INSERT) = EXTRACT(YEAR FROM CURRENT_TIMESTAMP);
	
	SELECT CGCNF_VALOR_CADENA INTO TMP_ACRONIMO
	FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = 'CONF9';
	
	SELECT EXTRACT(YEAR FROM CURRENT_TIMESTAMP) INTO TMP_ANIO;
	
	RETURN  TMP_ACRONIMO||'-'||TMP_ANIO||'-'||LPAD(TMP_SECUENCIA,4,'0');
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;

