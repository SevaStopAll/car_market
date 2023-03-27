CREATE TABLE IF NOT EXISTS engine
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

comment on table engine is '������� � �����������';
comment on column engine.id is '�������������';
comment on column engine.name is '��������';

CREATE TABLE IF NOT EXISTS car
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL,
    created   TIMESTAMP NOT NULL,
    engine_id INT       NOT NULL REFERENCES engine (id)
);

comment on table car is '������� � ������������';
comment on column car.id is '�������������';
comment on column car.name is '��������';
comment on column car.engine_id is '������������� ���������';




