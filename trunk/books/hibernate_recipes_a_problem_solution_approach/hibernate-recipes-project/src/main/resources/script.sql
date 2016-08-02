create table publisher(
	code varchar(4) not null,
	publisher_name varchar(100) not null,
	address varchar(200),
	primary key(code)
);

create table book(
	isbn varchar(50) not null,
	book_name varchar(100) not null,
	publisher_code varchar(4),
	publish_date date,
	price integer,
	primary key(isbn),
	foreign key(publisher_code) references publisher(code)
);

create table chapter(
	book_isbn varchar(50) not null,
	idx integer not null,
	title varchar(100) not null,
	num_of_pages integer,
	primary key(book_isbn, idx),
	foreign key(book_isbn) references book(isbn)
);

insert into PUBLISHER(code, publisher_name, address) values 
	('001', 'Apress', 'New York ,New York'),
	('002', 'Manning', 'San Francisco, California');
	
insert into book(isbn, book_name, publisher_code, publish_date, price) values 
	('PBN123', 'Spring Recipes', '001', DATE('2008-02-02'), 30),
	('PBN456', 'Hibernate Recipes', '002', DATE('2008-11-02'), 40); 