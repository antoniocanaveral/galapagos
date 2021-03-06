/**
* FUNCION SII.TRG_KG_CGG_RES_GARANTIA_SOLICITUD. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_RES_GARANTIA_SOLICITUD
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_RES_GARANTIA_SOLICITUD() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CRGTS_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CRGTS_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CRGTS_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CRGTS_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CRGTS_CODIGO>'||COALESCE(OLD.CRGTS_CODIGO, '')||'</CRGTS_CODIGO>'||
			'<CRGRT_CODIGO>'||COALESCE(OLD.CRGRT_CODIGO, '')||'</CRGRT_CODIGO>'||
			'<CRTST_CODIGO>'||COALESCE(OLD.CRTST_CODIGO, '')||'</CRTST_CODIGO>'||
			'<CRGTS_ESTADO>'||COALESCE(OLD.CRGTS_ESTADO, FALSE)||'</CRGTS_ESTADO>'||
			'<CRGTS_FECHA_INSERT>'||COALESCE(OLD.CRGTS_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CRGTS_FECHA_INSERT>'||
			'<CRGTS_USUARIO_INSERT>'||COALESCE(OLD.CRGTS_USUARIO_INSERT, '')||'</CRGTS_USUARIO_INSERT>'||
			'<CRGTS_FECHA_UPDATE>'||COALESCE(OLD.CRGTS_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CRGTS_FECHA_UPDATE>'||
			'<CRGTS_USUARIO_UPDATE>'||COALESCE(OLD.CRGTS_USUARIO_UPDATE, '')||'</CRGTS_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CRGTS_CODIGO>'||COALESCE(NEW.CRGTS_CODIGO, '')||'</CRGTS_CODIGO>'||
			'<CRGRT_CODIGO>'||COALESCE(NEW.CRGRT_CODIGO, '')||'</CRGRT_CODIGO>'||
			'<CRTST_CODIGO>'||COALESCE(NEW.CRTST_CODIGO, '')||'</CRTST_CODIGO>'||
			'<CRGTS_ESTADO>'||COALESCE(NEW.CRGTS_ESTADO, FALSE)||'</CRGTS_ESTADO>'||
			'<CRGTS_FECHA_INSERT>'||COALESCE(NEW.CRGTS_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CRGTS_FECHA_INSERT>'||
			'<CRGTS_USUARIO_INSERT>'||COALESCE(NEW.CRGTS_USUARIO_INSERT, '')||'</CRGTS_USUARIO_INSERT>'||
			'<CRGTS_FECHA_UPDATE>'||COALESCE(NEW.CRGTS_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CRGTS_FECHA_UPDATE>'||
			'<CRGTS_USUARIO_UPDATE>'||COALESCE(NEW.CRGTS_USUARIO_UPDATE, '')||'</CRGTS_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_RES_GARANTIA_SOLICITUD. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_RES_GARANTIA_SOLICITUD
*/
CREATE TRIGGER TRG_AUD_CGG_RES_GARANTIA_SOLICITUD AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_RES_GARANTIA_SOLICITUD FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_RES_GARANTIA_SOLICITUD();
COMMENT ON TRIGGER TRG_AUD_CGG_RES_GARANTIA_SOLICITUD ON SII.CGG_RES_GARANTIA_SOLICITUD IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_RES_GARANTIA_SOLICITUD DISABLE TRIGGER TRG_AUD_CGG_RES_GARANTIA_SOLICITUD;

