#!/bin/bash

DIRNAME=`dirname $0`
PROGNAME=`basename $0`

if [ $# -lt 3 ]; then
	echo "Se necesita los siguientes parametros:"
	echo "Uso: $0 user host database"
	exit 1
fi

#for i in `ls $DIRNAME/*.SQL`
for i in `find . -iname '*.sql'`
do
echo "Cargando archivo $i ..."
psql -U $1 -h $2 -d$3 < $i >> out.txt
done 
