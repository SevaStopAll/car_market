CREATE TABLE file
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    path TEXT NOT NULL UNIQUE
);

comment on table file is 'Таблица с данными файлов';
comment on column file.id is 'Идентификатор';
comment on column file.name is 'Имя файла';
comment on column file.path is 'Путь к файлу';