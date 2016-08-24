-- Function: sii.f_cgg_res_documentacion_solicitada_count(text)

-- DROP FUNCTION sii.f_cgg_res_documentacion_solicitada_count(text);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_documentacion_solicitada_count(in_find_text text)
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_RES_DOCUMENTACION_SOLICITADA
	WHERE CRDCSL_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(CRDCSL_DESCRIPCION, '''')||' '||COALESCE(CRDCSL_TIPO, '''')) = 1;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_res_documentacion_solicitada_count(text)
  OWNER TO postgres;

--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','f_cgg_res_documentacion_solicitada_count','',
	'1.0','2016_06_14_f_cgg_res_documentacion_solicitada_count.sql',true);