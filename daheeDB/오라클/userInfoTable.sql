
-- 게스트북 sql
-- 시퀀스
create sequence gm_mid_seq MINVALUE 0;

create table guestbook_message (
 message_id number not null primary key,
 guest_name varchar2(50) not null,
 password varchar2(10) not null,
 message varchar(4000) not null
);

select * from guestbook_message;
drop table guestbook_message;
drop sequence gm_mid_seq;

-- mvc_member project sql
create table userInfo (
    userNum number primary key,
    userId varchar2(40) not null,
    userPw varchar2(16) not null,
    userName varchar2(50) not null,
    userRegDate date default sysdate not null
);
--시퀀스
create SEQUENCE userInfo_seq
MINVALUE 0;

select * from userInfo;



