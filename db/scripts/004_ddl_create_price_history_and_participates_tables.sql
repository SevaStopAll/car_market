CREATE TABLE IF NOT EXISTS PRICE_HISTORY
(
    id      SERIAL PRIMARY KEY,
    before  BIGINT NOT NULL,
    after   BIGINT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    post_id INT NOT NULL REFERENCES auto_post(id)
);

comment on table price_history is 'Изменение цены';
comment on column price_history.id is 'Идентификатор';
comment on column price_history.before is 'Цена до';
comment on column price_history.after is 'Цена после';
comment on column price_history.created is 'Дата создания';
comment on column price_history.post_id is 'Идентификатор объявления';

CREATE TABLE IF NOT EXISTS PARTICIPATES
(
    id      serial PRIMARY KEY,
    auto_post_id int not null REFERENCES auto_post (id),
    auto_user_id int not null REFERENCES auto_user (id)
);

comment on table participates is 'Таблица с хранением подписок на объявления';
comment on column participates.auto_post_id is 'Идентификатор объявления';
comment on column participates.auto_user_id is 'Идентификатор пользователя';

