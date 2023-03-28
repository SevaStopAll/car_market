
CREATE TABLE IF NOT EXISTS auto_post
(
    id           SERIAL PRIMARY KEY,
    description        TEXT      NOT NULL,
    created      timestamp without time zone default (now() at time zone 'utc'),
    auto_user_id INT       NOT NULL REFERENCES auto_user (id),
    car_id int REFERENCES car (id),
    file_id int REFERENCES file (id),
    boolean sold default false,
    int price NOT NULL
);

comment on table auto_post is '������� � ������������';
comment on column auto_post.id is '�������������';
comment on column auto_post.description is '��������';
comment on column auto_post.created is '���� ��������';
comment on column auto_post.auto_user_id is '������������� ������������';
comment on column auto_post.car_id is '������ �� ����������';
comment on column auto_post.file_id is '����������';
comment on column auto_post.sold is '������ �������';
comment on column auto_post.price is '���� �������';