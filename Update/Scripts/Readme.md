## Aplicación de Scripts en la Base de Datos

Antes de aplicar los scripts la primera vez, es necesario ejecutar el archivo _script_controller.sql_<br/>
Cada vez que un desarrollador genere un nuevo script hay que ubicarlo en la carpeta de la versión correspondiente.

Al final de cada script debe existir una clausula INSERT con el indicador de cabecera, tal como se muestra en el ejemplo:

>--> MIGRATION SCRIPT CONTROLLER <--
>
>INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
>	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
>	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
>VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
>	true,'acanaveral','CGGSII-30','Modifica la funcion f_keygen, para usar secuencias nativas de la base de datos. Va creando las secuencias a demanda, actualizando el indice',
>	'2.0','2016_04_25_SecuenciasNativas.sql',true);