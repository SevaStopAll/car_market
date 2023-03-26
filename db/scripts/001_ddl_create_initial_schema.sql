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

create table IF NOT EXISTS auto_user
(
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

comment on table auto_user is '������� � ��������������';
comment on column auto_user.id is '�������������';
comment on column auto_user.login is '�����';
comment on column auto_user.password is '������';

INSERT INTO auto_user (login, password) VALUES ('Ivanov', 'root');
INSERT INTO auto_user (login, password) VALUES ('Petrov', 'root');
INSERT INTO auto_user (login, password) VALUES ('Sidorov', 'root');

CREATE TABLE IF NOT EXISTS auto_post
(
    id           SERIAL PRIMARY KEY,
    description        TEXT      NOT NULL,
    created      TIMESTAMP NOT NULL,
    auto_user_id INT       NOT NULL REFERENCES auto_user (id),
    car_id int REFERENCES car (id),
    file_id int REFERENCES file (id)
);

comment on table auto_post is '������� � ������������';
comment on column auto_post.id is '�������������';
comment on column auto_post.description is '��������';
comment on column auto_post.created is '���� ��������';
comment on column auto_post.auto_user_id is '������������� ������������';
comment on column auto_post.car_id is '������ �� ����������';
comment on column auto_post.file_id is '����������';

CREATE TABLE IF NOT EXISTS PRICE_HISTORY
(
    id      SERIAL PRIMARY KEY,
    before  BIGINT NOT NULL,
    after   BIGINT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    post_id INT NOT NULL REFERENCES auto_post(id)
);

comment on table price_history is '��������� ����';
comment on column price_history.id is '�������������';
comment on column price_history.before is '���� ��';
comment on column price_history.after is '���� �����';
comment on column price_history.created is '���� ��������';
comment on column price_history.post_id is '������������� ����������';

CREATE TABLE IF NOT EXISTS participates
(
    id      serial PRIMARY KEY,
    auto_post_id int not null REFERENCES auto_post (id),
    auto_user_id int not null REFERENCES auto_user (id)
);

comment on table participates is '������� � ��������� �������� �� ����������';
comment on column participates.auto_post_id is '������������� ����������';
comment on column participates.auto_user_id is '������������� ������������';


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



