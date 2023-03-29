CREATE TABLE IF NOT EXISTS body
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is 'Таблица с типами кузова';
comment on column engine.id is 'Идентификатор';
comment on column engine.name is 'Название';
