create database db_cadastro_cliente_algaworks;
drop database db_cadastro_cliente_algaworks;

use db_jpa_algaworks;

create table cliente(
	codigo bigint not null auto_increment,
	nome varchar(100) not null,
	idade integer,
	sexo varchar(1) not null,
	profissao varchar(30),
	primary key(codigo)
);

create table conta_corrente(
	codigo bigint not null auto_increment,
	numero varchar(12) not null,
	saldo decimal,
	codigo_cliente bigint not null,
	primary key(codigo),
	foreign key(codigo_cliente) references cliente(codigo)
);

insert into cliente (nome, idade, sexo, profissao) values
	('José da Silva', 25, 'M', 'Engenheiro'),
	('Eilane Mattos', 24, 'F', 'Médica'),
	('Fernando Alves', 20, 'M', 'Professor'),
	('Márcio Souza', 22, 'M', 'Cozinheiro'),
	('Lucas Alves', 20, 'M', 'Marceneiro');