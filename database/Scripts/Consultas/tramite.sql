select t.crtra_codigo,t.crtra_numero,s.crseg_codigo,s.crseg_numero,s.cgg_crseg_codigo , s.cusu_codigo
from cgg_res_tramite t
inner join cgg_res_seguimiento s on (s.crtra_codigo = t.crtra_codigo)
where t.crtra_numero = 54;

SELECT * FROM CGG_RES_SEGUIMIENTO WHERE CRSEG_CODIGO = 'CRSEG119';
SELECT * FROM CGG_RES_FASE;

select * from cgg_res_novedad_notificacion where crseg_codigo = 'CRSEG122';
UPDATE CGG_RES_NOVEDAD_NOTIFICACION SET CRNOV_FECHA_REGISTRO = CURRENT_TIMESTAMP WHERE CRNOV_FECHA_REGISTRO IS NULL;

SELECT * FROM CGG_RES_FASE;

SELECT 'KEYGEN' AS CJSGC_CODIGO, 
				   '' AS CRSEG_CODIGO, 
				   CRI.CJCRI_CODIGO, 
				   FALSE AS CJSGC_RESPUESTA, 
				   '' AS CJSGC_JUSTIFICACION, 
				   '' AS CJSGC_OBSERVACION,
				   CRI.CJCRI_REQUERIMIENTO,				   
				   CRI.CJCRI_REQUERIDO			   
			FROM SII.CGG_JUR_CRITERIO CRI 		
			WHERE CRI.CRFAS_CODIGO ='CRFAS13';

SELECT SII.F_CGG_RES_SEGUIMIENTO_HTML('CRSEG122');


UPDATE CGG_RES_SEGUIMIENTO SET CUSU_CODIGO = 'CUSU5'
ROLLBACK;
SELECT * FROM CGG_RES_SEGUIMIENTO