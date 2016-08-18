#!/usr/bin/env bash

export ROOT_PATH=$(pwd)

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
   -Dfile=$ROOT_PATH/lib/BsxBSP.jar \
   -DgroupId=com.besixplus \
   -DartifactId=com.besixplus.biometric \
   -Dversion=1.0-SNAPSHOT \
   -Dpackaging=jar

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
   -Dfile=$ROOT_PATH/lib/SigPlus2_52.jar \
   -DgroupId=com.topaz \
   -DartifactId=com.topaz.sigplus \
   -Dversion=1.0 \
   -Dpackaging=jar


mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
   -Dfile=$ROOT_PATH/lib/comm.jar \
   -DgroupId=javax.comm \
   -DartifactId=comm \
   -Dversion=2.0.3 \
   -Dpackaging=jar


mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
   -Dfile=$ROOT_PATH/lib/NbioBSPJNI.jar \
   -DgroupId=com.nitgen \
   -DartifactId=SDK \
   -Dversion=1.0 \
   -Dpackaging=jar