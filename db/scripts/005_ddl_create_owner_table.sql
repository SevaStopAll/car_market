CREATE TABLE IF NOT EXISTS owner
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL
);

comment on table owner is 'Таблица с водителями';
comment on column owner.id is 'Идентификатор';
comment on column owner.name is 'Имя';

