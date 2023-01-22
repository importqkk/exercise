create table menu(
    name varchar2(45) unique not null check(regexp_like(name, '^[��-�R0-9][��-�R0-9 ]+$')),
    type varchar2(9) not null check(type in('����', '����Ʈ')),
    price number not null check(price >= 0)
);


insert into menu(name, type, price)
values('�Ƹ޸�ī��', '����', '4500');

insert into menu(name, type, price)
values('ī���', '����', '5000');

insert into menu(name, type, price)
values('������̵�', '����', '5500');

insert into menu(name, type, price)
values('���座�� ����ũ', '����Ʈ', '5600');

insert into menu(name, type, price)
values('����Ǫ��', '����Ʈ', '4800');

insert into menu(name, type, price)
values('��ī�ٹ̾� ��Ű', '����Ʈ', '3500');


commit;

select * from menu;

drop table menu;