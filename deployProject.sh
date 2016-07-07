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
#JBOSS_HOME="/home/advance/java/ambiente-integralGalapagos/jboss-eap-6.4"
#JBOSS_HOME="/Users/acanaveral/Desarrollo/Advance/JbossEAP40"
JBOSS_HOME="/home/advance/java/ambiente-integralGalapagos/jboss-eap-6.4"

export ROOT_PATH=$(pwd)

echo "Limpiando Deploy Anterior"

rm -rf $JBOSS_HOME/standalone/deployments/*.war
rm -rf $JBOSS_HOME/standalone/deployments/*.war.*

echo "Copiando Deploy"
echo ""
cp $ROOT_PATH/SIICGG_UI/target/SIICGG_UI.war $JBOSS_HOME/standalone/deployments
echo "1/3"
cp $ROOT_PATH/siicgg_web/target/siicgg_web.war $JBOSS_HOME/standalone/deployments
echo "2/3"
cp $ROOT_PATH/siiws/target/siiws.war $JBOSS_HOME/standalone/deployments
echo "3/3"
echo ""
echo ""
echo "Copiando SII_HOME"
echo ""
cp -RP $ROOT_PATH/JbossEAP/SII_HOME $JBOSS_HOME/
echo ""
echo "Deploy Finalizado"