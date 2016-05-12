SELECT * FROM cases;
SELECT title FROM cases;
--retornando registro com titulo "The Missing Tree"
SELECT * FROM cases WHERE title = "The Missing Tree";

--retornando registro de acordo com o id 
SELECT * FROM detectives WHERE id = 3;

--retornando registro diferente do id 
SELECT * FROM cases WHERE detective_id != 2;	
SELECT * FROM cases WHERE detective_id <> 2;

--retornando registro de acordo com uma data data
SELECT * FROM cases WHERE start_date < '2005-01-01';	
SELECT * FROM cases WHERE start_date > '2005-01-01';

--retornando registro de acordo com horas para resolver
SELECT * FROM cases WHERE hours_to_solve > 60;
--retornando registro de acordo parametros passados e trabalhando com operadores logicos
SELECT * FROM cases WHERE hours_to_solve < 24 AND detective_id = 2;
SELECT * FROM cases WHERE detective_id = 1 OR detective_id = 2;

--retornando registros de acordo com parametros passados no in
SELECT * FROM cases WHERE detective_id IN(1, 2);

--retornando registro entre os valores passados
SELECT * FROM cases WHERE hours_to_solve BETWEEN 24 AND 60;

--retornando registro que começem com a letra 'C'
SELECT * FROM detectives WHERE first_name LIKE "C%";
--retornando registro que começem com a letra '321'
SELECT * FROM detectives WHERE phone_number LIKE "321%";
--retornando registro que não começem com a letra 'C'
SELECT * FROM detectives WHERE phone_number NOT LIKE "321%";
	
SELECT * FROM cases;

--alterando um registro especifico
UPDATE cases SET title = "The Man That Wasn't" WHERE title = "The Shouldn't have been";

SELECT * FROM cases;

--deletando um registro especifico
DELETE FROM cases WHERE id = 4;

SELECT * FROM cases;