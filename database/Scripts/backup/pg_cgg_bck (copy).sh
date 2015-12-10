#!/bin/bash
DATE=`date +%F`
/opt/PostgresPlus/8.4SS/bin/pg_dump --host localhost --port 5432 --username 'sii' --format custom --blobs --verbose --file /root/tmp/sii_bck_$DATE.backup --schema 'sii' cgg
