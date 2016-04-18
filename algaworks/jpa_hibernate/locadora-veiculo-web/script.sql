drop database db_locadora;
create database db_locadora;
use db_locadora;

show tables;

desc acessorio;
insert into acessorio(descricao) values
	('Ar Condicionado'),
	('Rodas Liga Leve'),
	('Freio a Disco'),
	('Cambio Automatico'),
	('Portas e Vidros Eletricos');
    
desc fabricante;
insert into fabricante(nome) values
	('Fiat'),
	('Volkswagem'),
	('Ford'),
	('Chevrolet'),
	('Citroen'), 
	('Honda'), 
	('Hyundai'), 
	('JAC Motors'),
	('Nissan'), 
	('Peugeot'), 
	('Renault'),
	('Suzuki'), 
	('Toyota'), 
	('Volvo');
	
desc modelo_carro;
insert into modelo_carro values 
	(1,'HATCH_COMPACTO','Punto',1),
	(2,'HATCH_COMPACTO','Uno',1),
	(3,'HATCH_COMPACTO','Palio',1),
	(4,'SEDAN_GRANDE','Siena',1),
	(5,'HATCH_MEDIO','Gol G6',2),
	(6,'HATCH_MEDIO','G5',2),
	(7,'SEDAN_GRANDE','Jetta',2),
	(8,'SEDAN_COMPACTO','Polo',2),
	(9,'UTILITARIO_COMERCIAL','Amarok',2),
	(10,'SEDAN_GRANDE','Fusion',3),
	(11,'HATCH_COMPACTO','Fiesta',3),
	(12,'HATCH_MEDIO','Focus',3),
	(13,'ESPORTIVO','Mustang',3),
	(14,'HATCH_MEDIO','Onix',4),
	(15,'HATCH_MEDIO','Corsa',4),
	(16,'SEDAN_GRANDE','Vectra',4),
	(17,'SEDAN_GRANDE','C4 Pallas',5),
	(18,'SEDAN_GRANDE','C4 Picasso',5),
	(19,'MINIVAN','XSara Picasso',5),
	(20,'SEDAN_GRANDE','Civic',6),
	(21,'HATCH_MEDIO','City',6),
	(22,'HATCH_COMPACTO','Fit',6),
	(23,'SEDAN_GRANDE','Sonata',7),
	(24,'HATCH_MEDIO','I20',7),
	(25,'UTILITARIO_COMERCIAL','Tucson',7);

desc aluguel;
insert into aluguel values 
	(1,'2016-04-26 00:40:00','2016-04-22 11:00:00','2016-04-18',5584.00,1,1,4);

desc apolice_seguro;
insert into apolice_seguro values 
	(1,0,0,1,2563.00);

desc carro;
insert into carro values 
	(1,NULL,'Vermelho','2016-04-18 18:07:45','2016-04-18 18:07:45','SSD-5562',55.00,1),
	(2,NULL,'Vermelho','2016-04-18 18:07:56','2016-04-18 18:07:56','IID-5589',996.00,2),
	(3,NULL,'Azul','2016-04-18 18:08:17','2016-04-18 18:08:17','DDS-8889',1123.00,3),
	(4,NULL,'Vermelho','2016-04-18 18:08:38','2016-04-18 18:08:38','LOA-5584',55.00,4),
	(5,NULL,'Amarelo','2016-04-18 18:09:07','2016-04-18 18:09:07','OOK-5554',854.00,5),
	(6,NULL,'Branco','2016-04-18 18:09:49','2016-04-18 18:09:49','OIA-8854',854.00,7),
	(7,NULL,'Preto','2016-04-18 18:13:30','2016-04-18 18:13:30','OIJ-5478',5548.00,13);

desc carro_acessorio;
insert into carro_acessorio values (1,1),(1,2),(1,3),(2,1),(2,2),(2,4),(3,1),(3,2),(3,3),(3,4),(3,5),(4,1),(4,2),(4,3),(4,4),(5,1),(5,2),(5,3),(5,4),(5,5),(6,1),(6,2),(6,3),(7,1),(7,2),(7,3),(7,4),(7,5);

desc funcionario;
insert into funcionario values
	('11235',1),
	('55456',2),
	('66598',3);
	('223545',9);
	('221345',10);

desc motorista;
insert into motorista values 
	('225545',4);
	('221445',5);
	('223245',6);
	('225512',7);
	('225135',8);
	
desc pessoa;
insert into pessoa (codigo, cpf, data_nascimento, nome, sexo) values
	(1,'04488533621','2016-04-21','Mario Andrade','MASCULINO'),
	(2,'04488531151','2016-04-14','Marcos Lima','MASCULINO'),
	(3,'25438533621','2011-04-24','Fernanda Costa','FEMININO'),
	(4,'11288533633','2012-08-18','Luis Carlos','MASCULINO');
	(5,'02588533621','2013-04-21','Marcio Ximura','MASCULINO'),
	(6,'04436531151','2014-04-14','Fernando Kiss','MASCULINO'),
	(7,'25412533621','2015-04-24','Jhonatan Matos','FEMININO'),
	(8,'1128826633','2013-08-18','Daniel Carlos','MASCULINO');
	(9,'0448153621','2011-04-21','Marlos Sombra','MASCULINO'),
	(10,'04488231151','2014-06-14','Liu Moss','MASCULINO'),
	(11,'25438353621','2016-07-24','David Santos','FEMININO'),
	(12,'11288153633','2016-09-18','Ricardo Santos','MASCULINO');