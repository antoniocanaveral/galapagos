ALTER TABLE sii.CGG_ECM_FILE ADD COLUMN INSERTABLE boolean DEFAULT true;
ALTER TABLE sii.CGG_ECM_FILE ADD COLUMN UPDATEABLE boolean DEFAULT true;
ALTER TABLE sii.CGG_ECM_FILE ADD COLUMN MANDATORY boolean DEFAULT false;
ALTER TABLE sii.CGG_ECM_FILE ADD COLUMN VISIBLE_ROLE character varying;
ALTER TABLE sii.CGG_ECM_FILE ADD COLUMN EDITABLE_ROLE character varying;


--ESTANDARIZAMOS LOS ARCHIVOS EXISTENTES
update cgg_ecm_file set file_name ='cert_votacion' where file_name = 'PapeletaVotacion';
update cgg_ecm_file set file_name ='cert_votacion' where file_name = 'papeleta';
update cgg_ecm_file set file_name ='identificacion' where file_name = 'pasaporte';
update cgg_ecm_file set file_repository ='alfpath.beneficiario.path' where file_repository = 'Personales/@cgg_crper_codigo;cgg_res_persona.crper_num_doc_identific@';
update cgg_ecm_file set file_repository ='alfpath.auspiciante.path' where file_repository = 'Personales/@crper_codigo;cgg_res_persona.crper_num_doc_identific@';
update cgg_ecm_file set file_repository ='alfpath.identificacion.path' where file_repository = 'Personales/@crper_num_doc_identific@';


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','CONFIGURACION AVANZADA ALFRESCO','Agrega funcionalidad avanzada a la gestion de repisitorios',
	'2.0','2016_07_20_ConfiguracionArchivos.sql',true);