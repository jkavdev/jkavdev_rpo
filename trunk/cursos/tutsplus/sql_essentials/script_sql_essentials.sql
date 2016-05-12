 --criando um banco de dados
CREATE DATABASE intrepid_detectives;

--usando banco criado
USE intrepid_detectives;

--listando todas as tabelas de um banco
SHOW TABLES;

--criando uma tabela
--informando o nome e tipo da coluna
CREATE TABLE investigations(
	title varchar(100),
	detective varchar(30),
	days_to_solve integer
);

--mostrando detalhes da tabela criada
EXPLAIN investigations;
DESCRIBE investigations;
DESC investigations;



