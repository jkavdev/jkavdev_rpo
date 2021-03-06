delete from categorisa where categoria_pai_id is not null;
delete from categorias;

alter table categorias auto_increment = 1;

insert into categorias (descricao) values ('Informática');
insert into categorias (descricao) values ('Eletrodomésticos');
insert into categorias (descricao) values ('Móveis');

insert into categorias (descricao, categoria_pai_id) values ('Computadores', 1);
insert into categorias (descricao, categoria_pai_id) values ('Notebooks', 1);
insert into categorias (descricao, categoria_pai_id) values ('Tablets', 1);
insert into categorias (descricao, categoria_pai_id) values ('Monitores', 1);
insert into categorias (descricao, categoria_pai_id) values ('Impressoras', 1);
insert into categorias (descricao, categoria_pai_id) values ('Acessórios', 1);

insert into categorias (descricao, categoria_pai_id) values ('Ar condicionados', 2);
insert into categorias (descricao, categoria_pai_id) values ('Fogões', 2);
insert into categorias (descricao, categoria_pai_id) values ('Fornos elétricos', 2);
insert into categorias (descricao, categoria_pai_id) values ('Microondas', 2);
insert into categorias (descricao, categoria_pai_id) values ('Refrigeradores', 2);

insert into categorias (descricao, categoria_pai_id) values ('Cadeiras', 3);
insert into categorias (descricao, categoria_pai_id) values ('Mesas', 3);
insert into categorias (descricao, categoria_pai_id) values ('Racks', 3);
insert into categorias (descricao, categoria_pai_id) values ('Sofás', 3);
