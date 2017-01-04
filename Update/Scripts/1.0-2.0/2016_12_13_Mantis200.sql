DO $$DECLARE
	record_repetida RECORD;
	record_movilidad RECORD;
	v_crtra_codigo VARCHAR;

BEGIN

	FOR  record_repetida IN select min(crmov_codigo) as crmov_codigo, craln_codigo,carpt_codigo,cgg_carpt_codigo,crper_codigo,ctreg_codigo,crmov_fecha_viaje,
		crmov_tipo_operacion,crmov_numero_vuelo,crmov_observacion,crmov_tipo_salida,crmov_filtro_interno,crmov_soporte,crmov_fecha_insert,crmov_usuario_insert
		--crrsd_codigo
		from cgg_res_movilidad
		where crmov_soporte
		group by craln_codigo,carpt_codigo,cgg_carpt_codigo,crper_codigo,ctreg_codigo,crmov_fecha_viaje,
		crmov_tipo_operacion,crmov_numero_vuelo,crmov_observacion,crmov_tipo_salida,crmov_filtro_interno,crmov_soporte,crmov_fecha_insert,crmov_usuario_insert
		having count(1)>1
		order by crmov_fecha_viaje LOOP

		FOR record_movilidad IN select crmov_codigo, crrsd_codigo from cgg_res_movilidad
			where crper_codigo = record_repetida.crper_codigo
			and crmov_fecha_viaje=record_repetida.crmov_fecha_viaje
			and crmov_tipo_operacion = record_repetida.crmov_tipo_operacion
			and crmov_observacion = record_repetida.crmov_observacion
			and crmov_soporte = record_repetida.crmov_soporte
			and crmov_fecha_insert = record_repetida.crmov_fecha_insert
			and crmov_usuario_insert = record_repetida.crmov_usuario_insert
			and crmov_codigo <> record_repetida.crmov_codigo LOOP

			select crtra_codigo INTO v_crtra_codigo from cgg_res_residencia where crrsd_codigo = record_movilidad.crrsd_codigo;

      -- SE PUEDE CAMBIAR POR DELETE SI FUERA NECESARIO
			UPDATE cgg_res_tramite set crtra_estado = false where crtra_codigo = v_crtra_codigo;
			UPDATE cgg_res_residencia set crrsd_estado = false where crrsd_codigo = record_movilidad.crrsd_codigo;
			UPDATE cgg_res_movilidad set crmov_estado = false where crmov_codigo = record_movilidad.crmov_codigo;

		END LOOP;

	END LOOP;
END$$;