/*	Entregable 3
	Declaracion de Tablas.
	Grupo 5
	Integrantes: 
			Javier Badilla AgÃ¼ero
			Nancy Maroto Araya
			Anthony Cerdas ChacÃ³n
			Yorbin Esquivel Fallas
*/
/*==============================================================*/
/*Definicion de Tablas Master*/
create table categoria(
num_categoria  number(5) not null,
descripcion varchar(255) not null,
constraint pk_categoria primary key (num_categoria)
);

create table producto(
num_producto  number(10) not null,
num_categoria number(5) not null, 
ean number(13) null, 
plu number(5) null, 
descripcion varchar(255),
precio float not null,
peso float null,
cantidad number(10) null,
constraint pk_producto primary key (num_producto),
constraint fk01_producto foreign key (num_categoria)
references categoria (num_categoria)
);


create table factura(
num_factura number(10) not null,
constraint pk_factura primary key (num_factura)
);

numeracion_ventas, v_usuario,:new.caja,:new.num_factura,:new.total,v_fecha

create table detalle_factura(
num_detalle_factura  number(10) not null,
num_factura number(10) not null, 
fecha_hora timestamp,
cajero varchar(35),
caja number(2),
num_producto  number(10) not null,
cantidad float not null,
subtotal float not null,
total float not null,
constraint pk_detalle_factura primary key (num_detalle_factura),
constraint fk01_detalle_factura foreign key (num_factura)
references factura (num_factura),
constraint fk02_detalle_factura foreign key (num_producto)
references producto (num_producto)
);




/*
	Movimientos en las tablas maestras:
	•	Operación realizada
	•	Usuario quien realizó la operación
	•	Fecha
	•	Hora 
	•	Tabla afectada
*/


/*create table auditoria_maestras(
    
);*/

--Necesaria para generar el autoincremento de los registros de auditoria de operaciones--
create sequence  numeracion_operaciones
 increment by 1 start with 1
 minvalue 1 maxvalue 9999999999999999999999999999;


create table audit_operaciones(
    num_operacion number(10) not null, /*AUTO INCREMENTABLE*/
    operacion varchar(35) not null,
    usuario varchar(35) not null,
    fecha_hora timestamp,
    tabla_afectada varchar(35) not null,
    id_registro_1 number(10) null,
	id_registro_2 number(10) null
);

create or replace trigger inserta_producto
after insert on producto
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
	v_num_operacion number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
	select numeracion_operaciones.nextval into v_num_operacion from dual;
    insert into audit_operaciones( num_operacion, operacion, usuario, fecha_hora, tabla_afectada, id_registro_1, id_registro_2)
    values( v_num_operacion, 'Inserta nuevo producto',v_usuario, v_fecha,'producto', :new.ean, :new.plu);
end;

create or replace trigger inserta_categoria
after insert on categoria
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
	v_num_operacion number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
	select numeracion_operaciones.nextval into v_num_operacion from dual;
    insert into audit_operaciones(num_operacion, operacion, usuario, fecha_hora, tabla_afectada, id_registro_1)
    values( v_num_operacion, 'Inserta nueva categoria',v_usuario, v_fecha,'categoria', :new.num_categoria);
end;

create or replace trigger actualiza_producto
after update on producto
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
	v_num_operacion number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
	select numeracion_operaciones.nextval into v_num_operacion from dual;
    insert into audit_operaciones(num_operacion, operacion, usuario, fecha_hora, tabla_afectada, id_registro_1, id_registro_2)
    values( v_num_operacion, 'Actualizo el producto',v_usuario, v_fecha,'producto', :old.ean, :old.plu);
end;

create or replace trigger actualiza_categoria
after update on categoria
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
	v_num_operacion number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
	select numeracion_operaciones.nextval into v_num_operacion from dual;
    insert into audit_operaciones( num_operacion, operacion, usuario, fecha_hora, tabla_afectada, id_registro_1)
    values( v_num_operacion, 'Actualizo la categoria',v_usuario, v_fecha,'categoria', :old.num_categoria);
end;

create or replace trigger elimina_producto
before delete on producto
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
	v_num_operacion number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
	select numeracion_operaciones.nextval into v_num_operacion from dual;
    insert into audit_operaciones( num_operacion, operacion, usuario, fecha_hora, tabla_afectada, id_registro_1, id_registro_2)
    values( v_num_operacion, 'Borro el producto',v_usuario, v_fecha,'producto', :old.ean, :old.plu);
end;

create or replace trigger elimina_categoria
before delete on categoria
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
	v_num_operacion number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
	select numeracion_operaciones.nextval into v_num_operacion from dual;
    insert into audit_operaciones( num_operacion, operacion, usuario, fecha_hora, tabla_afectada, id_registro_1)
    values( v_num_operacion, 'Borro la categoria',v_usuario, v_fecha,'categoria', :old.num_categoria);
end;

/*
	En el caso de los cajeros se debe almacenar:
	•	Usuario
	•	Número de caja
	•	Número de factura
	•	Monto total de la factura 
	•	Fecha de la venta 
	•	Hora de la venta
*/

--Necesaria para generar el autoincremento de los registros de auditoria de ventas--
create sequence  numeracion_ventas
 increment by 1 start with 1
 minvalue 1 maxvalue 9999999999999999999999999999;


create table audit_ventas_cajeros(
    num_registro number(10) not null,/*Auto incrementable*/
    cajero varchar(150) not null,
    caja number(10) not null,
    num_factura number(10) not null,
    total float not null, /*Nos falta dentro de factura*/
    fecha timestamp 
);
create or replace trigger inserta_venta
after insert on detalle_factura
for each row
declare
    v_usuario varchar(30);
    v_fecha date;
    v_num_registro number(10);
begin
    select user into v_usuario from dual;
    select sysdate into v_fecha from dual;
    select numeracion_ventas.nextval into v_num_registro from dual;
    insert into audit_ventas_cajeros( num_registro, cajero, caja, num_factura, total, fecha)
    values( v_num_registro, v_usuario, :new.caja, :new.num_factura, :new.total, v_fecha);
end;
