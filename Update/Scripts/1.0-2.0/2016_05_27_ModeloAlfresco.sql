--DEFINICION DE LOS INDICES DE ALFRESCO
CREATE TABLE sii.CGG_ECM_INDEX_DEFINITION
(
   CODE character varying NOT NULL PRIMARY KEY,
   INDEX_NAME character varying NOT NULL,
   INDEX_ASPECT character varying NOT NULL,
   INDEX_DESCRIPTION character varying,
   ESTADO boolean DEFAULT TRUE,
   USUARIO_INSERT character varying NOT NULL,
   USUARIO_UPDATE character varying NOT NULL
);

CREATE TABLE sii.CGG_ECM_INDEX_ITEM
(
   CODE character varying NOT NULL PRIMARY KEY,
   CGG_ECM_INDEX_DEFINITION_CODE character varying NOT NULL,
   ITEM_NAME character varying NOT NULL,
   ITEM_ASPECT character varying NOT NULL,
   ITEM_DATA_TYPE character varying NOT NULL,
   ITEM_LABEL character varying NOT NULL,
   IS_MANDATORY boolean DEFAULT FALSE,
   INTERNAL boolean DEFAULT FALSE,
   ESTADO boolean DEFAULT TRUE,
   USUARIO_INSERT character varying NOT NULL,
   USUARIO_UPDATE character varying NOT NULL
);

ALTER TABLE sii.CGG_ECM_INDEX_ITEM ADD CONSTRAINT cgg_ecm_index_item_to_index_definition FOREIGN KEY (CGG_ECM_INDEX_DEFINITION_CODE) REFERENCES sii.CGG_ECM_INDEX_DEFINITION (code)
   ON UPDATE NO ACTION ON DELETE NO ACTION;
CREATE INDEX fki_cgg_ecm_index_item_to_index_definition ON sii.CGG_ECM_INDEX_ITEM(CGG_ECM_INDEX_DEFINITION_CODE);

--DEFINICION DE LA METADATA PARA LOS ARCHIVOS
CREATE TABLE sii.CGG_ECM_METADATA
(
   CODE character varying NOT NULL PRIMARY KEY,
   TABLE_NAME character varying NOT NULL,
   FILTER character varying,
   FILES_REPOSITORY character varying,
   IS_LIST boolean DEFAULT FALSE,
   ESTADO boolean DEFAULT TRUE,
   USUARIO_INSERT character varying NOT NULL,
   USUARIO_UPDATE character varying NOT NULL
);
ALTER TABLE sii.CGG_ECM_METADATA ADD CONSTRAINT CGG_ECM_METADATA_UNIQUE UNIQUE (table_name, filter);


CREATE TABLE sii.CGG_ECM_FILE
(
   CODE character varying NOT NULL PRIMARY KEY,
   CGG_ECM_METADATA_CODE character varying NOT NULL,
   FILE_NAME character varying NOT NULL,
   FILE_DESCRIPTION character varying,
   DOCUMENT_TYPE character varying NOT NULL DEFAULT 'D:sii:respaldo',
   FILE_REPOSITORY character varying NOT NULL,
   OVERRIDE_NAME boolean DEFAULT FALSE,
   ESTADO boolean DEFAULT TRUE,
   USUARIO_INSERT character varying NOT NULL,
   USUARIO_UPDATE character varying NOT NULL
);

ALTER TABLE sii.cgg_ecm_file ADD CONSTRAINT cgg_ecm_file_to_metadata FOREIGN KEY (cgg_ecm_metadata_code) REFERENCES sii.cgg_ecm_metadata (code)
   ON UPDATE NO ACTION ON DELETE NO ACTION;
CREATE INDEX fki_cgg_ecm_file_to_metadata ON sii.cgg_ecm_file(cgg_ecm_metadata_code);


CREATE TABLE sii.CGG_ECM_FILE_INDEX
(
  CGG_ECM_FILE_CODE character varying NOT NULL,
  CGG_ECM_INDEX_DEFINITION_CODE character varying NOT NULL
);
ALTER TABLE sii.cgg_ecm_file_index ADD CONSTRAINT cgg_ecm_file_index_pk PRIMARY KEY (cgg_ecm_file_code, cgg_ecm_index_definition_code);
ALTER TABLE sii.cgg_ecm_file_index ADD CONSTRAINT cgg_ecm_file_index_file_fk FOREIGN KEY (cgg_ecm_file_code) REFERENCES sii.cgg_ecm_file (code)
  ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE sii.cgg_ecm_file_index ADD CONSTRAINT cgg_ecm_file_index_index_fk FOREIGN KEY (cgg_ecm_index_definition_code) REFERENCES sii.cgg_ecm_index_definition (code)
  ON UPDATE NO ACTION ON DELETE NO ACTION;



-->DEFINICION DE LOS INDICES
-->ALMACENABLE
INSERT INTO sii.cgg_ecm_index_definition(
            code, index_name, index_aspect, index_description, estado,
            usuario_insert, usuario_update)
    VALUES ('IDX_ALM', 'Almacenable', 'P:sii:almacenable', 'Permite relacionar el adjunto con el archivo físico', true,'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_index_item(
            code, cgg_ecm_index_definition_code, item_name, item_aspect, item_data_type,
            item_label, is_mandatory, estado, usuario_insert, usuario_update)
    VALUES ('ITEM_DESCRIPCION', 'IDX_ALM', 'DESCRIPCION_NAME', 'sii:descripcion', 'TEXT',
            'Descripción del Almacenamiento', false, true, 'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_index_item(
            code, cgg_ecm_index_definition_code, item_name, item_aspect, item_data_type,
            item_label, is_mandatory, estado, usuario_insert, usuario_update)
    VALUES ('ITEM_CARPETA', 'IDX_ALM', 'CARPETA_NAME', 'sii:carpeta', 'STRING',
            'Número de Carpeta', true, true, 'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_index_item(
            code, cgg_ecm_index_definition_code, item_name, item_aspect, item_data_type,
            item_label, is_mandatory, estado, usuario_insert, usuario_update)
    VALUES ('ITEM_CAJA', 'IDX_ALM', 'CAJA_NAME', 'sii:caja', 'STRING',
            'Número de Caja', true, true, 'ADMIN', 'ADMIN');

-->CADUCABLE
INSERT INTO sii.cgg_ecm_index_definition(
            code, index_name, index_aspect, index_description, estado,
            usuario_insert, usuario_update)
    VALUES ('IDX_CAD', 'Caducable', 'P:sii:caducable', 'Añade una fecha de caducidad del adjunto', true,'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_index_item(
            code, cgg_ecm_index_definition_code, item_name, item_aspect, item_data_type,
            item_label, is_mandatory, estado, usuario_insert, usuario_update)
    VALUES ('ITEM_FECHA', 'IDX_CAD', 'CADUCIDAD_NAME', 'sii:caducidad', 'DATE',
            'Fecha de Caducidad del Documento', true, true, 'ADMIN', 'ADMIN');

-->IDENTIFICABLE -> INTERNO
INSERT INTO sii.cgg_ecm_index_definition(
            code, index_name, index_aspect, index_description, estado,
            usuario_insert, usuario_update)
    VALUES ('IDX_IDN', 'Identificable', 'P:sii:identificable', 'Relaciona el adjunto en Alfresco, con la base de datos de SII', true,'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_index_item(
            code, cgg_ecm_index_definition_code, item_name, item_aspect, item_data_type,
            item_label, is_mandatory, internal, estado, usuario_insert, usuario_update)
    VALUES ('ITEM_RECORD_ID', 'IDX_IDN', 'RECORD_ID_NAME', 'sii:record_id', 'STRING',
            'Identificador del Registro', true, true, true, 'ADMIN', 'ADMIN');
INSERT INTO sii.cgg_ecm_index_item(
            code, cgg_ecm_index_definition_code, item_name, item_aspect, item_data_type,
            item_label, is_mandatory, internal, estado, usuario_insert, usuario_update)
    VALUES ('ITEM_TABLA', 'IDX_IDN', 'TABLE_NAME_NAME', 'sii:table_name', 'STRING',
            'Nombre de la Tabla SII', true, true, true, 'ADMIN', 'ADMIN');

--///TEST DATA
--//EJEMPLO PARA LISTAS DE ARCHIVOS
INSERT INTO sii.cgg_ecm_metadata(
            code, table_name, filter, files_repository, is_list,
            estado, usuario_insert, usuario_update)
    VALUES ('TEST1', 'TABLA_PRUEBA', null, null, true,
            true, 'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_file(
            code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository,
            override_name, estado, usuario_insert, usuario_update)
    VALUES ('FILE_TEST1', 'TEST1', 'cedula', 'Documento de Identidad', 'D:sii:respaldo','test/listas/carpeta_usuario',
            true, true, 'ADMIN', 'ADMIN');

INSERT INTO sii.cgg_ecm_file(
            code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository,
            override_name, estado, usuario_insert, usuario_update)
    VALUES ('FILE_TEST2', 'TEST1', 'papeleta', 'Documento de Votación', 'D:sii:personales', 'test/listas/carpeta_usuario',
            true, true, 'ADMIN', 'ADMIN');


INSERT INTO sii.cgg_ecm_file_index(
            cgg_ecm_file_code, cgg_ecm_index_definition_code)
    VALUES ('FILE_TEST1', 'IDX_ALM');

INSERT INTO sii.cgg_ecm_file_index(
            cgg_ecm_file_code, cgg_ecm_index_definition_code)
    VALUES ('FILE_TEST1', 'IDX_IDN');

INSERT INTO sii.cgg_ecm_file_index(
            cgg_ecm_file_code, cgg_ecm_index_definition_code)
    VALUES ('FILE_TEST1', 'IDX_CAD');

INSERT INTO sii.cgg_ecm_file_index(
            cgg_ecm_file_code, cgg_ecm_index_definition_code)
    VALUES ('FILE_TEST2', 'IDX_ALM');

--//EJEMPLO PARA SUBIDA LIBRE
INSERT INTO sii.cgg_ecm_metadata(
            code, table_name, filter, files_repository, is_list,
            estado, usuario_insert, usuario_update)
    VALUES ('TEST2', 'TABLA_PRUEBA_2', null, 'test/libre/carpeta_usuario', false,
            true, 'ADMIN', 'ADMIN');

--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','MODELO ALFRESCO','Crea las tablas necesarias para la gestion de archivos con Alfresco',
	'2.0','2016_05_27_ModeloAlfresco.sql',true);