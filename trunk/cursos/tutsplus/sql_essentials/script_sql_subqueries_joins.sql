--retornando os casos da detetive calotta
SELECT 
	* FROM cases 
	WHERE detective_id = 
		(SELECT id FROM detectives WHERE first_name = "Calotta") --1;
--retornando o id da calotta	
SELECT id 
	FROM detectives 
	WHERE first_name = "Calotta" --= 1

--retornando os casos com telefone do detetive comecando com...
SELECT title 
	FROM cases 
	WHERE detective_id 
		IN(SELECT id FROM detectives WHERE phone_number LIKE '325%');

--retornando os registros dos detetives no qual tiveram um caso com Jim	
SELECT first_name, last_name 
	FROM detectives, cases 
	WHERE detectives.id = detective_id 
	AND criminal_id 
		IN(SELECT id FROM criminals WHERE first_name = "Jim");
	
SELECT * 
	FROM cases;

--inserindo registro copiando dados do registro id = 3
INSERT INTO cases 
	SELECT 10, detective_id, criminal_id, 'Stale Gun', start_date, hours_to_solve 
		FROM cases
	WHERE id = 3;

SELECT * 
	FROM cases;

SELECT first_name, last_name 
	FROM detectives;

SELECT first_name, last_name 
	FROM criminals;

--retornado a uniaos dos registro de detetives e criminosos
SELECT first_name, last_name 
	FROM detectives 
	UNION 
	SELECT first_name, last_name 
		FROM criminals;

--retornado a uniaos dos registro de detetives e criminosos, e ordenando pelo primeiro nome
SELECT first_name, last_name 
	FROM detectives 
	UNION 
	SELECT first_name, last_name 
		FROM criminals 
	ORDER BY first_name;

--retornado a uniaos dos registro de detetives e criminosos, e ordenando pelo sobrenome
SELECT first_name, last_name 
	FROM detectives 
	UNION 
	SELECT first_name, last_name 
		FROM criminals 
	ORDER BY last_name DESC;

--nao sera retornado, pois total de colunas devem corresponder entre si
SELECT * FROM detectives 
	UNION 
SELECT * FROM criminals;


--retornara registros repetidos, 
--como as tabelas sao diferentes, o sql fara uma busca de um registro eum tabela para cada registro da outra tabela
SELECT * 
	FROM cases, detectives;

SELECT * 
	FROM cases 
	CROSS JOIN detectives;

SELECT * 
	FROM cases 
	INNER JOIN detectives;

SELECT first_name 
	FROM cases 
	CROSS JOIN detectives;

--colunas iguais nas tabelas, erro
SELECT id 
	FROM cases 
	CROSS JOIN detectives;

SELECT cases.id 
	FROM cases 
	CROSS JOIN detectives;

--retornando detetives e criminosos em comum
SELECT detectives.last_name, criminals.last_name 
	FROM detectives 
	CROSS JOIN criminals 
	CROSS JOIN cases 
		WHERE cases.criminal_id = criminals.id AND cases.detective_id = detectives.id;
	
SELECT first_name, last_name, hours_to_solve 
	FROM criminals
	CROSS JOIN cases 
		WHERE criminals.id = criminal_id AND hours_to_solve > 90;
	
SELECT first_name, last_name, hours_to_solve 
	FROM criminals
	CROSS JOIN cases 
		WHERE criminals.id = criminal_id AND hours_to_solve > 90 
	ORDER BY hours_to_solve;	

SELECT first_name, last_name, hours_to_solve 
	FROM criminals
	INNER JOIN cases 
		ON criminals.id = criminal_id AND hours_to_solve > 90;
	
SELECT first_name, last_name, hours_to_solve 
	FROM criminals
	INNER JOIN cases 
		ON criminals.id = criminal_id;

SELECT first_name, last_name, sum(hours_to_solve) 
	FROM criminals
	INNER JOIN cases 
		ON criminals.id = criminal_id 
		WHERE hours_to_solve > 90
	GROUP BY first_name;