--renomeando o nome da tabela
ALTER TABLE investigations RENAME cases;

SELECT * FROM cases;

--adicionando coluna extra
ALTER TABLE cases ADD criminal varchar(100);

explain cases;
SELECT * FROM cases;

--removendo coluna
ALTER TABLE cases DROP criminal;

SELECT * FROM cases;

--alterando o nome da coluna
ALTER TABLE detectives CHANGE certificationDate certification_date date;

EXPLAIN detectives;
EXPLAIN cases;


--erro, auto_increment apenas para chaves primarias
ALTER TABLE cases ADD id int not null auto_increment

--adicionando id
ALTER TABLE cases ADD id int not null;

EXPLAIN cases;
SELECT * FROM cases;

--atribuindo o id criado como chave primaria da tabela
ALTER TABLE cases ADD PRIMARY KEY(id);

EXPLAIN cases;

--sobrescrevendo o atributo id para auto_increment
ALTER TABLE cases CHANGE id id int not null auto_increment;

EXPLAIN cases;
SELECT * FROM cases;

INSERT INTO cases(title, detective, days_to_solve) values
	("Another Case", "Luther King", 2);

SELECT * FROM cases;