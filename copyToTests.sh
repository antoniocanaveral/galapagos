#!/usr/bin/env bash

export ROOT_PATH=$(pwd)
export REMOTE_SERVER=192.168.100.12

scp $ROOT_PATH/SIICGG_UI/target/SIICGG_UI.war advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP40/standalone/deployments

scp $ROOT_PATH/siicgg_web/target/siicgg_web.war advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP40/standalone/deployments

scp $ROOT_PATH/siiws/target/siiws.war advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP40/standalone/deployments

scp $ROOT_PATH/JbossEAP/SII_HOME/rules/*.* advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP40/SII_HOME/rules

scp $ROOT_PATH/JbossEAP/SII_HOME/mailing/*.* advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP40/SII_HOME/mailing

scp $ROOT_PATH/JbossEAP/SII_HOME/alfresco/globals.properties advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP40/SII_HOME/alfresco

scp $ROOT_PATH/JbossEAP/SII_HOME/jasper/reports/Resources/sii/*.jrxml advance@$REMOTE_SERVER:/home/advance/galapagos/JbossEAP/SII_HOME/jasper/reports/Resources/sii