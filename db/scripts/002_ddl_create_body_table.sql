CREATE TABLE IF NOT EXISTS body
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is '������� � ������ ������';
comment on column engine.id is '�������������';
comment on column engine.name is '��������';
