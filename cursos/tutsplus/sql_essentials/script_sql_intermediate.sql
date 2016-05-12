--campos do tipo texto
--varchar
create table person(
	name varchar(100)
);

--text, para textos muito grandes
create table email(
	body text
);

--campos do tipo numero
--int, integer, inteiros
create table person(
	age integer
);

--numeros com casas decimais
--decimal
--decimal(precision, scope)
--decimal(10, 0)
	--1234567890
--decimal(5, 2)
	--123.45
--decimal(8, 7)
	--9.7777777
CREATE TABLE student(
	avg_score decimal(6, 2)
);

--campos com o auto_increment
--se nao for dado um valor para o campo, por
--padrao sera elevado pro valor mais alto da coluna
--incrementado por 1
CREATE TABLE student(
	id integer auto_increment
);	

--datas e hora
--date - 'yyyy-mm-dd'
--time - '[h]hh:mm:ss'
--datetime - 'yyyy-mm-dd hh:mm:ss'
CREATE TABLE order(
	order_date date
);

--campos booleanos
--bool
--boolean - tinyint(1)
--0 e falso e nao-zero eh verdadeiro
CREATE TABLE order(
	fulfilled boolean
);

--campos com valores padrao
CREATE TABLE order(
	coupon varchar(10) default "nodicount",
	customer_id integer default null,
	datetime datetime default current_timestamp,
	fulfilled boolean not null default 0
);








