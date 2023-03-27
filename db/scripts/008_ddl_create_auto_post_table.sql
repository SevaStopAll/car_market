
CREATE TABLE IF NOT EXISTS auto_post
(
    id           SERIAL PRIMARY KEY,
    description        TEXT      NOT NULL,
    created      timestamp without time zone default (now() at time zone 'utc'),
    auto_user_id INT       NOT NULL REFERENCES auto_user (id),
    car_id int REFERENCES car (id),
    file_id int REFERENCES file (id)
);

comment on table auto_post is 'Таблица с объявлениями';
comment on column auto_post.id is 'Идентификатор';
comment on column auto_post.description is 'Описание';
comment on column auto_post.created is 'Дата создания';
comment on column auto_post.auto_user_id is 'Идентификатор пользователя';
comment on column auto_post.car_id is 'Машина из объявления';
comment on column auto_post.file_id is 'Фотография';