CREATE TABLE IF NOT EXISTS owner
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL
);

comment on table owner is '������� � ����������';
comment on column owner.id is '�������������';
comment on column owner.name is '���';

INSERT INTO engine (name) VALUES ('����������'), ('���������'), ('�������');

    CREATE TABLE file
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    path TEXT NOT NULL UNIQUE
);