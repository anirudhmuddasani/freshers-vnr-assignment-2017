---- creating an database for the item price list


CREATE DATABASE Pricelist;

USE  DATABASE Pricelist;

CREATE TABLE pricemenu(
	item name varchar(30) ,
	price     money,
	primary key (item name)

);
CREATE TABLE starters (
	item name varchar (30),
	price  money,
	primary key (item name)

);
CREATE TABLE desserts (
	item name varchar (30),
	price  money,
	primary key (item name)

);
CREATE TABLE bewerages (
	item name varchar (30),
	price  money,
	primary key (item name)

);

