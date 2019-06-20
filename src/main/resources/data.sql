-- PERSON TABLE

-- Commenting the below because JPA automatically creates the table for us
-- create table PERSON
-- (
   -- id integer not null,
   -- name varchar(255) not null,
   -- location varchar(255),
   -- birth_date timestamp,
   -- primary key (id)
-- );

insert into PERSON (id, name, location, birth_date) values (10001, 'av8242n','london',sysdate());
insert into PERSON (id, name, location, birth_date) values (10002, 'elsa','winter',sysdate());
insert into PERSON (id, name, location, birth_date) values (10003, 'anna','spring',sysdate());
insert into PERSON (id, name, location, birth_date) values (10004, 'olaf','summer',sysdate());
