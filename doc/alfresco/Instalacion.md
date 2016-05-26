# Instalación del Modelo Documental de Alfresco para SII

El modelo documental de Alfresco está diseñado para versiones superiores a la **4.2b**

[enlace]: http://docs.alfresco.com/community/tasks/simpleinstall-community-lin.html "Instalador Alfresco"

Para revisar la guía de instalación de Alfresco puede seguier el siguiente [enlace][]

Debe crear un sitio en Alfresco Share para que se gestione la documentación de SII. El nombre de este sitio no debe tener espacios ni caracteres especiales. Por default es **documentos-sii**

## Definición del Modelo Documental

### Tipos de Documento

</br>
<table border=0>
    <tr>
        <td></td>
        <td>SiiAttachmentDocument</td>
        <td></td>
    </tr>
    <tr>
        <td>SiiPersonales</td>
        <td></td>
        <td>SiiRespaldo</td>
    </tr>
</table>

### Aspectos

**SiiAlmacenable**

1. Caja*
2. Carpeta*
3. Descripción

**SiiCaducable**

1. Fecha de Caducidad*

**SiiIdentificable**

1. Nombre de la Tabla
2. Id del Registro


## Compilación e Instalación del Modelo

En el proyecto principal de maven, identificar el sub-proyecto **sii_alfresco_config**

Identifique la ruta de su compilador `ant`

Ejecute mendiante el comando:
<code> $ANT_HOME/ant deploy-jar -f {ruta al proyecto}/build.xml

El resultado es el archivo `build/lib/SIIContentModel.jar`

## Instalación del Modelo en su servidor Alfresco

En su servidor de Alfresco previamente instalado y configurado. 

Vaya hasta el directorio `$ALFRESCO_HOME/tomcat/shared/lib`

En ese directorio copie el archivo **SIIContentModel.jar** generado previamente.

Reinicie los servicios.

## Configuración de Parámetros de conexión
[Instalador]: ../Install.md "Guía de Instalación"
Una vez instalado su servidor de SII según el manual [Instalador][], en la carpeta SII_HOME de su JBOSS EAP, existe una carpeta
llamada alfresco. Dentro está el archivo config.properties, que le proveerá de información para los parámetros de conexión.

## Uso del componente en SII
[Componente]: ./Usage.md "Componentes para SII"
[Componente][]
