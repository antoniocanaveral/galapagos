#!/usr/bin/env bash

#127.0.0.1 siidb siidb.gobiernogalapagos.gob.ec
#127.0.0.1 siiws siiws.gobiernogalapagos.gob.ec
#127.0.0.1 sii sii.gobiernogalapagos.gob.ec
#127.0.0.1 siialfresco siialfresco.gobiernogalapagos.gob.ec

##RUN SCRIPT AS ROOT

echo "## SII HOSTS ##" >> /etc/hosts
echo 127.0.0.1 siidb siidb.gobiernogalapagos.gob.ec >> /etc/hosts
echo 127.0.0.1 siiws siiws.gobiernogalapagos.gob.ec >> /etc/hosts
echo 127.0.0.1 sii sii.gobiernogalapagos.gob.ec >> /etc/hosts
echo 127.0.0.1 siialfresco siialfresco.gobiernogalapagos.gob.ec >> /etc/hosts