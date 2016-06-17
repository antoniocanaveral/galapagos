-- Table: sii.cgg_tct_tipo_registro

-- DROP TABLE sii.cgg_tct_tipo_registro;

CREATE TABLE sii.cgg_tct_tipo_registro
(
  tcttr_codigo character varying(20) NOT NULL,
  tcttr_nombre character varying(150),
  tcttr_estado boolean,
  CONSTRAINT pk_tct_tipo_registro PRIMARY KEY (tcttr_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sii.cgg_tct_tipo_registro
  OWNER TO postgres;

--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','CGGSII-30','',
	'1.0','2016_06_14_cgg_tct_tipo_registro.sql',true);