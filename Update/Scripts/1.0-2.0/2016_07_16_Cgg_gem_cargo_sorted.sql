CREATE OR REPLACE FUNCTION sii.f_cgg_gem_cargo_select_as(in_user_name character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CGCRG_CODIGO,
		CGARE_CODIGO,
		CGCRG_NOMBRE,
		CGCRG_DESCRIPCION,
		CGCRG_ESTADO,
		CGCRG_FECHA_INSERT,
		CGCRG_USUARIO_INSERT,
		CGCRG_FECHA_UPDATE,
		CGCRG_USUARIO_UPDATE
	FROM SII.CGG_GEM_CARGO
	WHERE CGCRG_ESTADO = TRUE
	ORDER BY CGCRG_NOMBRE;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

  --> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','GEM CARGO SORTED','Modifica la consulta GEM CARGO para devolver los datos ordenados.',
	'2.0','2016_07_16_Cgg_gem_cargo_sorted.sql',true);