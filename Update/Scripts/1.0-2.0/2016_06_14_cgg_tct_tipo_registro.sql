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
