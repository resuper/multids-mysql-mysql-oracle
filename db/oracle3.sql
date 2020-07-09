create table SYS_USER
(
  id      NUMBER not null,
  name    VARCHAR2(20),
  age     NUMBER,
  address VARCHAR2(50)
);
comment on column SYS_USER.id
  is '主键id';
comment on column SYS_USER.name
  is '姓名';
comment on column SYS_USER.age
  is '年龄';
comment on column SYS_USER.address
  is '住址';
alter table SYS_USER
  add primary key (ID);

insert into SYS_USER (id, name, age, address)
values (3, 'ds3', 3, 'mutidatasource3===oracle');
commit;

