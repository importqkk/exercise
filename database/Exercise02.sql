create table book(
    no number primary key,
    title varchar2(90) not null,
    author varchar2(30) not null,
    price number not null check(price >= 0),
    early char(1) not null check(early in ('0', '1'))
);
create sequence book_seq;

insert into book(no, title, author, price, early)
values(book_seq.nextval, '��ī�� ����', '�д簭��', 16200, '1');

insert into book(no, title, author, price, early)
values(book_seq.nextval, '�ƹ����� �ع�����', '������', 13500, '1');

insert into book(no, title, author, price, early)
values(book_seq.nextval, '���� ���ϸ����� 5', 'NAON', 5400, '0');

commit;

select * from book;

drop sequence book_seq;
drop table book;