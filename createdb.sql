CREATE DATABASE "PostgresqlConnection"
    WITH
    OWNER = smdsa
    ENCODING = 'UTF8'
    LC_COLLATE = 'ru_RU.UTF-8'
    LC_CTYPE = 'ru_RU.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE "PostgresqlConnection"
    IS 'Postgresql + spring boot';
