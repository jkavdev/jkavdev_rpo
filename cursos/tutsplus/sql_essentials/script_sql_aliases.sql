SELECT title, hours_to_solve cases;
--usando um alias para mudar o nome da coluna
SELECT title, hours_to_solve AS time 
	FROM cases;

--usando a funcao concat para concatenar o primeiro e segundo nome com um espaco entre eles	
SELECT CONCAT(first_name, " ", last_name) 
	FROM detectives;
SELECT CONCAT(first_name, " ", last_name) AS name 
	FROM detectives;

--retorna erro, pois nao sabe de qual tabela retornar os registros pois nas duas tabelas existem a mesma linha	
SELECT first_name 
	FROM detectives
	CROSS JOIN criminals;
	
--usando um alias para identificar qual coluna sera retornada
SELECT detectives.first_name 
	FROM detectives
	CROSS JOIN criminals;
	
--usando um alias para as tabelas	
SELECT d.first_name 
	FROM detectives AS d
	CROSS JOIN criminals;
	
SELECT d.first_name, d.last_name,
	c.first_name, c.last_name, title
	FROM detectives AS d
	CROSS JOIN criminals AS c
	CROSS JOIN cases
	WHERE d.id = detective_id AND c.id = criminal_id;
	
SELECT d.first_name AS dec_first_name, d.last_name AS dec_last_name,
	c.first_name AS cri_first_name, c.last_name AS cri_last_name, title AS case_title
	FROM detectives AS d
	CROSS JOIN criminals AS c
	CROSS JOIN cases
	WHERE d.id = detective_id AND c.id = criminal_id;
	
SELECT concat(d.first_name, " ", d.last_name) AS "Detective's Name",
	concat(c.first_name, " ", c.last_name) AS "Criminals' Name", title AS case_title
	FROM detectives AS d
	CROSS JOIN criminals AS c
	CROSS JOIN cases
	WHERE d.id = detective_id AND c.id = criminal_id;