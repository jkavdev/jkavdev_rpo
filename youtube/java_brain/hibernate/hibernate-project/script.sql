--criando o banco
CREATE DATABASE db_java_brains_hibernate
  WITH ENCODING='UTF8'
       OWNER=postgres
       CONNECTION LIMIT=-1;

--tabela usuario criada       
CREATE TABLE public.userdetails
(
  userid integer NOT NULL,
  username character varying(255),
  CONSTRAINT userdetails_pkey PRIMARY KEY (userid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.userdetails
  OWNER TO postgres;

select * from userdetails;