DROP DATABASE db_caelum_fj21_spring;
CREATE DATABASE db_caelum_spring;
USE db_caelum_spring;

CREATE TABLE tarefas (
	id BIGINT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255),
	finalizado BOOLEAN,
	dataFinalizacao DATE,
	PRIMARY KEY (id)
);

INSERT INTO contatos(nome, email, endereco, dataNascimento)
	VALUES
		('Finalizar Estudos', 0, '1994-04-05'),
        ('Futebol com os amigos', 1, '1994-01-05'),
        ('Chop no Buteco', 0, '1993-04-02'),
        ('Compra de roupas', 1, '1993-06-05'),
        ('Estudos na Faculdade', 0, '1993-08-05'),
        ('Chop em casa', 0, '1993-07-05'),
        ('Pizza no sábado', 1, '1993-06-05');