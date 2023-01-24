create table lectures(
    no number not null primary key,
    lecture varchar2(30) not null,
    lecturer varchar2(21) not null,
    hours number not null check(mod(hours, 30) = 0),
    fee number not null check(fee >= 0)
);

create sequence lectures_seq;


insert into lectures(no, lecture, lecturer, hours, fee)
values(lectures_seq.nextval, '왕기초 영어 회화', '알*스', 90, 400000);

insert into lectures(no, lecture, lecturer, hours, fee)
values(lectures_seq.nextval, '영어 문법 마스터', '김*영', 120, 800000);

insert into lectures(no, lecture, lecturer, hours, fee)
values(lectures_seq.nextval, '영어 신문 읽기', '최*주', 60, 350000);


commit;

select * from lectures;

drop table lectures;
drop sequence lectures_seq;