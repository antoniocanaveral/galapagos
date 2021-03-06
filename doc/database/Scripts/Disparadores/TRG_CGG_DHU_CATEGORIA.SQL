/**
* FUNCION SII.TRG_KG_CGG_DHU_CATEGORIA. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_CATEGORIA
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_DHU_CATEGORIA() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CDCAT_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDCAT_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CDCAT_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDCAT_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CDCAT_CODIGO>'||COALESCE(OLD.CDCAT_CODIGO, '')||'</CDCAT_CODIGO>'||
			'<CGG_CDCAT_CODIGO>'||COALESCE(OLD.CGG_CDCAT_CODIGO, '')||'</CGG_CDCAT_CODIGO>'||
			'<CDCAT_NOMBRE>'||COALESCE(OLD.CDCAT_NOMBRE, '')||'</CDCAT_NOMBRE>'||
			'<CDCAT_ESTADO>'||COALESCE(OLD.CDCAT_ESTADO, FALSE)||'</CDCAT_ESTADO>'||
			'<CDCAT_FECHA_INSERT>'||COALESCE(OLD.CDCAT_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDCAT_FECHA_INSERT>'||
			'<CDCAT_USUARIO_INSERT>'||COALESCE(OLD.CDCAT_USUARIO_INSERT, '')||'</CDCAT_USUARIO_INSERT>'||
			'<CDCAT_FECHA_UPDATE>'||COALESCE(OLD.CDCAT_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDCAT_FECHA_UPDATE>'||
			'<CDCAT_USUARIO_UPDATE>'||COALESCE(OLD.CDCAT_USUARIO_UPDATE, '')||'</CDCAT_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CDCAT_CODIGO>'||COALESCE(NEW.CDCAT_CODIGO, '')||'</CDCAT_CODIGO>'||
			'<CGG_CDCAT_CODIGO>'||COALESCE(NEW.CGG_CDCAT_CODIGO, '')||'</CGG_CDCAT_CODIGO>'||
			'<CDCAT_NOMBRE>'||COALESCE(NEW.CDCAT_NOMBRE, '')||'</CDCAT_NOMBRE>'||
			'<CDCAT_ESTADO>'||COALESCE(NEW.CDCAT_ESTADO, FALSE)||'</CDCAT_ESTADO>'||
			'<CDCAT_FECHA_INSERT>'||COALESCE(NEW.CDCAT_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDCAT_FECHA_INSERT>'||
			'<CDCAT_USUARIO_INSERT>'||COALESCE(NEW.CDCAT_USUARIO_INSERT, '')||'</CDCAT_USUARIO_INSERT>'||
			'<CDCAT_FECHA_UPDATE>'||COALESCE(NEW.CDCAT_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDCAT_FECHA_UPDATE>'||
			'<CDCAT_USUARIO_UPDATE>'||COALESCE(NEW.CDCAT_USUARIO_UPDATE, '')||'</CDCAT_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_DHU_CATEGORIA. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_CATEGORIA
*/
CREATE TRIGGER TRG_AUD_CGG_DHU_CATEGORIA AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_DHU_CATEGORIA FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_DHU_CATEGORIA();
COMMENT ON TRIGGER TRG_AUD_CGG_DHU_CATEGORIA ON SII.CGG_DHU_CATEGORIA IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_DHU_CATEGORIA DISABLE TRIGGER TRG_AUD_CGG_DHU_CATEGORIA;

