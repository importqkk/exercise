create table book(
    no number primary key,
    title varchar2(90) not null,
    author varchar2(30) not null,
    price number not null check(price >= 0),
    early char(1) not null check(early in ('0', '1'))
);
create sequence book_seq;

insert into book(no, title, author, price, early)
values(book_seq.nextval, '스카이 버스', '분당강쌤', 16200, '1');

insert into book(no, title, author, price, early)
values(book_seq.nextval, '아버지의 해방일지', '정지아', 13500, '1');

insert into book(no, title, author, price, early)
values(book_seq.nextval, '도쿄 에일리언즈 5', 'NAON', 5400, '0');

commit;

select * from book;

drop sequence book_seq;
drop table book;