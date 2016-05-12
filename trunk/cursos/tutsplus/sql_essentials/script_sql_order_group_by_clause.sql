SELECT * FROM cases;

--retornando registro ordenando pelo campo de data
SELECT * FROM cases ORDER BY start_date;

--retornando registro ordenando pelo campo de data por ordem crescente
SELECT * FROM cases ORDER BY start_date ASC;
--retornando registro ordenando pelo campo de data por ordem decrescente
SELECT * FROM cases ORDER BY start_date DESC;

--retornando registro ordenando pelo campo criminal_id
SELECT * FROM cases ORDER BY criminal_id;
--retornando registro ordenando pelos campos criminal_id e data
SELECT * FROM cases ORDER BY criminal_id, start_date;
--retornando registro ordenando pelos campos criminal_id decrescente e data crescente
SELECT * FROM cases ORDER BY criminal_id DESC, start_date ASC;

--retornara os registros agrupados pelo id do detetive
--mas como pode haver varios registros com o mesmo id, precisamos agrupar estes registro com funcoes agrupadoras
SELECT detective_id, hours_to_solve FROM cases GROUP BY detective_id;
SELECT detective_id, hours_to_solve FROM cases ORDER BY detective_id;

--retornando o total de registro de acordo com aquele id 
SELECT detective_id, COUNT(hours_to_solve) FROM cases GROUP BY detective_id;
--retornando a soma do valor registro de acordo com aquele id 
SELECT detective_id, SUM(hours_to_solve) FROM cases GROUP BY detective_id;
--retornando a media do valor registro de acordo com aquele id
SELECT detective_id, AVG(hours_to_solve) FROM cases GROUP BY detective_id;
SELECT detective_id, AVG(hours_to_solve) AS avg_hours FROM cases GROUP BY detective_id ORDER BY avg_hours;