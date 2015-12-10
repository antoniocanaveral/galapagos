
SELECT
	R.ANIO,
	R.MES,
	R.MES_NUM,
	COALESCE(R.CISLA_NOMBRE,'No definido') CISLA_NOMBRE,
	COALESCE(COUNT(R.CRMOV_CODIGO),0) COUNT
FROM(
	SELECT
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'yyyy') ANIO,
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'TMMONTH') MES,
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'MM')::INT MES_NUM,
		(SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CGG_CARPT_CODIGO)) CISLA_NOMBRE,
		M.CRMOV_CODIGO
	FROM SII.CGG_RES_MOVILIDAD M
	INNER JOIN SII.CGG_RES_RESIDENCIA R ON (M.CRRSD_CODIGO = R.CRRSD_CODIGO)
	INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
	WHERE M.CRMOV_TIPO_OPERACION=0
	AND M.CRMOV_SOPORTE=FALSE
	AND M.CGG_CARPT_CODIGO IS NOT NULL
	AND M.CRMOV_FECHA_VIAJE::DATE BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
	AND F_TIPO_SOLICITUD_PADRE(R.CRTST_CODIGO) = (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO='06')
	AND P.CGNCN_CODIGO <> (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO='CONF36')
	ORDER BY M.CRMOV_FECHA_VIAJE
)AS R
GROUP BY ANIO,MES,CISLA_NOMBRE,MES_NUM
ORDER BY ANIO,MES_NUM


WITH VACIOS AS (
                SELECT 
                N.CGINU_ANIO::TEXT ANIO,
                N.CGINU_MES MES_NUM,
                N.CGINU_MES_DESC MES,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = N.CCTN_CODIGO) CISLA_NOMBRE,
                0 AS COUNT
                FROM CGG_INDICE_NULO N
                WHERE CGINU_FECHA BETWEEN BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                ),
INDICE AS (
           SELECT
           R.ANIO,
           R.MES,
           R.MES_NUM,
           COALESCE(R.CISLA_NOMBRE,'No definido') CISLA_NOMBRE,
           COALESCE(COUNT(R.CRMOV_CODIGO), 0) COUNT
           FROM(
                SELECT
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'yyyy') ANIO,
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'TMMONTH') MES,
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'MM')::INT MES_NUM,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CGG_CARPT_CODIGO)) CISLA_NOMBRE,
                M.CRMOV_CODIGO
                FROM SII.CGG_RES_MOVILIDAD M
                INNER JOIN SII.CGG_RES_RESIDENCIA R ON (M.CRRSD_CODIGO = R.CRRSD_CODIGO)
                INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
                WHERE M.CRMOV_TIPO_OPERACION = 0
                AND M.CRMOV_SOPORTE = FALSE
                AND M.CGG_CARPT_CODIGO IS NOT NULL
                AND M.CRMOV_FECHA_VIAJE::DATE BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                AND F_TIPO_SOLICITUD_PADRE(R.CRTST_CODIGO) = (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = '06')
                AND P.CGNCN_CODIGO <> (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = 'CONF36')
                ORDER BY M.CRMOV_FECHA_VIAJE
                )AS R
           GROUP BY ANIO, MES, CISLA_NOMBRE, MES_NUM
           ORDER BY ANIO, MES_NUM
           )
SELECT 
V.ANIO,
V.MES,
V.MES_NUM,
V.CISLA_NOMBRE,
COALESCE(I.COUNT, 0)
FROM VACIOS V LEFT JOIN INDICE I ON(V.ANIO = I.ANIO AND V.MES_NUM = I.MES_NUM AND V.CISLA_NOMBRE = I.CISLA_NOMBRE)



SELECT
	R.ANIO,
	R.MES,
	R.MES_NUM,
	R.CISLA_NOMBRE,
	COUNT(R.CRMOV_CODIGO)
FROM(
	SELECT
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'yyyy') ANIO,
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'TMMONTH') MES,
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'MM')::INT MES_NUM,
		(SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CARPT_CODIGO)) CISLA_NOMBRE,
		M.CRMOV_CODIGO
	FROM SII.CGG_RES_MOVILIDAD M
	INNER JOIN SII.CGG_RES_RESIDENCIA R ON (M.CRRSD_CODIGO = R.CRRSD_CODIGO)
	INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
	WHERE M.CRMOV_TIPO_OPERACION=1
	AND M.CRMOV_SOPORTE=FALSE
	AND M.CARPT_CODIGO IS NOT NULL
	AND DATE(M.CRMOV_FECHA_VIAJE) BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
	AND R.CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO='06')
	AND P.CGNCN_CODIGO <> (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO='CONF36')
	ORDER BY M.CRMOV_FECHA_VIAJE DESC
)AS R
GROUP BY ANIO,MES,CISLA_NOMBRE,MES_NUM
ORDER BY ANIO,MES_NUM

WITH VACIOS AS (
                SELECT 
                N.CGINU_ANIO::TEXT ANIO,
                N.CGINU_MES MES_NUM,
                N.CGINU_MES_DESC MES,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = N.CCTN_CODIGO) CISLA_NOMBRE,
                0 AS COUNT
                FROM CGG_INDICE_NULO N
                WHERE CGINU_FECHA BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                ),
INDICE AS (
           SELECT
           R.ANIO,
           R.MES,
           R.MES_NUM,
           COALESCE(R.CISLA_NOMBRE,'No definido') CISLA_NOMBRE,
           COALESCE(COUNT(R.CRMOV_CODIGO), 0) COUNT
           FROM(
                SELECT
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'yyyy') ANIO,
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'TMMONTH') MES,
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'MM')::INT MES_NUM,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CARPT_CODIGO)) CISLA_NOMBRE,
                M.CRMOV_CODIGO
                FROM SII.CGG_RES_MOVILIDAD M
                INNER JOIN SII.CGG_RES_RESIDENCIA R ON (M.CRRSD_CODIGO = R.CRRSD_CODIGO)
                INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
                WHERE M.CRMOV_TIPO_OPERACION = 1
                AND M.CRMOV_SOPORTE = FALSE
                AND M.CARPT_CODIGO IS NOT NULL
                AND M.CRMOV_FECHA_VIAJE::DATE BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                AND F_TIPO_SOLICITUD_PADRE(R.CRTST_CODIGO) = (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = '06')
                AND P.CGNCN_CODIGO <> (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = 'CONF36')
                ORDER BY M.CRMOV_FECHA_VIAJE
                )AS R
           GROUP BY ANIO, MES, CISLA_NOMBRE, MES_NUM
           ORDER BY ANIO, MES_NUM
           )
SELECT 
V.ANIO,
V.MES,
V.MES_NUM,
V.CISLA_NOMBRE,
COALESCE(I.COUNT, 0) COUNT
FROM VACIOS V LEFT JOIN INDICE I ON(V.ANIO = I.ANIO AND V.MES_NUM = I.MES_NUM AND V.CISLA_NOMBRE = I.CISLA_NOMBRE)



SELECT
	R.ANIO,
	R.MES,
	COALESCE(R.CISLA_NOMBRE,'No definido') CISLA_NOMBRE,
	R.MES_NUM,
	COUNT(R.CRMOV_CODIGO)
FROM(
	SELECT
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'yyyy') ANIO,
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'TMMONTH') MES,
		TO_CHAR(M.CRMOV_FECHA_VIAJE,'MM')::int MES_NUM,
		(SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CGG_CARPT_CODIGO)) CISLA_NOMBRE,
		M.CRMOV_CODIGO
	FROM SII.CGG_RES_MOVILIDAD M
	INNER JOIN SII.CGG_RES_RESIDENCIA R ON (M.CRRSD_CODIGO = R.CRRSD_CODIGO)
	INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
	WHERE M.CRMOV_TIPO_OPERACION=0
	AND M.CGG_CARPT_CODIGO IS NOT NULL
	AND M.CRMOV_SOPORTE=FALSE
	AND M.CRMOV_FECHA_VIAJE::DATE BETWEEN $P{P_FECHA_INICIAL}::DATE AND $P{P_FECHA_FINAL}::DATE
	AND R.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
					SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
					FROM CGG_CONFIGURACION
					WHERE CGCNF_CODIGO = '03'))
					UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
					WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
				) SELECT CRTST_CODIGO  FROM TIPO)
	ORDER BY M.CRMOV_FECHA_VIAJE
)AS R
GROUP BY ANIO,MES,MES_NUM,CISLA_NOMBRE
ORDER BY ANIO,MES_NUM

WITH VACIOS AS (
                SELECT 
                N.CGINU_ANIO::TEXT ANIO,
                N.CGINU_MES MES_NUM,
                N.CGINU_MES_DESC MES,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = N.CCTN_CODIGO) CISLA_NOMBRE,
                0 AS COUNT
                FROM CGG_INDICE_NULO N
                WHERE CGINU_FECHA BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                ),
INDICE AS (
           SELECT
           R.ANIO,
           R.MES,
           R.MES_NUM,
           COALESCE(R.CISLA_NOMBRE,'No definido') CISLA_NOMBRE,
           COALESCE(COUNT(R.CRMOV_CODIGO), 0) COUNT
           FROM(
                SELECT
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'yyyy') ANIO,
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'TMMONTH') MES,
                TO_CHAR(M.CRMOV_FECHA_VIAJE, 'MM')::INT MES_NUM,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CARPT_CODIGO)) CISLA_NOMBRE,
                M.CRMOV_CODIGO
                FROM SII.CGG_RES_MOVILIDAD M
                INNER JOIN SII.CGG_RES_RESIDENCIA R ON (M.CRRSD_CODIGO = R.CRRSD_CODIGO)
                INNER JOIN SII.CGG_RES_PERSONA P ON (R.CRPER_CODIGO = P.CRPER_CODIGO)
                WHERE M.CRMOV_TIPO_OPERACION=1
				AND M.CARPT_CODIGO IS NOT NULL
                AND M.CRMOV_SOPORTE = FALSE                
                AND M.CRMOV_FECHA_VIAJE::DATE BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                AND R.CRTST_CODIGO IN (WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
					SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE (CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
					FROM CGG_CONFIGURACION
					WHERE CGCNF_CODIGO = '03'))
					UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
					WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
				) SELECT CRTST_CODIGO  FROM TIPO)                
                ORDER BY M.CRMOV_FECHA_VIAJE
                )AS R
           GROUP BY ANIO, MES, CISLA_NOMBRE, MES_NUM
           ORDER BY ANIO, MES_NUM
           )
SELECT 
V.ANIO,
V.MES,
V.MES_NUM,
V.CISLA_NOMBRE,
COALESCE(I.COUNT, 0) COUNT
FROM VACIOS V LEFT JOIN INDICE I ON(V.ANIO = I.ANIO AND V.MES_NUM = I.MES_NUM AND V.CISLA_NOMBRE = I.CISLA_NOMBRE)


WITH VACIOS AS (
                SELECT 
                N.CGINU_ANIO::TEXT ANIO,
                N.CGINU_MES MES_NUM,
                N.CGINU_MES_DESC MES,
                (SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = N.CCTN_CODIGO) CISLA_NOMBRE,
                0 AS COUNT
                FROM CGG_INDICE_NULO N
                WHERE CGINU_FECHA BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                ),
INDICE AS (           
	SELECT
		R.ANIO,
		R.MES,
		R.CISLA_NOMBRE,
		R.MES_NUM,
		COUNT(CRPER_CODIGO)
	FROM(
		SELECT 
			TO_CHAR(M.CTIGF_FECHA_INTENTO,'dd/mm/yyyy') CTIGF_FECHA_INTENTO,
			TO_CHAR(M.CTIGF_FECHA_INTENTO,'yyyy') ANIO,
			TO_CHAR(M.CTIGF_FECHA_INTENTO,'TMMONTH') MES,
			TO_CHAR(M.CTIGF_FECHA_INTENTO,'mm')::INT MES_NUM,		
			M.CRPER_CODIGO,					
			(SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CARPT_CODIGO)) CISLA_NOMBRE
		FROM SII.CGG_TCT_INGRESO_FALLIDO M	
		WHERE M.CTIGF_FECHA_INTENTO::DATE BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
		AND M.CARPT_CODIGO IS NOT NULL
		AND M.CTIGF_ESTADO=TRUE
		ORDER BY CISLA_NOMBRE,CRPER_CODIGO,CTIGF_FECHA_INTENTO
	)AS R
	GROUP BY ANIO,MES,CISLA_NOMBRE,MES_NUM
	ORDER BY ANIO,MES_NUM
)
SELECT 
V.ANIO,
V.MES,
V.MES_NUM,
V.CISLA_NOMBRE,
COALESCE(I.COUNT, 0) COUNT
FROM VACIOS V LEFT JOIN INDICE I ON(V.ANIO = I.ANIO AND V.MES_NUM = I.MES_NUM AND V.CISLA_NOMBRE = I.CISLA_NOMBRE)


                INNER JOIN CGG_CANTON C ON (C.CCTN_CODIGO = N.CCTN_CODIGO AND C.CGPRV_CODIGO = '9')
				
				
				

WITH VACIOS AS (
                SELECT 
                N.CGINU_ANIO::TEXT ANIO,
                N.CGINU_MES MES_NUM,
                N.CGINU_MES_DESC MES,
                C.CCTN_NOMBRE CISLA_NOMBRE,
                0 AS COUNT
                FROM CGG_INDICE_NULO N
				INNER JOIN CGG_CANTON C ON (C.CCTN_CODIGO = N.CCTN_CODIGO AND C.CGPRV_CODIGO = '9')
                WHERE CGINU_FECHA BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
                ),
INDICE AS ( 				
	SELECT
		R.ANIO,
		R.MES,
		R.MES_NUM,
		R.CISLA_NOMBRE,
		COUNT(R.CTREG_CODIGO)
	FROM(
		SELECT
			TO_CHAR(M.CTREG_IMPRESION_ESPECIE,'yyyy') ANIO,
			TO_CHAR(M.CTREG_IMPRESION_ESPECIE,'TMMONTH') MES,
			TO_CHAR(M.CTREG_IMPRESION_ESPECIE,'MM')::INT MES_NUM,
			(SELECT C.CCTN_NOMBRE FROM SII.CGG_CANTON C WHERE C.CCTN_CODIGO = (SELECT A.CCTN_CODIGO FROM SII.CGG_RES_AEROPUERTO A WHERE A.CARPT_CODIGO = M.CGG_CARPT_CODIGO)) CISLA_NOMBRE,
			M.CTREG_CODIGO
		FROM SII.CGG_TCT_REGISTRO M
		INNER JOIN SII.CGG_RES_PERSONA P ON (M.CRPER_CODIGO = P.CRPER_CODIGO)
		WHERE CTREG_ESTADO_REGISTRO = 1
		AND M.CGG_CARPT_CODIGO IS NOT NULL
		AND M.CTREG_IMPRESION_ESPECIE::DATE BETWEEN $P{P_FECHA_INICIAL} AND $P{P_FECHA_FINAL}
		AND P.CGNCN_CODIGO = (SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO='CONF36')
		ORDER BY CISLA_NOMBRE,M.CTREG_IMPRESION_ESPECIE
	)AS R
	GROUP BY CISLA_NOMBRE,MES_NUM,MES,ANIO
	ORDER BY ANIO ASC, MES_NUM ASC
)
SELECT 
V.ANIO,
V.MES,
V.MES_NUM,
V.CISLA_NOMBRE,
COALESCE(I.COUNT, 0) COUNT
FROM VACIOS V LEFT JOIN INDICE I ON(V.ANIO = I.ANIO AND V.MES_NUM = I.MES_NUM AND V.CISLA_NOMBRE = I.CISLA_NOMBRE)
ORDER BY ANIO,MES