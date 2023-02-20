-- 첨부파일 테이블
create table attachment(
    attachment_no number primary key,
    attachment_name varchar2(256) not null,
    attachment_type varchar2(60) not null,
    attachment_size number not null
);
create sequence attachment_seq;

-- 강의 사진 연결 테이블
create table lecture_img(
    lecture_no not null references lectures(no) on delete cascade,
    attachment_no not null references attachment(attachment_no) on delete cascade,
    primary key(lecture_no, attachment_no)
);

-- 회원 테이블
create table members(
    member_id varchar2(20) primary key check(regexp_like(member_id, '^[a-z0-9-_]{5,20}$')),
    member_pw varchar2(16) not null check(
        regexp_like(member_pw, '[A-Z]+') and    -- 대문자 1개 이상
        regexp_like(member_pw, '[a-z]+') and    -- 소문자 1개 이상
        regexp_like(member_pw, '[0-9]+') and    -- 숫자 1개 이상
        regexp_like(member_pw, '[!@#$%^&*?=+_-]+') and    -- 특수문자 1개 이상
        regexp_like(member_pw, '^[A-Za-z0-9!@#$%^&*?=+_-]{8,16}$')),
    member_nick varchar2(30) not null unique check(regexp_like(member_nick, '^[가-힣0-9]{2,10}$')),
    member_email varchar2(100) not null check(member_email like '%@%'),
    member_first_name varchar2(15) not null check(regexp_like(member_first_name, '^[가-힣]{1,5}$')),
    member_last_name varchar2(6) not null check(regexp_like(member_last_name, '^[가-힣]{1,2}$')),
    member_tel char(11) check(regexp_like(member_tel, '^010[1-9][0-9]{7}$')),
    member_birth char(10) check(regexp_like(member_birth, '^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|02-(0[1-9]|[12][0-9]))$')),
    
    member_point number default 0 check(member_point >= 0) not null,
    member_level varchar2(8) default 'bronze' check(member_level in ('bronze', 'silver', 'gold', 'platinum', 'admin')) not null,
    member_join date default sysdate not null,
    member_login date
);

-- 회원 프로필 사진 연결 테이블
create table members_img(
    member_id not null references members(member_id) on delete cascade,
    attachment_no not null references attachment(attachment_no) on delete cascade,
    primary key(member_id, attachment_no)
);

-- 회원 정보, 프로필사진 조회용 뷰
create view member_with_img as
    select M.member_id, M.member_nick, M.member_email, M.member_first_name, M.member_last_name, 
            M.member_tel, M.member_birth, M.member_point, M.member_level, M.member_join, M.member_login, 
            IMG.attachment_no
    from members M
    left outer join members_img IMG 
        on M.member_id = IMG.member_id;

commit;

select attachment_seq.nextval from dual;

select * from members;
select * from attachment;
select * from lecture_img;
select * from members_img;
select * from member_with_img;
select * from member_with_img where member_id = 'testuser01';
select * from members where member_id='testuser01';
select * from attachment where attachment_no=1;

drop table attachment;
drop table lecture_img;
drop sequence attachment_seq;
drop view member_with_img;