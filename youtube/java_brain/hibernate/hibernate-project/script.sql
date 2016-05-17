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

--tabela criada sem especifica os tamanhos e tipos dos campos
CREATE TABLE public.user_details
(
  user_id integer NOT NULL,
  address character varying(255),
  description character varying(255),
  joineddate timestamp without time zone,
  user_name character varying(255),
  CONSTRAINT user_details_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_details
  OWNER TO postgres;