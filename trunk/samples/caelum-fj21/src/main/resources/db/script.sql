DROP DATABASE db_caelum_fj21;
CREATE DATABASE db_caelum_fj21;
USE db_caelum_fj21;

CREATE TABLE contatos (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	endereco VARCHAR(255),
	dataNascimento DATE,
	PRIMARY KEY (id)
);

CREATE TABLE funcionarios (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	senha VARCHAR(255),
	usuario VARCHAR(255),
	PRIMARY KEY (id)
);

INSERT INTO contatos(nome, email, endereco, dataNascimento)
	VALUES
		('Jhonatan', 'jhonatan@gmail.com', 'QR 12 CASA 15', '1994-04-05'),
        ('Marcos', null, 'QR 15 CASA 03', '1994-04-05'),
        ('Douglas', 'douglas@gmail.com', 'QR 12 CASA 15', '1993-04-05'),
        ('Ismael', 'ismael@gmail.com', 'QR 15 CASA 15', '1992-04-05'),
        ('Lucas', null, 'QR 12 CASA 15', '1997-04-05'),
        ('Eilane', 'eilane@gmail.com', 'QR 15 CASA 15', '1998-04-05'),
        ('Celina', 'celina@gmail.com', 'QR 5 CASA 6', '1999-04-05'),
        ('Jadvan', null, 'QR 5 CASA 6', '1998-04-05'),
        ('Clarine', 'clarine@gmail.com', 'QR 5 CASA 6', '1999-04-05');