/**
* FUNCION SII.TRG_KG_CGG_GEM_DENUNCIA_ADJUNTO. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_GEM_DENUNCIA_ADJUNTO
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_GEM_DENUNCIA_ADJUNTO() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CGDAD_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CGDAD_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CGDAD_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CGDAD_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CGDAD_CODIGO>'||COALESCE(OLD.CGDAD_CODIGO, '')||'</CGDAD_CODIGO>'||
			'<CRDEN_CODIGO>'||COALESCE(OLD.CRDEN_CODIGO, '')||'</CRDEN_CODIGO>'||
			'<CGDAD_DESCRIPCION>'||COALESCE(OLD.CGDAD_DESCRIPCION, '')||'</CGDAD_DESCRIPCION>'||
			'<CGDAD_TIPO_ADJUNTO>'||COALESCE(OLD.CGDAD_TIPO_ADJUNTO, '')||'</CGDAD_TIPO_ADJUNTO>'||
			'<CGDAD_NOMBRE_ADJUNTO>'||COALESCE(OLD.CGDAD_NOMBRE_ADJUNTO, '')||'</CGDAD_NOMBRE_ADJUNTO>'||
			'<CGDAD_ADJUNTO>'||COALESCE(encode(OLD.CGDAD_ADJUNTO, 'base64'), '')||'</CGDAD_ADJUNTO>'||
			'<CGDAD_ESTADO>'||COALESCE(OLD.CGDAD_ESTADO, FALSE)||'</CGDAD_ESTADO>'||
			'<CGDAD_FECHA_INSERT>'||COALESCE(OLD.CGDAD_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CGDAD_FECHA_INSERT>'||
			'<CGDAD_USUARIO_INSERT>'||COALESCE(OLD.CGDAD_USUARIO_INSERT, '')||'</CGDAD_USUARIO_INSERT>'||
			'<CGDAD_FECHA_UPDATE>'||COALESCE(OLD.CGDAD_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CGDAD_FECHA_UPDATE>'||
			'<CGDAD_USUARIO_UPDATE>'||COALESCE(OLD.CGDAD_USUARIO_UPDATE, '')||'</CGDAD_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CGDAD_CODIGO>'||COALESCE(NEW.CGDAD_CODIGO, '')||'</CGDAD_CODIGO>'||
			'<CRDEN_CODIGO>'||COALESCE(NEW.CRDEN_CODIGO, '')||'</CRDEN_CODIGO>'||
			'<CGDAD_DESCRIPCION>'||COALESCE(NEW.CGDAD_DESCRIPCION, '')||'</CGDAD_DESCRIPCION>'||
			'<CGDAD_TIPO_ADJUNTO>'||COALESCE(NEW.CGDAD_TIPO_ADJUNTO, '')||'</CGDAD_TIPO_ADJUNTO>'||
			'<CGDAD_NOMBRE_ADJUNTO>'||COALESCE(NEW.CGDAD_NOMBRE_ADJUNTO, '')||'</CGDAD_NOMBRE_ADJUNTO>'||
			'<CGDAD_ADJUNTO>'||COALESCE(encode(NEW.CGDAD_ADJUNTO, 'base64'), '')||'</CGDAD_ADJUNTO>'||
			'<CGDAD_ESTADO>'||COALESCE(NEW.CGDAD_ESTADO, FALSE)||'</CGDAD_ESTADO>'||
			'<CGDAD_FECHA_INSERT>'||COALESCE(NEW.CGDAD_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CGDAD_FECHA_INSERT>'||
			'<CGDAD_USUARIO_INSERT>'||COALESCE(NEW.CGDAD_USUARIO_INSERT, '')||'</CGDAD_USUARIO_INSERT>'||
			'<CGDAD_FECHA_UPDATE>'||COALESCE(NEW.CGDAD_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CGDAD_FECHA_UPDATE>'||
			'<CGDAD_USUARIO_UPDATE>'||COALESCE(NEW.CGDAD_USUARIO_UPDATE, '')||'</CGDAD_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_GEM_DENUNCIA_ADJUNTO. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_GEM_DENUNCIA_ADJUNTO
*/
CREATE TRIGGER TRG_AUD_CGG_GEM_DENUNCIA_ADJUNTO AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_GEM_DENUNCIA_ADJUNTO FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_GEM_DENUNCIA_ADJUNTO();
COMMENT ON TRIGGER TRG_AUD_CGG_GEM_DENUNCIA_ADJUNTO ON SII.CGG_GEM_DENUNCIA_ADJUNTO IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_GEM_DENUNCIA_ADJUNTO DISABLE TRIGGER TRG_AUD_CGG_GEM_DENUNCIA_ADJUNTO;

