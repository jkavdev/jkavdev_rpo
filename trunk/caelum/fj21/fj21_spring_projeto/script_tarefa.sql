create database db_fj21_spring_tarefas;
use db_fj21_spring_tarefas;

CREATE TABLE tarefas (
	id BIGINT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255),
	finalizado BOOLEAN,
	dataFinalizacao DATE,
	PRIMARY KEY (id)
);