#!/usr/bin/env bash

export ROOT_PATH=$(pwd)

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
   -Dfile=$ROOT_PATH/lib/BsxBSP.jar \
   -DgroupId=com.besixplus \
   -DartifactId=com.besixplus.biometric \
   -Dversion=1.0-SNAPSHOT \
   -Dpackaging=jar