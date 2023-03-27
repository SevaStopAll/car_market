CREATE TABLE IF NOT EXISTS PARTICIPATES
(
    id      serial PRIMARY KEY,
    auto_post_id int not null REFERENCES auto_post (id),
    auto_user_id int not null REFERENCES auto_user (id)
);

comment on table participates is '������� � ��������� �������� �� ����������';
comment on column participates.auto_post_id is '������������� ����������';
comment on column participates.auto_user_id is '������������� ������������';