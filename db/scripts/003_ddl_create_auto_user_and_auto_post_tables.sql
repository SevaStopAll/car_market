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
