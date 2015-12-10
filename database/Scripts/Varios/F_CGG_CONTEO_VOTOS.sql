/**
*FUNCION F_CGG_VOTOS_APROBADOS
*CONTABILIZA LOS VOTOS APROBADOS.
*@param IN_CRRES_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION
*@return INTEGER
*/
CREATE OR REPLACE FUNCTION SII.F_CGG_VOTOS_APROBADOS(IN_CRRES_CODIGO CHARACTER VARYING)
  RETURNS INTEGER AS
$BODY$
DECLARE
	TMP_APROBADO INTEGER;	
BEGIN
	SELECT COUNT (VT.CRVTO_VOTACION) INTO TMP_APROBADO
	FROM CGG_RES_VOTO VT		
	WHERE  VT.CRVTO_VOTACION =0	
	AND VT.CRRES_CODIGO = IN_CRRES_CODIGO
	AND  VT.CRVTO_ESTADO= 'TRUE';
	
	RETURN  TMP_APROBADO;	
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;

 /** 
 * FUNCION SII.F_CGG_VOTOS_REPROBADOS
 * CONTABILIZA EL NUMERO DE VOTOS QUE HAN SIDO REPROBADOS.
 * @param IN_CRRES_CODIGO IDENTIFICATIVO UNICO DE RESOLUCION
 * @return INTEGER
 */

CREATE OR REPLACE FUNCTION SII.F_CGG_VOTOS_REPROBADOS( IN_CRRES_CODIGO CHARACTER VARYING)
  RETURNS INTEGER AS
$BODY$
DECLARE
	TMP_NEGADO INTEGER;	
BEGIN
	SELECT COUNT (VT.CRVTO_VOTACION) INTO TMP_NEGADO
	FROM CGG_RES_VOTO VT	
	WHERE  VT.CRVTO_VOTACION =1
	AND VT.CRRES_CODIGO = IN_CRRES_CODIGO
	AND  VT.CRVTO_ESTADO= 'TRUE';
	
	RETURN  TMP_NEGADO;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;

  /**
  * FUNCION SII.F_CGG_VOTOS_ABSTENCIONES
  * CONTABILIZA EL NUMERO DE VOTOS QUE SON DE ABSTENCIONES.
  * @param IN_CRRES_CODIGO IDENTIFICATIVO UNICO DE RESOLUCION
  * @return INTEGER
  */
  
CREATE OR REPLACE FUNCTION SII. F_CGG_VOTOS_ABSTENCIONES( IN_CRRES_CODIGO CHARACTER VARYING)
  RETURNS INTEGER AS
$BODY$
DECLARE
	TMP_ABSTENCION INTEGER;	
BEGIN
	SELECT COUNT (VT.CRVTO_VOTACION) INTO TMP_ABSTENCION
	FROM CGG_RES_VOTO VT	
	WHERE  VT.CRVTO_VOTACION =2
	AND VT.CRRES_CODIGO = IN_CRRES_CODIGO
	AND  VT.CRVTO_ESTADO= 'TRUE';
	
	RETURN  TMP_ABSTENCION;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;


