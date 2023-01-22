create table menu(
    name varchar2(45) unique not null check(regexp_like(name, '^[가-힣0-9][가-힣0-9 ]+$')),
    type varchar2(9) not null check(type in('음료', '디저트')),
    price number not null check(price >= 0)
);


insert into menu(name, type, price)
values('아메리카노', '음료', '4500');

insert into menu(name, type, price)
values('카페라떼', '음료', '5000');

insert into menu(name, type, price)
values('레모네이드', '음료', '5500');

insert into menu(name, type, price)
values('레드벨벳 케이크', '디저트', '5600');

insert into menu(name, type, price)
values('우유푸딩', '디저트', '4800');

insert into menu(name, type, price)
values('마카다미아 쿠키', '디저트', '3500');


commit;

select * from menu;

drop table menu;
