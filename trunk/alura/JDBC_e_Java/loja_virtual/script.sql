create database db_loja_virtual;
use db_loja_virtual;

create table Produto(
	id int auto_increment,
	nome varchar(255),
	decricao varchar(255),
	primary key(id)
);

insert into produto values 
	(1, 'Geladeira', 'Geladeira duas portas'),
	(2, 'Ferro de Passar', 'Ferro de passar com vaporizador'),
	(3, 'Televisao', 'Televisao de Plasma'),
	(4, 'Microondas', 'Microondas duas comportas');