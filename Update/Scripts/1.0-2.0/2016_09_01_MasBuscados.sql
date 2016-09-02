CREATE TABLE sii.cgg_srv_mas_buscados
(
   tipoIdentificacion character varying(10),
   identificacion character varying(20),
   apellidoPaterno character varying,
   apellidoMaterno character varying,
   nombres character varying,
   fecha timestamp,
   estado boolean
)
WITH (
  OIDS = FALSE
)
;

ALTER TABLE cgg_srv_mas_buscados
  ADD CONSTRAINT unq_mas_buscados UNIQUE (tipoidentificacion, identificacion);




--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','Mas Buscados','Datos necesarios para el servicio de los Mas Buscados',
	'2.0','2016_09_01_MasBuscados.sql',true);