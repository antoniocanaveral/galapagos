
--> AGREGAMOS CORREO Y APELLIDO MATERNO EN PERSONA TCT
CREATE OR REPLACE FUNCTION sii.f_cgg_res_persona_tramite_tct_select(
    in_crdid_codigo character varying,
    in_crper_num_doc_identific character varying,
    in_ctreg_fecha_ingreso timestamp with time zone)
  RETURNS refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
	TMP_CRTRA_NUMERO CHARACTER VARYING;
	TMP_CRTST_CODIGO VARCHAR;
BEGIN
	SELECT CGCNF_VALOR_CADENA INTO TMP_CRTST_CODIGO FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = '05';

	OPEN TMP_REF FOR
	SELECT
		PR.CRPER_CODIGO,
		PR.CRDID_CODIGO,
		(SELECT CRDID_DESCRIPCION FROM CGG_RES_DOCUMENTO_IDENTIFICACIO DI WHERE DI.CRDID_CODIGO = PR.CRDID_CODIGO) TIPO_DOCUMENTO,
		PR.CRPER_NUM_DOC_IDENTIFIC,
		PR.CRPER_NOMBRES,
		PR.CRPER_APELLIDO_PATERNO,
		PR.CRPER_GENERO,
		PR.CGNCN_CODIGO,
		(SELECT CGNCN_NACIONALIDAD FROM CGG_NACIONALIDAD ND WHERE ND.CGNCN_CODIGO = PR.CGNCN_CODIGO )  NACIONALIDAD,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CGG_CPAIS_CODIGO,
		(SELECT CPAIS_NOMBRE FROM CGG_PAIS PAI WHERE PAI.CPAIS_CODIGO = PR.CGG_CPAIS_CODIGO ) RESIDENCIA,
		PR.CRPER_ESTADO,
		RSA.CRTST_CODIGO,
		TRM.CRTRA_CODIGO,
		TRM.CRTRA_NUMERO,
		PR.CRPER_APELLIDO_MATERNO,
		PCON.CRPRC_CONTACTO
	FROM SII.CGG_RES_PERSONA PR
	LEFT JOIN SII.CGG_RES_RESIDENCIA RSA ON RSA.CRPER_CODIGO = PR.CRPER_CODIGO AND
		RSA.CRRSD_VIGENTE AND
		RSA.CRRSD_FECHA_INICIO::DATE = IN_CTREG_FECHA_INGRESO::DATE AND
		RSA.CRTST_CODIGO IN
		(WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO) AND
		RSA.CRRSD_ESTADO
	LEFT JOIN SII.CGG_RES_TRAMITE TRM ON TRM.CRTRA_CODIGO = RSA.CRTRA_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA_CONTACTO PCON ON PCON.CRPER_CODIGO = PR.CRPER_CODIGO AND CRTCO_CODIGO='CRTCO1'
	WHERE PR.CRPER_ESTADO AND
		CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC AND
		(PR.CRDID_CODIGO = IN_CRDID_CODIGO);
	RETURN TMP_REF ;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;



--CREAMOS LA TABLA DE ENCUESTAS, ITEMS DE ENCUESTA Y RESPUESTA DEL USUARIO.
--DROP TABLE sii.cgg_enc_pregunta;
--DROP TABLE sii.cgg_enc_item;

CREATE TABLE sii.cgg_enc_pregunta
(
   encpr_codigo character varying PRIMARY KEY,
   encpr_descripcion character varying NOT NULL,
   encpr_categoria character varying,
   encpr_type character varying NOT NULL DEFAULT 'SCORE', -- SCORE, COMBO, TEXT, MULTI
   encpr_estado boolean DEFAULT TRUE , -- ESTADO DEL REGISTRO
   encpr_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
   encpr_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
   encpr_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
   encpr_usuario_update character varying(20)
);

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR1','* ¿Qué motiva su viaje a Galápagos?','ENCUESTA_TCT','MULTI',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR2','* ¿Usted está viajando a Galápagos dentro de un tour organizado y contratado fuera de Galápagos?','ENCUESTA_TCT','COMBO',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR3','* ¿De dónde se informa de las actividades que realizará en Galápagos?','ENCUESTA_TCT','COMBO',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR4','* ¿Cuál?','ENCUESTA_TCT','TEXT',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR5',
  '* Califique con estrellas (1 menor valoración, 4 mayor valoración) qué tan importantes son los siguientes atractivos para su decisión de visitar Galápagos.','ENCUESTA_TCT','SCORE',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR6',
  '* Califique con estrellas (1 menor valoración, 4 mayor valoración) qué tan importantes son las siguientes actividades en su decisión de visitar Galápagos.','ENCUESTA_TCT','SCORE',
  true,current_timestamp,'admin',current_timestamp,'admin');

CREATE TABLE sii.cgg_enc_item
(
   encit_codigo character varying PRIMARY KEY,
   encpr_codigo character varying NOT NULL,
   encit_descripcion character varying NOT NULL,
   encit_estado boolean DEFAULT TRUE , -- ESTADO DEL REGISTRO
   encit_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
   encit_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
   encit_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
   encit_usuario_update character varying(20)
);
INSERT INTO sii.cgg_enc_item VALUES ('ENCIT1','ENCPR1','Turismo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES ('ENCIT2','ENCPR1','Negocios',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES ('ENCIT3','ENCPR1','Eventos Organizados',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES ('ENCIT4','ENCPR1','Servicios Religiosos',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES ('ENCIT5','ENCPR1','Visita Familiar o Amigo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES ('ENCIT6','ENCPR1','Investigación',true,current_timestamp,'admin',current_timestamp,'admin');

--ACTUALIZAMOS LA TABLA CGG_TCT_ACTIVIDAD POR COMPATIBILIDAD
UPDATE sii.cgg_tct_actividad SET CTACT_ESTADO = false;
INSERT INTO sii.cgg_tct_actividad VALUES ('ENCIT1','Turismo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_actividad VALUES ('ENCIT2','Negocios',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_actividad VALUES ('ENCIT3','Eventos Organizados',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_actividad VALUES ('ENCIT4','Servicios Religiosos',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_actividad VALUES ('ENCIT5','Visita Familiar o Amigo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_actividad VALUES ('ENCIT6','Investigación',true,current_timestamp,'admin',current_timestamp,'admin');


INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR2','Si',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR2','No',true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR3','Página Web',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR3','Agencia de Viajes',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR3','Revistas Especializadas',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR3','Otros',true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR4','¿Cuál?',true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR5','Vida Marina',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR5','Sol y Playa',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR5','Vida Terrestre',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR5','Paisaje',true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Crucero',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Buceo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Snorkel',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Kayak',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Surf',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Senderismo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Observación e interpretación de vida silvestre',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Fotografía',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR6','Pesca vivencial',true,current_timestamp,'admin',current_timestamp,'admin');

CREATE TABLE sii.cgg_enc_respuesta
(
   encres_codigo character varying PRIMARY KEY, -- CODIGO
   encpr_codigo character varying, --- CODIGO PREGUNTA
   encit_codigo character varying, -- CODIGO ITEM
   ctreg_codigo character varying, -- CODIGO PREREGISTRO
   ctgtr_codigo character varying(20),-- IDENTIFICATIVO DE GRUPO
   encres_numval numeric, -- VALOR NUMERICO
   encres_txtval character varying, -- VALOR TEXTO
   encres_estado boolean DEFAULT TRUE , -- ESTADO DEL REGISTRO
   encres_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
   encres_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
   encres_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
   encres_usuario_update character varying(20)
);


-- AGREGAR EL TIPO DE TRANSPORTE EN LA TABLA DE AEROLINEAS
ALTER TABLE sii.Cgg_res_aerolinea ADD COLUMN craln_tipo character varying(20) NOT NULL DEFAULT 'AVION';

CREATE OR REPLACE FUNCTION sii.f_cgg_res_aerolinea_select_as(in_tipo CHARACTER VARYING, in_user_name character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRALN_CODIGO,
		CRALN_NOMBRE,
		CRALN_TIPO_AEROLINEA,
		CRALN_ESTADO,
		CRALN_FECHA_INSERT,
		CRALN_USUARIO_INSERT,
		CRALN_FECHA_UPDATE,
		CRALN_USUARIO_UPDATE,
		CRALN_TIPO
	FROM SII.CGG_RES_AEROLINEA
	WHERE CRALN_ESTADO = TRUE AND CASE WHEN in_tipo IS NULL THEN 1=1 ELSE CRALN_TIPO = in_tipo END;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

-- TRANSPORTE POR AEROLINEAS y Nº de VUELO

CREATE TABLE sii.cgg_tct_transporte(
   tcttr_codigo character varying primary key,
   craln_codigo character varying not null,
   carpt_codigo character varying not null,
   tcttr_numero character varying not null,
   tcttr_estado boolean DEFAULT TRUE ,
   tcttr_fecha_insert timestamp with time zone,
   tcttr_usuario_insert character varying(20),
   tcttr_fecha_update timestamp with time zone,
   tcttr_usuario_update character varying(20)
);

INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'1','5','191',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'1','5','193',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'1','3','195',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'7','5','XL1551',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'7','5','XL1553',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'7','5','XL1557',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO SII.CGG_TCT_TRANSPORTE VALUES(SII.F_KEYGEN('CGG_TCT_TRANSPORTE','TCTTR_CODIGO','TCTTR'),'7','3','XL1561',true,current_timestamp,'admin',current_timestamp,'admin');

--ACTUALIZAMOS LA TABLA CGG_TCT_TIPO_HOSPEDAJE POR COMPATIBILIDAD
UPDATE sii.cgg_tct_tipo_hospedaje SET ctthj_estado = false;
INSERT INTO sii.cgg_tct_tipo_hospedaje VALUES ('102','Abordo De Crucero',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_tipo_hospedaje VALUES ('103','Domicilio Amigo/Familiar',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_tct_tipo_hospedaje VALUES ('104','Hotel',true,current_timestamp,'admin',current_timestamp,'admin');

-- TABLA DE HOSPEDAJES
CREATE TABLE sii.cgg_tct_hospedaje
(
  cthos_codigo character varying(20) NOT NULL, -- IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
  ctreg_codigo character varying(20) NOT NULL,-- IDENTIFICATIVO DE PRE-REGISTRO
  ctgtr_codigo character varying(20) NOT NULL,-- IDENTIFICATIVO DE GRUPO
  cthos_tipo character varying, -- TIPO DE HOSPEDAJE
  cisla_codigo character varying, -- ISLA DE HOSPEDAJE
  cthos_lugar character varying, -- LUGAR HOSPEDAJE
  cthos_fechaIngreso timestamp,
  cthos_fechaSalida timestamp,
  cthos_reserva character varying, -- NO SE USA. RESERVA DEL HOSPEDAJE
  cthos_estado boolean DEFAULT true, -- ESTADO DEL REGISTRO
  cthos_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
  cthos_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
  cthos_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cthos_usuario_update character varying(20), -- USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  CONSTRAINT pk_cgg_tct_hospedaje PRIMARY KEY (cthos_codigo)
);


-- LAS VENTAS NO SE HACEN HASTA EL FINAL
CREATE OR REPLACE FUNCTION sii.f_cgg_tct_registro_persona(
    in_ctgtr_codigo character varying,
    in_ctreg_estado_registro character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		),
	RESIDENCIA AS(
		SELECT RG.CRPER_CODIGO,RS.CRTRA_CODIGO,RS.CRTST_CODIGO FROM  SII.CGG_TCT_REGISTRO RG
		LEFT JOIN SII.CGG_RES_RESIDENCIA RS ON (RS.CRPER_CODIGO = RG.CRPER_CODIGO AND RS.CRRSD_VIGENTE AND RS.CRRSD_FECHA_INICIO::DATE = RG.CTREG_FECHA_INGRESO::DATE)
		AND RS.CRTST_CODIGO IN (SELECT CRTST_CODIGO  FROM TIPO)
		WHERE CTGTR_CODIGO = IN_CTGTR_CODIGO)
	SELECT DISTINCT
		RG.CTREG_CODIGO,
		GT.CTGTR_CODIGO,
		LPAD(GT.CTGTR_NUMERO::VARCHAR,7,'0'::VARCHAR) CTGTR_NUMERO,
		PR.CRPER_CODIGO,
		PR.CRDID_CODIGO,
		PR.CRPER_NUM_DOC_IDENTIFIC,
		PR.CRPER_NOMBRES,
		PR.CRPER_APELLIDO_PATERNO,
		PR.CRPER_GENERO,
		PR.CGNCN_CODIGO,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CGG_CPAIS_CODIGO,
		--VDT.CKESP_CODIGO,
		--CKESP_REPORTE,
		RG.CTREG_ESTADO_REGISTRO,
		RG.CTREG_OBSERVACION,
		TR.CRTRA_CODIGO,
		TR.CRTRA_NUMERO,
		PR.CRPER_SEGUIMIENTO,
		(CASE WHEN RS.CRTST_CODIGO IS NULL THEN 'Turista' ELSE 'Transeunte' END)TIPO_RESIDENCIA,
		RG.CTREG_FECHA_INSERT
	FROM  SII.CGG_TCT_REGISTRO RG
	INNER JOIN SII.CGG_RES_PERSONA PR ON PR.CRPER_CODIGO = RG.CRPER_CODIGO
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GT ON (GT.CTGTR_CODIGO = RG.CTGTR_CODIGO)
	--INNER JOIN SII.CGG_KDX_VENTA_DETALLE VDT ON (VDT.CTREG_CODIGO = RG.CTREG_CODIGO)
	--INNER JOIN SII.CGG_KDX_ESPECIE CKESP ON (CKESP.CKESP_CODIGO = VDT.CKESP_CODIGO)
	INNER JOIN RESIDENCIA RS ON (RS.CRPER_CODIGO = RG.CRPER_CODIGO)
	LEFT JOIN SII.CGG_RES_TRAMITE TR ON (TR.CRTRA_CODIGO=RS.CRTRA_CODIGO)
	WHERE RG.CTREG_ESTADO AND
		GT.CTGTR_CODIGO = IN_CTGTR_CODIGO AND
		CTREG_ESTADO_REGISTRO = ANY(STRING_TO_ARRAY(IN_CTREG_ESTADO_REGISTRO,',')::smallint[])
		AND NOT RG.CTREG_COMPLETO
	ORDER BY RG.CTREG_FECHA_INSERT;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


  -- Correo para usuarios TCT

  INSERT INTO sii.cgg_not_mail (ntml_codigo, ntml_name, ntml_description, ntml_subject, ntml_type, ntml_body, ntml_sendheader, ntml_sendfooter, ntml_header_override,
    ntml_footer_override, ntml_estado, ntml_fecha_insert, ntml_usuario_insert, ntml_fecha_update, ntml_usuario_update)
  VALUES ('NTML4', 'Correo Suscripción', 'Correo TCT', '[PRUEBA! POR FAVOR DESCARTAR] (TCT) Tarjeta de Control de Tránsito', 'html',
  '<p style="margin: 0 0 16px; text-align: left; color: #737373">@$PERSONA@</p>
<p style="margin: 0 0 16px;">Con fecha @$HOY@ se ha generado su pre-registro de Tarjeta de Control de Tránsito (TCT), con los siguientes datos:</p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220);">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">Datos de TCT</h3>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>No:</strong> @$REGNUMERO@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Tipo:</strong> @$CATEGORIA@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Origen:</strong> @Cgg_res_aeropuerto*origen:carpt_nombre@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Aerolinea/Nav&iacute;o:</strong> @Cgg_res_aerolinea*craln_codigo:craln_nombre@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Nro. de vuelo/navío:</strong> @$NUMVUELO@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Destino:</strong> @Cgg_res_aeropuerto*destino:carpt_nombre@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Fecha de Ingreso:</strong> @$FECHAINGRESO@
    </p>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        <strong>Fecha de Salida:</strong> @$FECHASALIDA@
    </p>
</div>

<p style="margin: 0 0 16px;"></p>

<div style="border-radius: 3px ! important; border: 1px solid rgb(220, 220, 220); font-size: 12px;">
    <h3 style="color: #00aca2; display: block; font-family: Helvetica Neue, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; font-weight: bold; line-height: 130%; margin: 16px 0 16px; padding-left: 16px; text-align: left;">--IMPORTANTE-- PASOS A SEGUIR</h3>
    <p style="margin: 0 0 16px; padding-left: 16px;">
        Para adquirir su TCT y pueda viajar a Gal&aacute;pagos, se recomienda que llegue al menos 2 horas antes al aeropuerto de origen y siga los siguientes pasos:
        <ol>
            <li>Acercarse a los counters del Consejo de Gobierno del R&eacute;gimen Especial de Gal&aacute;pagos en los aeropuertos de Quito y Guayaquil.</li>
            <li>En el counter deber&aacute; presentar su documento de identificaci&oacute;n y cancelar el valor de $20 d&oacute;lares americanos por concepto de emisi&oacute;n de TCT.</li>
            <li>Coloque su equipaje en las m&aacute;quinas de esc&aacute;ner para que &eacute;ste pueda ser cellado por la ABG (Agencia de Bioseguridad y Cuarentena).</li>
        </ol>

        Para su pre-chequeo deber&aacute; presentar su TCT y los documentos solicitados por la aerol&iacute;nea.</br></br>
        <div style="text-align: center;"><strong>GRACIAS POR SU COLABORACI&Oacute;N EN LA CONSERVACI&Oacute;N DE LAS ISLAS GAL&Aacute;PAGOS. </br></br>BIENVENIDO</strong></div>
    </p>
</div>

<p style="margin: 0 0 50px;"></p>

<p style="margin: 0px 0px 8px; font-size: 12px; text-align: justify;">Declaro bajo juramento que los datos consignados en el presente formulario reflejan la realidad y autorizo a las instituciones competentes de Gal&aacute;pagos a verificar
el contenido de esta declaraci&oacute;n en cualquier momento, a tiempo que me sujeto a las acciones previstas en la normativa legal del Ecuador en caso de falsedad o perjurio.</p>',
 true, true, null, null, true, '2016-08-29 16:53:14.783784', 'admin', '2016-08-29 16:53:14.783784', 'admin');

  INSERT INTO sii.Cgg_configuracion VALUES('CONF201','Cgg_not_correo codigo para Usuarios TCT','NTML4',0,null,true,current_timestamp,'admin',current_timestamp,'admin');


-- FACILITA LA GENERACION DE REPORTES
CREATE OR REPLACE FUNCTION SII.getcolumnvalue(
    record_id character varying,
    tablename character varying,
    column_id character varying,
    returncolumn character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	sel        VARCHAR (2000);
	v_Name          VARCHAR(2000) := '';
BEGIN
	if record_id is null then
		RETURN null;
	else
		sel:='SELECT '||returncolumn||' from sii.'||tablename||' where '||column_id||'='||quote_literal(record_id);
		EXECUTE sel INTO v_Name;
		RETURN v_Name;
	end if;

END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


-- MODIFICAMOS PARA TENER DATOS OPERACIONALES
CREATE OR REPLACE FUNCTION sii.f_cgg_tct_registro_count(
    in_user_name character varying,
    in_find_text text,
    in_operational boolean)
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT;
TMP_TIPO_USUARIO BOOLEAN;
BEGIN
	SELECT CUSU_USUARIO_INTERNO INTO TMP_TIPO_USUARIO
	FROM SII.CGG_USUARIO
	WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME;

	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_TCT_REGISTRO RGT
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GTR ON GTR.CTGTR_CODIGO = RGT.CTGTR_CODIGO
	INNER JOIN SII.CGG_RES_PERSONA CRPER ON CRPER.CRPER_CODIGO = RGT.CRPER_CODIGO
	INNER JOIN SII.CGG_USUARIO US ON US.CUSU_CODIGO = RGT.CUSU_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARO ON ARO.CARPT_CODIGO = RGT.CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARD ON ARD.CARPT_CODIGO = RGT.CGG_CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROLINEA AL ON AL.CRALN_CODIGO = RGT.CRALN_CODIGO
	LEFT JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = CRPER.CRPER_CODIGO AND RSD.CRRSD_ESTADO AND RSD.CRRSD_VIGENTE AND RSD.CRRSD_FECHA_INICIO::DATE = RGT.CTREG_FECHA_INGRESO::DATE AND
			RSD.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO)
	LEFT JOIN SII.CGG_RES_PERSONA_JURIDICA PJR ON PJR.CRPJR_CODIGO = US.CRPJR_CODIGO
	WHERE CTREG_ESTADO AND
		NOT RGT.CTREG_COMPLETO AND
		CASE WHEN in_operational THEN RGT.CTREG_ESTADO_REGISTRO=0 ELSE RGT.CTREG_ESTADO_REGISTRO IN (0,1) END AND
		(LENGTH(IN_FIND_TEXT) = 0 OR to_tsvector(
		COALESCE(GTR.CTGTR_NUMERO::VARCHAR,'')||' '||
		COALESCE(PJR.CRPJR_RAZON_SOCIAL, '')||' '||
		COALESCE(CRPER_NUM_DOC_IDENTIFIC, '')||' '||
		COALESCE(CRPER.CRPER_NOMBRES, '')||' '||
		COALESCE(CRPER.CRPER_APELLIDO_PATERNO, '')||' '||
		COALESCE(CRPER.CRPER_APELLIDO_MATERNO, '')) @@ plainto_tsquery(IN_FIND_TEXT) ) AND
		(TMP_TIPO_USUARIO OR US.CUSU_CODIGO IN (SELECT CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CRPJR_CODIGO IN (SELECT CRPJR_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME)));
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION sii.f_cgg_tct_registro_select(
    in_user_name character varying,
    in_start_index integer,
    in_limit integer,
    in_sort_field_name character varying,
    in_direction character varying,
    in_find_text text,
    in_operational boolean)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
	TMP_TIPO_USUARIO BOOLEAN;
	TMP_DATOS CHARACTER VARYING;
	TMP_TIME_ZONE VARCHAR;
	TMP_QUERY VARCHAR;
BEGIN
	SELECT CSSSN_ZONA_TIEMPO INTO TMP_TIME_ZONE
	FROM SII.CGG_SEC_SESION
	WHERE CUSU_CODIGO = (SELECT CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME AND CUSU_ESTADO) AND
		CSSSN_ACTIVO
	ORDER BY CSSSN_FECHA_INICIO DESC LIMIT 1;

	IF (TMP_TIME_ZONE IS NULL OR LENGTH(TMP_TIME_ZONE) = 0) THEN
		SELECT ABS(EXTRACT(TIMEZONE FROM CURRENT_TIMESTAMP)/3600) INTO TMP_TIME_ZONE;
	END IF;

	IF (LENGTH(IN_FIND_TEXT) > 0) THEN
		TMP_QUERY = ' to_tsvector(
		COALESCE(GTR.CTGTR_NUMERO::VARCHAR,'''')||'' ''||
		COALESCE(PJR.CRPJR_RAZON_SOCIAL,'''')||'' ''||
		COALESCE(CRPER_NUM_DOC_IDENTIFIC,'''')||'' ''||
		COALESCE(CRPER.CRPER_NOMBRES,'''')||'' ''||
		COALESCE(CRPER.CRPER_APELLIDO_PATERNO, '''')||'' ''||
		COALESCE(CRPER.CRPER_APELLIDO_MATERNO, '''')) @@ plainto_tsquery('||QUOTE_LITERAL(IN_FIND_TEXT)||') AND';
	END IF;
	IF (TMP_QUERY IS NULL) THEN
		TMP_QUERY = '';
	END IF;
	SELECT CUSU_USUARIO_INTERNO INTO TMP_TIPO_USUARIO
	FROM SII.CGG_USUARIO
	WHERE CUSU_NOMBRE_USUARIO = IN_USER_NAME;
	TMP_DATOS:='SELECT
		RS.CTREG_CODIGO,
		RS.CARPT_CODIGO,
		ARO.CARPT_NOMBRE AEROPUER_ORIGEN,
		RS.CGG_CARPT_CODIGO,
		ARD.CARPT_NOMBRE AEROPUER_DESTINO,
		RS.CRALN_CODIGO,
		AL.CRALN_NOMBRE AEROLINEA,
		RS.CTREG_NUMERO_VUELO,
		RS.CTGTR_CODIGO,
		RS.CRTRA_CODIGO,
		(SELECT CRTRA_NUMERO FROM SII.CGG_RES_TRAMITE TA WHERE TA.CRTRA_CODIGO = RSD.CRTRA_CODIGO) NUMERO,
		RS.CTREG_NUMERO,
		GTR.CTGTR_NUMERO,
		RS.CTREG_FECHA_PREREGISTRO,
		RS.CTREG_FECHA_INGRESO,
		RS.CTREG_CODIGO_BARRAS,
		RS.CTREG_FECHA_SALIDA,
		CASE WHEN CTREG_ESTADO_REGISTRO != 1 THEN NULL ELSE RS.CTREG_IMPRESION_ESPECIE AT TIME ZONE '||QUOTE_LITERAL('UTC+'||TMP_TIME_ZONE)||' END CTREG_IMPRESION_ESPECIE,
		RS.CTREG_ESTADO_REGISTRO,
		RS.CTREG_OBSERVACION,
		RS.CTREG_ESTADO,
		(PJR.CRPJR_RAZON_SOCIAL||'' - ''||US.CUSU_NOMBRE_USUARIO) CTAGV_NOMBRE,
		CRPER.CRPER_NUM_DOC_IDENTIFIC,
		COALESCE(CRPER.CRPER_NOMBRES,'''')||'' ''||COALESCE(CRPER.CRPER_APELLIDO_PATERNO,'''') AS CRPER_NOMBRES,
		CRPER.CRPER_FECHA_NACIMIENTO,
		(SELECT CPAIS_NOMBRE FROM SII.CGG_PAIS PAIS WHERE PAIS.CPAIS_CODIGO = CRPER.CGNCN_CODIGO) CGNCN_CODIGO,
		(SELECT CPAIS_NOMBRE FROM SII.CGG_PAIS PAIS WHERE PAIS.CPAIS_CODIGO = CRPER.CGG_CPAIS_CODIGO) CGG_CPAIS_CODIGO,
		RS.CTREG_FECHA_INSERT,
		RS.CTREG_USUARIO_INSERT,
		RS.CTREG_FECHA_UPDATE,
		RS.CTREG_USUARIO_UPDATE,
		(SELECT COALESCE(CRPER_NOMBRES,'''')||'' ''||COALESCE(CRPER_APELLIDO_PATERNO,'''') FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = US.CRPER_CODIGO) USUARIO_UPDATE,
		RS.CTREG_NUMERO_VUELO
	FROM SII.CGG_TCT_REGISTRO RS
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GTR ON GTR.CTGTR_CODIGO = RS.CTGTR_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARO ON ARO.CARPT_CODIGO = RS.CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARD ON ARD.CARPT_CODIGO = RS.CGG_CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROLINEA AL ON AL.CRALN_CODIGO = RS.CRALN_CODIGO
	INNER JOIN SII.CGG_RES_PERSONA CRPER ON (RS.CRPER_CODIGO = CRPER.CRPER_CODIGO)
	LEFT JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = CRPER.CRPER_CODIGO AND RSD.CRRSD_ESTADO AND RSD.CRRSD_VIGENTE AND RSD.CRRSD_FECHA_INICIO::DATE = RS.CTREG_FECHA_INGRESO::DATE AND
			RSD.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = ''05'')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO)
	LEFT JOIN SII.CGG_USUARIO US ON US.CUSU_CODIGO = RS.CUSU_CODIGO
	LEFT JOIN SII.CGG_RES_PERSONA_JURIDICA PJR ON PJR.CRPJR_CODIGO = US.CRPJR_CODIGO
	WHERE CTREG_ESTADO AND RS.CTREG_ESTADO_REGISTRO IN '||CASE WHEN in_operational THEN '(0)' ELSE '(0,1)' END ||' AND '
		||TMP_QUERY||'
		NOT RS.CTREG_COMPLETO AND
		('||TMP_TIPO_USUARIO||' OR US.CUSU_CODIGO IN (SELECT CUSU_CODIGO FROM SII.CGG_USUARIO WHERE CRPJR_CODIGO IN (SELECT CRPJR_CODIGO FROM SII.CGG_USUARIO WHERE CUSU_NOMBRE_USUARIO = '||QUOTE_LITERAL(IN_USER_NAME)||')))
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX ;

	OPEN TMP_REF FOR EXECUTE TMP_DATOS;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


-- REGISTROS DE MOVILIDAD
CREATE OR REPLACE FUNCTION f_cgg_movilidad_ingreso_pag_select(
    in_user_name character varying,
    in_start_index integer,
    in_limit integer,
    in_sort_field_name character varying,
    in_direction character varying,
    in_find_text text,
    in_identificacion character varying,
    in_movimiento integer)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
	TMP_RSD VARCHAR;
BEGIN
	TMP_RSD = 'AND RS.CRRSD_VIGENTE';

	IF (IN_MOVIMIENTO != -1) THEN
		TMP_RSD = 'AND RS.CRRSD_CODIGO = MV.CRRSD_CODIGO ';
	END IF;

	OPEN TMP_REF FOR EXECUTE
	'WITH TCT_REG AS (SELECT
		MV.CRMOV_CODIGO,
		RG.CTREG_CODIGO,
		RG.CTGTR_CODIGO	,
		PR.CRPER_CODIGO,
		PR.CRDID_CODIGO,
		RG.CTREG_CODIGO_BARRAS,
		RG.CRALN_CODIGO,
		(SELECT CRALN_NOMBRE FROM  CGG_RES_AEROLINEA AL WHERE AL.CRALN_CODIGO = RG.CRALN_CODIGO) AEROLINEA,
		RG.CARPT_CODIGO,
		(SELECT CARPT_NOMBRE FROM  CGG_RES_AEROPUERTO AR WHERE AR.CARPT_CODIGO = RG.CARPT_CODIGO) AEROPUER_ORIGEN,
		RG.CGG_CARPT_CODIGO,
		CASE WHEN MV.CRMOV_TIPO_OPERACION = 0 THEN ARPS.CARPT_NOMBRE ELSE (SELECT CARPT_NOMBRE FROM SII.CGG_RES_AEROPUERTO AR WHERE AR.CARPT_CODIGO = RG.CGG_CARPT_CODIGO) END AEROPUER_DESTINO,
		RG.CTREG_FECHA_INGRESO,
		RG.CTREG_FECHA_SALIDA,
		(SELECT CRDID_DESCRIPCION FROM SII.CGG_RES_DOCUMENTO_IDENTIFICACIO DI WHERE DI.CRDID_CODIGO = PR.CRDID_CODIGO) DOCUMENTO,
		PR.CRPER_NUM_DOC_IDENTIFIC,
		PR.CRPER_NOMBRES,
		PR.CRPER_APELLIDO_PATERNO,
		PR.CRPER_APELLIDO_MATERNO,
		PR.CRPER_GENERO,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CPAIS_CODIGO,
		PR.CGG_CPAIS_CODIGO,
		PR.CRPER_SEGUIMIENTO,
		(SELECT CPAIS_NOMBRE FROM SII.CGG_PAIS PS WHERE PS.CPAIS_CODIGO = PR.CGG_CPAIS_CODIGO) PAIS_RESIDENCIA,
		PR.CGNCN_CODIGO,
		(SELECT CGNCN_NACIONALIDAD FROM SII.CGG_NACIONALIDAD NC WHERE NC.CGNCN_CODIGO = PR.CGNCN_CODIGO) NACIONALIDAD,
		TRM.CRTRA_CODIGO,
		TRM.CRTRA_NUMERO,
		RS.CRRSD_CODIGO,
		COALESCE(TST.CRTST_DESCRIPCION,''Turista'') TIPO_RESIDENCIA,
		RG.CTREG_ESTADO_REGISTRO,
		RG.CTREG_OBSERVACION,
		MV.CRMOV_FECHA_VIAJE,
		RG.CTREG_NUMERO_VUELO
	FROM SII.CGG_RES_PERSONA PR
	INNER JOIN SII.CGG_TCT_REGISTRO RG ON RG.CRPER_CODIGO = PR.CRPER_CODIGO AND RG.CTREG_ESTADO_REGISTRO IN (1,4) AND NOT RG.CTREG_COMPLETO
	LEFT JOIN SII.CGG_RES_MOVILIDAD MV ON MV.CTREG_CODIGO = RG.CTREG_CODIGO
	LEFT JOIN SII.CGG_RES_RESIDENCIA RS ON RS.CRPER_CODIGO = PR.CRPER_CODIGO AND RS.CRRSD_ESTADO '||TMP_RSD||' AND
		(RS.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = ''05'') OR CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = ''06'')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO)) AND
		('||IN_MOVIMIENTO||' != -1 OR RS.CRRSD_FECHA_INICIO::DATE = CURRENT_DATE)
	LEFT JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = RS.CRTST_CODIGO
	LEFT JOIN SII.CGG_RES_AEROPUERTO ARPI ON ARPI.CARPT_CODIGO = MV.CARPT_CODIGO
	LEFT JOIN SII.CGG_RES_AEROPUERTO ARPS ON ARPS.CARPT_CODIGO = MV.CGG_CARPT_CODIGO
	LEFT JOIN SII.CGG_RES_TRAMITE TRM ON TRM.CRTRA_CODIGO = RS.CRTRA_CODIGO
	WHERE CTREG_ESTADO AND (LENGTH('||QUOTE_LITERAL(IN_FIND_TEXT)||') = 0 OR SII.F_STRING_IN('''||IN_FIND_TEXT||''',
		COALESCE(RG.CTREG_CODIGO_BARRAS,'''')||'' ''||
		COALESCE(RG.CTREG_FECHA_INGRESO,CURRENT_TIMESTAMP)||'' ''||
		COALESCE(RG.CTREG_FECHA_SALIDA,CURRENT_TIMESTAMP)||'' ''||
		COALESCE(PR.CRPER_NUM_DOC_IDENTIFIC,'''')||'' ''||
		COALESCE(PR.CRPER_NOMBRES,'''')||'' ''||
		COALESCE(PR.CRPER_APELLIDO_PATERNO,'''')||'' ''||
		COALESCE(PR.CRPER_APELLIDO_PATERNO,'''')) = 1 ) AND
	(LENGTH('||QUOTE_LITERAL(IN_IDENTIFICACION)||') = 0 OR RG.CTREG_CODIGO_BARRAS = '||QUOTE_LITERAL(IN_IDENTIFICACION)||' OR PR.CRPER_NUM_DOC_IDENTIFIC = '||QUOTE_LITERAL(IN_IDENTIFICACION)||'))
	SELECT * FROM TCT_REG WHERE ('||IN_MOVIMIENTO||' = 0 AND CRMOV_CODIGO IS NOT NULL OR '||IN_MOVIMIENTO||' = -1 AND CRMOV_CODIGO IS NULL)
	 LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	--ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


  --FUNCION DE COMPATIBILIDAD PARA HOSPEDAJE

  CREATE OR REPLACE FUNCTION sii.f_cgg_tct_registro_grupo_multi_hospedaje(in_ctgtr_codigo character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		TH.CTTHJ_CODIGO,
		TH.CTTHJ_NOMBRE
	FROM SII.CGG_TCT_TIPO_HOSPEDAJE TH
	INNER JOIN SII.CGG_TCT_HOSPEDAJE GH ON (GH.cthos_tipo = TH.CTTHJ_CODIGO)
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GT ON (GT.CTGTR_CODIGO = GH.CTGTR_CODIGO)
	WHERE CTTHJ_ESTADO = TRUE
	AND GT.CTGTR_CODIGO = IN_CTGTR_CODIGO;

	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

  -- SEGUIMIENTO EN TCT
  CREATE OR REPLACE FUNCTION sii.f_cgg_tct_registro_persona_update(
    in_crper_codigo character varying,
    in_crdid_codigo character varying,
    in_cgncn_codigo character varying,
    in_crper_nombres character varying,
    in_crper_apellido_paterno character varying,
    in_crper_num_doc_identific character varying,
    in_crper_fecha_nacimiento timestamp with time zone,
    in_crper_genero smallint,
    in_cgg_cpais_codigo character varying,
    in_crper_estado boolean,
    in_crper_usuario_update character varying,
    in_crper_seguimiento boolean)
  RETURNS void AS
$BODY$
BEGIN
	UPDATE SII.CGG_RES_PERSONA SET
		CRDID_CODIGO = IN_CRDID_CODIGO,
		CGNCN_CODIGO = IN_CGNCN_CODIGO,
		CRPER_NOMBRES = IN_CRPER_NOMBRES,
		CRPER_APELLIDO_PATERNO = IN_CRPER_APELLIDO_PATERNO,
		CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC,
		CRPER_FECHA_NACIMIENTO = IN_CRPER_FECHA_NACIMIENTO,
		CRPER_GENERO = IN_CRPER_GENERO,
		CGG_CPAIS_CODIGO = IN_CGG_CPAIS_CODIGO,
		CRPER_ESTADO = IN_CRPER_ESTADO,
		CRPER_FECHA_UPDATE = CURRENT_TIMESTAMP,
		CRPER_USUARIO_UPDATE = IN_CRPER_USUARIO_UPDATE,
		CRPER_SEGUIMIENTO = IN_CRPER_SEGUIMIENTO
	WHERE
		CRPER_CODIGO = IN_CRPER_CODIGO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION sii.f_cgg_tct_registro_persona_insert(
    in_crper_codigo character varying,
    in_crdid_codigo character varying,
    in_cgncn_codigo character varying,
    in_crper_nombres character varying,
    in_crper_apellido_paterno character varying,
    in_crper_num_doc_identific character varying,
    in_crper_fecha_nacimiento timestamp with time zone,
    in_crper_genero smallint,
    in_cgg_cpais_codigo character varying,
    in_crper_estado boolean,
    in_crper_usuario_insert character varying,
    in_crper_usuario_update character varying,
    in_crper_seguimiento boolean)
  RETURNS character varying AS
$BODY$
DECLARE
TMP_RECORD RECORD;
OUT_KEY VARCHAR;
TMP_CODIGO VARCHAR;
BEGIN
	SELECT CRPER_CODIGO INTO TMP_CODIGO FROM SII.CGG_RES_PERSONA WHERE CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC;
	IF (UPPER(IN_CRPER_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_PERSONA','CRPER_CODIGO','CRPER') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRPER_CODIGO;
	END IF;
	IF (TMP_CODIGO IS NULL ) THEN
		INSERT INTO SII.CGG_RES_PERSONA(
			CRPER_CODIGO,
			CRDID_CODIGO,
			CGNCN_CODIGO,
			CRPER_NOMBRES,
			CRPER_APELLIDO_PATERNO,
			CRPER_NUM_DOC_IDENTIFIC,
			CRPER_FECHA_NACIMIENTO,
			CRPER_GENERO,
			CGG_CPAIS_CODIGO,
			CRPER_ESTADO,
			CRPER_FECHA_INSERT,
			CRPER_USUARIO_INSERT,
			CRPER_FECHA_UPDATE,
			CRPER_USUARIO_UPDATE,
			CRPER_SEGUIMIENTO
		) VALUES (
			OUT_KEY,
			IN_CRDID_CODIGO,
			IN_CGNCN_CODIGO,
			IN_CRPER_NOMBRES,
			IN_CRPER_APELLIDO_PATERNO,
			UPPER(TRIM(IN_CRPER_NUM_DOC_IDENTIFIC)),
			IN_CRPER_FECHA_NACIMIENTO,
			IN_CRPER_GENERO,
			IN_CGG_CPAIS_CODIGO,
			IN_CRPER_ESTADO,
			CURRENT_TIMESTAMP,
			IN_CRPER_USUARIO_INSERT,
			CURRENT_TIMESTAMP,
			IN_CRPER_USUARIO_UPDATE,
			IN_CRPER_SEGUIMIENTO
		);
		FOR TMP_RECORD IN (SELECT
			CRPER_CODIGO,
			CRPER_NOMBRES,
			CRPER_APELLIDO_PATERNO,
			CRPER_APELLIDO_MATERNO,
			CRPER_NUM_DOC_IDENTIFIC,
			CRPER_FECHA_NACIMIENTO,
			CRPER_LUGAR_NACIMIENTO,
			CRPER_OBSERVACIONES,
			CRPER_NUMERO_RESIDENCIA,
			CRPER_NUMERO_EXPEDIENTE,
			CRPER_FECHA_ARCHIVO,
			CRPER_FECHA_ULTIMO_EMPLEO,
			CRPER_ASPIRACION_SALARIAL,
			CRPER_FECHA_DEFUNCION,
			CRPER_NUMERO_ACTA
			FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = OUT_KEY ) LOOP
			UPDATE SII.CGG_RES_PERSONA SET CRPER_INDEX = TO_TSVECTOR(TMP_RECORD::VARCHAR)
				WHERE CRPER_CODIGO = TMP_RECORD.CRPER_CODIGO;
		END LOOP;
	ELSE
		OUT_KEY := TMP_CODIGO;
	END IF;
	RETURN OUT_KEY;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION f_cgg_tct_registro_codigo_barras_select(in_ctgtr_numero bigint)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		RS.CTREG_CODIGO,
		RS.CARPT_CODIGO,
		LPAD(GT.CTGTR_NUMERO::VARCHAR,7,'0'::VARCHAR) CTGTR_NUMERO,
		(SELECT CARPT_NOMBRE FROM  CGG_RES_AEROPUERTO AR WHERE AR.CARPT_CODIGO = RS.CARPT_CODIGO) AEROPUER_ORIGEN,
		RS.CGG_CARPT_CODIGO,
		(SELECT CARPT_NOMBRE FROM  CGG_RES_AEROPUERTO AR WHERE AR.CARPT_CODIGO = RS.CGG_CARPT_CODIGO) AEROPUER_DESTINO,
		RS.CRALN_CODIGO,
		(SELECT CRALN_NOMBRE FROM  CGG_RES_AEROLINEA AL WHERE AL.CRALN_CODIGO = RS.CRALN_CODIGO) AEROLINEA,
		RS.CTGTR_CODIGO,
		RS.CRTRA_CODIGO,
		(SELECT CRTRA_NUMERO FROM  CGG_RES_TRAMITE TA WHERE TA.CRTRA_CODIGO = RS.CRTRA_CODIGO) NUMERO,
		RS.CTREG_FECHA_INGRESO,
		RS.CTREG_FECHA_SALIDA,
		RS.CTREG_ESTADO_REGISTRO,
		RS.CTREG_ESTADO_REGISTRO,
		RS.NUMERO_VUELO
	FROM SII.CGG_TCT_REGISTRO RS
	INNER JOIN SII.CGG_TCT_GRUPO_TURISTA GT ON (GT.CTGTR_CODIGO = RS.CTGTR_CODIGO)
	WHERE CTREG_ESTADO = TRUE AND
		NOT RS.CTREG_COMPLETO AND
		GT.CTGTR_NUMERO  = IN_CTGTR_NUMERO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


  --OPERACIONAL EN MOVILIZACION

CREATE OR REPLACE FUNCTION sii.f_cgg_res_movilidad_ingreso_select(
    in_user_name character varying,
    in_start_index integer,
    in_limit integer,
    in_sort_field_name character varying,
    in_direction character varying,
    in_find_text text,
    in_operational boolean)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
TMP_REF REFCURSOR;
--DIAS AUTORIZADOS DE PERMANENCIA EN LA PROVINCIA COMO TURISTA O TRANSEUNTE
TMP_DIAS_AUTORIZADOS INT;
BEGIN
	SELECT CGCNF_VALOR_NUMERICO INTO TMP_DIAS_AUTORIZADOS FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = 'CONF18';
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		MV.CRMOV_CODIGO,
		RG.CTREG_CODIGO,
		PR.CRPER_CODIGO,
		RG.CTREG_CODIGO_BARRAS,
		RG.CRALN_CODIGO,
		ARL.CRALN_NOMBRE AEROLINEA,
		RG.CARPT_CODIGO,
		ARO.CARPT_NOMBRE AEROPUER_ORIGEN,
		RG.CGG_CARPT_CODIGO,
		ARD.CARPT_NOMBRE AEROPUER_DESTINO,
		RG.CTREG_FECHA_INGRESO,
		RG.CTREG_FECHA_SALIDA,
		PR.CRDID_CODIGO,
		(SELECT CRDID_DESCRIPCION FROM  CGG_RES_DOCUMENTO_IDENTIFICACIO DI WHERE DI.CRDID_CODIGO = PR.CRDID_CODIGO) DOCUMENTO,
		PR.CRPER_NUM_DOC_IDENTIFIC,
		PR.CRPER_NOMBRES,
		PR.CRPER_APELLIDO_PATERNO,
		PR.CRPER_GENERO,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CPAIS_CODIGO,
		(SELECT CPAIS_NOMBRE FROM  CGG_PAIS PS WHERE PS.CPAIS_CODIGO = PR.CGG_CPAIS_CODIGO) PAIS_RESIDENCIA,
		PR.CGNCN_CODIGO,
		(SELECT CGNCN_NACIONALIDAD FROM  CGG_NACIONALIDAD NC WHERE NC.CGNCN_CODIGO = PR.CGNCN_CODIGO) NACIONALIDAD,
		RG.CRTRA_CODIGO,
		(SELECT CRTRA_NUMERO FROM SII.CGG_RES_TRAMITE TR WHERE TR.CRTRA_CODIGO = RG.CRTRA_CODIGO) CRTRA_NUMERO,
		MV.CRMOV_FECHA_VIAJE,
		MV.CRMOV_TIPO_OPERACION,
		MV.CRMOV_NUMERO_VUELO,
		MV.CRMOV_OBSERVACION,
		MV.CRMOV_TIPO_SALIDA,
		TST.CRTST_DESCRIPCION TIPO_RESIDENCIA,
		RG.CTREG_ESTADO_REGISTRO,
		MV.CRMOV_FILTRO_INTERNO,
		EXTRACT(DAY FROM (CURRENT_TIMESTAMP - MV.CRMOV_FECHA_VIAJE)) ESTADIA,
		CASE WHEN ('||TMP_DIAS_AUTORIZADOS||' - EXTRACT(DAY FROM (CURRENT_TIMESTAMP - MV.CRMOV_FECHA_VIAJE))) < 0 THEN ABS('||TMP_DIAS_AUTORIZADOS||' - EXTRACT(DAY FROM (CURRENT_TIMESTAMP - MV.CRMOV_FECHA_VIAJE))) ELSE 0 END EXCESO
	FROM SII.CGG_RES_PERSONA PR
	INNER JOIN SII.CGG_RES_MOVILIDAD MV ON MV.CRPER_CODIGO = PR.CRPER_CODIGO AND MV.CRMOV_ESTADO AND MV.CRMOV_TIPO_OPERACION = 0
	INNER JOIN SII.CGG_TCT_REGISTRO RG ON RG.CTREG_CODIGO = MV.CTREG_CODIGO AND NOT RG.CTREG_COMPLETO
	LEFT JOIN SII.CGG_RES_AEROPUERTO ARO ON ARO.CARPT_CODIGO = RG.CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARD ON ARD.CARPT_CODIGO = MV.CGG_CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROLINEA ARL ON ARL.CRALN_CODIGO = RG.CRALN_CODIGO
	INNER JOIN SII.CGG_RES_RESIDENCIA RS ON RS.CRPER_CODIGO = PR.CRPER_CODIGO AND RS.CRRSD_VIGENTE AND RS.CRRSD_ESTADO AND
		RS.CRTST_CODIGO IN
		(WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = ''05'') OR CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = ''06''))
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO)
	INNER JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = RS.CRTST_CODIGO
	WHERE ' || CASE WHEN in_operational THEN '(MV.CRMOV_FECHA_INSERT BETWEEN (current_timestamp - ''1 day''::interval) AND current_timestamp) ' ELSE '1=1' END ||' AND
	(LENGTH('||QUOTE_LITERAL(IN_FIND_TEXT)||') = 0 OR SII.F_STRING_IN('''||IN_FIND_TEXT||''',
	CASE WHEN RG.CTREG_CODIGO_BARRAS IS NULL THEN '''' ELSE RG.CTREG_CODIGO_BARRAS END ||'' ''||
	CASE WHEN RG.CTREG_FECHA_INGRESO IS NULL THEN CURRENT_TIMESTAMP ELSE RG.CTREG_FECHA_INGRESO END ||'' ''||
	CASE WHEN RG.CTREG_FECHA_SALIDA IS NULL THEN CURRENT_TIMESTAMP ELSE RG.CTREG_FECHA_SALIDA END ||'' ''||
	CASE WHEN PR.CRDID_CODIGO IS NULL THEN '''' ELSE PR.CRDID_CODIGO END ||'' ''||
	ARO.CARPT_NOMBRE||'' ''||
	ARD.CARPT_NOMBRE||'' ''||
	ARL.CRALN_NOMBRE||'' ''||
	CASE WHEN PR.CRPER_NUM_DOC_IDENTIFIC IS NULL THEN '''' ELSE PR.CRPER_NUM_DOC_IDENTIFIC END ||'' ''||
	CASE WHEN PR.CRPER_NOMBRES IS NULL THEN '''' ELSE PR.CRPER_NOMBRES END ||'' ''||
	CASE WHEN PR.CRPER_APELLIDO_PATERNO IS NULL THEN '''' ELSE PR.CRPER_APELLIDO_PATERNO END ||'' ''||
	CASE WHEN PR.CRPER_GENERO IS NULL THEN 0 ELSE PR.CRPER_GENERO END ||'' ''||
	CASE WHEN PR.CRPER_FECHA_NACIMIENTO IS NULL THEN CURRENT_TIMESTAMP ELSE PR.CRPER_FECHA_NACIMIENTO END ||'' ''||
	CASE WHEN MV.CRMOV_FECHA_VIAJE IS NULL THEN CURRENT_TIMESTAMP ELSE MV.CRMOV_FECHA_VIAJE END ||'' ''||
	CASE WHEN MV.CRMOV_TIPO_OPERACION IS NULL THEN 0 ELSE MV.CRMOV_TIPO_OPERACION END ||'' ''||
	CASE WHEN MV.CRMOV_NUMERO_VUELO IS NULL THEN '''' ELSE MV.CRMOV_NUMERO_VUELO END ||'' ''||
	CASE WHEN MV.CRMOV_OBSERVACION IS NULL THEN '''' ELSE MV.CRMOV_OBSERVACION END ) = 1)
	LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	--	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


CREATE OR REPLACE FUNCTION sii.f_cgg_res_movilidad_ingreso_count(in_find_text text,in_operational boolean)
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_PERSONA PR
	INNER JOIN SII.CGG_RES_MOVILIDAD MV ON MV.CRPER_CODIGO = PR.CRPER_CODIGO AND MV.CRMOV_TIPO_OPERACION = 0
	INNER JOIN SII.CGG_TCT_REGISTRO RG ON RG.CTREG_CODIGO = MV.CTREG_CODIGO AND NOT RG.CTREG_COMPLETO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARO ON ARO.CARPT_CODIGO = RG.CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROPUERTO ARD ON ARD.CARPT_CODIGO = MV.CGG_CARPT_CODIGO
	INNER JOIN SII.CGG_RES_AEROLINEA ARL ON ARL.CRALN_CODIGO = RG.CRALN_CODIGO
	LEFT JOIN SII.CGG_RES_RESIDENCIA RS ON RS.CRPER_CODIGO = PR.CRPER_CODIGO AND RS.CRRSD_ESTADO AND
		RS.CRTST_CODIGO IN
		(WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05') OR CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '06'))
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO)
	WHERE 	CASE WHEN in_operational THEN (MV.CRMOV_FECHA_INSERT BETWEEN (current_timestamp - '1 day'::interval) AND current_timestamp) ELSE 1=1 END  AND
		MV.CRMOV_ESTADO AND (LENGTH(IN_FIND_TEXT) = 0 OR SII.F_STRING_IN(IN_FIND_TEXT,
		CASE WHEN RG.CTREG_CODIGO_BARRAS IS NULL THEN '''' ELSE RG.CTREG_CODIGO_BARRAS END ||' '||
		CASE WHEN RG.CTREG_FECHA_INGRESO IS NULL THEN CURRENT_TIMESTAMP ELSE RG.CTREG_FECHA_INGRESO END ||' '||
		CASE WHEN RG.CTREG_FECHA_SALIDA IS NULL THEN CURRENT_TIMESTAMP ELSE RG.CTREG_FECHA_SALIDA END ||' '||
		CASE WHEN PR.CRPER_NUM_DOC_IDENTIFIC IS NULL THEN '' ELSE PR.CRPER_NUM_DOC_IDENTIFIC END ||' '||
		CASE WHEN PR.CRPER_NOMBRES IS NULL THEN '' ELSE PR.CRPER_NOMBRES END ||' '||
		ARO.CARPT_NOMBRE||' '||
		ARD.CARPT_NOMBRE||' '||
		ARL.CRALN_NOMBRE||' '||
		CASE WHEN PR.CRPER_APELLIDO_PATERNO IS NULL THEN '' ELSE PR.CRPER_APELLIDO_PATERNO END ||' '||
		CASE WHEN PR.CRPER_GENERO IS NULL THEN 0 ELSE PR.CRPER_GENERO END ||' '||
		CASE WHEN PR.CRPER_FECHA_NACIMIENTO IS NULL THEN CURRENT_TIMESTAMP ELSE PR.CRPER_FECHA_NACIMIENTO END ||' '||
		CASE WHEN MV.CRMOV_FECHA_VIAJE IS NULL THEN CURRENT_TIMESTAMP ELSE MV.CRMOV_FECHA_VIAJE END ||' '||
		CASE WHEN MV.CRMOV_TIPO_OPERACION IS NULL THEN 0 ELSE MV.CRMOV_TIPO_OPERACION END ||' '||
		CASE WHEN MV.CRMOV_NUMERO_VUELO IS NULL THEN '' ELSE MV.CRMOV_NUMERO_VUELO END ||' '||
		CASE WHEN MV.CRMOV_OBSERVACION IS NULL THEN '' ELSE MV.CRMOV_OBSERVACION END ) = 1);
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;




--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','Cambios TCT','Modificaciones de TCT para que funcione como el actual',
	'2.0','2016_08_23_Cambios_Tct.sql',true);