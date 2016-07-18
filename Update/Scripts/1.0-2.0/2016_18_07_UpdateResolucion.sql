update sii.cgg_res_fase set CRFAS_FUNCION_EJECUTA='com.bmlaurus.phaserule.GenerarResolucion' where CRFAS_FUNCION_EJECUTA='F_GENERAR_RESIDENCIA';




 --> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','RESOLUCIONES EN JAVA','Cambia las llamadas a F_GENERAR_RESIDENCIA, para que llame a la función Java, que además genera las resoluciones',
	'2.0','2016_18_07_UpdateResolucion.sql',true);