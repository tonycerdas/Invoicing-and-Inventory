
/*	Entregable 2
	Definición de usuarios y roles 
	Grupo 5
	Integrantes: 
			Javier Badilla Agüero
			Nancy Maroto Araya
			Anthony Cerdas Chacón
			Yorbin Esquivel Fallas
*/

/*==============================================================*/
/* DEFINICION DE USUARIOS   								    */
/*==============================================================*/

alter session set "_oracle_script"=true;

-- Creacion usuarios cajeros --

create user gerardo_ramirez identified by rm700	
default tablespace users
temporary tablespace temp
quota unlimited on users;

create user elias_lopez identified by ellz93
default tablespace users
temporary tablespace temp
quota unlimited on users;

create user martin_matamoros identified by m0r0s
default tablespace users
temporary tablespace temp
quota unlimited on users;

-- Creacion usuarios gerentes de area --

--gerente_frescos_1--
create user nancy_maroto identified by nan3665
default tablespace users
temporary tablespace temp
quota unlimited on users;
--gerente_abarrotes_2--
create user pedro_amador identified by me74xco
default tablespace users
temporary tablespace temp
quota unlimited on users;
--gerente_cuidado_personal_1--
create user dayanna_jimenez identified by 741mma
default tablespace users
temporary tablespace temp
quota unlimited on users;
--gerente_mercancia_1--
create user leonel_zaitama identified by cannai555
default tablespace users
temporary tablespace temp
quota unlimited on users;

-- Creacion usuarios gerentes generales --

create user yorbin_esquivel identified by esquivel3582
default tablespace users
temporary tablespace temp
quota unlimited on users;

create user kathy_solano identified by 20opaxi50
default tablespace users
temporary tablespace temp
quota unlimited on users;

-- Creacion usuarios area de sistemas --

create user javier_badilla identified by prisma123es
default tablespace users
temporary tablespace temp
quota unlimited on users;

create user anthony_cerdas identified by anthony7575
default tablespace users
temporary tablespace temp
quota unlimited on users;

/*==============================================================*/
/* DEFINICION DE ROLES         								    */
/*==============================================================*/
-- Creacion de rol cajero --
create role cajero;
-- Permisos --
grant create session to cajero;

grant select, insert on factura to cajero;

grant select, insert, update(cantidad), delete on detalle_factura to cajero;

grant select, update(cantidad, peso) on producto to cajero;

grant select on categoria to cajero;

-- Creacion de rol gerente de area --
create role gerente_area;
-- Permisos de gerentes de area --
grant create session to gerente_area;

grant select, update(descripcion, cantidad, peso) on producto to gerente_area;

/* Nota: Concideracion posterior la creacion de un trigger que controle antes de modificar productos para tomar en consideracion si entran dentro de su categoria o area.*/

-- Creacion de rol gerente de general --
create role gerente_general;
-- Permisos de gerentes de area --
grant create session to gerente_general;

grant select, insert, update on producto to gerente_general;

-- Creacion de rol encargado de sistemas --
create role sistemas;
-- Permisos de gerentes de area --
grant create session, create user, resource, connect, create table, create any TRIGGER,
select any table, alter any table to sistemas;

/*grant select, insert, update on producto to sistemas;*/

-- ASIGNAR LOS ROLES A CADA USUARIO --


grant cajero to gerardo_ramirez;
grant cajero to elias_lopez;
grant cajero to martin_matamoros;

grant gerente_general to yorbin_esquivel;
grant gerente_general to kathy_solano;

grant gerente_area to nancy_maroto;
grant gerente_area to pedro_amador;
grant gerente_area to dayanna_jimenez;
grant gerente_area to leonel_zaitama;

grant sistemas to javier_badilla;
grant sistemas to anthony_cerdas;
