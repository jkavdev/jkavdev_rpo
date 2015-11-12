
drop database db_cocodonto;

create database db_cocodonto;

use db_cocodonto;

CREATE TABLE PACIENTE (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(255),
    RG VARCHAR(20),
    CPF VARCHAR(20),
    SEXO VARCHAR(1),
    RESPONSAVEL_POR INT,
    dataCriacao DATE,
    CONSTRAINT fk_paciente_paciente FOREIGN KEY (responsavel_por)
        REFERENCES Paciente (id)
);

CREATE TABLE CONTATO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    EMAIL VARCHAR(255),
    TELEFONE VARCHAR(20),
    FAX VARCHAR(20),
    CELULAR VARCHAR(20)
);

CREATE TABLE PACIENTE_CONTATO (
    PACIENTE_ID INT,
    CONTATO_ID INT,
    CONSTRAINT fk_paciente_contato_paciente FOREIGN KEY (paciente_id)
        REFERENCES Paciente (id),
    CONSTRAINT fk_paciente_contato_contato FOREIGN KEY (contato_id)
        REFERENCES Contato (id)
);

CREATE TABLE ENDERECO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ENDERECO VARCHAR(255),
    CIDADE VARCHAR(255),
    CEP VARCHAR(20),
    BAIRRO VARCHAR(255)
);

CREATE TABLE PACIENTE_ENDERECO (
    PACIENTE_ID INT,
    ENDERECO_ID INT,
    CONSTRAINT fk_paciente_endereco_paciente FOREIGN KEY (paciente_id)
        REFERENCES Paciente (id),
    CONSTRAINT fk_paciente_endereco_endereco FOREIGN KEY (endereco_id)
        REFERENCES Endereco (id)
);

CREATE TABLE DENTISTA (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CRO VARCHAR(20),
    NOME VARCHAR(255),
    CPF VARCHAR(20)
);

CREATE TABLE DENTISTA_CONTATO (
    DENTISTA_ID INT,
    CONTATO_ID INT,
    CONSTRAINT fk_dentista_contato_dentista FOREIGN KEY (dentista_id)
        REFERENCES Dentista (id),
    CONSTRAINT fk_dentista_contato_contato FOREIGN KEY (contato_id)
        REFERENCES Contato (id)
);

CREATE TABLE DENTISTA_ENDERECO (
    DENTISTA_ID INT,
    ENDERECO_ID INT,
    CONSTRAINT fk_dentista_endereco_dentista FOREIGN KEY (endereco_id)
        REFERENCES Endereco (id),
    CONSTRAINT fk_dentista_endereco_endereco FOREIGN KEY (dentista_id)
        REFERENCES Dentista (id)
);

CREATE TABLE CONTRATO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    PACIENTE_ID INT,
    DENTISTA_ID INT,
    EM_NOME_DO_PACIENTE_ID INT,
    CONSTRAINT fk_contrato_paciente FOREIGN KEY (paciente_id)
        REFERENCES Paciente (id),
    CONSTRAINT fk_contrato_dentista FOREIGN KEY (dentista_id)
        REFERENCES Dentista (id),
    CONSTRAINT fk_contrato_paciente1 FOREIGN KEY (em_nome_do_paciente_id)
        REFERENCES Paciente (id)
);

CREATE TABLE PAGAMENTO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CONTRATO_ID INT,
    DATA_PAGAMENTO DATE,
    DATA_VENCIMENTO DATE,
    VALOR DOUBLE,
    JUROS DOUBLE,
    TIPO_JUROS VARCHAR(20),
    CONSTRAINT fk_pagamento_contrato FOREIGN KEY (contrato_id)
        REFERENCES Contrato (id)
);

CREATE TABLE CONSULTA (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    VALOR DOUBLE,
    DATACRIACAO DATE,
    DENTISTA_ID INT,
    PACIENTE_ID INT,
    CONSTRAINT fk_consulta_dentista FOREIGN KEY (dentista_id)
        REFERENCES Dentista (id),
    CONSTRAINT fk_consulta_paciente FOREIGN KEY (paciente_id)
        REFERENCES Paciente (id)
);

CREATE TABLE PROCEDIMENTO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(255),
    DESCRICAO VARCHAR(255),
    DATACRIACAO DATE
);

CREATE TABLE CONSULTA_PROCEDIMENTO (
    CONSULTA_ID INT,
    PROCEDIMENTO_ID INT,
    CONSTRAINT fk_consulta_procedimento FOREIGN KEY (consulta_id)
        REFERENCES Consulta (id),
    CONSTRAINT fk_consulta_procedimento1 FOREIGN KEY (procedimento_id)
        REFERENCES Procedimento (id)
);