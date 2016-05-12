SELECT * FROM cases;

--alterando coluna
ALTER TABLE cases change days_to_solve hours_to_solve int;

--alterando os valores da coluna
UPDATE cases SET hours_to_solve = hours_to_solve * 24;