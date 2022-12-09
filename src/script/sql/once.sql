-- this script should run on postgres
--
-- psql -U postgres \i setup.sql

drop schema if exists stem cascade;
drop user if exists stem;

create user stem with password 'password';
create schema authorization stem;
