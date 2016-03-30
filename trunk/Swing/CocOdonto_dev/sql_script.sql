create database db_coc_odonto;

use coc_odonto;

create table paciente(
	id integer not null auto_increment,
	nome varchar(255),
	rg varchar(255),
	cpf varchar(255),
	sexo varchar(1),
	endereco_id integer(255),
	email varchar(255),
	telefone varchar(20),
	celular varchar(20),
	primary key(id)
);