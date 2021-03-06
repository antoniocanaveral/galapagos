/**
* FUNCION SII.TRG_KG_CGG_RES_REQUISITO. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_RES_REQUISITO
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_RES_REQUISITO() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CRREQ_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CRREQ_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CRREQ_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CRREQ_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CRREQ_CODIGO>'||COALESCE(OLD.CRREQ_CODIGO, '')||'</CRREQ_CODIGO>'||
			'<CRREQ_DESCRIPCION>'||COALESCE(OLD.CRREQ_DESCRIPCION, '')||'</CRREQ_DESCRIPCION>'||
			'<CRREQ_OBSERVACION>'||COALESCE(OLD.CRREQ_OBSERVACION, '')||'</CRREQ_OBSERVACION>'||
			'<CRREQ_ESTADO>'||COALESCE(OLD.CRREQ_ESTADO, FALSE)||'</CRREQ_ESTADO>'||
			'<CRREQ_FECHA_INSERT>'||COALESCE(OLD.CRREQ_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CRREQ_FECHA_INSERT>'||
			'<CRREQ_USUARIO_INSERT>'||COALESCE(OLD.CRREQ_USUARIO_INSERT, '')||'</CRREQ_USUARIO_INSERT>'||
			'<CRREQ_FECHA_UPDATE>'||COALESCE(OLD.CRREQ_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CRREQ_FECHA_UPDATE>'||
			'<CRREQ_USUARIO_UPDATE>'||COALESCE(OLD.CRREQ_USUARIO_UPDATE, '')||'</CRREQ_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CRREQ_CODIGO>'||COALESCE(NEW.CRREQ_CODIGO, '')||'</CRREQ_CODIGO>'||
			'<CRREQ_DESCRIPCION>'||COALESCE(NEW.CRREQ_DESCRIPCION, '')||'</CRREQ_DESCRIPCION>'||
			'<CRREQ_OBSERVACION>'||COALESCE(NEW.CRREQ_OBSERVACION, '')||'</CRREQ_OBSERVACION>'||
			'<CRREQ_ESTADO>'||COALESCE(NEW.CRREQ_ESTADO, FALSE)||'</CRREQ_ESTADO>'||
			'<CRREQ_FECHA_INSERT>'||COALESCE(NEW.CRREQ_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CRREQ_FECHA_INSERT>'||
			'<CRREQ_USUARIO_INSERT>'||COALESCE(NEW.CRREQ_USUARIO_INSERT, '')||'</CRREQ_USUARIO_INSERT>'||
			'<CRREQ_FECHA_UPDATE>'||COALESCE(NEW.CRREQ_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CRREQ_FECHA_UPDATE>'||
			'<CRREQ_USUARIO_UPDATE>'||COALESCE(NEW.CRREQ_USUARIO_UPDATE, '')||'</CRREQ_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_RES_REQUISITO. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_RES_REQUISITO
*/
CREATE TRIGGER TRG_AUD_CGG_RES_REQUISITO AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_RES_REQUISITO FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_RES_REQUISITO();
COMMENT ON TRIGGER TRG_AUD_CGG_RES_REQUISITO ON SII.CGG_RES_REQUISITO IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_RES_REQUISITO DISABLE TRIGGER TRG_AUD_CGG_RES_REQUISITO;

