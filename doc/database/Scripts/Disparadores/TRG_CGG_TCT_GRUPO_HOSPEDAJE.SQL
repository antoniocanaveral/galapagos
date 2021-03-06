/**
* FUNCION SII.TRG_KG_CGG_TCT_GRUPO_HOSPEDAJE. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_TCT_GRUPO_HOSPEDAJE
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_TCT_GRUPO_HOSPEDAJE() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CTGHJ_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CTGHJ_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CTGHJ_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CTGHJ_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CTGHJ_CODIGO>'||COALESCE(OLD.CTGHJ_CODIGO, '')||'</CTGHJ_CODIGO>'||
			'<CTGTR_CODIGO>'||COALESCE(OLD.CTGTR_CODIGO, '')||'</CTGTR_CODIGO>'||
			'<CTTHJ_CODIGO>'||COALESCE(OLD.CTTHJ_CODIGO, '')||'</CTTHJ_CODIGO>'||
			'<CTGHJ_LUGAR_HOSPEDAJE>'||COALESCE(OLD.CTGHJ_LUGAR_HOSPEDAJE, '')||'</CTGHJ_LUGAR_HOSPEDAJE>'||
			'<CTGHJ_ESTADO>'||COALESCE(OLD.CTGHJ_ESTADO, FALSE)||'</CTGHJ_ESTADO>'||
			'<CTGHJ_FECHA_INSERT>'||COALESCE(OLD.CTGHJ_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CTGHJ_FECHA_INSERT>'||
			'<CTGHJ_USUARIO_INSERT>'||COALESCE(OLD.CTGHJ_USUARIO_INSERT, '')||'</CTGHJ_USUARIO_INSERT>'||
			'<CTGHJ_FECHA_UPDATE>'||COALESCE(OLD.CTGHJ_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CTGHJ_FECHA_UPDATE>'||
			'<CTGHJ_USUARIO_UPDATE>'||COALESCE(OLD.CTGHJ_USUARIO_UPDATE, '')||'</CTGHJ_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CTGHJ_CODIGO>'||COALESCE(NEW.CTGHJ_CODIGO, '')||'</CTGHJ_CODIGO>'||
			'<CTGTR_CODIGO>'||COALESCE(NEW.CTGTR_CODIGO, '')||'</CTGTR_CODIGO>'||
			'<CTTHJ_CODIGO>'||COALESCE(NEW.CTTHJ_CODIGO, '')||'</CTTHJ_CODIGO>'||
			'<CTGHJ_LUGAR_HOSPEDAJE>'||COALESCE(NEW.CTGHJ_LUGAR_HOSPEDAJE, '')||'</CTGHJ_LUGAR_HOSPEDAJE>'||
			'<CTGHJ_ESTADO>'||COALESCE(NEW.CTGHJ_ESTADO, FALSE)||'</CTGHJ_ESTADO>'||
			'<CTGHJ_FECHA_INSERT>'||COALESCE(NEW.CTGHJ_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CTGHJ_FECHA_INSERT>'||
			'<CTGHJ_USUARIO_INSERT>'||COALESCE(NEW.CTGHJ_USUARIO_INSERT, '')||'</CTGHJ_USUARIO_INSERT>'||
			'<CTGHJ_FECHA_UPDATE>'||COALESCE(NEW.CTGHJ_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CTGHJ_FECHA_UPDATE>'||
			'<CTGHJ_USUARIO_UPDATE>'||COALESCE(NEW.CTGHJ_USUARIO_UPDATE, '')||'</CTGHJ_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_TCT_GRUPO_HOSPEDAJE. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_TCT_GRUPO_HOSPEDAJE
*/
CREATE TRIGGER TRG_AUD_CGG_TCT_GRUPO_HOSPEDAJE AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_TCT_GRUPO_HOSPEDAJE FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_TCT_GRUPO_HOSPEDAJE();
COMMENT ON TRIGGER TRG_AUD_CGG_TCT_GRUPO_HOSPEDAJE ON SII.CGG_TCT_GRUPO_HOSPEDAJE IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_TCT_GRUPO_HOSPEDAJE DISABLE TRIGGER TRG_AUD_CGG_TCT_GRUPO_HOSPEDAJE;

