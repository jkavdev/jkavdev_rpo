SELECT * FROM cases LIMIT 5;

--retornando todos registro maior que e data informada
SELECT * FROM cases WHERE start_date > '2005-01-01';

--retornando apenas 2 registros maior que e data informada
SELECT * FROM cases WHERE start_date > '2005-01-01' LIMIT 2;

--offset apresentara apenas os dados depois do espeificado
SELECT * FROM cases WHERE start_date > '2005-01-01' LIMIT 2 OFFSET 3;

SELECT detective_id FROM cases;

--retornara apenas registros com valores distintos
SELECT DISTINCT detective_id FROM cases;

--retornara apenas registros com valores distintos
--com adicao da clausula where
SELECT DISTINCT detective_id FROM cases WHERE hours_to_solve > 50;

--retorna registro de acordo com o id informado
SELECT hours_to_solve FROM cases WHERE detective_id > 2;
