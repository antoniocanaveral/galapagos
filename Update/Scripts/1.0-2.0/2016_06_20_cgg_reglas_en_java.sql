INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL31', NULL, 'Casado Antes del 11 Junio de 2015', 'Verifica que el solicitante sea casado con el auspiciante antes del 11 de Junio del 2015', 'com.bmlaurus.rule.MarriedBeforeJune11Validator', '=', 'TRUE', 'TRUE', 'El solicitate no está casado con el auspiciante antes del 11 de Junio', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', '2011-05-26 10:44:52.184323', 'patricia');
INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL32', NULL, 'Unión hecho con el auspiciante', 'Verifica que el solicitante esté en unión hecho con el auspiciante registrado en el DINARDAP', 'com.bmlaurus.rule.FreeUnionValidator', '=', 'TRUE', 'TRUE', 'El solicitate no está en union de hecho con el auspiciante', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);
INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL33', NULL, 'Minimo 10 años desde la solicitud de residencia', 'Verifica que haya transcurrido minimo 10 años desde la solicitud de residencia bajo el Art. 41-1 cuyo auspiciante sea el mismo conviviente. ', 'com.bmlaurus.rule.TenyearsApplicationResidenceValidator', '=', 'TRUE', 'TRUE', 'No ha transcurrido minimo 10 años desde la solicitud de residencia', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);
INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL34', NULL, 'Permanente antes de los 10 años', 'Verifica que el auspiciante ha fallecido para darle la permanecia antes de los 10 años de casada', 'com.bmlaurus.rule.Before10YearsSponsorDiedValidator', '=', 'TRUE', 'TRUE', 'El auspiciente aún no ha fallecido', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);
INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL35', NULL, 'Unión libre después del 11 Junio de 2015', 'Verifica que el solicitante está en unión libre con el auspiciente después del 11 de Junio del 2015', 'com.bmlaurus.rule.temporal.FreeUnionAfertJune11Validator', '=', 'TRUE', 'TRUE', 'El solicitante no está en unión libre con el auspiciantea a partir del 11 del Junio del 2015', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);


INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL36', NULL, 'Hijo menor de edad', 'Verifica que el hijo del solicitante sea menor de edad', 'com.bmlaurus.rule.temporal.MinorChild', '=', 'TRUE', 'TRUE', 'El hijo del solicitante no es menor de edad', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL37', NULL, 'Tiempo permitido en categoría de turista', 'Verifica que si el solicitante está en la provincia como turista no deberá estar excedido de días.', 'F_TIEMPO_ESTADIA_TURISTA_TRANSEUNTE', '<=', '90', 'TRUE', 'El solicitante ha exedido los días permitidos como turista', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL38', NULL, 'Transeunte vigente', 'Verifica que si el solicitante está en la provincia como transeúnte tenga su transeúnte vigente. ', 'F_RESIDENTE_TRANSEUNTE', '=', 'TRUE', 'TRUE', 'La persona debe tener su transeunte vigente', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL39', NULL, 'Oferta laborar vigente', 'Verifica que la oferta laboral esté vigente', 'com.bmlaurus.rule.temporal.CurrentLaborSupply', '=', 'TRUE', 'TRUE', 'La oferta laboral no está vigente', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL40', NULL, 'Oferta laboral tenga vacantes', 'Verifica que la oferta laborar tenga vacantes libres para contratar', 'com.bmlaurus.rule.temporal.LaborSupplyFreeVacancies', '=', 'TRUE', 'TRUE', 'La oferta laboral no tiene vacantes para contratar', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', 'patricia', NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL41', NULL, 'Tiempo permitido en categoría de transeúnte', 'Verifica que si el solicitante está en la provincia como transeunte no deberá estar excedido de días.', 'F_TIEMPO_ESTADIA_TURISTA_TRANSEUNTE', '<=', '90', 'TRUE', 'El solicitante ha exedido los días permitidos como transeunte', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL42', NULL, 'Tiempo permitido en categoría de transeúnte por motivo(Trabajadora Sexual)', 'Verifica que el solicitante no exceda el tiempo permitido en la categoría de transeúnte, definido para éste motivo específico.', 'F_TRANSEUNTE_MOTIVO_TRABAJADORA', '<=', '90', 'TRUE', 'El solicitante ha excedido el tiempo permitido en la categoría de transeúnte, definido para éste motivo específico.', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL43', NULL, 'Casado después del 11 de Junio del 2015)', 'Verifica que la persona esté casado después del 11 de Junio del 2015 con el auspiciante', 'com.bmlaurus.rule.MarriedAfterJune11Validator', '=', 'TRUE', 'TRUE', 'El solicitante no está casado con el auspiciante después del 11 de Junio del 2015.', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL44', NULL, 'Oferta laboral con vacantes', 'Verifica que la oferta laboral tenga vacantes', 'F_OFERTA_LABORAL_VACANTES', '=', 'TRUE', 'TRUE', 'La oferta  laboral no tiene vacantes', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL45', NULL, 'Auspiciante consta en el registro civíl', 'Verifica que el auspiciante conste en el registro civíl', 'com.bmlaurus.rule.RegisteredIdentification', '=', 'TRUE', 'TRUE', 'El auspiciante no consta en el registro civíl', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL46', NULL, 'Sufrago el auspiciante', 'Verifica que el auspiciante haya sufragado en las últimas elecciones', 'com.bmlaurus.rule.VoteCNE', '=', 'TRUE', 'TRUE', 'El auspiciante no consta que haya votado en las últimas elecciones', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL47', NULL, 'Beneficiario consta en el registro civíl', 'Verifica que el beneficiario conste en el registro civíl', 'com.bmlaurus.rule.RegisteredIdentificationBeneficiary', '=', 'TRUE', 'TRUE', 'El beneficiario no consta en el registro civíl', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL48', NULL, 'Sufrago el beneficiario', 'Verifica que el beneficiario haya sufragado en las últimas elecciones', 'com.bmlaurus.rule.VoteCNEBeneficiary', '=', 'TRUE', 'TRUE', 'El beneficiario no consta que haya sufragado en las últimas elecciones', 1, '2011-03-13 01:00:00.0', '2011-03-13 01:00:00.0', NULL, NULL, true, '2011-03-18 14:11:12.165745', NULL, NULL, NULL);

-- Function: f_residente_transeunte(character varying, character varying, character varying)

-- DROP FUNCTION f_residente_transeunte(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION f_residente_transeunte(in_crper_codigo character varying, in_operador character varying, in_valor_comparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_CODIGO VARCHAR;
	TMP_RESULTADO VARCHAR;
BEGIN	
	SELECT PRS.CRPER_CODIGO INTO TMP_CODIGO 
	FROM SII.CGG_RES_PERSONA PRS
	INNER JOIN SII.CGG_RES_RESIDENCIA RSD ON RSD.CRPER_CODIGO = PRS.CRPER_CODIGO AND RSD.CRRSD_MODALIDAD = 1 AND RSD.CRRSD_VIGENTE
	WHERE PRS.CRPER_CODIGO = IN_CRPER_CODIGO AND RSD.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
		SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE  CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
		FROM CGG_CONFIGURACION
		WHERE CGCNF_CODIGO = '05')
		UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
		WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
	) SELECT CRTST_CODIGO  FROM TIPO);	
	
	SELECT SII.F_CGG_REGLA_VALIDACION((CASE WHEN TMP_CODIGO IS NOT NULL THEN 'TRUE' ELSE 'FALSE' END), IN_OPERADOR, IN_VALOR_COMPARACION) INTO TMP_RESULTADO;
	RETURN TMP_RESULTADO;	
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_residente_transeunte(character varying, character varying, character varying)
  OWNER TO sii;

-- Function: f_tiempo_estadia_turista_transeunte(character varying, character varying, character varying)

-- DROP FUNCTION f_tiempo_estadia_turista_transeunte(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION f_tiempo_estadia_turista_transeunte(in_crper_codigo character varying, in_operador character varying, in_valor_comparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_ESTADIA INT;
        OUT_RESULTADO VARCHAR;
BEGIN
	
	SELECT SII.F_CALCULO_DIAS_ESTADIA(CURRENT_TIMESTAMP, IN_CRPER_CODIGO) INTO TMP_ESTADIA;
	
	IF (TMP_ESTADIA IS NULL) THEN
		OUT_RESULTADO := 'false';
	ELSE
	    SELECT SII.F_CGG_REGLA_VALIDACION(TMP_ESTADIA::VARCHAR,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
	END IF;
	
	RETURN OUT_RESULTADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_tiempo_estadia_turista_transeunte(character varying, character varying, character varying)
  OWNER TO sii;

-- Function: f_transeunte_motivo_trabajadora(character varying, character varying, character varying)

-- DROP FUNCTION f_transeunte_motivo_trabajadora(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION f_transeunte_motivo_trabajadora(in_crper_codigo character varying, in_operador character varying, in_valor_comparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_CODIGO VARCHAR;
	TMP_RESULTADO VARCHAR;
	TMP_ESTADIA INT;
BEGIN	
	SELECT PRS.CRPER_CODIGO INTO TMP_CODIGO 
	FROM SII.CGG_RES_PERSONA PRS
	INNER JOIN SII.CGG_RES_OCUPACION_LABORAL RSD ON RSD.CRPER_CODIGO = PRS.CRPER_CODIGO AND CGCRG_CODIGO = 'CCRG219'
	WHERE PRS.CRPER_CODIGO = IN_CRPER_CODIGO;	

	 IF (TMP_CODIGO IS NOT NULL) THEN
	     SELECT SII.F_TIEMPO_ESTADIA_TURISTA_TRANSEUNTE(IN_CRPER_CODIGO,IN_OPERADOR,IN_VALOR_COMPARACION) INTO TMP_RESULTADO;
	 ELSE
	    TMP_RESULTADO:='false';
	 END IF;	
	 RETURN TMP_RESULTADO;	
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_transeunte_motivo_trabajadora(character varying, character varying, character varying)
  OWNER TO sii;


-- Function: f_cgg_res_tramite_s_cgg_res_persona_tipo(character varying, character varying, character varying)

-- DROP FUNCTION f_cgg_res_tramite_s_cgg_res_persona_tipo(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION f_cgg_res_tramite_s_cgg_res_persona_tipo(in_crper_codigo character varying, in_cgg_crper_codigo character varying, in_crtst_codigo character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRTRA_CODIGO, 
		CRPER_CODIGO, 
		CRPJR_CODIGO, 
		CGG_CRPER_CODIGO, 
		CRPRO_CODIGO, 
		CRTST_CODIGO, 
		CVVEH_CODIGO, 
		CRETT_CODIGO, 
		CISLA_CODIGO, 
		CVMTR_CODIGO, 
		CGG_CVMTR_CODIGO, 
		CGG_CVVEH_CODIGO, 
		CRTRA_ANIO, 
		CRTRA_NUMERO, 
		CRTRA_FECHA_RECEPCION, 
		CRTRA_ACTIVIDAD_RESIDENCIA, 
		CRTRA_OBSERVACION, 
		CRTRA_DIAS_PERMANENCIA, 
		CRTRA_PENDIENTE, 
		CRTRA_COMUNICADO_RADIAL, 
		CRTRA_MOTIVO, 
		CRTRA_FOLIO, 
		CRTRA_GRUPO, 
		CRTRA_ORDEN, 
		CRTRA_FECHA_INGRESO, 
		CRTRA_FECHA_SALIDA, 
		CRTRA_ESTADO, 
		CRTRA_FECHA_INSERT, 
		CRTRA_USUARIO_INSERT, 
		CRTRA_FECHA_INSERT, 
		CRTRA_USUARIO_UPDATE
	FROM SII.CGG_RES_TRAMITE
	WHERE CRTRA_ESTADO = TRUE AND 
		CRPER_CODIGO = IN_CRPER_CODIGO AND 
		CGG_CRPER_CODIGO = IN_CGG_CRPER_CODIGO AND
                CRTST_CODIGO = IN_CRTST_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION f_cgg_res_tramite_s_cgg_res_persona_tipo(character varying, character varying, character varying)
  OWNER TO postgres;


--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'xsilva','CGGSII-30','Insercion de registros para llamar a las reglas hechas en java',
	'1.0','2016_06_20_cgg_reglas_en_java.sql',true);

