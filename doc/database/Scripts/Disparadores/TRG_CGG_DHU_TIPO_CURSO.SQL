/**
* FUNCION SII.TRG_KG_CGG_DHU_TIPO_CURSO. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_TIPO_CURSO
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_DHU_TIPO_CURSO() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CDTCR_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDTCR_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CDTCR_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDTCR_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CDTCR_CODIGO>'||COALESCE(OLD.CDTCR_CODIGO, '')||'</CDTCR_CODIGO>'||
			'<CDTCR_NOMBRE>'||COALESCE(OLD.CDTCR_NOMBRE, '')||'</CDTCR_NOMBRE>'||
			'<CDTCR_TIPO_RESIDENTE>'||COALESCE(OLD.CDTCR_TIPO_RESIDENTE, 0)||'</CDTCR_TIPO_RESIDENTE>'||
			'<CDTCR_ESTADO>'||COALESCE(OLD.CDTCR_ESTADO, FALSE)||'</CDTCR_ESTADO>'||
			'<CDTCR_FECHA_INSERT>'||COALESCE(OLD.CDTCR_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDTCR_FECHA_INSERT>'||
			'<CDTCR_USUARIO_INSERT>'||COALESCE(OLD.CDTCR_USUARIO_INSERT, '')||'</CDTCR_USUARIO_INSERT>'||
			'<CDTCR_FECHA_UPDATE>'||COALESCE(OLD.CDTCR_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDTCR_FECHA_UPDATE>'||
			'<CDTCR_USUARIO_UPDATE>'||COALESCE(OLD.CDTCR_USUARIO_UPDATE, '')||'</CDTCR_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CDTCR_CODIGO>'||COALESCE(NEW.CDTCR_CODIGO, '')||'</CDTCR_CODIGO>'||
			'<CDTCR_NOMBRE>'||COALESCE(NEW.CDTCR_NOMBRE, '')||'</CDTCR_NOMBRE>'||
			'<CDTCR_TIPO_RESIDENTE>'||COALESCE(NEW.CDTCR_TIPO_RESIDENTE, 0)||'</CDTCR_TIPO_RESIDENTE>'||
			'<CDTCR_ESTADO>'||COALESCE(NEW.CDTCR_ESTADO, FALSE)||'</CDTCR_ESTADO>'||
			'<CDTCR_FECHA_INSERT>'||COALESCE(NEW.CDTCR_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDTCR_FECHA_INSERT>'||
			'<CDTCR_USUARIO_INSERT>'||COALESCE(NEW.CDTCR_USUARIO_INSERT, '')||'</CDTCR_USUARIO_INSERT>'||
			'<CDTCR_FECHA_UPDATE>'||COALESCE(NEW.CDTCR_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDTCR_FECHA_UPDATE>'||
			'<CDTCR_USUARIO_UPDATE>'||COALESCE(NEW.CDTCR_USUARIO_UPDATE, '')||'</CDTCR_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_DHU_TIPO_CURSO. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_TIPO_CURSO
*/
CREATE TRIGGER TRG_AUD_CGG_DHU_TIPO_CURSO AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_DHU_TIPO_CURSO FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_DHU_TIPO_CURSO();
COMMENT ON TRIGGER TRG_AUD_CGG_DHU_TIPO_CURSO ON SII.CGG_DHU_TIPO_CURSO IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_DHU_TIPO_CURSO DISABLE TRIGGER TRG_AUD_CGG_DHU_TIPO_CURSO;

