drop database if exists almacen_db;
create database almacen_db;
use almacen_db;

create table ciudad_tbl(
codPostal char(5) not null primary key,
nombreCiudad varchar(100) not null 
);
create table proveedor_tbl(
cveProveedor varchar(6) not null primary key,
nombreEmpresa varchar (100) not null,
nombreEncargado varchar(100) not null,
apePatEncargado varchar (50) not null,
apeMatEncargado varchar(50) default null,
telefonoProveedor char(10) not null,
correoProvedor varchar (100) default null,
rfc char(13) not null,
codPostal char(5) not null,
foreign key (codPostal) references ciudad_tbl(codPostal) on update cascade on delete restrict
);
create table materiaPrima_tbl(
-- Nomenclatura para el id MSC-01
cveMateriaPrima char(6) not null primary key,
nombreMateria varchar(50) not null,
stockMinimo int(2) default null,
cantidadDisp int(3) not null
);
create table ingresoMaterial_tbl(
-- Nomenclatura IEN-01 I:Ingreso EN: mes del año y -01 semana del mes
cveIngresoMaterial char(6) not null primary key,
detallePedido varchar(50) default null,
estado char(1) not null,
cantidadPedido int(3) not null,
fechaPedido datetime default  current_timestamp,
fechaIngreso date ,
costoTotal decimal (5,2) not null,
cveProveedor varchar(6)  not null,
cveMateriaPrima char(6) not null,
foreign key (cveProveedor) references proveedor_tbl(cveProveedor) on update cascade,
foreign key (cveMateriaPrima) references materiaPrima_tbl(cveMateriaPrima)on update cascade
);

create table salidaMaterial_tbl(
-- Nomenclatura SSA-06241
cveSalidaMaterial char (9) not null primary key,
cantidadSalida int(4) not null, 
fechaSalida datetime default current_timestamp,
detalleSalida varchar(50) default null,
cveMateriaPrima char(7) not null,
foreign key(cveMateriaPrima) references materiaPrima_tbl(cveMateriaPrima)

);

CREATE VIEW SalidasConMateriaPrima AS
SELECT s.cveSalidaMaterial, s.cantidadSalida, s.fechaSalida, s.detalleSalida, m.nombreMateria, m.cantidadDisp
FROM salidaMaterial_tbl s
INNER JOIN materiaPrima_tbl m ON s.cveMateriaPrima = m.cveMateriaPrima;
