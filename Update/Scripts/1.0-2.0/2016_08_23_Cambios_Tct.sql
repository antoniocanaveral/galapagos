
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
   encpr_type character varying NOT NULL DEFAULT 'SCORE', -- SCORE, COMBO, TEXT
   encpr_estado boolean DEFAULT TRUE , -- ESTADO DEL REGISTRO
   encpr_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
   encpr_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
   encpr_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
   encpr_usuario_update character varying(20)
);

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR1','* ¿Qué motiva su viaje a Galápagos?','ENCUESTA_TCT','COMBO',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR2','* ¿Usted está viajando a Galápagos dentro de un tour organizado y contratado fuera de Galápagos?','ENCUESTA_TCT','COMBO',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR3','* ¿De dónde se informa de las actividades que realizará en Galápagos?','ENCUESTA_TCT','COMBO',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR4','* ¿Cuál?','ENCUESTA_TCT','TEXT',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR5',
  'Califique con estrellas (1 menor valoración, 4 mayor valoración) qué tan importantes son los siguientes atractivos para su decisión de visitar Galápagos.','ENCUESTA_TCT','SCORE',
  true,current_timestamp,'admin',current_timestamp,'admin');

INSERT INTO sii.cgg_enc_pregunta VALUES('ENCPR6',
  'Califique con estrellas (1 menor valoración, 4 mayor valoración) qué tan importantes son las siguientes actividades en su decisión de visitar Galápagos.','ENCUESTA_TCT','SCORE',
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
   encres_codigo character varying PRIMARY KEY,
   encpr_codigo character varying,
   encit_codigo character varying,
   encres_numval numeric,
   encres_txtval character varying,
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

--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','Cambios TCT','Modificaciones de TCT para que funcione como el actual',
	'2.0','2016_08_23_Cambios_Tct.sql',true);