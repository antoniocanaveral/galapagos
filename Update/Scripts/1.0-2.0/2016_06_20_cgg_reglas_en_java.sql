INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL31', NULL, 'Casado Antes del 11 Junio de 2015', 'Verifica que el solicitante sea casado con el auspiciante antes del 11 de Junio del 2015', 'com.bmlaurus.rule.MarriedBeforeJune11Validator', '=', 'TRUE', 'TRUE', 'El solicitate no está casado con el auspiciante antes del 11 de Junio', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL32', NULL, 'Casado Despues del 11 Junio de 2015', 'Verifica que el solicitante sea casado con el auspiciante después de 11 de Junio de 2015 pero con mínimo 10 años de matrimonio', 'com.bmlaurus.rule.MarriedAfterJune11Validator', '=', 'TRUE', 'TRUE', 'El solicitate no está casado con el auspiciante despues del 11 de Junio con mínimo 10 años de matrimonio', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL33', NULL, 'Permanente antes de los 10 años y casado antes del 10 Junio', 'Verifica que el solicitante sea casado con el auspiciante antes del 11 de Junio del 2015 y el asupiciante haya fallecido', 'com.bmlaurus.rule.MarriedBefore10YearsSponsorDiedValidator', '=', 'TRUE', 'TRUE', 'El auspiciante aún no ha fallecido', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);


INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL34', NULL, 'Unión hecho con el auspiciante', 'Verifica que el solicitante esté en unión hecho con el auspiciante registrado en el DINARDAP', 'com.bmlaurus.rule.FreeUnionValidator', '=', 'TRUE', 'TRUE', 'El solicitate no está en union de hecho con el auspiciante', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL35', NULL, 'Minimo 10 años desde la solicitud de residencia', 'Verifica que haya transcurrido minimo 10 años desde la solicitud de residencia bajo el Art. 41-1 cuyo auspiciante sea el mismo conviviente. ', 'com.bmlaurus.rule.TenyearsApplicationResidenceValidator', '=', 'TRUE', 'TRUE', 'No ha transcurrido minimo 10 años desde la solicitud de residencia', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);

INSERT INTO sii.cgg_regla_validacion(crval_codigo, cgcnf_codigo, crval_nombre, crval_descripcion, crval_funcion_validacion, crval_operador_comparador, crval_valor_libre, crval_resultado_aceptacion, crval_sugerencia, crval_tipo, crvar_fecha_inicio, crvar_fecha_fin, crval_valor_1, crval_valor_2, crval_estado, crval_fecha_insert, crval_usuario_insert, crval_fecha_update, crval_usuario_update)
  VALUES('CRVAL36', NULL, 'Permanente antes de los 10 años', 'Verifica que el auspiciante ha fallecido para darle la permanecia antes de los 10 años de casada', 'com.bmlaurus.rule.Before10YearsSponsorDiedValidator', '=', 'TRUE', 'TRUE', 'No ha transcurrido minimo 10 años desde la solicitud de residencia', 1, NULL, NULL, NULL, NULL, true, NULL, NULL, NULL, NULL);


--> MIGRATION SCRIPT CONTROLLER <--

INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'xsilva','CGGSII-30','Insercion de registros para llamar a las reglas hechas en java',
	'1.0','2016_06_20_cgg_reglas_en_java.sql',true);

