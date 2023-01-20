create table chart(
    no number primary key,
    rank number(3) not null check(rank > 0 and rank <= 100),
    status varchar2(3) not null check(status in('↑', '↓', '-')),
    title varchar2(60) not null,
    artist varchar2(30) not null
);

create sequence chart_seq;
drop sequence chart_seq;

insert into chart(no, rank, status, title, artist)
values(chart_seq.nextval, 1, '-', 'Ditto', 'NewJeans');

insert into chart(no, rank, status, title, artist)
values(chart_seq.nextval, 2, '-', '사건의 지평선', '윤하');

insert into chart(no, rank, status, title, artist)
values(chart_seq.nextval, 3, '-', 'Hype Boy', 'NewJeans');

insert into chart(no, rank, status, title, artist)
values(chart_seq.nextval, 4, '↑', 'ANTIFRAZILE', 'LE SSERAFIM');

insert into chart(no, rank, status, title, artist)
values(chart_seq.nextval, 5, '↑', 'Attention', 'NewJeans');

commit;

select * from chart;

drop table chart;
