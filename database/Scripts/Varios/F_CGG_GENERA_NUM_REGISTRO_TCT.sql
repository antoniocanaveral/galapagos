/**
* FUNCION SII.F_CGG_GENERA_NUM_REGISTRO_TCT
* GENERA LOS NUMEROS DE REGISTRO DE TCT.
* @return TMP_SECUENCIA
*/
CREATE OR REPLACE FUNCTION F_CGG_GENERA_NUM_REGISTRO_TCT()
  RETURNS CHARACTER VARYING AS
$BODY$
DECLARE
	TMP_SECUENCIA CHARACTER VARYING;	
BEGIN
	SELECT max(CTREG_NUMERO )+1 INTO TMP_SECUENCIA  
	FROM SII.CGG_TCT_REGISTRO;	
	RETURN  COALESCE(LPAD(TMP_SECUENCIA,8,'0'), '00000001');	
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;

/**
* FUNCION SII.F_CGG_GENERA_NUM_GRUPO_TURISTA
* GENERA LOS NUMEROS DEL GRUPO DE TURISTAS DE TCT.
* @return TMP_SECUENCIA
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_GENERA_NUM_GRUPO_TURISTA()
RETURNS CHARACTER VARYING AS
$BODY$
DECLARE
	TMP_SECUENCIA CHARACTER VARYING;	
BEGIN
	SELECT MAX(CTGTR_NUMERO)+1 INTO TMP_SECUENCIA  
	FROM SII.CGG_TCT_GRUPO_TURISTA;	
	IF (TMP_SECUENCIA IS NULL) THEN
		TMP_SECUENCIA := '0';
	END IF;
	RETURN LPAD(TMP_SECUENCIA,7,'0');
END
$BODY$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;