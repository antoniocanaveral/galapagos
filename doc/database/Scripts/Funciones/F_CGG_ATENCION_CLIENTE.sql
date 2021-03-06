
/**
* FUNCION SII.F_CGG_ATC_CADENA_GRUPO
* UNE VARIAS CADENAS PARA REALIZAR UNA BUSQIUEDA PERZONALIZADA.
* @param IN_GRUPO_NAME NOMBRE DEL GRUPO DE BUSQUEDA
* @param IN_GRUPO_VALUE VALOR DEL GRUPO DE BUSQUEDA
* @return TOTAL DE REGISTROS
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_ATC_CADENA_GRUPO(
IN IN_GROUP_NAME VARCHAR,
IN IN_GROUP_VALUE VARCHAR
)RETURNS VARCHAR AS
$$
DECLARE
	TMP_IN_GRUPO VARCHAR;
BEGIN
	TMP_IN_GRUPO:='';
	IF LENGTH(IN_GROUP_NAME)>0 THEN
		SELECT CASE IN_GROUP_NAME 
			WHEN 'SECTOR' THEN 'CSCTP.CSCTP_CODIGO'
            WHEN 'AREA' THEN 'CGARE.CGARE_CODIGO'
            WHEN 'CARGO' THEN 'CGCRG.CGCRG_CODIGO'
            WHEN 'OFERENTE' THEN 'CRPJR.CRPJR_CODIGO'
            WHEN 'ISLA' THEN 'CGISE.CISLA_CODIGO'
            ELSE ' ' INTO TMP_IN_GRUPO
		END;
		IF IN_GROUP_NAME = 'ISLA' THEN
			TMP_IN_GRUPO:='AND '''||IN_GROUP_VALUE||''' in (SELECT EMP.CISLA_CODIGO FROM SII.CGG_GEM_ISLA_EMPLEO EMP WHERE EMP.CGVCN_CODIGO = CGVCN.CGVCN_CODIGO)';
		ELSIF TMP_IN_GRUPO <> ' ' THEN
			TMP_IN_GRUPO:='AND '||TMP_IN_GRUPO||'=''' ||IN_GROUP_VALUE ||''' ';
		ELSE
			TMP_IN_GRUPO:='';/*AND '||TMP_IN_GRUPO||' IS NULL';*/
		END IF;
	END IF;	
	IF LENGTH(IN_GROUP_VALUE)=0 THEN
		TMP_IN_GRUPO:='';
	END IF;
	RETURN	TMP_IN_GRUPO;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;


/**
* FUNCION SII.F_CGG_ATC_GEM_ACTIVAR
* ACTIVA EL USUARIO PARA UTILIZARLO EN GESTION DE EMPLEO.
* @param IN_NUMERO_CARNET NUMERO DE CARNET DE RESIDENCIA
* @param IN_USER_NAME NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES
* @return VOID
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_ATC_GEM_ACTIVAR(
IN IN_NUMERO_CARNET VARCHAR,
IN IN_USER_NAME VARCHAR
)RETURNS VARCHAR[] AS
$$
DECLARE
TMP_PER_CODIGO VARCHAR;
TMP_MAIL VARCHAR[];
TMP_COUNT INT;
TMP_USU_CODIGO VARCHAR;
TMP_USU_NOMBRE VARCHAR;
TMP_RESULT  VARCHAR;
BEGIN
	SELECT PER.CRPER_CODIGO INTO TMP_PER_CODIGO
	FROM SII.CGG_RES_PERSONA PER
	INNER JOIN SII.CGG_USUARIO USU ON PER.CRPER_CODIGO = USU.CRPER_CODIGO
	WHERE PER.CRPER_NUMERO_RESIDENCIA IS NOT NULL 
		AND PER.CRPER_NUMERO_RESIDENCIA=IN_NUMERO_CARNET
		AND PER.CRPER_ESTADO =TRUE
		AND USU.CUSU_ESTADO =TRUE		
		AND USU.CUSU_NOMBRE_USUARIO = IN_USER_NAME;
	
	IF TMP_PER_CODIGO IS NULL THEN
		RAISE EXCEPTION 'No existe un residente registrado con el # de carnet ingresado, o el numero de carnet no le corresponde!';
	ELSE
		SELECT ARRAY( SELECT CRPRC_CONTACTO 
		FROM SII.CGG_RES_PERSONA_CONTACTO 
		WHERE CRPER_CODIGO = TMP_PER_CODIGO
			AND CRPRC_ESTADO = TRUE 
			AND CRTCO_CODIGO = 'CRTCO1'
		) INTO TMP_MAIL;
		IF TMP_MAIL IS NULL OR ARRAY_LENGTH(TMP_MAIL,1) = 0 THEN
			RAISE EXCEPTION 'No tiene registrado un correo electronico necesario para activar su cuenta';
		ELSE
			SELECT COUNT(CUSU.CUSU_CODIGO) INTO TMP_COUNT
			FROM SII.CGG_USUARIO CUSU
			INNER JOIN SII.CGG_SEC_USUARIO_ROL CSROL ON CSROL.CUSU_CODIGO = CUSU.CUSU_CODIGO 
			WHERE CRPER_CODIGO =TMP_PER_CODIGO 
				AND CUSU_ESTADO AND CSPER_ESTADO
				AND CSROL.CSROL_CODIGO = 'CSROL_GEAPL';
			IF TMP_COUNT>0 THEN
				RAISE EXCEPTION 'Su cuenta ya esta activada para utilizar gestion de empleo';
			ELSE				
				SELECT CUSU_CODIGO, CUSU_NOMBRE_USUARIO INTO TMP_USU_CODIGO,TMP_USU_NOMBRE
				FROM  SII.CGG_USUARIO
				WHERE CUSU_ESTADO = TRUE 
					AND CRPER_CODIGO = TMP_PER_CODIGO;				
				IF TMP_USU_CODIGO IS NULL THEN 
					RAISE EXCEPTION 'No tiene creado un usuario para activar el modulo';
				END IF;
				SELECT 
					SII.F_CGG_SEC_USUARIO_ROL_INSERT(
						'KEYGEN','CSROL_GEAPL',TMP_USU_CODIGO, TRUE,TMP_USU_NOMBRE,TMP_USU_NOMBRE
					) INTO TMP_RESULT;
			END IF;
		END IF;	
	END IF;
	RETURN TMP_MAIL;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;