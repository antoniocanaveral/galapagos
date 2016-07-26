INSERT INTO sii.cgg_ecm_metadata(
		    code, table_name, filter, files_repository, is_list,
		    estado, usuario_insert, usuario_update)
	    VALUES (sii.f_keygen('Cgg_ECM_Metadata','code','ECM'), 'Cgg_res_carnet', null, 'alfpath.carnet.path', false,
		    true, 'admin', 'admin');


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','ADJUNTOS PARA CARNETIZACION','Definiciones de Adjuntos de subida libre, para carnetización.',
	'2.0','2016_07_26_Adjuntos_Carnet.sql',true);