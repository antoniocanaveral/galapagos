# Instalación del Modelo Documental de Alfresco para SII

El modelo documental de Alfresco está diseñado para versiones superiores a la **4.2b**

[enlace]: http://docs.alfresco.com/community/tasks/simpleinstall-community-lin.html "Instalador Alfresco"

Para revisar la guía de instalación de Alfresco puede seguier el siguiente [enlace][]

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

En el proyecto principal de maven, identificar el sub-proyecto __sii_alfresco_config__

Identifique la ruta de su compilador `ant`

Ejecute mendiante el comando:
<code> $ANT_HOME/ant deploy-jar -f {ruta al proyecto}/build.xml

El resultado es el archivo `build/lib/SIIContentModel.jar`

## Instalación del Modelo en su servidor Alfresco

En su servidor de Alfresco previamente instalado y configurado. 

Vaya hasta el directorio `$ALFRESCO_HOME/tomcat/shared/lib`

En ese directorio copie el archivo __SIIContentModel.jar__ generado previamente.

Reinicie los servicios.
