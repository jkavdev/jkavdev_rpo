create database db_agenda;

use db_agenda;

create table contato(
	codigo int not null auto_increment,
	nome varchar(50) null,
	email varchar(50) null,
	telefone varchar(50) null,
	data_nascimento date null,
	observacao text null,
	primary key(codigo)
);