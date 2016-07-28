ALTER TABLE sii.cgg_res_tramite ADD COLUMN REP_CRPER_CODIGO character varying(20);
COMMENT ON COLUMN sii.cgg_res_tramite.REP_CRPER_CODIGO IS 'IDENTIFICATIVO UNICO DE REGISTRO DE LA PERSONA REPRESENTANTE EN TEMPORALES';



-- Function: sii.f_cgg_res_tramite_insert_1(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, numeric, numeric, timestamp with time zone, character varying, text, smallint, smallint, text, boolean, character varying, character varying, numeric, timestamp with time zone, boolean, character varying, character varying)

-- DROP FUNCTION sii.f_cgg_res_tramite_insert_1(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, numeric, numeric, timestamp with time zone, character varying, text, smallint, smallint, text, boolean, character varying, character varying, numeric, timestamp with time zone, boolean, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_tramite_insert_1(in_crtra_codigo character varying, in_crper_codigo character varying, in_crpjr_codigo character varying,
  in_cgg_crper_codigo character varying, in_crpro_codigo character varying, in_crtst_codigo character varying, in_cvveh_codigo character varying, in_crett_codigo character varying,
  in_cisla_codigo character varying, in_cvmtr_codigo character varying, in_cgg_cvmtr_codigo character varying, in_cgg_cvveh_codigo character varying, in_crtra_anio numeric,
  in_crtra_numero numeric, in_crtra_fecha_recepcion timestamp with time zone, in_crtra_actividad_residencia character varying, in_crtra_observacion text,
  in_crtra_dias_permanencia smallint, in_crtra_pendiente smallint, in_crtra_observacion_pendiente text, in_crtra_atencion_cliente boolean, in_crtra_comunicado_radial character varying,
  in_crtra_motivo character varying, in_crtra_folio numeric, in_crtra_fecha_salida timestamp with time zone, in_crtra_estado boolean, in_crtra_usuario_insert character varying,
  in_crtra_usuario_update character varying, in_rep_crper_codigo character varying)
  RETURNS character varying AS
$BODY$
DECLARE
OUT_KEY VARCHAR;
OUT_NUM NUMERIC;
OUT_RESULT VARCHAR;
BEGIN
	IF (UPPER(IN_CRTRA_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_TRAMITE','CRTRA_CODIGO','CRTRA') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRTRA_CODIGO;
	END IF;

	IF(IN_CRTRA_NUMERO = 0)THEN
		SELECT SII.F_NUMERO('CGG_RES_TRAMITE','CRTRA_NUMERO','CRTRA_ANIO') INTO OUT_NUM;
	ELSE
		OUT_NUM := IN_CRTRA_NUMERO;
	END IF;

	INSERT INTO SII.CGG_RES_TRAMITE(
		CRTRA_CODIGO,
		CRPER_CODIGO,
		CRPJR_CODIGO,
		CGG_CRPER_CODIGO,
		CRPRO_CODIGO,
		CRTST_CODIGO,
		CVVEH_CODIGO,
		CRETT_CODIGO,
		CISLA_CODIGO,
		CVMTR_CODIGO,
		CGG_CVMTR_CODIGO,
		CGG_CVVEH_CODIGO,
		CRTRA_ANIO,
		CRTRA_NUMERO,
		CRTRA_FECHA_RECEPCION,
		CRTRA_ACTIVIDAD_RESIDENCIA,
		CRTRA_OBSERVACION,
		CRTRA_DIAS_PERMANENCIA,
		CRTRA_PENDIENTE,
		CRTRA_OBSERVACION_PENDIENTE,
		CRTRA_ATENCION_CLIENTE,
		CRTRA_COMUNICADO_RADIAL,
		CRTRA_MOTIVO,
		CRTRA_FOLIO,
	    CRTRA_FECHA_SALIDA,
		CRTRA_ESTADO,
		CRTRA_FECHA_INSERT,
		CRTRA_USUARIO_INSERT,
		CRTRA_FECHA_UPDATE,
		CRTRA_USUARIO_UPDATE,
		REP_CRPER_CODIGO
	) VALUES (
		OUT_KEY,
		IN_CRPER_CODIGO,
		IN_CRPJR_CODIGO,
		IN_CGG_CRPER_CODIGO,
		IN_CRPRO_CODIGO,
		IN_CRTST_CODIGO,
		IN_CVVEH_CODIGO,
		IN_CRETT_CODIGO,
		IN_CISLA_CODIGO,
		IN_CVMTR_CODIGO,
		IN_CGG_CVMTR_CODIGO,
		IN_CGG_CVVEH_CODIGO,
		IN_CRTRA_ANIO,
		OUT_NUM,
		IN_CRTRA_FECHA_RECEPCION,
		IN_CRTRA_ACTIVIDAD_RESIDENCIA,
		IN_CRTRA_OBSERVACION,
		IN_CRTRA_DIAS_PERMANENCIA,
		IN_CRTRA_PENDIENTE,
		IN_CRTRA_OBSERVACION_PENDIENTE,
		IN_CRTRA_ATENCION_CLIENTE,
		IN_CRTRA_COMUNICADO_RADIAL,
		IN_CRTRA_MOTIVO,
		IN_CRTRA_FOLIO,
		IN_CRTRA_FECHA_SALIDA,
		IN_CRTRA_ESTADO,
		CURRENT_TIMESTAMP,
		IN_CRTRA_USUARIO_INSERT,
		CURRENT_TIMESTAMP,
		IN_CRTRA_USUARIO_UPDATE,
		IN_REP_CRPER_CODIGO
	);
	OUT_RESULT:=OUT_KEY||','||OUT_NUM;
	RETURN OUT_RESULT;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION sii.f_cgg_res_tramite_update(in_crtra_codigo character varying, in_crper_codigo character varying, in_crpjr_codigo character varying, in_cgg_crper_codigo character varying, in_crpro_codigo character varying,
in_crtst_codigo character varying, in_cvveh_codigo character varying, in_crett_codigo character varying, in_cisla_codigo character varying, in_cvmtr_codigo character varying, in_cgg_cvmtr_codigo character varying,
in_cgg_cvveh_codigo character varying, in_crtra_anio numeric, in_crtra_numero numeric, in_crtra_fecha_recepcion timestamp with time zone, in_crtra_actividad_residencia character varying, in_crtra_observacion text,
in_crtra_dias_permanencia smallint, in_crtra_pendiente smallint, in_crtra_observacion_pendiente text, in_crtra_atencion_cliente boolean, in_crtra_comunicado_radial character varying, in_crtra_motivo character varying,
in_crtra_folio numeric, in_crtra_grupo boolean, in_crtra_orden numeric, in_crtra_fecha_ingreso timestamp with time zone, in_crtra_fecha_salida timestamp with time zone, in_crtra_estado boolean, in_crtra_usuario_update character varying, in_rep_crper_codigo character varying)
  RETURNS void AS
$BODY$
BEGIN
	UPDATE SII.CGG_RES_TRAMITE SET
		CRPER_CODIGO = IN_CRPER_CODIGO,
		CRPJR_CODIGO = IN_CRPJR_CODIGO,
		CGG_CRPER_CODIGO = IN_CGG_CRPER_CODIGO,
		CRPRO_CODIGO = IN_CRPRO_CODIGO,
		CRTST_CODIGO = IN_CRTST_CODIGO,
		CVVEH_CODIGO = IN_CVVEH_CODIGO,
		CRETT_CODIGO = IN_CRETT_CODIGO,
		CISLA_CODIGO = IN_CISLA_CODIGO,
		CVMTR_CODIGO = IN_CVMTR_CODIGO,
		CGG_CVMTR_CODIGO = IN_CGG_CVMTR_CODIGO,
		CGG_CVVEH_CODIGO = IN_CGG_CVVEH_CODIGO,
		CRTRA_ANIO = IN_CRTRA_ANIO,
		CRTRA_NUMERO = IN_CRTRA_NUMERO,
		CRTRA_FECHA_RECEPCION = IN_CRTRA_FECHA_RECEPCION,
		CRTRA_ACTIVIDAD_RESIDENCIA = IN_CRTRA_ACTIVIDAD_RESIDENCIA,
		CRTRA_OBSERVACION = IN_CRTRA_OBSERVACION,
		CRTRA_DIAS_PERMANENCIA = IN_CRTRA_DIAS_PERMANENCIA,
		CRTRA_PENDIENTE = IN_CRTRA_PENDIENTE,
		CRTRA_OBSERVACION_PENDIENTE = IN_CRTRA_OBSERVACION_PENDIENTE,
		CRTRA_ATENCION_CLIENTE = IN_CRTRA_ATENCION_CLIENTE,
		CRTRA_COMUNICADO_RADIAL = IN_CRTRA_COMUNICADO_RADIAL,
		CRTRA_MOTIVO = IN_CRTRA_MOTIVO,
		CRTRA_FOLIO = IN_CRTRA_FOLIO,
		CRTRA_GRUPO = IN_CRTRA_GRUPO,
		CRTRA_ORDEN = IN_CRTRA_ORDEN,
		CRTRA_FECHA_INGRESO = IN_CRTRA_FECHA_INGRESO,
		CRTRA_FECHA_SALIDA = IN_CRTRA_FECHA_SALIDA,
		CRTRA_ESTADO = IN_CRTRA_ESTADO,
		CRTRA_FECHA_UPDATE = CURRENT_TIMESTAMP,
		CRTRA_USUARIO_UPDATE = IN_CRTRA_USUARIO_UPDATE,
		REP_CRPER_CODIGO = IN_REP_CRPER_CODIGO
	WHERE
		CRTRA_CODIGO = IN_CRTRA_CODIGO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','REPRESENTANTE EN TRAMITES','Representante para Tramites de temporales',
	'2.0','2016_07_27_Tramite_Representante.sql',true);