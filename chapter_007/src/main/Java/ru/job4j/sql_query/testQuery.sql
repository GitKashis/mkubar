 CREATE TABLE company (
  id integer NOT NULL,
  name character varying,
  CONSTRAINT company_pkey PRIMARY KEY (id)
  );
CREATE TABLE person (
  id integer NOT NULL,
  name character varying,
  company_id integer,
  CONSTRAINT person_pkey PRIMARY KEY (id)
);
INSERT INTO company (id, name) VALUES (1, 'Лениздат');
INSERT INTO company (id, name) VALUES (2, 'Живая Классика');
INSERT INTO company (id, name) VALUES (3, 'Литературный след');
INSERT INTO company (id, name) VALUES (4, 'Союз литераторов');
INSERT INTO company (id, name) VALUES (5, 'Свежий взгляд');
--
INSERT INTO person (id, name, company_id) VALUES (1, 'Ахматова', 2);
INSERT INTO person (id, name, company_id) VALUES (2, 'Гумилев', 1);
INSERT INTO person (id, name, company_id) VALUES (3, 'Довлатов',3);
INSERT INTO person (id, name, company_id) VALUES (4, 'Есенин', 2);
INSERT INTO person (id, name, company_id) VALUES (5, 'Маяковский', 1);
INSERT INTO person (id, name, company_id) VALUES (6, 'Цветаева', 2);
INSERT INTO person (id, name, company_id) VALUES (7 ,'Блок', 4);
INSERT INTO person (id, name, company_id) VALUES (8, 'Мандельштам', 5);

 -- Names of all persons that are NOT in the company with id = 5

 SELECT p.name FROM person AS p
   INNER JOIN company AS c ON p.company_id = c.id
 WHERE c.id != 5;

 -- Company name for each person

 SELECT p.name, c.name FROM person AS p
   INNER JOIN company AS c ON p.company_id = c.id;

 -- Select the name of the company with the maximum number of persons + number of persons in this company

 SELECT c.name, count(*) as count, ARRAY_AGG(p.id) AS persons FROM person AS p
    INNER JOIN company AS c ON p.company_id = c.id
  GROUP BY c.name
  ORDER BY count(*) DESC LIMIT 1;
