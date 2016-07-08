CREATE TABLE sii.cgg_not_mail
(
   ntml_codigo character varying NOT NULL PRIMARY KEY,
   ntml_name character varying NOT NULL,
   ntml_description character varying,
   ntml_subject character varying NOT NULL,
   ntml_type character varying NOT NULL DEFAULT 'text',
   ntml_body character varying,
   ntml_sendheader boolean DEFAULT false,
   ntml_sendfooter boolean DEFAULT false,
   ntml_header_override character varying,
   ntml_footer_override character varying,
   ntml_estado boolean,
   ntml_fecha_insert timestamp,
   ntml_usuario_insert character varying(20),
   ntml_fecha_update timestamp,
   ntml_usuario_update character varying(20)
  );


CREATE OR REPLACE FUNCTION sii.f_cgg_not_mail_select_all()
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
  OPEN TMP_REF FOR
	SELECT
		ntml_codigo,
		ntml_name,
		ntml_description,
		ntml_subject,
		ntml_type,
		ntml_body,
		ntml_sendheader,
		ntml_sendfooter,
		ntml_header_override,
		ntml_footer_override,
		ntml_estado,
		ntml_fecha_insert,
		ntml_usuario_insert,
		ntml_fecha_update,
		ntml_usuario_update
	FROM SII.cgg_not_mail
	WHERE ntml_estado = TRUE;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


CREATE OR REPLACE FUNCTION sii.f_cgg_not_mail_selectByCode(in_NTML_CODIGO character VARYING )
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
  OPEN TMP_REF FOR
	SELECT
		ntml_codigo,
		ntml_name,
		ntml_description,
		ntml_subject,
		ntml_type,
		ntml_body,
		ntml_sendheader,
		ntml_sendfooter,
		ntml_header_override,
		ntml_footer_override,
		ntml_estado,
		ntml_fecha_insert,
		ntml_usuario_insert,
		ntml_fecha_update,
		ntml_usuario_update
	FROM SII.cgg_not_mail
	WHERE ntml_estado = TRUE
	AND ntml_codigo = in_NTML_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


CREATE TABLE sii.cgg_not_fase_notification
(
   ntml_codigo character varying NOT NULL,
   crfas_codigo character varying NOT NULL,
   crpro_codigo character varying NOT NULL,
   ntfn_destinatario character varying(5),
   ntfn_estado boolean,
   ntfn_fecha_insert timestamp,
   ntfn_usuario_insert character varying(20),
   ntfn_fecha_update timestamp,
   ntfn_usuario_update character varying(20)
);

ALTER TABLE sii.cgg_not_fase_notification ADD CONSTRAINT cgg_not_fase_notification_pk PRIMARY KEY (crpro_codigo, crfas_codigo, ntml_codigo, ntfn_destinatario);


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

CREATE OR REPLACE FUNCTION sii.f_cgg_not_fase_notification_delete(in_crpro_codigo character varying,in_crfas_codigo character varying,
          in_ntml_codigo character varying,in_ntfn_destinatario character varying)
  RETURNS void AS
$BODY$
BEGIN
	DELETE FROM SII.cgg_not_fase_notification
	WHERE CRPRO_CODIGO = in_crpro_codigo
		AND CRFAS_CODIGO = in_crfas_codigo
		AND ntml_codigo = in_ntml_codigo
		AND ntfn_destinatario = in_ntfn_destinatario
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION sii.f_cgg_not_fase_notification_insert(in_crpro_codigo character varying,in_crfas_codigo character varying,
          in_ntml_codigo character varying,in_ntfn_destinatario character varying, in_ntfn_estado boolean,
          in_ntfn_usuario_update character varying,in_ntfn_usuario_insert character varying)
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
		ntfn_usuario_update) VALUES(
		  in_crpro_codigo,in_crfas_codigo,in_ntml_codigo,in_ntfn_destinatario, in_ntfn_estado, CURRENT_TIMESTAMP, in_ntfn_usuario_insert,CURRENT_TIMESTAMP,in_ntfn_usuario_update
		);
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


INSERT INTO sii.cgg_not_mail(
            ntml_codigo, ntml_name, ntml_description, ntml_subject, ntml_type,
            ntml_body, ntml_sendheader, ntml_sendfooter, ntml_header_override,
            ntml_footer_override, ntml_estado, ntml_fecha_insert, ntml_usuario_insert,
            ntml_fecha_update, ntml_usuario_update)
    VALUES (sii.f_keygen('Cgg_Not_Mail','ntml_codigo','NTML'), 'Test Mail', 'Correo de Prueba', 'Sistema Integral C.G.G.', 'html',
            'Estimado @USER_NAME@ </br></br> Sirvase en atender el siguiente requerimiento', true, true, null,
            null, true, current_timestamp, 'admin',
            current_timestamp, 'admin');


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','FASE NOTIFICACION','Funcionalidad de Notificacion en las fases de los procesos.',
	'2.0','2016_07_04_Fase_Notificacion.sql',true);