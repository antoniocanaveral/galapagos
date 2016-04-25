--TABLA PARA ADMINISTRAR LA APLICACION DE PARCHES EN LA BASE DE DATOS.
CREATE TABLE sii.cgg_migrationscript
(
  mrgsp_codigo character varying(20) NOT NULL,
  mrgsp_fecha timestamp with time zone,
  mrgsp_usuario_insert character varying(20),
  mrgsp_fecha_insert timestamp with time zone,
  mrgsp_usuario_update character varying(20),
  mrgsp_fecha_update timestamp with time zone,
  mrgsp_estado boolean,
  mrgsp_developer character varying(160),
  mrgsp_name character varying(160) NOT NULL,
  mrgsp_description character varying(2000),
  mrgsp_releaseno character varying(10) NOT NULL,
  mrgsp_filename character varying(160) NOT NULL,
  mrgsp_isapply boolean DEFAULT false,
  CONSTRAINT cgg_migrationscript_pkey PRIMARY KEY (mrgsp_codigo )
)
WITH (
  OIDS=FALSE
);