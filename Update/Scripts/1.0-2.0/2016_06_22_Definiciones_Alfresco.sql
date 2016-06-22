-->ENTRADAS PARA GESTION DE ARCHIVOS:

--//Gestion de Archivos para Informe Seguimiento
INSERT INTO sii.cgg_ecm_metadata(
            code, table_name, filter, files_repository, is_list,
            estado, usuario_insert, usuario_update)
    VALUES (sii.f_keygen('Cgg_ECM_Metadata','code','ECM'), 'Cgg_res_informe_seguimiento', null, 'Tramites/@crseg_codigo;cgg_res_seguimiento.crtra_codigo@/informes', false,
            true, 'admin', 'admin');





--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','DEFINICIONES DE ALFRESCO','Definiciones de Metadata para que las herramientas de Alfresco funcionen en cada ventana parametrizada',
	'2.0','2016_06_22_Definiciones_Alfresco.sql',true);