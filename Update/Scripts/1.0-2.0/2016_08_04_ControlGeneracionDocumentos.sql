CREATE TABLE sii.cgg_ecm_doc_control
(
  document_type character varying NOT NULL,
  record_id character varying NOT NULL,
  date_created timestamp NOT NULL,
  CONSTRAINT cgg_ecm_doc_control_pkey PRIMARY KEY (document_type, record_id)
);

-->ENTRADAS PARA GESTION DE ARCHIVOS DE PERSONA JURIDICA:

DO $$DECLARE v_code VARCHAR; v_file_code VARCHAR;
BEGIN
	SELECT sii.f_keygen('Cgg_ECM_Metadata','code','ECM') INTO v_code;
	INSERT INTO sii.cgg_ecm_metadata(
		    code, table_name, filter, files_repository, is_list,
		    estado, usuario_insert, usuario_update)
	    VALUES (v_code, 'Cgg_res_persona_juridica', null, null, true,
		    true, 'admin', 'admin');


	SELECT sii.f_keygen('Cgg_ECM_File','code','ECMFL') INTO v_file_code;
	INSERT INTO sii.cgg_ecm_file(
            code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository,
            override_name, estado, usuario_insert, usuario_update)
	VALUES ( v_file_code, v_code, 'identificacion', 'RUC', 'D:sii:personales','alfpath.idempresa.path',
            true, true, 'ADMIN', 'ADMIN');

  INSERT INTO sii.cgg_ecm_file_index(
            cgg_ecm_file_code, cgg_ecm_index_definition_code)
	    VALUES (v_file_code, 'IDX_ALM');

	INSERT INTO sii.cgg_ecm_file_index(
		    cgg_ecm_file_code, cgg_ecm_index_definition_code)
	    VALUES (v_file_code, 'IDX_IDN');

	INSERT INTO sii.cgg_ecm_file_index(
		    cgg_ecm_file_code, cgg_ecm_index_definition_code)
	    VALUES (v_file_code, 'IDX_CAD');
END$$;
