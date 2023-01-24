create table lectures(
    no number not null primary key,
    lecture varchar2(30) not null,
    lecturer varchar2(21) not null,
    hours number not null check(mod(hours, 30) = 0),
    fee number not null check(fee >= 0)
);

create sequence lectures_seq;


insert into lectures(no, lecture, lecturer, hours, fee)
values(lectures_seq.nextval, '�ձ��� ���� ȸȭ', '��*��', 90, 400000);

insert into lectures(no, lecture, lecturer, hours, fee)
values(lectures_seq.nextval, '���� ���� ������', '��*��', 120, 800000);

insert into lectures(no, lecture, lecturer, hours, fee)
values(lectures_seq.nextval, '���� �Ź� �б�', '��*��', 60, 350000);


commit;

select * from lectures;

drop table lectures;
drop sequence lectures_seq;