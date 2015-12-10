Archivo:		pg_cgg_bck.sh
Descripcion:	Script para entornos Linux/Unix para obtener un respaldo de la base del SII.
Utilizacion:	Existen dos modos de utilizacion: manual, automatica.
				Modo Manual
				Ejecutar el script desde una consola/ventana de comandos del sistema e inmediante sacara un respaldo de la base
				"cgg" en esquema "sii".
				Modo automatico
				Crear una tarea programada del sistema que ejecute el script. La frecuecia con que se ejecute dependera 
				de las necesidades.
Puntos a tomar en cuenta:
				En cualquier modo que se eligiera para obtener el respaldo se debe tener configurado el modo de autenticación
				que utilizara la herramienta para acceder a la base.
				Existen varios metodos (http://www.postgresql.org/docs/8.4/static/client-authentication.html), pero le sugerimos
				el siguiente:
				El carpeta de trabajo del usuario con el cual se ejecuta el script se debe crear un archivo de texto oculto 
				nombrado .pgpass que contendra la informacion de acceso a la base de datos. 
				Cada linea dentro del archivo contiene la informacion de acceso para un usuario, esta linea debe contener 
				el siguiente formato:  
					hostname:port:database:username:password
				Ejemplo:
					192.168.32.7:5432:cgg:sii:sii
					
				El archivo esta configurado para almacenar los archivos dentro de esta ubicacion /bases/sii/
				El nombre del archivo de respaldo esta formado por sii_bck_YYYY-MM-DD.backup
				Ejemplo: sii_bck_2011-05-30.backup