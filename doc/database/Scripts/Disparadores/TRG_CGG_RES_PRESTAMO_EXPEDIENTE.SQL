/**
* FUNCION SII.TRG_KG_CGG_RES_PRESTAMO_EXPEDIENTE. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_RES_PRESTAMO_EXPEDIENTE
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_RES_PRESTAMO_EXPEDIENTE() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CRPEX_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CRPEX_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CRPEX_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CRPEX_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CRPEX_CODIGO>'||COALESCE(OLD.CRPEX_CODIGO, '')||'</CRPEX_CODIGO>'||
			'<CUSU_CODIGO>'||COALESCE(OLD.CUSU_CODIGO, '')||'</CUSU_CODIGO>'||
			'<CRPER_CODIGO>'||COALESCE(OLD.CRPER_CODIGO, '')||'</CRPER_CODIGO>'||
			'<CGG_CRPER_CODIGO>'||COALESCE(OLD.CGG_CRPER_CODIGO, '')||'</CGG_CRPER_CODIGO>'||
			'<CRPEX_FECHA_OPERACION>'||COALESCE(OLD.CRPEX_FECHA_OPERACION, CURRENT_TIMESTAMP)||'</CRPEX_FECHA_OPERACION>'||
			'<CRPEX_MOVIMIENTO>'||COALESCE(OLD.CRPEX_MOVIMIENTO, 0)||'</CRPEX_MOVIMIENTO>'||
			'<CRPEX_OBSERVACION>'||COALESCE(OLD.CRPEX_OBSERVACION, '')||'</CRPEX_OBSERVACION>'||
			'<CRPEX_ESTADO>'||COALESCE(OLD.CRPEX_ESTADO, FALSE)||'</CRPEX_ESTADO>'||
			'<CRPEX_FECHA_INSERT>'||COALESCE(OLD.CRPEX_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CRPEX_FECHA_INSERT>'||
			'<CRPEX_USUARIO_INSERT>'||COALESCE(OLD.CRPEX_USUARIO_INSERT, '')||'</CRPEX_USUARIO_INSERT>'||
			'<CRPEX_FECHA_UPDATE>'||COALESCE(OLD.CRPEX_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CRPEX_FECHA_UPDATE>'||
			'<CRPEX_USUARIO_UPDATE>'||COALESCE(OLD.CRPEX_USUARIO_UPDATE, '')||'</CRPEX_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CRPEX_CODIGO>'||COALESCE(NEW.CRPEX_CODIGO, '')||'</CRPEX_CODIGO>'||
			'<CUSU_CODIGO>'||COALESCE(NEW.CUSU_CODIGO, '')||'</CUSU_CODIGO>'||
			'<CRPER_CODIGO>'||COALESCE(NEW.CRPER_CODIGO, '')||'</CRPER_CODIGO>'||
			'<CGG_CRPER_CODIGO>'||COALESCE(NEW.CGG_CRPER_CODIGO, '')||'</CGG_CRPER_CODIGO>'||
			'<CRPEX_FECHA_OPERACION>'||COALESCE(NEW.CRPEX_FECHA_OPERACION, CURRENT_TIMESTAMP)||'</CRPEX_FECHA_OPERACION>'||
			'<CRPEX_MOVIMIENTO>'||COALESCE(NEW.CRPEX_MOVIMIENTO, 0)||'</CRPEX_MOVIMIENTO>'||
			'<CRPEX_OBSERVACION>'||COALESCE(NEW.CRPEX_OBSERVACION, '')||'</CRPEX_OBSERVACION>'||
			'<CRPEX_ESTADO>'||COALESCE(NEW.CRPEX_ESTADO, FALSE)||'</CRPEX_ESTADO>'||
			'<CRPEX_FECHA_INSERT>'||COALESCE(NEW.CRPEX_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CRPEX_FECHA_INSERT>'||
			'<CRPEX_USUARIO_INSERT>'||COALESCE(NEW.CRPEX_USUARIO_INSERT, '')||'</CRPEX_USUARIO_INSERT>'||
			'<CRPEX_FECHA_UPDATE>'||COALESCE(NEW.CRPEX_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CRPEX_FECHA_UPDATE>'||
			'<CRPEX_USUARIO_UPDATE>'||COALESCE(NEW.CRPEX_USUARIO_UPDATE, '')||'</CRPEX_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_RES_PRESTAMO_EXPEDIENTE. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_RES_PRESTAMO_EXPEDIENTE
*/
CREATE TRIGGER TRG_AUD_CGG_RES_PRESTAMO_EXPEDIENTE AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_RES_PRESTAMO_EXPEDIENTE FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_RES_PRESTAMO_EXPEDIENTE();
COMMENT ON TRIGGER TRG_AUD_CGG_RES_PRESTAMO_EXPEDIENTE ON SII.CGG_RES_PRESTAMO_EXPEDIENTE IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_RES_PRESTAMO_EXPEDIENTE DISABLE TRIGGER TRG_AUD_CGG_RES_PRESTAMO_EXPEDIENTE;

