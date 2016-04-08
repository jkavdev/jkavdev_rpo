create database db_jpw_financeiro;
use db_jpw_financeiro;

insert into usuario(nome, login, senha, email, idioma, celular, ativo, dataNascimento) values
	('Jhonatan', 'jhonatan', '123', 'jhonatan@gmail.com', 'pt_BR', '92546554', 1, '1994/05/10'),
    ('Ismael', 'ismael', '123', 'ismael@gmail.com', 'en_US', '99346124', 0, '1995/05/10'),
    ('Eilane', 'eilane', '123', 'eilane@gmail.com', 'pt_BR', '96698554', 0, '1996/05/10'),
    ('Maria', 'maria', '123', 'maria@gmail.com', 'pt_BR', '99341254', 1, '1994/05/10'),
    ('Douglas', 'douglas', '123', 'douglas@gmail.com', 'en_US', '99123554', 1, '1999/05/10'),
    ('Lucas', 'lucas', '123', 'lucas@gmail.com', 'es_ES', '99487554', 1, '2000/05/10');