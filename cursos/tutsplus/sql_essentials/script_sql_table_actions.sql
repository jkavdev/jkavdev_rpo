alter table investigations rename cases;

select * from cases;

alter table cases add criminal varchar(100);

explain cases;

select * from cases;

alter table cases drop criminal;

select * from cases;

alter table detectives change certificationDate certification_date date;

explain detectives;

--erro, auto_increment apenas para chaves primarias
alter table cases add id into not null auto_increment