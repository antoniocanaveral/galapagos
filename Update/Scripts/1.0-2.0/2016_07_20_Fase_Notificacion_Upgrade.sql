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


--->>> CORREOS

INSERT INTO sii.cgg_not_mail (ntml_codigo, ntml_name, ntml_description, ntml_subject, ntml_type, ntml_body, ntml_sendheader, ntml_sendfooter, ntml_header_override, ntml_footer_override, ntml_estado, ntml_fecha_insert, ntml_usuario_insert, ntml_fecha_update, ntml_usuario_update) VALUES ('NTML1', 'Solicitud Exitosa', 'Generación de solicitud de residencia', '[PRUEBA! POR FAVOR DESCARTAR] Generación de solicitud de residencia', 'html', '<p style="margin: 0 0 5px;">Estimado Se&ntilde;or(a)</p>
<p style="margin: 0 0 16px; text-align: left; color: #737373">@$AUSPICIANTE@</p>
<p style="margin: 0 0 16px;">Con fecha @T:crtra_fecha_recepcion@ se ha generado la solicitud de residencia con los siguientes datos:</p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos de la solicitud</h3>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>No Trámite:</strong> @T:crtra_anio@- @T:crtra_numero@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Tipo Residencia:</strong> @$TIPO_RESIDENCIA@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Motivo Residencia:</strong> @T:crtst_codigo;cgg_res_tipo_solicitud_tramite.crtst_descripcion@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Actividad:</strong> @T:crtra_actividad_residencia;cgg_gem_cargo.cgcrg_nombre@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Detalle Actividad:</strong> @T:crtra_observacion@
    </p>
</div>

<p style="margin: 0 0 16px;"></p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos del Auspiciante</h3>
	<p style="margin: 0 0 16px; padding-left: 16px;">
		<strong>Nombres:</strong> @$AUSPICIANTE@
	</p>
</div>

<p style="margin: 0 0 16px;"></p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos del Beneficiario</h3>
	<p style="margin: 0 0 16px; padding-left: 16px;">
		<strong>Nombres:</strong> @$BENEFICIARIO@
	</p>
	<p style="margin: 0 0 16px; padding-left: 16px;">
		<strong>N&uacute;mero de Identificaci&oacute;n:</strong> @$BENEFICIARIO_ID@
	</p>
</div>

<p style="margin: 0 0 50px;"></p>

<p style="margin: 0px 0px 8px; font-size: 12px;">Declaro que los datos registrados son correctos y reales</p>
<p style="font-size: 12px;">
	<strong>Nota:</strong> Por favor verificar si los datos registrados están correctos, caso contrario agradeceríamos se acerque a las oficinas de Control de Residencia y notifique para la anulación de la solicitud.
</p>', true, true, null, null, true, '2016-07-04 16:53:14.783784', 'admin', '2016-07-04 16:53:14.783784', 'admin');

INSERT INTO sii.cgg_not_mail (ntml_codigo, ntml_name, ntml_description, ntml_subject, ntml_type, ntml_body, ntml_sendheader, ntml_sendfooter, ntml_header_override, ntml_footer_override, ntml_estado, ntml_fecha_insert, ntml_usuario_insert, ntml_fecha_update, ntml_usuario_update) VALUES ('NTML2', 'Recepción Exitosa', 'Recepción de solicitud de residencia', '[PRUEBA! POR FAVOR DESCARTAR] Recepción de solicitud de residencia', 'html', '<p style="margin: 0 0 5px;">Estimado Se&ntilde;or(a)</p>
<p style="margin: 0 0 16px; text-align: left; color: #737373">@$AUSPICIANTE@</p>
<p style="margin: 0 0 16px;">Con fecha @T:crtra_fecha_recepcion@ se ha generado la solicitud de residencia con los siguientes datos:</p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos de la solicitud</h3>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>No Trámite:</strong> @T:crtra_anio@- @T:crtra_numero@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Tipo Residencia:</strong> @$TIPO_RESIDENCIA@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Motivo Residencia:</strong> @T:crtst_codigo;cgg_res_tipo_solicitud_tramite.crtst_descripcion@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Actividad:</strong> @T:crtra_actividad_residencia;cgg_gem_cargo.cgcrg_nombre@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Detalle Actividad:</strong> @T:crtra_observacion@
    </p>
</div>

<p style="margin: 0 0 16px;"></p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos del Auspiciante</h3>
	<p style="margin: 0 0 16px; padding-left: 16px;">
		<strong>Nombres:</strong> @$AUSPICIANTE@
	</p>
</div>

<p style="margin: 0 0 16px;"></p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos del Beneficiario</h3>
	<p style="margin: 0 0 16px; padding-left: 16px;">
		<strong>Nombres:</strong> @$BENEFICIARIO@
	</p>
	<p style="margin: 0 0 16px; padding-left: 16px;">
		<strong>N&uacute;mero de Identificaci&oacute;n:</strong> @$BENEFICIARIO_ID@
	</p>
</div>

<p style="margin: 0 0 50px;"></p>

<p style="margin: 0px 0px 8px; font-size: 12px;">Declaro que los datos registrados son correctos y reales</p>
<p style="font-size: 12px;">
	<strong>Nota:</strong> Por favor verificar si los datos registrados están correctos, caso contrario agradeceríamos se acerque a las oficinas de Control de Residencia y notifique para la anulación de la solicitud.
</p>', true, true, null, null, true, '2016-07-04 16:53:14.783784', 'admin', '2016-07-04 16:53:14.783784', 'admin');


--->>>> CORREO PARA SUSCRIPCION
INSERT INTO sii.cgg_not_mail (ntml_codigo, ntml_name, ntml_description, ntml_subject, ntml_type, ntml_body, ntml_sendheader, ntml_sendfooter, ntml_header_override,
  ntml_footer_override, ntml_estado, ntml_fecha_insert, ntml_usuario_insert, ntml_fecha_update, ntml_usuario_update)
VALUES ('NTML3', 'Correo Suscripción', 'Correo con información de suscripción del usuario', '[PRUEBA! POR FAVOR DESCARTAR] Cuenta de Acceso', 'html',
'Bienvenido al SII.<br/> Su cuenta de acceso es <strong>$CUSU_NOMBRE_USUARIO</strong> su password <strong>$CUSU_PASSWORD</strong>.</br> Para disfrutar de los nuevos servicios por favor visite $CUSU_URL.', true, true, null, null, true, '2016-07-04 16:53:14.783784', 'admin', '2016-07-04 16:53:14.783784', 'admin');

INSERT INTO Cgg_configuracion VALUES('CONF200','Cgg_not_correo codigo para Suscripcion de Usuarios','NTML3',0,null,true,current_timestamp,'admin',current_timestamp,'admin');


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','MEJORAS FASE NOTIFICACION','Mejoras en Envío de Correos',
	'2.0','2016_07_20_Fase_Notificacion_Upgrade.sql',true);