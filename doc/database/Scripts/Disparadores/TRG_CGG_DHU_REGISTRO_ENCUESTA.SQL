/**
* FUNCION SII.TRG_KG_CGG_DHU_REGISTRO_ENCUESTA. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_REGISTRO_ENCUESTA
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_DHU_REGISTRO_ENCUESTA() RETURNS TRIGGER AS
$$
DECLARE
TMP_CUSU_CODIGO VARCHAR;
TMP_IP VARCHAR;
TMP_SESSION_ID VARCHAR;
TMP_DATO_NUEVO VARCHAR;
TMP_DATO_ANTIGUO VARCHAR;
TMP_USUARIO VARCHAR;
TMP_CODIGO VARCHAR;
BEGIN
	TMP_DATO_ANTIGUO = '';
	TMP_DATO_NUEVO = '';
	IF (TG_OP = 'INSERT') THEN
		TMP_USUARIO = NEW.CDRGE_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDRGE_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CDRGE_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDRGE_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CDRGE_CODIGO>'||COALESCE(OLD.CDRGE_CODIGO, '')||'</CDRGE_CODIGO>'||
			'<CDPRG_CODIGO>'||COALESCE(OLD.CDPRG_CODIGO, '')||'</CDPRG_CODIGO>'||
			'<CDRES_CODIGO>'||COALESCE(OLD.CDRES_CODIGO, '')||'</CDRES_CODIGO>'||
			'<CDAPE_CODIGO>'||COALESCE(OLD.CDAPE_CODIGO, '')||'</CDAPE_CODIGO>'||
			'<CDRGE_RESPUESTA_ABIERTA>'||COALESCE(OLD.CDRGE_RESPUESTA_ABIERTA, '')||'</CDRGE_RESPUESTA_ABIERTA>'||
			'<CDRGE_FECHA_REGISTRO>'||COALESCE(OLD.CDRGE_FECHA_REGISTRO, CURRENT_TIMESTAMP)||'</CDRGE_FECHA_REGISTRO>'||
			'<CDRGE_OBSERVACION>'||COALESCE(OLD.CDRGE_OBSERVACION, '')||'</CDRGE_OBSERVACION>'||
			'<CDRGE_ESTADO>'||COALESCE(OLD.CDRGE_ESTADO, FALSE)||'</CDRGE_ESTADO>'||
			'<CDRGE_FECHA_INSERT>'||COALESCE(OLD.CDRGE_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDRGE_FECHA_INSERT>'||
			'<CDRGE_USUARIO_INSERT>'||COALESCE(OLD.CDRGE_USUARIO_INSERT, '')||'</CDRGE_USUARIO_INSERT>'||
			'<CDRGE_FECHA_UPDATE>'||COALESCE(OLD.CDRGE_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDRGE_FECHA_UPDATE>'||
			'<CDRGE_USUARIO_UPDATE>'||COALESCE(OLD.CDRGE_USUARIO_UPDATE, '')||'</CDRGE_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CDRGE_CODIGO>'||COALESCE(NEW.CDRGE_CODIGO, '')||'</CDRGE_CODIGO>'||
			'<CDPRG_CODIGO>'||COALESCE(NEW.CDPRG_CODIGO, '')||'</CDPRG_CODIGO>'||
			'<CDRES_CODIGO>'||COALESCE(NEW.CDRES_CODIGO, '')||'</CDRES_CODIGO>'||
			'<CDAPE_CODIGO>'||COALESCE(NEW.CDAPE_CODIGO, '')||'</CDAPE_CODIGO>'||
			'<CDRGE_RESPUESTA_ABIERTA>'||COALESCE(NEW.CDRGE_RESPUESTA_ABIERTA, '')||'</CDRGE_RESPUESTA_ABIERTA>'||
			'<CDRGE_FECHA_REGISTRO>'||COALESCE(NEW.CDRGE_FECHA_REGISTRO, CURRENT_TIMESTAMP)||'</CDRGE_FECHA_REGISTRO>'||
			'<CDRGE_OBSERVACION>'||COALESCE(NEW.CDRGE_OBSERVACION, '')||'</CDRGE_OBSERVACION>'||
			'<CDRGE_ESTADO>'||COALESCE(NEW.CDRGE_ESTADO, FALSE)||'</CDRGE_ESTADO>'||
			'<CDRGE_FECHA_INSERT>'||COALESCE(NEW.CDRGE_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDRGE_FECHA_INSERT>'||
			'<CDRGE_USUARIO_INSERT>'||COALESCE(NEW.CDRGE_USUARIO_INSERT, '')||'</CDRGE_USUARIO_INSERT>'||
			'<CDRGE_FECHA_UPDATE>'||COALESCE(NEW.CDRGE_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDRGE_FECHA_UPDATE>'||
			'<CDRGE_USUARIO_UPDATE>'||COALESCE(NEW.CDRGE_USUARIO_UPDATE, '')||'</CDRGE_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	END IF;

	INSERT INTO SII.CGG_SEC_AUDITORIA(
		CSADT_CODIGO,
		CSADT_FECHA,
		CSADT_USUARIO,
		CSADT_IP,
		CSADT_SESION,
		CSADT_TABLA,
		CSADT_OPERACION,
		CSADT_DATO_ANTIGUO,
		CSADT_DATO_NUEVO
	) VALUES (
		('CSADT'||NEXTVAL('scn_cgg_sec_auditoria'))::VARCHAR,
		CURRENT_TIMESTAMP,
		TMP_USUARIO,
		TMP_IP,
		TMP_SESSION_ID,
		TG_TABLE_NAME,
		TG_OP,
		TMP_DATO_ANTIGUO,
		TMP_DATO_NUEVO
	);
	RETURN NULL;
END;
$$
LANGUAGE plpgsql;

/**
* DISPARADOR TRG_KG_CGG_DHU_REGISTRO_ENCUESTA. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_REGISTRO_ENCUESTA
*/
CREATE TRIGGER TRG_AUD_CGG_DHU_REGISTRO_ENCUESTA AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_DHU_REGISTRO_ENCUESTA FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_DHU_REGISTRO_ENCUESTA();
COMMENT ON TRIGGER TRG_AUD_CGG_DHU_REGISTRO_ENCUESTA ON SII.CGG_DHU_REGISTRO_ENCUESTA IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_DHU_REGISTRO_ENCUESTA DISABLE TRIGGER TRG_AUD_CGG_DHU_REGISTRO_ENCUESTA;

