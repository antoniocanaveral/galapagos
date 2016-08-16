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
