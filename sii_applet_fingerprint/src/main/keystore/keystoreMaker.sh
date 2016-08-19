#!/usr/bin/env bash

KEYSTORE=./signing-jar.keystore
keytool -genkey -alias applet -keystore $KEYSTORE -storepass applet -keypass applet -dname "CN=acanaveral, OU=bmlaurus 3, O=com.bmlaurus, L=Quito, ST=Ecuador, C=EC"
keytool -selfcert -alias applet -keystore $KEYSTORE -storepass applet -keypass applet