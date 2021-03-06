# SII Galapagos
## Sinopsis

Nuevo Branch de Desarrollo a partir de aqui.

## Instalación

Documentos de Instalación de la plataforma

[Docs]: ./doc/README.md "Documentación"
[Docs][]

## Change Log

### V2
[Scripts]: ./Update/Scripts/Readme.md "Scripts"
[Componente]: ./doc/alfresco/Usage.md "Componentes para SII"
[Reglas]: ./doc/Reglas.md "Reglas Java"
[Dinardap]: ./sii_java_validator/README.md
[Fases]: ./doc/FasesJava.md

- Se creó la carpeta Update en la raíz del proyecto, para registrar los [Scripts][] de base de datos
- Separación de los componentes comunes en el proyecto **sii_commons** utilizado por los 3 proyectos originales
- Proyecto de Servicios de integración con Alfresco **sii_ecm_integration**
- Proyecto de Despliegue de modelo de Alfresco **sii_alfresco_config**
- SII_HOME carpeta global externa para almacenar archivos de propiedades
- Api para manejo de JasperServer **sii_jasper_api**
- Inclusion de archivo de configuracion de JasperServer en SII_HOME/jasper
- Se movieron los reportes a SII_HOME/jasper
- Servicio de Inicialización de JasperServer controlado desde el archivo de configuración
- Fácil integración del componente de Alfresco con SII [Componente][].
- bsxExtras.js ahora se puede editar en caliente desde SII_HOME/siicgg_ui.
- Se permiten reglas de Java además de las actuales funciones de base de datos [Reglas][].
- Servicio para llamadas a la Dinardap [Dinardap][]
- Procesos Cron y Mailing con archivos de configuración externos. SII_HOME/mailing & SII_HOME/cron
- Motor de Mensajería: Se define en cada fase el mensaje y los destinatarios a enviar. Defaults en SII_HOME/mailing/format.properties
- Mensajes HTML con templeta.
- Permitir funciones java en las fases. [Fases][]
- Todos los archivos de configuracion (.properties) se gestionan con un VirtualCache