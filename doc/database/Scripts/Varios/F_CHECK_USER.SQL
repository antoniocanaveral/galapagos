/**
* FUNCION SII.F_CHECK_USER
* VERIFICA SI UN USUARIO ESTA REEMPLAZANDO A OTRO.
* @param IN_OWNER_CODE CODIGO DEL USUARIO SUSTITUIDO
* @param IN_USER_NAME NOMBRE DEL USUARIO SUSTITUTO
* @return <code>true</code> SI ES UN REEMPLAZO, <code>false</code> NO ES UN REEMPLAZO
*/
CREATE OR REPLACE FUNCTION SII.F_CHECK_USER_NAME(
IN IN_OWNER_CODE VARCHAR,
IN IN_USER_NAME VARCHAR
)RETURNS BOOLEAN AS
$$
DECLARE
TMP_CODIGO VARCHAR;
BEGIN
	SELECT CUSU_CODIGO INTO TMP_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME;
	RETURN (SELECT SII.F_CHECK_USER(IN_OWNER_CODE, TMP_CODIGO));
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION SII.F_CHECK_USER
* VERIFICA SI UN USUARIO ESTA REEMPLAZANDO A OTRO.
* @param IN_OWNER_CODE IDENTIFICATIVO DEL USUARIO SUSTITUIDO
* @param IN_GUEST_CODE IDENTIFICATIVO DEL USUARIO SUSTITUTO
* @return <code>true</code> SI ES UN REEMPLAZO, <code>false</code> NO ES UN REEMPLAZO
*/
CREATE OR REPLACE FUNCTION SII.F_CHECK_USER(
IN IN_OWNER_CODE VARCHAR,
IN IN_GUEST_CODE VARCHAR
)RETURNS BOOLEAN AS
$$
DECLARE
TMP_SUSTITUIDO BOOLEAN;
BEGIN
	TMP_SUSTITUIDO := FALSE;
	
	IF (IN_OWNER_CODE = IN_GUEST_CODE) THEN
		RETURN TRUE;
	END IF;
	
	SELECT TRUE INTO TMP_SUSTITUIDO 
	FROM SII.CGG_SUSTITUCION 
	WHERE CSUST_ESTADO AND 
		CUSU_CODIGO = IN_OWNER_CODE AND 
		CGG_CUSU_CODIGO = IN_GUEST_CODE AND 
		CSUST_ESTADO_ENCARGO AND
		((CSUST_MODALIDAD = 0 AND DATE(CURRENT_DATE) BETWEEN DATE(CSUST_FECHA_INICIO) AND DATE(CSUST_FECHA_FIN)) OR
			(CSUST_MODALIDAD = 1 AND DATE(CURRENT_DATE) >= DATE(CSUST_FECHA_INICIO))
		);
	
	IF (TMP_SUSTITUIDO IS NULL) THEN
		TMP_SUSTITUIDO := FALSE;
	END IF;
	
	RETURN TMP_SUSTITUIDO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;