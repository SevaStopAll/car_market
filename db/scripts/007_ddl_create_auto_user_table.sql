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


