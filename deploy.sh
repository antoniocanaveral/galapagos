#!/usr/bin/env bash
clear
echo ""
echo ""
echo ""
echo "███████╗██╗██╗    ██████╗ ███████╗██████╗ ██╗      ██████╗ ██╗   ██╗"
echo "██╔════╝██║██║    ██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗╚██╗ ██╔╝"
echo "███████╗██║██║    ██║  ██║█████╗  ██████╔╝██║     ██║   ██║ ╚████╔╝ "
echo "╚════██║██║██║    ██║  ██║██╔══╝  ██╔═══╝ ██║     ██║   ██║  ╚██╔╝  "
echo "███████║██║██║    ██████╔╝███████╗██║     ███████╗╚██████╔╝   ██║   "
echo "╚══════╝╚═╝╚═╝    ╚═════╝ ╚══════╝╚═╝     ╚══════╝ ╚═════╝    ╚═╝   "
echo ""
echo ""

#MODIFICAR ESTA VARIABLE PARA SU AMBIENTE
JBOSS_HOME="/opt/jboss-eap-6.4"

USUARIO="antonio"
REMOTE_SERVER="sii.gobiernogalapagos.gob.ec"
PATH_DESTINO="/opt/jboss-eap-6.4/standalone/deployments"

export ROOT_PATH=$(pwd)

echo "Limpiando Deploy Anterior"

rm -rf $JBOSS_HOME/standalone/deployments/*.war
rm -rf $JBOSS_HOME/standalone/deployments/*.war.*

echo "Copiando Deploy Back-End"
echo ""
cp $ROOT_PATH/default/target/default.war $JBOSS_HOME/standalone/deployments
cp $ROOT_PATH/siiws/target/siiws.war $JBOSS_HOME/standalone/deployments
echo ""
echo "Iniciando Deploy Front-End"
echo ""
echo "Usuario: "$USUARIO
echo "1/2"
cp $ROOT_PATH/SIICGG_UI/target/SIICGG_UI.war $JBOSS_HOME/standalone/deployments
#scp $ROOT_PATH/SIICGG_UI/target/SIICGG_UI.war $USUARIO@$REMOTE_SERVER:$PATH_DESTINO
echo "2/2"
cp $ROOT_PATH/siicgg_web/target/siicgg_web.war $JBOSS_HOME/standalone/deployments
#scp $ROOT_PATH/siicgg_web/target/siicgg_web.war $USUARIO@$REMOTE_SERVER:$PATH_DESTINO
echo ""
echo "Copiando Global SII_HOME"
echo ""
cp -RP $ROOT_PATH/JbossEAP/SII_HOME $JBOSS_HOME/../
echo ""
echo "Deploy Finalizado"