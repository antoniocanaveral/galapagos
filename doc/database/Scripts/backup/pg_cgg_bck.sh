#!/bin/bash
DATE=`date +%F`
/opt/PostgresPlus/8.4SS/bin/pg_dump --host 192.168.32.7 --port 5432 --username 'sii' --format custom --blobs --verbose --file /bases/sii/sii_bck_$DATE.backup --schema 'sii' cgg
