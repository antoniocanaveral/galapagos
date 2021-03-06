/**
* FUNCION SII.TRG_KG_CGG_INSTITUCION_NIVEL. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_INSTITUCION_NIVEL
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_INSTITUCION_NIVEL() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CGIEN_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CGIEN_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CGIEN_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CGIEN_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CGIEN_CODIGO>'||COALESCE(OLD.CGIEN_CODIGO, '')||'</CGIEN_CODIGO>'||
			'<CGNES_CODIGO>'||COALESCE(OLD.CGNES_CODIGO, '')||'</CGNES_CODIGO>'||
			'<CGIED_CODIGO>'||COALESCE(OLD.CGIED_CODIGO, '')||'</CGIED_CODIGO>'||
			'<CGIEN_ESTADO>'||COALESCE(OLD.CGIEN_ESTADO, FALSE)||'</CGIEN_ESTADO>'||
			'<CGIEN_FECHA_INSERT>'||COALESCE(OLD.CGIEN_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CGIEN_FECHA_INSERT>'||
			'<CGIEN_USUARIO_INSERT>'||COALESCE(OLD.CGIEN_USUARIO_INSERT, '')||'</CGIEN_USUARIO_INSERT>'||
			'<CGIEN_FECHA_UPDATE>'||COALESCE(OLD.CGIEN_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CGIEN_FECHA_UPDATE>'||
			'<CGIEN_USUARIO_UPDATE>'||COALESCE(OLD.CGIEN_USUARIO_UPDATE, '')||'</CGIEN_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CGIEN_CODIGO>'||COALESCE(NEW.CGIEN_CODIGO, '')||'</CGIEN_CODIGO>'||
			'<CGNES_CODIGO>'||COALESCE(NEW.CGNES_CODIGO, '')||'</CGNES_CODIGO>'||
			'<CGIED_CODIGO>'||COALESCE(NEW.CGIED_CODIGO, '')||'</CGIED_CODIGO>'||
			'<CGIEN_ESTADO>'||COALESCE(NEW.CGIEN_ESTADO, FALSE)||'</CGIEN_ESTADO>'||
			'<CGIEN_FECHA_INSERT>'||COALESCE(NEW.CGIEN_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CGIEN_FECHA_INSERT>'||
			'<CGIEN_USUARIO_INSERT>'||COALESCE(NEW.CGIEN_USUARIO_INSERT, '')||'</CGIEN_USUARIO_INSERT>'||
			'<CGIEN_FECHA_UPDATE>'||COALESCE(NEW.CGIEN_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CGIEN_FECHA_UPDATE>'||
			'<CGIEN_USUARIO_UPDATE>'||COALESCE(NEW.CGIEN_USUARIO_UPDATE, '')||'</CGIEN_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_INSTITUCION_NIVEL. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_INSTITUCION_NIVEL
*/
CREATE TRIGGER TRG_AUD_CGG_INSTITUCION_NIVEL AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_INSTITUCION_NIVEL FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_INSTITUCION_NIVEL();
COMMENT ON TRIGGER TRG_AUD_CGG_INSTITUCION_NIVEL ON SII.CGG_INSTITUCION_NIVEL IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_INSTITUCION_NIVEL DISABLE TRIGGER TRG_AUD_CGG_INSTITUCION_NIVEL;

