--script de criação do banco de dados
DROP DATABASE intrepid_detective;
CREATE DATABASE intrepid_detective;
USE intrepid_detective;

CREATE TABLE detectives(
	id integer not null auto_increment,
	first_name varchar(50),
	last_name varchar(50) not null,
	phone_number varchar(10) not null,
	certification_date date not null,
	CONSTRAINT detectives_pk PRIMARY KEY(id)
);

CREATE TABLE criminals(
	id integer not null auto_increment,
	first_name varchar(50),
	last_name varchar(50) not null,
	date_of_birth date not null,
	CONSTRAINT criminals_pk PRIMARY KEY(id)
);

--casos tera uma referencia para detetive e um criminoso
CREATE TABLE cases(
	id integer not null auto_increment,
	detective_id integer not null,
	criminal_id integer not null,
	title varchar(50),
	start_date date not null,
	hours_to_solve int,	
	CONSTRAINT cases_pk PRIMARY KEY(id),
	CONSTRAINT detective_fk  FOREIGN KEY(detective_id) REFERENCES detectives(id),
	CONSTRAINT criminal_fk  FOREIGN KEY(criminal_id) REFERENCES criminals(id)	
);

INSERT INTO detectives
	VALUES(1, "Calotta", "McOwen", "321654817", "2004-04-05");
INSERT INTO detectives
	VALUES(2, "Luther", "Ellery", "321218712", "1995-11-20");
INSERT INTO detectives
	VALUES(3, "Finch", "Hosky", "325454487", "2010-07-18");
INSERT INTO detectives
	VALUES(4, "Carson", "Andrews", "321512187", "2009-01-31");
INSERT INTO detectives
	VALUES(5, "Mac", "Parker", "323652157", "1998-05-25");
INSERT INTO detectives
	VALUES(6, "", "Barney", "321654871", "2001-04-08");
	
INSERT INTO criminals
	VALUES(1, "Jim", "Roberts","1970-12-12");
INSERT INTO criminals
	VALUES(2, "Alec", "Ivanes", "1984-10-03");
INSERT INTO criminals
	VALUES(3, "Garland", "Ernest", "1989-03-14");
INSERT INTO criminals
	VALUES(4, "Luke", "Malcom", "1992-07-28");
INSERT INTO criminals
	VALUES(5, "Tyrell", "Preston", "1978-09-13");

INSERT INTO cases
	VALUES(1, 1, 1, "Finnigan's Fault", "2008-09-26", 24 * 4);
INSERT INTO cases
	VALUES(2, 2, 3, "The Missing Tree", "2006-12-30", 24 * 2);
INSERT INTO cases
	VALUES(3, 3, 2, "A Case of Allergies", "2004-03-12", 24 * 2.5);
INSERT INTO cases
	VALUES(4, 4, 5, "Digital Nightmare", "2001-09-12", 300);
INSERT INTO cases
	VALUES(5, 2, 4, "The Shouldn't have been", "2010-10-10", 23);
INSERT INTO cases
	VALUES(6, 1, 3, "Evidentially Frozen", "2008-07-07", 240);
INSERT INTO cases
	VALUES(7, 5, 2, "The Other Car", "2004-11-12", 489);
INSERT INTO cases
	VALUES(8, 5, 5, "Valentine's Dagger", "2011-02-14", 29);
INSERT INTO cases
	VALUES(9, 3, 1, "All Three Hats", "2002-08-15", 340);