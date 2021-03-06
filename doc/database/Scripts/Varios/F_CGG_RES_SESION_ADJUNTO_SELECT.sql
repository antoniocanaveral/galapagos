/**
* FUNCION SII.F_CGG_RES_SESION_ADJUNTO_SELECT
* SELECCIONA TODOS LOS REGISTROS DE LA TABLA SII.CGG_RES_ADJUNTO.
* @param IN_CRSSC_CODIGO CODIGO DE LA SESION DE COMITE
* @return REFCURSOR
*/

CREATE OR REPLACE FUNCTION F_CGG_RES_SESION_ADJUNTO_SELECT(
IN_CRSSC_CODIGO CHARACTER VARYING)
  RETURNS SETOF REFCURSOR AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CRADJ_CODIGO, 	 
		CRADJ_NOMBRE_ADJUNTO		
	FROM SII.CGG_RES_ADJUNTO
	WHERE CRADJ_ESTADO = TRUE AND 
		CRSSC_CODIGO = IN_CRSSC_CODIGO;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100
  ROWS 1000;

/**
* FUNCION SII.F_CGG_RES_ADJUNTO_INSERT
* INGRESA UN REGISTRO EN LA TABLA SII.CGG_RES_ADJUNTO.
* @param IN_CRADJ_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
* @param IN_CRRES_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
* @param IN_CRADJ_CONTENIDO DESCRIPCION DEL CONTENIDO DEL ARCHIVO
* @param IN_CRADJ_NOMBRE_ADJUNTO NOMBRE DEL DOCUMENTO ADJUNTO
* @param IN_CRADJ_OBSERVACION OBSERVACION DEL ARCHIVO ADJUNTO
* @param IN_CRADJ_ARCHIVO_ADJUNTO ARCHIVO DIGITAL ANEXO 
* @param IN_CRADJ_ESTADO ESTADO DEL REGISTRO
* @param IN_CRADJ_USUARIO_INSERT USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA
* @param IN_CRADJ_USUARIO_UPDATE USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION
* @return VARCHAR
*/  

CREATE OR REPLACE FUNCTION F_CGG_RES_ADJUNTO_SESION_INSERT(
IN_CRADJ_CODIGO CHARACTER VARYING,
 IN_CRRES_CODIGO CHARACTER VARYING,
 IN_CRSSC_CODIGO CHARACTER VARYING, 
 IN_CRADJ_CONTENIDO TEXT, 
 IN_CRADJ_NOMBRE_ADJUNTO CHARACTER VARYING, 
 IN_CRADJ_OBSERVACION CHARACTER VARYING,
 IN_CRADJ_ARCHIVO_ADJUNTO BYTEA, IN_CRADJ_FECHA_REGISTRO TIMESTAMP WITH TIME ZONE,
 IN_CRADJ_ESTADO BOOLEAN, IN_CRADJ_USUARIO_INSERT CHARACTER VARYING, 
 IN_CRADJ_USUARIO_UPDATE CHARACTER VARYING)
  RETURNS CHARACTER VARYING AS
$BODY$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CRADJ_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_RES_ADJUNTO','CRADJ_CODIGO','CRADJ') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CRADJ_CODIGO;
	END IF;
	INSERT INTO SII.CGG_RES_ADJUNTO(
		CRADJ_CODIGO, 		 
		CRRES_CODIGO, 
		CRSSC_CODIGO, 
		CRADJ_CONTENIDO, 
		CRADJ_NOMBRE_ADJUNTO, 
		CRADJ_OBSERVACION, 
		CRADJ_ARCHIVO_ADJUNTO, 
		CRADJ_FECHA_REGISTRO, 
		CRADJ_ESTADO, 
		CRADJ_FECHA_INSERT, 
		CRADJ_USUARIO_INSERT, 
		CRADJ_FECHA_UPDATE, 
		CRADJ_USUARIO_UPDATE
	) VALUES (
		OUT_KEY, 		 
		IN_CRRES_CODIGO, 
		IN_CRSSC_CODIGO, 
		IN_CRADJ_CONTENIDO, 
		IN_CRADJ_NOMBRE_ADJUNTO, 
		IN_CRADJ_OBSERVACION, 
		IN_CRADJ_ARCHIVO_ADJUNTO, 
		IN_CRADJ_FECHA_REGISTRO, 
		IN_CRADJ_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CRADJ_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CRADJ_USUARIO_UPDATE
	);
	RETURN OUT_KEY;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;

/**
* FUNCION: F_CGG_RES_ADJUNTO_SESION_DELETE(CHARACTER VARYING)
* ELIMINA UN REGISTRO EN LA TABLA SII.CGG_RES_ADJUNTO.
* @param IN_CRADJ_CODIGO IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
* @return VOID
*/
CREATE OR REPLACE FUNCTION F_CGG_RES_ADJUNTO_SESION_DELETE(IN_CRADJ_CODIGO CHARACTER VARYING)
  RETURNS VOID AS
$BODY$
BEGIN
	DELETE FROM SII.CGG_RES_ADJUNTO
	WHERE
		CRADJ_CODIGO = IN_CRADJ_CODIGO;
END
$BODY$
  LANGUAGE 'PLPGSQL' VOLATILE
  COST 100;