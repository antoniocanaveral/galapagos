/**
*FUNCION. REGLA DE VALIDACION QUE VALIDA EL NUMERO DE TRAMITES PERMANENTES PENDIENTES QUE TIENE EN CURSO UN RESIDENTE.
*LA FUNCION INTERNAMENTE VALIDA Y COMPRUEBA EL VALOR E INDICA SI LA REGLA SE HA CUMPLIDO O NO.
*@param IN_CRPER_CODIGO CODIGO DE PERSONA.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@param OUT_RESULTADO
*/
CREATE OR REPLACE FUNCTION SII.F_NUMERO_TRAMITE_PERMANENTE(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS VARCHAR AS
$$
DECLARE
	CRETTCODIGO VARCHAR(20);
	TMP_CONTADOR NUMERIC;
	CRTSTCODIGO VARCHAR;
	OUT_RESULTADO VARCHAR;
BEGIN
	
	
	SELECT COALESCE(COUNT(CRTRA_CODIGO),0) INTO TMP_CONTADOR 
	FROM SII.CGG_RES_TRAMITE 
	WHERE CRETT_CODIGO NOT IN ( SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO IN ('20','03','19','22') )
	AND SII.F_TIPO_SOLICITUD_PADRE(CRTST_CODIGO) = CRTSTCODIGO
	AND CGG_CRPER_CODIGO = IN_CRPER_CODIGO;	
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_CONTADOR::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
	
	RETURN OUT_RESULTADO;
	
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
*FUNCION. REGLA DE VALIDACION QUE VALIDA EL NUMERO DE TRAMITES TEMPORALES PENDIENTES QUE TIENE EN CURSO UN RESIDENTE TEMPORAL.
*LA FUNCION INTERNAMENTE VALIDA Y COMPRUEBA EL VALOR E INDICA SI LA REGLA SE HA CUMPLIDO O NO.
*@param IN_CRPER_CODIGO CODIGO DE PERSONA.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_NUMERO_TRAMITE_TEMPORAL(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS VARCHAR AS
$$
DECLARE
	CRETTCODIGO VARCHAR(20);
	TMP_CONTADOR NUMERIC;
	CRTSTCODIGO VARCHAR;
	OUT_RESULTADO VARCHAR;
BEGIN
	SELECT COALESCE(COUNT(CRTRA_CODIGO),0) INTO TMP_CONTADOR 
	FROM SII.CGG_RES_TRAMITE 
	WHERE CRETT_CODIGO NOT IN ( SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO IN ('20','04','19','22') )
	AND SII.F_TIPO_SOLICITUD_PADRE(CRTST_CODIGO) = CRTSTCODIGO
	AND CRPER_CODIGO = IN_CRPER_CODIGO;	
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_CONTADOR::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
	
	RETURN OUT_RESULTADO;
	
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
*FUNCION. REGLA DE VALIDACION QUE VALIDA SI UN RESIDENTE PERMANENTE O TEMPORAL ES OBSERVADO.
*LA FUNCION INTERNAMENTE VALIDA Y COMPRUEBA EL VALOR E INDICA SI LA REGLA SE HA CUMPLIDO O NO.
*@param IN_CRPER_CODIGO CODIGO DE PERSONA.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_RESIDENTE_OBSERVADO(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS VARCHAR AS
$$
DECLARE
	CRETTCODIGO VARCHAR(20);
	TMP_CONTADOR NUMERIC;
	CRTSTCODIGO VARCHAR;
	OUT_RESULTADO VARCHAR;
BEGIN	
	SELECT COALESCE(COUNT(CROBS_CODIGO),0) INTO TMP_CONTADOR FROM SII.CGG_RES_OBSERVADO 
	WHERE CRPER_CODIGO = IN_CRPER_CODIGO
	AND CROBS_RESUELTO = FALSE;		
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_CONTADOR::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
	RETURN OUT_RESULTADO;	
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
*FUNCION. VALIDA SI UNA PERSONA O BENEFICIARIO ESTA NOTIFICADO.
*@param IN_CRPER_NUM_DOC_IDENTIFIC NUMERO DE DOCUMENTO DE PERSONAL.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@return CHARACTER VARYING
*/
CREATE OR REPLACE FUNCTION SII.F_BENEFICIARIO_NOTIFICADO(
IN_CRPER_NUM_DOC_IDENTIFIC CHARACTER VARYING, 
INOPERADOR CHARACTER VARYING, 
INVALORCOMPARACION CHARACTER VARYING
) RETURNS CHARACTER VARYING AS
$BODY$
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
BEGIN	
	--EXTRAE EL VALOR DE LA CONFIGURACION DE LOS DIAS
	VALOR_FECHA := CURRENT_DATE;
	SELECT CGCNF_VALOR_NUMERICO INTO VALOR_DIAS FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO='CONF16';	
	
	SELECT CRNOT_FECHA_SALIDA_VOLUNT, 
		   CRNOT_FECHA_EXPULSION,
		   PER.CRPER_CODIGO, 
		  (CASE 
			WHEN CRNOT_FECHA_EXPULSION IS NOT NULL THEN
				CRNOT_FECHA_EXPULSION
			ELSE
				CURRENT_DATE			
			END) INTO TMP_FECHA_SALIDA,TMP_FECHA_EXPULSION,TMP_CODIGO,VALOR_FECHA
	FROM SII.CGG_RES_NOTIFICACION NTF 
	INNER JOIN SII.CGG_RES_PERSONA PER ON (PER.CRPER_CODIGO=NTF.CRPER_CODIGO) 
	WHERE (NTF.CRNOT_ESTADO_NOTIFICACION=3 OR NTF.CRNOT_ESTADO_NOTIFICACION=1)
	AND NTF.CRNOT_REGULARIZACION = '0' 
	AND NTF.CRNOT_ESTADO
	AND PER.CRPER_NUM_DOC_IDENTIFIC=IN_CRPER_NUM_DOC_IDENTIFIC
	ORDER BY CRNOT_FECHA_NOTIFICACION DESC;	
	
	VALOR_FECHA_INGRESO:=VALOR_FECHA+VALOR_DIAS;
	
	SELECT SII.F_CGG_REGLA_VALIDACION(COALESCE(VALOR_FECHA_INGRESO,CURRENT_DATE-1)::VARCHAR,INOPERADOR,CURRENT_DATE::VARCHAR) INTO TMP_NOTIFICADO;
	
	RETURN TMP_NOTIFICADO;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;
  
  /**
*FUNCION. REGLA DE VALIDACION QUE VERIFICA LOS ANIOS DE UNA FECHA DADA COMPARADO CON UN PARAMETRO DE CONFIGURACION SEAN MENOR O IGUAL A ESTE.
*LA FUNCION INTERNAMENTE VALIDA Y COMPRUEBA EL VALOR E INDICA SI LA REGLA SE HA CUMPLIDO O NO.
*@param IN_CRPER_FECHA_NACIMIENTO FECHA DE NACIMIENTO DE UNA PERSONA EN FORMATO dd/MM/yyyy.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_ANIOS_BENEFICIARIO(
IN IN_CRPER_FECHA_NACIMIENTO  CHARACTER VARYING,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS VARCHAR AS
$$
DECLARE	
	TMP_CONTADOR NUMERIC;
	EDAD_MAXIMA NUMERIC;	
	ANIOS NUMERIC;
	OUT_RESULTADO VARCHAR;
BEGIN	
		
	SELECT CGCNF_VALOR_NUMERICO INTO EDAD_MAXIMA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = 'CONF21';	
	IF (length(IN_CRPER_FECHA_NACIMIENTO) >0 ) THEN
		SELECT TRUNC(EXTRACT(DAY FROM (NOW() - DATE(IN_CRPER_FECHA_NACIMIENTO)))/365) INTO ANIOS;
	ELSE
		RETURN 'FALSE';
	END IF;
	SELECT SII.F_CGG_REGLA_VALIDACION(ANIOS::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
	RETURN OUT_RESULTADO;	
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
*FUNCION. REGLA DE VALIDACION QUE VALIDA SI EL BENEFICIARIO HA APLICADO ANTES A UNA RESIDENCIA TEMPORAL Y SE HALLA EN LA PROVINCIA.
*LA FUNCION INTERNAMENTE VALIDA Y COMPRUEBA EL VALOR E INDICA SI LA REGLA SE HA CUMPLIDO O NO.
*@param IN_CRPER_CODIGO CODIGO DE PERSONA.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_BENEFICIARIO_TEMPORAL_PROVINCIA(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS VARCHAR AS
$$
DECLARE
	TMP_RESIDENCIA BOOLEAN DEFAULT FALSE;
	TMP_ON_PROVINCE BOOLEAN DEFAULT FALSE;
	TMP_PERMITIDO_INGRESO BOOLEAN DEFAULT FALSE;
	OUT_RESULTADO VARCHAR;
BEGIN
	
	SELECT COALESCE(COUNT(*),0)<1  INTO TMP_RESIDENCIA  FROM CGG_RES_PERSONA P
	INNER JOIN CGG_RES_RESIDENCIA R ON (P.CRPER_CODIGO = R.CRPER_CODIGO)
	WHERE P.CRPER_CODIGO = IN_CRPER_CODIGO AND 
	(SELECT CGCNF_VALOR_CADENA   FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO = '04')=
		(WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT TS.CRTST_CODIGO, TS.CGG_CRTST_CODIGO, TS.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TS WHERE (TS.CRTST_CODIGO = R.CRTST_CODIGO)
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TP.CGG_CRTST_CODIGO = TST.CRTST_CODIGO) SELECT CRTST_CODIGO  FROM TIPO WHERE CGG_CRTST_CODIGO IS NULL );


	SELECT CRMOV_TIPO_OPERACION = 0 INTO  TMP_ON_PROVINCE FROM CGG_RES_MOVILIDAD
	WHERE CRPER_CODIGO = IN_CRPER_CODIGO
	AND CRMOV_FECHA_VIAJE = (SELECT MAX(CRMOV_FECHA_VIAJE) FROM CGG_RES_MOVILIDAD WHERE CRPER_CODIGO = IN_CRPER_CODIGO);

		IF (TMP_RESIDENCIA = TRUE AND (TMP_ON_PROVINCE = FALSE OR TMP_ON_PROVINCE IS NULL )) THEN
			TMP_PERMITIDO_INGRESO := TRUE;
		END IF;
			

	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_PERMITIDO_INGRESO::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
	
	RETURN OUT_RESULTADO;
	
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

/**
* FUNCION F_CGG_RES_PERSONA_AUTORIZADO_INGRESO_TURISTA_TRANSEUNTE
* CONTROL DE DIAS DE ESTADIA DE UNA PRSONA Y SI ESTA HABILITADO PARA SU INGRESO
* @param IN_CRPER_NUM_DOC_IDENTIFIC CRITERIO DE BUSQUEDA.
* @param INOPERADOR  OPERADOR DE COMPARACION
* @param INVALORCOMPARACION. VALOR DE COMPARACION
* @return  CHARACTER VARYING
*/
CREATE OR REPLACE FUNCTION F_CGG_RES_BENEFICIARIO_AUTORIZADO_INGRESO_TURISTA_TRANSEUNTE(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_VALOR_DIAS_TRANSCURRIDO INTEGER;
	TMP_NUMERO VARCHAR;
	VALOR_FECHA_SALIDA_MAX DATE;
	VALOR_DIAS_TOTAL INTEGER;
	TMP_FECHA RECORD;
	TMP_TRANSEUNTE VARCHAR;
	TMP_FECHA_PRIMER_INGRESO DATE;
	FECHA_ACTUAL RECORD;
	FECHA_ANTERIOR DATE;
	FECHA_ACTUAL_INGRESO DATE;
	FECHA_RESIDENCIA DATE;
	TMP_TURISTA VARCHAR;
	TMP_NUMERO_DIAS VARCHAR;
        OUT_KEY VARCHAR;
      	TMP_GEN_CODIGO VARCHAR;
BEGIN   
	VALOR_DIAS_TOTAL:=0;
	TMP_VALOR_DIAS_TRANSCURRIDO:=0;
        TMP_NUMERO_DIAS:='true';
	FECHA_ACTUAL_INGRESO = CURRENT_DATE - 365;
	FOR TMP_FECHA IN (SELECT
		MOV.CRMOV_FECHA_VIAJE, 
		MVD.CRMOV_FECHA_VIAJE, 
		PER.CRPER_CODIGO,
		(SELECT DATE(MVD.CRMOV_FECHA_VIAJE)-DATE(MOV.CRMOV_FECHA_VIAJE)) AS DIAS
		FROM SII.CGG_RES_MOVILIDAD MOV 
		LEFT JOIN SII.CGG_RES_MOVILIDAD MVD ON MOV.CRPER_CODIGO = MVD.CRPER_CODIGO
		INNER JOIN SII.CGG_RES_PERSONA PER ON MOV.CRPER_CODIGO = PER.CRPER_CODIGO
		WHERE MOV.CRMOV_TIPO_OPERACION = 0 AND 
			MVD.CRMOV_TIPO_OPERACION = 1 AND 
			MOV.CRMOV_ESTADO AND 
			PER.CRPER_CODIG = IN_CRPER_CODIGO AND 
			MVD.CRMOV_FECHA_VIAJE >= FECHA_ACTUAL_INGRESO AND 
			MOV.CRMOV_FECHA_VIAJE <= MVD.CRMOV_FECHA_VIAJE AND 
			MVD.CRMOV_FECHA_VIAJE = (SELECT MOV2.CRMOV_FECHA_VIAJE 
				FROM CGG_RES_MOVILIDAD MOV2 
				WHERE MOV2.CRMOV_FECHA_VIAJE >= MOV.CRMOV_FECHA_VIAJE AND 
				MOV2.CRPER_CODIGO = PER.CRPER_CODIGO AND 
				MOV2.CRMOV_TIPO_OPERACION = 1 
				ORDER BY MOV.CRMOV_FECHA_VIAJE ASC LIMIT 1)
		ORDER BY MOV.CRMOV_FECHA_VIAJE,MVD.CRMOV_FECHA_VIAJE,MOV.CRMOV_TIPO_OPERACION ASC)
	LOOP
		VALOR_DIAS_TOTAL := TMP_FECHA.DIAS;
		TMP_VALOR_DIAS_TRANSCURRIDO := TMP_VALOR_DIAS_TRANSCURRIDO + VALOR_DIAS_TOTAL;
	END LOOP;
	 
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_VALOR_DIAS_TRANSCURRIDO::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO TMP_NUMERO_DIAS;

	RETURN TMP_NUMERO_DIAS;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;


/**
* FUNCION F_CGG_RESIDENCIA_CONYUGE_VIGENTE
* VERIFICA QUE EL AUSPICIANTE NO HAYA GENERADO UN TRAMITE DE RESIDENCIA TEMPORAL Y ESTE SE HALLE VIGENTE PARA UN BENEFICIARIO DISTINTO 
* @param IN_CRPER_NUM_DOC_IDENTIFIC CRITERIO DE BUSQUEDA.
* @param IN_CRTST_CODIGO  CRITERIO DE BUSQUEDA.
* @param INOPERADOR  OPERADOR DE COMPARACION
* @param INVALORCOMPARACION. VALOR DE COMPARACION
* @return  CHARACTER VARYING 
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RESIDENCIA_CONYUGE_VIGENTE(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN IN_CRTST_CODIGO SII.CGG_RES_TRAMITE.CRTST_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_COUNT_RESIDENCIA INTEGER;
	TMP_RESULTADO VARCHAR;       
BEGIN   
	SELECT COUNT(CRRES.CRTST_CODIGO) INTO TMP_COUNT_RESIDENCIA FROM CGG_RES_TRAMITE CRTRA
	INNER JOIN CGG_RES_RESIDENCIA CRRES ON (CRRES.CRTRA_CODIGO = CRTRA.CRTRA_CODIGO)
	WHERE CRTRA.CRPER_CODIGO = IN_CRPER_CODIGO 
	AND CRRES.CRTST_CODIGO = IN_CRTST_CODIGO
	AND CRRES.CRRSD_VIGENTE;	 
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_COUNT_RESIDENCIA::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO TMP_RESULTADO;
	RETURN TMP_RESULTADO;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
* FUNCION SII.F_CGG_RES_RENOVACIONES_PERMITIDAS
* VERIFICA QUE EL AUSPICIANTE NO HAYA GENERADO UN TRAMITE DE RESIDENCIA TEMPORAL Y ESTE SE HALLE VIGENTE PARA UN BENEFICIARIO DISTINTO 
* @param IN_CRPER_CODIGO CODIGO DE LA PERSONA A QUIEN FUE OTORGADA LA RESIDENCIA
* @param IN_CRTST_CODIGO  TIPO DE SOLICITUD DE TRAMITE POR LA QUE OBTUVO LA RESIDENCIA.
* @param INOPERADOR OPERADOR DE COMPARACION
* @PARAM INVALORCOMPARACION VALOR DE COMPARACION
* @return CHARACTER VARYING
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_RENOVACIONES_PERMITIDAS(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN IN_CRTST_CODIGO SII.CGG_RES_TRAMITE.CRTST_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS CHARACTER VARYING AS
$$
DECLARE
	TMP_COUNT_RESIDENCIA INTEGER;
	TMP_RESULTADO VARCHAR;       
BEGIN   
	SELECT COUNT(CRRES.CRTST_CODIGO) INTO TMP_COUNT_RESIDENCIA FROM CGG_RES_TRAMITE CRTRA
	INNER JOIN CGG_RES_RESIDENCIA CRRES ON (CRRES.CRTRA_CODIGO = CRTRA.CRTRA_CODIGO)
	WHERE CRRES.CRPER_CODIGO = IN_CRPER_CODIGO 
	AND CRRES.CRTST_CODIGO = IN_CRTST_CODIGO;		 
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_COUNT_RESIDENCIA::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO TMP_RESULTADO;
	RETURN TMP_RESULTADO;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE COST 100;

/**
*FUNCION. REGLA DE VALIDACION QUE VALIDA QUE NO SE PODR� INICIAR UNA RENOVACI�N DE SOLICITUD DE RESIDENCIA TEMPORAL  N D�AS ANTES DE SU CADUCIDAD
*LA FUNCION INTERNAMENTE VALIDA Y COMPRUEBA EL VALOR E INDICA SI LA REGLA SE HA CUMPLIDO O NO.
*@param IN_CRPER_CODIGO CODIGO DE PERSONA.
*@param INOPERADOR OPERADOR DE COMPARACION.
*@param INVALORCOMPARACION VALOR DE COMPARACION.
*@return VARCHAR
*/
CREATE OR REPLACE FUNCTION SII.F_N_DIAS_CADUCIDAD_RENOVACION_TEMPORAL(
IN IN_CRPER_CODIGO SII.CGG_RES_TRAMITE.CRPER_CODIGO%TYPE,
IN INOPERADOR CHARACTER VARYING, 
IN INVALORCOMPARACION CHARACTER VARYING
)RETURNS VARCHAR AS
$$
DECLARE
	OUT_RESULTADO VARCHAR;
	TMP_COUNT INTEGER;
	TMP_RESULT VARCHAR;
BEGIN	
	/*SELECT count(PRS.CRPER_CODIGO) INTO TMP_COUNT
	FROM SII.CGG_RES_PERSONA PRS
	INNER JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = PRS.CRPER_CODIGO AND RSD.CRRSD_MODALIDAD = 1 AND RSD.CRRSD_VIGENTE
	WHERE PRS.CRPER_CODIGO = IN_CRPER_CODIGO AND RSD.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
		SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE  CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
		FROM CGG_CONFIGURACION
		WHERE CGCNF_CODIGO = '04')
		UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
		WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
	) SELECT CRTST_CODIGO  FROM TIPO);	
	
	IF TMP_COUNT = 0 THEN
		TMP_RESULT:='FALSE';
	ELSE*/
		TMP_RESULT:='TRUE';
		SELECT COUNT(CRPER_CODIGO) INTO TMP_COUNT		
		FROM CGG_RES_RESIDENCIA 
		WHERE 	CRRSD_MODALIDAD =  1 ----PARA TEMPORALES
				AND CRPER_CODIGO = IN_CRPER_CODIGO
				AND CURRENT_DATE BETWEEN 
					(SELECT CRRSD_FECHA_CADUCIDAD::DATE - 
						(SELECT CGCNF_VALOR_NUMERICO FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO = '26')::INTEGER
					)::DATE 
					AND CRRSD_FECHA_CADUCIDAD;
		IF TMP_COUNT = 0 THEN
			TMP_RESULT:='FALSE';
		ELSE
			TMP_RESULT:='TRUE';
		END IF;	
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_RESULT,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
	RETURN OUT_RESULTADO;	
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;
