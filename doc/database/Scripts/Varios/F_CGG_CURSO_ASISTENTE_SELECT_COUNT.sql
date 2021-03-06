/**
* FUNCION F_CGG_DHU_CURSO_ASISTENTE_SELECT_COUNT
* CONTABILIZA LOS REGISTRO EN LA TABLA SII.CGG_DHU_BECA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return  TMP_ROWS 
*/
CREATE OR REPLACE FUNCTION F_CGG_DHU_CURSO_ASISTENTE_SELECT_COUNT(in_find_text text)
  RETURNS integer AS
$BODY$
DECLARE
	TMP_ROWS INT2;
BEGIN
	
	SELECT COUNT(*)	
	FROM SII.CGG_DHU_CURSO CU
	INNER JOIN SII.CGG_CANTON CN ON (CN.CCTN_CODIGO=CU.CCTN_CODIGO)
	INNER JOIN SII.CGG_ISLA ISL ON(ISL.CCTN_CODIGO=ISL.CCTN_CODIGO)
	INNER JOIN SII.CGG_DHU_TIPO_CURSO TC ON(TC.CDTCR_CODIGO=CU.CDTCR_CODIGO)
	INNER JOIN SII.CGG_SECTOR_PRODUCTIVO SP ON(SP.CSCTP_CODIGO=CU.CSCTP_CODIGO)
	INNER JOIN SII.CGG_DHU_INSTITUCION_RESPONSABLE ITR ON(ITR.CDITR_CODIGO=CU.CDITR_CODIGO)
	INNER JOIN SII.CGG_RES_PERSONA PER ON(PER.CRPER_CODIGO=CU.CRPER_CODIGO)
	WHERE CDCUR_ESTADO = TRUE AND CU.CDCUR_ESTADO_CURSO=0 OR CU.CDCUR_ESTADO_CURSO=1 OR CU.CDCUR_ESTADO_CURSO=2 OR CU.CDCUR_ESTADO_CURSO=3 AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
	COALESCE(TC.CDTCR_NOMBRE,'''')||' '||
	COALESCE(CN.CCTN_NOMBRE,'''')||' '||
	COALESCE(TC.CDTCR_NOMBRE,'''')||' '||
	COALESCE(SP.CSCTP_NOMBRE,'''')||' '||
	COALESCE(ITR.CDITR_NOMBRE,'''')||' '||
	COALESCE(CU.CDCUR_DESCRIPCION, '''')||' '||
	COALESCE(CU.CDCUR_FECHA_PREVISTA_INICIO,CURRENT_TIMESTAMP)||' '||
	COALESCE(CU.CDCUR_FECHA_INICIO, CURRENT_TIMESTAMP)||' '||
	COALESCE(CU.CDCUR_FECHA_CULMINACION, CURRENT_TIMESTAMP)||' '||
	COALESCE(CU.CDCUR_FECHA_PREVISTA_CULMINACION,CURRENT_TIMESTAMP)||' '|
	COALESCE(CU.CDCUR_NUMERO_ASISTENTE, 0)||' '||
	COALESCE(CU.CDCUR_ESTADO_CURSO, 0)||' '||
	COALESCE(CU.CDCUR_ESTADO, FALSE)||' '||
	COALESCE(CU.CDCUR_FECHA_INSERT, CURRENT_TIMESTAMP)||' '||
	COALESCE(CU.CDCUR_USUARIO_INSERT, '''')||' '||
	COALESCE(CU.CDCUR_FECHA_UPDATE, CURRENT_TIMESTAMP)||' '||
	COALESCE(CU.CDCUR_USUARIO_UPDATE, '''')) = 1;
	
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION F_CGG_DHU_CURSO_ASISTENTE_SELECT_COUNT(text) OWNER TO sii;


/**
* FUNCION sii.f_cgg_dhu_curso_asistente_select_countCdtcr_codigo
* CONTABILIZA LOS REGISTRO EN LA TABLA SII.CGG_DHU_BECA.
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @param IN_CDTCR_CODIGO CRITERIO DE BUSQUEDA
* @return  TMP_ROWS 
*/
CREATE OR REPLACE FUNCTION sii.f_cgg_dhu_curso_asistente_select_countCdtcr_codigo(in_find_text text,IN_CDTCR_CODIGO varchar)
  RETURNS integer AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
	TOTALCADENA INT;
	CODIGOCURSO TEXT[];
	TMPWHERE TEXT;
	TMP_ROWS INT4;
	TMP TEXT;
BEGIN
	CODIGOCURSO := STRING_TO_ARRAY(IN_CDTCR_CODIGO, ';');
	TOTALCADENA := ARRAY_LENGTH(CODIGOCURSO, 1);	
	TMPWHERE:='';
	FOR I IN 1..TOTALCADENA LOOP
			TMPWHERE := TMPWHERE||'CU.CDTCR_CODIGO='''||CODIGOCURSO[I]||'''';
			IF (I < TOTALCADENA) THEN
				TMPWHERE := TMPWHERE||' OR ';
			END IF;
	END LOOP;
	
	TMP:='SELECT COUNT(*)
	FROM SII.CGG_DHU_CURSO CU
	INNER JOIN SII.CGG_CANTON CN ON (CN.CCTN_CODIGO=CU.CCTN_CODIGO)
	INNER JOIN SII.CGG_DHU_TIPO_CURSO TC ON(TC.CDTCR_CODIGO=CU.CDTCR_CODIGO)
	INNER JOIN SII.CGG_SECTOR_PRODUCTIVO SP ON(SP.CSCTP_CODIGO=CU.CSCTP_CODIGO)
	INNER JOIN SII.CGG_DHU_INSTITUCION_RESPONSABLE ITR ON(ITR.CDITR_CODIGO=CU.CDITR_CODIGO)
	INNER JOIN SII.CGG_RES_PERSONA PER ON(PER.CRPER_CODIGO=CU.CRPER_CODIGO)
	WHERE CDCUR_ESTADO = TRUE AND (CU.CDCUR_ESTADO_CURSO=0 OR CU.CDCUR_ESTADO_CURSO=1 OR CU.CDCUR_ESTADO_CURSO=2 OR CU.CDCUR_ESTADO_CURSO=3)AND '||TMPWHERE||' AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',
	COALESCE(TC.CDTCR_NOMBRE,'''')||'' ''||
	COALESCE(CN.CCTN_NOMBRE,'''')||'' ''||
	COALESCE(TC.CDTCR_NOMBRE,'''')||'' ''||
	COALESCE(SP.CSCTP_NOMBRE,'''')||'' ''||
	COALESCE(ITR.CDITR_NOMBRE,'''')||'' ''||
	COALESCE(PER.CRPER_NOMBRES,'''')||'' ''||
	COALESCE(PER.CRPER_APELLIDO_PATERNO)||'' ''||
	COALESCE(PER.CRPER_APELLIDO_MATERNO)||'' ''||
	COALESCE(CU.CDCUR_DESCRIPCION, '''')||'' ''||
	COALESCE(CU.CDCUR_FECHA_PREVISTA_INICIO,CURRENT_TIMESTAMP)||'' ''||
	COALESCE(CU.CDCUR_FECHA_INICIO, CURRENT_TIMESTAMP)||'' ''||
	COALESCE(CU.CDCUR_FECHA_CULMINACION, CURRENT_TIMESTAMP)||'' ''||
	COALESCE(CU.CDCUR_FECHA_PREVISTA_CULMINACION,CURRENT_TIMESTAMP)||'' ''||
	COALESCE(CU.CDCUR_NUMERO_ASISTENTE, 0)||'' ''||
	COALESCE(CU.CDCUR_ESTADO_CURSO, 0)||'' ''||
	COALESCE(CU.CDCUR_ESTADO, FALSE)||'' ''||
	COALESCE(CU.CDCUR_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||
	COALESCE(CU.CDCUR_USUARIO_INSERT, '''')||'' ''||
	COALESCE(CU.CDCUR_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||
	COALESCE(CU.CDCUR_USUARIO_UPDATE, '''')) = 1';
	
	EXECUTE TMP INTO TMP_ROWS;
	RETURN TMP_ROWS;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION f_cgg_dhu_curso_asistente_select_countCdtcr_codigo(text,VARCHAR) OWNER TO sii;