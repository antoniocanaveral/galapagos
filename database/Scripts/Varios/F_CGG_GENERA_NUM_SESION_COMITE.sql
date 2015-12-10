/**
* FUNCION SII.F_CGG_GENERA_NUM_SESION_COMITE
* GENERA LOS NUMEROS DE SESIONES DE LOS COMITES.
* @param IN_CISLA_CODIGO CODIGO DE LA ISLA DONDE SE REALIZA LA SESION
* @return NUMERO DE SESION
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GENERA_NUM_SESION_COMITE(
IN IN_CISLA_CODIGO VARCHAR
)RETURNS CHARACTER VARYING AS
$BODY$
DECLARE
	TMP_SECUENCIA CHARACTER VARYING;
	TMP_ANIO CHARACTER VARYING;
	TMP_ACRONIMO CHARACTER VARYING;	
	TMP_ABR VARCHAR;
BEGIN
	SELECT CISLA_ABREVIATURA INTO TMP_ABR FROM SII.CGG_ISLA WHERE CISLA_CODIGO = IN_CISLA_CODIGO;
	SELECT COUNT(CRSSC_NUMERO_SESION )+1 INTO TMP_SECUENCIA  
	FROM SII.CGG_RES_SESION_COMITE
	WHERE EXTRACT(YEAR FROM CRSSC_FECHA_INSERT) = EXTRACT(YEAR FROM CURRENT_TIMESTAMP);
	SELECT CGCNF_VALOR_CADENA INTO TMP_ACRONIMO
	FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = 'CONF11';
	SELECT EXTRACT(YEAR FROM CURRENT_TIMESTAMP) INTO TMP_ANIO;	
	RETURN  TMP_ACRONIMO||'-'||TMP_ABR||'-'||TMP_ANIO||'-'||LPAD(TMP_SECUENCIA,4,'0');
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;

