/**
* FUNCION SII.TRG_KG_CGG_JUR_HISTORIAL_PROCESO. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_JUR_HISTORIAL_PROCESO
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_JUR_HISTORIAL_PROCESO() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CJHTP_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CJHTP_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CJHTP_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CJHTP_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CJHTP_CODIGO>'||COALESCE(OLD.CJHTP_CODIGO, '')||'</CJHTP_CODIGO>'||
			'<CJPJU_CODIGO>'||COALESCE(OLD.CJPJU_CODIGO, '')||'</CJPJU_CODIGO>'||
			'<CJHTP_DESCRIPCION>'||COALESCE(OLD.CJHTP_DESCRIPCION, '')||'</CJHTP_DESCRIPCION>'||
			'<CJHTP_TIPO>'||COALESCE(OLD.CJHTP_TIPO, 0)||'</CJHTP_TIPO>'||
			'<CJHTP_RESPONSABLE>'||COALESCE(OLD.CJHTP_RESPONSABLE, '')||'</CJHTP_RESPONSABLE>'||
			'<CJHTP_FECHA>'||COALESCE(OLD.CJHTP_FECHA, CURRENT_TIMESTAMP)||'</CJHTP_FECHA>'||
			'<CJHTP_ESTADO>'||COALESCE(OLD.CJHTP_ESTADO, FALSE)||'</CJHTP_ESTADO>'||
			'<CJHTP_FECHA_INSERT>'||COALESCE(OLD.CJHTP_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CJHTP_FECHA_INSERT>'||
			'<CJHTP_USUARIO_INSERT>'||COALESCE(OLD.CJHTP_USUARIO_INSERT, '')||'</CJHTP_USUARIO_INSERT>'||
			'<CJHTP_FECHA_UPDATE>'||COALESCE(OLD.CJHTP_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CJHTP_FECHA_UPDATE>'||
			'<CJHTP_USUARIO_UPDATE>'||COALESCE(OLD.CJHTP_USUARIO_UPDATE, '')||'</CJHTP_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CJHTP_CODIGO>'||COALESCE(NEW.CJHTP_CODIGO, '')||'</CJHTP_CODIGO>'||
			'<CJPJU_CODIGO>'||COALESCE(NEW.CJPJU_CODIGO, '')||'</CJPJU_CODIGO>'||
			'<CJHTP_DESCRIPCION>'||COALESCE(NEW.CJHTP_DESCRIPCION, '')||'</CJHTP_DESCRIPCION>'||
			'<CJHTP_TIPO>'||COALESCE(NEW.CJHTP_TIPO, 0)||'</CJHTP_TIPO>'||
			'<CJHTP_RESPONSABLE>'||COALESCE(NEW.CJHTP_RESPONSABLE, '')||'</CJHTP_RESPONSABLE>'||
			'<CJHTP_FECHA>'||COALESCE(NEW.CJHTP_FECHA, CURRENT_TIMESTAMP)||'</CJHTP_FECHA>'||
			'<CJHTP_ESTADO>'||COALESCE(NEW.CJHTP_ESTADO, FALSE)||'</CJHTP_ESTADO>'||
			'<CJHTP_FECHA_INSERT>'||COALESCE(NEW.CJHTP_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CJHTP_FECHA_INSERT>'||
			'<CJHTP_USUARIO_INSERT>'||COALESCE(NEW.CJHTP_USUARIO_INSERT, '')||'</CJHTP_USUARIO_INSERT>'||
			'<CJHTP_FECHA_UPDATE>'||COALESCE(NEW.CJHTP_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CJHTP_FECHA_UPDATE>'||
			'<CJHTP_USUARIO_UPDATE>'||COALESCE(NEW.CJHTP_USUARIO_UPDATE, '')||'</CJHTP_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_JUR_HISTORIAL_PROCESO. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_JUR_HISTORIAL_PROCESO
*/
CREATE TRIGGER TRG_AUD_CGG_JUR_HISTORIAL_PROCESO AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_JUR_HISTORIAL_PROCESO FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_JUR_HISTORIAL_PROCESO();
COMMENT ON TRIGGER TRG_AUD_CGG_JUR_HISTORIAL_PROCESO ON SII.CGG_JUR_HISTORIAL_PROCESO IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_JUR_HISTORIAL_PROCESO DISABLE TRIGGER TRG_AUD_CGG_JUR_HISTORIAL_PROCESO;

