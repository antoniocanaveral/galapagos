/**
* FUNCION F_CGG_RES_PERSONA_NOTIFICADO_INGRESO
* CONTROL DE NOTIFICACIONES DE UNA PERSONA Y SI ESTA HABILITADO PARA SU INGRESO
* @param IN_CRPER_NUM_DOC_IDENTIFIC CRITERIO DE BUSQUEDA.
* @param  IN_CUSU_NOMBRE_USUARIO NOMBRE DE USUARIO INTERNO.
* @param  IN_CARPT_CODIGO IDENTIFICATIVO UNICO DE AEREOPUERTO
* @param  INOPERADOR IDENTIFICADOR DE OPERADOR
* @param  INVALORCOMPARACION. VALOR DE COMPARACION
* @RETURN TMP_NOTIFICADO
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_PERSONA_NOTIFICADO_INGRESO(
IN IN_CRPER_NUM_DOC_IDENTIFIC CHARACTER VARYING, 
IN IN_CUSU_NOMBRE_USUARIO CHARACTER VARYING,
IN IN_CARPT_CODIGO CHARACTER VARYING, 
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
) RETURNS CHARACTER VARYING AS
$$
DECLARE
VALOR_DIAS INTEGER;
VALOR_FECHA DATE ;
TMP_NUMERO VARCHAR;
TMP_FECHA_EXPULSION DATE;
TMP_NOTIFICADO VARCHAR;
TMP_FECHA_INGRESO DATE;
TMP_RESULTADO VARCHAR;
OUT_KEY VARCHAR;
TMP_FECHA_SALIDA DATE;
TMP_TIPO_USUARIO boolean;
VALOR_FECHA_INGRESO DATE;
TMP_CODIGO VARCHAR;
TMP_GEN_CODIGO VARCHAR;
BEGIN
	--EXTRAE EL VALOR DE LA CONFIGURACION DE LOS DIAS
	SELECT CGCNF_VALOR_NUMERICO INTO VALOR_DIAS
	FROM CGG_CONFIGURACION 
	WHERE CGCNF_CODIGO='CONF16';
	SELECT CRNOT_FECHA_SALIDA_VOLUNT, 
		CRNOT_FECHA_EXPULSION,
		PER.CRPER_CODIGO, 
		(CASE 
		WHEN CRNOT_FECHA_EXPULSION IS NOT NULL THEN
		CRNOT_FECHA_EXPULSION
		ELSE
		CURRENT_DATE
		END) INTO TMP_FECHA_SALIDA,
		TMP_FECHA_EXPULSION,
		TMP_CODIGO,VALOR_FECHA
	FROM SII.CGG_RES_NOTIFICACION NTF 
	INNER JOIN SII.CGG_RES_PERSONA PER ON PER.CRPER_CODIGO = NTF.CRPER_CODIGO
	WHERE (NTF.CRNOT_ESTADO_NOTIFICACION=3 OR NTF.CRNOT_ESTADO_NOTIFICACION=1) AND
	NTF.CRNOT_REGULARIZACION = '0' AND
	CRNOT_ESTADO AND
	PER.CRPER_NUM_DOC_IDENTIFIC=IN_CRPER_NUM_DOC_IDENTIFIC
	ORDER BY CRNOT_FECHA_NOTIFICACION DESC;
	--GROUP BY NTF.CRTNT_CODIGO,NTF.CRNOT_FECHA_SALIDA_VOLUNT,NTF.CRNOT_FECHA_EXPULSION,PER.CRPER_CODIGO ;
	VALOR_FECHA_INGRESO = VALOR_FECHA + VALOR_DIAS;
	SELECT SII.F_CGG_REGLA_VALIDACION(COALESCE(VALOR_FECHA_INGRESO,CURRENT_DATE-1)::VARCHAR,INOPERADOR,CURRENT_DATE::VARCHAR) INTO TMP_NOTIFICADO;
	SELECT CUSU_USUARIO_INTERNO INTO TMP_TIPO_USUARIO FROM SII.CGG_USUARIO U WHERE U.CUSU_ESTADO = TRUE 
		AND U.CUSU_NOMBRE_USUARIO=IN_CUSU_NOMBRE_USUARIO;
	IF(TMP_TIPO_USUARIO=true)THEN
		IF(TMP_NOTIFICADO='false')THEN
			SELECT SII.F_CGG_TCT_INGRESO_FALLIDO_INSERT(
				'KEYGEN'::VARCHAR,
				TMP_CODIGO,
				IN_CARPT_CODIGO,
				CURRENT_TIMESTAMP,
				0::SMALLINT,
				'Notificado'::VARCHAR,
				TRUE,
				IN_CUSU_NOMBRE_USUARIO,
				IN_CUSU_NOMBRE_USUARIO
			) INTO TMP_GEN_CODIGO;
		END IF;
	END IF;
	RETURN TMP_NOTIFICADO;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
* OBTIENE EL TIPO DE OPERACION DEL ULTIMO DESPLAZAMIENTO DE LA PERSONA.
* @param IN_CRPER_CODIGO CODIGO DE LA PERSONA QUE SE DESEA CONSULTAR
* @param IN_OPERADOR OPERADOR DE COMPARACION
* @param IN_VALOR_COMPARACION DATO DE CONVALIDACION
* @returns VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_PERSONA_EN_LA_PROVINCIA(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_OPERADOR VARCHAR, 
IN IN_VALOR_COMPARACION VARCHAR
)RETURNS VARCHAR AS
$$
DECLARE
TMP_OPERACION INT;
OUT_RESULTADO VARCHAR;
BEGIN
	SELECT CRMOV_TIPO_OPERACION INTO TMP_OPERACION
	FROM SII.CGG_RES_PERSONA PRS
	INNER JOIN SII.CGG_RES_MOVILIDAD MVD ON MVD.CRPER_CODIGO = PRS.CRPER_CODIGO AND MVD.CRMOV_ESTADO
	WHERE PRS.CRPER_ESTADO AND
		PRS.CRPER_CODIGO = IN_CRPER_CODIGO
	ORDER BY CRMOV_FECHA_VIAJE DESC, CRMOV_TIPO_OPERACION DESC LIMIT 1;
	IF (TMP_OPERACION IS NULL) THEN
		TMP_OPERACION = 1;
	END IF;
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_OPERACION::VARCHAR,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
	RETURN OUT_RESULTADO;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
* CALCULA EL TIEMPO DE ESTADIA DE UNA PERSONA DENTRO DE LA PROVINCIA COMO TURISTA Y TRANSEUNTE.
* @param IN_CRPER_CODIGO CODIGO DE LA PERSONA QUE SE DESEA CONSULTAR
* @param IN_OPERADOR OPERADOR DE COMPARACION
* @param IN_VALOR_COMPARACION DATO DE CONVALIDACION
* @returns VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_PERSONA_TIEMPO_ESTADIA(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_OPERADOR VARCHAR, 
IN IN_VALOR_COMPARACION VARCHAR
)RETURNS VARCHAR AS
$$
DECLARE
TMP_ESTADIA INT;
OUT_RESULTADO VARCHAR;
BEGIN
	
	SELECT SII.F_CALCULO_DIAS_ESTADIA(CURRENT_TIMESTAMP, IN_CRPER_CODIGO) INTO TMP_ESTADIA;
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_ESTADIA::VARCHAR,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
	
	IF (TMP_ESTADIA IS NULL) THEN
		TMP_ESTADIA = 0;
	END IF;
	
	RETURN OUT_RESULTADO||', La persona tiene '||TMP_ESTADIA::VARCHAR||' d&iacute;as dentro de la provincia.';
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
* VERIFICA QUE UNA GARANTIA ESTE VIGENTE Y RECEPTADA.
* @param IN_CRDPT_CODIGO CODIGO DEL DEPOSITO DE GARANTIA
* @param IN_OPERADOR OPERADOR DE COMPARACION
* @param IN_VALOR_COMPARACION DATO DE CONVALIDACION
* @returns VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_GARANTIA_VIGENTE(
IN IN_CRDPT_CODIGO VARCHAR,
IN IN_OPERADOR VARCHAR, 
IN IN_VALOR_COMPARACION VARCHAR
)RETURNS VARCHAR AS
$$
DECLARE
TMP_COUNT INT;
OUT_RESULTADO VARCHAR;
TMP_VAR VARCHAR;
BEGIN
	
	IF (IN_CRDPT_CODIGO != 'CRDPT_AT001') THEN
		SELECT COUNT(CRDPT_CODIGO) INTO TMP_COUNT 
		FROM SII.CGG_RES_DEPOSITO_GARANTIA CRDPT
		WHERE CRDPT_ESTADO_DEPOSITO IN (0,1) AND 
			CRDPT_ESTADO AND 
			CASE WHEN CRDPT_CADUCA THEN CURRENT_DATE < CRDPT_FECHA_CADUCIDAD::DATE ELSE NOT CRDPT_CADUCA END AND
			CRDPT_CODIGO = IN_CRDPT_CODIGO;
		
		IF (TMP_COUNT > 0) THEN 
			TMP_VAR = 'TRUE';
		ELSE
			TMP_VAR = 'FALSE';
		END IF;
		
		SELECT SII.F_CGG_REGLA_VALIDACION( TMP_VAR ,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
		
		RETURN OUT_RESULTADO;
	ELSE
		RETURN TRUE::VARCHAR;
	END IF;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
* FUNCION F_CGG_RES_PERSONA_AUTORIZADO_INGRESO_TURISTA_TRANSEUNTE
* CONTROL DE DIAS DE ESTADIA DE UNA PERSONA Y SI ESTA HABILITADO PARA SU INGRESO
* @param IN_CRPER_NUM_DOC_IDENTIFIC CRITERIO DE BUSQUEDA.
* @param IN_CUSU_NOMBRE_USUARIO NOMBRE DE USUARIO INTERNO.
* @param IN_CARPT_CODIGO IDENTIFICATIVO UNICO DE AEREOPUERTO
* @param INOPERADOR IDENTIFICADOR DE OPERADOR
* @param INVALORCOMPARACION VALOR DE COMPARACION
* @return TMP_NUMERO_DIAS
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_PERSONA_AUTORIZADO_INGRESO_TURISTA_TRANSEUNTE(
IN IN_CRPER_NUM_DOC_IDENTIFIC CHARACTER VARYING, 
IN IN_CUSU_NOMBRE_USUARIO CHARACTER VARYING, 
IN IN_CARPT_CODIGO CHARACTER VARYING, 
IN IN_FECHA_INGRESO TIMESTAMP WITH TIME ZONE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_VALOR_DIAS_TRANSCURRIDO INTEGER;
	TMP_RECORD RECORD;
	TMP_CRTST_CODIGO VARCHAR;
	TMP_NUMERO_DIAS VARCHAR;
    OUT_KEY VARCHAR;
    TMP_TIPO_USUARIO boolean;
    TMP_CODIGO VARCHAR;
	TMP_GEN_CODIGO VARCHAR;
	TMP_PERMANENTE VARCHAR;
	TMP_TEMPORAL VARCHAR;
BEGIN   
	TMP_VALOR_DIAS_TRANSCURRIDO:=0;
	TMP_NUMERO_DIAS:='true';
	SELECT CGCNF_VALOR_CADENA INTO TMP_PERMANENTE FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO='03';
	SELECT CGCNF_VALOR_CADENA INTO TMP_TEMPORAL FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO='04';
	SELECT CRPER_CODIGO INTO TMP_CODIGO FROM SII.CGG_RES_PERSONA WHERE CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC;
	
	SELECT CRTST_CODIGO INTO TMP_CRTST_CODIGO 
	FROM SII.CGG_RES_RESIDENCIA
	WHERE CRPER_CODIGO = TMP_CODIGO AND 
		CRRSD_FECHA_INICIO::DATE = IN_FECHA_INGRESO AND
		CRRSD_VIGENTE AND
		CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO);
		
	IF (TMP_CRTST_CODIGO IS NULL) THEN
		SELECT SII.F_CALCULO_DIAS_ESTADIA(IN_FECHA_INGRESO, TMP_CODIGO) INTO TMP_VALOR_DIAS_TRANSCURRIDO;
	END IF;
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_VALOR_DIAS_TRANSCURRIDO::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO TMP_NUMERO_DIAS;

	SELECT CUSU_USUARIO_INTERNO INTO TMP_TIPO_USUARIO 
	FROM SII.CGG_USUARIO U 
	WHERE U.CUSU_ESTADO AND 
		U.CUSU_NOMBRE_USUARIO = IN_CUSU_NOMBRE_USUARIO;
		
	IF(TMP_TIPO_USUARIO)THEN
		IF(TMP_NUMERO_DIAS='false')THEN
			SELECT SII.F_CGG_TCT_INGRESO_FALLIDO_INSERT(
				'KEYGEN'::VARCHAR,
				TMP_CODIGO,
				IN_CARPT_CODIGO,
				CURRENT_TIMESTAMP,
				1::SMALLINT,
				'Ha excedido los dias autorizados.'::VARCHAR,
				TRUE,
				IN_CUSU_NOMBRE_USUARIO,
				IN_CUSU_NOMBRE_USUARIO
			) INTO TMP_GEN_CODIGO;
		END IF;
	END IF;
	RETURN TMP_NUMERO_DIAS;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
* FUNCION SII.F_CALCULO_DIAS_ESTADIA
* CALCULA LOS DIAS DE ESTADIA DE UNA PERSONA DENTRO DE LA PROVINCIA COMO TURISTA O TRANSEUNTE
* @param IN_FECHA_INGRESO FECHA DE INGRESO
* @param IN_CRPER_CODIGO CODIGO DE LA PERSONA
* returns INT DIAS DE ESTADIA DENTRO DE LA PROVINCIA
*/
CREATE OR REPLACE FUNCTION SII.F_CALCULO_DIAS_ESTADIA(
IN IN_FECHA_INGRESO TIMESTAMP WITH TIME ZONE,
IN IN_CRPER_CODIGO VARCHAR
)RETURNS INT AS
$$
DECLARE
TMP_RECORD RECORD;
TMP_VALOR_DIAS_TRANSCURRIDO INT;
TMP_CRTST_CODIGO VARCHAR;
TMP_FECHA_ACTUAL_INGRESO DATE;
TMP_SW BOOLEAN;
TMP_FECHA_OLD DATE;
BEGIN
	TMP_FECHA_ACTUAL_INGRESO = IN_FECHA_INGRESO::DATE - 365;	
	TMP_VALOR_DIAS_TRANSCURRIDO := 0;
	TMP_SW = FALSE;
	FOR TMP_RECORD IN (SELECT
		PER.CRPER_CODIGO,
		MOV.CRMOV_FECHA_VIAJE,
		MOV.CRMOV_TIPO_OPERACION,
		MOV.CRRSD_CODIGO
		FROM SII.CGG_RES_PERSONA PER 
		INNER JOIN SII.CGG_RES_MOVILIDAD MOV ON MOV.CRPER_CODIGO = PER.CRPER_CODIGO
		WHERE MOV.CRMOV_FECHA_VIAJE::DATE >= TMP_FECHA_ACTUAL_INGRESO AND
				PER.CRPER_CODIGO = IN_CRPER_CODIGO AND MOV.CRMOV_ESTADO
		ORDER BY MOV.CRMOV_FECHA_VIAJE, MOV.CRMOV_TIPO_OPERACION ASC)
	LOOP
		SELECT CRTST_CODIGO INTO TMP_CRTST_CODIGO 
		FROM SII.CGG_RES_RESIDENCIA
		WHERE CRPER_CODIGO = TMP_RECORD.CRPER_CODIGO AND 
			CRRSD_CODIGO = TMP_RECORD.CRRSD_CODIGO AND 
			CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
				SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
				FROM CGG_CONFIGURACION
				WHERE CGCNF_CODIGO = '05') OR CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
				FROM CGG_CONFIGURACION
				WHERE CGCNF_CODIGO = '06')) 
				UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
				WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
			) SELECT CRTST_CODIGO  FROM TIPO);
		IF (TMP_CRTST_CODIGO IS NOT NULL) THEN
			TMP_SW = (TMP_RECORD.CRMOV_TIPO_OPERACION = 0);
			IF (TMP_FECHA_OLD IS NOT NULL AND TMP_RECORD.CRMOV_TIPO_OPERACION = 1 ) THEN
				TMP_VALOR_DIAS_TRANSCURRIDO := TMP_VALOR_DIAS_TRANSCURRIDO + (TMP_RECORD.CRMOV_FECHA_VIAJE::DATE - TMP_FECHA_OLD) + 1;
			END IF;
			
			IF (TMP_RECORD.CRMOV_TIPO_OPERACION = 1 AND TMP_FECHA_OLD IS NULL) THEN
				SELECT CRMOV_FECHA_VIAJE INTO TMP_FECHA_OLD FROM SII.CGG_RES_MOVILIDAD 
				WHERE CRPER_CODIGO = TMP_RECORD.CRPER_CODIGO AND CRMOV_FECHA_VIAJE < TMP_RECORD.CRMOV_FECHA_VIAJE
				ORDER BY CRMOV_FECHA_VIAJE DESC LIMIT 1;
				TMP_VALOR_DIAS_TRANSCURRIDO := (TMP_RECORD.CRMOV_FECHA_VIAJE::DATE - TMP_FECHA_OLD) + 1;
			ELSE 
				TMP_FECHA_OLD = TMP_RECORD.CRMOV_FECHA_VIAJE::DATE;
			END IF;
		END IF;
	END LOOP;
	IF (TMP_CRTST_CODIGO IS NOT NULL AND TMP_SW) THEN
		TMP_VALOR_DIAS_TRANSCURRIDO := TMP_VALOR_DIAS_TRANSCURRIDO + (CURRENT_DATE - TMP_FECHA_OLD)+1;
	END IF;
	RETURN TMP_VALOR_DIAS_TRANSCURRIDO;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE;

/**
* FUNCION SII.F_RESIDENTE_PERMANENTE
* VERIFICA SI LA PERSONA ES RESIDENTE PERMANENTE
* @param IN_CRPER_CODIGO CODIGO DE REGISTRO DE PERSONA
* @param IN_OPERADOR OPERADOR UTILIZADO PARA EVALUAR EL RESULTADO
* @param IN_VALOR_COMPARACION VALOR DE VALIDACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_RESIDENTE_PERMANENTE(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_OPERADOR CHARACTER VARYING,
IN IN_VALOR_COMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_CODIGO VARCHAR;
	TMP_RESULTADO VARCHAR;
BEGIN	

	SELECT PRS.CRPER_CODIGO INTO TMP_CODIGO 
	FROM SII.CGG_RES_PERSONA PRS
	INNER JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = PRS.CRPER_CODIGO AND RSD.CRRSD_MODALIDAD = 0 AND RSD.CRRSD_VIGENTE
	WHERE PRS.CRPER_CODIGO = IN_CRPER_CODIGO;
	
	SELECT SII.F_CGG_REGLA_VALIDACION((CASE WHEN TMP_CODIGO IS NOT NULL THEN 'TRUE' ELSE 'FALSE' END), IN_OPERADOR, IN_VALOR_COMPARACION) INTO TMP_RESULTADO;
	RETURN TMP_RESULTADO;	
END
$$
LANGUAGE 'PLPGSQL' VOLATILE;

/**
* FUNCION SII.F_RESIDENTE_TEMPORAL
* VERIFICA SI LA PERSONA ES RESIDENTE TEMPORAL
* @param IN_CRPER_CODIGO CODIGO DE REGISTRO DE PERSONA
* @param IN_OPERADOR OPERADOR UTILIZADO PARA EVALUAR EL RESULTADO
* @param IN_VALOR_COMPARACION VALOR DE VALIDACION
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_RESIDENTE_TEMPORAL(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_OPERADOR CHARACTER VARYING,
IN IN_VALOR_COMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_CODIGO VARCHAR;
	TMP_RESULTADO VARCHAR;
BEGIN	
	SELECT PRS.CRPER_CODIGO INTO TMP_CODIGO 
	FROM SII.CGG_RES_PERSONA PRS
	INNER JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = PRS.CRPER_CODIGO AND RSD.CRRSD_MODALIDAD = 1 AND RSD.CRRSD_VIGENTE
	WHERE PRS.CRPER_CODIGO = IN_CRPER_CODIGO AND RSD.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
		SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE  CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
		FROM CGG_CONFIGURACION
		WHERE CGCNF_CODIGO = '04')
		UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
		WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
	) SELECT CRTST_CODIGO  FROM TIPO);	
	
	SELECT SII.F_CGG_REGLA_VALIDACION((CASE WHEN TMP_CODIGO IS NOT NULL THEN 'TRUE' ELSE 'FALSE' END), IN_OPERADOR, IN_VALOR_COMPARACION) INTO TMP_RESULTADO;
	RETURN TMP_RESULTADO;	
END
$$
LANGUAGE 'PLPGSQL' VOLATILE;

/**
* FUNCION SII.F_RESIDENTE_PERMANENTE_TEMPORAL
* VERIFICA SI LA PERSONA ES RESIDENTE TEMPORAL O PERMANENTE
* @param IN_CRPER_CODIGO CODIGO DE REGISTRO DE PERSONA
* @param IN_OPERADOR OPERADOR UTILIZADO PARA EVALUAR EL RESULTADO
* @param IN_VALOR_COMPARACION VALOR DE VALIDACION
* @return TMP_RESULTADO DEVUELVE TRUE SI ES RESIDENTE PERMANENTE O TEMPORAL
*/
CREATE OR REPLACE FUNCTION SII.F_RESIDENTE_PERMANENTE_TEMPORAL(
IN IN_CRPER_CODIGO VARCHAR,
IN IN_OPERADOR CHARACTER VARYING,
IN IN_VALOR_COMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_CODIGO VARCHAR;
	TMP_RESULTADO VARCHAR;
BEGIN	
	SELECT SII.F_RESIDENTE_PERMANENTE(IN_CRPER_CODIGO,IN_OPERADOR,IN_VALOR_COMPARACION) INTO TMP_RESULTADO;
	IF UPPER(TMP_RESULTADO) = 'TRUE' THEN
		RETURN TMP_RESULTADO;
	ELSE
		SELECT SII.F_RESIDENTE_TEMPORAL(IN_CRPER_CODIGO,IN_OPERADOR,IN_VALOR_COMPARACION) INTO TMP_RESULTADO;
		RETURN TMP_RESULTADO;
	END IF;	
END
$$
LANGUAGE 'PLPGSQL' VOLATILE;
