/**
* FUNCION SII.TRG_KG_CGG_DHU_BECA. REGISTRA LA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_BECA
*/
CREATE OR REPLACE FUNCTION SII.TRG_AUD_CGG_DHU_BECA() RETURNS TRIGGER AS
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
		TMP_USUARIO = NEW.CDBEC_USUARIO_INSERT;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDBEC_USUARIO_INSERT;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
	ELSIF (TG_OP = 'UPDATE') THEN
		TMP_USUARIO = NEW.CDBEC_USUARIO_UPDATE;
		SELECT CUSU_CODIGO INTO TMP_CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = NEW.CDBEC_USUARIO_UPDATE;
		SELECT CSSSN_IP, CSSSN_ID INTO TMP_IP, TMP_SESSION_ID FROM SII.CGG_SEC_SESION WHERE CUSU_CODIGO = TMP_CUSU_CODIGO AND CSSSN_ACTIVO = TRUE;
		TMP_DATO_ANTIGUO = '<'||TG_TABLE_NAME||'>'||
			'<CDBEC_CODIGO>'||COALESCE(OLD.CDBEC_CODIGO, '')||'</CDBEC_CODIGO>'||
			'<CDTBC_CODIGO>'||COALESCE(OLD.CDTBC_CODIGO, '')||'</CDTBC_CODIGO>'||
			'<CGESP_CODIGO>'||COALESCE(OLD.CGESP_CODIGO, '')||'</CGESP_CODIGO>'||
			'<CGIED_CODIGO>'||COALESCE(OLD.CGIED_CODIGO, '')||'</CGIED_CODIGO>'||
			'<CPAIS_CODIGO>'||COALESCE(OLD.CPAIS_CODIGO, '')||'</CPAIS_CODIGO>'||
			'<CGTPR_CODIGO>'||COALESCE(OLD.CGTPR_CODIGO, '')||'</CGTPR_CODIGO>'||
			'<CRPER_CODIGO>'||COALESCE(OLD.CRPER_CODIGO, '')||'</CRPER_CODIGO>'||
			'<CGG_CRPER_CODIGO>'||COALESCE(OLD.CGG_CRPER_CODIGO, '')||'</CGG_CRPER_CODIGO>'||
			'<CRPJR_CODIGO>'||COALESCE(OLD.CRPJR_CODIGO, '')||'</CRPJR_CODIGO>'||
			'<CDBEC_NUMERO>'||COALESCE(OLD.CDBEC_NUMERO, '')||'</CDBEC_NUMERO>'||
			'<CDBEC_FECHA_INGRESO>'||COALESCE(OLD.CDBEC_FECHA_INGRESO, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_INGRESO>'||
			'<CDBEC_FUNCIONARIO>'||COALESCE(OLD.CDBEC_FUNCIONARIO, '')||'</CDBEC_FUNCIONARIO>'||
			'<CDBEC_NUMERO_APROBACION>'||COALESCE(OLD.CDBEC_NUMERO_APROBACION, '')||'</CDBEC_NUMERO_APROBACION>'||
			'<CDBEC_FECHA_INICIO>'||COALESCE(OLD.CDBEC_FECHA_INICIO, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_INICIO>'||
			'<CDBEC_FECHA_FIN>'||COALESCE(OLD.CDBEC_FECHA_FIN, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_FIN>'||
			'<CDBEC_NUMERO_CONVENIO>'||COALESCE(OLD.CDBEC_NUMERO_CONVENIO, '')||'</CDBEC_NUMERO_CONVENIO>'||
			'<CDBEC_VSALIDA_ORIGEN>'||COALESCE(OLD.CDBEC_VSALIDA_ORIGEN, '')||'</CDBEC_VSALIDA_ORIGEN>'||
			'<CDBEC_VSALIDA_DESTINO>'||COALESCE(OLD.CDBEC_VSALIDA_DESTINO, '')||'</CDBEC_VSALIDA_DESTINO>'||
			'<CDBEC_VSALIDA_VALOR>'||COALESCE(OLD.CDBEC_VSALIDA_VALOR, 0)||'</CDBEC_VSALIDA_VALOR>'||
			'<CDBEC_VRETORNO_ORIGEN>'||COALESCE(OLD.CDBEC_VRETORNO_ORIGEN, '')||'</CDBEC_VRETORNO_ORIGEN>'||
			'<CDBEC_VRETORNO_DESTINO>'||COALESCE(OLD.CDBEC_VRETORNO_DESTINO, '')||'</CDBEC_VRETORNO_DESTINO>'||
			'<CDBEC_VRETORNO_VALOR>'||COALESCE(OLD.CDBEC_VRETORNO_VALOR, 0)||'</CDBEC_VRETORNO_VALOR>'||
			'<CDBEC_CARRERA>'||COALESCE(OLD.CDBEC_CARRERA, '')||'</CDBEC_CARRERA>'||
			'<CDBEC_TIPO_CICLO>'||COALESCE(OLD.CDBEC_TIPO_CICLO, 0)||'</CDBEC_TIPO_CICLO>'||
			'<CDBEC_TOTAL_CICLOS>'||COALESCE(OLD.CDBEC_TOTAL_CICLOS, 0)||'</CDBEC_TOTAL_CICLOS>'||
			'<CDBEC_NUMERO_CUENTO>'||COALESCE(OLD.CDBEC_NUMERO_CUENTO, '')||'</CDBEC_NUMERO_CUENTO>'||
			'<CDBEC_NUMERO_APROBACION_MODIFIC>'||COALESCE(OLD.CDBEC_NUMERO_APROBACION_MODIFICATORIO, '')||'</CDBEC_NUMERO_APROBACION_MODIFIC>'||
			'<CDBEC_NUMERO_CONTRATO_MODIFICAT>'||COALESCE(OLD.CDBEC_NUMERO_CONTRATO_MODIFICATOTIO, '')||'</CDBEC_NUMERO_CONTRATO_MODIFICAT>'||
			'<CDBEC_OBSERVACION_CONTRATO_MODI>'||COALESCE(OLD.CDBEC_OBSERVACION_CONTRATO_MODIFICATORIO, '')||'</CDBEC_OBSERVACION_CONTRATO_MODI>'||
			'<CDBEC_OBSERVACION>'||COALESCE(OLD.CDBEC_OBSERVACION, '')||'</CDBEC_OBSERVACION>'||
			'<CDBEC_TITULO_ENTREGADO>'||COALESCE(OLD.CDBEC_TITULO_ENTREGADO, FALSE)||'</CDBEC_TITULO_ENTREGADO>'||
			'<CDBEC_BECA_DEVENGADA>'||COALESCE(OLD.CDBEC_BECA_DEVENGADA, FALSE)||'</CDBEC_BECA_DEVENGADA>'||
			'<CDBEC_ESTADO_APROBACION>'||COALESCE(OLD.CDBEC_ESTADO_APROBACION, 0)||'</CDBEC_ESTADO_APROBACION>'||
			'<CDBEC_VALOR_REEMBOLSO>'||COALESCE(OLD.CDBEC_VALOR_REEMBOLSO, 0)||'</CDBEC_VALOR_REEMBOLSO>'||
			'<CDBEC_ESTADO>'||COALESCE(OLD.CDBEC_ESTADO, FALSE)||'</CDBEC_ESTADO>'||
			'<CDBEC_FECHA_INSERT>'||COALESCE(OLD.CDBEC_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_INSERT>'||
			'<CDBEC_USUARIO_INSERT>'||COALESCE(OLD.CDBEC_USUARIO_INSERT, '')||'</CDBEC_USUARIO_INSERT>'||
			'<CDBEC_FECHA_UPDATE>'||COALESCE(OLD.CDBEC_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_UPDATE>'||
			'<CDBEC_USUARIO_UPDATE>'||COALESCE(OLD.CDBEC_USUARIO_UPDATE, '')||'</CDBEC_USUARIO_UPDATE>'||
		'</'||TG_TABLE_NAME||'>';
	ELSIF (TG_OP = 'DELETE') THEN
		SELECT INET_CLIENT_ADDR() INTO TMP_IP;
		SELECT SESSION_USER INTO TMP_SESSION_ID;
	END IF;

	IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
		TMP_DATO_NUEVO = '<'||TG_TABLE_NAME||'>'||
			'<CDBEC_CODIGO>'||COALESCE(NEW.CDBEC_CODIGO, '')||'</CDBEC_CODIGO>'||
			'<CDTBC_CODIGO>'||COALESCE(NEW.CDTBC_CODIGO, '')||'</CDTBC_CODIGO>'||
			'<CGESP_CODIGO>'||COALESCE(NEW.CGESP_CODIGO, '')||'</CGESP_CODIGO>'||
			'<CGIED_CODIGO>'||COALESCE(NEW.CGIED_CODIGO, '')||'</CGIED_CODIGO>'||
			'<CPAIS_CODIGO>'||COALESCE(NEW.CPAIS_CODIGO, '')||'</CPAIS_CODIGO>'||
			'<CGTPR_CODIGO>'||COALESCE(NEW.CGTPR_CODIGO, '')||'</CGTPR_CODIGO>'||
			'<CRPER_CODIGO>'||COALESCE(NEW.CRPER_CODIGO, '')||'</CRPER_CODIGO>'||
			'<CGG_CRPER_CODIGO>'||COALESCE(NEW.CGG_CRPER_CODIGO, '')||'</CGG_CRPER_CODIGO>'||
			'<CRPJR_CODIGO>'||COALESCE(NEW.CRPJR_CODIGO, '')||'</CRPJR_CODIGO>'||
			'<CDBEC_NUMERO>'||COALESCE(NEW.CDBEC_NUMERO, '')||'</CDBEC_NUMERO>'||
			'<CDBEC_FECHA_INGRESO>'||COALESCE(NEW.CDBEC_FECHA_INGRESO, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_INGRESO>'||
			'<CDBEC_FUNCIONARIO>'||COALESCE(NEW.CDBEC_FUNCIONARIO, '')||'</CDBEC_FUNCIONARIO>'||
			'<CDBEC_NUMERO_APROBACION>'||COALESCE(NEW.CDBEC_NUMERO_APROBACION, '')||'</CDBEC_NUMERO_APROBACION>'||
			'<CDBEC_FECHA_INICIO>'||COALESCE(NEW.CDBEC_FECHA_INICIO, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_INICIO>'||
			'<CDBEC_FECHA_FIN>'||COALESCE(NEW.CDBEC_FECHA_FIN, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_FIN>'||
			'<CDBEC_NUMERO_CONVENIO>'||COALESCE(NEW.CDBEC_NUMERO_CONVENIO, '')||'</CDBEC_NUMERO_CONVENIO>'||
			'<CDBEC_VSALIDA_ORIGEN>'||COALESCE(NEW.CDBEC_VSALIDA_ORIGEN, '')||'</CDBEC_VSALIDA_ORIGEN>'||
			'<CDBEC_VSALIDA_DESTINO>'||COALESCE(NEW.CDBEC_VSALIDA_DESTINO, '')||'</CDBEC_VSALIDA_DESTINO>'||
			'<CDBEC_VSALIDA_VALOR>'||COALESCE(NEW.CDBEC_VSALIDA_VALOR, 0)||'</CDBEC_VSALIDA_VALOR>'||
			'<CDBEC_VRETORNO_ORIGEN>'||COALESCE(NEW.CDBEC_VRETORNO_ORIGEN, '')||'</CDBEC_VRETORNO_ORIGEN>'||
			'<CDBEC_VRETORNO_DESTINO>'||COALESCE(NEW.CDBEC_VRETORNO_DESTINO, '')||'</CDBEC_VRETORNO_DESTINO>'||
			'<CDBEC_VRETORNO_VALOR>'||COALESCE(NEW.CDBEC_VRETORNO_VALOR, 0)||'</CDBEC_VRETORNO_VALOR>'||
			'<CDBEC_CARRERA>'||COALESCE(NEW.CDBEC_CARRERA, '')||'</CDBEC_CARRERA>'||
			'<CDBEC_TIPO_CICLO>'||COALESCE(NEW.CDBEC_TIPO_CICLO, 0)||'</CDBEC_TIPO_CICLO>'||
			'<CDBEC_TOTAL_CICLOS>'||COALESCE(NEW.CDBEC_TOTAL_CICLOS, 0)||'</CDBEC_TOTAL_CICLOS>'||
			'<CDBEC_NUMERO_CUENTO>'||COALESCE(NEW.CDBEC_NUMERO_CUENTO, '')||'</CDBEC_NUMERO_CUENTO>'||
			'<CDBEC_NUMERO_APROBACION_MODIFIC>'||COALESCE(NEW.CDBEC_NUMERO_APROBACION_MODIFIC, '')||'</CDBEC_NUMERO_APROBACION_MODIFIC>'||
			'<CDBEC_NUMERO_CONTRATO_MODIFICAT>'||COALESCE(NEW.CDBEC_NUMERO_CONTRATO_MODIFICAT, '')||'</CDBEC_NUMERO_CONTRATO_MODIFICAT>'||
			'<CDBEC_OBSERVACION_CONTRATO_MODI>'||COALESCE(NEW.CDBEC_OBSERVACION_CONTRATO_MODI, '')||'</CDBEC_OBSERVACION_CONTRATO_MODI>'||
			'<CDBEC_OBSERVACION>'||COALESCE(NEW.CDBEC_OBSERVACION, '')||'</CDBEC_OBSERVACION>'||
			'<CDBEC_TITULO_ENTREGADO>'||COALESCE(NEW.CDBEC_TITULO_ENTREGADO, FALSE)||'</CDBEC_TITULO_ENTREGADO>'||
			'<CDBEC_BECA_DEVENGADA>'||COALESCE(NEW.CDBEC_BECA_DEVENGADA, FALSE)||'</CDBEC_BECA_DEVENGADA>'||
			'<CDBEC_ESTADO_APROBACION>'||COALESCE(NEW.CDBEC_ESTADO_APROBACION, 0)||'</CDBEC_ESTADO_APROBACION>'||
			'<CDBEC_VALOR_REEMBOLSO>'||COALESCE(NEW.CDBEC_VALOR_REEMBOLSO, 0)||'</CDBEC_VALOR_REEMBOLSO>'||
			'<CDBEC_ESTADO>'||COALESCE(NEW.CDBEC_ESTADO, FALSE)||'</CDBEC_ESTADO>'||
			'<CDBEC_FECHA_INSERT>'||COALESCE(NEW.CDBEC_FECHA_INSERT, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_INSERT>'||
			'<CDBEC_USUARIO_INSERT>'||COALESCE(NEW.CDBEC_USUARIO_INSERT, '')||'</CDBEC_USUARIO_INSERT>'||
			'<CDBEC_FECHA_UPDATE>'||COALESCE(NEW.CDBEC_FECHA_UPDATE, CURRENT_TIMESTAMP)||'</CDBEC_FECHA_UPDATE>'||
			'<CDBEC_USUARIO_UPDATE>'||COALESCE(NEW.CDBEC_USUARIO_UPDATE, '')||'</CDBEC_USUARIO_UPDATE>'||
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
* DISPARADOR TRG_KG_CGG_DHU_BECA. REGISTRA UNA BITACORA DE LAS ACTIVIDADES REALIZADAS SOBRE LA INFORMACION ALMACENADA EN LA TABLA SII.CGG_DHU_BECA
*/
CREATE TRIGGER TRG_AUD_CGG_DHU_BECA AFTER INSERT OR UPDATE OR DELETE ON SII.CGG_DHU_BECA FOR EACH ROW EXECUTE PROCEDURE SII.TRG_AUD_CGG_DHU_BECA();
COMMENT ON TRIGGER TRG_AUD_CGG_DHU_BECA ON SII.CGG_DHU_BECA IS 'DISPARADOR DE AUDITORIA DE LOS DATOS';
ALTER TABLE SII.CGG_DHU_BECA DISABLE TRIGGER TRG_AUD_CGG_DHU_BECA;

