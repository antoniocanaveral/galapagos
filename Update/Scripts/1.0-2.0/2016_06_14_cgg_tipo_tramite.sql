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