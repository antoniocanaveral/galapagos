/**
* FUNCION SII.TRG_KG_CGG_VEH_CATEGORIA. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_VEH_CATEGORIA
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_VEH_CATEGORIA() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CVCTG_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CVCTG_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CVCTG_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CVCTG_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CVCTG_CODIGO>'||COALESCE(OLD.CVCTG_CODIGO, '')||'</CVCTG_CODIGO>'||
			'<CGG_CVCTG_CODIGO>'||COALESCE(OLD.CGG_CVCTG_CODIGO, '')||'</CGG_CVCTG_CODIGO>'||
			'<CVCTG_NOMBRE>'||COALESCE(OLD.CVCTG_NOMBRE, '')||'</CVCTG_NOMBRE>'||
			'<CVCTG_OBSERVACION>'||COALESCE(OLD.CVCTG_OBSERVACION, '')||'</CVCTG_OBSERVACION>'||
			'<CVCTG_ESTADO>'||COALESCE(OLD.CVCTG_ESTADO, FALSE)||'</CVCTG_ESTADO>'||
			'<CVCTG_USUARIO_INSERT>'||COALESCE(OLD.CVCTG_USUARIO_INSERT, '')||'</CVCTG_USUARIO_INSERT>'||
			'<CVCTG_FECHA_INSERT>'||COALESCE(OLD.CVCTG_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CVCTG_FECHA_INSERT>'||
			'<CVCTG_USUARIO_UPDATE>'||COALESCE(OLD.CVCTG_USUARIO_UPDATE, '')||'</CVCTG_USUARIO_UPDATE>'||
			'<CVCTG_FECHA_UPDATE>'||COALESCE(OLD.CVCTG_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CVCTG_FECHA_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CVCTG_CODIGO>'||COALESCE(NEW.CVCTG_CODIGO, '')||'</CVCTG_CODIGO>'||
			'<CGG_CVCTG_CODIGO>'||COALESCE(NEW.CGG_CVCTG_CODIGO, '')||'</CGG_CVCTG_CODIGO>'||
			'<CVCTG_NOMBRE>'||COALESCE(NEW.CVCTG_NOMBRE, '')||'</CVCTG_NOMBRE>'||
			'<CVCTG_OBSERVACION>'||COALESCE(NEW.CVCTG_OBSERVACION, '')||'</CVCTG_OBSERVACION>'||
			'<CVCTG_ESTADO>'||COALESCE(NEW.CVCTG_ESTADO, FALSE)||'</CVCTG_ESTADO>'||
			'<CVCTG_USUARIO_INSERT>'||COALESCE(NEW.CVCTG_USUARIO_INSERT, '')||'</CVCTG_USUARIO_INSERT>'||
			'<CVCTG_FECHA_INSERT>'||COALESCE(NEW.CVCTG_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CVCTG_FECHA_INSERT>'||
			'<CVCTG_USUARIO_UPDATE>'||COALESCE(NEW.CVCTG_USUARIO_UPDATE, '')||'</CVCTG_USUARIO_UPDATE>'||
			'<CVCTG_FECHA_UPDATE>'||COALESCE(NEW.CVCTG_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CVCTG_FECHA_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_VEH_CATEGORIA. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_VEH_CATEGORIA
*/
CREATE TRIGGER TRG_AUD_CGG_VEH_CATEGORIA AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_VEH_CATEGORIA FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_VEH_CATEGORIA();
COMMENT ON TRIGGER TRG_AUD_CGG_VEH_CATEGORIA ON SII.CGG_VEH_CATEGORIA IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_VEH_CATEGORIA DISABLE TRIGGER TRG_AUD_CGG_VEH_CATEGORIA;

