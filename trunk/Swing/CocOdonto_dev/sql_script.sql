create database db_coc_odonto;

use db_coc_odonto;

drop table paciente;
drop table endereco;
CREATE TABLE paciente (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    rg VARCHAR(255),
    cpf VARCHAR(255),
    sexo VARCHAR(1),
    PRIMARY KEY (id)
);

CREATE TABLE ENDERECO (
    id INT NOT NULL AUTO_INCREMENT,
    endereco VARCHAR(255),
    cidade VARCHAR(255),
    cep VARCHAR(20),
    bairro VARCHAR(255),
    PRIMARY KEY (id)
);

show tables;

desc paciente;
desc endereco;
SELECT 
    *
FROM
    paciente;