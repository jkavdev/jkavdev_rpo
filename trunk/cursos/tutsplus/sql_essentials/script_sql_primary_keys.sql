--trabalhando com chaves primarias
--chaves primarias nao podem ser modificadas
--toda tabela deve ter uma
--identifica unicamente uma linha
--nao pode ser nula
--e atribuida quando inserido algum registro
CREATE TABLE detectives(
	id int not null auto_increment,
	name varchar(100),
	phone_number varchar(10),
	certificationDate date,
	CONSTRAINT detectives_pk PRIMARY KEY(id)
);

EXPLAIN detectives;

--inserindo registro qual quando nao especificado a chave primaria obtera o maior numero entre os ids
INSERT INTO detectives(name, phone_number, certificationDate) VALUES
	("Carlotta McOwen", "1234567890", "2002-02-23"),
	("Finch Hosky", "9876543210", "1995-06-18");

--inserindo registro especificando uma chave primaria
INSERT INTO detectives VALUES
	(5, "Luther Ellenor", "3216547982", "1997-01-25");

SELECT * FROM detectives;