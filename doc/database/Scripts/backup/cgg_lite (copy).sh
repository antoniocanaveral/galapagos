#!/bin/bash
DATE=`date +%F`
/opt/PostgresPlus/8.4SS/bin/pg_dump --host localhost --port 5432 --username 'sii' --format custom --blobs --verbose --exclude-table="*adjunto*" --exclude-table="*auditoria*" --file /root/tmp/sii_lite_$DATE.backup --schema 'sii' cgg