ALTER TABLE sii.cgg_not_fase_notification ADD COLUMN NTFN_TIPO_SOLICITUD character varying;
ALTER TABLE sii.cgg_not_fase_notification ADD COLUMN NTFN_RESPUESTA_FASE character varying;

CREATE OR REPLACE FUNCTION sii.f_cgg_not_fase_notification_select(in_CRFAS_CODIGO character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		crpro_codigo,
		crfas_codigo,
		ntml_codigo,
		ntfn_destinatario,
		ntfn_estado,
		NTFN_TIPO_SOLICITUD,
		NTFN_RESPUESTA_FASE,
		ntfn_fecha_insert,
		ntfn_usuario_insert,
		ntfn_fecha_update,
		ntfn_usuario_update
	FROM SII.cgg_not_fase_notification
	WHERE ntfn_estado = TRUE AND
		CRFAS_CODIGO = in_CRFAS_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

CREATE OR REPLACE FUNCTION sii.f_cgg_not_fase_notification_insert(in_crpro_codigo character varying,in_crfas_codigo character varying,
          in_ntml_codigo character varying,in_ntfn_destinatario character varying, in_ntfn_estado boolean,
          in_ntfn_usuario_update character varying,in_ntfn_usuario_insert character varying,in_NTFN_TIPO_SOLICITUD character varying,in_NTFN_RESPUESTA_FASE character varying)
  RETURNS void AS
$BODY$
BEGIN
	INSERT INTO SII.cgg_not_fase_notification (
	  CRPRO_CODIGO,
		CRFAS_CODIGO,
		ntml_codigo,
		ntfn_destinatario,
		ntfn_estado,
		ntfn_fecha_insert,
		ntfn_usuario_insert,
		ntfn_fecha_update,
		ntfn_usuario_update,
		NTFN_TIPO_SOLICITUD,
		NTFN_RESPUESTA_FASE) VALUES(
		  in_crpro_codigo,in_crfas_codigo,in_ntml_codigo,in_ntfn_destinatario, in_ntfn_estado, CURRENT_TIMESTAMP, in_ntfn_usuario_insert,CURRENT_TIMESTAMP,in_ntfn_usuario_update,
		  in_NTFN_TIPO_SOLICITUD,in_NTFN_RESPUESTA_FASE
		);
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','MEJORAS FASE NOTIFICACION','Mejoras en Envío de Correos',
	'2.0','2016_07_20_Fase_Notificacion_Upgrade.sql',true);