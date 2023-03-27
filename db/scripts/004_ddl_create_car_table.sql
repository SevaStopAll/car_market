CREATE TABLE IF NOT EXISTS car
(
    id        SERIAL PRIMARY KEY,
    name      TEXT      NOT NULL,
    created      timestamp without time zone default (now() at time zone 'utc'),
    engine_id INT       NOT NULL REFERENCES engine (id),
    body_id INT NOT NULL REFERENCES body(id),
    transmission_id INT NOT NULL REFERENCES transmission(id)
);

comment on table car is '������� � ������������';
comment on column car.id is '�������������';
comment on column car.name is '��������';
comment on column car.engine_id is '������������� ���������';
comment on column car.body_id is '������������� ������';
comment on column car.transmission_id is '������������� �����������';