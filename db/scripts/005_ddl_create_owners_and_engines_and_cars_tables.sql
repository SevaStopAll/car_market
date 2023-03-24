create table owners(
    id serial primary key
);

create table engines(
    id serial primary key
);

create table cars(
    id serial primary key,
    engine_id int not null unique references engines(id),
    owner_id int not null references owners(id)
);
