/**
* FUNCION SII.TRG_KG_CGG_GEM_INFORMACION_LABORAL. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_GEM_INFORMACION_LABORAL
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_GEM_INFORMACION_LABORAL() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CGINF_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CGINF_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CGINF_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CGINF_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CGINF_CODIGO>'||COALESCE(OLD.CGINF_CODIGO, '')||'</CGINF_CODIGO>'||
			'<CRPER_CODIGO>'||COALESCE(OLD.CRPER_CODIGO, '')||'</CRPER_CODIGO>'||
			'<CGINF_TRAB_OTRA_CIUDAD>'||COALESCE(OLD.CGINF_TRAB_OTRA_CIUDAD, '')||'</CGINF_TRAB_OTRA_CIUDAD>'||
			'<CGINF_DISPONIBILIDAD>'||COALESCE(OLD.CGINF_DISPONIBILIDAD, '')||'</CGINF_DISPONIBILIDAD>'||
			'<CGINF_CALIFICACION>'||COALESCE(OLD.CGINF_CALIFICACION, '')||'</CGINF_CALIFICACION>'||
			'<CGINF_LICENCIA_CONDUCIR>'||COALESCE(OLD.CGINF_LICENCIA_CONDUCIR, '')||'</CGINF_LICENCIA_CONDUCIR>'||
			'<CGINF_ESTADO_LABORAL>'||COALESCE(OLD.CGINF_ESTADO_LABORAL, '')||'</CGINF_ESTADO_LABORAL>'||
			'<CGINF_HIJOS>'||COALESCE(OLD.CGINF_HIJOS, 0)||'</CGINF_HIJOS>'||
			'<CGINF_GESTION_EMPLEO>'||COALESCE(OLD.CGINF_GESTION_EMPLEO, '')||'</CGINF_GESTION_EMPLEO>'||
			'<CGINF_FECHA_GESTION_EMPLEO>'||COALESCE(OLD.CGINF_FECHA_GESTION_EMPLEO, CURRENT_TIMESTAMP)||'</CGINF_FECHA_GESTION_EMPLEO>'||
			'<CGINF_OBSERVACIONES>'||COALESCE(OLD.CGINF_OBSERVACIONES, '')||'</CGINF_OBSERVACIONES>'||
			'<CGINF_ESTADO>'||COALESCE(OLD.CGINF_ESTADO, FALSE)||'</CGINF_ESTADO>'||
			'<CGINF_FECHA_INSERT>'||COALESCE(OLD.CGINF_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CGINF_FECHA_INSERT>'||
			'<CGINF_USUARIO_INSERT>'||COALESCE(OLD.CGINF_USUARIO_INSERT, '')||'</CGINF_USUARIO_INSERT>'||
			'<CGINF_FECHA_UPDATE>'||COALESCE(OLD.CGINF_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CGINF_FECHA_UPDATE>'||
			'<CGINF_USUARIO_UPDATE>'||COALESCE(OLD.CGINF_USUARIO_UPDATE, '')||'</CGINF_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CGINF_CODIGO>'||COALESCE(NEW.CGINF_CODIGO, '')||'</CGINF_CODIGO>'||
			'<CRPER_CODIGO>'||COALESCE(NEW.CRPER_CODIGO, '')||'</CRPER_CODIGO>'||
			'<CGINF_TRAB_OTRA_CIUDAD>'||COALESCE(NEW.CGINF_TRAB_OTRA_CIUDAD, '')||'</CGINF_TRAB_OTRA_CIUDAD>'||
			'<CGINF_DISPONIBILIDAD>'||COALESCE(NEW.CGINF_DISPONIBILIDAD, '')||'</CGINF_DISPONIBILIDAD>'||
			'<CGINF_CALIFICACION>'||COALESCE(NEW.CGINF_CALIFICACION, '')||'</CGINF_CALIFICACION>'||
			'<CGINF_LICENCIA_CONDUCIR>'||COALESCE(NEW.CGINF_LICENCIA_CONDUCIR, '')||'</CGINF_LICENCIA_CONDUCIR>'||
			'<CGINF_ESTADO_LABORAL>'||COALESCE(NEW.CGINF_ESTADO_LABORAL, '')||'</CGINF_ESTADO_LABORAL>'||
			'<CGINF_HIJOS>'||COALESCE(NEW.CGINF_HIJOS, 0)||'</CGINF_HIJOS>'||
			'<CGINF_GESTION_EMPLEO>'||COALESCE(NEW.CGINF_GESTION_EMPLEO, '')||'</CGINF_GESTION_EMPLEO>'||
			'<CGINF_FECHA_GESTION_EMPLEO>'||COALESCE(NEW.CGINF_FECHA_GESTION_EMPLEO, CURRENT_TIMESTAMP)||'</CGINF_FECHA_GESTION_EMPLEO>'||
			'<CGINF_OBSERVACIONES>'||COALESCE(NEW.CGINF_OBSERVACIONES, '')||'</CGINF_OBSERVACIONES>'||
			'<CGINF_ESTADO>'||COALESCE(NEW.CGINF_ESTADO, FALSE)||'</CGINF_ESTADO>'||
			'<CGINF_FECHA_INSERT>'||COALESCE(NEW.CGINF_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CGINF_FECHA_INSERT>'||
			'<CGINF_USUARIO_INSERT>'||COALESCE(NEW.CGINF_USUARIO_INSERT, '')||'</CGINF_USUARIO_INSERT>'||
			'<CGINF_FECHA_UPDATE>'||COALESCE(NEW.CGINF_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CGINF_FECHA_UPDATE>'||
			'<CGINF_USUARIO_UPDATE>'||COALESCE(NEW.CGINF_USUARIO_UPDATE, '')||'</CGINF_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_GEM_INFORMACION_LABORAL. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_GEM_INFORMACION_LABORAL
*/
CREATE TRIGGER TRG_AUD_CGG_GEM_INFORMACION_LABORAL AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_GEM_INFORMACION_LABORAL FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_GEM_INFORMACION_LABORAL();
COMMENT ON TRIGGER TRG_AUD_CGG_GEM_INFORMACION_LABORAL ON SII.CGG_GEM_INFORMACION_LABORAL IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_GEM_INFORMACION_LABORAL DISABLE TRIGGER TRG_AUD_CGG_GEM_INFORMACION_LABORAL;

