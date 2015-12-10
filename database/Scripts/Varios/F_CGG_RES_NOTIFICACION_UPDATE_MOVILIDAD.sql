/** FUNCION: F_CGG_RES_NOTIFICACION_UPDATE_MOVILIDAD
*ACTUALIZA LA INFORMACION DE LA TABLA CGG_RES_NOTIFICACION.
*@param IN_CRNOT_CODIGO  IDENTIFICATIVO DE NOTIFICACION
*@param IN_CRNOT_ESTADO_NOTIFICACION ESTADO DE LA NOTIFICACION
*@param IN_CRNOT_FECHA_SALIDA_VOLUNT FECHA DE SALIDA VOLUNTARIA DE LA PROVINCIA
*@param IN_CRNOT_FECHA_EXPULSION FECHA DE EXPULSION DE LA PROVINCIA
*@param IN_CRNOT_ESTADO ESTADO DE LA NOTIFICACION
*@param IN_CRNOT_USUARIO_UPDATE USUARIO QUE ACTUALIZO LA INFORMACION
*@return VOID 
*/

-- DROP FUNCTION F_CGG_RES_NOTIFICACION_UPDATE_MOVILIDAD(CHARACTER VARYING, INTEGER, TIMESTAMP WITH TIME ZONE, TIMESTAMP WITH TIME ZONE, BOOLEAN, CHARACTER VARYING);

CREATE OR REPLACE FUNCTION F_CGG_RES_NOTIFICACION_UPDATE_MOVILIDAD(
in IN_CRNOT_CODIGO CHARACTER VARYING,
IN IN_CRNOT_ESTADO_NOTIFICACION INTEGER,
IN IN_CRNOT_FECHA_SALIDA_VOLUNT TIMESTAMP WITH TIME ZONE, 
IN IN_CRNOT_FECHA_EXPULSION TIMESTAMP WITH TIME ZONE, 
IN IN_CRNOT_ESTADO BOOLEAN, 
IN IN_CRNOT_USUARIO_UPDATE CHARACTER VARYING)
  RETURNS VOID AS
$BODY$
BEGIN
	UPDATE SII.CGG_RES_NOTIFICACION SET
		CRNOT_ESTADO_NOTIFICACION = IN_CRNOT_ESTADO_NOTIFICACION,
		CRNOT_FECHA_SALIDA_VOLUNT= IN_CRNOT_FECHA_SALIDA_VOLUNT,
	        CRNOT_FECHA_EXPULSION = IN_CRNOT_FECHA_EXPULSION,
		CRNOT_ESTADO = IN_CRNOT_ESTADO, 
		CRNOT_FECHA_UPDATE = CURRENT_TIMESTAMP, 
		CRNOT_USUARIO_UPDATE = IN_CRNOT_USUARIO_UPDATE
	WHERE
		CRNOT_CODIGO=IN_CRNOT_CODIGO;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;
ALTER FUNCTION F_CGG_RES_NOTIFICACION_UPDATE_MOVILIDAD(CHARACTER VARYING, INTEGER, TIMESTAMP WITH TIME ZONE, TIMESTAMP WITH TIME ZONE, BOOLEAN, CHARACTER VARYING) OWNER TO SII;
