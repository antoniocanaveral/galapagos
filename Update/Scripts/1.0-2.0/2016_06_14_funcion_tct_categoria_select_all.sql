-- Function: sii.f_cgg_tct_categoria_select_as(character varying)

-- DROP FUNCTION sii.f_cgg_tct_categoria_select_as(character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_tct_categoria_select_as(in_user_name character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		TCTCAT_CODIGO, 
		TCTCAT_NOMBRE	
	FROM SII.CGG_TCT_CATEGORIA
	WHERE TCTCAT_ESTADO = TRUE;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION sii.f_cgg_tct_categoria_select_as(character varying)
  OWNER TO postgres;


--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','f_cgg_tct_categoria_select_as','',
	'1.0','2016_06_14_f_cgg_tct_categoria_select_as.sql',true);