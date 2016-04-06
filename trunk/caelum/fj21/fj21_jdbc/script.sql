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

insert into contato(nome, email, endereco, data_nascimento)
	values
		('Jhonatan', 'jhonatan@gmail.com', 'QR 12 CASA 15', '1994-04-05'),
        ('Marcos', null, 'QR 15 CASA 03', '1994-04-05'),
        ('Douglas', 'douglas@gmail.com', 'QR 12 CASA 15', '1993-04-05'),
        ('Ismael', 'ismael@gmail.com', 'QR 15 CASA 15', '1992-04-05'),
        ('Lucas', null, 'QR 12 CASA 15', '1997-04-05'),
        ('Eilane', 'eilane@gmail.com', 'QR 15 CASA 15', '1998-04-05'),
        ('Celina', 'celina@gmail.com', 'QR 5 CASA 6', '1999-04-05'),
        ('Jadvan', null, 'QR 5 CASA 6', '1998-04-05'),
        ('Clarine', 'clarine@gmail.com', 'QR 5 CASA 6', '1999-04-05');