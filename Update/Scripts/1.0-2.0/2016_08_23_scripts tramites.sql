
-- Incremento de la sección de Coordinación de Residencia
INSERT INTO sii.cgg_res_seccion (crsec_codigo, crsec_nombre, crsec_estado, crsec_fecha_insert, crsec_usuario_insert, crsec_fecha_update, crsec_usuario_update) VALUES ('CRSEC31', 'COORDINACION DE RESIDENCIA', true, '2016-06-30 17:16:59.341544', 'patricia', '2016-06-30 17:16:59.341544', 'patricia');

-- Eliminación de documentos identificación no requeridos
update sii.cgg_res_documento_identificacio set crdid_estado = false where crdid_descripcion='PARTIDA DE NACIMIENTO ' or crdid_descripcion='RUC'
or crdid_descripcion='NINGUNO' or crdid_descripcion='CREDENCIAL';

-- Colocar estado civil ninguno en estado false
update sii.cgg_res_estado_civil set crecv_estado = false where crecv_descrpcion='NINGUNO';

-- Cambio de estado de transeuntes, en tipo solicitud trámite para los que no aplican
update sii.cgg_res_tipo_solicitud_tramite set crtst_estado = false where crtst_descripcion='Transeúntes 91-136' or crtst_descripcion='Transeúntes 1-90' or crtst_descripcion='Transeúntes 137-180';

-- Cambio de estado de temporales, en tipo solicitud trámite para los que no aplican
update sii.cgg_res_tipo_solicitud_tramite set crtst_estado = false where cgg_crtst_codigo = 'CRTST2' 
and (crtst_descripcion='Extensión Funcionarios Públicos' or crtst_descripcion='Temporales por Recurso de Reposición' 
or crtst_descripcion='Temporales por Recurso de Revisión' or crtst_descripcion='Temporal Renovaciones'
or crtst_descripcion='Temporales Contrato 1era Renovacion' or crtst_descripcion='Revisión de Residencias Temporales'
or crtst_descripcion='Temporales Sin Reglas de Validación');

-- Cambio de estado de permanentes, en tipo solicitud trámite para los que no aplican
update sii.cgg_res_tipo_solicitud_tramite set crtst_estado = false where cgg_crtst_codigo = 'CRTST1' 
and (crtst_descripcion='Art. 26-2B' or crtst_descripcion='Art. 26-1' 
or crtst_descripcion='Art. 26-2A' or crtst_descripcion='Art. 26-3B'
or crtst_descripcion='Art. 26-3A');

-- Cambio para que solo liste los tipos de trámites: permanente, temporal, traseunte
update sii.cgg_res_tipo_solicitud_tramite set crtst_estado = false where crtpt_codigo='CRTPT1'
and (crtst_codigo='CRTST95' or crtst_codigo='CRTST9' 
or crtst_codigo='CRTST83' or crtst_codigo='CRTST82' 
or crtst_codigo='CRTST81' or crtst_codigo='CRTST80'
or crtst_codigo='CRTST8' or crtst_codigo='CRTST79'
or crtst_codigo='CRTST78' or crtst_codigo='CRTST77'
or crtst_codigo='CRTST76' or crtst_codigo='CRTST74'
or crtst_codigo='CRTST73' or crtst_codigo='CRTST68'
or crtst_codigo='CRTST60' or crtst_codigo='CRTST59'
or crtst_codigo='CRTST40' or crtst_codigo='CRTST39'
or crtst_codigo='CRTST38' or crtst_codigo='CRTST37'
or crtst_codigo='CRTST36' or crtst_codigo='CRTST350'
or crtst_codigo='CRTST35' or crtst_codigo='CRTST349'
or crtst_codigo='CRTST348' or crtst_codigo='CRTST347'
or crtst_codigo='CRTST346' or crtst_codigo='CRTST345'
or crtst_codigo='CRTST34' or crtst_codigo='CRTST33'
or crtst_codigo='CRTST32' or crtst_codigo='CRTST312'
or crtst_codigo='CRTST311' or crtst_codigo='CRTST31'
or crtst_codigo='CRTST307' or crtst_codigo='CRTST30'
or crtst_codigo='CRTST27' or crtst_codigo='CRTST269'
or crtst_codigo='CRTST26' or crtst_codigo='CRTST25'
or crtst_codigo='CRTST24' or crtst_codigo='CRTST230'
or crtst_codigo='CRTST22' or crtst_codigo='CRTST207'
or crtst_codigo='CRTST20' or crtst_codigo='CRTST19'
or crtst_codigo='CRTST18' or crtst_codigo='CRTST16'
or crtst_codigo='CRTST15' or crtst_codigo='CRTST142'
or crtst_codigo='CRTST136' or crtst_codigo='CRTST13'
or crtst_codigo='CRTST122' or crtst_codigo='CRTST117'
or crtst_codigo='CRTST10');


--CGG_RES_REQUISITOS

﻿-- Requisitos Nuevos
INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update) 
VALUES ('CRREQ153', 'Se verificará que conste registrado con cédula en la base de datos del Registro Civil.', '', true, '2016-02-23 10:48:07.649769', 'patricia', '2016-02-23 10:48:07.649769', 'patricia'),
	('CRREQ154', 'Se verificará cumplimiento de haber ejercido el derecho al sufragio o pago de la sanción respectiva', '', true, '2016-02-23 10:48:07.649769', 'patricia', '2016-02-23 10:48:07.649769', 'patricia'),
	('CRREQ155', 'Se verificará que sea residente permanente', '', true, '2016-02-23 10:48:07.649769', 'patricia', '2016-02-23 10:48:07.649769', 'patricia');

INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update) 
VALUES ('CRREQ156', 'Se verificará el registro del matrimonio en la base de datos del Registro Civil', '', true, '2016-02-23 10:48:07.649769', 'patricia', '2016-02-23 10:48:07.649769', 'patricia');

INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update) 
VALUES ('CRREQ157', 'Se verificará el registro de la unión de hecho en la base de datos del Registro Civil', '', true, '2016-02-23 10:48:07.649769', 'patricia', '2016-02-23 10:48:07.649769', 'patricia');

INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update) 
VALUES ('CRREQ158', 'Deberá presentar documentos probatorios que justifiquen su solicitud', '', true, '2016-02-23 10:48:07.649769', 'patricia', '2016-02-23 10:48:07.649769', 'patricia');

-- INGRESO DE REQUISITOS PARA TRANSEÚNTES

INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update)
VALUES ('CRREQ159', 'Copia del pasaporte vigente para los extranjeros no nacionalizados en Ecuador', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia'),
	('CRREQ160', 'Copia del documento que acredite la actividad que viene a realizar a Galápagos', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia'),
	('CRREQ161', 'Realizar el proceso de actualización de los datos en el sistema del representante legal/delegado', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia');
	

-- AUMENTO DE COLUMNA EN cgg_res_tipo_solicitud_tramite PARA CONTROLAR EL INGRESO DE UNA SOLICITUD VIA WEB

ALTER TABLE sii.cgg_res_tipo_solicitud_tramite
ADD crtst_ingreso_web boolean;

-- INGRESO DE REQUISITOS PARA TEMPORALES
INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update)
VALUES ('CRREQ162', 'Se verificará que el padre/madre tenga residente temporal vigente', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia'),
	('CRREQ164', 'Se verificará que el cónyuge/Conviviente tenga residente temporal vigente', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia'),
	('CRREQ163', 'Se validará que se ha realizado la búsqueda interna mediante el sistema de gestión de empleo y que el beneficiario cumple con el perfil', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia');
---
INSERT INTO sii.cgg_res_requisito (crreq_codigo, crreq_descripcion, crreq_observacion, crreq_estado, crreq_fecha_insert, crreq_usuario_insert, crreq_fecha_update, crreq_usuario_update)
VALUES ('CRREQ151', 'Documento que acredite la solicitud de reactivación de la residencia', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia'),
	('CRREQ152', 'Verificar que la persona tenía residencia permanente', '', TRUE, current_timestamp, 'patricia', current_timestamp, 'patricia');






-- REGLA ANULAR RESIDENCIA 2016
-- Function: sii.f_cgg_anular_residencia_2016(character varying, character varying)
-- DROP FUNCTION sii.f_cgg_anular_residencia_2016(character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_anular_residencia_2016(in_crseg_codigo character varying, in_user_name character varying)
  RETURNS numeric AS
$BODY$
DECLARE
TMP_REF REFCURSOR;
TMP_ROW RECORD;
IN_CRPER_NUM_DOC_IDENTIFIC VARCHAR;
TMP_CRTRA_CODIGO VARCHAR;
BEGIN
SELECT TRM.CRTRA_CODIGO INTO TMP_CRTRA_CODIGO
	FROM SII.CGG_RES_TRAMITE TRM
	INNER JOIN SII.CGG_RES_SEGUIMIENTO SGM ON SGM.CRTRA_CODIGO = TRM.CRTRA_CODIGO AND SGM.CRSEG_CODIGO = IN_CRSEG_CODIGO;	
SELECT CRPER_NUM_DOC_IDENTIFIC INTO IN_CRPER_NUM_DOC_IDENTIFIC
		FROM SII.CGG_RES_PERSONA PRS
		WHERE PRS.CRPER_CODIGO = (SELECT CGG_CRPER_CODIGO FROM SII.CGG_RES_TRAMITE WHERE CRTRA_CODIGO = TMP_CRTRA_CODIGO);	
FOR TMP_ROW IN
SELECT
R.CRRSD_CODIGO, 
P.CRPER_CODIGO, 
R.CRTST_CODIGO, 
R.CRTRA_CODIGO, 
R.CGG_CRTRA_CODIGO, 
R.CRRSD_NUMERO, 
R.CRRSD_MODALIDAD, 
R.CRRSD_FECHA_INICIO, 
R.CRRSD_FECHA_CADUCIDAD, 
R.CRRSD_REVOCADA, 
R.CRRSD_FECHA_REVOCATORIA, 
R.CRRSD_MOTIVO_REVOCATORIA, 
R.CRRSD_VIGENTE, 
R.CRRSD_TRAMITE_PENDIENTE, 
R.CRRSD_ESTADO, 
R.CRRSD_FECHA_INSERT, 
R.CRRSD_USUARIO_INSERT, 
R.CRRSD_FECHA_UPDATE, 
R.CRRSD_USUARIO_UPDATE
FROM SII.CGG_RES_RESIDENCIA R 
INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
WHERE CRRSD_ESTADO AND 
P.CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC AND
R.CRRSD_VIGENTE
LOOP
UPDATE SII.CGG_RES_RESIDENCIA SET 
CRRSD_FECHA_UPDATE = CURRENT_TIMESTAMP,
CRRSD_USUARIO_UPDATE = IN_USER_NAME,
CRRSD_VIGENTE = FALSE, 
CRRSD_FECHA_CADUCIDAD = CURRENT_DATE,
CRRSD_MOTIVO_REVOCATORIA = NULL
WHERE CRRSD_CODIGO = TMP_ROW.CRRSD_CODIGO;
END LOOP;
RETURN 1;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_anular_residencia_2016(character varying, character varying)
  OWNER TO postgres;


--REGLA TIEMPO ESTADIA TURISTA
-- Function: sii.f_tiempo_estadia_turista(character varying, character varying, character varying)

-- DROP FUNCTION sii.f_tiempo_estadia_turista(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_tiempo_estadia_turista(in_crper_codigo character varying, in_operador character varying, in_valor_comparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_ESTADIA INT;
        OUT_RESULTADO VARCHAR;
        FECHA_FINAL TIMESTAMP;
        CTID_MOV TID;
        OPERACION SMALLINT;
        
        
BEGIN

        SELECT  MAX (CRMOV_FECHA_VIAJE) INTO FECHA_FINAL FROM SII.CGG_RES_MOVILIDAD M WHERE M.CRPER_CODIGO=IN_CRPER_CODIGO;
        SELECT MAX (CTID) INTO CTID_MOV FROM SII.CGG_RES_MOVILIDAD M WHERE M.CRPER_CODIGO=IN_CRPER_CODIGO AND M.CRMOV_FECHA_VIAJE=FECHA_FINAL;
        SELECT M.CRMOV_TIPO_OPERACION INTO OPERACION FROM SII.CGG_RES_MOVILIDAD M WHERE CTID =CTID_MOV;

        IF (OPERACION = 0) THEN 

	SELECT SII.F_CALCULO_DIAS_ESTADIA_TURISTA(CURRENT_TIMESTAMP, IN_CRPER_CODIGO) INTO TMP_ESTADIA;
	
	IF (TMP_ESTADIA = 0) THEN
            OUT_RESULTADO := 'true';
	ELSE
	    SELECT SII.F_CGG_REGLA_VALIDACION(TMP_ESTADIA::VARCHAR,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
	END IF;

	ELSE
		OUT_RESULTADO := 'true';
	END IF;
	
	RETURN OUT_RESULTADO;
	
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_tiempo_estadia_turista(character varying, character varying, character varying)
  OWNER TO sii;


--REGLA DE VALIDACIÓN DE BENEFICIARIO MAYOR DE EDAD (añadir a la tabla regla_validacion)


INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL50', null, 'Hijo mayor de edad', 'Verifica que el beneficiario sea mayor de edad', 'com.bmlaurus.rule.temporal.MinorChild', '=', 'TRUE', 'FALSE', 'El beneficiario no es mayor de edad', 1, '2011-03-13 01:00:00.000000', '2011-03-13 01:00:00.000000', null, null, true, '2011-03-18 14:11:12.165745', 'patricia', null, null);


-- REGLA PARA VALIDAR SI LA FECHA DE CADUCIDAD DEL BENEFICIARIO ES IGUAL AL DEL REPRESENTANTE

-- Function: sii.f_comparacion_caducidad(character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_comparacion_caducidad(character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_comparacion_caducidad(in_crper_codigo_rep character varying, in_fecha_cad_ben character varying, inoperador character varying, invalorcomparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE	
	TMP_RESULTADO VARCHAR;
	TMP_FECHA_CAD_REP TIMESTAMP;
	TMP_FECHA_INI_REP TIMESTAMP;
BEGIN 

	SELECT R.CRRSD_FECHA_CADUCIDAD INTO TMP_FECHA_CAD_REP FROM SII.CGG_RES_RESIDENCIA R WHERE R.CRPER_CODIGO=IN_CRPER_CODIGO_REP AND R.CRRSD_VIGENTE=TRUE;
	SELECT R.CRRSD_FECHA_INICIO INTO TMP_FECHA_INI_REP FROM SII.CGG_RES_RESIDENCIA R WHERE R.CRPER_CODIGO=IN_CRPER_CODIGO_REP AND R.CRRSD_VIGENTE=TRUE;
	
	IF (TMP_FECHA_CAD_REP::date)>=TO_DATE(IN_FECHA_CAD_BEN,'DD/MM/YYYY') THEN
	TMP_RESULTADO ='TRUE';
	ELSE
	TMP_RESULTADO ='FALSE,La fecha de entrada y salida del beneficiario debe estar entre el: '||to_char(TMP_FECHA_INI_REP,'DD/MM/YYYY')||' hasta el: '||to_char(TMP_FECHA_CAD_REP,'DD/MM/YYYY');
	END IF;

	RETURN TMP_RESULTADO;
			
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_comparacion_caducidad(character varying, character varying, character varying, character varying)
  OWNER TO postgres;

-- AÑADIR LA REGLA A LA TABLA REGLA_VALIDACION
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL51', null, 'Tener la misma fecha de caducidad que el representante', 'Verifica que el beneficiario tenga la misma fecha de caducidad que el representante', 'F_COMPARACION_CADUCIDAD', '=', 'TRUE', 'TRUE', 'El beneficiario debe tener la misma fecha de caducidad que el representante', 1, '2016-08-04 00:00:00.000000', '2016-08-04 00:00:00.000000', null, null, true, '2016-08-04 00:00:00.000000', 'patricia', '2016-08-04 00:00:00.000000', 'patricia');


--ACTUALIZACIÓN DE LA FUNCION CGG_USUARIO_COUNT
--DROP FUNCTION sii.f_cgg_usuario_count(text, character varying, character varying);

CREATE OR REPLACE FUNCTION SII.F_CGG_USUARIO_COUNT(
IN IN_FIND_TEXT TEXT,
IN IN_CUSU_USUARIO_INTERNO VARCHAR,
IN IN_CRPER_CODIGO VARCHAR
)RETURNS NUMERIC AS
$$
DECLARE
TMP_ROWS NUMERIC;
BEGIN
	SELECT COUNT(*) INTO TMP_ROWS
	FROM SII.CGG_USUARIO US
	LEFT JOIN SII.CGG_RES_PERSONA PRS ON PRS.CRPER_CODIGO = US.CRPER_CODIGO AND PRS.CRPER_ESTADO
	WHERE CUSU_ESTADO AND 
		(LENGTH(IN_CRPER_CODIGO) = 0 OR US.CRPER_CODIGO = IN_CRPER_CODIGO ) AND 
		(IN_CUSU_USUARIO_INTERNO = '-1' OR CUSU_USUARIO_INTERNO = IN_CUSU_USUARIO_INTERNO::BOOLEAN) AND 
		(LENGTH(IN_FIND_TEXT)=0 OR SII.F_STRING_IN(IN_FIND_TEXT, COALESCE(CUSU_NOMBRE_USUARIO,'')||' '||COALESCE(PRS.CRPER_NOMBRES,'')||' '||COALESCE(PRS.CRPER_APELLIDO_MATERNO,'')||' '||COALESCE(PRS.CRPER_APELLIDO_PATERNO,'') ) = 1);
	RETURN TMP_ROWS;
END
$$
LANGUAGE 'plpgsql' VOLATILE CALLED ON NULL INPUT;

-- AÑADIR REGLAS DE VALIDACION (HIJO DE AUSPICIANTE Y REPRESENTANTE) A LA TABLA REGLA_VALIDACION

INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL53', null, 'Beneficiario hijo de respresentante', 'Verifica que el beneficiario sea hijo del representante', 'com.bmlaurus.rule.temporal.HijoDelRepresentante', '=', 'TRUE', 'TRUE', 'El beneficiario no es hijo del representante', 1, '2011-04-09 01:00:00.000000', '2011-04-09 02:00:00.000000', null, null, true, '2011-04-09 03:00:00.000000', 'patricia', '2011-04-09 04:00:00.000000', 'patricia');
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL52', null, 'Beneficiario hijo del Auspiciante', 'Verifica que el beneficiario sea hijo del auspiciante', 'com.bmlaurus.rule.HijoDelAuspiciante', '=', 'TRUE', 'TRUE', 'El beneficiario no es hijo del auspiciante', 1, '2011-04-09 00:00:00.000000', '2011-04-09 00:00:00.000000', null, null, true, '2011-04-09 00:00:00.000000', 'patricia', '2011-04-09 00:00:00.000000', 'patricia');

-- AÑADIR REGLA DE BENEFICIARIO CASADO CON REPRESENTANTE EN LA TABLA REGLA_VALIDACION
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL54', null, 'Beneficiario casado con representante', 'Verifica que el beneficiario este casado con el representante', 'com.bmlaurus.rule.DinardapMarriedValidatorRep', '=', 'TRUE', 'TRUE', 'El beneficiario no se encuentra casado con el representante', 1, '2011-04-09 06:00:00.000000', '2011-04-09 07:00:00.000000', null, null, true, '2011-04-09 08:00:00.000000', 'patricia', '2011-04-09 10:00:00.000000', 'patricia');

-- AÑADIR REGLA DE BENEFICIARIO PADRE DEL AUSPICIANTE EN LA TABLA REGLA_VALIDACION
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL55', null, 'Beneficiario padre del Auspiciante', 'Verifica que el beneficiario sea padre del auspiciante', 'com.bmlaurus.rule.temporal.PadreDelAuspiciante', '=', 'TRUE', 'TRUE', 'El beneficiario no es padre del auspciante', 1, '2011-04-08 19:00:00.000000', '2011-04-08 19:00:00.000000', null, null, true, '2011-04-08 20:00:00.000000', 'patricia', '2011-04-08 21:00:00.000000', 'patricia');

-- AÑADIR REGLA DE BENEFICIARIO PADRE DEL REPRESENTANTE EN LA TABLA REGLA_VALIDACION
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL56', null, 'Beneficiario padre del respresentante', 'Verifica que el beneficiario sea padre del representante', 'com.bmlaurus.rule.temporal.PadreDelRepresentante', '=', 'TRUE', 'TRUE', 'El beneficiario no es padre del representante', 1, '2011-04-09 00:00:00.000000', '2011-04-09 00:00:00.000000', null, null, true, '2011-04-09 00:00:00.000000', 'patricia', '2011-04-09 00:00:00.000000', 'patricia');

-- REGLA PARA NUMERO DE TRAMITES DE TIPO TRANSEUNTE

-- Function: sii.f_numero_tramite_transeunte(character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_numero_tramite_transeunte(character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_numero_tramite_transeunte(in_crper_codigo character varying, in_crtra_codigo character varying, inoperador character varying, invalorcomparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
CRETTCODIGO VARCHAR(20);
TMP_CONTADOR NUMERIC;
CRTSTCODIGO VARCHAR;
OUT_RESULTADO VARCHAR;
BEGIN
select cgcnf_valor_cadena INTO CRTSTCODIGO from sii.cgg_configuracion where cgcnf_codigo='05';
SELECT COALESCE(COUNT(CRTRA_CODIGO),0) INTO TMP_CONTADOR 
FROM SII.CGG_RES_TRAMITE 
WHERE CRETT_CODIGO NOT IN ( SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO IN ('20','19','29') )
AND SII.F_TIPO_SOLICITUD_PADRE(CRTST_CODIGO) = CRTSTCODIGO
AND CGG_CRPER_CODIGO = IN_CRPER_CODIGO
--AND CRTRA_CODIGO NOT IN (SELECT RES.CRTRA_CODIGO FROM SII.CGG_RES_RESIDENCIA RES WHERE SII.CGG_RES_TRAMITE.CRTRA_CODIGO = RES.CRTRA_CODIGO AND crrsd_vigente=false AND crrsd_estado)
AND CRTRA_CODIGO IN (SELECT RES.CRTRA_CODIGO FROM SII.CGG_RES_RESIDENCIA RES WHERE SII.CGG_RES_TRAMITE.CRTRA_CODIGO = RES.CRTRA_CODIGO AND RES.CRRSD_TRAMITE_PENDIENTE AND crrsd_estado)
AND case when in_crtra_codigo = '' then 1=1 else crtra_codigo <> in_crtra_codigo end;

SELECT SII.F_CGG_REGLA_VALIDACION(TMP_CONTADOR::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
RETURN OUT_RESULTADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_numero_tramite_transeunte(character varying, character varying, character varying, character varying)
  OWNER TO postgres;

-- AÑADIR REGLA DE NUMERO DE TRAMITES TRANSEUNTE A LA TABLA DE REGLA_VALIDACION
INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL57', null, 'Numero de tramites de tipo transeunte', 'Verifica que no tenga mas de un tramite ingresado como de tipo transeunte', 'F_NUMERO_TRAMITE_TRANSEUNTE', '=', '0', 'TRUE', 'Ya tiene un tramite pendiente como tipo transeunte', 1, '2011-04-09 00:00:00.000000', '2011-04-09 00:00:00.000000', null, null, true, '2011-04-09 00:00:00.000000', 'patricia', '2011-04-09 00:00:00.000000', 'patricia');

-- MODIFICACIÓN REGLA DE NUMERO DE TRAMITES PERMANENTES

-- Function: sii.f_numero_tramite_permanente(character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_numero_tramite_permanente(character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_numero_tramite_permanente(in_crper_codigo character varying, in_crtra_codigo character varying, inoperador character varying, invalorcomparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
CRETTCODIGO VARCHAR(20);
TMP_CONTADOR NUMERIC;
CRTSTCODIGO VARCHAR;
OUT_RESULTADO VARCHAR;
BEGIN
select cgcnf_valor_cadena INTO CRTSTCODIGO from sii.cgg_configuracion where cgcnf_codigo='03';
SELECT COALESCE(COUNT(CRTRA_CODIGO),0) INTO TMP_CONTADOR 
FROM SII.CGG_RES_TRAMITE 
WHERE CRETT_CODIGO NOT IN ( SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO IN ('20','19','29') )
AND SII.F_TIPO_SOLICITUD_PADRE(CRTST_CODIGO) = CRTSTCODIGO
AND CGG_CRPER_CODIGO = IN_CRPER_CODIGO
AND case when in_crtra_codigo = '' then 1=1 else crtra_codigo <> in_crtra_codigo end;

SELECT SII.F_CGG_REGLA_VALIDACION(TMP_CONTADOR::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
RETURN OUT_RESULTADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_numero_tramite_permanente(character varying, character varying, character varying, character varying)
  OWNER TO postgres;

--MODIFICACIÓN REGLA DE NUMERO DE TRÁMITES TEMPORALES

-- Function: sii.f_numero_tramite_temporal(character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_numero_tramite_temporal(character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_numero_tramite_temporal(in_crper_codigo character varying, in_crtra_codigo character varying, inoperador character varying, invalorcomparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
CRETTCODIGO VARCHAR(20);
TMP_CONTADOR NUMERIC;
CRTSTCODIGO VARCHAR;
OUT_RESULTADO VARCHAR;
BEGIN
select cgcnf_valor_cadena INTO CRTSTCODIGO from sii.cgg_configuracion where cgcnf_codigo='04';
SELECT COALESCE(COUNT(CRTRA_CODIGO),0) INTO TMP_CONTADOR 
FROM SII.CGG_RES_TRAMITE 
WHERE CRETT_CODIGO NOT IN ( SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO IN ('20','19','29') )
AND SII.F_TIPO_SOLICITUD_PADRE(CRTST_CODIGO) = CRTSTCODIGO
AND CGG_CRPER_CODIGO = IN_CRPER_CODIGO
AND case when in_crtra_codigo = '' then 1=1 else crtra_codigo <> in_crtra_codigo end ;

SELECT SII.F_CGG_REGLA_VALIDACION(TMP_CONTADOR::VARCHAR,INOPERADOR,INVALORCOMPARACION) INTO OUT_RESULTADO;
RETURN OUT_RESULTADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_numero_tramite_temporal(character varying, character varying, character varying, character varying)
  OWNER TO postgres;


--SCRIPT ISNUMERIC
CREATE OR REPLACE FUNCTION isnumeric(text)
  RETURNS boolean AS
$BODY$
DECLARE x NUMERIC;
BEGIN
    x = $1::NUMERIC;
    RETURN TRUE;
EXCEPTION WHEN others THEN
    RETURN FALSE;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE STRICT
  COST 100;


-- REGLA QUE CALCULA LOS DIAS DE ESTADIA COMO TEMPORAL

-- Function: sii.f_calculo_dias_estadia_temporales(timestamp with time zone, character varying)

-- DROP FUNCTION sii.f_calculo_dias_estadia_temporales(timestamp with time zone, character varying);

CREATE OR REPLACE FUNCTION sii.f_calculo_dias_estadia_temporales(in_fecha_ingreso timestamp with time zone, in_crper_codigo character varying)
  RETURNS integer AS
$BODY$
DECLARE
TMP_RECORD RECORD;
TMP_VALOR_DIAS_TRANSCURRIDO INT;
TMP_CRTST_CODIGO VARCHAR;
TMP_SW BOOLEAN;
TMP_FECHA_OLD DATE;
BEGIN
TMP_VALOR_DIAS_TRANSCURRIDO := 0;
TMP_SW = FALSE;
FOR TMP_RECORD IN (SELECT
PER.CRPER_CODIGO,
MOV.CRMOV_FECHA_VIAJE,
MOV.CRMOV_TIPO_OPERACION,
MOV.CRRSD_CODIGO
FROM SII.CGG_RES_PERSONA PER 
INNER JOIN SII.CGG_RES_MOVILIDAD MOV ON MOV.CRPER_CODIGO = PER.CRPER_CODIGO
WHERE PER.CRPER_CODIGO = IN_CRPER_CODIGO AND MOV.CRMOV_ESTADO
ORDER BY MOV.CRMOV_FECHA_VIAJE, MOV.CRMOV_TIPO_OPERACION ASC)
LOOP
SELECT CRTST_CODIGO INTO TMP_CRTST_CODIGO 
FROM SII.CGG_RES_RESIDENCIA
WHERE CRPER_CODIGO = TMP_RECORD.CRPER_CODIGO AND 
CRRSD_CODIGO = TMP_RECORD.CRRSD_CODIGO AND 
CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
FROM CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '04')) 
UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
) SELECT CRTST_CODIGO  FROM TIPO);
IF (TMP_CRTST_CODIGO IS NOT NULL) THEN
TMP_SW = (TMP_RECORD.CRMOV_TIPO_OPERACION = 0);
IF (TMP_FECHA_OLD IS NOT NULL AND TMP_RECORD.CRMOV_TIPO_OPERACION = 1 ) THEN
TMP_VALOR_DIAS_TRANSCURRIDO := TMP_VALOR_DIAS_TRANSCURRIDO + (TMP_RECORD.CRMOV_FECHA_VIAJE::DATE - TMP_FECHA_OLD) + 1;
END IF;

IF (TMP_RECORD.CRMOV_TIPO_OPERACION = 1 AND TMP_FECHA_OLD IS NULL) THEN
SELECT CRMOV_FECHA_VIAJE INTO TMP_FECHA_OLD FROM SII.CGG_RES_MOVILIDAD 
WHERE CRPER_CODIGO = TMP_RECORD.CRPER_CODIGO AND CRMOV_FECHA_VIAJE < TMP_RECORD.CRMOV_FECHA_VIAJE
ORDER BY CRMOV_FECHA_VIAJE DESC LIMIT 1;
TMP_VALOR_DIAS_TRANSCURRIDO := (TMP_RECORD.CRMOV_FECHA_VIAJE::DATE - TMP_FECHA_OLD) + 1;
ELSE 
TMP_FECHA_OLD = TMP_RECORD.CRMOV_FECHA_VIAJE::DATE;
END IF;
END IF;
END LOOP;
IF (TMP_CRTST_CODIGO IS NOT NULL AND TMP_SW) THEN
TMP_VALOR_DIAS_TRANSCURRIDO := TMP_VALOR_DIAS_TRANSCURRIDO + (CURRENT_DATE - TMP_FECHA_OLD)+1;
END IF;
RETURN TMP_VALOR_DIAS_TRANSCURRIDO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_calculo_dias_estadia_temporales(timestamp with time zone, character varying)
  OWNER TO postgres;

-- FUNCIÓN QUE PARA VALIDAR EN NÚMERO DE DÍAS PERMITIDOS COMO TEMPORAL

-- Function: sii.f_tiempo_estadia_temporal(character varying, character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_tiempo_estadia_temporal(character varying, character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_tiempo_estadia_temporal(in_crper_codigo character varying, in_fecha_ingreso character varying, in_fecha_salida character varying, in_operador character varying, in_valor_comparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_ESTADIA INT;
        OUT_RESULTADO VARCHAR;
        TMP_ESTADIA_TOTAL INT;
        TMP_TIEMPO_RESTANTE INT;
BEGIN
	
	SELECT SII.F_CALCULO_DIAS_ESTADIA_TEMPORALES(CURRENT_TIMESTAMP, IN_CRPER_CODIGO) INTO TMP_ESTADIA;

	TMP_ESTADIA_TOTAL= (TMP_ESTADIA + (IN_FECHA_SALIDA::DATE - IN_FECHA_INGRESO::DATE));
	
	IF (TMP_ESTADIA = 0) THEN
            OUT_RESULTADO := 'true';
	ELSE
	    SELECT SII.F_CGG_REGLA_VALIDACION(TMP_ESTADIA_TOTAL::VARCHAR,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
	END IF;

	  IF (OUT_RESULTADO='false') THEN
	    TMP_TIEMPO_RESTANTE=730-TMP_ESTADIA;
	    OUT_RESULTADO='FALSE, Solo cuenta con: ' || TMP_TIEMPO_RESTANTE || ' días como residente temporal';
	    END IF;
	
	RETURN OUT_RESULTADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_tiempo_estadia_temporal(character varying, character varying, character varying, character varying, character varying)
  OWNER TO sii;

-- INGRESO EL REGISTRO DE VALIDACIÓN DE TIEMPO COMO TEMPORAL EN LA TABLA REGLA_VALIDACION

INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) 
VALUES ('CRVAL58', null, 'Tiempo permitido en categoría de temporal', 'Verifica que el beneficiario no exceda el tiempo permitido en la categoría de temporal.', 'F_TIEMPO_ESTADIA_TEMPORAL', '<=', '730', 'TRUE', 'El beneficiario ha excedido el tiempo permitido como residente temporal', 1, '2011-04-09 00:00:00.000000', '2011-04-09 00:00:00.000000', null, null, true, '2011-04-09 23:37:50.901388', 'patricia', '2011-04-09 23:37:50.901388', 'patricia');

-- FUNCIÓN QUE PARA VALIDAR EN NÚMERO DE DÍAS PERMITIDOS COMO TRANSEUNTE

-- Function: sii.f_tiempo_estadia_transeunte(character varying, character varying, character varying, character varying, character varying)

-- DROP FUNCTION sii.f_tiempo_estadia_transeunte(character varying, character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_tiempo_estadia_transeunte(in_crper_codigo character varying, in_fecha_ingreso character varying, in_fecha_salida character varying, in_operador character varying, in_valor_comparacion character varying)
  RETURNS character varying AS
$BODY$
DECLARE
	TMP_ESTADIA INT;
        OUT_RESULTADO VARCHAR;
         TMP_ESTADIA_TOTAL INT;
        TMP_TIEMPO_RESTANTE INT;
BEGIN
	
	SELECT SII.F_CALCULO_DIAS_ESTADIA_TRANSEUNTE(CURRENT_TIMESTAMP, IN_CRPER_CODIGO) INTO TMP_ESTADIA;

	TMP_ESTADIA_TOTAL= (TMP_ESTADIA + (IN_FECHA_SALIDA::DATE - IN_FECHA_INGRESO::DATE));
	
	IF (TMP_ESTADIA = 0) THEN
            OUT_RESULTADO := 'true';
	ELSE
	    SELECT SII.F_CGG_REGLA_VALIDACION(TMP_ESTADIA_TOTAL::VARCHAR,IN_OPERADOR,IN_VALOR_COMPARACION) INTO OUT_RESULTADO;
	END IF;

	 IF (OUT_RESULTADO = 'false') THEN
	    TMP_TIEMPO_RESTANTE=95-TMP_ESTADIA;
	    OUT_RESULTADO='FALSE, Solo cuenta con: ' || TMP_TIEMPO_RESTANTE || ' días como transeunte';
	 END IF;
	
	RETURN OUT_RESULTADO;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_tiempo_estadia_transeunte(character varying, character varying, character varying, character varying, character varying)
  OWNER TO sii;


-- CAMBIO EN LA FUNCION f_cgg_res_residencia_generar (CAMBIO DE FECHA DE INICIO PARA TEMPORALES)

-- Function: sii.f_cgg_res_residencia_generar(character varying, character varying, character varying)

-- DROP FUNCTION sii.f_cgg_res_residencia_generar(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION sii.f_cgg_res_residencia_generar(in_user_name character varying, in_crtra_codigo character varying, in_crseg_codigo character varying)
  RETURNS character varying AS
$BODY$
DECLARE
TMP_CRTST_CODIGO VARCHAR;
TMP_PERMANENTE VARCHAR;
TMP_TEMPORAL VARCHAR;
TMP_TRANSEUNTE VARCHAR;
TMP_IS_PERMANENTE BOOLEAN;
TMP_IS_TEMPORAL BOOLEAN;
TMP_IS_TRANSEUNTE BOOLEAN;
--FECHA DE INGRESO
TMP_CRTRA_FECHA_INGRESO TIMESTAMP WITH TIME ZONE;
--CODIGO DE RESIDENCIA
TMP_CRRSD_CODIGO VARCHAR;
--CODIGO DE LA NUEVA RESIDENCIA
TMP_NEW_CRRSD_CODIGO VARCHAR;
--FECHA DE CADUCIDAD DE LA RESIDENCIA
TMP_CRRSD_FECHA_CADUCIDAD TIMESTAMP WITH TIME ZONE;
--CODIGO DEL AUSPICIANTE DEL TRAMITE
TMP_CRPER_CODIGO VARCHAR;
--MODALIDAD DE LA RESIDENCIA ACTUAL
TMP_CRRSD_MODALIDAD INT;
--NUMERO DE RESIDENCIA ACTUAL
TMP_CRRSD_NUMERO INT;
--CODIGO DEL BENEFICIARIO DEL TRAMITE
TMP_CGG_CRPER_CODIGO VARCHAR;
--DIAS DE AUTORIZACION DE PERMANENCIA DENTRO DE LA PROVINCIA
TMP_DIAS_AUTORIZADOS INT;
--FECHA DE CADUCIDAD DE LA AUTORIZACION DE PERMANENCIA DENTRO DE LA PROVINCIA
TMP_FECHA_CADUCIDAD TIMESTAMP WITH TIME ZONE;
--CODIGO DE LA RESOLUCION ASOCIADA AL TRAMITE
TMP_CRRES_CODIGO VARCHAR;
--ESTADO DE LA RESOLUCION ASOCIADA AL TRAMITE
TMP_CRRES_ESTADO_RESOLUCION INT;
--BUFFER PARA ALMANCENAR EL CODIGO ASIGNADO EN LA INSERCION DE UN NUEVO REGISTRO.
TMP_CODIGO VARCHAR;
--FECHA DE APROBACION DE LA RESOLUCION
TMP_CRRES_FECHA_EMISION TIMESTAMP WITH TIME ZONE;
--NUMERO DE RESIDENCIA MAXIMO
TMP_MAX_RESIDENCIA INT;
--INDICE DE LA ISLA DONDE SE PRESENTO EL TRAMITE
TMP_CISLA_INDICE INT;
--INDICE PARA TIPO DE SOLICITUD PERMANENTE
TMP_INDICE_PERM INT;
--INDICE DEL TIPO DE RESIDENCIA
TMP_INDICE INT;
--INDICE PARA TIPO DE SOLICITUD TEMPORAL
TMP_INDICE_TEMP INT;
--MODALIDAD DE LA RESIDENCIA PERMANENTE O TEMPORAL
TMP_MODALIDAD INT;
--REGISTRO DE TABLA DE SEGUIMIENTO
TMP_RSGM RECORD;
--ESTADO DEL TRAMITE
TMP_CRETT_CODIGO VARCHAR;
--SI EL TIPO DE SOLICITUD DEBE GENERAR TRANSEUNTE TEMPORAL
TMP_APLICA_OTRO BOOLEAN;
--OBTIENE EL ESTADO DE TRAMITE PARA CUANDO ESTA LISTO PARA TRATARSE EN COMITE
TMP_ESTADO_COMITE VARCHAR;
--SI LA RESIDENCIA TIENE UN TRAMITE PENDIENTE
TMP_CRRSD_TRAMITE_PENDIENTE BOOLEAN;
--REGISTRO DE FASE QUE ESTA CUMPLIENDO EL SEGUIMIENTO
TMP_RFS RECORD;
--ISLA DE PRESENTACION
TMP_CISLA_CODIGO VARCHAR;
--ISLA DE LA OBTENCION DE LA RESIDENCIA
TMP_RSD_ISLA VARCHAR;
--CODIGO DE LA TABLA RESOL_TRAMITE
TMP_CRRST_CODIGO VARCHAR;
BEGIN
TMP_CRRSD_TRAMITE_PENDIENTE := FALSE;

--OBTIENE EL REGISTRO DEL TABLA SEGUIMIENTO
SELECT * INTO TMP_RSGM
FROM SII.CGG_RES_SEGUIMIENTO
WHERE CRSEG_CODIGO = IN_CRSEG_CODIGO AND
CRTRA_CODIGO = IN_CRTRA_CODIGO;

--OBTIENE LA FASE QUE ESTA CUMPLIENDO EL SEGUIMIENTO
SELECT * INTO TMP_RFS
FROM SII.CGG_RES_FASE
WHERE CRFAS_CODIGO = TMP_RSGM.CRFAS_CODIGO;

--OBTIENE EL TIPO DE SOLICITUD DEL TRAMITE
SELECT TST.CRRES_CODIGO,
TST.CRTST_CODIGO,
TRM.CRPER_CODIGO,
TRM.CGG_CRPER_CODIGO,
TRM.CRTRA_DIAS_PERMANENCIA,
TRM.CRTRA_FECHA_INGRESO,
TRM.CRTRA_FECHA_SALIDA,
SL.CISLA_INDICE,
TRM.CRETT_CODIGO,
TST.CRTST_APLICA_OTRO,
TRM.CISLA_CODIGO
INTO TMP_CRRES_CODIGO,
TMP_CRTST_CODIGO,
TMP_CRPER_CODIGO,
TMP_CGG_CRPER_CODIGO,
TMP_DIAS_AUTORIZADOS,
TMP_CRTRA_FECHA_INGRESO,
TMP_FECHA_CADUCIDAD,
TMP_CISLA_INDICE,
TMP_CRETT_CODIGO,
TMP_APLICA_OTRO,
TMP_CISLA_CODIGO
FROM SII.CGG_RES_TRAMITE TRM
INNER JOIN SII.CGG_ISLA SL ON SL.CISLA_CODIGO = TRM.CISLA_CODIGO AND SL.CISLA_ESTADO
INNER JOIN SII.CGG_RES_TIPO_SOLICITUD_TRAMITE TST ON TST.CRTST_CODIGO = case when TRM.CHANGE_CRTST_CODIGO is null then TRM.CRTST_CODIGO else TRM.CHANGE_CRTST_CODIGO end AND TST.CRTST_ESTADO
WHERE TRM.CRTRA_CODIGO = IN_CRTRA_CODIGO;

SELECT CRRST_CODIGO INTO TMP_CRRST_CODIGO
FROM SII.CGG_RES_RESOL_TRAMITE
WHERE CRTRA_CODIGO = IN_CRTRA_CODIGO AND
CRRST_ESTADO;

IF (TMP_CRRES_CODIGO IS NOT NULL AND TMP_CRRST_CODIGO IS NULL) THEN
SELECT SII.F_CGG_RES_RESOL_TRAMITE_INSERT(
'KEYGEN'::VARCHAR,
TMP_CRRES_CODIGO,
IN_CRTRA_CODIGO,
TRUE,
IN_USER_NAME
) INTO TMP_CODIGO;
END IF;

--OBTIENE INFORMACION DE LA RESOLUCION ASOCIADA AL TRAMITE
SELECT RSL.CRRES_CODIGO,
RSL.CRRES_ESTADO_RESOLUCION,
RSL.CRRES_FECHA_EMISION
INTO TMP_CRRES_CODIGO,
TMP_CRRES_ESTADO_RESOLUCION,
TMP_CRRES_FECHA_EMISION
FROM SII.CGG_RES_RESOL_TRAMITE RST
INNER JOIN SII.CGG_RES_RESOLUCION RSL ON RSL.CRRES_CODIGO = RST.CRRES_CODIGO AND RSL.CRRES_ESTADO
WHERE RST.CRTRA_CODIGO = IN_CRTRA_CODIGO AND
RST.CRRST_ESTADO;

--SI LA RESIDENCIA SE APRUEBA CON RESOLUCION ANTERIOR, SE ESCOGE LA FECHA DE APROBACION DEL SEGUIMIENTO
IF (TMP_CODIGO IS NOT NULL OR TMP_CRRES_CODIGO IS NULL) THEN
SELECT CRSEG_FECHA_DESPACHO INTO TMP_CRRES_FECHA_EMISION
FROM SII.CGG_RES_SEGUIMIENTO SGM
WHERE SGM.CRTRA_CODIGO = IN_CRTRA_CODIGO AND
SGM.CRSEG_ESTADO
ORDER BY CRSEG_FECHA_DESPACHO DESC
LIMIT 1;
END IF;

--OBTIENE EL TIPO DE SOLICITUD PADRE PARA RESIDENCIA PERMANENTE
SELECT CGCNF_VALOR_CADENA INTO TMP_PERMANENTE
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '03';
--OBTIENE EL INDICE DEL TIPO DE SOLICITUD DE TRAMITE PARA PERMANENTES
SELECT CRTST_INDICE INTO TMP_INDICE_PERM
FROM SII.CGG_RES_TIPO_SOLICITUD_TRAMITE
WHERE CRTST_CODIGO = TMP_PERMANENTE;

--OBTIENE EL TIPO DE SOLICITUD PADRE PARA RESIDENCIA TEMPORAL
SELECT CGCNF_VALOR_CADENA INTO TMP_TEMPORAL
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '04';
--OBTIENE EL INDICE DEL TIPO DE SOLICITUD DE TRAMITE PARA TEMPORALES
SELECT CRTST_INDICE INTO TMP_INDICE_TEMP
FROM SII.CGG_RES_TIPO_SOLICITUD_TRAMITE
WHERE CRTST_CODIGO = TMP_TEMPORAL;

--OBTIENE EL TIPO DE SOLICITUD PADRE PARA TRANSEUNTES
SELECT CGCNF_VALOR_CADENA INTO TMP_TRANSEUNTE
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '05';

--VERIFICA SI EL TIPO DE SOLICITUD DEL TRAMITE ES PARA RESIDENCIA PERMANENTE O TEMPORAL
TMP_IS_PERMANENTE := SII.F_PARENT_OF(TMP_PERMANENTE, TMP_CRTST_CODIGO);
TMP_IS_TEMPORAL := SII.F_PARENT_OF(TMP_TEMPORAL, TMP_CRTST_CODIGO);
TMP_IS_TRANSEUNTE := SII.F_PARENT_OF(TMP_TRANSEUNTE, TMP_CRTST_CODIGO);

--OBTIENE EL ESTADO DE TRAMITE QUE INDICA QUE EL TRAMITE ESTA LISTO PARA TRATARSE EN COMITE
SELECT CGCNF_VALOR_CADENA INTO TMP_ESTADO_COMITE
FROM SII.CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '01';

IF (TMP_IS_TEMPORAL AND TMP_APLICA_OTRO AND (TMP_RFS.CRETT_CODIGO = TMP_ESTADO_COMITE OR TMP_RFS.CGG_CRETT_CODIGO = TMP_ESTADO_COMITE)) THEN
TMP_IS_TEMPORAL = FALSE;
TMP_IS_TRANSEUNTE = TRUE;
TMP_CRTST_CODIGO := TMP_TRANSEUNTE;
TMP_CRRSD_TRAMITE_PENDIENTE := TRUE;
END IF;

IF(NOT TMP_IS_PERMANENTE AND NOT TMP_IS_TEMPORAL AND NOT TMP_IS_TRANSEUNTE) THEN
RETURN 'El tramite indicado no genera residencia para el beneficiario.';
END IF;

IF(TMP_IS_PERMANENTE)THEN
TMP_MODALIDAD := 0;
TMP_CRRSD_FECHA_CADUCIDAD := NULL;
TMP_INDICE := TMP_INDICE_PERM;
ELSIF(TMP_IS_TEMPORAL OR TMP_IS_TRANSEUNTE)THEN
TMP_MODALIDAD := 1;
TMP_INDICE := TMP_INDICE_TEMP;
IF(TMP_DIAS_AUTORIZADOS <= 0 )THEN
TMP_CRRSD_FECHA_CADUCIDAD := TMP_FECHA_CADUCIDAD::DATE;
ELSE
TMP_CRRSD_FECHA_CADUCIDAD := TMP_CRRES_FECHA_EMISION::DATE + TMP_DIAS_AUTORIZADOS;
END IF;
TMP_CRRSD_FECHA_CADUCIDAD := TMP_CRRSD_FECHA_CADUCIDAD + interval '23:59:00';
END IF;

--OBTIENE EL NUMERO DE RESIDENCIA MAXIMO DE ENTRE TODAS LAS RESIDENCIAS DE ACUERDO A LA MODALIDAD
SELECT MAX(CRRSD_NUMERO) INTO TMP_MAX_RESIDENCIA
FROM SII.CGG_RES_RESIDENCIA RSD
WHERE CRRSD_MODALIDAD = TMP_MODALIDAD AND
CISLA_CODIGO = TMP_CISLA_CODIGO AND
CRRSD_ESTADO;

IF (TMP_MAX_RESIDENCIA IS NULL) THEN
TMP_MAX_RESIDENCIA := 0;
END IF;

IF (NOT TMP_IS_TRANSEUNTE) THEN
TMP_MAX_RESIDENCIA := (TMP_MAX_RESIDENCIA + 1);
ELSE
TMP_CRRES_FECHA_EMISION := TMP_CRTRA_FECHA_INGRESO::DATE;
TMP_MAX_RESIDENCIA := NULL;
END IF;

--SELECCIONA LA RESIDENCIA DE LA PERSONA QUE HAYA SIDO DE LA MISMA MODALIDAD DE LA NUEVA RESIDENCIA
SELECT CRRSD_CODIGO, CRRSD_MODALIDAD
INTO TMP_CRRSD_CODIGO, TMP_CRRSD_MODALIDAD
FROM SII.CGG_RES_RESIDENCIA
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO AND
CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
FROM CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '03') OR CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
FROM CGG_CONFIGURACION
WHERE CGCNF_CODIGO = '04'))
UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
) SELECT CRTST_CODIGO  FROM TIPO) AND
CRRSD_ESTADO
ORDER BY CRRSD_FECHA_INICIO DESC LIMIT 1;
IF (TMP_CRRSD_CODIGO IS NOT NULL AND NOT TMP_IS_TRANSEUNTE) THEN
IF(TMP_CRRSD_MODALIDAD = TMP_MODALIDAD)THEN
SELECT CRRSD_NUMERO, CISLA_CODIGO INTO TMP_CRRSD_NUMERO, TMP_RSD_ISLA
FROM SII.CGG_RES_RESIDENCIA
WHERE CRRSD_CODIGO = TMP_CRRSD_CODIGO;
IF(TMP_CRRSD_NUMERO IS NOT NULL)THEN
TMP_MAX_RESIDENCIA := TMP_CRRSD_NUMERO;
TMP_CISLA_CODIGO := TMP_RSD_ISLA;
SELECT CISLA_INDICE INTO TMP_CISLA_INDICE FROM SII.CGG_ISLA WHERE CISLA_CODIGO = TMP_CISLA_CODIGO;
END IF;
END IF;
END IF;

--SELECCIONA LA RESIDENCIA VIGENTE DEL BENEFICIARIO PARA CERRAR
SELECT CRRSD_CODIGO INTO TMP_CRRSD_CODIGO
FROM SII.CGG_RES_RESIDENCIA
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO AND
CRRSD_VIGENTE AND
CRRSD_ESTADO;
IF (TMP_CRRSD_CODIGO IS NOT NULL AND CURRENT_DATE::DATE >= TMP_CRRES_FECHA_EMISION::DATE) THEN
UPDATE SII.CGG_RES_RESIDENCIA SET CRRSD_VIGENTE = FALSE,
--CRRSD_FECHA_CADUCIDAD = TMP_CRRES_FECHA_EMISION - interval '00:01:00',
CRRSD_USUARIO_UPDATE = IN_USER_NAME,
CRRSD_FECHA_UPDATE = CURRENT_TIMESTAMP
WHERE CRRSD_CODIGO = TMP_CRRSD_CODIGO;
END IF;

--MO: ASIGNACIÓN DE LA FECHA DE INICIO INGRESADA POR USUARIO EXTERNO PARA TEMPORALES

IF (TMP_IS_TEMPORAL) THEN
TMP_CRRES_FECHA_EMISION := TMP_CRTRA_FECHA_INGRESO;
END IF;

--CREACION DE LA RESIDENCIA
SELECT SII.F_CGG_RES_RESIDENCIA_INSERT(
'KEYGEN'::VARCHAR,
TMP_CGG_CRPER_CODIGO,
TMP_CRTST_CODIGO,
IN_CRTRA_CODIGO,
NULL::VARCHAR,
TMP_MAX_RESIDENCIA::INTEGER,
TMP_MODALIDAD::SMALLINT,
TMP_CRRES_FECHA_EMISION::TIMESTAMP WITH TIME ZONE,
TMP_CRRSD_FECHA_CADUCIDAD::TIMESTAMP WITH TIME ZONE,
FALSE,
NULL::TIMESTAMP WITH TIME ZONE,
NULL::VARCHAR,
(TMP_CRRSD_CODIGO IS NULL OR CURRENT_DATE::DATE >= COALESCE(TMP_CRRES_FECHA_EMISION::DATE, CURRENT_DATE + 1) ), --VIGENTE
TMP_CRRSD_TRAMITE_PENDIENTE,
TRUE,
IN_USER_NAME
)INTO TMP_NEW_CRRSD_CODIGO;

--ACTUALIZACION DE LA ISLA DE LA RESIDENCIA
UPDATE SII.CGG_RES_RESIDENCIA SET CISLA_CODIGO = TMP_CISLA_CODIGO
WHERE CRRSD_CODIGO = TMP_NEW_CRRSD_CODIGO;

--ACTUALIZACION DEL NUMERO DE RESIDENCIA DE LA PERSONA
IF (NOT TMP_IS_TRANSEUNTE) THEN
UPDATE SII.CGG_RES_PERSONA SET
CRPER_NUMERO_RESIDENCIA = TMP_CISLA_INDICE::VARCHAR||TMP_INDICE::VARCHAR||LPAD(TMP_MAX_RESIDENCIA::VARCHAR,5,'0'),
CRPER_USUARIO_UPDATE = IN_USER_NAME,
CRPER_FECHA_UPDATE = CURRENT_TIMESTAMP
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO;
UPDATE SII.CGG_RES_RESIDENCIA SET
CRRSD_NUMERO_RESIDENCIA = TMP_CISLA_INDICE::VARCHAR||TMP_INDICE::VARCHAR||LPAD(TMP_MAX_RESIDENCIA::VARCHAR,5,'0'),
CRRSD_USUARIO_UPDATE = IN_USER_NAME,
CRRSD_FECHA_UPDATE = CURRENT_TIMESTAMP
WHERE CRPER_CODIGO = TMP_CGG_CRPER_CODIGO AND CRRSD_CODIGO = TMP_NEW_CRRSD_CODIGO;
END IF;

--CREA UN NUEVO USUARIO PARA EL RESIDENTE PERMANENTE
IF (TMP_IS_PERMANENTE) THEN
SELECT SII.F_CGG_RES_RESIDENCIA_USUARIO(IN_USER_NAME,TMP_CGG_CRPER_CODIGO,IN_CRTRA_CODIGO) INTO TMP_CODIGO;
END IF;


--CREA LOS REGISTRO DE SOPORTE SI LA PERSONA ESTA DENTRO DE LA PROVINCIA Y CAMBIA DE RESIDENCIA
IF (CURRENT_DATE::DATE >= TMP_CRRES_FECHA_EMISION::DATE) THEN
SELECT SII.F_CREAR_REGISTROS_SOPORTE(IN_USER_NAME,
TMP_CGG_CRPER_CODIGO,
TMP_NEW_CRRSD_CODIGO,
TMP_CRRES_FECHA_EMISION,
TMP_CRRSD_FECHA_CADUCIDAD,
IN_CRTRA_CODIGO
) INTO TMP_CODIGO;
END IF;
RETURN 'TRUE';
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_cgg_res_residencia_generar(character varying, character varying, character varying)
  OWNER TO postgres;

--TIPO TRAMITE COMBO

INSERT INTO sii.cgg_tipo_tramite (crtt_codigo, crtt_nombre, crtt_estado) VALUES ('CRTT5', 'Primera Vez', true);
INSERT INTO sii.cgg_tipo_tramite (crtt_codigo, crtt_nombre, crtt_estado) VALUES ('CRTT7', 'Revocatoria', true);
INSERT INTO sii.cgg_tipo_tramite (crtt_codigo, crtt_nombre, crtt_estado) VALUES ('CRTT6', 'Renovación', true);

update sii.cgg_tipo_tramite set crtt_estado = false where crtt_codigo='CRTT1' or crtt_codigo='CRTT2'

-- RES TIPO TRAMITE

INSERT INTO sii.cgg_res_tipo_tramite (crtpt_codigo, crtpt_nombre, crtpt_abreviatura, crtpt_indice, crtpt_observaciones, crtpt_estado, crtpt_fecha_insert, crtpt_usuario_insert, crtpt_fecha_update, crtpt_usuario_update) VALUES ('CRTPT3', 'Revocatoria', 'RVC', 3, 'Tramite para revocacion de residencia', true, null, null, null, null);
 


--CREACIÓN DE PROCESO PARA SOLICITUD DE TRÁMITE

-- Creación de proceso: Solicitud Residencia 2016
INSERT INTO sii.cgg_res_proceso (crpro_codigo, crpro_nombre, crpro_estado, crpro_fecha_insert, crpro_usuario_insert, crpro_fecha_update, crpro_usuario_update) 
VALUES ('CRPRO81', 'Solicitud Residencia 2016', true, current_timestamp, 'patricia', '2016-06-02 09:19:17.959675', 'patricia');

-- Creación de fases para el proceso Solicitud Residencia 2016

INSERT INTO sii.cgg_res_fase (crfas_codigo, crpro_codigo, crett_codigo, cgg_crett_codigo, crsec_codigo, cgg_crfas_codigo, cgg_cusu_codigo, crfas_nombre, crfas_orden, crfas_tarea_realiza, crfas_funcion_ejecuta, crfas_sube_adjunto, crfas_sube_adjunto_requisito, crfas_ejecuta_despacho, crfas_atencion_normal, crfas_estado, crfas_fecha_insert, crfas_usuario_insert, crfas_fecha_update, crfas_usuario_update) 
VALUES ('CRFAS288', 'CRPRO81', null, null, 'CRSEC6', null, null, 'Recepción Trámite 2016', 1, 'Se ingresa via web la solicitud de tramite para residencia permanente', '', true, true, false, true, true, '2016-06-02 10:36:09.144272', 'patricia', '2016-06-02 10:36:09.144272', 'patricia');
INSERT INTO sii.cgg_res_fase (crfas_codigo, crpro_codigo, crett_codigo, cgg_crett_codigo, crsec_codigo, cgg_crfas_codigo, cgg_cusu_codigo, crfas_nombre, crfas_orden, crfas_tarea_realiza, crfas_funcion_ejecuta, crfas_sube_adjunto, crfas_sube_adjunto_requisito, crfas_ejecuta_despacho, crfas_atencion_normal, crfas_estado, crfas_fecha_insert, crfas_usuario_insert, crfas_fecha_update, crfas_usuario_update) 
VALUES ('CRFAS289', 'CRPRO81', null, null, 'CRSEC24', null, null, 'Digitalizacion 2016', 2, 'Revision de los adjuntos y la informacion ingresada por los solicitantes de residencia permanente', '', true, true, false, true, true, '2016-06-02 10:48:31.817610', 'patricia', '2016-06-02 10:48:31.817610', 'patricia');
INSERT INTO sii.cgg_res_fase (crfas_codigo, crpro_codigo, crett_codigo, cgg_crett_codigo, crsec_codigo, cgg_crfas_codigo, cgg_cusu_codigo, crfas_nombre, crfas_orden, crfas_tarea_realiza, crfas_funcion_ejecuta, crfas_sube_adjunto, crfas_sube_adjunto_requisito, crfas_ejecuta_despacho, crfas_atencion_normal, crfas_estado, crfas_fecha_insert, crfas_usuario_insert, crfas_fecha_update, crfas_usuario_update) 
VALUES ('CRFAS290', 'CRPRO81', 'CRETT3', 'CRETT4', 'CRSEC4', null, null, 'Calificacion 2016', 3, 'Calificación de solicitud de residencia', 'com.bmlaurus.phaserule.GenerarResolucion', true, true, true, true, true, '2016-06-02 10:58:37.713440', 'patricia', '2016-06-02 11:09:05.007827', 'patricia');

-- Creación de Requerimientos para cada fase

-- Requerimientos fase Digitalizacion 2016
INSERT INTO sii.cgg_jur_criterio (cjcri_codigo, crfas_codigo, cjcri_requerimiento, cjcri_requerido, cjcri_estado, cjcri_fecha_insert, cjcri_usuario_insert, cjcri_fecha_update, cjcri_usuario_update) 
VALUES ('CJCRI354', 'CRFAS289', 'Revision de datos ingresados', true, true, '2016-06-02 10:48:31.817610', 'patricia', '2016-06-02 10:48:31.817610', 'patricia');
INSERT INTO sii.cgg_jur_criterio (cjcri_codigo, crfas_codigo, cjcri_requerimiento, cjcri_requerido, cjcri_estado, cjcri_fecha_insert, cjcri_usuario_insert, cjcri_fecha_update, cjcri_usuario_update) 
VALUES ('CJCRI355', 'CRFAS289', 'Revision de adjuntos', true, true, '2016-06-02 10:48:31.817610', 'patricia', '2016-06-02 10:48:31.817610', 'patricia');


-- Creación de datos para tipo solicitud trámite
-- Hijo de padre o madre residentes permanentes (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST342', 'CRTST1', 'CRTPT1', 'CRPRO81', null, 'CKESP1', 'Art. 40-1 Hijo de residente permanente', 'Los hijos de padre o madre residentes permanentes pueden adquirir el estado de residentes permantes.', false, true, false, true, true, false, 0, false, false, false, true, 0, true, '2016-06-03 10:40:04.360929', 'patricia', '2016-08-18 10:35:50.424186', 'patricia', null);


-- Requisitos de tipo solicitud tramite (hijos padres permanentes)

INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1949', 'CRREQ154', 'CRTST342', '', false, 0, true, '2016-06-15 18:06:40.554242', 'patricia', '2016-08-18 10:35:50.434239', 'patricia'),
('CRSRQ1916', 'CRREQ153', 'CRTST342', '', false, 0, true, '2016-06-15 18:06:40.554242', 'patricia', '2016-08-18 10:35:50.434239', 'patricia'),
('CRSRQ1913', 'CRREQ155', 'CRTST342', '', false, 0, true, '2016-06-15 18:06:40.554242', 'patricia', '2016-08-18 10:35:50.434239', 'patricia'),
('CRSRQ1914', 'CRREQ153', 'CRTST342', '', false, 1, true, '2016-06-15 18:06:40.554242', 'patricia', '2016-08-18 10:35:50.434239', 'patricia'),
('CRSRQ1915', 'CRREQ154', 'CRTST342', '', false, 1, true, '2016-06-15 18:06:40.554242', 'patricia', '2016-08-18 10:35:50.434239', 'patricia');


-- Reglas de tipo solicitud trámite (hijos padres permanentes)

INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1008', 'CRTST342', 'CRVAL52', '[{"com.bmlaurus.rule.HijoDelAuspiciante":""}]', null, true, '2016-08-08 08:52:45.581506', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE1009', 'CRTST342', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 08:52:45.581506', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE827', 'CRTST342', 'CRVAL27', '[{"IN_CRPER_CODIGO":"crperCodigo"}]', null, true, '2016-06-15 14:28:44.010183', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE881', 'CRTST342', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-05 17:44:13.345270', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE880', 'CRTST342', 'CRVAL46', '[{"com.bmlaurus.rule.VoteCNE":""}]', null, true, '2016-07-05 17:44:13.345270', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE847', 'CRTST342', 'CRVAL36', '[{"com.bmlaurus.rule.temporal.MinorChild":""}]', null, true, '2016-07-01 14:33:57.065120', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE893', 'CRTST342', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-06 12:14:59.007136', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', ''),
('CRTSE892', 'CRTST342', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-06 12:05:21.320789', 'patricia', '2016-08-18 10:35:50.434239', 'patricia', '');

INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo)
VALUES ('CRTSE1150', 'CRTST343', 'CRVAL11', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:36:35.342036', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', '');


-- Opciones (hijos de padres permanentes)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO890', 'CRTSO2', 'CRTST342', true, '2016-08-18 10:35:50.434239', 'patricia', '2016-08-18 10:35:50.434239', 'patricia'),
('CRTAO914', 'CRTSO3', 'CRTST342', true, '2016-08-18 10:35:50.434239', 'patricia', '2016-08-18 10:35:50.434239', 'patricia'),
('CRTAO915', 'CRTSO12', 'CRTST342', true, '2016-08-18 10:35:50.434239', 'patricia', '2016-08-18 10:35:50.434239', 'patricia');

-- Adjuntos
-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM7', 'Cgg_res_tramite', 'crtst_codigo=''CRTST342''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL77', 'ECM7', 'informeResolucion', 'Resolucion', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL69', 'ECM7', 'identificacion', 'Identificación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL117', 'ECM7', 'identificacion', 'Identificación del auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL71', 'ECM7', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);


-- Cónyuge de residente permanente (tipo solicitud tramite) --
INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST343', 'CRTST1', 'CRTPT1', 'CRPRO81', null, 'CKESP1', 'Art. 40-2 Cónyuge de residente permanente', 'Él o la cónyuge de una persona residente permanente, siempre que hayan transcurrido por lo menos diez años desde la fecha en que contrajeron matrimonio.', false, true, false, true, true, false, 0, false, false, false, true, 0, true, '2016-06-05 21:28:17.340288', 'patricia', '2016-08-18 10:36:35.330761', 'patricia', null);


-- Requisitos de tipo solicitud tramite (Conyuge residente permanente)

INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1951', 'CRREQ154', 'CRTST343', '', false, 0, true, '2016-06-16 09:52:59.254548', 'patricia', '2016-08-18 10:36:35.342036', 'patricia'),
('CRSRQ1950', 'CRREQ153', 'CRTST343', '', false, 0, true, '2016-06-16 09:52:59.254548', 'patricia', '2016-08-18 10:36:35.342036', 'patricia'),
('CRSRQ1920', 'CRREQ155', 'CRTST343', '', false, 0, true, '2016-06-16 09:52:59.254548', 'patricia', '2016-08-18 10:36:35.342036', 'patricia'),
('CRSRQ1919', 'CRREQ154', 'CRTST343', '', false, 1, true, '2016-06-16 09:52:59.254548', 'patricia', '2016-08-18 10:36:35.342036', 'patricia'),
('CRSRQ1918', 'CRREQ153', 'CRTST343', '', false, 1, true, '2016-06-16 09:52:59.254548', 'patricia', '2016-08-18 10:36:35.342036', 'patricia'),
('CRSRQ1917', 'CRREQ156', 'CRTST343', '', false, 4, true, '2016-06-16 09:52:59.254548', 'patricia', '2016-08-18 10:36:35.342036', 'patricia');

-- Reglas de tipo solicitud trámite (cónyuge residente permanente)

INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) VALUES ('CRVAL30', null, 'Beneficiario casado con Auspiciante', 'Verifica si un beneficiario esta casado legalmente con el Auspiciante', 'com.bmlaurus.rule.DinardapMarriedValidator', '=', 'TRUE', 'TRUE', 'El beneficiario debe estar casado con el auspiciante para solicitar este trámite', 1, '2011-03-13 01:00:00.000000', '2011-03-13 01:00:00.000000', null, null, true, '2011-03-18 14:11:12.165745', 'patricia', '2011-05-26 10:44:52.184323', 'patricia');

INSERT INTO sii.cgg_regla_validacion (crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update) VALUES ('CRVAL49', null, 'Tipo de Identificación', 'Verifica que el tipo de identificación sea cédula o pasaporte', 'com.bmlaurus.rule.KindID', '=', 'TRUE', 'TRUE', 'El tipo de identificación debe ser cédula o pasaporte', 1, '2011-03-13 01:00:00.000000', '2011-03-13 01:00:00.000000', null, null, true, '2011-03-18 14:11:12.165745', 'patricia', null, null);


INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1011', 'CRTST343', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:20:52.761730', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE833', 'CRTST343', 'CRVAL31', '[{"com.bmlaurus.rule.MarriedBeforeJune11Validator":""}]', null, true, '2016-06-22 13:22:41.951690', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE832', 'CRTST343', 'CRVAL30', '[{"com.bmlaurus.rule.DinardapMarriedValidator":""}]', null, true, '2016-06-22 10:27:04.370183', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE894', 'CRTST343', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-06 12:16:08.988297', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE895', 'CRTST343', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-06 12:16:08.988297', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE882', 'CRTST343', 'CRVAL46', '[{"com.bmlaurus.rule.VoteCNE":""}]', null, true, '2016-07-05 17:45:52.900704', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE883', 'CRTST343', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-05 17:45:52.900704', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE998', 'CRTST343', 'CRVAL49', '[{"com.bmlaurus.rule.KindID":""}]', null, true, '2016-07-14 14:48:02.827246', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE807', 'CRTST343', 'CRVAL27', '[{"IN_CRPER_CODIGO":"crperCodigo"}]', null, true, '2016-06-05 21:28:17.340288', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', ''),
('CRTSE1150', 'CRTST343', 'CRVAL11', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:36:35.342036', 'patricia', '2016-08-18 10:36:35.342036', 'patricia', '');

-- Opciones (cónyuge residente permanente)

INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO891', 'CRTSO2', 'CRTST343', true, '2016-08-18 10:36:35.342036', 'patricia', '2016-08-18 10:36:35.342036', 'patricia');

-- Adjuntos (cónyuge residente permanente)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM8', 'Cgg_res_tramite', 'crtst_codigo=''CRTST343''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL78', 'ECM8', 'informeResolucion', 'Resolucion', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL70', 'ECM8', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL45', 'ECM8', 'identificacion', 'Identificación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Conviviente de residente permanente (tipo solicitud tramite) --
INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) VALUES ('CRTST344', 'CRTST1', 'CRTPT1', 'CRPRO81', null, 'CKESP1', 'Art. 40-3 Conviviente de residente permanente', 'Él o la conviviente de una persona residente permanente, siempre que se encuentren en unión de hecho al menos por diez años. Se entenderá que existe unión de hecho cuando se han cumplido los requisitos previstos en la legislación nacional. El plazo de que trata este numeral empezará a contarse desde la fecha en que se presente la solicitud de residencia temporal para él o la conviviente de una persona residente permanente.', false, true, false, true, true, false, 0, false, false, false, true, 0, true, '2016-06-05 22:07:37.188364', 'patricia', '2016-08-18 10:37:18.895457', 'patricia', null);


-- Requisitos de tipo solicitud tramite (Conviviente residente permanente)

INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1953', 'CRREQ154', 'CRTST344', '', false, 0, true, '2016-06-16 10:20:46.459422', 'patricia', '2016-08-18 10:37:18.906853', 'patricia'),
('CRSRQ1952', 'CRREQ153', 'CRTST344', '', false, 0, true, '2016-06-16 10:20:46.459422', 'patricia', '2016-08-18 10:37:18.906853', 'patricia'),
('CRSRQ1924', 'CRREQ155', 'CRTST344', '', false, 0, true, '2016-06-16 10:20:46.459422', 'patricia', '2016-08-18 10:37:18.906853', 'patricia'),
('CRSRQ1923', 'CRREQ153', 'CRTST344', '', false, 1, true, '2016-06-16 10:20:46.459422', 'patricia', '2016-08-18 10:37:18.906853', 'patricia'),
('CRSRQ1921', 'CRREQ157', 'CRTST344', '', false, 4, true, '2016-06-16 10:20:46.459422', 'patricia', '2016-08-18 10:37:18.906853', 'patricia'),
('CRSRQ1922', 'CRREQ154', 'CRTST344', '', false, 1, true, '2016-06-16 10:20:46.459422', 'patricia', '2016-08-18 10:37:18.906853', 'patricia');

-- Reglas de tipo solicitud trámite (conviviente residente permanente)

INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE896', 'CRTST344', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-06 12:17:04.008910', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE1013', 'CRTST344', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:24:08.085381', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE834', 'CRTST344', 'CRVAL32', '[{"com.bmlaurus.rule.FreeUnionValidator":""}]', null, true, '2016-06-22 13:30:00.570154', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE835', 'CRTST344', 'CRVAL33', '[{"com.bmlaurus.rule.TenyearsApplicationResidenceValidator":""}]', null, true, '2016-06-22 13:30:00.570154', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE884', 'CRTST344', 'CRVAL46', '[{"com.bmlaurus.rule.VoteCNE":""}]', null, true, '2016-07-05 17:46:41.255649', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE885', 'CRTST344', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-05 17:46:41.255649', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE897', 'CRTST344', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-06 12:17:04.008910', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE808', 'CRTST344', 'CRVAL27', '[{"IN_CRPER_CODIGO":"crperCodigo"}]', null, true, '2016-06-05 22:07:37.188364', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE999', 'CRTST344', 'CRVAL49', '[{"com.bmlaurus.rule.KindID":""}]', null, true, '2016-07-14 14:48:19.579854', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', ''),
('CRTSE1151', 'CRTST344', 'CRVAL11', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:37:18.906853', 'patricia', '2016-08-18 10:37:18.906853', 'patricia', '');

-- Opciones (conviviente residente permanente)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO892', 'CRTSO2', 'CRTST344', true, '2016-08-18 10:37:18.906853', 'patricia', '2016-08-18 10:37:18.906853', 'patricia');

-- Adjuntos (conviviente residente permanente)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM9', 'Cgg_res_tramite', 'crtst_codigo=''CRTST344''', null, true, true, 'patricia', 'patricia');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL72', 'ECM9', 'identificacion', 'Identificación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL79', 'ECM9', 'informeResolucion', 'Resolucion', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL73', 'ECM9', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Octava Transitoria (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST380', 'CRTST1', 'CRTPT1', 'CRPRO81', null, 'CKESP1', 'Permanente octava transitoria', 'Para los habitantes que llegaron al archipiélago hasta el 18 de marzo del 2000 y aspiran obtener la residencia permanente.', false, true, false, false, true, false, 0, false, false, false, true, 0, true, '2016-07-06 09:56:23.559664', 'patricia', '2016-08-18 10:38:12.743241', 'patricia', true);

-- Requisitos de tipo solicitud tramite (octava transitoria)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1984', 'CRREQ153', 'CRTST380', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-06 11:47:27.909728', 'patricia', '2016-08-18 10:38:12.754584', 'patricia'),
('CRSRQ1983', 'CRREQ154', 'CRTST380', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-06 11:47:27.909728', 'patricia', '2016-08-18 10:38:12.754584', 'patricia'),
('CRSRQ1985', 'CRREQ158', 'CRTST380', 'Presentar documentos probatorios', false, 1, true, '2016-07-06 11:48:30.390910', 'patricia', '2016-08-18 10:38:12.754584', 'patricia');

-- Reglas de tipo solicitud trámite (octava transitoria)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE898', 'CRTST380', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-06 12:17:54.756367', 'patricia', '2016-08-18 10:38:12.754584', 'patricia', ''),
('CRTSE899', 'CRTST380', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-06 12:17:54.756367', 'patricia', '2016-08-18 10:38:12.754584', 'patricia', ''),
('CRTSE1015', 'CRTST380', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:25:55.485671', 'patricia', '2016-08-18 10:38:12.754584', 'patricia', ''),
('CRTSE1152', 'CRTST380', 'CRVAL11', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:38:12.754584', 'patricia', '2016-08-18 10:38:12.754584', 'patricia', '');

-- Adjuntos (octava transitoria)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM25', 'Cgg_res_tramite', 'crtst_codigo=''CRTST380''', null, true, true, 'patricia', 'patricia');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL80', 'ECM25', 'informeResolucion', 'Resolucion', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL81', 'ECM25', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL46', 'ECM25', 'identificacion', 'Identificacion del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-1A Cónyuge de residente permanente (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST352', 'CRTST2', 'CRTPT1', 'CRPRO81', null, 'CKESP5', 'Art. 41-1A Cónyuge de residente permanente', 'Al cónyuge o conviviente, de una persona residente permanente, mientras transcurra el plazo de diez años, desde la fecha en que contrajeron matrimonio o la legalización de la unión de hecho.', false, true, false, true, true, false, 1825, false, false, false, true, 0, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.727815', 'patricia', null);

-- Requisitos de tipo solicitud tramite (cónyuge de residente permanente-temporal)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1958', 'CRREQ154', 'CRTST352', 'Verificación de ejercer el derecho al sufragio beneficiario', false, 1, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia'),
('CRSRQ1957', 'CRREQ153', 'CRTST352', 'Verificación de cédula auspiciante', false, 0, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia'),
('CRSRQ1955', 'CRREQ155', 'CRTST352', 'Verificación residencia permanente auspiciante', false, 0, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia'),
('CRSRQ1954', 'CRREQ156', 'CRTST352', 'Verificación de matrimonio', false, 4, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia'),
('CRSRQ1959', 'CRREQ153', 'CRTST352', 'Verificación de cédula beneficiario', false, 1, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia');

-- Reglas de tipo solicitud trámite (cónyuge de residente permanente-temporal)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE838', 'CRTST352', 'CRVAL27', '[{"IN_CRPER_CODIGO":"crperCodigo"}]', null, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE1016', 'CRTST352', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:28:08.205871', 'patricia', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE1004', 'CRTST352', 'CRVAL17', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, false, '2016-08-02 09:11:17.052407', 'patricia', '2016-08-15 16:12:58.781744', 'patricia', ''),
('CRTSE928', 'CRTST352', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 12:06:10.747643', 'admin', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE927', 'CRTST352', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 12:06:10.747643', 'admin', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE888', 'CRTST352', 'CRVAL31', '[{"com.bmlaurus.rule.MarriedBeforeJune11Validator":""}]', null, false, '2016-07-05 17:51:10.876489', 'patricia', '2016-07-05 17:51:10.876489', 'patricia', null),
('CRTSE887', 'CRTST352', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, false, '2016-07-05 17:49:35.206981', 'patricia', '2016-07-05 17:51:10.876489', 'patricia', null),
('CRTSE886', 'CRTST352', 'CRVAL46', '[{"com.bmlaurus.rule.VoteCNE":""}]', null, false, '2016-07-05 17:49:35.206981', 'patricia', '2016-07-05 17:51:10.876489', 'patricia', null),
('CRTSE929', 'CRTST352', 'CRVAL43', '[{"com.bmlaurus.rule.MarriedAfterJune11Validator":""}]', null, true, '2016-07-07 12:06:10.747643', 'admin', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE839', 'CRTST352', 'CRVAL30', '[{"com.bmlaurus.rule.DinardapMarriedValidator":""}]', null, true, '2016-07-01 11:21:37.624369', 'patricia', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE926', 'CRTST352', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-07 12:06:10.747643', 'admin', '2016-08-18 09:44:01.741040', 'patricia', ''),
('CRTSE1128', 'CRTST352', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:44:01.741040', 'patricia', '2016-08-18 09:44:01.741040', 'patricia', '');

-- Opciones (cónyuge de residente permanente-temporal)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO897', 'CRTSO2', 'CRTST352', true, '2016-08-18 09:44:01.741040', 'patricia', '2016-08-18 09:44:01.741040', 'patricia');

-- Adjuntos (cónyuge de residente permanente-temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM36', 'Cgg_res_tramite', 'crtst_codigo=''CRTST352''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL82', 'ECM36', 'identificacion', 'Identificación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL83', 'ECM36', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL84', 'ECM36', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-1B Conviviente de residente permanente (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST353', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-1B Conviviente de residente permanente', 'Al cónyuge o conviviente, de una persona residente permanente, mientras transcurra el plazo de diez años, desde la fecha en que contrajeron matrimonio o la legalización de la unión de hecho.', false, true, false, true, true, false, 3650, false, false, false, true, 0, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.876235', 'patricia', null);

-- Requisitos de tipo solicitud trámite (conviviente de residente permanente-temporal)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1965', 'CRREQ153', 'CRTST353', 'Verificación cédula beneficiario', false, 1, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia'),
('CRSRQ1964', 'CRREQ154', 'CRTST353', 'Verificación cumplimiento del derecho a sufragio beneficiario', false, 1, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia'),
('CRSRQ1963', 'CRREQ153', 'CRTST353', 'Verificación de cédula auspiciante', false, 0, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia'),
('CRSRQ1961', 'CRREQ155', 'CRTST353', 'Verificación residente permanente auspiciante', false, 0, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia'),
('CRSRQ1960', 'CRREQ157', 'CRTST353', 'Verificación de la unión de hecho', false, 4, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia');

-- Reglas de tipo solicitud trámite (conviviente de residente permanente-temporal)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1018', 'CRTST353', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:29:41.221034', 'patricia', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE840', 'CRTST353', 'CRVAL27', '[{"IN_CRPER_CODIGO":"crperCodigo"}]', null, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE890', 'CRTST353', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-05 17:53:19.021781', 'patricia', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE841', 'CRTST353', 'CRVAL35', '[{"com.bmlaurus.rule.temporal.FreeUnionAfertJune11Validator":""}]', null, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE842', 'CRTST353', 'CRVAL32', '[{"com.bmlaurus.rule.FreeUnionValidator":""}]', null, true, '2016-07-01 14:00:28.884706', 'patricia', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE930', 'CRTST353', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 14:21:16.467207', 'admin', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE931', 'CRTST353', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 14:21:16.467207', 'admin', '2016-08-18 09:45:01.895192', 'patricia', ''),
('CRTSE1129', 'CRTST353', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:45:01.895192', 'patricia', '2016-08-18 09:45:01.895192', 'patricia', '');

-- Opciones (conviviente de residente permanente-temporal)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO925', 'CRTSO2', 'CRTST353', true, '2016-08-18 09:45:01.895192', 'patricia', '2016-08-18 09:45:01.895192', 'patricia');

-- Adjuntos (cónyuge de residente permanente-temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM37', 'Cgg_res_tramite', 'crtst_codigo=''CRTST353''', null, true, true, 'patricia', 'patricia');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL85', 'ECM37', 'identificacion', 'Identificación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL87', 'ECM37', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL86', 'ECM37', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-2 Hijo menor de residente temporal (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST354', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-2 Hijo menor de residente temporal', 'Las hijas e hijos menores de dieciocho años, cuyos padres sean residentes temporales', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 14:06:43.616539', 'patricia', '2016-08-18 09:45:48.582588', 'patricia', null);

-- Requisitos de tipo solicitud trámite (hijo menor de residente temporal)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1978', 'CRREQ162', 'CRTST354', 'Verificar residencia temporal auspiciante', false, 0, true, '2016-07-05 18:11:57.775224', 'patricia', '2016-08-18 09:45:48.599885', 'patricia'),
('CRSRQ1962', 'CRREQ153', 'CRTST354', 'Verificar cédula beneficiario', false, 1, true, '2016-07-05 18:00:10.298269', 'patricia', '2016-08-18 09:45:48.599885', 'patricia'),
('CRSRQ1956', 'CRREQ153', 'CRTST354', 'Verificar cédula Auspiciante', false, 0, true, '2016-07-05 18:00:10.298269', 'patricia', '2016-08-18 09:45:48.599885', 'patricia');

-- Reglas de tipo solicitud trámite (hijo menor de residente temporal)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1006', 'CRTST354', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-08-03 12:15:57.708591', '2000026548', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE1007', 'CRTST354', 'CRVAL36', '[{"com.bmlaurus.rule.temporal.MinorChild":""}]', null, true, '2016-08-03 12:30:50.285153', '2000026548', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE1021', 'CRTST354', 'CRVAL53', '[{"com.bmlaurus.rule.temporal.HijoDelRepresentante":""}]', null, true, '2016-08-08 09:31:42.273706', 'patricia', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE1089', 'CRTST354', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 12:08:25.665776', 'patricia', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE1020', 'CRTST354', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:31:42.273706', 'patricia', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE891', 'CRTST354', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-05 18:25:34.070231', 'patricia', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE932', 'CRTST354', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 14:29:54.891978', 'admin', '2016-08-18 09:45:48.599885', 'patricia', ''),
('CRTSE1130', 'CRTST354', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:45:48.599885', 'patricia', '2016-08-18 09:45:48.599885', 'patricia', '');

-- Opciones (hijo menor de residente temporal)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO913', 'CRTSO2', 'CRTST354', true, '2016-08-18 09:45:48.599885', 'patricia', '2016-08-18 09:45:48.599885', 'patricia'),
('CRTAO942', 'CRTSO15', 'CRTST354', true, '2016-08-18 09:45:48.599885', 'patricia', '2016-08-18 09:45:48.599885', 'patricia');

-- Adjuntos (cónyuge de residente permanente-temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) 
VALUES ('ECM13', 'Cgg_res_tramite', 'crtst_codigo=''CRTST354''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL5', 'ECM13', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL14', 'ECM13', 'identificacion', 'Pasaporte Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL88', 'ECM13', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-3 Hijo mayor de residente temporal (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST355', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-3 Hijo mayor de residente temporal', 'Las hijas e hijos mayores de edad que no estén emancipados y dependan de residentes temporales, cuando adolezcan de alguna discapacidad o enfermedades catastróficas o degenerativas, debidamente calificado por la autoridad competente, que les imposibilite mantenerse por sí mismos.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 14:22:51.540141', 'patricia', '2016-08-18 09:46:30.381296', 'patricia', null);


-- Requisitos de tipo solicitud trámite (hijo mayor de residente temporal)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1982', 'CRREQ153', 'CRTST355', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-05 19:07:57.619421', 'patricia', '2016-08-18 09:46:30.390041', 'patricia'),
('CRSRQ1981', 'CRREQ154', 'CRTST355', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-05 19:07:57.619421', 'patricia', '2016-08-18 09:46:30.390041', 'patricia'),
('CRSRQ1980', 'CRREQ153', 'CRTST355', 'Verificar cédula Auspiciante', false, 0, true, '2016-07-05 19:07:57.619421', 'patricia', '2016-08-18 09:46:30.390041', 'patricia'),
('CRSRQ1979', 'CRREQ162', 'CRTST355', 'Verificar residencia temporal Auspiciante', false, 0, true, '2016-07-05 19:07:57.619421', 'patricia', '2016-08-18 09:46:30.390041', 'patricia');

-- Reglas de tipo solicitud trámite (hijo mayor de residente temporal)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1005', 'CRTST355', 'CRVAL50', '[{"com.bmlaurus.rule.temporal.MinorChild":""}]', null, true, '2016-08-02 12:17:11.423287', 'patricia', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE1024', 'CRTST355', 'CRVAL53', '[{"com.bmlaurus.rule.temporal.HijoDelRepresentante":""}]', null, true, '2016-08-08 09:33:21.460005', 'patricia', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE1023', 'CRTST355', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:33:21.460005', 'patricia', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE1090', 'CRTST355', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:28:28.218358', '2000043634', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE845', 'CRTST355', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-01 14:22:51.540141', 'patricia', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE933', 'CRTST355', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-07 14:33:08.694232', 'admin', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE934', 'CRTST355', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 14:33:08.694232', 'admin', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE935', 'CRTST355', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 14:33:08.694232', 'admin', '2016-08-18 09:46:30.390041', 'patricia', ''),
('CRTSE1131', 'CRTST355', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:46:30.390041', 'patricia', '2016-08-18 09:46:30.390041', 'patricia', '');

-- Opciones (hijo mayor de residente temporal)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO926', 'CRTSO2', 'CRTST355', true, '2016-08-18 09:46:30.390041', 'patricia', '2016-08-18 09:46:30.390041', 'patricia');

-- Adjuntos (hijo mayor de residente temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) 
VALUES ('ECM14', 'Cgg_res_tramite', 'crtst_codigo=''CRTST355''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL16', 'ECM14', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL89', 'ECM14', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL15', 'ECM14', 'identificacion', 'Pasaporte Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL17', 'ECM14', 'documentoNoEmancipadoDependiente', 'Documento que determine como no emancipado, dependinte y enfermedad catastrófica', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-4A Servidores Públicos (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST356', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-4A Servidores Públicos', 'Las servidoras y los servidores públicos que se encuentren cumpliendo sus servicios por más de noventa días, mientras duren sus funciones.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 14:49:12.084463', 'patricia', '2016-08-18 09:47:18.836667', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Servidores Públicos)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1989', 'CRREQ161', 'CRTST356', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-07 15:00:19.853124', 'admin', '2016-08-18 09:47:18.862017', 'patricia'),
('CRSRQ1992', 'CRREQ163', 'CRTST356', 'Validación gestión empleo Beneficiario', false, 1, true, '2016-07-07 15:04:01.769122', 'admin', '2016-08-18 09:47:18.862017', 'patricia'),
('CRSRQ1991', 'CRREQ153', 'CRTST356', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-07 15:00:19.853124', 'admin', '2016-08-18 09:47:18.862017', 'patricia'),
('CRSRQ1990', 'CRREQ154', 'CRTST356', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-07 15:00:19.853124', 'admin', '2016-08-18 09:47:18.862017', 'patricia');

-- Reglas de tipo solicitud trámite (Servidores Públicos)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE939', 'CRTST356', 'CRVAL39', '[{"com.bmlaurus.rule.temporal.CurrentLaborSupply":""}]', null, true, '2016-07-07 14:53:56.584431', 'admin', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE940', 'CRTST356', 'CRVAL40', '[{"com.bmlaurus.rule.temporal.LaborSupplyFreeVacancies":""}]', null, true, '2016-07-07 14:53:56.584431', 'admin', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE938', 'CRTST356', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 14:53:56.584431', 'admin', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE937', 'CRTST356', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 14:53:56.584431', 'admin', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE936', 'CRTST356', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 14:53:56.584431', 'admin', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE848', 'CRTST356', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"crperNumDocIdentific"}]', null, true, '2016-07-01 14:49:12.084463', 'patricia', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE1026', 'CRTST356', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:39:15.142901', 'patricia', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE1112', 'CRTST356', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 15:55:44.391430', 'patricia', '2016-08-18 09:47:18.862017', 'patricia', ''),
('CRTSE1132', 'CRTST356', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:47:18.862017', 'patricia', '2016-08-18 09:47:18.862017', 'patricia', '');

-- Opciones (Servidores Públicos)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO917', 'CRTSO2', 'CRTST356', true, '2016-08-18 09:47:18.862017', 'patricia', '2016-08-18 09:47:18.862017', 'patricia'),
('CRTAO918', 'CRTSO7', 'CRTST356', true, '2016-08-18 09:47:18.862017', 'patricia', '2016-08-18 09:47:18.862017', 'patricia'),
('CRTAO919', 'CRTSO1', 'CRTST356', true, '2016-08-18 09:47:18.862017', 'patricia', '2016-08-18 09:47:18.862017', 'patricia');

-- Adjuntos (hijo mayor de residente temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) 
VALUES ('ECM15', 'Cgg_res_tramite', 'crtst_codigo=''CRTST356''', null, true, true, 'admin', 'admin');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL19', 'ECM15', 'copiaCertificadaTraslado', 'Copia certificada de traslado como servidor público', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL18', 'ECM15', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL90', 'ECM15', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-4B Servidores públicos contrato ocasional (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST357', 'CRTST2', 'CRTPT1', 'CRPRO81', null, 'CKESP5', 'Art. 41-4B Servidores públicos contrato ocasional', 'Las servidoras y los servidores públicos por contrato de servicios ocasionales o profesionales', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 16:44:18.832898', 'patricia', '2016-08-18 09:48:01.686866', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Servidores públicos contrato ocasional)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1996', 'CRREQ153', 'CRTST357', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-07 19:12:03.949614', 'admin', '2016-08-18 09:48:01.699246', 'patricia'),
('CRSRQ1995', 'CRREQ154', 'CRTST357', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-07 19:12:03.949614', 'admin', '2016-08-18 09:48:01.699246', 'patricia'),
('CRSRQ1994', 'CRREQ161', 'CRTST357', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-07 19:12:03.949614', 'admin', '2016-08-18 09:48:01.699246', 'patricia'),
('CRSRQ1993', 'CRREQ163', 'CRTST357', 'Varlidar gestión de empleo', false, 1, true, '2016-07-07 19:12:03.949614', 'admin', '2016-08-18 09:48:01.699246', 'patricia');

-- Reglas de tipo solicitud trámite (Servidores públicos contrato ocasional)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE849', 'CRTST357', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 16:44:18.832898', 'patricia', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE945', 'CRTST357', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 18:59:57.667186', 'admin', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE944', 'CRTST357', 'CRVAL39', '[{"com.bmlaurus.rule.temporal.CurrentLaborSupply":""}]', null, true, '2016-07-07 18:59:57.667186', 'admin', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE941', 'CRTST357', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 18:59:57.667186', 'admin', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE942', 'CRTST357', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 18:59:57.667186', 'admin', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE943', 'CRTST357', 'CRVAL40', '[{"com.bmlaurus.rule.temporal.LaborSupplyFreeVacancies":""}]', null, true, '2016-07-07 18:59:57.667186', 'admin', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE1028', 'CRTST357', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:49:40.293317', 'patricia', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE1113', 'CRTST357', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:11:25.943044', 'patricia', '2016-08-18 09:48:01.699246', 'patricia', ''),
('CRTSE1133', 'CRTST357', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:48:01.699246', 'patricia', '2016-08-18 09:48:01.699246', 'patricia', '');

-- Opciones (Servidores públicos contrato ocasional)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO921', 'CRTSO2', 'CRTST357', true, '2016-08-18 09:48:01.699246', 'patricia', '2016-08-18 09:48:01.699246', 'patricia');

-- Adjuntos (hijo mayor de residente temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM16', 'Cgg_res_tramite', 'crtst_codigo=''CRTST357''', null, true, true, 'admin', 'admin');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL22', 'ECM16', 'certificadoIESSAvisoEntrada', 'Certificado del IESS de Aviso de entrada', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL20', 'ECM16', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL21', 'ECM16', 'copiaCertificadaTraslado', 'Copia certificada de traslado como servidor público', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL91', 'ECM16', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-5A Representantes Legales (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST358', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-5A Representantes Legales', 'Los representantes legales de empresas legalmente domiciliadas en la provincia de Galápagos y sus empleados.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 16:52:16.963257', 'patricia', '2016-08-18 09:49:21.417304', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Representantes Legales)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1999', 'CRREQ153', 'CRTST358', 'Verificar cédula Benefciario', false, 1, true, '2016-07-07 19:24:31.789080', 'admin', '2016-08-18 09:49:21.430876', 'patricia'),
('CRSRQ1998', 'CRREQ154', 'CRTST358', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-07 19:24:31.789080', 'admin', '2016-08-18 09:49:21.430876', 'patricia'),
('CRSRQ1997', 'CRREQ161', 'CRTST358', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-07 19:24:31.789080', 'admin', '2016-08-18 09:49:21.430876', 'patricia');

-- Reglas de tipo solicitud trámite (Representantes Legales)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1030', 'CRTST358', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:51:08.848400', 'patricia', '2016-08-18 09:49:21.430876', 'patricia', ''),
('CRTSE948', 'CRTST358', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 19:18:00.993133', 'admin', '2016-08-18 09:49:21.430876', 'patricia', ''),
('CRTSE947', 'CRTST358', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 19:18:00.993133', 'admin', '2016-08-18 09:49:21.430876', 'patricia', ''),
('CRTSE946', 'CRTST358', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 19:18:00.993133', 'admin', '2016-08-18 09:49:21.430876', 'patricia', ''),
('CRTSE850', 'CRTST358', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 16:52:16.963257', 'patricia', '2016-08-18 09:49:21.430876', 'patricia', ''),
('CRTSE1114', 'CRTST358', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:12:19.233359', 'patricia', '2016-08-18 09:49:21.430876', 'patricia', ''),
('CRTSE1134', 'CRTST358', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:49:21.430876', 'patricia', '2016-08-18 09:49:21.430876', 'patricia', '');

-- Opciones (Representantes Legales)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO928', 'CRTSO2', 'CRTST358', true, '2016-08-18 09:49:21.430876', 'patricia', '2016-08-18 09:49:21.430876', 'patricia');

-- Adjuntos (hijo mayor de residente temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM17', 'Cgg_res_tramite', 'crtst_codigo=''CRTST358''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL24', 'ECM17', 'copiaNombramientoRepresentanteLegal', 'Copia del nombramiento como representante legal de la empresa', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL23', 'ECM17', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL92', 'ECM17', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);


-- Art. 41-5B Empleados privadas en relación dependencia (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST359', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-5B Empleados privadas en relación dependencia', 'Los representantes legales de empresas legalmente domiciliadas en la provincia de Galápagos ysus empleados', false, true, false, true, true, false, 1095, false, false, false, true, 0, true, '2016-07-01 17:04:01.516215', 'patricia', '2016-08-18 09:49:58.659175', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Empleados privadas en relación dependencia)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2003', 'CRREQ153', 'CRTST359', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-07 19:35:10.173577', 'admin', '2016-08-18 09:49:58.673484', 'patricia'),
('CRSRQ2002', 'CRREQ154', 'CRTST359', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-07 19:35:10.173577', 'admin', '2016-08-18 09:49:58.673484', 'patricia'),
('CRSRQ2001', 'CRREQ161', 'CRTST359', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-07 19:35:10.173577', 'admin', '2016-08-18 09:49:58.673484', 'patricia'),
('CRSRQ2000', 'CRREQ163', 'CRTST359', 'Validar gestión de empleo', false, 1, true, '2016-07-07 19:35:10.173577', 'admin', '2016-08-18 09:49:58.673484', 'patricia');

-- Reglas de tipo solicitud trámite (Empleados privadas en relación dependencia)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE953', 'CRTST359', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 19:28:40.563866', 'admin', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE951', 'CRTST359', 'CRVAL40', '[{"com.bmlaurus.rule.temporal.LaborSupplyFreeVacancies":""}]', null, true, '2016-07-07 19:28:40.563866', 'admin', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE952', 'CRTST359', 'CRVAL39', '[{"com.bmlaurus.rule.temporal.CurrentLaborSupply":""}]', null, true, '2016-07-07 19:28:40.563866', 'admin', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE1032', 'CRTST359', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:52:29.581258', 'patricia', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE851', 'CRTST359', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 17:04:01.516215', 'patricia', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE949', 'CRTST359', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 19:28:40.563866', 'admin', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE950', 'CRTST359', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 19:28:40.563866', 'admin', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE1115', 'CRTST359', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:13:17.215738', 'patricia', '2016-08-18 09:49:58.673484', 'patricia', ''),
('CRTSE1135', 'CRTST359', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:49:58.673484', 'patricia', '2016-08-18 09:49:58.673484', 'patricia', '');

-- Opciones (Empleados privadas en relación dependencia)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO929', 'CRTSO2', 'CRTST359', true, '2016-08-18 09:49:58.673484', 'patricia', '2016-08-18 09:49:58.673484', 'patricia');

-- Adjuntos (hijo mayor de residente temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM18', 'Cgg_res_tramite', 'crtst_codigo=''CRTST359''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL27', 'ECM18', 'certificadoIESSAvisoEntrada', 'Certificado del IESS de Aviso de entrada', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL26', 'ECM18', 'copiaExtractoContrato', 'Copia del extracto del contrato emitida por el Ministerio de Relaciones Laborales', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL25', 'ECM18', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL93', 'ECM18', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-6A Personal de Fuerzas Armadas y Policía Nacional (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST360', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-6A Personal de Fuerzas Armadas y Policía Nacional', 'El personal de las Fuerzas Armadas y Policía Nacional que hayan sido designados para el cumplimiento de funciones en la provincia de Galápagos.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 17:10:19.719302', 'patricia', '2016-08-18 09:50:40.110057', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Personal de Fuerzas Armadas y Policía Nacional)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2005', 'CRREQ153', 'CRTST360', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-07 19:46:05.850123', 'admin', '2016-08-18 09:50:40.120071', 'patricia'),
('CRSRQ2004', 'CRREQ161', 'CRTST360', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-07 19:46:05.850123', 'admin', '2016-08-18 09:50:40.120071', 'patricia');

-- Reglas de tipo solicitud trámite (Personal de Fuerzas Armadas y Policía Nacional)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1034', 'CRTST360', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 09:53:59.974420', 'patricia', '2016-08-18 09:50:40.120071', 'patricia', ''),
('CRTSE852', 'CRTST360', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 17:10:19.719302', 'patricia', '2016-08-18 09:50:40.120071', 'patricia', ''),
('CRTSE954', 'CRTST360', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 19:42:12.799462', 'admin', '2016-08-18 09:50:40.120071', 'patricia', ''),
('CRTSE955', 'CRTST360', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 19:42:12.799462', 'admin', '2016-08-18 09:50:40.120071', 'patricia', ''),
('CRTSE1116', 'CRTST360', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:14:02.572539', 'patricia', '2016-08-18 09:50:40.120071', 'patricia', ''),
('CRTSE1136', 'CRTST360', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:50:40.120071', 'patricia', '2016-08-18 09:50:40.120071', 'patricia', '');


-- Opciones (Personal de Fuerzas Armadas y Policía Nacional)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO924', 'CRTSO2', 'CRTST360', true, '2016-08-18 09:50:40.120071', 'patricia', '2016-08-18 09:50:40.120071', 'patricia');

-- Adjuntos (hijo mayor de residente temporal)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM19', 'Cgg_res_tramite', 'crtst_codigo=''CRTST360''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL94', 'ECM19', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL29', 'ECM19', 'copiaDocumentoAcrediteTraslado', 'Copia del documento que acredite el traslado a Galápagos', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL28', 'ECM19', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL95', 'ECM19', 'cert_votacion', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);


-- Art. 41-6B Cónyuge/Conviviente de Fuerza Armada/Policía Nacional (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST361', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-6B Cónyuge/Conviviente de Fuerza Armada/Policía Nacional', 'Mientras se encuentren en el cumplimiento de sus funciones tendrán también la calidad de residentes temporales sus cónyuges o convivientes.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 17:22:33.521931', 'patricia', '2016-08-18 09:51:19.055639', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Cónyuge/Conviviente de Fuerza Armada/Policía Nacional)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2051', 'CRREQ153', 'CRTST361', 'Verificar que conste en el registro civil el beneficiario', false, 1, true, '2016-08-15 17:20:12.772205', 'patricia', '2016-08-18 09:51:19.065006', 'patricia'),
('CRSRQ2050', 'CRREQ154', 'CRTST361', 'Verificar haber ejercido el derecho al sufragio el beneficiario', false, 1, true, '2016-08-15 17:20:12.772205', 'patricia', '2016-08-18 09:51:19.065006', 'patricia'),
('CRSRQ2049', 'CRREQ156', 'CRTST361', 'Verificar el registro del matrimonio en el registro civil', false, 2, true, '2016-08-15 17:20:12.772205', 'patricia', '2016-08-18 09:51:19.065006', 'patricia'),
('CRSRQ2012', 'CRREQ164', 'CRTST361', 'Verificar residencia vigente del cónyuge/Conviviente', false, 2, true, '2016-08-15 17:20:12.772205', 'patricia', '2016-08-18 09:51:19.065006', 'patricia');

-- Reglas de tipo solicitud trámite (Cónyuge/Conviviente de Fuerza Armada/Policía Nacional)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE853', 'CRTST361', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 17:22:33.521931', 'patricia', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE959', 'CRTST361', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 19:50:08.884380', 'admin', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE958', 'CRTST361', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 19:50:08.884380', 'admin', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE957', 'CRTST361', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 19:50:08.884380', 'admin', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE956', 'CRTST361', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-07 19:50:08.884380', 'admin', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE1036', 'CRTST361', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:05:34.575595', 'patricia', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE1091', 'CRTST361', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:29:22.186194', '2000043634', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE854', 'CRTST361', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-01 17:22:33.521931', 'patricia', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE1087', 'CRTST361', 'CRVAL54', '[{"com.bmlaurus.rule.DinardapMarriedValidatorRep":""}]', null, true, '2016-08-08 13:04:45.255783', 'patricia', '2016-08-18 09:51:19.065006', 'patricia', ''),
('CRTSE1137', 'CRTST361', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:51:19.065006', 'patricia', '2016-08-18 09:51:19.065006', 'patricia', '');

-- Opciones (Cónyuge/Conviviente de Fuerza Armada/Policía Nacional)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO916', 'CRTSO2', 'CRTST361', true, '2016-08-18 09:51:19.065006', 'patricia', '2016-08-18 09:51:19.065006', 'patricia');

-- Adjuntos (Cónyuge/Conviviente de Fuerza Armada/Policía Nacional)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM20', 'Cgg_res_tramite', 'crtst_codigo=''CRTST361''', null, true, true, 'admin', 'admin');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL97', 'ECM20', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL31', 'ECM20', 'identificacion', 'Identificación Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL30', 'ECM20', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL96', 'ECM20', 'cert_votación', 'Papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-6C Hijo Menor del Personal Fuerza Armada/Policía Nacional (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST362', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-6C Hijo Menor del Personal Fuerza Armada/Policía Nacional', 'Mientras se encuentren en el cumplimiento de sus funciones tendrán también la calidad de residentes temporales sus hijas e hijos menores de edad', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 17:26:01.516791', 'patricia', '2016-08-18 09:52:07.760373', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Hijo Menor del Personal Fuerza Armada/Policía Nacional)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2008', 'CRREQ153', 'CRTST362', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-07 20:02:29.517079', 'admin', '2016-08-18 09:52:07.773993', 'patricia'),
('CRSRQ2007', 'CRREQ153', 'CRTST362', 'Verificar cédula Auspiciante', false, 3, true, '2016-07-07 20:02:29.517079', 'admin', '2016-08-18 09:52:07.773993', 'patricia'),
('CRSRQ2006', 'CRREQ162', 'CRTST362', 'Verificar residencia temporal Auspiciante', false, 3, true, '2016-07-07 20:02:29.517079', 'admin', '2016-08-18 09:52:07.773993', 'patricia');

-- Reglas de tipo solicitud trámite (Hijo Menor del Personal Fuerza Armada/Policía Nacional)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE961', 'CRTST362', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 19:56:17.461663', 'admin', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE856', 'CRTST362', 'CRVAL36', '[{"com.bmlaurus.rule.temporal.MinorChild":""}]', null, true, '2016-07-01 17:26:01.516791', 'patricia', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE855', 'CRTST362', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-01 17:26:01.516791', 'patricia', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE960', 'CRTST362', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-07 19:56:17.461663', 'admin', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE1038', 'CRTST362', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:33:17.564282', 'patricia', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE1039', 'CRTST362', 'CRVAL53', '[{"com.bmlaurus.rule.temporal.HijoDelRepresentante":""}]', null, true, '2016-08-08 10:33:17.564282', 'patricia', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE1092', 'CRTST362', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:30:00.817829', '2000043634', '2016-08-18 09:52:07.773993', 'patricia', ''),
('CRTSE1138', 'CRTST362', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:52:07.773993', 'patricia', '2016-08-18 09:52:07.773993', 'patricia', '');

-- Opciones (Hijo Menor del Personal Fuerza Armada/Policía Nacional)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO927', 'CRTSO2', 'CRTST362', true, '2016-08-18 09:52:07.773993', 'patricia', '2016-08-18 09:52:07.773993', 'patricia');

-- Adjuntos (Hijo Menor del Personal Fuerza Armada/Policía Nacional)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM21', 'Cgg_res_tramite', 'crtst_codigo=''CRTST362''', null, true, true, 'admin', 'admin');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL33', 'ECM21', 'identificacion', 'Pasaporte Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL98', 'ECM21', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL32', 'ECM21', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-6D Dependientes con discapacidad de Personal Fuerzas Armada/Policía Nacional (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST363', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-6D Dependientes con discapacidad de Personal Fuerzas Armada/Policía Nacional', 'Mientras se encuentren en el cumplimiento de sus funciones tendrán también la calidad de residentes temporales sus cónyuges o convivientes y sus hijas e hijos menores de edad o personas con discapacidad debidamente calificados por la autoridad competente.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 17:36:09.307688', 'patricia', '2016-08-18 09:52:45.823824', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Dependientes con discapacidad de Personal Fuerzas Armada/Policía Nacional)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2016', 'CRREQ153', 'CRTST363', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 11:19:54.434640', 'patricia', '2016-08-18 09:52:45.837350', 'patricia'),
('CRSRQ2015', 'CRREQ154', 'CRTST363', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 11:19:54.434640', 'patricia', '2016-08-18 09:52:45.837350', 'patricia'),
('CRSRQ2014', 'CRREQ153', 'CRTST363', 'Verificar cédula Auspiciante', false, 0, true, '2016-07-08 11:19:54.434640', 'patricia', '2016-08-18 09:52:45.837350', 'patricia'),
('CRSRQ2013', 'CRREQ162', 'CRTST363', 'Verificar residencia temporal Auspiciante', false, 0, true, '2016-07-08 11:19:54.434640', 'patricia', '2016-08-18 09:52:45.837350', 'patricia');

-- Reglas de tipo solicitud trámite (Dependientes con discapacidad de Personal Fuerzas Armada/Policía Nacional)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE857', 'CRTST363', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 17:36:09.307688', 'patricia', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE1041', 'CRTST363', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:34:50.051489', 'patricia', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE858', 'CRTST363', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-01 17:36:09.307688', 'patricia', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE962', 'CRTST363', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-08 10:40:35.274324', 'is-admin', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE963', 'CRTST363', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 10:40:35.274324', 'is-admin', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE964', 'CRTST363', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 10:40:35.274324', 'is-admin', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE965', 'CRTST363', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 10:40:35.274324', 'is-admin', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE1093', 'CRTST363', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:30:41.915481', '2000043634', '2016-08-18 09:52:45.837350', 'patricia', ''),
('CRTSE1139', 'CRTST363', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:52:45.837350', 'patricia', '2016-08-18 09:52:45.837350', 'patricia', '');

-- Opciones (Dependientes con discapacidad de Personal Fuerzas Armada/Policía Nacional)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO930', 'CRTSO2', 'CRTST363', true, '2016-08-18 09:52:45.837350', 'patricia', '2016-08-18 09:52:45.837350', 'patricia');

-- Adjuntos (Dependientes con discapacidad de Personal Fuerzas Armada/Policía Nacional)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM22', 'Cgg_res_tramite', 'crtst_codigo=''CRTST363''', null, true, true, 'is-admin', 'is-admin');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL36', 'ECM22', 'identificacion', 'Pasaporte Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL99', 'ECM22', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL37', 'ECM22', 'documentoCertifiqueDependencia', 'Documento que certifique que el beneficario depende del Residente Temporal', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL35', 'ECM22', 'documentoCalificaDiscapacidad', 'Documento  que lo califique con discapacidad', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL34', 'ECM22', 'identificacion', 'Pasaporte Beneficario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-7 Investigadores (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST364', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-7 Investigadores', 'Las personas que, con el auspicio de instituciones del Estado o de centros de investigación previamente calificados por el Secretario Técnico, realicen investigaciones', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-01 17:56:21.198106', 'patricia', '2016-08-18 09:53:23.778918', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Investigadores)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2019', 'CRREQ153', 'CRTST364', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 11:36:13.582670', 'patricia', '2016-08-18 09:53:23.793128', 'patricia'),
('CRSRQ2018', 'CRREQ154', 'CRTST364', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 11:36:13.582670', 'patricia', '2016-08-18 09:53:23.793128', 'patricia'),
('CRSRQ2017', 'CRREQ161', 'CRTST364', 'Realizar actualizacion documentos Auspiciante', false, 0, true, '2016-07-08 11:36:13.582670', 'patricia', '2016-08-18 09:53:23.793128', 'patricia');

-- Reglas de tipo solicitud trámite (Investigadores)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1043', 'CRTST364', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:36:34.769344', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', ''),
('CRTSE966', 'CRTST364', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 11:24:20.641819', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', ''),
('CRTSE967', 'CRTST364', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 11:24:20.641819', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', ''),
('CRTSE968', 'CRTST364', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 11:24:20.641819', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', ''),
('CRTSE859', 'CRTST364', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-01 17:56:21.198106', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', ''),
('CRTSE1117', 'CRTST364', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:14:52.665601', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', ''),
('CRTSE1140', 'CRTST364', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:53:23.793128', 'patricia', '2016-08-18 09:53:23.793128', 'patricia', '');


-- Opciones (Investigadores)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO932', 'CRTSO2', 'CRTST364', true, '2016-08-18 09:53:23.793128', 'patricia', '2016-08-18 09:53:23.793128', 'patricia');

-- Adjuntos (Investigadores)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM23', 'Cgg_res_tramite', 'crtst_codigo=''CRTST364''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL40', 'ECM23', 'atorizacionSecretarioTecnico', 'Copia de la autorización del Secretario Técnico para la ejecución de investigación en Galápagos', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL100', 'ECM23', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL39', 'ECM23', 'documentoInvestigacion', 'Documento que acredite que es parte de la investigación que se realiza en Galápagos', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL38', 'ECM23', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-8 Voluntarios/Becarios (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST365', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-8 Voluntarios/Becarios', 'Los voluntarios y becarios que ingresen a la provincia de Galápagos para prestar sus servicios dentro de programas de conservación, investigación, capacitación, educación o asistencia social.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:01:51.230840', 'patricia', '2016-08-17 17:39:16.132059', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Voluntarios/Becarios)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2022', 'CRREQ153', 'CRTST365', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 11:48:46.906521', 'patricia', '2016-08-17 17:39:16.155445', 'patricia'),
('CRSRQ2021', 'CRREQ154', 'CRTST365', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 11:48:46.906521', 'patricia', '2016-08-17 17:39:16.155445', 'patricia'),
('CRSRQ2020', 'CRREQ161', 'CRTST365', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-08 11:48:46.906521', 'patricia', '2016-08-17 17:39:16.155445', 'patricia');

-- Reglas de tipo solicitud trámite (Voluntarios/Becarios)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE970', 'CRTST365', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 11:40:31.493414', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', ''),
('CRTSE971', 'CRTST365', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 11:40:31.493414', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', ''),
('CRTSE1045', 'CRTST365', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:38:14.337162', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', ''),
('CRTSE860', 'CRTST365', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:01:51.230840', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', ''),
('CRTSE969', 'CRTST365', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 11:40:31.493414', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', ''),
('CRTSE1118', 'CRTST365', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:15:36.892587', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', ''),
('CRTSE1127', 'CRTST365', 'CRVAL17', '[{"IN_CRTST_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-17 17:03:23.972518', 'patricia', '2016-08-17 17:39:16.155445', 'patricia', '');

-- Opciones (Voluntarios/Becarios)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO933', 'CRTSO2', 'CRTST365', true, '2016-08-17 17:39:16.155445', 'patricia', '2016-08-17 17:39:16.155445', 'patricia');

-- Adjuntos (Voluntarios/Becarios)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM24', 'Cgg_res_tramite', 'crtst_codigo=''CRTST365''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL44', 'ECM24', 'copiaConvenio', 'Copia del convenio con la entidad receptora en la provincia de Galápagos', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null);
('ECMFL101', 'ECM24', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL42', 'ECM24', 'documentoAcreditacionBecaVoluntariadoBenef', 'Documento que acredite ser beneficiario de la beca o el voluntariado', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL41', 'ECM24', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL43', 'ECM24', 'documentoAcreditacionPrograma', 'Copia del documento que acredite el programa de voluntariado o beca', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. Art. 41-9 Científicos (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST366', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-9 Científicos', 'Los científicos que ingresen a la provincia de Galápagos para desarrollar programas de investigación ejecutados por instituciones públicas o entidades privadas sin fines de lucro debidamente registradas.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:03:59.285776', 'patricia', '2016-08-18 09:54:16.080897', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Científicos)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2025', 'CRREQ153', 'CRTST366', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 12:09:18.121011', 'admin', '2016-08-18 09:54:16.088395', 'patricia'),
('CRSRQ2024', 'CRREQ154', 'CRTST366', 'Verifiar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 12:09:18.121011', 'admin', '2016-08-18 09:54:16.088395', 'patricia'),
('CRSRQ2023', 'CRREQ161', 'CRTST366', 'Realizar actualización auspiciante', false, 0, true, '2016-07-08 12:09:18.121011', 'admin', '2016-08-18 09:54:16.088395', 'patricia');

-- Reglas de tipo solicitud trámite (Científicos)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE861', 'CRTST366', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:03:59.285776', 'patricia', '2016-08-18 09:54:16.088395', 'patricia', ''),
('CRTSE973', 'CRTST366', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 12:03:01.077417', 'admin', '2016-08-18 09:54:16.088395', 'patricia', ''),
('CRTSE972', 'CRTST366', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 12:03:01.077417', 'admin', '2016-08-18 09:54:16.088395', 'patricia', ''),
('CRTSE1047', 'CRTST366', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:39:28.790718', 'patricia', '2016-08-18 09:54:16.088395', 'patricia', ''),
('CRTSE974', 'CRTST366', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 12:03:01.077417', 'admin', '2016-08-18 09:54:16.088395', 'patricia', ''),
('CRTSE1119', 'CRTST366', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:16:23.670401', 'patricia', '2016-08-18 09:54:16.088395', 'patricia', ''),
('CRTSE1141', 'CRTST366', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:54:16.088395', 'patricia', '2016-08-18 09:54:16.088395', 'patricia', '');

-- Opciones (Científicos)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO922', 'CRTSO2', 'CRTST366', true, '2016-08-18 09:54:16.088395', 'patricia', '2016-08-18 09:54:16.088395', 'patricia');

-- Adjuntos (Voluntarios/Becarios)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM26', 'Cgg_res_tramite', 'crtst_codigo=''CRTST366''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL49', 'ECM26', 'atorizacionSecretarioTecnico', 'Copia de la autorización del Secretario Técnico para la ejecución de investigación en Galápagos', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL48', 'ECM26', 'documentoInvestigacion', 'Documento que acredite que es parte de la investigación que se realiza en Galápagos', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL102', 'ECM26', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL47', 'ECM26', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-10A Adultos Mayores padre de RP (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST367', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-10A Adultos Mayores padre de RP', 'Los adultos mayores con discapacidad o enfermedades catastróficas o degenerativas, padre o madre de un residente permanente o temporal y que sean sus Dependientes.', false, true, false, true, true, false, 1825, false, false, false, true, 0, true, '2016-07-04 09:09:07.389334', 'patricia', '2016-08-18 09:54:53.691730', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Adultos Mayores padre de RP)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2028', 'CRREQ153', 'CRTST367', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 12:17:34.350373', 'admin', '2016-08-18 09:54:53.703101', 'patricia'),
('CRSRQ2027', 'CRREQ153', 'CRTST367', 'Verificar cédula Auspiciante', false, 0, true, '2016-07-08 12:17:34.350373', 'admin', '2016-08-18 09:54:53.703101', 'patricia'),
('CRSRQ2026', 'CRREQ155', 'CRTST367', 'Verificar residencia permanente Auspiciante', false, 0, true, '2016-07-08 12:17:34.350373', 'admin', '2016-08-18 09:54:53.703101', 'patricia');

-- Reglas de tipo solicitud trámite (Adultos Mayores padre de RP)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE864', 'CRTST367', 'CRVAL2', '[{"IN_CRPER_CODIGO":"crperCodigo"}]', null, true, '2016-07-04 09:17:50.994651', 'patricia', '2016-08-18 09:54:53.703101', 'patricia', ''),
('CRTSE975', 'CRTST367', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-08 12:14:24.118809', 'admin', '2016-08-18 09:54:53.703101', 'patricia', ''),
('CRTSE976', 'CRTST367', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 12:14:24.118809', 'admin', '2016-08-18 09:54:53.703101', 'patricia', ''),
('CRTSE1049', 'CRTST367', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 10:42:30.386900', 'patricia', '2016-08-18 09:54:53.703101', 'patricia', ''),
('CRTSE1050', 'CRTST367', 'CRVAL55', '[{"com.bmlaurus.rule.temporal.PadreDelAuspiciante":""}]', null, true, '2016-08-08 10:55:03.828475', 'patricia', '2016-08-18 09:54:53.703101', 'patricia', ''),
('CRTSE1142', 'CRTST367', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:54:53.703101', 'patricia', '2016-08-18 09:54:53.703101', 'patricia', '');

-- Opciones (Adultos Mayores padre de RP)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO923', 'CRTSO2', 'CRTST367', true, '2016-08-18 09:54:53.703101', 'patricia', '2016-08-18 09:54:53.703101', 'patricia');

-- Adjuntos (Adultos Mayores padre de RP)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM27', 'Cgg_res_tramite', 'crtst_codigo=''CRTST367''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL103', 'ECM27', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL50', 'ECM27', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-10B Adultos Mayores padre de RT (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST368', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-10B Adultos Mayores padre de RT', 'Los adultos mayores con discapacidad o enfermedades catastróficas o degenerativas, padre o madre de un residente temporal y que sean sus Dependientes.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:17:17.020883', 'patricia', '2016-08-18 09:55:38.018726', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Adultos Mayores padre de RT)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2031', 'CRREQ153', 'CRTST368', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 12:54:17.687476', 'admin', '2016-08-18 09:55:38.026165', 'patricia'),
('CRSRQ2030', 'CRREQ153', 'CRTST368', 'Verificar cédula Auspiciante', false, 0, true, '2016-07-08 12:54:17.687476', 'admin', '2016-08-18 09:55:38.026165', 'patricia'),
('CRSRQ2029', 'CRREQ162', 'CRTST368', 'Verificar residentica temporal Auspiciante', false, 3, true, '2016-07-08 12:54:17.687476', 'admin', '2016-08-18 09:55:38.026165', 'patricia');

-- Reglas de tipo solicitud trámite (Adultos Mayores padre de RT)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE863', 'CRTST368', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-04 09:17:17.020883', 'patricia', '2016-08-18 09:55:38.026165', 'patricia', ''),
('CRTSE977', 'CRTST368', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-08 12:52:06.916427', 'admin', '2016-08-18 09:55:38.026165', 'patricia', ''),
('CRTSE1094', 'CRTST368', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:31:21.143968', '2000043634', '2016-08-18 09:55:38.026165', 'patricia', ''),
('CRTSE1053', 'CRTST368', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:03:13.560681', 'patricia', '2016-08-18 09:55:38.026165', 'patricia', ''),
('CRTSE1051', 'CRTST368', 'CRVAL56', '[{"com.bmlaurus.rule.temporal.PadreDelRepresentante":""}]', null, true, '2016-08-08 11:03:13.560681', 'patricia', '2016-08-18 09:55:38.026165', 'patricia', ''),
('CRTSE978', 'CRTST368', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 12:52:06.916427', 'admin', '2016-08-18 09:55:38.026165', 'patricia', ''),
('CRTSE1143', 'CRTST368', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:55:38.026165', 'patricia', '2016-08-18 09:55:38.026165', 'patricia', '');

-- Opciones (Adultos Mayores padre de RT)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO931', 'CRTSO2', 'CRTST368', true, '2016-08-18 09:55:38.026165', 'patricia', '2016-08-18 09:55:38.026165', 'patricia');

-- Adjuntos (Adultos Mayores padre de RT)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM28', 'Cgg_res_tramite', 'crtst_codigo=''CRTST368''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL51', 'ECM28', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL104', 'ECM28', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-11 Servicios rurales (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST369', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-11 Servicios rurales', 'Los profesionales que deben prestar un servicio obligatorio rural, que cuenten con el auspicio del ministerio que ejerce la rectoría de la política pública respectiva.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:21:09.935363', 'patricia', '2016-08-18 09:56:17.382235', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Servicios rurales)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2034', 'CRREQ153', 'CRTST369', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 13:01:06.538622', 'admin', '2016-08-18 09:56:17.391229', 'patricia'),
('CRSRQ2033', 'CRREQ154', 'CRTST369', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 13:01:06.538622', 'admin', '2016-08-18 09:56:17.391229', 'patricia'),
('CRSRQ2032', 'CRREQ161', 'CRTST369', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-08 13:01:06.538622', 'admin', '2016-08-18 09:56:17.391229', 'patricia');

-- Reglas de tipo solicitud trámite (Servicios rurales)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE979', 'CRTST369', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 12:56:36.995253', 'admin', '2016-08-18 09:56:17.391229', 'patricia', ''),
('CRTSE980', 'CRTST369', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 12:56:36.995253', 'admin', '2016-08-18 09:56:17.391229', 'patricia', ''),
('CRTSE981', 'CRTST369', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 12:56:36.995253', 'admin', '2016-08-18 09:56:17.391229', 'patricia', ''),
('CRTSE1055', 'CRTST369', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:06:31.279713', 'patricia', '2016-08-18 09:56:17.391229', 'patricia', ''),
('CRTSE865', 'CRTST369', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:21:09.935363', 'patricia', '2016-08-18 09:56:17.391229', 'patricia', ''),
('CRTSE1120', 'CRTST369', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:17:17.956260', 'patricia', '2016-08-18 09:56:17.391229', 'patricia', ''),
('CRTSE1144', 'CRTST369', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:56:17.391229', 'patricia', '2016-08-18 09:56:17.391229', 'patricia', '');

-- Opciones (Servicios rurales)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO935', 'CRTSO2', 'CRTST369', true, '2016-08-18 09:56:17.391229', 'patricia', '2016-08-18 09:56:17.391229', 'patricia');

-- Adjuntos (Servicios rurales)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM29', 'Cgg_res_tramite', 'crtst_codigo=''CRTST369''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL105', 'ECM29', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL52', 'ECM29', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL54', 'ECM29', 'certificadoIESSAvisoEntrada', 'Certificado del IESS de Aviso de entrada', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL53', 'ECM29', 'documentoAcrediteServicio', 'Copia del documento que acredite su traslado a Galápagos para ejecutar servicio rural', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-12A Ministros de culto u ordenes Religiosas (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST370', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-12A Ministros de culto u ordenes Religiosas', 'Los ministros de cultos religiosos o de órdenes religiosas reconocidas por el Estado ecuatoriano que sean designados para el cumplimiento de sus funciones en la provincia de Galápagos, mientras dure la misión', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:26:16.509242', 'patricia', '2016-08-18 09:57:45.794533', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2037', 'CRREQ153', 'CRTST370', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 13:06:43.063736', 'admin', '2016-08-18 09:57:45.807045', 'patricia'),
('CRSRQ2036', 'CRREQ154', 'CRTST370', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 13:06:43.063736', 'admin', '2016-08-18 09:57:45.807045', 'patricia'),
('CRSRQ2035', 'CRREQ161', 'CRTST370', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-08 13:06:43.063736', 'admin', '2016-08-18 09:57:45.807045', 'patricia');

-- Reglas de tipo solicitud trámite (Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE983', 'CRTST370', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 13:03:08.987741', 'admin', '2016-08-18 09:57:45.807045', 'patricia', ''),
('CRTSE982', 'CRTST370', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 13:03:08.987741', 'admin', '2016-08-18 09:57:45.807045', 'patricia', ''),
('CRTSE984', 'CRTST370', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 13:03:08.987741', 'admin', '2016-08-18 09:57:45.807045', 'patricia', ''),
('CRTSE1057', 'CRTST370', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:07:51.842294', 'patricia', '2016-08-18 09:57:45.807045', 'patricia', ''),
('CRTSE866', 'CRTST370', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:26:16.509242', 'patricia', '2016-08-18 09:57:45.807045', 'patricia', ''),
('CRTSE1121', 'CRTST370', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:18:08.276793', 'patricia', '2016-08-18 09:57:45.807045', 'patricia', ''),
('CRTSE1145', 'CRTST370', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:57:45.807045', 'patricia', '2016-08-18 09:57:45.807045', 'patricia', '');

-- Opciones (Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO936', 'CRTSO2', 'CRTST370', true, '2016-08-18 09:57:45.807045', 'patricia', '2016-08-18 09:57:45.807045', 'patricia');

-- Adjuntos (Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM30', 'Cgg_res_tramite', 'crtst_codigo=''CRTST370''', null, true, true, 'admin', 'admin');
--file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL57', 'ECM30', 'documentoAcrediteOrdenReligiosa', 'Documento que acredite que el Ministerio u Orden Religiosa es reconocidas por el Estado ecuatoriano', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL56', 'ECM30', 'documentoTraslado', 'Copia del documento de su traslado a Galápagos', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL55', 'ECM30', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL106', 'ECM30', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 41-12B Cónyuge de Ministros de culto Religioso (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST371', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-12B Cónyuge de Ministros de culto Religioso', 'Cónyuge e hijos menores de edad, de ministros de cultos religiosos o de órdenes religiosas reconocidas, tendrán la condición migratoria de temporales.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:29:28.819722', 'patricia', '2016-08-18 09:58:29.075254', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Cónyuge de Ministros de culto Religioso)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2040', 'CRREQ153', 'CRTST371', 'Verificar cédula Auspiciante', false, 0, true, '2016-07-08 13:14:37.475431', 'admin', '2016-08-18 09:58:29.087131', 'patricia'),
('CRSRQ2039', 'CRREQ156', 'CRTST371', 'Verificar matrimonio en registro civil', false, 2, true, '2016-07-08 13:14:37.475431', 'admin', '2016-08-18 09:58:29.087131', 'patricia'),
('CRSRQ2038', 'CRREQ164', 'CRTST371', 'Verificar residencia tempral Auspiciante', false, 2, true, '2016-07-08 13:14:37.475431', 'admin', '2016-08-18 09:58:29.087131', 'patricia'),
('CRSRQ2042', 'CRREQ153', 'CRTST371', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 13:14:37.475431', 'admin', '2016-08-18 09:58:29.087131', 'patricia'),
('CRSRQ2041', 'CRREQ154', 'CRTST371', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 13:14:37.475431', 'admin', '2016-08-18 09:58:29.087131', 'patricia');

-- Reglas de tipo solicitud trámite (Cónyuge de Ministros de culto Religioso)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE869', 'CRTST371', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:29:28.819722', 'patricia', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE985', 'CRTST371', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-08 13:09:45.722280', 'admin', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE986', 'CRTST371', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 13:09:45.722280', 'admin', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE987', 'CRTST371', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 13:09:45.722280', 'admin', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE988', 'CRTST371', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 13:09:45.722280', 'admin', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE1095', 'CRTST371', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:32:05.029789', '2000043634', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE1060', 'CRTST371', 'CRVAL54', '[{"com.bmlaurus.rule.DinardapMarriedValidatorRep":""}]', null, true, '2016-08-08 11:11:36.324337', 'patricia', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE1059', 'CRTST371', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:11:36.324337', 'patricia', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE867', 'CRTST371', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-04 09:29:28.819722', 'patricia', '2016-08-18 09:58:29.087131', 'patricia', ''),
('CRTSE1146', 'CRTST371', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:58:29.087131', 'patricia', '2016-08-18 09:58:29.087131', 'patricia', '');

-- Opciones (Cónyuge de Ministros de culto Religioso)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO934', 'CRTSO2', 'CRTST371', true, '2016-08-18 09:58:29.087131', 'patricia', '2016-08-18 09:58:29.087131', 'patricia');

-- Adjuntos (Cónyuge de Ministros de culto Religioso)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM31', 'Cgg_res_tramite', 'crtst_codigo=''CRTST371''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL107', 'ECM31', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL59', 'ECM31', 'identificacion', 'Identificación Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL58', 'ECM31', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 41-12C Hijos Ministros de culto u ordenes Religiosas (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST372', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 41-12C Hijos Ministros de culto u ordenes Religiosas', 'Hijos menores de edad, de ministros de cultos religiosos o de órdenes religiosas reconocidas, tendrán la condición migratoria de temporales.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:41:10.118183', 'patricia', '2016-08-18 09:59:10.404053', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Hijos Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2045', 'CRREQ153', 'CRTST372', 'Verificar cédula Beneficario', false, 1, true, '2016-07-08 14:31:26.205336', 'admin', '2016-08-18 09:59:10.410881', 'patricia'),
('CRSRQ2044', 'CRREQ153', 'CRTST372', 'Verificar cédula Auspiciante', false, 3, true, '2016-07-08 14:31:26.205336', 'admin', '2016-08-18 09:59:10.410881', 'patricia'),
('CRSRQ2043', 'CRREQ162', 'CRTST372', 'Verificar residencia temporal Auspiciante', false, 3, true, '2016-07-08 14:31:26.205336', 'admin', '2016-08-18 09:59:10.410881', 'patricia');

-- Reglas de tipo solicitud trámite (Hijos Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE871', 'CRTST372', 'CRVAL36', '[{"com.bmlaurus.rule.temporal.MinorChild":""}]', null, true, '2016-07-04 09:41:10.118183', 'patricia', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE989', 'CRTST372', 'CRVAL45', '[{"com.bmlaurus.rule.RegisteredIdentification":""}]', null, true, '2016-07-08 14:26:02.903150', 'admin', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE990', 'CRTST372', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 14:26:02.903150', 'admin', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE1096', 'CRTST372', 'CRVAL51', '[{"IN_FECHA_CAD_BEN":"valFechaSalida","IN_CRPER_CODIGO_REP":"repCrperCodigo"}]', null, true, '2016-08-10 14:32:45.300975', '2000043634', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE1063', 'CRTST372', 'CRVAL53', '[{"com.bmlaurus.rule.temporal.HijoDelRepresentante":""}]', null, true, '2016-08-08 11:13:55.922538', 'patricia', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE870', 'CRTST372', 'CRVAL3', '[{"IN_CRPER_CODIGO":"repCrperCodigo"}]', null, true, '2016-07-04 09:41:10.118183', 'patricia', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE1062', 'CRTST372', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:13:55.922538', 'patricia', '2016-08-18 09:59:10.410881', 'patricia', ''),
('CRTSE1147', 'CRTST372', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:59:10.410881', 'patricia', '2016-08-18 09:59:10.410881', 'patricia', '');

-- Opciones (Hijos Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO937', 'CRTSO2', 'CRTST372', true, '2016-08-18 09:59:10.410881', 'patricia', '2016-08-18 09:59:10.410881', 'patricia');

-- Adjuntos (Cónyuge de Ministros de culto Religioso)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM32', 'Cgg_res_tramite', 'crtst_codigo=''CRTST372''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL61', 'ECM32', 'identificacion', 'Identificación Auspiciante', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL60', 'ECM32', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL108', 'ECM32', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 47-1 Contratación Pública (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST373', 'CRTST2', 'CRTPT1', 'CRPRO81', null, null, 'Art. 47-1 Contratación Pública', 'Procedimientos para la contratación pública. En los concursos para la compra o contratación de obras, bienes y servicios en la provincia de Galápagos.', false, true, false, true, true, false, 365, false, false, false, true, 0, true, '2016-07-04 09:43:28.831428', 'patricia', '2016-08-18 09:59:52.831412', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Contratación Pública)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2048', 'CRREQ153', 'CRTST373', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-08 14:43:28.396299', 'admin', '2016-08-18 09:59:52.842850', 'patricia'),
('CRSRQ2047', 'CRREQ154', 'CRTST373', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-08 14:43:28.396299', 'admin', '2016-08-18 09:59:52.842850', 'patricia'),
('CRSRQ2046', 'CRREQ161', 'CRTST373', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-08 14:43:28.396299', 'admin', '2016-08-18 09:59:52.842850', 'patricia');

-- Reglas de tipo solicitud trámite (Contratación Pública)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE872', 'CRTST373', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:43:28.831428', 'patricia', '2016-08-18 09:59:52.842850', 'patricia', ''),
('CRTSE991', 'CRTST373', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-08 14:35:11.725526', 'admin', '2016-08-18 09:59:52.842850', 'patricia', ''),
('CRTSE992', 'CRTST373', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-08 14:35:11.725526', 'admin', '2016-08-18 09:59:52.842850', 'patricia', ''),
('CRTSE993', 'CRTST373', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-08 14:35:11.725526', 'admin', '2016-08-18 09:59:52.842850', 'patricia', ''),
('CRTSE1065', 'CRTST373', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:15:13.565325', 'patricia', '2016-08-18 09:59:52.842850', 'patricia', ''),
('CRTSE1122', 'CRTST373', 'CRVAL58', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:18:57.068790', 'patricia', '2016-08-18 09:59:52.842850', 'patricia', ''),
('CRTSE1148', 'CRTST373', 'CRVAL17', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 09:59:52.842850', 'patricia', '2016-08-18 09:59:52.842850', 'patricia', '');

-- Opciones (Hijos Ministros de culto u ordenes Religiosas)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO939', 'CRTSO2', 'CRTST373', true, '2016-08-18 09:59:52.842850', 'patricia', '2016-08-18 09:59:52.842850', 'patricia');

-- Adjuntos (Hijos Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM33', 'Cgg_res_tramite', 'crtst_codigo=''CRTST373''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL65', 'ECM33', 'copiaContrato', 'Copia del contrato de adjudicación del proceso de contratación pública', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL64', 'ECM33', 'documentoPortalComprasPublicas', 'Copia del documento emitido por el sistema del Portal de Compras Públicas que el proceso ha sido adjudicado a la empresa', 'D:sii:personales', 'alfpath.auspiciante.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL63', 'ECM33', 'documentoAcrediteQueConstaEnOferta', 'Copia del documento que acredite que el beneficiario consta en la lista de la oferta presentada para el proceso', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL109', 'ECM33', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL62', 'ECM33', 'identificacion', 'Identificación Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 42-1 Servidor público (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST374', 'CRTST7', 'CRTPT1', 'CRPRO81', null, null, 'Art. 42-1 Servidor público', 'Las servidoras y servidores públicos que ingresan a Galápagos para el cumplimiento de licencias de servicios institucionales', false, true, true, true, true, false, 90, false, false, true, true, 0, true, '2016-07-04 09:45:40.121442', 'patricia', '2016-08-18 10:39:30.760205', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Servidor público)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1966', 'CRREQ161', 'CRTST374', 'Realizar proceso de actualización documentos auspiciante', false, 0, true, '2016-07-04 11:39:12.642932', 'patricia', '2016-08-18 10:39:30.773045', 'patricia'),
('CRSRQ1967', 'CRREQ154', 'CRTST374', 'Verificar el derecho al sufragio beneficiario', false, 1, true, '2016-07-04 11:39:12.642932', 'patricia', '2016-08-18 10:39:30.773045', 'patricia'),
('CRSRQ1968', 'CRREQ153', 'CRTST374', 'Verificar cédula beneficiario', true, 1, true, '2016-07-04 11:39:12.642932', 'patricia', '2016-08-18 10:39:30.773045', 'patricia');

-- Reglas de tipo solicitud trámite (Servidor público)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE873', 'CRTST374', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:45:40.121442', 'patricia', '2016-08-18 10:39:30.773045', 'patricia', ''),
('CRTSE903', 'CRTST374', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 10:53:09.506774', 'admin', '2016-08-18 10:39:30.773045', 'patricia', ''),
('CRTSE902', 'CRTST374', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 10:53:09.506774', 'admin', '2016-08-18 10:39:30.773045', 'patricia', ''),
('CRTSE900', 'CRTST374', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-06 14:57:48.109789', 'patricia', '2016-08-18 10:39:30.773045', 'patricia', ''),
('CRTSE1067', 'CRTST374', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:34:26.730475', 'patricia', '2016-08-18 10:39:30.773045', 'patricia', ''),
('CRTSE1123', 'CRTST374', 'CRVAL41', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:20:10.089045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia', ''),
('CRTSE1153', 'CRTST374', 'CRVAL57', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:39:30.773045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia', '');

-- Opciones (Servidor público)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO898', 'CRTSO2', 'CRTST374', true, '2016-08-18 10:39:30.773045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia'),
('CRTAO899', 'CRTSO14', 'CRTST374', true, '2016-08-18 10:39:30.773045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia'),
('CRTAO940', 'CRTSO9', 'CRTST374', true, '2016-08-18 10:39:30.773045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia'),
('CRTAO900', 'CRTSO1O', 'CRTST374', true, '2016-08-18 10:39:30.773045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia'),
('CRTAO901', 'CRTSO11', 'CRTST374', true, '2016-08-18 10:39:30.773045', 'patricia', '2016-08-18 10:39:30.773045', 'patricia');

-- Adjuntos (Hijos Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM1', 'Cgg_res_tramite', 'crtst_codigo=''CRTST374''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL8', 'ECM1', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL9', 'ECM1', 'documentoAcrediteActividad', 'Documento Acredite Actividad Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL110', 'ECM1', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 42-2 Profesional (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST375', 'CRTST7', 'CRTPT1', 'CRPRO81', null, null, 'Art. 42-2 Profesional', 'Los profesionales de todas las ramas, deportistas y artistas que ingresan a la provincia de Galápagos para atender asuntos relacionados con el giro propio de su profesión u oficio', false, true, true, true, true, false, 90, false, false, true, true, 0, true, '2016-07-04 09:49:06.582145', 'patricia', '2016-08-18 10:40:10.551908', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Profesional)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1969', 'CRREQ161', 'CRTST375', 'Realizar actualización de documentos y datos auspiciante', false, 0, true, '2016-07-04 11:56:16.702412', 'patricia', '2016-08-18 10:40:10.559470', 'patricia'),
('CRSRQ1970', 'CRREQ154', 'CRTST375', 'Verificar cumplimiento del derecho de sufragio beneficiario', false, 1, true, '2016-07-04 11:56:16.702412', 'patricia', '2016-08-18 10:40:10.559470', 'patricia'),
('CRSRQ1971', 'CRREQ153', 'CRTST375', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-04 11:56:16.702412', 'patricia', '2016-08-18 10:40:10.559470', 'patricia');

-- Reglas de tipo solicitud trámite (Profesional)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE874', 'CRTST375', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:49:06.582145', 'patricia', '2016-08-18 10:40:10.559470', 'patricia', ''),
('CRTSE1068', 'CRTST375', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:37:35.333877', 'patricia', '2016-08-18 10:40:10.559470', 'patricia', ''),
('CRTSE906', 'CRTST375', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 10:57:16.442437', 'admin', '2016-08-18 10:40:10.559470', 'patricia', ''),
('CRTSE905', 'CRTST375', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 10:57:16.442437', 'admin', '2016-08-18 10:40:10.559470', 'patricia', ''),
('CRTSE904', 'CRTST375', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 10:57:16.442437', 'admin', '2016-08-18 10:40:10.559470', 'patricia', ''),
('CRTSE1124', 'CRTST375', 'CRVAL41', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:20:56.627298', 'patricia', '2016-08-18 10:40:10.559470', 'patricia', ''),
('CRTSE1154', 'CRTST375', 'CRVAL57', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:40:10.559470', 'patricia', '2016-08-18 10:40:10.559470', 'patricia', '');

-- Opciones (Profesional)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) VALUES ('CRTAO941', 'CRTSO2', 'CRTST375', true, '2016-08-18 10:40:10.559470', 'patricia', '2016-08-18 10:40:10.559470', 'patricia');

-- Adjuntos (Hijos Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM2', 'Cgg_res_tramite', 'crtst_codigo=''CRTST375''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL1', 'ECM2', 'documentoAcrediteActividad', 'Documento Acredite Actividad Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL111', 'ECM2', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL10', 'ECM2', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 42-3 Socio, accionista, administradores, y empleados (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST376', 'CRTST7', 'CRTPT1', 'CRPRO81', null, null, 'Art. 42-3 Socio, accionista, administradores, y empleados.', 'Los socios, accionistas, administradores, y empleados de las personas jurídicas, que ingresan a Galápagos para la realización de actividades relacionadas con el giro ordinario de los negocios de aquellas.', false, true, true, true, true, false, 90, false, false, true, true, 0, true, '2016-07-04 09:51:44.206853', 'patricia', '2016-08-18 10:40:50.104594', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Socio, accionista, administradores, y empleados)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1988', 'CRREQ153', 'CRTST376', 'Verificar cédula Beneficiario', false, 1, true, '2016-07-07 11:05:19.283178', 'admin', '2016-08-18 10:40:50.117209', 'patricia'),
('CRSRQ1987', 'CRREQ154', 'CRTST376', 'Verificar derecho al sufragio Beneficiario', false, 1, true, '2016-07-07 11:05:19.283178', 'admin', '2016-08-18 10:40:50.117209', 'patricia'),
('CRSRQ1986', 'CRREQ161', 'CRTST376', 'Realizar actualización datos Auspiciante', false, 0, true, '2016-07-07 11:05:19.283178', 'admin', '2016-08-18 10:40:50.117209', 'patricia');

-- Reglas de tipo solicitud trámite (Socio, accionista, administradores, y empleados)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE913', 'CRTST376', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 11:30:55.750007', 'admin', '2016-08-18 10:40:50.117209', 'patricia', ''),
('CRTSE912', 'CRTST376', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-07 11:29:06.904693', 'admin', '2016-08-18 10:40:50.117209', 'patricia', ''),
('CRTSE914', 'CRTST376', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 11:30:55.750007', 'admin', '2016-08-18 10:40:50.117209', 'patricia', ''),
('CRTSE1071', 'CRTST376', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:41:25.675530', 'patricia', '2016-08-18 10:40:50.117209', 'patricia', ''),
('CRTSE915', 'CRTST376', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 11:30:55.750007', 'admin', '2016-08-18 10:40:50.117209', 'patricia', ''),
('CRTSE1125', 'CRTST376', 'CRVAL41', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:21:58.124079', 'patricia', '2016-08-18 10:40:50.117209', 'patricia', ''),
('CRTSE1155', 'CRTST376', 'CRVAL57', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:40:50.117209', 'patricia', '2016-08-18 10:40:50.117209', 'patricia', '');

-- Opciones (Socio, accionista, administradores, y empleados)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO902', 'CRTSO2', 'CRTST376', true, '2016-08-18 10:40:50.117209', 'patricia', '2016-08-18 10:40:50.117209', 'patricia'),
('CRTAO911', 'CRTSO7', 'CRTST376', true, '2016-08-18 10:40:50.117209', 'patricia', '2016-08-18 10:40:50.117209', 'patricia'),
('CRTAO912', 'CRTSO12', 'CRTST376', true, '2016-08-18 10:40:50.117209', 'patricia', '2016-08-18 10:40:50.117209', 'patricia');

-- Adjuntos (Hijos Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM10', 'Cgg_res_tramite', 'crtst_codigo=''CRTST376''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL112', 'ECM10', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL11', 'ECM10', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL2', 'ECM10', 'documentoAcrediteActividad', 'Documento Acredite Actividad Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Art. 42-4 Atención y prevención de desastres (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST377', 'CRTST7', 'CRTPT1', 'CRPRO81', null, null, 'Art. 42-4 Atención y prevención de desastres', 'Las personas que ingresan a la provincia de Galápagos con el objeto de colaborar en la atención y prevención de catástrofes', false, true, true, true, true, false, 90, false, false, true, true, 0, true, '2016-07-04 09:53:28.808669', 'patricia', '2016-08-18 10:41:29.332059', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Atención y prevención de desastres)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1972', 'CRREQ161', 'CRTST377', 'Realizar actualización de datos auspiciante', false, 0, true, '2016-07-04 12:00:14.279905', 'patricia', '2016-08-18 10:41:29.340508', 'patricia'),
('CRSRQ1973', 'CRREQ154', 'CRTST377', 'Verificar derecho al sufragio beneficiario', false, 1, true, '2016-07-04 12:00:14.279905', 'patricia', '2016-08-18 10:41:29.340508', 'patricia'),
('CRSRQ1974', 'CRREQ153', 'CRTST377', 'Verificar cédula beneficiario', false, 1, true, '2016-07-04 12:00:14.279905', 'patricia', '2016-08-18 10:41:29.340508', 'patricia');

-- Reglas de tipo solicitud trámite (Atención y prevención de desastres)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE876', 'CRTST377', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:53:28.808669', 'patricia', '2016-08-18 10:41:29.340508', 'patricia', ''),
('CRTSE919', 'CRTST377', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 11:33:54.939940', 'admin', '2016-08-18 10:41:29.340508', 'patricia', ''),
('CRTSE918', 'CRTST377', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 11:33:54.939940', 'admin', '2016-08-18 10:41:29.340508', 'patricia', ''),
('CRTSE1073', 'CRTST377', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:43:26.021113', 'patricia', '2016-08-18 10:41:29.340508', 'patricia', ''),
('CRTSE1074', 'CRTST377', 'CRVAL41', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:43:26.021113', 'patricia', '2016-08-18 10:41:29.340508', 'patricia', ''),
('CRTSE917', 'CRTST377', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 11:33:54.939940', 'admin', '2016-08-18 10:41:29.340508', 'patricia', ''),
('CRTSE1156', 'CRTST377', 'CRVAL57', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:41:29.340508', 'patricia', '2016-08-18 10:41:29.340508', 'patricia', '');

-- Opciones (Atención y prevención de desastres)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO907', 'CRTSO2', 'CRTST377', true, '2016-08-18 10:41:29.340508', 'patricia', '2016-08-18 10:41:29.340508', 'patricia'),
('CRTAO908', 'CRTSO7', 'CRTST377', true, '2016-08-18 10:41:29.340508', 'patricia', '2016-08-18 10:41:29.340508', 'patricia'),
('CRTAO909', 'CRTSO12', 'CRTST377', true, '2016-08-18 10:41:29.340508', 'patricia', '2016-08-18 10:41:29.340508', 'patricia'),
('CRTAO938', 'CRTSO1', 'CRTST377', true, '2016-08-18 10:41:29.340508', 'patricia', '2016-08-18 10:41:29.340508', 'patricia');

-- Adjuntos (Hijos Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM11', 'Cgg_res_tramite', 'crtst_codigo=''CRTST377''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL12', 'ECM11', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL3', 'ECM11', 'documentoAcrediteActividad', 'Documento Acredite Actividad Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL113', 'ECM11', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

-- Art. 42-5 Voluntarios/Becarios/Pasantes (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST378', 'CRTST7', 'CRTPT1', 'CRPRO81', null, null, 'Art. 42-5 Voluntarios/Becarios/Pasantes', 'Los voluntarios, becarios y pasantes que ingresen a la provincia de Galápagos para prestar sus servicios dentro de programas de conservación.', false, true, true, true, true, false, 90, false, false, true, true, 0, true, '2016-07-04 09:56:38.018990', 'patricia', '2016-08-18 10:42:02.611445', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Voluntarios/Becarios/Pasantes)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ1977', 'CRREQ153', 'CRTST378', 'Verificar cédula beneficiario', false, 1, true, '2016-07-04 12:02:41.756114', 'patricia', '2016-08-18 10:42:02.621639', 'patricia'),
('CRSRQ1975', 'CRREQ161', 'CRTST378', 'Realizar actualización de datos auspiciante', false, 0, true, '2016-07-04 12:02:41.756114', 'patricia', '2016-08-18 10:42:02.621639', 'patricia'),
('CRSRQ1976', 'CRREQ154', 'CRTST378', 'Verificar derecho al sufragio beneficiario', false, 1, true, '2016-07-04 12:02:41.756114', 'patricia', '2016-08-18 10:42:02.621639', 'patricia');

-- Reglas de tipo solicitud trámite (Voluntarios/Becarios/Pasantes)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE877', 'CRTST378', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:56:38.018990', 'patricia', '2016-08-18 10:42:02.621639', 'patricia', ''),
('CRTSE920', 'CRTST378', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-07 11:37:15.738146', 'admin', '2016-08-18 10:42:02.621639', 'patricia', ''),
('CRTSE921', 'CRTST378', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-07 11:37:15.738146', 'admin', '2016-08-18 10:42:02.621639', 'patricia', ''),
('CRTSE922', 'CRTST378', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 11:37:15.738146', 'admin', '2016-08-18 10:42:02.621639', 'patricia', ''),
('CRTSE1076', 'CRTST378', 'CRVAL5', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-08 11:44:41.847299', 'patricia', '2016-08-18 10:42:02.621639', 'patricia', ''),
('CRTSE1126', 'CRTST378', 'CRVAL41', '[{"IN_FECHA_SALIDA":"valFechaSalida","IN_FECHA_INGRESO":"valFechaIngreso","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-16 17:22:49.694109', 'patricia', '2016-08-18 10:42:02.621639', 'patricia', ''),
('CRTSE1157', 'CRTST378', 'CRVAL57', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:42:02.621639', 'patricia', '2016-08-18 10:42:02.621639', 'patricia', '');

-- Opciones (Voluntarios/Becarios/Pasantes)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO903', 'CRTSO2', 'CRTST378', true, '2016-08-18 10:42:02.621639', 'patricia', '2016-08-18 10:42:02.621639', 'patricia'),
('CRTAO904', 'CRTSO7', 'CRTST378', true, '2016-08-18 10:42:02.621639', 'patricia', '2016-08-18 10:42:02.621639', 'patricia'),
('CRTAO905', 'CRTSO12', 'CRTST378', true, '2016-08-18 10:42:02.621639', 'patricia', '2016-08-18 10:42:02.621639', 'patricia'),
('CRTAO906', 'CRTSO1', 'CRTST378', true, '2016-08-18 10:42:02.621639', 'patricia', '2016-08-18 10:42:02.621639', 'patricia');

-- Adjuntos (Hijos Ministros de culto u ordenes Religiosas)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM12', 'Cgg_res_tramite', 'crtst_codigo=''CRTST378''', null, true, true, 'patricia', 'patricia');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL114', 'ECM12', 'informeResolucion', 'Resolución', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null),
('ECMFL13', 'ECM12', 'identificacion', 'Pasaporte Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL4', 'ECM12', 'documentoAcrediteActividad', 'Documento Acredite Actividad Beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Trabajadoras Sexuales (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST379', 'CRTST7', 'CRTPT1', 'CRPRO81', null, null, 'Trabajadoras Sexuales', 'Trabajadoras Sexuales', false, true, true, true, true, false, 90, false, false, true, true, 0, true, '2016-07-04 09:58:52.298863', 'patricia', '2016-08-18 10:43:00.232741', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Trabajadoras Sexuales)
--
-- Reglas de tipo solicitud trámite (Trabajadoras Sexuales)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE878', 'CRTST379', 'CRVAL10', '[{"IN_CRPER_NUM_DOC_IDENTIFIC":"cggcrperCodigo"}]', null, true, '2016-07-04 09:58:52.298863', 'patricia', '2016-08-18 10:43:00.242634', 'patricia', ''),
('CRTSE924', 'CRTST379', 'CRVAL42', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, false, '2016-07-07 11:38:38.611309', 'admin', '2016-08-08 11:46:15.456728', 'patricia', ''),
('CRTSE925', 'CRTST379', 'CRVAL37', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-07 11:38:38.611309', 'admin', '2016-08-18 10:43:00.242634', 'patricia', ''),
('CRTSE1158', 'CRTST379', 'CRVAL57', '[{"IN_CRTRA_CODIGO":"valCrtraCodigo","IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-08-18 10:43:00.242634', 'patricia', '2016-08-18 10:43:00.242634', 'patricia', '');

-- Opciones (Trabajadoras Sexuales)
--

--REVOCATORIA

--Ingreso del proceso
INSERT INTO sii.cgg_res_proceso (crpro_codigo, crpro_nombre, crpro_estado, crpro_fecha_insert, crpro_usuario_insert, crpro_fecha_update, crpro_usuario_update) 
VALUES ('CRPRO92', 'Solicitud Revocatoria 2016', true, '2016-07-25 16:37:48.389191', 'admin', '2016-07-25 16:37:48.389191', 'admin');

-- Creación de fases para el proceso Solicitud Revocatoria 2016

INSERT INTO sii.cgg_res_fase (crfas_codigo, crpro_codigo, crett_codigo, cgg_crett_codigo, crsec_codigo, cgg_crfas_codigo, cgg_cusu_codigo, crfas_nombre, crfas_orden, crfas_tarea_realiza, crfas_funcion_ejecuta, crfas_sube_adjunto, crfas_sube_adjunto_requisito, crfas_ejecuta_despacho, crfas_atencion_normal, crfas_estado, crfas_fecha_insert, crfas_usuario_insert, crfas_fecha_update, crfas_usuario_update) 
VALUES ('CRFAS292', 'CRPRO92', null, null, 'CRSEC6', null, null, 'Recepción Revocatoria 2016', 1, 'Se ingresa vía web la solicitud de revocatoria para residencia', '', true, true, false, true, true, '2016-06-02 10:36:09.144272', 'patricia', '2016-06-02 10:36:09.144272', 'patricia');
INSERT INTO sii.cgg_res_fase (crfas_codigo, crpro_codigo, crett_codigo, cgg_crett_codigo, crsec_codigo, cgg_crfas_codigo, cgg_cusu_codigo, crfas_nombre, crfas_orden, crfas_tarea_realiza, crfas_funcion_ejecuta, crfas_sube_adjunto, crfas_sube_adjunto_requisito, crfas_ejecuta_despacho, crfas_atencion_normal, crfas_estado, crfas_fecha_insert, crfas_usuario_insert, crfas_fecha_update, crfas_usuario_update) 
VALUES ('CRFAS293', 'CRPRO92', null, null, 'CRSEC24', null, null, 'Digitalización 2016', 2, 'Resvisión de los adjuntos y la información ingresada ', '', true, true, false, true, true, '2016-06-02 10:48:31.817610', 'patricia', '2016-06-02 10:48:31.817610', 'patricia');
INSERT INTO sii.cgg_res_fase (crfas_codigo, crpro_codigo, crett_codigo, cgg_crett_codigo, crsec_codigo, cgg_crfas_codigo, cgg_cusu_codigo, crfas_nombre, crfas_orden, crfas_tarea_realiza, crfas_funcion_ejecuta, crfas_sube_adjunto, crfas_sube_adjunto_requisito, crfas_ejecuta_despacho, crfas_atencion_normal, crfas_estado, crfas_fecha_insert, crfas_usuario_insert, crfas_fecha_update, crfas_usuario_update) 
VALUES ('CRFAS294', 'CRPRO92', 'CRETT3', 'CRETT4', 'CRSEC4', null, null, 'Calificación 2016', 3, 'Calificación de revocatoria de residencia', 'F_CGG_ANULAR_RESIDENCIA_2016', true, true, true, true, true, '2016-06-02 10:58:37.713440', 'patricia', '2016-06-02 11:09:05.007827', 'patricia');

-- Creación de Requerimientos para cada fase

-- Requerimientos fase Digitalizacion 2016
INSERT INTO sii.cgg_jur_criterio (cjcri_codigo, crfas_codigo, cjcri_requerimiento, cjcri_requerido, cjcri_estado, cjcri_fecha_insert, cjcri_usuario_insert, cjcri_fecha_update, cjcri_usuario_update) 
VALUES ('CJCRI358', 'CRFAS293', 'Revision de datos ingresados', true, true, '2016-06-02 10:48:31.817610', 'patricia', '2016-06-02 10:48:31.817610', 'patricia');
INSERT INTO sii.cgg_jur_criterio (cjcri_codigo, crfas_codigo, cjcri_requerimiento, cjcri_requerido, cjcri_estado, cjcri_fecha_insert, cjcri_usuario_insert, cjcri_fecha_update, cjcri_usuario_update) 
VALUES ('CJCRI359', 'CRFAS293', 'Revision de adjuntos', true, true, '2016-06-02 10:48:31.817610', 'patricia', '2016-06-02 10:48:31.817610', 'patricia');

-- Creación de tipos de solicitud para revocatoria (tipo_solicitud_tramite)

update sii.cgg_res_tipo_solicitud_tramite set cgg_crtst_codigo=null, crtpt_codigo='CRTPT1', crpro_codigo=null, crres_codigo=null, ckesp_codigo= null, 
crtst_descripcion='Revocatoria Permanente/Temporal/Transeunte', crtst_observacion='Revocatoria de residencias', crtst_aplica_garantia=false, crtst_aplica_tramite=false,
crtst_aplica_grupo=false, crtst_atencion_cliente=false, crtst_restringido=false, crtst_comunicado_radial=false, crtst_numero_dias= 0, crtst_vehiculo=false,
crtst_unanimidad=false, crtst_aplica_otro=false, crtst_aplica_beneficiario=false, crtst_indice=1, crtst_estado=true, crtst_fecha_insert='2011-04-19 19:56:27.271017',
crtst_usuario_insert='patricia', crtst_fecha_update='2016-07-25 19:31:28.980524', crtst_usuario_update='patricia', crtst_ingreso_web=null
 where crtst_codigo='CRTST65';

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST351', 'CRTST65', 'CRTPT1', 'CRPRO92', null, null, 'Revocatoria Residencia 2016', 'Revocatoria de cualquier tipo de residencia que este vigente', false, true, false, true, true, false, 0, false, false, false, true, 0, true, '2016-07-26 09:59:59.526676', 'patricia', '2016-08-08 10:07:27.058129', 'patricia', null);


-- Adjuntos (Revocatoria Residencia 2016)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM39', 'Cgg_res_tramite', 'crtst_codigo=''CRTST351''', null, true, true, 'admin', 'admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL118', 'ECM39', 'motivoRevocacion', 'Documentos que motiven el revocar la residencia', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL119', 'ECM39', 'documentosJustificacion', 'Documentos que justifiquen la revocatoria', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', true, true, false, null, null);

-- Cambio de Motivo 2016 (tipo solicitud tramite) --

INSERT INTO sii.cgg_res_tipo_solicitud_tramite (crtst_codigo, cgg_crtst_codigo, crtpt_codigo, crpro_codigo, crres_codigo, ckesp_codigo, crtst_descripcion, crtst_observacion, crtst_aplica_garantia, crtst_aplica_tramite, crtst_aplica_grupo, crtst_atencion_cliente, crtst_restringido, crtst_comunicado_radial, crtst_numero_dias, crtst_vehiculo, crtst_unanimidad, crtst_aplica_otro, crtst_aplica_beneficiario, crtst_indice, crtst_estado, crtst_fecha_insert, crtst_usuario_insert, crtst_fecha_update, crtst_usuario_update, crtst_ingreso_web) 
VALUES ('CRTST381', 'CRTST1', 'CRTPT1', 'CRPRO81', null, null, 'Cambio de Motivo 2016', 'Cambio de motivo para residentes permanentes', false, true, false, false, true, false, 0, false, false, false, true, 0, true, '2016-07-29 10:49:11.998094', 'is-admin', '2016-08-09 15:58:41.614324', 'patricia', null);

-- Requisitos de tipo solicitud trámite (Cambio de Motivo 2016)
INSERT INTO sii.cgg_res_solicitud_requisito (crsrq_codigo, crreq_codigo, crtst_codigo, crsrq_descripcion, crsrq_requerido, crsrq_participante, crsrq_estado, crsrq_fecha_insert, crsrq_usuario_insert, crsrq_fecha_update, crsrq_usuario_update) 
VALUES ('CRSRQ2011', 'CRREQ154', 'CRTST381', '', false, 1, true, '2016-07-29 11:01:30.702802', 'patricia', '2016-08-09 15:58:41.629705', 'patricia'),
('CRSRQ2010', 'CRREQ153', 'CRTST381', '', false, 1, true, '2016-07-29 11:01:30.702802', 'patricia', '2016-08-09 15:58:41.629705', 'patricia'),
('CRSRQ2009', 'CRREQ155', 'CRTST381', '', false, 1, true, '2016-07-29 11:01:30.702802', 'patricia', '2016-08-09 15:58:41.629705', 'patricia');

-- Reglas de tipo solicitud trámite (Cambio de Motivo 2016)
INSERT INTO sii.cgg_res_tipo_solicitud_regla (crtse_codigo, crtst_codigo, crval_codigo, crtse_campo_evaluacion, crtse_valor_1, crtse_estado, crtse_fecha_insert, crtse_usuario_insert, crtse_fecha_update, crtse_usuario_update, crtt_codigo) 
VALUES ('CRTSE1001', 'CRTST381', 'CRVAL2', '[{"IN_CRPER_CODIGO":"cggcrperCodigo"}]', null, true, '2016-07-29 11:01:30.702802', 'patricia', '2016-08-09 15:58:41.629705', 'patricia', ''),
('CRTSE1002', 'CRTST381', 'CRVAL48', '[{"com.bmlaurus.rule.VoteCNEBeneficiary":""}]', null, true, '2016-07-29 11:01:30.702802', 'patricia', '2016-08-09 15:58:41.629705', 'patricia', ''),
('CRTSE1003', 'CRTST381', 'CRVAL47', '[{"com.bmlaurus.rule.RegisteredIdentificationBeneficiary":""}]', null, true, '2016-07-29 11:01:30.702802', 'patricia', '2016-08-09 15:58:41.629705', 'patricia', '');

-- Opciones (Cambio de Motivo 2016)
INSERT INTO sii.cgg_res_tst_aplica (crtao_codigo, crtso_codigo, crtst_codigo, crtao_estado, crtao_fecha_insert, crtao_usuario_insert, crtao_fecha_update, crtao_usuario_update) 
VALUES ('CRTAO910', 'CRTSO2', 'CRTST381', true, '2016-08-09 15:58:41.629705', 'patricia', '2016-08-09 15:58:41.629705', 'patricia'),
('CRTAO920', 'CRTSO16', 'CRTST381', true, '2016-08-09 15:58:41.629705', 'patricia', '2016-08-09 15:58:41.629705', 'patricia');

-- Adjuntos (Cambio de Motivo 2016)

-- metadata
INSERT INTO sii.cgg_ecm_metadata (code, table_name, filter, files_repository, is_list, estado, usuario_insert, usuario_update) VALUES ('ECM42', 'Cgg_res_tramite', 'crtst_codigo=''CRTST381''', 'alfpath.resolucion.path', true, true, 'is-admin', 'is-admin');
-- file
INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository, override_name, estado, usuario_insert, usuario_update, insertable, updateable, mandatory, visible_role, editable_role) 
VALUES ('ECMFL121', 'ECM42', 'identificacion', 'Identificación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL122', 'ECM42', 'cert_votacion', 'papeleta de votación del beneficiario', 'D:sii:personales', 'alfpath.beneficiario.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL125', 'ECM42', 'respaldo', 'Documentación de Respaldo', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', true, true, false, null, null),
('ECMFL120', 'ECM42', 'informeResolucion', 'Resolucion', 'D:sii:respaldo', 'alfpath.resolucion.path', true, true, 'patricia', 'patricia', false, true, false, null, null);

--TRUNCATE
TRUNCATE cgg_buzon_correo;
TRUNCATE cgg_sec_log

--ISLA
update cgg_isla set cisla_estado=false where cisla_nombre='Baltra' or cisla_nombre='Floreana'

--DESHABILITAR TRIGGERS
CREATE OR REPLACE FUNCTION fn_triggerall(DoEnable boolean) RETURNS integer AS
$BODY$
DECLARE
mytables RECORD;
BEGIN
  FOR mytables IN SELECT relname FROM pg_class WHERE relhastriggers AND relname LIKE 'cgg%' AND NOT relname LIKE 'pg_%'
  LOOP
    IF DoEnable THEN
      EXECUTE 'ALTER TABLE ' || mytables.relname || ' ENABLE TRIGGER ALL';
    ELSE
      EXECUTE 'ALTER TABLE ' || mytables.relname || ' DISABLE TRIGGER ALL';
    END IF;
  END LOOP;

  RETURN 1;

END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE;


--F_IS_GRANT
-- Function: sii.f_is_grant(character varying, character varying, character varying, integer)

-- DROP FUNCTION sii.f_is_grant(character varying, character varying, character varying, integer);

CREATE OR REPLACE FUNCTION sii.f_is_grant(in_object character varying, in_path character varying, in_user character varying, in_sw integer)
  RETURNS boolean AS
$BODY$
DECLARE
TMP_SW INT;
TMP_CSOBJ_CODIGO VARCHAR;
BEGIN
	RETURN TRUE;
	SELECT COUNT(U.CUSU_CODIGO) INTO TMP_SW FROM SII.CGG_USUARIO U
	INNER JOIN SII.CGG_SEC_USUARIO_ROL SRL ON SRL.CUSU_CODIGO = U.CUSU_CODIGO AND SRL.CSPER_ESTADO AND SRL.CSROL_CODIGO = '1'
	WHERE U.CUSU_NOMBRE_USUARIO = IN_USER;
	IF (TMP_SW > 0) THEN
		RETURN TRUE;
	END IF;

	IF(IN_SW = 0) THEN
		SELECT OBJ.CSOBJ_CODIGO INTO TMP_CSOBJ_CODIGO
		FROM SII.CGG_SEC_OBJETO OBJ
		WHERE OBJ.CSOBJ_NOMBRE = IN_OBJECT;
		IF (TMP_CSOBJ_CODIGO IS NULL) THEN
			RETURN TRUE;
		END IF;
	END IF;

	SELECT COUNT(OBJ.CSOBJ_CODIGO) INTO TMP_SW
	FROM SII.CGG_SEC_OBJETO OBJ
	INNER JOIN SII.CGG_SEC_OBJETO_ROL BJR ON BJR.CSOBJ_CODIGO = OBJ.CSOBJ_CODIGO AND BJR.CSBJR_ESTADO
	INNER JOIN SII.CGG_SEC_USUARIO_ROL SRL ON SRL.CSROL_CODIGO = BJR.CSROL_CODIGO AND SRL.CSPER_ESTADO
	INNER JOIN SII.CGG_USUARIO U ON U.CUSU_CODIGO = SRL.CUSU_CODIGO AND U.CUSU_NOMBRE_USUARIO = IN_USER AND U.CUSU_ESTADO
	WHERE OBJ.CSOBJ_NOMBRE = IN_OBJECT AND
		CSOBJ_RUTA = IN_PATH AND IN_SW = 1 OR OBJ.CSOBJ_NOMBRE = IN_OBJECT AND IN_SW = 0;

	RETURN (TMP_SW > 0);
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION sii.f_is_grant(character varying, character varying, character varying, integer)
  OWNER TO postgres;



--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'mortiz','Tipos de solicitudes','Configuración de todos los tipos de solicitudes',
	'2.0','2016_08_23_scripts tramites.sql',true);
