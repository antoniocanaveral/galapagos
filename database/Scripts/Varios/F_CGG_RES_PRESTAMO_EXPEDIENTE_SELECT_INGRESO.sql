/**
* FUNCION F_CGG_RES_PRESTAMO_EXPEDIENTE_SELECT_INGRESO
* SELECCIONA N REGISTROS DE LA TABLA SII.CGG_RES_PRESTAMO_EXPEDIENTE DE LOS INGRESOS DE LOS EXPEDIENTE.
* @param IN_USER_NAME NOMBRE DE USUARIO DEL SERVIDOR DE APP. O DE LA BASE DE DATOS
* @param IN_START_INDEX INDICE DE INICIO DE REGISTROS
* @param IN_LIMIT NUMERO DE REGISTRO DISCRIMINADOS
* @param IN_SORT_FIELD_NAME COLUMNA DE ORDENAMIENTO
* @param IN_DIRECTION DIRECCION DEL ORDENAMIENTO ASC/DESC
* @param IN_FIND_TEXT CRITERIO DE BUSQUEDA
* @return REFCURSOR
*/

CREATE OR REPLACE FUNCTION F_CGG_RES_PRESTAMO_EXPEDIENTE_SELECT_INGRESO(IN_USER_NAME CHARACTER VARYING, IN_START_INDEX INTEGER, IN_LIMIT INTEGER, IN_SORT_FIELD_NAME CHARACTER VARYING, IN_DIRECTION CHARACTER VARYING, IN_FIND_TEXT TEXT)
  RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR EXECUTE
	'SELECT
		PEX.CRPEX_CODIGO, 
		PEX.CUSU_CODIGO, 
		PEX.CRPER_CODIGO,
		(SELECT CRPER_NOMBRES||'' ''||CRPER_APELLIDO_PATERNO||'' ''||CRPER_APELLIDO_MATERNO FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO=PEX.CRPER_CODIGO)AS CRPER_NOMBRE_RECIBE ,
		(SELECT CRPER_NUMERO_EXPEDIENTE FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO=PEX.CRPER_CODIGO)AS CRPER_NUMERO_EXPEDIENTE,
		(SELECT CRPER_FECHA_ARCHIVO FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO=PEX.CRPER_CODIGO)AS CRPER_FECHA_ARCHIVO,
		CGG_CRPER_CODIGO,
		(SELECT CRPER_NOMBRES||'' ''||CRPER_APELLIDO_PATERNO||'' ''||CRPER_APELLIDO_MATERNO FROM SII.CGG_RES_PERSONA WHERE CRPER_CODIGO=PEX.CRPER_CODIGO)AS CRPER_NOMBRE_ENTREGA ,
		CRPEX_FECHA_OPERACION, 
		CRPEX_MOVIMIENTO, 
		CRPEX_OBSERVACION, 
		CRPEX_ESTADO, 
		CRPEX_FECHA_INSERT, 
		CRPEX_USUARIO_INSERT, 
		CRPEX_FECHA_UPDATE, 
		CRPEX_USUARIO_UPDATE
	FROM SII.CGG_RES_PRESTAMO_EXPEDIENTE PEX WHERE PEX.CRPEX_ESTADO=TRUE AND CRPEX_MOVIMIENTO = 1  AND SII.F_STRING_IN('''||IN_FIND_TEXT||''',COALESCE(CRPEX_FECHA_OPERACION, CURRENT_TIMESTAMP)||'' ''||COALESCE(CRPEX_MOVIMIENTO, 0)||'' ''||COALESCE(CRPEX_OBSERVACION, '''')||'' ''||COALESCE(CRPEX_ESTADO, FALSE)||'' ''||COALESCE(CRPEX_FECHA_INSERT, CURRENT_TIMESTAMP)||'' ''||COALESCE(CRPEX_USUARIO_INSERT, '''')||'' ''||COALESCE(CRPEX_FECHA_UPDATE, CURRENT_TIMESTAMP)||'' ''||COALESCE(CRPEX_USUARIO_UPDATE, '''')) = 1
	ORDER BY '||IN_SORT_FIELD_NAME||' '||IN_DIRECTION||
	' LIMIT '||IN_LIMIT||' OFFSET '||IN_START_INDEX;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100
  ROWS 1000;