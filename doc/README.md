# Proyecto SII

Para la instalación del sistema SII, se requiere instalar Alfresco según el manuál de instalación, JasperServer y JBoss EAP.<br/>
A continuación la descripción de cada componente:

## Instalación del Servidor JBoss de SII
[Instalador]: ./Install.md "Guía de Instalación"
[Instalador][]

## Instalación del Modelo de Alfresco
[Alfresco]: ./alfresco/Instalacion.md "Instalación del Modelo de Alfresco"
[Alfresco][]

## Instalación de JasperServer
[Jasper]: http://community.jaspersoft.com/project/jasperreports-server/releases
Descargar la versión 6.2 o superior de Jasper Reports Server, desde el sitio [Jasper][]

Instalarlo en un servidor que se tenga acceso en la red local y configurarlo según la guía de instalación que puede encontrar en la misma página.

En la carpeta SII_HOME/jasper se encuentra el archivo **config.properties** que contiene las propiedades generales de la integración con el sistema SII

`Una vez probado el primer reporte en el sistema, es importante desactivar el parámetro ` **INIT_JASPERSERVER** ` para aumentar el rendimiento de la generación de reportes.`