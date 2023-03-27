CREATE TABLE IF NOT EXISTS history_owner
(
    id        serial PRIMARY KEY,
    car_id    int not null REFERENCES car (id),
    owner_id int not null REFERENCES owner (id),
    startAt   TIMESTAMP,
    endAt     TIMESTAMP
);

comment on table history_owner is 'Таблица с историей владения автомобилей';
comment on column history_owner.car_id is 'Идентификатор автомобиля';
comment on column history_owner.owner_id is 'Идентификатор водителя';
comment on column history_owner.startAt is 'Дата покупки';
comment on column history_owner.endAt is 'Дата продажи';