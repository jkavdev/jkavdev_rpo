--renomeando o nome da tabela
ALTER TABLE investigations RENAME cases;

SELECT * FROM cases;

--adicionando uma coluna 
ALTER TABLE cases ADD criminal varchar(100);

explain cases;
SELECT * FROM cases;

--removendo uma coluna
ALTER TABLE cases DROP criminal;

SELECT * FROM cases;

--alterando o nome de uma coluna
ALTER TABLE detectives CHANGE certificationDate certification_date date;

EXPLAIN detectives;

--adicionando id para a tabela, ocorrera erro pois id nao eh chave primaria
--erro, auto_increment apenas para chaves primarias
ALTER TABLE cases ADD id int not null auto_increment

--para resolver, adicionar o campo id
ALTER TABLE cases ADD id int not null;

EXPLAIN cases;
SELECT * FROM cases;

--para que id seja uma chave primaria seu campo deve ser diferente dos demais registros
--alterando valor do id, pois quando criado iniciou com zero
INSERT INTO cases(id) VALUES(1, 2, 3, 4);

--adicionando chave primaria de acordo com o id que adicionamos
ALTER TABLE cases ADD PRIMARY KEY(id);

EXPLAIN cases;

--tornando a chave primaria auto incrementavel
ALTER TABLE cases CHANGE id id int not null auto_increment;

SELECT * FROM cases;

INSERT INTO cases(title, detective, days_to_solve) VALUES
	('Another Case', "Luther King", 2);

SELECT * FROM cases;








