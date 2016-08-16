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

--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','CGGSII-30','Creación de la tabla cgg_res_documentacion_solicitada usada en la solicitud de un trámite de residencia, para listar los documentos necesarios según el trámite a solicitar',
	'1.0','2016_06_14_cgg_res_documentacion_solicitada.sql',true);