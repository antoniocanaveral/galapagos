DROP FUNCTION sii.f_keygen(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_old_keygen(intablename character varying, incolname character varying, inabr character varying)
  RETURNS character varying AS
$BODY$
DECLARE
TMP_NUMREGISTROS NUMERIC;
TMP_EXISTS NUMERIC;
OUT_KEY VARCHAR;
BEGIN
	EXECUTE 'SELECT COUNT('||INCOLNAME||')+1 FROM sii.'||INTABLENAME INTO TMP_NUMREGISTROS;
	OUT_KEY := INABR||TMP_NUMREGISTROS;
	EXECUTE 'SELECT COUNT('||INCOLNAME||') FROM sii.'||INTABLENAME||' WHERE '||INCOLNAME||' = $1' INTO TMP_EXISTS USING OUT_KEY;
	IF (TMP_EXISTS > 0) THEN
		FOR I IN 1..TMP_NUMREGISTROS LOOP
			EXECUTE 'SELECT COUNT('||INCOLNAME||') FROM sii.'||INTABLENAME||' WHERE '||INCOLNAME||' = $1' INTO TMP_EXISTS USING INABR||I;
			IF (TMP_EXISTS = 0) THEN
				OUT_KEY := INABR||I;
				EXIT;
			END IF;
		END LOOP;
	END IF;
	RETURN OUT_KEY;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION sii.f_keygen(intablename character varying, incolname character varying, inabr character varying)
  RETURNS character varying AS
$BODY$
DECLARE
GENERATED_OUT VARCHAR;
BEGIN
	select nextval('SII.seq_'||lower(intablename)||'_'||lower(incolname)) INTO GENERATED_OUT;
	RETURN inabr||GENERATED_OUT;
EXCEPTION WHEN others THEN
	RAISE NOTICE '%; SQLSTATE: %', SQLERRM, SQLSTATE;
	SELECT SII.F_OLD_KEYGEN(intablename,incolname,inabr) INTO GENERATED_OUT;
	SELECT translate(GENERATED_OUT,inabr,'') into GENERATED_OUT;
	--CREATE SEQUENCE
	RAISE NOTICE 'CREATING SEQUENCE';
	EXECUTE 'CREATE SEQUENCE SII.'||'seq_'||lower(intablename)||'_'||lower(incolname)
		||' INCREMENT 1'
		||' START '||GENERATED_OUT;
	RETURN inabr||GENERATED_OUT;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','CGGSII-30','Modifica la funcion f_keygen, para usar secuencias nativas de la base de datos. Va creando las secuencias a demanda, actualizando el indice',
	'2.0','2016_04_25_SecuenciasNativas.sql',true);