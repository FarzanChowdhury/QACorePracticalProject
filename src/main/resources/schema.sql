create database if not exists spring;
use spring;
create table cat (id integer auto_increment, age integer, name varchar(255), breed varchar(255), primary key (id));

insert into cat (age, breed, name) values (12, 'Persian', 'John');
insert into cat (age, breed, name) values (5, 'Bengal', 'Jimmy');

select * from cat;

