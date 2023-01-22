create table menu(
    name varchar2(45) unique not null check(regexp_like(name, '^[°¡-ÆR0-9][°¡-ÆR0-9 ]+$')),
    type varchar2(9) not null check(type in('À½·á', 'µğÀúÆ®')),
    price number not null check(price >= 0)
);


insert into menu(name, type, price)
values('¾Æ¸Ş¸®Ä«³ë', 'À½·á', '4500');

insert into menu(name, type, price)
values('Ä«Æä¶ó¶¼', 'À½·á', '5000');

insert into menu(name, type, price)
values('·¹¸ğ³×ÀÌµå', 'À½·á', '5500');

insert into menu(name, type, price)
values('·¹µåº§ºª ÄÉÀÌÅ©', 'µğÀúÆ®', '5600');

insert into menu(name, type, price)
values('¿ìÀ¯Çªµù', 'µğÀúÆ®', '4800');

insert into menu(name, type, price)
values('¸¶Ä«´Ù¹Ì¾Æ ÄíÅ°', 'µğÀúÆ®', '3500');


commit;

select * from menu;

drop table menu;