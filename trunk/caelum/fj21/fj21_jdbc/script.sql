create database db_fj21;
use db_fj21;

create table contato(
	id bigint not null auto_increment,
    nome varchar(255),
    email varchar(255),
    endereco varchar(255),
    data_nascimento date,
    primary key(id)
);

create table funcionario(
	id bigint not null auto_increment,
    nome varchar(255),
    usuario varchar(255),
    senha varchar(255),
    primary key(id)
);

desc funcionario;
select * from funcionario;

desc contato;
select * from contato;