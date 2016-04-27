drop database db_mysql_world;
create database db_mysql_world;
use db_mysql_world;

show tables;

desc city;
select * from city;
desc country;
select * from country;
desc country_language;
select * from country_language;
desc hibernate_sequence;

select ci.name, co.name 
	from city ci
	inner join country co
    on ci.country_Code = co.id;
    
select * from city
	where country_code = 1;