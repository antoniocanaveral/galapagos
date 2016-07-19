DO $$DECLARE v_code VARCHAR; v_file_code VARCHAR;
BEGIN
	SELECT sii.f_keygen('Cgg_ECM_Metadata','code','ECM') INTO v_code;
	INSERT INTO sii.cgg_ecm_metadata(
		    code, table_name, filter, files_repository, is_list,
		    estado, usuario_insert, usuario_update)
	    VALUES (v_code, 'Cgg_res_persona', 'tipoResidencia=CRTST7', null, true,
		    true, 'admin', 'admin');


	SELECT sii.f_keygen('Cgg_ECM_File','code','ECMFL') INTO v_file_code;
	INSERT INTO sii.cgg_ecm_file(
            code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository,
            override_name, estado, usuario_insert, usuario_update)
	VALUES ( v_file_code, v_code, 'identificacion', 'Documento de Identidad', 'D:sii:personales','alfpath.identificacion.path',
            true, true, 'ADMIN', 'ADMIN');

  INSERT INTO sii.cgg_ecm_file_index(
		    cgg_ecm_file_code, cgg_ecm_index_definition_code)
	    VALUES (v_file_code, 'IDX_IDN');

	SELECT sii.f_keygen('Cgg_ECM_File','code','ECMFL') INTO v_file_code;
	INSERT INTO sii.cgg_ecm_file(
            code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository,
            override_name, estado, usuario_insert, usuario_update)
	VALUES (v_file_code , v_code, 'cert_votacion', 'Certificado de Votacion', 'D:sii:personales','alfpath.identificacion.path',
            true, true, 'ADMIN', 'ADMIN');

  INSERT INTO sii.cgg_ecm_file_index(
		    cgg_ecm_file_code, cgg_ecm_index_definition_code)
	    VALUES (v_file_code, 'IDX_IDN');

	SELECT sii.f_keygen('Cgg_ECM_File','code','ECMFL') INTO v_file_code;
	INSERT INTO sii.cgg_ecm_file(
            code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository,
            override_name, estado, usuario_insert, usuario_update)
	VALUES (v_file_code , v_code, 'acreditacion', 'Acreditación de Actividad', 'D:sii:personales','alfpath.identificacion.path',
            true, true, 'ADMIN', 'ADMIN');

	INSERT INTO sii.cgg_ecm_file_index(
		    cgg_ecm_file_code, cgg_ecm_index_definition_code)
	    VALUES (v_file_code, 'IDX_IDN');

END$$;

--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','ATTACHMENT BENEFICIARIOS TRANSEUNTES','Definiciones de Metadata para la tabla personas de los procesos de transeunte',
	'2.0','2016_07_19_AdjuntosBeneficiariosTranseuntes.sql',true);