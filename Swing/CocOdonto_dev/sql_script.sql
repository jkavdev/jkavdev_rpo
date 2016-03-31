create database db_coc_odonto;
drop database db_coc_odonto;

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

CREATE TABLE endereco (
    id INT NOT NULL AUTO_INCREMENT,
    endereco VARCHAR(255),
    cidade VARCHAR(255),
    cep VARCHAR(20),
    bairro VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE contato (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    telefone VARCHAR(255),
    celular VARCHAR(20),
    fax VARCHAR(255),
    PRIMARY KEY (id)
);

create table paciente_endereco(
	paciente_id int not null,
    endereco_id int not null,
    foreign key(paciente_id) references Paciente(id),
    foreign key(endereco_id) references Endereco(id)
);

create table paciente_contato(
	paciente_id int not null,
    contato_id int not null,
    foreign key(paciente_id) references Paciente(id),
    foreign key(contato_id) references Contato(id)
);

show tables;

desc paciente;
desc endereco;
desc contato;
desc paciente_contato;
desc paciente_endereco;

select * from paciente;
select * from paciente_endereco;
select * from paciente_contato;
select * from endereco;
select * from contato;