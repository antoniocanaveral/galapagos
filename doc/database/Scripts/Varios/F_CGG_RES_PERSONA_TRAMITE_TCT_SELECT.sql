/**
* FUNCION SII.F_CGG_RES_PERSONA_TRAMITE_TCT_SELECT
* SELECCIONA UN REGISTRO EN LA TABLA SII.CGG_RES_PERSONA.
* @param IN_CRDID_CODIGO DOCUMENTO DE IDENTIFICACION
* @param IN_CRPER_NUM_DOC_IDENTIFIC NUMERO DE DOCUMENTO DEL REGISTRO DE PERSONA
* @param IN_CTREG_FECHA_INGRESO FECHA DE INGRESO  A LA PROVINCIA POR TCT
* @return REFCURSOR
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_RES_PERSONA_TRAMITE_TCT_SELECT(
IN IN_CRDID_CODIGO VARCHAR, 
IN IN_CRPER_NUM_DOC_IDENTIFIC SII.CGG_RES_PERSONA.CRPER_NUM_DOC_IDENTIFIC%TYPE,
IN IN_CTREG_FECHA_INGRESO SII.CGG_TCT_REGISTRO.CTREG_FECHA_INGRESO%TYPE 
)RETURNS REFCURSOR AS
$$
DECLARE
	TMP_REF REFCURSOR;	
	TMP_CRTRA_NUMERO CHARACTER VARYING;	
	TMP_CRTST_CODIGO VARCHAR;
BEGIN
	SELECT CGCNF_VALOR_CADENA INTO TMP_CRTST_CODIGO FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO = '05';

	OPEN TMP_REF FOR
	SELECT 
		PR.CRPER_CODIGO, 
		PR.CRDID_CODIGO,				
		(SELECT CRDID_DESCRIPCION FROM CGG_RES_DOCUMENTO_IDENTIFICACIO DI WHERE DI.CRDID_CODIGO = PR.CRDID_CODIGO) TIPO_DOCUMENTO,
		PR.CRPER_NUM_DOC_IDENTIFIC, 
		PR.CRPER_NOMBRES, 
		PR.CRPER_APELLIDO_PATERNO, 
		PR.CRPER_GENERO, 
		PR.CGNCN_CODIGO,		
		(SELECT CGNCN_NACIONALIDAD FROM CGG_NACIONALIDAD ND WHERE ND.CGNCN_CODIGO = PR.CGNCN_CODIGO )  NACIONALIDAD,
		PR.CRPER_FECHA_NACIMIENTO,
		PR.CGG_CPAIS_CODIGO,		
		(SELECT CPAIS_NOMBRE FROM CGG_PAIS PAI WHERE PAI.CPAIS_CODIGO = PR.CGG_CPAIS_CODIGO ) RESIDENCIA,
		PR.CRPER_ESTADO,
		RSA.CRTST_CODIGO,
		TRM.CRTRA_CODIGO,
		TRM.CRTRA_NUMERO
	FROM SII.CGG_RES_PERSONA PR
	LEFT JOIN SII.CGG_RES_RESIDENCIA RSA ON RSA.CRPER_CODIGO = PR.CRPER_CODIGO AND 
		RSA.CRRSD_VIGENTE AND 
		RSA.CRRSD_FECHA_INICIO::DATE = IN_CTREG_FECHA_INGRESO::DATE AND 
		RSA.CRTST_CODIGO IN
		(WITH RECURSIVE TIPO(CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION)AS(
			SELECT CRTST_CODIGO, CGG_CRTST_CODIGO, CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE WHERE CRTST_CODIGO = (SELECT CGCNF_VALOR_CADENA
			FROM CGG_CONFIGURACION
			WHERE CGCNF_CODIGO = '05') 
			UNION SELECT TST.CRTST_CODIGO, TST.CGG_CRTST_CODIGO, TP.CRTST_DESCRIPCION FROM CGG_RES_TIPO_SOLICITUD_TRAMITE TST, TIPO TP
			WHERE TST.CGG_CRTST_CODIGO = TP.CRTST_CODIGO
		) SELECT CRTST_CODIGO  FROM TIPO) AND
		RSA.CRRSD_ESTADO
	LEFT JOIN SII.CGG_RES_TRAMITE TRM ON TRM.CRTRA_CODIGO = RSA.CRTRA_CODIGO 
	WHERE PR.CRPER_ESTADO AND 
		CRPER_NUM_DOC_IDENTIFIC = IN_CRPER_NUM_DOC_IDENTIFIC AND 
		(PR.CRDID_CODIGO = IN_CRDID_CODIGO);
	RETURN TMP_REF ;
END
$$
LANGUAGE 'PLPGSQL' VOLATILE CALLED ON NULL INPUT;