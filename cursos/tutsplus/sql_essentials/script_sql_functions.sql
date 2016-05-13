--concatenando os campos com concat
SELECT concat(first_name, " ", last_name) 
	FROM criminals;

--todos os detetives com telefone... 
SELECT count(*) 
	FROM detectives 
	WHERE phone_number LIKE "323%";

--podemos selecionar um literal, constante	
SELECT 317 AS area_code, count(*) AS count 
	FROM detectives 
	WHERE phone_number LIKE "323%";
	
--total de titulo de acordo com um detetive	
SELECT count(title) AS titles
	FROM cases
	WHERE detective_id = 2;
	
--usando funcao do mysql	
INSERT INTO detectives(first_name, last_name, certification_date, phone_number)
	VALUES("Joe", "Smith", curdate(), "99346554");

--retornado os registros e uma data de fim a partir da data_inicio	
SELECT title, start_date, date_add(start_date, interval hours_to_solve hour) AS end_datetime
	FROM cases;
	
--maior tempo	
SELECT max(hours_to_solve) 
	FROM cases;
--menor tempo
SELECT min(hours_to_solve) 
	FROM cases;

--o resultado nao condiz, pois select title apenas retornara o primeiro resultado
SELECT title, MAX(hours_to_solve) FROM cases;
SELECT title, MIN(hours_to_solve) FROM cases;

--para isso podemos usar o order by limitando a consulta, max hours_to_solve, 
SELECT * 
	FROM cases 
	ORDER BY hours_to_solve DESC limit 1;
	
--total de horas dos casos
SELECT SUM(hours_to_solve) 
	FROM cases;
	
--retornando o resultado em formato de dias	
SELECT SUM(hours_to_solve) / 24 AS days 
	FROM cases;	

--retornando apenas o valor da coluna sem formataçao	
select DATE_ADD(start_date, INTERVAL hours_to_solve HOUR)
	from cases;

--transformando o resultado da consulta em um date	
SELECT CAST(DATE_ADD(start_date, INTERVAL hours_to_solve HOUR) AS DATE) AS end_date
	FROM cases;

SELECT title, start_date, CAST(DATE_ADD(start_date, INTERVAL hours_to_solve HOUR) AS DATE) AS end_date
	FROM cases;