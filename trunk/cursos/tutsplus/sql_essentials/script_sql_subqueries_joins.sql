select * from cases where detective_id = 
	(select id from detectives where first_name = "Calotta") --1;
	
select id from detectives where first_name = "Calotta" --= 1

select title from cases where detective_id 
	in(select id from detectives where phone_number like '325%');
	
select first_name, last_name from detectives, cases where detectives.id = detective_id and
	criminal_id in(select id from criminals where first_name = "Jim");
	
select * from cases;

insert into cases select 10, detective_id, criminal_id, 'Stale Gun', start_date, hours_to_solve from cases
	where id = 3;

select * from cases;

select first_name, last_name from detectives;
select first_name, last_name from criminals;
select first_name, last_name from detectives union select first_name, last_name from criminals;
select first_name, last_name from detectives union select first_name, last_name from criminals order by first_name;
select first_name, last_name from detectives union select first_name, last_name from criminals order by first_name desc;
select * from detectives union select * from criminals;
select * from detectives, cases;
select * from detectives cross join cases;
select * from detectives inner join cases;
select first_name from detectives cross join cases;
select id from detectives cross join cases;