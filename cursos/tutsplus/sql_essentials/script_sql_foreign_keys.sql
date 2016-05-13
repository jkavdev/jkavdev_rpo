CREATE TABLE parent(
	id int,
	CONSTRAINT parent_pk 
		PRIMARY KEY(id)
);

--criando campo referenciando a outra tabela
CREATE TABLE child(
	parent int,
	CONSTRAINT parent_fk 
		FOREIGN KEY(parent) REFERENCES parent(id)
);

INSERT INTO parent VALUES(1), (2), (3);
INSERT INTO child VALUES(2), (3);

--ocorrera erro pois por padrao nao se pode 
--remover registros com referencias em outras tabelas
DELETE FROM parent WHERE id = 1;

DROP TABLE child;
DROP TABLE parent;

--criando a tabela para que quando a tabela que faz ligamento com esta
--remover algum registro esta tabela sera tambem atualizada removendo este registro
CREATE TABLE child(
	parent int,
	CONSTRAINT parent_fk 
		FOREIGN KEY(parent) REFERENCES parent(id)
		ON DELETE CASCADE	
);

--quando o registro for removido apenas atribui como null o valor
CREATE TABLE child(
	parent int,
	CONSTRAINT parent_fk 
		FOREIGN KEY(parent) REFERENCES parent(id)
		ON DELETE SET NULL	
);

--comportamanento padrao, nao deixa apagar
CREATE TABLE child(
	parent int,
	CONSTRAINT parent_fk 
		FOREIGN KEY(parent) REFERENCES parent(id)
		ON DELETE RESTRICT
);

--nao faz nada, aceita comportamento padrao
CREATE TABLE child(
	parent int,
	CONSTRAINT parent_fk 
		FOREIGN KEY(parent) REFERENCES parent(id)
		ON DELETE NO ACTION
);