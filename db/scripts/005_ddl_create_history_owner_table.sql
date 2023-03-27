
CREATE TABLE IF NOT EXISTS history_owner
(
    id        serial PRIMARY KEY,
    car_id    int not null REFERENCES car (id),
    owner_id int not null REFERENCES owner (id),
    startAt   TIMESTAMP,
    endAt     TIMESTAMP
);

comment on table history_owner is '������� � �������� �������� �����������';
comment on column history_owner.car_id is '������������� ����������';
comment on column history_owner.owner_id is '������������� ��������';
comment on column history_owner.startAt is '���� �������';
comment on column history_owner.endAt is '���� �������';
