CREATE TABLE IF NOT EXISTS owner
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL
);

comment on table owner is '������� � ����������';
comment on column owner.id is '�������������';
comment on column owner.name is '���';

