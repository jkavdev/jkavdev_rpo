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

--inserindo dados na tabela
--inserindo apenas um registro, com todos os valores da tabela
INSERT INTO investigations VALUES ("Finnigan's Fault", "Charlotta McOwen", 4);
--inserindo registro informando quais campos serao persistidos, obedecendo a ordens dos registros
INSERT INTO investigations(days_to_solve, title, detective) VALUES (5, "The Missing Tree", "Finch Hosky");
--inserindo registro informando titulo e detetive
INSERT INTO investigations(title, detective) VALUES ("A Case of Allergies", "Carson Andrews");
--inserindo varios registro em apenas um comando
INSERT INTO investigations(days_to_solve, title, detective) VALUES 
	(1, "The Night of Crimes", "Kirk James"),
	(8, "Murderer of Chong", "Bradd Stone"),
	(4, "Killing New York People", "Michael Douglas");



