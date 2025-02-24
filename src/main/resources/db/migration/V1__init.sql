CREATE TABLE profissional (
 id integer CONSTRAINT pk_id PRIMARY KEY,
 nome varchar(50) NULL, 
 nascimento date NULL,
 created_date date
);

CREATE TABLE contato (
 id integer CONSTRAINT pk_id PRIMARY KEY,
 nome varchar(50) NULL,
 contato varchar(50) NULL, 
 created_date date,
 profissional_id integer NOT NULL
);