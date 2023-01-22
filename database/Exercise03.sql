create table plan(
    type varchar2(8) not null check(type in ('Premium', 'Standard', 'Basic')),
    month number not null check(month >= 1),
    price number not null check(price >= 0),
    monthly_price number check(monthly_price >= 0),
    rate number not null check(rate >= 0 and rate <= 100),
    recommend char(1)  not null check(recommend in('0', '1')),
    unique(type, month)
);


insert into plan(type, month, price, rate, recommend)
values('Premium', 1, 13900, 0, '0');

insert into plan(type, month, price, monthly_price, rate, recommend)
values('Premium', 12, 139000, 11583, 16, '0');

insert into plan(type, month, price, rate, recommend)
values('Standard', 1, 10900, 0, '1');

insert into plan(type, month, price, monthly_price, rate, recommend)
values('Standard', 12, 109000, 9083, 16, '1');

insert into plan(type, month, price, rate, recommend)
values('Basic', 1, 7900, 0, '0');

insert into plan(type, month, price, monthly_price, rate, recommend)
values('Basic', 12, 79000, 6583, 16, '0');

commit;

select * from plan;

drop table plan;