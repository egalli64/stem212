DROP TABLE IF EXISTS CONTACT;

create table CONTACT(
	contact_id serial primary key,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	phone varchar(20) not null unique
);

insert into contact(first_name, last_name, phone) values('Mario', 'Rossi', '+3928361836481');