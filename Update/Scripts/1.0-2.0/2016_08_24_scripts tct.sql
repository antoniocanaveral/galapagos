INSERT INTO sii.cgg_tct_tipo_registro (tcttr_codigo, tcttr_nombre, tcttr_estado) VALUES ('1', 'Individual', true);
INSERT INTO sii.cgg_tct_tipo_registro (tcttr_codigo, tcttr_nombre, tcttr_estado) VALUES ('2', 'Grupal', true);

INSERT INTO sii.cgg_tct_categoria (tctcat_codigo, tctcat_nombre, tctcat_estado) VALUES ('1', 'Turista', true);
INSERT INTO sii.cgg_tct_categoria (tctcat_codigo, tctcat_nombre, tctcat_estado) VALUES ('2', 'Transeunte', true);


-- Function: sii.f_cgg_res_persona_autorizado_ingreso_turista_transeunte2(character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_cgg_res_persona_autorizado_ingreso_turista_transeunte2(character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_persona_autorizado_ingreso_turista_transeunte2(in_crper_num_doc_identific character varying, in_fecha_ingreso timestamp with time zone, inoperador character varying, invalorcomparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_VALOR_DIAS_TRANSCURRIDO INTEGER;
	TMP_RECORD RECORD;
	TMP_CRTST_CODIGO VARCHAR;
	TMP_NUMERO_DIAS VARCHAR;
    OUT_KEY VARCHAR;
    TMP_TIPO_USUARIO boolean;
    TMP_CODIGO VARCHAR;
	TMP_GEN_CODIGO VARCHAR;
	TMP_PERMANENTE VARCHAR;
	TMP_TEMPORAL VARCHAR;
BEGIN   
	TMP_VALOR_DIAS_TRANSCURRIDO:=0;
	TMP_NUMERO_DIAS:='true';
	SELECT CGCNF_VALOR_CADENA INTO TMP_PERMANENTE FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO='03';
	SELECT CGCNF_VALOR_CADENA INTO TMP_TEMPORAL FROM CGG_CONFIGURACION WHERE CGCNF_CODIGO='04';
	SELECT CRPER_CODIGO INTO TMP_CODIGO FROM SII.CGG_RES_PERSONA WHERE CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC;
	
	SELECT CRTST_CODIGO INTO TMP_CRTST_CODIGO 
	FROM SII.CGG_RES_RESIDENCIA
	WHERE CRPER_CODIGO = TMP_CODIGO AND 
		CRRSD_FECHA_INICIO::DATE = IN_FECHA_INGRESO AND
		CRRSD_VIGENTE AND
		CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05')
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO);
		
	IF (TMP_CRTST_CODIGO IS NULL) THEN
		SELECT SII.F_CALCULO_DIAS_ESTADIA(IN_FECHA_INGRESO, TMP_CODIGO) INTO TMP_VALOR_DIAS_TRANSCURRIDO;
	END IF;
	
	SELECT SII.F_CGG_REGLA_VALIDACION(TMP_VALOR_DIAS_TRANSCURRIDO::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO TMP_NUMERO_DIAS;

	
	RETURN TMP_NUMERO_DIAS;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_res_persona_autorizado_ingreso_turista_transeunte2(character varying, timestamp with time zone, character varying, character varying)
  OWNER TO postgres;


-- Ingreso de la regla anterior a la lista de reglas_validación

INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL59', null, 'Calculo de los 90 dias', 'Calcula el total de días de visita a la provincia de un persona.', 'F_CGG_RES_PERSONA_AUTORIZADO_INGRESO_TURISTA_TRANSEUNTE2', '<=', '90', 'TRUE', 'La Persona no puede ingresar por que ha excedido los días autorizados.', 1, '2011-03-18 01:00:00.000000', '2011-03-18 01:00:00.000000', null, null, true, '2011-03-18 14:03:55.417804', 'admin', '2011-03-19 19:53:24.790092', 'admin');

--

INSERT INTO sii.cgg_operacion_regla_validacion (corv_codigo, crval_codigo, copvl_codigo, corv_campo_evaluacion, corv_valor_1, corv_estado, corv_fecha_insert, corv_usuario_insert, corv_fecha_update, corv_usuario_update) 
VALUES ('CORV12', 'CRVAL59', 'COPVL1', '[{"IN_FECHA_INGRESO":"tmpFechaIngreso","IN_CRPER_NUM_DOC_IDENTIFIC":"tmpNumeroDocumento"}]', null, true, '2011-03-19 19:42:36.292847', null, '2011-05-17 19:22:06.458445', null);

-- 

-- Function: sii.f_cgg_res_persona_notificado_ingreso2(character varying, character varying, character varying)

-- DROP FUNCTION sii.f_cgg_res_persona_notificado_ingreso2(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_persona_notificado_ingreso2(in_crper_num_doc_identific character varying, inoperador character varying, invalorcomparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
VALOR_DIAS INTEGER;
VALOR_FECHA DATE ;
TMP_NUMERO VARCHAR;
TMP_FECHA_EXPULSION DATE;
TMP_NOTIFICADO VARCHAR;
TMP_FECHA_INGRESO DATE;
TMP_RESULTADO VARCHAR;
OUT_KEY VARCHAR;
TMP_FECHA_SALIDA DATE;
TMP_TIPO_USUARIO boolean;
VALOR_FECHA_INGRESO DATE;
TMP_CODIGO VARCHAR;
TMP_GEN_CODIGO VARCHAR;
BEGIN
--EXTRAE EL VALOR DE LA CONFIGURACION DE LOS DIAS
SELECT CGCNF_VALOR_NUMERICO INTO VALOR_DIAS
FROM CGG_CONFIGURACION 
WHERE CGCNF_CODIGO='CONF16';
SELECT CRNOT_FECHA_SALIDA_VOLUNT, 
CRNOT_FECHA_EXPULSION,
PER.CRPER_CODIGO, 
(CASE 
WHEN CRNOT_FECHA_EXPULSION IS NOT NULL THEN
CRNOT_FECHA_EXPULSION
ELSE
CURRENT_DATE
END) INTO TMP_FECHA_SALIDA,
TMP_FECHA_EXPULSION,
TMP_CODIGO,VALOR_FECHA
FROM SII.CGG_RES_NOTIFICACION NTF 
INNER JOIN SII.CGG_RES_PERSONA PER ON PER.CRPER_CODIGO = NTF.CRPER_CODIGO
WHERE (NTF.CRNOT_ESTADO_NOTIFICACION=3 OR NTF.CRNOT_ESTADO_NOTIFICACION=1) AND
NTF.CRNOT_REGULARIZACION = '0' AND
CRNOT_ESTADO AND
PER.CRPER_NUM_DOC_IDENTIFIC=IN_CRPER_NUM_DOC_IDENTIFIC
ORDER BY CRNOT_FECHA_NOTIFICACION DESC;
--GROUP BY NTF.CRTNT_CODIGO,NTF.CRNOT_FECHA_SALIDA_VOLUNT,NTF.CRNOT_FECHA_EXPULSION,PER.CRPER_CODIGO ;
VALOR_FECHA_INGRESO = VALOR_FECHA + VALOR_DIAS;
SELECT SII.F_CGG_REGLA_VALIDACION(COALESCE(VALOR_FECHA_INGRESO,CURRENT_DATE-1)::VARCHAR,INOPERADOR,CURRENT_DATE::VARCHAR) INTO TMP_NOTIFICADO;
SELECT CUSU_USUARIO_INTERNO INTO TMP_TIPO_USUARIO FROM SII.CGG_USUARIO U WHERE U.CUSU_ESTADO = TRUE;
IF(TMP_TIPO_USUARIO=true)THEN
IF(TMP_NOTIFICADO='false')THEN
SELECT SII.F_CGG_TCT_INGRESO_FALLIDO_INSERT(
'KEYGEN'::VARCHAR,
TMP_CODIGO,
NULL,
CURRENT_TIMESTAMP,
0::SMALLINT,
'Notificado'::VARCHAR,
TRUE,
NULL,
NULL
) INTO TMP_GEN_CODIGO;
END IF;
END IF;
RETURN TMP_NOTIFICADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_res_persona_notificado_ingreso2(character varying, character varying, character varying)
  OWNER TO postgres;


-- Ingreso de la regla anterior a la lista de reglas_validación
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL60', null, 'Persona notificada', 'Verifica que la persona no esta notificada.', 'F_CGG_RES_PERSONA_NOTIFICADO_INGRESO2', '<=', '', 'TRUE', 'La persona esta Notificada no puede ingresar a la Provincia', 1, '2011-03-18 01:00:00.000000', '2011-03-18 01:00:00.000000', null, null, true, '2011-03-18 14:23:10.730641', 'admin', '2011-03-18 14:23:10.730641', 'admin');

--
INSERT INTO sii.cgg_operacion_regla_validacion (corv_codigo, crval_codigo, copvl_codigo, corv_campo_evaluacion, corv_valor_1, corv_estado, corv_fecha_insert, corv_usuario_insert, corv_fecha_update, corv_usuario_update) 
VALUES ('CORV13', 'CRVAL60', 'COPVL1', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"tmpNumeroDocumento"}]', null, true, '2011-03-29 17:50:48.283439', null, '2011-05-17 19:22:06.458445', null);

-- INCREMENTO DE COLUMNA SEGUIMIENTO EN TABLA DE PERSONA

ALTER TABLE sii.cgg_res_persona ADD COLUMN crper_seguimiento BOOLEAN DEFAULT false

-- FUNCIÓN QUE ELIMINA LOS REGISTROS TCT CADUCADOS A LA FECHA ACTUAL
-- Function: sii.f_cgg_eliminar_tct_caducado()
--  DROP FUNCTION sii.f_cgg_eliminar_tct_caducado();
CREATE OR REPLACE FUNCTION sii.f_cgg_eliminar_tct_caducado()
 RETURNS void AS
$BODY$
BEGIN
    DELETE SII.CGG_TCT_REGISTRO TR
    WHERE TR.CTREG_FECHA_INGRESO < CURRENT_DATE AND TR.CTREG_ESTADO_REGISTRO=0 AND ctreg_impresion_especie is null;
$BODY$
 LANGUAGE plpgsql VOLATILE
 COST 100;


--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','Scripts TCT','Funciones y Reglasnuevas de tct',
	'2.0','2016_08_24_scripts tct.sql',true);