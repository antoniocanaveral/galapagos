  /*
ECM ARCHIVO-> GESTION DE DOCUMENTOS
ECMCH
*/
CREATE TABLE sii.cgg_ecm_archivo
(
  ECMCH_CODIGO character varying NOT NULL PRIMARY KEY,
  ECMCH_TIPO character varying NOT NULL,
  ECMCH_ASUNTO character varying NOT NULL,
  ECMCH_FECHA timestamp,
  ECMCH_DESCRIPCION character varying,
  ECMCH_EXTRACTO text,
  ECMCH_ESTADO boolean DEFAULT true,
  ECMCH_USUARIO_INSERT character varying NOT NULL,
  ECMCH_FECHA_INSERT timestamp,
  ECMCH_USUARIO_UPDATE character varying NOT NULL,
  ECMCH_FECHA_UPDATE timestamp,
  ECMCH_UPDATEABLE boolean DEFAULT true
)
WITH (
  OIDS=FALSE
);



CREATE OR REPLACE FUNCTION sii.f_cgg_ecm_archivo_select(in_user_name character varying, in_start_index integer, in_limit integer, in_sort_field_name character varying, in_direction character varying, in_find_text text)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		ECMCH_CODIGO,
    ECMCH_TIPO,
    ECMCH_ASUNTO,
    ECMCH_FECHA,
    ECMCH_DESCRIPCION,
    ECMCH_EXTRACTO,
    ECMCH_ESTADO,
    ECMCH_USUARIO_INSERT,
    ECMCH_FECHA_INSERT,
    ECMCH_USUARIO_UPDATE,
    ECMCH_FECHA_UPDATE,
    ECMCH_UPDATEABLE
	FROM SII.CGG_ECM_ARCHIVO
	WHERE ECMCH_TIPO <> ''PERS'' OR '''||in_user_name||'''= ECMCH_USUARIO_INSERT
	AND ECMCH_ESTADO = TRUE AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(ECMCH_TIPO, '''')||'' ''||COALESCE(ECMCH_ASUNTO, '''')||'' ''||COALESCE(ECMCH_USUARIO_INSERT, '''')||'' ''||COALESCE(ECMCH_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(ECMCH_USUARIO_UPDATE, '''')||'' ''||COALESCE(ECMCH_FECHA_UPDATE, CURRENT_TIMESTAMP)) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


CREATE OR REPLACE FUNCTION sii.f_cgg_ecm_archivo_count(in_user_name character varying)
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_ECM_ARCHIVO
	WHERE (ECMCH_TIPO <> 'PERS' OR in_user_name = ECMCH_USUARIO_INSERT)
	AND ECMCH_ESTADO = TRUE;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION sii.f_cgg_ecm_archivo_count(in_user_name character varying, in_find_text text)
  RETURNS integer AS
$BODY$
DECLARE
TMP_ROWS INT2;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_ECM_ARCHIVO
	WHERE (ECMCH_TIPO <> 'PERS' OR in_user_name = ECMCH_USUARIO_INSERT)
	AND ECMCH_ESTADO = TRUE AND SII.F_STRING_IN(IN_FIND_TEXT,COALESCE(ECMCH_TIPO, '''')||' '||COALESCE(ECMCH_ASUNTO, '''')||' '||COALESCE(ECMCH_USUARIO_INSERT, '''')||' '||COALESCE(ECMCH_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||COALESCE(ECMCH_USUARIO_UPDATE, '''')||' '||COALESCE(ECMCH_FECHA_UPDATE, CURRENT_TIMESTAMP)) = 1;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;



INSERT INTO sii.cgg_ecm_metadata(
		    code, table_name, filter, files_repository, is_list,
		    estado, usuario_insert, usuario_update)
	    VALUES (sii.f_keygen('Cgg_ECM_Metadata','code','ECM'), 'Cgg_ecm_archivo', null, 'alfpath.repositorio.path', false,
		    true, 'admin', 'admin');


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','ADMINISTRACION DE ARCHIVOS','Ventanas y Funcionalidad para gestión de archivos',
	'2.0','2016_08_08_Ecm_Archivos.sql',true);