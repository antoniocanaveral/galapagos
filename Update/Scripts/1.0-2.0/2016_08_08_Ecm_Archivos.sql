  /*
ECM ARCHIVO-> GESTION DE DOCUMENTOS
ECMCH
*/
CREATE TABLE sii.cgg_ecm_archivo
(
  ECMCH_CODIGO character varying NOT NULL PRIMARY KEY,
  ECMCH_TIPO character varying NOT NULL,
  ECMCH_ASUNTO character varying NOT NULL,
  ECMCH_FECHA timestamp,
  ECMCH_DESCRIPCION character varying,
  ECMCH_EXTRACTO text,
  ECMCH_ESTADO boolean DEFAULT true,
  ECMCH_USUARIO_INSERT character varying NOT NULL,
  ECMCH_FECHA_INSERT timestamp,
  ECMCH_USUARIO_UPDATE character varying NOT NULL,
  ECMCH_FECHA_UPDATE timestamp,
  ECMCH_UPDATEABLE boolean DEFAULT true
)
WITH (
  OIDS=FALSE
);



/*
sii.F_CGG_ECM_ARCHIVO_SELECT(?,?,?,?,?,?)
F_CGG_ECM_ARCHIVO_COUNT(?)
F_CGG_ECM_ARCHIVO_COUNT()
*/