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

select * from cliente;	

insert into conta_corrente (numero, saldo, codigo_cliente) values
	(123456, 1000.00, 1),
	(123457, 10336.00, 2),
	(123458, 120.00, 3),
	(123459, 1110.00, 4),
	(123460, 1560.00, 5);

select * from conta_corrente;

--selecionando todos os cliente com conta_corrente
--do maior para o menor saldo na conta
select cli.nome, cc.saldo
	from cliente cli, conta_corrente cc
	where cli.codigo = cc.codigo_cliente
	order by cc.saldo desc;