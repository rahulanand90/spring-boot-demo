docker exec database "pg_restore -U postgres -d postgres /mnt/dvdrental"
psql -U postgres postgres