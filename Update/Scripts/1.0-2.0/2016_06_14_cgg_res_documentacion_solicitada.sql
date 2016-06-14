-- Table: sii.cgg_res_documentacion_solicitada

-- DROP TABLE sii.cgg_res_documentacion_solicitada;

CREATE TABLE sii.cgg_res_documentacion_solicitada
(
  crdcsl_codigo character varying(20) NOT NULL, -- IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO
  crdcsl_descripcion character varying(250), --DESCRIPCION DEL DOCUMENTO
  crdcsl_estado boolean, -- ESTADO DEL REGISTRO
  CONSTRAINT pk_cgg_res_documentacion_solicitada PRIMARY KEY (crdcsl_codigo)
)
WITH (
  OIDS=FALSE
);