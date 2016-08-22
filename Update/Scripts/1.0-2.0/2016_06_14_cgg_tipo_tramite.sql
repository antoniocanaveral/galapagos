-- Table: sii.cgg_tipo_tramite

-- DROP TABLE sii.cgg_tipo_tramite;

CREATE TABLE sii.cgg_tipo_tramite
(
  crtt_codigo character varying(20) NOT NULL,
  crtt_nombre character varying(150),
  crtt_estado boolean,
  CONSTRAINT pk_cgg_prueba PRIMARY KEY (crtt_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sii.cgg_tipo_tramite
  OWNER TO postgres;

-- Datos

INSERT INTO sii.cgg_tipo_tramite (crtt_codigo, crtt_nombre, crtt_estado) VALUES ('CRTT1', 'Solicitud de residencia', true);
INSERT INTO sii.cgg_tipo_tramite (crtt_codigo, crtt_nombre, crtt_estado) VALUES ('CRTT2', 'Revocatoria de residencia', true);

--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','CGGSII-30','',
	'1.0','2016_06_14_cgg_tipo_tramite.sql',true);