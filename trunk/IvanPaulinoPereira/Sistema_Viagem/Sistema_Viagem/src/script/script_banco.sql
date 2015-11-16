create database db_transporte;

use db_transporte;

create table usuario(
	id int not null auto_increment,
	nome varchar(45),
	login varchar(45),
	senha varchar(45),
	primary key(id)
);

create table veiculo(
	id int not null auto_increment,
	marca varchar(45),
	modelo varchar(45),
	placa varchar(45),
	primary key(id)
);

create table passageiro(
	id int not null auto_increment,
	nome varchar(45),
	cpf varchar(45),
	rg varchar(45),
	telefone varchar(45),
	primary key(id)
);

create table viagem(
	id int not null auto_increment,
	dataViagem date,
	horaPartida time,
	origem varchar(45),
	destino varchar(45),
	idVeiculo int,
	constraint pk_viagem 
		primary key(id),
	constraint fk_veiculo
		foreign key(idVeiculo) references veiculo(id)
);

create table passageiro_viagem(
	idPassageiro int not null,
	idViagem int not null,
	constraint pk_passageiro_viagem 
		primary key(idPassageiro, idViagem),
	constraint fk_passageiro
		foreign key(idPassageiro) references passageiro(id),
	constraint fk_viagem
		foreign key(idViagem) references viagem(id)
);
