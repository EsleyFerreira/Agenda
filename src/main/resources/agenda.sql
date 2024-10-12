create table contacts
(
    id                int not null auto_increment primary key,
    name              varchar(50),
    age               int,
    registration_date date
);

select * from agenda.contacts;

drop table contacts;