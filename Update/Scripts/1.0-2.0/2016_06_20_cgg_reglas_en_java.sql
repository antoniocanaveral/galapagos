--REGLAS PARA PERMANENTES
INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL31', NULL, 'Casado Antes del 11 Junio de 2015', 'Verifica que el solicitante sea casado con el auspiciante antes del 11 de Junio del 2015', 'com.bmlaurus.rule.MarriedBeforeJune11Validator', '=', 'TRUE', 'TRUE', 'El auspiciente aún no ha fallecido', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL32', NULL, 'Unión hecho con el auspiciante', 'Verifica que el solicitante esté en unión hecho con el auspiciante registrado en el DINARDAP', 'com.bmlaurus.rule.FreeUnionValidator', '=', 'TRUE', 'TRUE', 'El solicitate no está en union de hecho con el auspiciante', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL33', NULL, 'Minimo 10 años desde la solicitud de residencia', 'Verifica que haya transcurrido minimo 10 años desde la solicitud de residencia bajo el Art. 41-1 cuyo auspiciante sea el mismo conviviente. ', 'com.bmlaurus.rule.TenyearsApplicationResidenceValidator', '=', 'TRUE', 'TRUE', 'No ha transcurrido minimo 10 años desde la solicitud de residencia', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL34', NULL, 'Permanente antes de los 10 años', 'Verifica que el auspiciante ha fallecido para darle la permanecia antes de los 10 años de casada', 'com.bmlaurus.rule.Before10YearsSponsorDiedValidator', '=', 'TRUE', 'TRUE', 'El auspiciente aún no ha fallecido', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

-- REGLAS PARA TEMPORALES

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL35', NULL, 'Unión libre después del 11 Junio de 2015', 'Verifica que el solicitante está en unión libre con el auspiciente después del 11 de Junio del 2015', 'com.bmlaurus.rule.temporal.FreeUnionAfertJune11Validator', '=', 'TRUE', 'TRUE', 'El solicitante no está en unión libre con el auspiciantea a partir del 11 del Junio del 2015', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL36', NULL, 'Hijo menor de edad', 'Verifica que el hijo del solicitante sea menor de edad', 'com.bmlaurus.rule.temporal.MinorChild', '=', 'TRUE', 'TRUE', 'El hijo del solicitante no es menor de edad', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL37', NULL, 'Excedio de días como turista', 'Verifica que si el solicitante está en la provincia como turista no deberá estar excedido de días.', 'com.bmlaurus.rule.temporal.AsATouristExceededDays', '=', 'TRUE', 'TRUE', 'El solicitante está en la provincia como turista y está excedidio en días', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL38', NULL, 'Transeunte vigente', 'Verifica que si el solicitante está en la provincia como transeúnte tenga su transeúnte vigente. ', 'com.bmlaurus.rule.temporal.AsAPasserby', '=', 'TRUE', 'TRUE', 'El solicitante está con su transeúnte no vigente', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL39', NULL, 'Oferta laborar vigente', 'Verifica que la oferta laboral esté vigente', 'com.bmlaurus.rule.temporal.CurrentLaborSupply', '=', 'TRUE', 'TRUE', 'La oferta laboral no está vigente', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL40', NULL, 'Oferta laboral tenga vacantes', 'Verifica que la oferta laborar tenga vacantes libres para contratar', 'com.bmlaurus.rule.temporal.LaborSupplyFreeVacancies', '=', 'TRUE', 'TRUE', 'La oferta laboral no tiene vacantes para contratar', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

--Reglas para Transeuntes

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL41', NULL, 'Tiempo permitido en categoría de transeúnte', 'Verifica que el solicitante no exceda el tiempo permitido en la categoría de transeúnte.', 'com.bmlaurus.rule.transeunte.ExceedTimeCategoryPasserby', '=', 'TRUE', 'TRUE', 'El solicitante ha excedido el tiempo permitido en la categoría de transeúnte.', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL42', NULL, 'Permanente antes de los 10 años', 'Verifica que el solicitante no exceda el tiempo permitido en la categoría de transeúnte, definido para éste motivo específico.', 'com.bmlaurus.rule.transeunte.ExceedTimeCategoryPasserbyReason', '=', 'TRUE', 'TRUE', 'El solicitante ha excedido el tiempo permitido en la categoría de transeúnte, definido para éste motivo específico.', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);


--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'xsilva','CGGSII-30','Insercion de registros para llamar a las reglas hechas en java',
	'1.0','2016_06_20_cgg_reglas_en_java.sql',true);

