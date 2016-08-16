-- Table: sii.cgg_tct_categoria

-- DROP TABLE sii.cgg_tct_categoria;

CREATE TABLE sii.cgg_tct_categoria
(
  tctcat_codigo character varying(20) NOT NULL,
  tctcat_nombre character varying(150),
  tctcat_estado boolean,
  CONSTRAINT pk_tct_categoria PRIMARY KEY (tctcat_codigo)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sii.cgg_tct_categoria
  OWNER TO postgres;


--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','CGGSII-30','Creación de tabla para definir un combo en categoría en la pag. de resgistro de tct',
	'1.0','2016_06_14_cgg_tct_categoria.sql',true);