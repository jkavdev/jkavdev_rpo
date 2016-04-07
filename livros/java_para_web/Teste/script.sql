create database db_jpw_agenda;
use db_jpw_agenda;

create table contato(
	codigo int not null auto_increment,
	nome varchar(50) null,
	telefone varchar(50) null,
	email varchar(50) null,
	data_cadastro date null,
	observacao text,
	primary key(codigo)
);

create database db_jpw_comercio;
use db_jpw_comercio;