/**
* FUNCION SII.TRG_KG_CGG_KDX_PUNTO_VENTA. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_KDX_PUNTO_VENTA
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_KDX_PUNTO_VENTA() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CKPVT_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CKPVT_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CKPVT_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CKPVT_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CKPVT_CODIGO>'||COALESCE(OLD.CKPVT_CODIGO, '')||'</CKPVT_CODIGO>'||
			'<CCTN_CODIGO>'||COALESCE(OLD.CCTN_CODIGO, '')||'</CCTN_CODIGO>'||
			'<CKPVT_NOMBRE>'||COALESCE(OLD.CKPVT_NOMBRE, '')||'</CKPVT_NOMBRE>'||
			'<CKPVT_OBSERVACION>'||COALESCE(OLD.CKPVT_OBSERVACION, '')||'</CKPVT_OBSERVACION>'||
			'<CKPVT_ESTADO>'||COALESCE(OLD.CKPVT_ESTADO, FALSE)||'</CKPVT_ESTADO>'||
			'<CKPVT_FECHA_INSERT>'||COALESCE(OLD.CKPVT_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CKPVT_FECHA_INSERT>'||
			'<CKPVT_USUARIO_INSERT>'||COALESCE(OLD.CKPVT_USUARIO_INSERT, '')||'</CKPVT_USUARIO_INSERT>'||
			'<CKPVT_FECHA_UPDATE>'||COALESCE(OLD.CKPVT_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CKPVT_FECHA_UPDATE>'||
			'<CKPVT_USUARIO_UPDATE>'||COALESCE(OLD.CKPVT_USUARIO_UPDATE, '')||'</CKPVT_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CKPVT_CODIGO>'||COALESCE(NEW.CKPVT_CODIGO, '')||'</CKPVT_CODIGO>'||
			'<CCTN_CODIGO>'||COALESCE(NEW.CCTN_CODIGO, '')||'</CCTN_CODIGO>'||
			'<CKPVT_NOMBRE>'||COALESCE(NEW.CKPVT_NOMBRE, '')||'</CKPVT_NOMBRE>'||
			'<CKPVT_OBSERVACION>'||COALESCE(NEW.CKPVT_OBSERVACION, '')||'</CKPVT_OBSERVACION>'||
			'<CKPVT_ESTADO>'||COALESCE(NEW.CKPVT_ESTADO, FALSE)||'</CKPVT_ESTADO>'||
			'<CKPVT_FECHA_INSERT>'||COALESCE(NEW.CKPVT_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CKPVT_FECHA_INSERT>'||
			'<CKPVT_USUARIO_INSERT>'||COALESCE(NEW.CKPVT_USUARIO_INSERT, '')||'</CKPVT_USUARIO_INSERT>'||
			'<CKPVT_FECHA_UPDATE>'||COALESCE(NEW.CKPVT_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CKPVT_FECHA_UPDATE>'||
			'<CKPVT_USUARIO_UPDATE>'||COALESCE(NEW.CKPVT_USUARIO_UPDATE, '')||'</CKPVT_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_KDX_PUNTO_VENTA. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_KDX_PUNTO_VENTA
*/
CREATE TRIGGER TRG_AUD_CGG_KDX_PUNTO_VENTA AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_KDX_PUNTO_VENTA FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_KDX_PUNTO_VENTA();
COMMENT ON TRIGGER TRG_AUD_CGG_KDX_PUNTO_VENTA ON SII.CGG_KDX_PUNTO_VENTA IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_KDX_PUNTO_VENTA DISABLE TRIGGER TRG_AUD_CGG_KDX_PUNTO_VENTA;

