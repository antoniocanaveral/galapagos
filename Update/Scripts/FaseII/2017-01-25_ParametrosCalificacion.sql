CREATE TABLE sii.cgg_gem_parametro_calificacion
(
  cgpcl_codigo character varying(20) NOT NULL,
  cgpcl_estado boolean, -- ESTADO DEL REGISTRO
  cgpcl_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
  cgpcl_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
  cgpcl_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cgpcl_usuario_update character varying(20), -- USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cgpcl_nombre character varying(100),
  cgpcl_decripcion character varying(250),
  CONSTRAINT pk_cgg_gem_parametro_calificacion PRIMARY KEY (cgpcl_codigo)
)

CREATE TABLE sii.cgg_gem_parametro_vacante
(
  cgpvc_codigo character varying(20) NOT NULL,
  cgpvc_estado boolean, -- ESTADO DEL REGISTRO
  cgpvc_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
  cgpvc_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
  cgpvc_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cgpvc_usuario_update character varying(20), -- USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cgpcl_codigo character varying(20) NOT NULL, -- IDE PARAMETRO CALIFICACION
  cgvcn_codigo character varying(20) NOT NULL, -- IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
  cgvcn_weight numeric NOT NULL,-- PESO DEL PARAMETRO PARA LA VACANTE
  CONSTRAINT pk_cgg_gem_parametro_vacante PRIMARY KEY (cgpvc_codigo)
)

CREATE TABLE sii.cgg_gem_candidato_calificacion(
  cgccl_codigo character varying(20) NOT NULL,
  cgccl_estado boolean, -- ESTADO DEL REGISTRO
  cgccl_fecha_insert timestamp with time zone, -- FECHA DE INGRESO DE INFORMACION AL SISTEMA...
  cgccl_usuario_insert character varying(20), -- USUARIO QUE INGRESO LA INFORMACION EN EL SISTEMA...
  cgccl_fecha_update timestamp with time zone, -- FECHA QUE SE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cgccl_usuario_update character varying(20), -- USUARIO QUE REALIZO LA ACTUALIZACION DE LA INFORMACION...
  cgpvc_codigo character varying(20) NOT NULL, -- IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO_VACANTE
  cgccl_grade numeric NOT NULL,
  CONSTRAINT pk_cgg_gem_candidato_calificacion PRIMARY KEY (cgccl_codigo)
)

ALTER TABLE sii.cgg_gem_candidato ADD COLUMN cgcnd_final_grade NUMERIC ;

--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'acanaveral','Parametros Calificacion','Scripts para implementar parametros de calificacion',
	'2.0','Update/Scripts/FaseII/2017-01-25_ParametrosCalificacion.sql',true);