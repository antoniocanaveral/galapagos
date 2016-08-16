# Guía de Compilación e Instalación

## Pre-Requisitos

* Maven 3.1 o Superior
* Java 1.8_45 o Superior
* Git 2.3.8 o Superior
* Ant 1.8 o Superior

## Fuentes

Descargar el código fuente desde el repositorio **https://github.com/lasalazarr/galapagos**

> Ubíquese en un directorio de su máquina local y ejecute:
>> git clone https://github.com/lasalazarr/galapagos .

La carpeta principal del proyecto "galapagos" la denominaremos PROJECT_HOME.<br/>
Una vez descargado el código fuente y la documentación, procederemos a la compilación del sistema

## JBOSS EAP
[Jboss]: http://www.jboss.org/products/eap/download/ "Jboss Home"
Descargar Jboss EAP 6.3 o 6.4 desde [Jboss][]

Instalarlo en una carpeta de la máquina local. Normalmente en /opt, la denominaremos JBOSS_HOME.

En la carpeta PROJECT_HOME, identificar proyecto JbossEAP

**Crear el Módulo de PostgreSQL**

Copiar el módulo postgresql desde _PROJECT_HOME/JbossEAP/modules/system/layers/base/org_ en _JBOSS_HOME/modules/system/layers/base/org_

**Definir las Configuraciones**

Editar el archivo _standalone.xml_ reemplazando el datasource, con las configuraciones correspondientes:

    <datasource jndi-name="java:/sii" pool-name="sii" enabled="true">
        <connection-url>jdbc:postgresql://localhost/bdsii</connection-url>
        <driver>postgresql</driver>
        <pool>
            <min-pool-size>5</min-pool-size>
            <max-pool-size>100</max-pool-size>
            <flush-strategy>IdleConnections</flush-strategy>
        </pool>
        <security>
            <user-name>sii</user-name>
            <password>sii</password>
        </security>
        <statement>
            <track-statements>false</track-statements>
        </statement>
    </datasource>

Copiar el archivo _standalone.xml_ en _JBOSS_HOME/configuration_

**Copiar SII_HOME**

Copiar la carpeta _PROJECT_HOME/JbossEAP/SII_HOME_ en _JBOSS_HOME_

**Copiar Script de Arranque**

Copiar el archivo _PROJECT_HOME/JbossEAP/startup.sh_ en _JBOSS_HOME_

**Registrar el Keystore**

En una consola, ubicarse en el directorio _JBOSS_HOME/SII_HOME_<br/>

Para mayor información: https://support.globalsign.com/customer/en/portal/articles/2121490-java-keytool---create-keystore

Ejecutar el comando: `keytool -genkey -alias gobiernogalapagos.gob.ec -keyalg RSA -validity 1500 -keystore cgg_sii.jks` la clave preliminar es **siicgg2010**

## Compilación

Desde PROJECT_HOME, nos movemos a la carpeta MavenLocalResources, donde ejecutaremos la actualización de nuestro Maven local.

`./mvnLocalInstall.sh`  (puede ser que necesitemos darle permiso de ejecución al archivo: sudo chmod -x mvnLocalInstall.sh)

En la carpeta PROJECT_HOME ejecutamos el comando:

`mvn clean install -DskipTests=true`
<br/>
*Es necesario tener conexión a internet*

Los proyectos que vamos a instalar en JBOSS, son los que fueron generados en la carpeta target de:

- PROJECT_HOME/SIICGG_UI
- PROJECT_HOME/siicgg_web
- PROJECT_HOME/siiws


## Despliegue

En la carpeta PROJECT_HOME existe el archivo _deployProject.sh_<br/>
Edite el archivo modificando la variable JBOSS_HOME con la ruta de instalación de su JBOSS EAP.

Modifique los permisos del archivo `chmod 777 deployProject.sh` <br/>
A partir de ahora puede ejecutar el archivo cada vez que quiera desplegar el proyecto en su ambiente: `./deployProject.sh`


## Ejecución

Para iniciar el servidor con todos los servicios configurados. Abrir una consola y posicionarse en el directorio de JBOSS_HOME<br/>
Ejecutar el script:<br/>
`./startup.sh`

_**No arranque el servidor con el script nativo (JBOSS_HOME/bin/standalone.sh) porque hay variables del sistema que se deben cargar previamente.**_
<br/>
<br/>