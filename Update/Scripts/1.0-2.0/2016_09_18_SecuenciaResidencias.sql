ALTER TABLE SII.CGG_SECUENCIA ADD COLUMN CRRSD_MODALIDAD NUMERIC;
ALTER TABLE SII.CGG_SECUENCIA ADD COLUMN CISLA_CODIGO VARCHAR(20);

INSERT INTO SII.CGG_SECUENCIA VALUES ('RESPER1',0,2016,0,'CISLA1');
INSERT INTO SII.CGG_SECUENCIA VALUES ('RESPER2',0,2016,0,'CISLA2');
INSERT INTO SII.CGG_SECUENCIA VALUES ('RESPER3',0,2016,0,'CISLA3');

INSERT INTO SII.CGG_SECUENCIA VALUES ('RESTMP1',0,2016,0,'CISLA1');
INSERT INTO SII.CGG_SECUENCIA VALUES ('RESTMP2',0,2016,0,'CISLA2');
INSERT INTO SII.CGG_SECUENCIA VALUES ('RESTMP3',0,2016,0,'CISLA3');
INSERT INTO SII.CGG_SECUENCIA VALUES ('RESTMP4',0,2016,0,NULL);



--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','Modifica el la Secuencia de las Residencias','Permite seleccionar las secuencias de las residencias desde la tabla CGG_SECUENCIA',
	'2.0','Update/Scripts/1.0-2.0/2016_09_18_SecuenciaResidencias.sql',true);