#!/usr/bin/env bash
#acanaveral

#Descomentar y poner la ruta respectiva si el resultado del comando java -version no es el adecuado.
#export JAVA_HOME=

export JBOSS_HOME=$(pwd)

export SII_HOME=$JBOSS_HOME/SII_HOME

JAVA_OPTS="-Xms2048m -Xmx2048m -XX:MaxPermSize=512m -Djava.net.preferIPv4Stack=true"
JAVA_OPTS="$JAVA_OPTS -Djboss.modules.policy-permissions=true -Djava.util.Arrays.useLegacyMergeSort=true"
JAVA_OPTS="$JAVA_OPTS -Dsii.home=$SII_HOME"
JAVA_OPTS="$JAVA_OPTS -DSII_HOME=$SII_HOME"

export JAVA_OPTS

echo "Iniciando JBOSS"
echo ""
#Modo Desarrollo
sh ${JBOSS_HOME}/bin/standalone.sh --debug 8787 -b 0.0.0.0

#Modo Produccion
#sh ${JBOSS_HOME}/bin/standalone.sh -b 0.0.0.0

#Si se tienen varios archivos standalone.xml
#sh ${JBOSS_HOME}/bin/standalone.sh --debug 8787 -b 0.0.0.0 #-c standalone-custom.xml