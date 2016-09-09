CREATE OR REPLACE FUNCTION f_cgg_res_datos_personales_byresidencia(inCrrsd_numero_residencia character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		PER.CRPER_NOMBRES,
		PER.CRPER_APELLIDO_PATERNO,
		PER.CRPER_APELLIDO_MATERNO,
		PER.CRPER_NUM_DOC_IDENTIFIC,
		PER.CRPER_FECHA_NACIMIENTO,
		PER.CRPER_GENERO,
		PER.CRPER_NUMERO_RESIDENCIA,
		PER.CGG_CPAIS_CODIGO,
		PER.CCTN_CODIGO,
		PER.CPRR_CODIGO,
		PER.CRPER_EMPLEADO,
		PER.CRPER_ASPIRACION_SALARIAL,
		RES.CRRSD_NUMERO_RESIDENCIA
	FROM CGG_RES_RESIDENCIA RES
		JOIN CGG_RES_PERSONA PER ON RES.CRPER_CODIGO = PER.CRPER_CODIGO
	WHERE RES.crrsd_numero_residencia = inCrrsd_numero_residencia
		AND RES.crrsd_vigente
		AND res.crrsd_estado
		AND (res.crrsd_fecha_caducidad is null or res.crrsd_fecha_caducidad>current_timestamp);
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
	true,'acanaveral','Consulta de Auspiciante para Hospedaje','Consulta de Auspiciante para Hospedaje',
	'2.0','Update/Scripts/1.0-2.0/2016_09_08_ConsultaAuspicianteHospedaje.sql',true);