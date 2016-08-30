
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
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR1','Turismo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR1','Negocios',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR1','Eventos Organizados',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR1','Servicios Religiosos',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR1','Visita Familiar o Amigo',true,current_timestamp,'admin',current_timestamp,'admin');
INSERT INTO sii.cgg_enc_item VALUES (SII.F_KEYGEN('CGG_ENC_ITEM','ENCIT_CODIGO','ENCIT'),'ENCPR1','Investigación',true,current_timestamp,'admin',current_timestamp,'admin');

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


-- TABLA DE HOSPEDAJES
CREATE TABLE sii.cgg_tct_hospedaje
(
  cthos_codigo character varying(20) NOT NULL, -- IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
  ctreg_codigo character varying(20) NOT NULL,-- IDENTIFICATIVO DE PRE-REGISTRO
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
CREATE OR REPLACE FUNCTION f_cgg_tct_registro_persona(
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

  INSERT INTO Cgg_configuracion VALUES('CONF201','Cgg_not_correo codigo para Usuarios TCT','NTML4',0,null,true,current_timestamp,'admin',current_timestamp,'admin');


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
CREATE OR REPLACE FUNCTION f_cgg_tct_registro_count(
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
		RGT.CTREG_ESTADO_REGISTRO IN (CASE WHEN in_operational THEN (0) ELSE (0,1) END) AND
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


CREATE OR REPLACE FUNCTION f_cgg_tct_registro_select(
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
		(SELECT COALESCE(CRPER_NOMBRES,'''')||'' ''||COALESCE(CRPER_APELLIDO_PATERNO,'''') FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO = US.CRPER_CODIGO) USUARIO_UPDATE
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

--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','Cambios TCT','Modificaciones de TCT para que funcione como el actual',
	'2.0','2016_08_23_Cambios_Tct.sql',true);