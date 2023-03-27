CREATE TABLE IF NOT EXISTS transmission
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is 'Таблица с типами трансмиссии';
comment on column engine.id is 'Идентификатор';
comment on column engine.name is 'Название';
