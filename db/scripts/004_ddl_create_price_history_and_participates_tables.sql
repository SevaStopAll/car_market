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

CREATE TABLE IF NOT EXISTS PARTICIPATES
(
    id      serial PRIMARY KEY,
    auto_post_id int not null REFERENCES auto_post (id),
    auto_user_id int not null REFERENCES auto_user (id)
);

comment on table participates is '������� � ��������� �������� �� ����������';
comment on column participates.auto_post_id is '������������� ����������';
comment on column participates.auto_user_id is '������������� ������������';

