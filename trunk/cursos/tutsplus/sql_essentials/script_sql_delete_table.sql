SHOW TABLES;

CREATE TABLE criminals(
	name varchar(50)
);

INSERT INTO criminals VALUES
	("moriarty"),
	("cruella"),

SELECT * FROM criminals;

--removera todos os dados da tabela
DELETE FROM criminals;

--apagara a tabela
DROP TABLE criminals;