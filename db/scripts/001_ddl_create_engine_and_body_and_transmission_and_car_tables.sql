CREATE TABLE IF NOT EXISTS engine
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is 'Таблица с двигателями';
comment on column engine.id is 'Идентификатор';
comment on column engine.name is 'Название';

CREATE TABLE IF NOT EXISTS body
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is 'Таблица с типами кузова';
comment on column engine.id is 'Идентификатор';
comment on column engine.name is 'Название';

CREATE TABLE IF NOT EXISTS transmission
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is 'Таблица с типами трансмиссии';
comment on column engine.id is 'Идентификатор';
comment on column engine.name is 'Название';

CREATE TABLE IF NOT EXISTS car
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL,
    created   TIMESTAMP NOT NULL,
    engine_id INT       NOT NULL REFERENCES engine (id),
    body_id INT NOT NULL REFERENCES body(id),
    transmission_id INT NOT NULL REFERENCES transmission(id)
);

comment on table car is 'Таблица с автомобилями';
comment on column car.id is 'Идентификатор';
comment on column car.name is 'Название';
comment on column car.engine_id is 'Идентификатор двигателя';
comment on column car.body_id is 'Идентификатор кузова';
comment on column car.transmission_id is 'Идентификатор трансмиссии';




