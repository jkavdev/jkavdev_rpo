create database db_financeiro_algaworks
use db_financeiro_algaworks

insert into pessoas values
	(1, 'Márcio Gelius'),
	(2, 'Clarine Souza'),
	(3, 'Marcos Melhem'),
	(4, 'Vinícius Gaúcho'),
	(5, 'Neném Mattos');
	
create table usuario(
	nome_usuario varchar(15) not null primary key,
	senha varchar(32) not null
);

create table permissao_usuario(
	nome_usuario varchar(15) not null,
	nome_permissao varchar(15) not null,
	primary key(nome_usuario, nome_permissao),
	foreign key(nome_usuario) references usuario(nome_usuario)
);

insert into usuario values
	('Jhonatan', '123456'),
	('Lucas', '123'),
	('Douglas', '456');
	
insert into permissao_usuario values
	('Jhonatan', 'cadastro'),
	('Lucas', 'consulta'),
	('Douglas', 'cadastro'),
	('Douglas', 'consulta');
	
update usuario set senha = md5(senha);