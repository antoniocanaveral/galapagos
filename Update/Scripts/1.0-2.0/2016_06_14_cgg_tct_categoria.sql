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
