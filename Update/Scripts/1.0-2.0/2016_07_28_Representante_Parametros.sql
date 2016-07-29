INSERT INTO sii.cgg_res_tst_opcion(
            crtso_codigo, crtso_nombre, crtso_descripcion, crtso_estado,
            crtso_fecha_insert, crtso_usuario_insert, crtso_fecha_update,
            crtso_usuario_update)
    VALUES ('CRTSO15', 'Representante', 'Habilita el ingreso del representante', TRUE,
            CURRENT_TIMESTAMP , 'admin', CURRENT_TIMESTAMP ,
            'admin');
--sii.f_keygen('cgg_res_tst_opcion','crtso_codigo','CRTSO')


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','PARAMETROS REPRESENTANTES','Definicion de Opciones para tipo solicitud tramite',
	'2.0','2016_07_28_Representante_Parametros.sql',true);