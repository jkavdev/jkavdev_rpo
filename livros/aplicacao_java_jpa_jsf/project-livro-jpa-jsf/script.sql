drop database db_jpa_jsf_livro;
create database db_jpa_jsf_livro;
use db_jpa_jsf_livro;

show tables;

create table automoveis(
	id int not null auto_increment,
	modelo varchar(50),
	ano_modelo integer,
	ano_fabricacao integer,
	marca varchar(50),
	observacoes text,
	constraint pk_automovel
		primary key(id)	
);