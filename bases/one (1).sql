alter session set "_oracle_script"=true;

create user dba_sys identified by 1234
default tablespace users
temporary tablespace temp
quota unlimited on users;

grant connect, resource to dba_sys;
grant create table, create user to dba_sys;

commit;