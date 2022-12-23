drop table Pets if exists;


create table if not exists Pet (
  id identity,
  name varchar(25) not null,
  type varchar(25) not null,
  phone varchar(25) not null
);
